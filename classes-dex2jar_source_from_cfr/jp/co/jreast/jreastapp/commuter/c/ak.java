/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.LinearLayout
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import jp.co.jreast.jreastapp.commuter.commuterpager.d;

public abstract class ak
extends ViewDataBinding {
    public final ViewPager c;
    public final TabLayout d;
    public final ConstraintLayout e;
    public final TabLayout f;
    public final LinearLayout g;
    public final CheckBox h;
    public final Button i;
    protected d j;

    protected ak(e e2, View view, int n2, ViewPager viewPager, TabLayout tabLayout, ConstraintLayout constraintLayout, TabLayout tabLayout2, LinearLayout linearLayout, CheckBox checkBox, Button button) {
        super(e2, view, n2);
        this.c = viewPager;
        this.d = tabLayout;
        this.e = constraintLayout;
        this.f = tabLayout2;
        this.g = linearLayout;
        this.h = checkBox;
        this.i = button;
    }

    public static ak a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ak.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ak a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ak)f.a(layoutInflater, 2131427391, viewGroup, bl2, e2);
    }

    public abstract void a(d var1);
}

