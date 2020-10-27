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
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy */
public class jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy extends RFGApiContentImage implements RealmObjectProxy, C1004x7399afb3 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiContentImageColumnInfo columnInfo;
    private ProxyState<RFGApiContentImage> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiContentImage";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy$RFGApiContentImageColumnInfo */
    static final class RFGApiContentImageColumnInfo extends ColumnInfo {
        long fullIndex;
        long heightIndex;
        long maxColumnIndexValue;
        long pKeyIndex;
        long pathIndex;
        long widthIndex;

        RFGApiContentImageColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiContentImageColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.pKeyIndex = addColumnDetails("pKey", "pKey", objectSchemaInfo);
            this.pathIndex = addColumnDetails("path", "path", objectSchemaInfo);
            this.widthIndex = addColumnDetails("width", "width", objectSchemaInfo);
            this.heightIndex = addColumnDetails("height", "height", objectSchemaInfo);
            this.fullIndex = addColumnDetails("full", "full", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiContentImageColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiContentImageColumnInfo rFGApiContentImageColumnInfo = (RFGApiContentImageColumnInfo) columnInfo;
            RFGApiContentImageColumnInfo rFGApiContentImageColumnInfo2 = (RFGApiContentImageColumnInfo) columnInfo2;
            rFGApiContentImageColumnInfo2.pKeyIndex = rFGApiContentImageColumnInfo.pKeyIndex;
            rFGApiContentImageColumnInfo2.pathIndex = rFGApiContentImageColumnInfo.pathIndex;
            rFGApiContentImageColumnInfo2.widthIndex = rFGApiContentImageColumnInfo.widthIndex;
            rFGApiContentImageColumnInfo2.heightIndex = rFGApiContentImageColumnInfo.heightIndex;
            rFGApiContentImageColumnInfo2.fullIndex = rFGApiContentImageColumnInfo.fullIndex;
            rFGApiContentImageColumnInfo2.maxColumnIndexValue = rFGApiContentImageColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiContentImage copy(Realm realm, RFGApiContentImageColumnInfo rFGApiContentImageColumnInfo, RFGApiContentImage rFGApiContentImage, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGApiContentImage);
        if (realmObjectProxy != null) {
            return (RFGApiContentImage) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentImage.class), rFGApiContentImageColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentImageColumnInfo.pKeyIndex, rFGApiContentImage.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentImageColumnInfo.pathIndex, rFGApiContentImage.realmGet$path());
        osObjectBuilder.addInteger(rFGApiContentImageColumnInfo.widthIndex, Integer.valueOf(rFGApiContentImage.realmGet$width()));
        osObjectBuilder.addInteger(rFGApiContentImageColumnInfo.heightIndex, Integer.valueOf(rFGApiContentImage.realmGet$height()));
        osObjectBuilder.addBoolean(rFGApiContentImageColumnInfo.fullIndex, Boolean.valueOf(rFGApiContentImage.realmGet$full()));
        jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGApiContentImage, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.RFGApiContentImageColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentImage r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentImage> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage.class
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentImage r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.api.train.RFGApiContentImage r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy$RFGApiContentImageColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiContentImage, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiContentImage");
    }

    public static RFGApiContentImageColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiContentImageColumnInfo(osSchemaInfo);
    }

    public static RFGApiContentImage createDetachedCopy(RFGApiContentImage rFGApiContentImage, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiContentImage rFGApiContentImage2;
        if (i > i2 || rFGApiContentImage == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiContentImage);
        if (cacheData == null) {
            rFGApiContentImage2 = new RFGApiContentImage();
            map.put(rFGApiContentImage, new RealmObjectProxy.CacheData(i, rFGApiContentImage2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiContentImage) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiContentImage2 = (RFGApiContentImage) cacheData.object;
        }
        rFGApiContentImage2.realmSet$pKey(rFGApiContentImage.realmGet$pKey());
        rFGApiContentImage2.realmSet$path(rFGApiContentImage.realmGet$path());
        rFGApiContentImage2.realmSet$width(rFGApiContentImage.realmGet$width());
        rFGApiContentImage2.realmSet$height(rFGApiContentImage.realmGet$height());
        rFGApiContentImage2.realmSet$full(rFGApiContentImage.realmGet$full());
        return rFGApiContentImage2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 5, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("pKey", RealmFieldType.STRING, true, true, true);
        builder2.addPersistedProperty("path", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("width", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("height", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("full", RealmFieldType.BOOLEAN, false, false, true);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage createOrUpdateUsingJsonObject(p041io.realm.Realm r13, org.json.JSONObject r14, boolean r15) throws org.json.JSONException {
        /*
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentImage> r0 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage.class
            java.util.List r1 = java.util.Collections.emptyList()
            r2 = 0
            java.lang.String r3 = "pKey"
            if (r15 == 0) goto L_0x005d
            io.realm.internal.Table r15 = r13.getTable(r0)
            io.realm.RealmSchema r4 = r13.getSchema()
            io.realm.internal.ColumnInfo r4 = r4.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy$RFGApiContentImageColumnInfo r4 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.RFGApiContentImageColumnInfo) r4
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy r15 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy     // Catch:{ all -> 0x0058 }
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy r15 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy) r15
            goto L_0x0086
        L_0x007e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "JSON object doesn't have the primary key field 'pKey'."
            r13.<init>(r14)
            throw r13
        L_0x0086:
            java.lang.String r13 = "path"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x009f
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x0098
            r15.realmSet$path(r2)
            goto L_0x009f
        L_0x0098:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$path(r13)
        L_0x009f:
            java.lang.String r13 = "width"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00bd
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00b5
            int r13 = r14.getInt(r13)
            r15.realmSet$width(r13)
            goto L_0x00bd
        L_0x00b5:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'width' to null."
            r13.<init>(r14)
            throw r13
        L_0x00bd:
            java.lang.String r13 = "height"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00db
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00d3
            int r13 = r14.getInt(r13)
            r15.realmSet$height(r13)
            goto L_0x00db
        L_0x00d3:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'height' to null."
            r13.<init>(r14)
            throw r13
        L_0x00db:
            java.lang.String r13 = "full"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00f9
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00f1
            boolean r13 = r14.getBoolean(r13)
            r15.realmSet$full(r13)
            goto L_0x00f9
        L_0x00f1:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'full' to null."
            r13.<init>(r14)
            throw r13
        L_0x00f9:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiContentImage");
    }

    @TargetApi(11)
    public static RFGApiContentImage createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGApiContentImage rFGApiContentImage = new RFGApiContentImage();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("pKey")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentImage.realmSet$pKey(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentImage.realmSet$pKey((String) null);
                }
                z = true;
            } else if (nextName.equals("path")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentImage.realmSet$path(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentImage.realmSet$path((String) null);
                }
            } else if (nextName.equals("width")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentImage.realmSet$width(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'width' to null.");
                }
            } else if (nextName.equals("height")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentImage.realmSet$height(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'height' to null.");
                }
            } else if (!nextName.equals("full")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiContentImage.realmSet$full(jsonReader.nextBoolean());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'full' to null.");
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiContentImage) realm.copyToRealm(rFGApiContentImage, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pKey'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiContentImage rFGApiContentImage, Map<RealmModel, Long> map) {
        Class<RFGApiContentImage> cls = RFGApiContentImage.class;
        if (rFGApiContentImage instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentImage;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentImageColumnInfo rFGApiContentImageColumnInfo = (RFGApiContentImageColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentImageColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentImage.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentImage, Long.valueOf(j2));
        String realmGet$path = rFGApiContentImage.realmGet$path();
        if (realmGet$path != null) {
            Table.nativeSetString(nativePtr, rFGApiContentImageColumnInfo.pathIndex, j2, realmGet$path, false);
        }
        long j3 = j2;
        Table.nativeSetLong(nativePtr, rFGApiContentImageColumnInfo.widthIndex, j3, (long) rFGApiContentImage.realmGet$width(), false);
        long j4 = nativePtr;
        Table.nativeSetLong(j4, rFGApiContentImageColumnInfo.heightIndex, j3, (long) rFGApiContentImage.realmGet$height(), false);
        Table.nativeSetBoolean(j4, rFGApiContentImageColumnInfo.fullIndex, j3, rFGApiContentImage.realmGet$full(), false);
        return j2;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentImage> cls = RFGApiContentImage.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentImageColumnInfo rFGApiContentImageColumnInfo = (RFGApiContentImageColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentImageColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentImage rFGApiContentImage = (RFGApiContentImage) it.next();
            if (!map2.containsKey(rFGApiContentImage)) {
                if (rFGApiContentImage instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentImage;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentImage, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentImage.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j3, realmGet$pKey) : -1;
                if (nativeFindFirstString == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j3, realmGet$pKey);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
                    j = nativeFindFirstString;
                }
                map2.put(rFGApiContentImage, Long.valueOf(j));
                String realmGet$path = rFGApiContentImage.realmGet$path();
                if (realmGet$path != null) {
                    j2 = j3;
                    Table.nativeSetString(nativePtr, rFGApiContentImageColumnInfo.pathIndex, j, realmGet$path, false);
                } else {
                    j2 = j3;
                }
                long j4 = j;
                Table.nativeSetLong(nativePtr, rFGApiContentImageColumnInfo.widthIndex, j4, (long) rFGApiContentImage.realmGet$width(), false);
                long j5 = nativePtr;
                Table.nativeSetLong(j5, rFGApiContentImageColumnInfo.heightIndex, j4, (long) rFGApiContentImage.realmGet$height(), false);
                Table.nativeSetBoolean(j5, rFGApiContentImageColumnInfo.fullIndex, j4, rFGApiContentImage.realmGet$full(), false);
                j3 = j2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiContentImage rFGApiContentImage, Map<RealmModel, Long> map) {
        Class<RFGApiContentImage> cls = RFGApiContentImage.class;
        if (rFGApiContentImage instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentImage;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentImageColumnInfo rFGApiContentImageColumnInfo = (RFGApiContentImageColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentImageColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentImage.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentImage, Long.valueOf(j2));
        String realmGet$path = rFGApiContentImage.realmGet$path();
        long j3 = rFGApiContentImageColumnInfo.pathIndex;
        if (realmGet$path != null) {
            Table.nativeSetString(nativePtr, j3, j2, realmGet$path, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, j2, false);
        }
        long j4 = j2;
        Table.nativeSetLong(nativePtr, rFGApiContentImageColumnInfo.widthIndex, j4, (long) rFGApiContentImage.realmGet$width(), false);
        long j5 = nativePtr;
        Table.nativeSetLong(j5, rFGApiContentImageColumnInfo.heightIndex, j4, (long) rFGApiContentImage.realmGet$height(), false);
        Table.nativeSetBoolean(j5, rFGApiContentImageColumnInfo.fullIndex, j4, rFGApiContentImage.realmGet$full(), false);
        return j2;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentImage> cls = RFGApiContentImage.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentImageColumnInfo rFGApiContentImageColumnInfo = (RFGApiContentImageColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiContentImageColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentImage rFGApiContentImage = (RFGApiContentImage) it.next();
            if (!map2.containsKey(rFGApiContentImage)) {
                if (rFGApiContentImage instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentImage;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentImage, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentImage.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j2, realmGet$pKey) : -1;
                long createRowWithPrimaryKey = nativeFindFirstString == -1 ? OsObject.createRowWithPrimaryKey(table, j2, realmGet$pKey) : nativeFindFirstString;
                map2.put(rFGApiContentImage, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$path = rFGApiContentImage.realmGet$path();
                if (realmGet$path != null) {
                    j = j2;
                    Table.nativeSetString(nativePtr, rFGApiContentImageColumnInfo.pathIndex, createRowWithPrimaryKey, realmGet$path, false);
                } else {
                    j = j2;
                    Table.nativeSetNull(nativePtr, rFGApiContentImageColumnInfo.pathIndex, createRowWithPrimaryKey, false);
                }
                long j3 = createRowWithPrimaryKey;
                Table.nativeSetLong(nativePtr, rFGApiContentImageColumnInfo.widthIndex, j3, (long) rFGApiContentImage.realmGet$width(), false);
                long j4 = nativePtr;
                Table.nativeSetLong(j4, rFGApiContentImageColumnInfo.heightIndex, j3, (long) rFGApiContentImage.realmGet$height(), false);
                Table.nativeSetBoolean(j4, rFGApiContentImageColumnInfo.fullIndex, j3, rFGApiContentImage.realmGet$full(), false);
                j2 = j;
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentImage.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentimagerealmproxy = new jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapicontentimagerealmproxy;
    }

    static RFGApiContentImage update(Realm realm, RFGApiContentImageColumnInfo rFGApiContentImageColumnInfo, RFGApiContentImage rFGApiContentImage, RFGApiContentImage rFGApiContentImage2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentImage.class), rFGApiContentImageColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentImageColumnInfo.pKeyIndex, rFGApiContentImage2.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentImageColumnInfo.pathIndex, rFGApiContentImage2.realmGet$path());
        osObjectBuilder.addInteger(rFGApiContentImageColumnInfo.widthIndex, Integer.valueOf(rFGApiContentImage2.realmGet$width()));
        osObjectBuilder.addInteger(rFGApiContentImageColumnInfo.heightIndex, Integer.valueOf(rFGApiContentImage2.realmGet$height()));
        osObjectBuilder.addBoolean(rFGApiContentImageColumnInfo.fullIndex, Boolean.valueOf(rFGApiContentImage2.realmGet$full()));
        osObjectBuilder.updateExistingObject();
        return rFGApiContentImage;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentimagerealmproxy = (jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapicontentimagerealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapicontentimagerealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapicontentimagerealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiContentImageColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiContentImage> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public boolean realmGet$full() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.fullIndex);
    }

    public int realmGet$height() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.heightIndex);
    }

    public String realmGet$pKey() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pKeyIndex);
    }

    public String realmGet$path() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pathIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int realmGet$width() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.widthIndex);
    }

    public void realmSet$full(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.fullIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.fullIndex, row$realm.getIndex(), z, true);
        }
    }

    public void realmSet$height(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.heightIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.heightIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$pKey(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'pKey' cannot be changed after object was created.");
        }
    }

    public void realmSet$path(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.pathIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'path' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.pathIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'path' to null.");
        }
    }

    public void realmSet$width(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.widthIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.widthIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGApiContentImage = proxy[", "{pKey:");
        b.append(realmGet$pKey());
        b.append("}");
        b.append(",");
        b.append("{path:");
        b.append(realmGet$path());
        b.append("}");
        b.append(",");
        b.append("{width:");
        b.append(realmGet$width());
        b.append("}");
        b.append(",");
        b.append("{height:");
        b.append(realmGet$height());
        b.append("}");
        b.append(",");
        b.append("{full:");
        b.append(realmGet$full());
        return C0681a.m324a(b, "}", "]");
    }
}
