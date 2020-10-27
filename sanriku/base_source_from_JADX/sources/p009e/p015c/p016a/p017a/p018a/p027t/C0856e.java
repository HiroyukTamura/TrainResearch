package p009e.p015c.p016a.p017a.p018a.p027t;

import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.C0696d;
import p009e.p015c.p016a.p017a.p018a.C0698f;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0703j;
import p009e.p015c.p016a.p017a.p018a.C0707k;
import p009e.p015c.p016a.p017a.p018a.C0708l;
import p009e.p015c.p016a.p017a.p018a.C0710m;
import p009e.p015c.p016a.p017a.p018a.p020o.C0718a;
import p009e.p015c.p016a.p017a.p018a.p021p.C0722b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;
import p078g.p079a.C1704j;
import p078g.p079a.C1705k;
import p078g.p079a.C1706l;
import p078g.p079a.C1707m;
import p078g.p079a.C1708n;
import p078g.p079a.C1714r;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p085e.p088c.C1621a;
import p078g.p079a.p080A.p085e.p089d.C1629e;
import p078g.p079a.p100z.C1742e;

/* renamed from: e.c.a.a.a.t.e */
public abstract class C0856e<Model, R extends C0856e<Model, ?>> extends C0703j<Model, R> {
    protected final C0855d conn;

    /* renamed from: e.c.a.a.a.t.e$a */
    class C0857a implements Callable<Model> {

        /* renamed from: a */
        final /* synthetic */ int f490a;

        C0857a(int i) {
            this.f490a = i;
        }

        public Model call() throws Exception {
            return C0856e.this.get(this.f490a);
        }
    }

    /* renamed from: e.c.a.a.a.t.e$b */
    class C0858b implements C1705k<Integer> {

        /* renamed from: a */
        final /* synthetic */ Object f492a;

        C0858b(C0856e eVar, Object obj) {
            this.f492a = obj;
        }
    }

    /* renamed from: e.c.a.a.a.t.e$c */
    class C0859c implements Callable<Integer> {

        /* renamed from: a */
        final /* synthetic */ int f493a;

        C0859c(int i) {
            this.f493a = i;
        }

        public Object call() throws Exception {
            String escapedName = C0856e.this.getSchema().getPrimaryKey().getEscapedName();
            C0865f selector = C0856e.this.selector();
            selector.limit(2147483647L);
            selector.offset((long) this.f493a);
            C0856e eVar = C0856e.this;
            return Integer.valueOf(eVar.conn.mo19801a((C0707k<?>) eVar.getSchema(), C0681a.m324a(C0681a.m340c(escapedName, " IN ("), selector.buildQueryWithColumns(escapedName), ")"), C0856e.this.getBindArgs()));
        }
    }

    /* renamed from: e.c.a.a.a.t.e$d */
    class C0860d implements Callable<Long> {

        /* renamed from: a */
        final /* synthetic */ Callable f495a;

        C0860d(Callable callable) {
            this.f495a = callable;
        }

        public Object call() throws Exception {
            C0854c inserter = C0856e.this.inserter();
            Callable callable = this.f495a;
            if (inserter != null) {
                try {
                    return Long.valueOf(inserter.mo19796a(callable.call()));
                } catch (Exception e) {
                    throw new C0722b((Throwable) e);
                }
            } else {
                throw null;
            }
        }
    }

    /* renamed from: e.c.a.a.a.t.e$e */
    class C0861e implements C0698f<Model> {

        /* renamed from: a */
        final /* synthetic */ Object f497a;

        C0861e(Object obj) {
            this.f497a = obj;
        }

        @NonNull
        public Model call() {
            return C0856e.this.upsert(this.f497a);
        }
    }

    /* renamed from: e.c.a.a.a.t.e$f */
    class C0862f implements C1708n<Model> {

        /* renamed from: a */
        final /* synthetic */ Iterable f499a;

        /* renamed from: e.c.a.a.a.t.e$f$a */
        class C0863a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1707m f501a;

            C0863a(C1707m mVar) {
                this.f501a = mVar;
            }

            public void run() {
                for (Object upsertWithoutTransaction : C0862f.this.f499a) {
                    this.f501a.mo27373a(C0856e.this.upsertWithoutTransaction(upsertWithoutTransaction));
                }
            }
        }

        C0862f(Iterable iterable) {
            this.f499a = iterable;
        }

        public void subscribe(C1707m<Model> mVar) {
            C0856e.this.conn.mo19811b(new C0863a(mVar));
            mVar.onComplete();
        }
    }

    /* renamed from: e.c.a.a.a.t.e$g */
    class C0864g implements C1742e<C0718a<S>, S> {
        C0864g(C0856e eVar) {
        }

        public Object apply(Object obj) throws Exception {
            return ((C0718a) obj).mo19927a();
        }
    }

    public C0856e(@NonNull C0855d dVar) {
        super((C0700h) dVar);
        this.conn = dVar;
    }

    public C0856e(@NonNull C0856e<Model, ?> eVar) {
        super(eVar);
        this.conn = eVar.conn;
    }

    @Deprecated
    public <S extends C0708l<Model, ?>> C1706l<C0718a<S>> createEventObservable() {
        return this.conn.mo20248a(selector());
    }

    public <S extends C0708l<Model, ?>> C1706l<S> createQueryObservable() {
        C1706l a = this.conn.mo20248a(selector());
        C0864g gVar = new C0864g(this);
        if (a != null) {
            C1599b.m2241a(gVar, "mapper is null");
            return new C1629e(a, gVar);
        }
        throw null;
    }

    @CheckResult
    @NonNull
    public C1704j<Integer> deleteAsMaybe(@NonNull Model model) {
        C0858b bVar = new C0858b(this, model);
        C1599b.m2241a(bVar, "onSubscribe is null");
        return new C1621a(bVar);
    }

    @NonNull
    public abstract /* bridge */ /* synthetic */ C0696d deleter();

    @NonNull
    public abstract C0852b<Model, ?> deleter();

    @CheckResult
    @NonNull
    public C1714r<Model> getAsSingle(@IntRange(from = 0) int i) {
        return C1714r.m2413a(new C0857a(i));
    }

    @CheckResult
    @NonNull
    public C1714r<Long> insertAsSingle(@NonNull Callable<Model> callable) {
        return C1714r.m2413a(new C0860d(callable));
    }

    @NonNull
    public C0854c<Model> inserter() {
        return inserter(0, true);
    }

    @NonNull
    public C0854c<Model> inserter(int i) {
        return new C0854c<>(this.conn, getSchema(), i, true);
    }

    @NonNull
    public C0854c<Model> inserter(int i, boolean z) {
        return new C0854c<>(this.conn, getSchema(), i, z);
    }

    @NonNull
    public abstract /* bridge */ /* synthetic */ C0708l selector();

    @NonNull
    public abstract C0865f<Model, ?> selector();

    @CheckResult
    @NonNull
    public C1714r<Integer> truncateAsSingle(@IntRange(from = 0) int i) {
        return C1714r.m2413a(new C0859c(i));
    }

    @NonNull
    public abstract /* bridge */ /* synthetic */ C0710m updater();

    @NonNull
    public abstract C0869g<Model, ?> updater();

    @CheckResult
    @NonNull
    public C1706l<Model> upsertAsObservable(@NonNull Iterable<Model> iterable) {
        return C1706l.m2396a(new C0862f(iterable));
    }

    @CheckResult
    @NonNull
    public C1714r<Model> upsertAsSingle(@NonNull Model model) {
        return C1714r.m2413a(new C0861e(model));
    }

    @NonNull
    @Deprecated
    public C0854c<Model> upserter() {
        return inserter(5, false);
    }
}
