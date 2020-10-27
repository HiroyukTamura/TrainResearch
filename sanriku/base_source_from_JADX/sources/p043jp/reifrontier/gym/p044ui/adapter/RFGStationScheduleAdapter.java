package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGTrainDetail;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGTransfer;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0014\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGStationScheduleAdapter;", "Landroid/widget/ArrayAdapter;", "Ljp/reifrontier/gym/ui/viewModel/RFGTrainDetail;", "context", "Landroid/content/Context;", "trainDetailList", "", "resource", "", "(Landroid/content/Context;Ljava/util/List;I)V", "inflater", "Landroid/view/LayoutInflater;", "onDataSetChangedListener", "Lkotlin/Function0;", "", "getOnDataSetChangedListener", "()Lkotlin/jvm/functions/Function0;", "setOnDataSetChangedListener", "(Lkotlin/jvm/functions/Function0;)V", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "notifyDataSetChanged", "updateData", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGStationScheduleAdapter */
public final class RFGStationScheduleAdapter extends ArrayAdapter<RFGTrainDetail> {
    private final LayoutInflater inflater;
    private Function0<Unit> onDataSetChangedListener;
    private final int resource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGStationScheduleAdapter(Context context, List<RFGTrainDetail> list, int i) {
        super(context, i, list);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(list, "trainDetailList");
        this.resource = i;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(context)");
        this.inflater = from;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGStationScheduleAdapter(Context context, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i2 & 4) != 0 ? R.layout.row_sanriku_schedule : i);
    }

    public final Function0<Unit> getOnDataSetChangedListener() {
        return this.onDataSetChangedListener;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (view == null) {
            view = this.inflater.inflate(this.resource, viewGroup, false);
        }
        RFGTrainDetail rFGTrainDetail = (RFGTrainDetail) getItem(i);
        TextView textView = (TextView) view.findViewById(R.id.goToText);
        TextView textView2 = (TextView) view.findViewById(R.id.timeText);
        TextView textView3 = (TextView) view.findViewById(R.id.transferText);
        if (rFGTrainDetail == null) {
            Intrinsics.checkExpressionValueIsNotNull(textView, "goToText");
            textView.setText("");
            Intrinsics.checkExpressionValueIsNotNull(textView2, "timeText");
            textView2.setText("");
        } else {
            String string = getContext().getString(rFGTrainDetail.getTrainType() == RFGDef.TrainType.UP ? R.string.sanriku_train_type_up : R.string.sanriku_train_type_down);
            Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(typeResId)");
            Intrinsics.checkExpressionValueIsNotNull(textView, "goToText");
            textView.setText(getContext().getString(R.string.sanriku_goto_text, new Object[]{rFGTrainDetail.getEndStationName(), string}));
            textView.setBackgroundResource(rFGTrainDetail.getTrainType() == RFGDef.TrainType.UP ? R.drawable.rounded_blue_square : R.drawable.rounded_red_square);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "timeText");
            textView2.setText(rFGTrainDetail.getDeparture());
            if (!rFGTrainDetail.getTransferList().isEmpty()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (RFGTransfer rFGTransfer : rFGTrainDetail.getTransferList()) {
                    if (stringBuffer.length() > 0) {
                        stringBuffer.append(" / ");
                    }
                    stringBuffer.append(getContext().getString(R.string.sanriku_transfer_text, new Object[]{rFGTransfer.getStationName(), rFGTransfer.getArrival()}));
                }
                Intrinsics.checkExpressionValueIsNotNull(textView3, "transferText");
                textView3.setText(stringBuffer.toString());
                Intrinsics.checkExpressionValueIsNotNull(view, Promotion.ACTION_VIEW);
                return view;
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(textView3, "transferText");
        textView3.setText("");
        Intrinsics.checkExpressionValueIsNotNull(view, Promotion.ACTION_VIEW);
        return view;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Function0<Unit> function0 = this.onDataSetChangedListener;
        if (function0 != null) {
            Unit invoke = function0.invoke();
        }
    }

    public final void setOnDataSetChangedListener(Function0<Unit> function0) {
        this.onDataSetChangedListener = function0;
    }

    public final void updateData(List<RFGTrainDetail> list) {
        Intrinsics.checkParameterIsNotNull(list, "trainDetailList");
        clear();
        addAll(list);
        notifyDataSetChanged();
    }
}
