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
import p043jp.reifrontier.gym.domain.api.train.RFGApiSpot;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy */
public class jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy extends RFGApiSpot implements RealmObjectProxy, C1010x7e6e613 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiSpotColumnInfo columnInfo;
    private ProxyState<RFGApiSpot> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiSpot";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy$RFGApiSpotColumnInfo */
    static final class RFGApiSpotColumnInfo extends ColumnInfo {
        long dateIndex;
        long idIndex;
        long maxColumnIndexValue;
        long orderIndex;
        long stationIdIndex;
        long titleIndex;
        long updateAtIndex;

        RFGApiSpotColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiSpotColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.stationIdIndex = addColumnDetails("stationId", "stationId", objectSchemaInfo);
            this.updateAtIndex = addColumnDetails("updateAt", "updateAt", objectSchemaInfo);
            this.orderIndex = addColumnDetails("order", "order", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiSpotColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiSpotColumnInfo rFGApiSpotColumnInfo = (RFGApiSpotColumnInfo) columnInfo;
            RFGApiSpotColumnInfo rFGApiSpotColumnInfo2 = (RFGApiSpotColumnInfo) columnInfo2;
            rFGApiSpotColumnInfo2.idIndex = rFGApiSpotColumnInfo.idIndex;
            rFGApiSpotColumnInfo2.dateIndex = rFGApiSpotColumnInfo.dateIndex;
            rFGApiSpotColumnInfo2.titleIndex = rFGApiSpotColumnInfo.titleIndex;
            rFGApiSpotColumnInfo2.stationIdIndex = rFGApiSpotColumnInfo.stationIdIndex;
            rFGApiSpotColumnInfo2.updateAtIndex = rFGApiSpotColumnInfo.updateAtIndex;
            rFGApiSpotColumnInfo2.orderIndex = rFGApiSpotColumnInfo.orderIndex;
            rFGApiSpotColumnInfo2.maxColumnIndexValue = rFGApiSpotColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiSpot copy(Realm realm, RFGApiSpotColumnInfo rFGApiSpotColumnInfo, RFGApiSpot rFGApiSpot, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGApiSpot);
        if (realmObjectProxy != null) {
            return (RFGApiSpot) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiSpot.class), rFGApiSpotColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.idIndex, Integer.valueOf(rFGApiSpot.realmGet$id()));
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.dateIndex, Integer.valueOf(rFGApiSpot.realmGet$date()));
        osObjectBuilder.addString(rFGApiSpotColumnInfo.titleIndex, rFGApiSpot.realmGet$title());
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.stationIdIndex, Integer.valueOf(rFGApiSpot.realmGet$stationId()));
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.updateAtIndex, Integer.valueOf(rFGApiSpot.realmGet$updateAt()));
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.orderIndex, Integer.valueOf(rFGApiSpot.realmGet$order()));
        jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGApiSpot, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiSpot copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.RFGApiSpotColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiSpot r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiSpot r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiSpot) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0087
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiSpot> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiSpot.class
            io.realm.internal.Table r2 = r8.getTable(r2)
            long r3 = r9.idIndex
            int r5 = r10.realmGet$id()
            long r5 = (long) r5
            long r3 = r2.findFirstLong(r3, r5)
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0067
            r0 = 0
            goto L_0x0088
        L_0x0067:
            io.realm.internal.UncheckedRow r3 = r2.getUncheckedRow(r3)     // Catch:{ all -> 0x0082 }
            r5 = 0
            java.util.List r6 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0082 }
            r1 = r0
            r2 = r8
            r4 = r9
            r1.set(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0082 }
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy     // Catch:{ all -> 0x0082 }
            r1.<init>()     // Catch:{ all -> 0x0082 }
            r12.put(r10, r1)     // Catch:{ all -> 0x0082 }
            r0.clear()
            goto L_0x0087
        L_0x0082:
            r8 = move-exception
            r0.clear()
            throw r8
        L_0x0087:
            r0 = r11
        L_0x0088:
            r3 = r1
            if (r0 == 0) goto L_0x0095
            r1 = r8
            r2 = r9
            r4 = r10
            r5 = r12
            r6 = r13
            jp.reifrontier.gym.domain.api.train.RFGApiSpot r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0099
        L_0x0095:
            jp.reifrontier.gym.domain.api.train.RFGApiSpot r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0099:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy$RFGApiSpotColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiSpot, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiSpot");
    }

    public static RFGApiSpotColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiSpotColumnInfo(osSchemaInfo);
    }

    public static RFGApiSpot createDetachedCopy(RFGApiSpot rFGApiSpot, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiSpot rFGApiSpot2;
        if (i > i2 || rFGApiSpot == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiSpot);
        if (cacheData == null) {
            rFGApiSpot2 = new RFGApiSpot();
            map.put(rFGApiSpot, new RealmObjectProxy.CacheData(i, rFGApiSpot2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiSpot) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiSpot2 = (RFGApiSpot) cacheData.object;
        }
        rFGApiSpot2.realmSet$id(rFGApiSpot.realmGet$id());
        rFGApiSpot2.realmSet$date(rFGApiSpot.realmGet$date());
        rFGApiSpot2.realmSet$title(rFGApiSpot.realmGet$title());
        rFGApiSpot2.realmSet$stationId(rFGApiSpot.realmGet$stationId());
        rFGApiSpot2.realmSet$updateAt(rFGApiSpot.realmGet$updateAt());
        rFGApiSpot2.realmSet$order(rFGApiSpot.realmGet$order());
        return rFGApiSpot2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 6, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("id", RealmFieldType.INTEGER, true, true, true);
        builder2.addPersistedProperty("date", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("title", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("stationId", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("updateAt", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("order", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiSpot createOrUpdateUsingJsonObject(p041io.realm.Realm r13, org.json.JSONObject r14, boolean r15) throws org.json.JSONException {
        /*
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiSpot> r0 = p043jp.reifrontier.gym.domain.api.train.RFGApiSpot.class
            java.util.List r1 = java.util.Collections.emptyList()
            r2 = 0
            java.lang.String r3 = "id"
            if (r15 == 0) goto L_0x005d
            io.realm.internal.Table r15 = r13.getTable(r0)
            io.realm.RealmSchema r4 = r13.getSchema()
            io.realm.internal.ColumnInfo r4 = r4.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy$RFGApiSpotColumnInfo r4 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.RFGApiSpotColumnInfo) r4
            long r4 = r4.idIndex
            boolean r6 = r14.isNull(r3)
            r7 = -1
            if (r6 != 0) goto L_0x002c
            long r9 = r14.getLong(r3)
            long r4 = r15.findFirstLong(r4, r9)
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy r15 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy     // Catch:{ all -> 0x0058 }
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
            if (r15 != 0) goto L_0x008a
            boolean r15 = r14.has(r3)
            if (r15 == 0) goto L_0x0082
            boolean r15 = r14.isNull(r3)
            r4 = 1
            if (r15 == 0) goto L_0x0072
            io.realm.RealmModel r13 = r13.createObjectInternal(r0, r2, r4, r1)
            goto L_0x007e
        L_0x0072:
            int r15 = r14.getInt(r3)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            io.realm.RealmModel r13 = r13.createObjectInternal(r0, r15, r4, r1)
        L_0x007e:
            r15 = r13
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy r15 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy) r15
            goto L_0x008a
        L_0x0082:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "JSON object doesn't have the primary key field 'id'."
            r13.<init>(r14)
            throw r13
        L_0x008a:
            java.lang.String r13 = "date"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00a8
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00a0
            int r13 = r14.getInt(r13)
            r15.realmSet$date(r13)
            goto L_0x00a8
        L_0x00a0:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'date' to null."
            r13.<init>(r14)
            throw r13
        L_0x00a8:
            java.lang.String r13 = "title"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00c1
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x00ba
            r15.realmSet$title(r2)
            goto L_0x00c1
        L_0x00ba:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$title(r13)
        L_0x00c1:
            java.lang.String r13 = "stationId"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00df
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00d7
            int r13 = r14.getInt(r13)
            r15.realmSet$stationId(r13)
            goto L_0x00df
        L_0x00d7:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'stationId' to null."
            r13.<init>(r14)
            throw r13
        L_0x00df:
            java.lang.String r13 = "updateAt"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00fd
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00f5
            int r13 = r14.getInt(r13)
            r15.realmSet$updateAt(r13)
            goto L_0x00fd
        L_0x00f5:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'updateAt' to null."
            r13.<init>(r14)
            throw r13
        L_0x00fd:
            java.lang.String r13 = "order"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x011b
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x0113
            int r13 = r14.getInt(r13)
            r15.realmSet$order(r13)
            goto L_0x011b
        L_0x0113:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'order' to null."
            r13.<init>(r14)
            throw r13
        L_0x011b:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiSpot");
    }

    @TargetApi(11)
    public static RFGApiSpot createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        String str;
        RFGApiSpot rFGApiSpot = new RFGApiSpot();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("id")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiSpot.realmSet$id(jsonReader.nextInt());
                    z = true;
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'id' to null.");
                }
            } else if (nextName.equals("date")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiSpot.realmSet$date(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'date' to null.");
                }
            } else if (nextName.equals("title")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    str = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                    str = null;
                }
                rFGApiSpot.realmSet$title(str);
            } else if (nextName.equals("stationId")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiSpot.realmSet$stationId(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'stationId' to null.");
                }
            } else if (nextName.equals("updateAt")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiSpot.realmSet$updateAt(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'updateAt' to null.");
                }
            } else if (!nextName.equals("order")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiSpot.realmSet$order(jsonReader.nextInt());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'order' to null.");
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiSpot) realm.copyToRealm(rFGApiSpot, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiSpot rFGApiSpot, Map<RealmModel, Long> map) {
        long j;
        RFGApiSpot rFGApiSpot2 = rFGApiSpot;
        Class<RFGApiSpot> cls = RFGApiSpot.class;
        if (rFGApiSpot2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiSpot2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiSpotColumnInfo rFGApiSpotColumnInfo = (RFGApiSpotColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiSpotColumnInfo.idIndex;
        Integer valueOf = Integer.valueOf(rFGApiSpot.realmGet$id());
        if (valueOf != null) {
            j = Table.nativeFindFirstInt(nativePtr, j2, (long) rFGApiSpot.realmGet$id());
        } else {
            j = -1;
        }
        if (j == -1) {
            j = OsObject.createRowWithPrimaryKey(table, j2, Integer.valueOf(rFGApiSpot.realmGet$id()));
        } else {
            Table.throwDuplicatePrimaryKeyException(valueOf);
        }
        long j3 = j;
        map.put(rFGApiSpot2, Long.valueOf(j3));
        Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.dateIndex, j3, (long) rFGApiSpot.realmGet$date(), false);
        String realmGet$title = rFGApiSpot.realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(nativePtr, rFGApiSpotColumnInfo.titleIndex, j3, realmGet$title, false);
        }
        long j4 = j3;
        Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.stationIdIndex, j4, (long) rFGApiSpot.realmGet$stationId(), false);
        long j5 = nativePtr;
        Table.nativeSetLong(j5, rFGApiSpotColumnInfo.updateAtIndex, j4, (long) rFGApiSpot.realmGet$updateAt(), false);
        Table.nativeSetLong(j5, rFGApiSpotColumnInfo.orderIndex, j4, (long) rFGApiSpot.realmGet$order(), false);
        return j3;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiSpot> cls = RFGApiSpot.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiSpotColumnInfo rFGApiSpotColumnInfo = (RFGApiSpotColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiSpotColumnInfo.idIndex;
        while (it.hasNext()) {
            RFGApiSpot rFGApiSpot = (RFGApiSpot) it.next();
            if (!map2.containsKey(rFGApiSpot)) {
                if (rFGApiSpot instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiSpot;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiSpot, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                Integer valueOf = Integer.valueOf(rFGApiSpot.realmGet$id());
                if (valueOf != null) {
                    j = Table.nativeFindFirstInt(nativePtr, j2, (long) rFGApiSpot.realmGet$id());
                } else {
                    j = -1;
                }
                if (j == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j2, Integer.valueOf(rFGApiSpot.realmGet$id()));
                } else {
                    Table.throwDuplicatePrimaryKeyException(valueOf);
                }
                long j3 = j;
                map2.put(rFGApiSpot, Long.valueOf(j3));
                long j4 = j2;
                Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.dateIndex, j3, (long) rFGApiSpot.realmGet$date(), false);
                String realmGet$title = rFGApiSpot.realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(nativePtr, rFGApiSpotColumnInfo.titleIndex, j3, realmGet$title, false);
                }
                long j5 = j3;
                Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.stationIdIndex, j5, (long) rFGApiSpot.realmGet$stationId(), false);
                Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.updateAtIndex, j5, (long) rFGApiSpot.realmGet$updateAt(), false);
                Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.orderIndex, j5, (long) rFGApiSpot.realmGet$order(), false);
                j2 = j4;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiSpot rFGApiSpot, Map<RealmModel, Long> map) {
        long j;
        RFGApiSpot rFGApiSpot2 = rFGApiSpot;
        Class<RFGApiSpot> cls = RFGApiSpot.class;
        if (rFGApiSpot2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiSpot2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiSpotColumnInfo rFGApiSpotColumnInfo = (RFGApiSpotColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiSpotColumnInfo.idIndex;
        if (Integer.valueOf(rFGApiSpot.realmGet$id()) != null) {
            j = Table.nativeFindFirstInt(nativePtr, j2, (long) rFGApiSpot.realmGet$id());
        } else {
            j = -1;
        }
        if (j == -1) {
            j = OsObject.createRowWithPrimaryKey(table, j2, Integer.valueOf(rFGApiSpot.realmGet$id()));
        }
        long j3 = j;
        map.put(rFGApiSpot2, Long.valueOf(j3));
        Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.dateIndex, j3, (long) rFGApiSpot.realmGet$date(), false);
        String realmGet$title = rFGApiSpot.realmGet$title();
        long j4 = rFGApiSpotColumnInfo.titleIndex;
        if (realmGet$title != null) {
            Table.nativeSetString(nativePtr, j4, j3, realmGet$title, false);
        } else {
            Table.nativeSetNull(nativePtr, j4, j3, false);
        }
        long j5 = j3;
        Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.stationIdIndex, j5, (long) rFGApiSpot.realmGet$stationId(), false);
        long j6 = nativePtr;
        Table.nativeSetLong(j6, rFGApiSpotColumnInfo.updateAtIndex, j5, (long) rFGApiSpot.realmGet$updateAt(), false);
        Table.nativeSetLong(j6, rFGApiSpotColumnInfo.orderIndex, j5, (long) rFGApiSpot.realmGet$order(), false);
        return j3;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiSpot> cls = RFGApiSpot.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiSpotColumnInfo rFGApiSpotColumnInfo = (RFGApiSpotColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiSpotColumnInfo.idIndex;
        while (it.hasNext()) {
            RFGApiSpot rFGApiSpot = (RFGApiSpot) it.next();
            if (!map2.containsKey(rFGApiSpot)) {
                if (rFGApiSpot instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiSpot;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiSpot, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                if (Integer.valueOf(rFGApiSpot.realmGet$id()) != null) {
                    j = Table.nativeFindFirstInt(nativePtr, j2, (long) rFGApiSpot.realmGet$id());
                } else {
                    j = -1;
                }
                if (j == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j2, Integer.valueOf(rFGApiSpot.realmGet$id()));
                }
                long j3 = j;
                map2.put(rFGApiSpot, Long.valueOf(j3));
                long j4 = j2;
                Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.dateIndex, j3, (long) rFGApiSpot.realmGet$date(), false);
                String realmGet$title = rFGApiSpot.realmGet$title();
                long j5 = rFGApiSpotColumnInfo.titleIndex;
                if (realmGet$title != null) {
                    Table.nativeSetString(nativePtr, j5, j3, realmGet$title, false);
                } else {
                    Table.nativeSetNull(nativePtr, j5, j3, false);
                }
                long j6 = j3;
                Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.stationIdIndex, j6, (long) rFGApiSpot.realmGet$stationId(), false);
                Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.updateAtIndex, j6, (long) rFGApiSpot.realmGet$updateAt(), false);
                Table.nativeSetLong(nativePtr, rFGApiSpotColumnInfo.orderIndex, j6, (long) rFGApiSpot.realmGet$order(), false);
                j2 = j4;
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiSpot.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy jp_reifrontier_gym_domain_api_train_rfgapispotrealmproxy = new jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapispotrealmproxy;
    }

    static RFGApiSpot update(Realm realm, RFGApiSpotColumnInfo rFGApiSpotColumnInfo, RFGApiSpot rFGApiSpot, RFGApiSpot rFGApiSpot2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiSpot.class), rFGApiSpotColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.idIndex, Integer.valueOf(rFGApiSpot2.realmGet$id()));
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.dateIndex, Integer.valueOf(rFGApiSpot2.realmGet$date()));
        osObjectBuilder.addString(rFGApiSpotColumnInfo.titleIndex, rFGApiSpot2.realmGet$title());
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.stationIdIndex, Integer.valueOf(rFGApiSpot2.realmGet$stationId()));
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.updateAtIndex, Integer.valueOf(rFGApiSpot2.realmGet$updateAt()));
        osObjectBuilder.addInteger(rFGApiSpotColumnInfo.orderIndex, Integer.valueOf(rFGApiSpot2.realmGet$order()));
        osObjectBuilder.updateExistingObject();
        return rFGApiSpot;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy jp_reifrontier_gym_domain_api_train_rfgapispotrealmproxy = (jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapispotrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapispotrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapispotrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiSpotColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiSpot> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public int realmGet$date() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.dateIndex);
    }

    public int realmGet$id() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.idIndex);
    }

    public int realmGet$order() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.orderIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int realmGet$stationId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.stationIdIndex);
    }

    public String realmGet$title() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.titleIndex);
    }

    public int realmGet$updateAt() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.updateAtIndex);
    }

    public void realmSet$date(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.dateIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.dateIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$id(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    public void realmSet$order(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.orderIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.orderIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$stationId(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.stationIdIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.stationIdIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$title(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.titleIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.titleIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
        }
    }

    public void realmSet$updateAt(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.updateAtIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.updateAtIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGApiSpot = proxy[", "{id:");
        b.append(realmGet$id());
        b.append("}");
        b.append(",");
        b.append("{date:");
        b.append(realmGet$date());
        b.append("}");
        b.append(",");
        b.append("{title:");
        b.append(realmGet$title());
        b.append("}");
        b.append(",");
        b.append("{stationId:");
        b.append(realmGet$stationId());
        b.append("}");
        b.append(",");
        b.append("{updateAt:");
        b.append(realmGet$updateAt());
        b.append("}");
        b.append(",");
        b.append("{order:");
        b.append(realmGet$order());
        return C0681a.m324a(b, "}", "]");
    }
}
