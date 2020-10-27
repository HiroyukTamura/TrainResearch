package p043jp.reifrontier.gym.activity;

import kotlin.Metadata;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$requestUpdateIcon$1 */
final class RFGInitActivity$requestUpdateIcon$1<T> implements C1741d<RFGH2Client.H2APIResponse> {
    final /* synthetic */ RFGInitActivity this$0;

    RFGInitActivity$requestUpdateIcon$1(RFGInitActivity rFGInitActivity) {
        this.this$0 = rFGInitActivity;
    }

    public final void accept(RFGH2Client.H2APIResponse h2APIResponse) {
        if (h2APIResponse.getCode() == 200) {
            this.this$0.requestUser();
        } else {
            this.this$0.stopLoading();
        }
    }
}
