package p009e.p028d.p030b.p031a.p032i;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import p009e.p028d.p030b.p031a.C0877d;
import p009e.p028d.p030b.p031a.p032i.C0888c;

/* renamed from: e.d.b.a.i.k */
public abstract class C0903k {

    /* renamed from: e.d.b.a.i.k$a */
    public static abstract class C0904a {
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* renamed from: a */
        public abstract C0904a mo20326a(C0877d dVar);

        /* renamed from: a */
        public abstract C0904a mo20327a(String str);

        /* renamed from: a */
        public abstract C0904a mo20328a(@Nullable byte[] bArr);

        /* renamed from: a */
        public abstract C0903k mo20329a();
    }

    /* renamed from: d */
    public static C0904a m1231d() {
        C0888c.C0890b bVar = new C0888c.C0890b();
        bVar.mo20326a(C0877d.DEFAULT);
        return bVar;
    }

    /* renamed from: a */
    public abstract String mo20321a();

    @Nullable
    /* renamed from: b */
    public abstract byte[] mo20322b();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: c */
    public abstract C0877d mo20323c();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = mo20321a();
        objArr[1] = mo20323c();
        objArr[2] = mo20322b() == null ? "" : Base64.encodeToString(mo20322b(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
