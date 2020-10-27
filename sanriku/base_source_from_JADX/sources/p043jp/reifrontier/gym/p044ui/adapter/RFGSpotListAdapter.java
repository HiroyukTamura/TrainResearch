package p043jp.reifrontier.gym.p044ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012J\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSpotListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljp/reifrontier/gym/ui/adapter/RFGSpotListAdapter$Holder;", "()V", "onItemClicked", "Lkotlin/Function1;", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "Lkotlin/ParameterName;", "name", "spot", "", "getOnItemClicked", "()Lkotlin/jvm/functions/Function1;", "setOnItemClicked", "(Lkotlin/jvm/functions/Function1;)V", "spotList", "", "addData", "", "clearData", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGSpotListAdapter */
public final class RFGSpotListAdapter extends RecyclerView.Adapter<Holder> {
    private Function1<? super RFGSpot, Unit> onItemClicked;
    private final List<RFGSpot> spotList = new ArrayList();

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSpotListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dateView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "imageView", "Landroid/widget/ImageView;", "stationView", "titleView", "setData", "", "spot", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSpotListAdapter$Holder */
    public static final class Holder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final TextView dateView;
        private final ImageView imageView;
        private final TextView stationView;
        private final TextView titleView;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSpotListAdapter$Holder$Companion;", "", "()V", "newInstance", "Ljp/reifrontier/gym/ui/adapter/RFGSpotListAdapter$Holder;", "parent", "Landroid/view/ViewGroup;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSpotListAdapter$Holder$Companion */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Holder newInstance(ViewGroup viewGroup) {
                Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_sanriku_spot, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, Promotion.ACTION_VIEW);
                return new Holder(inflate);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Holder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.dateView = (TextView) view.findViewById(R.id.dateView);
            this.titleView = (TextView) view.findViewById(R.id.titleView);
            this.stationView = (TextView) view.findViewById(R.id.stationView);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x007e, code lost:
            if (r6 != null) goto L_0x0083;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setData(p043jp.reifrontier.gym.data.train.spot.RFGSpot r6) {
            /*
                r5 = this;
                java.lang.String r0 = "spot"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
                jp.reifrontier.gym.data.api.RFGRailroadClient$Companion r0 = p043jp.reifrontier.gym.data.api.RFGRailroadClient.Companion
                jp.reifrontier.gym.data.api.RFGRailroadClient r0 = r0.getINSTANCE()
                int r1 = r6.getId()
                java.lang.String r2 = "top.jpg"
                java.lang.String r0 = r0.getImageUrl(r1, r2)
                com.squareup.picasso.u r1 = com.squareup.picasso.C1513u.m2068b()
                com.squareup.picasso.y r0 = r1.mo27251b((java.lang.String) r0)
                android.widget.ImageView r1 = r5.imageView
                r2 = 0
                r0.mo27281a((android.widget.ImageView) r1, (com.squareup.picasso.C1489e) r2)
                android.widget.TextView r0 = r5.titleView
                java.lang.String r1 = "titleView"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                java.lang.String r1 = r6.getTitle()
                r0.setText(r1)
                android.widget.TextView r0 = r5.dateView
                java.lang.String r1 = "dateView"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                jp.reifrontier.gym.util.CalendarEx r1 = p043jp.reifrontier.gym.util.CalendarEx.INSTANCE
                int r2 = r6.getDate()
                java.util.Calendar r1 = r1.parse((int) r2)
                java.lang.String r2 = "yyyy/MM/dd"
                java.lang.String r1 = p043jp.reifrontier.gym.util.CaledarExKt.format(r1, r2)
                r0.setText(r1)
                android.widget.TextView r0 = r5.stationView
                java.lang.String r1 = "stationView"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                jp.reifrontier.gym.data.train.RFGTrainData r1 = p043jp.reifrontier.gym.data.train.RFGTrainData.INSTANCE
                int r6 = r6.getStationId()
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                jp.reifrontier.gym.data.train.RFGStation r6 = r1.findStation((java.lang.Integer) r6)
                if (r6 == 0) goto L_0x0081
                android.view.View r1 = r5.itemView
                java.lang.String r2 = "itemView"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                android.content.Context r1 = r1.getContext()
                r2 = 2131624383(0x7f0e01bf, float:1.8875944E38)
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r4 = 0
                java.lang.String r6 = r6.getName()
                r3[r4] = r6
                java.lang.String r6 = r1.getString(r2, r3)
                if (r6 == 0) goto L_0x0081
                goto L_0x0083
            L_0x0081:
                java.lang.String r6 = ""
            L_0x0083:
                r0.setText(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.p044ui.adapter.RFGSpotListAdapter.Holder.setData(jp.reifrontier.gym.data.train.spot.RFGSpot):void");
        }
    }

    public final void addData(List<RFGSpot> list) {
        Intrinsics.checkParameterIsNotNull(list, "spotList");
        this.spotList.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.spotList.clear();
    }

    public int getItemCount() {
        return this.spotList.size();
    }

    public final Function1<RFGSpot, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    public void onBindViewHolder(Holder holder, int i) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        RFGSpot rFGSpot = this.spotList.get(i);
        holder.setData(rFGSpot);
        holder.itemView.setOnClickListener(new RFGSpotListAdapter$onBindViewHolder$1(this, rFGSpot));
    }

    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return Holder.Companion.newInstance(viewGroup);
    }

    public final void setOnItemClicked(Function1<? super RFGSpot, Unit> function1) {
        this.onItemClicked = function1;
    }
}
