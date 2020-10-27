package p009e.p015c.p016a.p017a.p018a.p024s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;

/* renamed from: e.c.a.a.a.s.a */
public abstract class C0731a implements C0737e {
    @NonNull

    /* renamed from: a */
    private final C0745l f418a;

    protected C0731a(@NonNull C0745l lVar) {
        this.f418a = lVar;
    }

    /* renamed from: a */
    protected static int m412a(@NonNull Context context) {
        int i = m413b(context).versionCode;
        if (i != 0) {
            return i;
        }
        return 1;
    }

    @NonNull
    /* renamed from: b */
    protected static PackageInfo m413b(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public void mo19950a(@NonNull C0711a aVar, @NonNull Runnable runnable) {
        C0714d dVar = (C0714d) aVar;
        boolean z = dVar.mo19911a("PRAGMA foreign_keys", (String[]) null) != 0;
        if (z) {
            dVar.mo19919b("PRAGMA foreign_keys = OFF");
        }
        dVar.mo19914a();
        try {
            runnable.run();
            dVar.mo19924g();
        } finally {
            dVar.mo19921d();
            if (z) {
                dVar.mo19919b("PRAGMA foreign_keys = ON");
            }
        }
    }

    /* renamed from: a */
    public void mo19951a(@NonNull String str, @NonNull Object... objArr) {
        this.f418a.mo19971a(this, str, objArr);
    }
}
