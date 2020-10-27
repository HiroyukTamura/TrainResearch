package p043jp.reifrontier.gym.activity;

import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import kotlin.Metadata;
import p043jp.reifrontier.gym.C2092R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$checkLoginBonus$1 */
final class RFGMainActivity$checkLoginBonus$1 implements View.OnClickListener {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$checkLoginBonus$1(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public final void onClick(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setAnimationListener(new C2098x7daa13ba(this));
        this.this$0.shouldShowLoginBonus = false;
        ((FrameLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.viewLoginBonusAnimation)).clearAnimation();
        ((FrameLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.viewLoginBonusAnimation)).startAnimation(translateAnimation);
    }
}
