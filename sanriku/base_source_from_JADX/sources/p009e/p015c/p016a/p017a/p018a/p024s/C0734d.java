package p009e.p015c.p016a.p017a.p018a.p024s;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;

@SuppressLint({"Assert"})
/* renamed from: e.c.a.a.a.s.d */
public class C0734d extends C0731a {

    /* renamed from: b */
    final int f427b;

    /* renamed from: c */
    final SparseArray<C0736b> f428c;

    /* renamed from: d */
    boolean f429d = false;

    /* renamed from: e.c.a.a.a.s.d$a */
    public class C0735a {
        public C0735a(C0734d dVar, C0711a aVar, int i, boolean z) {
        }
    }

    /* renamed from: e.c.a.a.a.s.d$b */
    public interface C0736b {
        /* renamed from: a */
        void mo19958a(@NonNull C0735a aVar);

        /* renamed from: b */
        void mo19959b(@NonNull C0735a aVar);
    }

    public C0734d(@NonNull Context context, int i, @NonNull SparseArray<C0736b> sparseArray, @NonNull C0745l lVar) {
        super(lVar);
        String str = C0731a.m413b(context).versionName;
        C0731a.m412a(context);
        this.f427b = i;
        this.f428c = sparseArray.clone();
    }

    /* renamed from: b */
    private void m416b(@NonNull C0711a aVar, @NonNull List<Runnable> list) {
        if (!list.isEmpty()) {
            C0714d dVar = (C0714d) aVar;
            boolean z = dVar.mo19911a("PRAGMA foreign_keys", (String[]) null) != 0;
            if (z) {
                dVar.mo19919b("PRAGMA foreign_keys = OFF");
            }
            dVar.mo19914a();
            try {
                for (Runnable run : list) {
                    run.run();
                }
                dVar.mo19924g();
            } finally {
                dVar.mo19921d();
                if (z) {
                    dVar.mo19919b("PRAGMA foreign_keys = ON");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19954a(@NonNull C0711a aVar) {
        if (!this.f429d) {
            ((C0714d) aVar).mo19919b("CREATE TABLE IF NOT EXISTS orma_migration_steps (id INTEGER PRIMARY KEY AUTOINCREMENT, version INTEGER NOT NULL, sql TEXT NULL, created_timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP)");
            this.f429d = true;
        }
    }

    /* renamed from: a */
    public void mo19955a(@NonNull C0711a aVar, int i, @Nullable String str) {
        mo19954a(aVar);
        ContentValues contentValues = new ContentValues();
        contentValues.put("version", Integer.valueOf(i));
        contentValues.put("sql", str);
        C0714d dVar = (C0714d) aVar;
        dVar.mo19908a("orma_migration_steps", (String) null, contentValues);
        dVar.mo19915a(i);
        mo19951a("set version to %d, creating a migration log for %s", Integer.valueOf(i), str);
    }

    /* renamed from: a */
    public void mo19956a(@NonNull C0711a aVar, @NonNull List<? extends C0738f> list) {
        C0714d dVar = (C0714d) aVar;
        int e = dVar.mo19922e();
        if (e == 0) {
            dVar.mo19915a(this.f427b);
            mo19951a("set version from 0 to %d", Integer.valueOf(this.f427b));
            return;
        }
        int i = this.f427b;
        if (e == i) {
            mo19951a("nothing tdo (version=%d)", Integer.valueOf(i));
            return;
        }
        mo19951a("start migration from %d to %d", Integer.valueOf(e), Integer.valueOf(this.f427b));
        int i2 = this.f427b;
        if (e < i2) {
            mo19954a(aVar);
            ArrayList arrayList = new ArrayList();
            int size = this.f428c.size();
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.f428c.keyAt(i3);
                if (e < keyAt && keyAt <= i2) {
                    arrayList.add(new C0732b(this, keyAt, this.f428c.valueAt(i3), new C0735a(this, aVar, keyAt, true)));
                }
            }
            m416b(aVar, arrayList);
            mo19955a(aVar, i2, (String) null);
            return;
        }
        mo19954a(aVar);
        ArrayList arrayList2 = new ArrayList();
        int size2 = this.f428c.size();
        while (true) {
            size2--;
            if (size2 >= 0) {
                int keyAt2 = this.f428c.keyAt(size2);
                if (i2 < keyAt2 && keyAt2 <= e) {
                    arrayList2.add(new C0733c(this, keyAt2, this.f428c.valueAt(size2), new C0735a(this, aVar, keyAt2, false)));
                }
            } else {
                m416b(aVar, arrayList2);
                mo19955a(aVar, i2, (String) null);
                return;
            }
        }
    }

    @NonNull
    public String getTag() {
        return "ManualStepMigration";
    }
}
