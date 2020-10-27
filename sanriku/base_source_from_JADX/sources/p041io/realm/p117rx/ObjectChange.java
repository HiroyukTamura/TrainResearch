package p041io.realm.p117rx;

import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.ObjectChangeSet;
import p041io.realm.RealmModel;

/* renamed from: io.realm.rx.ObjectChange */
public class ObjectChange<E extends RealmModel> {
    private final ObjectChangeSet changeset;
    private final E object;

    public ObjectChange(E e, ObjectChangeSet objectChangeSet) {
        this.object = e;
        this.changeset = objectChangeSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ObjectChange.class != obj.getClass()) {
            return false;
        }
        ObjectChange objectChange = (ObjectChange) obj;
        if (!this.object.equals(objectChange.object)) {
            return false;
        }
        ObjectChangeSet objectChangeSet = this.changeset;
        ObjectChangeSet objectChangeSet2 = objectChange.changeset;
        return objectChangeSet != null ? objectChangeSet.equals(objectChangeSet2) : objectChangeSet2 == null;
    }

    public ObjectChangeSet getChangeset() {
        return this.changeset;
    }

    public E getObject() {
        return this.object;
    }

    public int hashCode() {
        int hashCode = this.object.hashCode() * 31;
        ObjectChangeSet objectChangeSet = this.changeset;
        return hashCode + (objectChangeSet != null ? objectChangeSet.hashCode() : 0);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("ObjectChange{object=");
        a.append(this.object);
        a.append(", changeset=");
        a.append(this.changeset);
        a.append('}');
        return a.toString();
    }
}
