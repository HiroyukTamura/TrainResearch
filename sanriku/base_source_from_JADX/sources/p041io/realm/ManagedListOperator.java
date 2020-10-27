package p041io.realm;

import p041io.realm.internal.OsList;

/* renamed from: io.realm.ManagedListOperator */
abstract class ManagedListOperator<T> {
    static final String INVALID_OBJECT_TYPE_MESSAGE = "Unacceptable value type. Acceptable: %1$s, actual: %2$s .";
    static final String NULL_OBJECTS_NOT_ALLOWED_MESSAGE = "RealmList does not accept null values.";
    final Class<T> clazz;
    final OsList osList;
    final BaseRealm realm;

    ManagedListOperator(BaseRealm baseRealm, OsList osList2, Class<T> cls) {
        this.realm = baseRealm;
        this.clazz = cls;
        this.osList = osList2;
    }

    private void appendNull() {
        this.osList.addNull();
    }

    public final void append(Object obj) {
        checkValidValue(obj);
        if (obj == null) {
            appendNull();
        } else {
            appendValue(obj);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void appendValue(Object obj);

    /* access modifiers changed from: protected */
    public abstract void checkValidValue(Object obj);

    /* access modifiers changed from: package-private */
    public final void delete(int i) {
        this.osList.delete((long) i);
    }

    /* access modifiers changed from: package-private */
    public final void deleteAll() {
        this.osList.deleteAll();
    }

    /* access modifiers changed from: package-private */
    public final void deleteLast() {
        OsList osList2 = this.osList;
        osList2.delete(osList2.size() - 1);
    }

    public abstract boolean forRealmModel();

    public abstract T get(int i);

    public final OsList getOsList() {
        return this.osList;
    }

    public final void insert(int i, Object obj) {
        checkValidValue(obj);
        if (obj == null) {
            insertNull(i);
        } else {
            insertValue(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void insertNull(int i) {
        this.osList.insertNull((long) i);
    }

    /* access modifiers changed from: protected */
    public abstract void insertValue(int i, Object obj);

    public final boolean isEmpty() {
        return this.osList.isEmpty();
    }

    public final boolean isValid() {
        return this.osList.isValid();
    }

    /* access modifiers changed from: package-private */
    public final void move(int i, int i2) {
        this.osList.move((long) i, (long) i2);
    }

    /* access modifiers changed from: package-private */
    public final void remove(int i) {
        this.osList.remove((long) i);
    }

    /* access modifiers changed from: package-private */
    public final void removeAll() {
        this.osList.removeAll();
    }

    public final T set(int i, Object obj) {
        checkValidValue(obj);
        T t = get(i);
        if (obj == null) {
            setNull(i);
        } else {
            setValue(i, obj);
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public void setNull(int i) {
        this.osList.setNull((long) i);
    }

    /* access modifiers changed from: protected */
    public abstract void setValue(int i, Object obj);

    public final int size() {
        long size = this.osList.size();
        if (size < 2147483647L) {
            return (int) size;
        }
        return Integer.MAX_VALUE;
    }
}
