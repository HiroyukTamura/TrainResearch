// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

final class zzaw implements Runnable
{
    private /* synthetic */ zzat zzbEt;
    private /* synthetic */ String zzbEv;
    
    zzaw(final zzat zzbEt, final String zzbEv) {
        this.zzbEt = zzbEt;
        this.zzbEv = zzbEv;
    }
    
    @Override
    public final void run() {
        this.zzbEt.zzff(this.zzbEv);
    }
}
