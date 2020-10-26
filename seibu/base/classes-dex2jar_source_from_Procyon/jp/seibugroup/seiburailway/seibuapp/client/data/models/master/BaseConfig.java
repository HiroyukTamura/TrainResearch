// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import android.text.TextUtils;
import android.graphics.drawable.Drawable;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import android.support.v4.content.ContextCompat;
import android.content.Context;
import java.util.Collection;
import java.util.Arrays;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import jp.seibugroup.seiburailway.seibuapp.client.CTCApplication_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.UsageTrainImageData;
import java.util.ArrayList;
import android.support.annotation.DrawableRes;
import java.util.Map;
import android.support.v4.util.Pair;
import java.util.List;

public class BaseConfig
{
    public static final List<String> ALL_STOP_CODE;
    public static final String ALL_STOP_TYPE;
    public static final Pair[] BRANCH_ROUTE;
    public static final Map<String, Integer> CAR_ICON_RES;
    public static final List<String> DEFAULT_TRAIN_TYPE;
    @DrawableRes
    public static final int ICON_RES_DEFAULT = 2130837822;
    @DrawableRes
    public static final int ICON_RES_MULTI = 2130837825;
    public static final String ICON_TYPE_MULTI = "131415926";
    public static final ArrayList<String> IKEBUKURO_CHICHIBULINE_STATION_IDS;
    public static final String LINE_CHICHIBU;
    public static final String LINE_DEFAULT;
    public static final String LINE_HAIJIMA;
    public static final String LINE_IKEBUKURO;
    public static final String LINE_KOKUBUNJI;
    public static final String LINE_SAYAMA;
    public static final String LINE_SINJYUKU;
    public static final String LINE_TAMAGAWA;
    public static final String LINE_TAMAKO;
    public static final String LINE_YAMAGUCHI;
    public static final String LINE_YURAKUTYO;
    public static final String ROUTE_CONFIG_DIR = "route_config/";
    public static final Pair[] ROUTE_CONFIG_MAP;
    public static final String ROUTE_DIR = "route_map/";
    public static final Pair[] ROUTE_MAP;
    public static final Pair[] SUBLINE_LEFT;
    public static final Pair[] SUBLINE_RIGHT;
    public static final String TRAIN_POSITION_ALL_LINES = "L001+L002+L003+L005+L008+L009+L011+L012+L021+L022+L013+L010";
    public static final ArrayList<UsageTrainImageData> USAGE_DATA;
    
    static {
        SUBLINE_LEFT = new Pair[] { Pair.create("L003", "S0200TO"), Pair.create("L003", "S0105NE") };
        SUBLINE_RIGHT = new Pair[] { Pair.create("L010", "S1500SB"), Pair.create("L010", "S1435HM") };
        ALL_STOP_TYPE = CTCApplication_.getInstance().getString(2131230819);
        ALL_STOP_CODE = Lists.newArrayList("15", "60", "61", "62");
        BRANCH_ROUTE = new Pair[] { Pair.create("L010", "L009"), Pair.create("L003", "L001") };
        CAR_ICON_RES = ImmutableMap.builder().put("001", 2130837866).put("101", 2130837806).put("2000", 2130837809).put("2007", 2130837863).put("4000", 2130837813).put("4001", 2130837814).put("6000", 2130837815).put("8500", 2130837816).put("9000", 2130837817).put("9001", 2130837819).put("9002", 2130837818).put("10000", 2130837804).put("10001", 2130837805).put("20000", 2130837807).put("20001", 2130837820).put("20002", 2130837808).put("30000", 2130837810).put("30001", 2130837811).put("40000", 2130837812).put("ME", 2130837867).put("TY", 2130837869).put("YM", 2130837870).put("131415926", 2130837825).build();
        USAGE_DATA = new ArrayList<UsageTrainImageData>(Arrays.asList(new UsageTrainImageData(2130903052, 2130837812), new UsageTrainImageData(2130903050, 2130837810), new UsageTrainImageData(2130903049, 2130837807), new UsageTrainImageData(2130903046, 2130837804), new UsageTrainImageData(2130903055, 2130837817), new UsageTrainImageData(2130903053, 2130837815), new UsageTrainImageData(2130903051, 2130837813), new UsageTrainImageData(2130903048, 2130837809), new UsageTrainImageData(2130903047, 2130837806), new UsageTrainImageData(2130903054, 2130837816)));
        LINE_SINJYUKU = CTCApplication_.getInstance().getString(2131230899);
        LINE_IKEBUKURO = CTCApplication_.getInstance().getString(2131230896);
        LINE_YURAKUTYO = CTCApplication_.getInstance().getString(2131230903);
        LINE_KOKUBUNJI = CTCApplication_.getInstance().getString(2131230897);
        LINE_HAIJIMA = CTCApplication_.getInstance().getString(2131230895);
        LINE_CHICHIBU = CTCApplication_.getInstance().getString(2131230894);
        LINE_SAYAMA = CTCApplication_.getInstance().getString(2131230898);
        LINE_YAMAGUCHI = CTCApplication_.getInstance().getString(2131230902);
        LINE_TAMAKO = CTCApplication_.getInstance().getString(2131230901);
        LINE_TAMAGAWA = CTCApplication_.getInstance().getString(2131230900);
        LINE_DEFAULT = BaseConfig.LINE_IKEBUKURO;
        ROUTE_MAP = new Pair[] { Pair.create(BaseConfig.LINE_TAMAGAWA, "img_train_position_tamagawa.jpg"), Pair.create(BaseConfig.LINE_YAMAGUCHI, "img_train_position_yamaguchi.jpg"), Pair.create(BaseConfig.LINE_TAMAKO, "img_train_position_tamako.jpg"), Pair.create(BaseConfig.LINE_KOKUBUNJI, "img_train_position_kokubunji.jpg"), Pair.create(BaseConfig.LINE_HAIJIMA, "img_train_position_haijima.jpg"), Pair.create(BaseConfig.LINE_SINJYUKU, "img_train_position_shinjuku.jpg"), Pair.create(BaseConfig.LINE_IKEBUKURO, "img_train_position_ikebukuro.jpg"), Pair.create(BaseConfig.LINE_CHICHIBU, "img_train_position_chichibu.jpg"), Pair.create(BaseConfig.LINE_YURAKUTYO, "img_train_position_yurakutyo.jpg"), Pair.create(BaseConfig.LINE_SAYAMA, "img_train_position_sayama.jpg") };
        ROUTE_CONFIG_MAP = new Pair[] { Pair.create(BaseConfig.LINE_SINJYUKU, "shinjuku.json"), Pair.create(BaseConfig.LINE_IKEBUKURO, "ikebukuro.json"), Pair.create(BaseConfig.LINE_KOKUBUNJI, "kokubunji.json"), Pair.create(BaseConfig.LINE_HAIJIMA, "haijima.json"), Pair.create(BaseConfig.LINE_CHICHIBU, "chichibu.json"), Pair.create(BaseConfig.LINE_SAYAMA, "sayama.json"), Pair.create(BaseConfig.LINE_YAMAGUCHI, "yamaguchi.json"), Pair.create(BaseConfig.LINE_TAMAKO, "tamako.json"), Pair.create(BaseConfig.LINE_TAMAGAWA, "tamagawa.json"), Pair.create(BaseConfig.LINE_YURAKUTYO, "yurakutyo.json") };
        IKEBUKURO_CHICHIBULINE_STATION_IDS = Lists.newArrayList("S0161HH", "S0166CK", "S0167CM", "S0168CH", "S0170CA", "S0175CN", "S0176CS", "S0178CB", "S0179CY", "S0180CC");
        DEFAULT_TRAIN_TYPE = Arrays.asList("9", "19", "17", "2", "4", "6", "5", "7", "8", "15");
    }
    
    @DrawableRes
    public static int getCarTypeResource(final String s) {
        final Integer n = BaseConfig.CAR_ICON_RES.get(s);
        if (n == null) {
            return 2130837822;
        }
        return n;
    }
    
    public enum NearbyStationLineColor
    {
        CHICHIBU("L008", 2131558472, 2131230894), 
        HAJIMA("L011", 2131558420, 2131230895), 
        IKEBUKURO("L001", 2131558472, 2131230896), 
        KOKUBUNJI("L012", 2131558464, 2131230897), 
        SAYAMA("L002", 2131558472, 2131230898), 
        SEIBUEN("L010", 2131558420, 2131231248), 
        SHINJUKU("L009", 2131558420, 2131230899), 
        TAMAGAWA("L021", 2131558472, 2131230900), 
        TAMAKO("L013", 2131558494, 2131230901), 
        TOSHIMAEN("L003", 2131558472, 2131231249), 
        YAMAGUCHI("L022", 2131558480, 2131230902), 
        YURAKUTYO("L005", 2131558472, 2131230903);
        
        private int mColorId;
        private String mLineId;
        private int mLineName;
        
        private NearbyStationLineColor(final String mLineId, final int mColorId, final int mLineName) {
            this.mLineId = mLineId;
            this.mColorId = mColorId;
            this.mLineName = mLineName;
        }
        
        private int getColor(final Context context) {
            return ContextCompat.getColor(context, this.mColorId);
        }
        
        public static int getLineColor(final String s, final Context context) {
            final Optional<NearbyStationLineColor> first = Stream.of((Iterable<? extends NearbyStationLineColor>)Lists.newArrayList(values())).filter(BaseConfig$NearbyStationLineColor$$Lambda$1.lambdaFactory$(s)).findFirst();
            if (first.isPresent()) {
                return first.get().getColor(context);
            }
            return 0;
        }
        
        public static String getLineName(final String s, final Context context) {
            final Optional<NearbyStationLineColor> first = Stream.of((Iterable<? extends NearbyStationLineColor>)Lists.newArrayList(values())).filter(BaseConfig$NearbyStationLineColor$$Lambda$2.lambdaFactory$(s)).findFirst();
            if (first.isPresent()) {
                return first.get().getString(context);
            }
            return "";
        }
        
        private String getString(final Context context) {
            return context.getString(this.mLineName);
        }
        
        private boolean isValid(final String anObject) {
            return this.mLineId.equals(anObject);
        }
    }
    
    public enum OtherCompanyInfo
    {
        JR_COMPANY("jreast", 2130837725), 
        KEIO_COMPANY("keio", 2130837726), 
        METORO_COMPANY("metro", 2130837727), 
        ODAKYU_COMPANY("odakyu", 2130837728), 
        TOBULINE_COMPANY("tobu", 2130837729);
        
        private int companyIcon;
        private String companyId;
        
        private OtherCompanyInfo(final String companyId, final int companyIcon) {
            this.companyId = companyId;
            this.companyIcon = companyIcon;
        }
        
        private static OtherCompanyInfo getCompanyById(final String s) {
            final Optional<OtherCompanyInfo> first = Stream.of((Iterable<? extends OtherCompanyInfo>)Lists.newArrayList(values())).filter(BaseConfig$OtherCompanyInfo$$Lambda$1.lambdaFactory$(s)).findFirst();
            if (first.isPresent()) {
                return first.get();
            }
            return null;
        }
        
        public static int getCompanyIcon(final String s) {
            final OtherCompanyInfo companyById = getCompanyById(s);
            if (companyById != null) {
                return companyById.companyIcon;
            }
            return 2130837778;
        }
        
        private boolean isValid(final String anObject) {
            return this.companyId.equals(anObject);
        }
    }
    
    public enum OtherLineInfo
    {
        L901_LINE("L901", 2130837855), 
        L902_LINE("L902", 2130837852), 
        L908_LINE("L908", 2130837847), 
        L909_LINE("L909", 2130837845), 
        L910_LINE("L910", 2130837850), 
        L911_LINE("L911", 2130837849), 
        L912_LINE("L912", 2130837847), 
        L913_LINE("L913", 2130837845), 
        L914_LINE("L914", 2130837846), 
        L915_LINE("L915", 2130837847), 
        L917_LINE("L917", 2130837848), 
        L918_LINE("L918", 2130837851), 
        L919_LINE("L919", 2130837860), 
        L923_LINE("L923", 2130837853), 
        L924_LINE("L924", 2130837854), 
        L925_LINE("L925", 2130837872);
        
        private int lineIcon;
        private String lineId;
        
        private OtherLineInfo(final String lineId, final int lineIcon) {
            this.lineId = lineId;
            this.lineIcon = lineIcon;
        }
        
        public static int getOtherLineDrawable(final String s) {
            final Optional<OtherLineInfo> first = Stream.of((Iterable<? extends OtherLineInfo>)Lists.newArrayList(values())).filter(BaseConfig$OtherLineInfo$$Lambda$1.lambdaFactory$(s)).findFirst();
            if (first.isPresent()) {
                return first.get().lineIcon;
            }
            return 2130837778;
        }
        
        private boolean isValid(final String anObject) {
            return this.lineId.equals(anObject);
        }
    }
    
    public enum StationIcon
    {
        TYPE_SI("SS", ContextCompat.getDrawable((Context)CTCApplication_.getInstance(), 2130837797)), 
        TYPE_SK("SK", ContextCompat.getDrawable((Context)CTCApplication_.getInstance(), 2130837798)), 
        TYPE_SS("SI", ContextCompat.getDrawable((Context)CTCApplication_.getInstance(), 2130837800)), 
        TYPE_ST("ST", ContextCompat.getDrawable((Context)CTCApplication_.getInstance(), 2130837802)), 
        TYPE_SW("SW", ContextCompat.getDrawable((Context)CTCApplication_.getInstance(), 2130837799)), 
        TYPE_SY("SY", ContextCompat.getDrawable((Context)CTCApplication_.getInstance(), 2130837801)), 
        TYPE_UNKNOWN("XX", ContextCompat.getDrawable((Context)CTCApplication_.getInstance(), 2130837796));
        
        private Drawable mIconDrawable;
        private String mType;
        
        private StationIcon(final String mType, final Drawable mIconDrawable) {
            this.mType = mType;
            this.mIconDrawable = mIconDrawable;
        }
        
        public static StationIcon getStationIconInfoByType(final String s) {
            final Optional<StationIcon> first = Stream.of((Iterable<? extends StationIcon>)Lists.newArrayList(values())).filter(BaseConfig$StationIcon$$Lambda$1.lambdaFactory$(s)).findFirst();
            if (first.isPresent()) {
                return first.get();
            }
            return StationIcon.TYPE_UNKNOWN;
        }
        
        private boolean isValid(final String anObject) {
            return this.mType.equals(anObject);
        }
        
        public Drawable getDrawable() {
            return this.mIconDrawable;
        }
    }
    
    public enum TrainType
    {
        ALL_STOP_A_TRAIN("61", 2131558460, 2130837961, 2130837962, 2131230819), 
        ALL_STOP_B_TRAIN("62", 2131558460, 2130837961, 2130837962, 2131230819), 
        ALL_STOP_D_TRAIN("60", 2131558460, 2130837961, 2130837962, 2131230819), 
        ALL_STOP_TRAIN("15", 2131558449, 2130837961, 2130837962, 2131230819), 
        BACK_A_TRAIN("90", 2131558486, 0), 
        BACK_B_TRAIN("91", 2131558486, 0), 
        BACK_C_TRAIN("92", 2131558486, 0), 
        BACK_D_TRAIN("93", 2131558486, 0), 
        BACK_E_TRAIN("94", 2131558486, 0), 
        BACK_F_TRAIN("95", 2131558486, 0), 
        BACK_G_TRAIN("96", 2131558486, 0), 
        BACK_H_TRAIN("97", 2131558486, 0), 
        BACK_I_TRAIN("98", 2131558486, 0), 
        BACK_J_TRAIN("99", 2131558486, 0), 
        BACK_TRAIN("1", 2131558486, 0), 
        CARGO_TRAIN("14", 2131558486, 0), 
        COMMUTE_SPECIAL_RAPID_TRAIN("6", 2131558492, 2130837949, 2130837950, 2131230813), 
        COMMUT_SEMI_EXPRESS_TRAIN("7", 2131558423, 2130837951, 2130837952, 2131230814), 
        EXPRESS_ST("3", 2131558463, 2130837963, 2130837966, 2131230820), 
        EXPRESS_ST_19("19", 2131558447, 2130837957, 2130837958, 2131230817), 
        EXPRESS_TRAIN("4", 2131558470, 2130837953, 2130837954, 2131230815), 
        LIMITED_EXPRESS_TRAIN("9", 2131558481, 2130837959, 2130837960, 2131230818), 
        LOCAL_A_TRAIN("63", 2131558475, 2130837964, 2130837965, 2131230821), 
        LOCAL_B_TRAIN("64", 2131558475, 2130837964, 2130837965, 2131230821), 
        LOCAL_C_TRAIN("65", 2131558475, 2130837964, 2130837965, 2131230821), 
        LOCAL_D_TRAIN("66", 2131558475, 2130837964, 2130837965, 2131230821), 
        LOCAL_E_TRAIN("67", 2131558475, 2130837955, 2130837956, 2131230816), 
        LOCAL_TRAIN("10", 2131558475, 2130837964, 2130837965, 2131230821), 
        METRO_LIMITED_EXPRESS_A_TRAIN("21", 2131558481, 2130837959, 2130837960, 2131230818), 
        METRO_LIMITED_EXPRESS_B_TRAIN("22", 2131558481, 2130837959, 2130837960, 2131230818), 
        METRO_LIMITED_EXPRESS_TRAIN("20", 2131558481, 2130837959, 2130837960, 2131230818), 
        RAPID_A_TRAIN("51", 2131558463, 2130837963, 2130837966, 2131230820), 
        RAPID_B_TRAIN("52", 2131558463, 2130837963, 2130837966, 2131230820), 
        RAPID_C_TRAIN("53", 2131558463, 2130837963, 2130837966, 2131230820), 
        RAPID_D_TRAIN("54", 2131558463, 2130837963, 2130837966, 2131230820), 
        RAPID_EXPRESS_TRAIN("2", 2131558475, 2130837964, 2130837965, 2131230821), 
        RAPID_TRAIN("5", 2131558463, 2130837963, 2130837966, 2131230820), 
        SECTION_SEMI_EXPRESS_TRAIN("12", 2131558444, 2130837969, 2130837970, 2131230823), 
        SEMI_EXPRESS_A_TRAIN("56", 2131558444, 2130837969, 2130837970, 2131230823), 
        SEMI_EXPRESS_C_TRAIN("58", 2131558444, 2130837969, 2130837970, 2131230823), 
        SEMI_EXPRESS_D_TRAIN("59", 2131558444, 2130837969, 2130837970, 2131230823), 
        SEMI_EXPRESS_TRAIN("8", 2131558444, 2130837969, 2130837970, 2131230823), 
        S_TRY_A_TRAIN("17", 2131558447, 2130837967, 2130837968, 2131230822), 
        S_TRY_A_TRAIN_HAVE("69", 2131558447, 2130837967, 2130837968, 2131230822), 
        S_TRY_A_TRAIN_VICE("68", 2131558447, 2130837967, 2130837968, 2131230822), 
        S_TRY_B_TRAIN("18", 2131558447, 2130837967, 2130837968, 2131230822), 
        S_TRY_B_TRAIN_HAVE("71", 2131558447, 2130837967, 2130837968, 2131230822), 
        S_TRY_B_TRAIN_VICE("70", 2131558447, 2130837967, 2130837968, 2131230822), 
        TEST_RUN_TRAIN("16", 2131558486, 0), 
        UNKNOWN("-1", 2131558452, 0), 
        WROK_RAPID_TRAIN("11", 2131558463, 2130837963, 2130837966, 2131230820), 
        temporary_A_TRAIN("80", 2131558486, 0), 
        temporary_B_TRAIN("81", 2131558486, 0), 
        temporary_C_TRAIN("82", 2131558486, 0), 
        temporary_D_TRAIN("83", 2131558486, 0), 
        temporary_E_TRAIN("84", 2131558486, 0), 
        temporary_F_TRAIN("85", 2131558486, 0), 
        temporary_G_TRAIN("86", 2131558486, 0), 
        temporary_H_TRAIN("87", 2131558486, 0), 
        temporary_I_TRAIN("88", 2131558486, 0), 
        temporary_J_TRAIN("89", 2131558486, 0);
        
        int mBgColorId;
        String mCode;
        int mTrainPositionTypeIcon;
        int mTypeTextId;
        int mbgDrawable;
        
        private TrainType(final String mCode, final int mBgColorId, final int mTypeTextId) {
            this.mCode = mCode;
            this.mBgColorId = mBgColorId;
            this.mTypeTextId = mTypeTextId;
        }
        
        private TrainType(final String mCode, final int mBgColorId, final int mbgDrawable, final int mTrainPositionTypeIcon, final int mTypeTextId) {
            this.mCode = mCode;
            this.mBgColorId = mBgColorId;
            this.mbgDrawable = mbgDrawable;
            this.mTrainPositionTypeIcon = mTrainPositionTypeIcon;
            this.mTypeTextId = mTypeTextId;
        }
        
        public static TrainType get(final String s) {
            final Optional<TrainType> first = Stream.of((Iterable<? extends TrainType>)Lists.newArrayList(values())).filter(BaseConfig$TrainType$$Lambda$1.lambdaFactory$(s)).findFirst();
            if (first.isPresent()) {
                return first.get();
            }
            return TrainType.UNKNOWN;
        }
        
        private boolean isValid(final String anObject) {
            return this.mCode.equals(anObject);
        }
        
        public static TrainType valueOf(final int n) {
            if (n < 0 || n >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }
            return values()[n];
        }
        
        public int getBgColor() {
            return ContextCompat.getColor((Context)CTCApplication_.getInstance(), this.mBgColorId);
        }
        
        @DrawableRes
        public int getBgDrawable() {
            return this.mbgDrawable;
        }
        
        public String getCode() {
            return this.mCode;
        }
        
        public int getTimeTableTextColor() {
            if (BaseConfig.DEFAULT_TRAIN_TYPE.contains(this.mCode) && !TextUtils.equals((CharSequence)this.mCode, (CharSequence)"15")) {
                return ContextCompat.getColor((Context)CTCApplication_.getInstance(), this.mBgColorId);
            }
            return ContextCompat.getColor((Context)CTCApplication_.getInstance(), 2131558453);
        }
        
        public Drawable getTrainPositionTypeIcon() {
            if (this.mTrainPositionTypeIcon == 0) {
                return null;
            }
            return ContextCompat.getDrawable((Context)CTCApplication_.getInstance(), this.mTrainPositionTypeIcon);
        }
        
        public int getTypeText() {
            return this.mTypeTextId;
        }
    }
}
