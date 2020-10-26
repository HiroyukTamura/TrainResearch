/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.candidatestation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.di;
import jp.co.jreast.jreastapp.commuter.candidatestation.c;
import jp.co.jreast.jreastapp.commuter.candidatestation.g;
import jp.co.jreast.jreastapp.commuter.model.Station;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2={"Ljp/co/jreast/jreastapp/commuter/candidatestation/CandidateStationListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/candidatestation/CandidateStationViewModel;", "stations", "Ljava/util/ArrayList;", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/candidatestation/CandidateStationViewModel;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/candidatestation/CandidateStationViewModel;", "addAll", "", "newStations", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends RecyclerView.a<RecyclerView.x> {
    private final Context a;
    private final c b;
    private final ArrayList<Station> c;

    public b(Context context, c c2, ArrayList<Station> arrayList) {
        j.b((Object)context, "context");
        j.b(c2, "viewModel");
        j.b(arrayList, "stations");
        this.a = context;
        this.b = c2;
        this.c = arrayList;
    }

    public /* synthetic */ b(Context context, c c2, ArrayList arrayList, int n2, kotlin.e.b.g g2) {
        if ((n2 & 4) != 0) {
            arrayList = new ArrayList<Station>();
        }
        this(context, c2, arrayList);
    }

    @Override
    public int a() {
        return ((Collection)this.c).size();
    }

    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        j.b(object, "parent");
        object = di.a(LayoutInflater.from((Context)this.a), object, false);
        j.a(object, "binding");
        return new g((di)object);
    }

    @Override
    public void a(RecyclerView.x object, int n2) {
        j.b(object, "holder");
        Object object2 = this.c.get(n2);
        if (object instanceof g) {
            object = (g)object;
            ((g)object).A().a(this.b);
            ((g)object).A().a((Station)object2);
            object2 = this.b.g().a();
            if (object2 == null) {
                j.a();
            }
            j.a(object2, "viewModel.closeButtonVisibility.value!!");
            if (((Boolean)object2).booleanValue()) {
                object2 = object.A().c;
                j.a(object2, "holder.binding.closeButton");
                object2.setVisibility(0);
                object = object.A().e;
                j.a(object, "holder.binding.stationListItem");
                object.setEnabled(false);
                return;
            }
            object2 = object.A().c;
            j.a(object2, "holder.binding.closeButton");
            object2.setVisibility(8);
            object = object.A().e;
            j.a(object, "holder.binding.stationListItem");
            object.setEnabled(true);
        }
    }

    @Override
    public final void a(List<Station> list) {
        j.b(list, "newStations");
        ArrayList<Station> arrayList = this.c;
        arrayList.clear();
        arrayList.addAll((Collection<Station>)list);
        this.c();
    }
}

