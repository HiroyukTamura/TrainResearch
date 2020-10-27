package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzkv extends AbstractList<String> implements zziu, RandomAccess {
    /* access modifiers changed from: private */
    public final zziu zza;

    public zzkv(zziu zziu) {
        this.zza = zziu;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    public final Iterator<String> iterator() {
        return new zzkx(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzky(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzgt zzgt) {
        throw new UnsupportedOperationException();
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final List<?> zzd() {
        return this.zza.zzd();
    }

    public final zziu zze() {
        return this;
    }
}
