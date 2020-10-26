/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.widget.TimePicker
 *  android.widget.TimePicker$OnTimeChangedListener
 */
package jp.co.jreast.jreastapp.commuter.h.a;

import android.widget.TimePicker;

public final class e
implements TimePicker.OnTimeChangedListener {
    final a a;
    final int b;

    public e(a a2, int n2) {
        this.a = a2;
        this.b = n2;
    }

    public void onTimeChanged(TimePicker timePicker, int n2, int n3) {
        this.a.a(this.b, timePicker, n2, n3);
    }

    public static interface a {
        public void a(int var1, TimePicker var2, int var3, int var4);
    }

}

