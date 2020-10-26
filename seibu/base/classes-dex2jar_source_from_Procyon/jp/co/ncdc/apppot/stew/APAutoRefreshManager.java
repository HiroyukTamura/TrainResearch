// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import java.util.TimerTask;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.Iterator;
import jp.co.ncdc.apppot.stew.log.Logger;
import jp.co.ncdc.apppot.stew.dto.APMessageQueue;
import java.util.List;
import java.util.HashMap;
import java.util.Timer;
import java.util.Map;

public class APAutoRefreshManager
{
    private static final String TAG = "APAutoRefreshManager";
    private static APAutoRefreshManager _instance;
    private Map<String, Timer> mTimers;
    
    static {
        APAutoRefreshManager._instance = null;
    }
    
    public APAutoRefreshManager() {
        this.mTimers = new HashMap<String, Timer>();
    }
    
    private Class<?> classForName(final String className) {
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private void flushMessageQueue(final List<APMessageQueue> list) {
        final APEntityManager instance = APEntityManager.getInstance();
        for (final APMessageQueue apMessageQueue : list) {
            final Class<?> classForName = this.classForName(apMessageQueue.targetTableName);
            switch (apMessageQueue.messageType) {
                default: {
                    continue;
                }
                case 1: {
                    Logger.d("APAutoRefreshManager", "MESSAGE_INSERT:" + apMessageQueue.targetTableName);
                    instance.insertToServerFromLocalData(classForName, apMessageQueue.targetObjectId);
                    continue;
                }
                case 2: {
                    Logger.d("APAutoRefreshManager", "MESSAGE_UPDATE:" + apMessageQueue.targetTableName);
                    instance.updateToServerFromLocalData(classForName, apMessageQueue.targetObjectId);
                    continue;
                }
                case 3: {
                    Logger.d("APAutoRefreshManager", "MESSAGE_DELETE:" + apMessageQueue.targetTableName);
                    instance.deleteToServerFromLocalData(classForName, apMessageQueue.targetObjectId);
                    continue;
                }
            }
        }
    }
    
    public static APAutoRefreshManager getInstance() {
        synchronized (APAutoRefreshManager.class) {
            if (APAutoRefreshManager._instance == null) {
                APAutoRefreshManager._instance = new APAutoRefreshManager();
            }
            return APAutoRefreshManager._instance;
        }
    }
    
    public void flushMessageQueue() {
        this.flushMessageQueue(APEntityManager.getInstance().getAllMessageQueue());
    }
    
    public void registerAutoRefresh(final APObject apObject) {
        final String simpleName = apObject.getClass().getSimpleName();
        if (this.mTimers.get(simpleName) != null) {
            return;
        }
        Logger.d("APAutoRefreshManager", "registerAutoRefresh:" + simpleName);
        final Timer timer = new Timer();
        timer.schedule(new APRefreshWorker(apObject), apObject.getRefreshInterval() * 1000, apObject.getRefreshInterval() * 1000);
        this.mTimers.put(simpleName, timer);
    }
    
    public void stopAutoRefresh(final String str) {
        Logger.d("APAutoRefreshManager", "stopAutoRefresh:" + str);
        final Timer timer = this.mTimers.get(str);
        if (timer == null) {
            return;
        }
        timer.cancel();
        this.mTimers.remove(str);
    }
    
    public void stopAutoRefresh(final APObject apObject) {
        this.stopAutoRefresh(apObject.getClass().getSimpleName());
    }
    
    private class APRefreshWorker extends TimerTask
    {
        private static final String TAG = "APRefreshWorker";
        private APObject mTargetDto;
        
        public APRefreshWorker(final APObject mTargetDto) {
            this.mTargetDto = mTargetDto;
        }
        
        @Override
        public void run() {
            final String name = this.mTargetDto.getClass().getName();
            Logger.v("APRefreshWorker", "refresh:" + name);
            final APEntityManager instance = APEntityManager.getInstance();
            final List<APMessageQueue> messageQueue = instance.getMessageQueue(name);
            instance.deleteExpireData(APAutoRefreshManager.this.classForName(name));
            APAutoRefreshManager.this.flushMessageQueue(messageQueue);
        }
    }
}
