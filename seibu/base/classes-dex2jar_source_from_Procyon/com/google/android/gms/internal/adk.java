// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.List;
import java.io.IOException;

public final class adk<M extends adj<M>, T>
{
    public final int tag;
    private int type;
    protected final Class<T> zzcjG;
    protected final boolean zzcsp;
    
    private adk(final int n, final Class<T> zzcjG, final int tag, final boolean b) {
        this.type = 11;
        this.zzcjG = zzcjG;
        this.tag = tag;
        this.zzcsp = false;
    }
    
    public static <M extends adj<M>, T extends adp> adk<M, T> zza(final int n, final Class<T> clazz, final long n2) {
        return new adk<M, T>(11, clazz, (int)n2, false);
    }
    
    private final Object zzb(final adg adg) {
        while (true) {
            final Class<T> zzcjG = this.zzcjG;
            while (true) {
                Label_0208: {
                    try {
                        switch (this.type) {
                            case 10: {
                                goto Label_0110;
                                goto Label_0110;
                            }
                            case 11: {
                                goto Label_0134;
                                goto Label_0134;
                            }
                            default: {
                                break Label_0208;
                            }
                        }
                        throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
                    }
                    catch (InstantiationException cause) {
                        final String value = String.valueOf(zzcjG);
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(value).length() + 33).append("Error creating instance of class ").append(value).toString(), cause);
                    }
                    catch (IllegalAccessException cause2) {
                        final String value2 = String.valueOf(zzcjG);
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(value2).length() + 33).append("Error creating instance of class ").append(value2).toString(), cause2);
                    }
                    catch (IOException cause3) {
                        throw new IllegalArgumentException("Error reading extension field", cause3);
                    }
                }
                continue;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof adk)) {
                return false;
            }
            final adk adk = (adk)o;
            if (this.type != adk.type || this.zzcjG != adk.zzcjG || this.tag != adk.tag) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        return (((this.type + 1147) * 31 + this.zzcjG.hashCode()) * 31 + this.tag) * 31;
    }
    
    final T zzX(final List<adr> list) {
        if (list != null && !list.isEmpty()) {
            return this.zzcjG.cast(this.zzb(adg.zzH(list.get(list.size() - 1).zzbws)));
        }
        return null;
    }
    
    protected final void zza(final Object o, final adh adh) {
        while (true) {
            Label_0104: {
                Label_0080: {
                    while (true) {
                        Label_0113: {
                            try {
                                adh.zzcu(this.tag);
                                switch (this.type) {
                                    case 10: {
                                        break Label_0080;
                                    }
                                    case 11: {
                                        break Label_0104;
                                    }
                                    default: {
                                        break Label_0113;
                                    }
                                }
                                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
                            }
                            catch (IOException cause) {
                                throw new IllegalStateException(cause);
                            }
                            break Label_0080;
                        }
                        continue;
                    }
                }
                final adp adp = (adp)o;
                final int tag = this.tag;
                adp.zza(adh);
                adh.zzt(tag >>> 3, 4);
                return;
            }
            adh.zzb((adp)o);
        }
    }
    
    protected final int zzav(final Object o) {
        final int n = this.tag >>> 3;
        switch (this.type) {
            default: {
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
            case 10: {
                return (adh.zzct(n) << 1) + ((adp)o).zzLV();
            }
            case 11: {
                return adh.zzb(n, (adp)o);
            }
        }
    }
}
