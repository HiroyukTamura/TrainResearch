package p043jp.reifrontier.gym.activity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.Realm;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Lio/realm/Realm;", "kotlin.jvm.PlatformType", "execute"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$onReceiveUpdate$1 */
final class RFGMainActivity$onReceiveUpdate$1 implements Realm.Transaction {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$onReceiveUpdate$1(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public final void execute(Realm realm) {
        Realm access$getMRealm$p = this.this$0.mRealm;
        if (access$getMRealm$p == null) {
            Intrinsics.throwNpe();
        }
        access$getMRealm$p.deleteAll();
    }
}
