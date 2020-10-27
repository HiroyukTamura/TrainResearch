package p041io.realm.internal.modules;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p041io.realm.ImportFlag;
import p041io.realm.Realm;
import p041io.realm.RealmModel;
import p041io.realm.exceptions.RealmException;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.RealmProxyMediator;
import p041io.realm.internal.Row;
import p041io.realm.internal.Util;

/* renamed from: io.realm.internal.modules.CompositeMediator */
public class CompositeMediator extends RealmProxyMediator {
    private final Map<String, Class<? extends RealmModel>> internalClassNames = new HashMap();
    private final Map<Class<? extends RealmModel>, RealmProxyMediator> mediators;

    public CompositeMediator(RealmProxyMediator... realmProxyMediatorArr) {
        HashMap hashMap = new HashMap();
        if (realmProxyMediatorArr != null) {
            for (RealmProxyMediator realmProxyMediator : realmProxyMediatorArr) {
                for (Class next : realmProxyMediator.getModelClasses()) {
                    String simpleClassName = realmProxyMediator.getSimpleClassName(next);
                    Class cls = this.internalClassNames.get(simpleClassName);
                    if (cls == null || cls.equals(next)) {
                        hashMap.put(next, realmProxyMediator);
                        this.internalClassNames.put(simpleClassName, next);
                    } else {
                        throw new IllegalStateException(String.format("It is not allowed for two different model classes to share the same internal name in Realm. The classes %s and %s are being included from the modules '%s' and '%s' and they share the same internal name '%s'.", new Object[]{cls, next, hashMap.get(cls), realmProxyMediator, simpleClassName}));
                    }
                }
            }
        }
        this.mediators = Collections.unmodifiableMap(hashMap);
    }

    private RealmProxyMediator getMediator(Class<? extends RealmModel> cls) {
        RealmProxyMediator realmProxyMediator = this.mediators.get(cls);
        if (realmProxyMediator != null) {
            return realmProxyMediator;
        }
        throw new RealmException(cls.getSimpleName() + " is not part of the schema for this Realm");
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        return getMediator(Util.getOriginalModelClass(e.getClass())).copyOrUpdate(realm, e, z, map, set);
    }

    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        return getMediator(cls).createColumnInfo(cls, osSchemaInfo);
    }

    public <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        return getMediator(Util.getOriginalModelClass(e.getClass())).createDetachedCopy(e, i, map);
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> cls, Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        return getMediator(cls).createOrUpdateUsingJsonObject(cls, realm, jSONObject, z);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> cls, Realm realm, JsonReader jsonReader) throws IOException {
        return getMediator(cls).createUsingJsonStream(cls, realm, jsonReader);
    }

    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap();
        for (RealmProxyMediator expectedObjectSchemaInfoMap : this.mediators.values()) {
            hashMap.putAll(expectedObjectSchemaInfoMap.getExpectedObjectSchemaInfoMap());
        }
        return hashMap;
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return this.mediators.keySet();
    }

    /* access modifiers changed from: protected */
    public String getSimpleClassNameImpl(Class<? extends RealmModel> cls) {
        return getMediator(cls).getSimpleClassName(cls);
    }

    public void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        getMediator(Util.getOriginalModelClass(realmModel.getClass())).insert(realm, realmModel, map);
    }

    public void insert(Realm realm, Collection<? extends RealmModel> collection) {
        getMediator(Util.getOriginalModelClass(Util.getOriginalModelClass(((RealmModel) collection.iterator().next()).getClass()))).insert(realm, collection);
    }

    public void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        getMediator(Util.getOriginalModelClass(realmModel.getClass())).insertOrUpdate(realm, realmModel, map);
    }

    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> collection) {
        getMediator(Util.getOriginalModelClass(Util.getOriginalModelClass(((RealmModel) collection.iterator().next()).getClass()))).insertOrUpdate(realm, collection);
    }

    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        return getMediator(cls).newInstance(cls, obj, row, columnInfo, z, list);
    }

    public boolean transformerApplied() {
        for (Map.Entry<Class<? extends RealmModel>, RealmProxyMediator> value : this.mediators.entrySet()) {
            if (!((RealmProxyMediator) value.getValue()).transformerApplied()) {
                return false;
            }
        }
        return true;
    }
}
