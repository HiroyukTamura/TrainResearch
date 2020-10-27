package p041io.realm.internal;

import p041io.realm.ProxyState;
import p041io.realm.RealmModel;

/* renamed from: io.realm.internal.RealmObjectProxy */
public interface RealmObjectProxy extends RealmModel {

    /* renamed from: io.realm.internal.RealmObjectProxy$CacheData */
    public static class CacheData<E extends RealmModel> {
        public int minDepth;
        public final E object;

        public CacheData(int i, E e) {
            this.minDepth = i;
            this.object = e;
        }
    }

    void realm$injectObjectContext();

    ProxyState realmGet$proxyState();
}
