package p009e.p015c.p016a.p017a.p018a.p023r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.C0695c;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0707k;
import p009e.p015c.p016a.p017a.p018a.p022q.C0726a;
import p009e.p015c.p016a.p017a.p018a.p023r.C0728b;
import p043jp.reifrontier.gym.RFGDef;

/* renamed from: e.c.a.a.a.r.b */
public abstract class C0728b<Model, C extends C0728b<Model, ?>> implements Cloneable {
    @Nullable
    protected ArrayList<String> bindArgs;
    protected final C0700h conn;
    @Nullable
    protected StringBuilder whereClause;
    protected String whereConjunction;

    public C0728b(@NonNull C0700h hVar) {
        this.whereConjunction = " AND ";
        this.conn = hVar;
    }

    public C0728b(@NonNull C0728b<Model, ?> bVar) {
        this(bVar.conn);
        where(bVar);
    }

    private C emptyClone() {
        C clone = clone();
        clone.whereConjunction = " AND ";
        clone.whereClause = null;
        clone.bindArgs = null;
        return clone;
    }

    public C and() {
        this.whereConjunction = " AND ";
        return this;
    }

    /* access modifiers changed from: protected */
    public void appendBindArgs(@NonNull Object... objArr) {
        ArrayList<String> arrayList;
        String str;
        if (this.bindArgs == null) {
            this.bindArgs = new ArrayList<>(objArr.length);
        }
        for (Boolean bool : objArr) {
            if (bool == null) {
                this.bindArgs.add((Object) null);
            } else {
                if (bool instanceof Boolean) {
                    arrayList = this.bindArgs;
                    str = bool.booleanValue() ? "1" : RFGDef.DEFAULT_GYM_ID;
                } else {
                    arrayList = this.bindArgs;
                    str = bool.toString();
                }
                arrayList.add(str);
            }
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String buildColumnName(@NonNull C0695c<Model, ?> cVar);

    public abstract C0728b<Model, C> clone();

    /* access modifiers changed from: protected */
    @Nullable
    public String[] getBindArgs() {
        ArrayList<String> arrayList = this.bindArgs;
        if (arrayList == null) {
            return null;
        }
        return (String[]) this.bindArgs.toArray(new String[arrayList.size()]);
    }

    public C0700h getConnection() {
        return this.conn;
    }

    public abstract C0707k<Model> getSchema();

    /* access modifiers changed from: protected */
    @Nullable
    public String getWhereClause() {
        StringBuilder sb = this.whereClause;
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: in */
    public C mo19936in(boolean z, @NonNull C0695c<Model, ?> cVar, @NonNull Collection<?> collection) {
        StringBuilder a = C0681a.m330a(buildColumnName(cVar));
        if (z) {
            a.append(" NOT");
        }
        a.append(" IN (");
        int i = 0;
        int size = collection.size();
        while (i < size) {
            a.append('?');
            i++;
            if (i != size) {
                a.append(", ");
            }
        }
        a.append(')');
        return where((CharSequence) a, collection);
    }

    /* access modifiers changed from: protected */
    /* renamed from: in */
    public <ColumnType, SerializedType> C mo19937in(boolean z, @NonNull C0695c<Model, ?> cVar, @NonNull Collection<ColumnType> collection, C0726a<ColumnType, SerializedType> aVar) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (ColumnType apply : collection) {
            arrayList.add(aVar.apply(apply));
        }
        return mo19936in(z, cVar, arrayList);
    }

    /* renamed from: or */
    public C mo19938or() {
        this.whereConjunction = " OR ";
        return this;
    }

    public C where(@NonNull C0695c<Model, ?> cVar, @NonNull String str) {
        return where((CharSequence) buildColumnName(cVar) + ' ' + str, new Object[0]);
    }

    public C where(@NonNull C0695c<Model, ?> cVar, @NonNull String str, @NonNull Object obj) {
        return where((CharSequence) buildColumnName(cVar) + ' ' + str + " ?", obj);
    }

    public C where(@NonNull C0726a<C, C> aVar) {
        return where((C0728b) aVar.apply(emptyClone()));
    }

    public C where(@NonNull C0728b<Model, ?> bVar) {
        ArrayList<String> arrayList;
        StringBuilder sb = bVar.whereClause;
        if (!(sb == null || (arrayList = bVar.bindArgs) == null)) {
            where((CharSequence) sb, (Collection<?>) arrayList);
        }
        return this;
    }

    public C where(@NonNull CharSequence charSequence, @NonNull Collection<?> collection) {
        return where(charSequence, collection.toArray());
    }

    public C where(@NonNull CharSequence charSequence, @NonNull Object... objArr) {
        StringBuilder sb = this.whereClause;
        if (sb == null) {
            this.whereClause = new StringBuilder(charSequence.length() + 2);
        } else {
            sb.append(this.whereConjunction);
        }
        this.whereClause.append('(');
        this.whereClause.append(charSequence);
        this.whereClause.append(')');
        appendBindArgs(objArr);
        return this;
    }

    /* access modifiers changed from: protected */
    public C whereBetween(@NonNull C0695c<Model, ?> cVar, Object obj, Object obj2) {
        return where((CharSequence) C0681a.m324a(new StringBuilder(), buildColumnName(cVar), " BETWEEN ? AND ?"), obj, obj2);
    }
}
