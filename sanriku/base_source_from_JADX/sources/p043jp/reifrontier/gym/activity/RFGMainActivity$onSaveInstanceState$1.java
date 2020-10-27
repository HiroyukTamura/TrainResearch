package p043jp.reifrontier.gym.activity;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import p043jp.reifrontier.gym.p044ui.tab.RFGFragNavController;

@Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$onSaveInstanceState$1 */
final /* synthetic */ class RFGMainActivity$onSaveInstanceState$1 extends MutablePropertyReference0 {
    RFGMainActivity$onSaveInstanceState$1(RFGMainActivity rFGMainActivity) {
        super(rFGMainActivity);
    }

    public Object get() {
        return RFGMainActivity.access$getMNavController$p((RFGMainActivity) this.receiver);
    }

    public String getName() {
        return "mNavController";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(RFGMainActivity.class);
    }

    public String getSignature() {
        return "getMNavController()Ljp/reifrontier/gym/ui/tab/RFGFragNavController;";
    }

    public void set(Object obj) {
        ((RFGMainActivity) this.receiver).mNavController = (RFGFragNavController) obj;
    }
}
