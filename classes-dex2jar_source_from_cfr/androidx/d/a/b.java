/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.widget.Filter
 *  android.widget.Filter$FilterResults
 */
package androidx.d.a;

import android.database.Cursor;
import android.widget.Filter;

class b
extends Filter {
    a a;

    b(a a2) {
        this.a = a2;
    }

    public CharSequence convertResultToString(Object object) {
        return this.a.b((Cursor)object);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        charSequence = this.a.a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence != null) {
            filterResults.count = charSequence.getCount();
        } else {
            filterResults.count = 0;
            charSequence = null;
        }
        filterResults.values = charSequence;
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        charSequence = this.a.a();
        if (filterResults.values != null && filterResults.values != charSequence) {
            this.a.a((Cursor)filterResults.values);
        }
    }

    static interface a {
        public Cursor a();

        public Cursor a(CharSequence var1);

        public void a(Cursor var1);

        public CharSequence b(Cursor var1);
    }

}

