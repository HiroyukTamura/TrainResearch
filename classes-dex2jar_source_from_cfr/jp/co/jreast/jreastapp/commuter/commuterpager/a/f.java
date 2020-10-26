/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.a;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import jp.co.jreast.jreastapp.commuter.c.ae;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.c;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.e;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.g;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.i;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u001a\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!J\u0006\u0010$\u001a\u00020\u001fJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0016J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010*\u001a\u00020&H\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u0010'\u001a\u00020&H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u00060"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewModel;", "route", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "notifyUtil", "Ljp/co/jreast/jreastapp/commuter/util/NotifyUtil;", "lineIconPositionProvider", "Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailLineIconPositionProvider;", "postDelayedInterval", "", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewModel;Ljp/co/jreast/jreastapp/commuter/model/Route;Ljp/co/jreast/jreastapp/commuter/util/NotifyUtil;Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailLineIconPositionProvider;J)V", "getContext", "()Landroid/content/Context;", "delayAnimated", "", "getDelayAnimated", "()Z", "setDelayAnimated", "(Z)V", "getLineIconPositionProvider", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailLineIconPositionProvider;", "getRoute", "()Ljp/co/jreast/jreastapp/commuter/model/Route;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewModel;", "add", "", "serviceStatusMap", "", "", "Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "clearServiceStatus", "getHeight", "", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f
extends RecyclerView.a<RecyclerView.x> {
    private boolean a;
    private final Context b;
    private final g c;
    private final Route d;
    private final jp.co.jreast.jreastapp.commuter.r.f e;
    private final e f;
    private final long g;

    public f(Context context, g g2, Route route, jp.co.jreast.jreastapp.commuter.r.f f2, e e2, long l2) {
        j.b((Object)context, "context");
        j.b(g2, "viewModel");
        j.b(route, "route");
        j.b(f2, "notifyUtil");
        j.b(e2, "lineIconPositionProvider");
        this.b = context;
        this.c = g2;
        this.d = route;
        this.e = f2;
        this.f = e2;
        this.g = l2;
    }

    public /* synthetic */ f(Context context, g g2, Route route, jp.co.jreast.jreastapp.commuter.r.f f2, e e2, long l2, int n2, kotlin.e.b.g g3) {
        if ((n2 & 8) != 0) {
            f2 = new jp.co.jreast.jreastapp.commuter.r.f();
        }
        if ((n2 & 16) != 0) {
            e2 = new e();
        }
        if ((n2 & 32) != 0) {
            l2 = 1000L;
        }
        this(context, g2, route, f2, e2, l2);
    }

    private final int c(int n2) {
        if (n2 == i.b.a()) {
            return 0;
        }
        switch (((Collection)this.d.getLines()).size()) {
            default: {
                return 64;
            }
            case 2: {
                return 97;
            }
            case 1: 
        }
        return 244;
    }

    @Override
    public int a() {
        return ((Collection)this.d.getLines()).size() + 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int a(int n2) {
        i i2;
        if (n2 < this.a() - 1) {
            i2 = i.a;
            do {
                return i2.a();
                break;
            } while (true);
        }
        i2 = i.b;
        return i2.a();
    }

    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        j.b(object, "parent");
        i[] arri = LayoutInflater.from((Context)this.b);
        if (n2 == i.a.a() || n2 == i.b.a()) {
            Context context = this.b;
            object = ae.a((LayoutInflater)arri, object, false);
            j.a(object, "FavoriteRouteDetailItemB\u2026(inflater, parent, false)");
            for (i i2 : i.values()) {
                boolean bl2 = i2.a() == n2;
                if (!bl2) continue;
                return new c(context, (ae)object, i2, this.c(n2));
            }
            throw (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
        }
        throw (Throwable)new Exception("FavoriteRouteDetailViewType does not match");
    }

    @Override
    public void a(RecyclerView.x object, int n2) {
        j.b(object, "holder");
        if (object instanceof c) {
            c c2 = (c)object;
            c2.E().a(this.c);
            if (c2.F().equals((Object)i.b)) {
                c2.E().a(this.d.getLines().get(n2 - 1));
            } else {
                RailwayLine railwayLine = this.d.getLines().get(n2);
                jp.co.jreast.jreastapp.commuter.common.f f2 = this.f.a(n2, this.d);
                c2.E().a(railwayLine);
                object = null;
                c.a(c2, f2, null, 2, null);
                if (railwayLine.getDirectOperationArrival()) {
                    object = this.d.getLines().get(n2 - 1).getColor();
                }
                c.a(c2, f2, (String)object, null, null, 12, null);
                c2.C();
                if (!this.a) {
                    c2.D();
                    new Handler().postDelayed(new Runnable(){

                        @Override
                        public final void run() {
                            this.a(true);
                        }
                    }, this.g);
                }
            }
            c2.A();
            c2.B();
            return;
        }
        throw (Throwable)new Exception("RecyclerView.ViewHolder does not match");
    }

    @Override
    public final void a(Map<String, ServiceStatus> map) {
        j.b(map, "serviceStatusMap");
        this.a = false;
        for (RailwayLine railwayLine : (Iterable)this.d.getLines()) {
            if (railwayLine.isNormalPaidExpress() || map.get(railwayLine.getJrId()) == null) continue;
            ServiceStatus serviceStatus = map.get(railwayLine.getJrId());
            if (serviceStatus == null) {
                j.a();
            }
            railwayLine.setServiceStatus(serviceStatus);
        }
        this.e.a(this);
    }

    @Override
    public final void a(boolean bl2) {
        this.a = bl2;
    }

    public final void d() {
        Iterator iterator = ((Iterable)this.d.getLines()).iterator();
        while (iterator.hasNext()) {
            ((RailwayLine)iterator.next()).getServiceStatus().clearStatus();
        }
        this.e.a(this);
    }

}

