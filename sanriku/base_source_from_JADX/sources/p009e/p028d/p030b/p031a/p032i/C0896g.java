package p009e.p028d.p030b.p031a.p032i;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p009e.p028d.p030b.p031a.p032i.C0882a;

/* renamed from: e.d.b.a.i.g */
public abstract class C0896g {

    /* renamed from: e.d.b.a.i.g$a */
    public static abstract class C0897a {
        /* renamed from: a */
        public abstract C0897a mo20299a(long j);

        /* renamed from: a */
        public abstract C0897a mo20300a(C0895f fVar);

        /* renamed from: a */
        public abstract C0897a mo20301a(Integer num);

        /* renamed from: a */
        public abstract C0897a mo20302a(String str);

        /* renamed from: a */
        public final C0897a mo20344a(String str, int i) {
            mo20306b().put(str, String.valueOf(i));
            return this;
        }

        /* renamed from: a */
        public final C0897a mo20345a(String str, long j) {
            mo20306b().put(str, String.valueOf(j));
            return this;
        }

        /* renamed from: a */
        public final C0897a mo20346a(String str, String str2) {
            mo20306b().put(str, str2);
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract C0897a mo20303a(Map<String, String> map);

        /* renamed from: a */
        public abstract C0896g mo20304a();

        /* renamed from: b */
        public abstract C0897a mo20305b(long j);

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract Map<String, String> mo20306b();
    }

    /* renamed from: i */
    public static C0897a m1196i() {
        C0882a.C0884b bVar = new C0882a.C0884b();
        bVar.mo20303a((Map<String, String>) new HashMap());
        return bVar;
    }

    /* renamed from: a */
    public final String mo20339a(String str) {
        String str2 = mo20290a().get(str);
        return str2 == null ? "" : str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Map<String, String> mo20290a();

    /* renamed from: b */
    public final int mo20340b(String str) {
        String str2 = mo20290a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    @Nullable
    /* renamed from: b */
    public abstract Integer mo20291b();

    /* renamed from: c */
    public final long mo20341c(String str) {
        String str2 = mo20290a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Long.valueOf(str2).longValue();
    }

    /* renamed from: c */
    public abstract C0895f mo20292c();

    /* renamed from: d */
    public abstract long mo20293d();

    /* renamed from: e */
    public final Map<String, String> mo20342e() {
        return Collections.unmodifiableMap(mo20290a());
    }

    /* renamed from: f */
    public abstract String mo20295f();

    /* renamed from: g */
    public abstract long mo20296g();

    /* renamed from: h */
    public C0897a mo20343h() {
        C0882a.C0884b bVar = new C0882a.C0884b();
        bVar.mo20302a(mo20295f());
        bVar.mo20301a(mo20291b());
        bVar.mo20300a(mo20292c());
        bVar.mo20299a(mo20293d());
        bVar.mo20305b(mo20296g());
        bVar.mo20303a((Map<String, String>) new HashMap(mo20290a()));
        return bVar;
    }
}
