// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.text.TextUtils;

final class zzbx
{
    private final long zzaid;
    private final long zzbEO;
    private final long zzbEP;
    private String zzbEQ;
    
    zzbx(final long zzbEO, final long zzaid, final long zzbEP) {
        this.zzbEO = zzbEO;
        this.zzaid = zzaid;
        this.zzbEP = zzbEP;
    }
    
    final long zzBm() {
        return this.zzbEO;
    }
    
    final long zzBn() {
        return this.zzbEP;
    }
    
    final String zzBo() {
        return this.zzbEQ;
    }
    
    final void zzfl(final String zzbEQ) {
        if (zzbEQ == null || TextUtils.isEmpty((CharSequence)zzbEQ.trim())) {
            return;
        }
        this.zzbEQ = zzbEQ;
    }
}
