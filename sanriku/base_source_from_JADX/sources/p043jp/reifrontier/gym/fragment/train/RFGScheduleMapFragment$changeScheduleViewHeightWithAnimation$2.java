package p043jp.reifrontier.gym.fragment.train;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo21739d2 = {"jp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$2 */
public final class RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$2 extends AnimatorListenerAdapter {
    final /* synthetic */ Function0 $onCompleted;

    RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$2(Function0 function0) {
        this.$onCompleted = function0;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        Function0 function0 = this.$onCompleted;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }
}
