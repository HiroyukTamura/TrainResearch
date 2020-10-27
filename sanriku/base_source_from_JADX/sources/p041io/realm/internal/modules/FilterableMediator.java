package p041io.realm.internal.modules;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p041io.realm.ImportFlag;
import p041io.realm.Realm;
import p041io.realm.RealmModel;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.RealmProxyMediator;
import p041io.realm.internal.Row;
import p041io.realm.internal.Util;

/* renamed from: io.realm.internal.modules.FilterableMediator */
public class FilterableMediator extends RealmProxyMediator {
    private final Set<Class<? extends RealmModel>> allowedClasses;
    private final RealmProxyMediator originalMediator;

    public FilterableMediator(RealmProxyMediator realmProxyMediator, Collection<Class<? extends RealmModel>> collection) {
        this.originalMediator = realmProxyMediator;
        HashSet hashSet = new HashSet();
        if (realmProxyMediator != null) {
            Set<Class<? extends RealmModel>> modelClasses = realmProxyMediator.getModelClasses();
            for (Class next : collection) {
                if (modelClasses.contains(next)) {
                    hashSet.add(next);
                }
            }
        }
        this.allowedClasses = Collections.unmodifiableSet(hashSet);
    }

    private void checkSchemaHasClass(Class<? extends RealmModel> cls) {
        if (!this.allowedClasses.contains(cls)) {
            throw new IllegalArgumentException(cls.getSimpleName() + " is not part of the schema for this Realm");
        }
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        checkSchemaHasClass(Util.getOriginalModelClass(e.getClass()));
        return this.originalMediator.copyOrUpdate(realm, e, z, map, set);
    }

    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        checkSchemaHasClass(cls);
        return this.originalMediator.createColumnInfo(cls, osSchemaInfo);
    }

    public <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        checkSchemaHasClass(Util.getOriginalModelClass(e.getClass()));
        return this.originalMediator.createDetachedCopy(e, i, map);
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> cls, Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        checkSchemaHasClass(cls);
        return this.originalMediator.createOrUpdateUsingJsonObject(cls, realm, jSONObject, z);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> cls, Realm realm, JsonReader jsonReader) throws IOException {
        checkSchemaHasClass(cls);
        return this.originalMediator.createUsingJsonStream(cls, realm, jsonReader);
    }

    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.originalMediator.getExpectedObjectSchemaInfoMap().entrySet()) {
            if (this.allowedClasses.contains(next.getKey())) {
                hashMap.put((Class) next.getKey(), (OsObjectSchemaInfo) next.getValue());
            }
        }
        return hashMap;
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return this.allowedClasses;
    }

    /* access modifiers changed from: protected */
    public String getSimpleClassNameImpl(Class<? extends RealmModel> cls) {
        checkSchemaHasClass(cls);
        return this.originalMediator.getSimpleClassName(cls);
    }

    public void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        checkSchemaHasClass(Util.getOriginalModelClass(realmModel.getClass()));
        this.originalMediator.insert(realm, realmModel, map);
    }

    public void insert(Realm realm, Collection<? extends RealmModel> collection) {
        checkSchemaHasClass(Util.getOriginalModelClass(((RealmModel) collection.iterator().next()).getClass()));
        this.originalMediator.insert(realm, collection);
    }

    public void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        checkSchemaHasClass(Util.getOriginalModelClass(realmModel.getClass()));
        this.originalMediator.insertOrUpdate(realm, realmModel, map);
    }

    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> collection) {
        checkSchemaHasClass(Util.getOriginalModelClass(((RealmModel) collection.iterator().next()).getClass()));
        this.originalMediator.insertOrUpdate(realm, collection);
    }

    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        checkSchemaHasClass(cls);
        return this.originalMediator.newInstance(cls, obj, row, columnInfo, z, list);
    }

    public boolean transformerApplied() {
        RealmProxyMediator realmProxyMediator = this.originalMediator;
        if (realmProxyMediator == null) {
            return true;
        }
        return realmProxyMediator.transformerApplied();
    }
}
