/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.ak;
import jp.co.jreast.jreastapp.commuter.c.ae;
import jp.co.jreast.jreastapp.commuter.common.f;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.d;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.g;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.i;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import jp.co.jreast.jreastapp.commuter.r.a;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0019J.\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010'\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020&J\u0006\u0010(\u001a\u00020\u0019J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006*"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/FavoriteRouteDetailItemBinding;", "viewType", "Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewType;", "height", "", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/databinding/FavoriteRouteDetailItemBinding;Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewType;I)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FavoriteRouteDetailItemBinding;", "getContext", "()Landroid/content/Context;", "getHeight", "()I", "mAlphaFadeInAnimation", "Landroid/view/animation/Animation;", "mScaleAnimation", "scale", "", "getViewType", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewType;", "doDelayInfoAnimation", "", "getLineBarResourceId", "setColorOfLineBar", "appCompatResourcesUtil", "Ljp/co/jreast/jreastapp/commuter/repository/di/AppCompatResourcesUtil;", "setDelayIcon", "setInformationVisibility", "setLineBar", "lineIconPosition", "Ljp/co/jreast/jreastapp/commuter/common/LineIconPosition;", "previousLineColor", "", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "setLineIcon", "setStationName", "setWalkingLineBar", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends RecyclerView.x {
    private float q;
    private Animation r;
    private Animation s;
    private final Context t;
    private final ae u;
    private final i v;
    private final int w;

    public c(Context object, ae ae2, i i2, int n2) {
        j.b(object, "context");
        j.b(ae2, "binding");
        j.b((Object)i2, "viewType");
        super(ae2.e());
        this.t = object;
        this.u = ae2;
        this.v = i2;
        this.w = n2;
        object = this.t.getResources();
        j.a(object, "context.resources");
        this.q = object.getDisplayMetrics().density;
        n2 = (int)((float)this.w * this.q + 0.5f);
        object = this.u.j;
        j.a(object, "binding.information");
        object.getLayoutParams().height = n2;
        object = AnimationUtils.loadAnimation((Context)this.t, (int)2130771992);
        j.a(object, "AnimationUtils.loadAnima\u2026ute_service_status_scale)");
        this.r = object;
        object = AnimationUtils.loadAnimation((Context)this.t, (int)2130771990);
        j.a(object, "AnimationUtils.loadAnima\u2026ute_service_status_alpha)");
        this.s = object;
    }

    private final int G() {
        RailwayLine railwayLine = this.u.k();
        if (railwayLine == null) {
            j.a();
        }
        boolean bl2 = railwayLine.getDirectOperationDeparture();
        railwayLine = this.u.k();
        if (railwayLine == null) {
            j.a();
        }
        boolean bl3 = railwayLine.getDirectOperationArrival();
        if (bl2 && bl3) {
            return 0;
        }
        if (bl2 && !bl3) {
            return 2131165708;
        }
        if (!bl2 && bl3) {
            return 2131165707;
        }
        return 2131165706;
    }

    private final void a(f f2) {
        block6 : {
            LayoutInflater layoutInflater = LayoutInflater.from((Context)this.t);
            f f3 = f.b;
            int n2 = 1;
            int n3 = f2 == f3 ? Math.max((this.w - 32) / 20 / 2, 1) : (this.w - 32 - 10) / 20;
            if (1 > n3) break block6;
            do {
                block7 : {
                    switch (d.e[f2.ordinal()]) {
                        default: {
                            break block7;
                        }
                        case 3: {
                            f3 = this.u.t;
                            break;
                        }
                        case 2: {
                            layoutInflater.inflate(2131427461, (ViewGroup)this.u.t);
                        }
                        case 1: {
                            f3 = this.u.s;
                        }
                    }
                    layoutInflater.inflate(2131427461, (ViewGroup)f3);
                }
                if (n2 == n3) break;
                ++n2;
            } while (true);
        }
    }

    public static /* synthetic */ void a(c c2, f f2, e e2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            e2 = new e();
        }
        c2.a(f2, e2);
    }

    public static /* synthetic */ void a(c c2, f f2, String string2, e e2, jp.co.jreast.jreastapp.commuter.m.a.a a2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string2 = null;
        }
        if ((n2 & 4) != 0) {
            e2 = new e();
        }
        if ((n2 & 8) != 0) {
            a2 = new jp.co.jreast.jreastapp.commuter.m.a.a();
        }
        c2.a(f2, string2, e2, a2);
    }

    private final void a(jp.co.jreast.jreastapp.commuter.m.a.a a2) {
        int n2;
        Object object = this.u.k();
        if (object == null) {
            j.a();
        }
        if ((n2 = ((CharSequence)(object = ((RailwayLine)object).getColor())).length() == 0 ? 1 : 0) == 0) {
            n2 = Color.parseColor((String)object);
            int n3 = this.G();
            if (n3 != 0) {
                if ((a2 = a2.a(this.t, n3)) == null) {
                    j.a();
                }
                a2 = a2.mutate();
                a2.setColorFilter(n2, PorterDuff.Mode.SRC_IN);
                object = this.a;
                j.a(object, "itemView");
                object = object.findViewById(ak.a.lineBar);
                j.a(object, "itemView.lineBar");
                object.setBackground((Drawable)a2);
                return;
            }
            a2 = this.a;
            j.a((Object)a2, "itemView");
            a2 = a2.findViewById(ak.a.lineBar);
            j.a((Object)a2, "itemView.lineBar");
            a2.setBackground((Drawable)null);
            a2 = this.a;
            j.a((Object)a2, "itemView");
            a2.findViewById(ak.a.lineBar).setBackgroundColor(n2);
            return;
        }
        throw (Throwable)new Exception("colorCode is Empty");
    }

    public final void A() {
        Serializable serializable;
        i i2 = this.v;
        switch (d.a[i2.ordinal()]) {
            default: {
                return;
            }
            case 2: {
                i2 = this.u.r;
                j.a((Object)i2, "binding.stationName");
                serializable = this.u.k();
                if (serializable == null) {
                    j.a();
                }
                serializable = ((RailwayLine)serializable).getTo();
                break;
            }
            case 1: {
                i2 = this.u.r;
                j.a((Object)i2, "binding.stationName");
                serializable = this.u.k();
                if (serializable == null) {
                    j.a();
                }
                serializable = ((RailwayLine)serializable).getFrom();
            }
        }
        i2.setText((CharSequence)((BoardingStation)serializable).getName());
    }

    public final void B() {
        Object object = this.v;
        switch (d.b[object.ordinal()]) {
            default: {
                break;
            }
            case 2: {
                object = this.u.j;
                j.a(object, "binding.information");
                object.setVisibility(4);
                break;
            }
            case 1: {
                object = this.u.j;
                j.a(object, "binding.information");
                object.setVisibility(0);
            }
        }
        object = this.u.k();
        if (object == null) {
            j.a();
        }
        if (((RailwayLine)object).getDirectOperationArrival() && this.v == i.a) {
            object = this.a;
            j.a(object, "itemView");
            object = (ConstraintLayout)object.findViewById(ak.a.railwayDirectView);
            j.a(object, "itemView.railwayDirectView");
            object.setVisibility(0);
            object = this.a;
            j.a(object, "itemView");
            object = (TextView)object.findViewById(ak.a.stationName);
            j.a(object, "itemView.stationName");
            object.setVisibility(4);
            return;
        }
        object = this.a;
        j.a(object, "itemView");
        object = (ConstraintLayout)object.findViewById(ak.a.railwayDirectView);
        j.a(object, "itemView.railwayDirectView");
        object.setVisibility(8);
        object = this.a;
        j.a(object, "itemView");
        object = (TextView)object.findViewById(ak.a.stationName);
        j.a(object, "itemView.stationName");
        object.setVisibility(0);
    }

    public final void C() {
        RailwayLine railwayLine;
        Object object = this.u.j();
        if (object == null) {
            j.a();
        }
        if ((railwayLine = this.u.k()) == null) {
            j.a();
        }
        j.a((Object)railwayLine, "binding.line!!");
        object = ((g)object).b(railwayLine);
        railwayLine = this.a;
        j.a((Object)railwayLine, "itemView");
        ((AppCompatImageView)railwayLine.findViewById(ak.a.delayWarningImage)).setImageDrawable((Drawable)object);
        object = this.u.k();
        if (object == null) {
            j.a();
        }
        if (((RailwayLine)object).isDelayed()) {
            object = this.a;
            j.a(object, "itemView");
            object = (ConstraintLayout)object.findViewById(ak.a.delayInfoLayout);
            j.a(object, "itemView.delayInfoLayout");
            int n2 = 0;
            object.setVisibility(0);
            object = this.a;
            j.a(object, "itemView");
            object = (TextView)object.findViewById(ak.a.delayStatus);
            j.a(object, "itemView.delayStatus");
            railwayLine = this.u.k();
            if (railwayLine == null) {
                j.a();
            }
            int n3 = ((CharSequence)railwayLine.getServiceStatus().getDelayStatus()).length();
            int n4 = 1;
            n3 = n3 == 0 ? 1 : 0;
            n3 = n3 != 0 ? 8 : 0;
            object.setVisibility(n3);
            object = this.a;
            j.a(object, "itemView");
            object = (TextView)object.findViewById(ak.a.delayReason);
            j.a(object, "itemView.delayReason");
            railwayLine = this.u.k();
            if (railwayLine == null) {
                j.a();
            }
            n3 = ((CharSequence)railwayLine.getServiceStatus().getDelayReason()).length() == 0 ? 1 : 0;
            n3 = n3 != 0 ? 8 : 0;
            object.setVisibility(n3);
            object = this.a;
            j.a(object, "itemView");
            object = (TextView)object.findViewById(ak.a.delayMinutes);
            j.a(object, "itemView.delayMinutes");
            railwayLine = this.u.k();
            if (railwayLine == null) {
                j.a();
            }
            if ((n3 = ((CharSequence)railwayLine.getServiceStatus().getDelayMinute()).length() == 0 ? n4 : 0) != 0) {
                n2 = 8;
            }
            object.setVisibility(n2);
            return;
        }
        object = this.a;
        j.a(object, "itemView");
        object = (ConstraintLayout)object.findViewById(ak.a.delayInfoLayout);
        j.a(object, "itemView.delayInfoLayout");
        object.setVisibility(4);
    }

    public final void D() {
        RailwayLine railwayLine = this.u.k();
        if (railwayLine == null) {
            j.a();
        }
        if (railwayLine.isDelayed()) {
            railwayLine = this.a;
            j.a((Object)railwayLine, "itemView");
            ((ConstraintLayout)railwayLine.findViewById(ak.a.delayInfoLayout)).startAnimation(this.r);
            railwayLine = this.a;
            j.a((Object)railwayLine, "itemView");
            ((LinearLayout)railwayLine.findViewById(ak.a.delayInfoLayoutLeft)).startAnimation(this.s);
            railwayLine = this.a;
            j.a((Object)railwayLine, "itemView");
            ((ConstraintLayout)railwayLine.findViewById(ak.a.delayInfoLayoutRight)).startAnimation(this.s);
        }
    }

    public final ae E() {
        return this.u;
    }

    public final i F() {
        return this.v;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(f var1_1, e var2_2) {
        block7 : {
            j.b(var1_1, "lineIconPosition");
            j.b(var2_19, "constraintSet");
            var5_20 = this.u.j();
            if (var5_20 == null) {
                j.a();
            }
            if ((var6_27 = this.u.k()) == null) {
                j.a();
            }
            j.a((Object)var6_27, "binding.line!!");
            var5_21 = var5_20.a(var6_27);
            var6_27 = this.a;
            j.a((Object)var6_27, "itemView");
            ((AppCompatImageView)var6_27.findViewById(ak.a.lineIconImageView)).setImageDrawable(var5_21);
            var5_22 = this.a;
            j.a((Object)var5_22, "itemView");
            ((AppCompatImageView)var5_22.findViewById(ak.a.lineIconImageView)).bringToFront();
            var2_19.a(this.u.j);
            switch (d.c[var1_1.ordinal()]) {
                default: {
                    break block7;
                }
                case 3: {
                    var1_2 = this.u.p;
                    j.a((Object)var1_2, "binding.lineIconImageView");
                    var2_19.a(var1_2.getId(), 3);
                    var1_3 = this.u.p;
                    j.a((Object)var1_3, "binding.lineIconImageView");
                    var3_28 = var1_3.getId();
                    var1_4 = this.u.j;
                    j.a((Object)var1_4, "binding.information");
                    var2_19.a(var3_28, 4, var1_4.getId(), 4, (int)(this.q * 10.0f + 0.5f));
                    var1_5 = this.u.c;
                    j.a((Object)var1_5, "binding.delayInfoLayout");
                    var2_19.a(var1_5.getId(), 3);
                    var1_6 = this.u.c;
                    j.a((Object)var1_6, "binding.delayInfoLayout");
                    var3_28 = var1_6.getId();
                    var1_7 = this.u.j;
                    j.a((Object)var1_7, "binding.information");
                    var4_30 = var1_7.getId();
                    ** GOTO lbl67
                }
                case 2: {
                    var1_8 = this.u.p;
                    j.a((Object)var1_8, "binding.lineIconImageView");
                    var3_28 = var1_8.getId();
                    var1_9 = this.u.j;
                    j.a((Object)var1_9, "binding.information");
                    var4_30 = var1_9.getId();
                    var1_10 = var2_19;
                    var1_10.a(var3_28, 3, var4_30, 3, 0);
                    var5_23 = this.u.p;
                    j.a((Object)var5_23, "binding.lineIconImageView");
                    var3_28 = var5_23.getId();
                    var5_24 = this.u.j;
                    j.a((Object)var5_24, "binding.information");
                    var1_10.a(var3_28, 4, var5_24.getId(), 4, 0);
                    var5_25 = this.u.c;
                    j.a((Object)var5_25, "binding.delayInfoLayout");
                    var3_28 = var5_25.getId();
                    var5_26 = this.u.j;
                    j.a((Object)var5_26, "binding.information");
                    var1_10.a(var3_28, 3, var5_26.getId(), 3, 0);
                    var1_11 = this.u.c;
                    j.a((Object)var1_11, "binding.delayInfoLayout");
                    var3_28 = var1_11.getId();
                    var1_12 = this.u.j;
                    j.a((Object)var1_12, "binding.information");
                    var4_30 = var1_12.getId();
lbl67: // 2 sources:
                    var2_19.a(var3_28, 4, var4_30, 4, 0);
                    break block7;
                }
                case 1: 
            }
            var1_13 = this.u.p;
            j.a((Object)var1_13, "binding.lineIconImageView");
            var3_29 = var1_13.getId();
            var1_14 = this.u.j;
            j.a((Object)var1_14, "binding.information");
            var2_19.a(var3_29, 3, var1_14.getId(), 3, (int)(this.q * 10.0f + 0.5f));
            var1_15 = this.u.p;
            j.a((Object)var1_15, "binding.lineIconImageView");
            var2_19.a(var1_15.getId(), 4);
            var1_16 = this.u.c;
            j.a((Object)var1_16, "binding.delayInfoLayout");
            var3_29 = var1_16.getId();
            var1_17 = this.u.j;
            j.a((Object)var1_17, "binding.information");
            var2_19.a(var3_29, 3, var1_17.getId(), 3, 0);
            var1_18 = this.u.c;
            j.a((Object)var1_18, "binding.delayInfoLayout");
            var2_19.a(var1_18.getId(), 4);
        }
        var2_19.b(this.u.j);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(f var1_1, String var2_2, e var3_3, jp.co.jreast.jreastapp.commuter.m.a.a var4_4) {
        block9 : {
            j.b((Object)var1_1, "lineIconPosition");
            j.b(var3_16, "constraintSet");
            j.b(var4_17, "appCompatResourcesUtil");
            this.u.t.removeAllViews();
            this.u.s.removeAllViews();
            var7_18 = this.u.k();
            if (var7_18 == null) {
                j.a();
            }
            if (var7_18.isWalking()) {
                var2_3 = this.a;
                j.a((Object)var2_3, "itemView");
                var2_4 = var2_3.findViewById(ak.a.lineBar);
                j.a((Object)var2_4, "itemView.lineBar");
                var2_4.setVisibility(8);
                this.a(var1_1);
                return;
            }
            var7_18 = this.a;
            j.a((Object)var7_18, "itemView");
            var7_18 = var7_18.findViewById(ak.a.lineBar);
            j.a((Object)var7_18, "itemView.lineBar");
            var5_19 = 0;
            var7_18.setVisibility(0);
            if (var2_2 /* !! */  != null) {
                var6_20 = Color.parseColor((String)var2_2 /* !! */ );
                var2_5 = this.a;
                j.a((Object)var2_5, "itemView");
                var2_6 = (ConstraintLayout)var2_5.findViewById(ak.a.railwayDirectView);
                j.a((Object)var2_6, "itemView.railwayDirectView");
                ((View)var2_6).findViewById(ak.a.lineBarTopPadding).setBackgroundColor(var6_20);
                var2_7 = this.a;
                j.a((Object)var2_7, "itemView");
                var2_8 = (ConstraintLayout)var2_7.findViewById(ak.a.railwayDirectView);
                j.a((Object)var2_8, "itemView.railwayDirectView");
                var2_9 = ((View)var2_8).findViewById(ak.a.lineBarTop);
                j.a((Object)var2_9, "itemView.railwayDirectView.lineBarTop");
                var2_9.getBackground().mutate().setColorFilter(var6_20, PorterDuff.Mode.SRC_IN);
                var2_10 = this.u.k();
                if (var2_10 == null) {
                    j.a();
                }
                var6_20 = Color.parseColor((String)var2_10.getColor());
                var2_11 = this.a;
                j.a((Object)var2_11, "itemView");
                var2_12 = (ConstraintLayout)var2_11.findViewById(ak.a.railwayDirectView);
                j.a((Object)var2_12, "itemView.railwayDirectView");
                var2_13 = ((View)var2_12).findViewById(ak.a.lineBarBottom);
                j.a((Object)var2_13, "itemView.railwayDirectView.lineBarBottom");
                var2_13.getBackground().mutate().setColorFilter(var6_20, PorterDuff.Mode.SRC_IN);
                var2_14 = this.a;
                j.a((Object)var2_14, "itemView");
                var2_15 = (ConstraintLayout)var2_14.findViewById(ak.a.railwayDirectView);
                j.a((Object)var2_15, "itemView.railwayDirectView");
                ((View)var2_15).findViewById(ak.a.lineBarBottomPadding).setBackgroundColor(var6_20);
            }
            this.a((jp.co.jreast.jreastapp.commuter.m.a.a)var4_17);
            var3_16.a(this.u.j);
            switch (d.d[var1_1.ordinal()]) {
                default: {
                    break block9;
                }
                case 3: {
                    var1_1 = this.u.k;
                    j.a((Object)var1_1, "binding.lineBar");
                    var6_20 = var1_1.getId();
                    ** GOTO lbl69
                }
                case 2: {
                    if (this.w <= 200) ** GOTO lbl74
                    var1_1 = this.u.k;
                    j.a((Object)var1_1, "binding.lineBar");
                    var6_20 = var1_1.getId();
                    var5_19 = a.a.a(10, this.q);
lbl69: // 2 sources:
                    var3_16.a(var6_20, 3, var5_19);
                    var1_1 = this.u.k;
                    j.a((Object)var1_1, "binding.lineBar");
                    var3_16.a(var1_1.getId(), 4, a.a.a(10, this.q));
                    break block9;
lbl74: // 1 sources:
                    var1_1 = this.u.k;
                    j.a((Object)var1_1, "binding.lineBar");
                    var3_16.a(var1_1.getId(), 3, 0);
                    ** break;
                }
                case 1: 
            }
            var1_1 = this.u.k;
            j.a((Object)var1_1, "binding.lineBar");
            var3_16.a(var1_1.getId(), 3, a.a.a(10, this.q));
lbl82: // 2 sources:
            var1_1 = this.u.k;
            j.a((Object)var1_1, "binding.lineBar");
            var3_16.a(var1_1.getId(), 4, 0);
        }
        var3_16.b(this.u.j);
    }
}

