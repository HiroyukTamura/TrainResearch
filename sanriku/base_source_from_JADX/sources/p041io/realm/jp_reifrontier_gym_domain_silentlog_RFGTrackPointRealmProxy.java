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
import p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint;

/* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy */
public class jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy extends RFGTrackPoint implements RealmObjectProxy, C1013x5a4bc2b4 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGTrackPointColumnInfo columnInfo;
    private ProxyState<RFGTrackPoint> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGTrackPoint";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy$RFGTrackPointColumnInfo */
    static final class RFGTrackPointColumnInfo extends ColumnInfo {
        long accuracyIndex;
        long latitudeIndex;
        long longitudeIndex;
        long maxColumnIndexValue;
        long timestampIndex;

        RFGTrackPointColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGTrackPointColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.latitudeIndex = addColumnDetails("latitude", "latitude", objectSchemaInfo);
            this.longitudeIndex = addColumnDetails("longitude", "longitude", objectSchemaInfo);
            this.accuracyIndex = addColumnDetails("accuracy", "accuracy", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", "timestamp", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGTrackPointColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGTrackPointColumnInfo rFGTrackPointColumnInfo = (RFGTrackPointColumnInfo) columnInfo;
            RFGTrackPointColumnInfo rFGTrackPointColumnInfo2 = (RFGTrackPointColumnInfo) columnInfo2;
            rFGTrackPointColumnInfo2.latitudeIndex = rFGTrackPointColumnInfo.latitudeIndex;
            rFGTrackPointColumnInfo2.longitudeIndex = rFGTrackPointColumnInfo.longitudeIndex;
            rFGTrackPointColumnInfo2.accuracyIndex = rFGTrackPointColumnInfo.accuracyIndex;
            rFGTrackPointColumnInfo2.timestampIndex = rFGTrackPointColumnInfo.timestampIndex;
            rFGTrackPointColumnInfo2.maxColumnIndexValue = rFGTrackPointColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGTrackPoint copy(Realm realm, RFGTrackPointColumnInfo rFGTrackPointColumnInfo, RFGTrackPoint rFGTrackPoint, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGTrackPoint);
        if (realmObjectProxy != null) {
            return (RFGTrackPoint) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGTrackPoint.class), rFGTrackPointColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addDouble(rFGTrackPointColumnInfo.latitudeIndex, Double.valueOf(rFGTrackPoint.realmGet$latitude()));
        osObjectBuilder.addDouble(rFGTrackPointColumnInfo.longitudeIndex, Double.valueOf(rFGTrackPoint.realmGet$longitude()));
        osObjectBuilder.addFloat(rFGTrackPointColumnInfo.accuracyIndex, Float.valueOf(rFGTrackPoint.realmGet$accuracy()));
        osObjectBuilder.addInteger(rFGTrackPointColumnInfo.timestampIndex, Integer.valueOf(rFGTrackPoint.realmGet$timestamp()));
        jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGTrackPoint, newProxyInstance);
        return newProxyInstance;
    }

    public static RFGTrackPoint copyOrUpdate(Realm realm, RFGTrackPointColumnInfo rFGTrackPointColumnInfo, RFGTrackPoint rFGTrackPoint, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        if (rFGTrackPoint instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrackPoint;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null) {
                BaseRealm realm$realm = realmObjectProxy.realmGet$proxyState().getRealm$realm();
                if (realm$realm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (realm$realm.getPath().equals(realm.getPath())) {
                    return rFGTrackPoint;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(rFGTrackPoint);
        return realmObjectProxy2 != null ? (RFGTrackPoint) realmObjectProxy2 : copy(realm, rFGTrackPointColumnInfo, rFGTrackPoint, z, map, set);
    }

    public static RFGTrackPointColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGTrackPointColumnInfo(osSchemaInfo);
    }

    public static RFGTrackPoint createDetachedCopy(RFGTrackPoint rFGTrackPoint, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGTrackPoint rFGTrackPoint2;
        if (i > i2 || rFGTrackPoint == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGTrackPoint);
        if (cacheData == null) {
            rFGTrackPoint2 = new RFGTrackPoint();
            map.put(rFGTrackPoint, new RealmObjectProxy.CacheData(i, rFGTrackPoint2));
        } else if (i >= cacheData.minDepth) {
            return (RFGTrackPoint) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGTrackPoint2 = (RFGTrackPoint) cacheData.object;
        }
        rFGTrackPoint2.realmSet$latitude(rFGTrackPoint.realmGet$latitude());
        rFGTrackPoint2.realmSet$longitude(rFGTrackPoint.realmGet$longitude());
        rFGTrackPoint2.realmSet$accuracy(rFGTrackPoint.realmGet$accuracy());
        rFGTrackPoint2.realmSet$timestamp(rFGTrackPoint.realmGet$timestamp());
        return rFGTrackPoint2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 4, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("latitude", RealmFieldType.DOUBLE, false, false, true);
        builder2.addPersistedProperty("longitude", RealmFieldType.DOUBLE, false, false, true);
        builder2.addPersistedProperty("accuracy", RealmFieldType.FLOAT, false, false, true);
        builder2.addPersistedProperty("timestamp", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    public static RFGTrackPoint createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        RFGTrackPoint rFGTrackPoint = (RFGTrackPoint) realm.createObjectInternal(RFGTrackPoint.class, true, Collections.emptyList());
        if (jSONObject.has("latitude")) {
            if (!jSONObject.isNull("latitude")) {
                rFGTrackPoint.realmSet$latitude(jSONObject.getDouble("latitude"));
            } else {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
            }
        }
        if (jSONObject.has("longitude")) {
            if (!jSONObject.isNull("longitude")) {
                rFGTrackPoint.realmSet$longitude(jSONObject.getDouble("longitude"));
            } else {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
            }
        }
        if (jSONObject.has("accuracy")) {
            if (!jSONObject.isNull("accuracy")) {
                rFGTrackPoint.realmSet$accuracy((float) jSONObject.getDouble("accuracy"));
            } else {
                throw new IllegalArgumentException("Trying to set non-nullable field 'accuracy' to null.");
            }
        }
        if (jSONObject.has("timestamp")) {
            if (!jSONObject.isNull("timestamp")) {
                rFGTrackPoint.realmSet$timestamp(jSONObject.getInt("timestamp"));
            } else {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
            }
        }
        return rFGTrackPoint;
    }

    @TargetApi(11)
    public static RFGTrackPoint createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGTrackPoint rFGTrackPoint = new RFGTrackPoint();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("latitude")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGTrackPoint.realmSet$latitude(jsonReader.nextDouble());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'latitude' to null.");
                }
            } else if (nextName.equals("longitude")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGTrackPoint.realmSet$longitude(jsonReader.nextDouble());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'longitude' to null.");
                }
            } else if (nextName.equals("accuracy")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGTrackPoint.realmSet$accuracy((float) jsonReader.nextDouble());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'accuracy' to null.");
                }
            } else if (!nextName.equals("timestamp")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGTrackPoint.realmSet$timestamp(jsonReader.nextInt());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'timestamp' to null.");
            }
        }
        jsonReader.endObject();
        return (RFGTrackPoint) realm.copyToRealm(rFGTrackPoint, new ImportFlag[0]);
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGTrackPoint rFGTrackPoint, Map<RealmModel, Long> map) {
        Class<RFGTrackPoint> cls = RFGTrackPoint.class;
        if (rFGTrackPoint instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrackPoint;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGTrackPointColumnInfo rFGTrackPointColumnInfo = (RFGTrackPointColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGTrackPoint, Long.valueOf(createRow));
        long j = nativePtr;
        long j2 = createRow;
        Table.nativeSetDouble(j, rFGTrackPointColumnInfo.latitudeIndex, j2, rFGTrackPoint.realmGet$latitude(), false);
        Table.nativeSetDouble(j, rFGTrackPointColumnInfo.longitudeIndex, j2, rFGTrackPoint.realmGet$longitude(), false);
        Table.nativeSetFloat(j, rFGTrackPointColumnInfo.accuracyIndex, j2, rFGTrackPoint.realmGet$accuracy(), false);
        Table.nativeSetLong(j, rFGTrackPointColumnInfo.timestampIndex, j2, (long) rFGTrackPoint.realmGet$timestamp(), false);
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Map<RealmModel, Long> map2 = map;
        Class<RFGTrackPoint> cls = RFGTrackPoint.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGTrackPointColumnInfo rFGTrackPointColumnInfo = (RFGTrackPointColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGTrackPoint rFGTrackPoint = (RFGTrackPoint) it.next();
            if (!map2.containsKey(rFGTrackPoint)) {
                if (rFGTrackPoint instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrackPoint;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGTrackPoint, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGTrackPoint, Long.valueOf(createRow));
                long j = nativePtr;
                long j2 = createRow;
                Table.nativeSetDouble(j, rFGTrackPointColumnInfo.latitudeIndex, j2, rFGTrackPoint.realmGet$latitude(), false);
                Table.nativeSetDouble(j, rFGTrackPointColumnInfo.longitudeIndex, j2, rFGTrackPoint.realmGet$longitude(), false);
                Table.nativeSetFloat(j, rFGTrackPointColumnInfo.accuracyIndex, j2, rFGTrackPoint.realmGet$accuracy(), false);
                Table.nativeSetLong(nativePtr, rFGTrackPointColumnInfo.timestampIndex, j2, (long) rFGTrackPoint.realmGet$timestamp(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGTrackPoint rFGTrackPoint, Map<RealmModel, Long> map) {
        Class<RFGTrackPoint> cls = RFGTrackPoint.class;
        if (rFGTrackPoint instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrackPoint;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGTrackPointColumnInfo rFGTrackPointColumnInfo = (RFGTrackPointColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGTrackPoint, Long.valueOf(createRow));
        long j = nativePtr;
        long j2 = createRow;
        Table.nativeSetDouble(j, rFGTrackPointColumnInfo.latitudeIndex, j2, rFGTrackPoint.realmGet$latitude(), false);
        Table.nativeSetDouble(j, rFGTrackPointColumnInfo.longitudeIndex, j2, rFGTrackPoint.realmGet$longitude(), false);
        Table.nativeSetFloat(j, rFGTrackPointColumnInfo.accuracyIndex, j2, rFGTrackPoint.realmGet$accuracy(), false);
        Table.nativeSetLong(j, rFGTrackPointColumnInfo.timestampIndex, j2, (long) rFGTrackPoint.realmGet$timestamp(), false);
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Map<RealmModel, Long> map2 = map;
        Class<RFGTrackPoint> cls = RFGTrackPoint.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGTrackPointColumnInfo rFGTrackPointColumnInfo = (RFGTrackPointColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGTrackPoint rFGTrackPoint = (RFGTrackPoint) it.next();
            if (!map2.containsKey(rFGTrackPoint)) {
                if (rFGTrackPoint instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrackPoint;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGTrackPoint, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGTrackPoint, Long.valueOf(createRow));
                long j = nativePtr;
                long j2 = createRow;
                Table.nativeSetDouble(j, rFGTrackPointColumnInfo.latitudeIndex, j2, rFGTrackPoint.realmGet$latitude(), false);
                Table.nativeSetDouble(j, rFGTrackPointColumnInfo.longitudeIndex, j2, rFGTrackPoint.realmGet$longitude(), false);
                Table.nativeSetFloat(j, rFGTrackPointColumnInfo.accuracyIndex, j2, rFGTrackPoint.realmGet$accuracy(), false);
                Table.nativeSetLong(nativePtr, rFGTrackPointColumnInfo.timestampIndex, j2, (long) rFGTrackPoint.realmGet$timestamp(), false);
            }
        }
    }

    private static jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGTrackPoint.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy jp_reifrontier_gym_domain_silentlog_rfgtrackpointrealmproxy = new jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_silentlog_rfgtrackpointrealmproxy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy jp_reifrontier_gym_domain_silentlog_rfgtrackpointrealmproxy = (jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_silentlog_rfgtrackpointrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_silentlog_rfgtrackpointrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_silentlog_rfgtrackpointrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGTrackPointColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGTrackPoint> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public float realmGet$accuracy() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getFloat(this.columnInfo.accuracyIndex);
    }

    public double realmGet$latitude() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getDouble(this.columnInfo.latitudeIndex);
    }

    public double realmGet$longitude() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getDouble(this.columnInfo.longitudeIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int realmGet$timestamp() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.timestampIndex);
    }

    public void realmSet$accuracy(float f) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setFloat(this.columnInfo.accuracyIndex, f);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setFloat(this.columnInfo.accuracyIndex, row$realm.getIndex(), f, true);
        }
    }

    public void realmSet$latitude(double d) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setDouble(this.columnInfo.latitudeIndex, d);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setDouble(this.columnInfo.latitudeIndex, row$realm.getIndex(), d, true);
        }
    }

    public void realmSet$longitude(double d) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setDouble(this.columnInfo.longitudeIndex, d);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setDouble(this.columnInfo.longitudeIndex, row$realm.getIndex(), d, true);
        }
    }

    public void realmSet$timestamp(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.timestampIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.timestampIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGTrackPoint = proxy[", "{latitude:");
        b.append(realmGet$latitude());
        b.append("}");
        b.append(",");
        b.append("{longitude:");
        b.append(realmGet$longitude());
        b.append("}");
        b.append(",");
        b.append("{accuracy:");
        b.append(realmGet$accuracy());
        b.append("}");
        b.append(",");
        b.append("{timestamp:");
        b.append(realmGet$timestamp());
        return C0681a.m324a(b, "}", "]");
    }
}
