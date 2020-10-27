package p043jp.reifrontier.gym.p044ui.widget.train;

import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo21739d2 = {"jp/reifrontier/gym/ui/widget/train/RFGAccessView$setSpannableStationName$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.train.RFGAccessView$setSpannableStationName$1 */
public final class RFGAccessView$setSpannableStationName$1 extends ClickableSpan {
    final /* synthetic */ RFGAccessView this$0;

    RFGAccessView$setSpannableStationName$1(RFGAccessView rFGAccessView) {
        this.this$0 = rFGAccessView;
    }

    public void onClick(View view) {
        Intrinsics.checkParameterIsNotNull(view, "widget");
        Function0<Unit> onClickStation = this.this$0.getOnClickStation();
        if (onClickStation != null) {
            Unit invoke = onClickStation.invoke();
        }
    }
}
