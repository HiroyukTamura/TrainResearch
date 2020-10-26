/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package jp.co.jreast.jreastapp.commuter.skewscroll;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.dc;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.o.a;
import jp.co.jreast.jreastapp.commuter.skewscroll.h;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bJ\u0010\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\bH\u0016J\u0006\u0010!\u001a\u00020\u0010J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\bH\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006)"}, d2={"Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewModel;", "viewHeight", "", "routes", "Ljava/util/ArrayList;", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewModel;ILjava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "pixelForMinute", "", "getRoutes", "()Ljava/util/ArrayList;", "scale", "getViewHeight", "()I", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewModel;", "addAll", "", "newRoutes", "", "getDepatureDateTimeDiff", "dateTime", "Ljava/util/Calendar;", "getEarliestDepartureDateTime", "getItemCount", "getSlope", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class g
extends RecyclerView.a<RecyclerView.x> {
    private final float a;
    private float b;
    private final Context c;
    private final h d;
    private final int e;
    private final ArrayList<Route> f;

    public g(Context context, h h2, int n2, ArrayList<Route> arrayList) {
        j.b((Object)context, "context");
        j.b(h2, "viewModel");
        j.b(arrayList, "routes");
        this.c = context;
        this.d = h2;
        this.e = n2;
        this.f = arrayList;
        context = this.c.getResources();
        j.a((Object)context, "context.resources");
        this.a = context.getDisplayMetrics().density;
    }

    public /* synthetic */ g(Context context, h h2, int n2, ArrayList arrayList, int n3, kotlin.e.b.g g2) {
        if ((n3 & 8) != 0) {
            arrayList = new ArrayList<Route>();
        }
        this(context, h2, n2, arrayList);
    }

    private final Calendar e() {
        Calendar calendar = m.f(((Route)m.f((List)this.f)).getLines()).getFrom().dateTime();
        if (!this.f.isEmpty() && calendar != null) {
            return calendar;
        }
        calendar = Calendar.getInstance();
        j.a((Object)calendar, "Calendar.getInstance()");
        return calendar;
    }

    @Override
    public int a() {
        return ((Collection)this.f).size();
    }

    public final int a(Calendar calendar) {
        if (calendar == null) {
            return 0;
        }
        Calendar calendar2 = this.e();
        return (int)((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / (long)60000);
    }

    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        j.b(object, "parent");
        object = dc.a(LayoutInflater.from((Context)this.c), object, false);
        Context context = this.c;
        j.a(object, "binding");
        return new a(context, (dc)object);
    }

    @Override
    public void a(RecyclerView.x object, int n2) {
        j.b(object, "holder");
        Route route = this.f.get(n2);
        if (object instanceof a) {
            object = (a)object;
            ((a)object).A().a(this.d);
            ((a)object).A().a(route);
            ((a)object).b((int)(this.b * (float)route.getAccuracy().getMinutes()), (int)(this.b * (float)this.a(m.f(route.getLines()).getFrom().dateTime()) + this.d.f()));
            if (object.A().n != null) {
                object = object.A().n;
                j.a(object, "holder.binding.routeListItem");
                object.getLayoutParams().height = this.e;
            }
        }
    }

    @Override
    public final void a(List<Route> list) {
        j.b(list, "newRoutes");
        ArrayList<Route> arrayList = this.f;
        arrayList.clear();
        arrayList.addAll((Collection<Route>)list);
        if (((Collection)this.f).isEmpty() ^ true) {
            this.d.D();
            this.b = this.d.e();
            this.d.a(this.b);
        }
        this.c();
    }

    public final float d() {
        if (!this.f.isEmpty() && ((Collection)this.f).size() != 1) {
            return this.b * (float)this.a(m.f(((Route)m.h((List)this.f)).getLines()).getFrom().dateTime()) / ((float)84 * this.a * (float)(((Collection)this.f).size() - 1));
        }
        return 0.0f;
    }
}

