package p043jp.reifrontier.gym;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.hash.HashIdManager;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef;", "", "()V", "DEFAULT_GYM_ID", "", "DEFAULT_GYM_ID_HASH", "getDEFAULT_GYM_ID_HASH", "()Ljava/lang/String;", "DEFAULT_GYM_ID_INT", "", "IMAGE_URL_SUFFIX", "ActivityChartType", "BodyType", "ChartType", "FragType", "Info", "RankingType", "T", "TabType", "TrainType", "URL", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.RFGDef */
public final class RFGDef {
    public static final String DEFAULT_GYM_ID = "0";
    private static final String DEFAULT_GYM_ID_HASH = HashIdManager.INSTANCE.encode(0);
    public static final int DEFAULT_GYM_ID_INT = 0;
    public static final String IMAGE_URL_SUFFIX = "?access_token=";
    public static final RFGDef INSTANCE = new RFGDef();

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$ActivityChartType;", "", "titleRes", "", "unitRes", "json", "", "colorRes", "(Ljava/lang/String;IIILjava/lang/String;I)V", "getColor", "context", "Landroid/content/Context;", "getJson", "getTitle", "getUnit", "X", "POINT", "WEIGHT", "STEP", "BICYCLE", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$ActivityChartType */
    public enum ActivityChartType {
        X(R.string.activity_chart_title_x, R.string.activity_chart_unit_x, "x", R.color.green),
        POINT(R.string.activity_chart_title_point, R.string.activity_chart_unit_point, "point", R.color.yellow),
        WEIGHT(R.string.activity_chart_title_weight, R.string.activity_chart_unit_weight, "weight", R.color.pink),
        STEP(R.string.activity_chart_title_step, R.string.activity_chart_unit_step, "step", R.color.yellow),
        BICYCLE(R.string.activity_chart_title_bicycle, R.string.activity_chart_unit_bicycle, "bicycle", R.color.sanriku_orange);
        
        private final int colorRes;
        private final String json;
        private final int titleRes;
        private final int unitRes;

        private ActivityChartType(@StringRes int i, @StringRes int i2, String str, @ColorRes int i3) {
            this.titleRes = i;
            this.unitRes = i2;
            this.json = str;
            this.colorRes = i3;
        }

        public final int getColor(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return ContextCompat.getColor(context, this.colorRes);
        }

        public final String getJson() {
            return this.json;
        }

        public final String getTitle(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            String string = context.getResources().getString(this.titleRes);
            Intrinsics.checkExpressionValueIsNotNull(string, "context.resources.getString(titleRes)");
            return string;
        }

        public final String getUnit(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            String string = context.getResources().getString(this.unitRes);
            Intrinsics.checkExpressionValueIsNotNull(string, "context.resources.getString(unitRes)");
            return string;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$BodyType;", "", "(Ljava/lang/String;I)V", "Height", "Weight", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$BodyType */
    public enum BodyType {
        Height,
        Weight
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$ChartType;", "", "(Ljava/lang/String;I)V", "WEEK6", "WEEK12", "MONTH6", "MONTH12", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$ChartType */
    public enum ChartType {
        WEEK6,
        WEEK12,
        MONTH6,
        MONTH12
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$FragType;", "", "(Ljava/lang/String;I)V", "Feed", "ActivitySingle", "Point", "ScheduleMap", "StationList", "SpotList", "SpotDetail", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$FragType */
    public enum FragType {
        Feed,
        ActivitySingle,
        Point,
        ScheduleMap,
        StationList,
        SpotList,
        SpotDetail
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$Info;", "", "()V", "getResId", "", "resName", "", "getStringId", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$Info */
    public static final class Info {
        public static final Info INSTANCE = new Info();

        private Info() {
        }

        public final int getResId(String str) {
            Intrinsics.checkParameterIsNotNull(str, "resName");
            try {
                Field field = C2092R.mipmap.class.getField(str);
                Intrinsics.checkExpressionValueIsNotNull(field, "res.getField(resName)");
                return field.getInt((Object) null);
            } catch (Exception unused) {
                return R.mipmap.map999;
            }
        }

        public final int getStringId(String str) {
            Intrinsics.checkParameterIsNotNull(str, "resName");
            try {
                Field field = C2092R.string.class.getField(str);
                Intrinsics.checkExpressionValueIsNotNull(field, "res.getField(resName)");
                return field.getInt((Object) null);
            } catch (Exception unused) {
                return R.mipmap.map999;
            }
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$RankingType;", "", "(Ljava/lang/String;I)V", "POINT", "STEPS", "BIKE", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$RankingType */
    public enum RankingType {
        POINT,
        STEPS,
        BIKE
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$T;", "", "()V", "walkTime", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$T */
    public static final class C2097T {
        public static final C2097T INSTANCE = new C2097T();

        private C2097T() {
        }

        public final boolean walkTime() {
            Date date = new Date();
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
            instance.setTime(date);
            return instance.get(11) > 5;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$TabType;", "", "(Ljava/lang/String;I)V", "Feed", "Schedule", "Info", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$TabType */
    public enum TabType {
        Feed,
        Schedule,
        Info
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$TrainType;", "", "typeValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeValue", "()Ljava/lang/String;", "UP", "DOWN", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$TrainType */
    public enum TrainType {
        UP("up"),
        DOWN("down");
        
        private final String typeValue;

        private TrainType(String str) {
            this.typeValue = str;
        }

        public final String getTypeValue() {
            return this.typeValue;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGDef$URL;", "", "()V", "USER_ICON_PATH", "", "baseUrl", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGDef$URL */
    public static final class URL {
        public static final URL INSTANCE = new URL();
        public static final String USER_ICON_PATH = "/user/image";

        private URL() {
        }

        public final String baseUrl() {
            return "https://api.gym.silentlog.com/api/v1";
        }
    }

    private RFGDef() {
    }

    public final String getDEFAULT_GYM_ID_HASH() {
        return DEFAULT_GYM_ID_HASH;
    }
}
