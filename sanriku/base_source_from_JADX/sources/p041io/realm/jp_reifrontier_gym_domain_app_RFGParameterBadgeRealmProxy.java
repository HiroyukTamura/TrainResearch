package p041io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.BaseRealm;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObject;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Row;
import p041io.realm.internal.Table;
import p041io.realm.internal.objectstore.OsObjectBuilder;
import p043jp.reifrontier.gym.domain.app.RFGParameterBadge;

/* renamed from: io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy */
public class jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy extends RFGParameterBadge implements RealmObjectProxy, C1011x6905d40d {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGParameterBadgeColumnInfo columnInfo;
    private ProxyState<RFGParameterBadge> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGParameterBadge";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy$RFGParameterBadgeColumnInfo */
    static final class RFGParameterBadgeColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long parameterIdIndex;

        RFGParameterBadgeColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGParameterBadgeColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.parameterIdIndex = addColumnDetails("parameterId", "parameterId", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGParameterBadgeColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGParameterBadgeColumnInfo rFGParameterBadgeColumnInfo = (RFGParameterBadgeColumnInfo) columnInfo;
            RFGParameterBadgeColumnInfo rFGParameterBadgeColumnInfo2 = (RFGParameterBadgeColumnInfo) columnInfo2;
            rFGParameterBadgeColumnInfo2.parameterIdIndex = rFGParameterBadgeColumnInfo.parameterIdIndex;
            rFGParameterBadgeColumnInfo2.maxColumnIndexValue = rFGParameterBadgeColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGParameterBadge copy(Realm realm, RFGParameterBadgeColumnInfo rFGParameterBadgeColumnInfo, RFGParameterBadge rFGParameterBadge, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGParameterBadge);
        if (realmObjectProxy != null) {
            return (RFGParameterBadge) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGParameterBadge.class), rFGParameterBadgeColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGParameterBadgeColumnInfo.parameterIdIndex, rFGParameterBadge.realmGet$parameterId());
        jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGParameterBadge, newProxyInstance);
        return newProxyInstance;
    }

    public static RFGParameterBadge copyOrUpdate(Realm realm, RFGParameterBadgeColumnInfo rFGParameterBadgeColumnInfo, RFGParameterBadge rFGParameterBadge, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        if (rFGParameterBadge instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGParameterBadge;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null) {
                BaseRealm realm$realm = realmObjectProxy.realmGet$proxyState().getRealm$realm();
                if (realm$realm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (realm$realm.getPath().equals(realm.getPath())) {
                    return rFGParameterBadge;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(rFGParameterBadge);
        return realmObjectProxy2 != null ? (RFGParameterBadge) realmObjectProxy2 : copy(realm, rFGParameterBadgeColumnInfo, rFGParameterBadge, z, map, set);
    }

    public static RFGParameterBadgeColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGParameterBadgeColumnInfo(osSchemaInfo);
    }

    public static RFGParameterBadge createDetachedCopy(RFGParameterBadge rFGParameterBadge, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGParameterBadge rFGParameterBadge2;
        if (i > i2 || rFGParameterBadge == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGParameterBadge);
        if (cacheData == null) {
            rFGParameterBadge2 = new RFGParameterBadge();
            map.put(rFGParameterBadge, new RealmObjectProxy.CacheData(i, rFGParameterBadge2));
        } else if (i >= cacheData.minDepth) {
            return (RFGParameterBadge) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGParameterBadge2 = (RFGParameterBadge) cacheData.object;
        }
        rFGParameterBadge2.realmSet$parameterId(rFGParameterBadge.realmGet$parameterId());
        return rFGParameterBadge2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 1, 0);
        builder.addPersistedProperty("parameterId", RealmFieldType.STRING, false, false, true);
        return builder.build();
    }

    public static RFGParameterBadge createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        RFGParameterBadge rFGParameterBadge = (RFGParameterBadge) realm.createObjectInternal(RFGParameterBadge.class, true, Collections.emptyList());
        if (jSONObject.has("parameterId")) {
            rFGParameterBadge.realmSet$parameterId(jSONObject.isNull("parameterId") ? null : jSONObject.getString("parameterId"));
        }
        return rFGParameterBadge;
    }

    @TargetApi(11)
    public static RFGParameterBadge createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        String str;
        RFGParameterBadge rFGParameterBadge = new RFGParameterBadge();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("parameterId")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    str = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                    str = null;
                }
                rFGParameterBadge.realmSet$parameterId(str);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return (RFGParameterBadge) realm.copyToRealm(rFGParameterBadge, new ImportFlag[0]);
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGParameterBadge rFGParameterBadge, Map<RealmModel, Long> map) {
        Class<RFGParameterBadge> cls = RFGParameterBadge.class;
        if (rFGParameterBadge instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGParameterBadge;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGParameterBadgeColumnInfo rFGParameterBadgeColumnInfo = (RFGParameterBadgeColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGParameterBadge, Long.valueOf(createRow));
        String realmGet$parameterId = rFGParameterBadge.realmGet$parameterId();
        if (realmGet$parameterId != null) {
            Table.nativeSetString(nativePtr, rFGParameterBadgeColumnInfo.parameterIdIndex, createRow, realmGet$parameterId, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Class<RFGParameterBadge> cls = RFGParameterBadge.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGParameterBadgeColumnInfo rFGParameterBadgeColumnInfo = (RFGParameterBadgeColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGParameterBadge rFGParameterBadge = (RFGParameterBadge) it.next();
            if (!map.containsKey(rFGParameterBadge)) {
                if (rFGParameterBadge instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGParameterBadge;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map.put(rFGParameterBadge, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map.put(rFGParameterBadge, Long.valueOf(createRow));
                String realmGet$parameterId = rFGParameterBadge.realmGet$parameterId();
                if (realmGet$parameterId != null) {
                    Table.nativeSetString(nativePtr, rFGParameterBadgeColumnInfo.parameterIdIndex, createRow, realmGet$parameterId, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGParameterBadge rFGParameterBadge, Map<RealmModel, Long> map) {
        Class<RFGParameterBadge> cls = RFGParameterBadge.class;
        if (rFGParameterBadge instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGParameterBadge;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        long createRow = OsObject.createRow(table);
        map.put(rFGParameterBadge, Long.valueOf(createRow));
        String realmGet$parameterId = rFGParameterBadge.realmGet$parameterId();
        long j = ((RFGParameterBadgeColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls)).parameterIdIndex;
        if (realmGet$parameterId != null) {
            Table.nativeSetString(nativePtr, j, createRow, realmGet$parameterId, false);
        } else {
            Table.nativeSetNull(nativePtr, j, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Class<RFGParameterBadge> cls = RFGParameterBadge.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGParameterBadgeColumnInfo rFGParameterBadgeColumnInfo = (RFGParameterBadgeColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGParameterBadge rFGParameterBadge = (RFGParameterBadge) it.next();
            if (!map.containsKey(rFGParameterBadge)) {
                if (rFGParameterBadge instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGParameterBadge;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map.put(rFGParameterBadge, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map.put(rFGParameterBadge, Long.valueOf(createRow));
                String realmGet$parameterId = rFGParameterBadge.realmGet$parameterId();
                long j = rFGParameterBadgeColumnInfo.parameterIdIndex;
                if (realmGet$parameterId != null) {
                    Table.nativeSetString(nativePtr, j, createRow, realmGet$parameterId, false);
                } else {
                    Table.nativeSetNull(nativePtr, j, createRow, false);
                }
            }
        }
    }

    private static jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGParameterBadge.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy jp_reifrontier_gym_domain_app_rfgparameterbadgerealmproxy = new jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_app_rfgparameterbadgerealmproxy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy jp_reifrontier_gym_domain_app_rfgparameterbadgerealmproxy = (jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_app_rfgparameterbadgerealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_app_rfgparameterbadgerealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_app_rfgparameterbadgerealmproxy.proxyState.getRow$realm().getIndex();
        }
        return false;
    }

    public int hashCode() {
        String path = this.proxyState.getRealm$realm().getPath();
        String a = C0681a.m315a((ProxyState) this.proxyState);
        long index = this.proxyState.getRow$realm().getIndex();
        int i = 0;
        int hashCode = ((path != null ? path.hashCode() : 0) + 527) * 31;
        if (a != null) {
            i = a.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (index ^ (index >>> 32)));
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RFGParameterBadgeColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGParameterBadge> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$parameterId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.parameterIdIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public void realmSet$parameterId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.parameterIdIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'parameterId' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.parameterIdIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'parameterId' to null.");
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGParameterBadge = proxy[", "{parameterId:");
        b.append(realmGet$parameterId());
        b.append("}");
        b.append("]");
        return b.toString();
    }
}
