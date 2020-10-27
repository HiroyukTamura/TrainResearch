package p041io.realm.internal;

import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.OrderedCollectionChangeSet;
import p041io.realm.OrderedRealmCollectionChangeListener;
import p041io.realm.RealmChangeListener;
import p041io.realm.internal.ObserverPairList;

@Keep
/* renamed from: io.realm.internal.ObservableCollection */
interface ObservableCollection {

    /* renamed from: io.realm.internal.ObservableCollection$Callback */
    public static class Callback implements ObserverPairList.Callback<CollectionObserverPair> {
        private final OsCollectionChangeSet changeSet;

        Callback(OsCollectionChangeSet osCollectionChangeSet) {
            this.changeSet = osCollectionChangeSet;
        }

        public void onCalled(CollectionObserverPair collectionObserverPair, Object obj) {
            collectionObserverPair.onChange(obj, this.changeSet);
        }
    }

    /* renamed from: io.realm.internal.ObservableCollection$CollectionObserverPair */
    public static class CollectionObserverPair<T> extends ObserverPairList.ObserverPair<T, Object> {
        public CollectionObserverPair(T t, Object obj) {
            super(t, obj);
        }

        public void onChange(T t, OsCollectionChangeSet osCollectionChangeSet) {
            S s = this.listener;
            if (s instanceof OrderedRealmCollectionChangeListener) {
                ((OrderedRealmCollectionChangeListener) s).onChange(t, new StatefulCollectionChangeSet(osCollectionChangeSet));
            } else if (s instanceof RealmChangeListener) {
                ((RealmChangeListener) s).onChange(t);
            } else {
                StringBuilder a = C0681a.m330a("Unsupported listener type: ");
                a.append(this.listener);
                throw new RuntimeException(a.toString());
            }
        }
    }

    /* renamed from: io.realm.internal.ObservableCollection$RealmChangeListenerWrapper */
    public static class RealmChangeListenerWrapper<T> implements OrderedRealmCollectionChangeListener<T> {
        private final RealmChangeListener<T> listener;

        RealmChangeListenerWrapper(RealmChangeListener<T> realmChangeListener) {
            this.listener = realmChangeListener;
        }

        public boolean equals(Object obj) {
            return (obj instanceof RealmChangeListenerWrapper) && this.listener == ((RealmChangeListenerWrapper) obj).listener;
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void onChange(T t, OrderedCollectionChangeSet orderedCollectionChangeSet) {
            this.listener.onChange(t);
        }
    }

    void notifyChangeListeners(long j);
}
