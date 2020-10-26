// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.internal.zzbdt;
import android.content.Intent;

final class zzw extends zzt
{
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ int val$requestCode;
    private /* synthetic */ zzbdt zzaHp;
    
    zzw(final Intent val$intent, final zzbdt zzaHp, final int val$requestCode) {
        this.val$intent = val$intent;
        this.zzaHp = zzaHp;
        this.val$requestCode = val$requestCode;
    }
    
    public final void zzrv() {
        if (this.val$intent != null) {
            this.zzaHp.startActivityForResult(this.val$intent, this.val$requestCode);
        }
    }
}
