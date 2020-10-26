/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.push.c;

public abstract class o
extends ViewDataBinding {
    public final Button c;
    public final TextView d;
    public final Button e;
    public final FrameLayout f;
    public final TextView g;
    protected c h;

    protected o(e e2, View view, int n2, Button button, TextView textView, Button button2, FrameLayout frameLayout, TextView textView2) {
        super(e2, view, n2);
        this.c = button;
        this.d = textView;
        this.e = button2;
        this.f = frameLayout;
        this.g = textView2;
    }

    public abstract void a(c var1);
}

