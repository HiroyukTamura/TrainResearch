package p043jp.reifrontier.gym.data;

import kotlin.Metadata;
import p078g.p079a.p100z.C1738a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "run"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.RFGDataRemover$deleteWithoutLogout$1 */
final class RFGDataRemover$deleteWithoutLogout$1 implements C1738a {
    final /* synthetic */ RFGAppSetUp $setUp;
    final /* synthetic */ RFGDataRemover this$0;

    RFGDataRemover$deleteWithoutLogout$1(RFGDataRemover rFGDataRemover, RFGAppSetUp rFGAppSetUp) {
        this.this$0 = rFGDataRemover;
        this.$setUp = rFGAppSetUp;
    }

    public final void run() {
        this.this$0.deleteRealm();
        this.this$0.deleteSharedPref();
        this.$setUp.setUpPreference();
        this.$setUp.setUpSilentLog();
    }
}
