package p041io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.BaseRealm;
import p041io.realm.exceptions.RealmException;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsList;
import p041io.realm.internal.OsObject;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Row;
import p041io.realm.internal.Table;
import p041io.realm.internal.objectstore.OsObjectBuilder;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy;
import p043jp.reifrontier.gym.domain.silentlog.RFGActivity;
import p043jp.reifrontier.gym.domain.silentlog.RFGDay;

/* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy */
public class jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy extends RFGDay implements RealmObjectProxy, jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxyInterface {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmList<RFGActivity> activitesRealmList;
    private RFGDayColumnInfo columnInfo;
    private ProxyState<RFGDay> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGDay";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy$RFGDayColumnInfo */
    static final class RFGDayColumnInfo extends ColumnInfo {
        long activitesIndex;
        long dateIndex;
        long maxColumnIndexValue;

        RFGDayColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGDayColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.activitesIndex = addColumnDetails("activites", "activites", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGDayColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGDayColumnInfo rFGDayColumnInfo = (RFGDayColumnInfo) columnInfo;
            RFGDayColumnInfo rFGDayColumnInfo2 = (RFGDayColumnInfo) columnInfo2;
            rFGDayColumnInfo2.dateIndex = rFGDayColumnInfo.dateIndex;
            rFGDayColumnInfo2.activitesIndex = rFGDayColumnInfo.activitesIndex;
            rFGDayColumnInfo2.maxColumnIndexValue = rFGDayColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGDay copy(Realm realm, RFGDayColumnInfo rFGDayColumnInfo, RFGDay rFGDay, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGDay);
        if (realmObjectProxy != null) {
            return (RFGDay) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGDay.class), rFGDayColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGDayColumnInfo.dateIndex, rFGDay.realmGet$date());
        jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGDay, newProxyInstance);
        RealmList<RFGActivity> realmGet$activites = rFGDay.realmGet$activites();
        if (realmGet$activites != null) {
            RealmList<RFGActivity> realmGet$activites2 = newProxyInstance.realmGet$activites();
            realmGet$activites2.clear();
            for (int i = 0; i < realmGet$activites.size(); i++) {
                RFGActivity rFGActivity = realmGet$activites.get(i);
                RFGActivity rFGActivity2 = (RFGActivity) map.get(rFGActivity);
                if (rFGActivity2 == null) {
                    rFGActivity2 = jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.RFGActivityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGActivity.class), rFGActivity, z, map, set);
                }
                realmGet$activites2.add(rFGActivity2);
            }
        }
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.silentlog.RFGDay copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.RFGDayColumnInfo r9, p043jp.reifrontier.gym.domain.silentlog.RFGDay r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
        /*
            boolean r0 = r10 instanceof p041io.realm.internal.RealmObjectProxy
            if (r0 == 0) goto L_0x0038
            r0 = r10
            io.realm.internal.RealmObjectProxy r0 = (p041io.realm.internal.RealmObjectProxy) r0
            io.realm.ProxyState r1 = r0.realmGet$proxyState()
            io.realm.BaseRealm r1 = r1.getRealm$realm()
            if (r1 == 0) goto L_0x0038
            io.realm.ProxyState r0 = r0.realmGet$proxyState()
            io.realm.BaseRealm r0 = r0.getRealm$realm()
            long r1 = r0.threadId
            long r3 = r8.threadId
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0030
            java.lang.String r0 = r0.getPath()
            java.lang.String r1 = r8.getPath()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            return r10
        L_0x0030:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Objects which belong to Realm instances in other threads cannot be copied into this Realm instance."
            r8.<init>(r9)
            throw r8
        L_0x0038:
            io.realm.BaseRealm$ThreadLocalRealmObjectContext r0 = p041io.realm.BaseRealm.objectContext
            java.lang.Object r0 = r0.get()
            io.realm.BaseRealm$RealmObjectContext r0 = (p041io.realm.BaseRealm.RealmObjectContext) r0
            java.lang.Object r1 = r12.get(r10)
            io.realm.internal.RealmObjectProxy r1 = (p041io.realm.internal.RealmObjectProxy) r1
            if (r1 == 0) goto L_0x004b
            jp.reifrontier.gym.domain.silentlog.RFGDay r1 = (p043jp.reifrontier.gym.domain.silentlog.RFGDay) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGDay> r2 = p043jp.reifrontier.gym.domain.silentlog.RFGDay.class
            io.realm.internal.Table r2 = r8.getTable(r2)
            long r3 = r9.dateIndex
            java.lang.String r5 = r10.realmGet$date()
            long r3 = r2.findFirstString(r3, r5)
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0066
            r0 = 0
            goto L_0x0087
        L_0x0066:
            io.realm.internal.UncheckedRow r3 = r2.getUncheckedRow(r3)     // Catch:{ all -> 0x0081 }
            r5 = 0
            java.util.List r6 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0081 }
            r1 = r0
            r2 = r8
            r4 = r9
            r1.set(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0081 }
            io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy     // Catch:{ all -> 0x0081 }
            r1.<init>()     // Catch:{ all -> 0x0081 }
            r12.put(r10, r1)     // Catch:{ all -> 0x0081 }
            r0.clear()
            goto L_0x0086
        L_0x0081:
            r8 = move-exception
            r0.clear()
            throw r8
        L_0x0086:
            r0 = r11
        L_0x0087:
            r3 = r1
            if (r0 == 0) goto L_0x0094
            r1 = r8
            r2 = r9
            r4 = r10
            r5 = r12
            r6 = r13
            jp.reifrontier.gym.domain.silentlog.RFGDay r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.silentlog.RFGDay r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy$RFGDayColumnInfo, jp.reifrontier.gym.domain.silentlog.RFGDay, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.silentlog.RFGDay");
    }

    public static RFGDayColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGDayColumnInfo(osSchemaInfo);
    }

    public static RFGDay createDetachedCopy(RFGDay rFGDay, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGDay rFGDay2;
        if (i > i2 || rFGDay == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGDay);
        if (cacheData == null) {
            rFGDay2 = new RFGDay();
            map.put(rFGDay, new RealmObjectProxy.CacheData(i, rFGDay2));
        } else if (i >= cacheData.minDepth) {
            return (RFGDay) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGDay2 = (RFGDay) cacheData.object;
        }
        rFGDay2.realmSet$date(rFGDay.realmGet$date());
        if (i == i2) {
            rFGDay2.realmSet$activites((RealmList<RFGActivity>) null);
        } else {
            RealmList<RFGActivity> realmGet$activites = rFGDay.realmGet$activites();
            RealmList realmList = new RealmList();
            rFGDay2.realmSet$activites(realmList);
            int i3 = i + 1;
            int size = realmGet$activites.size();
            for (int i4 = 0; i4 < size; i4++) {
                realmList.add(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.createDetachedCopy(realmGet$activites.get(i4), i3, i2, map));
            }
        }
        return rFGDay2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 2, 0);
        builder.addPersistedProperty("date", RealmFieldType.STRING, true, true, true);
        builder.addPersistedLinkProperty("activites", RealmFieldType.LIST, jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.silentlog.RFGDay createOrUpdateUsingJsonObject(p041io.realm.Realm r15, org.json.JSONObject r16, boolean r17) throws org.json.JSONException {
        /*
            r0 = r15
            r7 = r16
            r8 = r17
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGDay> r9 = p043jp.reifrontier.gym.domain.silentlog.RFGDay.class
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 1
            r10.<init>(r11)
            r12 = 0
            java.lang.String r13 = "date"
            if (r8 == 0) goto L_0x0065
            io.realm.internal.Table r1 = r15.getTable(r9)
            io.realm.RealmSchema r2 = r15.getSchema()
            io.realm.internal.ColumnInfo r2 = r2.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r9)
            io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy$RFGDayColumnInfo r2 = (p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.RFGDayColumnInfo) r2
            long r2 = r2.dateIndex
            boolean r4 = r7.isNull(r13)
            r5 = -1
            if (r4 != 0) goto L_0x0033
            java.lang.String r4 = r7.getString(r13)
            long r2 = r1.findFirstString(r2, r4)
            goto L_0x0034
        L_0x0033:
            r2 = r5
        L_0x0034:
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0065
            io.realm.BaseRealm$ThreadLocalRealmObjectContext r4 = p041io.realm.BaseRealm.objectContext
            java.lang.Object r4 = r4.get()
            r14 = r4
            io.realm.BaseRealm$RealmObjectContext r14 = (p041io.realm.BaseRealm.RealmObjectContext) r14
            io.realm.internal.UncheckedRow r3 = r1.getUncheckedRow(r2)     // Catch:{ all -> 0x0060 }
            io.realm.RealmSchema r1 = r15.getSchema()     // Catch:{ all -> 0x0060 }
            io.realm.internal.ColumnInfo r4 = r1.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r9)     // Catch:{ all -> 0x0060 }
            r5 = 0
            java.util.List r6 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0060 }
            r1 = r14
            r2 = r15
            r1.set(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0060 }
            io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            r14.clear()
            goto L_0x0066
        L_0x0060:
            r0 = move-exception
            r14.clear()
            throw r0
        L_0x0065:
            r1 = r12
        L_0x0066:
            java.lang.String r2 = "activites"
            if (r1 != 0) goto L_0x0097
            boolean r1 = r7.has(r2)
            if (r1 == 0) goto L_0x0073
            r10.add(r2)
        L_0x0073:
            boolean r1 = r7.has(r13)
            if (r1 == 0) goto L_0x008f
            boolean r1 = r7.isNull(r13)
            if (r1 == 0) goto L_0x0084
            io.realm.RealmModel r1 = r15.createObjectInternal(r9, r12, r11, r10)
            goto L_0x008c
        L_0x0084:
            java.lang.String r1 = r7.getString(r13)
            io.realm.RealmModel r1 = r15.createObjectInternal(r9, r1, r11, r10)
        L_0x008c:
            io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy r1 = (p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy) r1
            goto L_0x0097
        L_0x008f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "JSON object doesn't have the primary key field 'date'."
            r0.<init>(r1)
            throw r0
        L_0x0097:
            boolean r3 = r7.has(r2)
            if (r3 == 0) goto L_0x00cb
            boolean r3 = r7.isNull(r2)
            if (r3 == 0) goto L_0x00a7
            r1.realmSet$activites(r12)
            goto L_0x00cb
        L_0x00a7:
            io.realm.RealmList r3 = r1.realmGet$activites()
            r3.clear()
            org.json.JSONArray r2 = r7.getJSONArray(r2)
            r3 = 0
        L_0x00b3:
            int r4 = r2.length()
            if (r3 >= r4) goto L_0x00cb
            org.json.JSONObject r4 = r2.getJSONObject(r3)
            jp.reifrontier.gym.domain.silentlog.RFGActivity r4 = p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.createOrUpdateUsingJsonObject(r15, r4, r8)
            io.realm.RealmList r5 = r1.realmGet$activites()
            r5.add(r4)
            int r3 = r3 + 1
            goto L_0x00b3
        L_0x00cb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.silentlog.RFGDay");
    }

    @TargetApi(11)
    public static RFGDay createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGDay rFGDay = new RFGDay();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("date")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGDay.realmSet$date(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGDay.realmSet$date((String) null);
                }
                z = true;
            } else if (!nextName.equals("activites")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                rFGDay.realmSet$activites((RealmList<RFGActivity>) null);
            } else {
                rFGDay.realmSet$activites(new RealmList());
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    rFGDay.realmGet$activites().add(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGDay) realm.copyToRealm(rFGDay, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'date'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGDay rFGDay, Map<RealmModel, Long> map) {
        Class<RFGDay> cls = RFGDay.class;
        if (rFGDay instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGDay;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGDayColumnInfo rFGDayColumnInfo = (RFGDayColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGDayColumnInfo.dateIndex;
        String realmGet$date = rFGDay.realmGet$date();
        long nativeFindFirstString = realmGet$date != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$date) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$date);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$date);
        }
        map.put(rFGDay, Long.valueOf(nativeFindFirstString));
        RealmList<RFGActivity> realmGet$activites = rFGDay.realmGet$activites();
        if (realmGet$activites != null) {
            OsList osList = new OsList(table.getUncheckedRow(nativeFindFirstString), rFGDayColumnInfo.activitesIndex);
            Iterator<RFGActivity> it = realmGet$activites.iterator();
            while (it.hasNext()) {
                RFGActivity next = it.next();
                Long l = map.get(next);
                if (l == null) {
                    l = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insert(realm, next, map));
                }
                osList.addRow(l.longValue());
            }
        }
        return nativeFindFirstString;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Class<RFGDay> cls = RFGDay.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGDayColumnInfo rFGDayColumnInfo = (RFGDayColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGDayColumnInfo.dateIndex;
        while (it.hasNext()) {
            RFGDay rFGDay = (RFGDay) it.next();
            if (!map.containsKey(rFGDay)) {
                if (rFGDay instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGDay;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map.put(rFGDay, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$date = rFGDay.realmGet$date();
                long nativeFindFirstString = realmGet$date != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$date) : -1;
                if (nativeFindFirstString == -1) {
                    nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$date);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$date);
                }
                map.put(rFGDay, Long.valueOf(nativeFindFirstString));
                RealmList<RFGActivity> realmGet$activites = rFGDay.realmGet$activites();
                if (realmGet$activites != null) {
                    OsList osList = new OsList(table.getUncheckedRow(nativeFindFirstString), rFGDayColumnInfo.activitesIndex);
                    Iterator<RFGActivity> it2 = realmGet$activites.iterator();
                    while (it2.hasNext()) {
                        RFGActivity next = it2.next();
                        Long l = map.get(next);
                        if (l == null) {
                            l = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insert(realm, next, map));
                        }
                        osList.addRow(l.longValue());
                    }
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGDay rFGDay, Map<RealmModel, Long> map) {
        Class<RFGDay> cls = RFGDay.class;
        if (rFGDay instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGDay;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGDayColumnInfo rFGDayColumnInfo = (RFGDayColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGDayColumnInfo.dateIndex;
        String realmGet$date = rFGDay.realmGet$date();
        long nativeFindFirstString = realmGet$date != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$date) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$date);
        }
        map.put(rFGDay, Long.valueOf(nativeFindFirstString));
        OsList osList = new OsList(table.getUncheckedRow(nativeFindFirstString), rFGDayColumnInfo.activitesIndex);
        RealmList<RFGActivity> realmGet$activites = rFGDay.realmGet$activites();
        if (realmGet$activites == null || ((long) realmGet$activites.size()) != osList.size()) {
            osList.removeAll();
            if (realmGet$activites != null) {
                Iterator<RFGActivity> it = realmGet$activites.iterator();
                while (it.hasNext()) {
                    RFGActivity next = it.next();
                    Long l = map.get(next);
                    if (l == null) {
                        l = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insertOrUpdate(realm, next, map));
                    }
                    osList.addRow(l.longValue());
                }
            }
        } else {
            int size = realmGet$activites.size();
            for (int i = 0; i < size; i++) {
                RFGActivity rFGActivity = realmGet$activites.get(i);
                Long l2 = map.get(rFGActivity);
                if (l2 == null) {
                    l2 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insertOrUpdate(realm, rFGActivity, map));
                }
                osList.setRow((long) i, l2.longValue());
            }
        }
        return nativeFindFirstString;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGDay> cls = RFGDay.class;
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGDayColumnInfo rFGDayColumnInfo = (RFGDayColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGDayColumnInfo.dateIndex;
        while (it.hasNext()) {
            RFGDay rFGDay = (RFGDay) it.next();
            if (!map2.containsKey(rFGDay)) {
                if (rFGDay instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGDay;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGDay, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$date = rFGDay.realmGet$date();
                long nativeFindFirstString = realmGet$date != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$date) : -1;
                if (nativeFindFirstString == -1) {
                    nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$date);
                }
                map2.put(rFGDay, Long.valueOf(nativeFindFirstString));
                OsList osList = new OsList(table.getUncheckedRow(nativeFindFirstString), rFGDayColumnInfo.activitesIndex);
                RealmList<RFGActivity> realmGet$activites = rFGDay.realmGet$activites();
                if (realmGet$activites == null || ((long) realmGet$activites.size()) != osList.size()) {
                    osList.removeAll();
                    if (realmGet$activites != null) {
                        Iterator<RFGActivity> it2 = realmGet$activites.iterator();
                        while (it2.hasNext()) {
                            RFGActivity next = it2.next();
                            Long l = map2.get(next);
                            if (l == null) {
                                l = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insertOrUpdate(realm2, next, map2));
                            }
                            osList.addRow(l.longValue());
                        }
                    }
                } else {
                    int size = realmGet$activites.size();
                    for (int i = 0; i < size; i++) {
                        RFGActivity rFGActivity = realmGet$activites.get(i);
                        Long l2 = map2.get(rFGActivity);
                        if (l2 == null) {
                            l2 = Long.valueOf(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insertOrUpdate(realm2, rFGActivity, map2));
                        }
                        osList.setRow((long) i, l2.longValue());
                    }
                }
            }
        }
    }

    private static jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGDay.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy jp_reifrontier_gym_domain_silentlog_rfgdayrealmproxy = new jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_silentlog_rfgdayrealmproxy;
    }

    static RFGDay update(Realm realm, RFGDayColumnInfo rFGDayColumnInfo, RFGDay rFGDay, RFGDay rFGDay2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGDay.class), rFGDayColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGDayColumnInfo.dateIndex, rFGDay2.realmGet$date());
        RealmList<RFGActivity> realmGet$activites = rFGDay2.realmGet$activites();
        if (realmGet$activites != null) {
            RealmList realmList = new RealmList();
            for (int i = 0; i < realmGet$activites.size(); i++) {
                RFGActivity rFGActivity = realmGet$activites.get(i);
                RFGActivity rFGActivity2 = (RFGActivity) map.get(rFGActivity);
                if (rFGActivity2 == null) {
                    rFGActivity2 = jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.RFGActivityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGActivity.class), rFGActivity, true, map, set);
                }
                realmList.add(rFGActivity2);
            }
            osObjectBuilder.addObjectList(rFGDayColumnInfo.activitesIndex, realmList);
        } else {
            osObjectBuilder.addObjectList(rFGDayColumnInfo.activitesIndex, new RealmList());
        }
        osObjectBuilder.updateExistingObject();
        return rFGDay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy jp_reifrontier_gym_domain_silentlog_rfgdayrealmproxy = (jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_silentlog_rfgdayrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_silentlog_rfgdayrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_silentlog_rfgdayrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGDayColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGDay> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public RealmList<RFGActivity> realmGet$activites() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGActivity> realmList = this.activitesRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGActivity> realmList2 = new RealmList<>(RFGActivity.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.activitesIndex), this.proxyState.getRealm$realm());
        this.activitesRealmList = realmList2;
        return realmList2;
    }

    public String realmGet$date() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.dateIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public void realmSet$activites(RealmList<RFGActivity> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("activites")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGActivity> realmList2 = new RealmList<>();
                Iterator<RFGActivity> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGActivity) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.activitesIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGActivity rFGActivity = realmList.get(i);
                    this.proxyState.checkValidObject(rFGActivity);
                    modelList.addRow(((RealmObjectProxy) rFGActivity).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGActivity rFGActivity2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGActivity2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGActivity2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
    }

    public void realmSet$date(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'date' cannot be changed after object was created.");
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGDay = proxy[", "{date:");
        b.append(realmGet$date());
        b.append("}");
        b.append(",");
        b.append("{activites:");
        b.append("RealmList<RFGActivity>[");
        b.append(realmGet$activites().size());
        b.append("]");
        b.append("}");
        b.append("]");
        return b.toString();
    }
}
