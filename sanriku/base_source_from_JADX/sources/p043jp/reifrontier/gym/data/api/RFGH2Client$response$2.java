package p043jp.reifrontier.gym.data.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "T", "it", "", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGH2Client$response$2 */
final class RFGH2Client$response$2<T, R> implements C1742e<Throwable, RFGH2Client.H2APIResponse> {
    final /* synthetic */ String $path;
    final /* synthetic */ RFGH2Client this$0;

    RFGH2Client$response$2(RFGH2Client rFGH2Client, String str) {
        this.this$0 = rFGH2Client;
        this.$path = str;
    }

    public final RFGH2Client.H2APIResponse apply(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        return this.this$0.handleErrorResponse(this.$path, (String) null);
    }
}
