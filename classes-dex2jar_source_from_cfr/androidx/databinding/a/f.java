/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.widget.TimePicker
 *  android.widget.TimePicker$OnTimeChangedListener
 */
package androidx.databinding.a;

import android.widget.TimePicker;
import androidx.databinding.g;

public class f {
    public static void a(TimePicker timePicker, final TimePicker.OnTimeChangedListener onTimeChangedListener, final g g2, final g g3) {
        if (g2 == null && g3 == null) {
            timePicker.setOnTimeChangedListener(onTimeChangedListener);
            return;
        }
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){

            public void onTimeChanged(TimePicker timePicker, int n2, int n3) {
                if (onTimeChangedListener != null) {
                    onTimeChangedListener.onTimeChanged(timePicker, n2, n3);
                }
                if (g2 != null) {
                    g2.a();
                }
                if (g3 != null) {
                    g3.a();
                }
            }
        });
    }

}

