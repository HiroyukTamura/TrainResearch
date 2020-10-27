package p041io.realm;

import java.util.List;
import p041io.realm.RealmModel;
import p041io.realm.internal.ObserverPairList;
import p041io.realm.internal.OsObject;
import p041io.realm.internal.OsSharedRealm;
import p041io.realm.internal.PendingRow;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Row;
import p041io.realm.internal.UncheckedRow;

/* renamed from: io.realm.ProxyState */
public final class ProxyState<E extends RealmModel> implements PendingRow.FrontEnd {
    private static QueryCallback queryCallback = new QueryCallback();
    private boolean acceptDefaultValue;
    private List<String> excludeFields;
    private E model;
    private ObserverPairList<OsObject.ObjectObserverPair> observerPairs = new ObserverPairList<>();
    private OsObject osObject;
    private BaseRealm realm;
    private Row row;
    private boolean underConstruction = true;

    /* renamed from: io.realm.ProxyState$QueryCallback */
    private static class QueryCallback implements ObserverPairList.Callback<OsObject.ObjectObserverPair> {
        private QueryCallback() {
        }

        public void onCalled(OsObject.ObjectObserverPair objectObserverPair, Object obj) {
            objectObserverPair.onChange((RealmModel) obj, (ObjectChangeSet) null);
        }
    }

    /* renamed from: io.realm.ProxyState$RealmChangeListenerWrapper */
    static class RealmChangeListenerWrapper<T extends RealmModel> implements RealmObjectChangeListener<T> {
        private final RealmChangeListener<T> listener;

        RealmChangeListenerWrapper(RealmChangeListener<T> realmChangeListener) {
            if (realmChangeListener != null) {
                this.listener = realmChangeListener;
                return;
            }
            throw new IllegalArgumentException("Listener should not be null");
        }

        public boolean equals(Object obj) {
            return (obj instanceof RealmChangeListenerWrapper) && this.listener == ((RealmChangeListenerWrapper) obj).listener;
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void onChange(T t, ObjectChangeSet objectChangeSet) {
            this.listener.onChange(t);
        }
    }

    public ProxyState() {
    }

    public ProxyState(E e) {
        this.model = e;
    }

    private void notifyQueryFinished() {
        this.observerPairs.foreach(queryCallback);
    }

    private void registerToObjectNotifier() {
        OsSharedRealm osSharedRealm = this.realm.sharedRealm;
        if (osSharedRealm != null && !osSharedRealm.isClosed() && this.row.isAttached() && this.osObject == null) {
            OsObject osObject2 = new OsObject(this.realm.sharedRealm, (UncheckedRow) this.row);
            this.osObject = osObject2;
            osObject2.setObserverPairs(this.observerPairs);
            this.observerPairs = null;
        }
    }

    public void addChangeListener(RealmObjectChangeListener<E> realmObjectChangeListener) {
        Row row2 = this.row;
        if (row2 instanceof PendingRow) {
            this.observerPairs.add(new OsObject.ObjectObserverPair(this.model, realmObjectChangeListener));
        } else if (row2 instanceof UncheckedRow) {
            registerToObjectNotifier();
            OsObject osObject2 = this.osObject;
            if (osObject2 != null) {
                osObject2.addListener(this.model, realmObjectChangeListener);
            }
        }
    }

    public void checkValidObject(RealmModel realmModel) {
        if (!RealmObject.isValid(realmModel) || !RealmObject.isManaged(realmModel)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        } else if (((RealmObjectProxy) realmModel).realmGet$proxyState().getRealm$realm() != getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
    }

    public boolean getAcceptDefaultValue$realm() {
        return this.acceptDefaultValue;
    }

    public List<String> getExcludeFields$realm() {
        return this.excludeFields;
    }

    public BaseRealm getRealm$realm() {
        return this.realm;
    }

    public Row getRow$realm() {
        return this.row;
    }

    public boolean isLoaded() {
        return !(this.row instanceof PendingRow);
    }

    public boolean isUnderConstruction() {
        return this.underConstruction;
    }

    public void load() {
        Row row2 = this.row;
        if (row2 instanceof PendingRow) {
            ((PendingRow) row2).executeQuery();
        }
    }

    public void onQueryFinished(Row row2) {
        this.row = row2;
        notifyQueryFinished();
        if (row2.isAttached()) {
            registerToObjectNotifier();
        }
    }

    public void removeAllChangeListeners() {
        OsObject osObject2 = this.osObject;
        if (osObject2 != null) {
            osObject2.removeListener(this.model);
        } else {
            this.observerPairs.clear();
        }
    }

    public void removeChangeListener(RealmObjectChangeListener<E> realmObjectChangeListener) {
        OsObject osObject2 = this.osObject;
        if (osObject2 != null) {
            osObject2.removeListener(this.model, realmObjectChangeListener);
        } else {
            this.observerPairs.remove(this.model, realmObjectChangeListener);
        }
    }

    public void setAcceptDefaultValue$realm(boolean z) {
        this.acceptDefaultValue = z;
    }

    public void setConstructionFinished() {
        this.underConstruction = false;
        this.excludeFields = null;
    }

    public void setExcludeFields$realm(List<String> list) {
        this.excludeFields = list;
    }

    public void setRealm$realm(BaseRealm baseRealm) {
        this.realm = baseRealm;
    }

    public void setRow$realm(Row row2) {
        this.row = row2;
    }
}
