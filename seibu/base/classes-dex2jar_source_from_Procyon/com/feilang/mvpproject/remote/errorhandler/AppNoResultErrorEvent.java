// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.errorhandler;

import android.content.DialogInterface$OnClickListener;

public class AppNoResultErrorEvent
{
    public final DialogInterface$OnClickListener callback;
    
    public AppNoResultErrorEvent(final DialogInterface$OnClickListener callback) {
        this.callback = callback;
    }
}
