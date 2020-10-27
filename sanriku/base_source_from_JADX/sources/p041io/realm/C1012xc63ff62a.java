package p041io.realm;

import p043jp.reifrontier.gym.domain.silentlog.RFGActTag;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint;

/* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxyInterface */
public interface C1012xc63ff62a {
    String realmGet$activity();

    int realmGet$fromDate();

    int realmGet$steps();

    RealmList<RFGActTag> realmGet$tags();

    int realmGet$toDate();

    RealmList<RFGTrackPoint> realmGet$trackPoints();

    void realmSet$activity(String str);

    void realmSet$fromDate(int i);

    void realmSet$steps(int i);

    void realmSet$tags(RealmList<RFGActTag> realmList);

    void realmSet$toDate(int i);

    void realmSet$trackPoints(RealmList<RFGTrackPoint> realmList);
}
