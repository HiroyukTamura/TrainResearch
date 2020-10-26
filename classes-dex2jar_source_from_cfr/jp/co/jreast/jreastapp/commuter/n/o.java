/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.da;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.n.k;
import jp.co.jreast.jreastapp.commuter.r.b;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailWalkingItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljp/co/jreast/jreastapp/commuter/util/Capturable;", "context", "Landroid/content/Context;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailWalkingItemBinding;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailWalkingItemBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailWalkingItemBinding;", "getContext", "()Landroid/content/Context;", "prepareCapture", "", "setStartMarginOfDepartureName", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class o
extends RecyclerView.x
implements b {
    private final Context q;
    private final da r;

    public o(Context context, da da2) {
        j.b((Object)context, "context");
        j.b(da2, "binding");
        super(da2.e());
        this.q = context;
        this.r = da2;
    }

    public static /* synthetic */ void a(o o2, e e2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            e2 = new e();
        }
        o2.a(e2);
    }

    public final da A() {
        return this.r;
    }

    @Override
    public void B() {
        k k2;
        RailwayLine railwayLine = this.r.k();
        if (railwayLine != null && (k2 = this.r.j()) != null) {
            da da2 = this.r;
            TextView textView = da2.e;
            j.a((Object)textView, "departureName");
            textView.setText((CharSequence)railwayLine.getFrom().getName());
            da2 = da2.c;
            j.a((Object)da2, "changeTime");
            j.a((Object)railwayLine, "line");
            da2.setText((CharSequence)k2.e(railwayLine));
        }
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
        var4_2 = this.r.k();
        if (var4_2 == null) {
            j.a();
        }
        switch (var4_2.getFrom().getName().length()) {
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
        var1_1.a(this.r.f);
        var4_2 = this.r.e;
        j.a(var4_2, "binding.departureName");
        var1_1.a(var4_2.getId(), 6, var3_4);
        var1_1.b(this.r.f);
    }
}

