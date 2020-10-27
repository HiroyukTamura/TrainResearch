package p043jp.reifrontier.gym.activity;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, mo21739d2 = {"jp/reifrontier/gym/activity/RFGMainActivity$checkLoginBonus$1$hideAnimation$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$checkLoginBonus$1$$special$$inlined$apply$lambda$1 */
public final class C2098x7daa13ba implements Animation.AnimationListener {
    final /* synthetic */ RFGMainActivity$checkLoginBonus$1 this$0;

    C2098x7daa13ba(RFGMainActivity$checkLoginBonus$1 rFGMainActivity$checkLoginBonus$1) {
        this.this$0 = rFGMainActivity$checkLoginBonus$1;
    }

    public void onAnimationEnd(Animation animation) {
        FrameLayout frameLayout = (FrameLayout) this.this$0.this$0._$_findCachedViewById(C2092R.C2094id.viewLoginBonusCover);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "viewLoginBonusCover");
        frameLayout.setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
