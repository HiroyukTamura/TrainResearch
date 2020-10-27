package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzehi<T> implements zzegz<Set<T>> {
    private static final zzegz<Set<Object>> zziji = zzehc.zzbb(Collections.emptySet());
    private final List<zzehm<T>> zzijj;
    private final List<zzehm<Collection<T>>> zzijk;

    private zzehi(List<zzehm<T>> list, List<zzehm<Collection<T>>> list2) {
        this.zzijj = list;
        this.zzijk = list2;
    }

    public static <T> zzehk<T> zzar(int i, int i2) {
        return new zzehk<>(i, i2);
    }

    public final /* synthetic */ Object get() {
        int size = this.zzijj.size();
        ArrayList arrayList = new ArrayList(this.zzijk.size());
        int size2 = this.zzijk.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) this.zzijk.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zzht = zzegy.zzht(size);
        int size3 = this.zzijj.size();
        for (int i2 = 0; i2 < size3; i2++) {
            zzht.add(zzehf.checkNotNull(this.zzijj.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object checkNotNull : (Collection) arrayList.get(i3)) {
                zzht.add(zzehf.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(zzht);
    }
}
