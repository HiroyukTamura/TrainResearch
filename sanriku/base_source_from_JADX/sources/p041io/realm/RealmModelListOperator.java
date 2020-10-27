package p041io.realm;

import java.util.Locale;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.OsList;
import p041io.realm.internal.OsObjectStore;
import p041io.realm.internal.RealmObjectProxy;

/* renamed from: io.realm.RealmModelListOperator */
final class RealmModelListOperator<T> extends ManagedListOperator<T> {
    private final String className;

    RealmModelListOperator(BaseRealm baseRealm, OsList osList, Class<T> cls, String str) {
        super(baseRealm, osList, cls);
        this.className = str;
    }

    private void checkInsertIndex(int i) {
        int size = size();
        if (i < 0 || size < i) {
            StringBuilder b = C0681a.m338b("Invalid index ", i, ", size is ");
            b.append(this.osList.size());
            throw new IndexOutOfBoundsException(b.toString());
        }
    }

    private <E extends RealmModel> E copyToRealmIfNeeded(E e) {
        if (e instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) e;
            if (realmObjectProxy instanceof DynamicRealmObject) {
                String str = this.className;
                BaseRealm realm$realm = realmObjectProxy.realmGet$proxyState().getRealm$realm();
                BaseRealm baseRealm = this.realm;
                if (realm$realm == baseRealm) {
                    String type = ((DynamicRealmObject) e).getType();
                    if (str.equals(type)) {
                        return e;
                    }
                    throw new IllegalArgumentException(String.format(Locale.US, "The object has a different type from list's. Type of the list is '%s', type of object is '%s'.", new Object[]{str, type}));
                } else if (baseRealm.threadId == realmObjectProxy.realmGet$proxyState().getRealm$realm().threadId) {
                    throw new IllegalArgumentException("Cannot copy DynamicRealmObject between Realm instances.");
                } else {
                    throw new IllegalStateException("Cannot copy an object to a Realm instance created in another thread.");
                }
            } else if (realmObjectProxy.realmGet$proxyState().getRow$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(this.realm.getPath())) {
                if (this.realm == realmObjectProxy.realmGet$proxyState().getRealm$realm()) {
                    return e;
                }
                throw new IllegalArgumentException("Cannot copy an object from another Realm instance.");
            }
        }
        Realm realm = (Realm) this.realm;
        ImportFlag[] importFlagArr = new ImportFlag[0];
        return OsObjectStore.getPrimaryKeyForObject(realm.getSharedRealm(), realm.getConfiguration().getSchemaMediator().getSimpleClassName(e.getClass())) != null ? realm.copyToRealmOrUpdate(e, importFlagArr) : realm.copyToRealm(e, importFlagArr);
    }

    public void appendValue(Object obj) {
        this.osList.addRow(((RealmObjectProxy) copyToRealmIfNeeded((RealmModel) obj)).realmGet$proxyState().getRow$realm().getIndex());
    }

    /* access modifiers changed from: protected */
    public void checkValidValue(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("RealmList does not accept null values.");
        } else if (!(obj instanceof RealmModel)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", new Object[]{"java.lang.String", obj.getClass().getName()}));
        }
    }

    public boolean forRealmModel() {
        return true;
    }

    public T get(int i) {
        return this.realm.get(this.clazz, this.className, this.osList.getUncheckedRow((long) i));
    }

    /* access modifiers changed from: protected */
    public void insertNull(int i) {
        throw new RuntimeException("Should not reach here.");
    }

    public void insertValue(int i, Object obj) {
        checkInsertIndex(i);
        this.osList.insertRow((long) i, ((RealmObjectProxy) copyToRealmIfNeeded((RealmModel) obj)).realmGet$proxyState().getRow$realm().getIndex());
    }

    /* access modifiers changed from: protected */
    public void setNull(int i) {
        throw new RuntimeException("Should not reach here.");
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, Object obj) {
        this.osList.setRow((long) i, ((RealmObjectProxy) copyToRealmIfNeeded((RealmModel) obj)).realmGet$proxyState().getRow$realm().getIndex());
    }
}
