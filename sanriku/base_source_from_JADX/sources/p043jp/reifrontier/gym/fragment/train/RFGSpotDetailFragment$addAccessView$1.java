package p043jp.reifrontier.gym.fragment.train;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "lat", "", "lon", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$addAccessView$1 */
final class RFGSpotDetailFragment$addAccessView$1 extends Lambda implements Function2<Double, Double, Unit> {
    final /* synthetic */ RFGSpotDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RFGSpotDetailFragment$addAccessView$1(RFGSpotDetailFragment rFGSpotDetailFragment) {
        super(2);
        this.this$0 = rFGSpotDetailFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).doubleValue(), ((Number) obj2).doubleValue());
        return Unit.INSTANCE;
    }

    public final void invoke(double d, double d2) {
        this.this$0.openMapApp(d, d2);
    }
}
