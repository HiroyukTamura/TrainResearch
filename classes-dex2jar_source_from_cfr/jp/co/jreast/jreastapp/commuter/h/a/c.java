/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.widget.DatePicker
 *  android.widget.DatePicker$OnDateChangedListener
 */
package jp.co.jreast.jreastapp.commuter.h.a;

import android.widget.DatePicker;

public final class c
implements DatePicker.OnDateChangedListener {
    final a a;
    final int b;

    public c(a a2, int n2) {
        this.a = a2;
        this.b = n2;
    }

    public void onDateChanged(DatePicker datePicker, int n2, int n3, int n4) {
        this.a.a(this.b, datePicker, n2, n3, n4);
    }

    public static interface a {
        public void a(int var1, DatePicker var2, int var3, int var4, int var5);
    }

}

