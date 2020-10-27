package p041io.realm;

import p043jp.reifrontier.gym.domain.silentlog.RFGActivity;

/* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxyInterface */
public interface jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxyInterface {
    RealmList<RFGActivity> realmGet$activites();

    String realmGet$date();

    void realmSet$activites(RealmList<RFGActivity> realmList);

    void realmSet$date(String str);
}
