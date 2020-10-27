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
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy */
public class jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy extends RFGApiContentTitle implements RealmObjectProxy, C1009x59ce1396 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiContentTitleColumnInfo columnInfo;
    private ProxyState<RFGApiContentTitle> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiContentTitle";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy$RFGApiContentTitleColumnInfo */
    static final class RFGApiContentTitleColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long pKeyIndex;
        long sizeIndex;
        long valueIndex;

        RFGApiContentTitleColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiContentTitleColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.pKeyIndex = addColumnDetails("pKey", "pKey", objectSchemaInfo);
            this.valueIndex = addColumnDetails("value", "value", objectSchemaInfo);
            this.sizeIndex = addColumnDetails("size", "size", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiContentTitleColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiContentTitleColumnInfo rFGApiContentTitleColumnInfo = (RFGApiContentTitleColumnInfo) columnInfo;
            RFGApiContentTitleColumnInfo rFGApiContentTitleColumnInfo2 = (RFGApiContentTitleColumnInfo) columnInfo2;
            rFGApiContentTitleColumnInfo2.pKeyIndex = rFGApiContentTitleColumnInfo.pKeyIndex;
            rFGApiContentTitleColumnInfo2.valueIndex = rFGApiContentTitleColumnInfo.valueIndex;
            rFGApiContentTitleColumnInfo2.sizeIndex = rFGApiContentTitleColumnInfo.sizeIndex;
            rFGApiContentTitleColumnInfo2.maxColumnIndexValue = rFGApiContentTitleColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiContentTitle copy(Realm realm, RFGApiContentTitleColumnInfo rFGApiContentTitleColumnInfo, RFGApiContentTitle rFGApiContentTitle, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGApiContentTitle);
        if (realmObjectProxy != null) {
            return (RFGApiContentTitle) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentTitle.class), rFGApiContentTitleColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentTitleColumnInfo.pKeyIndex, rFGApiContentTitle.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentTitleColumnInfo.valueIndex, rFGApiContentTitle.realmGet$value());
        osObjectBuilder.addInteger(rFGApiContentTitleColumnInfo.sizeIndex, Integer.valueOf(rFGApiContentTitle.realmGet$size()));
        jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGApiContentTitle, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.RFGApiContentTitleColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentTitle r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentTitle> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle.class
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentTitle r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.api.train.RFGApiContentTitle r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy$RFGApiContentTitleColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiContentTitle, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiContentTitle");
    }

    public static RFGApiContentTitleColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiContentTitleColumnInfo(osSchemaInfo);
    }

    public static RFGApiContentTitle createDetachedCopy(RFGApiContentTitle rFGApiContentTitle, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiContentTitle rFGApiContentTitle2;
        if (i > i2 || rFGApiContentTitle == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiContentTitle);
        if (cacheData == null) {
            rFGApiContentTitle2 = new RFGApiContentTitle();
            map.put(rFGApiContentTitle, new RealmObjectProxy.CacheData(i, rFGApiContentTitle2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiContentTitle) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiContentTitle2 = (RFGApiContentTitle) cacheData.object;
        }
        rFGApiContentTitle2.realmSet$pKey(rFGApiContentTitle.realmGet$pKey());
        rFGApiContentTitle2.realmSet$value(rFGApiContentTitle.realmGet$value());
        rFGApiContentTitle2.realmSet$size(rFGApiContentTitle.realmGet$size());
        return rFGApiContentTitle2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 3, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("pKey", RealmFieldType.STRING, true, true, true);
        builder2.addPersistedProperty("value", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("size", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle createOrUpdateUsingJsonObject(p041io.realm.Realm r13, org.json.JSONObject r14, boolean r15) throws org.json.JSONException {
        /*
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentTitle> r0 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle.class
            java.util.List r1 = java.util.Collections.emptyList()
            r2 = 0
            java.lang.String r3 = "pKey"
            if (r15 == 0) goto L_0x005d
            io.realm.internal.Table r15 = r13.getTable(r0)
            io.realm.RealmSchema r4 = r13.getSchema()
            io.realm.internal.ColumnInfo r4 = r4.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy$RFGApiContentTitleColumnInfo r4 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.RFGApiContentTitleColumnInfo) r4
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy r15 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy     // Catch:{ all -> 0x0058 }
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy r15 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy) r15
            goto L_0x0086
        L_0x007e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "JSON object doesn't have the primary key field 'pKey'."
            r13.<init>(r14)
            throw r13
        L_0x0086:
            java.lang.String r13 = "value"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x009f
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x0098
            r15.realmSet$value(r2)
            goto L_0x009f
        L_0x0098:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$value(r13)
        L_0x009f:
            java.lang.String r13 = "size"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00bd
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00b5
            int r13 = r14.getInt(r13)
            r15.realmSet$size(r13)
            goto L_0x00bd
        L_0x00b5:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'size' to null."
            r13.<init>(r14)
            throw r13
        L_0x00bd:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiContentTitle");
    }

    @TargetApi(11)
    public static RFGApiContentTitle createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGApiContentTitle rFGApiContentTitle = new RFGApiContentTitle();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("pKey")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentTitle.realmSet$pKey(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentTitle.realmSet$pKey((String) null);
                }
                z = true;
            } else if (nextName.equals("value")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentTitle.realmSet$value(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentTitle.realmSet$value((String) null);
                }
            } else if (!nextName.equals("size")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiContentTitle.realmSet$size(jsonReader.nextInt());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'size' to null.");
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiContentTitle) realm.copyToRealm(rFGApiContentTitle, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pKey'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiContentTitle rFGApiContentTitle, Map<RealmModel, Long> map) {
        Class<RFGApiContentTitle> cls = RFGApiContentTitle.class;
        if (rFGApiContentTitle instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentTitle;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentTitleColumnInfo rFGApiContentTitleColumnInfo = (RFGApiContentTitleColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentTitleColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentTitle.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentTitle, Long.valueOf(j2));
        String realmGet$value = rFGApiContentTitle.realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(nativePtr, rFGApiContentTitleColumnInfo.valueIndex, j2, realmGet$value, false);
        }
        Table.nativeSetLong(nativePtr, rFGApiContentTitleColumnInfo.sizeIndex, j2, (long) rFGApiContentTitle.realmGet$size(), false);
        return j2;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentTitle> cls = RFGApiContentTitle.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentTitleColumnInfo rFGApiContentTitleColumnInfo = (RFGApiContentTitleColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentTitleColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentTitle rFGApiContentTitle = (RFGApiContentTitle) it.next();
            if (!map2.containsKey(rFGApiContentTitle)) {
                if (rFGApiContentTitle instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentTitle;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentTitle, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentTitle.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j3, realmGet$pKey) : -1;
                if (nativeFindFirstString == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j3, realmGet$pKey);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
                    j = nativeFindFirstString;
                }
                map2.put(rFGApiContentTitle, Long.valueOf(j));
                String realmGet$value = rFGApiContentTitle.realmGet$value();
                if (realmGet$value != null) {
                    j2 = j3;
                    Table.nativeSetString(nativePtr, rFGApiContentTitleColumnInfo.valueIndex, j, realmGet$value, false);
                } else {
                    j2 = j3;
                }
                Table.nativeSetLong(nativePtr, rFGApiContentTitleColumnInfo.sizeIndex, j, (long) rFGApiContentTitle.realmGet$size(), false);
                j3 = j2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiContentTitle rFGApiContentTitle, Map<RealmModel, Long> map) {
        Class<RFGApiContentTitle> cls = RFGApiContentTitle.class;
        if (rFGApiContentTitle instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentTitle;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentTitleColumnInfo rFGApiContentTitleColumnInfo = (RFGApiContentTitleColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentTitleColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentTitle.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentTitle, Long.valueOf(j2));
        String realmGet$value = rFGApiContentTitle.realmGet$value();
        long j3 = rFGApiContentTitleColumnInfo.valueIndex;
        if (realmGet$value != null) {
            Table.nativeSetString(nativePtr, j3, j2, realmGet$value, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, j2, false);
        }
        Table.nativeSetLong(nativePtr, rFGApiContentTitleColumnInfo.sizeIndex, j2, (long) rFGApiContentTitle.realmGet$size(), false);
        return j2;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentTitle> cls = RFGApiContentTitle.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentTitleColumnInfo rFGApiContentTitleColumnInfo = (RFGApiContentTitleColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiContentTitleColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentTitle rFGApiContentTitle = (RFGApiContentTitle) it.next();
            if (!map2.containsKey(rFGApiContentTitle)) {
                if (rFGApiContentTitle instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentTitle;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentTitle, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentTitle.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j2, realmGet$pKey) : -1;
                long createRowWithPrimaryKey = nativeFindFirstString == -1 ? OsObject.createRowWithPrimaryKey(table, j2, realmGet$pKey) : nativeFindFirstString;
                map2.put(rFGApiContentTitle, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$value = rFGApiContentTitle.realmGet$value();
                if (realmGet$value != null) {
                    j = j2;
                    Table.nativeSetString(nativePtr, rFGApiContentTitleColumnInfo.valueIndex, createRowWithPrimaryKey, realmGet$value, false);
                } else {
                    j = j2;
                    Table.nativeSetNull(nativePtr, rFGApiContentTitleColumnInfo.valueIndex, createRowWithPrimaryKey, false);
                }
                Table.nativeSetLong(nativePtr, rFGApiContentTitleColumnInfo.sizeIndex, createRowWithPrimaryKey, (long) rFGApiContentTitle.realmGet$size(), false);
                j2 = j;
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentTitle.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontenttitlerealmproxy = new jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapicontenttitlerealmproxy;
    }

    static RFGApiContentTitle update(Realm realm, RFGApiContentTitleColumnInfo rFGApiContentTitleColumnInfo, RFGApiContentTitle rFGApiContentTitle, RFGApiContentTitle rFGApiContentTitle2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentTitle.class), rFGApiContentTitleColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentTitleColumnInfo.pKeyIndex, rFGApiContentTitle2.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentTitleColumnInfo.valueIndex, rFGApiContentTitle2.realmGet$value());
        osObjectBuilder.addInteger(rFGApiContentTitleColumnInfo.sizeIndex, Integer.valueOf(rFGApiContentTitle2.realmGet$size()));
        osObjectBuilder.updateExistingObject();
        return rFGApiContentTitle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontenttitlerealmproxy = (jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapicontenttitlerealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapicontenttitlerealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapicontenttitlerealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiContentTitleColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiContentTitle> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$pKey() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pKeyIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int realmGet$size() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.sizeIndex);
    }

    public String realmGet$value() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.valueIndex);
    }

    public void realmSet$pKey(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'pKey' cannot be changed after object was created.");
        }
    }

    public void realmSet$size(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.sizeIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.sizeIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$value(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.valueIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'value' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.valueIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'value' to null.");
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGApiContentTitle = proxy[", "{pKey:");
        b.append(realmGet$pKey());
        b.append("}");
        b.append(",");
        b.append("{value:");
        b.append(realmGet$value());
        b.append("}");
        b.append(",");
        b.append("{size:");
        b.append(realmGet$size());
        return C0681a.m324a(b, "}", "]");
    }
}
