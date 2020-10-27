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
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy */
public class jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy extends RFGApiContentInfo implements RealmObjectProxy, C1005x73df4298 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiContentInfoColumnInfo columnInfo;
    private ProxyState<RFGApiContentInfo> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiContentInfo";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy$RFGApiContentInfoColumnInfo */
    static final class RFGApiContentInfoColumnInfo extends ColumnInfo {
        long contentsIndex;
        long maxColumnIndexValue;
        long pKeyIndex;
        long titleIndex;

        RFGApiContentInfoColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiContentInfoColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.pKeyIndex = addColumnDetails("pKey", "pKey", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.contentsIndex = addColumnDetails("contents", "contents", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiContentInfoColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiContentInfoColumnInfo rFGApiContentInfoColumnInfo = (RFGApiContentInfoColumnInfo) columnInfo;
            RFGApiContentInfoColumnInfo rFGApiContentInfoColumnInfo2 = (RFGApiContentInfoColumnInfo) columnInfo2;
            rFGApiContentInfoColumnInfo2.pKeyIndex = rFGApiContentInfoColumnInfo.pKeyIndex;
            rFGApiContentInfoColumnInfo2.titleIndex = rFGApiContentInfoColumnInfo.titleIndex;
            rFGApiContentInfoColumnInfo2.contentsIndex = rFGApiContentInfoColumnInfo.contentsIndex;
            rFGApiContentInfoColumnInfo2.maxColumnIndexValue = rFGApiContentInfoColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiContentInfo copy(Realm realm, RFGApiContentInfoColumnInfo rFGApiContentInfoColumnInfo, RFGApiContentInfo rFGApiContentInfo, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGApiContentInfo);
        if (realmObjectProxy != null) {
            return (RFGApiContentInfo) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentInfo.class), rFGApiContentInfoColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentInfoColumnInfo.pKeyIndex, rFGApiContentInfo.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentInfoColumnInfo.titleIndex, rFGApiContentInfo.realmGet$title());
        osObjectBuilder.addString(rFGApiContentInfoColumnInfo.contentsIndex, rFGApiContentInfo.realmGet$contents());
        jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGApiContentInfo, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.RFGApiContentInfoColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentInfo r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentInfo> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo.class
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentInfo r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.api.train.RFGApiContentInfo r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy$RFGApiContentInfoColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiContentInfo, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiContentInfo");
    }

    public static RFGApiContentInfoColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiContentInfoColumnInfo(osSchemaInfo);
    }

    public static RFGApiContentInfo createDetachedCopy(RFGApiContentInfo rFGApiContentInfo, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiContentInfo rFGApiContentInfo2;
        if (i > i2 || rFGApiContentInfo == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiContentInfo);
        if (cacheData == null) {
            rFGApiContentInfo2 = new RFGApiContentInfo();
            map.put(rFGApiContentInfo, new RealmObjectProxy.CacheData(i, rFGApiContentInfo2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiContentInfo) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiContentInfo2 = (RFGApiContentInfo) cacheData.object;
        }
        rFGApiContentInfo2.realmSet$pKey(rFGApiContentInfo.realmGet$pKey());
        rFGApiContentInfo2.realmSet$title(rFGApiContentInfo.realmGet$title());
        rFGApiContentInfo2.realmSet$contents(rFGApiContentInfo.realmGet$contents());
        return rFGApiContentInfo2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 3, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("pKey", RealmFieldType.STRING, true, true, true);
        builder2.addPersistedProperty("title", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("contents", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo createOrUpdateUsingJsonObject(p041io.realm.Realm r13, org.json.JSONObject r14, boolean r15) throws org.json.JSONException {
        /*
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentInfo> r0 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo.class
            java.util.List r1 = java.util.Collections.emptyList()
            r2 = 0
            java.lang.String r3 = "pKey"
            if (r15 == 0) goto L_0x005d
            io.realm.internal.Table r15 = r13.getTable(r0)
            io.realm.RealmSchema r4 = r13.getSchema()
            io.realm.internal.ColumnInfo r4 = r4.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy$RFGApiContentInfoColumnInfo r4 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.RFGApiContentInfoColumnInfo) r4
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy r15 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy     // Catch:{ all -> 0x0058 }
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy r15 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy) r15
            goto L_0x0086
        L_0x007e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "JSON object doesn't have the primary key field 'pKey'."
            r13.<init>(r14)
            throw r13
        L_0x0086:
            java.lang.String r13 = "title"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x009f
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x0098
            r15.realmSet$title(r2)
            goto L_0x009f
        L_0x0098:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$title(r13)
        L_0x009f:
            java.lang.String r13 = "contents"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00b8
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x00b1
            r15.realmSet$contents(r2)
            goto L_0x00b8
        L_0x00b1:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$contents(r13)
        L_0x00b8:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiContentInfo");
    }

    @TargetApi(11)
    public static RFGApiContentInfo createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGApiContentInfo rFGApiContentInfo = new RFGApiContentInfo();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("pKey")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentInfo.realmSet$pKey(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentInfo.realmSet$pKey((String) null);
                }
                z = true;
            } else if (nextName.equals("title")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentInfo.realmSet$title(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentInfo.realmSet$title((String) null);
                }
            } else if (!nextName.equals("contents")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiContentInfo.realmSet$contents(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                rFGApiContentInfo.realmSet$contents((String) null);
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiContentInfo) realm.copyToRealm(rFGApiContentInfo, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pKey'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiContentInfo rFGApiContentInfo, Map<RealmModel, Long> map) {
        Class<RFGApiContentInfo> cls = RFGApiContentInfo.class;
        if (rFGApiContentInfo instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentInfo;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentInfoColumnInfo rFGApiContentInfoColumnInfo = (RFGApiContentInfoColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentInfoColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentInfo.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentInfo, Long.valueOf(j2));
        String realmGet$title = rFGApiContentInfo.realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(nativePtr, rFGApiContentInfoColumnInfo.titleIndex, j2, realmGet$title, false);
        }
        String realmGet$contents = rFGApiContentInfo.realmGet$contents();
        if (realmGet$contents != null) {
            Table.nativeSetString(nativePtr, rFGApiContentInfoColumnInfo.contentsIndex, j2, realmGet$contents, false);
        }
        return j2;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        RFGApiContentInfo rFGApiContentInfo;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentInfo> cls = RFGApiContentInfo.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentInfoColumnInfo rFGApiContentInfoColumnInfo = (RFGApiContentInfoColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiContentInfoColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentInfo rFGApiContentInfo2 = (RFGApiContentInfo) it.next();
            if (!map2.containsKey(rFGApiContentInfo2)) {
                if (rFGApiContentInfo2 instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentInfo2;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentInfo2, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentInfo2.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j2, realmGet$pKey) : -1;
                if (nativeFindFirstString == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j2, realmGet$pKey);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
                    j = nativeFindFirstString;
                }
                map2.put(rFGApiContentInfo2, Long.valueOf(j));
                String realmGet$title = rFGApiContentInfo2.realmGet$title();
                if (realmGet$title != null) {
                    rFGApiContentInfo = rFGApiContentInfo2;
                    Table.nativeSetString(nativePtr, rFGApiContentInfoColumnInfo.titleIndex, j, realmGet$title, false);
                } else {
                    rFGApiContentInfo = rFGApiContentInfo2;
                }
                String realmGet$contents = rFGApiContentInfo.realmGet$contents();
                if (realmGet$contents != null) {
                    Table.nativeSetString(nativePtr, rFGApiContentInfoColumnInfo.contentsIndex, j, realmGet$contents, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiContentInfo rFGApiContentInfo, Map<RealmModel, Long> map) {
        Class<RFGApiContentInfo> cls = RFGApiContentInfo.class;
        if (rFGApiContentInfo instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentInfo;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentInfoColumnInfo rFGApiContentInfoColumnInfo = (RFGApiContentInfoColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentInfoColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentInfo.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentInfo, Long.valueOf(j2));
        String realmGet$title = rFGApiContentInfo.realmGet$title();
        long j3 = rFGApiContentInfoColumnInfo.titleIndex;
        if (realmGet$title != null) {
            Table.nativeSetString(nativePtr, j3, j2, realmGet$title, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, j2, false);
        }
        String realmGet$contents = rFGApiContentInfo.realmGet$contents();
        long j4 = rFGApiContentInfoColumnInfo.contentsIndex;
        if (realmGet$contents != null) {
            Table.nativeSetString(nativePtr, j4, j2, realmGet$contents, false);
        } else {
            Table.nativeSetNull(nativePtr, j4, j2, false);
        }
        return j2;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        RFGApiContentInfo rFGApiContentInfo;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentInfo> cls = RFGApiContentInfo.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentInfoColumnInfo rFGApiContentInfoColumnInfo = (RFGApiContentInfoColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentInfoColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentInfo rFGApiContentInfo2 = (RFGApiContentInfo) it.next();
            if (!map2.containsKey(rFGApiContentInfo2)) {
                if (rFGApiContentInfo2 instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentInfo2;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentInfo2, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentInfo2.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
                long createRowWithPrimaryKey = nativeFindFirstString == -1 ? OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey) : nativeFindFirstString;
                map2.put(rFGApiContentInfo2, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$title = rFGApiContentInfo2.realmGet$title();
                if (realmGet$title != null) {
                    rFGApiContentInfo = rFGApiContentInfo2;
                    Table.nativeSetString(nativePtr, rFGApiContentInfoColumnInfo.titleIndex, createRowWithPrimaryKey, realmGet$title, false);
                } else {
                    rFGApiContentInfo = rFGApiContentInfo2;
                    Table.nativeSetNull(nativePtr, rFGApiContentInfoColumnInfo.titleIndex, createRowWithPrimaryKey, false);
                }
                String realmGet$contents = rFGApiContentInfo.realmGet$contents();
                long j2 = rFGApiContentInfoColumnInfo.contentsIndex;
                if (realmGet$contents != null) {
                    Table.nativeSetString(nativePtr, j2, createRowWithPrimaryKey, realmGet$contents, false);
                } else {
                    Table.nativeSetNull(nativePtr, j2, createRowWithPrimaryKey, false);
                }
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentInfo.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentinforealmproxy = new jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapicontentinforealmproxy;
    }

    static RFGApiContentInfo update(Realm realm, RFGApiContentInfoColumnInfo rFGApiContentInfoColumnInfo, RFGApiContentInfo rFGApiContentInfo, RFGApiContentInfo rFGApiContentInfo2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentInfo.class), rFGApiContentInfoColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentInfoColumnInfo.pKeyIndex, rFGApiContentInfo2.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentInfoColumnInfo.titleIndex, rFGApiContentInfo2.realmGet$title());
        osObjectBuilder.addString(rFGApiContentInfoColumnInfo.contentsIndex, rFGApiContentInfo2.realmGet$contents());
        osObjectBuilder.updateExistingObject();
        return rFGApiContentInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentinforealmproxy = (jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapicontentinforealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapicontentinforealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapicontentinforealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiContentInfoColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiContentInfo> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$contents() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.contentsIndex);
    }

    public String realmGet$pKey() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pKeyIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public String realmGet$title() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.titleIndex);
    }

    public void realmSet$contents(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.contentsIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.contentsIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.contentsIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.contentsIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$pKey(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'pKey' cannot be changed after object was created.");
        }
    }

    public void realmSet$title(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.titleIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.titleIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.titleIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.titleIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGApiContentInfo = proxy[", "{pKey:");
        b.append(realmGet$pKey());
        b.append("}");
        b.append(",");
        b.append("{title:");
        String str = "null";
        C0681a.m335a(b, realmGet$title() != null ? realmGet$title() : str, "}", ",", "{contents:");
        if (realmGet$contents() != null) {
            str = realmGet$contents();
        }
        b.append(str);
        b.append("}");
        b.append("]");
        return b.toString();
    }
}
