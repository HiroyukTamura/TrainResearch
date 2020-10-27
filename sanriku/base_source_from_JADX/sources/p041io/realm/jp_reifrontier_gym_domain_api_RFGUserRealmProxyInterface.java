package p041io.realm;

import p043jp.reifrontier.gym.domain.api.RFGHistory;
import p043jp.reifrontier.gym.domain.api.RFGUserSummary;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxyInterface */
public interface jp_reifrontier_gym_domain_api_RFGUserRealmProxyInterface {
    String realmGet$archiveCount();

    String realmGet$birthday();

    String realmGet$email();

    String realmGet$firstDate();

    String realmGet$gender();

    String realmGet$handleName();

    RealmList<RFGHistory> realmGet$heightHistory();

    String realmGet$icon();

    String realmGet$pushAllow();

    RealmList<RFGUserSummary> realmGet$summaryAll();

    RealmList<RFGUserSummary> realmGet$summaryToday();

    String realmGet$userId();

    RealmList<RFGHistory> realmGet$weightHistory();

    void realmSet$archiveCount(String str);

    void realmSet$birthday(String str);

    void realmSet$email(String str);

    void realmSet$firstDate(String str);

    void realmSet$gender(String str);

    void realmSet$handleName(String str);

    void realmSet$heightHistory(RealmList<RFGHistory> realmList);

    void realmSet$icon(String str);

    void realmSet$pushAllow(String str);

    void realmSet$summaryAll(RealmList<RFGUserSummary> realmList);

    void realmSet$summaryToday(RealmList<RFGUserSummary> realmList);

    void realmSet$userId(String str);

    void realmSet$weightHistory(RealmList<RFGHistory> realmList);
}
