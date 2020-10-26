/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.cq;
import jp.co.jreast.jreastapp.commuter.c.cs;
import jp.co.jreast.jreastapp.commuter.c.cu;
import jp.co.jreast.jreastapp.commuter.c.cw;
import jp.co.jreast.jreastapp.commuter.c.cy;
import jp.co.jreast.jreastapp.commuter.c.da;
import jp.co.jreast.jreastapp.commuter.common.s;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.n.a;
import jp.co.jreast.jreastapp.commuter.n.b;
import jp.co.jreast.jreastapp.commuter.n.c;
import jp.co.jreast.jreastapp.commuter.n.d;
import jp.co.jreast.jreastapp.commuter.n.i;
import jp.co.jreast.jreastapp.commuter.n.k;
import jp.co.jreast.jreastapp.commuter.n.n;
import jp.co.jreast.jreastapp.commuter.n.o;
import jp.co.jreast.jreastapp.commuter.r.h;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailViewModel;", "route", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailViewModel;Ljp/co/jreast/jreastapp/commuter/model/Route;)V", "getContext", "()Landroid/content/Context;", "getRoute", "()Ljp/co/jreast/jreastapp/commuter/model/Route;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailViewModel;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "viewChangeTime", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class j
extends RecyclerView.a<RecyclerView.x> {
    private final Context a;
    private final k b;
    private final Route c;

    public j(Context context, k k2, Route route) {
        kotlin.e.b.j.b((Object)context, "context");
        kotlin.e.b.j.b(k2, "viewModel");
        kotlin.e.b.j.b(route, "route");
        this.a = context;
        this.b = k2;
        this.c = route;
    }

    private final boolean c(int n2) {
        boolean bl2 = false;
        if (n2 == 0) {
            return false;
        }
        RailwayLine railwayLine = this.c.getLines().get(n2);
        RailwayLine railwayLine2 = this.c.getLines().get(n2 - 1);
        boolean bl3 = bl2;
        if (railwayLine.getChangeTime() != null) {
            bl3 = bl2;
            if (!railwayLine2.isWalking()) {
                bl3 = true;
            }
        }
        return bl3;
    }

    @Override
    public int a() {
        return ((Collection)this.c.getLines()).size() + 1;
    }

    @Override
    public int a(int n2) {
        n n3 = n2 < this.a() - 1 ? (this.c.getLines().get(n2).isWalking() ? (n2 != 0 && n2 != this.a() - 2 ? n.c : n.b) : (this.c.getLines().get(n2).getDirectOperationArrival() ? n.d : n.a)) : n.e;
        return n3.a();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        void var1_4;
        void var2_17;
        kotlin.e.b.j.b(object, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.a);
        if (var2_17 == n.a.a()) {
            Context context = this.a;
            cy cy2 = cy.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)cy2, "RouteDetailItemBinding.i\u2026(inflater, parent, false)");
            i i2 = new i(context, cy2);
            do {
                return (RecyclerView.x)var1_4;
                break;
            } while (true);
        }
        if (var2_17 == n.b.a()) {
            Context context = this.a;
            cy cy3 = cy.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)cy3, "RouteDetailItemBinding.i\u2026(inflater, parent, false)");
            i i3 = new i(context, cy3);
            return (RecyclerView.x)var1_4;
        }
        if (var2_17 == n.c.a()) {
            Context context = this.a;
            da da2 = da.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)da2, "RouteDetailWalkingItemBi\u2026(inflater, parent, false)");
            o o2 = new o(context, da2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_17 == n.d.a()) {
            Context context = this.a;
            cw cw2 = cw.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)cw2, "RouteDetailDirectItemBin\u2026(inflater, parent, false)");
            d d2 = new d(context, cw2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_17 == n.e.a()) {
            Context context = this.a;
            cq cq2 = cq.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)cq2, "RouteDetailBottomItemBin\u2026(inflater, parent, false)");
            a a2 = new a(context, cq2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_17 == h.a.a()) {
            Context context = this.a;
            cu cu2 = cu.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)cu2, "RouteDetailCaptureHeader\u2026(inflater, parent, false)");
            c c2 = new c(context, cu2, this.b.p());
            return (RecyclerView.x)var1_4;
        }
        if (var2_17 != h.b.a()) throw (Throwable)new Exception("RouteDetailViewType does not match");
        Context context = this.a;
        cs cs2 = cs.a(layoutInflater, object, false);
        kotlin.e.b.j.a((Object)cs2, "RouteDetailCaptureFooter\u2026(inflater, parent, false)");
        b b2 = new b(context, cs2);
        return (RecyclerView.x)var1_4;
    }

    @Override
    public void a(RecyclerView.x x2, int n2) {
        kotlin.e.b.j.b(x2, "holder");
        if (x2 instanceof i) {
            x2 = (i)x2;
            ((i)x2).E().a(this.b);
            ((i)x2).E().a(this.c.getLines().get(n2));
            ((i)x2).E().b(this.c(n2));
            ((i)x2).A();
            i.a((i)x2, null, null, 3, null);
            ((i)x2).C();
            ((i)x2).D();
            return;
        }
        if (x2 instanceof o) {
            x2 = (o)x2;
            ((o)x2).A().a(this.b);
            ((o)x2).A().a(this.c.getLines().get(n2));
            o.a((o)x2, null, 1, null);
            return;
        }
        if (x2 instanceof d) {
            x2 = (d)x2;
            ((d)x2).C().a(this.b);
            ((d)x2).C().a(this.c.getLines().get(n2));
            d.a((d)x2, null, 1, null);
            ((d)x2).a(this.c.getLines().get(n2 - 1).getColor());
            ((d)x2).A();
            d.b((d)x2, null, 1, null);
            return;
        }
        if (x2 instanceof a) {
            x2 = (a)x2;
            ((a)x2).C().a(this.b);
            ((a)x2).C().a(this.c);
            a.a((a)x2, null, 1, null);
            ((a)x2).A();
            return;
        }
        if (x2 instanceof c) {
            x2 = (c)x2;
            ((c)x2).A().a(this.c);
            ((c)x2).A().a(this.b);
            return;
        }
        throw (Throwable)new Exception("RecyclerView.ViewHolder does not match");
    }
}

