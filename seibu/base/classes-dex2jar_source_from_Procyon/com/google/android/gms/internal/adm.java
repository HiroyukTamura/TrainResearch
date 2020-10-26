// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class adm implements Cloneable
{
    private Object value;
    private adk<?, ?> zzcsu;
    private List<adr> zzcsv;
    
    adm() {
        this.zzcsv = new ArrayList<adr>();
    }
    
    private final byte[] toByteArray() throws IOException {
        final byte[] array = new byte[this.zzn()];
        this.zza(adh.zzI(array));
        return array;
    }
    
    private adm zzLP() {
        final adm adm = new adm();
        try {
            adm.zzcsu = this.zzcsu;
            if (this.zzcsv == null) {
                adm.zzcsv = null;
            }
            else {
                adm.zzcsv.addAll(this.zzcsv);
            }
            if (this.value == null) {
                return adm;
            }
            if (this.value instanceof adp) {
                adm.value = ((adp)this.value).clone();
                return adm;
            }
        }
        catch (CloneNotSupportedException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
        if (this.value instanceof byte[]) {
            adm.value = ((byte[])this.value).clone();
            return adm;
        }
        if (this.value instanceof byte[][]) {
            final byte[][] array = (byte[][])this.value;
            final byte[][] value = new byte[array.length][];
            adm.value = value;
            for (int i = 0; i < array.length; ++i) {
                value[i] = array[i].clone();
            }
        }
        else {
            if (this.value instanceof boolean[]) {
                adm.value = ((boolean[])this.value).clone();
                return adm;
            }
            if (this.value instanceof int[]) {
                adm.value = ((int[])this.value).clone();
                return adm;
            }
            if (this.value instanceof long[]) {
                adm.value = ((long[])this.value).clone();
                return adm;
            }
            if (this.value instanceof float[]) {
                adm.value = ((float[])this.value).clone();
                return adm;
            }
            if (this.value instanceof double[]) {
                adm.value = ((double[])this.value).clone();
                return adm;
            }
            if (this.value instanceof adp[]) {
                final adp[] array2 = (adp[])this.value;
                final adp[] value2 = new adp[array2.length];
                adm.value = value2;
                for (int j = 0; j < array2.length; ++j) {
                    value2[j] = (adp)array2[j].clone();
                }
            }
        }
        return adm;
    }
    
    @Override
    public final boolean equals(final Object o) {
        final boolean b = false;
        boolean b2;
        if (o == this) {
            b2 = true;
        }
        else {
            b2 = b;
            if (o instanceof adm) {
                final adm adm = (adm)o;
                if (this.value != null && adm.value != null) {
                    b2 = b;
                    if (this.zzcsu == adm.zzcsu) {
                        if (!this.zzcsu.zzcjG.isArray()) {
                            return this.value.equals(adm.value);
                        }
                        if (this.value instanceof byte[]) {
                            return Arrays.equals((byte[])this.value, (byte[])adm.value);
                        }
                        if (this.value instanceof int[]) {
                            return Arrays.equals((int[])this.value, (int[])adm.value);
                        }
                        if (this.value instanceof long[]) {
                            return Arrays.equals((long[])this.value, (long[])adm.value);
                        }
                        if (this.value instanceof float[]) {
                            return Arrays.equals((float[])this.value, (float[])adm.value);
                        }
                        if (this.value instanceof double[]) {
                            return Arrays.equals((double[])this.value, (double[])adm.value);
                        }
                        if (this.value instanceof boolean[]) {
                            return Arrays.equals((boolean[])this.value, (boolean[])adm.value);
                        }
                        return Arrays.deepEquals((Object[])this.value, (Object[])adm.value);
                    }
                }
                else {
                    if (this.zzcsv != null && adm.zzcsv != null) {
                        return this.zzcsv.equals(adm.zzcsv);
                    }
                    try {
                        return Arrays.equals(this.toByteArray(), adm.toByteArray());
                    }
                    catch (IOException cause) {
                        throw new IllegalStateException(cause);
                    }
                }
            }
        }
        return b2;
    }
    
    @Override
    public final int hashCode() {
        try {
            return Arrays.hashCode(this.toByteArray()) + 527;
        }
        catch (IOException cause) {
            throw new IllegalStateException(cause);
        }
    }
    
    final void zza(final adh adh) throws IOException {
        if (this.value != null) {
            this.zzcsu.zza(this.value, adh);
        }
        else {
            for (final adr adr : this.zzcsv) {
                adh.zzcu(adr.tag);
                adh.zzK(adr.zzbws);
            }
        }
    }
    
    final void zza(final adr adr) {
        this.zzcsv.add(adr);
    }
    
    final <T> T zzb(final adk<?, T> zzcsu) {
        if (this.value != null) {
            if (!this.zzcsu.equals(zzcsu)) {
                throw new IllegalStateException("Tried to getExtension with a different Extension.");
            }
        }
        else {
            this.zzcsu = zzcsu;
            this.value = zzcsu.zzX(this.zzcsv);
            this.zzcsv = null;
        }
        return (T)this.value;
    }
    
    final int zzn() {
        int zzav;
        if (this.value != null) {
            zzav = this.zzcsu.zzav(this.value);
        }
        else {
            final Iterator<adr> iterator = this.zzcsv.iterator();
            int n = 0;
            while (true) {
                zzav = n;
                if (!iterator.hasNext()) {
                    break;
                }
                final adr adr = iterator.next();
                n += adr.zzbws.length + (adh.zzcv(adr.tag) + 0);
            }
        }
        return zzav;
    }
}
