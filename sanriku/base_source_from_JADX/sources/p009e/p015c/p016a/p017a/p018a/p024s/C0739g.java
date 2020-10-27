package p009e.p015c.p016a.p017a.p018a.p024s;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p024s.C0734d;

/* renamed from: e.c.a.a.a.s.g */
public class C0739g extends C0731a {
    @NonNull

    /* renamed from: b */
    final C0734d f430b;
    @NonNull

    /* renamed from: c */
    final C0743j f431c;

    /* renamed from: e.c.a.a.a.s.g$a */
    public static class C0740a {
        @NonNull

        /* renamed from: a */
        final Context f432a;

        /* renamed from: b */
        final boolean f433b;

        /* renamed from: c */
        int f434c = 0;
        @Nullable

        /* renamed from: d */
        String f435d = null;
        @NonNull

        /* renamed from: e */
        C0745l f436e;

        /* renamed from: f */
        SparseArray<C0734d.C0736b> f437f = new SparseArray<>();

        C0740a(@NonNull Context context) {
            boolean z = false;
            this.f432a = context;
            z = (context.getApplicationInfo().flags & 2) == 2 ? true : z;
            this.f433b = z;
            mo19963a(z ? C0745l.f450b : C0745l.f449a);
        }

        @NonNull
        /* renamed from: a */
        public C0740a mo19961a(@IntRange(from = 1) int i) {
            this.f434c = i;
            return this;
        }

        /* renamed from: a */
        public C0740a mo19962a(@IntRange(from = 1) int i, @NonNull C0734d.C0736b bVar) {
            this.f437f.append(i, bVar);
            return this;
        }

        /* renamed from: a */
        public C0740a mo19963a(@Nullable C0745l lVar) {
            if (lVar == null) {
                lVar = C0745l.f449a;
            }
            this.f436e = lVar;
            return this;
        }

        @NonNull
        /* renamed from: a */
        public C0740a mo19964a(@NonNull String str) {
            this.f435d = str;
            return this;
        }

        @NonNull
        /* renamed from: a */
        public C0739g mo19965a() {
            if (this.f434c == 0) {
                this.f434c = C0731a.m412a(this.f432a);
            }
            if (this.f435d != null) {
                return new C0739g(new C0734d(this.f432a, this.f434c, this.f437f, this.f436e), new C0743j(this.f432a, this.f435d, this.f436e), this.f436e);
            }
            throw new IllegalStateException("You must set OrmaDatabase.SCHEMA_HASH to schemaHashForSchemaDiffMigration.");
        }
    }

    protected C0739g(@NonNull C0734d dVar, @NonNull C0743j jVar, @NonNull C0745l lVar) {
        super(lVar);
        this.f430b = dVar;
        this.f431c = jVar;
    }

    /* renamed from: c */
    public static C0740a m423c(@NonNull Context context) {
        return new C0740a(context);
    }

    /* renamed from: a */
    public void mo19956a(@NonNull C0711a aVar, @NonNull List<? extends C0738f> list) {
        this.f430b.mo19956a(aVar, list);
        this.f431c.mo19956a(aVar, list);
    }

    @NonNull
    public String getTag() {
        return "OrmaMigration";
    }
}
