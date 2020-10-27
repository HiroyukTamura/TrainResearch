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
import p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy;
import p043jp.reifrontier.gym.domain.api.RFGHistory;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.domain.api.RFGUserSummary;

/* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy */
public class jp_reifrontier_gym_domain_api_RFGUserRealmProxy extends RFGUser implements RealmObjectProxy, jp_reifrontier_gym_domain_api_RFGUserRealmProxyInterface {
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RFGUserColumnInfo columnInfo;
    private RealmList<RFGHistory> heightHistoryRealmList;
    private ProxyState<RFGUser> proxyState;
    private RealmList<RFGUserSummary> summaryAllRealmList;
    private RealmList<RFGUserSummary> summaryTodayRealmList;
    private RealmList<RFGHistory> weightHistoryRealmList;

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy$ClassNameHelper */
    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RFGUser";
    }

    /* renamed from: io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy$RFGUserColumnInfo */
    static final class RFGUserColumnInfo extends ColumnInfo {
        long archiveCountIndex;
        long birthdayIndex;
        long emailIndex;
        long firstDateIndex;
        long genderIndex;
        long handleNameIndex;
        long heightHistoryIndex;
        long iconIndex;
        long maxColumnIndexValue;
        long pushAllowIndex;
        long summaryAllIndex;
        long summaryTodayIndex;
        long userIdIndex;
        long weightHistoryIndex;

        RFGUserColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        RFGUserColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(13);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(ClassNameHelper.INTERNAL_CLASS_NAME);
            this.userIdIndex = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.firstDateIndex = addColumnDetails("firstDate", "firstDate", objectSchemaInfo);
            this.iconIndex = addColumnDetails("icon", "icon", objectSchemaInfo);
            this.genderIndex = addColumnDetails("gender", "gender", objectSchemaInfo);
            this.birthdayIndex = addColumnDetails("birthday", "birthday", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
            this.handleNameIndex = addColumnDetails("handleName", "handleName", objectSchemaInfo);
            this.pushAllowIndex = addColumnDetails("pushAllow", "pushAllow", objectSchemaInfo);
            this.archiveCountIndex = addColumnDetails("archiveCount", "archiveCount", objectSchemaInfo);
            this.heightHistoryIndex = addColumnDetails("heightHistory", "heightHistory", objectSchemaInfo);
            this.weightHistoryIndex = addColumnDetails("weightHistory", "weightHistory", objectSchemaInfo);
            this.summaryTodayIndex = addColumnDetails("summaryToday", "summaryToday", objectSchemaInfo);
            this.summaryAllIndex = addColumnDetails("summaryAll", "summaryAll", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        /* access modifiers changed from: protected */
        public final ColumnInfo copy(boolean z) {
            return new RFGUserColumnInfo(this, z);
        }

        /* access modifiers changed from: protected */
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RFGUserColumnInfo rFGUserColumnInfo = (RFGUserColumnInfo) columnInfo;
            RFGUserColumnInfo rFGUserColumnInfo2 = (RFGUserColumnInfo) columnInfo2;
            rFGUserColumnInfo2.userIdIndex = rFGUserColumnInfo.userIdIndex;
            rFGUserColumnInfo2.firstDateIndex = rFGUserColumnInfo.firstDateIndex;
            rFGUserColumnInfo2.iconIndex = rFGUserColumnInfo.iconIndex;
            rFGUserColumnInfo2.genderIndex = rFGUserColumnInfo.genderIndex;
            rFGUserColumnInfo2.birthdayIndex = rFGUserColumnInfo.birthdayIndex;
            rFGUserColumnInfo2.emailIndex = rFGUserColumnInfo.emailIndex;
            rFGUserColumnInfo2.handleNameIndex = rFGUserColumnInfo.handleNameIndex;
            rFGUserColumnInfo2.pushAllowIndex = rFGUserColumnInfo.pushAllowIndex;
            rFGUserColumnInfo2.archiveCountIndex = rFGUserColumnInfo.archiveCountIndex;
            rFGUserColumnInfo2.heightHistoryIndex = rFGUserColumnInfo.heightHistoryIndex;
            rFGUserColumnInfo2.weightHistoryIndex = rFGUserColumnInfo.weightHistoryIndex;
            rFGUserColumnInfo2.summaryTodayIndex = rFGUserColumnInfo.summaryTodayIndex;
            rFGUserColumnInfo2.summaryAllIndex = rFGUserColumnInfo.summaryAllIndex;
            rFGUserColumnInfo2.maxColumnIndexValue = rFGUserColumnInfo.maxColumnIndexValue;
        }
    }

    jp_reifrontier_gym_domain_api_RFGUserRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public static RFGUser copy(Realm realm, RFGUserColumnInfo rFGUserColumnInfo, RFGUser rFGUser, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        int i;
        int i2;
        Realm realm2 = realm;
        RFGUserColumnInfo rFGUserColumnInfo2 = rFGUserColumnInfo;
        RFGUser rFGUser2 = rFGUser;
        Map<RealmModel, RealmObjectProxy> map2 = map;
        Class<RFGUserSummary> cls = RFGUserSummary.class;
        Class<RFGHistory> cls2 = RFGHistory.class;
        RealmObjectProxy realmObjectProxy = map2.get(rFGUser2);
        if (realmObjectProxy != null) {
            return (RFGUser) realmObjectProxy;
        }
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm2.getTable(RFGUser.class), rFGUserColumnInfo2.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGUserColumnInfo2.userIdIndex, rFGUser.realmGet$userId());
        osObjectBuilder.addString(rFGUserColumnInfo2.firstDateIndex, rFGUser.realmGet$firstDate());
        osObjectBuilder.addString(rFGUserColumnInfo2.iconIndex, rFGUser.realmGet$icon());
        osObjectBuilder.addString(rFGUserColumnInfo2.genderIndex, rFGUser.realmGet$gender());
        osObjectBuilder.addString(rFGUserColumnInfo2.birthdayIndex, rFGUser.realmGet$birthday());
        osObjectBuilder.addString(rFGUserColumnInfo2.emailIndex, rFGUser.realmGet$email());
        osObjectBuilder.addString(rFGUserColumnInfo2.handleNameIndex, rFGUser.realmGet$handleName());
        osObjectBuilder.addString(rFGUserColumnInfo2.pushAllowIndex, rFGUser.realmGet$pushAllow());
        osObjectBuilder.addString(rFGUserColumnInfo2.archiveCountIndex, rFGUser.realmGet$archiveCount());
        jp_reifrontier_gym_domain_api_RFGUserRealmProxy newProxyInstance = newProxyInstance(realm2, osObjectBuilder.createNewObject());
        map2.put(rFGUser2, newProxyInstance);
        RealmList<RFGHistory> realmGet$heightHistory = rFGUser.realmGet$heightHistory();
        if (realmGet$heightHistory != null) {
            RealmList<RFGHistory> realmGet$heightHistory2 = newProxyInstance.realmGet$heightHistory();
            realmGet$heightHistory2.clear();
            int i3 = 0;
            while (i3 < realmGet$heightHistory.size()) {
                RFGHistory rFGHistory = realmGet$heightHistory.get(i3);
                RFGHistory rFGHistory2 = (RFGHistory) map2.get(rFGHistory);
                if (rFGHistory2 != null) {
                    realmGet$heightHistory2.add(rFGHistory2);
                    i2 = i3;
                } else {
                    i2 = i3;
                    realmGet$heightHistory2.add(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls2), rFGHistory, z, map, set));
                }
                i3 = i2 + 1;
            }
        }
        RealmList<RFGHistory> realmGet$weightHistory = rFGUser.realmGet$weightHistory();
        if (realmGet$weightHistory != null) {
            RealmList<RFGHistory> realmGet$weightHistory2 = newProxyInstance.realmGet$weightHistory();
            realmGet$weightHistory2.clear();
            int i4 = 0;
            while (i4 < realmGet$weightHistory.size()) {
                RFGHistory rFGHistory3 = realmGet$weightHistory.get(i4);
                RFGHistory rFGHistory4 = (RFGHistory) map2.get(rFGHistory3);
                if (rFGHistory4 != null) {
                    realmGet$weightHistory2.add(rFGHistory4);
                    i = i4;
                } else {
                    i = i4;
                    realmGet$weightHistory2.add(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls2), rFGHistory3, z, map, set));
                }
                i4 = i + 1;
            }
        }
        RealmList<RFGUserSummary> realmGet$summaryToday = rFGUser.realmGet$summaryToday();
        if (realmGet$summaryToday != null) {
            RealmList<RFGUserSummary> realmGet$summaryToday2 = newProxyInstance.realmGet$summaryToday();
            realmGet$summaryToday2.clear();
            for (int i5 = 0; i5 < realmGet$summaryToday.size(); i5++) {
                RFGUserSummary rFGUserSummary = realmGet$summaryToday.get(i5);
                RFGUserSummary rFGUserSummary2 = (RFGUserSummary) map2.get(rFGUserSummary);
                if (rFGUserSummary2 == null) {
                    rFGUserSummary2 = jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls), rFGUserSummary, z, map, set);
                }
                realmGet$summaryToday2.add(rFGUserSummary2);
            }
        }
        RealmList<RFGUserSummary> realmGet$summaryAll = rFGUser.realmGet$summaryAll();
        if (realmGet$summaryAll != null) {
            RealmList<RFGUserSummary> realmGet$summaryAll2 = newProxyInstance.realmGet$summaryAll();
            realmGet$summaryAll2.clear();
            for (int i6 = 0; i6 < realmGet$summaryAll.size(); i6++) {
                RFGUserSummary rFGUserSummary3 = realmGet$summaryAll.get(i6);
                RFGUserSummary rFGUserSummary4 = (RFGUserSummary) map2.get(rFGUserSummary3);
                if (rFGUserSummary4 == null) {
                    rFGUserSummary4 = jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls), rFGUserSummary3, z, map, set);
                }
                realmGet$summaryAll2.add(rFGUserSummary4);
            }
        }
        return newProxyInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.RFGUser copyOrUpdate(p041io.realm.Realm r8, p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy.RFGUserColumnInfo r9, p043jp.reifrontier.gym.domain.api.RFGUser r10, boolean r11, java.util.Map<p041io.realm.RealmModel, p041io.realm.internal.RealmObjectProxy> r12, java.util.Set<p041io.realm.ImportFlag> r13) {
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
            jp.reifrontier.gym.domain.api.RFGUser r1 = (p043jp.reifrontier.gym.domain.api.RFGUser) r1
            return r1
        L_0x004b:
            r1 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGUser> r2 = p043jp.reifrontier.gym.domain.api.RFGUser.class
            io.realm.internal.Table r2 = r8.getTable(r2)
            long r3 = r9.userIdIndex
            java.lang.String r5 = r10.realmGet$userId()
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
            io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy     // Catch:{ all -> 0x0081 }
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
            jp.reifrontier.gym.domain.api.RFGUser r8 = update(r1, r2, r3, r4, r5, r6)
            goto L_0x0098
        L_0x0094:
            jp.reifrontier.gym.domain.api.RFGUser r8 = copy(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy.copyOrUpdate(io.realm.Realm, io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy$RFGUserColumnInfo, jp.reifrontier.gym.domain.api.RFGUser, boolean, java.util.Map, java.util.Set):jp.reifrontier.gym.domain.api.RFGUser");
    }

    public static RFGUserColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RFGUserColumnInfo(osSchemaInfo);
    }

    public static RFGUser createDetachedCopy(RFGUser rFGUser, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RFGUser rFGUser2;
        if (i > i2 || rFGUser == null) {
            return null;
        }
        RealmObjectProxy.CacheData cacheData = map.get(rFGUser);
        if (cacheData == null) {
            rFGUser2 = new RFGUser();
            map.put(rFGUser, new RealmObjectProxy.CacheData(i, rFGUser2));
        } else if (i >= cacheData.minDepth) {
            return (RFGUser) cacheData.object;
        } else {
            cacheData.minDepth = i;
            rFGUser2 = (RFGUser) cacheData.object;
        }
        rFGUser2.realmSet$userId(rFGUser.realmGet$userId());
        rFGUser2.realmSet$firstDate(rFGUser.realmGet$firstDate());
        rFGUser2.realmSet$icon(rFGUser.realmGet$icon());
        rFGUser2.realmSet$gender(rFGUser.realmGet$gender());
        rFGUser2.realmSet$birthday(rFGUser.realmGet$birthday());
        rFGUser2.realmSet$email(rFGUser.realmGet$email());
        rFGUser2.realmSet$handleName(rFGUser.realmGet$handleName());
        rFGUser2.realmSet$pushAllow(rFGUser.realmGet$pushAllow());
        rFGUser2.realmSet$archiveCount(rFGUser.realmGet$archiveCount());
        if (i == i2) {
            rFGUser2.realmSet$heightHistory((RealmList<RFGHistory>) null);
        } else {
            RealmList<RFGHistory> realmGet$heightHistory = rFGUser.realmGet$heightHistory();
            RealmList realmList = new RealmList();
            rFGUser2.realmSet$heightHistory(realmList);
            int i3 = i + 1;
            int size = realmGet$heightHistory.size();
            for (int i4 = 0; i4 < size; i4++) {
                realmList.add(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createDetachedCopy(realmGet$heightHistory.get(i4), i3, i2, map));
            }
        }
        if (i == i2) {
            rFGUser2.realmSet$weightHistory((RealmList<RFGHistory>) null);
        } else {
            RealmList<RFGHistory> realmGet$weightHistory = rFGUser.realmGet$weightHistory();
            RealmList realmList2 = new RealmList();
            rFGUser2.realmSet$weightHistory(realmList2);
            int i5 = i + 1;
            int size2 = realmGet$weightHistory.size();
            for (int i6 = 0; i6 < size2; i6++) {
                realmList2.add(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createDetachedCopy(realmGet$weightHistory.get(i6), i5, i2, map));
            }
        }
        if (i == i2) {
            rFGUser2.realmSet$summaryToday((RealmList<RFGUserSummary>) null);
        } else {
            RealmList<RFGUserSummary> realmGet$summaryToday = rFGUser.realmGet$summaryToday();
            RealmList realmList3 = new RealmList();
            rFGUser2.realmSet$summaryToday(realmList3);
            int i7 = i + 1;
            int size3 = realmGet$summaryToday.size();
            for (int i8 = 0; i8 < size3; i8++) {
                realmList3.add(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createDetachedCopy(realmGet$summaryToday.get(i8), i7, i2, map));
            }
        }
        if (i == i2) {
            rFGUser2.realmSet$summaryAll((RealmList<RFGUserSummary>) null);
        } else {
            RealmList<RFGUserSummary> realmGet$summaryAll = rFGUser.realmGet$summaryAll();
            RealmList realmList4 = new RealmList();
            rFGUser2.realmSet$summaryAll(realmList4);
            int i9 = i + 1;
            int size4 = realmGet$summaryAll.size();
            for (int i10 = 0; i10 < size4; i10++) {
                realmList4.add(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createDetachedCopy(realmGet$summaryAll.get(i10), i9, i2, map));
            }
        }
        return rFGUser2;
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(ClassNameHelper.INTERNAL_CLASS_NAME, 13, 0);
        OsObjectSchemaInfo.Builder builder2 = builder;
        builder2.addPersistedProperty("userId", RealmFieldType.STRING, true, true, true);
        builder2.addPersistedProperty("firstDate", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("icon", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("gender", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("birthday", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("email", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("handleName", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("pushAllow", RealmFieldType.STRING, false, false, true);
        builder2.addPersistedProperty("archiveCount", RealmFieldType.STRING, false, false, true);
        builder.addPersistedLinkProperty("heightHistory", RealmFieldType.LIST, jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("weightHistory", RealmFieldType.LIST, jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("summaryToday", RealmFieldType.LIST, jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        builder.addPersistedLinkProperty("summaryAll", RealmFieldType.LIST, jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p043jp.reifrontier.gym.domain.api.RFGUser createOrUpdateUsingJsonObject(p041io.realm.Realm r14, org.json.JSONObject r15, boolean r16) throws org.json.JSONException {
        /*
            r0 = r14
            r7 = r15
            r8 = r16
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGUser> r9 = p043jp.reifrontier.gym.domain.api.RFGUser.class
            java.util.ArrayList r10 = new java.util.ArrayList
            r1 = 4
            r10.<init>(r1)
            java.lang.String r11 = "userId"
            r12 = 0
            if (r8 == 0) goto L_0x0064
            io.realm.internal.Table r1 = r14.getTable(r9)
            io.realm.RealmSchema r2 = r14.getSchema()
            io.realm.internal.ColumnInfo r2 = r2.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r9)
            io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy$RFGUserColumnInfo r2 = (p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy.RFGUserColumnInfo) r2
            long r2 = r2.userIdIndex
            boolean r4 = r15.isNull(r11)
            r5 = -1
            if (r4 != 0) goto L_0x0032
            java.lang.String r4 = r15.getString(r11)
            long r2 = r1.findFirstString(r2, r4)
            goto L_0x0033
        L_0x0032:
            r2 = r5
        L_0x0033:
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0064
            io.realm.BaseRealm$ThreadLocalRealmObjectContext r4 = p041io.realm.BaseRealm.objectContext
            java.lang.Object r4 = r4.get()
            r13 = r4
            io.realm.BaseRealm$RealmObjectContext r13 = (p041io.realm.BaseRealm.RealmObjectContext) r13
            io.realm.internal.UncheckedRow r3 = r1.getUncheckedRow(r2)     // Catch:{ all -> 0x005f }
            io.realm.RealmSchema r1 = r14.getSchema()     // Catch:{ all -> 0x005f }
            io.realm.internal.ColumnInfo r4 = r1.getColumnInfo((java.lang.Class<? extends p041io.realm.RealmModel>) r9)     // Catch:{ all -> 0x005f }
            r5 = 0
            java.util.List r6 = java.util.Collections.emptyList()     // Catch:{ all -> 0x005f }
            r1 = r13
            r2 = r14
            r1.set(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x005f }
            io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy r1 = new io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy     // Catch:{ all -> 0x005f }
            r1.<init>()     // Catch:{ all -> 0x005f }
            r13.clear()
            goto L_0x0065
        L_0x005f:
            r0 = move-exception
            r13.clear()
            throw r0
        L_0x0064:
            r1 = r12
        L_0x0065:
            java.lang.String r2 = "summaryAll"
            java.lang.String r3 = "summaryToday"
            java.lang.String r4 = "weightHistory"
            java.lang.String r5 = "heightHistory"
            if (r1 != 0) goto L_0x00b8
            boolean r1 = r15.has(r5)
            if (r1 == 0) goto L_0x0078
            r10.add(r5)
        L_0x0078:
            boolean r1 = r15.has(r4)
            if (r1 == 0) goto L_0x0081
            r10.add(r4)
        L_0x0081:
            boolean r1 = r15.has(r3)
            if (r1 == 0) goto L_0x008a
            r10.add(r3)
        L_0x008a:
            boolean r1 = r15.has(r2)
            if (r1 == 0) goto L_0x0093
            r10.add(r2)
        L_0x0093:
            boolean r1 = r15.has(r11)
            if (r1 == 0) goto L_0x00b0
            boolean r1 = r15.isNull(r11)
            r6 = 1
            if (r1 == 0) goto L_0x00a5
            io.realm.RealmModel r1 = r14.createObjectInternal(r9, r12, r6, r10)
            goto L_0x00ad
        L_0x00a5:
            java.lang.String r1 = r15.getString(r11)
            io.realm.RealmModel r1 = r14.createObjectInternal(r9, r1, r6, r10)
        L_0x00ad:
            io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy r1 = (p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy) r1
            goto L_0x00b8
        L_0x00b0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "JSON object doesn't have the primary key field 'userId'."
            r0.<init>(r1)
            throw r0
        L_0x00b8:
            java.lang.String r6 = "firstDate"
            boolean r9 = r15.has(r6)
            if (r9 == 0) goto L_0x00d1
            boolean r9 = r15.isNull(r6)
            if (r9 == 0) goto L_0x00ca
            r1.realmSet$firstDate(r12)
            goto L_0x00d1
        L_0x00ca:
            java.lang.String r6 = r15.getString(r6)
            r1.realmSet$firstDate(r6)
        L_0x00d1:
            java.lang.String r6 = "icon"
            boolean r9 = r15.has(r6)
            if (r9 == 0) goto L_0x00ea
            boolean r9 = r15.isNull(r6)
            if (r9 == 0) goto L_0x00e3
            r1.realmSet$icon(r12)
            goto L_0x00ea
        L_0x00e3:
            java.lang.String r6 = r15.getString(r6)
            r1.realmSet$icon(r6)
        L_0x00ea:
            java.lang.String r6 = "gender"
            boolean r9 = r15.has(r6)
            if (r9 == 0) goto L_0x0103
            boolean r9 = r15.isNull(r6)
            if (r9 == 0) goto L_0x00fc
            r1.realmSet$gender(r12)
            goto L_0x0103
        L_0x00fc:
            java.lang.String r6 = r15.getString(r6)
            r1.realmSet$gender(r6)
        L_0x0103:
            java.lang.String r6 = "birthday"
            boolean r9 = r15.has(r6)
            if (r9 == 0) goto L_0x011c
            boolean r9 = r15.isNull(r6)
            if (r9 == 0) goto L_0x0115
            r1.realmSet$birthday(r12)
            goto L_0x011c
        L_0x0115:
            java.lang.String r6 = r15.getString(r6)
            r1.realmSet$birthday(r6)
        L_0x011c:
            java.lang.String r6 = "email"
            boolean r9 = r15.has(r6)
            if (r9 == 0) goto L_0x0135
            boolean r9 = r15.isNull(r6)
            if (r9 == 0) goto L_0x012e
            r1.realmSet$email(r12)
            goto L_0x0135
        L_0x012e:
            java.lang.String r6 = r15.getString(r6)
            r1.realmSet$email(r6)
        L_0x0135:
            java.lang.String r6 = "handleName"
            boolean r9 = r15.has(r6)
            if (r9 == 0) goto L_0x014e
            boolean r9 = r15.isNull(r6)
            if (r9 == 0) goto L_0x0147
            r1.realmSet$handleName(r12)
            goto L_0x014e
        L_0x0147:
            java.lang.String r6 = r15.getString(r6)
            r1.realmSet$handleName(r6)
        L_0x014e:
            java.lang.String r6 = "pushAllow"
            boolean r9 = r15.has(r6)
            if (r9 == 0) goto L_0x0167
            boolean r9 = r15.isNull(r6)
            if (r9 == 0) goto L_0x0160
            r1.realmSet$pushAllow(r12)
            goto L_0x0167
        L_0x0160:
            java.lang.String r6 = r15.getString(r6)
            r1.realmSet$pushAllow(r6)
        L_0x0167:
            java.lang.String r6 = "archiveCount"
            boolean r9 = r15.has(r6)
            if (r9 == 0) goto L_0x0180
            boolean r9 = r15.isNull(r6)
            if (r9 == 0) goto L_0x0179
            r1.realmSet$archiveCount(r12)
            goto L_0x0180
        L_0x0179:
            java.lang.String r6 = r15.getString(r6)
            r1.realmSet$archiveCount(r6)
        L_0x0180:
            boolean r6 = r15.has(r5)
            r9 = 0
            if (r6 == 0) goto L_0x01b5
            boolean r6 = r15.isNull(r5)
            if (r6 == 0) goto L_0x0191
            r1.realmSet$heightHistory(r12)
            goto L_0x01b5
        L_0x0191:
            io.realm.RealmList r6 = r1.realmGet$heightHistory()
            r6.clear()
            org.json.JSONArray r5 = r15.getJSONArray(r5)
            r6 = 0
        L_0x019d:
            int r10 = r5.length()
            if (r6 >= r10) goto L_0x01b5
            org.json.JSONObject r10 = r5.getJSONObject(r6)
            jp.reifrontier.gym.domain.api.RFGHistory r10 = p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createOrUpdateUsingJsonObject(r14, r10, r8)
            io.realm.RealmList r11 = r1.realmGet$heightHistory()
            r11.add(r10)
            int r6 = r6 + 1
            goto L_0x019d
        L_0x01b5:
            boolean r5 = r15.has(r4)
            if (r5 == 0) goto L_0x01e9
            boolean r5 = r15.isNull(r4)
            if (r5 == 0) goto L_0x01c5
            r1.realmSet$weightHistory(r12)
            goto L_0x01e9
        L_0x01c5:
            io.realm.RealmList r5 = r1.realmGet$weightHistory()
            r5.clear()
            org.json.JSONArray r4 = r15.getJSONArray(r4)
            r5 = 0
        L_0x01d1:
            int r6 = r4.length()
            if (r5 >= r6) goto L_0x01e9
            org.json.JSONObject r6 = r4.getJSONObject(r5)
            jp.reifrontier.gym.domain.api.RFGHistory r6 = p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createOrUpdateUsingJsonObject(r14, r6, r8)
            io.realm.RealmList r10 = r1.realmGet$weightHistory()
            r10.add(r6)
            int r5 = r5 + 1
            goto L_0x01d1
        L_0x01e9:
            boolean r4 = r15.has(r3)
            if (r4 == 0) goto L_0x021d
            boolean r4 = r15.isNull(r3)
            if (r4 == 0) goto L_0x01f9
            r1.realmSet$summaryToday(r12)
            goto L_0x021d
        L_0x01f9:
            io.realm.RealmList r4 = r1.realmGet$summaryToday()
            r4.clear()
            org.json.JSONArray r3 = r15.getJSONArray(r3)
            r4 = 0
        L_0x0205:
            int r5 = r3.length()
            if (r4 >= r5) goto L_0x021d
            org.json.JSONObject r5 = r3.getJSONObject(r4)
            jp.reifrontier.gym.domain.api.RFGUserSummary r5 = p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createOrUpdateUsingJsonObject(r14, r5, r8)
            io.realm.RealmList r6 = r1.realmGet$summaryToday()
            r6.add(r5)
            int r4 = r4 + 1
            goto L_0x0205
        L_0x021d:
            boolean r3 = r15.has(r2)
            if (r3 == 0) goto L_0x0250
            boolean r3 = r15.isNull(r2)
            if (r3 == 0) goto L_0x022d
            r1.realmSet$summaryAll(r12)
            goto L_0x0250
        L_0x022d:
            io.realm.RealmList r3 = r1.realmGet$summaryAll()
            r3.clear()
            org.json.JSONArray r2 = r15.getJSONArray(r2)
        L_0x0238:
            int r3 = r2.length()
            if (r9 >= r3) goto L_0x0250
            org.json.JSONObject r3 = r2.getJSONObject(r9)
            jp.reifrontier.gym.domain.api.RFGUserSummary r3 = p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createOrUpdateUsingJsonObject(r14, r3, r8)
            io.realm.RealmList r4 = r1.realmGet$summaryAll()
            r4.add(r3)
            int r9 = r9 + 1
            goto L_0x0238
        L_0x0250:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy.createOrUpdateUsingJsonObject(io.realm.Realm, org.json.JSONObject, boolean):jp.reifrontier.gym.domain.api.RFGUser");
    }

    @TargetApi(11)
    public static RFGUser createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RFGUser rFGUser = new RFGUser();
        jsonReader.beginObject();
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("userId")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUser.realmSet$userId(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUser.realmSet$userId((String) null);
                }
                z = true;
            } else if (nextName.equals("firstDate")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUser.realmSet$firstDate(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUser.realmSet$firstDate((String) null);
                }
            } else if (nextName.equals("icon")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUser.realmSet$icon(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUser.realmSet$icon((String) null);
                }
            } else if (nextName.equals("gender")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUser.realmSet$gender(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUser.realmSet$gender((String) null);
                }
            } else if (nextName.equals("birthday")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUser.realmSet$birthday(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUser.realmSet$birthday((String) null);
                }
            } else if (nextName.equals("email")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUser.realmSet$email(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUser.realmSet$email((String) null);
                }
            } else if (nextName.equals("handleName")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUser.realmSet$handleName(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUser.realmSet$handleName((String) null);
                }
            } else if (nextName.equals("pushAllow")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    rFGUser.realmSet$pushAllow(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    rFGUser.realmSet$pushAllow((String) null);
                }
            } else if (!nextName.equals("archiveCount")) {
                if (nextName.equals("heightHistory")) {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.skipValue();
                        rFGUser.realmSet$heightHistory((RealmList<RFGHistory>) null);
                    } else {
                        rFGUser.realmSet$heightHistory(new RealmList());
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            rFGUser.realmGet$heightHistory().add(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createUsingJsonStream(realm, jsonReader));
                        }
                    }
                } else if (nextName.equals("weightHistory")) {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.skipValue();
                        rFGUser.realmSet$weightHistory((RealmList<RFGHistory>) null);
                    } else {
                        rFGUser.realmSet$weightHistory(new RealmList());
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            rFGUser.realmGet$weightHistory().add(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createUsingJsonStream(realm, jsonReader));
                        }
                    }
                } else if (nextName.equals("summaryToday")) {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.skipValue();
                        rFGUser.realmSet$summaryToday((RealmList<RFGUserSummary>) null);
                    } else {
                        rFGUser.realmSet$summaryToday(new RealmList());
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            rFGUser.realmGet$summaryToday().add(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createUsingJsonStream(realm, jsonReader));
                        }
                    }
                } else if (!nextName.equals("summaryAll")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    rFGUser.realmSet$summaryAll((RealmList<RFGUserSummary>) null);
                } else {
                    rFGUser.realmSet$summaryAll(new RealmList());
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        rFGUser.realmGet$summaryAll().add(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createUsingJsonStream(realm, jsonReader));
                    }
                }
                jsonReader.endArray();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                rFGUser.realmSet$archiveCount(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                rFGUser.realmSet$archiveCount((String) null);
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RFGUser) realm.copyToRealm(rFGUser, new ImportFlag[0]);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static String getSimpleClassName() {
        return ClassNameHelper.INTERNAL_CLASS_NAME;
    }

    public static long insert(Realm realm, RFGUser rFGUser, Map<RealmModel, Long> map) {
        long j;
        long j2;
        Realm realm2 = realm;
        RFGUser rFGUser2 = rFGUser;
        Map<RealmModel, Long> map2 = map;
        Class<RFGUser> cls = RFGUser.class;
        if (rFGUser2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUser2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGUserColumnInfo rFGUserColumnInfo = (RFGUserColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGUserColumnInfo.userIdIndex;
        String realmGet$userId = rFGUser.realmGet$userId();
        long nativeFindFirstString = realmGet$userId != null ? Table.nativeFindFirstString(nativePtr, j3, realmGet$userId) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j3, realmGet$userId);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$userId);
        }
        long j4 = nativeFindFirstString;
        map2.put(rFGUser2, Long.valueOf(j4));
        String realmGet$firstDate = rFGUser.realmGet$firstDate();
        if (realmGet$firstDate != null) {
            j = j4;
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.firstDateIndex, j4, realmGet$firstDate, false);
        } else {
            j = j4;
        }
        String realmGet$icon = rFGUser.realmGet$icon();
        if (realmGet$icon != null) {
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.iconIndex, j, realmGet$icon, false);
        }
        String realmGet$gender = rFGUser.realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.genderIndex, j, realmGet$gender, false);
        }
        String realmGet$birthday = rFGUser.realmGet$birthday();
        if (realmGet$birthday != null) {
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.birthdayIndex, j, realmGet$birthday, false);
        }
        String realmGet$email = rFGUser.realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.emailIndex, j, realmGet$email, false);
        }
        String realmGet$handleName = rFGUser.realmGet$handleName();
        if (realmGet$handleName != null) {
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.handleNameIndex, j, realmGet$handleName, false);
        }
        String realmGet$pushAllow = rFGUser.realmGet$pushAllow();
        if (realmGet$pushAllow != null) {
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.pushAllowIndex, j, realmGet$pushAllow, false);
        }
        String realmGet$archiveCount = rFGUser.realmGet$archiveCount();
        if (realmGet$archiveCount != null) {
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.archiveCountIndex, j, realmGet$archiveCount, false);
        }
        RealmList<RFGHistory> realmGet$heightHistory = rFGUser.realmGet$heightHistory();
        if (realmGet$heightHistory != null) {
            j2 = j;
            OsList osList = new OsList(table.getUncheckedRow(j2), rFGUserColumnInfo.heightHistoryIndex);
            Iterator<RFGHistory> it = realmGet$heightHistory.iterator();
            while (it.hasNext()) {
                RFGHistory next = it.next();
                Long l = map2.get(next);
                if (l == null) {
                    l = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insert(realm2, next, map2));
                }
                osList.addRow(l.longValue());
            }
        } else {
            j2 = j;
        }
        RealmList<RFGHistory> realmGet$weightHistory = rFGUser.realmGet$weightHistory();
        if (realmGet$weightHistory != null) {
            OsList osList2 = new OsList(table.getUncheckedRow(j2), rFGUserColumnInfo.weightHistoryIndex);
            Iterator<RFGHistory> it2 = realmGet$weightHistory.iterator();
            while (it2.hasNext()) {
                RFGHistory next2 = it2.next();
                Long l2 = map2.get(next2);
                if (l2 == null) {
                    l2 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insert(realm2, next2, map2));
                }
                osList2.addRow(l2.longValue());
            }
        }
        RealmList<RFGUserSummary> realmGet$summaryToday = rFGUser.realmGet$summaryToday();
        if (realmGet$summaryToday != null) {
            OsList osList3 = new OsList(table.getUncheckedRow(j2), rFGUserColumnInfo.summaryTodayIndex);
            Iterator<RFGUserSummary> it3 = realmGet$summaryToday.iterator();
            while (it3.hasNext()) {
                RFGUserSummary next3 = it3.next();
                Long l3 = map2.get(next3);
                if (l3 == null) {
                    l3 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insert(realm2, next3, map2));
                }
                osList3.addRow(l3.longValue());
            }
        }
        RealmList<RFGUserSummary> realmGet$summaryAll = rFGUser.realmGet$summaryAll();
        if (realmGet$summaryAll != null) {
            OsList osList4 = new OsList(table.getUncheckedRow(j2), rFGUserColumnInfo.summaryAllIndex);
            Iterator<RFGUserSummary> it4 = realmGet$summaryAll.iterator();
            while (it4.hasNext()) {
                RFGUserSummary next4 = it4.next();
                Long l4 = map2.get(next4);
                if (l4 == null) {
                    l4 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insert(realm2, next4, map2));
                }
                osList4.addRow(l4.longValue());
            }
        }
        return j2;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        RFGUser rFGUser;
        long j;
        long j2;
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGUser> cls = RFGUser.class;
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGUserColumnInfo rFGUserColumnInfo = (RFGUserColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j3 = rFGUserColumnInfo.userIdIndex;
        while (it.hasNext()) {
            RFGUser rFGUser2 = (RFGUser) it.next();
            if (!map2.containsKey(rFGUser2)) {
                if (rFGUser2 instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUser2;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGUser2, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$userId = rFGUser2.realmGet$userId();
                long nativeFindFirstString = realmGet$userId != null ? Table.nativeFindFirstString(nativePtr, j3, realmGet$userId) : -1;
                if (nativeFindFirstString == -1) {
                    nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j3, realmGet$userId);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$userId);
                }
                long j4 = nativeFindFirstString;
                map2.put(rFGUser2, Long.valueOf(j4));
                String realmGet$firstDate = rFGUser2.realmGet$firstDate();
                if (realmGet$firstDate != null) {
                    j = j4;
                    rFGUser = rFGUser2;
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.firstDateIndex, j4, realmGet$firstDate, false);
                } else {
                    j = j4;
                    rFGUser = rFGUser2;
                }
                String realmGet$icon = rFGUser.realmGet$icon();
                if (realmGet$icon != null) {
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.iconIndex, j, realmGet$icon, false);
                }
                String realmGet$gender = rFGUser.realmGet$gender();
                if (realmGet$gender != null) {
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.genderIndex, j, realmGet$gender, false);
                }
                String realmGet$birthday = rFGUser.realmGet$birthday();
                if (realmGet$birthday != null) {
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.birthdayIndex, j, realmGet$birthday, false);
                }
                String realmGet$email = rFGUser.realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.emailIndex, j, realmGet$email, false);
                }
                String realmGet$handleName = rFGUser.realmGet$handleName();
                if (realmGet$handleName != null) {
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.handleNameIndex, j, realmGet$handleName, false);
                }
                String realmGet$pushAllow = rFGUser.realmGet$pushAllow();
                if (realmGet$pushAllow != null) {
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.pushAllowIndex, j, realmGet$pushAllow, false);
                }
                String realmGet$archiveCount = rFGUser.realmGet$archiveCount();
                if (realmGet$archiveCount != null) {
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.archiveCountIndex, j, realmGet$archiveCount, false);
                }
                RealmList<RFGHistory> realmGet$heightHistory = rFGUser.realmGet$heightHistory();
                if (realmGet$heightHistory != null) {
                    j2 = j;
                    OsList osList = new OsList(table.getUncheckedRow(j2), rFGUserColumnInfo.heightHistoryIndex);
                    Iterator<RFGHistory> it2 = realmGet$heightHistory.iterator();
                    while (it2.hasNext()) {
                        RFGHistory next = it2.next();
                        Long l = map2.get(next);
                        if (l == null) {
                            l = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insert(realm2, next, map2));
                        }
                        osList.addRow(l.longValue());
                    }
                } else {
                    j2 = j;
                }
                RealmList<RFGHistory> realmGet$weightHistory = rFGUser.realmGet$weightHistory();
                if (realmGet$weightHistory != null) {
                    OsList osList2 = new OsList(table.getUncheckedRow(j2), rFGUserColumnInfo.weightHistoryIndex);
                    Iterator<RFGHistory> it3 = realmGet$weightHistory.iterator();
                    while (it3.hasNext()) {
                        RFGHistory next2 = it3.next();
                        Long l2 = map2.get(next2);
                        if (l2 == null) {
                            l2 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insert(realm2, next2, map2));
                        }
                        osList2.addRow(l2.longValue());
                    }
                }
                RealmList<RFGUserSummary> realmGet$summaryToday = rFGUser.realmGet$summaryToday();
                if (realmGet$summaryToday != null) {
                    OsList osList3 = new OsList(table.getUncheckedRow(j2), rFGUserColumnInfo.summaryTodayIndex);
                    Iterator<RFGUserSummary> it4 = realmGet$summaryToday.iterator();
                    while (it4.hasNext()) {
                        RFGUserSummary next3 = it4.next();
                        Long l3 = map2.get(next3);
                        if (l3 == null) {
                            l3 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insert(realm2, next3, map2));
                        }
                        osList3.addRow(l3.longValue());
                    }
                }
                RealmList<RFGUserSummary> realmGet$summaryAll = rFGUser.realmGet$summaryAll();
                if (realmGet$summaryAll != null) {
                    OsList osList4 = new OsList(table.getUncheckedRow(j2), rFGUserColumnInfo.summaryAllIndex);
                    Iterator<RFGUserSummary> it5 = realmGet$summaryAll.iterator();
                    while (it5.hasNext()) {
                        RFGUserSummary next4 = it5.next();
                        Long l4 = map2.get(next4);
                        if (l4 == null) {
                            l4 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insert(realm2, next4, map2));
                        }
                        osList4.addRow(l4.longValue());
                    }
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RFGUser rFGUser, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        RFGUser rFGUser2 = rFGUser;
        Map<RealmModel, Long> map2 = map;
        Class<RFGUser> cls = RFGUser.class;
        if (rFGUser2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUser2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return C0681a.m304a(realmObjectProxy);
            }
        }
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGUserColumnInfo rFGUserColumnInfo = (RFGUserColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j2 = rFGUserColumnInfo.userIdIndex;
        String realmGet$userId = rFGUser.realmGet$userId();
        long nativeFindFirstString = realmGet$userId != null ? Table.nativeFindFirstString(nativePtr, j2, realmGet$userId) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j2, realmGet$userId);
        }
        long j3 = nativeFindFirstString;
        map2.put(rFGUser2, Long.valueOf(j3));
        String realmGet$firstDate = rFGUser.realmGet$firstDate();
        if (realmGet$firstDate != null) {
            j = j3;
            Table.nativeSetString(nativePtr, rFGUserColumnInfo.firstDateIndex, j3, realmGet$firstDate, false);
        } else {
            j = j3;
            Table.nativeSetNull(nativePtr, rFGUserColumnInfo.firstDateIndex, j, false);
        }
        String realmGet$icon = rFGUser.realmGet$icon();
        long j4 = rFGUserColumnInfo.iconIndex;
        if (realmGet$icon != null) {
            Table.nativeSetString(nativePtr, j4, j, realmGet$icon, false);
        } else {
            Table.nativeSetNull(nativePtr, j4, j, false);
        }
        String realmGet$gender = rFGUser.realmGet$gender();
        long j5 = rFGUserColumnInfo.genderIndex;
        if (realmGet$gender != null) {
            Table.nativeSetString(nativePtr, j5, j, realmGet$gender, false);
        } else {
            Table.nativeSetNull(nativePtr, j5, j, false);
        }
        String realmGet$birthday = rFGUser.realmGet$birthday();
        long j6 = rFGUserColumnInfo.birthdayIndex;
        if (realmGet$birthday != null) {
            Table.nativeSetString(nativePtr, j6, j, realmGet$birthday, false);
        } else {
            Table.nativeSetNull(nativePtr, j6, j, false);
        }
        String realmGet$email = rFGUser.realmGet$email();
        long j7 = rFGUserColumnInfo.emailIndex;
        if (realmGet$email != null) {
            Table.nativeSetString(nativePtr, j7, j, realmGet$email, false);
        } else {
            Table.nativeSetNull(nativePtr, j7, j, false);
        }
        String realmGet$handleName = rFGUser.realmGet$handleName();
        long j8 = rFGUserColumnInfo.handleNameIndex;
        if (realmGet$handleName != null) {
            Table.nativeSetString(nativePtr, j8, j, realmGet$handleName, false);
        } else {
            Table.nativeSetNull(nativePtr, j8, j, false);
        }
        String realmGet$pushAllow = rFGUser.realmGet$pushAllow();
        long j9 = rFGUserColumnInfo.pushAllowIndex;
        if (realmGet$pushAllow != null) {
            Table.nativeSetString(nativePtr, j9, j, realmGet$pushAllow, false);
        } else {
            Table.nativeSetNull(nativePtr, j9, j, false);
        }
        String realmGet$archiveCount = rFGUser.realmGet$archiveCount();
        long j10 = rFGUserColumnInfo.archiveCountIndex;
        if (realmGet$archiveCount != null) {
            Table.nativeSetString(nativePtr, j10, j, realmGet$archiveCount, false);
        } else {
            Table.nativeSetNull(nativePtr, j10, j, false);
        }
        long j11 = j;
        OsList osList = new OsList(table.getUncheckedRow(j11), rFGUserColumnInfo.heightHistoryIndex);
        RealmList<RFGHistory> realmGet$heightHistory = rFGUser.realmGet$heightHistory();
        if (realmGet$heightHistory == null || ((long) realmGet$heightHistory.size()) != osList.size()) {
            osList.removeAll();
            if (realmGet$heightHistory != null) {
                Iterator<RFGHistory> it = realmGet$heightHistory.iterator();
                while (it.hasNext()) {
                    RFGHistory next = it.next();
                    Long l = map2.get(next);
                    if (l == null) {
                        l = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm2, next, map2));
                    }
                    osList.addRow(l.longValue());
                }
            }
        } else {
            int size = realmGet$heightHistory.size();
            for (int i = 0; i < size; i++) {
                RFGHistory rFGHistory = realmGet$heightHistory.get(i);
                Long l2 = map2.get(rFGHistory);
                if (l2 == null) {
                    l2 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm2, rFGHistory, map2));
                }
                osList.setRow((long) i, l2.longValue());
            }
        }
        OsList osList2 = new OsList(table.getUncheckedRow(j11), rFGUserColumnInfo.weightHistoryIndex);
        RealmList<RFGHistory> realmGet$weightHistory = rFGUser.realmGet$weightHistory();
        if (realmGet$weightHistory == null || ((long) realmGet$weightHistory.size()) != osList2.size()) {
            osList2.removeAll();
            if (realmGet$weightHistory != null) {
                Iterator<RFGHistory> it2 = realmGet$weightHistory.iterator();
                while (it2.hasNext()) {
                    RFGHistory next2 = it2.next();
                    Long l3 = map2.get(next2);
                    if (l3 == null) {
                        l3 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm2, next2, map2));
                    }
                    osList2.addRow(l3.longValue());
                }
            }
        } else {
            int size2 = realmGet$weightHistory.size();
            for (int i2 = 0; i2 < size2; i2++) {
                RFGHistory rFGHistory2 = realmGet$weightHistory.get(i2);
                Long l4 = map2.get(rFGHistory2);
                if (l4 == null) {
                    l4 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm2, rFGHistory2, map2));
                }
                osList2.setRow((long) i2, l4.longValue());
            }
        }
        OsList osList3 = new OsList(table.getUncheckedRow(j11), rFGUserColumnInfo.summaryTodayIndex);
        RealmList<RFGUserSummary> realmGet$summaryToday = rFGUser.realmGet$summaryToday();
        if (realmGet$summaryToday == null || ((long) realmGet$summaryToday.size()) != osList3.size()) {
            osList3.removeAll();
            if (realmGet$summaryToday != null) {
                Iterator<RFGUserSummary> it3 = realmGet$summaryToday.iterator();
                while (it3.hasNext()) {
                    RFGUserSummary next3 = it3.next();
                    Long l5 = map2.get(next3);
                    if (l5 == null) {
                        l5 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm2, next3, map2));
                    }
                    osList3.addRow(l5.longValue());
                }
            }
        } else {
            int size3 = realmGet$summaryToday.size();
            for (int i3 = 0; i3 < size3; i3++) {
                RFGUserSummary rFGUserSummary = realmGet$summaryToday.get(i3);
                Long l6 = map2.get(rFGUserSummary);
                if (l6 == null) {
                    l6 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm2, rFGUserSummary, map2));
                }
                osList3.setRow((long) i3, l6.longValue());
            }
        }
        OsList osList4 = new OsList(table.getUncheckedRow(j11), rFGUserColumnInfo.summaryAllIndex);
        RealmList<RFGUserSummary> realmGet$summaryAll = rFGUser.realmGet$summaryAll();
        if (realmGet$summaryAll == null || ((long) realmGet$summaryAll.size()) != osList4.size()) {
            osList4.removeAll();
            if (realmGet$summaryAll != null) {
                Iterator<RFGUserSummary> it4 = realmGet$summaryAll.iterator();
                while (it4.hasNext()) {
                    RFGUserSummary next4 = it4.next();
                    Long l7 = map2.get(next4);
                    if (l7 == null) {
                        l7 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm2, next4, map2));
                    }
                    osList4.addRow(l7.longValue());
                }
            }
        } else {
            int size4 = realmGet$summaryAll.size();
            for (int i4 = 0; i4 < size4; i4++) {
                RFGUserSummary rFGUserSummary2 = realmGet$summaryAll.get(i4);
                Long l8 = map2.get(rFGUserSummary2);
                if (l8 == null) {
                    l8 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm2, rFGUserSummary2, map2));
                }
                osList4.setRow((long) i4, l8.longValue());
            }
        }
        return j11;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        RFGUser rFGUser;
        long j;
        long j2;
        long j3;
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Class<RFGUser> cls = RFGUser.class;
        Table table = realm2.getTable(cls);
        long nativePtr = table.getNativePtr();
        RFGUserColumnInfo rFGUserColumnInfo = (RFGUserColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls);
        long j4 = rFGUserColumnInfo.userIdIndex;
        while (it.hasNext()) {
            RFGUser rFGUser2 = (RFGUser) it.next();
            if (!map2.containsKey(rFGUser2)) {
                if (rFGUser2 instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) rFGUser2;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(rFGUser2, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                String realmGet$userId = rFGUser2.realmGet$userId();
                long nativeFindFirstString = realmGet$userId != null ? Table.nativeFindFirstString(nativePtr, j4, realmGet$userId) : -1;
                if (nativeFindFirstString == -1) {
                    nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j4, realmGet$userId);
                }
                long j5 = nativeFindFirstString;
                map2.put(rFGUser2, Long.valueOf(j5));
                String realmGet$firstDate = rFGUser2.realmGet$firstDate();
                if (realmGet$firstDate != null) {
                    j = j5;
                    rFGUser = rFGUser2;
                    Table.nativeSetString(nativePtr, rFGUserColumnInfo.firstDateIndex, j5, realmGet$firstDate, false);
                } else {
                    j = j5;
                    rFGUser = rFGUser2;
                    Table.nativeSetNull(nativePtr, rFGUserColumnInfo.firstDateIndex, j5, false);
                }
                String realmGet$icon = rFGUser.realmGet$icon();
                long j6 = rFGUserColumnInfo.iconIndex;
                if (realmGet$icon != null) {
                    Table.nativeSetString(nativePtr, j6, j, realmGet$icon, false);
                } else {
                    Table.nativeSetNull(nativePtr, j6, j, false);
                }
                String realmGet$gender = rFGUser.realmGet$gender();
                long j7 = rFGUserColumnInfo.genderIndex;
                if (realmGet$gender != null) {
                    Table.nativeSetString(nativePtr, j7, j, realmGet$gender, false);
                } else {
                    Table.nativeSetNull(nativePtr, j7, j, false);
                }
                String realmGet$birthday = rFGUser.realmGet$birthday();
                long j8 = rFGUserColumnInfo.birthdayIndex;
                if (realmGet$birthday != null) {
                    Table.nativeSetString(nativePtr, j8, j, realmGet$birthday, false);
                } else {
                    Table.nativeSetNull(nativePtr, j8, j, false);
                }
                String realmGet$email = rFGUser.realmGet$email();
                long j9 = rFGUserColumnInfo.emailIndex;
                if (realmGet$email != null) {
                    Table.nativeSetString(nativePtr, j9, j, realmGet$email, false);
                } else {
                    Table.nativeSetNull(nativePtr, j9, j, false);
                }
                String realmGet$handleName = rFGUser.realmGet$handleName();
                long j10 = rFGUserColumnInfo.handleNameIndex;
                if (realmGet$handleName != null) {
                    Table.nativeSetString(nativePtr, j10, j, realmGet$handleName, false);
                } else {
                    Table.nativeSetNull(nativePtr, j10, j, false);
                }
                String realmGet$pushAllow = rFGUser.realmGet$pushAllow();
                long j11 = rFGUserColumnInfo.pushAllowIndex;
                if (realmGet$pushAllow != null) {
                    Table.nativeSetString(nativePtr, j11, j, realmGet$pushAllow, false);
                } else {
                    Table.nativeSetNull(nativePtr, j11, j, false);
                }
                String realmGet$archiveCount = rFGUser.realmGet$archiveCount();
                long j12 = rFGUserColumnInfo.archiveCountIndex;
                if (realmGet$archiveCount != null) {
                    Table.nativeSetString(nativePtr, j12, j, realmGet$archiveCount, false);
                } else {
                    Table.nativeSetNull(nativePtr, j12, j, false);
                }
                long j13 = j;
                OsList osList = new OsList(table.getUncheckedRow(j13), rFGUserColumnInfo.heightHistoryIndex);
                RealmList<RFGHistory> realmGet$heightHistory = rFGUser.realmGet$heightHistory();
                if (realmGet$heightHistory == null || ((long) realmGet$heightHistory.size()) != osList.size()) {
                    j2 = j13;
                    osList.removeAll();
                    if (realmGet$heightHistory != null) {
                        Iterator<RFGHistory> it2 = realmGet$heightHistory.iterator();
                        while (it2.hasNext()) {
                            RFGHistory next = it2.next();
                            Long l = map2.get(next);
                            if (l == null) {
                                l = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm2, next, map2));
                            }
                            osList.addRow(l.longValue());
                        }
                    }
                } else {
                    int size = realmGet$heightHistory.size();
                    int i = 0;
                    while (i < size) {
                        RFGHistory rFGHistory = realmGet$heightHistory.get(i);
                        Long l2 = map2.get(rFGHistory);
                        if (l2 == null) {
                            l2 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm2, rFGHistory, map2));
                        }
                        osList.setRow((long) i, l2.longValue());
                        i++;
                        size = size;
                        j13 = j13;
                    }
                    j2 = j13;
                }
                long j14 = j2;
                OsList osList2 = new OsList(table.getUncheckedRow(j14), rFGUserColumnInfo.weightHistoryIndex);
                RealmList<RFGHistory> realmGet$weightHistory = rFGUser.realmGet$weightHistory();
                if (realmGet$weightHistory == null || ((long) realmGet$weightHistory.size()) != osList2.size()) {
                    j3 = nativePtr;
                    osList2.removeAll();
                    if (realmGet$weightHistory != null) {
                        Iterator<RFGHistory> it3 = realmGet$weightHistory.iterator();
                        while (it3.hasNext()) {
                            RFGHistory next2 = it3.next();
                            Long l3 = map2.get(next2);
                            if (l3 == null) {
                                l3 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm2, next2, map2));
                            }
                            osList2.addRow(l3.longValue());
                        }
                    }
                } else {
                    int size2 = realmGet$weightHistory.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        RFGHistory rFGHistory2 = realmGet$weightHistory.get(i2);
                        Long l4 = map2.get(rFGHistory2);
                        if (l4 == null) {
                            l4 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm2, rFGHistory2, map2));
                        }
                        osList2.setRow((long) i2, l4.longValue());
                        i2++;
                        nativePtr = nativePtr;
                    }
                    j3 = nativePtr;
                }
                OsList osList3 = new OsList(table.getUncheckedRow(j14), rFGUserColumnInfo.summaryTodayIndex);
                RealmList<RFGUserSummary> realmGet$summaryToday = rFGUser.realmGet$summaryToday();
                if (realmGet$summaryToday == null || ((long) realmGet$summaryToday.size()) != osList3.size()) {
                    osList3.removeAll();
                    if (realmGet$summaryToday != null) {
                        Iterator<RFGUserSummary> it4 = realmGet$summaryToday.iterator();
                        while (it4.hasNext()) {
                            RFGUserSummary next3 = it4.next();
                            Long l5 = map2.get(next3);
                            if (l5 == null) {
                                l5 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm2, next3, map2));
                            }
                            osList3.addRow(l5.longValue());
                        }
                    }
                } else {
                    int size3 = realmGet$summaryToday.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        RFGUserSummary rFGUserSummary = realmGet$summaryToday.get(i3);
                        Long l6 = map2.get(rFGUserSummary);
                        if (l6 == null) {
                            l6 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm2, rFGUserSummary, map2));
                        }
                        osList3.setRow((long) i3, l6.longValue());
                    }
                }
                OsList osList4 = new OsList(table.getUncheckedRow(j14), rFGUserColumnInfo.summaryAllIndex);
                RealmList<RFGUserSummary> realmGet$summaryAll = rFGUser.realmGet$summaryAll();
                if (realmGet$summaryAll == null || ((long) realmGet$summaryAll.size()) != osList4.size()) {
                    osList4.removeAll();
                    if (realmGet$summaryAll != null) {
                        Iterator<RFGUserSummary> it5 = realmGet$summaryAll.iterator();
                        while (it5.hasNext()) {
                            RFGUserSummary next4 = it5.next();
                            Long l7 = map2.get(next4);
                            if (l7 == null) {
                                l7 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm2, next4, map2));
                            }
                            osList4.addRow(l7.longValue());
                        }
                    }
                } else {
                    int size4 = realmGet$summaryAll.size();
                    for (int i4 = 0; i4 < size4; i4++) {
                        RFGUserSummary rFGUserSummary2 = realmGet$summaryAll.get(i4);
                        Long l8 = map2.get(rFGUserSummary2);
                        if (l8 == null) {
                            l8 = Long.valueOf(jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm2, rFGUserSummary2, map2));
                        }
                        osList4.setRow((long) i4, l8.longValue());
                    }
                }
                nativePtr = j3;
            }
        }
    }

    private static jp_reifrontier_gym_domain_api_RFGUserRealmProxy newProxyInstance(BaseRealm baseRealm, Row row) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectContext.set(baseRealm, row, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) RFGUser.class), false, Collections.emptyList());
        jp_reifrontier_gym_domain_api_RFGUserRealmProxy jp_reifrontier_gym_domain_api_rfguserrealmproxy = new jp_reifrontier_gym_domain_api_RFGUserRealmProxy();
        realmObjectContext.clear();
        return jp_reifrontier_gym_domain_api_rfguserrealmproxy;
    }

    static RFGUser update(Realm realm, RFGUserColumnInfo rFGUserColumnInfo, RFGUser rFGUser, RFGUser rFGUser2, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        int i;
        int i2;
        RFGUserColumnInfo rFGUserColumnInfo2 = rFGUserColumnInfo;
        Map<RealmModel, RealmObjectProxy> map2 = map;
        Class<RFGUserSummary> cls = RFGUserSummary.class;
        Class<RFGHistory> cls2 = RFGHistory.class;
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(realm.getTable(RFGUser.class), rFGUserColumnInfo2.maxColumnIndexValue, set);
        osObjectBuilder.addString(rFGUserColumnInfo2.userIdIndex, rFGUser2.realmGet$userId());
        osObjectBuilder.addString(rFGUserColumnInfo2.firstDateIndex, rFGUser2.realmGet$firstDate());
        osObjectBuilder.addString(rFGUserColumnInfo2.iconIndex, rFGUser2.realmGet$icon());
        osObjectBuilder.addString(rFGUserColumnInfo2.genderIndex, rFGUser2.realmGet$gender());
        osObjectBuilder.addString(rFGUserColumnInfo2.birthdayIndex, rFGUser2.realmGet$birthday());
        osObjectBuilder.addString(rFGUserColumnInfo2.emailIndex, rFGUser2.realmGet$email());
        osObjectBuilder.addString(rFGUserColumnInfo2.handleNameIndex, rFGUser2.realmGet$handleName());
        osObjectBuilder.addString(rFGUserColumnInfo2.pushAllowIndex, rFGUser2.realmGet$pushAllow());
        osObjectBuilder.addString(rFGUserColumnInfo2.archiveCountIndex, rFGUser2.realmGet$archiveCount());
        RealmList<RFGHistory> realmGet$heightHistory = rFGUser2.realmGet$heightHistory();
        if (realmGet$heightHistory != null) {
            RealmList realmList = new RealmList();
            int i3 = 0;
            while (i3 < realmGet$heightHistory.size()) {
                RFGHistory rFGHistory = realmGet$heightHistory.get(i3);
                RFGHistory rFGHistory2 = (RFGHistory) map2.get(rFGHistory);
                if (rFGHistory2 != null) {
                    realmList.add(rFGHistory2);
                    i2 = i3;
                } else {
                    i2 = i3;
                    realmList.add(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls2), rFGHistory, true, map, set));
                }
                i3 = i2 + 1;
            }
            osObjectBuilder.addObjectList(rFGUserColumnInfo2.heightHistoryIndex, realmList);
        } else {
            osObjectBuilder.addObjectList(rFGUserColumnInfo2.heightHistoryIndex, new RealmList());
        }
        RealmList<RFGHistory> realmGet$weightHistory = rFGUser2.realmGet$weightHistory();
        if (realmGet$weightHistory != null) {
            RealmList realmList2 = new RealmList();
            int i4 = 0;
            while (i4 < realmGet$weightHistory.size()) {
                RFGHistory rFGHistory3 = realmGet$weightHistory.get(i4);
                RFGHistory rFGHistory4 = (RFGHistory) map2.get(rFGHistory3);
                if (rFGHistory4 != null) {
                    realmList2.add(rFGHistory4);
                    i = i4;
                } else {
                    i = i4;
                    realmList2.add(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls2), rFGHistory3, true, map, set));
                }
                i4 = i + 1;
            }
            osObjectBuilder.addObjectList(rFGUserColumnInfo2.weightHistoryIndex, realmList2);
        } else {
            osObjectBuilder.addObjectList(rFGUserColumnInfo2.weightHistoryIndex, new RealmList());
        }
        RealmList<RFGUserSummary> realmGet$summaryToday = rFGUser2.realmGet$summaryToday();
        if (realmGet$summaryToday != null) {
            RealmList realmList3 = new RealmList();
            for (int i5 = 0; i5 < realmGet$summaryToday.size(); i5++) {
                RFGUserSummary rFGUserSummary = realmGet$summaryToday.get(i5);
                RFGUserSummary rFGUserSummary2 = (RFGUserSummary) map2.get(rFGUserSummary);
                if (rFGUserSummary2 == null) {
                    rFGUserSummary2 = jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls), rFGUserSummary, true, map, set);
                }
                realmList3.add(rFGUserSummary2);
            }
            osObjectBuilder.addObjectList(rFGUserColumnInfo2.summaryTodayIndex, realmList3);
        } else {
            osObjectBuilder.addObjectList(rFGUserColumnInfo2.summaryTodayIndex, new RealmList());
        }
        RealmList<RFGUserSummary> realmGet$summaryAll = rFGUser2.realmGet$summaryAll();
        if (realmGet$summaryAll != null) {
            RealmList realmList4 = new RealmList();
            for (int i6 = 0; i6 < realmGet$summaryAll.size(); i6++) {
                RFGUserSummary rFGUserSummary3 = realmGet$summaryAll.get(i6);
                RFGUserSummary rFGUserSummary4 = (RFGUserSummary) map2.get(rFGUserSummary3);
                if (rFGUserSummary4 == null) {
                    rFGUserSummary4 = jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls), rFGUserSummary3, true, map, set);
                }
                realmList4.add(rFGUserSummary4);
            }
            osObjectBuilder.addObjectList(rFGUserColumnInfo2.summaryAllIndex, realmList4);
        } else {
            osObjectBuilder.addObjectList(rFGUserColumnInfo2.summaryAllIndex, new RealmList());
        }
        osObjectBuilder.updateExistingObject();
        return rFGUser;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jp_reifrontier_gym_domain_api_RFGUserRealmProxy.class != obj.getClass()) {
            return false;
        }
        jp_reifrontier_gym_domain_api_RFGUserRealmProxy jp_reifrontier_gym_domain_api_rfguserrealmproxy = (jp_reifrontier_gym_domain_api_RFGUserRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = jp_reifrontier_gym_domain_api_rfguserrealmproxy.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) jp_reifrontier_gym_domain_api_rfguserrealmproxy.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == jp_reifrontier_gym_domain_api_rfguserrealmproxy.proxyState.getRow$realm().getIndex();
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
            this.columnInfo = (RFGUserColumnInfo) realmObjectContext.getColumnInfo();
            ProxyState<RFGUser> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$archiveCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.archiveCountIndex);
    }

    public String realmGet$birthday() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.birthdayIndex);
    }

    public String realmGet$email() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.emailIndex);
    }

    public String realmGet$firstDate() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.firstDateIndex);
    }

    public String realmGet$gender() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.genderIndex);
    }

    public String realmGet$handleName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.handleNameIndex);
    }

    public RealmList<RFGHistory> realmGet$heightHistory() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGHistory> realmList = this.heightHistoryRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGHistory> realmList2 = new RealmList<>(RFGHistory.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.heightHistoryIndex), this.proxyState.getRealm$realm());
        this.heightHistoryRealmList = realmList2;
        return realmList2;
    }

    public String realmGet$icon() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.iconIndex);
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public String realmGet$pushAllow() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pushAllowIndex);
    }

    public RealmList<RFGUserSummary> realmGet$summaryAll() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGUserSummary> realmList = this.summaryAllRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGUserSummary> realmList2 = new RealmList<>(RFGUserSummary.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.summaryAllIndex), this.proxyState.getRealm$realm());
        this.summaryAllRealmList = realmList2;
        return realmList2;
    }

    public RealmList<RFGUserSummary> realmGet$summaryToday() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGUserSummary> realmList = this.summaryTodayRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGUserSummary> realmList2 = new RealmList<>(RFGUserSummary.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.summaryTodayIndex), this.proxyState.getRealm$realm());
        this.summaryTodayRealmList = realmList2;
        return realmList2;
    }

    public String realmGet$userId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.userIdIndex);
    }

    public RealmList<RFGHistory> realmGet$weightHistory() {
        this.proxyState.getRealm$realm().checkIfValid();
        RealmList<RFGHistory> realmList = this.weightHistoryRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<RFGHistory> realmList2 = new RealmList<>(RFGHistory.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.weightHistoryIndex), this.proxyState.getRealm$realm());
        this.weightHistoryRealmList = realmList2;
        return realmList2;
    }

    public void realmSet$archiveCount(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.archiveCountIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'archiveCount' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.archiveCountIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'archiveCount' to null.");
        }
    }

    public void realmSet$birthday(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.birthdayIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'birthday' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.birthdayIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'birthday' to null.");
        }
    }

    public void realmSet$email(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.emailIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.emailIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
        }
    }

    public void realmSet$firstDate(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.firstDateIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'firstDate' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.firstDateIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'firstDate' to null.");
        }
    }

    public void realmSet$gender(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.genderIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'gender' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.genderIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'gender' to null.");
        }
    }

    public void realmSet$handleName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.handleNameIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'handleName' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.handleNameIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'handleName' to null.");
        }
    }

    public void realmSet$heightHistory(RealmList<RFGHistory> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("heightHistory")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGHistory> realmList2 = new RealmList<>();
                Iterator<RFGHistory> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGHistory) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.heightHistoryIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGHistory rFGHistory = realmList.get(i);
                    this.proxyState.checkValidObject(rFGHistory);
                    modelList.addRow(((RealmObjectProxy) rFGHistory).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGHistory rFGHistory2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGHistory2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGHistory2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
    }

    public void realmSet$icon(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.iconIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'icon' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.iconIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'icon' to null.");
        }
    }

    public void realmSet$pushAllow(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str != null) {
                this.proxyState.getRow$realm().setString(this.columnInfo.pushAllowIndex, str);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'pushAllow' to null.");
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str != null) {
                row$realm.getTable().setString(this.columnInfo.pushAllowIndex, row$realm.getIndex(), str, true);
                return;
            }
            throw new IllegalArgumentException("Trying to set non-nullable field 'pushAllow' to null.");
        }
    }

    public void realmSet$summaryAll(RealmList<RFGUserSummary> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("summaryAll")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGUserSummary> realmList2 = new RealmList<>();
                Iterator<RFGUserSummary> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGUserSummary) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.summaryAllIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGUserSummary rFGUserSummary = realmList.get(i);
                    this.proxyState.checkValidObject(rFGUserSummary);
                    modelList.addRow(((RealmObjectProxy) rFGUserSummary).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGUserSummary rFGUserSummary2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGUserSummary2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGUserSummary2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
    }

    public void realmSet$summaryToday(RealmList<RFGUserSummary> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("summaryToday")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGUserSummary> realmList2 = new RealmList<>();
                Iterator<RFGUserSummary> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGUserSummary) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.summaryTodayIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGUserSummary rFGUserSummary = realmList.get(i);
                    this.proxyState.checkValidObject(rFGUserSummary);
                    modelList.addRow(((RealmObjectProxy) rFGUserSummary).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGUserSummary rFGUserSummary2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGUserSummary2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGUserSummary2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
    }

    public void realmSet$userId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'userId' cannot be changed after object was created.");
        }
    }

    public void realmSet$weightHistory(RealmList<RFGHistory> realmList) {
        int i = 0;
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("weightHistory")) {
                return;
            }
            if (realmList != null && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<RFGHistory> realmList2 = new RealmList<>();
                Iterator<RFGHistory> it = realmList.iterator();
                while (it.hasNext()) {
                    RealmModel realmModel = (RFGHistory) it.next();
                    if (realmModel != null && !RealmObject.isManaged(realmModel)) {
                        realmModel = realm.copyToRealm(realmModel, new ImportFlag[0]);
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.weightHistoryIndex);
        if (realmList == null || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != null) {
                int size = realmList.size();
                while (i < size) {
                    RFGHistory rFGHistory = realmList.get(i);
                    this.proxyState.checkValidObject(rFGHistory);
                    modelList.addRow(((RealmObjectProxy) rFGHistory).realmGet$proxyState().getRow$realm().getIndex());
                    i++;
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        while (i < size2) {
            RFGHistory rFGHistory2 = realmList.get(i);
            this.proxyState.checkValidObject(rFGHistory2);
            modelList.setRow((long) i, ((RealmObjectProxy) rFGHistory2).realmGet$proxyState().getRow$realm().getIndex());
            i++;
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder b = C0681a.m339b("RFGUser = proxy[", "{userId:");
        b.append(realmGet$userId());
        b.append("}");
        b.append(",");
        b.append("{firstDate:");
        b.append(realmGet$firstDate());
        b.append("}");
        b.append(",");
        b.append("{icon:");
        b.append(realmGet$icon());
        b.append("}");
        b.append(",");
        b.append("{gender:");
        b.append(realmGet$gender());
        b.append("}");
        b.append(",");
        b.append("{birthday:");
        b.append(realmGet$birthday());
        b.append("}");
        b.append(",");
        b.append("{email:");
        b.append(realmGet$email());
        b.append("}");
        b.append(",");
        b.append("{handleName:");
        b.append(realmGet$handleName());
        b.append("}");
        b.append(",");
        b.append("{pushAllow:");
        b.append(realmGet$pushAllow());
        b.append("}");
        b.append(",");
        b.append("{archiveCount:");
        b.append(realmGet$archiveCount());
        C0681a.m335a(b, "}", ",", "{heightHistory:", "RealmList<RFGHistory>[");
        b.append(realmGet$heightHistory().size());
        b.append("]");
        b.append("}");
        b.append(",");
        b.append("{weightHistory:");
        b.append("RealmList<RFGHistory>[");
        b.append(realmGet$weightHistory().size());
        b.append("]");
        C0681a.m335a(b, "}", ",", "{summaryToday:", "RealmList<RFGUserSummary>[");
        b.append(realmGet$summaryToday().size());
        b.append("]");
        b.append("}");
        b.append(",");
        b.append("{summaryAll:");
        b.append("RealmList<RFGUserSummary>[");
        b.append(realmGet$summaryAll().size());
        b.append("]");
        return C0681a.m324a(b, "}", "]");
    }
}
