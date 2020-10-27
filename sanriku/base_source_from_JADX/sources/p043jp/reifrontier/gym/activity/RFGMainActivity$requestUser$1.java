package p043jp.reifrontier.gym.activity;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.ImportFlag;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$requestUser$1 */
final class RFGMainActivity$requestUser$1<T> implements C1741d<RFGH2Client.H2APIResponse> {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$requestUser$1(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public final void accept(RFGH2Client.H2APIResponse h2APIResponse) {
        if (h2APIResponse.getCode() == 200) {
            Object data = h2APIResponse.getData();
            if (data != null) {
                RFGUser rFGUser = (RFGUser) data;
                RFGShared.INSTANCE.setFirstDate(rFGUser.getFirstDate());
                Realm access$getMRealm$p = this.this$0.mRealm;
                if (access$getMRealm$p == null) {
                    Intrinsics.throwNpe();
                }
                access$getMRealm$p.beginTransaction();
                Realm access$getMRealm$p2 = this.this$0.mRealm;
                if (access$getMRealm$p2 == null) {
                    Intrinsics.throwNpe();
                }
                access$getMRealm$p2.copyToRealmOrUpdate(rFGUser, new ImportFlag[0]);
                Realm access$getMRealm$p3 = this.this$0.mRealm;
                if (access$getMRealm$p3 == null) {
                    Intrinsics.throwNpe();
                }
                access$getMRealm$p3.commitTransaction();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.domain.api.RFGUser");
        }
    }
}
