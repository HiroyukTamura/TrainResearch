/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.bq;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.c;
import jp.co.jreast.jreastapp.commuter.trainlocation.d;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0014\u0010\u001d\u001a\u00020\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineViewModel;", "railways", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineViewModel;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getRailways", "()Ljava/util/List;", "setRailways", "(Ljava/util/List;)V", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineViewModel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setRailwayLineList", "newRailways", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends RecyclerView.a<RecyclerView.x> {
    private final Context a;
    private final d b;
    private List<RailwayLineInformation> c;

    public b(Context context, d d2, List<RailwayLineInformation> list) {
        j.b((Object)context, "context");
        j.b(d2, "viewModel");
        j.b(list, "railways");
        this.a = context;
        this.b = d2;
        this.c = list;
    }

    public /* synthetic */ b(Context context, d d2, List list, int n2, g g2) {
        if ((n2 & 4) != 0) {
            list = new ArrayList();
        }
        this(context, d2, list);
    }

    @Override
    public int a() {
        return ((Collection)this.c).size();
    }

    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        j.b(object, "parent");
        object = bq.a(LayoutInflater.from((Context)this.a), object, false);
        j.a(object, "binding");
        return new c((bq)object);
    }

    @Override
    public void a(RecyclerView.x x2, int n2) {
        j.b(x2, "holder");
        if (x2 instanceof c) {
            x2 = (c)x2;
            ((c)x2).A().a(this.b);
            ((c)x2).A().a(this.c.get(n2));
        }
    }

    @Override
    public final void a(List<RailwayLineInformation> list) {
        j.b(list, "newRailways");
        List<RailwayLineInformation> list2 = this.c;
        list2.clear();
        list2.addAll((Collection<RailwayLineInformation>)list);
    }
}

