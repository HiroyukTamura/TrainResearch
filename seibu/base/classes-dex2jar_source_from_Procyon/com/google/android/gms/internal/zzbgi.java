// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import java.util.Iterator;
import java.util.Map;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzc;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.android.gms.common.util.zzo;

public abstract class zzbgi
{
    protected static <O, I> I zza(final zzbgj<I, O> zzbgj, final Object o) {
        Object convertBack = o;
        if (((zzbgj<Object, Object>)zzbgj).zzaIQ != null) {
            convertBack = zzbgj.convertBack(o);
        }
        return (I)convertBack;
    }
    
    private static void zza(final StringBuilder sb, final zzbgj zzbgj, final Object o) {
        if (zzbgj.zzaIH == 11) {
            sb.append(((zzbgi)zzbgj.zzaIN.cast(o)).toString());
            return;
        }
        if (zzbgj.zzaIH == 7) {
            sb.append("\"");
            sb.append(zzo.zzcK((String)o));
            sb.append("\"");
            return;
        }
        sb.append(o);
    }
    
    private static void zza(final StringBuilder sb, final zzbgj zzbgj, final ArrayList<Object> list) {
        sb.append("[");
        for (int i = 0; i < list.size(); ++i) {
            if (i > 0) {
                sb.append(",");
            }
            final Object value = list.get(i);
            if (value != null) {
                zza(sb, zzbgj, value);
            }
        }
        sb.append("]");
    }
    
    @Override
    public String toString() {
        final Map<String, zzbgj<?, ?>> zzrL = this.zzrL();
        final StringBuilder sb = new StringBuilder(100);
        for (final String str : zzrL.keySet()) {
            final zzbgj<Object, Object> zzbgj = zzrL.get(str);
            if (this.zza(zzbgj)) {
                final HashMap<String, String> zza = zza((zzbgj<HashMap<String, String>, Object>)zzbgj, this.zzb(zzbgj));
                if (sb.length() == 0) {
                    sb.append("{");
                }
                else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (zza == null) {
                    sb.append("null");
                }
                else {
                    switch (zzbgj.zzaIJ) {
                        default: {
                            if (zzbgj.zzaII) {
                                zza(sb, zzbgj, (ArrayList<Object>)zza);
                                continue;
                            }
                            zza(sb, zzbgj, zza);
                            continue;
                        }
                        case 8: {
                            sb.append("\"").append(zzc.encode((byte[])(Object)zza)).append("\"");
                            continue;
                        }
                        case 9: {
                            sb.append("\"").append(zzc.zzg((byte[])(Object)zza)).append("\"");
                            continue;
                        }
                        case 10: {
                            zzp.zza(sb, zza);
                            continue;
                        }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        }
        else {
            sb.append("{}");
        }
        return sb.toString();
    }
    
    protected boolean zza(final zzbgj zzbgj) {
        if (zzbgj.zzaIJ != 11) {
            return this.zzcI(zzbgj.zzaIL);
        }
        if (zzbgj.zzaIK) {
            final String zzaIL = zzbgj.zzaIL;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        final String zzaIL2 = zzbgj.zzaIL;
        throw new UnsupportedOperationException("Concrete types not supported");
    }
    
    protected Object zzb(final zzbgj zzbgj) {
        final String zzaIL = zzbgj.zzaIL;
        if (zzbgj.zzaIN != null) {
            this.zzcH(zzbgj.zzaIL);
            zzbo.zza(true, "Concrete field shouldn't be value object: %s", zzbgj.zzaIL);
            final boolean zzaIK = zzbgj.zzaIK;
            try {
                final char upperCase = Character.toUpperCase(zzaIL.charAt(0));
                final String value = String.valueOf(zzaIL.substring(1));
                return this.getClass().getMethod(new StringBuilder(String.valueOf(value).length() + 4).append("get").append(upperCase).append(value).toString(), (Class<?>[])new Class[0]).invoke(this, new Object[0]);
            }
            catch (Exception cause) {
                throw new RuntimeException(cause);
            }
        }
        return this.zzcH(zzbgj.zzaIL);
    }
    
    protected abstract Object zzcH(final String p0);
    
    protected abstract boolean zzcI(final String p0);
    
    public abstract Map<String, zzbgj<?, ?>> zzrL();
}
