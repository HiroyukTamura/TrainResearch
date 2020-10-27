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
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy */
public class C2009x9093b7d7 extends RFGApiContentAccess implements RealmObjectProxy, C1002xa3bfb722 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiContentAccessColumnInfo columnInfo;
    private ProxyState<RFGApiContentAccess> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiContentAccess";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy$RFGApiContentAccessColumnInfo */
    static final class RFGApiContentAccessColumnInfo extends ColumnInfo {
        long accessIndex;
        long addressIndex;
        long latIndex;
        long lonIndex;
        long maxColumnIndexValue;
        long pKeyIndex;

        RFGApiContentAccessColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiContentAccessColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.pKeyIndex = addColumnDetails("pKey", "pKey", objectSchemaInfo);
            this.addressIndex = addColumnDetails("address", "address", objectSchemaInfo);
            this.accessIndex = addColumnDetails("access", "access", objectSchemaInfo);
            this.latIndex = addColumnDetails("lat", "lat", objectSchemaInfo);
            this.lonIndex = addColumnDetails("lon", "lon", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiContentAccessColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiContentAccessColumnInfo rFGApiContentAccessColumnInfo = (RFGApiContentAccessColumnInfo) columnInfo;
            RFGApiContentAccessColumnInfo rFGApiContentAccessColumnInfo2 = (RFGApiContentAccessColumnInfo) columnInfo2;
            rFGApiContentAccessColumnInfo2.pKeyIndex = rFGApiContentAccessColumnInfo.pKeyIndex;
            rFGApiContentAccessColumnInfo2.addressIndex = rFGApiContentAccessColumnInfo.addressIndex;
            rFGApiContentAccessColumnInfo2.accessIndex = rFGApiContentAccessColumnInfo.accessIndex;
            rFGApiContentAccessColumnInfo2.latIndex = rFGApiContentAccessColumnInfo.latIndex;
            rFGApiContentAccessColumnInfo2.lonIndex = rFGApiContentAccessColumnInfo.lonIndex;
            rFGApiContentAccessColumnInfo2.maxColumnIndexValue = rFGApiContentAccessColumnInfo.maxColumnIndexValue;
        }
    }

    C2009x9093b7d7() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiContentAccess copy(Realm realm, RFGApiContentAccessColumnInfo rFGApiContentAccessColumnInfo, RFGApiContentAccess rFGApiContentAccess, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGApiContentAccess);
        if (realmObjectProxy != null) {
            return (RFGApiContentAccess) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentAccess.class), rFGApiContentAccessColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentAccessColumnInfo.pKeyIndex, rFGApiContentAccess.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentAccessColumnInfo.addressIndex, rFGApiContentAccess.realmGet$address());
        osObjectBuilder.addString(rFGApiContentAccessColumnInfo.accessIndex, rFGApiContentAccess.realmGet$access());
        osObjectBuilder.addDouble(rFGApiContentAccessColumnInfo.latIndex, Double.valueOf(rFGApiContentAccess.realmGet$lat()));
        osObjectBuilder.addDouble(rFGApiContentAccessColumnInfo.lonIndex, Double.valueOf(rFGApiContentAccess.realmGet$lon()));
        C2009x9093b7d7 newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGApiContentAccess, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess copyOrUpdate(p041io.realm.Realm r8, p041io.realm.C2009x9093b7d7.RFGApiContentAccessColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentAccess r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentAccess> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess.class
            io.realm.internal.Table r2 = r8.getTable(r2)
            long r3 = r9.pKeyIndex
            java.lang.String r5 = r10.realmGet$pKey()
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentAccess r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.api.train.RFGApiContentAccess r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.C2009x9093b7d7.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy$RFGApiContentAccessColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiContentAccess, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiContentAccess");
    }

    public static RFGApiContentAccessColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiContentAccessColumnInfo(osSchemaInfo);
    }

    public static RFGApiContentAccess createDetachedCopy(RFGApiContentAccess rFGApiContentAccess, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiContentAccess rFGApiContentAccess2;
        if (i > i2 || rFGApiContentAccess == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiContentAccess);
        if (cacheData == null) {
            rFGApiContentAccess2 = new RFGApiContentAccess();
            map.put(rFGApiContentAccess, new RealmObjectProxy.CacheData(i, rFGApiContentAccess2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiContentAccess) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiContentAccess2 = (RFGApiContentAccess) cacheData.object;
        }
        rFGApiContentAccess2.realmSet$pKey(rFGApiContentAccess.realmGet$pKey());
        rFGApiContentAccess2.realmSet$address(rFGApiContentAccess.realmGet$address());
        rFGApiContentAccess2.realmSet$access(rFGApiContentAccess.realmGet$access());
        rFGApiContentAccess2.realmSet$lat(rFGApiContentAccess.realmGet$lat());
        rFGApiContentAccess2.realmSet$lon(rFGApiContentAccess.realmGet$lon());
        return rFGApiContentAccess2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 5, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("pKey", RealmFieldType.STRING, true, true, true);
        builder2.addPersistedProperty("address", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("access", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("lat", RealmFieldType.DOUBLE, false, false, true);
        builder2.addPersistedProperty("lon", RealmFieldType.DOUBLE, false, false, true);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess createOrUpdateUsingJsonObject(p041io.realm.Realm r13, org.json.JSONObject r14, boolean r15) throws org.json.JSONException {
        /*
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentAccess> r0 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess.class
            java.util.List r1 = java.util.Collections.emptyList()
            r2 = 0
            java.lang.String r3 = "pKey"
            if (r15 == 0) goto L_0x005d
            io.realm.internal.Table r15 = r13.getTable(r0)
            io.realm.RealmSchema r4 = r13.getSchema()
            io.realm.internal.ColumnInfo r4 = r4.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy$RFGApiContentAccessColumnInfo r4 = (p041io.realm.C2009x9093b7d7.RFGApiContentAccessColumnInfo) r4
            long r4 = r4.pKeyIndex
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy r15 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy     // Catch:{ all -> 0x0058 }
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentAccessRealmProxy r15 = (p041io.realm.C2009x9093b7d7) r15
            goto L_0x0086
        L_0x007e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "JSON object doesn't have the primary key field 'pKey'."
            r13.<init>(r14)
            throw r13
        L_0x0086:
            java.lang.String r13 = "address"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x009f
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x0098
            r15.realmSet$address(r2)
            goto L_0x009f
        L_0x0098:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$address(r13)
        L_0x009f:
            java.lang.String r13 = "access"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00b8
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x00b1
            r15.realmSet$access(r2)
            goto L_0x00b8
        L_0x00b1:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$access(r13)
        L_0x00b8:
            java.lang.String r13 = "lat"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00d6
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00ce
            double r0 = r14.getDouble(r13)
            r15.realmSet$lat(r0)
            goto L_0x00d6
        L_0x00ce:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'lat' to null."
            r13.<init>(r14)
            throw r13
        L_0x00d6:
            java.lang.String r13 = "lon"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00ec
            double r13 = r14.getDouble(r13)
            r15.realmSet$lon(r13)
            goto L_0x00f4
        L_0x00ec:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'lon' to null."
            r13.<init>(r14)
            throw r13
        L_0x00f4:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.C2009x9093b7d7.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiContentAccess");
    }

    @TargetApi(11)
    public static RFGApiContentAccess createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGApiContentAccess rFGApiContentAccess = new RFGApiContentAccess();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("pKey")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentAccess.realmSet$pKey(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentAccess.realmSet$pKey((String) null);
                }
                z = true;
            } else if (nextName.equals("address")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentAccess.realmSet$address(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentAccess.realmSet$address((String) null);
                }
            } else if (nextName.equals("access")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentAccess.realmSet$access(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentAccess.realmSet$access((String) null);
                }
            } else if (nextName.equals("lat")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentAccess.realmSet$lat(jsonReader.nextDouble());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'lat' to null.");
                }
            } else if (!nextName.equals("lon")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiContentAccess.realmSet$lon(jsonReader.nextDouble());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'lon' to null.");
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiContentAccess) realm.copyToRealm(rFGApiContentAccess, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pKey'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiContentAccess rFGApiContentAccess, Map<RealmModel, Long> map) {
        Class<RFGApiContentAccess> cls = RFGApiContentAccess.class;
        if (rFGApiContentAccess instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentAccess;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentAccessColumnInfo rFGApiContentAccessColumnInfo = (RFGApiContentAccessColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentAccessColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentAccess.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentAccess, Long.valueOf(j2));
        String realmGet$address = rFGApiContentAccess.realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, rFGApiContentAccessColumnInfo.addressIndex, j2, realmGet$address, false);
        }
        String realmGet$access = rFGApiContentAccess.realmGet$access();
        if (realmGet$access != null) {
            Table.nativeSetString(nativePtr, rFGApiContentAccessColumnInfo.accessIndex, j2, realmGet$access, false);
        }
        long j3 = nativePtr;
        long j4 = j2;
        Table.nativeSetDouble(j3, rFGApiContentAccessColumnInfo.latIndex, j4, rFGApiContentAccess.realmGet$lat(), false);
        Table.nativeSetDouble(j3, rFGApiContentAccessColumnInfo.lonIndex, j4, rFGApiContentAccess.realmGet$lon(), false);
        return j2;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentAccess> cls = RFGApiContentAccess.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentAccessColumnInfo rFGApiContentAccessColumnInfo = (RFGApiContentAccessColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentAccessColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentAccess rFGApiContentAccess = (RFGApiContentAccess) it.next();
            if (!map2.containsKey(rFGApiContentAccess)) {
                if (rFGApiContentAccess instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentAccess;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentAccess, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentAccess.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j3, realmGet$pKey) : -1;
                if (nativeFindFirstString == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j3, realmGet$pKey);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
                    j = nativeFindFirstString;
                }
                map2.put(rFGApiContentAccess, Long.valueOf(j));
                String realmGet$address = rFGApiContentAccess.realmGet$address();
                if (realmGet$address != null) {
                    j2 = j3;
                    Table.nativeSetString(nativePtr, rFGApiContentAccessColumnInfo.addressIndex, j, realmGet$address, false);
                } else {
                    j2 = j3;
                }
                String realmGet$access = rFGApiContentAccess.realmGet$access();
                if (realmGet$access != null) {
                    Table.nativeSetString(nativePtr, rFGApiContentAccessColumnInfo.accessIndex, j, realmGet$access, false);
                }
                long j4 = nativePtr;
                long j5 = j;
                Table.nativeSetDouble(j4, rFGApiContentAccessColumnInfo.latIndex, j5, rFGApiContentAccess.realmGet$lat(), false);
                Table.nativeSetDouble(j4, rFGApiContentAccessColumnInfo.lonIndex, j5, rFGApiContentAccess.realmGet$lon(), false);
                j3 = j2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiContentAccess rFGApiContentAccess, Map<RealmModel, Long> map) {
        Class<RFGApiContentAccess> cls = RFGApiContentAccess.class;
        if (rFGApiContentAccess instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentAccess;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentAccessColumnInfo rFGApiContentAccessColumnInfo = (RFGApiContentAccessColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentAccessColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentAccess.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentAccess, Long.valueOf(j2));
        String realmGet$address = rFGApiContentAccess.realmGet$address();
        long j3 = rFGApiContentAccessColumnInfo.addressIndex;
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, j3, j2, realmGet$address, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, j2, false);
        }
        String realmGet$access = rFGApiContentAccess.realmGet$access();
        long j4 = rFGApiContentAccessColumnInfo.accessIndex;
        if (realmGet$access != null) {
            Table.nativeSetString(nativePtr, j4, j2, realmGet$access, false);
        } else {
            Table.nativeSetNull(nativePtr, j4, j2, false);
        }
        long j5 = nativePtr;
        long j6 = j2;
        Table.nativeSetDouble(j5, rFGApiContentAccessColumnInfo.latIndex, j6, rFGApiContentAccess.realmGet$lat(), false);
        Table.nativeSetDouble(j5, rFGApiContentAccessColumnInfo.lonIndex, j6, rFGApiContentAccess.realmGet$lon(), false);
        return j2;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentAccess> cls = RFGApiContentAccess.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentAccessColumnInfo rFGApiContentAccessColumnInfo = (RFGApiContentAccessColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiContentAccessColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentAccess rFGApiContentAccess = (RFGApiContentAccess) it.next();
            if (!map2.containsKey(rFGApiContentAccess)) {
                if (rFGApiContentAccess instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentAccess;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentAccess, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentAccess.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j2, realmGet$pKey) : -1;
                long createRowWithPrimaryKey = nativeFindFirstString == -1 ? OsObject.createRowWithPrimaryKey(table, j2, realmGet$pKey) : nativeFindFirstString;
                map2.put(rFGApiContentAccess, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$address = rFGApiContentAccess.realmGet$address();
                if (realmGet$address != null) {
                    j = j2;
                    Table.nativeSetString(nativePtr, rFGApiContentAccessColumnInfo.addressIndex, createRowWithPrimaryKey, realmGet$address, false);
                } else {
                    j = j2;
                    Table.nativeSetNull(nativePtr, rFGApiContentAccessColumnInfo.addressIndex, createRowWithPrimaryKey, false);
                }
                String realmGet$access = rFGApiContentAccess.realmGet$access();
                long j3 = rFGApiContentAccessColumnInfo.accessIndex;
                if (realmGet$access != null) {
                    Table.nativeSetString(nativePtr, j3, createRowWithPrimaryKey, realmGet$access, false);
                } else {
                    Table.nativeSetNull(nativePtr, j3, createRowWithPrimaryKey, false);
                }
                long j4 = nativePtr;
                long j5 = createRowWithPrimaryKey;
                Table.nativeSetDouble(j4, rFGApiContentAccessColumnInfo.latIndex, j5, rFGApiContentAccess.realmGet$lat(), false);
                Table.nativeSetDouble(j4, rFGApiContentAccessColumnInfo.lonIndex, j5, rFGApiContentAccess.realmGet$lon(), false);
                j2 = j;
            }
        }
    }

    private static C2009x9093b7d7 newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentAccess.class), false, Collections.emptyList());
        C2009x9093b7d7 jp_reifrontier_gym_domain_api_train_rfgapicontentaccessrealmproxy = new C2009x9093b7d7();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapicontentaccessrealmproxy;
    }

    static RFGApiContentAccess update(Realm realm, RFGApiContentAccessColumnInfo rFGApiContentAccessColumnInfo, RFGApiContentAccess rFGApiContentAccess, RFGApiContentAccess rFGApiContentAccess2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentAccess.class), rFGApiContentAccessColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentAccessColumnInfo.pKeyIndex, rFGApiContentAccess2.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentAccessColumnInfo.addressIndex, rFGApiContentAccess2.realmGet$address());
        osObjectBuilder.addString(rFGApiContentAccessColumnInfo.accessIndex, rFGApiContentAccess2.realmGet$access());
        osObjectBuilder.addDouble(rFGApiContentAccessColumnInfo.latIndex, Double.valueOf(rFGApiContentAccess2.realmGet$lat()));
        osObjectBuilder.addDouble(rFGApiContentAccessColumnInfo.lonIndex, Double.valueOf(rFGApiContentAccess2.realmGet$lon()));
        osObjectBuilder.updateExistingObject();
        return rFGApiContentAccess;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2009x9093b7d7.class != obj.getClass()) {
            return false;
        }
        C2009x9093b7d7 jp_reifrontier_gym_domain_api_train_rfgapicontentaccessrealmproxy = (C2009x9093b7d7) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapicontentaccessrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapicontentaccessrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapicontentaccessrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiContentAccessColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiContentAccess> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$access() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.accessIndex);
    }

    public String realmGet$address() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.addressIndex);
    }

    public double realmGet$lat() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getDouble(this.columnInfo.latIndex);
    }

    public double realmGet$lon() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getDouble(this.columnInfo.lonIndex);
    }

    public String realmGet$pKey() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pKeyIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public void realmSet$access(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.accessIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.accessIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.accessIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.accessIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$address(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.addressIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.addressIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.addressIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.addressIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$lat(double d) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setDouble(this.columnInfo.latIndex, d);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setDouble(this.columnInfo.latIndex, row$realm.getIndex(), d, true);
        }
    }

    public void realmSet$lon(double d) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setDouble(this.columnInfo.lonIndex, d);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setDouble(this.columnInfo.lonIndex, row$realm.getIndex(), d, true);
        }
    }

    public void realmSet$pKey(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'pKey' cannot be changed after object was created.");
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGApiContentAccess = proxy[", "{pKey:");
        b.append(realmGet$pKey());
        b.append("}");
        b.append(",");
        b.append("{address:");
        String str = "null";
        C0681a.m335a(b, realmGet$address() != null ? realmGet$address() : str, "}", ",", "{access:");
        if (realmGet$access() != null) {
            str = realmGet$access();
        }
        C0681a.m335a(b, str, "}", ",", "{lat:");
        b.append(realmGet$lat());
        b.append("}");
        b.append(",");
        b.append("{lon:");
        b.append(realmGet$lon());
        return C0681a.m324a(b, "}", "]");
    }
}
