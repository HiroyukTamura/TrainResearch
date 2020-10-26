/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 */
package jp.co.jreast.jreastapp.commuter.h.a;

import android.text.Editable;
import androidx.databinding.a.e;

public final class a
implements e.a {
    final a a;
    final int b;

    public a(a a2, int n2) {
        this.a = a2;
        this.b = n2;
    }

    @Override
    public void a(Editable editable) {
        this.a.a(this.b, editable);
    }

    public static interface a {
        public void a(int var1, Editable var2);
    }

}

