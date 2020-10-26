/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.view.animation.ScaleAnimation
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.au;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.favoriteroute.FavoriteRouteRegistrationActivity;
import jp.co.jreast.jreastapp.commuter.main.MainActivity;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingDate;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.servicestatus.ServiceStatusDetailActivity;
import jp.co.jreast.jreastapp.commuter.webview.n;
import kotlin.Metadata;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\"\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u001dH\u0007J\b\u0010.\u001a\u00020\u001dH\u0007J+\u0010/\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u00103\u001a\u000204H\u0016\u00a2\u0006\u0002\u00105J\b\u00106\u001a\u00020\u001dH\u0016J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0007J\u000e\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020\u001dH\u0002J\u0010\u0010>\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u00010$J\b\u0010@\u001a\u00020\u001dH\u0002J\b\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\u0018\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u0002022\u0006\u0010E\u001a\u00020FH\u0002J\u0006\u0010G\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006H"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteDetailBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteDetailBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteDetailBinding;)V", "mainActivity", "Ljp/co/jreast/jreastapp/commuter/main/MainActivity;", "notifyUtil", "Ljp/co/jreast/jreastapp/commuter/util/NotifyUtil;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "captureScreen", "", "closeScreenCaptureNoticeView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNeverAskAgain", "onPermissionDenied", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onShowRationale", "request", "Lpermissions/dispatcher/PermissionRequest;", "openFavoriteRouteRegistrationScreen", "route", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "openScreenCaptureNotice", "openServiceStatusDetailScreen", "passedIntent", "setAccentAnimation", "setSupportActionBar", "showPermissionDialog", "showSnackBar", "message", "isSuccess", "", "tapBackButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e
extends androidx.f.a.d
implements s {
    public w.b a;
    public jp.co.jreast.jreastapp.commuter.n.k b;
    public au c;
    private MainActivity d;
    private jp.co.jreast.jreastapp.commuter.f.q e;
    private jp.co.jreast.jreastapp.commuter.r.f f;
    private HashMap g;

    public e() {
        this.e = new jp.co.jreast.jreastapp.commuter.f.q();
        this.f = new jp.co.jreast.jreastapp.commuter.r.f();
    }

    private final void a(String object, boolean bl2) {
        au au2 = this.c;
        if (au2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object = Snackbar.a((View)au2.f, (CharSequence)object, 0);
        int n2 = bl2 ? 2131165714 : 2131165715;
        kotlin.e.b.j.a(object, "snack");
        au2 = ((BaseTransientBottomBar)object).d();
        kotlin.e.b.j.a((Object)au2, "snack.view");
        Context context = this.m();
        if (context == null) {
            kotlin.e.b.j.a();
        }
        au2.setBackground(androidx.core.a.a.a(context, n2));
        au2 = ((BaseTransientBottomBar)object).d().findViewById(2131231199);
        if (au2 != null) {
            au2 = (TextView)au2;
            au2.setTextSize(1, 14.0f);
            CalligraphyUtils.applyFontToTextView(this.m(), (TextView)au2, "fonts/TT-UDShinGoPro-Medium.ttf");
            ((BaseTransientBottomBar)object).a(700);
            ((Snackbar)object).e();
            return;
        }
        throw new t("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void am() {
        Object object = this.k();
        if (object == null) {
            kotlin.e.b.j.a();
        }
        if ((object = object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.v.a())) != null) {
            object = (Route)object;
            Object object2 = kotlin.a.m.f(((Route)object).getLines()).getFrom().getAccuracy().fourDigitString();
            Object object3 = kotlin.a.m.h(((Route)object).getLines()).getTo().getAccuracy().fourDigitString();
            au au2 = this.c;
            if (au2 == null) {
                kotlin.e.b.j.b("dataBinding");
            }
            au2 = au2.s;
            kotlin.e.b.j.a((Object)au2, "dataBinding.titleDepartureTime");
            au2.setText((CharSequence)object2);
            object2 = this.c;
            if (object2 == null) {
                kotlin.e.b.j.b("dataBinding");
            }
            object2 = ((au)object2).r;
            kotlin.e.b.j.a(object2, "dataBinding.titleArrivalTime");
            object2.setText((CharSequence)object3);
            object3 = kotlin.a.m.f(((Route)object).getLines()).getFrom().getBoardingDate();
            int n2 = ((CharSequence)((BoardingDate)object3).getYear()).length();
            int n3 = 0;
            n2 = n2 > 0 ? 1 : 0;
            if (n2 != 0 && (n2 = ((CharSequence)((BoardingDate)object3).getMonth()).length() > 0 ? 1 : 0) != 0) {
                n2 = n3;
                if (((CharSequence)((BoardingDate)object3).getDay()).length() > 0) {
                    n2 = 1;
                }
                if (n2 != 0) {
                    object = new jp.co.jreast.jreastapp.commuter.d.a().a(kotlin.a.m.f(((Route)object).getLines()).getFrom().getBoardingDate());
                    object3 = this.c;
                    if (object3 == null) {
                        kotlin.e.b.j.b("dataBinding");
                    }
                    object3 = ((au)object3).q;
                    kotlin.e.b.j.a(object3, "dataBinding.subTitle");
                    object3.setText((CharSequence)jp.co.jreast.jreastapp.commuter.d.b.a((Date)object, "M\u6708d\u65e5(E)"));
                }
            }
            return;
        }
        throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.model.Route");
    }

    private final void an() {
        Object object = n.ah;
        Object object2 = this.m();
        if (object2 == null) {
            kotlin.e.b.j.a();
        }
        object2 = object2.getString(2131558459);
        kotlin.e.b.j.a(object2, "context!!.getString(R.st\u2026sion_extra_storage_title)");
        Object object3 = this.m();
        if (object3 == null) {
            kotlin.e.b.j.a();
        }
        object3 = object3.getString(2131558457);
        kotlin.e.b.j.a(object3, "context!!.getString(R.st\u2026on_extra_storage_message)");
        Object object4 = this.m();
        if (object4 == null) {
            kotlin.e.b.j.a();
        }
        object4 = object4.getString(2131558458);
        kotlin.e.b.j.a(object4, "context!!.getString(R.st\u2026on_extra_storage_setting)");
        Context context = this.m();
        if (context == null) {
            kotlin.e.b.j.a();
        }
        object = ((n.a)object).a((String)object2, (String)object3, (String)object4, context.getString(2131558456));
        ((n)object).a(new DialogInterface.OnClickListener(){

            public final void onClick(DialogInterface object, int n2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("package:");
                object = this.m();
                if (object == null || (object = object.getPackageName()) == null) {
                    object = "";
                }
                stringBuilder.append(object);
                object = stringBuilder.toString();
                stringBuilder = new Intent();
                stringBuilder.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                stringBuilder.setData(Uri.parse((String)object));
                this.a((Intent)stringBuilder);
            }
        });
        ((n)object).b(new DialogInterface.OnClickListener((n)object){
            final /* synthetic */ n a;
            {
                this.a = n2;
            }

            public final void onClick(DialogInterface dialogInterface, int n2) {
                this.a.a();
            }
        });
        ((androidx.f.a.c)object).a(this.s(), "permissionMessageDialog");
    }

    private final void ao() {
        Animation animation = AnimationUtils.loadAnimation((Context)((Context)this.o()), (int)2130771986);
        Object object = AnimationUtils.loadAnimation((Context)((Context)this.o()), (int)2130771986);
        kotlin.e.b.j.a(object, "anim");
        object.setDuration(500L);
        object.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                this.b().p.clearAnimation();
                this.ap();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        Handler handler = new Handler();
        object = new Runnable((Animation)object){
            final /* synthetic */ Animation b;
            {
                this.b = animation;
            }

            @Override
            public final void run() {
                this.a().l().b(false);
                this.b().p.startAnimation(this.b);
            }
        };
        kotlin.e.b.j.a((Object)animation, "enterAnim");
        handler.postDelayed((Runnable)object, animation.getDuration() + (long)300);
    }

    private final void ap() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setDuration(500L);
        Object object = this.c;
        if (object == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object = ((au)object).c;
        scaleAnimation = (Animation)scaleAnimation;
        object.startAnimation((Animation)scaleAnimation);
        object = this.c;
        if (object == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        ((au)object).j.startAnimation((Animation)scaleAnimation);
    }

    private final void aq() {
        jp.co.jreast.jreastapp.commuter.n.k k2 = this.b;
        if (k2 == null) {
            kotlin.e.b.j.b("viewModel");
        }
        k2.v();
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        kotlin.e.b.j.b(object, "inflater");
        object = au.a((LayoutInflater)object, object2, false);
        kotlin.e.b.j.a(object, "FragmentRouteDetailBindi\u2026flater, container, false)");
        this.c = object;
        object = this.k();
        object2 = null;
        if (object != null && (object = (object = this.k()) != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
            object = this.k();
            object = object != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null;
            if (object != null) {
                this.e = (jp.co.jreast.jreastapp.commuter.f.q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        if ((object = (object = this.k()) != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.v.a()) : null) != null) {
            object3 = (Route)object;
            object = this.e;
            Object object4 = this.o();
            if (object4 == null) {
                kotlin.e.b.j.a();
            }
            kotlin.e.b.j.a(object4, "activity!!");
            Object object5 = this.a;
            if (object5 == null) {
                kotlin.e.b.j.b("viewModelFactory");
            }
            object = ((jp.co.jreast.jreastapp.commuter.f.q)object).a((androidx.f.a.e)object4, (w.b)object5).a(jp.co.jreast.jreastapp.commuter.n.k.class);
            kotlin.e.b.j.a(object, "commuterViewModelProvide\u2026ailViewModel::class.java)");
            this.b = (jp.co.jreast.jreastapp.commuter.n.k)object;
            object = this.b;
            if (object == null) {
                kotlin.e.b.j.b("viewModel");
            }
            ((jp.co.jreast.jreastapp.commuter.n.k)object).a((Route)object3);
            object5 = ((jp.co.jreast.jreastapp.commuter.n.k)object).c();
            object4 = this;
            ((al)object5).a((androidx.lifecycle.j)object4, (q)}
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    