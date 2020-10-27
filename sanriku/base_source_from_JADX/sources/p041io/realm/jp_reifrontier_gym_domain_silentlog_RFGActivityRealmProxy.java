package p041io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.BaseRealm;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsList;
import p041io.realm.internal.OsObject;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Row;
import p041io.realm.internal.Table;
import p041io.realm.internal.objectstore.OsObjectBuilder;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy;
import p043jp.reifrontier.gym.domain.silentlog.RFGActTag;
import p043jp.reifrontier.gym.domain.silentlog.RFGActivity;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint;

/* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy */
public class jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy extends RFGActivity implements RealmObjectProxy, C1012xc63ff62a {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGActivityColumnInfo columnInfo;
    private ProxyState<RFGActivity> proxyState;
    private RealmList<RFGActTag> tagsRealmList;
    private RealmList<RFGTrackPoint> trackPointsRealmList;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGActivity";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy$RFGActivityColumnInfo */
    static final class RFGActivityColumnInfo extends ColumnInfo {
        long activityIndex;
        long fromDateIndex;
        long maxColumnIndexValue;
        long stepsIndex;
        long tagsIndex;
        long toDateIndex;
        long trackPointsIndex;

        RFGActivityColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGActivityColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.fromDateIndex = addColumnDetails("fromDate", "fromDate", objectSchemaInfo);
            this.toDateIndex = addColumnDetails("toDate", "toDate", objectSchemaInfo);
            this.stepsIndex = addColumnDetails("steps", "steps", objectSchemaInfo);
            this.activityIndex = addColumnDetails("activity", "activity", objectSchemaInfo);
            this.trackPointsIndex = addColumnDetails("trackPoints", "trackPoints", objectSchemaInfo);
            this.tagsIndex = addColumnDetails("tags", "tags", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGActivityColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGActivityColumnInfo rFGActivityColumnInfo = (RFGActivityColumnInfo) columnInfo;
            RFGActivityColumnInfo rFGActivityColumnInfo2 = (RFGActivityColumnInfo) columnInfo2;
            rFGActivityColumnInfo2.fromDateIndex = rFGActivityColumnInfo.fromDateIndex;
            rFGActivityColumnInfo2.toDateIndex = rFGActivityColumnInfo.toDateIndex;
            rFGActivityColumnInfo2.stepsIndex = rFGActivityColumnInfo.stepsIndex;
            rFGActivityColumnInfo2.activityIndex = rFGActivityColumnInfo.activityIndex;
            rFGActivityColumnInfo2.trackPointsIndex = rFGActivityColumnInfo.trackPointsIndex;
            rFGActivityColumnInfo2.tagsIndex = rFGActivityColumnInfo.tagsIndex;
            rFGActivityColumnInfo2.maxColumnIndexValue = rFGActivityColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGActivity copy(Realm realm, RFGActivityColumnInfo rFGActivityColumnInfo, RFGActivity rFGActivity, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        Realm realm2 = realm;
        RFGActivityColumnInfo rFGActivityColumnInfo2 = rFGActivityColumnInfo;
        RFGActivity rFGActivity2 = rFGActivity;
        Map<RealmModel, RealmObjectProxy> map2 = map;
        RealmObjectProxy realmObjectProxy = map2.get(rFGActivity2);
        if (realmObjectProxy != null) {
            return (RFGActivity) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGActivity.class), rFGActivityColumnInfo2.maxColumnIndexValue, set);
        osObjectBuilder.addInteger(rFGActivityColumnInfo2.fromDateIndex, Integer.valueOf(rFGActivity.realmGet$fromDate()));
        osObjectBuilder.addInteger(rFGActivityColumnInfo2.toDateIndex, Integer.valueOf(rFGActivity.realmGet$toDate()));
        osObjectBuilder.addInteger(rFGActivityColumnInfo2.stepsIndex, Integer.valueOf(rFGActivity.realmGet$steps()));
        osObjectBuilder.addString(rFGActivityColumnInfo2.activityIndex, rFGActivity.realmGet$activity());
        jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map2.put(rFGActivity2, newProxyInstance);
        RealmList<RFGTrackPoint> realmGet$trackPoints = rFGActivity.realmGet$trackPoints();
        if (realmGet$trackPoints != null) {
            RealmList<RFGTrackPoint> realmGet$trackPoints2 = newProxyInstance.realmGet$trackPoints();
            realmGet$trackPoints2.clear();
            for (int i = 0; i < realmGet$trackPoints.size(); i++) {
                RFGTrackPoint rFGTrackPoint = realmGet$trackPoints.get(i);
                RFGTrackPoint rFGTrackPoint2 = (RFGTrackPoint) map2.get(rFGTrackPoint);
                if (rFGTrackPoint2 == null) {
                    rFGTrackPoint2 = jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.RFGTrackPointColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGTrackPoint.class), rFGTrackPoint, z, map, set);
                }
                realmGet$trackPoints2.add(rFGTrackPoint2);
            }
        }
        RealmList<RFGActTag> realmGet$tags = rFGActivity.realmGet$tags();
        if (realmGet$tags != null) {
            RealmList<RFGActTag> realmGet$tags2 = newProxyInstance.realmGet$tags();
            realmGet$tags2.clear();
            for (int i2 = 0; i2 < realmGet$tags.size(); i2++) {
                RFGActTag rFGActTag = realmGet$tags.get(i2);
                RFGActTag rFGActTag2 = (RFGActTag) map2.get(rFGActTag);
                if (rFGActTag2 == null) {
                    rFGActTag2 = jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.RFGActTagColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGActTag.class), rFGActTag, z, map, set);
                }
                realmGet$tags2.add(rFGActTag2);
            }
        }
        return newProxyInstance;
    }

    public static RFGActivity copyOrUpdate(Realm realm, RFGActivityColumnInfo rFGActivityColumnInfo, RFGActivity rFGActivity, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        if (rFGActivity instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActivity;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null) {
                BaseRealm realm$realm = realmObjectProxy.realmGet$proxyState().getRealm$realm();
                if (realm$realm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (realm$realm.getPath().equals(realm.getPath())) {
                    return rFGActivity;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(rFGActivity);
        return realmObjectProxy2 != null ? (RFGActivity) realmObjectProxy2 : copy(realm, rFGActivityColumnInfo, rFGActivity, z, map, set);
    }

    public static RFGActivityColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGActivityColumnInfo(osSchemaInfo);
    }

    public static RFGActivity createDetachedCopy(RFGActivity rFGActivity, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGActivity rFGActivity2;
        if (i > i2 || rFGActivity == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGActivity);
        if (cacheData == null) {
            rFGActivity2 = new RFGActivity();
            map.put(rFGActivity, new RealmObjectProxy.CacheData(i, rFGActivity2));
        } else if (i >= cacheData.minDepth) {
            return (RFGActivity) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGActivity2 = (RFGActivity) cacheData.object;
        }
        rFGActivity2.realmSet$fromDate(rFGActivity.realmGet$fromDate());
        rFGActivity2.realmSet$toDate(rFGActivity.realmGet$toDate());
        rFGActivity2.realmSet$steps(rFGActivity.realmGet$steps());
        rFGActivity2.realmSet$activity(rFGActivity.realmGet$activity());
        if (i == i2) {
            rFGActivity2.realmSet$trackPoints((RealmList<RFGTrackPoint>) null);
        } else {
            RealmList<RFGTrackPoint> realmGet$trackPoints = rFGActivity.realmGet$trackPoints();
            RealmList realmList = new RealmList();
            rFGActivity2.realmSet$trackPoints(realmList);
            int i3 = i + 1;
            int size = realmGet$trackPoints.size();
            for (int i4 = 0; i4 < size; i4++) {
                realmList.add(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.createDetachedCopy(realmGet$trackPoints.get(i4), i3, i2, map));
            }
        }
        if (i == i2) {
            rFGActivity2.realmSet$tags((RealmList<RFGActTag>) null);
        } else {
            RealmList<RFGActTag> realmGet$tags = rFGActivity.realmGet$tags();
            RealmList realmList2 = new RealmList();
            rFGActivity2.realmSet$tags(realmList2);
            int i5 = i + 1;
            int size2 = realmGet$tags.size();
            for (int i6 = 0; i6 < size2; i6++) {
                realmList2.add(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.createDetachedCopy(realmGet$tags.get(i6), i5, i2, map));
            }
        }
        return rFGActivity2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 6, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("fromDate", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("toDate", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("steps", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("activity", RealmFieldType.STRING, false, false, true);
        builder.addPersistedLinkProperty("trackPoints", RealmFieldType.LIST, jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("tags", RealmFieldType.LIST, jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        return builder.build();
    }

    public static RFGActivity createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        ArrayList arrayList = new ArrayList(2);
        if (jSONObject.has("trackPoints")) {
            arrayList.add("trackPoints");
        }
        if (jSONObject.has("tags")) {
            arrayList.add("tags");
        }
        RFGActivity rFGActivity = (RFGActivity) realm.createObjectInternal(RFGActivity.class, true, arrayList);
        if (jSONObject.has("fromDate")) {
            if (!jSONObject.isNull("fromDate")) {
                rFGActivity.realmSet$fromDate(jSONObject.getInt("fromDate"));
            } else {
                throw new IllegalArgumentException("Trying to set non-nullable field 'fromDate' to null.");
            }
        }
        if (jSONObject.has("toDate")) {
            if (!jSONObject.isNull("toDate")) {
                rFGActivity.realmSet$toDate(jSONObject.getInt("toDate"));
            } else {
                throw new IllegalArgumentException("Trying to set non-nullable field 'toDate' to null.");
            }
        }
        if (jSONObject.has("steps")) {
            if (!jSONObject.isNull("steps")) {
                rFGActivity.realmSet$steps(jSONObject.getInt("steps"));
            } else {
                throw new IllegalArgumentException("Trying to set non-nullable field 'steps' to null.");
            }
        }
        if (jSONObject.has("activity")) {
            if (jSONObject.isNull("activity")) {
                rFGActivity.realmSet$activity((String) null);
            } else {
                rFGActivity.realmSet$activity(jSONObject.getString("activity"));
            }
        }
        if (jSONObject.has("trackPoints")) {
            if (jSONObject.isNull("trackPoints")) {
                rFGActivity.realmSet$trackPoints((RealmList<RFGTrackPoint>) null);
            } else {
                rFGActivity.realmGet$trackPoints().clear();
                JSONArray jSONArray = jSONObject.getJSONArray("trackPoints");
                for (int i = 0; i < jSONArray.length(); i++) {
                    rFGActivity.realmGet$trackPoints().add(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.createOrUpdateUsingJsonObject(realm, jSONArray.getJSONObject(i), z));
                }
            }
        }
        if (jSONObject.has("tags")) {
            if (jSONObject.isNull("tags")) {
                rFGActivity.realmSet$tags((RealmList<RFGActTag>) null);
            } else {
                rFGActivity.realmGet$tags().clear();
                JSONArray jSONArray2 = jSONObject.getJSONArray("tags");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    rFGActivity.realmGet$tags().add(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.createOrUpdateUsingJsonObject(realm, jSONArray2.getJSONObject(i2), z));
                }
            }
        }
        return rFGActivity;
    }

    @TargetApi(11)
    public static RFGActivity createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGActivity rFGActivity = new RFGActivity();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("fromDate")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGActivity.realmSet$fromDate(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'fromDate' to null.");
                }
            } else if (nextName.equals("toDate")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGActivity.realmSet$toDate(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'toDate' to null.");
                }
            } else if (nextName.equals("steps")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGActivity.realmSet$steps(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'steps' to null.");
                }
            } else if (!nextName.equals("activity")) {
                if (nextName.equals("trackPoints")) {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.skipValue();
                        rFGActivity.realmSet$trackPoints((RealmList<RFGTrackPoint>) null);
                    } else {
                        rFGActivity.realmSet$trackPoints(new RealmList());
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            rFGActivity.realmGet$trackPoints().add(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.createUsingJsonStream(realm, jsonReader));
                        }
                    }
                } else if (!nextName.equals("tags")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGActivity.realmSet$tags((RealmList<RFGActTag>) null);
                } else {
                    rFGActivity.realmSet$tags(new RealmList());
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        rFGActivity.realmGet$tags().add(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.createUsingJsonStream(realm, jsonReader));
                    }
                }
                jsonReader.endArray();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGActivity.realmSet$activity(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                rFGActivity.realmSet$activity((String) null);
            }
        }
        jsonReader.endObject();
        return (RFGActivity) realm.copyToRealm(rFGActivity, new ImportFlag[0]);
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGActivity rFGActivity, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        RFGActivity rFGActivity2 = rFGActivity;
        Map<RealmModel, Long> map2 = map;
        Class<RFGActivity> cls = RFGActivity.class;
        if (rFGActivity2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActivity2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGActivityColumnInfo rFGActivityColumnInfo = (RFGActivityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map2.put(rFGActivity2, Long.valueOf(createRow));
        long j2 = createRow;
        Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.fromDateIndex, createRow, (long) rFGActivity.realmGet$fromDate(), false);
        long j3 = j2;
        Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.toDateIndex, j3, (long) rFGActivity.realmGet$toDate(), false);
        Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.stepsIndex, j3, (long) rFGActivity.realmGet$steps(), false);
        String realmGet$activity = rFGActivity.realmGet$activity();
        if (realmGet$activity != null) {
            Table.nativeSetString(nativePtr, rFGActivityColumnInfo.activityIndex, j2, realmGet$activity, false);
        }
        RealmList<RFGTrackPoint> realmGet$trackPoints = rFGActivity.realmGet$trackPoints();
        if (realmGet$trackPoints != null) {
            j = j2;
            OsList osList = new OsList(table.getUncheckedRow(j), rFGActivityColumnInfo.trackPointsIndex);
            Iterator<RFGTrackPoint> it = realmGet$trackPoints.iterator();
            while (it.hasNext()) {
                RFGTrackPoint next = it.next();
                Long l = map2.get(next);
                if (l == null) {
                    l = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insert(realm2, next, map2));
                }
                osList.addRow(l.longValue());
            }
        } else {
            j = j2;
        }
        RealmList<RFGActTag> realmGet$tags = rFGActivity.realmGet$tags();
        if (realmGet$tags != null) {
            OsList osList2 = new OsList(table.getUncheckedRow(j), rFGActivityColumnInfo.tagsIndex);
            Iterator<RFGActTag> it2 = realmGet$tags.iterator();
            while (it2.hasNext()) {
                RFGActTag next2 = it2.next();
                Long l2 = map2.get(next2);
                if (l2 == null) {
                    l2 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insert(realm2, next2, map2));
                }
                osList2.addRow(l2.longValue());
            }
        }
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGActivity> cls = RFGActivity.class;
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGActivityColumnInfo rFGActivityColumnInfo = (RFGActivityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGActivity rFGActivity = (RFGActivity) it.next();
            if (!map2.containsKey(rFGActivity)) {
                if (rFGActivity instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActivity;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGActivity, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(rFGActivity, Long.valueOf(createRow));
                long j2 = createRow;
                Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.fromDateIndex, createRow, (long) rFGActivity.realmGet$fromDate(), false);
                long j3 = j2;
                Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.toDateIndex, j3, (long) rFGActivity.realmGet$toDate(), false);
                Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.stepsIndex, j3, (long) rFGActivity.realmGet$steps(), false);
                String realmGet$activity = rFGActivity.realmGet$activity();
                if (realmGet$activity != null) {
                    Table.nativeSetString(nativePtr, rFGActivityColumnInfo.activityIndex, j2, realmGet$activity, false);
                }
                RealmList<RFGTrackPoint> realmGet$trackPoints = rFGActivity.realmGet$trackPoints();
                if (realmGet$trackPoints != null) {
                    j = j2;
                    OsList osList = new OsList(table.getUncheckedRow(j), rFGActivityColumnInfo.trackPointsIndex);
                    Iterator<RFGTrackPoint> it2 = realmGet$trackPoints.iterator();
                    while (it2.hasNext()) {
                        RFGTrackPoint next = it2.next();
                        Long l = map2.get(next);
                        if (l == null) {
                            l = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insert(realm2, next, map2));
                        }
                        osList.addRow(l.longValue());
                    }
                } else {
                    j = j2;
                }
                RealmList<RFGActTag> realmGet$tags = rFGActivity.realmGet$tags();
                if (realmGet$tags != null) {
                    OsList osList2 = new OsList(table.getUncheckedRow(j), rFGActivityColumnInfo.tagsIndex);
                    Iterator<RFGActTag> it3 = realmGet$tags.iterator();
                    while (it3.hasNext()) {
                        RFGActTag next2 = it3.next();
                        Long l2 = map2.get(next2);
                        if (l2 == null) {
                            l2 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insert(realm2, next2, map2));
                        }
                        osList2.addRow(l2.longValue());
                    }
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGActivity rFGActivity, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        RFGActivity rFGActivity2 = rFGActivity;
        Map<RealmModel, Long> map2 = map;
        Class<RFGActivity> cls = RFGActivity.class;
        if (rFGActivity2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActivity2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGActivityColumnInfo rFGActivityColumnInfo = (RFGActivityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long createRow = OsObject.createRow(table);
        map2.put(rFGActivity2, Long.valueOf(createRow));
        long j = createRow;
        Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.fromDateIndex, createRow, (long) rFGActivity.realmGet$fromDate(), false);
        long j2 = j;
        Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.toDateIndex, j2, (long) rFGActivity.realmGet$toDate(), false);
        Table.nativeSetLong(nativePtr, rFGActivityColumnInfo.stepsIndex, j2, (long) rFGActivity.realmGet$steps(), false);
        String realmGet$activity = rFGActivity.realmGet$activity();
        long j3 = rFGActivityColumnInfo.activityIndex;
        if (realmGet$activity != null) {
            Table.nativeSetString(nativePtr, j3, j, realmGet$activity, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, j, false);
        }
        long j4 = j;
        OsList osList = new OsList(table.getUncheckedRow(j4), rFGActivityColumnInfo.trackPointsIndex);
        RealmList<RFGTrackPoint> realmGet$trackPoints = rFGActivity.realmGet$trackPoints();
        if (realmGet$trackPoints == null || ((long) realmGet$trackPoints.size()) != osList.size()) {
            osList.removeAll();
            if (realmGet$trackPoints != null) {
                Iterator<RFGTrackPoint> it = realmGet$trackPoints.iterator();
                while (it.hasNext()) {
                    RFGTrackPoint next = it.next();
                    Long l = map2.get(next);
                    if (l == null) {
                        l = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insertOrUpdate(realm2, next, map2));
                    }
                    osList.addRow(l.longValue());
                }
            }
        } else {
            int size = realmGet$trackPoints.size();
            for (int i = 0; i < size; i++) {
                RFGTrackPoint rFGTrackPoint = realmGet$trackPoints.get(i);
                Long l2 = map2.get(rFGTrackPoint);
                if (l2 == null) {
                    l2 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insertOrUpdate(realm2, rFGTrackPoint, map2));
                }
                osList.setRow((long) i, l2.longValue());
            }
        }
        OsList osList2 = new OsList(table.getUncheckedRow(j4), rFGActivityColumnInfo.tagsIndex);
        RealmList<RFGActTag> realmGet$tags = rFGActivity.realmGet$tags();
        if (realmGet$tags == null || ((long) realmGet$tags.size()) != osList2.size()) {
            osList2.removeAll();
            if (realmGet$tags != null) {
                Iterator<RFGActTag> it2 = realmGet$tags.iterator();
                while (it2.hasNext()) {
                    RFGActTag next2 = it2.next();
                    Long l3 = map2.get(next2);
                    if (l3 == null) {
                        l3 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insertOrUpdate(realm2, next2, map2));
                    }
                    osList2.addRow(l3.longValue());
                }
            }
        } else {
            int size2 = realmGet$tags.size();
            for (int i2 = 0; i2 < size2; i2++) {
                RFGActTag rFGActTag = realmGet$tags.get(i2);
                Long l4 = map2.get(rFGActTag);
                if (l4 == null) {
                    l4 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insertOrUpdate(realm2, rFGActTag, map2));
                }
                osList2.setRow((long) i2, l4.longValue());
            }
        }
        return j4;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        RFGActivityColumnInfo rFGActivityColumnInfo;
        Table table;
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGActivity> cls = RFGActivity.class;
        Table table2 = realm2.getTable(cls);
        long nativePtr = table2.getNativePtr();
        RFGActivityColumnInfo rFGActivityColumnInfo2 = (RFGActivityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        while (it.hasNext()) {
            RFGActivity rFGActivity = (RFGActivity) it.next();
            if (!map2.containsKey(rFGActivity)) {
                if (rFGActivity instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGActivity;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGActivity, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table2);
                map2.put(rFGActivity, Long.valueOf(createRow));
                long j = createRow;
                Table.nativeSetLong(nativePtr, rFGActivityColumnInfo2.fromDateIndex, createRow, (long) rFGActivity.realmGet$fromDate(), false);
                long j2 = j;
                Table.nativeSetLong(nativePtr, rFGActivityColumnInfo2.toDateIndex, j2, (long) rFGActivity.realmGet$toDate(), false);
                Table.nativeSetLong(nativePtr, rFGActivityColumnInfo2.stepsIndex, j2, (long) rFGActivity.realmGet$steps(), false);
                String realmGet$activity = rFGActivity.realmGet$activity();
                long j3 = rFGActivityColumnInfo2.activityIndex;
                if (realmGet$activity != null) {
                    Table.nativeSetString(nativePtr, j3, j, realmGet$activity, false);
                } else {
                    Table.nativeSetNull(nativePtr, j3, j, false);
                }
                long j4 = j;
                OsList osList = new OsList(table2.getUncheckedRow(j4), rFGActivityColumnInfo2.trackPointsIndex);
                RealmList<RFGTrackPoint> realmGet$trackPoints = rFGActivity.realmGet$trackPoints();
                if (realmGet$trackPoints == null || ((long) realmGet$trackPoints.size()) != osList.size()) {
                    osList.removeAll();
                    if (realmGet$trackPoints != null) {
                        Iterator<RFGTrackPoint> it2 = realmGet$trackPoints.iterator();
                        while (it2.hasNext()) {
                            RFGTrackPoint next = it2.next();
                            Long l = map2.get(next);
                            if (l == null) {
                                l = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insertOrUpdate(realm2, next, map2));
                            }
                            osList.addRow(l.longValue());
                        }
                    }
                } else {
                    int i = 0;
                    for (int size = realmGet$trackPoints.size(); i < size; size = size) {
                        RFGTrackPoint rFGTrackPoint = realmGet$trackPoints.get(i);
                        Long l2 = map2.get(rFGTrackPoint);
                        if (l2 == null) {
                            l2 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insertOrUpdate(realm2, rFGTrackPoint, map2));
                        }
                        osList.setRow((long) i, l2.longValue());
                        i++;
                    }
                }
                OsList osList2 = new OsList(table2.getUncheckedRow(j4), rFGActivityColumnInfo2.tagsIndex);
                RealmList<RFGActTag> realmGet$tags = rFGActivity.realmGet$tags();
                if (realmGet$tags == null || ((long) realmGet$tags.size()) != osList2.size()) {
                    rFGActivityColumnInfo = rFGActivityColumnInfo2;
                    table = table2;
                    osList2.removeAll();
                    if (realmGet$tags != null) {
                        Iterator<RFGActTag> it3 = realmGet$tags.iterator();
                        while (it3.hasNext()) {
                            RFGActTag next2 = it3.next();
                            Long l3 = map2.get(next2);
                            if (l3 == null) {
                                l3 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insertOrUpdate(realm2, next2, map2));
                            }
                            osList2.addRow(l3.longValue());
                        }
                    }
                } else {
                    int size2 = realmGet$tags.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        RFGActTag rFGActTag = realmGet$tags.get(i2);
                        Long l4 = map2.get(rFGActTag);
                        if (l4 == null) {
                            l4 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insertOrUpdate(realm2, rFGActTag, map2));
                        }
                        osList2.setRow((long) i2, l4.longValue());
                        i2++;
                        table2 = table2;
                        rFGActivityColumnInfo2 = rFGActivityColumnInfo2;
                    }
                    rFGActivityColumnInfo = rFGActivityColumnInfo2;
                    table = table2;
                }
                table2 = table;
                rFGActivityColumnInfo2 = rFGActivityColumnInfo;
            }
        }
    }

    private static jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGActivity.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy jp_reifrontier_gym_domain_silentlog_rfgactivityrealmproxy = new jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_silentlog_rfgactivityrealmproxy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy jp_reifrontier_gym_domain_silentlog_rfgactivityrealmproxy = (jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_silentlog_rfgactivityrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_silentlog_rfgactivityrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_silentlog_rfgactivityrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGActivityColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGActivity> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$activity() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.activityIndex);
    }

    public int realmGet$fromDate() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.fromDateIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int realmGet$steps() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.stepsIndex);
    }

    public RealmList<RFGActTag> realmGet$tags() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGActTag> realmList = this.tagsRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGActTag> realmList2 = new RealmList<>(RFGActTag.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.tagsIndex), this.proxyState.getRealm$realm());
        this.tagsRealmList = realmList2;
        return realmList2;
    }

    public int realmGet$toDate() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.toDateIndex);
    }

    public RealmList<RFGTrackPoint> realmGet$trackPoints() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGTrackPoint> realmList = this.trackPointsRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGTrackPoint> realmList2 = new RealmList<>(RFGTrackPoint.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.trackPointsIndex), this.proxyState.getRealm$realm());
        this.trackPointsRealmList = realmList2;
        return realmList2;
    }

    public void realmSet$activity(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.activityIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'activity' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.activityIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'activity' to null.");
        }
    }

    public void realmSet$fromDate(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.fromDateIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.fromDateIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$steps(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.stepsIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.stepsIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$tags(RealmList<RFGActTag> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("tags")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGActTag> realmList2 = new RealmList<>();
                Iterator<RFGActTag> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGActTag) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.tagsIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGActTag rFGActTag = realmList.get(i);
                    this.proxyState.checkValidObject(rFGActTag);
                    modelList.addRow(((RealmObjectProxy) rFGActTag).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGActTag rFGActTag2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGActTag2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGActTag2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
    }

    public void realmSet$toDate(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.toDateIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.toDateIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$trackPoints(RealmList<RFGTrackPoint> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("trackPoints")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGTrackPoint> realmList2 = new RealmList<>();
                Iterator<RFGTrackPoint> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGTrackPoint) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.trackPointsIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGTrackPoint rFGTrackPoint = realmList.get(i);
                    this.proxyState.checkValidObject(rFGTrackPoint);
                    modelList.addRow(((RealmObjectProxy) rFGTrackPoint).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGTrackPoint rFGTrackPoint2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGTrackPoint2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGTrackPoint2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGActivity = proxy[", "{fromDate:");
        b.append(realmGet$fromDate());
        b.append("}");
        b.append(",");
        b.append("{toDate:");
        b.append(realmGet$toDate());
        b.append("}");
        b.append(",");
        b.append("{steps:");
        b.append(realmGet$steps());
        b.append("}");
        b.append(",");
        b.append("{activity:");
        b.append(realmGet$activity());
        C0681a.m335a(b, "}", ",", "{trackPoints:", "RealmList<RFGTrackPoint>[");
        b.append(realmGet$trackPoints().size());
        b.append("]");
        b.append("}");
        b.append(",");
        b.append("{tags:");
        b.append("RealmList<RFGActTag>[");
        b.append(realmGet$tags().size());
        b.append("]");
        return C0681a.m324a(b, "}", "]");
    }
}
