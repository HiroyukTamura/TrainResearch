package p043jp.reifrontier.gym.p044ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.app.RFGAdapterSummary;
import p043jp.reifrontier.gym.p044ui.adapter.RFGActivityAdapter;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGDayAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljp/reifrontier/gym/ui/adapter/RFGDayAdapter$ViewHolder;", "onTodayListener", "Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$OnTodayListener;", "(Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$OnTodayListener;)V", "days", "", "Ljp/reifrontier/gym/domain/app/RFGAdapterSummary;", "todayListener", "addItems", "", "list", "", "clear", "data", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGDayAdapter */
public final class RFGDayAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<RFGAdapterSummary> days = new ArrayList();
    private final RFGActivityAdapter.OnTodayListener todayListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGDayAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "snapRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getSnapRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setSnapRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Factory", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGDayAdapter$ViewHolder */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
        private RecyclerView snapRecyclerView;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGDayAdapter$ViewHolder$Factory;", "", "()V", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.ui.adapter.RFGDayAdapter$ViewHolder$Factory */
        public static final class Factory {
            private Factory() {
            }

            public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.actRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.actRecyclerView)");
            this.snapRecyclerView = (RecyclerView) findViewById;
        }

        public final RecyclerView getSnapRecyclerView() {
            return this.snapRecyclerView;
        }

        public final void setSnapRecyclerView(RecyclerView recyclerView) {
            Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
            this.snapRecyclerView = recyclerView;
        }
    }

    public RFGDayAdapter(RFGActivityAdapter.OnTodayListener onTodayListener) {
        Intrinsics.checkParameterIsNotNull(onTodayListener, "onTodayListener");
        this.todayListener = onTodayListener;
    }

    public final void addItems(List<RFGAdapterSummary> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.days.addAll(list);
    }

    public final void clear() {
        this.days.clear();
    }

    public final List<RFGAdapterSummary> data() {
        return this.days;
    }

    public int getItemCount() {
        return this.days.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        RFGAdapterSummary rFGAdapterSummary = this.days.get(i);
        if (rFGAdapterSummary.getList().isEmpty()) {
            viewHolder.getSnapRecyclerView().setLayoutManager(new LinearLayoutManager(viewHolder.getSnapRecyclerView().getContext(), 0, false));
            recyclerView = viewHolder.getSnapRecyclerView();
            adapter = new RFGSummaryAdapter(CollectionsKt__CollectionsJVMKt.listOf(rFGAdapterSummary));
        } else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(viewHolder.getSnapRecyclerView().getContext(), 2);
            viewHolder.getSnapRecyclerView().setHasFixedSize(true);
            viewHolder.getSnapRecyclerView().setLayoutManager(gridLayoutManager);
            recyclerView = viewHolder.getSnapRecyclerView();
            adapter = new RFGActivityAdapter(rFGAdapterSummary.getList(), this.todayListener);
        }
        recyclerView.setAdapter(adapter);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_activity, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…_activity, parent, false)");
        return new ViewHolder(inflate);
    }
}
