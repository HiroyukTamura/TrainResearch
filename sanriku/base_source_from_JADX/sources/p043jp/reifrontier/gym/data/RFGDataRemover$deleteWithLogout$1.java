package p043jp.reifrontier.gym.data;

import kotlin.Metadata;
import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.gym.data.bus.RFGCompletedRemoveData;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p048l.p049a.C1122a;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "result", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$LogoutResult;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.RFGDataRemover$deleteWithLogout$1 */
final class RFGDataRemover$deleteWithLogout$1<T> implements C1741d<SilentLogOperation.LogoutResult> {
    final /* synthetic */ RFGAppSetUp $setUp;
    final /* synthetic */ RFGDataRemover this$0;

    RFGDataRemover$deleteWithLogout$1(RFGDataRemover rFGDataRemover, RFGAppSetUp rFGAppSetUp) {
        this.this$0 = rFGDataRemover;
        this.$setUp = rFGAppSetUp;
    }

    public final void accept(SilentLogOperation.LogoutResult logoutResult) {
        if (logoutResult == SilentLogOperation.LogoutResult.Success) {
            C1122a.m1600c("[Gym]::Info release RFGLogoutSilentLog(success)", new Object[0]);
        } else {
            C1122a.m1599b("[Gym]::Error release RFGLogoutSilentLog(error)", new Object[0]);
        }
        this.this$0.deleteRealm();
        this.this$0.deleteSharedPref();
        this.$setUp.setUpPreference();
        this.$setUp.setUpSilentLog();
        C1126c.m1638c().mo21903a((Object) new RFGCompletedRemoveData(true));
    }
}
