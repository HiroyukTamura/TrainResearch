package p043jp.reifrontier.gym.p044ui.dialog;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.train.RFGTrainSchedule;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo21739d2 = {"jp/reifrontier/gym/ui/dialog/RFGTrainScheduleDialog$scrollToCurrentStation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGTrainScheduleDialog$scrollToCurrentStation$1 */
public final class RFGTrainScheduleDialog$scrollToCurrentStation$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ RFGTrainSchedule $currentStation;
    final /* synthetic */ LinearLayout $viewScheduleList;
    final /* synthetic */ ScrollView $viewScroll;

    RFGTrainScheduleDialog$scrollToCurrentStation$1(LinearLayout linearLayout, RFGTrainSchedule rFGTrainSchedule, ScrollView scrollView) {
        this.$viewScheduleList = linearLayout;
        this.$currentStation = rFGTrainSchedule;
        this.$viewScroll = scrollView;
    }

    public void onGlobalLayout() {
        this.$viewScheduleList.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (this.$viewScheduleList.getChildCount() > 0) {
            int childCount = this.$viewScheduleList.getChildCount();
            int i = 0;
            int i2 = 0;
            while (i < childCount) {
                View childAt = this.$viewScheduleList.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "childView");
                Object tag = childAt.getTag();
                if (tag == null) {
                    throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.data.train.RFGTrainSchedule");
                } else if (this.$currentStation.getStationId() == ((RFGTrainSchedule) tag).getStationId()) {
                    break;
                } else {
                    i2 += childAt.getHeight();
                    i++;
                }
            }
            this.$viewScroll.scrollTo(0, i2);
        }
    }
}
