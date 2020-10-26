/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.commuterpager.d;

public abstract class bk
extends ViewDataBinding {
    public final Button c;
    public final RecyclerView d;
    protected d e;

    protected bk(e e2, View view, int n2, Button button, RecyclerView recyclerView) {
        super(e2, view, n2);
        this.c = button;
        this.d = recyclerView;
    }

    public static bk a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return bk.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static bk a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (bk)f.a(layoutInflater, 2131427405, viewGroup, bl2, e2);
    }

    public abstract void a(d var1);
}

