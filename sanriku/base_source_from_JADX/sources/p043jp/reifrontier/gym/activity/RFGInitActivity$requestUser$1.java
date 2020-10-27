package p043jp.reifrontier.gym.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.ImportFlag;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p048l.p049a.C1122a;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$requestUser$1 */
final class RFGInitActivity$requestUser$1<T> implements C1741d<RFGH2Client.H2APIResponse> {
    final /* synthetic */ RFGInitActivity this$0;

    RFGInitActivity$requestUser$1(RFGInitActivity rFGInitActivity) {
        this.this$0 = rFGInitActivity;
    }

    public final void accept(RFGH2Client.H2APIResponse h2APIResponse) {
        if (h2APIResponse.getCode() == 200) {
            Object data = h2APIResponse.getData();
            if (data != null) {
                RFGUser rFGUser = (RFGUser) data;
                if (rFGUser.getUserId().length() == 0) {
                    this.this$0.stopLoading();
                    this.this$0.isLoading = false;
                    this.this$0.setEditView();
                    return;
                }
                Date parse = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.JAPANESE).parse(rFGUser.getFirstDate());
                if (parse == null) {
                    parse = new Date();
                }
                RFGShared.INSTANCE.setInstallDate(parse.getTime());
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
                SilentLogOperation.Companion.getInstance().getInternalOperation().saveSl2Id(rFGUser.gymId());
                HashMap hashMap = new HashMap();
                String str = RFGShared.INSTANCE.token();
                hashMap.put("push_allow", String.valueOf(1));
                hashMap.put("push_device_id", str);
                this.this$0.requestUpdatePushDeviceId(hashMap);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.domain.api.RFGUser");
        }
        this.this$0.stopLoading();
        this.this$0.isLoading = false;
        this.this$0.setEditView();
        C1122a.m1599b("[Gym]::Error #code %s", Integer.valueOf(h2APIResponse.getCode()));
    }
}
