// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import java.lang.ref.WeakReference;
import android.os.Message;
import android.os.Handler$Callback;
import android.os.Looper;
import android.os.Handler;

class SnackbarManager
{
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager sSnackbarManager;
    private SnackbarRecord mCurrentSnackbar;
    private final Handler mHandler;
    private final Object mLock;
    private SnackbarRecord mNextSnackbar;
    
    private SnackbarManager() {
        this.mLock = new Object();
        this.mHandler = new Handler(Looper.getMainLooper(), (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                switch (message.what) {
                    default: {
                        return false;
                    }
                    case 0: {
                        SnackbarManager.this.handleTimeout((SnackbarRecord)message.obj);
                        return true;
                    }
                }
            }
        });
    }
    
    private boolean cancelSnackbarLocked(final SnackbarRecord snackbarRecord, final int n) {
        final Callback callback = snackbarRecord.callback.get();
        if (callback != null) {
            this.mHandler.removeCallbacksAndMessages((Object)snackbarRecord);
            callback.dismiss(n);
            return true;
        }
        return false;
    }
    
    static SnackbarManager getInstance() {
        if (SnackbarManager.sSnackbarManager == null) {
            SnackbarManager.sSnackbarManager = new SnackbarManager();
        }
        return SnackbarManager.sSnackbarManager;
    }
    
    private boolean isCurrentSnackbarLocked(final Callback callback) {
        return this.mCurrentSnackbar != null && this.mCurrentSnackbar.isSnackbar(callback);
    }
    
    private boolean isNextSnackbarLocked(final Callback callback) {
        return this.mNextSnackbar != null && this.mNextSnackbar.isSnackbar(callback);
    }
    
    private void scheduleTimeoutLocked(final SnackbarRecord snackbarRecord) {
        if (snackbarRecord.duration == -2) {
            return;
        }
        int duration = 2750;
        if (snackbarRecord.duration > 0) {
            duration = snackbarRecord.duration;
        }
        else if (snackbarRecord.duration == -1) {
            duration = 1500;
        }
        this.mHandler.removeCallbacksAndMessages((Object)snackbarRecord);
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, (Object)snackbarRecord), (long)duration);
    }
    
    private void showNextSnackbarLocked() {
        if (this.mNextSnackbar != null) {
            this.mCurrentSnackbar = this.mNextSnackbar;
            this.mNextSnackbar = null;
            final Callback callback = this.mCurrentSnackbar.callback.get();
            if (callback == null) {
                this.mCurrentSnackbar = null;
                return;
            }
            callback.show();
        }
    }
    
    public void dismiss(final Callback callback, final int n) {
        synchronized (this.mLock) {
            if (this.isCurrentSnackbarLocked(callback)) {
                this.cancelSnackbarLocked(this.mCurrentSnackbar, n);
            }
            else if (this.isNextSnackbarLocked(callback)) {
                this.cancelSnackbarLocked(this.mNextSnackbar, n);
            }
        }
    }
    
    void handleTimeout(final SnackbarRecord snackbarRecord) {
        synchronized (this.mLock) {
            if (this.mCurrentSnackbar == snackbarRecord || this.mNextSnackbar == snackbarRecord) {
                this.cancelSnackbarLocked(snackbarRecord, 2);
            }
        }
    }
    
    public boolean isCurrent(final Callback callback) {
        synchronized (this.mLock) {
            return this.isCurrentSnackbarLocked(callback);
        }
    }
    
    public boolean isCurrentOrNext(final Callback callback) {
        while (true) {
            synchronized (this.mLock) {
                if (this.isCurrentSnackbarLocked(callback)) {
                    return true;
                }
                if (this.isNextSnackbarLocked(callback)) {
                    return true;
                }
                return false;
            }
            return true;
            b = false;
            return b;
        }
    }
    
    public void onDismissed(final Callback callback) {
        synchronized (this.mLock) {
            if (this.isCurrentSnackbarLocked(callback)) {
                this.mCurrentSnackbar = null;
                if (this.mNextSnackbar != null) {
                    this.showNextSnackbarLocked();
                }
            }
        }
    }
    
    public void onShown(final Callback callback) {
        synchronized (this.mLock) {
            if (this.isCurrentSnackbarLocked(callback)) {
                this.scheduleTimeoutLocked(this.mCurrentSnackbar);
            }
        }
    }
    
    public void pauseTimeout(final Callback callback) {
        synchronized (this.mLock) {
            if (this.isCurrentSnackbarLocked(callback) && !this.mCurrentSnackbar.paused) {
                this.mCurrentSnackbar.paused = true;
                this.mHandler.removeCallbacksAndMessages((Object)this.mCurrentSnackbar);
            }
        }
    }
    
    public void restoreTimeoutIfPaused(final Callback callback) {
        synchronized (this.mLock) {
            if (this.isCurrentSnackbarLocked(callback) && this.mCurrentSnackbar.paused) {
                this.mCurrentSnackbar.paused = false;
                this.scheduleTimeoutLocked(this.mCurrentSnackbar);
            }
        }
    }
    
    public void show(final int n, final Callback callback) {
        while (true) {
            while (true) {
                synchronized (this.mLock) {
                    if (this.isCurrentSnackbarLocked(callback)) {
                        this.mCurrentSnackbar.duration = n;
                        this.mHandler.removeCallbacksAndMessages((Object)this.mCurrentSnackbar);
                        this.scheduleTimeoutLocked(this.mCurrentSnackbar);
                        return;
                    }
                    if (this.isNextSnackbarLocked(callback)) {
                        this.mNextSnackbar.duration = n;
                        if (this.mCurrentSnackbar != null && this.cancelSnackbarLocked(this.mCurrentSnackbar, 4)) {
                            return;
                        }
                        break;
                    }
                }
                final Callback callback2;
                this.mNextSnackbar = new SnackbarRecord(n, callback2);
                continue;
            }
        }
        this.mCurrentSnackbar = null;
        this.showNextSnackbarLocked();
    }
    // monitorexit(o)
    
    interface Callback
    {
        void dismiss(final int p0);
        
        void show();
    }
    
    private static class SnackbarRecord
    {
        final WeakReference<Callback> callback;
        int duration;
        boolean paused;
        
        SnackbarRecord(final int duration, final Callback referent) {
            this.callback = new WeakReference<Callback>(referent);
            this.duration = duration;
        }
        
        boolean isSnackbar(final Callback callback) {
            return callback != null && this.callback.get() == callback;
        }
    }
}
