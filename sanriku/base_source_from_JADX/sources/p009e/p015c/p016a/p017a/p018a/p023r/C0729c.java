package p009e.p015c.p016a.p017a.p018a.p023r;

import android.database.Cursor;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p009e.p015c.p016a.p017a.p018a.C0708l;

/* renamed from: e.c.a.a.a.r.c */
public class C0729c<Model> implements Iterator<Model> {

    /* renamed from: a */
    final C0708l<Model, ?> f412a;

    /* renamed from: b */
    final long f413b;

    /* renamed from: c */
    long f414c = 0;

    /* renamed from: d */
    long f415d;

    /* renamed from: e */
    Cursor f416e;

    /* JADX WARNING: type inference failed for: r4v0, types: [e.c.a.a.a.l, e.c.a.a.a.l<Model, ?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0729c(p009e.p015c.p016a.p017a.p018a.C0708l<Model, ?> r4) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f414c = r0
            boolean r2 = r4.hasOffset()
            if (r2 == 0) goto L_0x0011
            long r0 = r4.getOffset()
        L_0x0011:
            r3.f415d = r0
            boolean r0 = r4.hasLimit()
            if (r0 == 0) goto L_0x001e
            long r0 = r4.getLimit()
            goto L_0x0023
        L_0x001e:
            int r0 = r4.count()
            long r0 = (long) r0
        L_0x0023:
            r3.f413b = r0
            e.c.a.a.a.l r4 = r4.clone()
            e.c.a.a.a.l r4 = r4.resetLimitClause()
            r3.f412a = r4
            r3.mo19946a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p015c.p016a.p017a.p018a.p023r.C0729c.<init>(e.c.a.a.a.l):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19946a() {
        Cursor cursor = this.f416e;
        if (cursor != null) {
            cursor.close();
        }
        Cursor execute = this.f412a.limit(1000).offset(this.f415d).execute();
        this.f416e = execute;
        execute.moveToFirst();
        this.f415d += 1000;
    }

    public boolean hasNext() {
        return this.f414c < this.f413b;
    }

    public Model next() {
        if (this.f414c < this.f413b) {
            Model newModelFromCursor = this.f412a.newModelFromCursor(this.f416e);
            this.f414c++;
            if (!hasNext()) {
                this.f416e.close();
            } else if (this.f416e.isLast()) {
                mo19946a();
            } else {
                this.f416e.moveToNext();
            }
            return newModelFromCursor;
        }
        throw new NoSuchElementException("OrmaIterator#next()");
    }

    public void remove() {
        throw new UnsupportedOperationException("Iterator#remove()");
    }
}
