/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.cq;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.r.b;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailBottomItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljp/co/jreast/jreastapp/commuter/util/Capturable;", "context", "Landroid/content/Context;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailBottomItemBinding;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailBottomItemBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailBottomItemBinding;", "getContext", "()Landroid/content/Context;", "prepareCapture", "", "setStartMarginOfArrivalName", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "setVisibilityAmountTime", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends RecyclerView.x
implements b {
    private final Context q;
    private final cq r;

    public a(Context context, cq cq2) {
        j.b((Object)context, "context");
        j.b(cq2, "binding");
        super(cq2.e());
        this.q = context;
        this.r = cq2;
    }

    public static /* synthetic */ void a(a a2, e e2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            e2 = new e();
        }
        a2.a(e2);
    }

    public final void A() {
        Route route = this.r.j();
        if (route == null) {
            j.a();
        }
        if (j.a((Object)route.getAccuracy().getHour(), (Object)"0")) {
            route = this.r.h;
            j.a((Object)route, "binding.hoursOfAmountTime");
            route.setVisibility(8);
            route = this.r.i;
            j.a((Object)route, "binding.hoursUnitOfAmountTime");
            route.setVisibility(8);
        } else {
            route = this.r.h;
            j.a((Object)route, "binding.hoursOfAmountTime");
            route.setVisibility(0);
            route = this.r.i;
            j.a((Object)route, "binding.hoursUnitOfAmountTime");
            route.setVisibility(0);
        }
        route = this.r.j();
        if (route == null) {
            j.a();
        }
        if (j.a((Object)route.getAccuracy().getMin(), (Object)"0")) {
            route = this.r.j;
            j.a((Object)route, "binding.minutesOfAmountTime");
            route.setVisibility(8);
            route = this.r.k;
            j.a((Object)route, "binding.minutesUnitOfAmountTime");
            route.setVisibility(8);
            return;
        }
        route = this.r.j;
        j.a((Object)route, "binding.minutesOfAmountTime");
        route.setVisibility(0);
        route = this.r.k;
        j.a((Object)route, "binding.minutesUnitOfAmountTime");
        route.setVisibility(0);
    }

    @Override
    public void B() {
        Route route = this.r.j();
        if (route != null) {
            TextView textView = this.r.c;
            j.a((Object)textView, "binding.arrivalName");
            textView.setText((CharSequence)route.getLines().get(route.getLines().size() - 1).getTo().getName());
            route = this.r.n;
            j.a((Object)route, "binding.separatorLineViewTop");
            route.setVisibility(8);
            route = this.r.d;
            j.a((Object)route, "binding.bottomLayout");
            route.setVisibility(8);
        }
    }

    public final cq C() {
        return this.r;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(e var1_1) {
        j.b(var1_1, "constraintSet");
        var4_2 = this.q.getResources();
        j.a(var4_2, "context.resources");
        var2_3 = var4_2.getDisplayMetrics().density;
        var4_2 = this.r.j();
        if (var4_2 == null) {
            j.a();
        }
        switch (m.h(var4_2.getLines()).getTo().getName().length()) {
            default: {
                var3_4 = 74;
                break;
            }
            case 2: {
                var3_4 = 83;
                break;
            }
            case 1: {
                var3_4 = 92;
            }
        }
        var3_4 = (int)((float)var3_4 * var2_3 + 0.5f);
        ** break;
lbl19: // 1 sources:
        var1_1.a(this.r.g);
        var4_2 = this.r.c;
        j.a(var4_2, "binding.arrivalName");
        var1_1.a(var4_2.getId(), 6, var3_4);
        var1_1.b(this.r.g);
    }
}

