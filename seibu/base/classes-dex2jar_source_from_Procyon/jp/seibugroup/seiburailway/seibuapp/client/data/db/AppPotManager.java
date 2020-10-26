// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.db;

import org.androidannotations.annotations.Background;
import com.feilang.mvpproject.base.annotations.Succeed;
import com.feilang.mvpproject.base.annotations.Failed;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.data.datasource.DataNotifyEventBus;
import com.feilang.mvpproject.base.annotations.Stage;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import com.feilang.mvpproject.util.Pipeline;
import java.io.IOException;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.android.gms.common.GoogleApiAvailability;
import jp.seibugroup.seiburailway.seibuapp.client.CTCApplication_;
import jp.co.ncdc.apppot.stew.APService;
import java.util.Iterator;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import android.text.TextUtils;
import com.google.common.collect.Lists;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;
import jp.co.ncdc.apppot.stew.APResponse;
import com.feilang.mvpproject.util.LogUtils;
import jp.co.ncdc.apppot.stew.APEntityManager;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.ApSettingServiceInfoPushDetailModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingPushModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingMyStationModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingStationHistoryModel;
import java.util.ArrayList;
import jp.co.ncdc.apppot.stew.APResponseHandler;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMyStationData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;
import org.androidannotations.annotations.RootContext;
import android.content.Context;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount_;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class AppPotManager
{
    @Bean
    AppPotDao mAppPotDao;
    @Pref
    PrefAppPotAccount_ mAppPotUser;
    @RootContext
    Context mContext;
    @Pref
    PrefAppData_ mPrefAppData;
    @Pref
    PrefMyStationData_ mStationPref;
    
    private void createDatabase(final APResponseHandler apResponseHandler) {
        final ArrayList<APObject> list = (ArrayList<APObject>)new ArrayList<APSettingStationHistoryModel>();
        list.add(new APSettingMyStationModel());
        list.add(new APSettingStationHistoryModel());
        list.add(new APSettingPushModel());
        list.add(new ApSettingServiceInfoPushDetailModel());
        APEntityManager.getInstance().createAppDB(this.mContext, list, 1, false, 1, new APResponseHandler() {
            @Override
            public void onError(final String str, final Throwable cause) {
                super.onError(str, cause);
                LogUtils.e("createDB:onError=" + str, new Exception(cause));
                if (apResponseHandler != null) {
                    apResponseHandler.onFailure((APResponse)null);
                }
            }
            
            @Override
            public void onFailure(final APResponse apResponse) {
                LogUtils.outputLog("createDB:onFailure=" + apResponse.getResponseData());
                if (apResponseHandler != null) {
                    apResponseHandler.onFailure(apResponse);
                }
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                LogUtils.outputLog("createAppPotDB:onSuccess=" + apResponse.getResponseData());
                if (apResponseHandler != null) {
                    apResponseHandler.onSuccess(apResponse);
                }
            }
        });
    }
    
    private List<String> getMyStationList() {
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
                if (!Stream.of((Iterable<?>)arrayList).filter(AppPotManager$$Lambda$1.lambdaFactory$(apSettingMyStationModel)).findFirst().isPresent()) {
                    arrayList.add((T)apSettingMyStationModel);
                }
            }
            o = Stream.of((Iterable<?>)arrayList).map((Function<? super Object, ?>)AppPotManager$$Lambda$2.lambdaFactory$()).toList();
            ((PrefMyStationData_.PrefMyStationDataEditor_)this.mStationPref.edit().myStation().put(new Gson().toJson(o))).apply();
        }
        return (List<String>)o;
    }
    
    public static String getToken() {
        if (!APService.getInstance().isInit()) {
            return "";
        }
        return APService.getInstance().getUserInfo().userTokens;
    }
    
    private void initAppPot(final APResponseHandler apResponseHandler) {
        final APService instance = APService.getInstance();
        if (instance.isInit()) {
            if (apResponseHandler != null) {
                apResponseHandler.onSuccess(null);
            }
        }
        else {
            try {
                instance.setServiceInfo(this.mContext, 1, CTCApplication_.getInstance().getPackageName(), "960f4622a1ad40069c7ea589f489c131", "1.0", "mobile.seibuapp.jp", "/apppot", 443, true, true);
                instance.setTimeout(10);
                if (apResponseHandler != null) {
                    apResponseHandler.onSuccess(null);
                }
            }
            catch (Exception ex) {
                LogUtils.e(ex.getMessage(), ex);
                if (apResponseHandler != null) {
                    apResponseHandler.onFailure((APResponse)null);
                }
            }
        }
    }
    
    private void insertDefaultMyStation(final APResponseHandler apResponseHandler) {
        final List<String> myStationList = this.getMyStationList();
        if (myStationList != null && myStationList.size() > 0) {
            if (apResponseHandler != null) {
                apResponseHandler.onSuccess(null);
            }
            return;
        }
        final APSettingMyStationModel apSettingMyStationModel = new APSettingMyStationModel();
        apSettingMyStationModel.stationId = "S0440TZ";
        apSettingMyStationModel.appPotUserId = (String)this.mAppPotUser.apppotUserId().get();
        apSettingMyStationModel.orderNumber = 1;
        APEntityManager.getInstance().saveObject(apSettingMyStationModel, new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
                if (apResponseHandler != null) {
                    apResponseHandler.onFailure((APResponse)null);
                }
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                if (apResponseHandler != null) {
                    ((PrefMyStationData_.PrefMyStationDataEditor_)AppPotManager.this.mStationPref.edit().myStation().put(new Gson().toJson(Lists.newArrayList(apSettingMyStationModel.stationId)))).apply();
                    apResponseHandler.onSuccess(null);
                }
            }
        });
    }
    
    private void loginAppPot(final APResponseHandler apResponseHandler) {
        final APService instance = APService.getInstance();
        if (instance.getUserInfo().isLogin()) {
            if (apResponseHandler != null) {
                apResponseHandler.onSuccess(null);
            }
        }
        else {
            try {
                instance.authentication(true, 1, (String)this.mAppPotUser.apppotUserId().get(), (String)this.mAppPotUser.apppotPassword().get(), new APResponseHandler() {
                    @Override
                    public void onError(final String s, final Throwable cause) {
                        super.onError(s, cause);
                        LogUtils.e(s, new Exception(cause));
                        if (apResponseHandler != null) {
                            apResponseHandler.onFailure((APResponse)null);
                        }
                    }
                    
                    @Override
                    public void onFailure(final APResponse apResponse) {
                        LogUtils.outputLog("login:onFailure:" + apResponse.getResponseData());
                        if (apResponseHandler != null) {
                            apResponseHandler.onFailure(apResponse);
                        }
                    }
                    
                    @Override
                    public void onSuccess(final APResponse apResponse) {
                        LogUtils.outputLog("login:onSuccess=" + apResponse.getResponseData());
                        if (apResponseHandler != null) {
                            apResponseHandler.onSuccess(apResponse);
                        }
                    }
                });
            }
            catch (Exception ex) {
                LogUtils.e(ex.getMessage(), ex);
                if (apResponseHandler != null) {
                    apResponseHandler.onFailure((APResponse)null);
                }
            }
        }
    }
    
    private void registerDevice(final APResponseHandler apResponseHandler) {
        if (!TextUtils.isEmpty((CharSequence)this.mPrefAppData.deviceToken().get())) {
            if (apResponseHandler != null) {
                apResponseHandler.onSuccess(null);
            }
        }
        else {
            try {
                if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.mContext) == 0) {
                    final String token = FirebaseInstanceId.getInstance().getToken("1014244367395", "FCM");
                    APService.getInstance().registerDevice(token, new APResponseHandler() {
                        @Override
                        public void onFailure(final APResponse apResponse) {
                            LogUtils.outputLog("registerDevice:onFailure:" + apResponse.getResponseData());
                            if (apResponseHandler != null) {
                                apResponseHandler.onSuccess(null);
                            }
                        }
                        
                        @Override
                        public void onSuccess(final APResponse apResponse) {
                            LogUtils.outputLog("registerDevice:onSuccess=" + apResponse.getResponseData());
                            ((PrefAppData_.PrefAppDataEditor_)AppPotManager.this.mPrefAppData.edit().deviceToken().put(token)).apply();
                            if (apResponseHandler != null) {
                                apResponseHandler.onSuccess(null);
                            }
                        }
                    });
                    return;
                }
            }
            catch (IOException ex) {
                LogUtils.e("registerDevice:timeOut:", ex);
                if (apResponseHandler != null) {
                    apResponseHandler.onSuccess(null);
                }
                return;
            }
            if (apResponseHandler != null) {
                apResponseHandler.onSuccess(null);
            }
        }
    }
    
    public void init() {
        new Pipeline(null, true) {
            @Stage(order = 1, value = Stage.Type.AC)
            void createDatabase(final Constants.Result result) {
                AppPotManager.this.createDatabase(new APResponseHandler() {
                    @Override
                    public void onFailure(final APResponse apResponse) {
                        Pipeline.this.abort("stop");
                    }
                    
                    @Override
                    public void onSuccess(final APResponse apResponse) {
                        Pipeline.this.nextStage(Constants.Result.SUCCESS);
                    }
                });
            }
            
            @Stage(Stage.Type.AC)
            void initAppPot(final Void void1) {
                AppPotManager.this.initAppPot(new APResponseHandler() {
                    @Override
                    public void onFailure(final APResponse apResponse) {
                        Pipeline.this.abort("stop");
                    }
                    
                    @Override
                    public void onSuccess(final APResponse apResponse) {
                        Pipeline.this.nextStage(Constants.Result.SUCCESS);
                    }
                });
            }
            
            @Stage(order = 5, value = Stage.Type.AC)
            void insertDefaultMyStation(final Constants.Result result) {
                AppPotManager.this.insertDefaultMyStation(new APResponseHandler() {
                    @Override
                    public void onFailure(final APResponse apResponse) {
                        Pipeline.this.abort("stop");
                    }
                    
                    @Override
                    public void onSuccess(final APResponse apResponse) {
                        Pipeline.this.nextStage(Constants.Result.SUCCESS);
                    }
                });
            }
            
            @Stage(order = 4, value = Stage.Type.BG)
            void insertDefaultServiceInfoPushDetail(final Constants.Result result) {
                AppPotManager.this.insertDefaultServiceInfoPushDetail();
                AppPotManager.this.insertDefaultPush();
                this.nextStage(Constants.Result.SUCCESS);
            }
            
            @Stage(order = 3, value = Stage.Type.AC)
            void loginAppPot(final Constants.Result result) {
                AppPotManager.this.loginAppPot(new APResponseHandler() {
                    @Override
                    public void onFailure(final APResponse apResponse) {
                        Pipeline.this.abort("stop");
                    }
                    
                    @Override
                    public void onSuccess(final APResponse apResponse) {
                        Pipeline.this.nextStage(Constants.Result.SUCCESS);
                    }
                });
            }
            
            @Failed
            void onFailed(final int n, final Exception ex) {
                DataNotifyEventBus.getInstance().post(new DataNotifyEvent(DataNotifyEvent.ApiEventType.API_APP_POT_DONE, new Object[] { Constants.Result.FAILURE }));
            }
            
            @Succeed
            void onSucceed(final Constants.Result result) {
                DataNotifyEventBus.getInstance().post(new DataNotifyEvent(DataNotifyEvent.ApiEventType.API_APP_POT_DONE, new Object[] { Constants.Result.SUCCESS }));
            }
            
            @Stage(order = 2, value = Stage.Type.AC)
            void registerDevice(final Constants.Result result) {
                AppPotManager.this.registerDevice(new APResponseHandler() {
                    @Override
                    public void onFailure(final APResponse apResponse) {
                        Pipeline.this.nextStage(Constants.Result.SUCCESS);
                    }
                    
                    @Override
                    public void onSuccess(final APResponse apResponse) {
                        Pipeline.this.nextStage(Constants.Result.SUCCESS);
                    }
                });
            }
        }.open();
    }
    
    @Background
    public void insertDefaultPush() {
        final List<APSettingPushModel> allPush = this.mAppPotDao.getAllPush();
        if (allPush != null && allPush.size() > 0) {
            return;
        }
        final APSettingPushModel apSettingPushModel = new APSettingPushModel();
        apSettingPushModel.appPotUserId = (String)this.mAppPotUser.apppotUserId().get();
        APEntityManager.getInstance().saveObject(apSettingPushModel);
    }
    
    @Background
    public void insertDefaultServiceInfoPushDetail() {
        final List<ApSettingServiceInfoPushDetailModel> allService = this.mAppPotDao.getAllService();
        LogUtils.outputLog("insertDefaultServiceInfoPushDetail apppotUserId : " + (String)this.mAppPotUser.apppotUserId().get());
        if (allService != null && allService.size() > 0) {
            LogUtils.outputLog("insertDefaultServiceInfoPushDetail: list empty");
            return;
        }
        final ArrayList<ApSettingServiceInfoPushDetailModel> list = new ArrayList<ApSettingServiceInfoPushDetailModel>();
        for (int i = 1; i < 8; ++i) {
            final ApSettingServiceInfoPushDetailModel apSettingServiceInfoPushDetailModel = new ApSettingServiceInfoPushDetailModel();
            apSettingServiceInfoPushDetailModel.appPotUserId = (String)this.mAppPotUser.apppotUserId().get();
            apSettingServiceInfoPushDetailModel.dayOfWeek = i;
            list.add(apSettingServiceInfoPushDetailModel);
        }
        APEntityManager.getInstance().saveObjectList((List<APObject>)list, new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
                LogUtils.outputLog("insertDefaultServiceInfoPushDetail:onFailure=" + apResponse.getResponseData());
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                LogUtils.outputLog("insertDefaultServiceInfoPushDetail:onSuccess=" + apResponse.getResponseData());
            }
        });
    }
}
