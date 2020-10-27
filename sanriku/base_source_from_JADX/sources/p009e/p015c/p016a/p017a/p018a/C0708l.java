package p009e.p015c.p016a.p017a.p018a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.C0708l;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;
import p009e.p015c.p016a.p017a.p018a.p021p.C0723c;
import p009e.p015c.p016a.p017a.p018a.p021p.C0724d;
import p009e.p015c.p016a.p017a.p018a.p022q.C0726a;
import p009e.p015c.p016a.p017a.p018a.p023r.C0728b;
import p009e.p015c.p016a.p017a.p018a.p023r.C0729c;

@SuppressLint({"Assert"})
/* renamed from: e.c.a.a.a.l */
public abstract class C0708l<Model, S extends C0708l<Model, ?>> extends C0728b<Model, S> implements Iterable<Model>, Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String[] countSelections = {"COUNT(*)"};
    @Nullable
    protected String groupBy;
    @Nullable
    protected String having;
    protected long limit = -1;
    protected long offset = -1;
    @Nullable
    protected String orderBy;
    protected long page = -1;

    /* renamed from: e.c.a.a.a.l$a */
    class C0709a implements C0726a<Cursor, Model> {
        C0709a() {
        }

        public Object apply(Object obj) {
            return C0708l.this.newModelFromCursor((Cursor) obj);
        }
    }

    static {
        Class<C0708l> cls = C0708l.class;
    }

    public C0708l(@NonNull C0700h hVar) {
        super(hVar);
    }

    public C0708l(@NonNull C0703j<Model, ?> jVar) {
        super(jVar);
        this.orderBy = jVar.buildOrderingTerms();
    }

    public C0708l(@NonNull C0708l<Model, ?> lVar) {
        super(lVar);
        this.groupBy = lVar.groupBy;
        this.having = lVar.having;
        this.orderBy = lVar.orderBy;
        this.limit = lVar.limit;
        this.offset = lVar.offset;
        this.page = lVar.page;
    }

    @Nullable
    private String getLimitClause() {
        long j;
        StringBuilder sb;
        if (this.page == -1 || this.offset == -1) {
            long j2 = this.limit;
            if (j2 != -1) {
                if (this.offset != -1) {
                    sb = new StringBuilder();
                    j = this.offset;
                } else if (this.page == -1) {
                    return String.valueOf(j2);
                } else {
                    sb = new StringBuilder();
                    j = (this.page - 1) * this.limit;
                }
                sb.append(j);
                sb.append(",");
                sb.append(this.limit);
                return sb.toString();
            } else if (this.offset == -1 && this.page == -1) {
                return null;
            } else {
                throw new C0723c("Missing limit() when offset() or page() is specified.");
            }
        } else {
            throw new C0723c("page() and offset() are exclusive. Use either.");
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String buildColumnName(@NonNull C0695c<Model, ?> cVar) {
        return cVar.getQualifiedName();
    }

    @NonNull
    public String buildQuery() {
        return buildQueryWithColumns(getSchema().getDefaultResultColumns());
    }

    @NonNull
    public String buildQueryWithColumns(@NonNull String... strArr) {
        return SQLiteQueryBuilder.buildQueryString(false, getSchema().getSelectFromTableClause(), strArr, getWhereClause(), this.groupBy, this.having, this.orderBy, getLimitClause());
    }

    public abstract C0708l<Model, S> clone();

    @IntRange(from = 0)
    public int count() {
        String buildQueryString = SQLiteQueryBuilder.buildQueryString(false, getSchema().getSelectFromTableClause(), countSelections, getWhereClause(), this.groupBy, (String) null, (String) null, (String) null);
        C0700h hVar = this.conn;
        String[] bindArgs = getBindArgs();
        hVar.mo19809a((CharSequence) buildQueryString, (Object[]) bindArgs);
        return (int) ((C0714d) hVar.mo19814h()).mo19911a(buildQueryString, bindArgs);
    }

    @CheckResult
    @NonNull
    public Cursor execute() {
        return this.conn.mo19803a(buildQuery(), getBindArgs());
    }

    @CheckResult
    @NonNull
    public Cursor executeWithColumns(@NonNull String... strArr) {
        return this.conn.mo19803a(buildQueryWithColumns(strArr), getBindArgs());
    }

    @NonNull
    public Model get(@IntRange(from = 0) long j) {
        Model orNull = getOrNull(j);
        if (orNull != null) {
            return orNull;
        }
        throw new C0724d("Expected single get for " + j + " but nothing for " + getSchema().getTableName());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getLimit() {
        return this.limit;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getOffset() {
        long j = this.offset;
        return j != -1 ? j : (this.page - 1) * this.limit;
    }

    @Nullable
    public Model getOrNull(@IntRange(from = 0) long j) {
        return this.conn.mo19806a(getSchema(), getSchema().getDefaultResultColumns(), getWhereClause(), getBindArgs(), this.groupBy, this.having, this.orderBy, Math.max(this.offset, 0) + j);
    }

    @NonNull
    public <T> List<T> getRawValuesAndMap(@NonNull C0726a<Cursor, T> aVar) {
        Cursor execute = execute();
        try {
            ArrayList arrayList = new ArrayList(execute.getCount());
            for (int i = 0; execute.moveToPosition(i); i++) {
                arrayList.add(((C0709a) aVar).apply(execute));
            }
            return arrayList;
        } finally {
            execute.close();
        }
    }

    public S groupBy(@NonNull String str) {
        this.groupBy = str;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasLimit() {
        return this.limit != -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasOffset() {
        return (this.offset == -1 && (this.limit == -1 || this.page == -1)) ? false : true;
    }

    public S having(@NonNull String str, @NonNull Object... objArr) {
        this.having = str;
        appendBindArgs(objArr);
        return this;
    }

    public boolean isEmpty() {
        return count() == 0;
    }

    @NonNull
    public Iterator<Model> iterator() {
        return new C0729c(this);
    }

    public S limit(@IntRange(from = 1) long j) {
        this.limit = j;
        return this;
    }

    @NonNull
    public Model newModelFromCursor(@NonNull Cursor cursor) {
        return getSchema().newModelFromCursor(this.conn, cursor, 0);
    }

    public S offset(@IntRange(from = 0) long j) {
        this.offset = j;
        return this;
    }

    public S orderBy(@NonNull C0699g<Model> gVar) {
        return orderBy((CharSequence) gVar.toString());
    }

    public S orderBy(@NonNull CharSequence charSequence) {
        String str;
        if (this.orderBy == null) {
            str = charSequence.toString();
        } else {
            str = this.orderBy + ", " + charSequence;
        }
        this.orderBy = str;
        return this;
    }

    public S page(@IntRange(from = 1) long j) {
        this.page = j;
        return this;
    }

    public S per(@IntRange(from = 1) long j) {
        this.limit = j;
        return this;
    }

    @NonNull
    public <T> Iterable<T> pluck(C0695c<Model, T> cVar) {
        Cursor executeWithColumns = executeWithColumns(cVar.getQualifiedName());
        try {
            ArrayList arrayList = new ArrayList(executeWithColumns.getCount());
            for (int i = 0; executeWithColumns.moveToPosition(i); i++) {
                arrayList.add(cVar.getFromCursor(this.conn, executeWithColumns, 0));
            }
            return arrayList;
        } finally {
            executeWithColumns.close();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public S resetLimitClause() {
        this.limit = -1;
        this.offset = -1;
        this.page = -1;
        return this;
    }

    @NonNull
    public List<Model> toList() {
        return getRawValuesAndMap(new C0709a());
    }

    @NonNull
    public Model value() throws C0724d {
        Model orNull = getOrNull(0);
        if (orNull != null) {
            return orNull;
        }
        StringBuilder a = C0681a.m330a("Expected single get but nothing for ");
        a.append(getSchema().getTableName());
        throw new C0724d(a.toString());
    }

    @Nullable
    public Model valueOrNull() {
        return getOrNull(0);
    }
}
