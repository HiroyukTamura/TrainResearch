// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import android.os.Handler;

public class Exclusive
{
    private static final int LONG_TIME = 800;
    private static final int SHORT_TIME = 200;
    private static boolean isQuickClick;
    private static boolean isQuickPushpop;
    private static boolean isTabSwitch;
    private static Handler mExclusiveHandler;
    private static Runnable recovery;
    private Runnable mAbortRunnable;
    
    static {
        Exclusive.mExclusiveHandler = new Handler();
        Exclusive.isQuickPushpop = false;
        Exclusive.isTabSwitch = false;
        Exclusive.isQuickClick = false;
        Exclusive.recovery = new Runnable() {
            @Override
            public void run() {
                Exclusive.isQuickClick = false;
            }
        };
    }
    
    private Exclusive() {
    }
    
    public static ActivityExclusive Activity() {
        return new ActivityExclusive();
    }
    
    public static NormalExclusive Normal() {
        return new NormalExclusive();
    }
    
    public static TabExclusive Tab() {
        return new TabExclusive();
    }
    
    private Exclusive abort(final Runnable mAbortRunnable) {
        this.mAbortRunnable = mAbortRunnable;
        return this;
    }
    
    private void go(final Runnable runnable) {
        switchTab((ExclusiveListener<Object>)this.makeListener(runnable));
    }
    
    private ExclusiveListener makeListener(final Runnable runnable) {
        return (ExclusiveListener)new ExclusiveListener<Void>() {
            @Override
            public void onAbort() {
                if (Exclusive.this.mAbortRunnable != null) {
                    Exclusive.this.mAbortRunnable.run();
                }
            }
            
            public Void onExclusive() {
                runnable.run();
                return null;
            }
        };
    }
    
    public static <T> T normalAction(final ExclusiveListener<T> exclusiveListener) {
        if (Exclusive.isQuickClick || Exclusive.isQuickPushpop) {
            LogUtils.w("Exclusive Touch : Abort because clicking is fast.");
            return null;
        }
        Exclusive.isQuickClick = true;
        final T onExclusive = exclusiveListener.onExclusive();
        Exclusive.mExclusiveHandler.postDelayed(Exclusive.recovery, 800L);
        return onExclusive;
    }
    
    public static void recoveryClick() {
        Exclusive.mExclusiveHandler.removeCallbacks(Exclusive.recovery);
        Exclusive.mExclusiveHandler.postDelayed(Exclusive.recovery, 200L);
    }
    
    private void start(final Runnable runnable) {
        switchView((ExclusiveListener<Object>)this.makeListener(runnable));
    }
    
    public static <T> T switchTab(final ExclusiveListener<T> exclusiveListener) {
        if (Exclusive.isTabSwitch) {
            LogUtils.w("Exclusive Touch : Abort this Tab switch because the last not completed.");
            exclusiveListener.onAbort();
            return null;
        }
        Exclusive.isTabSwitch = true;
        final T onExclusive = exclusiveListener.onExclusive();
        Exclusive.mExclusiveHandler.postDelayed((Runnable)new Runnable() {
            @Override
            public void run() {
                Exclusive.isTabSwitch = false;
            }
        }, 800L);
        return onExclusive;
    }
    
    public static <T> T switchView(final ExclusiveListener<T> exclusiveListener) {
        if (Exclusive.isQuickPushpop) {
            LogUtils.w("Exclusive Touch : Abort this operation because the last not completed.");
            exclusiveListener.onAbort();
            return null;
        }
        Exclusive.isQuickPushpop = true;
        final T onExclusive = exclusiveListener.onExclusive();
        Exclusive.mExclusiveHandler.postDelayed((Runnable)new Runnable() {
            @Override
            public void run() {
                Exclusive.isQuickPushpop = false;
            }
        }, 800L);
        return onExclusive;
    }
    
    private void tap(final Runnable runnable) {
        normalAction((ExclusiveListener<Object>)this.makeListener(runnable));
    }
    
    public static class ActivityExclusive extends Exclusive
    {
        public ActivityExclusive() {
            super(null);
        }
        
        public ActivityExclusive abort(final Runnable runnable) {
            Exclusive.this.abort(runnable);
            return this;
        }
        
        public void start(final Runnable runnable) {
            Exclusive.this.start(runnable);
        }
    }
    
    public interface ExclusiveListener<T>
    {
        void onAbort();
        
        T onExclusive();
    }
    
    public static class NormalExclusive extends Exclusive
    {
        public NormalExclusive() {
            super(null);
        }
        
        public NormalExclusive abort(final Runnable runnable) {
            Exclusive.this.abort(runnable);
            return this;
        }
        
        public void tap(final Runnable runnable) {
            Exclusive.this.tap(runnable);
        }
    }
    
    public static class TabExclusive extends Exclusive
    {
        public TabExclusive() {
            super(null);
        }
        
        public TabExclusive abort(final Runnable runnable) {
            Exclusive.this.abort(runnable);
            return this;
        }
        
        public void go(final Runnable runnable) {
            Exclusive.this.go(runnable);
        }
    }
}
