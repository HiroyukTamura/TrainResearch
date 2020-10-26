/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.q;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.ak;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.bi;
import jp.co.jreast.jreastapp.commuter.c.cm;
import jp.co.jreast.jreastapp.commuter.commuterpager.a;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.main.MainActivity;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatus;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatusItem;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.r;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001YB\u0005\u00a2\u0006\u0002\u0010\u0004J\"\u0010)\u001a\u00020*2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020.0,H\u0002J(\u0010/\u001a\u0002002\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020.0,2\u0006\u00101\u001a\u000202J0\u00103\u001a\u0002002\u0006\u00104\u001a\u0002052\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020*J0\u00107\u001a\u0002002\u0006\u00104\u001a\u0002052\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020*J0\u00108\u001a\u0002002\u0006\u00104\u001a\u0002052\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020.0,2\u0006\u00109\u001a\u000202J*\u0010:\u001a\u0002022\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020*H\u0002J\b\u0010;\u001a\u000200H\u0002J\u001b\u0010<\u001a\u0002002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020.0>H\u0002\u00a2\u0006\u0002\u0010?J\"\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J&\u0010E\u001a\u0004\u0018\u00010-2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u000200H\u0002J\b\u0010M\u001a\u000200H\u0002J\b\u0010N\u001a\u000200H\u0002J\u0010\u0010O\u001a\u0002002\u0006\u0010P\u001a\u000205H\u0016J\b\u0010Q\u001a\u000200H\u0002J\u0010\u0010R\u001a\u0002002\u0006\u0010S\u001a\u000205H\u0002J\u001c\u0010T\u001a\u0002002\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020X0VH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006Z"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "Ljp/co/jreast/jreastapp/commuter/main/RootFragmentMainChild;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTrainServiceBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTrainServiceBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTrainServiceBinding;)V", "infoDialog", "Ljp/co/jreast/jreastapp/commuter/trainservice/trainserviceinfo/TrainServiceInfoDialogFragment;", "getInfoDialog", "()Ljp/co/jreast/jreastapp/commuter/trainservice/trainserviceinfo/TrainServiceInfoDialogFragment;", "setInfoDialog", "(Ljp/co/jreast/jreastapp/commuter/trainservice/trainserviceinfo/TrainServiceInfoDialogFragment;)V", "mainActivity", "Ljp/co/jreast/jreastapp/commuter/main/MainActivity;", "getMainActivity", "()Ljp/co/jreast/jreastapp/commuter/main/MainActivity;", "setMainActivity", "(Ljp/co/jreast/jreastapp/commuter/main/MainActivity;)V", "mainViewModel", "Ljp/co/jreast/jreastapp/commuter/main/MainViewModel;", "scalableImageDialog", "Ljp/co/jreast/jreastapp/commuter/common/ScalableImageDialogFragment;", "getScalableImageDialog", "()Ljp/co/jreast/jreastapp/commuter/common/ScalableImageDialogFragment;", "setScalableImageDialog", "(Ljp/co/jreast/jreastapp/commuter/common/ScalableImageDialogFragment;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "calculateTrainServiceDetailRowHeight", "", "rowInfo", "Lkotlin/Triple;", "Landroid/view/View;", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;", "doExpandAnimation", "", "rowAnimator", "Landroid/animation/ValueAnimator;", "doExpandAnimationEnd", "detailRowGone", "", "trainServiceDetailRowHeight", "doExpandAnimationStart", "doExpandAnimationUpdate", "updatedAnimation", "generateAnimator", "hideErrorAnimation", "loadData", "list", "", "([Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;)V", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "openScalableImage", "openTrainServiceInfo", "refreshScreen", "setUserVisibleHint", "isVisibleToUser", "showErrorAnimation", "startPopupAnimation", "isShow", "updateStatusOfSummary", "resultMap", "", "", "Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends androidx.f.a.d
implements s,
jp.co.jreast.jreastapp.commuter.main.v {
    public static final a d;
    public bi a;
    private HashMap ag;
    public w.b b;
    public MainActivity c;
    private jp.co.jreast.jreastapp.commuter.common.m e;
    private jp.co.jreast.jreastapp.commuter.q.a.a f;
    private jp.co.jreast.jreastapp.commuter.q.h g;
    private jp.co.jreast.jreastapp.commuter.main.s h;
    private jp.co.jreast.jreastapp.commuter.f.q i;

    static {
        d = new a(null);
    }

    public c() {
        this.e = new jp.co.jreast.jreastapp.commuter.common.m();
        this.f = new jp.co.jreast.jreastapp.commuter.q.a.a();
        this.i = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    private final int a(r<? extends View, Integer, LineServiceStatusItem> object) {
        Object object2 = ((r)object).a();
        LineServiceStatus lineServiceStatus = ((LineServiceStatusItem)(object = ((r)object).c())).getLineServiceStatus();
        if (lineServiceStatus == null) {
            kotlin.e.b.j.a();
        }
        TextView textView = (TextView)object2.findViewById(ak.a.detailText);
        object2 = (AppCompatImageView)object2.findViewById(ak.a.changeRouteImage);
        Object object3 = this.q();
        kotlin.e.b.j.a(object3, "resources");
        int n2 = View.MeasureSpec.makeMeasureSpec((int)object3.getDisplayMetrics().widthPixels, (int)1073741824);
        textView.measure(n2, -2);
        object2.measure(n2, -2);
        object3 = this.g;
        if (object3 == null) {
            kotlin.e.b.j.b("viewModel");
        }
        if (((jp.co.jreast.jreastapp.commuter.q.h)object3).a(((LineServiceStatusItem)object).getJrId(), lineServiceStatus.getDelayStatus())) {
            kotlin.e.b.j.a((Object)textView, "detailText");
            n2 = textView.getMeasuredHeight();
            kotlin.e.b.j.a(object2, "changeRouteImage");
            return n2 + object2.getMeasuredHeight();
        }
        kotlin.e.b.j.a((Object)textView, "detailText");
        return textView.getMeasuredHeight();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final ValueAnimator a(r<? extends View, Integer, LineServiceStatusItem> object, int n2) {
        void var3_8;
        void var1_3;
        void var2_5;
        ConstraintLayout constraintLayout = (ConstraintLayout)((View)((r)object).a()).findViewById(ak.a.trainServiceDetailRow);
        kotlin.e.b.j.a((Object)constraintLayout, "itemView.trainServiceDetailRow");
        if (constraintLayout.getVisibility() == 8) {
            ValueAnimator valueAnimator = ValueAnimator.ofInt((int[])new int[]{0, var2_5});
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener((r)object, (int)var2_5){
                final /* synthetic */ r b;
                final /* synthetic */ int c;
                {
                    this.b = r2;
                    this.c = n2;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c c2 = this;
                    r r2 = this.b;
                    kotlin.e.b.j.a((Object)valueAnimator, "updatedAnimation");
                    c2.a(true, (r<? extends View, Integer, LineServiceStatusItem>)r2, valueAnimator);
                }
            });
            valueAnimator.addListener(new Animator.AnimatorListener((r)object, (int)var2_5){
                final /* synthetic */ r b;
                final /* synthetic */ int c;
                {
                    this.b = r2;
                    this.c = n2;
                }

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    this.b(true, this.b, this.c);
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    this.a(true, (r<? extends View, Integer, LineServiceStatusItem>)this.b, this.c);
                }
            });
            String string2 = "ValueAnimator.ofInt(0, t\u2026         })\n            }";
            ValueAnimator valueAnimator2 = valueAnimator;
        } else {
            ValueAnimator valueAnimator = ValueAnimator.ofInt((int[])new int[]{var2_5, 0});
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener((r)object, (int)var2_5){
                final /* synthetic */ r b;
                final /* synthetic */ int c;
                {
                    this.b = r2;
                    this.c = n2;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c c2 = this;
                    r r2 = this.b;
                    kotlin.e.b.j.a((Object)valueAnimator, "updatedAnimation");
                    c2.a(false, (r<? extends View, Integer, LineServiceStatusItem>)r2, valueAnimator);
                }
            });
            valueAnimator.addListener(new Animator.AnimatorListener((r)object, (int)var2_5){
                final /* synthetic */ r b;
                final /* synthetic */ int c;
                {
                    this.b = r2;
                    this.c = n2;
                }

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    this.b(false, this.b, this.c);
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    this.a(false, (r<? extends View, Integer, LineServiceStatusItem>)this.b, this.c);
                }
            });
            String string3 = "ValueAnimator.ofInt(trai\u2026         })\n            }";
            ValueAnimator valueAnimator3 = valueAnimator;
            String string4 = string3;
        }
        kotlin.e.b.j.a((Object)var1_3, (String)var3_8);
        return var1_3;
    }

    private final void a(Map<String, ServiceStatus> map) {
        block6 : for (int i2 = 1; i2 <= 4; ++i2) {
            Object object;
            Object object2;
            block20 : {
                object2 = this.g;
                if (object2 == null) {
                    kotlin.e.b.j.b("viewModel");
                }
                if ((object = map.get(String.valueOf(i2))) == null) {
                    kotlin.e.b.j.a();
                }
                object2 = ((jp.co.jreast.jreastapp.commuter.q.h)object2).a((ServiceStatus)object);
                switch (i2) {
                    Object object3;
                    Object object4;
                    default: {
                        continue block6;
                    }
                    case 4: {
                        object = this.a;
                        if (object == null) {
                            kotlin.e.b.j.b("dataBinding");
                        }
                        object.j.q.setImageDrawable((Drawable)object2);
                        object2 = this.a;
                        if (object2 == null) {
                            kotlin.e.b.j.b("dataBinding");
                        }
                        object3 = object2.j.r;
                        kotlin.e.b.j.a(object3, "dataBinding.popupTrainSe\u2026Area.shinkansenAreaStatus");
                        object4 = map.get(String.valueOf(i2));
                        object = object3;
                        object2 = object4;
                        if (object4 == null) {
                            object = object3;
                            object2 = object4;
                            break;
                        }
                        break block20;
                    }
                    case 3: {
                        object = this.a;
                        if (object == null) {
                            kotlin.e.b.j.b("dataBinding");
                        }
                        object.j.l.setImageDrawable((Drawable)object2);
                        object2 = this.a;
                        if (object2 == null) {
                            kotlin.e.b.j.b("dataBinding");
                        }
                        object3 = object2.j.m;
                        kotlin.e.b.j.a(object3, "dataBinding.popupTrainSe\u2026ceArea.shinetsuAreaStatus");
                        object4 = map.get(String.valueOf(i2));
                        object = object3;
                        object2 = object4;
                        if (object4 == null) {
                            object = object3;
                            object2 = object4;
                            break;
                        }
                        break block20;
                    }
                    case 2: {
                        object = this.a;
                        if (object == null) {
                            kotlin.e.b.j.b("dataBinding");
                        }
                        object.j.e.setImageDrawable((Drawable)object2);
                        object2 = this.a;
                        if (object2 == null) {
                            kotlin.e.b.j.b("dataBinding");
                        }
                        object3 = object2.j.f;
                        kotlin.e.b.j.a(object3, "dataBinding.popupTrainServiceArea.kantoAreaStatus");
                        object4 = map.get(String.valueOf(i2));
                        object = object3;
                        object2 = object4;
                        if (object4 == null) {
                            object = object3;
                            object2 = object4;
                            break;
                        }
                        break block20;
                    }
                    case 1: {
                        object = this.a;
                        if (object == null) {
                            kotlin.e.b.j.b("dataBinding");
                        }
                        object.j.u.setImageDrawable((Drawable)object2);
                        object2 = this.a;
                        if (object2 == null) {
                            kotlin.e.b.j.b("dataBinding");
                        }
                        object4 = object2.j.v;
                        kotlin.e.b.j.a(object4, "dataBinding.popupTrainServiceArea.tohokuAreaStatus");
                        object3 = map.get(String.valueOf(i2));
                        object = object4;
                        object2 = object3;
                        if (object3 != null) break block20;
                        object2 = object3;
                        object = object4;
                    }
                }
                kotlin.e.b.j.a();
            }
            object.setText((CharSequence)((ServiceStatus)object2).getDelayStatus());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void a(boolean bl2) {
        Context context;
        int n2;
        if (bl2) {
            context = (Context)this.o();
            n2 = 2130771986;
        } else {
            context = (Context)this.o();
            n2 = 2130771988;
        }
        context = AnimationUtils.loadAnimation((Context)context, (int)n2);
        Object object = this.c;
        if (object == null) {
            kotlin.e.b.j.b("mainActivity");
        }
        ((MainActivity)object).a(bl2 ^ true);
        context.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation object) {
                object = this.a().j;
                kotlin.e.b.j.a(object, "dataBinding.popupTrainServiceArea");
                ((ViewDataBinding)object).e().clearAnimation();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        object = this.a;
        if (object == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object = ((bi)object).j;
        kotlin.e.b.j.a(object, "dataBinding.popupTrainServiceArea");
        ((ViewDataBinding)object).e().startAnimation((Animation)context);
    }

    private final void a(LineServiceStatusItem[] arrlineServiceStatusItem) {
        Object object = this.a;
        if (object == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object = ((bi)object).o;
        kotlin.e.b.j.a(object, "dataBinding.trainServiceList");
        object = ((RecyclerView)object).getAdapter();
        if (object != null) {
            object = (jp.co.jreast.jreastapp.commuter.q.a)object;
            ((jp.co.jreast.jreastapp.commuter.q.a)object).a(arrlineServiceStatusItem);
            ((RecyclerView.a)object).c();
            return;
        }
        throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.trainservice.TrainServiceAdapter");
    }

    private final void ai() {
        this.e.b(this);
        this.e.a(this.r(), "ScalableImageDialog");
    }

    private final void aj() {
        this.f.b(this);
        this.f.a(this.r(), "TrainServiceInfoDialog");
    }

    private final void ak() {
        Animation animation = AnimationUtils.loadAnimation((Context)this.m(), (int)2130771997);
        bi bi2 = this.a;
        if (bi2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bi2.e.startAnimation(animation);
    }

    private final void al() {
        Animation animation = AnimationUtils.loadAnimation((Context)this.m(), (int)2130771995);
        animation.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                c.f(this).v();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        bi bi2 = this.a;
        if (bi2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bi2.e.startAnimation(animation);
    }

    private final void c() {
        Object object = this.g;
        if (object == null) {
            kotlin.e.b.j.b("viewModel");
        }
        ((jp.co.jreast.jreastapp.commuter.q.h)object).z();
        object = this.a;
        if (object == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        ((bi)object).o.b(0);
    }

    public static final /* synthetic */ jp.co.jreast.jreastapp.commuter.q.h f(c object) {
        object = ((c)object).g;
        if (object == null) {
            kotlin.e.b.j.b("viewModel");
        }
        return object;
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        kotlin.e.b.j.b(object, "inflater");
        object = bi.a((LayoutInflater)object, (ViewGroup)object2, false);
        kotlin.e.b.j.a(object, "FragmentTrainServiceBind\u2026flater, container, false)");
        this.a = object;
        if (this.k() != null) {
            object = this.k();
            object2 = null;
            if ((object = object != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
                object3 = this.k();
                object = object2;
                if (object3 != null) {
                    object = object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a());
                }
                if (object != null) {
                    this.i = (jp.co.jreast.jreastapp.commuter.f.q)object;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
        }
        object = this.i;
        object2 = this.o();
        if (object2 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a(object2, "activity!!");
        object3 = this.b;
        if (object3 == null) {
            kotlin.e.b.j.b("viewModelFactory");
        }
        object = ((jp.co.jreast.jreastapp.commuter.f.q)object).a((androidx.f.a.e)object2, (w.b)object3).a(a.a.b.name(), jp.co.jreast.jreastapp.commuter.q.h.class);
        object2 = this.i;
        object3 = this.o();
        if (object3 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a(object3, "activity!!");
        w.b b2 = this.b;
        if (b2 == null) {
            kotlin.e.b.j.b("viewModelFactory");
        }
        object2 = ((jp.co.jreast.jreastapp.commuter.f.q)object2).a((androidx.f.a.e)object3, b2).a(jp.co.jreast.jreastapp.commuter.main.s.class);
        kotlin.e.b.j.a(object2, "commuterViewModelProvide\u2026ainViewModel::class.java)");
        this.h = (jp.co.jreast.jreastapp.commuter.main.s)object2;
        object3 = ((jp.co.jreast.jreastapp.commuter.q.h)object).d();
        object2 = this;
        ((al)object3).a((androidx.lifecycle.j)object2, (androidx.lifecycle.q)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    