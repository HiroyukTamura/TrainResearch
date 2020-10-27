package p043jp.reifrontier.gym.data.shared;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.shared.RFGShared$initialize$2 */
final /* synthetic */ class RFGShared$initialize$2 extends MutablePropertyReference0 {
    RFGShared$initialize$2(RFGShared rFGShared) {
        super(rFGShared);
    }

    public Object get() {
        return ((RFGShared) this.receiver).getYesterdayMetsList();
    }

    public String getName() {
        return "yesterdayMetsList";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(RFGShared.class);
    }

    public String getSignature() {
        return "getYesterdayMetsList()Ljava/util/HashMap;";
    }

    public void set(Object obj) {
        ((RFGShared) this.receiver).setYesterdayMetsList((HashMap) obj);
    }
}
