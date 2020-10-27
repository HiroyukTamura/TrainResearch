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
import p043jp.reifrontier.gym.domain.api.RFGHistory;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy */
public class jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy extends RFGHistory implements RealmObjectProxy, jp_reifrontier_gym_domain_api_RFGHistoryRealmProxyInterface {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGHistoryColumnInfo columnInfo;
    private ProxyState<RFGHistory> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGHistory";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy$RFGHistoryColumnInfo */
    static final class RFGHistoryColumnInfo extends ColumnInfo {
        long gymIdIndex;
        long heightIndex;
        long historyIdIndex;
        long maxColumnIndexValue;
        long updated_atIndex;
        long weightIndex;

        RFGHistoryColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGHistoryColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.historyIdIndex = addColumnDetails("historyId", "historyId", objectSchemaInfo);
            this.gymIdIndex = addColumnDetails("gymId", "gymId", objectSchemaInfo);
            this.heightIndex = addColumnDetails("height", "height", objectSchemaInfo);
            this.weightIndex = addColumnDetails("weight", "weight", objectSchemaInfo);
            this.updated_atIndex = addColumnDetails("updated_at", "updated_at", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGHistoryColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGHistoryColumnInfo rFGHistoryColumnInfo = (RFGHistoryColumnInfo) columnInfo;
            RFGHistoryColumnInfo rFGHistoryColumnInfo2 = (RFGHistoryColumnInfo) columnInfo2;
            rFGHistoryColumnInfo2.historyIdIndex = rFGHistoryColumnInfo.historyIdIndex;
            rFGHistoryColumnInfo2.gymIdIndex = rFGHistoryColumnInfo.gymIdIndex;
            rFGHistoryColumnInfo2.heightIndex = rFGHistoryColumnInfo.heightIndex;
            rFGHistoryColumnInfo2.weightIndex = rFGHistoryColumnInfo.weightIndex;
            rFGHistoryColumnInfo2.updated_atIndex = rFGHistoryColumnInfo.updated_atIndex;
            rFGHistoryColumnInfo2.maxColumnIndexValue = rFGHistoryColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGHistory copy(Realm realm, RFGHistoryColumnInfo rFGHistoryColumnInfo, RFGHistory rFGHistory, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGHistory);
        if (realmObjectProxy != null) {
            return (RFGHistory) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGHistory.class), rFGHistoryColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGHistoryColumnInfo.historyIdIndex, rFGHistory.realmGet$historyId());
        osObjectBuilder.addString(rFGHistoryColumnInfo.gymIdIndex, rFGHistory.realmGet$gymId());
        osObjectBuilder.addString(rFGHistoryColumnInfo.heightIndex, rFGHistory.realmGet$height());
        osObjectBuilder.addString(rFGHistoryColumnInfo.weightIndex, rFGHistory.realmGet$weight());
        osObjectBuilder.addString(rFGHistoryColumnInfo.updated_atIndex, rFGHistory.realmGet$updated_at());
        jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGHistory, newProxyInstance);
        return newProxyInstance;
    }

    public static RFGHistory copyOrUpdate(Realm realm, RFGHistoryColumnInfo rFGHistoryColumnInfo, RFGHistory rFGHistory, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        if (rFGHistory instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGHistory;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null) {
                BaseRealm realm$realm = realmObjectProxy.realmGet$proxyState().getRealm$realm();
                if (realm$realm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (realm$realm.getPath().equals(realm.getPath())) {
                    return rFGHistory;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(rFGHistory);
        return realmObjectProxy2 != null ? (RFGHistory) realmObjectProxy2 : copy(realm, rFGHistoryColumnInfo, rFGHistory, z, map, set);
    }

    public static RFGHistoryColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGHistoryColumnInfo(osSchemaInfo);
    }

    public static RFGHistory createDetachedCopy(RFGHistory rFGHistory, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGHistory rFGHistory2;
        if (i > i2 || rFGHistory == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGHistory);
        if (cacheData == null) {
            rFGHistory2 = new RFGHistory();
            map.put(rFGHistory, new RealmObjectProxy.CacheData(i, rFGHistory2));
        } else if (i >= cacheData.minDepth) {
            return (RFGHistory) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGHistory2 = (RFGHistory) cacheData.object;
        }
        rFGHistory2.realmSet$historyId(rFGHistory.realmGet$historyId());
        rFGHistory2.realmSet$gymId(rFGHistory.realmGet$gymId());
        rFGHistory2.realmSet$height(rFGHistory.realmGet$height());
        rFGHistory2.realmSet$weight(rFGHistory.realmGet$weight());
        rFGHistory2.realmSet$updated_at(rFGHistory.realmGet$updated_at());
        return rFGHistory2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 5, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("historyId", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("gymId", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("height", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("weight", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("updated_at", RealmFieldType.STRING, false, false, true);
        return builder.build();
    }

    public static RFGHistory createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        RFGHistory rFGHistory = (RFGHistory) realm.createObjectInternal(RFGHistory.class, true, Collections.emptyList());
        if (jSONObject.has("historyId")) {
            if (jSONObject.isNull("historyId")) {
                rFGHistory.realmSet$historyId((String) null);
            } else {
                rFGHistory.realmSet$historyId(jSONObject.getString("historyId"));
            }
        }
        if (jSONObject.has("gymId")) {
            if (jSONObject.isNull("gymId")) {
                rFGHistory.realmSet$gymId((String) null);
            } else {
                rFGHistory.realmSet$gymId(jSONObject.getString("gymId"));
            }
        }
        if (jSONObject.has("height")) {
            if (jSONObject.isNull("height")) {
                rFGHistory.realmSet$height((String) null);
            } else {
                rFGHistory.realmSet$height(jSONObject.getString("height"));
            }
        }
        if (jSONObject.has("weight")) {
            if (jSONObject.isNull("weight")) {
                rFGHistory.realmSet$weight((String) null);
            } else {
                rFGHistory.realmSet$weight(jSONObject.getString("weight"));
            }
        }
        if (jSONObject.has("updated_at")) {
            if (jSONObject.isNull("updated_at")) {
                rFGHistory.realmSet$updated_at((String) null);
            } else {
                rFGHistory.realmSet$updated_at(jSONObject.getString("updated_at"));
            }
        }
        return rFGHistory;
    }

    @TargetApi(11)
    public static RFGHistory createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGHistory rFGHistory = new RFGHistory();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("historyId")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGHistory.realmSet$historyId(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGHistory.realmSet$historyId((String) null);
                }
            } else if (nextName.equals("gymId")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGHistory.realmSet$gymId(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGHistory.realmSet$gymId((String) null);
                }
            } else if (nextName.equals("height")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGHistory.realmSet$height(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGHistory.realmSet$height((String) null);
                }
            } else if (nextName.equals("weight")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGHistory.realmSet$weight(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGHistory.realmSet$weight((String) null);
                }
            } else if (!nextName.equals("updated_at")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGHistory.realmSet$updated_at(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                rFGHistory.realmSet$updated_at((String) null);
            }
        }
        jsonReader.endObject();
        return (RFGHistory) realm.copyToRealm(rFGHistory, new ImportFlag[0]);
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGHistory rFGHistory, Map<RealmModel, Long> map) {
        Class<RFGHistory> cls = RFGHistory.class;
        if (rFGHistory instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGHistory;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGHistoryColumnInfo rFGHistoryColumnInfo = (RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGHistory, Long.valueOf(createRow));
        String realmGet$historyId = rFGHistory.realmGet$historyId();
        if (realmGet$historyId != null) {
            Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.historyIdIndex, createRow, realmGet$historyId, false);
        }
        String realmGet$gymId = rFGHistory.realmGet$gymId();
        if (realmGet$gymId != null) {
            Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.gymIdIndex, createRow, realmGet$gymId, false);
        }
        String realmGet$height = rFGHistory.realmGet$height();
        if (realmGet$height != null) {
            Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.heightIndex, createRow, realmGet$height, false);
        }
        String realmGet$weight = rFGHistory.realmGet$weight();
        if (realmGet$weight != null) {
            Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.weightIndex, createRow, realmGet$weight, false);
        }
        String realmGet$updated_at = rFGHistory.realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.updated_atIndex, createRow, realmGet$updated_at, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Map<RealmModel, Long> map2 = map;
        Class<RFGHistory> cls = RFGHistory.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGHistoryColumnInfo rFGHistoryColumnInfo = (RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGHistory rFGHistory = (RFGHistory) it.next();
            if (!map2.containsKey(rFGHistory)) {
                if (rFGHistory instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGHistory;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGHistory, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGHistory, Long.valueOf(createRow));
                String realmGet$historyId = rFGHistory.realmGet$historyId();
                if (realmGet$historyId != null) {
                    Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.historyIdIndex, createRow, realmGet$historyId, false);
                }
                String realmGet$gymId = rFGHistory.realmGet$gymId();
                if (realmGet$gymId != null) {
                    Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.gymIdIndex, createRow, realmGet$gymId, false);
                }
                String realmGet$height = rFGHistory.realmGet$height();
                if (realmGet$height != null) {
                    Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.heightIndex, createRow, realmGet$height, false);
                }
                String realmGet$weight = rFGHistory.realmGet$weight();
                if (realmGet$weight != null) {
                    Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.weightIndex, createRow, realmGet$weight, false);
                }
                String realmGet$updated_at = rFGHistory.realmGet$updated_at();
                if (realmGet$updated_at != null) {
                    Table.nativeSetString(nativePtr, rFGHistoryColumnInfo.updated_atIndex, createRow, realmGet$updated_at, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGHistory rFGHistory, Map<RealmModel, Long> map) {
        Class<RFGHistory> cls = RFGHistory.class;
        if (rFGHistory instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGHistory;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGHistoryColumnInfo rFGHistoryColumnInfo = (RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGHistory, Long.valueOf(createRow));
        String realmGet$historyId = rFGHistory.realmGet$historyId();
        long j = rFGHistoryColumnInfo.historyIdIndex;
        if (realmGet$historyId != null) {
            Table.nativeSetString(nativePtr, j, createRow, realmGet$historyId, false);
        } else {
            Table.nativeSetNull(nativePtr, j, createRow, false);
        }
        String realmGet$gymId = rFGHistory.realmGet$gymId();
        long j2 = rFGHistoryColumnInfo.gymIdIndex;
        if (realmGet$gymId != null) {
            Table.nativeSetString(nativePtr, j2, createRow, realmGet$gymId, false);
        } else {
            Table.nativeSetNull(nativePtr, j2, createRow, false);
        }
        String realmGet$height = rFGHistory.realmGet$height();
        long j3 = rFGHistoryColumnInfo.heightIndex;
        if (realmGet$height != null) {
            Table.nativeSetString(nativePtr, j3, createRow, realmGet$height, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, createRow, false);
        }
        String realmGet$weight = rFGHistory.realmGet$weight();
        long j4 = rFGHistoryColumnInfo.weightIndex;
        if (realmGet$weight != null) {
            Table.nativeSetString(nativePtr, j4, createRow, realmGet$weight, false);
        } else {
            Table.nativeSetNull(nativePtr, j4, createRow, false);
        }
        String realmGet$updated_at = rFGHistory.realmGet$updated_at();
        long j5 = rFGHistoryColumnInfo.updated_atIndex;
        if (realmGet$updated_at != null) {
            Table.nativeSetString(nativePtr, j5, createRow, realmGet$updated_at, false);
        } else {
            Table.nativeSetNull(nativePtr, j5, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Map<RealmModel, Long> map2 = map;
        Class<RFGHistory> cls = RFGHistory.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGHistoryColumnInfo rFGHistoryColumnInfo = (RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGHistory rFGHistory = (RFGHistory) it.next();
            if (!map2.containsKey(rFGHistory)) {
                if (rFGHistory instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGHistory;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGHistory, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGHistory, Long.valueOf(createRow));
                String realmGet$historyId = rFGHistory.realmGet$historyId();
                long j = rFGHistoryColumnInfo.historyIdIndex;
                if (realmGet$historyId != null) {
                    Table.nativeSetString(nativePtr, j, createRow, realmGet$historyId, false);
                } else {
                    Table.nativeSetNull(nativePtr, j, createRow, false);
                }
                String realmGet$gymId = rFGHistory.realmGet$gymId();
                long j2 = rFGHistoryColumnInfo.gymIdIndex;
                if (realmGet$gymId != null) {
                    Table.nativeSetString(nativePtr, j2, createRow, realmGet$gymId, false);
                } else {
                    Table.nativeSetNull(nativePtr, j2, createRow, false);
                }
                String realmGet$height = rFGHistory.realmGet$height();
                long j3 = rFGHistoryColumnInfo.heightIndex;
                if (realmGet$height != null) {
                    Table.nativeSetString(nativePtr, j3, createRow, realmGet$height, false);
                } else {
                    Table.nativeSetNull(nativePtr, j3, createRow, false);
                }
                String realmGet$weight = rFGHistory.realmGet$weight();
                long j4 = rFGHistoryColumnInfo.weightIndex;
                if (realmGet$weight != null) {
                    Table.nativeSetString(nativePtr, j4, createRow, realmGet$weight, false);
                } else {
                    Table.nativeSetNull(nativePtr, j4, createRow, false);
                }
                String realmGet$updated_at = rFGHistory.realmGet$updated_at();
                long j5 = rFGHistoryColumnInfo.updated_atIndex;
                if (realmGet$updated_at != null) {
                    Table.nativeSetString(nativePtr, j5, createRow, realmGet$updated_at, false);
                } else {
                    Table.nativeSetNull(nativePtr, j5, createRow, false);
                }
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGHistory.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy jp_reifrontier_gym_domain_api_rfghistoryrealmproxy = new jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_rfghistoryrealmproxy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy jp_reifrontier_gym_domain_api_rfghistoryrealmproxy = (jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_rfghistoryrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_rfghistoryrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_rfghistoryrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGHistoryColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGHistory> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$gymId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.gymIdIndex);
    }

    public String realmGet$height() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.heightIndex);
    }

    public String realmGet$historyId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.historyIdIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public String realmGet$updated_at() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.updated_atIndex);
    }

    public String realmGet$weight() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.weightIndex);
    }

    public void realmSet$gymId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.gymIdIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'gymId' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.gymIdIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'gymId' to null.");
        }
    }

    public void realmSet$height(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.heightIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'height' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.heightIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'height' to null.");
        }
    }

    public void realmSet$historyId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.historyIdIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'historyId' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.historyIdIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'historyId' to null.");
        }
    }

    public void realmSet$updated_at(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.updated_atIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'updated_at' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.updated_atIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'updated_at' to null.");
        }
    }

    public void realmSet$weight(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.weightIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'weight' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.weightIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'weight' to null.");
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGHistory = proxy[", "{historyId:");
        b.append(realmGet$historyId());
        b.append("}");
        b.append(",");
        b.append("{gymId:");
        b.append(realmGet$gymId());
        b.append("}");
        b.append(",");
        b.append("{height:");
        b.append(realmGet$height());
        b.append("}");
        b.append(",");
        b.append("{weight:");
        b.append(realmGet$weight());
        b.append("}");
        b.append(",");
        b.append("{updated_at:");
        b.append(realmGet$updated_at());
        return C0681a.m324a(b, "}", "]");
    }
}
