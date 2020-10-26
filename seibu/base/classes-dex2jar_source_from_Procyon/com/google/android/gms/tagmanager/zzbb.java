// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.Context;

public final class zzbb implements zzby
{
    private static final Object zzbDk;
    private static zzbb zzbEy;
    private zzek zzbDM;
    private zzbz zzbEz;
    
    static {
        zzbDk = new Object();
    }
    
    private zzbb(final Context context) {
        this(zzca.zzbs(context), new zzfm());
    }
    
    private zzbb(final zzbz zzbEz, final zzek zzbDM) {
        this.zzbEz = zzbEz;
        this.zzbDM = zzbDM;
    }
    
    public static zzby zzbm(final Context context) {
        synchronized (zzbb.zzbDk) {
            if (zzbb.zzbEy == null) {
                zzbb.zzbEy = new zzbb(context);
            }
            return zzbb.zzbEy;
        }
    }
    
    @Override
    public final boolean zzfh(final String s) {
        if (!this.zzbDM.zzlL()) {
            zzdj.zzaT("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        this.zzbEz.zzfm(s);
        return true;
    }
}
