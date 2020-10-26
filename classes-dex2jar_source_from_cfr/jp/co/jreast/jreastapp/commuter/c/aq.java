/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.trainlocation.p;

public abstract class aq
extends ViewDataBinding {
    public final RecyclerView c;
    protected p d;

    protected aq(e e2, View view, int n2, RecyclerView recyclerView) {
        super(e2, view, n2);
        this.c = recyclerView;
    }

    public static aq a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return aq.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static aq a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (aq)f.a(layoutInflater, 2131427395, viewGroup, bl2, e2);
    }

    public abstract void a(p var1);
}

