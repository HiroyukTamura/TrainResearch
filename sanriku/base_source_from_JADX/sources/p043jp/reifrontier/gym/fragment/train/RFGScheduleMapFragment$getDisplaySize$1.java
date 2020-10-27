package p043jp.reifrontier.gym.fragment.train;

import android.graphics.Point;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$getDisplaySize$1 */
final /* synthetic */ class RFGScheduleMapFragment$getDisplaySize$1 extends MutablePropertyReference0 {
    RFGScheduleMapFragment$getDisplaySize$1(RFGScheduleMapFragment rFGScheduleMapFragment) {
        super(rFGScheduleMapFragment);
    }

    public Object get() {
        return RFGScheduleMapFragment.access$getDisplaySize$p((RFGScheduleMapFragment) this.receiver);
    }

    public String getName() {
        return "displaySize";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(RFGScheduleMapFragment.class);
    }

    public String getSignature() {
        return "getDisplaySize()Landroid/graphics/Point;";
    }

    public void set(Object obj) {
        ((RFGScheduleMapFragment) this.receiver).displaySize = (Point) obj;
    }
}
