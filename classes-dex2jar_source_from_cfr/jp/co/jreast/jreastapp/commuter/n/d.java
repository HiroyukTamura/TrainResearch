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
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.ak;
import jp.co.jreast.jreastapp.commuter.c.cw;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import jp.co.jreast.jreastapp.commuter.n.k;
import jp.co.jreast.jreastapp.commuter.r.b;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailDirectArrivalItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljp/co/jreast/jreastapp/commuter/util/Capturable;", "context", "Landroid/content/Context;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailDirectItemBinding;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailDirectItemBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailDirectItemBinding;", "getContext", "()Landroid/content/Context;", "scale", "", "prepareCapture", "", "setDelayIcon", "setLineBar", "previousLineColor", "", "setLineIcon", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "setTopMarginOfSeparatorLine", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
extends RecyclerView.x
implements b {
    private float q;
    private final Context r;
    private final cw s;

    public d(Context context, cw cw2) {
        j.b((Object)context, "context");
        j.b(cw2, "binding");
        super(cw2.e());
        this.r = context;
        this.s = cw2;
        context = this.r.getResources();
        j.a((Object)context, "context.resources");
        this.q = context.getDisplayMetrics().density;
    }

    public static /* synthetic */ void a(d d2, e e2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            e2 = new e();
        }
        d2.a(e2);
    }

    public static /* synthetic */ void b(d d2, e e2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            e2 = new e();
        }
        d2.b(e2);
    }

    public final void A() {
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

    @Override
    public void B() {
        k k2;
        RailwayLine railwayLine = this.s.k();
        if (railwayLine != null && (k2 = this.s.j()) != null) {
            cw cw2 = this.s;
            AppCompatTextView appCompatTextView = cw2.s;
            j.a((Object)appCompatTextView, "toPlatformName");
            appCompatTextView.setText((CharSequence)railwayLine.getTo().platformNameWithSuffix());
            appCompatTextView = cw2.c;
            j.a((Object)appCompatTextView, "arrivalTime");
            appCompatTextView.setText((CharSequence)railwayLine.getTo().getAccuracy().fourDigitString());
            appCompatTextView = cw2.h;
            j.a((Object)appCompatTextView, "departureName");
            appCompatTextView.setText((CharSequence)railwayLine.getFrom().getName());
            appCompatTextView = cw2.j;
            j.a((Object)appCompatTextView, "lineBar");
            boolean bl2 = railwayLine.getDirectOperationDeparture();
            int n2 = 8;
            int n3 = 0;
            int n4 = bl2 ? 0 : 8;
            appCompatTextView.setVisibility(n4);
            appCompatTextView = cw2.q;
            j.a((Object)appCompatTextView, "lineName");
            appCompatTextView.setText((CharSequence)railwayLine.getName());
            appCompatTextView = cw2.q;
            j.a((Object)appCompatTextView, "lineName");
            n4 = railwayLine.isWalking() ? 4 : 0;
            appCompatTextView.setVisibility(n4);
            appCompatTextView = cw2.p;
            j.a((Object)appCompatTextView, "lineKind");
            appCompatTextView.setText((CharSequence)railwayLine.getKindAndBoundFor());
            appCompatTextView = cw2.p;
            j.a((Object)appCompatTextView, "lineKind");
            n4 = ((CharSequence)railwayLine.getKindAndBoundFor()).length();
            int n5 = 1;
            n4 = n4 == 0 ? 1 : 0;
            n4 = n4 != 0 ? 8 : 0;
            appCompatTextView.setVisibility(n4);
            appCompatTextView = cw2.e;
            j.a((Object)appCompatTextView, "delayMinutes");
            j.a((Object)railwayLine, "line");
            appCompatTextView.setText((CharSequence)k2.d(railwayLine));
            k2 = cw2.e;
            j.a((Object)k2, "delayMinutes");
            n4 = ((CharSequence)railwayLine.getServiceStatus().getDelayMinute()).length() == 0 ? 1 : 0;
            n4 = n4 != 0 ? 8 : 0;
            k2.setVisibility(n4);
            k2 = cw2.f;
            j.a((Object)k2, "delayReason");
            k2.setText((CharSequence)railwayLine.getServiceStatus().getDelayReason());
            k2 = cw2.f;
            j.a((Object)k2, "delayReason");
            n4 = ((CharSequence)railwayLine.getServiceStatus().getDelayReason()).length() == 0 ? n5 : 0;
            n4 = n4 != 0 ? n2 : 0;
            k2.setVisibility(n4);
            cw2 = cw2.r;
            j.a((Object)cw2, "separatorLineViewBottom");
            n4 = n3;
            if (railwayLine.getDirectOperationDeparture()) {
                n4 = 4;
            }
            cw2.setVisibility(n4);
        }
    }

    public final cw C() {
        return this.s;
    }

    public final void a(e e2) {
        int n2;
        RailwayLine railwayLine;
        j.b(e2, "constraintSet");
        Object object = this.s.j();
        if (object == null) {
            j.a();
        }
        if ((railwayLine = this.s.k()) == null) {
            j.a();
        }
        j.a((Object)railwayLine, "binding.line!!");
        object = ((k)object).a(railwayLine);
        railwayLine = this.a;
        j.a((Object)railwayLine, "itemView");
        ((AppCompatImageView)railwayLine.findViewById(ak.a.lineIconImageView)).setImageDrawable((Drawable)object);
        object = this.a;
        j.a(object, "itemView");
        e2.a((ConstraintLayout)object.findViewById(ak.a.generalInformation));
        object = this.s.k();
        if (object == null) {
            j.a();
        }
        if (((RailwayLine)object).getDirectOperationDeparture()) {
            object = this.a;
            j.a(object, "itemView");
            object = (AppCompatImageView)object.findViewById(ak.a.lineIconImageView);
            j.a(object, "itemView.lineIconImageView");
            n2 = object.getId();
            object = this.a;
            j.a(object, "itemView");
            object = (AppCompatImageView)object.findViewById(ak.a.lineBarDirectArrivalTop);
            j.a(object, "itemView.lineBarDirectArrivalTop");
            e2.a(n2, 3, object.getId(), 4, 0);
            n2 = 0;
        } else {
            object = this.a;
            j.a(object, "itemView");
            object = (AppCompatImageView)object.findViewById(ak.a.lineIconImageView);
            j.a(object, "itemView.lineIconImageView");
            e2.a(object.getId(), 3);
            n2 = (int)((float)24 * this.q + 0.5f);
        }
        object = this.a;
        j.a(object, "itemView");
        object = (AppCompatImageView)object.findViewById(ak.a.lineIconImageView);
        j.a(object, "itemView.lineIconImageView");
        e2.a(object.getId(), 4, n2);
        object = this.a;
        j.a(object, "itemView");
        e2.b((ConstraintLayout)object.findViewById(ak.a.generalInformation));
    }

    public final void a(String object) {
        j.b(object, "previousLineColor");
        int n2 = Color.parseColor((String)object);
        object = this.a;
        j.a(object, "itemView");
        object = (AppCompatImageView)object.findViewById(ak.a.lineBarDirecteDeparture);
        j.a(object, "itemView.lineBarDirecteDeparture");
        object.getDrawable().mutate().setColorFilter(n2, PorterDuff.Mode.SRC_IN);
        object = this.s.k();
        if (object == null) {
            j.a();
        }
        if ((n2 = ((CharSequence)(object = ((RailwayLine)object).getColor())).length() == 0 ? 1 : 0) == 0) {
            n2 = Color.parseColor((String)object);
            object = this.a;
            j.a(object, "itemView");
            object.findViewById(ak.a.lineBar).setBackgroundColor(n2);
            object = this.a;
            j.a(object, "itemView");
            object = (AppCompatImageView)object.findViewById(ak.a.lineBarDirectArrivalTop);
            j.a(object, "itemView.lineBarDirectArrivalTop");
            object.getDrawable().mutate().setColorFilter(n2, PorterDuff.Mode.SRC_IN);
            object = this.a;
            j.a(object, "itemView");
            object.findViewById(ak.a.lineBarDirectArrival).setBackgroundColor(n2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void b(e e2) {
        j.b(e2, "constraintSet");
        Object object = this.a;
        j.a(object, "itemView");
        e2.a((ConstraintLayout)object.findViewById(ak.a.generalInformation));
        object = this.s.k();
        if (object == null) {
            j.a();
        }
        int n2 = ((RailwayLine)object).getDirectOperationDeparture() ? 23 : 55;
        n2 = (int)((float)n2 * this.q + 0.5f);
        object = this.a;
        j.a(object, "itemView");
        object = object.findViewById(ak.a.separatorLineViewBottom);
        j.a(object, "itemView.separatorLineViewBottom");
        e2.a(object.getId(), 3, n2);
        object = this.a;
        j.a(object, "itemView");
        e2.b((ConstraintLayout)object.findViewById(ak.a.generalInformation));
    }
}

