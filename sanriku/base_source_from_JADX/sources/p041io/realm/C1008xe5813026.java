package p041io.realm;

import p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxyInterface */
public interface C1008xe5813026 {
    RealmList<RFGApiContentItem> realmGet$contents();

    int realmGet$date();

    int realmGet$id();

    int realmGet$spotType();

    Integer realmGet$stationId();

    String realmGet$title();

    int realmGet$updateAt();

    void realmSet$contents(RealmList<RFGApiContentItem> realmList);

    void realmSet$date(int i);

    void realmSet$id(int i);

    void realmSet$spotType(int i);

    void realmSet$stationId(Integer num);

    void realmSet$title(String str);

    void realmSet$updateAt(int i);
}
