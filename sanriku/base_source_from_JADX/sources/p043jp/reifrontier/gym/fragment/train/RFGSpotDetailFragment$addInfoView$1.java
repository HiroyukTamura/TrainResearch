package p043jp.reifrontier.gym.fragment.train;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "tel", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$addInfoView$1 */
final class RFGSpotDetailFragment$addInfoView$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ RFGSpotDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RFGSpotDetailFragment$addInfoView$1(RFGSpotDetailFragment rFGSpotDetailFragment) {
        super(1);
        this.this$0 = rFGSpotDetailFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tel");
        this.this$0.openTel(str);
    }
}
