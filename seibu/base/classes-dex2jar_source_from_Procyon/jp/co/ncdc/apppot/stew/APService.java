// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import java.util.Iterator;
import java.util.TimerTask;
import jp.co.ncdc.apppot.stew.dto.APLogging;
import android.os.Build;
import jp.co.ncdc.apppot.stew.utils.StringUtils;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import android.content.SharedPreferences$Editor;
import jp.co.ncdc.apppot.stew.log.Logger;
import com.google.gson.Gson;
import android.text.TextUtils;
import java.util.Map;
import jp.co.ncdc.apppot.stew.utils.MacAddress;
import android.content.SharedPreferences;
import android.util.Log;
import android.provider.Settings$Secure;
import android.os.Build$VERSION;
import java.util.Timer;
import jp.co.ncdc.apppot.stew.log.LogLevel;
import android.content.Context;

public class APService
{
    private static final String TAG = "APService";
    private static APService _instance;
    private Context mContext;
    private APHttpClient mHttpClient;
    private LogLevel mLogLevel;
    private Timer mLogTimer;
    private boolean mPushFlag;
    private APServerInfo mServerInfo;
    private APUserInfo mUserInfo;
    
    static {
        APService._instance = null;
    }
    
    private APService() {
        this.mContext = null;
        this.mServerInfo = null;
        this.mHttpClient = null;
        this.mPushFlag = false;
        this.mUserInfo = null;
        this.mLogTimer = null;
        this.mLogLevel = LogLevel.info;
    }
    
    private String getDeviceID() {
        final SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("APService", 0);
        String str;
        if ((str = sharedPreferences.getString("deviceUDID", (String)null)) == null) {
            if (Build$VERSION.SDK_INT >= 23) {
                str = Settings$Secure.getString(this.mContext.getContentResolver(), "android_id");
            }
            else {
                str = this.getMacAddress();
            }
            Log.d("APService", "[getDeviceID]:" + str);
            sharedPreferences.edit().putString("deviceUDID", str).commit();
        }
        return str;
    }
    
    public static APService getInstance() {
        if (APService._instance == null) {
            APService._instance = new APService();
        }
        return APService._instance;
    }
    
    private String getMacAddress() {
        final Map<String, String> macAddress = MacAddress.getMacAddress();
        final String s = macAddress.get("wlan0");
        if (s != null) {
            Log.d("APService", "[getDeviceID]:Use wlan0 MAC Address");
            return s;
        }
        final String s2 = macAddress.get("eth0");
        Log.d("APService", "[getDeviceID]:Use eth0 MAC Address");
        if (s2 != null) {
            return s2;
        }
        throw new APException("Can not get DeviceUDID(MAC Address) from Device.");
    }
    
    private SharedPreferences getUserInfoSharedPreferences() {
        return this.mContext.getSharedPreferences("userInfo", 0);
    }
    
    private boolean hasAnonymousToken() {
        return this.mUserInfo != null && !TextUtils.isEmpty((CharSequence)this.mUserInfo.anonymousToken);
    }
    
    private void loadUserInfo() {
        final String string = this.getUserInfoSharedPreferences().getString("APUserInfo", "");
        if (string.length() > 0) {
            this.mUserInfo = new Gson().fromJson(string, APUserInfo.class);
            return;
        }
        this.mUserInfo = new APUserInfo();
    }
    
    private void saveUserInfo() {
        final SharedPreferences$Editor edit = this.getUserInfoSharedPreferences().edit();
        final String json = new Gson().toJson(this.mUserInfo);
        edit.putString("APUserInfo", json).commit();
        Logger.d("APService", "[saveUserInfo]json=" + json);
        Logger.d("APService", "[saveUserInfo]SharedPreferences=" + this.getUserInfoSharedPreferences().getString("APUserInfo", ""));
    }
    
    public void authentication(final int n, final String s, final String s2, final APResponseHandler apResponseHandler) {
        this.authentication(false, n, s, s2, apResponseHandler);
    }
    
    public void authentication(final boolean b, final int n, final String s, final String s2, final APResponseHandler apResponseHandler) {
        if (!this.isInit()) {
            throw new IllegalArgumentException("you need to set APService.setServiceInfo");
        }
        if (!b && this.mUserInfo != null && this.mUserInfo.lastLogginedAccount != null && !s.equals(this.mUserInfo.lastLogginedAccount)) {
            throw new APInvalidLoginException();
        }
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("username", s);
        ajsonObject.put("password", s2);
        ajsonObject.put("appId", this.mServerInfo.appId);
        ajsonObject.put("deviceUDID", this.mServerInfo.deviceUDID);
        ajsonObject.put("appVersion", this.mServerInfo.appVersion);
        ajsonObject.put("isPush", this.mPushFlag);
        ajsonObject.put("companyId", n);
        Logger.v("APService", "[authentication]params=" + ajsonObject.toString());
        apResponseHandler.setInterceptDataListener((APResponseHandler.APInterceptResponseListener)new APResponseHandler.APInterceptResponseListener() {
            @Override
            public void receiveData(APResponse ajsonObject) {
                if (!ajsonObject.isOK()) {
                    APService.this.mUserInfo.clearToken();
                    return;
                }
                Logger.d("APInterceptResponseListener", "receiveData");
                final AJSONObject ajsonObject2 = (AJSONObject)ajsonObject.getResponseData();
                if (ajsonObject2 == null) {
                    throw new IllegalArgumentException("IllegalArgumentException");
                }
                ajsonObject = (APResponse)ajsonObject2.getAJSONObject("authInfor");
                if (ajsonObject != null) {
                    Logger.d("APService", "[authentication]:clearAllTables");
                    APService.this.mUserInfo.userTokens = ((AJSONObject)ajsonObject).getString("userTokens");
                    if (APService.this.mUserInfo != null && !s.equals(APService.this.mUserInfo.lastLogginedAccount)) {
                        APAutoRefreshManager.getInstance().flushMessageQueue();
                        APEntityManager.getInstance().clearAllTables();
                    }
                    APService.this.mUserInfo.userId = ((AJSONObject)ajsonObject).getInt("userId");
                    APService.this.mUserInfo.validTime = ((AJSONObject)ajsonObject).getLong("validTime");
                    final JSONArray jsonArray = ((AJSONObject)ajsonObject).getJSONArray("groupsAndRoles");
                    if (jsonArray != null) {
                        APService.this.mUserInfo.groupInfo = new APUserInfo.APGroupInfo[jsonArray.length()];
                        int i = 0;
                    Label_0235_Outer:
                        while (i < jsonArray.length()) {
                            while (true) {
                                try {
                                    final JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    if (jsonObject != null) {
                                        APService.this.mUserInfo.groupInfo[i] = new APUserInfo.APGroupInfo(jsonObject);
                                    }
                                    ++i;
                                    continue Label_0235_Outer;
                                }
                                catch (JSONException ex) {
                                    Logger.e("APGroupInfo", ex.getLocalizedMessage());
                                    continue;
                                }
                                break;
                            }
                            break;
                        }
                    }
                    final AJSONObject ajsonObject3 = ((AJSONObject)ajsonObject).getAJSONObject("userInfo");
                    if (ajsonObject3 != null) {
                        Logger.d("APInterceptResponseListener", "setUserInfo");
                        APService.this.mUserInfo.firstName = ajsonObject3.getString("firstName");
                        APService.this.mUserInfo.lastName = ajsonObject3.getString("lastName");
                        APService.this.mUserInfo.account = ajsonObject3.getString("account");
                    }
                }
                APService.this.saveUserInfo();
            }
        });
        apResponseHandler.setUseSynchronousMode(true);
        this.refreshAnonymousToken(true);
        this.mHttpClient.postWithToken(this.mContext, this.mUserInfo.anonymousToken, this.mServerInfo.getUrl("/auth/login"), ajsonObject, apResponseHandler);
    }
    
    public boolean deleteTokenInfo() {
        final boolean commit = this.getUserInfoSharedPreferences().edit().remove("APUserInfo").commit();
        this.mUserInfo.lastLogginedAccount = this.mUserInfo.account;
        this.mUserInfo.lastLogginedUserId = this.mUserInfo.userId;
        this.mUserInfo.clear();
        Logger.d("APService", "deleteTokenInfo");
        return commit;
    }
    
    @Deprecated
    public void getAnonymouseToken(final APResponseHandler apResponseHandler) {
    }
    
    String getAuthToken() {
        if (this.mUserInfo.isLogin()) {
            return this.mUserInfo.userTokens;
        }
        return this.mUserInfo.anonymousToken;
    }
    
    Context getContext() {
        return this.mContext;
    }
    
    APHttpClient getHttpClient() {
        return this.mHttpClient;
    }
    
    public LogLevel getLogLevel() {
        return this.mLogLevel;
    }
    
    APServerInfo getServerInfo() {
        return this.mServerInfo;
    }
    
    public APUserInfo getUserInfo() {
        return this.mUserInfo;
    }
    
    @Deprecated
    public String getUserToken() {
        return "";
    }
    
    public boolean hasUserToken() {
        return this.mUserInfo != null && !TextUtils.isEmpty((CharSequence)this.mUserInfo.userTokens);
    }
    
    public boolean isInit() {
        return this.mServerInfo != null && !StringUtils.isNullSpace(this.mServerInfo.appId) && !StringUtils.isNullSpace(this.mServerInfo.appVersion) && !StringUtils.isNullSpace(this.mServerInfo.deviceUDID) && !StringUtils.isNullSpace(this.mServerInfo.hostName);
    }
    
    public void logout(final APResponseHandler apResponseHandler) {
        if (!this.isInit()) {
            throw new APException("you need to set APService.setServiceInfo");
        }
        Logger.i("APService", "logout");
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("authToken", this.getAuthToken());
        Logger.v("APService", "params=" + ajsonObject.toString());
        this.mHttpClient.postWithToken(this.mContext, this.mUserInfo.userTokens, this.mServerInfo.getUrl("/auth/logout"), ajsonObject, apResponseHandler);
        this.deleteTokenInfo();
    }
    
    void refreshAnonymousToken(final boolean b) {
        if (!this.isInit()) {
            throw new APException("you need to set APService.setServiceInfo");
        }
        if (!b && this.hasUserToken()) {
            Log.d("APService", "[refreshAnonymousToken]:hasUserToken is OK.");
            return;
        }
        if (!b && this.hasAnonymousToken()) {
            Log.d("APService", "[refreshAnonymousToken]:hasAnonymousToken is OK.");
            return;
        }
        this.mHttpClient.get(this.mContext, this.mServerInfo.getUrl("/anonymousTokens") + "?" + "appKey" + "=" + this.mServerInfo.appKey + "&" + "deviceUDID" + "=" + this.mServerInfo.deviceUDID, new APCommonResponseHandler(true) {
            @Override
            public void onFailure(final APResponse apResponse) {
                Log.d("APService", "refreshAnonymousToken:onFailure=" + apResponse.getResponseData());
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                Logger.d("APService", "[refreshAnonymousToken]:success.");
                APService.this.mUserInfo.anonymousToken = ((AJSONObject)apResponse.getResponseData()).getString("results");
                APService.this.saveUserInfo();
            }
        });
    }
    
    @Deprecated
    public void registeDevice(final int n, final String s, final String s2, final APResponseHandler apResponseHandler) {
        this.registerDevice(s, apResponseHandler);
    }
    
    public void registerDevice(final String s, final APResponseHandler apResponseHandler) {
        if (!this.isInit()) {
            throw new IllegalArgumentException("you need to set APService.setServiceInfo");
        }
        this.refreshAnonymousToken(true);
        final String anonymousToken = this.getUserInfo().anonymousToken;
        Logger.i("APService", "registerDevice");
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("deviceToken", s);
        ajsonObject.put("deviceUDID", this.mServerInfo.deviceUDID);
        ajsonObject.put("osType", "Android");
        ajsonObject.put("deviceName", Build.DEVICE);
        this.mHttpClient.postWithToken(this.mContext, anonymousToken, this.mServerInfo.getUrl("/devices"), ajsonObject, apResponseHandler);
    }
    
    public void sendLog(final APLogging apLogging) {
        if (!this.isInit()) {
            throw new IllegalArgumentException("you need to set APService.setServiceInfo");
        }
        Logger.i("APService", "sendLog");
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("message", apLogging.message);
        String s;
        if (apLogging.logLevel == 1) {
            s = "ERROR";
        }
        else {
            s = "MONITOR";
        }
        ajsonObject.put("logLevel", s);
        Logger.v("APService", "params=" + ajsonObject.toString());
        this.refreshAnonymousToken(false);
        this.mHttpClient.postWithToken(this.mContext, this.getAuthToken(), this.mServerInfo.getUrl("/logs"), ajsonObject, new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                APEntityManager.getInstance().removeLog(apLogging);
            }
        });
    }
    
    public void setLogLevel(final LogLevel mLogLevel) {
        this.mLogLevel = mLogLevel;
    }
    
    public void setServiceInfo(final Context context, final int n, final String s, final String s2, final String s3, final String s4, final String s5, final int n2, final boolean b, final boolean b2) {
        this.setServiceInfo(context, n, s, s2, s3, s4, s5, n2, b, b2, null);
    }
    
    public void setServiceInfo(final Context mContext, final int n, final String s, final String s2, final String s3, final String s4, final String s5, final int n2, final boolean mPushFlag, final boolean b, final String s6) {
        this.mContext = mContext;
        this.mServerInfo = new APServerInfo(n, s, s2, s3, s4, n2, s5, b, this.getDeviceID(), s6);
        this.mPushFlag = mPushFlag;
        this.mHttpClient = this.mServerInfo.getHttpClient();
        (this.mLogTimer = new Timer()).schedule(new APLogWorker(), 600000L, 600000L);
        this.loadUserInfo();
    }
    
    @Deprecated
    public void setTimeout(final int n) {
        if (this.mHttpClient == null) {
            throw new APException("set after APService.setServiceInfo()");
        }
    }
    
    private class APLogWorker extends TimerTask
    {
        private static final String TAG = "APLogWorker";
        
        @Override
        public void run() {
            Logger.v("APLogWorker", "[run]check Log");
            APService.this.mHttpClient.get(APService.this.getContext(), APService.this.mServerInfo.getUrl("/logLevel?token=" + APService.this.getAuthToken()), new APResponseHandler() {
                private void sendLogsToServer(final int n) {
                    final APEntityManager instance = APEntityManager.getInstance();
                    for (final APLogging apLogging : instance.getLogList()) {
                        if (apLogging.logLevel >= n) {
                            APService.this.sendLog(apLogging);
                        }
                        else {
                            instance.removeLog(apLogging);
                        }
                    }
                }
                
                @Override
                public void onFailure(final APResponse apResponse) {
                    Logger.d("APLogWorker", "[onFailure]:Can not get LogLevel. " + apResponse.getDescription() + ", logLevel=" + 0);
                    this.sendLogsToServer(0);
                }
                
                @Override
                public void onSuccess(final APResponse apResponse) {
                    final String string = ((AJSONObject)apResponse.getResponseData()).getString("results");
                    int i;
                    if ("ERROR".equals(string)) {
                        i = 1;
                    }
                    else {
                        i = 0;
                    }
                    Logger.d("APLogWorker", "[onSuccess]:logLevelStr=" + string + ", logLevel=" + i);
                    this.sendLogsToServer(i);
                }
            });
        }
    }
    
    public enum LoginCheckLevel
    {
        CheckNone, 
        CheckUserAndData, 
        CheckUserOnly;
    }
}
