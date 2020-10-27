package p043jp.reifrontier.gym.fragment.train;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import p043jp.reifrontier.gym.C2092R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0000"}, mo21739d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1 */
public final class RFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ Ref.ObjectRef $titleView$inlined;
    final /* synthetic */ RFGSpotDetailFragment this$0;

    public RFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1(RFGSpotDetailFragment rFGSpotDetailFragment, Ref.ObjectRef objectRef) {
        this.this$0 = rFGSpotDetailFragment;
        this.$titleView$inlined = objectRef;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        view.removeOnLayoutChangeListener(this);
        TextView textView = (TextView) this.$titleView$inlined.element;
        if (textView != null) {
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2092R.C2094id.viewSpotTitleTop);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "viewSpotTitleTop");
            textView2.setText(textView.getText());
            ((NestedScrollView) this.this$0._$_findCachedViewById(C2092R.C2094id.viewScrollContent)).setOnScrollChangeListener(new C2109x7b57950b(textView.getHeight(), this));
        }
    }
}
