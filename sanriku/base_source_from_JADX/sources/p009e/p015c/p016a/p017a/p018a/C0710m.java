package p009e.p015c.p016a.p017a.p018a;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.C0710m;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;
import p009e.p015c.p016a.p017a.p018a.p020o.C0718a;
import p009e.p015c.p016a.p017a.p018a.p023r.C0728b;

/* renamed from: e.c.a.a.a.m */
public abstract class C0710m<Model, U extends C0710m<Model, ?>> extends C0728b<Model, U> implements Cloneable {
    protected final ContentValues contents = new ContentValues();

    public C0710m(@NonNull C0700h hVar) {
        super(hVar);
    }

    public C0710m(@NonNull C0703j<Model, ?> jVar) {
        super(jVar);
    }

    public C0710m(@NonNull C0710m<Model, U> mVar) {
        super(mVar);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String buildColumnName(@NonNull C0695c<Model, ?> cVar) {
        return cVar.getEscapedName();
    }

    public abstract C0710m<Model, U> clone();

    public abstract /* bridge */ /* synthetic */ C0728b clone();

    public abstract /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException;

    public int execute() {
        C0700h hVar = this.conn;
        C0707k schema = getSchema();
        ContentValues contentValues = this.contents;
        String whereClause = getWhereClause();
        String[] bindArgs = getBindArgs();
        C0711a l = hVar.mo19816l();
        if (hVar.f392h) {
            StringBuilder a = C0681a.m330a("UPDATE ");
            a.append(schema.getEscapedTableName());
            a.append(" SET ");
            int size = contentValues.size();
            int length = bindArgs == null ? size : bindArgs.length + size;
            Object[] objArr = new Object[length];
            int i = 0;
            for (String next : contentValues.keySet()) {
                a.append(i > 0 ? "," : "");
                a.append(next);
                objArr[i] = contentValues.get(next);
                a.append("=?");
                i++;
            }
            if (bindArgs != null) {
                for (int i2 = size; i2 < length; i2++) {
                    objArr[i2] = bindArgs[i2 - size];
                }
            }
            if (!TextUtils.isEmpty(whereClause)) {
                a.append(" WHERE ");
                a.append(whereClause);
            }
            hVar.mo19809a((CharSequence) a, objArr);
        }
        int a2 = ((C0714d) l).mo19907a(schema.getEscapedTableName(), contentValues, whereClause, bindArgs);
        hVar.mo19808a(C0718a.C0719a.UPDATE, schema);
        return a2;
    }

    @NonNull
    public ContentValues getContentValues() {
        return this.contents;
    }

    public U putAll(ContentValues contentValues) {
        this.contents.putAll(contentValues);
        return this;
    }
}
