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
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.ak;
import jp.co.jreast.jreastapp.commuter.c.cy;
import jp.co.jreast.jreastapp.commuter.m.a.a;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import jp.co.jreast.jreastapp.commuter.n.k;
import jp.co.jreast.jreastapp.commuter.r.b;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u001a\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljp/co/jreast/jreastapp/commuter/util/Capturable;", "context", "Landroid/content/Context;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailItemBinding;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailItemBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailItemBinding;", "getContext", "()Landroid/content/Context;", "scale", "", "prepareCapture", "", "setBottomMarginOfLineBar", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "setColorOfLineBar", "appCompatResourcesUtil", "Ljp/co/jreast/jreastapp/commuter/repository/di/AppCompatResourcesUtil;", "setDelayIcon", "setLeftMarginOfDepartureName", "setLineBar", "setLineIcon", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class i
extends RecyclerView.x
implements b {
    private float q;
    private final Context r;
    private final cy s;

    public i(Context context, cy cy2) {
        j.b((Object)context, "context");
        j.b(cy2, "binding");
        super(cy2.e());
        this.r = context;
        this.s = cy2;
        context = this.r.getResources();
        j.a((Object)context, "context.resources");
        this.q = context.getDisplayMetrics().density;
    }

    private final void a(e e2) {
        Object object = this.a;
        j.a(object, "itemView");
        e2.a((ConstraintLayout)object.findViewById(ak.a.generalInformation));
        object = this.s.k();
        if (object == null) {
            j.a();
        }
        int n2 = ((RailwayLine)object).getDirectOperationDeparture() ? 0 : (int)((float)24 * this.q + 0.5f);
        object = this.a;
        j.a(object, "itemView");
        object = object.findViewById(ak.a.lineBar);
        j.a(object, "itemView.lineBar");
        e2.a(object.getId(), 4, n2);
        object = this.a;
        j.a(object, "itemView");
        e2.b((ConstraintLayout)object.findViewById(ak.a.generalInformation));
    }

    private final void a(a a2) {
        int n2;
        Object object = this.s.k();
        if (object == null) {
            j.a();
        }
        if ((n2 = ((CharSequence)(object = ((RailwayLine)object).getColor())).length() == 0 ? 1 : 0) == 0) {
            n2 = Color.parseColor((String)object);
            object = this.s.k();
            if (object == null) {
                j.a();
            }
            if (((RailwayLine)object).getDirectOperationDeparture()) {
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
            if ((a2 = a2.a(this.r, 2131165707)) == null) {
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
        throw (Throwable)new Exception("colorCode is Empty");
    }

    public static /* synthetic */ void a(i i2, e e2, a a2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            e2 = new e();
        }
        if ((n2 & 2) != 0) {
            a2 = new a();
        }
        i2.a(e2, a2);
    }

    public final void A() {
        RailwayLine railwayLine;
        k k2 = this.s.j();
        if (k2 == null) {
            j.a();
        }
        if ((railwayLine = this.s.k()) == null) {
            j.a();
        }
        j.a((Object)railwayLine, "binding.line!!");
        k2 = k2.a(railwayLine);
        railwayLine = this.a;
        j.a((Object)railwayLine, "itemView");
        ((AppCompatImageView)railwayLine.findViewById(ak.a.lineIconImageView)).setImageDrawable((Drawable)k2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void B() {
        k k2;
        RailwayLine railwayLine;
        Boolean bl2 = this.s.l();
        if (bl2 != null && (railwayLine = this.s.k()) != null && (k2 = this.s.j()) != null) {
            cy cy2 = this.s;
            Object object = cy2.k;
            j.a(object, "departureName");
            object.setText((CharSequence)railwayLine.getFrom().getName());
            object = cy2.e;
            j.a(object, "changeTimeImage");
            j.a((Object)bl2, "viewChangeTime");
            boolean bl3 = bl2;
            int n2 = 8;
            int n3 = bl3 && !railwayLine.isWalking() ? 0 : 8;
            object.setVisibility(n3);
            TextView textView = cy2.d;
            j.a((Object)textView, "changeTime");
            if (railwayLine.getChangeTime() == null) {
                object = "";
            } else {
                object = railwayLine.getChangeTime();
                if (object == null) {
                    j.a();
                }
                object = ((Accuracy)object).displayString();
            }
            object = (CharSequence)object;
            textView.setText((CharSequence)object);
            object = cy2.d;
            j.a(object, "changeTime");
            n3 = bl2 != false && !railwayLine.isWalking() ? 0 : 8;
            object.setVisibility(n3);
            object = cy2.l;
            j.a(object, "departureTime");
            object.setText((CharSequence)railwayLine.getFrom().getAccuracy().fourDigitString());
            object = cy2.m;
            j.a(object, "fromPlatformName");
            object.setText((CharSequence)railwayLine.getFrom().platformNameWithSuffix());
            object = cy2.w;
            j.a(object, "toPlatformName");
            object.setText((CharSequence)railwayLine.getTo().platformNameWithSuffix());
            object = cy2.w;
            j.a(object, "toPlatformName");
            n3 = railwayLine.getDirectOperationDeparture() ? 8 : 0;
            object.setVisibility(n3);
            object = cy2.c;
            j.a(object, "arrivalTime");
            object.setText((CharSequence)railwayLine.getTo().getAccuracy().fourDigitString());
            object = cy2.c;
            j.a(object, "arrivalTime");
            n3 = railwayLine.getDirectOperationDeparture() ? 8 : 0;
            object.setVisibility(n3);
            object = cy2.x;
            j.a(object, "walkingTime");
            j.a((Object)railwayLine, "line");
            object.setText((CharSequence)k2.e(railwayLine));
            object = cy2.x;
            j.a(object, "walkingTime");
            n3 = railwayLine.isWalking() ? 0 : 8;
            object.setVisibility(n3);
            object = cy2.s;
            j.a(object, "lineName");
            object.setText((CharSequence)railwayLine.getName());
            object = cy2.s;
            j.a(object, "lineName");
            bl3 = railwayLine.isWalking();
            int n4 = 4;
            n3 = bl3 ? 4 : 0;
            object.setVisibility(n3);
            object = cy2.r;
            j.a(object, "lineKind");
            object.setText((CharSequence)railwayLine.getKindAndBoundFor());
            object = cy2.r;
            j.a(object, "lineKind");
            n3 = ((CharSequence)railwayLine.getKindAndBoundFor()).length();
            int n5 = 1;
            n3 = n3 == 0 ? 1 : 0;
            n3 = n3 != 0 ? 8 : 0;
            object.setVisibility(n3);
            object = cy2.h;
            j.a(object, "delayMinutes");
            object.setText((CharSequence)k2.d(railwayLine));
            object = cy2.h;
            j.a(object, "delayMinutes");
            n3 = ((CharSequence)railwayLine.getServiceStatus().getDelayMinute()).length() == 0 ? 1 : 0;
            n3 = n3 != 0 ? 8 : 0;
            object.setVisibility(n3);
            object = cy2.i;
            j.a(object, "delayReason");
            object.setText((CharSequence)railwayLine.getServiceStatus().getDelayReason());
            object = cy2.i;
            j.a(object, "delayReason");
            n3 = ((CharSequence)railwayLine.getServiceStatus().getDelayReason()).length() == 0 ? n5 : 0;
            n3 = n3 != 0 ? n2 : 0;
            object.setVisibility(n3);
            object = cy2.u;
            j.a(object, "separatorLineViewBottom");
            n3 = railwayLine.getDirectOperationDeparture() ? n4 : 0;
            object.setVisibility(n3);
        }
    }

    public final void C() {
        RailwayLine railwayLine;
        Object object = this.s.j();
        if (object == null) {
            j.a();
        }
        if ((railwayLine = this.s.k()) == null) {
            j.a();
        }
        j.a((Object)railwayLine, "binding.line!!");
        object = ((k)object).b(railwayLine);
        railwayLine = this.a;
        j.a((Object)railwayLine, "itemView");
        ((AppCompatImageView)railwayLine.findViewById(ak.a.delayWarningImage)).setImageDrawable((Drawable)object);
        object = this.s.k();
        if (object == null) {
            j.a();
        }
        boolean bl2 = ((RailwayLine)object).isDelayed();
        int n2 = 8;
        if (bl2) {
            object = this.a;
            j.a(object, "itemView");
            object = (ConstraintLayout)object.findViewById(ak.a.delayInfoLayout);
            j.a(object, "itemView.delayInfoLayout");
            object.setVisibility(0);
            object = this.a;
            j.a(object, "itemView");
            object = (TextView)object.findViewById(ak.a.delayReason);
            j.a(object, "itemView.delayReason");
            railwayLine = this.s.k();
            if (railwayLine == null) {
                j.a();
            }
            int n3 = ((CharSequence)railwayLine.getServiceStatus().getDelayReason()).length();
            int n4 = 1;
            n3 = n3 == 0 ? 1 : 0;
            n3 = n3 != 0 ? 8 : 0;
            object.setVisibility(n3);
            object = this.a;
            j.a(object, "itemView");
            object = (TextView)object.findViewById(ak.a.delayMinutes);
            j.a(object, "itemView.delayMinutes");
            railwayLine = this.s.k();
            if (railwayLine == null) {
                j.a();
            }
            n3 = ((CharSequence)railwayLine.getServiceStatus().getDelayMinute()).length() == 0 ? n4 : 0;
            n3 = n3 != 0 ? n2 : 0;
            object.setVisibility(n3);
            return;
        }
        object = this.a;
        j.a(object, "itemView");
        object = (ConstraintLayout)object.findViewById(ak.a.delayInfoLayout);
        j.a(object, "itemView.delayInfoLayout");
        object.setVisibility(8);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void D() {
        var2_1 = this.s.k();
        if (var2_1 == null) {
            j.a();
        }
        switch (var2_1.getFrom().getName().length()) {
            default: {
                var1_2 = 74;
                break;
            }
            case 2: {
                var1_2 = 83;
                break;
            }
            case 1: {
                var1_2 = 92;
            }
        }
        var1_2 = (int)((float)var1_2 * this.q + 0.5f);
        ** break;
lbl15: // 1 sources:
        var2_1 = this.s.k;
        j.a((Object)var2_1, "binding.departureName");
        var2_1 = var2_1.getLayoutParams();
        if (var2_1 == null) throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        var2_1 = (ViewGroup.MarginLayoutParams)var2_1;
        var2_1.setMargins(var1_2, var2_1.topMargin, var2_1.rightMargin, var2_1.bottomMargin);
        var3_3 = this.s.k;
        j.a((Object)var3_3, "binding.departureName");
        var3_3.setLayoutParams((ViewGroup.LayoutParams)var2_1);
    }

    public final cy E() {
        return this.s;
    }

    public final void a(e e2, a a2) {
        j.b(e2, "constraintSet");
        j.b(a2, "appCompatResourcesUtil");
        RailwayLine railwayLine = this.s.k();
        if (railwayLine == null) {
            j.a();
        }
        if (railwayLine.isWalking()) {
            e2 = this.s.o;
            j.a((Object)e2, "binding.lineBar");
            e2.setVisibility(8);
            e2 = this.s.t;
            j.a((Object)e2, "binding.lineWalkingBar");
            e2.setVisibility(0);
            return;
        }
        railwayLine = this.s.o;
        j.a((Object)railwayLine, "binding.lineBar");
        railwayLine.setVisibility(0);
        railwayLine = this.s.t;
        j.a((Object)railwayLine, "binding.lineWalkingBar");
        railwayLine.setVisibility(8);
        this.a(a2);
        this.a(e2);
    }
}

