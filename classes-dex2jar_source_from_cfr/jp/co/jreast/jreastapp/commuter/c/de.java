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
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.j;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;

public abstract class de
extends ViewDataBinding {
    public final Button c;
    protected j d;
    protected FavoriteRoute e;

    protected de(e e2, View view, int n2, Button button) {
        super(e2, view, n2);
        this.c = button;
    }

    public static de a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return de.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static de a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (de)f.a(layoutInflater, 2131427453, viewGroup, bl2, e2);
    }

    public abstract void a(j var1);

    public abstract void a(FavoriteRoute var1);
}

