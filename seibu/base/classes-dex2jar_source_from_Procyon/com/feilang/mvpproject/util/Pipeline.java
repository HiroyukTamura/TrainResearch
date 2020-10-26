// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import com.google.common.eventbus.Subscribe;
import com.feilang.mvpproject.base.annotations.Failed;
import com.feilang.mvpproject.base.annotations.Succeed;
import org.androidannotations.api.BackgroundExecutor;
import android.os.Message;
import org.androidannotations.api.UiThreadExecutor;
import com.feilang.mvpproject.data.datasource.DataNotifyEventBus;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import com.feilang.mvpproject.base.annotations.Stage;
import com.google.common.collect.Maps;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import java.util.Map;
import java.util.TreeSet;
import android.os.Looper;
import android.os.Handler;
import java.lang.reflect.Method;

public abstract class Pipeline
{
    private static final int CLOSE_LOOPER = 3;
    public static final int ERR_CODE_NETWORK = 1;
    public static final int ERR_CODE_USER = 99;
    private static final int INIT_ERR_ORDER = -99;
    private static final int PARAM_EXIST = 1;
    private static final int PARAM_NONE = 2;
    private Exception mAbortedException;
    private int mErrorCode;
    private int mErrorHappenedOrder;
    private Method mFailedMethod;
    private Handler mHandler;
    private Looper mLooper;
    private TreeSet<Integer> mOrders;
    private Object mParam;
    private Integer mPrevOrder;
    private OnResult mResultListener;
    private boolean mSkipError;
    private Map<Integer, Method> mStages;
    private Method mSucceedMethod;
    private long mTaskStartTime;
    private Map<DataNotifyEvent.ApiEventType, Method> mTypes;
    private boolean mUIFailed;
    private boolean mUISucceed;
    
    public Pipeline() {
        this(null, false);
    }
    
    public Pipeline(final Object o) {
        this(o, false);
    }
    
    public Pipeline(final Object mParam, final boolean mSkipError) {
        this.mStages = (Map<Integer, Method>)Maps.newConcurrentMap();
        this.mTypes = (Map<DataNotifyEvent.ApiEventType, Method>)Maps.newConcurrentMap();
        this.mParam = mParam;
        this.mSkipError = mSkipError;
        this.mErrorHappenedOrder = -99;
    }
    
    private void assemble() {
        final Method[] declaredMethods = this.getClass().getDeclaredMethods();
        for (int length = declaredMethods.length, i = 0; i < length; ++i) {
            final Method resultMethodIfNeed = declaredMethods[i];
            if (!this.setResultMethodIfNeed(resultMethodIfNeed)) {
                final Stage stage = resultMethodIfNeed.getAnnotation(Stage.class);
                if (stage != null) {
                    if (!resultMethodIfNeed.isAccessible()) {
                        resultMethodIfNeed.setAccessible(true);
                    }
                    final Integer value = stage.order();
                    if (this.mStages.containsKey(value)) {
                        throw new RuntimeException("stage: " + resultMethodIfNeed.getName() + " => order(" + value + ") cannot be same with " + this.mStages.get(value).getName());
                    }
                    this.mStages.put(stage.order(), resultMethodIfNeed);
                    if (stage.RestEvent() != DataNotifyEvent.ApiEventType.API_NONE && this.mTypes.containsKey(stage.RestEvent())) {
                        throw new RuntimeException("value of RestEvent is not repeatable");
                    }
                    this.mTypes.put(stage.RestEvent(), resultMethodIfNeed);
                }
            }
        }
        this.mOrders = new TreeSet<Integer>(this.mStages.keySet());
        this.mPrevOrder = this.mOrders.first();
    }
    
    private void doNext() {
        this.doNext(null, false);
    }
    
    private void doNext(final Object o) {
        this.doNext(o, true);
    }
    
    private void doNext(Object invoke, final boolean b) {
        if (this.mAbortedException != null) {
            this.handleFailed();
            return;
        }
        if (this.mOrders.isEmpty()) {
            this.handleSucceed(invoke);
            return;
        }
        final Integer n = this.mOrders.first();
        final Method method = this.mStages.get(n);
        this.mOrders.remove(n);
        this.mPrevOrder = n;
        try {
            final StringBuilder append = new StringBuilder().append("PipeLine: run task ").append(method.getName());
            if (!b) {
                goto Label_0216;
            }
            LogUtils.outputLog(append.append(" with parameter: " + invoke).toString());
            if (!b) {
                goto Label_0223;
            }
            invoke = method.invoke(this, invoke);
            final Stage stage = method.getAnnotation(Stage.class);
            if (AsyncResult.class.isInstance(invoke) || stage.value() == Stage.Type.AC) {
                LogUtils.outputLog("PipeLine: run task " + method.getName() + " in another thread.");
                return;
            }
            goto Label_0237;
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
            return;
        }
        catch (InvocationTargetException ex2) {
            ex2.printStackTrace();
            return;
        }
        this.nextStage(invoke);
    }
    
    private void handleFailed() {
        LogUtils.outputLog("PipeLine: run FAILED");
        DataNotifyEventBus.getInstance().unregister(this);
        if (this.mResultListener != null) {
            this.mResultListener.onFailed(this.mPrevOrder, this.mAbortedException);
        }
        if (this.mUIFailed) {
            UiThreadExecutor.runTask("", Pipeline$$Lambda$5.lambdaFactory$(this), 0L);
            return;
        }
        this.onResult(false, null);
    }
    
    private void handleSucceed(final Object o) {
        DataNotifyEventBus.getInstance().unregister(this);
        if (this.mResultListener != null) {
            this.mResultListener.onSucceed(o);
        }
        if (this.mUISucceed) {
            UiThreadExecutor.runTask("", Pipeline$$Lambda$4.lambdaFactory$(this, o), 0L);
            return;
        }
        this.onResult(true, o);
    }
    
    private void nextStage(final Object o, final int n) {
        BackgroundExecutor.execute(Pipeline$$Lambda$2.lambdaFactory$(this, n, o), 200L);
    }
    
    private void nextStageError(final Object o, final int n, final int mErrorCode) {
        this.mErrorCode = mErrorCode;
        this.mErrorHappenedOrder = this.mPrevOrder;
        this.nextStage(o, n);
    }
    
    private void onResult(final boolean b, final Object o) {
        Label_0033: {
            if (!b) {
                break Label_0033;
            }
            try {
                if (this.mSucceedMethod != null) {
                    this.mSucceedMethod.invoke(this, o);
                }
                Label_0028: {
                    return;
                }
                // iftrue(Label_0028:, this.mFailedMethod == null)
                this.mFailedMethod.invoke(this, this.mPrevOrder, this.mAbortedException);
            }
            catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
            catch (InvocationTargetException ex2) {
                ex2.printStackTrace();
            }
            finally {
                this.close();
            }
        }
    }
    
    private void run() {
        this.assemble();
        Looper.prepare();
        this.mLooper = Looper.myLooper();
        if (this.mLooper != null) {
            LogUtils.outputLog("PipeLine: start running in thread " + this.mLooper.getThread().getId());
        }
        this.mHandler = new Handler(this.mLooper) {
            public void handleMessage(final Message message) {
                super.handleMessage(message);
                if (message.arg1 == 1) {
                    Pipeline.this.doNext(message.obj);
                }
                else {
                    if (message.arg1 == 2) {
                        Pipeline.this.doNext();
                        return;
                    }
                    if (message.arg1 == 3) {
                        Pipeline.this.mLooper.quit();
                        Pipeline.this.mLooper = null;
                        Pipeline.this.mHandler = null;
                    }
                }
            }
        };
        this.mTaskStartTime = System.currentTimeMillis();
        this.nextStage(this.mParam);
        Looper.loop();
    }
    
    private boolean setResultMethodIfNeed(final Method method) {
        final boolean b = false;
        boolean muiSucceed = false;
        Label_0067: {
            if (this.mSucceedMethod != null) {
                break Label_0067;
            }
            final Succeed succeed = method.getAnnotation(Succeed.class);
            if (succeed == null) {
                break Label_0067;
            }
            this.mSucceedMethod = method;
            if (succeed.value() == Stage.Type.UI) {
                muiSucceed = true;
            }
            this.mUISucceed = muiSucceed;
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return true;
        }
        if (this.mFailedMethod == null) {
            final Failed failed = method.getAnnotation(Failed.class);
            if (failed != null) {
                this.mFailedMethod = method;
                boolean muiFailed = b;
                if (failed.value() == Stage.Type.UI) {
                    muiFailed = true;
                }
                this.mUIFailed = muiFailed;
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                    return true;
                }
                return true;
            }
        }
        return false;
    }
    
    public void abort(final String s) {
        this.abort(s, 99);
    }
    
    public void abort(final String message, final int mErrorCode) {
        this.mAbortedException = new Exception(message);
        this.mErrorCode = mErrorCode;
        this.mErrorHappenedOrder = this.mPrevOrder;
        final Message obtain = Message.obtain();
        obtain.arg1 = 1;
        obtain.obj = null;
        this.mHandler.sendMessage(obtain);
    }
    
    public void close() {
        if (this.mHandler == null) {
            return;
        }
        final Message obtain = Message.obtain();
        obtain.arg1 = 3;
        obtain.obj = null;
        this.mHandler.sendMessageDelayed(obtain, 100L);
    }
    
    public int error() {
        return this.mErrorCode;
    }
    
    protected void errorHappening(final int mErrorCode) {
        this.mErrorCode = mErrorCode;
        this.mErrorHappenedOrder = this.mPrevOrder;
    }
    
    protected boolean isPreviousStageFailed() {
        return this.mPrevOrder == this.mErrorHappenedOrder + 1;
    }
    
    public void nextStage() {
        this.nextStage(null, 2);
    }
    
    public void nextStage(final Object o) {
        this.nextStage(o, 1);
    }
    
    public void nextStageError(final int n) {
        this.nextStageError(null, 2, n);
    }
    
    public void nextStageError(final Object o, final int n) {
        this.nextStageError(o, 1, n);
    }
    
    @Subscribe
    public void onEvent(final DataNotifyEvent dataNotifyEvent) {
        while (true) {
            final Method method2;
            Label_0096: {
                synchronized (this) {
                    final Method method = this.mStages.get(this.mPrevOrder);
                    method2 = this.mTypes.get(dataNotifyEvent.getType());
                    if (method2 != null && method.getName().equals(method2.getName())) {
                        this.mTypes.remove(dataNotifyEvent.getType());
                        if (!dataNotifyEvent.isSucceed()) {
                            break Label_0096;
                        }
                        this.nextStage(dataNotifyEvent.getData()[0]);
                    }
                    return;
                }
            }
            if (this.mSkipError) {
                this.nextStageError(null, 1, 1);
                return;
            }
            this.abort(method2.getName() + " failed.");
        }
    }
    
    public void open() {
        this.open(this.mParam, null);
    }
    
    public void open(final OnResult onResult) {
        this.open(this.mParam, onResult);
    }
    
    public void open(final Object mParam, final OnResult mResultListener) {
        this.mParam = mParam;
        this.mResultListener = mResultListener;
        DataNotifyEventBus.getInstance().register(this);
        new Thread(Pipeline$$Lambda$1.lambdaFactory$(this)).start();
    }
    
    public long resumedTime() {
        return System.currentTimeMillis() - this.mTaskStartTime;
    }
    
    protected static class AsyncResult
    {
        public static AsyncResult make() {
            return new AsyncResult();
        }
    }
    
    public interface OnResult
    {
        void onFailed(final Integer p0, final Exception p1);
        
        void onSucceed(final Object p0);
    }
}
