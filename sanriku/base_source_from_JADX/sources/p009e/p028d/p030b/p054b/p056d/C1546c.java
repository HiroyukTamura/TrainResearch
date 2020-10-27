package p009e.p028d.p030b.p054b.p056d;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import p009e.p028d.p030b.p054b.p058f.C1554a;

/* renamed from: e.d.b.b.d.c */
public interface C1546c {

    /* renamed from: e.d.b.b.d.c$b */
    public static class C1548b implements TypeEvaluator<C1551e> {

        /* renamed from: b */
        public static final TypeEvaluator<C1551e> f1792b = new C1548b();

        /* renamed from: a */
        private final C1551e f1793a = new C1551e((C1547a) null);

        public Object evaluate(float f, Object obj, Object obj2) {
            C1551e eVar = (C1551e) obj;
            C1551e eVar2 = (C1551e) obj2;
            C1551e eVar3 = this.f1793a;
            float a = C1554a.m2171a(eVar.f1796a, eVar2.f1796a, f);
            float a2 = C1554a.m2171a(eVar.f1797b, eVar2.f1797b, f);
            float a3 = C1554a.m2171a(eVar.f1798c, eVar2.f1798c, f);
            eVar3.f1796a = a;
            eVar3.f1797b = a2;
            eVar3.f1798c = a3;
            return this.f1793a;
        }
    }

    /* renamed from: e.d.b.b.d.c$c */
    public static class C1549c extends Property<C1546c, C1551e> {

        /* renamed from: a */
        public static final Property<C1546c, C1551e> f1794a = new C1549c("circularReveal");

        private C1549c(String str) {
            super(C1551e.class, str);
        }

        public Object get(Object obj) {
            return ((C1546c) obj).mo27312a();
        }

        public void set(Object obj, Object obj2) {
            ((C1546c) obj).mo27315a((C1551e) obj2);
        }
    }

    /* renamed from: e.d.b.b.d.c$d */
    public static class C1550d extends Property<C1546c, Integer> {

        /* renamed from: a */
        public static final Property<C1546c, Integer> f1795a = new C1550d("circularRevealScrimColor");

        private C1550d(String str) {
            super(Integer.class, str);
        }

        public Object get(Object obj) {
            return Integer.valueOf(((C1546c) obj).mo27317c());
        }

        public void set(Object obj, Object obj2) {
            ((C1546c) obj).mo27313a(((Integer) obj2).intValue());
        }
    }

    /* renamed from: e.d.b.b.d.c$e */
    public static class C1551e {

        /* renamed from: a */
        public float f1796a;

        /* renamed from: b */
        public float f1797b;

        /* renamed from: c */
        public float f1798c;

        private C1551e() {
        }

        public C1551e(float f, float f2, float f3) {
            this.f1796a = f;
            this.f1797b = f2;
            this.f1798c = f3;
        }

        /* synthetic */ C1551e(C1547a aVar) {
        }
    }

    @Nullable
    /* renamed from: a */
    C1551e mo27312a();

    /* renamed from: a */
    void mo27313a(@ColorInt int i);

    /* renamed from: a */
    void mo27314a(@Nullable Drawable drawable);

    /* renamed from: a */
    void mo27315a(@Nullable C1551e eVar);

    /* renamed from: b */
    void mo27316b();

    @ColorInt
    /* renamed from: c */
    int mo27317c();

    /* renamed from: d */
    void mo27318d();
}
