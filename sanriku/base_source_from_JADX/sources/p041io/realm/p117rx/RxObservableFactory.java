package p041io.realm.p117rx;

import p041io.realm.DynamicRealm;
import p041io.realm.DynamicRealmObject;
import p041io.realm.Realm;
import p041io.realm.RealmList;
import p041io.realm.RealmModel;
import p041io.realm.RealmQuery;
import p041io.realm.RealmResults;
import p078g.p079a.C1701g;
import p078g.p079a.C1706l;
import p078g.p079a.C1714r;

/* renamed from: io.realm.rx.RxObservableFactory */
public interface RxObservableFactory {
    C1706l<ObjectChange<DynamicRealmObject>> changesetsFrom(DynamicRealm dynamicRealm, DynamicRealmObject dynamicRealmObject);

    <E> C1706l<CollectionChange<RealmList<E>>> changesetsFrom(DynamicRealm dynamicRealm, RealmList<E> realmList);

    <E> C1706l<CollectionChange<RealmResults<E>>> changesetsFrom(DynamicRealm dynamicRealm, RealmResults<E> realmResults);

    <E> C1706l<CollectionChange<RealmList<E>>> changesetsFrom(Realm realm, RealmList<E> realmList);

    <E extends RealmModel> C1706l<ObjectChange<E>> changesetsFrom(Realm realm, E e);

    <E> C1706l<CollectionChange<RealmResults<E>>> changesetsFrom(Realm realm, RealmResults<E> realmResults);

    C1701g<DynamicRealm> from(DynamicRealm dynamicRealm);

    C1701g<DynamicRealmObject> from(DynamicRealm dynamicRealm, DynamicRealmObject dynamicRealmObject);

    <E> C1701g<RealmList<E>> from(DynamicRealm dynamicRealm, RealmList<E> realmList);

    <E> C1701g<RealmResults<E>> from(DynamicRealm dynamicRealm, RealmResults<E> realmResults);

    C1701g<Realm> from(Realm realm);

    <E> C1701g<RealmList<E>> from(Realm realm, RealmList<E> realmList);

    <E extends RealmModel> C1701g<E> from(Realm realm, E e);

    <E> C1701g<RealmResults<E>> from(Realm realm, RealmResults<E> realmResults);

    <E> C1714r<RealmQuery<E>> from(DynamicRealm dynamicRealm, RealmQuery<E> realmQuery);

    <E> C1714r<RealmQuery<E>> from(Realm realm, RealmQuery<E> realmQuery);
}
