package p043jp.reifrontier.gym.domain.silentlog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.RealmList;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxyInterface;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/silentlog/RFGDay;", "Lio/realm/RealmObject;", "()V", "activites", "Lio/realm/RealmList;", "Ljp/reifrontier/gym/domain/silentlog/RFGActivity;", "getActivites", "()Lio/realm/RealmList;", "setActivites", "(Lio/realm/RealmList;)V", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.silentlog.RFGDay */
public class RFGDay extends RealmObject implements jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxyInterface {
    private RealmList<RFGActivity> activites;
    @PrimaryKey
    private String date;

    public RFGDay() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$date("");
        realmSet$activites(new RealmList());
    }

    public RealmList<RFGActivity> getActivites() {
        return realmGet$activites();
    }

    public String getDate() {
        return realmGet$date();
    }

    public RealmList realmGet$activites() {
        return this.activites;
    }

    public String realmGet$date() {
        return this.date;
    }

    public void realmSet$activites(RealmList realmList) {
        this.activites = realmList;
    }

    public void realmSet$date(String str) {
        this.date = str;
    }

    public void setActivites(RealmList<RFGActivity> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$activites(realmList);
    }

    public void setDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$date(str);
    }
}
