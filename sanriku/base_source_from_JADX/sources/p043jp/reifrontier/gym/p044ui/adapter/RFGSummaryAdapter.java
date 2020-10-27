package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.api.RFGSummaryHistory;
import p043jp.reifrontier.gym.domain.app.RFGAdapterSummary;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSummaryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljp/reifrontier/gym/ui/adapter/RFGSummaryAdapter$ViewHolder;", "data", "", "Ljp/reifrontier/gym/domain/app/RFGAdapterSummary;", "(Ljava/util/List;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGSummaryAdapter */
public final class RFGSummaryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private final List<RFGAdapterSummary> mData;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSummaryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Ljp/reifrontier/gym/ui/adapter/RFGSummaryAdapter;Landroid/view/View;)V", "mDist", "Landroid/widget/TextView;", "getMDist", "()Landroid/widget/TextView;", "mMets", "getMMets", "mOtPoint", "getMOtPoint", "mPoint", "getMPoint", "mPoints", "getMPoints", "mStep", "getMStep", "mTitle", "getMTitle", "mTrainPoint", "getMTrainPoint", "mWlkPoint", "getMWlkPoint", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSummaryAdapter$ViewHolder */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mDist;
        private final TextView mMets;
        private final TextView mOtPoint;
        private final TextView mPoint;
        private final TextView mPoints;
        private final TextView mStep;
        private final TextView mTitle;
        private final TextView mTrainPoint;
        private final TextView mWlkPoint;
        final /* synthetic */ RFGSummaryAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(RFGSummaryAdapter rFGSummaryAdapter, View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = rFGSummaryAdapter;
            View findViewById = view.findViewById(R.id.sum_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.sum_title)");
            this.mTitle = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.sum_point_all);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.sum_point_all)");
            this.mPoint = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.sum_point_walk);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.sum_point_walk)");
            this.mWlkPoint = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.sum_point_train);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.sum_point_train)");
            this.mTrainPoint = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.sum_point_other);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "itemView.findViewById(R.id.sum_point_other)");
            this.mOtPoint = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.sum_step);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "itemView.findViewById(R.id.sum_step)");
            this.mStep = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.sum_distance);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "itemView.findViewById(R.id.sum_distance)");
            this.mDist = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.sum_mets);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "itemView.findViewById(R.id.sum_mets)");
            this.mMets = (TextView) findViewById8;
            View findViewById9 = view.findViewById(R.id.sum_point);
            Intrinsics.checkExpressionValueIsNotNull(findViewById9, "itemView.findViewById(R.id.sum_point)");
            this.mPoints = (TextView) findViewById9;
        }

        public final TextView getMDist() {
            return this.mDist;
        }

        public final TextView getMMets() {
            return this.mMets;
        }

        public final TextView getMOtPoint() {
            return this.mOtPoint;
        }

        public final TextView getMPoint() {
            return this.mPoint;
        }

        public final TextView getMPoints() {
            return this.mPoints;
        }

        public final TextView getMStep() {
            return this.mStep;
        }

        public final TextView getMTitle() {
            return this.mTitle;
        }

        public final TextView getMTrainPoint() {
            return this.mTrainPoint;
        }

        public final TextView getMWlkPoint() {
            return this.mWlkPoint;
        }
    }

    public RFGSummaryAdapter(List<RFGAdapterSummary> list) {
        Intrinsics.checkParameterIsNotNull(list, "data");
        this.mData = list;
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        RFGAdapterSummary rFGAdapterSummary = this.mData.get(i);
        RFGSummaryHistory summary = rFGAdapterSummary.getSummary();
        TextView mTitle = viewHolder.getMTitle();
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwNpe();
        }
        mTitle.setText(context.getResources().getString(R.string.summary_suffix, new Object[]{rFGAdapterSummary.getDateTitle()}));
        viewHolder.getMPoint().setText(summary.point());
        viewHolder.getMWlkPoint().setText(summary.walk());
        viewHolder.getMTrainPoint().setText(summary.trainPointText());
        viewHolder.getMOtPoint().setText(summary.getOtherPoint());
        viewHolder.getMStep().setText(summary.stepText());
        viewHolder.getMDist().setText(summary.distanceBikeText());
        viewHolder.getMPoints().setText(summary.point());
        viewHolder.getMMets().setText(summary.getMets());
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        this.mContext = viewGroup.getContext();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_act_summary, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…t_summary, parent, false)");
        return new ViewHolder(this, inflate);
    }

    public final void setMContext(Context context) {
        this.mContext = context;
    }
}
