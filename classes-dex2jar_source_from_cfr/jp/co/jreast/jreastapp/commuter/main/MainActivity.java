/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.LinearLayout
 */
package jp.co.jreast.jreastapp.commuter.main;

import a.a.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.f.a.i;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import jp.co.jreast.jreastapp.commuter.c.bm;
import jp.co.jreast.jreastapp.commuter.c.k;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.main.MainViewPager;
import jp.co.jreast.jreastapp.commuter.main.r;
import jp.co.jreast.jreastapp.commuter.main.s;
import jp.co.jreast.jreastapp.commuter.main.u;
import jp.co.jreast.jreastapp.commuter.webview.g;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

@Metadata(bv={1, 0, 2}, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u001fH\u0016J\u0012\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u00101\u001a\u00020\u001fJ\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u00063"}, d2={"Ljp/co/jreast/jreastapp/commuter/main/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/lifecycle/LifecycleOwner;", "Ldagger/android/support/HasSupportFragmentInjector;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "animFlashFadein", "Landroid/view/animation/Animation;", "animFlashFadeout", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityMainBinding;", "listenerFlashFadein", "Landroid/view/animation/Animation$AnimationListener;", "listenerFlashFadeout", "viewModel", "Ljp/co/jreast/jreastapp/commuter/main/MainViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "backToTopFragment", "fragment", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reselectedTab", "setFlash", "setTabEnabled", "enabled", "", "setupBottomTabLayout", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "showInitPage", "startFlashAnimation", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class MainActivity
extends androidx.appcompat.app.c
implements a.a.a.d,
androidx.lifecycle.j {
    public e<androidx.f.a.d> k;
    public w.b l;
    private s m;
    private q n = new q();
    private k o;
    private Animation.AnimationListener p;
    private Animation.AnimationListener q;
    private Animation r;
    private Animation s;

    public static final /* synthetic */ k a(MainActivity object) {
        object = ((MainActivity)object).o;
        if (object == null) {
            j.b("dataBinding");
        }
        return object;
    }

    private final void a(TabLayout tabLayout) {
        Object object = (Context)this;
        Object object2 = LayoutInflater.from((Context)object);
        Object object3 = (ViewGroup)new LinearLayout((Context)object);
        Object object4 = (bm)f.a((LayoutInflater)object2, 2131427406, (ViewGroup)object3, false);
        object = (bm)f.a((LayoutInflater)object2, 2131427406, (ViewGroup)object3, false);
        object2 = (bm)f.a((LayoutInflater)object2, 2131427406, (ViewGroup)object3, false);
        ((bm)object4).c.setImageResource(2131165720);
        ((bm)object4).e.setText(2131558450);
        object3 = tabLayout.a(0);
        if (object3 == null) {
            j.a();
        }
        j.a(object3, "tabLayout.getTabAt(0)!!");
        j.a(object4, "tabDataBinding");
        ((TabLayout.f)object3).a(((ViewDataBinding)object4).e());
        ((bm)object).c.setImageResource(2131165718);
        ((bm)object).e.setText(2131558451);
        object4 = tabLayout.a(1);
        if (object4 == null) {
            j.a();
        }
        j.a(object4, "tabLayout.getTabAt(1)!!");
        j.a(object, "tabDataBinding2");
        ((TabLayout.f)object4).a(((ViewDataBinding)object).e());
        ((bm)object2).c.setImageResource(2131165719);
        ((bm)object2).e.setText(2131558452);
        object = tabLayout.a(2);
        if (object == null) {
            j.a();
        }
        j.a(object, "tabLayout.getTabAt(2)!!");
        j.a(object2, "tabDataBinding3");
        ((TabLayout.f)object).a(((ViewDataBinding)object2).e());
        tabLayout.a(new TabLayout.c(){

            public void a(TabLayout.f object) {
                j.b(object, "tab");
                object = MainActivity.c(this);
                TabLayout tabLayout = MainActivity.a((MainActivity)this).f;
                j.a((Object)tabLayout, "dataBinding.tabs");
                ((s)object).a(tabLayout.getSelectedTabPosition());
            }

            public void b(TabLayout.f f2) {
                j.b(f2, "tab");
            }

            public void c(TabLayout.f object) {
                j.b(object, "tab");
                this.o();
                object = MainActivity.c(this);
                TabLayout tabLayout = MainActivity.a((MainActivity)this).f;
                j.a((Object)tabLayout, "dataBinding.tabs");
                ((s)object).a(tabLayout.getSelectedTabPosition());
            }
        });
    }

    public static final /* synthetic */ Animation b(MainActivity mainActivity) {
        mainActivity = mainActivity.s;
        if (mainActivity == null) {
            j.b("animFlashFadeout");
        }
        return mainActivity;
    }

    private final void b(androidx.f.a.d object) {
        object = ((androidx.f.a.d)object).s();
        j.a(object, "fragmentManager");
        if (((i)object).d() > 0) {
            i.a a2 = ((i)object).a(0);
            j.a((Object)a2, "entry");
            ((i)object).b(a2.a(), 1);
        }
    }

    private final void b(TabLayout object) {
        if (object.getSelectedTabPosition() == 0) {
            object = (TabLayout)((Object)this.findViewById(2131230821));
            if (object != null) {
                if ((object = object.a(1)) == null) {
                    j.a();
                }
                ((TabLayout.f)object).e();
                return;
            }
        } else {
            if (object.getSelectedTabPosition() == 1) {
                object = this.m;
                if (object == null) {
                    j.b("viewModel");
                }
                ((s)object).c();
                return;
            }
            if (object.getSelectedTabPosition() == 2 && (object = (TabLayout)((Object)this.findViewById(2131231283))) != null) {
                object = object.a(0);
                new Handler().post(new Runnable((TabLayout.f)object){
                    final /* synthetic */ TabLayout.f a;
                    {
                        this.a = f2;
                    }

                    @Override
                    public final void run() {
                        TabLayout.f f2 = this.a;
                        if (f2 == null) {
                            j.a();
                        }
                        f2.e();
                    }
                });
            }
        }
    }

    public static final /* synthetic */ s c(MainActivity object) {
        object = ((MainActivity)object).m;
        if (object == null) {
            j.b("viewModel");
        }
        return object;
    }

    private final void n() {
        this.p = new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                MainActivity.a((MainActivity)this).e.clearAnimation();
                MainActivity.a((MainActivity)this).e.startAnimation(MainActivity.b(this));
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                animation = MainActivity.a((MainActivity)this).e;
                j.a((Object)animation, "dataBinding.screenCaptureFlashing");
                animation.setVisibility(0);
            }
        };
        this.q = new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                MainActivity.a((MainActivity)this).e.clearAnimation();
                animation = MainActivity.a((MainActivity)this).e;
                j.a((Object)animation, "dataBinding.screenCaptureFlashing");
                animation.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        Context context = (Context)this;
        Animation animation = AnimationUtils.loadAnimation((Context)context, (int)2130771986);
        animation.setDuration(100L);
        MainActivity mainActivity = this;
        if (mainActivity.p != null) {
            Animation.AnimationListener animationListener = this.p;
            if (animationListener == null) {
                j.b("listenerFlashFadein");
            }
            animation.setAnimationListener(animationListener);
        }
        j.a((Object)animation, "AnimationUtils.loadAnima\u2026)\n            }\n        }");
        this.r = animation;
        context = AnimationUtils.loadAnimation((Context)context, (int)2130771988);
        context.setDuration(300L);
        context.setInterpolator((Interpolator)new DecelerateInterpolator());
        if (mainActivity.q != null) {
            mainActivity = this.q;
            if (mainActivity == null) {
                j.b("listenerFlashFadeout");
            }
            context.setAnimationListener((Animation.AnimationListener)mainActivity);
        }
        j.a((Object)context, "AnimationUtils.loadAnima\u2026)\n            }\n        }");
        this.s = context;
    }

    private final void o() {
        Object object = this.k();
        j.a(object, "supportFragmentManager");
        Object object2 = ((i)object).e();
        object = this.o;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((k)object).f;
        j.a(object2, "fragments");
        Object object32 = (Iterable)object2;
        object2 = new ArrayList();
        object32 = object32.iterator();
        while (object32.hasNext()) {
            Object e2 = object32.next();
            if (!((androidx.f.a.d)e2 instanceof u)) continue;
            object2.add(e2);
        }
        for (Object object32 : (Iterable)object2) {
            if (object32 != null) {
                int n2 = ((u)object32).a();
                j.a(object, "tabLayout");
                if ((n2 = n2 == ((TabLayout)((Object)object)).getSelectedTabPosition() ? 1 : 0) == 0) continue;
                j.a(object32, "fragment");
                this.b((androidx.f.a.d)object32);
                this.b((TabLayout)((Object)object));
                return;
            }
            throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.main.RootFragment");
        }
        throw (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final void a(boolean bl2) {
        Object object = this.o;
        if (object == null) {
            j.b("dataBinding");
        }
        object = object.f;
        if ((object = object.getChildAt(0)) != null) {
            object = (LinearLayout)object;
            object.setEnabled(bl2);
            int n2 = object.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view = object.getChildAt(i2);
                j.a((Object)view, "tabStrip.getChildAt(i)");
                view.setClickable(bl2);
            }
            return;
        }
        throw new t("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext((Context)CalligraphyContextWrapper.wrap(context));
    }

    public /* synthetic */ a.a.b c_() {
        return this.l();
    }

    public e<androidx.f.a.d> l() {
        e<androidx.f.a.d> e2 = this.k;
        if (e2 == null) {
            j.b("androidInjector");
        }
        return e2;
    }

    public final void m() {
        k k2 = this.o;
        if (k2 == null) {
            j.b("dataBinding");
        }
        k2 = k2.e;
        Animation animation = this.r;
        if (animation == null) {
            j.b("animFlashFadein");
        }
        k2.startAnimation(animation);
    }

    @Override
    public void onBackPressed() {
        Object object4 = this.k();
        j.a(object4, "supportFragmentManager");
        Object object2 = ((i)object4).e();
        object4 = this.o;
        if (object4 == null) {
            j.b("dataBinding");
        }
        object4 = ((k)object4).f;
        j.a(object2, "fragments");
        Object object3 = (Iterable)object2;
        object2 = new ArrayList();
        object3 = object3.iterator();
        while (object3.hasNext()) {
            Object e2 = object3.next();
            if (!((androidx.f.a.d)e2 instanceof u)) continue;
            object2.add(e2);
        }
        object2 = ((Iterable)object2).iterator();
        while (object2.hasNext()) {
            object3 = (androidx.f.a.d)object2.next();
            if (object3 != null) {
                block7 : {
                    int n2 = ((u)object3).a();
                    j.a(object4, "tabLayout");
                    if ((n2 = n2 == ((TabLayout)((Object)object4)).getSelectedTabPosition() ? 1 : 0) == 0) continue;
                    j.a(object3, "fragment");
                    object2 = ((androidx.f.a.d)object3).s();
                    j.a(object2, "fragmentManager");
                    object4 = ((i)object2).e();
                    j.a(object4, "fragmentManager.fragments");
                    for (Object object4 : (Iterable)object4) {
                        if (!((androidx.f.a.d)object4 instanceof g)) continue;
                        break block7;
                    }
                    object4 = null;
                }
                object4 = (g)object4;
                if (object4 != null) {
                    ((g)object4).an();
                    return;
                }
                if (((i)object2).d() > 0) {
                    ((i)object2).b();
                    return;
                }
                super.onBackPressed();
                return;
            }
            throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.main.RootFragment");
        }
        throw (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = f.a(this, 2131427361);
        j.a(object, "DataBindingUtil.setConte\u2026, R.layout.activity_main)");
        this.o = (k)object;
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object != null) {
                this.n = (q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object = this.n;
        Object object2 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object = ((q)object).a((androidx.f.a.e)object2, b2).a(s.class);
        j.a(object, "commuterViewModelProvide\u2026ainViewModel::class.java)");
        this.m = (s)object;
        object = this.o;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((k)object).d;
        ((MainViewPager)((Object)object)).setPagingEnabled(false);
        j.a(object, "viewPager");
        ((ViewPager)((Object)object)).setOffscreenPageLimit(3);
        object2 = this.k();
        j.a(object2, "supportFragmentManager");
        ((ViewPager)((Object)object)).setAdapter(new r((i)object2, (Context)this));
        object2 = this.o;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object2 = ((k)object2).f;
        ((TabLayout)((Object)object2)).setupWithViewPager((ViewPager)((Object)object));
        j.a(object2, "tabLayout");
        this.a((TabLayout)((Object)object2));
        this.n();
    }

}

