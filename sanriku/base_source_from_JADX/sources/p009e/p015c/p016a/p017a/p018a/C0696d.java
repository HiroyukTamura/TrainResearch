package p009e.p015c.p016a.p017a.p018a;

import androidx.annotation.NonNull;
import p009e.p015c.p016a.p017a.p018a.C0696d;
import p009e.p015c.p016a.p017a.p018a.p023r.C0728b;

/* renamed from: e.c.a.a.a.d */
public abstract class C0696d<Model, D extends C0696d<Model, ?>> extends C0728b<Model, D> implements Cloneable {
    public C0696d(@NonNull C0696d<Model, D> dVar) {
        super(dVar);
    }

    public C0696d(@NonNull C0700h hVar) {
        super(hVar);
    }

    public C0696d(@NonNull C0703j<Model, ?> jVar) {
        super(jVar);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String buildColumnName(@NonNull C0695c<Model, ?> cVar) {
        return cVar.getEscapedName();
    }

    public abstract C0696d<Model, D> clone();

    public abstract /* bridge */ /* synthetic */ C0728b clone();

    public abstract /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException;

    public int execute() {
        return this.conn.mo19801a((C0707k<?>) getSchema(), getWhereClause(), getBindArgs());
    }
}
