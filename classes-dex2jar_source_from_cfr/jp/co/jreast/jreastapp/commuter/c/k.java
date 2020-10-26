/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.google.android.material.tabs.TabLayout;
import jp.co.jreast.jreastapp.commuter.main.MainViewPager;

public abstract class k
extends ViewDataBinding {
    public final ConstraintLayout c;
    public final MainViewPager d;
    public final View e;
    public final TabLayout f;

    protected k(e e2, View view, int n2, ConstraintLayout constraintLayout, MainViewPager mainViewPager, View view2, TabLayout tabLayout) {
        super(e2, view, n2);
        this.c = constraintLayout;
        this.d = mainViewPager;
        this.e = view2;
        this.f = tabLayout;
    }
}

