/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.DatePicker
 *  android.widget.DatePicker$OnDateChangedListener
 */
package androidx.databinding.a;

import android.view.View;
import android.widget.DatePicker;
import androidx.databinding.a.d;
import androidx.databinding.b.a.b;
import androidx.databinding.g;

public class b {
    public static void a(DatePicker datePicker, int n2, int n3, int n4, DatePicker.OnDateChangedListener onDateChangedListener, g g2, g g3, g g4) {
        a a2;
        int n5 = n2;
        if (n2 == 0) {
            n5 = datePicker.getYear();
        }
        n2 = n4;
        if (n4 == 0) {
            n2 = datePicker.getDayOfMonth();
        }
        if (g2 == null && g3 == null && g4 == null) {
            datePicker.init(n5, n3, n2, onDateChangedListener);
            return;
        }
        a a3 = a2 = (a)d.a((View)datePicker, b.a.onDateChanged);
        if (a2 == null) {
            a3 = new a();
            d.a((View)datePicker, a3, b.a.onDateChanged);
        }
        a3.a(onDateChangedListener, g2, g3, g4);
        datePicker.init(n5, n3, n2, (DatePicker.OnDateChangedListener)a3);
    }

    private static class a
    implements DatePicker.OnDateChangedListener {
        DatePicker.OnDateChangedListener a;
        g b;
        g c;
        g d;

        private a() {
        }

        public void a(DatePicker.OnDateChangedListener onDateChangedListener, g g2, g g3, g g4) {
            this.a = onDateChangedListener;
            this.b = g2;
            this.c = g3;
            this.d = g4;
        }

        public void onDateChanged(DatePicker datePicker, int n2, int n3, int n4) {
            if (this.a != null) {
                this.a.onDateChanged(datePicker, n2, n3, n4);
            }
            if (this.b != null) {
                this.b.a();
            }
            if (this.c != null) {
                this.c.a();
            }
            if (this.d != null) {
                this.d.a();
            }
        }
    }

}

