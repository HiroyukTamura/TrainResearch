package p009e.p028d.p030b.p054b.p055c;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* renamed from: e.d.b.b.c.d */
public class C1537d extends Property<Drawable, Integer> {

    /* renamed from: b */
    public static final Property<Drawable, Integer> f1775b = new C1537d();

    /* renamed from: a */
    private final WeakHashMap<Drawable, Integer> f1776a = new WeakHashMap<>();

    private C1537d() {
        super(Integer.class, "drawableAlphaCompat");
    }

    public Object get(Object obj) {
        return Integer.valueOf(((Drawable) obj).getAlpha());
    }

    public void set(Object obj, Object obj2) {
        ((Drawable) obj).setAlpha(((Integer) obj2).intValue());
    }
}
