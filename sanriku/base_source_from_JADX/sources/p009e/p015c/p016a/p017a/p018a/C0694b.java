package p009e.p015c.p016a.p017a.p018a;

import androidx.annotation.NonNull;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.p023r.C0728b;

/* renamed from: e.c.a.a.a.b */
public abstract class C0694b<Model, A extends C0694b<Model, ?>> extends C0728b<Model, A> implements Cloneable {
    public C0694b(@NonNull C0694b<Model, A> bVar) {
        super(bVar);
    }

    public C0694b(@NonNull C0700h hVar) {
        super(hVar);
    }

    public C0694b(@NonNull C0703j<Model, ?> jVar) {
        super(jVar);
    }

    public <C extends C0728b<?, ?>> C appendTo(C c) {
        String whereClause = getWhereClause();
        String[] bindArgs = getBindArgs();
        if (whereClause != null && bindArgs != null) {
            c.where((CharSequence) whereClause, (Object[]) bindArgs);
        } else if (whereClause != null) {
            c.where((CharSequence) whereClause, new Object[0]);
        }
        return c;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String buildColumnName(@NonNull C0695c<Model, ?> cVar) {
        return cVar.getQualifiedName();
    }

    public abstract C0694b<Model, A> clone();

    public abstract /* bridge */ /* synthetic */ C0728b clone();

    public abstract /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException;
}
