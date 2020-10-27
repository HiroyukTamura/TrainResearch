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
import p041io.realm.C2009x9093b7d7;
import p041io.realm.C2010xb5bcc025;
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
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy */
public class jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy extends RFGApiContentItem implements RealmObjectProxy, C1006xbf250013 {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGApiContentItemColumnInfo columnInfo;
    private RealmList<RFGApiContentInfo> infoListRealmList;
    private ProxyState<RFGApiContentItem> proxyState;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGApiContentItem";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy$RFGApiContentItemColumnInfo */
    static final class RFGApiContentItemColumnInfo extends ColumnInfo {
        long accessIndex;
        long buttonIndex;
        long imageIndex;
        long infoListIndex;
        long maxColumnIndexValue;
        long noteIndex;
        long orderIndex;
        long pKeyIndex;
        long titleIndex;

        RFGApiContentItemColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGApiContentItemColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.pKeyIndex = addColumnDetails("pKey", "pKey", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.noteIndex = addColumnDetails("note", "note", objectSchemaInfo);
            this.imageIndex = addColumnDetails("image", "image", objectSchemaInfo);
            this.accessIndex = addColumnDetails("access", "access", objectSchemaInfo);
            this.infoListIndex = addColumnDetails("infoList", "infoList", objectSchemaInfo);
            this.buttonIndex = addColumnDetails("button", "button", objectSchemaInfo);
            this.orderIndex = addColumnDetails("order", "order", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGApiContentItemColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo = (RFGApiContentItemColumnInfo) columnInfo;
            RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo2 = (RFGApiContentItemColumnInfo) columnInfo2;
            rFGApiContentItemColumnInfo2.pKeyIndex = rFGApiContentItemColumnInfo.pKeyIndex;
            rFGApiContentItemColumnInfo2.titleIndex = rFGApiContentItemColumnInfo.titleIndex;
            rFGApiContentItemColumnInfo2.noteIndex = rFGApiContentItemColumnInfo.noteIndex;
            rFGApiContentItemColumnInfo2.imageIndex = rFGApiContentItemColumnInfo.imageIndex;
            rFGApiContentItemColumnInfo2.accessIndex = rFGApiContentItemColumnInfo.accessIndex;
            rFGApiContentItemColumnInfo2.infoListIndex = rFGApiContentItemColumnInfo.infoListIndex;
            rFGApiContentItemColumnInfo2.buttonIndex = rFGApiContentItemColumnInfo.buttonIndex;
            rFGApiContentItemColumnInfo2.orderIndex = rFGApiContentItemColumnInfo.orderIndex;
            rFGApiContentItemColumnInfo2.maxColumnIndexValue = rFGApiContentItemColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGApiContentItem copy(Realm realm, RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo, RFGApiContentItem rFGApiContentItem, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        Realm realm2 = realm;
        RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo2 = rFGApiContentItemColumnInfo;
        RFGApiContentItem rFGApiContentItem2 = rFGApiContentItem;
        Map<RealmModel, RealmObjectProxy> map2 = map;
        RealmObjectProxy realmObjectProxy = map2.get(rFGApiContentItem2);
        if (realmObjectProxy != null) {
            return (RFGApiContentItem) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentItem.class), rFGApiContentItemColumnInfo2.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentItemColumnInfo2.pKeyIndex, rFGApiContentItem.realmGet$pKey());
        osObjectBuilder.addInteger(rFGApiContentItemColumnInfo2.orderIndex, Integer.valueOf(rFGApiContentItem.realmGet$order()));
        jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy newProxyInstance = newProxyInstance(realm, osObjectBuilder.createNewObject());
        map2.put(rFGApiContentItem2, newProxyInstance);
        RFGApiContentTitle realmGet$title = rFGApiContentItem.realmGet$title();
        if (realmGet$title == null) {
            newProxyInstance.realmSet$title((RFGApiContentTitle) null);
        } else {
            RFGApiContentTitle rFGApiContentTitle = (RFGApiContentTitle) map2.get(realmGet$title);
            if (rFGApiContentTitle == null) {
                rFGApiContentTitle = jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.RFGApiContentTitleColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentTitle.class), realmGet$title, z, map, set);
            }
            newProxyInstance.realmSet$title(rFGApiContentTitle);
        }
        RFGApiContentNote realmGet$note = rFGApiContentItem.realmGet$note();
        if (realmGet$note == null) {
            newProxyInstance.realmSet$note((RFGApiContentNote) null);
        } else {
            RFGApiContentNote rFGApiContentNote = (RFGApiContentNote) map2.get(realmGet$note);
            if (rFGApiContentNote == null) {
                rFGApiContentNote = jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.RFGApiContentNoteColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentNote.class), realmGet$note, z, map, set);
            }
            newProxyInstance.realmSet$note(rFGApiContentNote);
        }
        RFGApiContentImage realmGet$image = rFGApiContentItem.realmGet$image();
        if (realmGet$image == null) {
            newProxyInstance.realmSet$image((RFGApiContentImage) null);
        } else {
            RFGApiContentImage rFGApiContentImage = (RFGApiContentImage) map2.get(realmGet$image);
            if (rFGApiContentImage == null) {
                rFGApiContentImage = jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.RFGApiContentImageColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentImage.class), realmGet$image, z, map, set);
            }
            newProxyInstance.realmSet$image(rFGApiContentImage);
        }
        RFGApiContentAccess realmGet$access = rFGApiContentItem.realmGet$access();
        if (realmGet$access == null) {
            newProxyInstance.realmSet$access((RFGApiContentAccess) null);
        } else {
            RFGApiContentAccess rFGApiContentAccess = (RFGApiContentAccess) map2.get(realmGet$access);
            if (rFGApiContentAccess == null) {
                rFGApiContentAccess = C2009x9093b7d7.copyOrUpdate(realm, (C2009x9093b7d7.RFGApiContentAccessColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentAccess.class), realmGet$access, z, map, set);
            }
            newProxyInstance.realmSet$access(rFGApiContentAccess);
        }
        RealmList<RFGApiContentInfo> realmGet$infoList = rFGApiContentItem.realmGet$infoList();
        if (realmGet$infoList != null) {
            RealmList<RFGApiContentInfo> realmGet$infoList2 = newProxyInstance.realmGet$infoList();
            realmGet$infoList2.clear();
            for (int i = 0; i < realmGet$infoList.size(); i++) {
                RFGApiContentInfo rFGApiContentInfo = realmGet$infoList.get(i);
                RFGApiContentInfo rFGApiContentInfo2 = (RFGApiContentInfo) map2.get(rFGApiContentInfo);
                if (rFGApiContentInfo2 == null) {
                    rFGApiContentInfo2 = jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.RFGApiContentInfoColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentInfo.class), rFGApiContentInfo, z, map, set);
                }
                realmGet$infoList2.add(rFGApiContentInfo2);
            }
        }
        RFGApiContentButton realmGet$button = rFGApiContentItem.realmGet$button();
        if (realmGet$button == null) {
            newProxyInstance.realmSet$button((RFGApiContentButton) null);
        } else {
            RFGApiContentButton rFGApiContentButton = (RFGApiContentButton) map2.get(realmGet$button);
            if (rFGApiContentButton == null) {
                rFGApiContentButton = C2010xb5bcc025.copyOrUpdate(realm, (C2010xb5bcc025.RFGApiContentButtonColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentButton.class), realmGet$button, z, map, set);
            }
            newProxyInstance.realmSet$button(rFGApiContentButton);
        }
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.RFGApiContentItemColumnInfo r9, p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentItem r1 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentItem> r2 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem.class
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
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.api.train.RFGApiContentItem r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.api.train.RFGApiContentItem r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy$RFGApiContentItemColumnInfo, jp.reifrontier.gym.domain.api.train.RFGApiContentItem, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.train.RFGApiContentItem");
    }

    public static RFGApiContentItemColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGApiContentItemColumnInfo(osSchemaInfo);
    }

    public static RFGApiContentItem createDetachedCopy(RFGApiContentItem rFGApiContentItem, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGApiContentItem rFGApiContentItem2;
        if (i > i2 || rFGApiContentItem == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGApiContentItem);
        if (cacheData == null) {
            rFGApiContentItem2 = new RFGApiContentItem();
            map.put(rFGApiContentItem, new RealmObjectProxy.CacheData(i, rFGApiContentItem2));
        } else if (i >= cacheData.minDepth) {
            return (RFGApiContentItem) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGApiContentItem2 = (RFGApiContentItem) cacheData.object;
        }
        rFGApiContentItem2.realmSet$pKey(rFGApiContentItem.realmGet$pKey());
        int i3 = i + 1;
        rFGApiContentItem2.realmSet$title(jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.createDetachedCopy(rFGApiContentItem.realmGet$title(), i3, i2, map));
        rFGApiContentItem2.realmSet$note(jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.createDetachedCopy(rFGApiContentItem.realmGet$note(), i3, i2, map));
        rFGApiContentItem2.realmSet$image(jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.createDetachedCopy(rFGApiContentItem.realmGet$image(), i3, i2, map));
        rFGApiContentItem2.realmSet$access(C2009x9093b7d7.createDetachedCopy(rFGApiContentItem.realmGet$access(), i3, i2, map));
        if (i == i2) {
            rFGApiContentItem2.realmSet$infoList((RealmList<RFGApiContentInfo>) null);
        } else {
            RealmList<RFGApiContentInfo> realmGet$infoList = rFGApiContentItem.realmGet$infoList();
            RealmList realmList = new RealmList();
            rFGApiContentItem2.realmSet$infoList(realmList);
            int size = realmGet$infoList.size();
            for (int i4 = 0; i4 < size; i4++) {
                realmList.add(jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.createDetachedCopy(realmGet$infoList.get(i4), i3, i2, map));
            }
        }
        rFGApiContentItem2.realmSet$button(C2010xb5bcc025.createDetachedCopy(rFGApiContentItem.realmGet$button(), i3, i2, map));
        rFGApiContentItem2.realmSet$order(rFGApiContentItem.realmGet$order());
        return rFGApiContentItem2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 8, 0);
        builder.addPersistedProperty("pKey", RealmFieldType.STRING, true, true, true);
        builder.addPersistedLinkProperty("title", RealmFieldType.OBJECT, jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("note", RealmFieldType.OBJECT, jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("image", RealmFieldType.OBJECT, jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("access", RealmFieldType.OBJECT, C2009x9093b7d7.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("infoList", RealmFieldType.LIST, jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("button", RealmFieldType.OBJECT, C2010xb5bcc025.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedProperty("order", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem createOrUpdateUsingJsonObject(p041io.realm.Realm r15, org.json.JSONObject r16, boolean r17) throws org.json.JSONException {
        /*
            r0 = r15
            r7 = r16
            r8 = r17
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentItem> r9 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem.class
            java.util.ArrayList r10 = new java.util.ArrayList
            r1 = 6
            r10.<init>(r1)
            java.lang.String r11 = "pKey"
            r12 = 0
            if (r8 == 0) goto L_0x0065
            io.realm.internal.Table r1 = r15.getTable(r9)
            io.realm.RealmSchema r2 = r15.getSchema()
            io.realm.internal.ColumnInfo r2 = r2.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r9)
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy$RFGApiContentItemColumnInfo r2 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.RFGApiContentItemColumnInfo) r2
            long r2 = r2.pKeyIndex
            boolean r4 = r7.isNull(r11)
            r5 = -1
            if (r4 != 0) goto L_0x0033
            java.lang.String r4 = r7.getString(r11)
            long r2 = r1.findFirstString(r2, r4)
            goto L_0x0034
        L_0x0033:
            r2 = r5
        L_0x0034:
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0065
            io.realm.BaseRealm$ThreadLocalRealmObjectContext r4 = p041io.realm.BaseRealm.objectContext
            java.lang.Object r4 = r4.get()
            r13 = r4
            io.realm.BaseRealm$RealmObjectContext r13 = (p041io.realm.BaseRealm.RealmObjectContext) r13
            io.realm.internal.UncheckedRow r3 = r1.getUncheckedRow(r2)     // Catch:{ all -> 0x0060 }
            io.realm.RealmSchema r1 = r15.getSchema()     // Catch:{ all -> 0x0060 }
            io.realm.internal.ColumnInfo r4 = r1.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r9)     // Catch:{ all -> 0x0060 }
            r5 = 0
            java.util.List r6 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0060 }
            r1 = r13
            r2 = r15
            r1.set(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0060 }
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            r13.clear()
            goto L_0x0066
        L_0x0060:
            r0 = move-exception
            r13.clear()
            throw r0
        L_0x0065:
            r1 = r12
        L_0x0066:
            java.lang.String r2 = "button"
            java.lang.String r3 = "infoList"
            java.lang.String r4 = "access"
            java.lang.String r5 = "image"
            java.lang.String r6 = "note"
            java.lang.String r13 = "title"
            if (r1 != 0) goto L_0x00cf
            boolean r1 = r7.has(r13)
            if (r1 == 0) goto L_0x007d
            r10.add(r13)
        L_0x007d:
            boolean r1 = r7.has(r6)
            if (r1 == 0) goto L_0x0086
            r10.add(r6)
        L_0x0086:
            boolean r1 = r7.has(r5)
            if (r1 == 0) goto L_0x008f
            r10.add(r5)
        L_0x008f:
            boolean r1 = r7.has(r4)
            if (r1 == 0) goto L_0x0098
            r10.add(r4)
        L_0x0098:
            boolean r1 = r7.has(r3)
            if (r1 == 0) goto L_0x00a1
            r10.add(r3)
        L_0x00a1:
            boolean r1 = r7.has(r2)
            if (r1 == 0) goto L_0x00aa
            r10.add(r2)
        L_0x00aa:
            boolean r1 = r7.has(r11)
            if (r1 == 0) goto L_0x00c7
            boolean r1 = r7.isNull(r11)
            r14 = 1
            if (r1 == 0) goto L_0x00bc
            io.realm.RealmModel r1 = r15.createObjectInternal(r9, r12, r14, r10)
            goto L_0x00c4
        L_0x00bc:
            java.lang.String r1 = r7.getString(r11)
            io.realm.RealmModel r1 = r15.createObjectInternal(r9, r1, r14, r10)
        L_0x00c4:
            io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy r1 = (p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy) r1
            goto L_0x00cf
        L_0x00c7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "JSON object doesn't have the primary key field 'pKey'."
            r0.<init>(r1)
            throw r0
        L_0x00cf:
            boolean r9 = r7.has(r13)
            if (r9 == 0) goto L_0x00ea
            boolean r9 = r7.isNull(r13)
            if (r9 == 0) goto L_0x00df
            r1.realmSet$title(r12)
            goto L_0x00ea
        L_0x00df:
            org.json.JSONObject r9 = r7.getJSONObject(r13)
            jp.reifrontier.gym.domain.api.train.RFGApiContentTitle r9 = p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.createOrUpdateUsingJsonObject(r15, r9, r8)
            r1.realmSet$title(r9)
        L_0x00ea:
            boolean r9 = r7.has(r6)
            if (r9 == 0) goto L_0x0105
            boolean r9 = r7.isNull(r6)
            if (r9 == 0) goto L_0x00fa
            r1.realmSet$note(r12)
            goto L_0x0105
        L_0x00fa:
            org.json.JSONObject r6 = r7.getJSONObject(r6)
            jp.reifrontier.gym.domain.api.train.RFGApiContentNote r6 = p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.createOrUpdateUsingJsonObject(r15, r6, r8)
            r1.realmSet$note(r6)
        L_0x0105:
            boolean r6 = r7.has(r5)
            if (r6 == 0) goto L_0x0120
            boolean r6 = r7.isNull(r5)
            if (r6 == 0) goto L_0x0115
            r1.realmSet$image(r12)
            goto L_0x0120
        L_0x0115:
            org.json.JSONObject r5 = r7.getJSONObject(r5)
            jp.reifrontier.gym.domain.api.train.RFGApiContentImage r5 = p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.createOrUpdateUsingJsonObject(r15, r5, r8)
            r1.realmSet$image(r5)
        L_0x0120:
            boolean r5 = r7.has(r4)
            if (r5 == 0) goto L_0x013b
            boolean r5 = r7.isNull(r4)
            if (r5 == 0) goto L_0x0130
            r1.realmSet$access(r12)
            goto L_0x013b
        L_0x0130:
            org.json.JSONObject r4 = r7.getJSONObject(r4)
            jp.reifrontier.gym.domain.api.train.RFGApiContentAccess r4 = p041io.realm.C2009x9093b7d7.createOrUpdateUsingJsonObject(r15, r4, r8)
            r1.realmSet$access(r4)
        L_0x013b:
            boolean r4 = r7.has(r3)
            if (r4 == 0) goto L_0x016f
            boolean r4 = r7.isNull(r3)
            if (r4 == 0) goto L_0x014b
            r1.realmSet$infoList(r12)
            goto L_0x016f
        L_0x014b:
            io.realm.RealmList r4 = r1.realmGet$infoList()
            r4.clear()
            org.json.JSONArray r3 = r7.getJSONArray(r3)
            r4 = 0
        L_0x0157:
            int r5 = r3.length()
            if (r4 >= r5) goto L_0x016f
            org.json.JSONObject r5 = r3.getJSONObject(r4)
            jp.reifrontier.gym.domain.api.train.RFGApiContentInfo r5 = p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.createOrUpdateUsingJsonObject(r15, r5, r8)
            io.realm.RealmList r6 = r1.realmGet$infoList()
            r6.add(r5)
            int r4 = r4 + 1
            goto L_0x0157
        L_0x016f:
            boolean r3 = r7.has(r2)
            if (r3 == 0) goto L_0x018a
            boolean r3 = r7.isNull(r2)
            if (r3 == 0) goto L_0x017f
            r1.realmSet$button(r12)
            goto L_0x018a
        L_0x017f:
            org.json.JSONObject r2 = r7.getJSONObject(r2)
            jp.reifrontier.gym.domain.api.train.RFGApiContentButton r0 = p041io.realm.C2010xb5bcc025.createOrUpdateUsingJsonObject(r15, r2, r8)
            r1.realmSet$button(r0)
        L_0x018a:
            java.lang.String r0 = "order"
            boolean r2 = r7.has(r0)
            if (r2 == 0) goto L_0x01a8
            boolean r2 = r7.isNull(r0)
            if (r2 != 0) goto L_0x01a0
            int r0 = r7.getInt(r0)
            r1.realmSet$order(r0)
            goto L_0x01a8
        L_0x01a0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Trying to set non-nullable field 'order' to null."
            r0.<init>(r1)
            throw r0
        L_0x01a8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.train.RFGApiContentItem");
    }

    @TargetApi(11)
    public static RFGApiContentItem createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGApiContentItem rFGApiContentItem = new RFGApiContentItem();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("pKey")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGApiContentItem.realmSet$pKey(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGApiContentItem.realmSet$pKey((String) null);
                }
                z = true;
            } else if (nextName.equals("title")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGApiContentItem.realmSet$title((RFGApiContentTitle) null);
                } else {
                    rFGApiContentItem.realmSet$title(jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
            } else if (nextName.equals("note")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGApiContentItem.realmSet$note((RFGApiContentNote) null);
                } else {
                    rFGApiContentItem.realmSet$note(jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
            } else if (nextName.equals("image")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGApiContentItem.realmSet$image((RFGApiContentImage) null);
                } else {
                    rFGApiContentItem.realmSet$image(jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
            } else if (nextName.equals("access")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGApiContentItem.realmSet$access((RFGApiContentAccess) null);
                } else {
                    rFGApiContentItem.realmSet$access(C2009x9093b7d7.createUsingJsonStream(realm, jsonReader));
                }
            } else if (nextName.equals("infoList")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGApiContentItem.realmSet$infoList((RealmList<RFGApiContentInfo>) null);
                } else {
                    rFGApiContentItem.realmSet$infoList(new RealmList());
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        rFGApiContentItem.realmGet$infoList().add(jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.createUsingJsonStream(realm, jsonReader));
                    }
                    jsonReader.endArray();
                }
            } else if (nextName.equals("button")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGApiContentItem.realmSet$button((RFGApiContentButton) null);
                } else {
                    rFGApiContentItem.realmSet$button(C2010xb5bcc025.createUsingJsonStream(realm, jsonReader));
                }
            } else if (!nextName.equals("order")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGApiContentItem.realmSet$order(jsonReader.nextInt());
            } else {
                throw C0681a.m307a(jsonReader, "Trying to set non-nullable field 'order' to null.");
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGApiContentItem) realm.copyToRealm(rFGApiContentItem, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pKey'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGApiContentItem rFGApiContentItem, Map<RealmModel, Long> map) {
        long j;
        long j2;
        long j3;
        Realm realm2 = realm;
        RFGApiContentItem rFGApiContentItem2 = rFGApiContentItem;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentItem> cls = RFGApiContentItem.class;
        if (rFGApiContentItem2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentItem2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo = (RFGApiContentItemColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j4 = rFGApiContentItemColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentItem.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j4, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j4, realmGet$pKey);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
        }
        long j5 = nativeFindFirstString;
        map2.put(rFGApiContentItem2, Long.valueOf(j5));
        RFGApiContentTitle realmGet$title = rFGApiContentItem.realmGet$title();
        if (realmGet$title != null) {
            Long l = map2.get(realmGet$title);
            if (l == null) {
                l = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insert(realm2, realmGet$title, map2));
            }
            j = j5;
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.titleIndex, j5, l.longValue(), false);
        } else {
            j = j5;
        }
        RFGApiContentNote realmGet$note = rFGApiContentItem.realmGet$note();
        if (realmGet$note != null) {
            Long l2 = map2.get(realmGet$note);
            if (l2 == null) {
                l2 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insert(realm2, realmGet$note, map2));
            }
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.noteIndex, j, l2.longValue(), false);
        }
        RFGApiContentImage realmGet$image = rFGApiContentItem.realmGet$image();
        if (realmGet$image != null) {
            Long l3 = map2.get(realmGet$image);
            if (l3 == null) {
                l3 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insert(realm2, realmGet$image, map2));
            }
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.imageIndex, j, l3.longValue(), false);
        }
        RFGApiContentAccess realmGet$access = rFGApiContentItem.realmGet$access();
        if (realmGet$access != null) {
            Long l4 = map2.get(realmGet$access);
            if (l4 == null) {
                l4 = Long.valueOf(C2009x9093b7d7.insert(realm2, realmGet$access, map2));
            }
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.accessIndex, j, l4.longValue(), false);
        }
        RealmList<RFGApiContentInfo> realmGet$infoList = rFGApiContentItem.realmGet$infoList();
        if (realmGet$infoList != null) {
            j2 = j;
            OsList osList = new OsList(table.getUncheckedRow(j2), rFGApiContentItemColumnInfo.infoListIndex);
            Iterator<RFGApiContentInfo> it = realmGet$infoList.iterator();
            while (it.hasNext()) {
                RFGApiContentInfo next = it.next();
                Long l5 = map2.get(next);
                if (l5 == null) {
                    l5 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insert(realm2, next, map2));
                }
                osList.addRow(l5.longValue());
            }
        } else {
            j2 = j;
        }
        RFGApiContentButton realmGet$button = rFGApiContentItem.realmGet$button();
        if (realmGet$button != null) {
            Long l6 = map2.get(realmGet$button);
            if (l6 == null) {
                l6 = Long.valueOf(C2010xb5bcc025.insert(realm2, realmGet$button, map2));
            }
            j3 = j2;
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.buttonIndex, j2, l6.longValue(), false);
        } else {
            j3 = j2;
        }
        Table.nativeSetLong(nativePtr, rFGApiContentItemColumnInfo.orderIndex, j3, (long) rFGApiContentItem.realmGet$order(), false);
        return j3;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        RFGApiContentItem rFGApiContentItem;
        long j3;
        long j4;
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentItem> cls = RFGApiContentItem.class;
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo = (RFGApiContentItemColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j5 = rFGApiContentItemColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentItem rFGApiContentItem2 = (RFGApiContentItem) it.next();
            if (!map2.containsKey(rFGApiContentItem2)) {
                if (rFGApiContentItem2 instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentItem2;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentItem2, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentItem2.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j5, realmGet$pKey) : -1;
                if (nativeFindFirstString == -1) {
                    j = OsObject.createRowWithPrimaryKey(table, j5, realmGet$pKey);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$pKey);
                    j = nativeFindFirstString;
                }
                map2.put(rFGApiContentItem2, Long.valueOf(j));
                RFGApiContentTitle realmGet$title = rFGApiContentItem2.realmGet$title();
                if (realmGet$title != null) {
                    Long l = map2.get(realmGet$title);
                    if (l == null) {
                        l = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insert(realm2, realmGet$title, map2));
                    }
                    j2 = j;
                    rFGApiContentItem = rFGApiContentItem2;
                    table.setLink(rFGApiContentItemColumnInfo.titleIndex, j, l.longValue(), false);
                } else {
                    j2 = j;
                    rFGApiContentItem = rFGApiContentItem2;
                }
                RFGApiContentNote realmGet$note = rFGApiContentItem.realmGet$note();
                if (realmGet$note != null) {
                    Long l2 = map2.get(realmGet$note);
                    if (l2 == null) {
                        l2 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insert(realm2, realmGet$note, map2));
                    }
                    table.setLink(rFGApiContentItemColumnInfo.noteIndex, j2, l2.longValue(), false);
                }
                RFGApiContentImage realmGet$image = rFGApiContentItem.realmGet$image();
                if (realmGet$image != null) {
                    Long l3 = map2.get(realmGet$image);
                    if (l3 == null) {
                        l3 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insert(realm2, realmGet$image, map2));
                    }
                    table.setLink(rFGApiContentItemColumnInfo.imageIndex, j2, l3.longValue(), false);
                }
                RFGApiContentAccess realmGet$access = rFGApiContentItem.realmGet$access();
                if (realmGet$access != null) {
                    Long l4 = map2.get(realmGet$access);
                    if (l4 == null) {
                        l4 = Long.valueOf(C2009x9093b7d7.insert(realm2, realmGet$access, map2));
                    }
                    table.setLink(rFGApiContentItemColumnInfo.accessIndex, j2, l4.longValue(), false);
                }
                RealmList<RFGApiContentInfo> realmGet$infoList = rFGApiContentItem.realmGet$infoList();
                if (realmGet$infoList != null) {
                    j3 = j2;
                    OsList osList = new OsList(table.getUncheckedRow(j3), rFGApiContentItemColumnInfo.infoListIndex);
                    Iterator<RFGApiContentInfo> it2 = realmGet$infoList.iterator();
                    while (it2.hasNext()) {
                        RFGApiContentInfo next = it2.next();
                        Long l5 = map2.get(next);
                        if (l5 == null) {
                            l5 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insert(realm2, next, map2));
                        }
                        osList.addRow(l5.longValue());
                    }
                } else {
                    j3 = j2;
                }
                RFGApiContentButton realmGet$button = rFGApiContentItem.realmGet$button();
                if (realmGet$button != null) {
                    Long l6 = map2.get(realmGet$button);
                    if (l6 == null) {
                        l6 = Long.valueOf(C2010xb5bcc025.insert(realm2, realmGet$button, map2));
                    }
                    j4 = j3;
                    table.setLink(rFGApiContentItemColumnInfo.buttonIndex, j3, l6.longValue(), false);
                } else {
                    j4 = j3;
                }
                Table.nativeSetLong(nativePtr, rFGApiContentItemColumnInfo.orderIndex, j4, (long) rFGApiContentItem.realmGet$order(), false);
                j5 = j5;
                nativePtr = nativePtr;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGApiContentItem rFGApiContentItem, Map<RealmModel, Long> map) {
        long j;
        long j2;
        long j3;
        Realm realm2 = realm;
        RFGApiContentItem rFGApiContentItem2 = rFGApiContentItem;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentItem> cls = RFGApiContentItem.class;
        if (rFGApiContentItem2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentItem2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo = (RFGApiContentItemColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j4 = rFGApiContentItemColumnInfo.pKeyIndex;
        String realmGet$pKey = rFGApiContentItem.realmGet$pKey();
        long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j4, realmGet$pKey) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j4, realmGet$pKey);
        }
        long j5 = nativeFindFirstString;
        map2.put(rFGApiContentItem2, Long.valueOf(j5));
        RFGApiContentTitle realmGet$title = rFGApiContentItem.realmGet$title();
        if (realmGet$title != null) {
            Long l = map2.get(realmGet$title);
            if (l == null) {
                l = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insertOrUpdate(realm2, realmGet$title, map2));
            }
            j = j5;
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.titleIndex, j5, l.longValue(), false);
        } else {
            j = j5;
            Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.titleIndex, j);
        }
        RFGApiContentNote realmGet$note = rFGApiContentItem.realmGet$note();
        if (realmGet$note != null) {
            Long l2 = map2.get(realmGet$note);
            if (l2 == null) {
                l2 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insertOrUpdate(realm2, realmGet$note, map2));
            }
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.noteIndex, j, l2.longValue(), false);
        } else {
            Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.noteIndex, j);
        }
        RFGApiContentImage realmGet$image = rFGApiContentItem.realmGet$image();
        if (realmGet$image != null) {
            Long l3 = map2.get(realmGet$image);
            if (l3 == null) {
                l3 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insertOrUpdate(realm2, realmGet$image, map2));
            }
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.imageIndex, j, l3.longValue(), false);
        } else {
            Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.imageIndex, j);
        }
        RFGApiContentAccess realmGet$access = rFGApiContentItem.realmGet$access();
        if (realmGet$access != null) {
            Long l4 = map2.get(realmGet$access);
            if (l4 == null) {
                l4 = Long.valueOf(C2009x9093b7d7.insertOrUpdate(realm2, realmGet$access, map2));
            }
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.accessIndex, j, l4.longValue(), false);
        } else {
            Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.accessIndex, j);
        }
        long j6 = j;
        OsList osList = new OsList(table.getUncheckedRow(j6), rFGApiContentItemColumnInfo.infoListIndex);
        RealmList<RFGApiContentInfo> realmGet$infoList = rFGApiContentItem.realmGet$infoList();
        if (realmGet$infoList == null || ((long) realmGet$infoList.size()) != osList.size()) {
            j2 = j6;
            osList.removeAll();
            if (realmGet$infoList != null) {
                Iterator<RFGApiContentInfo> it = realmGet$infoList.iterator();
                while (it.hasNext()) {
                    RFGApiContentInfo next = it.next();
                    Long l5 = map2.get(next);
                    if (l5 == null) {
                        l5 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insertOrUpdate(realm2, next, map2));
                    }
                    osList.addRow(l5.longValue());
                }
            }
        } else {
            int size = realmGet$infoList.size();
            int i = 0;
            while (i < size) {
                RFGApiContentInfo rFGApiContentInfo = realmGet$infoList.get(i);
                Long l6 = map2.get(rFGApiContentInfo);
                if (l6 == null) {
                    l6 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insertOrUpdate(realm2, rFGApiContentInfo, map2));
                }
                osList.setRow((long) i, l6.longValue());
                i++;
                j6 = j6;
            }
            j2 = j6;
        }
        RFGApiContentButton realmGet$button = rFGApiContentItem.realmGet$button();
        if (realmGet$button != null) {
            Long l7 = map2.get(realmGet$button);
            if (l7 == null) {
                l7 = Long.valueOf(C2010xb5bcc025.insertOrUpdate(realm2, realmGet$button, map2));
            }
            j3 = j2;
            Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.buttonIndex, j2, l7.longValue(), false);
        } else {
            j3 = j2;
            Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.buttonIndex, j3);
        }
        Table.nativeSetLong(nativePtr, rFGApiContentItemColumnInfo.orderIndex, j3, (long) rFGApiContentItem.realmGet$order(), false);
        return j3;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        long j2;
        long j3;
        long j4;
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGApiContentItem> cls = RFGApiContentItem.class;
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo = (RFGApiContentItemColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j5 = rFGApiContentItemColumnInfo.pKeyIndex;
        while (it.hasNext()) {
            RFGApiContentItem rFGApiContentItem = (RFGApiContentItem) it.next();
            if (!map2.containsKey(rFGApiContentItem)) {
                if (rFGApiContentItem instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGApiContentItem;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGApiContentItem, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$pKey = rFGApiContentItem.realmGet$pKey();
                long nativeFindFirstString = realmGet$pKey != null ? Table.nativeFindFirstString(nativePtr, j5, realmGet$pKey) : -1;
                long createRowWithPrimaryKey = nativeFindFirstString == -1 ? OsObject.createRowWithPrimaryKey(table, j5, realmGet$pKey) : nativeFindFirstString;
                map2.put(rFGApiContentItem, Long.valueOf(createRowWithPrimaryKey));
                RFGApiContentTitle realmGet$title = rFGApiContentItem.realmGet$title();
                if (realmGet$title != null) {
                    Long l = map2.get(realmGet$title);
                    if (l == null) {
                        l = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insertOrUpdate(realm2, realmGet$title, map2));
                    }
                    j2 = createRowWithPrimaryKey;
                    j = j5;
                    Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.titleIndex, createRowWithPrimaryKey, l.longValue(), false);
                } else {
                    j2 = createRowWithPrimaryKey;
                    j = j5;
                    Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.titleIndex, createRowWithPrimaryKey);
                }
                RFGApiContentNote realmGet$note = rFGApiContentItem.realmGet$note();
                if (realmGet$note != null) {
                    Long l2 = map2.get(realmGet$note);
                    if (l2 == null) {
                        l2 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insertOrUpdate(realm2, realmGet$note, map2));
                    }
                    Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.noteIndex, j2, l2.longValue(), false);
                } else {
                    Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.noteIndex, j2);
                }
                RFGApiContentImage realmGet$image = rFGApiContentItem.realmGet$image();
                if (realmGet$image != null) {
                    Long l3 = map2.get(realmGet$image);
                    if (l3 == null) {
                        l3 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insertOrUpdate(realm2, realmGet$image, map2));
                    }
                    Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.imageIndex, j2, l3.longValue(), false);
                } else {
                    Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.imageIndex, j2);
                }
                RFGApiContentAccess realmGet$access = rFGApiContentItem.realmGet$access();
                if (realmGet$access != null) {
                    Long l4 = map2.get(realmGet$access);
                    if (l4 == null) {
                        l4 = Long.valueOf(C2009x9093b7d7.insertOrUpdate(realm2, realmGet$access, map2));
                    }
                    Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.accessIndex, j2, l4.longValue(), false);
                } else {
                    Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.accessIndex, j2);
                }
                long j6 = j2;
                OsList osList = new OsList(table.getUncheckedRow(j6), rFGApiContentItemColumnInfo.infoListIndex);
                RealmList<RFGApiContentInfo> realmGet$infoList = rFGApiContentItem.realmGet$infoList();
                if (realmGet$infoList == null || ((long) realmGet$infoList.size()) != osList.size()) {
                    j3 = j6;
                    osList.removeAll();
                    if (realmGet$infoList != null) {
                        Iterator<RFGApiContentInfo> it2 = realmGet$infoList.iterator();
                        while (it2.hasNext()) {
                            RFGApiContentInfo next = it2.next();
                            Long l5 = map2.get(next);
                            if (l5 == null) {
                                l5 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insertOrUpdate(realm2, next, map2));
                            }
                            osList.addRow(l5.longValue());
                        }
                    }
                } else {
                    int size = realmGet$infoList.size();
                    int i = 0;
                    while (i < size) {
                        RFGApiContentInfo rFGApiContentInfo = realmGet$infoList.get(i);
                        Long l6 = map2.get(rFGApiContentInfo);
                        if (l6 == null) {
                            l6 = Long.valueOf(jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insertOrUpdate(realm2, rFGApiContentInfo, map2));
                        }
                        osList.setRow((long) i, l6.longValue());
                        i++;
                        j6 = j6;
                    }
                    j3 = j6;
                }
                RFGApiContentButton realmGet$button = rFGApiContentItem.realmGet$button();
                if (realmGet$button != null) {
                    Long l7 = map2.get(realmGet$button);
                    if (l7 == null) {
                        l7 = Long.valueOf(C2010xb5bcc025.insertOrUpdate(realm2, realmGet$button, map2));
                    }
                    j4 = j3;
                    Table.nativeSetLink(nativePtr, rFGApiContentItemColumnInfo.buttonIndex, j3, l7.longValue(), false);
                } else {
                    j4 = j3;
                    Table.nativeNullifyLink(nativePtr, rFGApiContentItemColumnInfo.buttonIndex, j4);
                }
                Table.nativeSetLong(nativePtr, rFGApiContentItemColumnInfo.orderIndex, j4, (long) rFGApiContentItem.realmGet$order(), false);
                j5 = j;
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentItem.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentitemrealmproxy = new jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_train_rfgapicontentitemrealmproxy;
    }

    static RFGApiContentItem update(Realm realm, RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo, RFGApiContentItem rFGApiContentItem, RFGApiContentItem rFGApiContentItem2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        RFGApiContentItemColumnInfo rFGApiContentItemColumnInfo2 = rFGApiContentItemColumnInfo;
        Map<RealmModel, RealmObjectProxy> map2 = map;
        Realm realm2 = realm;
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGApiContentItem.class), rFGApiContentItemColumnInfo2.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGApiContentItemColumnInfo2.pKeyIndex, rFGApiContentItem2.realmGet$pKey());
        RFGApiContentTitle realmGet$title = rFGApiContentItem2.realmGet$title();
        if (realmGet$title == null) {
            osObjectBuilder.addNull(rFGApiContentItemColumnInfo2.titleIndex);
        } else {
            RFGApiContentTitle rFGApiContentTitle = (RFGApiContentTitle) map2.get(realmGet$title);
            if (rFGApiContentTitle != null) {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.titleIndex, rFGApiContentTitle);
            } else {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.titleIndex, jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.RFGApiContentTitleColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentTitle.class), realmGet$title, true, map, set));
            }
        }
        RFGApiContentNote realmGet$note = rFGApiContentItem2.realmGet$note();
        if (realmGet$note == null) {
            osObjectBuilder.addNull(rFGApiContentItemColumnInfo2.noteIndex);
        } else {
            RFGApiContentNote rFGApiContentNote = (RFGApiContentNote) map2.get(realmGet$note);
            if (rFGApiContentNote != null) {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.noteIndex, rFGApiContentNote);
            } else {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.noteIndex, jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.RFGApiContentNoteColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentNote.class), realmGet$note, true, map, set));
            }
        }
        RFGApiContentImage realmGet$image = rFGApiContentItem2.realmGet$image();
        if (realmGet$image == null) {
            osObjectBuilder.addNull(rFGApiContentItemColumnInfo2.imageIndex);
        } else {
            RFGApiContentImage rFGApiContentImage = (RFGApiContentImage) map2.get(realmGet$image);
            if (rFGApiContentImage != null) {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.imageIndex, rFGApiContentImage);
            } else {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.imageIndex, jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.RFGApiContentImageColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentImage.class), realmGet$image, true, map, set));
            }
        }
        RFGApiContentAccess realmGet$access = rFGApiContentItem2.realmGet$access();
        if (realmGet$access == null) {
            osObjectBuilder.addNull(rFGApiContentItemColumnInfo2.accessIndex);
        } else {
            RFGApiContentAccess rFGApiContentAccess = (RFGApiContentAccess) map2.get(realmGet$access);
            if (rFGApiContentAccess != null) {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.accessIndex, rFGApiContentAccess);
            } else {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.accessIndex, C2009x9093b7d7.copyOrUpdate(realm, (C2009x9093b7d7.RFGApiContentAccessColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentAccess.class), realmGet$access, true, map, set));
            }
        }
        RealmList<RFGApiContentInfo> realmGet$infoList = rFGApiContentItem2.realmGet$infoList();
        if (realmGet$infoList != null) {
            RealmList realmList = new RealmList();
            for (int i = 0; i < realmGet$infoList.size(); i++) {
                RFGApiContentInfo rFGApiContentInfo = realmGet$infoList.get(i);
                RFGApiContentInfo rFGApiContentInfo2 = (RFGApiContentInfo) map2.get(rFGApiContentInfo);
                if (rFGApiContentInfo2 == null) {
                    rFGApiContentInfo2 = jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.RFGApiContentInfoColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentInfo.class), rFGApiContentInfo, true, map, set);
                }
                realmList.add(rFGApiContentInfo2);
            }
            osObjectBuilder.addObjectList(rFGApiContentItemColumnInfo2.infoListIndex, realmList);
        } else {
            osObjectBuilder.addObjectList(rFGApiContentItemColumnInfo2.infoListIndex, new RealmList());
        }
        RFGApiContentButton realmGet$button = rFGApiContentItem2.realmGet$button();
        if (realmGet$button == null) {
            osObjectBuilder.addNull(rFGApiContentItemColumnInfo2.buttonIndex);
        } else {
            RFGApiContentButton rFGApiContentButton = (RFGApiContentButton) map2.get(realmGet$button);
            if (rFGApiContentButton != null) {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.buttonIndex, rFGApiContentButton);
            } else {
                osObjectBuilder.addObject(rFGApiContentItemColumnInfo2.buttonIndex, C2010xb5bcc025.copyOrUpdate(realm, (C2010xb5bcc025.RFGApiContentButtonColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGApiContentButton.class), realmGet$button, true, map, set));
            }
        }
        osObjectBuilder.addInteger(rFGApiContentItemColumnInfo2.orderIndex, Integer.valueOf(rFGApiContentItem2.realmGet$order()));
        osObjectBuilder.updateExistingObject();
        return rFGApiContentItem;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy jp_reifrontier_gym_domain_api_train_rfgapicontentitemrealmproxy = (jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_train_rfgapicontentitemrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_train_rfgapicontentitemrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_train_rfgapicontentitemrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGApiContentItemColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGApiContentItem> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public RFGApiContentAccess realmGet$access() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.accessIndex)) {
            return null;
        }
        return (RFGApiContentAccess) this.proxyState.getRealm$realm().get(RFGApiContentAccess.class, this.proxyState.getRow$realm().getLink(this.columnInfo.accessIndex), false, Collections.emptyList());
    }

    public RFGApiContentButton realmGet$button() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.buttonIndex)) {
            return null;
        }
        return (RFGApiContentButton) this.proxyState.getRealm$realm().get(RFGApiContentButton.class, this.proxyState.getRow$realm().getLink(this.columnInfo.buttonIndex), false, Collections.emptyList());
    }

    public RFGApiContentImage realmGet$image() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.imageIndex)) {
            return null;
        }
        return (RFGApiContentImage) this.proxyState.getRealm$realm().get(RFGApiContentImage.class, this.proxyState.getRow$realm().getLink(this.columnInfo.imageIndex), false, Collections.emptyList());
    }

    public RealmList<RFGApiContentInfo> realmGet$infoList() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGApiContentInfo> realmList = this.infoListRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGApiContentInfo> realmList2 = new RealmList<>(RFGApiContentInfo.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.infoListIndex), this.proxyState.getRealm$realm());
        this.infoListRealmList = realmList2;
        return realmList2;
    }

    public RFGApiContentNote realmGet$note() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.noteIndex)) {
            return null;
        }
        return (RFGApiContentNote) this.proxyState.getRealm$realm().get(RFGApiContentNote.class, this.proxyState.getRow$realm().getLink(this.columnInfo.noteIndex), false, Collections.emptyList());
    }

    public int realmGet$order() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.orderIndex);
    }

    public String realmGet$pKey() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pKeyIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public RFGApiContentTitle realmGet$title() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.titleIndex)) {
            return null;
        }
        return (RFGApiContentTitle) this.proxyState.getRealm$realm().get(RFGApiContentTitle.class, this.proxyState.getRow$realm().getLink(this.columnInfo.titleIndex), false, Collections.emptyList());
    }

    public void realmSet$access(RFGApiContentAccess rFGApiContentAccess) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (rFGApiContentAccess == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.accessIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentAccess);
            this.proxyState.getRow$realm().setLink(this.columnInfo.accessIndex, ((RealmObjectProxy) rFGApiContentAccess).realmGet$proxyState().getRow$realm().getIndex());
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("access")) {
            if (rFGApiContentAccess != null && !RealmObject.isManaged(rFGApiContentAccess)) {
                rFGApiContentAccess = (RFGApiContentAccess) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(rFGApiContentAccess, new ImportFlag[0]);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (rFGApiContentAccess == null) {
                row$realm.nullifyLink(this.columnInfo.accessIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentAccess);
            row$realm.getTable().setLink(this.columnInfo.accessIndex, row$realm.getIndex(), C0681a.m304a((RealmObjectProxy) rFGApiContentAccess), true);
        }
    }

    public void realmSet$button(RFGApiContentButton rFGApiContentButton) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (rFGApiContentButton == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.buttonIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentButton);
            this.proxyState.getRow$realm().setLink(this.columnInfo.buttonIndex, ((RealmObjectProxy) rFGApiContentButton).realmGet$proxyState().getRow$realm().getIndex());
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("button")) {
            if (rFGApiContentButton != null && !RealmObject.isManaged(rFGApiContentButton)) {
                rFGApiContentButton = (RFGApiContentButton) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(rFGApiContentButton, new ImportFlag[0]);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (rFGApiContentButton == null) {
                row$realm.nullifyLink(this.columnInfo.buttonIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentButton);
            row$realm.getTable().setLink(this.columnInfo.buttonIndex, row$realm.getIndex(), C0681a.m304a((RealmObjectProxy) rFGApiContentButton), true);
        }
    }

    public void realmSet$image(RFGApiContentImage rFGApiContentImage) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (rFGApiContentImage == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.imageIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentImage);
            this.proxyState.getRow$realm().setLink(this.columnInfo.imageIndex, ((RealmObjectProxy) rFGApiContentImage).realmGet$proxyState().getRow$realm().getIndex());
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("image")) {
            if (rFGApiContentImage != null && !RealmObject.isManaged(rFGApiContentImage)) {
                rFGApiContentImage = (RFGApiContentImage) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(rFGApiContentImage, new ImportFlag[0]);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (rFGApiContentImage == null) {
                row$realm.nullifyLink(this.columnInfo.imageIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentImage);
            row$realm.getTable().setLink(this.columnInfo.imageIndex, row$realm.getIndex(), C0681a.m304a((RealmObjectProxy) rFGApiContentImage), true);
        }
    }

    public void realmSet$infoList(RealmList<RFGApiContentInfo> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("infoList")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGApiContentInfo> realmList2 = new RealmList<>();
                Iterator<RFGApiContentInfo> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGApiContentInfo) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.infoListIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGApiContentInfo rFGApiContentInfo = realmList.get(i);
                    this.proxyState.checkValidObject(rFGApiContentInfo);
                    modelList.addRow(((RealmObjectProxy) rFGApiContentInfo).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGApiContentInfo rFGApiContentInfo2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGApiContentInfo2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGApiContentInfo2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
    }

    public void realmSet$note(RFGApiContentNote rFGApiContentNote) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (rFGApiContentNote == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.noteIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentNote);
            this.proxyState.getRow$realm().setLink(this.columnInfo.noteIndex, ((RealmObjectProxy) rFGApiContentNote).realmGet$proxyState().getRow$realm().getIndex());
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("note")) {
            if (rFGApiContentNote != null && !RealmObject.isManaged(rFGApiContentNote)) {
                rFGApiContentNote = (RFGApiContentNote) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(rFGApiContentNote, new ImportFlag[0]);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (rFGApiContentNote == null) {
                row$realm.nullifyLink(this.columnInfo.noteIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentNote);
            row$realm.getTable().setLink(this.columnInfo.noteIndex, row$realm.getIndex(), C0681a.m304a((RealmObjectProxy) rFGApiContentNote), true);
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

    public void realmSet$pKey(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'pKey' cannot be changed after object was created.");
        }
    }

    public void realmSet$title(RFGApiContentTitle rFGApiContentTitle) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (rFGApiContentTitle == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.titleIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentTitle);
            this.proxyState.getRow$realm().setLink(this.columnInfo.titleIndex, ((RealmObjectProxy) rFGApiContentTitle).realmGet$proxyState().getRow$realm().getIndex());
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("title")) {
            if (rFGApiContentTitle != null && !RealmObject.isManaged(rFGApiContentTitle)) {
                rFGApiContentTitle = (RFGApiContentTitle) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(rFGApiContentTitle, new ImportFlag[0]);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (rFGApiContentTitle == null) {
                row$realm.nullifyLink(this.columnInfo.titleIndex);
                return;
            }
            this.proxyState.checkValidObject(rFGApiContentTitle);
            row$realm.getTable().setLink(this.columnInfo.titleIndex, row$realm.getIndex(), C0681a.m304a((RealmObjectProxy) rFGApiContentTitle), true);
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGApiContentItem = proxy[", "{pKey:");
        b.append(realmGet$pKey());
        b.append("}");
        b.append(",");
        b.append("{title:");
        String str = "null";
        C0681a.m335a(b, realmGet$title() != null ? jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME : str, "}", ",", "{note:");
        C0681a.m335a(b, realmGet$note() != null ? jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME : str, "}", ",", "{image:");
        C0681a.m335a(b, realmGet$image() != null ? jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME : str, "}", ",", "{access:");
        C0681a.m335a(b, realmGet$access() != null ? C2009x9093b7d7.ClassNameHelper.INTERNAL_CLASS_NAME : str, "}", ",", "{infoList:");
        b.append("RealmList<RFGApiContentInfo>[");
        b.append(realmGet$infoList().size());
        b.append("]");
        b.append("}");
        b.append(",");
        b.append("{button:");
        if (realmGet$button() != null) {
            str = C2010xb5bcc025.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        C0681a.m335a(b, str, "}", ",", "{order:");
        b.append(realmGet$order());
        b.append("}");
        b.append("]");
        return b.toString();
    }
}
