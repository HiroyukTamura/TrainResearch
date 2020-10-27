package p043jp.reifrontier.gym.data.shared;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.shared.RFGShared$initialize$1 */
final /* synthetic */ class RFGShared$initialize$1 extends MutablePropertyReference0 {
    RFGShared$initialize$1(RFGShared rFGShared) {
        super(rFGShared);
    }

    public Object get() {
        return RFGShared.access$getSHARED$p((RFGShared) this.receiver);
    }

    public String getName() {
        return "SHARED";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(RFGShared.class);
    }

    public String getSignature() {
        return "getSHARED()Landroid/content/SharedPreferences;";
    }

    public void set(Object obj) {
        RFGShared.SHARED = (SharedPreferences) obj;
    }
}
