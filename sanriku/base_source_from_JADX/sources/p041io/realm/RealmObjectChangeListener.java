package p041io.realm;

import p041io.realm.RealmModel;

/* renamed from: io.realm.RealmObjectChangeListener */
public interface RealmObjectChangeListener<T extends RealmModel> {
    void onChange(T t, ObjectChangeSet objectChangeSet);
}
