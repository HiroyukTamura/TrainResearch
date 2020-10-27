package p009e.p028d.p030b.p031a.p032i.p039x;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.EnumMap;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.C0877d;

/* renamed from: e.d.b.a.i.x.a */
public final class C0973a {

    /* renamed from: a */
    private static SparseArray<C0877d> f691a = new SparseArray<>();

    /* renamed from: b */
    private static EnumMap<C0877d, Integer> f692b;

    static {
        EnumMap<C0877d, Integer> enumMap = new EnumMap<>(C0877d.class);
        f692b = enumMap;
        enumMap.put(C0877d.DEFAULT, 0);
        f692b.put(C0877d.VERY_LOW, 1);
        f692b.put(C0877d.HIGHEST, 2);
        for (C0877d next : f692b.keySet()) {
            f691a.append(f692b.get(next).intValue(), next);
        }
    }

    /* renamed from: a */
    public static int m1372a(@NonNull C0877d dVar) {
        Integer num = f692b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    @NonNull
    /* renamed from: a */
    public static C0877d m1373a(int i) {
        C0877d dVar = f691a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(C0681a.m316a("Unknown Priority for value ", i));
    }
}
