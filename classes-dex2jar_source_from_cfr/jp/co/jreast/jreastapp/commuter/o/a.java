/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
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
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.ak;
import jp.co.jreast.jreastapp.commuter.c.dc;
import jp.co.jreast.jreastapp.commuter.common.g;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.o.b;
import jp.co.jreast.jreastapp.commuter.skewscroll.h;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010 \u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016H\u0002J\u0016\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fJ \u0010'\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016H\u0002J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020)H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2={"Ljp/co/jreast/jreastapp/commuter/routesearchresults/RouteListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/RouteListItemBinding;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/databinding/RouteListItemBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/RouteListItemBinding;", "getContext", "()Landroid/content/Context;", "lineBarHeight", "", "lineBarMinHeight", "scale", "", "setDirectLine", "", "departureColorCode", "", "arrivalColorCode", "directView", "Landroid/view/View;", "setLineBar", "railWayLine", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "lineBar", "isDirect", "", "setLineIcon", "lineIconView", "Landroidx/appcompat/widget/AppCompatImageView;", "setRailwayLine", "lineViewType", "Ljp/co/jreast/jreastapp/commuter/common/LineViewType;", "railWayLineView", "setRailwayLineView", "railWayLineViewHeight", "topMargin", "setWalkingLine", "setWalkingLineBar", "Landroid/view/ViewGroup;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends RecyclerView.x {
    private final float q;
    private final int r;
    private int s;
    private final Context t;
    private final dc u;

    public a(Context context, dc dc2) {
        j.b((Object)context, "context");
        j.b(dc2, "binding");
        super(dc2.e());
        this.t = context;
        this.u = dc2;
        context = this.t.getResources();
        j.a((Object)context, "context.resources");
        this.q = context.getDisplayMetrics().density;
        this.r = (int)((float)2 * this.q + 0.5f);
    }

    private final void a(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.t);
        int n2 = this.s / (int)((float)20 * this.q + 0.5f);
        int n3 = 1;
        if (1 <= n2) {
            do {
                layoutInflater.inflate(2131427461, viewGroup);
                if (n3 == n2) break;
                ++n3;
            } while (true);
        }
    }

    private final void a(String string2, String string3, View view) {
        int n2 = Color.parseColor((String)string2);
        string2 = view.findViewById(ak.a.directLineBarTop);
        j.a((Object)string2, "directView.directLineBarTop");
        string2.getBackground().mutate().setColorFilter(n2, PorterDuff.Mode.SRC_IN);
        n2 = Color.parseColor((String)string3);
        string2 = view.findViewById(ak.a.directLineBarBottom);
        j.a((Object)string2, "directView.directLineBarBottom");
        string2.getBackground().mutate().setColorFilter(n2, PorterDuff.Mode.SRC_IN);
    }

    private final void a(RailwayLine railwayLine, View view, boolean bl2) {
        int n2 = Color.parseColor((String)railwayLine.getColor());
        if (bl2) {
            view.setBackground((Drawable)null);
            view.setBackgroundTintList((ColorStateList)null);
            view.setBackgroundColor(n2);
            return;
        }
        view.getBackground().mutate().setColorFilter(n2, PorterDuff.Mode.SRC_IN);
    }

    private final void a(RailwayLine railwayLine, AppCompatImageView appCompatImageView) {
        h h2 = this.u.j();
        if (h2 == null) {
            j.a();
        }
        appCompatImageView.setImageDrawable(h2.a(railwayLine));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final void a(RailwayLine var1_1, g var2_2, View var3_3) {
        block15 : {
            block16 : {
                var4_5 = (TextView)var3_4.findViewById(ak.a.transferName);
                var5_6 = var3_4.findViewById(ak.a.lineBarTop);
                var6_7 = var3_4.findViewById(ak.a.lineBarBottom);
                if (this.s == 0 || !var1_1.getDirectOperationDeparture() && !var1_1.getDirectOperationArrival() && this.s <= this.r) {
                    j.a((Object)var5_6, "lineBarTop");
                    var5_6.setVisibility(8);
                    j.a((Object)var6_7, "lineBarBottom");
                    var6_7.setVisibility(8);
                } else {
                    j.a((Object)var5_6, "lineBarTop");
                    var5_6.getLayoutParams().height = this.s;
                    j.a((Object)var6_7, "lineBarBottom");
                    var6_7.getLayoutParams().height = this.s;
                }
                switch (b.a[var2_2.ordinal()]) {
                    default: {
                        break block15;
                    }
                    case 4: {
                        j.a((Object)var4_5, "transferName");
                        var4_5.setVisibility(4);
                        var4_5.getLayoutParams().height = (int)((float)24 * this.q + 0.5f);
                        a.a(this, (RailwayLine)var1_1, var5_6, false, 4, null);
                        a.a(this, (RailwayLine)var1_1, var6_7, false, 4, null);
                        break block15;
                    }
                    case 3: {
                        if (var1_1.getDirectOperationArrival()) {
                            j.a((Object)var4_5, "transferName");
                            var4_5.setVisibility(8);
                        } else {
                            j.a((Object)var4_5, "transferName");
                            var4_5.setText((CharSequence)var1_1.getFrom().getName());
                        }
                        this.a((RailwayLine)var1_1, var5_6, var1_1.getDirectOperationArrival());
                        ** GOTO lbl45
                    }
                    case 2: {
                        if (var1_1.getDirectOperationArrival()) {
                            j.a((Object)var4_5, "transferName");
                            var4_5.setVisibility(8);
                        } else {
                            j.a((Object)var4_5, "transferName");
                            var4_5.setText((CharSequence)var1_1.getFrom().getName());
                        }
                        if (var1_1.getDirectOperationDeparture() && !var1_1.getDirectOperationArrival()) {
                            var5_6.setVisibility(8);
                        } else {
                            this.a((RailwayLine)var1_1, var5_6, var1_1.getDirectOperationArrival());
                        }
                        if (var1_1.getDirectOperationDeparture() || !var1_1.getDirectOperationArrival()) break block16;
lbl45: // 2 sources:
                        var6_7.setVisibility(8);
                        break block15;
                    }
                    case 1: 
                }
                j.a((Object)var4_5, "transferName");
                var4_5.setVisibility(4);
                var4_5.getLayoutParams().height = (int)((float)24 * this.q + 0.5f);
                var5_6.setVisibility(8);
            }
            this.a((RailwayLine)var1_1, var6_7, var1_1.getDirectOperationDeparture());
        }
        var2_3 = (AppCompatImageView)var3_4.findViewById(ak.a.lineIconImageView);
        j.a((Object)var2_3, "railWayLineView.lineIconImageView");
        this.a((RailwayLine)var1_1, var2_3);
        if (var1_1.isDelayed()) {
            var1_1 = (AppCompatImageView)var3_4.findViewById(ak.a.delayIconImageView);
            j.a(var1_1, "railWayLineView.delayIconImageView");
            var1_1.setVisibility(0);
            return;
        }
        var1_1 = (AppCompatImageView)var3_4.findViewById(ak.a.delayIconImageView);
        j.a(var1_1, "railWayLineView.delayIconImageView");
        var1_1.setVisibility(4);
    }

    static /* bridge */ /* synthetic */ void a(a a2, RailwayLine railwayLine, View view, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        a2.a(railwayLine, view, bl2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final void b(RailwayLine var1_1, g var2_2, View var3_3) {
        block8 : {
            var4_4 = (TextView)var3_3.findViewById(ak.a.transferName);
            var5_5 = var3_3.findViewById(ak.a.lineBarTop);
            if (var5_5 == null) throw new t("null cannot be cast to non-null type android.view.ViewGroup");
            var5_5 = (ViewGroup)var5_5;
            if ((var3_3 = var3_3.findViewById(ak.a.lineBarBottom)) == null) throw new t("null cannot be cast to non-null type android.view.ViewGroup");
            var3_3 = (ViewGroup)var3_3;
            if (this.s == 0) {
                var5_5.setVisibility(8);
                var3_3.setVisibility(8);
            } else {
                var5_5.getLayoutParams().height = this.s;
                var3_3.getLayoutParams().height = this.s;
            }
            switch (b.b[var2_2.ordinal()]) {
                default: {
                    return;
                }
                case 4: {
                    j.a((Object)var4_4, "transferName");
                    var4_4.setVisibility(4);
                    ** GOTO lbl29
                }
                case 3: {
                    j.a((Object)var4_4, "transferName");
                    var4_4.setText((CharSequence)var1_1.getFrom().getName());
                    this.a((ViewGroup)var5_5);
                    var3_3.setVisibility(8);
                    return;
                }
                case 2: {
                    j.a((Object)var4_4, "transferName");
                    var4_4.setText((CharSequence)var1_1.getFrom().getName());
lbl29: // 2 sources:
                    this.a((ViewGroup)var5_5);
                    break block8;
                }
                case 1: 
            }
            j.a((Object)var4_4, "transferName");
            var4_4.setVisibility(4);
            var5_5.setVisibility(8);
        }
        this.a((ViewGroup)var3_3);
    }

    public final dc A() {
        return this.u;
    }

    public final void b(int n2, int n3) {
        Object object = this.a;
        j.a(object, "itemView");
        object = (ConstraintLayout)object.findViewById(ak.a.routeListItem);
        j.a(object, "itemView.routeListItem");
        object = object.getLayoutParams();
        if (object != null) {
            object = (ViewGroup.MarginLayoutParams)object;
            int n4 = 0;
            object.setMargins(0, n3, 0, 0);
            object = new jp.co.jreast.jreastapp.commuter.skewscroll.b();
            float f2 = this.q;
            Route route = this.u.k();
            if (route == null) {
                j.a();
            }
            this.s = object.a(f2, n2, route.getLines());
            LayoutInflater layoutInflater = LayoutInflater.from((Context)this.t);
            object = this.u.k();
            if (object == null) {
                j.a();
            }
            int n5 = ((Collection)object.getLines()).size();
            object = this.a;
            j.a(object, "itemView");
            ((LinearLayout)object.findViewById(ak.a.railwayLinesView)).removeAllViews();
            object = this.u.k();
            if (object == null) {
                j.a();
            }
            Iterator iterator = ((Iterable)object.getLines()).iterator();
            n3 = 0;
            while (iterator.hasNext()) {
                RailwayLine railwayLine = (RailwayLine)iterator.next();
                if (n3 == 0) {
                    object = n5 == 1 ? g.d : g.a;
                } else {
                    object = this.u.k();
                    if (object == null) {
                        j.a();
                    }
                    object = n3 < ((Collection)object.getLines()).size() - 1 ? g.b : g.c;
                }
                if (railwayLine.isWalking()) {
                    route = layoutInflater.inflate(2131427462, null);
                    j.a((Object)route, "inflater.inflate(R.layout.walkingline_view, null)");
                    this.b(railwayLine, (g)((Object)object), (View)route);
                    object = route;
                } else {
                    Object object2;
                    route = layoutInflater.inflate(2131427441, null);
                    j.a((Object)route, "inflater.inflate(R.layout.railwayline_view, null)");
                    if (railwayLine.getDirectOperationArrival()) {
                        object2 = (FrameLayout)route.findViewById(ak.a.directView);
                        j.a(object2, "railWayLineView.directView");
                        object2.setVisibility(0);
                        object2 = this.u.k();
                        if (object2 == null) {
                            j.a();
                        }
                        object2 = ((Route)object2).getLines().get(n3 - 1).getColor();
                        String string2 = railwayLine.getColor();
                        FrameLayout frameLayout = (FrameLayout)route.findViewById(ak.a.directView);
                        j.a((Object)frameLayout, "railWayLineView.directView");
                        this.a((String)object2, string2, (View)frameLayout);
                    } else {
                        object2 = (FrameLayout)route.findViewById(ak.a.directView);
                        j.a(object2, "railWayLineView.directView");
                        object2.setVisibility(8);
                    }
                    this.a(railwayLine, (g)((Object)object), (View)route);
                    object = route;
                }
                route = this.a;
                j.a((Object)route, "itemView");
                ((LinearLayout)route.findViewById(ak.a.railwayLinesView)).addView(object);
                object = this.a;
                j.a(object, "itemView");
                object = (LinearLayout)object.findViewById(ak.a.railwayLinesView);
                j.a(object, "itemView.railwayLinesView");
                object = object.getLayoutParams();
                f2 = 30;
                route = this.t.getResources();
                j.a((Object)route, "context.resources");
                int n6 = (int)(f2 * route.getDisplayMetrics().density);
                if (n2 >= n6) {
                    n6 = n2;
                }
                object.height = n6;
                route = this.a;
                j.a((Object)route, "itemView");
                route = (LinearLayout)route.findViewById(ak.a.railwayLinesView);
                j.a((Object)route, "itemView.railwayLinesView");
                route.setLayoutParams((ViewGroup.LayoutParams)object);
                ++n3;
            }
            object = this.a;
            j.a(object, "itemView");
            object = (ConstraintLayout)object.findViewById(ak.a.norikaeCount);
            j.a(object, "itemView.norikaeCount");
            f2 = n2;
            float f3 = 84;
            route = this.t.getResources();
            j.a((Object)route, "context.resources");
            n2 = n4;
            if (f2 <= f3 * route.getDisplayMetrics().density) {
                n2 = 4;
            }
            object.setVisibility(n2);
            return;
        }
        throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}

