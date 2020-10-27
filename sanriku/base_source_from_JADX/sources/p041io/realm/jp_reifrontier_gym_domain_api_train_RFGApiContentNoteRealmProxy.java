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
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy */
public class jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy extends RFGApiContentNote implements RealmObjectProxy, C1007x116808d4 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiContentNoteColumnInfo columnInfo;
    private ProxyState<RFGApiContentNote> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiContentNote";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy$RFGApiContentNoteColumnInfo */
    static final class RFGApiContentNoteColumnInfo extends ColumnInfo {
        long boldIndex;
        long colorIndex;
        long maxColumnIndexValue;
        long pKeyIndex;
        long sizeIndex;
        long valueIndex;

        RFGApiContentNoteColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiContentNoteColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.pKeyIndex = addColumnDetails("pKey", "pKey", objectSchemaInfo);
            this.valueIndex = addColumnDetails("value", "value", objectSchemaInfo);
            this.sizeIndex = addColumnDetails("size", "size", objectSchemaInfo);
            this.boldIndex = addColumnDetails("bold", "bold", objectSchemaInfo);
            this.colorIndex = addColumnDetails("color", "color", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiContentNoteColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiContentNoteColumnInfo rFGApiContentNoteColumnInfo = (RFGApiContentNoteColumnInfo) columnInfo;
            RFGApiContentNoteColumnInfo rFGApiContentNoteColumnInfo2 = (RFGApiContentNoteColumnInfo) columnInfo2;
            rFGApiContentNoteColumnInfo2.pKeyIndex = rFGApiContentNoteColumnInfo.pKeyIndex;
            rFGApiContentNoteColumnInfo2.valueIndex = rFGApiContentNoteColumnInfo.valueIndex;
            rFGApiContentNoteColumnInfo2.sizeIndex = rFGApiContentNoteColumnInfo.sizeIndex;
            rFGApiContentNoteColumnInfo2.boldIndex = rFGApiContentNoteColumnInfo.boldIndex;
            rFGApiContentNoteColumnInfo2.colorIndex = rFGApiContentNoteColumnInfo.colorIndex;
            rFGApiContentNoteColumnInfo2.maxColumnIndexValue = rFGApiContentNoteColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiContentNote copy(Realm realm, RFGApiContentNoteColumnInfo rFGApiContentNoteColumnInfo, RFGApiContentNote rFGApiContentNote, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGApiContentNote);
        if (realmObjectProxy != null) {
            return (RFGApiContentNote) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentNote.class), rFGApiContentNoteColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentNoteColumnInfo.pKeyIndex, rFGApiContentNote.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentNoteColumnInfo.valueIndex, rFGApiContentNote.realmGet$value());
        osObjectBuilder.addInteger(rFGApiContentNoteColumnInfo.sizeIndex, Integer.valueOf(rFGApiContentNote.realmGet$size()));
        osObjectBuilder.addBoolean(rFGApiContentNoteColumnInfo.boldIndex, Boolean.valueOf(rFGApiContentNote.realmGet$bold()));
        osObjectBuilder.addInteger(rFGApiContentNoteColumnInfo.colorIndex, Integer.valueOf(rFGApiContentNote.realmGet$color()));
        jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGApiContentNote, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.RFGApiContentNoteColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentNote r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentNote> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote.class
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentNote r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.api.train.RFGApiContentNote r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy$RFGApiContentNoteColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiContentNote, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiContentNote");
    }

    public static RFGApiContentNoteColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiContentNoteColumnInfo(osSchemaInfo);
    }

    public static RFGApiContentNote createDetachedCopy(RFGApiContentNote rFGApiContentNote, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiContentNote rFGApiContentNote2;
        if (i > i2 || rFGApiContentNote == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiContentNote);
        if (cacheData == null) {
            rFGApiContentNote2 = new RFGApiContentNote();
            map.put(rFGApiContentNote, new RealmObjectProxy.CacheData(i, rFGApiContentNote2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiContentNote) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiContentNote2 = (RFGApiContentNote) cacheData.object;
        }
        rFGApiContentNote2.realmSet$pKey(rFGApiContentNote.realmGet$pKey());
        rFGApiContentNote2.realmSet$value(rFGApiContentNote.realmGet$value());
        rFGApiContentNote2.realmSet$size(rFGApiContentNote.realmGet$size());
        rFGApiContentNote2.realmSet$bold(rFGApiContentNote.realmGet$bold());
        rFGApiContentNote2.realmSet$color(rFGApiContentNote.realmGet$color());
        return rFGApiContentNote2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 5, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("pKey", RealmFieldType.STRING, true, true, true);
        builder2.addPersistedProperty("value", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("size", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("bold", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addPersistedProperty("color", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote createOrUpdateUsingJsonObject(p041io.realm.Realm r13, org.json.JSONObject r14, boolean r15) throws org.json.JSONException {
        /*
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentNote> r0 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote.class
            java.util.List r1 = java.util.Collections.emptyList()
            r2 = 0
            java.lang.String r3 = "pKey"
            if (r15 == 0) goto L_0x005d
            io.realm.internal.Table r15 = r13.getTable(r0)
            io.realm.RealmSchema r4 = r13.getSchema()
            io.realm.internal.ColumnInfo r4 = r4.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy$RFGApiContentNoteColumnInfo r4 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.RFGApiContentNoteColumnInfo) r4
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy r15 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy     // Catch:{ all -> 0x0058 }
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy r15 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy) r15
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
            java.lang.String r13 = "bold"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00db
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00d3
            boolean r13 = r14.getBoolean(r13)
            r15.realmSet$bold(r13)
            goto L_0x00db
        L_0x00d3:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'bold' to null."
            r13.<init>(r14)
            throw r13
        L_0x00db:
            java.lang.String r13 = "color"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00f9
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00f1
            int r13 = r14.getInt(r13)
            r15.realmSet$color(r13)
            goto L_0x00f9
        L_0x00f1:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'color' to null."
            r13.<init>(r14)
            throw r13
        L_0x00f9:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiContentNote");
    }

    @TargetApi(11)
    public static RFGApiContentNote createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGApiContentNote rFGApiContentNote = new RFGApiContentNote();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("pKey")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentNote.realmSet$pKey(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentNote.realmSet$pKey((String) null);
                }
                z = true;
            } else if (nextName.equals("value")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentNote.realmSet$value(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentNote.realmSet$value((String) null);
                }
            } else if (nextName.equals("size")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentNote.realmSet$size(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'size' to null.");
                }
            } else if (nextName.equals("bold")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentNote.realmSet$bold(jsonReader.nextBoolean());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'bold' to null.");
                }
            } else if (!nextName.equals("color")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiContentNote.realmSet$color(jsonReader.nextInt());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'color' to null.");
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiContentNote) realm.copyToRealm(rFGApiContentNote, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pKey'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiContentNote rFGApiContentNote, Map<RealmModel, Long> map) {
        Class<RFGApiContentNote> cls = RFGApiContentNote.class;
        if (rFGApiContentNote instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentNote;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentNoteColumnInfo rFGApiContentNoteColumnInfo = (RFGApiContentNoteColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentNoteColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentNote.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentNote, Long.valueOf(j2));
        String realmGet$value = rFGApiContentNote.realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(nativePtr, rFGApiContentNoteColumnInfo.valueIndex, j2, realmGet$value, false);
        }
        long j3 = nativePtr;
        long j4 = j2;
        Table.nativeSetLong(j3, rFGApiContentNoteColumnInfo.sizeIndex, j4, (long) rFGApiContentNote.realmGet$size(), false);
        Table.nativeSetBoolean(j3, rFGApiContentNoteColumnInfo.boldIndex, j4, rFGApiContentNote.realmGet$bold(), false);
        Table.nativeSetLong(j3, rFGApiContentNoteColumnInfo.colorIndex, j4, (long) rFGApiContentNote.realmGet$color(), false);
        return j2;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentNote> cls = RFGApiContentNote.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentNoteColumnInfo rFGApiContentNoteColumnInfo = (RFGApiContentNoteColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentNoteColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentNote rFGApiContentNote = (RFGApiContentNote) it.next();
            if (!map2.containsKey(rFGApiContentNote)) {
                if (rFGApiContentNote instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentNote;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentNote, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentNote.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j3, realmGet$pKey) : -1;
                if (nativeFindFirstString == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j3, realmGet$pKey);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
                    j = nativeFindFirstString;
                }
                map2.put(rFGApiContentNote, Long.valueOf(j));
                String realmGet$value = rFGApiContentNote.realmGet$value();
                if (realmGet$value != null) {
                    j2 = j3;
                    Table.nativeSetString(nativePtr, rFGApiContentNoteColumnInfo.valueIndex, j, realmGet$value, false);
                } else {
                    j2 = j3;
                }
                long j4 = nativePtr;
                long j5 = j;
                Table.nativeSetLong(j4, rFGApiContentNoteColumnInfo.sizeIndex, j5, (long) rFGApiContentNote.realmGet$size(), false);
                Table.nativeSetBoolean(j4, rFGApiContentNoteColumnInfo.boldIndex, j5, rFGApiContentNote.realmGet$bold(), false);
                Table.nativeSetLong(nativePtr, rFGApiContentNoteColumnInfo.colorIndex, j5, (long) rFGApiContentNote.realmGet$color(), false);
                j3 = j2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiContentNote rFGApiContentNote, Map<RealmModel, Long> map) {
        Class<RFGApiContentNote> cls = RFGApiContentNote.class;
        if (rFGApiContentNote instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentNote;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentNoteColumnInfo rFGApiContentNoteColumnInfo = (RFGApiContentNoteColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentNoteColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentNote.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentNote, Long.valueOf(j2));
        String realmGet$value = rFGApiContentNote.realmGet$value();
        long j3 = rFGApiContentNoteColumnInfo.valueIndex;
        if (realmGet$value != null) {
            Table.nativeSetString(nativePtr, j3, j2, realmGet$value, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, j2, false);
        }
        long j4 = nativePtr;
        long j5 = j2;
        Table.nativeSetLong(j4, rFGApiContentNoteColumnInfo.sizeIndex, j5, (long) rFGApiContentNote.realmGet$size(), false);
        Table.nativeSetBoolean(j4, rFGApiContentNoteColumnInfo.boldIndex, j5, rFGApiContentNote.realmGet$bold(), false);
        Table.nativeSetLong(j4, rFGApiContentNoteColumnInfo.colorIndex, j5, (long) rFGApiContentNote.realmGet$color(), false);
        return j2;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentNote> cls = RFGApiContentNote.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentNoteColumnInfo rFGApiContentNoteColumnInfo = (RFGApiContentNoteColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiContentNoteColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentNote rFGApiContentNote = (RFGApiContentNote) it.next();
            if (!map2.containsKey(rFGApiContentNote)) {
                if (rFGApiContentNote instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentNote;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentNote, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentNote.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j2, realmGet$pKey) : -1;
                long createRowWithPrimaryKey = nativeFindFirstString == -1 ? OsObject.createRowWithPrimaryKey(table, j2, realmGet$pKey) : nativeFindFirstString;
                map2.put(rFGApiContentNote, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$value = rFGApiContentNote.realmGet$value();
                if (realmGet$value != null) {
                    j = j2;
                    Table.nativeSetString(nativePtr, rFGApiContentNoteColumnInfo.valueIndex, createRowWithPrimaryKey, realmGet$value, false);
                } else {
                    j = j2;
                    Table.nativeSetNull(nativePtr, rFGApiContentNoteColumnInfo.valueIndex, createRowWithPrimaryKey, false);
                }
                long j3 = nativePtr;
                long j4 = createRowWithPrimaryKey;
                Table.nativeSetLong(j3, rFGApiContentNoteColumnInfo.sizeIndex, j4, (long) rFGApiContentNote.realmGet$size(), false);
                Table.nativeSetBoolean(j3, rFGApiContentNoteColumnInfo.boldIndex, j4, rFGApiContentNote.realmGet$bold(), false);
                Table.nativeSetLong(nativePtr, rFGApiContentNoteColumnInfo.colorIndex, j4, (long) rFGApiContentNote.realmGet$color(), false);
                j2 = j;
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentNote.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentnoterealmproxy = new jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapicontentnoterealmproxy;
    }

    static RFGApiContentNote update(Realm realm, RFGApiContentNoteColumnInfo rFGApiContentNoteColumnInfo, RFGApiContentNote rFGApiContentNote, RFGApiContentNote rFGApiContentNote2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentNote.class), rFGApiContentNoteColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentNoteColumnInfo.pKeyIndex, rFGApiContentNote2.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentNoteColumnInfo.valueIndex, rFGApiContentNote2.realmGet$value());
        osObjectBuilder.addInteger(rFGApiContentNoteColumnInfo.sizeIndex, Integer.valueOf(rFGApiContentNote2.realmGet$size()));
        osObjectBuilder.addBoolean(rFGApiContentNoteColumnInfo.boldIndex, Boolean.valueOf(rFGApiContentNote2.realmGet$bold()));
        osObjectBuilder.addInteger(rFGApiContentNoteColumnInfo.colorIndex, Integer.valueOf(rFGApiContentNote2.realmGet$color()));
        osObjectBuilder.updateExistingObject();
        return rFGApiContentNote;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentnoterealmproxy = (jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapicontentnoterealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapicontentnoterealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapicontentnoterealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiContentNoteColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiContentNote> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public boolean realmGet$bold() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.boldIndex);
    }

    public int realmGet$color() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.colorIndex);
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

    public void realmSet$bold(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.boldIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.boldIndex, row$realm.getIndex(), z, true);
        }
    }

    public void realmSet$color(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.colorIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.colorIndex, row$realm.getIndex(), (long) i, true);
        }
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
        StringBuilder b = C0681a.m339b("RFGApiContentNote = proxy[", "{pKey:");
        b.append(realmGet$pKey());
        b.append("}");
        b.append(",");
        b.append("{value:");
        b.append(realmGet$value());
        b.append("}");
        b.append(",");
        b.append("{size:");
        b.append(realmGet$size());
        b.append("}");
        b.append(",");
        b.append("{bold:");
        b.append(realmGet$bold());
        b.append("}");
        b.append(",");
        b.append("{color:");
        b.append(realmGet$color());
        return C0681a.m324a(b, "}", "]");
    }
}
