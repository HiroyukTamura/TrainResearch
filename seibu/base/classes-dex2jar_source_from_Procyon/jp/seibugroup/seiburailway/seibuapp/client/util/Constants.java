// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.util;

import java.util.Arrays;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import java.util.Random;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import java.util.List;
import java.util.ArrayList;

public class Constants
{
    public static final String ADD_STATION_INTENT_KEY = "station_name";
    public static final int ADD_STATION_REQUEST_CODE = 1;
    public static final String API_DETAIL_TRAIN = "1";
    public static final String APP_POT = "AppPot";
    public static final String APP_POT_APP_VERSION = "1.0";
    public static final int APP_POT_COMPANY_ID = 1;
    public static final String APP_POT_CONTEXT_ROOT = "/apppot";
    public static final int APP_POT_DATABASE_VERSION = 1;
    public static final boolean APP_POT_IS_ALLOW_DIFFERENT_USER = true;
    public static final boolean APP_POT_PUSH_FLAG = true;
    public static final int APP_POT_REFRESH_INTERVAL = 300;
    public static final boolean APP_POT_RESET_DATABASE = false;
    public static final int APP_STATUS_CODE_ERROR = -1;
    public static final int APP_STATUS_CODE_NORMAL = 1;
    public static final String BACKGROUND_OPEN_PUSH = "background_open_push";
    public static final String BACKGROUND_RECEIVE_PUSH = "background_receive_push";
    public static String BASEBALL_REST_DAY_NIGHT;
    public static String BASEBALL_REST_DAY_SUN;
    public static String BASEBALL_WORK_DAY_NIGHT;
    public static final long BEACON_DEFAULT_BETWEEN_SCAN_PERIOD = 3000L;
    public static final long BEACON_DEFAULT_EXIT_PERIOD = 60000L;
    public static final long BEACON_DEFAULT_SCAN_PERIOD = 2000L;
    public static final String BEACON_DELETE = "beacon_delete";
    public static final String BEACON_FORMAT = "m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24";
    public static final String BEACON_LOCATION_TYPE_CAR = "1";
    public static final String BEACON_REGISTER = "beacon_register";
    public static final String BEACON_UNIQUE_ID = "EstimoteRegion1";
    public static final String CHECKIN_API_ERROR = "E0234";
    public static final String CHECKIN_BY_WEB = "checkin_by_web";
    public static final String CHECKN_IN_INFO_CHANGED = "check_in_info_changed";
    public static final String CLUB_SEIBURAILWAY = "8";
    public static final String CODE_120 = "120";
    public static final String CODE_200 = "200";
    public static final String CODE_201 = "201";
    public static final String CODE_202 = "202";
    public static final String CODE_203 = "203";
    public static final String CODE_210 = "210";
    public static final String CODE_300 = "300";
    public static final String CODE_301 = "301";
    public static final String CODE_302 = "302";
    public static final String CODE_400 = "400";
    public static final String CODE_401 = "401";
    public static final String CODE_402 = "402";
    public static final String CODE_500 = "500";
    public static final String CODE_501 = "501";
    public static final String CODE_NG_PARAM = "100";
    public static final String CODE_NG_SERVER = "200";
    public static final String CODE_OK = "0";
    public static final String COUPON_URL = "https://events.seibuapp.jp/cp/Coupon";
    public static final String CS = "12";
    public static final String DEFAULT_ROUTE_ID = "L001";
    public static final String DELAY = "1";
    public static ArrayList<String> DETECTED_ID;
    public static final String EVENT_HISTORY_URL = "https://events.seibuapp.jp/cp/EventHistory";
    public static final String EVENT_URL = "https://events.seibuapp.jp/cp/Event";
    public static final String FIRST_OPEN_APP = "first_open_app";
    public static final String HELP_URL = "https://events.seibuapp.jp/cp/Help";
    public static final String HTTPS = "https://";
    public static boolean IS_FIRST_START_FROM_RUNSTATUS_NOTIFICATION = false;
    public static boolean IS_FROM_RUNSTATUS = false;
    public static final String LEFT_LINE = "L902";
    public static String LINE_ID;
    public static String LOCATION_STATION_ID;
    public static final String LOGIN_URL = "https://events.seibuapp.jp/cp/Login";
    public static final int MAX_SEARCH_LENGTH = 50;
    public static final String MEMBER_URL = "https://events.seibuapp.jp/cp/Member";
    public static final String MYPAGE = "9";
    public static final int MY_LINE_COUNT_MAX = 3;
    public static final String MY_STATION_CHANGED = "my_station_changed";
    public static final int MY_STATION_COUNT_MAX = 10;
    public static final String NORIKAE_PC_N1 = "5";
    public static final String NORIKAE_PC_READMESP = "3";
    public static final String NORIKAE_PC_U1 = "4";
    public static String NORMAL_REST_DAY;
    public static String NORMAL_WORK_DAY;
    public static final int NOTIFICATION_IMAGE_LOAD_TIME = 30000;
    public static final String OPEN_EXPLORER = "seibuapp://open?";
    public static final String PARAM_LOGIN_TOKEN = "loginToken";
    public static final String PARAM_URL = "url";
    public static final String PARAM_USER_ID = "userId";
    public static final String PRIVACY = "11";
    public static final String PUSH_BROWSER = "1";
    public static final String PUSH_CHANNEL = "SEIBU";
    public static final String PUSH_CLICK_ACTION = "notification_clicked";
    public static final String PUSH_DATA_EXTRA = "PUSH_DATA_EXTRA";
    public static final String PUSH_HOST_NAME = "events.seibuapp.jp";
    public static final String PUSH_PARAM_TOKEN = "{:loginToken}";
    public static final String PUSH_PARAM_USER_ID = "{:appPotUserId}";
    public static final String PUSH_WEBVIEW = "0";
    public static final String QR_CODE = "qr_code";
    public static final String RAILWAY_EIGYO_WASUREMONO = "6";
    public static final String REGION_IDENTIFIER = "A12136E2-6C83-42D0-9F4D-E779A9B7BE06";
    public static final int REQUEST_CODE_PERMISSION = 1;
    public static final int RESULT_CODE_LOCATION_REQUEST = 3;
    public static final int RESULT_CODE_QR = 5;
    public static final int RESULT_CODE_ROUTE_MAP = 4;
    public static final int RESULT_CODE_TRAIN_INFO = 2;
    public static final int RESULT_CODE_TRAIN_WRAPPING = 1;
    public static final String REVERSE_URL = "https://events.seibuapp.jp/cp/Train/checkin?";
    public static final String RIGHT_LINE = "L901";
    public static final int SHARED_COUNT_MAX = 5;
    public static final String SIGN_CHECKIN = "seibuapp://checkin";
    public static final String SIGN_LOGIN = "seibuapp://token";
    public static final String SIGN_LOGOUT = "seibuapp://logout";
    public static final String SIGN_QR = "seibuapp://qr";
    public static final String SMOOTH = "2";
    public static final String STATION_DEPARTURES = "station_departures";
    public static final int STATION_HISTORY_MAX_COUNT = 20;
    public static final String STATION_ID = "station_id";
    public static final String TIME_TABLE_API_BASEBALL_MATCH = "2";
    public static final String TIME_TABLE_API_BASEBALL_NORMAL = "3";
    public static final String TIME_TABLE_API_BASEBALL_NORMAL_HOLIDAY = "4";
    public static final String TIME_TABLE_API_DW_HOLIDAY = "1";
    public static final String TIME_TABLE_API_DW_NORMAL = "0";
    public static final String TIME_TABLE_ARRIVAL = "arrival";
    public static final String TIME_TABLE_DEPARTURE = "departure";
    public static final String TOSHIMAEN = "10";
    public static final String TRAIN_DIRECTION_DOWN = "down";
    public static final String TRAIN_DIRECTION_UP = "up";
    public static String TRAIN_ID;
    public static final String TRAIN_POSITION_SCROLL_TO_NEXT = "train_position_scroll_to_next";
    public static final String TRAIN_POSITION_SCROLL_TO_PREVIOUS = "train_position_scroll_to_previous";
    public static final String TRANSFER_URL = "https://events.seibuapp.jp/cp/Train/searchRoute";
    public static final int TRANSFORM_CELL = 1;
    public static final int TRANSFORM_SECTION = 0;
    public static final String TRANSFORM_SECTION_TYPE = "section_type";
    public static int TUTORIAL_PAGER_POSITION = 0;
    public static final String USER_POLICY_URL = "https://events.seibuapp.jp/cp/Setting/userpolicy";
    public static final String WALLPAPER = "13";
    public static final String WEATHER = "14";
    public static final String WEB_SEIBURAILWAY = "7";
    private static List<BaseStation> mSavedMyStationData;
    
    static {
        Constants.TUTORIAL_PAGER_POSITION = 0;
        Constants.IS_FROM_RUNSTATUS = false;
        Constants.IS_FIRST_START_FROM_RUNSTATUS_NOTIFICATION = false;
        Constants.NORMAL_WORK_DAY = "0";
        Constants.NORMAL_REST_DAY = "1";
        Constants.BASEBALL_WORK_DAY_NIGHT = "2";
        Constants.BASEBALL_REST_DAY_SUN = "3";
        Constants.BASEBALL_REST_DAY_NIGHT = "4";
    }
    
    public static List<BaseStation> getSavedMyStationData() {
        if (Constants.mSavedMyStationData == null) {
            return new ArrayList<BaseStation>();
        }
        return Constants.mSavedMyStationData;
    }
    
    public static void setSavedMyStationData(final List<BaseStation> mSavedMyStationData) {
        Constants.mSavedMyStationData = mSavedMyStationData;
    }
    
    public enum HomeBgColorType
    {
        BLUE(0, 2131230934, -15765064, -14768929, -13408564), 
        GREEN(1, 2131230935, -6563704, -3937629, -12072342), 
        LIGHTBLUE(6, 2131230936, -10435857, -6826772, -4335105), 
        ORANGE(2, 2131230937, -83916, -598912, -22512), 
        PINK(4, 2131230938, -1143106, -802082, -141841), 
        PURPLE(5, 2131230939, -3042092, -1321730, -4218165), 
        WHITE(7, 2131230941, -657931, -328966, -1), 
        YELLOW(3, 2131230942, -724315, -790334, -1448777);
        
        private int colorId;
        private int colorName;
        private int endColor;
        private int previewColor;
        private int startColor;
        
        private HomeBgColorType(final int colorId, final int colorName, final int startColor, final int endColor, final int previewColor) {
            this.colorId = colorId;
            this.colorName = colorName;
            this.startColor = startColor;
            this.endColor = endColor;
            this.previewColor = previewColor;
        }
        
        private int getColorId() {
            return this.colorId;
        }
        
        public static HomeBgColorType getStartColorById(final int n) {
            final HomeBgColorType[] values = values();
            for (int length = values.length, i = 0; i < length; ++i) {
                final HomeBgColorType homeBgColorType = values[i];
                if (homeBgColorType.getColorId() == n) {
                    return homeBgColorType;
                }
            }
            return null;
        }
        
        public int getColorName() {
            return this.colorName;
        }
        
        public int getEndColor() {
            return this.endColor;
        }
        
        public int getPreviewColor() {
            return this.previewColor;
        }
        
        public int getStartColor() {
            return this.startColor;
        }
    }
    
    public enum HomeTrain
    {
        LAVIEW_TRAIN(2130837779), 
        SMILE_TRAIN_2000(2130837789), 
        SMILE_TRAIN_40000(2130837790), 
        SMILE_TRAIN_DEFAULT(2130837791), 
        SMILE_TRAIN_REDARROW(2130837792), 
        SMILE_TRAIN_REDARROW_CLASSIC(2130837793);
        
        private int resId;
        
        private HomeTrain(final int resId) {
            this.resId = resId;
        }
        
        public static int getHomeTrainRes() {
            return values()[new Random().nextInt(values().length)].resId;
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface LegendRest {
    }
    
    public enum PushType
    {
        ACTIVITY, 
        ARRIVAL, 
        COMPANY, 
        COUPON, 
        COUPONS, 
        EVENT, 
        EVENTS, 
        NEWS, 
        NOTIFICATION, 
        NULL, 
        OTHER, 
        POSTMARK, 
        RUN, 
        STATION, 
        STATIONS, 
        TICKET, 
        WAYSIDE;
    }
    
    public enum Result
    {
        FAILURE, 
        SUCCESS;
    }
    
    public enum RouteWithBeacon
    {
        IKEBUKURO_LONG("S0100IK", "S0180CC", Arrays.asList("S0180CC", "S0179CY", "S0160HA", "S0154IM", "S0440TZ", "S0100IK")), 
        IKEBUKURO_SHORT("S0100IK", "S0215SK", Arrays.asList("S0215SK", "S0440TZ", "S0100IK")), 
        SHINJUKU("S0160HA", "S0100IK", Arrays.asList("S0160HA", "S0154IM", "S0440TZ", "S0100IK"));
        
        private String endStationOneSide;
        private String endStationOtherSide;
        private List<String> stationList;
        
        private RouteWithBeacon(final String endStationOneSide, final String endStationOtherSide, final List<String> stationList) {
            this.endStationOneSide = endStationOneSide;
            this.endStationOtherSide = endStationOtherSide;
            this.stationList = stationList;
        }
        
        public static RouteWithBeacon getStationByTrain(final String s, final String s2) {
            final RouteWithBeacon[] values = values();
            for (int length = values.length, i = 0; i < length; ++i) {
                final RouteWithBeacon routeWithBeacon = values[i];
                if ((routeWithBeacon.endStationOneSide.equals(s2) || routeWithBeacon.endStationOtherSide.equals(s2)) && (routeWithBeacon.endStationOneSide.equals(s) || routeWithBeacon.endStationOtherSide.equals(s))) {
                    return routeWithBeacon;
                }
            }
            return null;
        }
        
        public List<String> getStationList() {
            return this.stationList;
        }
    }
    
    public enum TimeTableType
    {
        BASEBALL, 
        NORMAL;
    }
    
    public enum TrainInfoType
    {
        ESTIMATED_TIME, 
        SCHEDULED_TIME, 
        TIME_REQUIRED;
    }
}
