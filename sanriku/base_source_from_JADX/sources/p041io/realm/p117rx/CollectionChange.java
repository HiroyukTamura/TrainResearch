package p041io.realm.p117rx;

import p041io.realm.OrderedCollectionChangeSet;
import p041io.realm.OrderedRealmCollection;

/* renamed from: io.realm.rx.CollectionChange */
public class CollectionChange<E extends OrderedRealmCollection> {
    private final OrderedCollectionChangeSet changeset;
    private final E collection;

    public CollectionChange(E e, OrderedCollectionChangeSet orderedCollectionChangeSet) {
        this.collection = e;
        this.changeset = orderedCollectionChangeSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CollectionChange.class != obj.getClass()) {
            return false;
        }
        CollectionChange collectionChange = (CollectionChange) obj;
        if (!this.collection.equals(collectionChange.collection)) {
            return false;
        }
        OrderedCollectionChangeSet orderedCollectionChangeSet = this.changeset;
        OrderedCollectionChangeSet orderedCollectionChangeSet2 = collectionChange.changeset;
        return orderedCollectionChangeSet != null ? orderedCollectionChangeSet.equals(orderedCollectionChangeSet2) : orderedCollectionChangeSet2 == null;
    }

    public OrderedCollectionChangeSet getChangeset() {
        return this.changeset;
    }

    public E getCollection() {
        return this.collection;
    }

    public int hashCode() {
        int hashCode = this.collection.hashCode() * 31;
        OrderedCollectionChangeSet orderedCollectionChangeSet = this.changeset;
        return hashCode + (orderedCollectionChangeSet != null ? orderedCollectionChangeSet.hashCode() : 0);
    }
}
