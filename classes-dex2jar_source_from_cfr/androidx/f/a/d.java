/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.app.Activity
 *  android.content.ComponentCallbacks
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnCreateContextMenuListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 */
package androidx.f.a;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.c.g;
import androidx.f.a.e;
import androidx.f.a.f;
import androidx.f.a.h;
import androidx.f.a.i;
import androidx.f.a.j;
import androidx.f.a.k;
import androidx.f.a.u;
import androidx.lifecycle.g;
import androidx.lifecycle.p;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class d
implements ComponentCallbacks,
View.OnCreateContextMenuListener,
androidx.lifecycle.j,
z {
    private static final g<String, Class<?>> a = new g();
    static final Object j = new Object();
    int A;
    j B;
    h C;
    j D;
    k E;
    y F;
    d G;
    int H;
    int I;
    String J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    boolean P = true;
    boolean Q;
    ViewGroup R;
    View S;
    View T;
    boolean U;
    boolean V = true;
    a W;
    boolean X;
    boolean Y;
    float Z;
    LayoutInflater aa;
    boolean ab;
    androidx.lifecycle.k ac = new androidx.lifecycle.k(this);
    androidx.lifecycle.k ad;
    androidx.lifecycle.j ae;
    p<androidx.lifecycle.j> af = new p();
    int k = 0;
    Bundle l;
    SparseArray<Parcelable> m;
    Boolean n;
    int o = -1;
    String p;
    Bundle q;
    d r;
    int s = -1;
    int t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    private a a() {
        if (this.W == null) {
            this.W = new a();
        }
        return this.W;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d a(Context object, String string2, Bundle object2) {
        try {
            Class<?> class_;
            Class<?> class_2 = class_ = a.get(string2);
            if (class_ == null) {
                class_2 = object.getClassLoader().loadClass(string2);
                a.put(string2, class_2);
            }
            object = (d)class_2.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (object2 != null) {
                object2.setClassLoader(object.getClass().getClassLoader());
                ((d)object).g((Bundle)object2);
            }
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(": calling Fragment constructor caused an exception");
            throw new b(((StringBuilder)object2).toString(), invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(": could not find Fragment constructor");
            throw new b(((StringBuilder)object2).toString(), noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(": make sure class name exists, is public, and has an");
            ((StringBuilder)object2).append(" empty constructor that is public");
            throw new b(((StringBuilder)object2).toString(), illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(": make sure class name exists, is public, and has an");
            ((StringBuilder)object2).append(" empty constructor that is public");
            throw new b(((StringBuilder)object2).toString(), instantiationException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(": make sure class name exists, is public, and has an");
            ((StringBuilder)object2).append(" empty constructor that is public");
            throw new b(((StringBuilder)object2).toString(), classNotFoundException);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static boolean a(Context context, String string2) {
        Class<?> class_;
        try {
            Class<?> class_2;
            class_ = class_2 = a.get(string2);
            if (class_2 != null) return d.class.isAssignableFrom(class_);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
        class_ = context.getClassLoader().loadClass(string2);
        a.put(string2, class_);
        return d.class.isAssignableFrom(class_);
    }

    public void A() {
        this.Q = true;
    }

    public void B() {
        boolean bl2 = true;
        this.Q = true;
        e e2 = this.o();
        if (e2 == null || !e2.isChangingConfigurations()) {
            bl2 = false;
        }
        if (this.F != null && !bl2) {
            this.F.a();
        }
    }

    void C() {
        this.o = -1;
        this.p = null;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.A = 0;
        this.B = null;
        this.D = null;
        this.C = null;
        this.H = 0;
        this.I = 0;
        this.J = null;
        this.K = false;
        this.L = false;
        this.N = false;
    }

    public void D() {
    }

    public Object E() {
        if (this.W == null) {
            return null;
        }
        return this.W.g;
    }

    public Object F() {
        if (this.W == null) {
            return null;
        }
        if (this.W.h == j) {
            return this.E();
        }
        return this.W.h;
    }

    public Object G() {
        if (this.W == null) {
            return null;
        }
        return this.W.i;
    }

    public Object H() {
        if (this.W == null) {
            return null;
        }
        if (this.W.j == j) {
            return this.G();
        }
        return this.W.j;
    }

    public Object I() {
        if (this.W == null) {
            return null;
        }
        return this.W.k;
    }

    public Object J() {
        if (this.W == null) {
            return null;
        }
        if (this.W.l == j) {
            return this.I();
        }
        return this.W.l;
    }

    public boolean K() {
        if (this.W != null && this.W.n != null) {
            return this.W.n;
        }
        return true;
    }

    public boolean L() {
        if (this.W != null && this.W.m != null) {
            return this.W.m;
        }
        return true;
    }

    public void M() {
        if (this.B != null && this.B.m != null) {
            if (Looper.myLooper() != this.B.m.h().getLooper()) {
                this.B.m.h().postAtFrontOfQueue(new Runnable(){

                    @Override
                    public void run() {
                        d.this.N();
                    }
                });
                return;
            }
            this.N();
            return;
        }
        this.a().q = false;
    }

    void N() {
        c c2;
        if (this.W == null) {
            c2 = null;
        } else {
            this.W.q = false;
            c2 = this.W.r;
            this.W.r = null;
        }
        if (c2 != null) {
            c2.a();
        }
    }

    void O() {
        if (this.C != null) {
            this.D = new j();
            this.D.a(this.C, new f(){

                @Override
                public View a(int n2) {
                    if (d.this.S != null) {
                        return d.this.S.findViewById(n2);
                    }
                    throw new IllegalStateException("Fragment does not have a view");
                }

                @Override
                public d a(Context context, String string2, Bundle bundle) {
                    return d.this.C.a(context, string2, bundle);
                }

                @Override
                public boolean a() {
                    return d.this.S != null;
                }
            }, this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    void P() {
        if (this.D != null) {
            this.D.o();
            this.D.i();
        }
        this.k = 3;
        this.Q = false;
        this.e();
        if (this.Q) {
            if (this.D != null) {
                this.D.r();
            }
            this.ac.a(g.a.ON_START);
            if (this.S != null) {
                this.ad.a(g.a.ON_START);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onStart()");
        throw new u(stringBuilder.toString());
    }

    void Q() {
        if (this.D != null) {
            this.D.o();
            this.D.i();
        }
        this.k = 4;
        this.Q = false;
        this.z();
        if (this.Q) {
            if (this.D != null) {
                this.D.s();
                this.D.i();
            }
            this.ac.a(g.a.ON_RESUME);
            if (this.S != null) {
                this.ad.a(g.a.ON_RESUME);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onResume()");
        throw new u(stringBuilder.toString());
    }

    void R() {
        if (this.D != null) {
            this.D.o();
        }
    }

    void S() {
        this.onLowMemory();
        if (this.D != null) {
            this.D.x();
        }
    }

    void T() {
        if (this.S != null) {
            this.ad.a(g.a.ON_PAUSE);
        }
        this.ac.a(g.a.ON_PAUSE);
        if (this.D != null) {
            this.D.t();
        }
        this.k = 3;
        this.Q = false;
        this.A();
        if (this.Q) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onPause()");
        throw new u(stringBuilder.toString());
    }

    void U() {
        if (this.S != null) {
            this.ad.a(g.a.ON_STOP);
        }
        this.ac.a(g.a.ON_STOP);
        if (this.D != null) {
            this.D.u();
        }
        this.k = 2;
        this.Q = false;
        this.f();
        if (this.Q) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onStop()");
        throw new u(stringBuilder.toString());
    }

    void V() {
        if (this.S != null) {
            this.ad.a(g.a.ON_DESTROY);
        }
        if (this.D != null) {
            this.D.v();
        }
        this.k = 1;
        this.Q = false;
        this.h();
        if (this.Q) {
            androidx.h.a.a.a(this).a();
            this.z = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroyView()");
        throw new u(stringBuilder.toString());
    }

    void W() {
        this.ac.a(g.a.ON_DESTROY);
        if (this.D != null) {
            this.D.w();
        }
        this.k = 0;
        this.Q = false;
        this.ab = false;
        this.B();
        if (this.Q) {
            this.D = null;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroy()");
        throw new u(stringBuilder.toString());
    }

    void X() {
        this.Q = false;
        this.d();
        this.aa = null;
        if (this.Q) {
            if (this.D != null) {
                if (this.N) {
                    this.D.w();
                    this.D = null;
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Child FragmentManager of ");
                stringBuilder.append(this);
                stringBuilder.append(" was not ");
                stringBuilder.append(" destroyed and this fragment is not retaining instance");
                throw new IllegalStateException(stringBuilder.toString());
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDetach()");
        throw new u(stringBuilder.toString());
    }

    int Y() {
        if (this.W == null) {
            return 0;
        }
        return this.W.d;
    }

    int Z() {
        if (this.W == null) {
            return 0;
        }
        return this.W.e;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int n2, boolean bl2, int n3) {
        return null;
    }

    void a(int n2) {
        if (this.W == null && n2 == 0) {
            return;
        }
        this.a().d = n2;
    }

    void a(int n2, int n3) {
        if (this.W == null && n2 == 0 && n3 == 0) {
            return;
        }
        this.a();
        this.W.e = n2;
        this.W.f = n3;
    }

    public void a(int n2, int n3, Intent intent) {
    }

    /*
     * Enabled aggressive block sorting
     */
    final void a(int n2, d object) {
        String string2;
        this.o = n2;
        if (object != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((d)object).p);
            string2 = ":";
            object = stringBuilder;
        } else {
            object = new StringBuilder();
            string2 = "android:fragment:";
        }
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(this.o);
        this.p = ((StringBuilder)object).toString();
    }

    public void a(int n2, String[] arrstring, int[] arrn) {
    }

    void a(Animator animator) {
        this.a().b = animator;
    }

    @Deprecated
    public void a(Activity activity) {
        this.Q = true;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.Q = true;
    }

    public void a(Context object) {
        this.Q = true;
        object = this.C == null ? null : this.C.f();
        if (object != null) {
            this.Q = false;
            this.a((Activity)object);
        }
    }

    public void a(Context object, AttributeSet attributeSet, Bundle bundle) {
        this.Q = true;
        object = this.C == null ? null : this.C.f();
        if (object != null) {
            this.Q = false;
            this.a((Activity)object, attributeSet, bundle);
        }
    }

    public void a(Intent intent) {
        this.a(intent, null);
    }

    public void a(Intent intent, int n2) {
        this.a(intent, n2, null);
    }

    public void a(Intent object, int n2, Bundle bundle) {
        if (this.C != null) {
            this.C.a(this, (Intent)object, n2, bundle);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to Activity");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public void a(Intent object, Bundle bundle) {
        if (this.C != null) {
            this.C.a(this, (Intent)object, -1, bundle);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to Activity");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    void a(Configuration configuration) {
        this.onConfigurationChanged(configuration);
        if (this.D != null) {
            this.D.a(configuration);
        }
    }

    public void a(Bundle bundle) {
        this.Q = true;
        this.j(bundle);
        if (this.D != null && !this.D.b(1)) {
            this.D.p();
        }
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    void a(View view) {
        this.a().a = view;
    }

    public void a(View view, Bundle bundle) {
    }

    void a(c object) {
        this.a();
        if (object == this.W.r) {
            return;
        }
        if (object != null && this.W.r != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Trying to set a replacement startPostponedEnterTransition on ");
            ((StringBuilder)object).append(this);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        if (this.W.q) {
            this.W.r = object;
        }
        if (object != null) {
            object.b();
        }
    }

    public void a(d d2) {
        if (this.o < 0) {
            d2 = d2 != null && d2.a != null ? d2.a : null;
            this.l = d2;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    public void a(d d2) {
    }

    public void a(Object object) {
        this.a().g = object;
    }

    public void a(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.print(string2);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.H));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.I));
        printWriter.print(" mTag=");
        printWriter.println(this.J);
        printWriter.print(string2);
        printWriter.print("mState=");
        printWriter.print(this.k);
        printWriter.print(" mIndex=");
        printWriter.print(this.o);
        printWriter.print(" mWho=");
        printWriter.print(this.p);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.A);
        printWriter.print(string2);
        printWriter.print("mAdded=");
        printWriter.print(this.u);
        printWriter.print(" mRemoving=");
        printWriter.print(this.v);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.w);
        printWriter.print(" mInLayout=");
        printWriter.println(this.x);
        printWriter.print(string2);
        printWriter.print("mHidden=");
        printWriter.print(this.K);
        printWriter.print(" mDetached=");
        printWriter.print(this.L);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.P);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.O);
        printWriter.print(string2);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.M);
        printWriter.print(" mRetaining=");
        printWriter.print(this.N);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.V);
        if (this.B != null) {
            printWriter.print(string2);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.B);
        }
        if (this.C != null) {
            printWriter.print(string2);
            printWriter.print("mHost=");
            printWriter.println(this.C);
        }
        if (this.G != null) {
            printWriter.print(string2);
            printWriter.print("mParentFragment=");
            printWriter.println(this.G);
        }
        if (this.q != null) {
            printWriter.print(string2);
            printWriter.print("mArguments=");
            printWriter.println((Object)this.q);
        }
        if (this.l != null) {
            printWriter.print(string2);
            printWriter.print("mSavedFragmentState=");
            printWriter.println((Object)this.l);
        }
        if (this.m != null) {
            printWriter.print(string2);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.m);
        }
        if (this.r != null) {
            printWriter.print(string2);
            printWriter.print("mTarget=");
            printWriter.print(this.r);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.t);
        }
        if (this.Y() != 0) {
            printWriter.print(string2);
            printWriter.print("mNextAnim=");
            printWriter.println(this.Y());
        }
        if (this.R != null) {
            printWriter.print(string2);
            printWriter.print("mContainer=");
            printWriter.println((Object)this.R);
        }
        if (this.S != null) {
            printWriter.print(string2);
            printWriter.print("mView=");
            printWriter.println((Object)this.S);
        }
        if (this.T != null) {
            printWriter.print(string2);
            printWriter.print("mInnerView=");
            printWriter.println((Object)this.S);
        }
        if (this.ad() != null) {
            printWriter.print(string2);
            printWriter.print("mAnimatingAway=");
            printWriter.println((Object)this.ad());
            printWriter.print(string2);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.af());
        }
        if (this.m() != null) {
            androidx.h.a.a.a(this).a(string2, fileDescriptor, printWriter, arrstring);
        }
        if (this.D != null) {
            printWriter.print(string2);
            Object object = new StringBuilder();
            ((StringBuilder)object).append("Child ");
            ((StringBuilder)object).append(this.D);
            ((StringBuilder)object).append(":");
            printWriter.println(((StringBuilder)object).toString());
            object = this.D;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("  ");
            ((j)object).a(stringBuilder.toString(), fileDescriptor, printWriter, arrstring);
        }
    }

    public final void a(String[] object, int n2) {
        if (this.C != null) {
            this.C.a(this, (String[])object, n2);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to Activity");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public boolean a(String string2) {
        if (this.C != null) {
            return this.C.a(string2);
        }
        return false;
    }

    int aa() {
        if (this.W == null) {
            return 0;
        }
        return this.W.f;
    }

    androidx.core.app.f ab() {
        if (this.W == null) {
            return null;
        }
        return this.W.o;
    }

    androidx.core.app.f ac() {
        if (this.W == null) {
            return null;
        }
        return this.W.p;
    }

    View ad() {
        if (this.W == null) {
            return null;
        }
        return this.W.a;
    }

    Animator ae() {
        if (this.W == null) {
            return null;
        }
        return this.W.b;
    }

    int af() {
        if (this.W == null) {
            return 0;
        }
        return this.W.c;
    }

    boolean ag() {
        if (this.W == null) {
            return false;
        }
        return this.W.q;
    }

    boolean ah() {
        if (this.W == null) {
            return false;
        }
        return this.W.s;
    }

    public Animator b(int n2, boolean bl2, int n3) {
        return null;
    }

    public LayoutInflater b(Bundle bundle) {
        return this.i(bundle);
    }

    d b(String string2) {
        if (string2.equals(this.p)) {
            return this;
        }
        if (this.D != null) {
            return this.D.b(string2);
        }
        return null;
    }

    void b(int n2) {
        this.a().c = n2;
    }

    void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.D != null) {
            this.D.o();
        }
        this.z = true;
        this.ae = new androidx.lifecycle.j(){

            @Override
            public androidx.lifecycle.g g() {
                if (d.this.ad == null) {
                    d.this.ad = new androidx.lifecycle.k(d.this.ae);
                }
                return d.this.ad;
            }
        };
        this.ad = null;
        this.S = this.a(layoutInflater, viewGroup, bundle);
        if (this.S != null) {
            this.ae.g();
            this.af.b(this.ae);
            return;
        }
        if (this.ad == null) {
            this.ae = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void b(Menu menu) {
    }

    public void b(Object object) {
        this.a().h = object;
    }

    public void b(boolean bl2) {
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean bl2 = this.K;
        boolean bl3 = false;
        boolean bl4 = false;
        if (!bl2) {
            bl2 = bl4;
            if (this.O) {
                bl2 = bl4;
                if (this.P) {
                    bl2 = true;
                    this.a(menu, menuInflater);
                }
            }
            bl3 = bl2;
            if (this.D != null) {
                bl3 = bl2 | this.D.a(menu, menuInflater);
            }
        }
        return bl3;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void c(Object object) {
        this.a().j = object;
    }

    public void c(boolean bl2) {
        if (this.P != bl2) {
            this.P = bl2;
            if (this.O && this.v() && !this.w()) {
                this.C.c();
            }
        }
    }

    boolean c(Menu menu) {
        boolean bl2 = this.K;
        boolean bl3 = false;
        boolean bl4 = false;
        if (!bl2) {
            bl2 = bl4;
            if (this.O) {
                bl2 = bl4;
                if (this.P) {
                    bl2 = true;
                    this.a(menu);
                }
            }
            bl3 = bl2;
            if (this.D != null) {
                bl3 = bl2 | this.D.a(menu);
            }
        }
        return bl3;
    }

    boolean c(MenuItem menuItem) {
        if (!this.K) {
            if (this.O && this.P && this.a(menuItem)) {
                return true;
            }
            if (this.D != null && this.D.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        this.Q = true;
    }

    public void d(Bundle bundle) {
        this.Q = true;
    }

    void d(Menu menu) {
        if (!this.K) {
            if (this.O && this.P) {
                this.b(menu);
            }
            if (this.D != null) {
                this.D.b(menu);
            }
        }
    }

    public void d(boolean bl2) {
        if (!this.V && bl2 && this.k < 3 && this.B != null && this.v() && this.ab) {
            this.B.b(this);
        }
        this.V = bl2;
        boolean bl3 = this.k < 3 && !bl2;
        this.U = bl3;
        if (this.l != null) {
            this.n = bl2;
        }
    }

    boolean d(MenuItem menuItem) {
        if (!this.K) {
            if (this.b(menuItem)) {
                return true;
            }
            if (this.D != null && this.D.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e() {
        this.Q = true;
    }

    public void e(Bundle bundle) {
    }

    public void e(boolean bl2) {
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    public void f() {
        this.Q = true;
    }

    final void f(Bundle object) {
        if (this.m != null) {
            this.T.restoreHierarchyState(this.m);
            this.m = null;
        }
        this.Q = false;
        this.k((Bundle)object);
        if (this.Q) {
            if (this.S != null) {
                this.ad.a(g.a.ON_CREATE);
            }
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onViewStateRestored()");
        throw new u(((StringBuilder)object).toString());
    }

    public void f(boolean bl2) {
    }

    @Override
    public androidx.lifecycle.g g() {
        return this.ac;
    }

    public void g(Bundle bundle) {
        if (this.o >= 0 && this.l()) {
            throw new IllegalStateException("Fragment already active and state has been saved");
        }
        this.q = bundle;
    }

    void g(boolean bl2) {
        this.e(bl2);
        if (this.D != null) {
            this.D.a(bl2);
        }
    }

    LayoutInflater h(Bundle bundle) {
        this.aa = this.b(bundle);
        return this.aa;
    }

    public void h() {
        this.Q = true;
    }

    void h(boolean bl2) {
        this.f(bl2);
        if (this.D != null) {
            this.D.b(bl2);
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Deprecated
    public LayoutInflater i(Bundle bundle) {
        if (this.C != null) {
            bundle = this.C.b();
            this.s();
            androidx.core.h.f.a((LayoutInflater)bundle, this.D.z());
            return bundle;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Override
    public y i() {
        if (this.m() != null) {
            if (this.F == null) {
                this.F = new y();
            }
            return this.F;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    void i(boolean bl2) {
        this.a().s = bl2;
    }

    void j(Bundle bundle) {
        if (bundle != null && (bundle = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.D == null) {
                this.O();
            }
            this.D.a((Parcelable)bundle, this.E);
            this.E = null;
            this.D.p();
        }
    }

    final boolean j() {
        return this.A > 0;
    }

    public final Bundle k() {
        return this.q;
    }

    public void k(Bundle bundle) {
        this.Q = true;
    }

    void l(Bundle object) {
        if (this.D != null) {
            this.D.o();
        }
        this.k = 1;
        this.Q = false;
        this.a((Bundle)object);
        this.ab = true;
        if (this.Q) {
            this.ac.a(g.a.ON_CREATE);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onCreate()");
        throw new u(((StringBuilder)object).toString());
    }

    public final boolean l() {
        if (this.B == null) {
            return false;
        }
        return this.B.f();
    }

    public Context m() {
        if (this.C == null) {
            return null;
        }
        return this.C.g();
    }

    void m(Bundle object) {
        if (this.D != null) {
            this.D.o();
        }
        this.k = 2;
        this.Q = false;
        this.d((Bundle)object);
        if (this.Q) {
            if (this.D != null) {
                this.D.q();
            }
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onActivityCreated()");
        throw new u(((StringBuilder)object).toString());
    }

    public final Context n() {
        Object object = this.m();
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to a context.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    void n(Bundle bundle) {
        Parcelable parcelable;
        this.e(bundle);
        if (this.D != null && (parcelable = this.D.n()) != null) {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
    }

    public final e o() {
        if (this.C == null) {
            return null;
        }
        return (e)this.C.f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.Q = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.o().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.Q = true;
    }

    public final e p() {
        Object object = this.o();
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to an activity.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public final Resources q() {
        return this.n().getResources();
    }

    public final i r() {
        return this.B;
    }

    public final i s() {
        if (this.D == null) {
            this.O();
            if (this.k >= 4) {
                this.D.s();
            } else if (this.k >= 3) {
                this.D.r();
            } else if (this.k >= 2) {
                this.D.q();
            } else if (this.k >= 1) {
                this.D.p();
            }
        }
        return this.D;
    }

    i t() {
        return this.D;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        androidx.core.g.a.a(this, stringBuilder);
        if (this.o >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.o);
        }
        if (this.H != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.H));
        }
        if (this.J != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.J);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final d u() {
        return this.G;
    }

    public final boolean v() {
        return this.C != null && this.u;
    }

    public final boolean w() {
        return this.K;
    }

    public boolean x() {
        return this.V;
    }

    public View y() {
        return this.S;
    }

    public void z() {
        this.Q = true;
    }

    static class a {
        View a;
        Animator b;
        int c;
        int d;
        int e;
        int f;
        Object g = null;
        Object h = d.j;
        Object i = null;
        Object j = d.j;
        Object k = null;
        Object l = d.j;
        Boolean m;
        Boolean n;
        androidx.core.app.f o = null;
        androidx.core.app.f p = null;
        boolean q;
        c r;
        boolean s;

        a() {
        }
    }

    public static class b
    extends RuntimeException {
        public b(String string2, Exception exception) {
            super(string2, exception);
        }
    }

    static interface c {
        public void a();

        public void b();
    }

    public static class d
    implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>(){

            public d a(Parcel parcel) {
                return new d(parcel, null);
            }

            public d a(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            public d[] a(int n2) {
                return new d[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return this.a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        final Bundle a;

        d(Bundle bundle) {
            this.a = bundle;
        }

        d(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle();
            if (classLoader != null && this.a != null) {
                this.a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeBundle(this.a);
        }

    }

}

