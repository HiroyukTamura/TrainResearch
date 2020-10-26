/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package androidx.databinding.a;

import android.widget.CompoundButton;
import androidx.databinding.g;

public class a {
    public static void a(CompoundButton compoundButton, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener, final g g2) {
        if (g2 == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
            return;
        }
        compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            public void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, bl2);
                }
                g2.a();
            }
        });
    }

    public static void a(CompoundButton compoundButton, boolean bl2) {
        if (compoundButton.isChecked() != bl2) {
            compoundButton.setChecked(bl2);
        }
    }

}

