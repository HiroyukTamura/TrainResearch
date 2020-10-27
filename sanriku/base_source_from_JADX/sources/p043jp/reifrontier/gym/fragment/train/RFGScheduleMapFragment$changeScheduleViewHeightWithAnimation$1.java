package p043jp.reifrontier.gym.fragment.train;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$1 */
final class RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ Integer $targetMapBottom;
    final /* synthetic */ RFGScheduleMapFragment this$0;

    RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$1(RFGScheduleMapFragment rFGScheduleMapFragment, Integer num) {
        this.this$0 = rFGScheduleMapFragment;
        this.$targetMapBottom = num;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        RFGScheduleMapFragment rFGScheduleMapFragment = this.this$0;
        Object animatedValue = valueAnimator.getAnimatedValue("result");
        if (animatedValue != null) {
            rFGScheduleMapFragment.setScheduleViewHeight(((Integer) animatedValue).intValue());
            if (this.$targetMapBottom != null) {
                RFGScheduleMapFragment rFGScheduleMapFragment2 = this.this$0;
                Object animatedValue2 = valueAnimator.getAnimatedValue("map");
                if (animatedValue2 != null) {
                    rFGScheduleMapFragment2.setMapBottomMargin(((Integer) animatedValue2).intValue());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
            }
            View view = this.this$0.getView();
            if (view != null) {
                view.invalidate();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
