package p041io.realm;

import p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxyInterface */
public interface C1006xbf250013 {
    RFGApiContentAccess realmGet$access();

    RFGApiContentButton realmGet$button();

    RFGApiContentImage realmGet$image();

    RealmList<RFGApiContentInfo> realmGet$infoList();

    RFGApiContentNote realmGet$note();

    int realmGet$order();

    String realmGet$pKey();

    RFGApiContentTitle realmGet$title();

    void realmSet$access(RFGApiContentAccess rFGApiContentAccess);

    void realmSet$button(RFGApiContentButton rFGApiContentButton);

    void realmSet$image(RFGApiContentImage rFGApiContentImage);

    void realmSet$infoList(RealmList<RFGApiContentInfo> realmList);

    void realmSet$note(RFGApiContentNote rFGApiContentNote);

    void realmSet$order(int i);

    void realmSet$pKey(String str);

    void realmSet$title(RFGApiContentTitle rFGApiContentTitle);
}
