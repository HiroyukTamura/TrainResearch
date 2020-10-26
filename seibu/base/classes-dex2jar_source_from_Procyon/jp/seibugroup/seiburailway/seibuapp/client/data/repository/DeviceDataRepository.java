// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.repository;

import java.util.Collection;
import jp.co.ncdc.apppot.stew.APResponse;
import jp.co.ncdc.apppot.stew.APResponseHandler;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import jp.co.ncdc.apppot.stew.dto.APObject;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BeaconLocationInfo;
import org.altbeacon.beacon.Beacon;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.BeaconInfo;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.AppPotUser;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.AppPotGetUserParam;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeThreeMessageWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.ApSettingServiceInfoPushDetailModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingPushModel;
import java.util.Iterator;
import com.annimon.stream.function.Function;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageWrapper;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import org.androidannotations.annotations.Background;
import org.androidannotations.api.UiThreadExecutor;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingStationHistoryModel;
import com.feilang.mvpproject.data.models.ResultData;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInInfo;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingCallback;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingMyStationModel;
import com.google.common.collect.Lists;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageData;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMyStationData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.MasterDaoUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.remote.AppDeviceRestManager;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount_;
import org.androidannotations.annotations.Bean;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.AppPotDao;
import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class DeviceDataRepository
{
    @Bean
    AppPotDao mAppPotDao;
    @Pref
    PrefAppPotAccount_ mAppPotUser;
    @Bean
    AppDeviceRestManager mAppRest;
    private List<CheckInData> mCheckInDatas;
    @Bean
    MasterDaoUtils mGreenDao;
    @Pref
    PrefMyStationData_ mStationPref;
    public ArrayList<NoticeMessageData> wallpaper;
    
    public DeviceDataRepository() {
        this.mCheckInDatas = (List<CheckInData>)Lists.newArrayList();
    }
    
    public void changeCheckIn(@NonNull final Object o, final String s, final CheckInInfo checkInInfo, final boolean b) {
        this.mAppRest.changeCheckIn(new DataCallWrapper<CheckInData>(o, DataNotifyEvent.ApiEventType.API_CHANGE_CHECK_IN, b) {
            @NonNull
            @Override
            public ResultData handleData(final CheckInData checkInData) {
                return ResultData.createNew(checkInData);
            }
        }, s, checkInInfo);
    }
    
    @Background
    public void clearStationHistory(final APSettingCallback.Common common) {
        if (this.mAppPotDao.clearLocalTable(APSettingStationHistoryModel.class)) {
            common.getClass();
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$5.lambdaFactory$(common), 0L);
            return;
        }
        common.getClass();
        UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$6.lambdaFactory$(common), 0L);
    }
    
    public void deleteBeacon(@NonNull final Object o) {
        this.mAppRest.deleteBeacon(new DataCallWrapper<Object>(o, DataNotifyEvent.ApiEventType.API_DELETE_BEACON, false, true) {
            @NonNull
            @Override
            public ResultData handleData(final Object o) {
                return ResultData.createNew("delete_beacon succeed", o);
            }
        });
    }
    
    public void deleteCheckIn(@NonNull final Object o, final String s, final boolean b) {
        this.mAppRest.deleteCheckIn(new DataCallWrapper<Object>(o, DataNotifyEvent.ApiEventType.API_DELETE_CHECK_IN, b) {
            @NonNull
            @Override
            public ResultData handleData(final Object o) {
                return ResultData.createNew(o);
            }
        }, s);
    }
    
    public void getCheckIn(@NonNull final Object o, final boolean b, final boolean b2) {
        this.getCheckIn(o, b, b2, false);
    }
    
    public void getCheckIn(@NonNull final Object o, final boolean b, final boolean b2, final boolean b3) {
        this.mAppRest.getCheckIn(new DataCallWrapper<List<CheckInData>>(o, DataNotifyEvent.ApiEventType.API_GET_CHECK_IN, b, b2, new Object[] { o.hashCode(), b3 }) {
            @NonNull
            @Override
            public ResultData handleData(final List<CheckInData> list) {
                if (list != null) {
                    DeviceDataRepository.this.mCheckInDatas = (List<CheckInData>)Stream.of((Iterable<?>)list).filter(DeviceDataRepository$11$$Lambda$1.lambdaFactory$()).toList();
                }
                return ResultData.createNew(list);
            }
        });
    }
    
    public List<CheckInData> getCheckInTrains() {
        return this.mCheckInDatas;
    }
    
    public void getEmerg(@NonNull final Object o) {
        this.mAppRest.getEmerg(new DataCallWrapper<NoticeMessageWrapper>(o, DataNotifyEvent.ApiEventType.API_EMERG, false, true) {
            @NonNull
            @Override
            public ResultData handleData(final NoticeMessageWrapper noticeMessageWrapper) {
                return ResultData.createNew("succeed", noticeMessageWrapper.getNotice());
            }
        });
    }
    
    public void getEvents(@NonNull final Object o) {
        this.mAppRest.getEventMessage(new DataCallWrapper<NoticeMessageWrapper>(o, DataNotifyEvent.ApiEventType.API_EVENT_MESSAGE) {
            @NonNull
            public ResultType checkBusinessError(final NoticeMessageWrapper noticeMessageWrapper) {
                if (noticeMessageWrapper == null || noticeMessageWrapper.getNotice() == null || noticeMessageWrapper.getNotice().size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final NoticeMessageWrapper noticeMessageWrapper) {
                return ResultData.createNew("succeed", noticeMessageWrapper.getNotice());
            }
        });
    }
    
    public void getHeadlines(@NonNull final Object o) {
        this.mAppRest.getHeadlines(new DataCallWrapper<NoticeMessageWrapper>(o, DataNotifyEvent.ApiEventType.API_HEADLINES, false, true) {
            @NonNull
            @Override
            public ResultData handleData(final NoticeMessageWrapper noticeMessageWrapper) {
                return ResultData.createNew("succeed", noticeMessageWrapper.getNotice());
            }
        });
    }
    
    public List<String> getMyStationList() {
        Object o = Lists.newArrayList();
        final String s = (String)this.mStationPref.myStation().get();
        if (!TextUtils.isEmpty((CharSequence)s)) {
            o = new Gson().fromJson(s, new TypeToken<List<String>>() {}.getType());
        }
        if (o != null && ((List)o).size() != 0) {
            return (List<String>)o;
        }
        final List<APSettingMyStationModel> allMyStation = this.mAppPotDao.getAllMyStation();
        if (allMyStation != null) {
            final ArrayList<? extends T> arrayList = Lists.newArrayList();
            for (final APSettingMyStationModel apSettingMyStationModel : allMyStation) {
                if (!Stream.of((Iterable<?>)arrayList).filter(DeviceDataRepository$$Lambda$10.lambdaFactory$(apSettingMyStationModel)).findFirst().isPresent()) {
                    arrayList.add((T)apSettingMyStationModel);
                }
            }
            o = Stream.of((Iterable<?>)arrayList).map((Function<? super Object, ?>)DeviceDataRepository$$Lambda$11.lambdaFactory$()).toList();
            ((PrefMyStationData_.PrefMyStationDataEditor_)this.mStationPref.edit().myStation().put(new Gson().toJson(o))).apply();
        }
        return (List<String>)o;
    }
    
    public void getNoticeMessages(@NonNull final Object o) {
        this.mAppRest.getNoticeMessage(new DataCallWrapper<NoticeMessageWrapper>(o, DataNotifyEvent.ApiEventType.API_NOTICE_MESSAGE) {
            @NonNull
            @Override
            public ResultData handleData(final NoticeMessageWrapper noticeMessageWrapper) {
                return ResultData.createNew("succeed", noticeMessageWrapper.getNotice());
            }
        });
    }
    
    public void getNoticeMessagesUnreadCount(@NonNull final Object o) {
        this.mAppRest.getNoticeMessage(new DataCallWrapper<NoticeMessageWrapper>(o, DataNotifyEvent.ApiEventType.API_NOTICE_MESSAGE_UNREAD, false, true) {
            @NonNull
            @Override
            public ResultData handleData(final NoticeMessageWrapper noticeMessageWrapper) {
                if (noticeMessageWrapper.getNotice() == null) {
                    return ResultData.createNew("succeed", 0);
                }
                return ResultData.createNew("succeed", DeviceDataRepository.this.mGreenDao.unreadNoticeCount(Stream.of((Iterable<?>)noticeMessageWrapper.getNotice()).map((Function<? super Object, ? extends String>)DeviceDataRepository$3$$Lambda$1.lambdaFactory$()).toList()));
            }
        });
    }
    
    @Background
    public void getPushSetting(final APSettingCallback.Select<APSettingPushModel> select) {
        final List<APSettingPushModel> allPush = this.mAppPotDao.getAllPush();
        if (allPush.size() >= 0) {
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$16.lambdaFactory$(select, allPush), 0L);
            return;
        }
        select.getClass();
        UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$17.lambdaFactory$(select), 0L);
    }
    
    @Background
    public void getServiceInfo(final APSettingCallback.Select<ApSettingServiceInfoPushDetailModel> select) {
        final List<ApSettingServiceInfoPushDetailModel> allService = this.mAppPotDao.getAllService();
        if (allService != null) {
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$14.lambdaFactory$(select, allService), 0L);
            return;
        }
        select.getClass();
        UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$15.lambdaFactory$(select), 0L);
    }
    
    public void getSharedCheckIn(@NonNull final Object o, final String s, final boolean b) {
        this.mAppRest.getSharedCheckIn(new DataCallWrapper<List<CheckInData>>(o, DataNotifyEvent.ApiEventType.API_GET_SHARED_CHECK_IN, b) {
            @NonNull
            @Override
            public ResultData handleData(final List<CheckInData> list) {
                if (list != null) {
                    return ResultData.createNew(list);
                }
                return ResultData.createNew(null);
            }
        }, s);
    }
    
    @Background
    public void getStationHistoryList(final APSettingCallback.Select<APSettingStationHistoryModel> select) {
        final List<APSettingStationHistoryModel> allStationHistory = this.mAppPotDao.getAllStationHistory();
        if (allStationHistory != null && allStationHistory.size() > 0) {
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$3.lambdaFactory$(select, allStationHistory), 0L);
            return;
        }
        select.getClass();
        UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$4.lambdaFactory$(select), 0L);
    }
    
    public void getThreeNoticeMessages(@NonNull final Object o) {
        this.mAppRest.getThreeNoticeMessage(new DataCallWrapper<NoticeThreeMessageWrapper>(o, DataNotifyEvent.ApiEventType.API_THREE_NOTICE, false, true) {
            @NonNull
            @Override
            public ResultData handleData(final NoticeThreeMessageWrapper noticeThreeMessageWrapper) {
                noticeThreeMessageWrapper.setHomeUnreadCount(DeviceDataRepository.this.mGreenDao.unreadNoticeCount(Stream.of((Iterable<?>)noticeThreeMessageWrapper.getHome().getNotice()).map((Function<? super Object, ? extends String>)DeviceDataRepository$7$$Lambda$1.lambdaFactory$()).toList()));
                if (DeviceDataRepository.this.wallpaper != null && !DeviceDataRepository.this.wallpaper.isEmpty()) {
                    DeviceDataRepository.this.wallpaper.clear();
                }
                DeviceDataRepository.this.wallpaper = noticeThreeMessageWrapper.getWallpapers().getNotice();
                return ResultData.createNew("succeed", noticeThreeMessageWrapper);
            }
        });
    }
    
    public void getUserFromAppPot(@NonNull final Object o, final AppPotGetUserParam appPotGetUserParam) {
        this.mAppRest.getUserFromAppPot(appPotGetUserParam, new DataCallWrapper<AppPotUser>(o, DataNotifyEvent.ApiEventType.API_APP_POT_ACCOUNT, false, false) {
            @NonNull
            @Override
            public ResultData handleData(final AppPotUser appPotUser) {
                if (appPotUser != null) {
                    ((PrefAppPotAccount_.PrefAppPotAccountEditor_)((PrefAppPotAccount_.PrefAppPotAccountEditor_)((PrefAppPotAccount_.PrefAppPotAccountEditor_)DeviceDataRepository.this.mAppPotUser.edit().isSaved().put(true)).apppotUserId().put(appPotUser.getApppotUserId())).apppotPassword().put(appPotUser.getApppotPassword())).apply();
                }
                return ResultData.createNew(Constants.Result.SUCCESS);
            }
        });
    }
    
    public void getWallpapers(@NonNull final Object o) {
        this.mAppRest.getWallpapers(new DataCallWrapper<NoticeMessageWrapper>(o, DataNotifyEvent.ApiEventType.API_WALLPAPERS) {
            @NonNull
            @Override
            public ResultData handleData(final NoticeMessageWrapper noticeMessageWrapper) {
                return ResultData.createNew("succeed", noticeMessageWrapper.getNotice());
            }
        });
    }
    
    public boolean isSaveUser() {
        return (boolean)this.mAppPotUser.isSaved().get();
    }
    
    public void registerBeacon(@NonNull final Object o, @NonNull final BeaconInfo beaconInfo, @NonNull final Beacon beacon) {
        this.mAppRest.postBeacon(beaconInfo, new DataCallWrapper<BeaconLocationInfo>(o, DataNotifyEvent.ApiEventType.API_REGISTER_BEACON, false, true, new Object[] { beacon }) {
            @NonNull
            @Override
            public ResultData handleData(final BeaconLocationInfo beaconLocationInfo) {
                return ResultData.createNew("register_beacon succeed", beaconLocationInfo);
            }
        });
    }
    
    public void requestCheckIn(@NonNull final Object o, final CheckInInfo checkInInfo, final boolean b) {
        this.mAppRest.requestCheckIn(new DataCallWrapper<List<CheckInData>>(o, DataNotifyEvent.ApiEventType.API_REQUEST_CHECK_IN, b) {
            @NonNull
            public ResultType checkBusinessError(final List<CheckInData> list) {
                if (list == null || list.size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final List<CheckInData> list) {
                DeviceDataRepository.this.mCheckInDatas = (List<CheckInData>)Stream.of((Iterable<?>)list).filter(DeviceDataRepository$13$$Lambda$1.lambdaFactory$()).toList();
                return ResultData.createNew(DeviceDataRepository.this.mCheckInDatas);
            }
        }, checkInInfo);
    }
    
    @Background
    public void saveMyStation(final String stationId, final APSettingCallback.Common common) {
        final List<APSettingMyStationModel> allMyStation = this.mAppPotDao.getAllMyStation();
        final APSettingMyStationModel apSettingMyStationModel = new APSettingMyStationModel();
        apSettingMyStationModel.appPotUserId = (String)this.mAppPotUser.apppotUserId().get();
        apSettingMyStationModel.stationId = stationId;
        apSettingMyStationModel.orderNumber = allMyStation.size() + 1;
        if (this.mAppPotDao.save(apSettingMyStationModel)) {
            if (common != null) {
                Object o;
                if ((o = this.getMyStationList()) == null) {
                    o = Lists.newArrayList();
                }
                ((List<String>)o).add(stationId);
                ((PrefMyStationData_.PrefMyStationDataEditor_)this.mStationPref.edit().myStation().put(new Gson().toJson(o))).apply();
                common.getClass();
                UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$8.lambdaFactory$(common), 0L);
            }
        }
        else if (common != null) {
            common.getClass();
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$9.lambdaFactory$(common), 0L);
        }
    }
    
    @Background
    public void saveMyStationList(final List<BaseStation> list, final APSettingCallback.Common common) {
        final ArrayList<String> arrayList = Lists.newArrayList();
        final ArrayList<APSettingMyStationModel> list2 = new ArrayList<APSettingMyStationModel>();
        if (list != null) {
            for (int i = 0; i < list.size(); ++i) {
                final BaseStation baseStation = list.get(i);
                final APSettingMyStationModel apSettingMyStationModel = new APSettingMyStationModel();
                apSettingMyStationModel.appPotUserId = (String)this.mAppPotUser.apppotUserId().get();
                apSettingMyStationModel.stationId = baseStation.getId();
                apSettingMyStationModel.orderNumber = i + 1;
                list2.add(apSettingMyStationModel);
                arrayList.add(baseStation.getId());
            }
        }
        if (this.mAppPotDao.clearServerTable(APSettingMyStationModel.class)) {
            this.mAppPotDao.saveList((List<APObject>)list2, new APResponseHandler() {
                @Override
                public void onFailure(final APResponse apResponse) {
                    final APSettingCallback.Common val$callback = common;
                    val$callback.getClass();
                    UiThreadExecutor.runTask("AppPot", DeviceDataRepository$16$$Lambda$2.lambdaFactory$(val$callback), 0L);
                }
                
                @Override
                public void onSuccess(final APResponse apResponse) {
                    ((PrefMyStationData_.PrefMyStationDataEditor_)DeviceDataRepository.this.mStationPref.edit().myStation().put(new Gson().toJson(arrayList))).apply();
                    final APSettingCallback.Common val$callback = common;
                    val$callback.getClass();
                    UiThreadExecutor.runTask("AppPot", DeviceDataRepository$16$$Lambda$1.lambdaFactory$(val$callback), 0L);
                }
            });
            return;
        }
        common.getClass();
        UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$7.lambdaFactory$(common), 0L);
    }
    
    public void saveNoticeMessage(final List<NoticeMessageData> list) {
        this.mGreenDao.insertNoticeHistory(Stream.of((Iterable<?>)list).map((Function<? super Object, ? extends String>)DeviceDataRepository$$Lambda$20.lambdaFactory$()).toList());
    }
    
    @Background
    public void savePushSetting(final APSettingPushModel apSettingPushModel, final APSettingCallback.Common common) {
        final List<APSettingPushModel> allPush = this.mAppPotDao.getAllPush();
        APSettingPushModel apSettingPushModel2;
        if (allPush != null && allPush.size() > 0) {
            apSettingPushModel2 = allPush.get(0);
        }
        else {
            apSettingPushModel2 = new APSettingPushModel();
        }
        apSettingPushModel2.appPotUserId = (String)this.mAppPotUser.apppotUserId().get();
        apSettingPushModel2.isEnabledInformation = apSettingPushModel.isEnabledInformation;
        apSettingPushModel2.isEnabledServiceInfo = apSettingPushModel.isEnabledServiceInfo;
        apSettingPushModel2.isEnabledGetOff = apSettingPushModel.isEnabledGetOff;
        apSettingPushModel2.getOffStationId = apSettingPushModel.getOffStationId;
        apSettingPushModel2.scheduledDate = apSettingPushModel.scheduledDate;
        apSettingPushModel2.lineId = apSettingPushModel.lineId;
        apSettingPushModel2.trainNo = apSettingPushModel.trainNo;
        apSettingPushModel2.isEnabledStampRally = apSettingPushModel.isEnabledStampRally;
        apSettingPushModel2.isEnabledCoupon = apSettingPushModel.isEnabledCoupon;
        if (this.mAppPotDao.save(apSettingPushModel2)) {
            common.getClass();
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$18.lambdaFactory$(common), 0L);
        }
        else {
            common.getClass();
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$19.lambdaFactory$(common), 0L);
        }
        this.mAppPotDao.deleteOverflowStationHistory(new ArrayList<APObject>(this.mAppPotDao.getAllPush()), 1);
    }
    
    @Background(serial = "save_notify_time")
    public void saveServiceInfo(final ApSettingServiceInfoPushDetailModel apSettingServiceInfoPushDetailModel, final APSettingCallback.Common common) {
        final ApSettingServiceInfoPushDetailModel apSettingServiceInfoPushDetailModel2 = null;
        final Iterator<ApSettingServiceInfoPushDetailModel> iterator = this.mAppPotDao.getAllService().iterator();
        ApSettingServiceInfoPushDetailModel apSettingServiceInfoPushDetailModel3;
        do {
            apSettingServiceInfoPushDetailModel3 = apSettingServiceInfoPushDetailModel2;
            if (!iterator.hasNext()) {
                break;
            }
            apSettingServiceInfoPushDetailModel3 = iterator.next();
        } while (apSettingServiceInfoPushDetailModel3.dayOfWeek != apSettingServiceInfoPushDetailModel.dayOfWeek);
        ApSettingServiceInfoPushDetailModel apSettingServiceInfoPushDetailModel4;
        if ((apSettingServiceInfoPushDetailModel4 = apSettingServiceInfoPushDetailModel3) == null) {
            apSettingServiceInfoPushDetailModel4 = new ApSettingServiceInfoPushDetailModel();
        }
        apSettingServiceInfoPushDetailModel4.appPotUserId = (String)this.mAppPotUser.apppotUserId().get();
        apSettingServiceInfoPushDetailModel4.dayOfWeek = apSettingServiceInfoPushDetailModel.dayOfWeek;
        apSettingServiceInfoPushDetailModel4.at4 = apSettingServiceInfoPushDetailModel.at4;
        apSettingServiceInfoPushDetailModel4.at6 = apSettingServiceInfoPushDetailModel.at6;
        apSettingServiceInfoPushDetailModel4.at8 = apSettingServiceInfoPushDetailModel.at8;
        apSettingServiceInfoPushDetailModel4.at10 = apSettingServiceInfoPushDetailModel.at10;
        apSettingServiceInfoPushDetailModel4.at12 = apSettingServiceInfoPushDetailModel.at12;
        apSettingServiceInfoPushDetailModel4.at14 = apSettingServiceInfoPushDetailModel.at14;
        apSettingServiceInfoPushDetailModel4.at16 = apSettingServiceInfoPushDetailModel.at16;
        apSettingServiceInfoPushDetailModel4.at18 = apSettingServiceInfoPushDetailModel.at18;
        apSettingServiceInfoPushDetailModel4.at20 = apSettingServiceInfoPushDetailModel.at20;
        apSettingServiceInfoPushDetailModel4.at22 = apSettingServiceInfoPushDetailModel.at22;
        apSettingServiceInfoPushDetailModel4.at24 = apSettingServiceInfoPushDetailModel.at24;
        if (this.mAppPotDao.save(apSettingServiceInfoPushDetailModel4)) {
            common.getClass();
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$12.lambdaFactory$(common), 0L);
            return;
        }
        common.getClass();
        UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$13.lambdaFactory$(common), 0L);
    }
    
    @Background
    public void saveStationHistory(final String s, final APSettingCallback.Common common) {
        final APSettingStationHistoryModel apSettingStationHistoryModel = null;
        final Iterator<APSettingStationHistoryModel> iterator = this.mAppPotDao.getAllStationHistory().iterator();
        APSettingStationHistoryModel apSettingStationHistoryModel2;
        do {
            apSettingStationHistoryModel2 = apSettingStationHistoryModel;
            if (!iterator.hasNext()) {
                break;
            }
            apSettingStationHistoryModel2 = iterator.next();
        } while (!apSettingStationHistoryModel2.stationId.equals(s));
        APSettingStationHistoryModel apSettingStationHistoryModel3;
        if ((apSettingStationHistoryModel3 = apSettingStationHistoryModel2) == null) {
            apSettingStationHistoryModel3 = new APSettingStationHistoryModel();
        }
        apSettingStationHistoryModel3.stationId = s;
        if (this.mAppPotDao.save(apSettingStationHistoryModel3)) {
            if (common != null) {
                common.getClass();
                UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$1.lambdaFactory$(common), 0L);
            }
        }
        else if (common != null) {
            common.getClass();
            UiThreadExecutor.runTask("AppPot", DeviceDataRepository$$Lambda$2.lambdaFactory$(common), 0L);
        }
        this.mAppPotDao.deleteOverflowStationHistory(new ArrayList<APObject>(this.mAppPotDao.getAllStationHistory()), 20);
    }
}
