package p043jp.reifrontier.gym.activity;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p078g.p079a.p100z.C1739b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "summaryResponse", "pointResponse", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$requestSummary$1 */
final class RFGMainActivity$requestSummary$1<T1, T2, R> implements C1739b<RFGH2Client.H2APIResponse, RFGH2Client.H2APIResponse, Map<String, ? extends RFGH2Client.H2APIResponse>> {
    public static final RFGMainActivity$requestSummary$1 INSTANCE = new RFGMainActivity$requestSummary$1();

    RFGMainActivity$requestSummary$1() {
    }

    public final Map<String, RFGH2Client.H2APIResponse> apply(RFGH2Client.H2APIResponse h2APIResponse, RFGH2Client.H2APIResponse h2APIResponse2) {
        Intrinsics.checkParameterIsNotNull(h2APIResponse, "summaryResponse");
        Intrinsics.checkParameterIsNotNull(h2APIResponse2, "pointResponse");
        return MapsKt__MapsKt.mapOf(TuplesKt.m4300to("summary", h2APIResponse), TuplesKt.m4300to("point", h2APIResponse2));
    }
}
