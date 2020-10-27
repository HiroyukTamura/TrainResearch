package p043jp.reifrontier.gym.activity;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.ImportFlag;
import p041io.realm.Realm;
import p041io.realm.RealmList;
import p043jp.reifrontier.gym.domain.silentlog.RFGActivity;
import p043jp.reifrontier.gym.domain.silentlog.RFGDaily;
import p043jp.reifrontier.gym.domain.silentlog.RFGDay;
import p043jp.reifrontier.gym.domain.silentlog.RFGSegment;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "dailyResult", "", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$onStart$1 */
final class RFGMainActivity$onStart$1<T> implements C1741d<String> {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$onStart$1(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public final void accept(String str) {
        RFGDaily rFGDaily = (RFGDaily) new Gson().fromJson(str, new RFGMainActivity$onStart$1$turnsType$1().getType());
        if (rFGDaily != null) {
            RealmList realmList = new RealmList();
            for (RFGSegment activities : rFGDaily.getSegments()) {
                for (RFGActivity add : activities.getActivities()) {
                    realmList.add(add);
                }
            }
            if (realmList.size() > 0) {
                RFGDay rFGDay = new RFGDay();
                rFGDay.setDate(rFGDaily.getDate());
                rFGDay.setActivites(realmList);
                Realm access$getMRealm$p = this.this$0.mRealm;
                if (access$getMRealm$p == null) {
                    Intrinsics.throwNpe();
                }
                access$getMRealm$p.beginTransaction();
                Realm access$getMRealm$p2 = this.this$0.mRealm;
                if (access$getMRealm$p2 == null) {
                    Intrinsics.throwNpe();
                }
                access$getMRealm$p2.copyToRealmOrUpdate(rFGDay, new ImportFlag[0]);
                Realm access$getMRealm$p3 = this.this$0.mRealm;
                if (access$getMRealm$p3 == null) {
                    Intrinsics.throwNpe();
                }
                access$getMRealm$p3.commitTransaction();
            }
        }
    }
}
