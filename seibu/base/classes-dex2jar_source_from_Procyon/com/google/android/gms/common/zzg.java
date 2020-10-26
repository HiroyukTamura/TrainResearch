// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.common.internal.zzar;
import java.io.UnsupportedEncodingException;
import com.google.android.gms.common.internal.zzbo;
import java.util.Arrays;
import android.util.Log;
import com.google.android.gms.common.util.zzl;
import com.google.android.gms.common.internal.zzas;

abstract class zzg extends zzas
{
    private int zzaAg;
    
    protected zzg(final byte[] original) {
        boolean b = false;
        byte[] copyOfRange = original;
        if (original.length != 25) {
            final int length = original.length;
            final String value = String.valueOf(zzl.zza(original, 0, original.length, false));
            Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(value).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(value).toString(), (Throwable)new Exception());
            copyOfRange = Arrays.copyOfRange(original, 0, 25);
            if (copyOfRange.length == 25) {
                b = true;
            }
            zzbo.zzb(b, (Object)new StringBuilder(55).append("cert hash data has incorrect length. length=").append(copyOfRange.length).toString());
        }
        this.zzaAg = Arrays.hashCode(copyOfRange);
    }
    
    protected static byte[] zzcs(final String s) {
        try {
            return s.getBytes("ISO-8859-1");
        }
        catch (UnsupportedEncodingException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof zzar)) {
            return false;
        }
        try {
            final zzar zzar = (zzar)o;
            if (zzar.zzoZ() != this.hashCode()) {
                return false;
            }
            final IObjectWrapper zzoY = zzar.zzoY();
            return zzoY != null && Arrays.equals(this.getBytes(), (byte[])zzn.zzE(zzoY));
        }
        catch (RemoteException ex) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex);
            return false;
        }
    }
    
    abstract byte[] getBytes();
    
    public int hashCode() {
        return this.zzaAg;
    }
    
    @Override
    public final IObjectWrapper zzoY() {
        return zzn.zzw(this.getBytes());
    }
    
    @Override
    public final int zzoZ() {
        return this.hashCode();
    }
}
