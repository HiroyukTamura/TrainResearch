// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.List;

final class zzav implements Runnable
{
    private /* synthetic */ zzat zzbEt;
    private /* synthetic */ zzaq zzbEu;
    
    zzav(final zzat zzbEt, final zzaq zzbEu) {
        this.zzbEt = zzbEt;
        this.zzbEu = zzbEu;
    }
    
    @Override
    public final void run() {
        this.zzbEu.zzJ(this.zzbEt.zzBa());
    }
}
