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
import jp.co.jreast.jreastapp.commuter.model.Settings;
import jp.co.jreast.jreastapp.commuter.selectsetting.d;

public abstract class dg
extends ViewDataBinding {
    protected d c;
    protected Settings d;
    protected boolean e;

    protected dg(e e2, View view, int n2) {
        super(e2, view, n2);
    }

    public static dg a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return dg.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static dg a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (dg)f.a(layoutInflater, 2131427454, viewGroup, bl2, e2);
    }

    public abstract void a(Settings var1);

    public abstract void a(d var1);

    public abstract void a(boolean var1);
}

