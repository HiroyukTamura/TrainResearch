/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.transition.Transition
 *  android.transition.TransitionInflater
 *  android.transition.TransitionSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.main;

import android.content.Context;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.f.a.p;
import androidx.lifecycle.x;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import jp.co.jreast.jreastapp.commuter.c.as;
import jp.co.jreast.jreastapp.commuter.common.d;
import jp.co.jreast.jreastapp.commuter.commuterpager.b;
import jp.co.jreast.jreastapp.commuter.main.v;
import jp.co.jreast.jreastapp.commuter.main.w;
import jp.co.jreast.jreastapp.commuter.q.c;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Ljp/co/jreast/jreastapp/commuter/main/RootFragment;", "Landroidx/fragment/app/Fragment;", "()V", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRootBinding;", "type", "", "getType", "()I", "setType", "(I)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/main/RootViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setUserVisibleHint", "isVisibleToUser", "", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class u
extends androidx.f.a.d {
    public static final a a = new a(null);
    private int b;
    private as c;
    private w d;
    private HashMap e;

    public final int a() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        int n2;
        j.b(object, "inflater");
        object = as.a((LayoutInflater)object, (ViewGroup)object2, false);
        j.a(object, "FragmentRootBinding.infl\u2026flater, container, false)");
        this.c = object;
        object = this.k();
        if (object == null) {
            j.a();
        }
        if ((object = object.get("param_position")) == null) {
            throw new t("null cannot be cast to non-null type kotlin.Int");
        }
        this.b = n2 = ((Integer)object).intValue();
        if (n2 == d.a.a()) {
            object = new b();
            ((androidx.f.a.d)object).c((Object)new TransitionSet().addTransition(TransitionInflater.from((Context)this.m()).inflateTransition(2131755010)));
        } else if (n2 == d.b.a()) {
            object = new c();
        } else if (n2 == d.c.a()) {
            object = new jp.co.jreast.jreastapp.commuter.trainlocation.w();
            ((androidx.f.a.d)object).c((Object)new TransitionSet().addTransition(TransitionInflater.from((Context)this.m()).inflateTransition(2131755020)));
        } else {
            object = n2 == 3 ? new b() : new b();
        }
        object = (androidx.f.a.d)object;
        object2 = this.s().a();
        object3 = this.c;
        if (object3 == null) {
            j.b("dataBinding");
        }
        object3 = ((ViewDataBinding)object3).e();
        j.a(object3, "dataBinding.root");
        int n3 = object3.getId();
        object3 = d.values();
        int n4 = ((Object)object3).length;
        int n5 = 0;
        do {
            if (n5 >= n4) {
                throw (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
            }
            Object object4 = object3[n5];
            boolean bl2 = ((d)((Object)object4)).a() == n2;
            if (bl2) {
                ((p)object2).b(n3, (androidx.f.a.d)object, ((Enum)object4).toString()).d();
                object = this.c;
                if (object == null) {
                    j.b("dataBinding");
                }
                return ((ViewDataBinding)object).e();
            }
            ++n5;
        } while (true);
    }

    public void b() {
        if (this.e != null) {
            this.e.clear();
        }
    }

    @Override
    public void d(Bundle object) {
        super.d((Bundle)object);
        object = x.a(this).a(w.class);
        j.a(object, "ViewModelProviders.of(th\u2026ootViewModel::class.java)");
        this.d = (w)object;
    }

    @Override
    public void d(boolean bl2) {
        super.d(bl2);
        if (this.d != null) {
            Object object2;
            block3 : {
                object2 = this.s();
                j.a(object2, "childFragmentManager");
                object2 = ((i)object2).e();
                j.a(object2, "childFragmentManager.fragments");
                for (Object object2 : (Iterable)object2) {
                    if (!((androidx.f.a.d)object2 instanceof v)) continue;
                    break block3;
                }
                object2 = null;
            }
            object2 = (androidx.f.a.d)object2;
            if (object2 != null) {
                ((androidx.f.a.d)object2).d(bl2);
            }
        }
    }

    @Override
    public /* synthetic */ void h() {
        super.h();
        this.b();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/main/RootFragment$Companion;", "", "()V", "PARAM_POSITION", "", "newInstance", "Ljp/co/jreast/jreastapp/commuter/main/RootFragment;", "position", "", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final u a(int n2) {
            u u2 = new u();
            Bundle bundle = new Bundle(1);
            bundle.putInt("param_position", n2);
            u2.g(bundle);
            return u2;
        }
    }

}

