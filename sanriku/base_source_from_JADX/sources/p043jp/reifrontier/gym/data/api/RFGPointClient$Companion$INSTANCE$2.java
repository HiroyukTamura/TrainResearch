package p043jp.reifrontier.gym.data.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p043jp.reifrontier.gym.data.api.RFGPointClient;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/gym/data/api/RFGPointClient;", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGPointClient$Companion$INSTANCE$2 */
final class RFGPointClient$Companion$INSTANCE$2 extends Lambda implements Function0<RFGPointClient> {
    public static final RFGPointClient$Companion$INSTANCE$2 INSTANCE = new RFGPointClient$Companion$INSTANCE$2();

    RFGPointClient$Companion$INSTANCE$2() {
        super(0);
    }

    public final RFGPointClient invoke() {
        return RFGPointClient.Holder.INSTANCE.getINSTANCE();
    }
}
