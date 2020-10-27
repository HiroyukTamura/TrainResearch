package p043jp.reifrontier.gym.p044ui.widget.train;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.train.RFGAccessView$addAddress$1 */
final class RFGAccessView$addAddress$1 implements View.OnClickListener {
    final /* synthetic */ RFGAccessView this$0;

    RFGAccessView$addAddress$1(RFGAccessView rFGAccessView) {
        this.this$0 = rFGAccessView;
    }

    public final void onClick(View view) {
        Function2<Double, Double, Unit> onClickShowMap = this.this$0.getOnClickShowMap();
        if (onClickShowMap != null) {
            Unit invoke = onClickShowMap.invoke(Double.valueOf(this.this$0.access.getLat()), Double.valueOf(this.this$0.access.getLon()));
        }
    }
}
