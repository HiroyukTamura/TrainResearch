package p043jp.reifrontier.gym.p044ui.adapter;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import p043jp.reifrontier.gym.p044ui.adapter.RFGFeedAdapter;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo21739d2 = {"jp/reifrontier/gym/ui/adapter/RFGFeedAdapter$setMetsPoint$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$setMetsPoint$1 */
public final class RFGFeedAdapter$setMetsPoint$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ConstraintLayout $baseImageView;
    final /* synthetic */ RFGFeedAdapter.Feed $feed;

    RFGFeedAdapter$setMetsPoint$1(ConstraintLayout constraintLayout, RFGFeedAdapter.Feed feed) {
        this.$baseImageView = constraintLayout;
        this.$feed = feed;
    }

    public void onGlobalLayout() {
        this.$baseImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        float f = ((float) this.$baseImageView.getLayoutParams().height) / 400.0f;
        float f2 = (float) 2;
        int roundToInt = MathKt__MathJVMKt.roundToInt((180.0f * f) - (((float) this.$feed.getArchiveFirst().getHeight()) / f2));
        int roundToInt2 = MathKt__MathJVMKt.roundToInt((f * 48.0f) - (((float) this.$feed.getArchiveMessage().getHeight()) / f2));
        ViewGroup.LayoutParams layoutParams = this.$feed.getArchiveNumberBase().getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.topMargin = roundToInt;
            this.$feed.getArchiveNumberBase().setLayoutParams(marginLayoutParams2);
        }
        ViewGroup.LayoutParams layoutParams2 = this.$feed.getArchiveUnit().getLayoutParams();
        if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams2 = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (marginLayoutParams3 != null) {
            marginLayoutParams3.topMargin = roundToInt;
            this.$feed.getArchiveUnit().setLayoutParams(marginLayoutParams3);
        }
        ViewGroup.LayoutParams layoutParams3 = this.$feed.getArchiveMessage().getLayoutParams();
        if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams3;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams4 = marginLayoutParams;
        if (marginLayoutParams4 != null) {
            marginLayoutParams4.bottomMargin = roundToInt2;
            this.$feed.getArchiveMessage().setLayoutParams(marginLayoutParams4);
        }
    }
}
