package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final CrashListener crashListener;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    private final SettingsDataProvider settingsDataProvider;

    interface CrashListener {
        void onUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener2, SettingsDataProvider settingsDataProvider2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.crashListener = crashListener2;
        this.settingsDataProvider = settingsDataProvider2;
        this.defaultHandler = uncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Logger logger;
        String str;
        this.isHandlingException.set(true);
        if (thread == null) {
            try {
                logger = Logger.getLogger();
                str = "Could not handle uncaught exception; null thread";
            } catch (Exception e) {
                Logger.getLogger().mo25715e("An error occurred in the uncaught exception handler", e);
            } catch (Throwable th2) {
                Logger.getLogger().mo25712d("Crashlytics completed exception processing. Invoking default exception handler.");
                this.defaultHandler.uncaughtException(thread, th);
                this.isHandlingException.set(false);
                throw th2;
            }
        } else if (th == null) {
            logger = Logger.getLogger();
            str = "Could not handle uncaught exception; null throwable";
        } else {
            this.crashListener.onUncaughtException(this.settingsDataProvider, thread, th);
            Logger.getLogger().mo25712d("Crashlytics completed exception processing. Invoking default exception handler.");
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
        }
        logger.mo25714e(str);
        Logger.getLogger().mo25712d("Crashlytics completed exception processing. Invoking default exception handler.");
        this.defaultHandler.uncaughtException(thread, th);
        this.isHandlingException.set(false);
    }
}
