// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;

final class zzv extends zzt
{
    private /* synthetic */ Fragment val$fragment;
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ int val$requestCode;
    
    zzv(final Intent val$intent, final Fragment val$fragment, final int val$requestCode) {
        this.val$intent = val$intent;
        this.val$fragment = val$fragment;
        this.val$requestCode = val$requestCode;
    }
    
    public final void zzrv() {
        if (this.val$intent != null) {
            this.val$fragment.startActivityForResult(this.val$intent, this.val$requestCode);
        }
    }
}
