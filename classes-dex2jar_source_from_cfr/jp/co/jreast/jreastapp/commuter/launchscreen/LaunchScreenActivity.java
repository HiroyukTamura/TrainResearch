/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.KeyEvent
 */
package jp.co.jreast.jreastapp.commuter.launchscreen;

import a.a.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import androidx.appcompat.app.c;
import androidx.f.a.d;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.launchscreen.b;
import jp.co.jreast.jreastapp.commuter.main.MainActivity;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2={"Ljp/co/jreast/jreastapp/commuter/launchscreen/LaunchScreenActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ldagger/android/support/HasSupportFragmentInjector;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "splashTime", "", "viewModel", "Ljp/co/jreast/jreastapp/commuter/launchscreen/LaunchScreenViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class LaunchScreenActivity
extends c
implements a.a.a.d,
androidx.lifecycle.j {
    public e<d> k;
    public w.b l;
    private final long m = 700L;
    private q n = new q();
    private b o;

    public /* synthetic */ a.a.b c_() {
        return this.l();
    }

    public e<d> l() {
        e<d> e2 = this.k;
        if (e2 == null) {
            j.b("androidInjector");
        }
        return e2;
    }

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object != null) {
                this.n = (q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object = this.n;
        androidx.f.a.e e2 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object = ((q)object).a(e2, b2).a(b.class);
        j.a(object, "commuterViewModelProvide\u2026eenViewModel::class.java)");
        this.o = (b)object;
        object = this.getIntent();
        j.a(object, "intent");
        if ((object.getFlags() & 4194304) != 0) {
            this.finish();
            return;
        }
        object = this.o;
        if (object == null) {
            j.b("viewModel");
        }
        ((b)object).b();
        new Handler().postDelayed(new Runnable(){

            @Override
            public final void run() {
                Intent intent = new Intent((Context)this, MainActivity.class);
                this.startActivity(intent);
            }
        }, this.m);
        object = this.o;
        if (object == null) {
            j.b("viewModel");
        }
        ((b)object).c();
    }

    @Override
    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        j.b((Object)keyEvent, "event");
        if (n2 == 4) {
            return false;
        }
        return super.onKeyDown(n2, keyEvent);
    }

}

