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
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton;
import p043jp.reifrontier.gym.p044ui.dialog.RFGAddMemberDialog;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy */
public class C2010xb5bcc025 extends RFGApiContentButton implements RealmObjectProxy, C1003xf6a02694 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiContentButtonColumnInfo columnInfo;
    private ProxyState<RFGApiContentButton> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiContentButton";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy$RFGApiContentButtonColumnInfo */
    static final class RFGApiContentButtonColumnInfo extends ColumnInfo {
        long analyticsIndex;
        long colorIndex;
        long labelIndex;
        long maxColumnIndexValue;
        long pKeyIndex;
        long typeIndex;
        long valueIndex;

        RFGApiContentButtonColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiContentButtonColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.pKeyIndex = addColumnDetails("pKey", "pKey", objectSchemaInfo);
            this.labelIndex = addColumnDetails(RFGAddMemberDialog.ARG_LABEL, RFGAddMemberDialog.ARG_LABEL, objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.valueIndex = addColumnDetails("value", "value", objectSchemaInfo);
            this.colorIndex = addColumnDetails("color", "color", objectSchemaInfo);
            this.analyticsIndex = addColumnDetails("analytics", "analytics", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiContentButtonColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiContentButtonColumnInfo rFGApiContentButtonColumnInfo = (RFGApiContentButtonColumnInfo) columnInfo;
            RFGApiContentButtonColumnInfo rFGApiContentButtonColumnInfo2 = (RFGApiContentButtonColumnInfo) columnInfo2;
            rFGApiContentButtonColumnInfo2.pKeyIndex = rFGApiContentButtonColumnInfo.pKeyIndex;
            rFGApiContentButtonColumnInfo2.labelIndex = rFGApiContentButtonColumnInfo.labelIndex;
            rFGApiContentButtonColumnInfo2.typeIndex = rFGApiContentButtonColumnInfo.typeIndex;
            rFGApiContentButtonColumnInfo2.valueIndex = rFGApiContentButtonColumnInfo.valueIndex;
            rFGApiContentButtonColumnInfo2.colorIndex = rFGApiContentButtonColumnInfo.colorIndex;
            rFGApiContentButtonColumnInfo2.analyticsIndex = rFGApiContentButtonColumnInfo.analyticsIndex;
            rFGApiContentButtonColumnInfo2.maxColumnIndexValue = rFGApiContentButtonColumnInfo.maxColumnIndexValue;
        }
    }

    C2010xb5bcc025() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiContentButton copy(Realm realm, RFGApiContentButtonColumnInfo rFGApiContentButtonColumnInfo, RFGApiContentButton rFGApiContentButton, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGApiContentButton);
        if (realmObjectProxy != null) {
            return (RFGApiContentButton) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentButton.class), rFGApiContentButtonColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentButtonColumnInfo.pKeyIndex, rFGApiContentButton.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentButtonColumnInfo.labelIndex, rFGApiContentButton.realmGet$label());
        osObjectBuilder.addInteger(rFGApiContentButtonColumnInfo.typeIndex, Integer.valueOf(rFGApiContentButton.realmGet$type()));
        osObjectBuilder.addString(rFGApiContentButtonColumnInfo.valueIndex, rFGApiContentButton.realmGet$value());
        osObjectBuilder.addInteger(rFGApiContentButtonColumnInfo.colorIndex, Integer.valueOf(rFGApiContentButton.realmGet$color()));
        osObjectBuilder.addString(rFGApiContentButtonColumnInfo.analyticsIndex, rFGApiContentButton.realmGet$analytics());
        C2010xb5bcc025 newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGApiContentButton, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton copyOrUpdate(p041io.realm.Realm r8, p041io.realm.C2010xb5bcc025.RFGApiContentButtonColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentButton r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentButton> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton.class
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentButton r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.api.train.RFGApiContentButton r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.C2010xb5bcc025.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy$RFGApiContentButtonColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiContentButton, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiContentButton");
    }

    public static RFGApiContentButtonColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiContentButtonColumnInfo(osSchemaInfo);
    }

    public static RFGApiContentButton createDetachedCopy(RFGApiContentButton rFGApiContentButton, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiContentButton rFGApiContentButton2;
        if (i > i2 || rFGApiContentButton == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiContentButton);
        if (cacheData == null) {
            rFGApiContentButton2 = new RFGApiContentButton();
            map.put(rFGApiContentButton, new RealmObjectProxy.CacheData(i, rFGApiContentButton2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiContentButton) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiContentButton2 = (RFGApiContentButton) cacheData.object;
        }
        rFGApiContentButton2.realmSet$pKey(rFGApiContentButton.realmGet$pKey());
        rFGApiContentButton2.realmSet$label(rFGApiContentButton.realmGet$label());
        rFGApiContentButton2.realmSet$type(rFGApiContentButton.realmGet$type());
        rFGApiContentButton2.realmSet$value(rFGApiContentButton.realmGet$value());
        rFGApiContentButton2.realmSet$color(rFGApiContentButton.realmGet$color());
        rFGApiContentButton2.realmSet$analytics(rFGApiContentButton.realmGet$analytics());
        return rFGApiContentButton2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 6, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("pKey", RealmFieldType.STRING, true, true, true);
        builder2.addPersistedProperty(RFGAddMemberDialog.ARG_LABEL, RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("type", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("value", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("color", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("analytics", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton createOrUpdateUsingJsonObject(p041io.realm.Realm r13, org.json.JSONObject r14, boolean r15) throws org.json.JSONException {
        /*
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentButton> r0 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton.class
            java.util.List r1 = java.util.Collections.emptyList()
            java.lang.String r2 = "pKey"
            r3 = 0
            if (r15 == 0) goto L_0x005d
            io.realm.internal.Table r15 = r13.getTable(r0)
            io.realm.RealmSchema r4 = r13.getSchema()
            io.realm.internal.ColumnInfo r4 = r4.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r0)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy$RFGApiContentButtonColumnInfo r4 = (p041io.realm.C2010xb5bcc025.RFGApiContentButtonColumnInfo) r4
            long r4 = r4.pKeyIndex
            boolean r6 = r14.isNull(r2)
            r7 = -1
            if (r6 != 0) goto L_0x002c
            java.lang.String r6 = r14.getString(r2)
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy r15 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy     // Catch:{ all -> 0x0058 }
            r15.<init>()     // Catch:{ all -> 0x0058 }
            r6.clear()
            goto L_0x005e
        L_0x0058:
            r13 = move-exception
            r6.clear()
            throw r13
        L_0x005d:
            r15 = r3
        L_0x005e:
            if (r15 != 0) goto L_0x0086
            boolean r15 = r14.has(r2)
            if (r15 == 0) goto L_0x007e
            boolean r15 = r14.isNull(r2)
            r4 = 1
            if (r15 == 0) goto L_0x0072
            io.realm.RealmModel r13 = r13.createObjectInternal(r0, r3, r4, r1)
            goto L_0x007a
        L_0x0072:
            java.lang.String r15 = r14.getString(r2)
            io.realm.RealmModel r13 = r13.createObjectInternal(r0, r15, r4, r1)
        L_0x007a:
            r15 = r13
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentButtonRealmProxy r15 = (p041io.realm.C2010xb5bcc025) r15
            goto L_0x0086
        L_0x007e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "JSON object doesn't have the primary key field 'pKey'."
            r13.<init>(r14)
            throw r13
        L_0x0086:
            java.lang.String r13 = "label"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x009f
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x0098
            r15.realmSet$label(r3)
            goto L_0x009f
        L_0x0098:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$label(r13)
        L_0x009f:
            java.lang.String r13 = "type"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00bd
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00b5
            int r13 = r14.getInt(r13)
            r15.realmSet$type(r13)
            goto L_0x00bd
        L_0x00b5:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'type' to null."
            r13.<init>(r14)
            throw r13
        L_0x00bd:
            java.lang.String r13 = "value"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00d6
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x00cf
            r15.realmSet$value(r3)
            goto L_0x00d6
        L_0x00cf:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$value(r13)
        L_0x00d6:
            java.lang.String r13 = "color"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r14.isNull(r13)
            if (r0 != 0) goto L_0x00ec
            int r13 = r14.getInt(r13)
            r15.realmSet$color(r13)
            goto L_0x00f4
        L_0x00ec:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trying to set non-nullable field 'color' to null."
            r13.<init>(r14)
            throw r13
        L_0x00f4:
            java.lang.String r13 = "analytics"
            boolean r0 = r14.has(r13)
            if (r0 == 0) goto L_0x010d
            boolean r0 = r14.isNull(r13)
            if (r0 == 0) goto L_0x0106
            r15.realmSet$analytics(r3)
            goto L_0x010d
        L_0x0106:
            java.lang.String r13 = r14.getString(r13)
            r15.realmSet$analytics(r13)
        L_0x010d:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.C2010xb5bcc025.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiContentButton");
    }

    @TargetApi(11)
    public static RFGApiContentButton createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGApiContentButton rFGApiContentButton = new RFGApiContentButton();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("pKey")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentButton.realmSet$pKey(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentButton.realmSet$pKey((String) null);
                }
                z = true;
            } else if (nextName.equals(RFGAddMemberDialog.ARG_LABEL)) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentButton.realmSet$label(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentButton.realmSet$label((String) null);
                }
            } else if (nextName.equals("type")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentButton.realmSet$type(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'type' to null.");
                }
            } else if (nextName.equals("value")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentButton.realmSet$value(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentButton.realmSet$value((String) null);
                }
            } else if (nextName.equals("color")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentButton.realmSet$color(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'color' to null.");
                }
            } else if (!nextName.equals("analytics")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiContentButton.realmSet$analytics(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                rFGApiContentButton.realmSet$analytics((String) null);
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiContentButton) realm.copyToRealm(rFGApiContentButton, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pKey'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiContentButton rFGApiContentButton, Map<RealmModel, Long> map) {
        Class<RFGApiContentButton> cls = RFGApiContentButton.class;
        if (rFGApiContentButton instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentButton;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentButtonColumnInfo rFGApiContentButtonColumnInfo = (RFGApiContentButtonColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentButtonColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentButton.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentButton, Long.valueOf(j2));
        String realmGet$label = rFGApiContentButton.realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(nativePtr, rFGApiContentButtonColumnInfo.labelIndex, j2, realmGet$label, false);
        }
        Table.nativeSetLong(nativePtr, rFGApiContentButtonColumnInfo.typeIndex, j2, (long) rFGApiContentButton.realmGet$type(), false);
        String realmGet$value = rFGApiContentButton.realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(nativePtr, rFGApiContentButtonColumnInfo.valueIndex, j2, realmGet$value, false);
        }
        Table.nativeSetLong(nativePtr, rFGApiContentButtonColumnInfo.colorIndex, j2, (long) rFGApiContentButton.realmGet$color(), false);
        String realmGet$analytics = rFGApiContentButton.realmGet$analytics();
        if (realmGet$analytics != null) {
            Table.nativeSetString(nativePtr, rFGApiContentButtonColumnInfo.analyticsIndex, j2, realmGet$analytics, false);
        }
        return j2;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentButton> cls = RFGApiContentButton.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentButtonColumnInfo rFGApiContentButtonColumnInfo = (RFGApiContentButtonColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentButtonColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentButton rFGApiContentButton = (RFGApiContentButton) it.next();
            if (!map2.containsKey(rFGApiContentButton)) {
                if (rFGApiContentButton instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentButton;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentButton, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentButton.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j3, realmGet$pKey) : -1;
                if (nativeFindFirstString == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j3, realmGet$pKey);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
                    j = nativeFindFirstString;
                }
                map2.put(rFGApiContentButton, Long.valueOf(j));
                String realmGet$label = rFGApiContentButton.realmGet$label();
                if (realmGet$label != null) {
                    j2 = j3;
                    Table.nativeSetString(nativePtr, rFGApiContentButtonColumnInfo.labelIndex, j, realmGet$label, false);
                } else {
                    j2 = j3;
                }
                Table.nativeSetLong(nativePtr, rFGApiContentButtonColumnInfo.typeIndex, j, (long) rFGApiContentButton.realmGet$type(), false);
                String realmGet$value = rFGApiContentButton.realmGet$value();
                if (realmGet$value != null) {
                    Table.nativeSetString(nativePtr, rFGApiContentButtonColumnInfo.valueIndex, j, realmGet$value, false);
                }
                Table.nativeSetLong(nativePtr, rFGApiContentButtonColumnInfo.colorIndex, j, (long) rFGApiContentButton.realmGet$color(), false);
                String realmGet$analytics = rFGApiContentButton.realmGet$analytics();
                if (realmGet$analytics != null) {
                    Table.nativeSetString(nativePtr, rFGApiContentButtonColumnInfo.analyticsIndex, j, realmGet$analytics, false);
                }
                j3 = j2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiContentButton rFGApiContentButton, Map<RealmModel, Long> map) {
        Class<RFGApiContentButton> cls = RFGApiContentButton.class;
        if (rFGApiContentButton instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentButton;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentButtonColumnInfo rFGApiContentButtonColumnInfo = (RFGApiContentButtonColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j = rFGApiContentButtonColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentButton.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j, realmGet$pKey);
        }
        long j2 = nativeFindFirstString;
        map.put(rFGApiContentButton, Long.valueOf(j2));
        String realmGet$label = rFGApiContentButton.realmGet$label();
        long j3 = rFGApiContentButtonColumnInfo.labelIndex;
        if (realmGet$label != null) {
            Table.nativeSetString(nativePtr, j3, j2, realmGet$label, false);
        } else {
            Table.nativeSetNull(nativePtr, j3, j2, false);
        }
        Table.nativeSetLong(nativePtr, rFGApiContentButtonColumnInfo.typeIndex, j2, (long) rFGApiContentButton.realmGet$type(), false);
        String realmGet$value = rFGApiContentButton.realmGet$value();
        long j4 = rFGApiContentButtonColumnInfo.valueIndex;
        if (realmGet$value != null) {
            Table.nativeSetString(nativePtr, j4, j2, realmGet$value, false);
        } else {
            Table.nativeSetNull(nativePtr, j4, j2, false);
        }
        Table.nativeSetLong(nativePtr, rFGApiContentButtonColumnInfo.colorIndex, j2, (long) rFGApiContentButton.realmGet$color(), false);
        String realmGet$analytics = rFGApiContentButton.realmGet$analytics();
        long j5 = rFGApiContentButtonColumnInfo.analyticsIndex;
        if (realmGet$analytics != null) {
            Table.nativeSetString(nativePtr, j5, j2, realmGet$analytics, false);
        } else {
            Table.nativeSetNull(nativePtr, j5, j2, false);
        }
        return j2;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentButton> cls = RFGApiContentButton.class;
        Table table = realm.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentButtonColumnInfo rFGApiContentButtonColumnInfo = (RFGApiContentButtonColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGApiContentButtonColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentButton rFGApiContentButton = (RFGApiContentButton) it.next();
            if (!map2.containsKey(rFGApiContentButton)) {
                if (rFGApiContentButton instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentButton;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentButton, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentButton.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j2, realmGet$pKey) : -1;
                long createRowWithPrimaryKey = nativeFindFirstString == -1 ? OsObject.createRowWithPrimaryKey(table, j2, realmGet$pKey) : nativeFindFirstString;
                map2.put(rFGApiContentButton, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$label = rFGApiContentButton.realmGet$label();
                if (realmGet$label != null) {
                    j = j2;
                    Table.nativeSetString(nativePtr, rFGApiContentButtonColumnInfo.labelIndex, createRowWithPrimaryKey, realmGet$label, false);
                } else {
                    j = j2;
                    Table.nativeSetNull(nativePtr, rFGApiContentButtonColumnInfo.labelIndex, createRowWithPrimaryKey, false);
                }
                Table.nativeSetLong(nativePtr, rFGApiContentButtonColumnInfo.typeIndex, createRowWithPrimaryKey, (long) rFGApiContentButton.realmGet$type(), false);
                String realmGet$value = rFGApiContentButton.realmGet$value();
                long j3 = rFGApiContentButtonColumnInfo.valueIndex;
                if (realmGet$value != null) {
                    Table.nativeSetString(nativePtr, j3, createRowWithPrimaryKey, realmGet$value, false);
                } else {
                    Table.nativeSetNull(nativePtr, j3, createRowWithPrimaryKey, false);
                }
                Table.nativeSetLong(nativePtr, rFGApiContentButtonColumnInfo.colorIndex, createRowWithPrimaryKey, (long) rFGApiContentButton.realmGet$color(), false);
                String realmGet$analytics = rFGApiContentButton.realmGet$analytics();
                long j4 = rFGApiContentButtonColumnInfo.analyticsIndex;
                if (realmGet$analytics != null) {
                    Table.nativeSetString(nativePtr, j4, createRowWithPrimaryKey, realmGet$analytics, false);
                } else {
                    Table.nativeSetNull(nativePtr, j4, createRowWithPrimaryKey, false);
                }
                j2 = j;
            }
        }
    }

    private static C2010xb5bcc025 newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentButton.class), false, Collections.emptyList());
        C2010xb5bcc025 jp_reifrontier_gym_domain_api_train_rfgapicontentbuttonrealmproxy = new C2010xb5bcc025();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapicontentbuttonrealmproxy;
    }

    static RFGApiContentButton update(Realm realm, RFGApiContentButtonColumnInfo rFGApiContentButtonColumnInfo, RFGApiContentButton rFGApiContentButton, RFGApiContentButton rFGApiContentButton2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentButton.class), rFGApiContentButtonColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentButtonColumnInfo.pKeyIndex, rFGApiContentButton2.realmGet$pKey());
        osObjectBuilder.addString(rFGApiContentButtonColumnInfo.labelIndex, rFGApiContentButton2.realmGet$label());
        osObjectBuilder.addInteger(rFGApiContentButtonColumnInfo.typeIndex, Integer.valueOf(rFGApiContentButton2.realmGet$type()));
        osObjectBuilder.addString(rFGApiContentButtonColumnInfo.valueIndex, rFGApiContentButton2.realmGet$value());
        osObjectBuilder.addInteger(rFGApiContentButtonColumnInfo.colorIndex, Integer.valueOf(rFGApiContentButton2.realmGet$color()));
        osObjectBuilder.addString(rFGApiContentButtonColumnInfo.analyticsIndex, rFGApiContentButton2.realmGet$analytics());
        osObjectBuilder.updateExistingObject();
        return rFGApiContentButton;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2010xb5bcc025.class != obj.getClass()) {
            return false;
        }
        C2010xb5bcc025 jp_reifrontier_gym_domain_api_train_rfgapicontentbuttonrealmproxy = (C2010xb5bcc025) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapicontentbuttonrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapicontentbuttonrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapicontentbuttonrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiContentButtonColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiContentButton> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$analytics() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.analyticsIndex);
    }

    public int realmGet$color() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.colorIndex);
    }

    public String realmGet$label() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.labelIndex);
    }

    public String realmGet$pKey() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pKeyIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int realmGet$type() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.typeIndex);
    }

    public String realmGet$value() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.valueIndex);
    }

    public void realmSet$analytics(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.analyticsIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.analyticsIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.analyticsIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.analyticsIndex, row$realm.getIndex(), str, true);
            }
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

    public void realmSet$label(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.labelIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.labelIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.labelIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.labelIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public void realmSet$pKey(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'pKey' cannot be changed after object was created.");
        }
    }

    public void realmSet$type(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.typeIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.typeIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$value(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.valueIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.valueIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.valueIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.valueIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGApiContentButton = proxy[", "{pKey:");
        b.append(realmGet$pKey());
        b.append("}");
        b.append(",");
        b.append("{label:");
        String str = "null";
        C0681a.m335a(b, realmGet$label() != null ? realmGet$label() : str, "}", ",", "{type:");
        b.append(realmGet$type());
        b.append("}");
        b.append(",");
        b.append("{value:");
        C0681a.m335a(b, realmGet$value() != null ? realmGet$value() : str, "}", ",", "{color:");
        b.append(realmGet$color());
        b.append("}");
        b.append(",");
        b.append("{analytics:");
        if (realmGet$analytics() != null) {
            str = realmGet$analytics();
        }
        b.append(str);
        b.append("}");
        b.append("]");
        return b.toString();
    }
}
