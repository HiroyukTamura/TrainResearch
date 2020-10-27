package p041io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
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
import p043jp.reifrontier.gym.domain.silentlog.RFGActTag;

/* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy */
public class jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy extends RFGActTag implements RealmObjectProxy, jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxyInterface {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGActTagColumnInfo columnInfo;
    private ProxyState<RFGActTag> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGActTag";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy$RFGActTagColumnInfo */
    static final class RFGActTagColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long nameIndex;
        long ownerIndex;
        long typeIndex;

        RFGActTagColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGActTagColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.nameIndex = addColumnDetails(AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.NAME, objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.ownerIndex = addColumnDetails("owner", "owner", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGActTagColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGActTagColumnInfo rFGActTagColumnInfo = (RFGActTagColumnInfo) columnInfo;
            RFGActTagColumnInfo rFGActTagColumnInfo2 = (RFGActTagColumnInfo) columnInfo2;
            rFGActTagColumnInfo2.nameIndex = rFGActTagColumnInfo.nameIndex;
            rFGActTagColumnInfo2.typeIndex = rFGActTagColumnInfo.typeIndex;
            rFGActTagColumnInfo2.ownerIndex = rFGActTagColumnInfo.ownerIndex;
            rFGActTagColumnInfo2.maxColumnIndexValue = rFGActTagColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGActTag copy(Realm realm, RFGActTagColumnInfo rFGActTagColumnInfo, RFGActTag rFGActTag, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGActTag);
        if (realmObjectProxy != null) {
            return (RFGActTag) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGActTag.class), rFGActTagColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGActTagColumnInfo.nameIndex, rFGActTag.realmGet$name());
        osObjectBuilder.addString(rFGActTagColumnInfo.typeIndex, rFGActTag.realmGet$type());
        osObjectBuilder.addString(rFGActTagColumnInfo.ownerIndex, rFGActTag.realmGet$owner());
        jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGActTag, newProxyInstance);
        return newProxyInstance;
    }

    public static RFGActTag copyOrUpdate(Realm realm, RFGActTagColumnInfo rFGActTagColumnInfo, RFGActTag rFGActTag, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        if (rFGActTag instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActTag;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null) {
                BaseRealm realm$realm = realmObjectProxy.realmGet$proxyState().getRealm$realm();
                if (realm$realm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (realm$realm.getPath().equals(realm.getPath())) {
                    return rFGActTag;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(rFGActTag);
        return realmObjectProxy2 != null ? (RFGActTag) realmObjectProxy2 : copy(realm, rFGActTagColumnInfo, rFGActTag, z, map, set);
    }

    public static RFGActTagColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGActTagColumnInfo(osSchemaInfo);
    }

    public static RFGActTag createDetachedCopy(RFGActTag rFGActTag, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGActTag rFGActTag2;
        if (i > i2 || rFGActTag == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGActTag);
        if (cacheData == null) {
            rFGActTag2 = new RFGActTag();
            map.put(rFGActTag, new RealmObjectProxy.CacheData(i, rFGActTag2));
        } else if (i >= cacheData.minDepth) {
            return (RFGActTag) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGActTag2 = (RFGActTag) cacheData.object;
        }
        rFGActTag2.realmSet$name(rFGActTag.realmGet$name());
        rFGActTag2.realmSet$type(rFGActTag.realmGet$type());
        rFGActTag2.realmSet$owner(rFGActTag.realmGet$owner());
        return rFGActTag2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 3, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty(AppMeasurementSdk.ConditionalUserProperty.NAME, RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("type", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("owner", RealmFieldType.STRING, false, false, true);
        return builder.build();
    }

    public static RFGActTag createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        RFGActTag rFGActTag = (RFGActTag) realm.createObjectInternal(RFGActTag.class, true, Collections.emptyList());
        if (jSONObject.has(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
            if (jSONObject.isNull(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                rFGActTag.realmSet$name((String) null);
            } else {
                rFGActTag.realmSet$name(jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
            }
        }
        if (jSONObject.has("type")) {
            if (jSONObject.isNull("type")) {
                rFGActTag.realmSet$type((String) null);
            } else {
                rFGActTag.realmSet$type(jSONObject.getString("type"));
            }
        }
        if (jSONObject.has("owner")) {
            if (jSONObject.isNull("owner")) {
                rFGActTag.realmSet$owner((String) null);
            } else {
                rFGActTag.realmSet$owner(jSONObject.getString("owner"));
            }
        }
        return rFGActTag;
    }

    @TargetApi(11)
    public static RFGActTag createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGActTag rFGActTag = new RFGActTag();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGActTag.realmSet$name(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGActTag.realmSet$name((String) null);
                }
            } else if (nextName.equals("type")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGActTag.realmSet$type(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGActTag.realmSet$type((String) null);
                }
            } else if (!nextName.equals("owner")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGActTag.realmSet$owner(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                rFGActTag.realmSet$owner((String) null);
            }
        }
        jsonReader.endObject();
        return (RFGActTag) realm.copyToRealm(rFGActTag, new ImportFlag[0]);
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGActTag rFGActTag, Map<RealmModel, Long> map) {
        Class<RFGActTag> cls = RFGActTag.class;
        if (rFGActTag instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActTag;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGActTagColumnInfo rFGActTagColumnInfo = (RFGActTagColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGActTag, Long.valueOf(createRow));
        String realmGet$name = rFGActTag.realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(nativePtr, rFGActTagColumnInfo.nameIndex, createRow, realmGet$name, false);
        }
        String realmGet$type = rFGActTag.realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(nativePtr, rFGActTagColumnInfo.typeIndex, createRow, realmGet$type, false);
        }
        String realmGet$owner = rFGActTag.realmGet$owner();
        if (realmGet$owner != null) {
            Table.nativeSetString(nativePtr, rFGActTagColumnInfo.ownerIndex, createRow, realmGet$owner, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Map<RealmModel, Long> map2 = map;
        Class<RFGActTag> cls = RFGActTag.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGActTagColumnInfo rFGActTagColumnInfo = (RFGActTagColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGActTag rFGActTag = (RFGActTag) it.next();
            if (!map2.containsKey(rFGActTag)) {
                if (rFGActTag instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActTag;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGActTag, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGActTag, Long.valueOf(createRow));
                String realmGet$name = rFGActTag.realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(nativePtr, rFGActTagColumnInfo.nameIndex, createRow, realmGet$name, false);
                }
                String realmGet$type = rFGActTag.realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(nativePtr, rFGActTagColumnInfo.typeIndex, createRow, realmGet$type, false);
                }
                String realmGet$owner = rFGActTag.realmGet$owner();
                if (realmGet$owner != null) {
                    Table.nativeSetString(nativePtr, rFGActTagColumnInfo.ownerIndex, createRow, realmGet$owner, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGActTag rFGActTag, Map<RealmModel, Long> map) {
        Class<RFGActTag> cls = RFGActTag.class;
        if (rFGActTag instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActTag;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGActTagColumnInfo rFGActTagColumnInfo = (RFGActTagColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGActTag, Long.valueOf(createRow));
        String realmGet$name = rFGActTag.realmGet$name();
        long j = rFGActTagColumnInfo.nameIndex;
        if (realmGet$name != null) {
            Table.nativeSetString(nativePtr, j, createRow, realmGet$name, false);
        } else {
            Table.nativeSetNull(nativePtr, j, createRow, false);
        }
        String realmGet$type = rFGActTag.realmGet$type();
        long j2 = rFGActTagColumnInfo.typeIndex;
        if (realmGet$type != null) {
            Table.nativeSetString(nativePtr, j2, createRow, realmGet$type, false);
        } else {
            Table.nativeSetNull(nativePtr, j2, createRow, false);
        }
        String realmGet$owner = rFGActTag.realmGet$owner();
        long j3 = rFGActTagColumnInfo.ownerIndex;
        if (realmGet$owner != null) {
            Table.nativeSetString(nativePtr, j3, createRow, realmGet$owner, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Map<RealmModel, Long> map2 = map;
        Class<RFGActTag> cls = RFGActTag.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGActTagColumnInfo rFGActTagColumnInfo = (RFGActTagColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGActTag rFGActTag = (RFGActTag) it.next();
            if (!map2.containsKey(rFGActTag)) {
                if (rFGActTag instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActTag;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGActTag, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGActTag, Long.valueOf(createRow));
                String realmGet$name = rFGActTag.realmGet$name();
                long j = rFGActTagColumnInfo.nameIndex;
                if (realmGet$name != null) {
                    Table.nativeSetString(nativePtr, j, createRow, realmGet$name, false);
                } else {
                    Table.nativeSetNull(nativePtr, j, createRow, false);
                }
                String realmGet$type = rFGActTag.realmGet$type();
                long j2 = rFGActTagColumnInfo.typeIndex;
                if (realmGet$type != null) {
                    Table.nativeSetString(nativePtr, j2, createRow, realmGet$type, false);
                } else {
                    Table.nativeSetNull(nativePtr, j2, createRow, false);
                }
                String realmGet$owner = rFGActTag.realmGet$owner();
                long j3 = rFGActTagColumnInfo.ownerIndex;
                if (realmGet$owner != null) {
                    Table.nativeSetString(nativePtr, j3, createRow, realmGet$owner, false);
                } else {
                    Table.nativeSetNull(nativePtr, j3, createRow, false);
                }
            }
        }
    }

    private static jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGActTag.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy jp_reifrontier_gym_domain_silentlog_rfgacttagrealmproxy = new jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_silentlog_rfgacttagrealmproxy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy jp_reifrontier_gym_domain_silentlog_rfgacttagrealmproxy = (jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_silentlog_rfgacttagrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_silentlog_rfgacttagrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_silentlog_rfgacttagrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGActTagColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGActTag> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$name() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.nameIndex);
    }

    public String realmGet$owner() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.ownerIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public String realmGet$type() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.typeIndex);
    }

    public void realmSet$name(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.nameIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'name' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.nameIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'name' to null.");
        }
    }

    public void realmSet$owner(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.ownerIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'owner' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.ownerIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'owner' to null.");
        }
    }

    public void realmSet$type(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.typeIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.typeIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGActTag = proxy[", "{name:");
        b.append(realmGet$name());
        b.append("}");
        b.append(",");
        b.append("{type:");
        b.append(realmGet$type());
        b.append("}");
        b.append(",");
        b.append("{owner:");
        b.append(realmGet$owner());
        return C0681a.m324a(b, "}", "]");
    }
}
