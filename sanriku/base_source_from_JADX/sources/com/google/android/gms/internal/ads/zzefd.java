package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzefd extends AbstractList<String> implements zzecv, RandomAccess {
    /* access modifiers changed from: private */
    public final zzecv zzicl;

    public zzefd(zzecv zzecv) {
        this.zzicl = zzecv;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzicl.get(i);
    }

    public final Iterator<String> iterator() {
        return new zzeff(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzefg(this, i);
    }

    public final int size() {
        return this.zzicl.size();
    }

    public final void zzaj(zzeaq zzeaq) {
        throw new UnsupportedOperationException();
    }

    public final List<?> zzbfs() {
        return this.zzicl.zzbfs();
    }

    public final zzecv zzbft() {
        return this;
    }

    public final Object zzgy(int i) {
        return this.zzicl.zzgy(i);
    }
}
