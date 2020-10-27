package com.google.android.gms.internal.fitness;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.List;

@ShowFirstParty
public final class zzi {
    public static <T> int zza(@Nullable T t, List<T> list) {
        if (t == null) {
            return -1;
        }
        int indexOf = list.indexOf(t);
        if (indexOf >= 0) {
            return indexOf;
        }
        list.add(t);
        return list.size() - 1;
    }
}
