package p009e.p015c.p016a.p017a.p018a.p024s;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Locale;

/* renamed from: e.c.a.a.a.s.l */
public interface C0745l {

    /* renamed from: a */
    public static final C0745l f449a = new C0746a();

    /* renamed from: b */
    public static final C0745l f450b = new C0747b();

    /* renamed from: e.c.a.a.a.s.l$a */
    public static class C0746a implements C0745l {
        /* renamed from: a */
        public void mo19971a(@NonNull C0737e eVar, @NonNull String str, @NonNull Object[] objArr) {
        }
    }

    /* renamed from: e.c.a.a.a.s.l$b */
    public static class C0747b implements C0745l {
        /* renamed from: a */
        public void mo19971a(@NonNull C0737e eVar, @NonNull String str, @NonNull Object[] objArr) {
            Log.i(eVar.getTag(), String.format(Locale.getDefault(), str, objArr));
        }
    }

    /* renamed from: a */
    void mo19971a(@NonNull C0737e eVar, @NonNull String str, @NonNull Object[] objArr);
}
