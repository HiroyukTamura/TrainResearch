package p043jp.reifrontier.gym.data.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p043jp.reifrontier.gym.data.api.RFGH2Client;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/gym/data/api/RFGH2Client;", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGH2Client$Companion$INSTANCE$2 */
final class RFGH2Client$Companion$INSTANCE$2 extends Lambda implements Function0<RFGH2Client> {
    public static final RFGH2Client$Companion$INSTANCE$2 INSTANCE = new RFGH2Client$Companion$INSTANCE$2();

    RFGH2Client$Companion$INSTANCE$2() {
        super(0);
    }

    public final RFGH2Client invoke() {
        return RFGH2Client.Holder.INSTANCE.getINSTANCE();
    }
}
