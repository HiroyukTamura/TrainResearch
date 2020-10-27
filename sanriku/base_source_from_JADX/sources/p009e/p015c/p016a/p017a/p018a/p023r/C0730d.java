package p009e.p015c.p016a.p017a.p018a.p023r;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import p009e.p015c.p016a.p017a.p018a.C0707k;

/* renamed from: e.c.a.a.a.r.d */
public class C0730d {

    /* renamed from: a */
    static final SimpleArrayMap<Class<?>, C0707k<?>> f417a = new SimpleArrayMap<>();

    /* renamed from: a */
    public static <M, T extends C0707k<M>> T m411a(@NonNull T t) {
        f417a.put(t.getModelClass(), t);
        return t;
    }
}
