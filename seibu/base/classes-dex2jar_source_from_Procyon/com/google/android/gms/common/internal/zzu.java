// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.content.Intent;
import android.app.Activity;

final class zzu extends zzt
{
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ int val$requestCode;
    
    zzu(final Intent val$intent, final Activity val$activity, final int val$requestCode) {
        this.val$intent = val$intent;
        this.val$activity = val$activity;
        this.val$requestCode = val$requestCode;
    }
    
    public final void zzrv() {
        if (this.val$intent != null) {
            this.val$activity.startActivityForResult(this.val$intent, this.val$requestCode);
        }
    }
}
