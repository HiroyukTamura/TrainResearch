package p043jp.reifrontier.gym;

import kotlin.Metadata;
import p041io.realm.Realm;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Lio/realm/Realm;", "kotlin.jvm.PlatformType", "execute"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.RFGApp$resultForLogoutApi$1 */
final class RFGApp$resultForLogoutApi$1 implements Realm.Transaction {
    final /* synthetic */ Realm $realm;

    RFGApp$resultForLogoutApi$1(Realm realm) {
        this.$realm = realm;
    }

    public final void execute(Realm realm) {
        this.$realm.deleteAll();
    }
}
