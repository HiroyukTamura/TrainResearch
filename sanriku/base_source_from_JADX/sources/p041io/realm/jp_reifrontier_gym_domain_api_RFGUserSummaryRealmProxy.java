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
import p043jp.reifrontier.gym.domain.api.RFGUserSummary;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy */
public class jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy extends RFGUserSummary implements RealmObjectProxy, jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxyInterface {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGUserSummaryColumnInfo columnInfo;
    private ProxyState<RFGUserSummary> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGUserSummary";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy$RFGUserSummaryColumnInfo */
    static final class RFGUserSummaryColumnInfo extends ColumnInfo {
        long distanceBikeIndex;
        long distanceRunIndex;
        long maxColumnIndexValue;
        long metsBikeIndex;
        long metsRunIndex;
        long metsStepIndex;
        long stepIndex;

        RFGUserSummaryColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGUserSummaryColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.stepIndex = addColumnDetails("step", "step", objectSchemaInfo);
            this.distanceBikeIndex = addColumnDetails("distanceBike", "distanceBike", objectSchemaInfo);
            this.distanceRunIndex = addColumnDetails("distanceRun", "distanceRun", objectSchemaInfo);
            this.metsStepIndex = addColumnDetails("metsStep", "metsStep", objectSchemaInfo);
            this.metsBikeIndex = addColumnDetails("metsBike", "metsBike", objectSchemaInfo);
            this.metsRunIndex = addColumnDetails("metsRun", "metsRun", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGUserSummaryColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGUserSummaryColumnInfo rFGUserSummaryColumnInfo = (RFGUserSummaryColumnInfo) columnInfo;
            RFGUserSummaryColumnInfo rFGUserSummaryColumnInfo2 = (RFGUserSummaryColumnInfo) columnInfo2;
            rFGUserSummaryColumnInfo2.stepIndex = rFGUserSummaryColumnInfo.stepIndex;
            rFGUserSummaryColumnInfo2.distanceBikeIndex = rFGUserSummaryColumnInfo.distanceBikeIndex;
            rFGUserSummaryColumnInfo2.distanceRunIndex = rFGUserSummaryColumnInfo.distanceRunIndex;
            rFGUserSummaryColumnInfo2.metsStepIndex = rFGUserSummaryColumnInfo.metsStepIndex;
            rFGUserSummaryColumnInfo2.metsBikeIndex = rFGUserSummaryColumnInfo.metsBikeIndex;
            rFGUserSummaryColumnInfo2.metsRunIndex = rFGUserSummaryColumnInfo.metsRunIndex;
            rFGUserSummaryColumnInfo2.maxColumnIndexValue = rFGUserSummaryColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGUserSummary copy(Realm realm, RFGUserSummaryColumnInfo rFGUserSummaryColumnInfo, RFGUserSummary rFGUserSummary, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGUserSummary);
        if (realmObjectProxy != null) {
            return (RFGUserSummary) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGUserSummary.class), rFGUserSummaryColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGUserSummaryColumnInfo.stepIndex, rFGUserSummary.realmGet$step());
        osObjectBuilder.addString(rFGUserSummaryColumnInfo.distanceBikeIndex, rFGUserSummary.realmGet$distanceBike());
        osObjectBuilder.addString(rFGUserSummaryColumnInfo.distanceRunIndex, rFGUserSummary.realmGet$distanceRun());
        osObjectBuilder.addString(rFGUserSummaryColumnInfo.metsStepIndex, rFGUserSummary.realmGet$metsStep());
        osObjectBuilder.addString(rFGUserSummaryColumnInfo.metsBikeIndex, rFGUserSummary.realmGet$metsBike());
        osObjectBuilder.addString(rFGUserSummaryColumnInfo.metsRunIndex, rFGUserSummary.realmGet$metsRun());
        jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGUserSummary, newProxyInstance);
        return newProxyInstance;
    }

    public static RFGUserSummary copyOrUpdate(Realm realm, RFGUserSummaryColumnInfo rFGUserSummaryColumnInfo, RFGUserSummary rFGUserSummary, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        if (rFGUserSummary instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUserSummary;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null) {
                BaseRealm realm$realm = realmObjectProxy.realmGet$proxyState().getRealm$realm();
                if (realm$realm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (realm$realm.getPath().equals(realm.getPath())) {
                    return rFGUserSummary;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(rFGUserSummary);
        return realmObjectProxy2 != null ? (RFGUserSummary) realmObjectProxy2 : copy(realm, rFGUserSummaryColumnInfo, rFGUserSummary, z, map, set);
    }

    public static RFGUserSummaryColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGUserSummaryColumnInfo(osSchemaInfo);
    }

    public static RFGUserSummary createDetachedCopy(RFGUserSummary rFGUserSummary, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGUserSummary rFGUserSummary2;
        if (i > i2 || rFGUserSummary == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGUserSummary);
        if (cacheData == null) {
            rFGUserSummary2 = new RFGUserSummary();
            map.put(rFGUserSummary, new RealmObjectProxy.CacheData(i, rFGUserSummary2));
        } else if (i >= cacheData.minDepth) {
            return (RFGUserSummary) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGUserSummary2 = (RFGUserSummary) cacheData.object;
        }
        rFGUserSummary2.realmSet$step(rFGUserSummary.realmGet$step());
        rFGUserSummary2.realmSet$distanceBike(rFGUserSummary.realmGet$distanceBike());
        rFGUserSummary2.realmSet$distanceRun(rFGUserSummary.realmGet$distanceRun());
        rFGUserSummary2.realmSet$metsStep(rFGUserSummary.realmGet$metsStep());
        rFGUserSummary2.realmSet$metsBike(rFGUserSummary.realmGet$metsBike());
        rFGUserSummary2.realmSet$metsRun(rFGUserSummary.realmGet$metsRun());
        return rFGUserSummary2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 6, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("step", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("distanceBike", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("distanceRun", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("metsStep", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("metsBike", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("metsRun", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static RFGUserSummary createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        RFGUserSummary rFGUserSummary = (RFGUserSummary) realm.createObjectInternal(RFGUserSummary.class, true, Collections.emptyList());
        if (jSONObject.has("step")) {
            if (jSONObject.isNull("step")) {
                rFGUserSummary.realmSet$step((String) null);
            } else {
                rFGUserSummary.realmSet$step(jSONObject.getString("step"));
            }
        }
        if (jSONObject.has("distanceBike")) {
            if (jSONObject.isNull("distanceBike")) {
                rFGUserSummary.realmSet$distanceBike((String) null);
            } else {
                rFGUserSummary.realmSet$distanceBike(jSONObject.getString("distanceBike"));
            }
        }
        if (jSONObject.has("distanceRun")) {
            if (jSONObject.isNull("distanceRun")) {
                rFGUserSummary.realmSet$distanceRun((String) null);
            } else {
                rFGUserSummary.realmSet$distanceRun(jSONObject.getString("distanceRun"));
            }
        }
        if (jSONObject.has("metsStep")) {
            if (jSONObject.isNull("metsStep")) {
                rFGUserSummary.realmSet$metsStep((String) null);
            } else {
                rFGUserSummary.realmSet$metsStep(jSONObject.getString("metsStep"));
            }
        }
        if (jSONObject.has("metsBike")) {
            if (jSONObject.isNull("metsBike")) {
                rFGUserSummary.realmSet$metsBike((String) null);
            } else {
                rFGUserSummary.realmSet$metsBike(jSONObject.getString("metsBike"));
            }
        }
        if (jSONObject.has("metsRun")) {
            if (jSONObject.isNull("metsRun")) {
                rFGUserSummary.realmSet$metsRun((String) null);
            } else {
                rFGUserSummary.realmSet$metsRun(jSONObject.getString("metsRun"));
            }
        }
        return rFGUserSummary;
    }

    @TargetApi(11)
    public static RFGUserSummary createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGUserSummary rFGUserSummary = new RFGUserSummary();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("step")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUserSummary.realmSet$step(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUserSummary.realmSet$step((String) null);
                }
            } else if (nextName.equals("distanceBike")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUserSummary.realmSet$distanceBike(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUserSummary.realmSet$distanceBike((String) null);
                }
            } else if (nextName.equals("distanceRun")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUserSummary.realmSet$distanceRun(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUserSummary.realmSet$distanceRun((String) null);
                }
            } else if (nextName.equals("metsStep")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUserSummary.realmSet$metsStep(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUserSummary.realmSet$metsStep((String) null);
                }
            } else if (nextName.equals("metsBike")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUserSummary.realmSet$metsBike(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUserSummary.realmSet$metsBike((String) null);
                }
            } else if (!nextName.equals("metsRun")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGUserSummary.realmSet$metsRun(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                rFGUserSummary.realmSet$metsRun((String) null);
            }
        }
        jsonReader.endObject();
        return (RFGUserSummary) realm.copyToRealm(rFGUserSummary, new ImportFlag[0]);
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGUserSummary rFGUserSummary, Map<RealmModel, Long> map) {
        Class<RFGUserSummary> cls = RFGUserSummary.class;
        if (rFGUserSummary instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUserSummary;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGUserSummaryColumnInfo rFGUserSummaryColumnInfo = (RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGUserSummary, Long.valueOf(createRow));
        String realmGet$step = rFGUserSummary.realmGet$step();
        if (realmGet$step != null) {
            Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.stepIndex, createRow, realmGet$step, false);
        }
        String realmGet$distanceBike = rFGUserSummary.realmGet$distanceBike();
        if (realmGet$distanceBike != null) {
            Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.distanceBikeIndex, createRow, realmGet$distanceBike, false);
        }
        String realmGet$distanceRun = rFGUserSummary.realmGet$distanceRun();
        if (realmGet$distanceRun != null) {
            Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.distanceRunIndex, createRow, realmGet$distanceRun, false);
        }
        String realmGet$metsStep = rFGUserSummary.realmGet$metsStep();
        if (realmGet$metsStep != null) {
            Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.metsStepIndex, createRow, realmGet$metsStep, false);
        }
        String realmGet$metsBike = rFGUserSummary.realmGet$metsBike();
        if (realmGet$metsBike != null) {
            Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.metsBikeIndex, createRow, realmGet$metsBike, false);
        }
        String realmGet$metsRun = rFGUserSummary.realmGet$metsRun();
        if (realmGet$metsRun != null) {
            Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.metsRunIndex, createRow, realmGet$metsRun, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Map<RealmModel, Long> map2 = map;
        Class<RFGUserSummary> cls = RFGUserSummary.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGUserSummaryColumnInfo rFGUserSummaryColumnInfo = (RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGUserSummary rFGUserSummary = (RFGUserSummary) it.next();
            if (!map2.containsKey(rFGUserSummary)) {
                if (rFGUserSummary instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUserSummary;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGUserSummary, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGUserSummary, Long.valueOf(createRow));
                String realmGet$step = rFGUserSummary.realmGet$step();
                if (realmGet$step != null) {
                    Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.stepIndex, createRow, realmGet$step, false);
                }
                String realmGet$distanceBike = rFGUserSummary.realmGet$distanceBike();
                if (realmGet$distanceBike != null) {
                    Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.distanceBikeIndex, createRow, realmGet$distanceBike, false);
                }
                String realmGet$distanceRun = rFGUserSummary.realmGet$distanceRun();
                if (realmGet$distanceRun != null) {
                    Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.distanceRunIndex, createRow, realmGet$distanceRun, false);
                }
                String realmGet$metsStep = rFGUserSummary.realmGet$metsStep();
                if (realmGet$metsStep != null) {
                    Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.metsStepIndex, createRow, realmGet$metsStep, false);
                }
                String realmGet$metsBike = rFGUserSummary.realmGet$metsBike();
                if (realmGet$metsBike != null) {
                    Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.metsBikeIndex, createRow, realmGet$metsBike, false);
                }
                String realmGet$metsRun = rFGUserSummary.realmGet$metsRun();
                if (realmGet$metsRun != null) {
                    Table.nativeSetString(nativePtr, rFGUserSummaryColumnInfo.metsRunIndex, createRow, realmGet$metsRun, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGUserSummary rFGUserSummary, Map<RealmModel, Long> map) {
        Class<RFGUserSummary> cls = RFGUserSummary.class;
        if (rFGUserSummary instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUserSummary;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGUserSummaryColumnInfo rFGUserSummaryColumnInfo = (RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map.put(rFGUserSummary, Long.valueOf(createRow));
        String realmGet$step = rFGUserSummary.realmGet$step();
        long j = rFGUserSummaryColumnInfo.stepIndex;
        if (realmGet$step != null) {
            Table.nativeSetString(nativePtr, j, createRow, realmGet$step, false);
        } else {
            Table.nativeSetNull(nativePtr, j, createRow, false);
        }
        String realmGet$distanceBike = rFGUserSummary.realmGet$distanceBike();
        long j2 = rFGUserSummaryColumnInfo.distanceBikeIndex;
        if (realmGet$distanceBike != null) {
            Table.nativeSetString(nativePtr, j2, createRow, realmGet$distanceBike, false);
        } else {
            Table.nativeSetNull(nativePtr, j2, createRow, false);
        }
        String realmGet$distanceRun = rFGUserSummary.realmGet$distanceRun();
        long j3 = rFGUserSummaryColumnInfo.distanceRunIndex;
        if (realmGet$distanceRun != null) {
            Table.nativeSetString(nativePtr, j3, createRow, realmGet$distanceRun, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, createRow, false);
        }
        String realmGet$metsStep = rFGUserSummary.realmGet$metsStep();
        long j4 = rFGUserSummaryColumnInfo.metsStepIndex;
        if (realmGet$metsStep != null) {
            Table.nativeSetString(nativePtr, j4, createRow, realmGet$metsStep, false);
        } else {
            Table.nativeSetNull(nativePtr, j4, createRow, false);
        }
        String realmGet$metsBike = rFGUserSummary.realmGet$metsBike();
        long j5 = rFGUserSummaryColumnInfo.metsBikeIndex;
        if (realmGet$metsBike != null) {
            Table.nativeSetString(nativePtr, j5, createRow, realmGet$metsBike, false);
        } else {
            Table.nativeSetNull(nativePtr, j5, createRow, false);
        }
        String realmGet$metsRun = rFGUserSummary.realmGet$metsRun();
        long j6 = rFGUserSummaryColumnInfo.metsRunIndex;
        if (realmGet$metsRun != null) {
            Table.nativeSetString(nativePtr, j6, createRow, realmGet$metsRun, false);
        } else {
            Table.nativeSetNull(nativePtr, j6, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Map<RealmModel, Long> map2 = map;
        Class<RFGUserSummary> cls = RFGUserSummary.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGUserSummaryColumnInfo rFGUserSummaryColumnInfo = (RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGUserSummary rFGUserSummary = (RFGUserSummary) it.next();
            if (!map2.containsKey(rFGUserSummary)) {
                if (rFGUserSummary instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUserSummary;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGUserSummary, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGUserSummary, Long.valueOf(createRow));
                String realmGet$step = rFGUserSummary.realmGet$step();
                long j = rFGUserSummaryColumnInfo.stepIndex;
                if (realmGet$step != null) {
                    Table.nativeSetString(nativePtr, j, createRow, realmGet$step, false);
                } else {
                    Table.nativeSetNull(nativePtr, j, createRow, false);
                }
                String realmGet$distanceBike = rFGUserSummary.realmGet$distanceBike();
                long j2 = rFGUserSummaryColumnInfo.distanceBikeIndex;
                if (realmGet$distanceBike != null) {
                    Table.nativeSetString(nativePtr, j2, createRow, realmGet$distanceBike, false);
                } else {
                    Table.nativeSetNull(nativePtr, j2, createRow, false);
                }
                String realmGet$distanceRun = rFGUserSummary.realmGet$distanceRun();
                long j3 = rFGUserSummaryColumnInfo.distanceRunIndex;
                if (realmGet$distanceRun != null) {
                    Table.nativeSetString(nativePtr, j3, createRow, realmGet$distanceRun, false);
                } else {
                    Table.nativeSetNull(nativePtr, j3, createRow, false);
                }
                String realmGet$metsStep = rFGUserSummary.realmGet$metsStep();
                long j4 = rFGUserSummaryColumnInfo.metsStepIndex;
                if (realmGet$metsStep != null) {
                    Table.nativeSetString(nativePtr, j4, createRow, realmGet$metsStep, false);
                } else {
                    Table.nativeSetNull(nativePtr, j4, createRow, false);
                }
                String realmGet$metsBike = rFGUserSummary.realmGet$metsBike();
                long j5 = rFGUserSummaryColumnInfo.metsBikeIndex;
                if (realmGet$metsBike != null) {
                    Table.nativeSetString(nativePtr, j5, createRow, realmGet$metsBike, false);
                } else {
                    Table.nativeSetNull(nativePtr, j5, createRow, false);
                }
                String realmGet$metsRun = rFGUserSummary.realmGet$metsRun();
                long j6 = rFGUserSummaryColumnInfo.metsRunIndex;
                if (realmGet$metsRun != null) {
                    Table.nativeSetString(nativePtr, j6, createRow, realmGet$metsRun, false);
                } else {
                    Table.nativeSetNull(nativePtr, j6, createRow, false);
                }
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGUserSummary.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy jp_reifrontier_gym_domain_api_rfgusersummaryrealmproxy = new jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_rfgusersummaryrealmproxy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy jp_reifrontier_gym_domain_api_rfgusersummaryrealmproxy = (jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_rfgusersummaryrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_rfgusersummaryrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_rfgusersummaryrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGUserSummaryColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGUserSummary> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$distanceBike() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.distanceBikeIndex);
    }

    public String realmGet$distanceRun() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.distanceRunIndex);
    }

    public String realmGet$metsBike() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.metsBikeIndex);
    }

    public String realmGet$metsRun() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.metsRunIndex);
    }

    public String realmGet$metsStep() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.metsStepIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public String realmGet$step() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.stepIndex);
    }

    public void realmSet$distanceBike(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.distanceBikeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.distanceBikeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.distanceBikeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.distanceBikeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$distanceRun(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.distanceRunIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.distanceRunIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.distanceRunIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.distanceRunIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$metsBike(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.metsBikeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.metsBikeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.metsBikeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.metsBikeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$metsRun(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.metsRunIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.metsRunIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.metsRunIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.metsRunIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$metsStep(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.metsStepIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.metsStepIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.metsStepIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.metsStepIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$step(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.stepIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.stepIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.stepIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.stepIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGUserSummary = proxy[", "{step:");
        String str = "null";
        C0681a.m335a(b, realmGet$step() != null ? realmGet$step() : str, "}", ",", "{distanceBike:");
        C0681a.m335a(b, realmGet$distanceBike() != null ? realmGet$distanceBike() : str, "}", ",", "{distanceRun:");
        C0681a.m335a(b, realmGet$distanceRun() != null ? realmGet$distanceRun() : str, "}", ",", "{metsStep:");
        C0681a.m335a(b, realmGet$metsStep() != null ? realmGet$metsStep() : str, "}", ",", "{metsBike:");
        C0681a.m335a(b, realmGet$metsBike() != null ? realmGet$metsBike() : str, "}", ",", "{metsRun:");
        if (realmGet$metsRun() != null) {
            str = realmGet$metsRun();
        }
        b.append(str);
        b.append("}");
        b.append("]");
        return b.toString();
    }
}
