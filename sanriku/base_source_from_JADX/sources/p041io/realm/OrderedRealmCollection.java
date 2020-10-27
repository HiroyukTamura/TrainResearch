package p041io.realm;

import java.util.List;

/* renamed from: io.realm.OrderedRealmCollection */
public interface OrderedRealmCollection<E> extends List<E>, RealmCollection<E> {
    OrderedRealmCollectionSnapshot<E> createSnapshot();

    boolean deleteFirstFromRealm();

    void deleteFromRealm(int i);

    boolean deleteLastFromRealm();

    E first();

    E first(E e);

    E last();

    E last(E e);

    RealmResults<E> sort(String str);

    RealmResults<E> sort(String str, Sort sort);

    RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2);

    RealmResults<E> sort(String[] strArr, Sort[] sortArr);
}
