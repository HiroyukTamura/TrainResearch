package p043jp.reifrontier.gym.fragment.train;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import p043jp.reifrontier.gym.C2092R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t¨\u0006\n"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/core/widget/NestedScrollView;", "<anonymous parameter 1>", "", "scrollY", "<anonymous parameter 3>", "oldScrollY", "onScrollChange", "jp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$setUpDetail$5$1"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1$lambda$1 */
final class C2109x7b57950b implements NestedScrollView.OnScrollChangeListener {
    final /* synthetic */ int $titleHeight;
    final /* synthetic */ RFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1 this$0;

    C2109x7b57950b(int i, RFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1 rFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1) {
        this.$titleHeight = i;
        this.this$0 = rFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        TextView textView;
        AlphaAnimation access$getHideTitleAnimation$p;
        int i5 = this.$titleHeight;
        if (i4 <= i5 && i2 > i5) {
            this.this$0.this$0.hideTitleAnimation.cancel();
            textView = (TextView) this.this$0.this$0._$_findCachedViewById(C2092R.C2094id.viewSpotTitleTop);
            access$getHideTitleAnimation$p = this.this$0.this$0.showTitleAnimation;
        } else {
            int i6 = i2 + 1;
            int i7 = this.$titleHeight;
            if (i6 <= i7 && i4 >= i7) {
                this.this$0.this$0.showTitleAnimation.cancel();
                textView = (TextView) this.this$0.this$0._$_findCachedViewById(C2092R.C2094id.viewSpotTitleTop);
                access$getHideTitleAnimation$p = this.this$0.this$0.hideTitleAnimation;
            } else {
                return;
            }
        }
        textView.startAnimation(access$getHideTitleAnimation$p);
    }
}
