// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import com.google.common.eventbus.EventBus;

public class AppEventBus
{
    private static EventBus INSTANCE;
    public static final String KEY_COLLAPS_HEADER = "KEY_COLLAPS_HEADER";
    public static final String KEY_PROGRESS_START = "KEY_PROGRESS_START";
    public static final String KEY_PROGRESS_STOP = "KEY_PROGRESS_STOP";
    
    public static EventBus getInstance() {
        if (AppEventBus.INSTANCE == null) {
            AppEventBus.INSTANCE = new EventBus("AppEventBus");
        }
        return AppEventBus.INSTANCE;
    }
    
    public static void hideProgress() {
        getInstance().post("KEY_PROGRESS_STOP");
    }
    
    public static void showProgress() {
        getInstance().post("KEY_PROGRESS_START");
    }
}
