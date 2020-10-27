package p043jp.reifrontier.gym.p044ui.widget;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.RFGIndicator$onCreateAnimators$1 */
final class RFGIndicator$onCreateAnimators$1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: $i */
    final /* synthetic */ int f2965$i;
    final /* synthetic */ RFGIndicator this$0;

    RFGIndicator$onCreateAnimators$1(RFGIndicator rFGIndicator, int i) {
        this.this$0 = rFGIndicator;
        this.f2965$i = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] access$getScaleYFloats$p = this.this$0.scaleYFloats;
        int i = this.f2965$i;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            access$getScaleYFloats$p[i] = ((Float) animatedValue).floatValue();
            this.this$0.postInvalidate();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
