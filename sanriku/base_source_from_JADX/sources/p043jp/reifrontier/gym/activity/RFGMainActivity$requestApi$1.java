package p043jp.reifrontier.gym.activity;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.train.RFGApiPointActionResponse;
import p078g.p079a.p100z.C1741d;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "response", "Lretrofit2/Response;", "Ljp/reifrontier/gym/domain/api/train/RFGApiPointActionResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$requestApi$1 */
final class RFGMainActivity$requestApi$1<T> implements C1741d<Response<RFGApiPointActionResponse>> {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$requestApi$1(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public final void accept(Response<RFGApiPointActionResponse> response) {
        RFGApiPointActionResponse body = response.body();
        if (response.code() == 200 && body != null) {
            Integer loginBonus = body.getLoginBonus();
            if (loginBonus != null && loginBonus.intValue() == 1) {
                this.this$0.shouldShowLoginBonus = true;
            }
            RFGShared rFGShared = RFGShared.INSTANCE;
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
            rFGShared.setSanLoginDate(instance);
        }
        this.this$0.requestStations();
    }
}
