/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.DataSetObserver
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.Filter
 *  android.widget.FilterQueryProvider
 *  android.widget.Filterable
 */
package androidx.d.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.d.a.b;

public abstract class a
extends BaseAdapter
implements Filterable,
b.a {
    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected a f;
    protected DataSetObserver g;
    protected androidx.d.a.b h;
    protected FilterQueryProvider i;

    public a(Context context, Cursor cursor, boolean bl2) {
        int n2 = bl2 ? 1 : 2;
        this.a(context, cursor, n2);
    }

    @Override
    public Cursor a() {
        return this.c;
    }

    @Override
    public Cursor a(CharSequence charSequence) {
        if (this.i != null) {
            return this.i.runQuery(charSequence);
        }
        return this.c;
    }

    public abstract View a(Context var1, Cursor var2, ViewGroup var3);

    /*
     * Enabled aggressive block sorting
     */
    void a(Context object, Cursor cursor, int n2) {
        int n3;
        void var1_3;
        void var2_5;
        boolean bl2 = false;
        if ((n3 & true) == 1) {
            n3 |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        if (var2_5 != null) {
            bl2 = true;
        }
        this.c = var2_5;
        this.a = bl2;
        this.d = object;
        int n4 = bl2 ? var2_5.getColumnIndexOrThrow("_id") : -1;
        this.e = n4;
        if ((n3 & 2) == 2) {
            this.f = new a();
            b b2 = new b();
        } else {
            Object var1_4 = null;
            this.f = null;
        }
        this.g = var1_3;
        if (bl2) {
            if (this.f != null) {
                var2_5.registerContentObserver((ContentObserver)this.f);
            }
            if (this.g != null) {
                var2_5.registerDataSetObserver(this.g);
            }
        }
    }

    @Override
    public void a(Cursor cursor) {
        if ((cursor = this.c(cursor)) != null) {
            cursor.close();
        }
    }

    public abstract void a(View var1, Context var2, Cursor var3);

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.a(context, cursor, viewGroup);
    }

    @Override
    public CharSequence b(Cursor cursor) {
        if (cursor == null) {
            return "";
        }
        return cursor.toString();
    }

    protected void b() {
        if (this.b && this.c != null && !this.c.isClosed()) {
            this.a = this.c.requery();
        }
    }

    public Cursor c(Cursor cursor) {
        if (cursor == this.c) {
            return null;
        }
        Cursor cursor2 = this.c;
        if (cursor2 != null) {
            if (this.f != null) {
                cursor2.unregisterContentObserver((ContentObserver)this.f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            if (this.f != null) {
                cursor.registerContentObserver((ContentObserver)this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.a = true;
            this.notifyDataSetChanged();
            return cursor2;
        }
        this.e = -1;
        this.a = false;
        this.notifyDataSetInvalidated();
        return cursor2;
    }

    public int getCount() {
        if (this.a && this.c != null) {
            return this.c.getCount();
        }
        return 0;
    }

    public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
        if (this.a) {
            this.c.moveToPosition(n2);
            View view2 = view;
            if (view == null) {
                view2 = this.b(this.d, this.c, viewGroup);
            }
            this.a(view2, this.d, this.c);
            return view2;
        }
        return null;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new androidx.d.a.b(this);
        }
        return this.h;
    }

    public Object getItem(int n2) {
        if (this.a && this.c != null) {
            this.c.moveToPosition(n2);
            return this.c;
        }
        return null;
    }

    public long getItemId(int n2) {
        if (this.a && this.c != null && this.c.moveToPosition(n2)) {
            return this.c.getLong(this.e);
        }
        return 0L;
    }

    public View getView(int n2, View object, ViewGroup viewGroup) {
        if (this.a) {
            if (this.c.moveToPosition(n2)) {
                View view = object;
                if (object == null) {
                    view = this.a(this.d, this.c, viewGroup);
                }
                this.a(view, this.d, this.c);
                return view;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("couldn't move cursor to position ");
            ((StringBuilder)object).append(n2);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public boolean hasStableIds() {
        return true;
    }

    private class a
    extends ContentObserver {
        a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean bl2) {
            a.this.b();
        }
    }

    private class b
    extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a.this.a = true;
            a.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a.this.a = false;
            a.this.notifyDataSetInvalidated();
        }
    }

}

