package p009e.p015c.p016a.p017a.p018a;

import android.content.ContentValues;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p009e.p015c.p016a.p017a.p018a.C0703j;
import p009e.p015c.p016a.p017a.p018a.p023r.C0728b;

/* renamed from: e.c.a.a.a.j */
public abstract class C0703j<Model, R extends C0703j<Model, ?>> extends C0728b<Model, R> implements Cloneable, Iterable<Model> {
    protected final ArrayList<C0699g<Model>> orderSpecs;

    /* renamed from: e.c.a.a.a.j$a */
    class C0704a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0705b f397a;

        /* renamed from: b */
        final /* synthetic */ Object f398b;

        C0704a(C0705b bVar, Object obj) {
            this.f397a = bVar;
            this.f398b = obj;
        }

        public void run() {
            this.f397a.f400a = C0703j.this.upsertWithoutTransaction(this.f398b);
        }
    }

    /* renamed from: e.c.a.a.a.j$b */
    class C0705b<T> {

        /* renamed from: a */
        T f400a;

        C0705b(C0703j jVar) {
        }
    }

    /* renamed from: e.c.a.a.a.j$c */
    class C0706c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Iterable f401a;

        /* renamed from: b */
        final /* synthetic */ List f402b;

        C0706c(Iterable iterable, List list) {
            this.f401a = iterable;
            this.f402b = list;
        }

        public void run() {
            for (Object upsertWithoutTransaction : this.f401a) {
                this.f402b.add(C0703j.this.upsertWithoutTransaction(upsertWithoutTransaction));
            }
        }
    }

    public C0703j(@NonNull C0700h hVar) {
        super(hVar);
        this.orderSpecs = new ArrayList<>();
    }

    public C0703j(@NonNull C0703j<Model, ?> jVar) {
        super(jVar);
        ArrayList<C0699g<Model>> arrayList = new ArrayList<>();
        this.orderSpecs = arrayList;
        arrayList.addAll(jVar.orderSpecs);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String buildColumnName(@NonNull C0695c<Model, ?> cVar) {
        return cVar.getQualifiedName();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String buildOrderingTerms() {
        if (this.orderSpecs.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<C0699g<Model>> it = this.orderSpecs.iterator();
        while (it.hasNext()) {
            C0699g next = it.next();
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(next);
        }
        return sb.toString();
    }

    public abstract C0703j<Model, R> clone();

    public abstract /* bridge */ /* synthetic */ C0728b clone();

    public abstract /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException;

    @NonNull
    public Object[] convertToArgs(@NonNull Model model, boolean z) {
        return getSchema().convertToArgs(this.conn, model, z);
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull Model model, boolean z) {
        return getSchema().convertToContentValues(this.conn, model, z);
    }

    @IntRange(from = 0)
    public int count() {
        return selector().count();
    }

    @NonNull
    public abstract C0696d<Model, ?> deleter();

    @NonNull
    public Model get(@IntRange(from = 0) int i) {
        return selector().get((long) i);
    }

    @NonNull
    public Model getOrCreate(@IntRange(from = 0) long j, @NonNull C0698f<Model> fVar) {
        Model orNull = selector().getOrNull(j);
        return orNull == null ? this.conn.mo19805a(getSchema(), fVar) : orNull;
    }

    public int indexOf(@NonNull Model model) {
        String str;
        Object obj;
        C0708l selector = selector();
        Iterator<C0699g<Model>> it = this.orderSpecs.iterator();
        while (it.hasNext()) {
            C0699g next = it.next();
            C0695c<Model, ?> cVar = next.f383a;
            if (next.f384b.equals("ASC")) {
                obj = cVar.getSerialized(model);
                str = "<";
            } else {
                obj = cVar.getSerialized(model);
                str = ">";
            }
            selector.where(cVar, str, obj);
        }
        return selector.count();
    }

    @NonNull
    public abstract C0697e<Model> inserter();

    @NonNull
    public abstract C0697e<Model> inserter(int i);

    @NonNull
    public abstract C0697e<Model> inserter(int i, boolean z);

    public boolean isEmpty() {
        return selector().isEmpty();
    }

    public Iterator<Model> iterator() {
        return selector().iterator();
    }

    @NonNull
    public R orderBy(@NonNull C0699g<Model> gVar) {
        this.orderSpecs.add(gVar);
        return this;
    }

    @NonNull
    public abstract C0708l<Model, ?> selector();

    @NonNull
    public abstract C0710m<Model, ?> updater();

    @NonNull
    public Model upsert(@NonNull Model model) {
        C0705b bVar = new C0705b(this);
        this.conn.mo19811b(new C0704a(bVar, model));
        return bVar.f400a;
    }

    @NonNull
    public List<Model> upsert(@NonNull Iterable<Model> iterable) {
        ArrayList arrayList = new ArrayList();
        this.conn.mo19811b(new C0706c(iterable, arrayList));
        return arrayList;
    }

    @NonNull
    public abstract Model upsertWithoutTransaction(@NonNull Model model);

    @NonNull
    @Deprecated
    public abstract C0697e<Model> upserter();
}
