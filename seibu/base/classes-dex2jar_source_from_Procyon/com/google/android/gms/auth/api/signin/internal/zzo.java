// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.auth.api.signin.internal;

public final class zzo
{
    private static int zzams;
    private int zzamt;
    
    static {
        zzo.zzams = 31;
    }
    
    public zzo() {
        this.zzamt = 1;
    }
    
    public final zzo zzP(final boolean b) {
        final int zzams = zzo.zzams;
        final int zzamt = this.zzamt;
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 0;
        }
        this.zzamt = n + zzamt * zzams;
        return this;
    }
    
    public final int zzmJ() {
        return this.zzamt;
    }
    
    public final zzo zzo(final Object o) {
        final int zzams = zzo.zzams;
        final int zzamt = this.zzamt;
        int hashCode;
        if (o == null) {
            hashCode = 0;
        }
        else {
            hashCode = o.hashCode();
        }
        this.zzamt = hashCode + zzamt * zzams;
        return this;
    }
}
