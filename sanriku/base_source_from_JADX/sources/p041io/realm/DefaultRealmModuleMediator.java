package p041io.realm;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p041io.realm.BaseRealm;
import p041io.realm.C2009x9093b7d7;
import p041io.realm.C2010xb5bcc025;
import p041io.realm.annotations.RealmModule;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.RealmProxyMediator;
import p041io.realm.internal.Row;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy;
import p043jp.reifrontier.gym.domain.api.RFGHistory;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.domain.api.RFGUserSummary;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContent;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle;
import p043jp.reifrontier.gym.domain.api.train.RFGApiSpot;
import p043jp.reifrontier.gym.domain.app.RFGParameterBadge;
import p043jp.reifrontier.gym.domain.silentlog.RFGActTag;
import p043jp.reifrontier.gym.domain.silentlog.RFGActivity;
import p043jp.reifrontier.gym.domain.silentlog.RFGDay;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity;

@RealmModule
/* renamed from: io.realm.DefaultRealmModuleMediator */
class DefaultRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    static {
        HashSet hashSet = new HashSet(18);
        hashSet.add(RFGParameterBadge.class);
        hashSet.add(RFGUserSummary.class);
        hashSet.add(RFGUser.class);
        hashSet.add(RFGApiContent.class);
        hashSet.add(RFGApiContentImage.class);
        hashSet.add(RFGApiContentInfo.class);
        hashSet.add(RFGApiContentTitle.class);
        hashSet.add(RFGApiContentNote.class);
        hashSet.add(RFGApiSpot.class);
        hashSet.add(RFGApiContentButton.class);
        hashSet.add(RFGApiContentAccess.class);
        hashSet.add(RFGApiContentItem.class);
        hashSet.add(RFGHistory.class);
        hashSet.add(RFGActivity.class);
        hashSet.add(RFGDay.class);
        hashSet.add(RFGTrackPoint.class);
        hashSet.add(RFGTrainEntity.class);
        hashSet.add(RFGActTag.class);
        MODEL_CLASSES = Collections.unmodifiableSet(hashSet);
    }

    DefaultRealmModuleMediator() {
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        Object copyOrUpdate;
        E e2 = e;
        Class<RFGActivity> cls = RFGActivity.class;
        Class<RFGHistory> cls2 = RFGHistory.class;
        Class<RFGApiContentItem> cls3 = RFGApiContentItem.class;
        Class<RFGApiContentAccess> cls4 = RFGApiContentAccess.class;
        Class<RFGApiContentButton> cls5 = RFGApiContentButton.class;
        Class<RFGApiSpot> cls6 = RFGApiSpot.class;
        Class<RFGApiContentNote> cls7 = RFGApiContentNote.class;
        Class<RFGApiContentTitle> cls8 = RFGApiContentTitle.class;
        Class<RFGApiContentInfo> cls9 = RFGApiContentInfo.class;
        Class<RFGApiContentImage> cls10 = RFGApiContentImage.class;
        Class<RFGApiContent> cls11 = RFGApiContent.class;
        Class<RFGActTag> cls12 = RFGActTag.class;
        Class<RFGUser> cls13 = RFGUser.class;
        Class<RFGTrainEntity> cls14 = RFGTrainEntity.class;
        Class<RFGUserSummary> cls15 = RFGUserSummary.class;
        Class<RFGTrackPoint> cls16 = RFGTrackPoint.class;
        Class<RFGParameterBadge> cls17 = RFGParameterBadge.class;
        Class<RFGDay> cls18 = RFGDay.class;
        Class superclass = e2 instanceof RealmObjectProxy ? e.getClass().getSuperclass() : e.getClass();
        if (superclass.equals(cls17)) {
            copyOrUpdate = jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.RFGParameterBadgeColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls17), (RFGParameterBadge) e2, z, map, set);
        } else if (superclass.equals(cls15)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.RFGUserSummaryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls15), (RFGUserSummary) e2, z, map, set);
        } else if (superclass.equals(cls13)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_RFGUserRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGUserRealmProxy.RFGUserColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls13), (RFGUser) e2, z, map, set);
        } else if (superclass.equals(cls11)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.RFGApiContentColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls11), (RFGApiContent) e2, z, map, set);
        } else if (superclass.equals(cls10)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.RFGApiContentImageColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls10), (RFGApiContentImage) e2, z, map, set);
        } else if (superclass.equals(cls9)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.RFGApiContentInfoColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls9), (RFGApiContentInfo) e2, z, map, set);
        } else if (superclass.equals(cls8)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.RFGApiContentTitleColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls8), (RFGApiContentTitle) e2, z, map, set);
        } else if (superclass.equals(cls7)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.RFGApiContentNoteColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls7), (RFGApiContentNote) e2, z, map, set);
        } else if (superclass.equals(cls6)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.RFGApiSpotColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls6), (RFGApiSpot) e2, z, map, set);
        } else if (superclass.equals(cls5)) {
            copyOrUpdate = C2010xb5bcc025.copyOrUpdate(realm, (C2010xb5bcc025.RFGApiContentButtonColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls5), (RFGApiContentButton) e2, z, map, set);
        } else if (superclass.equals(cls4)) {
            copyOrUpdate = C2009x9093b7d7.copyOrUpdate(realm, (C2009x9093b7d7.RFGApiContentAccessColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls4), (RFGApiContentAccess) e2, z, map, set);
        } else if (superclass.equals(cls3)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.RFGApiContentItemColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls3), (RFGApiContentItem) e2, z, map, set);
        } else if (superclass.equals(cls2)) {
            copyOrUpdate = jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.RFGHistoryColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls2), (RFGHistory) e2, z, map, set);
        } else if (superclass.equals(cls)) {
            copyOrUpdate = jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.RFGActivityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls), (RFGActivity) e2, z, map, set);
        } else {
            Class<RFGDay> cls19 = cls18;
            if (superclass.equals(cls19)) {
                copyOrUpdate = jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.RFGDayColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls19), (RFGDay) e2, z, map, set);
            } else {
                Class<RFGTrackPoint> cls20 = cls16;
                if (superclass.equals(cls20)) {
                    copyOrUpdate = jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.RFGTrackPointColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls20), (RFGTrackPoint) e2, z, map, set);
                } else {
                    Class<RFGTrainEntity> cls21 = cls14;
                    if (superclass.equals(cls21)) {
                        copyOrUpdate = jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.RFGTrainEntityColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls21), (RFGTrainEntity) e2, z, map, set);
                    } else {
                        Class<RFGActTag> cls22 = cls12;
                        if (superclass.equals(cls22)) {
                            copyOrUpdate = jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.copyOrUpdate(realm, (jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.RFGActTagColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls22), (RFGActTag) e2, z, map, set);
                        } else {
                            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
                        }
                    }
                }
            }
        }
        return (RealmModel) superclass.cast(copyOrUpdate);
    }

    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(RFGParameterBadge.class)) {
            return jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGUserSummary.class)) {
            return jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGUser.class)) {
            return jp_reifrontier_gym_domain_api_RFGUserRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiContent.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiContentImage.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiContentInfo.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiContentTitle.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiContentNote.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiSpot.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiContentButton.class)) {
            return C2010xb5bcc025.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiContentAccess.class)) {
            return C2009x9093b7d7.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGApiContentItem.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGHistory.class)) {
            return jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGActivity.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGDay.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGTrackPoint.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGTrainEntity.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RFGActTag.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.createColumnInfo(osSchemaInfo);
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        Object createDetachedCopy;
        Class<? super Object> superclass = e.getClass().getSuperclass();
        if (superclass.equals(RFGParameterBadge.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.createDetachedCopy((RFGParameterBadge) e, 0, i, map);
        } else if (superclass.equals(RFGUserSummary.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createDetachedCopy((RFGUserSummary) e, 0, i, map);
        } else if (superclass.equals(RFGUser.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_RFGUserRealmProxy.createDetachedCopy((RFGUser) e, 0, i, map);
        } else if (superclass.equals(RFGApiContent.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.createDetachedCopy((RFGApiContent) e, 0, i, map);
        } else if (superclass.equals(RFGApiContentImage.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.createDetachedCopy((RFGApiContentImage) e, 0, i, map);
        } else if (superclass.equals(RFGApiContentInfo.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.createDetachedCopy((RFGApiContentInfo) e, 0, i, map);
        } else if (superclass.equals(RFGApiContentTitle.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.createDetachedCopy((RFGApiContentTitle) e, 0, i, map);
        } else if (superclass.equals(RFGApiContentNote.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.createDetachedCopy((RFGApiContentNote) e, 0, i, map);
        } else if (superclass.equals(RFGApiSpot.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.createDetachedCopy((RFGApiSpot) e, 0, i, map);
        } else if (superclass.equals(RFGApiContentButton.class)) {
            createDetachedCopy = C2010xb5bcc025.createDetachedCopy((RFGApiContentButton) e, 0, i, map);
        } else if (superclass.equals(RFGApiContentAccess.class)) {
            createDetachedCopy = C2009x9093b7d7.createDetachedCopy((RFGApiContentAccess) e, 0, i, map);
        } else if (superclass.equals(RFGApiContentItem.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.createDetachedCopy((RFGApiContentItem) e, 0, i, map);
        } else if (superclass.equals(RFGHistory.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createDetachedCopy((RFGHistory) e, 0, i, map);
        } else if (superclass.equals(RFGActivity.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.createDetachedCopy((RFGActivity) e, 0, i, map);
        } else if (superclass.equals(RFGDay.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.createDetachedCopy((RFGDay) e, 0, i, map);
        } else if (superclass.equals(RFGTrackPoint.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.createDetachedCopy((RFGTrackPoint) e, 0, i, map);
        } else if (superclass.equals(RFGTrainEntity.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.createDetachedCopy((RFGTrainEntity) e, 0, i, map);
        } else if (superclass.equals(RFGActTag.class)) {
            createDetachedCopy = jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.createDetachedCopy((RFGActTag) e, 0, i, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
        }
        return (RealmModel) superclass.cast(createDetachedCopy);
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> cls, Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        Object createOrUpdateUsingJsonObject;
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(RFGParameterBadge.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGUserSummary.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGUser.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_RFGUserRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiContent.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiContentImage.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiContentInfo.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiContentTitle.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiContentNote.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiSpot.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiContentButton.class)) {
            createOrUpdateUsingJsonObject = C2010xb5bcc025.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiContentAccess.class)) {
            createOrUpdateUsingJsonObject = C2009x9093b7d7.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGApiContentItem.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGHistory.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGActivity.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGDay.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGTrackPoint.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGTrainEntity.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RFGActTag.class)) {
            createOrUpdateUsingJsonObject = jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) cls);
        }
        return (RealmModel) cls.cast(createOrUpdateUsingJsonObject);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> cls, Realm realm, JsonReader jsonReader) throws IOException {
        Object createUsingJsonStream;
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(RFGParameterBadge.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGUserSummary.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGUser.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_RFGUserRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiContent.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiContentImage.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiContentInfo.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiContentTitle.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiContentNote.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiSpot.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiContentButton.class)) {
            createUsingJsonStream = C2010xb5bcc025.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiContentAccess.class)) {
            createUsingJsonStream = C2009x9093b7d7.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGApiContentItem.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGHistory.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGActivity.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGDay.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGTrackPoint.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGTrainEntity.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RFGActTag.class)) {
            createUsingJsonStream = jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) cls);
        }
        return (RealmModel) cls.cast(createUsingJsonStream);
    }

    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap(18);
        hashMap.put(RFGParameterBadge.class, jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGUserSummary.class, jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGUser.class, jp_reifrontier_gym_domain_api_RFGUserRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiContent.class, jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiContentImage.class, jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiContentInfo.class, jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiContentTitle.class, jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiContentNote.class, jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiSpot.class, jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiContentButton.class, C2010xb5bcc025.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiContentAccess.class, C2009x9093b7d7.getExpectedObjectSchemaInfo());
        hashMap.put(RFGApiContentItem.class, jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGHistory.class, jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGActivity.class, jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGDay.class, jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGTrackPoint.class, jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGTrainEntity.class, jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RFGActTag.class, jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.getExpectedObjectSchemaInfo());
        return hashMap;
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    public String getSimpleClassNameImpl(Class<? extends RealmModel> cls) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(RFGParameterBadge.class)) {
            return jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGUserSummary.class)) {
            return jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGUser.class)) {
            return jp_reifrontier_gym_domain_api_RFGUserRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiContent.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiContentImage.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiContentInfo.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiContentTitle.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiContentNote.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiSpot.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiContentButton.class)) {
            return C2010xb5bcc025.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiContentAccess.class)) {
            return C2009x9093b7d7.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGApiContentItem.class)) {
            return jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGHistory.class)) {
            return jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGActivity.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGDay.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGTrackPoint.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGTrainEntity.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RFGActTag.class)) {
            return jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class<?> superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(RFGParameterBadge.class)) {
            jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.insert(realm, (RFGParameterBadge) realmModel, map);
        } else if (superclass.equals(RFGUserSummary.class)) {
            jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insert(realm, (RFGUserSummary) realmModel, map);
        } else if (superclass.equals(RFGUser.class)) {
            jp_reifrontier_gym_domain_api_RFGUserRealmProxy.insert(realm, (RFGUser) realmModel, map);
        } else if (superclass.equals(RFGApiContent.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.insert(realm, (RFGApiContent) realmModel, map);
        } else if (superclass.equals(RFGApiContentImage.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insert(realm, (RFGApiContentImage) realmModel, map);
        } else if (superclass.equals(RFGApiContentInfo.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insert(realm, (RFGApiContentInfo) realmModel, map);
        } else if (superclass.equals(RFGApiContentTitle.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insert(realm, (RFGApiContentTitle) realmModel, map);
        } else if (superclass.equals(RFGApiContentNote.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insert(realm, (RFGApiContentNote) realmModel, map);
        } else if (superclass.equals(RFGApiSpot.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.insert(realm, (RFGApiSpot) realmModel, map);
        } else if (superclass.equals(RFGApiContentButton.class)) {
            C2010xb5bcc025.insert(realm, (RFGApiContentButton) realmModel, map);
        } else if (superclass.equals(RFGApiContentAccess.class)) {
            C2009x9093b7d7.insert(realm, (RFGApiContentAccess) realmModel, map);
        } else if (superclass.equals(RFGApiContentItem.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insert(realm, (RFGApiContentItem) realmModel, map);
        } else if (superclass.equals(RFGHistory.class)) {
            jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insert(realm, (RFGHistory) realmModel, map);
        } else if (superclass.equals(RFGActivity.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insert(realm, (RFGActivity) realmModel, map);
        } else if (superclass.equals(RFGDay.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.insert(realm, (RFGDay) realmModel, map);
        } else if (superclass.equals(RFGTrackPoint.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insert(realm, (RFGTrackPoint) realmModel, map);
        } else if (superclass.equals(RFGTrainEntity.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.insert(realm, (RFGTrainEntity) realmModel, map);
        } else if (superclass.equals(RFGActTag.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insert(realm, (RFGActTag) realmModel, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void insert(p041io.realm.Realm r25, java.util.Collection<? extends p041io.realm.RealmModel> r26) {
        /*
            r24 = this;
            r0 = r25
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGActTag> r1 = p043jp.reifrontier.gym.domain.silentlog.RFGActTag.class
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGTrainEntity> r2 = p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity.class
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGTrackPoint> r3 = p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint.class
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGDay> r4 = p043jp.reifrontier.gym.domain.silentlog.RFGDay.class
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGActivity> r5 = p043jp.reifrontier.gym.domain.silentlog.RFGActivity.class
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGHistory> r6 = p043jp.reifrontier.gym.domain.api.RFGHistory.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentItem> r7 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentAccess> r8 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentButton> r9 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiSpot> r10 = p043jp.reifrontier.gym.domain.api.train.RFGApiSpot.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentNote> r11 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentTitle> r12 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentInfo> r13 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentImage> r14 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContent> r15 = p043jp.reifrontier.gym.domain.api.train.RFGApiContent.class
            r16 = r1
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGUser> r1 = p043jp.reifrontier.gym.domain.api.RFGUser.class
            r17 = r2
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGUserSummary> r2 = p043jp.reifrontier.gym.domain.api.RFGUserSummary.class
            r18 = r3
            java.lang.Class<jp.reifrontier.gym.domain.app.RFGParameterBadge> r3 = p043jp.reifrontier.gym.domain.app.RFGParameterBadge.class
            r19 = r4
            java.util.Iterator r4 = r26.iterator()
            r20 = r5
            java.util.HashMap r5 = new java.util.HashMap
            r21 = r6
            int r6 = r26.size()
            r5.<init>(r6)
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0240
            java.lang.Object r6 = r4.next()
            io.realm.RealmModel r6 = (p041io.realm.RealmModel) r6
            r22 = r4
            boolean r4 = r6 instanceof p041io.realm.internal.RealmObjectProxy
            if (r4 == 0) goto L_0x005a
            java.lang.Class r4 = r6.getClass()
            java.lang.Class r4 = r4.getSuperclass()
            goto L_0x005e
        L_0x005a:
            java.lang.Class r4 = r6.getClass()
        L_0x005e:
            boolean r23 = r4.equals(r3)
            if (r23 == 0) goto L_0x006f
            jp.reifrontier.gym.domain.app.RFGParameterBadge r6 = (p043jp.reifrontier.gym.domain.app.RFGParameterBadge) r6
            p041io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.app.RFGParameterBadge) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
        L_0x0069:
            r23 = r7
        L_0x006b:
            r7 = r16
            goto L_0x0162
        L_0x006f:
            boolean r23 = r4.equals(r2)
            if (r23 == 0) goto L_0x007b
            jp.reifrontier.gym.domain.api.RFGUserSummary r6 = (p043jp.reifrontier.gym.domain.api.RFGUserSummary) r6
            p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.RFGUserSummary) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x007b:
            boolean r23 = r4.equals(r1)
            if (r23 == 0) goto L_0x0087
            jp.reifrontier.gym.domain.api.RFGUser r6 = (p043jp.reifrontier.gym.domain.api.RFGUser) r6
            p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.RFGUser) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x0087:
            boolean r23 = r4.equals(r15)
            if (r23 == 0) goto L_0x0093
            jp.reifrontier.gym.domain.api.train.RFGApiContent r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContent) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContent) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x0093:
            boolean r23 = r4.equals(r14)
            if (r23 == 0) goto L_0x009f
            jp.reifrontier.gym.domain.api.train.RFGApiContentImage r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x009f:
            boolean r23 = r4.equals(r13)
            if (r23 == 0) goto L_0x00ab
            jp.reifrontier.gym.domain.api.train.RFGApiContentInfo r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00ab:
            boolean r23 = r4.equals(r12)
            if (r23 == 0) goto L_0x00b7
            jp.reifrontier.gym.domain.api.train.RFGApiContentTitle r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00b7:
            boolean r23 = r4.equals(r11)
            if (r23 == 0) goto L_0x00c3
            jp.reifrontier.gym.domain.api.train.RFGApiContentNote r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00c3:
            boolean r23 = r4.equals(r10)
            if (r23 == 0) goto L_0x00cf
            jp.reifrontier.gym.domain.api.train.RFGApiSpot r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiSpot) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiSpot) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00cf:
            boolean r23 = r4.equals(r9)
            if (r23 == 0) goto L_0x00db
            jp.reifrontier.gym.domain.api.train.RFGApiContentButton r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton) r6
            p041io.realm.C2010xb5bcc025.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00db:
            boolean r23 = r4.equals(r8)
            if (r23 == 0) goto L_0x00e7
            jp.reifrontier.gym.domain.api.train.RFGApiContentAccess r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess) r6
            p041io.realm.C2009x9093b7d7.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00e7:
            boolean r23 = r4.equals(r7)
            if (r23 == 0) goto L_0x00f4
            jp.reifrontier.gym.domain.api.train.RFGApiContentItem r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00f4:
            r23 = r7
            r7 = r21
            boolean r21 = r4.equals(r7)
            if (r21 == 0) goto L_0x0107
            jp.reifrontier.gym.domain.api.RFGHistory r6 = (p043jp.reifrontier.gym.domain.api.RFGHistory) r6
            p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.RFGHistory) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r21 = r7
            goto L_0x006b
        L_0x0107:
            r21 = r7
            r7 = r20
            boolean r20 = r4.equals(r7)
            if (r20 == 0) goto L_0x011a
            jp.reifrontier.gym.domain.silentlog.RFGActivity r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGActivity) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGActivity) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r20 = r7
            goto L_0x006b
        L_0x011a:
            r20 = r7
            r7 = r19
            boolean r19 = r4.equals(r7)
            if (r19 == 0) goto L_0x012d
            jp.reifrontier.gym.domain.silentlog.RFGDay r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGDay) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGDay) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r19 = r7
            goto L_0x006b
        L_0x012d:
            r19 = r7
            r7 = r18
            boolean r18 = r4.equals(r7)
            if (r18 == 0) goto L_0x0140
            jp.reifrontier.gym.domain.silentlog.RFGTrackPoint r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r18 = r7
            goto L_0x006b
        L_0x0140:
            r18 = r7
            r7 = r17
            boolean r17 = r4.equals(r7)
            if (r17 == 0) goto L_0x0153
            jp.reifrontier.gym.domain.silentlog.RFGTrainEntity r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r17 = r7
            goto L_0x006b
        L_0x0153:
            r17 = r7
            r7 = r16
            boolean r16 = r4.equals(r7)
            if (r16 == 0) goto L_0x023b
            jp.reifrontier.gym.domain.silentlog.RFGActTag r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGActTag) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insert((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGActTag) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
        L_0x0162:
            boolean r6 = r22.hasNext()
            if (r6 == 0) goto L_0x0240
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0175
            r3 = r22
            p041io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0175:
            r3 = r22
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0182
            p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0182:
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x018d
            p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x018d:
            boolean r1 = r4.equals(r15)
            if (r1 == 0) goto L_0x0198
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0198:
            boolean r1 = r4.equals(r14)
            if (r1 == 0) goto L_0x01a3
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01a3:
            boolean r1 = r4.equals(r13)
            if (r1 == 0) goto L_0x01ae
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01ae:
            boolean r1 = r4.equals(r12)
            if (r1 == 0) goto L_0x01b9
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01b9:
            boolean r1 = r4.equals(r11)
            if (r1 == 0) goto L_0x01c4
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01c4:
            boolean r1 = r4.equals(r10)
            if (r1 == 0) goto L_0x01cf
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01cf:
            boolean r1 = r4.equals(r9)
            if (r1 == 0) goto L_0x01da
            p041io.realm.C2010xb5bcc025.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01da:
            boolean r1 = r4.equals(r8)
            if (r1 == 0) goto L_0x01e4
            p041io.realm.C2009x9093b7d7.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01e4:
            r1 = r23
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x01f0
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01f0:
            r1 = r21
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x01fc
            p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01fc:
            r1 = r20
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0208
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0208:
            r1 = r19
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0214
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0214:
            r1 = r18
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0220
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0220:
            r1 = r17
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x022c
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x022c:
            boolean r1 = r4.equals(r7)
            if (r1 == 0) goto L_0x0236
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insert((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0236:
            io.realm.exceptions.RealmException r0 = p041io.realm.internal.RealmProxyMediator.getMissingProxyClassException((java.lang.Class<? extends p041io.realm.RealmModel>) r4)
            throw r0
        L_0x023b:
            io.realm.exceptions.RealmException r0 = p041io.realm.internal.RealmProxyMediator.getMissingProxyClassException((java.lang.Class<? extends p041io.realm.RealmModel>) r4)
            throw r0
        L_0x0240:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.DefaultRealmModuleMediator.insert(io.realm.Realm, java.util.Collection):void");
    }

    public void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class<?> superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(RFGParameterBadge.class)) {
            jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.insertOrUpdate(realm, (RFGParameterBadge) realmModel, map);
        } else if (superclass.equals(RFGUserSummary.class)) {
            jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate(realm, (RFGUserSummary) realmModel, map);
        } else if (superclass.equals(RFGUser.class)) {
            jp_reifrontier_gym_domain_api_RFGUserRealmProxy.insertOrUpdate(realm, (RFGUser) realmModel, map);
        } else if (superclass.equals(RFGApiContent.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.insertOrUpdate(realm, (RFGApiContent) realmModel, map);
        } else if (superclass.equals(RFGApiContentImage.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insertOrUpdate(realm, (RFGApiContentImage) realmModel, map);
        } else if (superclass.equals(RFGApiContentInfo.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insertOrUpdate(realm, (RFGApiContentInfo) realmModel, map);
        } else if (superclass.equals(RFGApiContentTitle.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insertOrUpdate(realm, (RFGApiContentTitle) realmModel, map);
        } else if (superclass.equals(RFGApiContentNote.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insertOrUpdate(realm, (RFGApiContentNote) realmModel, map);
        } else if (superclass.equals(RFGApiSpot.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.insertOrUpdate(realm, (RFGApiSpot) realmModel, map);
        } else if (superclass.equals(RFGApiContentButton.class)) {
            C2010xb5bcc025.insertOrUpdate(realm, (RFGApiContentButton) realmModel, map);
        } else if (superclass.equals(RFGApiContentAccess.class)) {
            C2009x9093b7d7.insertOrUpdate(realm, (RFGApiContentAccess) realmModel, map);
        } else if (superclass.equals(RFGApiContentItem.class)) {
            jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insertOrUpdate(realm, (RFGApiContentItem) realmModel, map);
        } else if (superclass.equals(RFGHistory.class)) {
            jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate(realm, (RFGHistory) realmModel, map);
        } else if (superclass.equals(RFGActivity.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insertOrUpdate(realm, (RFGActivity) realmModel, map);
        } else if (superclass.equals(RFGDay.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.insertOrUpdate(realm, (RFGDay) realmModel, map);
        } else if (superclass.equals(RFGTrackPoint.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insertOrUpdate(realm, (RFGTrackPoint) realmModel, map);
        } else if (superclass.equals(RFGTrainEntity.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.insertOrUpdate(realm, (RFGTrainEntity) realmModel, map);
        } else if (superclass.equals(RFGActTag.class)) {
            jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insertOrUpdate(realm, (RFGActTag) realmModel, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void insertOrUpdate(p041io.realm.Realm r25, java.util.Collection<? extends p041io.realm.RealmModel> r26) {
        /*
            r24 = this;
            r0 = r25
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGActTag> r1 = p043jp.reifrontier.gym.domain.silentlog.RFGActTag.class
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGTrainEntity> r2 = p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity.class
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGTrackPoint> r3 = p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint.class
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGDay> r4 = p043jp.reifrontier.gym.domain.silentlog.RFGDay.class
            java.lang.Class<jp.reifrontier.gym.domain.silentlog.RFGActivity> r5 = p043jp.reifrontier.gym.domain.silentlog.RFGActivity.class
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGHistory> r6 = p043jp.reifrontier.gym.domain.api.RFGHistory.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentItem> r7 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentAccess> r8 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentButton> r9 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiSpot> r10 = p043jp.reifrontier.gym.domain.api.train.RFGApiSpot.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentNote> r11 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentTitle> r12 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentInfo> r13 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContentImage> r14 = p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage.class
            java.lang.Class<jp.reifrontier.gym.domain.api.train.RFGApiContent> r15 = p043jp.reifrontier.gym.domain.api.train.RFGApiContent.class
            r16 = r1
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGUser> r1 = p043jp.reifrontier.gym.domain.api.RFGUser.class
            r17 = r2
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGUserSummary> r2 = p043jp.reifrontier.gym.domain.api.RFGUserSummary.class
            r18 = r3
            java.lang.Class<jp.reifrontier.gym.domain.app.RFGParameterBadge> r3 = p043jp.reifrontier.gym.domain.app.RFGParameterBadge.class
            r19 = r4
            java.util.Iterator r4 = r26.iterator()
            r20 = r5
            java.util.HashMap r5 = new java.util.HashMap
            r21 = r6
            int r6 = r26.size()
            r5.<init>(r6)
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0240
            java.lang.Object r6 = r4.next()
            io.realm.RealmModel r6 = (p041io.realm.RealmModel) r6
            r22 = r4
            boolean r4 = r6 instanceof p041io.realm.internal.RealmObjectProxy
            if (r4 == 0) goto L_0x005a
            java.lang.Class r4 = r6.getClass()
            java.lang.Class r4 = r4.getSuperclass()
            goto L_0x005e
        L_0x005a:
            java.lang.Class r4 = r6.getClass()
        L_0x005e:
            boolean r23 = r4.equals(r3)
            if (r23 == 0) goto L_0x006f
            jp.reifrontier.gym.domain.app.RFGParameterBadge r6 = (p043jp.reifrontier.gym.domain.app.RFGParameterBadge) r6
            p041io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.app.RFGParameterBadge) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
        L_0x0069:
            r23 = r7
        L_0x006b:
            r7 = r16
            goto L_0x0162
        L_0x006f:
            boolean r23 = r4.equals(r2)
            if (r23 == 0) goto L_0x007b
            jp.reifrontier.gym.domain.api.RFGUserSummary r6 = (p043jp.reifrontier.gym.domain.api.RFGUserSummary) r6
            p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.RFGUserSummary) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x007b:
            boolean r23 = r4.equals(r1)
            if (r23 == 0) goto L_0x0087
            jp.reifrontier.gym.domain.api.RFGUser r6 = (p043jp.reifrontier.gym.domain.api.RFGUser) r6
            p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.RFGUser) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x0087:
            boolean r23 = r4.equals(r15)
            if (r23 == 0) goto L_0x0093
            jp.reifrontier.gym.domain.api.train.RFGApiContent r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContent) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContent) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x0093:
            boolean r23 = r4.equals(r14)
            if (r23 == 0) goto L_0x009f
            jp.reifrontier.gym.domain.api.train.RFGApiContentImage r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x009f:
            boolean r23 = r4.equals(r13)
            if (r23 == 0) goto L_0x00ab
            jp.reifrontier.gym.domain.api.train.RFGApiContentInfo r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00ab:
            boolean r23 = r4.equals(r12)
            if (r23 == 0) goto L_0x00b7
            jp.reifrontier.gym.domain.api.train.RFGApiContentTitle r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00b7:
            boolean r23 = r4.equals(r11)
            if (r23 == 0) goto L_0x00c3
            jp.reifrontier.gym.domain.api.train.RFGApiContentNote r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00c3:
            boolean r23 = r4.equals(r10)
            if (r23 == 0) goto L_0x00cf
            jp.reifrontier.gym.domain.api.train.RFGApiSpot r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiSpot) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiSpot) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00cf:
            boolean r23 = r4.equals(r9)
            if (r23 == 0) goto L_0x00db
            jp.reifrontier.gym.domain.api.train.RFGApiContentButton r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton) r6
            p041io.realm.C2010xb5bcc025.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00db:
            boolean r23 = r4.equals(r8)
            if (r23 == 0) goto L_0x00e7
            jp.reifrontier.gym.domain.api.train.RFGApiContentAccess r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess) r6
            p041io.realm.C2009x9093b7d7.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00e7:
            boolean r23 = r4.equals(r7)
            if (r23 == 0) goto L_0x00f4
            jp.reifrontier.gym.domain.api.train.RFGApiContentItem r6 = (p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem) r6
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0069
        L_0x00f4:
            r23 = r7
            r7 = r21
            boolean r21 = r4.equals(r7)
            if (r21 == 0) goto L_0x0107
            jp.reifrontier.gym.domain.api.RFGHistory r6 = (p043jp.reifrontier.gym.domain.api.RFGHistory) r6
            p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.api.RFGHistory) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r21 = r7
            goto L_0x006b
        L_0x0107:
            r21 = r7
            r7 = r20
            boolean r20 = r4.equals(r7)
            if (r20 == 0) goto L_0x011a
            jp.reifrontier.gym.domain.silentlog.RFGActivity r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGActivity) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGActivity) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r20 = r7
            goto L_0x006b
        L_0x011a:
            r20 = r7
            r7 = r19
            boolean r19 = r4.equals(r7)
            if (r19 == 0) goto L_0x012d
            jp.reifrontier.gym.domain.silentlog.RFGDay r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGDay) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGDay) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r19 = r7
            goto L_0x006b
        L_0x012d:
            r19 = r7
            r7 = r18
            boolean r18 = r4.equals(r7)
            if (r18 == 0) goto L_0x0140
            jp.reifrontier.gym.domain.silentlog.RFGTrackPoint r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r18 = r7
            goto L_0x006b
        L_0x0140:
            r18 = r7
            r7 = r17
            boolean r17 = r4.equals(r7)
            if (r17 == 0) goto L_0x0153
            jp.reifrontier.gym.domain.silentlog.RFGTrainEntity r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            r17 = r7
            goto L_0x006b
        L_0x0153:
            r17 = r7
            r7 = r16
            boolean r16 = r4.equals(r7)
            if (r16 == 0) goto L_0x023b
            jp.reifrontier.gym.domain.silentlog.RFGActTag r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGActTag) r6
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (p043jp.reifrontier.gym.domain.silentlog.RFGActTag) r6, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
        L_0x0162:
            boolean r6 = r22.hasNext()
            if (r6 == 0) goto L_0x0240
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0175
            r3 = r22
            p041io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0175:
            r3 = r22
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0182
            p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0182:
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x018d
            p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x018d:
            boolean r1 = r4.equals(r15)
            if (r1 == 0) goto L_0x0198
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0198:
            boolean r1 = r4.equals(r14)
            if (r1 == 0) goto L_0x01a3
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01a3:
            boolean r1 = r4.equals(r13)
            if (r1 == 0) goto L_0x01ae
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01ae:
            boolean r1 = r4.equals(r12)
            if (r1 == 0) goto L_0x01b9
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01b9:
            boolean r1 = r4.equals(r11)
            if (r1 == 0) goto L_0x01c4
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01c4:
            boolean r1 = r4.equals(r10)
            if (r1 == 0) goto L_0x01cf
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01cf:
            boolean r1 = r4.equals(r9)
            if (r1 == 0) goto L_0x01da
            p041io.realm.C2010xb5bcc025.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01da:
            boolean r1 = r4.equals(r8)
            if (r1 == 0) goto L_0x01e4
            p041io.realm.C2009x9093b7d7.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01e4:
            r1 = r23
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x01f0
            p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01f0:
            r1 = r21
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x01fc
            p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x01fc:
            r1 = r20
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0208
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0208:
            r1 = r19
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0214
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0214:
            r1 = r18
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0220
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0220:
            r1 = r17
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x022c
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x022c:
            boolean r1 = r4.equals(r7)
            if (r1 == 0) goto L_0x0236
            p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.insertOrUpdate((p041io.realm.Realm) r0, (java.util.Iterator<? extends p041io.realm.RealmModel>) r3, (java.util.Map<p041io.realm.RealmModel, java.lang.Long>) r5)
            goto L_0x0240
        L_0x0236:
            io.realm.exceptions.RealmException r0 = p041io.realm.internal.RealmProxyMediator.getMissingProxyClassException((java.lang.Class<? extends p041io.realm.RealmModel>) r4)
            throw r0
        L_0x023b:
            io.realm.exceptions.RealmException r0 = p041io.realm.internal.RealmProxyMediator.getMissingProxyClassException((java.lang.Class<? extends p041io.realm.RealmModel>) r4)
            throw r0
        L_0x0240:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.DefaultRealmModuleMediator.insertOrUpdate(io.realm.Realm, java.util.Collection):void");
    }

    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            realmObjectContext.set((BaseRealm) obj, row, columnInfo, z, list);
            RealmProxyMediator.checkClass(cls);
            if (cls.equals(RFGParameterBadge.class)) {
                return (RealmModel) cls.cast(new jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy());
            }
            if (cls.equals(RFGUserSummary.class)) {
                E e = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxy());
                realmObjectContext.clear();
                return e;
            } else if (cls.equals(RFGUser.class)) {
                E e2 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_RFGUserRealmProxy());
                realmObjectContext.clear();
                return e2;
            } else if (cls.equals(RFGApiContent.class)) {
                E e3 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_train_RFGApiContentRealmProxy());
                realmObjectContext.clear();
                return e3;
            } else if (cls.equals(RFGApiContentImage.class)) {
                E e4 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_train_RFGApiContentImageRealmProxy());
                realmObjectContext.clear();
                return e4;
            } else if (cls.equals(RFGApiContentInfo.class)) {
                E e5 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_train_RFGApiContentInfoRealmProxy());
                realmObjectContext.clear();
                return e5;
            } else if (cls.equals(RFGApiContentTitle.class)) {
                E e6 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_train_RFGApiContentTitleRealmProxy());
                realmObjectContext.clear();
                return e6;
            } else if (cls.equals(RFGApiContentNote.class)) {
                E e7 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_train_RFGApiContentNoteRealmProxy());
                realmObjectContext.clear();
                return e7;
            } else if (cls.equals(RFGApiSpot.class)) {
                E e8 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy());
                realmObjectContext.clear();
                return e8;
            } else if (cls.equals(RFGApiContentButton.class)) {
                E e9 = (RealmModel) cls.cast(new C2010xb5bcc025());
                realmObjectContext.clear();
                return e9;
            } else if (cls.equals(RFGApiContentAccess.class)) {
                E e10 = (RealmModel) cls.cast(new C2009x9093b7d7());
                realmObjectContext.clear();
                return e10;
            } else if (cls.equals(RFGApiContentItem.class)) {
                E e11 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_train_RFGApiContentItemRealmProxy());
                realmObjectContext.clear();
                return e11;
            } else if (cls.equals(RFGHistory.class)) {
                E e12 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy());
                realmObjectContext.clear();
                return e12;
            } else if (cls.equals(RFGActivity.class)) {
                E e13 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy());
                realmObjectContext.clear();
                return e13;
            } else if (cls.equals(RFGDay.class)) {
                E e14 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy());
                realmObjectContext.clear();
                return e14;
            } else if (cls.equals(RFGTrackPoint.class)) {
                E e15 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_silentlog_RFGTrackPointRealmProxy());
                realmObjectContext.clear();
                return e15;
            } else if (cls.equals(RFGTrainEntity.class)) {
                E e16 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy());
                realmObjectContext.clear();
                return e16;
            } else if (cls.equals(RFGActTag.class)) {
                E e17 = (RealmModel) cls.cast(new jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy());
                realmObjectContext.clear();
                return e17;
            } else {
                throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) cls);
            }
        } finally {
            realmObjectContext.clear();
        }
    }

    public boolean transformerApplied() {
        return true;
    }
}
