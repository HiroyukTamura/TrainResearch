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
import p041io.realm.internal.OsObject;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Row;
import p041io.realm.internal.Table;
import p041io.realm.internal.objectstore.OsObjectBuilder;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity;

/* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy */
public class jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy extends RFGTrainEntity implements RealmObjectProxy, C1014x5da4d90 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGTrainEntityColumnInfo columnInfo;
    private ProxyState<RFGTrainEntity> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGTrainEntity";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy$RFGTrainEntityColumnInfo */
    static final class RFGTrainEntityColumnInfo extends ColumnInfo {
        long idIndex;
        long maxColumnIndexValue;
        long stationsIndex;
        long trainsIndex;
        long updateTimeIndex;

        RFGTrainEntityColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGTrainEntityColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.stationsIndex = addColumnDetails("stations", "stations", objectSchemaInfo);
            this.trainsIndex = addColumnDetails("trains", "trains", objectSchemaInfo);
            this.updateTimeIndex = addColumnDetails("updateTime", "updateTime", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGTrainEntityColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGTrainEntityColumnInfo rFGTrainEntityColumnInfo = (RFGTrainEntityColumnInfo) columnInfo;
            RFGTrainEntityColumnInfo rFGTrainEntityColumnInfo2 = (RFGTrainEntityColumnInfo) columnInfo2;
            rFGTrainEntityColumnInfo2.idIndex = rFGTrainEntityColumnInfo.idIndex;
            rFGTrainEntityColumnInfo2.stationsIndex = rFGTrainEntityColumnInfo.stationsIndex;
            rFGTrainEntityColumnInfo2.trainsIndex = rFGTrainEntityColumnInfo.trainsIndex;
            rFGTrainEntityColumnInfo2.updateTimeIndex = rFGTrainEntityColumnInfo.updateTimeIndex;
            rFGTrainEntityColumnInfo2.maxColumnIndexValue = rFGTrainEntityColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGTrainEntity copy(Realm realm, RFGTrainEntityColumnInfo rFGTrainEntityColumnInfo, RFGTrainEntity rFGTrainEntity, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGTrainEntity);
        if (realmObjectProxy != null) {
            return (RFGTrainEntity) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGTrainEntity.class), rFGTrainEntityColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGTrainEntityColumnInfo.idIndex, rFGTrainEntity.realmGet$id());
        osObjectBuilder.addString(rFGTrainEntityColumnInfo.stationsIndex, rFGTrainEntity.realmGet$stations());
        osObjectBuilder.addString(rFGTrainEntityColumnInfo.trainsIndex, rFGTrainEntity.realmGet$trains());
        osObjectBuilder.addInteger(rFGTrainEntityColumnInfo.updateTimeIndex, Long.valueOf(rFGTrainEntity.realmGet$updateTime()));
        jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGTrainEntity, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.RFGTrainEntityColumnInfo r9, p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.silentlog.RFGTrainEntity r1 = (p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGTrainEntity> r2 = p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity.class
            io.realm.internal.Table r2 = r8.getTable(r2)
            long r3 = r9.idIndex
            java.lang.String r5 = r10.realmGet$id()
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
            io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.silentlog.RFGTrainEntity r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.silentlog.RFGTrainEntity r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy$RFGTrainEntityColumnInfo, jp.reifrontier.gym.domain.silentlog.RFGTrainEntity, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.silentlog.RFGTrainEntity");
    }

    public static RFGTrainEntityColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGTrainEntityColumnInfo(osSchemaInfo);
    }

    public static RFGTrainEntity createDetachedCopy(RFGTrainEntity rFGTrainEntity, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGTrainEntity rFGTrainEntity2;
        if (i > i2 || rFGTrainEntity == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGTrainEntity);
        if (cacheData == null) {
            rFGTrainEntity2 = new RFGTrainEntity();
            map.put(rFGTrainEntity, new RealmObjectProxy.CacheData(i, rFGTrainEntity2));
        } else if (i >= cacheData.minDepth) {
            return (RFGTrainEntity) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGTrainEntity2 = (RFGTrainEntity) cacheData.object;
        }
        rFGTrainEntity2.realmSet$id(rFGTrainEntity.realmGet$id());
        rFGTrainEntity2.realmSet$stations(rFGTrainEntity.realmGet$stations());
        rFGTrainEntity2.realmSet$trains(rFGTrainEntity.realmGet$trains());
        rFGTrainEntity2.realmSet$updateTime(rFGTrainEntity.realmGet$updateTime());
        return rFGTrainEntity2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 4, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("id", RealmFieldType.STRING, true, true, true);
        builder2.addPersistedProperty("stations", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("trains", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("updateTime", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity createOrUpdateUsingJsonObject(p041io.realm.Realm r13, org.json.JSONObject r14, boolean r15) throws org.json.JSONException {
        /*
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGTrainEntity> r0 = p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity.class
            java.util.List r1 = java.util.Collections.emptyList()
            r2 = 0
            java.lang.String r3 = "id"
            if (r15 == 0) goto L_0x005d
            io.realm.internal.Table r15 = r13.getTable(r0)
            io.realm.RealmSchema r4 = r13.getSchema()
            io.realm.internal.ColumnInfo r4 = r4.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)
            io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy$RFGTrainEntityColumnInfo r4 = (p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.RFGTrainEntityColumnInfo) r4
            long r4 = r4.idIndex
            boolean r6 = r14.isNull(r3)
            r7 = -1
            if (r6 != 0) goto L_0x002c
            java.lang.String r6 = r14.getString(r3)
            long r4 = r15.findFirstString(r4, r6)
            goto L_0x002d
        L_0x002c:
            r4 = r7
        L_0x002d:
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x005d
            io.realm.BaseRealm$ThreadLocalRealmObjectContext r6 = p041io.realm.BaseRealm.objectContext
            java.lang.Object r6 = r6.get()
            io.realm.BaseRealm$RealmObjectContext r6 = (p041io.realm.BaseRealm.RealmObjectContext) r6
            io.realm.internal.UncheckedRow r9 = r15.getUncheckedRow(r4)     // Catch:{ all -> 0x0058 }
            io.realm.RealmSchema r15 = r13.getSchema()     // Catch:{ all -> 0x0058 }
            io.realm.internal.ColumnInfo r10 = r15.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)     // Catch:{ all -> 0x0058 }
            r11 = 0
            java.util.List r12 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0058 }
            r7 = r6
            r8 = r13
            r7.set(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0058 }
            io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy r15 = new io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy     // Catch:{ all -> 0x0058 }
            r15.<init>()     // Catch:{ all -> 0x0058 }
            r6.clear()
            goto L_0x005e
        L_0x0058:
            r13 = move-exception
            r6.clear()
            throw r13
        L_0x005d:
            r15 = r2
        L_0x005e:
            if (r15 != 0) goto L_0x0086
            boolean r15 = r14.has(r3)
            if (r15 == 0) goto L_0x007e
            boolean r15 = r14.isNull(r3)
            r4 = 1
            if (r15 == 0) goto L_0x0072
            io.realm.RealmModel r13 = r13.createObjectInternal(r0, r2, r4, r1)
            goto L_0x007a
        L_0x0072:
            java.lang.String r15 = r14.getString(r3)
            io.realm.RealmModel r13 = r13.createObjectInternal(r0, r15, r4, r1)
        L_0x007a:
            r15 = r13
            io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy r15 = (p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy) r15
            goto L_0x0086
        L_0x007e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "JSON object doesn't have the primary key field 'id'."
            r13.<init>(r14)
            throw r13
        L_0x0086:
            java.lang.String r13 = "stations"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x009f
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x0098
            r15.realmSet$stations(r2)
            goto L_0x009f
        L_0x0098:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$stations(r13)
        L_0x009f:
            java.lang.String r13 = "trains"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00b8
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x00b1
            r15.realmSet$trains(r2)
            goto L_0x00b8
        L_0x00b1:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$trains(r13)
        L_0x00b8:
            java.lang.String r13 = "updateTime"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00d6
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00ce
            long r13 = r14.getLong(r13)
            r15.realmSet$updateTime(r13)
            goto L_0x00d6
        L_0x00ce:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'updateTime' to null."
            r13.<init>(r14)
            throw r13
        L_0x00d6:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.silentlog.RFGTrainEntity");
    }

    @TargetApi(11)
    public static RFGTrainEntity createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGTrainEntity rFGTrainEntity = new RFGTrainEntity();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("id")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGTrainEntity.realmSet$id(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGTrainEntity.realmSet$id((String) null);
                }
                z = true;
            } else if (nextName.equals("stations")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGTrainEntity.realmSet$stations(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGTrainEntity.realmSet$stations((String) null);
                }
            } else if (nextName.equals("trains")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGTrainEntity.realmSet$trains(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGTrainEntity.realmSet$trains((String) null);
                }
            } else if (!nextName.equals("updateTime")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGTrainEntity.realmSet$updateTime(jsonReader.nextLong());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'updateTime' to null.");
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGTrainEntity) realm.copyToRealm(rFGTrainEntity, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGTrainEntity rFGTrainEntity, Map<RealmModel, Long> map) {
        Class<RFGTrainEntity> cls = RFGTrainEntity.class;
        if (rFGTrainEntity instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrainEntity;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGTrainEntityColumnInfo rFGTrainEntityColumnInfo = (RFGTrainEntityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGTrainEntityColumnInfo.idIndex;
        String realmGet$id = rFGTrainEntity.realmGet$id();
        long nativeFindFirstString = realmGet$id != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$id) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$id);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$id);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGTrainEntity, Long.valueOf(j2));
        String realmGet$stations = rFGTrainEntity.realmGet$stations();
        if (realmGet$stations != null) {
            Table.nativeSetString(nativePtr, rFGTrainEntityColumnInfo.stationsIndex, j2, realmGet$stations, false);
        }
        String realmGet$trains = rFGTrainEntity.realmGet$trains();
        if (realmGet$trains != null) {
            Table.nativeSetString(nativePtr, rFGTrainEntityColumnInfo.trainsIndex, j2, realmGet$trains, false);
        }
        Table.nativeSetLong(nativePtr, rFGTrainEntityColumnInfo.updateTimeIndex, j2, rFGTrainEntity.realmGet$updateTime(), false);
        return j2;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Map<RealmModel, Long> map2 = map;
        Class<RFGTrainEntity> cls = RFGTrainEntity.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGTrainEntityColumnInfo rFGTrainEntityColumnInfo = (RFGTrainEntityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGTrainEntityColumnInfo.idIndex;
        while (it.hasNext()) {
            RFGTrainEntity rFGTrainEntity = (RFGTrainEntity) it.next();
            if (!map2.containsKey(rFGTrainEntity)) {
                if (rFGTrainEntity instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrainEntity;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGTrainEntity, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$id = rFGTrainEntity.realmGet$id();
                long nativeFindFirstString = realmGet$id != null ? Table.nativeFindFirstString(nativePtr, j3, realmGet$id) : -1;
                if (nativeFindFirstString == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j3, realmGet$id);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$id);
                    j = nativeFindFirstString;
                }
                map2.put(rFGTrainEntity, Long.valueOf(j));
                String realmGet$stations = rFGTrainEntity.realmGet$stations();
                if (realmGet$stations != null) {
                    j2 = j3;
                    Table.nativeSetString(nativePtr, rFGTrainEntityColumnInfo.stationsIndex, j, realmGet$stations, false);
                } else {
                    j2 = j3;
                }
                String realmGet$trains = rFGTrainEntity.realmGet$trains();
                if (realmGet$trains != null) {
                    Table.nativeSetString(nativePtr, rFGTrainEntityColumnInfo.trainsIndex, j, realmGet$trains, false);
                }
                Table.nativeSetLong(nativePtr, rFGTrainEntityColumnInfo.updateTimeIndex, j, rFGTrainEntity.realmGet$updateTime(), false);
                j3 = j2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGTrainEntity rFGTrainEntity, Map<RealmModel, Long> map) {
        Class<RFGTrainEntity> cls = RFGTrainEntity.class;
        if (rFGTrainEntity instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrainEntity;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGTrainEntityColumnInfo rFGTrainEntityColumnInfo = (RFGTrainEntityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGTrainEntityColumnInfo.idIndex;
        String realmGet$id = rFGTrainEntity.realmGet$id();
        long nativeFindFirstString = realmGet$id != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$id) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$id);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGTrainEntity, Long.valueOf(j2));
        String realmGet$stations = rFGTrainEntity.realmGet$stations();
        long j3 = rFGTrainEntityColumnInfo.stationsIndex;
        if (realmGet$stations != null) {
            Table.nativeSetString(nativePtr, j3, j2, realmGet$stations, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, j2, false);
        }
        String realmGet$trains = rFGTrainEntity.realmGet$trains();
        long j4 = rFGTrainEntityColumnInfo.trainsIndex;
        if (realmGet$trains != null) {
            Table.nativeSetString(nativePtr, j4, j2, realmGet$trains, false);
        } else {
            Table.nativeSetNull(nativePtr, j4, j2, false);
        }
        Table.nativeSetLong(nativePtr, rFGTrainEntityColumnInfo.updateTimeIndex, j2, rFGTrainEntity.realmGet$updateTime(), false);
        return j2;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Map<RealmModel, Long> map2 = map;
        Class<RFGTrainEntity> cls = RFGTrainEntity.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGTrainEntityColumnInfo rFGTrainEntityColumnInfo = (RFGTrainEntityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGTrainEntityColumnInfo.idIndex;
        while (it.hasNext()) {
            RFGTrainEntity rFGTrainEntity = (RFGTrainEntity) it.next();
            if (!map2.containsKey(rFGTrainEntity)) {
                if (rFGTrainEntity instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGTrainEntity;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGTrainEntity, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$id = rFGTrainEntity.realmGet$id();
                long nativeFindFirstString = realmGet$id != null ? Table.nativeFindFirstString(nativePtr, j2, realmGet$id) : -1;
                long createRowWithPrimaryKey = nativeFindFirstString == -1 ? OsObject.createRowWithPrimaryKey(table, j2, realmGet$id) : nativeFindFirstString;
                map2.put(rFGTrainEntity, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$stations = rFGTrainEntity.realmGet$stations();
                if (realmGet$stations != null) {
                    j = j2;
                    Table.nativeSetString(nativePtr, rFGTrainEntityColumnInfo.stationsIndex, createRowWithPrimaryKey, realmGet$stations, false);
                } else {
                    j = j2;
                    Table.nativeSetNull(nativePtr, rFGTrainEntityColumnInfo.stationsIndex, createRowWithPrimaryKey, false);
                }
                String realmGet$trains = rFGTrainEntity.realmGet$trains();
                long j3 = rFGTrainEntityColumnInfo.trainsIndex;
                if (realmGet$trains != null) {
                    Table.nativeSetString(nativePtr, j3, createRowWithPrimaryKey, realmGet$trains, false);
                } else {
                    Table.nativeSetNull(nativePtr, j3, createRowWithPrimaryKey, false);
                }
                Table.nativeSetLong(nativePtr, rFGTrainEntityColumnInfo.updateTimeIndex, createRowWithPrimaryKey, rFGTrainEntity.realmGet$updateTime(), false);
                j2 = j;
            }
        }
    }

    private static jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGTrainEntity.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy jp_reifrontier_gym_domain_silentlog_rfgtrainentityrealmproxy = new jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_silentlog_rfgtrainentityrealmproxy;
    }

    static RFGTrainEntity update(Realm realm, RFGTrainEntityColumnInfo rFGTrainEntityColumnInfo, RFGTrainEntity rFGTrainEntity, RFGTrainEntity rFGTrainEntity2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGTrainEntity.class), rFGTrainEntityColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGTrainEntityColumnInfo.idIndex, rFGTrainEntity2.realmGet$id());
        osObjectBuilder.addString(rFGTrainEntityColumnInfo.stationsIndex, rFGTrainEntity2.realmGet$stations());
        osObjectBuilder.addString(rFGTrainEntityColumnInfo.trainsIndex, rFGTrainEntity2.realmGet$trains());
        osObjectBuilder.addInteger(rFGTrainEntityColumnInfo.updateTimeIndex, Long.valueOf(rFGTrainEntity2.realmGet$updateTime()));
        osObjectBuilder.updateExistingObject();
        return rFGTrainEntity;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy jp_reifrontier_gym_domain_silentlog_rfgtrainentityrealmproxy = (jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_silentlog_rfgtrainentityrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_silentlog_rfgtrainentityrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_silentlog_rfgtrainentityrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGTrainEntityColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGTrainEntity> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$id() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.idIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public String realmGet$stations() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.stationsIndex);
    }

    public String realmGet$trains() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.trainsIndex);
    }

    public long realmGet$updateTime() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.updateTimeIndex);
    }

    public void realmSet$id(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    public void realmSet$stations(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.stationsIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'stations' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.stationsIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'stations' to null.");
        }
    }

    public void realmSet$trains(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.trainsIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'trains' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.trainsIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'trains' to null.");
        }
    }

    public void realmSet$updateTime(long j) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.updateTimeIndex, j);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.updateTimeIndex, row$realm.getIndex(), j, true);
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGTrainEntity = proxy[", "{id:");
        b.append(realmGet$id());
        b.append("}");
        b.append(",");
        b.append("{stations:");
        b.append(realmGet$stations());
        b.append("}");
        b.append(",");
        b.append("{trains:");
        b.append(realmGet$trains());
        b.append("}");
        b.append(",");
        b.append("{updateTime:");
        b.append(realmGet$updateTime());
        return C0681a.m324a(b, "}", "]");
    }
}
