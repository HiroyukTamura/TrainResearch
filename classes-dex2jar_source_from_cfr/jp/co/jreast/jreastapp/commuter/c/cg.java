/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatusItem;

public abstract class cg
extends ViewDataBinding {
    public final TextView c;
    protected LineServiceStatusItem d;

    protected cg(e e2, View view, int n2, TextView textView) {
        super(e2, view, n2);
        this.c = textView;
    }

    public static cg a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return cg.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static cg a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (cg)f.a(layoutInflater, 2131427418, viewGroup, bl2, e2);
    }

    public abstract void a(LineServiceStatusItem var1);
}

