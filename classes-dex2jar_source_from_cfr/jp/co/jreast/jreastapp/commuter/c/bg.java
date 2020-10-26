/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Toolbar
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;

public abstract class bg
extends ViewDataBinding {
    public final TabLayout c;
    public final View d;
    public final Toolbar e;
    public final ViewPager f;
    public final ConstraintLayout g;
    public final TabLayout h;
    protected y i;

    protected bg(e e2, View view, int n2, TabLayout tabLayout, View view2, Toolbar toolbar, ViewPager viewPager, ConstraintLayout constraintLayout, TabLayout tabLayout2) {
        super(e2, view, n2);
        this.c = tabLayout;
        this.d = view2;
        this.e = toolbar;
        this.f = viewPager;
        this.g = constraintLayout;
        this.h = tabLayout2;
    }

    public static bg a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return bg.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static bg a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (bg)f.a(layoutInflater, 2131427403, viewGroup, bl2, e2);
    }

    public abstract void a(y var1);
}

