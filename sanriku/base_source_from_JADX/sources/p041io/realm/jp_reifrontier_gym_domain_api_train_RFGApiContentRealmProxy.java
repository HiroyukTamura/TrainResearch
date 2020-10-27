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
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContent;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy */
public class jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy extends RFGApiContent implements RealmObjectProxy, C1008xe5813026 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiContentColumnInfo columnInfo;
    private RealmList<RFGApiContentItem> contentsRealmList;
    private ProxyState<RFGApiContent> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiContent";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy$RFGApiContentColumnInfo */
    static final class RFGApiContentColumnInfo extends ColumnInfo {
        long contentsIndex;
        long dateIndex;
        long idIndex;
        long maxColumnIndexValue;
        long spotTypeIndex;
        long stationIdIndex;
        long titleIndex;
        long updateAtIndex;

        RFGApiContentColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiContentColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.stationIdIndex = addColumnDetails("stationId", "stationId", objectSchemaInfo);
            this.contentsIndex = addColumnDetails("contents", "contents", objectSchemaInfo);
            this.spotTypeIndex = addColumnDetails("spotType", "spotType", objectSchemaInfo);
            this.updateAtIndex = addColumnDetails("updateAt", "updateAt", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiContentColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiContentColumnInfo rFGApiContentColumnInfo = (RFGApiContentColumnInfo) columnInfo;
            RFGApiContentColumnInfo rFGApiContentColumnInfo2 = (RFGApiContentColumnInfo) columnInfo2;
            rFGApiContentColumnInfo2.idIndex = rFGApiContentColumnInfo.idIndex;
            rFGApiContentColumnInfo2.dateIndex = rFGApiContentColumnInfo.dateIndex;
            rFGApiContentColumnInfo2.titleIndex = rFGApiContentColumnInfo.titleIndex;
            rFGApiContentColumnInfo2.stationIdIndex = rFGApiContentColumnInfo.stationIdIndex;
            rFGApiContentColumnInfo2.contentsIndex = rFGApiContentColumnInfo.contentsIndex;
            rFGApiContentColumnInfo2.spotTypeIndex = rFGApiContentColumnInfo.spotTypeIndex;
            rFGApiContentColumnInfo2.updateAtIndex = rFGApiContentColumnInfo.updateAtIndex;
            rFGApiContentColumnInfo2.maxColumnIndexValue = rFGApiContentColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiContent copy(Realm realm, RFGApiContentColumnInfo rFGApiContentColumnInfo, RFGApiContent rFGApiContent, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RealmObjectProxy realmObjectProxy = map.get(rFGApiContent);
        if (realmObjectProxy != null) {
            return (RFGApiContent) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContent.class), rFGApiContentColumnInfo.maxColumnIndexValue, set);
        osObjectBuilder.addInteger(rFGApiContentColumnInfo.idIndex, Integer.valueOf(rFGApiContent.realmGet$id()));
        osObjectBuilder.addInteger(rFGApiContentColumnInfo.dateIndex, Integer.valueOf(rFGApiContent.realmGet$date()));
        osObjectBuilder.addString(rFGApiContentColumnInfo.titleIndex, rFGApiContent.realmGet$title());
        osObjectBuilder.addInteger(rFGApiContentColumnInfo.stationIdIndex, rFGApiContent.realmGet$stationId());
        osObjectBuilder.addInteger(rFGApiContentColumnInfo.spotTypeIndex, Integer.valueOf(rFGApiContent.realmGet$spotType()));
        osObjectBuilder.addInteger(rFGApiContentColumnInfo.updateAtIndex, Integer.valueOf(rFGApiContent.realmGet$updateAt()));
        jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map.put(rFGApiContent, newProxyInstance);
        RealmList<RFGApiContentItem> realmGet$contents = rFGApiContent.realmGet$contents();
        if (realmGet$contents != null) {
            RealmList<RFGApiContentItem> realmGet$contents2 = newProxyInstance.realmGet$contents();
            realmGet$contents2.clear();
            for (int i = 0; i < realmGet$contents.size(); i++) {
                RFGApiContentItem rFGApiContentItem = realmGet$contents.get(i);
                RFGApiContentItem rFGApiContentItem2 = (RFGApiContentItem) map.get(rFGApiContentItem);
                if (rFGApiContentItem2 == null) {
                    rFGApiContentItem2 = jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.RFGApiContentItemColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentItem.class), rFGApiContentItem, z, map, set);
                }
                realmGet$contents2.add(rFGApiContentItem2);
            }
        }
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContent copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.RFGApiContentColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiContent r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiContent r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContent) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0087
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContent> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiContent.class
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy     // Catch:{ all -> 0x0082 }
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
            jp.reifrontier.gym.domain.api.train.RFGApiContent r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0099
        L_0x0095:
            jp.reifrontier.gym.domain.api.train.RFGApiContent r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0099:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy$RFGApiContentColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiContent, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiContent");
    }

    public static RFGApiContentColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiContentColumnInfo(osSchemaInfo);
    }

    public static RFGApiContent createDetachedCopy(RFGApiContent rFGApiContent, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiContent rFGApiContent2;
        if (i > i2 || rFGApiContent == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiContent);
        if (cacheData == null) {
            rFGApiContent2 = new RFGApiContent();
            map.put(rFGApiContent, new RealmObjectProxy.CacheData(i, rFGApiContent2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiContent) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiContent2 = (RFGApiContent) cacheData.object;
        }
        rFGApiContent2.realmSet$id(rFGApiContent.realmGet$id());
        rFGApiContent2.realmSet$date(rFGApiContent.realmGet$date());
        rFGApiContent2.realmSet$title(rFGApiContent.realmGet$title());
        rFGApiContent2.realmSet$stationId(rFGApiContent.realmGet$stationId());
        if (i == i2) {
            rFGApiContent2.realmSet$contents((RealmList<RFGApiContentItem>) null);
        } else {
            RealmList<RFGApiContentItem> realmGet$contents = rFGApiContent.realmGet$contents();
            RealmList realmList = new RealmList();
            rFGApiContent2.realmSet$contents(realmList);
            int i3 = i + 1;
            int size = realmGet$contents.size();
            for (int i4 = 0; i4 < size; i4++) {
                realmList.add(jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.createDetachedCopy(realmGet$contents.get(i4), i3, i2, map));
            }
        }
        rFGApiContent2.realmSet$spotType(rFGApiContent.realmGet$spotType());
        rFGApiContent2.realmSet$updateAt(rFGApiContent.realmGet$updateAt());
        return rFGApiContent2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 7, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("id", RealmFieldType.INTEGER, true, true, true);
        builder2.addPersistedProperty("date", RealmFieldType.INTEGER, false, false, true);
        builder2.addPersistedProperty("title", RealmFieldType.STRING, false, false, false);
        builder2.addPersistedProperty("stationId", RealmFieldType.INTEGER, false, false, false);
        builder.addPersistedLinkProperty("contents", RealmFieldType.LIST, jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        OsObjectSchemaInfo.Builder builder3 = builder;
        builder3.addPersistedProperty("spotType", RealmFieldType.INTEGER, false, false, true);
        builder3.addPersistedProperty("updateAt", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContent createOrUpdateUsingJsonObject(p041io.realm.Realm r16, org.json.JSONObject r17, boolean r18) throws org.json.JSONException {
        /*
            r0 = r16
            r7 = r17
            r8 = r18
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContent> r9 = p043jp.reifrontier.gym.domain.api.train.RFGApiContent.class
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 1
            r10.<init>(r11)
            java.lang.String r12 = "id"
            r13 = 0
            if (r8 == 0) goto L_0x0067
            io.realm.internal.Table r1 = r0.getTable(r9)
            io.realm.RealmSchema r2 = r16.getSchema()
            io.realm.internal.ColumnInfo r2 = r2.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r9)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy$RFGApiContentColumnInfo r2 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.RFGApiContentColumnInfo) r2
            long r2 = r2.idIndex
            boolean r4 = r7.isNull(r12)
            r5 = -1
            if (r4 != 0) goto L_0x0034
            long r14 = r7.getLong(r12)
            long r2 = r1.findFirstLong(r2, r14)
            goto L_0x0035
        L_0x0034:
            r2 = r5
        L_0x0035:
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0067
            io.realm.BaseRealm$ThreadLocalRealmObjectContext r4 = p041io.realm.BaseRealm.objectContext
            java.lang.Object r4 = r4.get()
            r14 = r4
            io.realm.BaseRealm$RealmObjectContext r14 = (p041io.realm.BaseRealm.RealmObjectContext) r14
            io.realm.internal.UncheckedRow r3 = r1.getUncheckedRow(r2)     // Catch:{ all -> 0x0062 }
            io.realm.RealmSchema r1 = r16.getSchema()     // Catch:{ all -> 0x0062 }
            io.realm.internal.ColumnInfo r4 = r1.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r9)     // Catch:{ all -> 0x0062 }
            r5 = 0
            java.util.List r6 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0062 }
            r1 = r14
            r2 = r16
            r1.set(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0062 }
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy     // Catch:{ all -> 0x0062 }
            r1.<init>()     // Catch:{ all -> 0x0062 }
            r14.clear()
            goto L_0x0068
        L_0x0062:
            r0 = move-exception
            r14.clear()
            throw r0
        L_0x0067:
            r1 = r13
        L_0x0068:
            java.lang.String r2 = "contents"
            if (r1 != 0) goto L_0x009d
            boolean r1 = r7.has(r2)
            if (r1 == 0) goto L_0x0075
            r10.add(r2)
        L_0x0075:
            boolean r1 = r7.has(r12)
            if (r1 == 0) goto L_0x0095
            boolean r1 = r7.isNull(r12)
            if (r1 == 0) goto L_0x0086
            io.realm.RealmModel r1 = r0.createObjectInternal(r9, r13, r11, r10)
            goto L_0x0092
        L_0x0086:
            int r1 = r7.getInt(r12)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            io.realm.RealmModel r1 = r0.createObjectInternal(r9, r1, r11, r10)
        L_0x0092:
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy r1 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy) r1
            goto L_0x009d
        L_0x0095:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "JSON object doesn't have the primary key field 'id'."
            r0.<init>(r1)
            throw r0
        L_0x009d:
            java.lang.String r3 = "date"
            boolean r4 = r7.has(r3)
            if (r4 == 0) goto L_0x00bb
            boolean r4 = r7.isNull(r3)
            if (r4 != 0) goto L_0x00b3
            int r3 = r7.getInt(r3)
            r1.realmSet$date(r3)
            goto L_0x00bb
        L_0x00b3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Trying to set non-nullable field 'date' to null."
            r0.<init>(r1)
            throw r0
        L_0x00bb:
            java.lang.String r3 = "title"
            boolean r4 = r7.has(r3)
            if (r4 == 0) goto L_0x00d4
            boolean r4 = r7.isNull(r3)
            if (r4 == 0) goto L_0x00cd
            r1.realmSet$title(r13)
            goto L_0x00d4
        L_0x00cd:
            java.lang.String r3 = r7.getString(r3)
            r1.realmSet$title(r3)
        L_0x00d4:
            java.lang.String r3 = "stationId"
            boolean r4 = r7.has(r3)
            if (r4 == 0) goto L_0x00f1
            boolean r4 = r7.isNull(r3)
            if (r4 == 0) goto L_0x00e6
            r1.realmSet$stationId(r13)
            goto L_0x00f1
        L_0x00e6:
            int r3 = r7.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.realmSet$stationId(r3)
        L_0x00f1:
            boolean r3 = r7.has(r2)
            if (r3 == 0) goto L_0x0125
            boolean r3 = r7.isNull(r2)
            if (r3 == 0) goto L_0x0101
            r1.realmSet$contents(r13)
            goto L_0x0125
        L_0x0101:
            io.realm.RealmList r3 = r1.realmGet$contents()
            r3.clear()
            org.json.JSONArray r2 = r7.getJSONArray(r2)
            r3 = 0
        L_0x010d:
            int r4 = r2.length()
            if (r3 >= r4) goto L_0x0125
            org.json.JSONObject r4 = r2.getJSONObject(r3)
            jp.reifrontier.gym.domain.api.train.RFGApiContentItem r4 = p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.createOrUpdateUsingJsonObject(r0, r4, r8)
            io.realm.RealmList r5 = r1.realmGet$contents()
            r5.add(r4)
            int r3 = r3 + 1
            goto L_0x010d
        L_0x0125:
            java.lang.String r0 = "spotType"
            boolean r2 = r7.has(r0)
            if (r2 == 0) goto L_0x0143
            boolean r2 = r7.isNull(r0)
            if (r2 != 0) goto L_0x013b
            int r0 = r7.getInt(r0)
            r1.realmSet$spotType(r0)
            goto L_0x0143
        L_0x013b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Trying to set non-nullable field 'spotType' to null."
            r0.<init>(r1)
            throw r0
        L_0x0143:
            java.lang.String r0 = "updateAt"
            boolean r2 = r7.has(r0)
            if (r2 == 0) goto L_0x0161
            boolean r2 = r7.isNull(r0)
            if (r2 != 0) goto L_0x0159
            int r0 = r7.getInt(r0)
            r1.realmSet$updateAt(r0)
            goto L_0x0161
        L_0x0159:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Trying to set non-nullable field 'updateAt' to null."
            r0.<init>(r1)
            throw r0
        L_0x0161:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiContent");
    }

    @TargetApi(11)
    public static RFGApiContent createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGApiContent rFGApiContent = new RFGApiContent();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("id")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContent.realmSet$id(jsonReader.nextInt());
                    z = true;
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'id' to null.");
                }
            } else if (nextName.equals("date")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContent.realmSet$date(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'date' to null.");
                }
            } else if (nextName.equals("title")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContent.realmSet$title(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContent.realmSet$title((String) null);
                }
            } else if (nextName.equals("stationId")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContent.realmSet$stationId(Integer.valueOf(jsonReader.nextInt()));
                } else {
                    jsonReader.skipValue();
                    rFGApiContent.realmSet$stationId((Integer) null);
                }
            } else if (nextName.equals("contents")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGApiContent.realmSet$contents((RealmList<RFGApiContentItem>) null);
                } else {
                    rFGApiContent.realmSet$contents(new RealmList());
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        rFGApiContent.realmGet$contents().add(jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.createUsingJsonStream(realm, jsonReader));
                    }
                    jsonReader.endArray();
                }
            } else if (nextName.equals("spotType")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContent.realmSet$spotType(jsonReader.nextInt());
                } else {
                    throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'spotType' to null.");
                }
            } else if (!nextName.equals("updateAt")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiContent.realmSet$updateAt(jsonReader.nextInt());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'updateAt' to null.");
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiContent) realm.copyToRealm(rFGApiContent, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiContent rFGApiContent, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Realm realm2 = realm;
        RFGApiContent rFGApiContent2 = rFGApiContent;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContent> cls = RFGApiContent.class;
        if (rFGApiContent2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContent2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentColumnInfo rFGApiContentColumnInfo = (RFGApiContentColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentColumnInfo.idIndex;
        Integer valueOf = Integer.valueOf(rFGApiContent.realmGet$id());
        if (valueOf != null) {
            j = Table.nativeFindFirstInt(nativePtr, j3, (long) rFGApiContent.realmGet$id());
        } else {
            j = -1;
        }
        if (j == -1) {
            j = OsObject.createRowWithPrimaryKey(table, j3, Integer.valueOf(rFGApiContent.realmGet$id()));
        } else {
            Table.throwDuplicatePrimaryKeyException(valueOf);
        }
        long j4 = j;
        map2.put(rFGApiContent2, Long.valueOf(j4));
        long j5 = j4;
        Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.dateIndex, j4, (long) rFGApiContent.realmGet$date(), false);
        String realmGet$title = rFGApiContent.realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(nativePtr, rFGApiContentColumnInfo.titleIndex, j5, realmGet$title, false);
        }
        Integer realmGet$stationId = rFGApiContent.realmGet$stationId();
        if (realmGet$stationId != null) {
            Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.stationIdIndex, j5, realmGet$stationId.longValue(), false);
        }
        RealmList<RFGApiContentItem> realmGet$contents = rFGApiContent.realmGet$contents();
        if (realmGet$contents != null) {
            j2 = j5;
            OsList osList = new OsList(table.getUncheckedRow(j2), rFGApiContentColumnInfo.contentsIndex);
            Iterator<RFGApiContentItem> it = realmGet$contents.iterator();
            while (it.hasNext()) {
                RFGApiContentItem next = it.next();
                Long l = map2.get(next);
                if (l == null) {
                    l = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insert(realm2, next, map2));
                }
                osList.addRow(l.longValue());
            }
        } else {
            j2 = j5;
        }
        long j6 = nativePtr;
        long j7 = j2;
        Table.nativeSetLong(j6, rFGApiContentColumnInfo.spotTypeIndex, j2, (long) rFGApiContent.realmGet$spotType(), false);
        Table.nativeSetLong(j6, rFGApiContentColumnInfo.updateAtIndex, j7, (long) rFGApiContent.realmGet$updateAt(), false);
        return j7;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContent> cls = RFGApiContent.class;
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentColumnInfo rFGApiContentColumnInfo = (RFGApiContentColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentColumnInfo.idIndex;
        while (it.hasNext()) {
            RFGApiContent rFGApiContent = (RFGApiContent) it.next();
            if (!map2.containsKey(rFGApiContent)) {
                if (rFGApiContent instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContent;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContent, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                Integer valueOf = Integer.valueOf(rFGApiContent.realmGet$id());
                if (valueOf != null) {
                    j = Table.nativeFindFirstInt(nativePtr, j3, (long) rFGApiContent.realmGet$id());
                } else {
                    j = -1;
                }
                if (j == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j3, Integer.valueOf(rFGApiContent.realmGet$id()));
                } else {
                    Table.throwDuplicatePrimaryKeyException(valueOf);
                }
                long j4 = j;
                map2.put(rFGApiContent, Long.valueOf(j4));
                long j5 = j4;
                long j6 = j3;
                Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.dateIndex, j4, (long) rFGApiContent.realmGet$date(), false);
                String realmGet$title = rFGApiContent.realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(nativePtr, rFGApiContentColumnInfo.titleIndex, j5, realmGet$title, false);
                }
                Integer realmGet$stationId = rFGApiContent.realmGet$stationId();
                if (realmGet$stationId != null) {
                    Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.stationIdIndex, j5, realmGet$stationId.longValue(), false);
                }
                RealmList<RFGApiContentItem> realmGet$contents = rFGApiContent.realmGet$contents();
                if (realmGet$contents != null) {
                    j2 = j5;
                    OsList osList = new OsList(table.getUncheckedRow(j2), rFGApiContentColumnInfo.contentsIndex);
                    Iterator<RFGApiContentItem> it2 = realmGet$contents.iterator();
                    while (it2.hasNext()) {
                        RFGApiContentItem next = it2.next();
                        Long l = map2.get(next);
                        if (l == null) {
                            l = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insert(realm2, next, map2));
                        }
                        osList.addRow(l.longValue());
                    }
                } else {
                    j2 = j5;
                }
                Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.spotTypeIndex, j2, (long) rFGApiContent.realmGet$spotType(), false);
                Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.updateAtIndex, j2, (long) rFGApiContent.realmGet$updateAt(), false);
                j3 = j6;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiContent rFGApiContent, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Realm realm2 = realm;
        RFGApiContent rFGApiContent2 = rFGApiContent;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContent> cls = RFGApiContent.class;
        if (rFGApiContent2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContent2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentColumnInfo rFGApiContentColumnInfo = (RFGApiContentColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentColumnInfo.idIndex;
        if (Integer.valueOf(rFGApiContent.realmGet$id()) != null) {
            j = Table.nativeFindFirstInt(nativePtr, j3, (long) rFGApiContent.realmGet$id());
        } else {
            j = -1;
        }
        if (j == -1) {
            j = OsObject.createRowWithPrimaryKey(table, j3, Integer.valueOf(rFGApiContent.realmGet$id()));
        }
        long j4 = j;
        map2.put(rFGApiContent2, Long.valueOf(j4));
        long j5 = j4;
        Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.dateIndex, j4, (long) rFGApiContent.realmGet$date(), false);
        String realmGet$title = rFGApiContent.realmGet$title();
        long j6 = rFGApiContentColumnInfo.titleIndex;
        if (realmGet$title != null) {
            Table.nativeSetString(nativePtr, j6, j5, realmGet$title, false);
        } else {
            Table.nativeSetNull(nativePtr, j6, j5, false);
        }
        Integer realmGet$stationId = rFGApiContent.realmGet$stationId();
        long j7 = rFGApiContentColumnInfo.stationIdIndex;
        if (realmGet$stationId != null) {
            Table.nativeSetLong(nativePtr, j7, j5, realmGet$stationId.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, j7, j5, false);
        }
        long j8 = j5;
        OsList osList = new OsList(table.getUncheckedRow(j8), rFGApiContentColumnInfo.contentsIndex);
        RealmList<RFGApiContentItem> realmGet$contents = rFGApiContent.realmGet$contents();
        if (realmGet$contents == null || ((long) realmGet$contents.size()) != osList.size()) {
            j2 = j8;
            osList.removeAll();
            if (realmGet$contents != null) {
                Iterator<RFGApiContentItem> it = realmGet$contents.iterator();
                while (it.hasNext()) {
                    RFGApiContentItem next = it.next();
                    Long l = map2.get(next);
                    if (l == null) {
                        l = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insertOrUpdate(realm2, next, map2));
                    }
                    osList.addRow(l.longValue());
                }
            }
        } else {
            int size = realmGet$contents.size();
            int i = 0;
            while (i < size) {
                RFGApiContentItem rFGApiContentItem = realmGet$contents.get(i);
                Long l2 = map2.get(rFGApiContentItem);
                if (l2 == null) {
                    l2 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insertOrUpdate(realm2, rFGApiContentItem, map2));
                }
                osList.setRow((long) i, l2.longValue());
                i++;
                j8 = j8;
            }
            j2 = j8;
        }
        long j9 = nativePtr;
        long j10 = j2;
        Table.nativeSetLong(j9, rFGApiContentColumnInfo.spotTypeIndex, j2, (long) rFGApiContent.realmGet$spotType(), false);
        Table.nativeSetLong(j9, rFGApiContentColumnInfo.updateAtIndex, j10, (long) rFGApiContent.realmGet$updateAt(), false);
        return j10;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContent> cls = RFGApiContent.class;
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentColumnInfo rFGApiContentColumnInfo = (RFGApiContentColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGApiContentColumnInfo.idIndex;
        while (it.hasNext()) {
            RFGApiContent rFGApiContent = (RFGApiContent) it.next();
            if (!map2.containsKey(rFGApiContent)) {
                if (rFGApiContent instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContent;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContent, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                if (Integer.valueOf(rFGApiContent.realmGet$id()) != null) {
                    j = Table.nativeFindFirstInt(nativePtr, j3, (long) rFGApiContent.realmGet$id());
                } else {
                    j = -1;
                }
                if (j == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j3, Integer.valueOf(rFGApiContent.realmGet$id()));
                }
                long j4 = j;
                map2.put(rFGApiContent, Long.valueOf(j4));
                long j5 = j4;
                long j6 = j3;
                Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.dateIndex, j4, (long) rFGApiContent.realmGet$date(), false);
                String realmGet$title = rFGApiContent.realmGet$title();
                long j7 = rFGApiContentColumnInfo.titleIndex;
                if (realmGet$title != null) {
                    Table.nativeSetString(nativePtr, j7, j5, realmGet$title, false);
                } else {
                    Table.nativeSetNull(nativePtr, j7, j5, false);
                }
                Integer realmGet$stationId = rFGApiContent.realmGet$stationId();
                long j8 = rFGApiContentColumnInfo.stationIdIndex;
                if (realmGet$stationId != null) {
                    Table.nativeSetLong(nativePtr, j8, j5, realmGet$stationId.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, j8, j5, false);
                }
                long j9 = j5;
                OsList osList = new OsList(table.getUncheckedRow(j9), rFGApiContentColumnInfo.contentsIndex);
                RealmList<RFGApiContentItem> realmGet$contents = rFGApiContent.realmGet$contents();
                if (realmGet$contents == null || ((long) realmGet$contents.size()) != osList.size()) {
                    j2 = j9;
                    osList.removeAll();
                    if (realmGet$contents != null) {
                        Iterator<RFGApiContentItem> it2 = realmGet$contents.iterator();
                        while (it2.hasNext()) {
                            RFGApiContentItem next = it2.next();
                            Long l = map2.get(next);
                            if (l == null) {
                                l = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insertOrUpdate(realm2, next, map2));
                            }
                            osList.addRow(l.longValue());
                        }
                    }
                } else {
                    int size = realmGet$contents.size();
                    int i = 0;
                    while (i < size) {
                        RFGApiContentItem rFGApiContentItem = realmGet$contents.get(i);
                        Long l2 = map2.get(rFGApiContentItem);
                        if (l2 == null) {
                            l2 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insertOrUpdate(realm2, rFGApiContentItem, map2));
                        }
                        osList.setRow((long) i, l2.longValue());
                        i++;
                        j9 = j9;
                    }
                    j2 = j9;
                }
                Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.spotTypeIndex, j2, (long) rFGApiContent.realmGet$spotType(), false);
                Table.nativeSetLong(nativePtr, rFGApiContentColumnInfo.updateAtIndex, j2, (long) rFGApiContent.realmGet$updateAt(), false);
                j3 = j6;
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContent.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentrealmproxy = new jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapicontentrealmproxy;
    }

    static RFGApiContent update(Realm realm, RFGApiContentColumnInfo rFGApiContentColumnInfo, RFGApiContent rFGApiContent, RFGApiContent rFGApiContent2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RFGApiContentColumnInfo rFGApiContentColumnInfo2 = rFGApiContentColumnInfo;
        Realm realm2 = realm;
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContent.class), rFGApiContentColumnInfo2.maxColumnIndexValue, set);
        osObjectBuilder.addInteger(rFGApiContentColumnInfo2.idIndex, Integer.valueOf(rFGApiContent2.realmGet$id()));
        osObjectBuilder.addInteger(rFGApiContentColumnInfo2.dateIndex, Integer.valueOf(rFGApiContent2.realmGet$date()));
        osObjectBuilder.addString(rFGApiContentColumnInfo2.titleIndex, rFGApiContent2.realmGet$title());
        osObjectBuilder.addInteger(rFGApiContentColumnInfo2.stationIdIndex, rFGApiContent2.realmGet$stationId());
        RealmList<RFGApiContentItem> realmGet$contents = rFGApiContent2.realmGet$contents();
        if (realmGet$contents != null) {
            RealmList realmList = new RealmList();
            for (int i = 0; i < realmGet$contents.size(); i++) {
                RFGApiContentItem rFGApiContentItem = realmGet$contents.get(i);
                RFGApiContentItem rFGApiContentItem2 = (RFGApiContentItem) map.get(rFGApiContentItem);
                if (rFGApiContentItem2 == null) {
                    rFGApiContentItem2 = jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.RFGApiContentItemColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentItem.class), rFGApiContentItem, true, map, set);
                }
                realmList.add(rFGApiContentItem2);
            }
            osObjectBuilder.addObjectList(rFGApiContentColumnInfo2.contentsIndex, realmList);
        } else {
            osObjectBuilder.addObjectList(rFGApiContentColumnInfo2.contentsIndex, new RealmList());
        }
        osObjectBuilder.addInteger(rFGApiContentColumnInfo2.spotTypeIndex, Integer.valueOf(rFGApiContent2.realmGet$spotType()));
        osObjectBuilder.addInteger(rFGApiContentColumnInfo2.updateAtIndex, Integer.valueOf(rFGApiContent2.realmGet$updateAt()));
        osObjectBuilder.updateExistingObject();
        return rFGApiContent;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentrealmproxy = (jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapicontentrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapicontentrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapicontentrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiContentColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiContent> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public RealmList<RFGApiContentItem> realmGet$contents() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGApiContentItem> realmList = this.contentsRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGApiContentItem> realmList2 = new RealmList<>(RFGApiContentItem.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.contentsIndex), this.proxyState.getRealm$realm());
        this.contentsRealmList = realmList2;
        return realmList2;
    }

    public int realmGet$date() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.dateIndex);
    }

    public int realmGet$id() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.idIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int realmGet$spotType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.spotTypeIndex);
    }

    public Integer realmGet$stationId() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.stationIdIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.stationIdIndex));
    }

    public String realmGet$title() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.titleIndex);
    }

    public int realmGet$updateAt() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.updateAtIndex);
    }

    public void realmSet$contents(RealmList<RFGApiContentItem> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("contents")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGApiContentItem> realmList2 = new RealmList<>();
                Iterator<RFGApiContentItem> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGApiContentItem) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.contentsIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGApiContentItem rFGApiContentItem = realmList.get(i);
                    this.proxyState.checkValidObject(rFGApiContentItem);
                    modelList.addRow(((RealmObjectProxy) rFGApiContentItem).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGApiContentItem rFGApiContentItem2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGApiContentItem2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGApiContentItem2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
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

    public void realmSet$spotType(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.spotTypeIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.spotTypeIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public void realmSet$stationId(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            Row row$realm = this.proxyState.getRow$realm();
            long j = this.columnInfo.stationIdIndex;
            if (num == null) {
                row$realm.setNull(j);
            } else {
                row$realm.setLong(j, (long) num.intValue());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm2 = this.proxyState.getRow$realm();
            if (num == null) {
                row$realm2.getTable().setNull(this.columnInfo.stationIdIndex, row$realm2.getIndex(), true);
            } else {
                row$realm2.getTable().setLong(this.columnInfo.stationIdIndex, row$realm2.getIndex(), (long) num.intValue(), true);
            }
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
        StringBuilder b = C0681a.m339b("RFGApiContent = proxy[", "{id:");
        b.append(realmGet$id());
        b.append("}");
        b.append(",");
        b.append("{date:");
        b.append(realmGet$date());
        b.append("}");
        b.append(",");
        b.append("{title:");
        Object obj = "null";
        C0681a.m335a(b, realmGet$title() != null ? realmGet$title() : obj, "}", ",", "{stationId:");
        Object obj2 = obj;
        if (realmGet$stationId() != null) {
            obj2 = realmGet$stationId();
        }
        b.append(obj2);
        b.append("}");
        b.append(",");
        b.append("{contents:");
        b.append("RealmList<RFGApiContentItem>[");
        b.append(realmGet$contents().size());
        b.append("]");
        b.append("}");
        b.append(",");
        b.append("{spotType:");
        b.append(realmGet$spotType());
        b.append("}");
        b.append(",");
        b.append("{updateAt:");
        b.append(realmGet$updateAt());
        b.append("}");
        b.append("]");
        return b.toString();
    }
}
