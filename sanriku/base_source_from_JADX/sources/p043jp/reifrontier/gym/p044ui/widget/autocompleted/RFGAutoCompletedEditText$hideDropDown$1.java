package p043jp.reifrontier.gym.p044ui.widget.autocompleted;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo21739d2 = {"jp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedEditText$hideDropDown$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.autocompleted.RFGAutoCompletedEditText$hideDropDown$1 */
public final class RFGAutoCompletedEditText$hideDropDown$1 extends AnimatorListenerAdapter {
    final /* synthetic */ RFGAutoCompletedEditText this$0;

    RFGAutoCompletedEditText$hideDropDown$1(RFGAutoCompletedEditText rFGAutoCompletedEditText) {
        this.this$0 = rFGAutoCompletedEditText;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        ListView listView = (ListView) this.this$0._$_findCachedViewById(C2092R.C2094id.hintList);
        Intrinsics.checkExpressionValueIsNotNull(listView, "hintList");
        listView.setVisibility(8);
        ListView listView2 = (ListView) this.this$0._$_findCachedViewById(C2092R.C2094id.hintList);
        Intrinsics.checkExpressionValueIsNotNull(listView2, "hintList");
        listView2.setAlpha(0.0f);
    }
}
