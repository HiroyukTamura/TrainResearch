/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.acknowledgement.AcknowledgementActivity;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.ba;
import jp.co.jreast.jreastapp.commuter.c.de;
import jp.co.jreast.jreastapp.commuter.commuterpager.a;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.j;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.FavoriteRouteEditActivity;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.model.SettingTypes;
import jp.co.jreast.jreastapp.commuter.selectsetting.SelectSettingActivity;
import jp.co.jreast.jreastapp.commuter.webview.WebViewActivity;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\"\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u00020%J\u0006\u00107\u001a\u00020%J\b\u00108\u001a\u00020%H\u0002J\u000e\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020%H\u0002J\u0010\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020BH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006C"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterPagerViewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;", "getCommuterPagerViewModel", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;", "setCommuterPagerViewModel", "(Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "getTranslationRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "setTranslationRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "viewDataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentSettingsBinding;", "getViewDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentSettingsBinding;", "setViewDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentSettingsBinding;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/SettingsViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/SettingsViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/SettingsViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "callBrowser", "", "url", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "openAcknowledgement", "openFavoriteRouteEdit", "openResetSettingsDialog", "openSelectSetting", "settingType", "Ljp/co/jreast/jreastapp/commuter/model/SettingTypes;", "openWebView", "site", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "resetSettings", "setUserVisibleHint", "isVisibleToUser", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class h
extends androidx.f.a.d
implements s {
    public ba a;
    public j b;
    public jp.co.jreast.jreastapp.commuter.commuterpager.d c;
    public w.b d;
    public p e;
    private jp.co.jreast.jreastapp.commuter.f.q f;
    private HashMap g;

    public h() {
        this.f = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    private final void ai() {
        jp.co.jreast.jreastapp.commuter.commuterpager.settings.g g2 = new jp.co.jreast.jreastapp.commuter.commuterpager.settings.g();
        g2.a(new DialogInterface.OnClickListener(){

            public final void onClick(DialogInterface dialogInterface, int n2) {
                this.aj();
            }
        });
        g2.a(this.s(), "resetDialog");
    }

    private final void aj() {
        j j2 = this.b;
        if (j2 == null) {
            kotlin.e.b.j.b("viewModel");
        }
        j2.y();
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        Object object4;
        kotlin.e.b.j.b(object, "inflater");
        object2 = ba.a((LayoutInflater)object, (ViewGroup)object2, false);
        kotlin.e.b.j.a(object2, "FragmentSettingsBinding.\u2026flater, container, false)");
        this.a = object2;
        if (this.k() != null) {
            object2 = this.k();
            object3 = null;
            if ((object2 = object2 != null ? object2.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
                object4 = this.k();
                object2 = object3;
                if (object4 != null) {
                    object2 = object4.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a());
                }
                if (object2 != null) {
                    this.f = (jp.co.jreast.jreastapp.commuter.f.q)object2;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
        }
        object2 = this.f;
        object3 = this.o();
        if (object3 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a(object3, "activity!!");
        object4 = this.d;
        if (object4 == null) {
            kotlin.e.b.j.b("viewModelFactory");
        }
        object2 = ((jp.co.jreast.jreastapp.commuter.f.q)object2).a((androidx.f.a.e)object3, (w.b)object4).a(jp.co.jreast.jreastapp.commuter.commuterpager.d.class);
        kotlin.e.b.j.a(object2, "commuterViewModelProvide\u2026gerViewModel::class.java)");
        this.c = (jp.co.jreast.jreastapp.commuter.commuterpager.d)object2;
        object3 = this.c;
        if (object3 == null) {
            kotlin.e.b.j.b("commuterPagerViewModel");
        }
        object2 = this.f;
        object4 = this.o();
        if (object4 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a(object4, "activity!!");
        Object object5 = this.d;
        if (object5 == null) {
            kotlin.e.b.j.b("viewModelFactory");
        }
        object2 = ((jp.co.jreast.jreastapp.commuter.f.q)object2).a((androidx.f.a.e)object4, (w.b)object5).a(a.a.a.name(), j.class);
        object4 = this.a;
        if (object4 == null) {
            kotlin.e.b.j.b("viewDataBinding");
        }
        ((ba)object4).a((j)object2);
        object4 = this.a;
        if (object4 == null) {
            kotlin.e.b.j.b("viewDataBinding");
        }
        if ((object5 = this.c) == null) {
            kotlin.e.b.j.b("commuterPagerViewModel");
        }
        ((ba)object4).a((jp.co.jreast.jreastapp.commuter.commuterpager.d)object5);
        object4 = this.a;
        if (object4 == null) {
            kotlin.e.b.j.b("viewDataBinding");
        }
        object5 = this;
        ((ViewDataBinding)object4).a((androidx.lifecycle.j)object5);
        ((j)object2).j().a((androidx.lifecycle.j)object5, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    