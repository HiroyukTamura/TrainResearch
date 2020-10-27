package p009e.p015c.p016a.p017a.p018a.p027t;

import android.database.Cursor;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import p009e.p015c.p016a.p017a.p018a.C0695c;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0703j;
import p009e.p015c.p016a.p017a.p018a.C0708l;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;
import p078g.p079a.C1706l;
import p078g.p079a.C1707m;
import p078g.p079a.C1708n;
import p078g.p079a.C1714r;

/* renamed from: e.c.a.a.a.t.f */
public abstract class C0865f<Model, S extends C0865f<Model, ?>> extends C0708l<Model, S> {

    /* renamed from: e.c.a.a.a.t.f$a */
    class C0866a implements Callable<Integer> {
        C0866a() {
        }

        public Object call() throws Exception {
            return Integer.valueOf(C0865f.this.count());
        }
    }

    /* renamed from: e.c.a.a.a.t.f$b */
    class C0867b implements C1708n<T> {

        /* renamed from: a */
        final /* synthetic */ C0695c f504a;

        C0867b(C0695c cVar) {
            this.f504a = cVar;
        }

        /* JADX INFO: finally extract failed */
        public void subscribe(C1707m<T> mVar) throws Exception {
            Cursor executeWithColumns = C0865f.this.executeWithColumns(this.f504a.getQualifiedName());
            int i = 0;
            while (!mVar.mo27340a() && executeWithColumns.moveToPosition(i)) {
                try {
                    mVar.mo27373a(this.f504a.getFromCursor(C0865f.this.conn, executeWithColumns, 0));
                    i++;
                } catch (Throwable th) {
                    executeWithColumns.close();
                    throw th;
                }
            }
            executeWithColumns.close();
            mVar.onComplete();
        }
    }

    /* renamed from: e.c.a.a.a.t.f$c */
    class C0868c implements C1708n<Model> {
        C0868c() {
        }

        /* JADX INFO: finally extract failed */
        public void subscribe(C1707m<Model> mVar) throws Exception {
            Cursor execute = C0865f.this.execute();
            int i = 0;
            while (!mVar.mo27340a() && execute.moveToPosition(i)) {
                try {
                    mVar.mo27373a(C0865f.this.newModelFromCursor(execute));
                    i++;
                } catch (Throwable th) {
                    execute.close();
                    throw th;
                }
            }
            execute.close();
            mVar.onComplete();
        }
    }

    public C0865f(@NonNull C0700h hVar) {
        super(hVar);
    }

    public C0865f(@NonNull C0703j<Model, ?> jVar) {
        super(jVar);
    }

    public C0865f(@NonNull C0708l<Model, ?> lVar) {
        super(lVar);
    }

    @CheckResult
    @NonNull
    public C1714r<Integer> countAsSingle() {
        return C1714r.m2413a(new C0866a());
    }

    @NonNull
    public C1706l<Model> executeAsObservable() {
        return C1706l.m2396a(new C0868c());
    }

    @NonNull
    public <T> C1706l<T> pluckAsObservable(C0695c<Model, T> cVar) {
        return C1706l.m2396a(new C0867b(cVar));
    }
}
