package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import android.os.Build;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.C1126c;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.silentlogsdkandroid.bus.PostDaily;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLBarometer;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSegment;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSummary;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherListData;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFL_SEGMENT_TYPE;
import p048l.p049a.C1122a;
import p078g.p079a.C1696b;
import p078g.p079a.C1697c;
import p078g.p079a.C1699e;
import p078g.p079a.C1714r;
import p078g.p079a.C1718v;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p100z.C1741d;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00101\u001a\u000202H\u0002J\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J \u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u000209H\u0002J\u001e\u0010<\u001a\u0002092\f\u0010=\u001a\b\u0012\u0004\u0012\u0002090/2\u0006\u00101\u001a\u00020>H\u0002J&\u0010?\u001a\u00020\"2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020>0/2\u0006\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020>H\u0002J&\u0010C\u001a\u00020\"2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020>0/2\u0006\u0010A\u001a\u00020>2\u0006\u0010E\u001a\u00020>H\u0002J\u001f\u0010F\u001a\u00020G2\u0006\u00101\u001a\u0002022\b\u0010H\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020\"2\u0006\u0010K\u001a\u000200H\u0002J*\u0010L\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020>0/H\u0002J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u0002000/2\f\u0010N\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J$\u0010O\u001a\b\u0012\u0004\u0012\u0002000/2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020>0/2\u0006\u00101\u001a\u000202H\u0002J \u0010Q\u001a\u0004\u0018\u00010R2\u0006\u00101\u001a\u0002022\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001e\u0010S\u001a\u00020T2\u0006\u00101\u001a\u0002022\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u0018\u0010U\u001a\u00020T2\u0006\u00101\u001a\u0002022\u0006\u0010V\u001a\u00020RH\u0002J*\u0010W\u001a\b\u0012\u0004\u0012\u0002000/2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002090/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001c\u0010[\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001c\u0010]\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001c\u0010^\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J$\u0010_\u001a\b\u0012\u0004\u0012\u00020>0/2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020>0/2\u0006\u0010A\u001a\u00020>H\u0002J$\u0010`\u001a\b\u0012\u0004\u0012\u00020>0/2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020>0/2\u0006\u0010A\u001a\u00020>H\u0002J*\u0010a\u001a\b\u0012\u0004\u0012\u00020b0/2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020b0/2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020b0/H\u0002J\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020T0e2\u0006\u00101\u001a\u000202J\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020T0e2\u0006\u00101\u001a\u000202J&\u0010g\u001a\u00020G2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010h\u001a\u00020\"2\u0006\u0010i\u001a\u00020jH\u0002J \u0010k\u001a\u00020G2\u0006\u00108\u001a\u0002002\u0006\u0010h\u001a\u00020\"2\u0006\u0010i\u001a\u00020jH\u0002J\u0016\u0010l\u001a\u00020G2\f\u0010N\u001a\b\u0012\u0004\u0012\u0002090/H\u0002J\u0016\u0010m\u001a\u00020G2\f\u0010N\u001a\b\u0012\u0004\u0012\u0002090/H\u0002J\u0018\u0010n\u001a\u00020j2\u0006\u00101\u001a\u0002022\u0006\u0010o\u001a\u00020RH\u0002J\u0016\u0010p\u001a\u00020j2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020j0/H\u0002J&\u0010r\u001a\u00020T2\u0006\u00101\u001a\u0002022\f\u0010s\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010V\u001a\u00020RH\u0002J\u001c\u0010t\u001a\b\u0012\u0004\u0012\u0002090/2\f\u0010u\u001a\b\u0012\u0004\u0012\u0002090/H\u0002J\u001c\u0010v\u001a\b\u0012\u0004\u0012\u0002090/2\f\u0010u\u001a\b\u0012\u0004\u0012\u0002090/H\u0002J\u001c\u0010w\u001a\b\u0012\u0004\u0012\u0002090/2\f\u0010u\u001a\b\u0012\u0004\u0012\u0002090/H\u0002J%\u0010x\u001a\u00020G2\u0006\u00101\u001a\u0002022\u0006\u0010o\u001a\u00020R2\b\u0010H\u001a\u0004\u0018\u00010>¢\u0006\u0002\u0010yJ'\u0010z\u001a\u00020G2\u0006\u00101\u001a\u0002022\u0006\u0010o\u001a\u00020R2\b\u0010H\u001a\u0004\u0018\u00010>H\u0003¢\u0006\u0002\u0010yJ'\u0010{\u001a\u00020G2\u0006\u00101\u001a\u0002022\u0006\u0010|\u001a\u00020R2\b\u0010H\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010yJ\"\u0010}\u001a\u00020G2\u0006\u00101\u001a\u0002022\u0006\u0010|\u001a\u00020R2\b\u0010~\u001a\u0004\u0018\u00010RH\u0002J\"\u0010\u001a\u00020G2\u0006\u00101\u001a\u0002022\u0006\u0010|\u001a\u00020R2\b\u0010~\u001a\u0004\u0018\u00010RH\u0002J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/H\u0002JM\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u00010\u00012\f\u0010V\u001a\b\u0012\u0004\u0012\u00020b0/2\u0007\u0010\u0001\u001a\u00020j2\u0007\u0010\u0001\u001a\u00020j2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020b0/2\u0007\u0010\u0001\u001a\u00020jH\u0002J-\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020b0/2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020b0/2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020b0/H\u0002J!\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020>2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u001f\u0010\u0001\u001a\t\u0012\u0004\u0012\u0002090\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002090/H\u0002J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020>0/2\u0006\u00101\u001a\u000202H\u0002J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020>0/2\u0006\u00101\u001a\u000202H\u0002J\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020>0/2\u0006\u00101\u001a\u0002022\t\b\u0002\u0010\u0001\u001a\u00020\"H\u0002J#\u0010\u0001\u001a\u00020G2\u0006\u00101\u001a\u0002022\u0006\u0010|\u001a\u00020R2\b\u0010~\u001a\u0004\u0018\u00010RH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006\u0001"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;", "", "()V", "dailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "getDailyUtils", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "setDailyUtils", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;)V", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "getDataLogger", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "setDataLogger", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "eventBus", "Lorg/greenrobot/eventbus/EventBus;", "getEventBus", "()Lorg/greenrobot/eventbus/EventBus;", "setEventBus", "(Lorg/greenrobot/eventbus/EventBus;)V", "googleFitManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;", "getGoogleFitManager", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;", "setGoogleFitManager", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;)V", "h1Client", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "getH1Client", "()Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "setH1Client", "(Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;)V", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "isUseSdkStepPerMinutes", "setUseSdkStepPerMinutes", "pointManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLPointManager;", "getPointManager", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLPointManager;", "setPointManager", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLPointManager;)V", "activityLog", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivity;", "date", "Ljava/util/Date;", "addAdjustTrackPointsToActivities", "activities", "addTagToActivities", "angle", "", "a", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "b", "c", "bestTrackPointFrom", "points", "", "calcStepRange", "stepData", "currentI", "currentS", "calcTrackPointRange", "tpData", "currentTp", "calculationPoint", "", "previousUpdate", "(Ljava/util/Date;Ljava/lang/Integer;)V", "center", "activity", "checkTrackPointsWithRFLActivities", "compressActivity", "list", "createActivitiesFromStep", "steplist", "createLocalDailyFromActivities", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "createWithLocal", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader$UpdateDaily;", "createWithServer", "server", "fillTrackPointsToActivities", "trackPoints", "filterByCompress", "filterCompressByDetail", "filterFirst", "filterGPSJump", "filterOneTrackPointStayActivity", "filterStay", "getCalcRangeStepList", "getCalcRangeTpList", "injectTagFromServerToLocal", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSegment;", "local", "loadDaily", "Lio/reactivex/Single;", "loadPredictionDaily", "logA", "l", "m", "", "logAS", "logLocation", "logLocationForDebug", "makeDailyStringFromDaily", "daily", "mergeString", "array", "mergeWithServer", "localActivityLog", "omitTrackerBy", "tracker", "omitTrackerByContinuous", "omitTrackerInActivity", "postDaily", "(Ljava/util/Date;Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;Ljava/lang/Integer;)V", "postDailyString", "postDailyWithGoogleFitStepCount", "targetDaily", "refreshDailyNote", "serverDaily", "refreshDailyTag", "removeChange", "removeLocalSegmentsFromServer", "Ljava/util/HashMap;", "serverDataId", "serverDataCounts", "localDataId", "replaceSegmentsFromServerToLocal", "serverSegments", "localSegments", "shouldCreateNew", "serverLast", "localLog", "sortTimestampAndConflictRemoveList", "", "aList", "stepPerMinutes", "stepPerMinutesA", "stepPerMinutesByGoogleFit", "limitNow", "updateWeather", "RFLTrackPointMap", "UpdateDaily", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader */
public final class RFLDailyLoader {

    /* renamed from: a */
    private boolean f3069a = true;

    /* renamed from: b */
    private boolean f3070b;
    public RFLDailyUtils dailyUtils;
    public RFLDataLogger dataLogger;
    public C1126c eventBus;
    public RFLGoogleFitManager googleFitManager;
    public RFLH1Client h1Client;
    public RFLPointManager pointManager;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader$RFLTrackPointMap;", "", "distance", "", "location", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "(ILjp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;)V", "getDistance", "()I", "getLocation", "()Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$RFLTrackPointMap */
    public static final class RFLTrackPointMap {

        /* renamed from: a */
        private final int f3071a;

        /* renamed from: b */
        private final RFLTrackPoint f3072b;

        public RFLTrackPointMap(int i, RFLTrackPoint rFLTrackPoint) {
            Intrinsics.checkParameterIsNotNull(rFLTrackPoint, FirebaseAnalytics.Param.LOCATION);
            this.f3071a = i;
            this.f3072b = rFLTrackPoint;
        }

        public static /* synthetic */ RFLTrackPointMap copy$default(RFLTrackPointMap rFLTrackPointMap, int i, RFLTrackPoint rFLTrackPoint, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = rFLTrackPointMap.f3071a;
            }
            if ((i2 & 2) != 0) {
                rFLTrackPoint = rFLTrackPointMap.f3072b;
            }
            return rFLTrackPointMap.copy(i, rFLTrackPoint);
        }

        public final int component1() {
            return this.f3071a;
        }

        public final RFLTrackPoint component2() {
            return this.f3072b;
        }

        public final RFLTrackPointMap copy(int i, RFLTrackPoint rFLTrackPoint) {
            Intrinsics.checkParameterIsNotNull(rFLTrackPoint, FirebaseAnalytics.Param.LOCATION);
            return new RFLTrackPointMap(i, rFLTrackPoint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RFLTrackPointMap)) {
                return false;
            }
            RFLTrackPointMap rFLTrackPointMap = (RFLTrackPointMap) obj;
            return this.f3071a == rFLTrackPointMap.f3071a && Intrinsics.areEqual((Object) this.f3072b, (Object) rFLTrackPointMap.f3072b);
        }

        public final int getDistance() {
            return this.f3071a;
        }

        public final RFLTrackPoint getLocation() {
            return this.f3072b;
        }

        public int hashCode() {
            int i = this.f3071a * 31;
            RFLTrackPoint rFLTrackPoint = this.f3072b;
            return i + (rFLTrackPoint != null ? rFLTrackPoint.hashCode() : 0);
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("RFLTrackPointMap(distance=");
            a.append(this.f3071a);
            a.append(", location=");
            a.append(this.f3072b);
            a.append(")");
            return a.toString();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader$UpdateDaily;", "", "daily", "", "hasData", "", "(Ljava/lang/String;Z)V", "getDaily", "()Ljava/lang/String;", "getHasData", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$UpdateDaily */
    public static final class UpdateDaily {

        /* renamed from: a */
        private final String f3073a;

        /* renamed from: b */
        private final boolean f3074b;

        public UpdateDaily(String str, boolean z) {
            Intrinsics.checkParameterIsNotNull(str, "daily");
            this.f3073a = str;
            this.f3074b = z;
        }

        public static /* synthetic */ UpdateDaily copy$default(UpdateDaily updateDaily, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateDaily.f3073a;
            }
            if ((i & 2) != 0) {
                z = updateDaily.f3074b;
            }
            return updateDaily.copy(str, z);
        }

        public final String component1() {
            return this.f3073a;
        }

        public final boolean component2() {
            return this.f3074b;
        }

        public final UpdateDaily copy(String str, boolean z) {
            Intrinsics.checkParameterIsNotNull(str, "daily");
            return new UpdateDaily(str, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateDaily)) {
                return false;
            }
            UpdateDaily updateDaily = (UpdateDaily) obj;
            return Intrinsics.areEqual((Object) this.f3073a, (Object) updateDaily.f3073a) && this.f3074b == updateDaily.f3074b;
        }

        public final String getDaily() {
            return this.f3073a;
        }

        public final boolean getHasData() {
            return this.f3074b;
        }

        public int hashCode() {
            String str = this.f3073a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.f3074b;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("UpdateDaily(daily=");
            a.append(this.f3073a);
            a.append(", hasData=");
            a.append(this.f3074b);
            a.append(")");
            return a.toString();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$a */
    static final class C2140a implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLDailyLoader f3075a;

        /* renamed from: b */
        final /* synthetic */ Date f3076b;

        /* renamed from: c */
        final /* synthetic */ Integer f3077c;

        C2140a(RFLDailyLoader rFLDailyLoader, Date date, Integer num) {
            this.f3075a = rFLDailyLoader;
            this.f3076b = date;
            this.f3077c = num;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "emitter");
            this.f3075a.getPointManager().calculation(this.f3076b, this.f3077c, this.f3075a.m3683a((List<Integer>) this.f3075a.m3706c(this.f3076b), this.f3076b));
            cVar.onComplete();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader$UpdateDaily;", "kotlin.jvm.PlatformType", "t", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$b */
    static final class C2141b<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyLoader f3078a;

        /* renamed from: b */
        final /* synthetic */ Date f3079b;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$b$a */
        static final class C2142a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2141b f3080a;

            /* renamed from: b */
            final /* synthetic */ RFLH1Client.APIResponse f3081b;

            C2142a(C2141b bVar, RFLH1Client.APIResponse aPIResponse) {
                this.f3080a = bVar;
                this.f3081b = aPIResponse;
            }

            public final UpdateDaily call() {
                C2141b bVar = this.f3080a;
                List access$activityLog = bVar.f3078a.m3680a(bVar.f3079b);
                if (this.f3081b.getCode() == 200) {
                    Object data = this.f3081b.getData();
                    if (data != null) {
                        RFLDaily rFLDaily = (RFLDaily) data;
                        if (!rFLDaily.getSegments().isEmpty()) {
                            Integer updateTimeApp = rFLDaily.getUpdateTimeApp();
                            if (this.f3080a.f3078a.m3694a(updateTimeApp != null ? updateTimeApp.intValue() : 0, (List<RFLActivity>) access$activityLog)) {
                                StringBuilder a = C0681a.m330a("[SilentLogSDK]::Debug loadDaily mergeWithServer ");
                                a.append(rFLDaily.getDate());
                                C1122a.m1596a(a.toString(), new Object[0]);
                                C2141b bVar2 = this.f3080a;
                                return bVar2.f3078a.m3686a(bVar2.f3079b, (List<RFLActivity>) access$activityLog, rFLDaily);
                            }
                            StringBuilder a2 = C0681a.m330a("[SilentLogSDK]::Debug loadDaily createWithServer ");
                            a2.append(rFLDaily.getDate());
                            C1122a.m1596a(a2.toString(), new Object[0]);
                            C2141b bVar3 = this.f3080a;
                            return bVar3.f3078a.m3687a(bVar3.f3079b, rFLDaily);
                        }
                        StringBuilder a3 = C0681a.m330a("[SilentLogSDK]::Debug loadDaily createWithLocal ");
                        a3.append(rFLDaily.getDate());
                        C1122a.m1596a(a3.toString(), new Object[0]);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily");
                    }
                } else {
                    StringBuilder a4 = C0681a.m330a("[SilentLogSDK]::Debug loadDaily createWithLocal ");
                    a4.append(RFLDailyUtilsKt.format$default(this.f3080a.f3079b, "yyyyMMdd'T'HHmmssZ", (String) null, 2, (Object) null));
                    a4.append(" code=");
                    a4.append(this.f3081b.getCode());
                    C1122a.m1596a(a4.toString(), new Object[0]);
                }
                C2141b bVar4 = this.f3080a;
                return bVar4.f3078a.m3702b(bVar4.f3079b, (List<RFLActivity>) access$activityLog);
            }
        }

        C2141b(RFLDailyLoader rFLDailyLoader, Date date) {
            this.f3078a = rFLDailyLoader;
            this.f3079b = date;
        }

        /* renamed from: a */
        public final C1714r<UpdateDaily> apply(RFLH1Client.APIResponse aPIResponse) {
            Intrinsics.checkParameterIsNotNull(aPIResponse, "t");
            return C1714r.m2413a(new C2142a(this, aPIResponse));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader$UpdateDaily;", "kotlin.jvm.PlatformType", "t", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$c */
    static final class C2143c<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyLoader f3082a;

        /* renamed from: b */
        final /* synthetic */ Date f3083b;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$c$a */
        static final class C2144a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2143c f3084a;

            /* renamed from: b */
            final /* synthetic */ RFLH1Client.APIResponse f3085b;

            C2144a(C2143c cVar, RFLH1Client.APIResponse aPIResponse) {
                this.f3084a = cVar;
                this.f3085b = aPIResponse;
            }

            public final UpdateDaily call() {
                String str;
                if (this.f3085b.getCode() == 200) {
                    Object data = this.f3085b.getData();
                    if (data != null) {
                        RFLDaily rFLDaily = (RFLDaily) data;
                        if (rFLDaily.getUpdateTimeServer() != null) {
                            C2143c cVar = this.f3084a;
                            str = cVar.f3082a.m3697b(cVar.f3083b, rFLDaily);
                            return new UpdateDaily(str, !Intrinsics.areEqual((Object) str, (Object) ""));
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily");
                    }
                }
                str = "";
                return new UpdateDaily(str, !Intrinsics.areEqual((Object) str, (Object) ""));
            }
        }

        C2143c(RFLDailyLoader rFLDailyLoader, Date date) {
            this.f3082a = rFLDailyLoader;
            this.f3083b = date;
        }

        /* renamed from: a */
        public final C1714r<UpdateDaily> apply(RFLH1Client.APIResponse aPIResponse) {
            Intrinsics.checkParameterIsNotNull(aPIResponse, "t");
            return C1714r.m2413a(new C2144a(this, aPIResponse));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$d */
    static final class C2145d<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyLoader f3086a;

        /* renamed from: b */
        final /* synthetic */ Date f3087b;

        /* renamed from: c */
        final /* synthetic */ Integer f3088c;

        C2145d(RFLDailyLoader rFLDailyLoader, Date date, Integer num) {
            this.f3086a = rFLDailyLoader;
            this.f3087b = date;
            this.f3088c = num;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            if (aPIResponse.getCode() == 200) {
                C1122a.m1600c("[SilentLogSDK] Info::Upload Daily end... Successfully", new Object[0]);
                RFLSharedHolder.INSTANCE.setLoadTime(System.currentTimeMillis());
                this.f3086a.m3690a(this.f3087b, this.f3088c);
                return;
            }
            C1122a.m1599b("[SilentLogSDK] Error::Upload Daily end... code:%s", Integer.valueOf(aPIResponse.getCode()));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$e */
    static final class C2146e<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C2146e f3089a = new C2146e();

        C2146e() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            Intrinsics.checkExpressionValueIsNotNull(th, "it");
            C1122a.m1599b("[SilentLogSDK] Error::Upload Daily end... message:%s", th.getLocalizedMessage());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$f */
    static final class C2147f extends Lambda implements Function3<Boolean, Date, Integer, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyLoader f3090a;

        /* renamed from: b */
        final /* synthetic */ RFLDaily f3091b;

        /* renamed from: c */
        final /* synthetic */ Date f3092c;

        /* renamed from: d */
        final /* synthetic */ Integer f3093d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2147f(RFLDailyLoader rFLDailyLoader, RFLDaily rFLDaily, Date date, Integer num) {
            super(3);
            this.f3090a = rFLDailyLoader;
            this.f3091b = rFLDaily;
            this.f3092c = date;
            this.f3093d = num;
        }

        /* renamed from: a */
        public final void mo31267a(boolean z, Date date, int i) {
            Object obj;
            int i2;
            RFLWeather rFLWeather;
            List list;
            RFLSummary rFLSummary;
            Integer num;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Integer num2;
            List list2;
            List list3;
            Integer num3;
            Integer num4;
            String str6;
            String str7;
            String str8;
            List list4;
            int i3;
            String str9;
            String str10;
            Intrinsics.checkParameterIsNotNull(date, "<anonymous parameter 1>");
            RFLDailyLoader rFLDailyLoader = this.f3090a;
            String str11 = rFLDailyLoader.isUseSdkStepPerMinutes() ? null : "google_fit";
            RFLDaily rFLDaily = this.f3091b;
            if (z) {
                num2 = Integer.valueOf(i);
                str10 = null;
                str9 = null;
                i3 = 0;
                list4 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                num4 = null;
                num3 = null;
                list3 = null;
                list2 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
                num = null;
                rFLSummary = null;
                list = null;
                rFLWeather = null;
                i2 = 4179967;
                obj = null;
                str5 = "GoogleFit";
            } else {
                str10 = null;
                str9 = null;
                i3 = 0;
                list4 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                num4 = null;
                num3 = null;
                list3 = null;
                list2 = null;
                num2 = null;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
                num = null;
                rFLSummary = null;
                list = null;
                rFLWeather = null;
                i2 = 4186111;
                obj = null;
            }
            rFLDailyLoader.m3691a(this.f3092c, RFLDaily.copy$default(rFLDaily, str10, str9, i3, list4, str8, str7, str6, num4, num3, list3, list2, num2, str5, str11, str4, str3, str2, str, num, rFLSummary, list, rFLWeather, i2, obj), this.f3093d);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            mo31267a(((Boolean) obj).booleanValue(), (Date) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }
    }

    public RFLDailyLoader() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final HashMap<String, Object> m3679a(List<RFLSegment> list, String str, String str2, List<RFLSegment> list2, String str3) {
        List<RFLSegment> list3 = list2;
        String str4 = str3;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
        List split$default2 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{","}, false, 0, 6, (Object) null);
        int size = split$default.size();
        for (int i = 0; i < size; i++) {
            List split$default3 = StringsKt__StringsKt.split$default((CharSequence) split$default2.get(i), new String[]{"-"}, false, 0, 6, (Object) null);
            int parseInt = Integer.parseInt((String) CollectionsKt___CollectionsKt.first(split$default3));
            int parseInt2 = Integer.parseInt((String) CollectionsKt___CollectionsKt.last(split$default3));
            List<RFLSegment> list4 = list;
            if (parseInt <= parseInt2) {
                hashMap.put((String) split$default.get(i), list4.subList(parseInt, parseInt2));
            }
        }
        List list5 = (List) hashMap.get(str4);
        if (list5 != null) {
            Intrinsics.checkExpressionValueIsNotNull(list5, "tempServerSegments");
            list3 = m3712d(list5, list3);
        }
        hashMap.put(str4, list3);
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        if (arrayList2.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, new RFLDailyLoader$removeLocalSegmentsFromServer$$inlined$sortBy$1());
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size2; i3++) {
            List list6 = (List) hashMap.get((String) arrayList2.get(i3));
            if (list6 == null) {
                Intrinsics.throwNpe();
            }
            int size3 = list6.size();
            arrayList.addAll(list6);
            String format = String.format("%s-%s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(size3)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
            arrayList3.add(format);
            i2 += size3;
        }
        String k = m3719k(arrayList2);
        String k2 = m3719k(arrayList3);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("ids", k);
        hashMap2.put("counts", k2);
        hashMap2.put("segs", arrayList);
        return hashMap2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final List<RFLActivity> m3680a(Date date) {
        Date date2 = date;
        RFLTrackPoint rFLTrackPoint = null;
        String format$default = RFLDailyUtilsKt.format$default(date2, "yyyy-MM-dd", (String) null, 2, (Object) null);
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        List<List<RFLTrackPoint>> findLocations = rFLDataLogger.findLocations(format$default);
        ArrayList arrayList = new ArrayList();
        for (List<RFLTrackPoint> addAll : findLocations) {
            arrayList.addAll(addAll);
        }
        if (arrayList.isEmpty()) {
            C1122a.m1599b("[SilentLogSDK] Error::activityLog:: Location is Empty", new Object[0]);
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<RFLTrackPoint> n = m3722n((List) CollectionsKt___CollectionsKt.first(findLocations));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(n);
        String format$default2 = RFLDailyUtilsKt.format$default(RFLDailyUtilsKt.yesterday(date), "yyyy-MM-dd", (String) null, 2, (Object) null);
        RFLDataLogger rFLDataLogger2 = this.dataLogger;
        if (rFLDataLogger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        List<List<RFLTrackPoint>> findLocations2 = rFLDataLogger2.findLocations(format$default2);
        RFLDataLogger rFLDataLogger3 = this.dataLogger;
        if (rFLDataLogger3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        RFLTrackPoint findTP = rFLDataLogger3.findTP(format$default2);
        int time = (int) (RFLDailyUtilsKt.start(date).getTime() / 1000);
        if (!findLocations2.isEmpty()) {
            RFLTrackPoint rFLTrackPoint2 = (RFLTrackPoint) CollectionsKt___CollectionsKt.last((List) CollectionsKt___CollectionsKt.first(findLocations2));
            if (findTP != null) {
                rFLTrackPoint = findTP.getTimestamp() - rFLTrackPoint2.getTimestamp() > 0 ? new RFLTrackPoint(findTP.getTimezone(), findTP.getLatitude(), findTP.getLongitude(), 0.0f, time) : new RFLTrackPoint(rFLTrackPoint2.getTimezone(), rFLTrackPoint2.getLatitude(), rFLTrackPoint2.getLongitude(), 0.0f, time);
            }
        } else if (findTP != null) {
            rFLTrackPoint = new RFLTrackPoint(findTP.getTimezone(), findTP.getLatitude(), findTP.getLongitude(), 0.0f, time);
        }
        if (rFLTrackPoint != null) {
            arrayList2.add(0, rFLTrackPoint);
        }
        List<Integer> c = m3706c(date);
        return m3684a(m3701b((List<RFLTrackPoint>) arrayList2, m3683a(c, date2)), c);
    }

    /* renamed from: a */
    private final List<Integer> m3681a(Date date, boolean z) {
        Date start = RFLDailyUtilsKt.start(date);
        Date start2 = RFLDailyUtilsKt.start(RFLDailyUtilsKt.tomorrow(start));
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        if (rFLH1Client.getStaging()) {
            C1122a.m1596a("stepPerMinutesByGoogleFit from:" + start + " to:" + start2, new Object[0]);
        }
        RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
        if (rFLGoogleFitManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
        }
        Map<Long, Integer> minuteRangeStepCount = rFLGoogleFitManager.getMinuteRangeStepCount(start, start2);
        long time = new Date().getTime();
        long time2 = start.getTime();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 1439; i++) {
            long j = (((long) i) * 60000) + time2;
            if (z && time <= j) {
                break;
            }
            Integer num = minuteRangeStepCount.get(Long.valueOf(j));
            arrayList.add(Integer.valueOf(num != null ? num.intValue() : 0));
            RFLH1Client rFLH1Client2 = this.h1Client;
            if (rFLH1Client2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("h1Client");
            }
            if (rFLH1Client2.getStaging()) {
                StringBuilder a = C0681a.m330a("stepPerMinutesByGoogleFit ");
                Integer num2 = minuteRangeStepCount.get(Long.valueOf(j));
                a.append(num2 != null ? num2.intValue() : 0);
                a.append(" from:");
                a.append(new Date(j));
                C1122a.m1596a(a.toString(), new Object[0]);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private final List<RFLActivity> m3682a(List<RFLActivity> list) {
        for (RFLActivity next : list) {
            RFLDataLogger rFLDataLogger = this.dataLogger;
            if (rFLDataLogger == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
            }
            List<RFLTrackPoint> findAdjustTrackPoints = rFLDataLogger.findAdjustTrackPoints(next.getFromDate(), next.getToDate());
            if (!findAdjustTrackPoints.isEmpty()) {
                next.setAdjustTrackPoints(findAdjustTrackPoints);
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final List<RFLActivity> m3683a(List<Integer> list, Date date) {
        String str;
        int i;
        String str2;
        long time = RFLDailyUtilsKt.start(date).getTime();
        ArrayList arrayList = new ArrayList();
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
        String id = timeZone.getID();
        Iterator<T> it = list.iterator();
        int i2 = 0;
        while (true) {
            str = "timezone";
            if (!it.hasNext()) {
                break;
            }
            int intValue = ((Number) it.next()).intValue();
            long j = (((long) i2) * 60000) + time;
            long j2 = (long) 1000;
            int i3 = (int) (j / j2);
            int i4 = (int) ((60000 + j) / j2);
            RFL_ACTIVITY_TYPE rfl_activity_type = RFL_ACTIVITY_TYPE.STAY;
            if (m3695a(list, i2, intValue)) {
                rfl_activity_type = RFL_ACTIVITY_TYPE.WALK;
            }
            Intrinsics.checkExpressionValueIsNotNull(id, str);
            arrayList.add(new RFLActivity(id, i3, i4, intValue, 0.0f, CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), RFLDailyUtilsKt.string(rfl_activity_type), ProductAction.ACTION_DETAIL, "sensor", 0, 0.0f));
            i2++;
        }
        List<RFLActivity> c = m3707c((List<RFLActivity>) arrayList);
        int size = c.size() - 1;
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        for (RFLActivity rFLActivity : c) {
            if (!(i5 == 0 || i5 == size || rFLActivity.type() != RFL_ACTIVITY_TYPE.STAY)) {
                RFLActivity rFLActivity2 = c.get(i5 - 1);
                int stepPerAct = rFLActivity2.stepPerAct();
                int stepPerAct2 = rFLActivity.stepPerAct();
                if (rFLActivity.count() < 5 && stepPerAct2 > 10 && stepPerAct - stepPerAct2 < 40) {
                    rFLActivity.setType(rFLActivity2.type());
                    arrayList2.add(rFLActivity);
                    RFL_ACTIVITY_TYPE rfl_activity_type2 = RFL_ACTIVITY_TYPE.CHANGE;
                    Intrinsics.checkExpressionValueIsNotNull(id, str);
                    RFLActivity rFLActivity3 = r6;
                    str2 = str;
                    i = i5;
                    RFLActivity rFLActivity4 = new RFLActivity(id, 0, 0, 0, 0.0f, CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), RFLDailyUtilsKt.string(rfl_activity_type2), "", "", 0, 0.0f);
                    rFLActivity = rFLActivity3;
                    arrayList2.add(rFLActivity);
                    i5 = i + 1;
                    str = str2;
                }
            }
            str2 = str;
            i = i5;
            arrayList2.add(rFLActivity);
            i5 = i + 1;
            str = str2;
        }
        return m3707c((List<RFLActivity>) arrayList2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0093, code lost:
        if (r6 > r9) goto L_0x009b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity> m3684a(java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity> r33, java.util.List<java.lang.Integer> r34) {
        /*
            r32 = this;
            r0 = r32
            boolean r1 = r33.isEmpty()
            if (r1 == 0) goto L_0x000d
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            return r1
        L_0x000d:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.first(r33)
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity r2 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity) r2
            int r2 = r2.getFromDate()
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.first(r33)
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity) r3
            java.lang.String r3 = r3.getTimezone()
            java.util.Iterator r18 = r33.iterator()
        L_0x002a:
            boolean r4 = r18.hasNext()
            if (r4 == 0) goto L_0x016f
            java.lang.Object r4 = r18.next()
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity r4 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity) r4
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r5 = r4.type()
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r6 = p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE.STAY
            if (r5 != r6) goto L_0x0166
            java.util.List r15 = r4.getTrackPoints()
            int r5 = r15.size()
            int r5 = r5 + -1
            int r19 = r4.getFromDate()
            int r6 = r19 - r2
            int r20 = r6 / 60
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            int r4 = r4.count()
            int r4 = r4 + -1
            if (r4 < 0) goto L_0x00c8
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0065:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            int r11 = r19 + r8
            int r12 = r19 + 1
            if (r7 > r5) goto L_0x00ac
            r6 = r9
            r9 = r7
        L_0x0072:
            java.lang.Object r16 = r15.get(r7)
            r21 = r2
            r2 = r16
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint r2 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint) r2
            r16 = r13
            jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils r13 = r0.dailyUtils
            if (r13 != 0) goto L_0x0087
            java.lang.String r17 = "dailyUtils"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r17)
        L_0x0087:
            r17 = r15
            int r15 = r2.getTimestamp()
            int r13 = r13.isTimeBetweenBandC(r11, r15, r12)
            if (r13 >= 0) goto L_0x0096
            if (r6 <= r9) goto L_0x009c
            goto L_0x009b
        L_0x0096:
            if (r13 != 0) goto L_0x00a9
            r10.add(r2)
        L_0x009b:
            r6 = r9
        L_0x009c:
            int r9 = r9 + 1
            if (r7 == r5) goto L_0x00a9
            int r7 = r7 + 1
            r13 = r16
            r15 = r17
            r2 = r21
            goto L_0x0072
        L_0x00a9:
            r7 = r9
            r9 = r6
            goto L_0x00b2
        L_0x00ac:
            r21 = r2
            r16 = r13
            r17 = r15
        L_0x00b2:
            int r2 = r10.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r14.add(r2)
            if (r8 == r4) goto L_0x00ce
            int r8 = r8 + 1
            r13 = r16
            r15 = r17
            r2 = r21
            goto L_0x0065
        L_0x00c8:
            r21 = r2
            r16 = r13
            r17 = r15
        L_0x00ce:
            int r2 = r14.size()
            int r2 = r2 + -1
            if (r2 < 0) goto L_0x014e
            r15 = 0
        L_0x00d7:
            java.lang.Object r4 = r14.get(r15)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            int r5 = r15 * 60
            int r6 = r5 + r19
            int r7 = r6 + 60
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r5 = p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE.STAY
            boolean r4 = r0.m3705b((java.util.List<java.lang.Integer>) r14, (int) r15, (int) r4)
            if (r4 == 0) goto L_0x00f2
            java.lang.String r4 = "auto"
            goto L_0x00f4
        L_0x00f2:
            java.lang.String r4 = "sty"
        L_0x00f4:
            r22 = r4
            int r4 = r20 + r15
            r13 = r34
            java.lang.Object r4 = r13.get(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r8 = r4.intValue()
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.List r11 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.lang.String r23 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.string((p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE) r5)
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity r9 = new jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity
            r24 = 0
            r25 = 0
            r26 = 0
            java.lang.String r27 = "sensor"
            r4 = r9
            r5 = r3
            r28 = r3
            r3 = r9
            r9 = r24
            r29 = r16
            r13 = r23
            r23 = r14
            r14 = r22
            r31 = r15
            r30 = r17
            r15 = r27
            r16 = r25
            r17 = r26
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r4 = r29
            r4.add(r3)
            r3 = r31
            if (r3 == r2) goto L_0x0154
            int r15 = r3 + 1
            r16 = r4
            r14 = r23
            r3 = r28
            r17 = r30
            goto L_0x00d7
        L_0x014e:
            r28 = r3
            r4 = r16
            r30 = r17
        L_0x0154:
            java.util.List r2 = r0.m3713e(r4)
            r3 = r30
            r0.m3701b((java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint>) r3, (java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity>) r2)
            r1.addAll(r2)
            r2 = r21
            r3 = r28
            goto L_0x002a
        L_0x0166:
            r21 = r2
            r28 = r3
            r1.add(r4)
            goto L_0x002a
        L_0x016f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader.m3684a(java.util.List, java.util.List):java.util.List");
    }

    /* renamed from: a */
    static /* synthetic */ List m3685a(RFLDailyLoader rFLDailyLoader, Date date, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return rFLDailyLoader.m3681a(date, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final UpdateDaily m3686a(Date date, List<RFLActivity> list, RFLDaily rFLDaily) {
        Integer num;
        Date date2 = date;
        RFLDaily rFLDaily2 = rFLDaily;
        RFLDaily a = m3688a(date, list);
        if (a != null) {
            List<RFLSegment> segments = rFLDaily.getSegments();
            List<RFLSegment> segments2 = a.getSegments();
            String dataCounts = rFLDaily.getDataCounts();
            String dataId = rFLDaily.getDataId();
            String dataId2 = a.getDataId();
            if (dataId2 == null) {
                Intrinsics.throwNpe();
            }
            Integer updateTimeServer = rFLDaily.getUpdateTimeServer();
            Integer updateTimeApp = rFLDaily.getUpdateTimeApp();
            if (dataCounts == null || dataId == null) {
                num = updateTimeApp;
            } else {
                num = updateTimeApp;
                C1122a.m1596a("merge Daily server:%s local:%s", dataId, dataId2);
                if (Intrinsics.areEqual((Object) dataId, (Object) dataId2)) {
                    List<RFLSegment> d = m3712d(segments, segments2);
                    m3709c(segments, d);
                    a.setSegment(d);
                } else {
                    HashMap<String, Object> a2 = m3679a(segments, dataId, dataCounts, segments2, dataId2);
                    Object obj = a2.get("segs");
                    if (obj != null) {
                        List list2 = (List) obj;
                        Object obj2 = a2.get("ids");
                        if (obj2 != null) {
                            String str = (String) obj2;
                            Object obj3 = a2.get("counts");
                            if (obj3 != null) {
                                a.setSegment(list2);
                                a.setDataCounts((String) obj3);
                                a.setDataId(str);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSegment>");
                    }
                }
            }
            a.setUpdateTimeServer(updateTimeServer);
            m3704b(date2, a, rFLDaily2);
            m3692a(date2, a, rFLDaily2);
            m3710c(date2, a, rFLDaily2);
            String b = m3697b(date2, a);
            boolean z = !Intrinsics.areEqual((Object) b, (Object) "");
            if (z) {
                String format$default = RFLDailyUtilsKt.format$default(date2, "yyyy-MM-dd", (String) null, 2, (Object) null);
                RFLDataLogger rFLDataLogger = this.dataLogger;
                if (rFLDataLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
                }
                rFLDataLogger.insertDaily(a, format$default).mo27431a();
                C1126c cVar = this.eventBus;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventBus");
                }
                cVar.mo21903a((Object) new PostDaily(date2, num));
            }
            return new UpdateDaily(b, z);
        }
        C1122a.m1599b("[SilentLogSDK] Error:: Local Daily is Null ", new Object[0]);
        m3704b(date2, rFLDaily2, rFLDaily2);
        m3692a(date2, rFLDaily2, rFLDaily2);
        m3710c(date2, rFLDaily2, rFLDaily2);
        String b2 = m3697b(date2, rFLDaily2);
        boolean z2 = !Intrinsics.areEqual((Object) b2, (Object) "");
        if (z2) {
            String format$default2 = RFLDailyUtilsKt.format$default(date2, "yyyy-MM-dd", (String) null, 2, (Object) null);
            RFLDataLogger rFLDataLogger2 = this.dataLogger;
            if (rFLDataLogger2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
            }
            rFLDataLogger2.insertDaily(rFLDaily2, format$default2).mo27431a();
        }
        return new UpdateDaily(b2, z2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final UpdateDaily m3687a(Date date, RFLDaily rFLDaily) {
        m3704b(date, rFLDaily, rFLDaily);
        m3692a(date, rFLDaily, rFLDaily);
        m3710c(date, rFLDaily, rFLDaily);
        String json = new Gson().toJson((Object) rFLDaily);
        if (json == null) {
            json = "";
        }
        boolean z = !Intrinsics.areEqual((Object) json, (Object) "");
        if (z) {
            String format$default = RFLDailyUtilsKt.format$default(date, "yyyy-MM-dd", (String) null, 2, (Object) null);
            RFLDataLogger rFLDataLogger = this.dataLogger;
            if (rFLDataLogger == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
            }
            rFLDataLogger.insertDaily(rFLDaily, format$default).mo27431a();
            C1126c cVar = this.eventBus;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventBus");
            }
            cVar.mo21903a((Object) new PostDaily(date, rFLDaily.getUpdateTimeApp()));
        }
        return new UpdateDaily(json, z);
    }

    /* renamed from: a */
    private final RFLDaily m3688a(Date date, List<RFLActivity> list) {
        String format$default = RFLDailyUtilsKt.format$default(date, "yyyy-MM-dd", (String) null, 2, (Object) null);
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        List<List<RFLTrackPoint>> findLocations = rFLDataLogger.findLocations(format$default);
        ArrayList arrayList = new ArrayList();
        for (List<RFLTrackPoint> addAll : findLocations) {
            arrayList.addAll(addAll);
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new RFLDailyLoader$createLocalDailyFromActivities$$inlined$sortBy$1());
        }
        if (arrayList.isEmpty()) {
            C1122a.m1599b("[SilentLogSDK] Error::createDaily:: Location is Empty", new Object[0]);
            return null;
        }
        String valueOf = String.valueOf(((RFLTrackPoint) CollectionsKt___CollectionsKt.first(arrayList)).getTimestamp());
        List<RFLActivity> i = m3717i(m3711d(m3715g(m3711d(m3716h(m3711d(m3721m(m3714f(list))))))));
        m3693a(i, false, "CreateDaily:: After filterStay");
        List<RFLActivity> a = m3682a(m3699b(i));
        HashMap hashMap = new HashMap();
        for (RFLActivity timezone : a) {
            String timezone2 = timezone.getTimezone();
            if (((String) hashMap.get(timezone2)) == null) {
                hashMap.put(timezone2, "1");
            }
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        int size = arrayList2.size();
        String str = "";
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = (String) arrayList2.get(i2);
            if (i2 != 0) {
                str = C0681a.m320a(str, ",");
            }
            str = C0681a.m320a(str, str2);
        }
        Date start = RFLDailyUtilsKt.start(((RFLActivity) CollectionsKt___CollectionsKt.first(list)).startTime());
        String timezone3 = ((RFLActivity) CollectionsKt___CollectionsKt.first(list)).getTimezone();
        ArrayList arrayList3 = new ArrayList();
        for (RFLActivity activity : a) {
            RFLSegment rFLSegment = new RFLSegment(RFL_SEGMENT_TYPE.PLACE, "", 0, 0, 0, CollectionsKt__CollectionsKt.emptyList(), "", "place");
            rFLSegment.setActivity(activity);
            arrayList3.add(rFLSegment);
        }
        if (arrayList3.isEmpty()) {
            C1122a.m1599b("[SilentLogSDK] Error::createDaily:: Segments is Empty", new Object[0]);
            return null;
        }
        String str3 = Build.VERSION.RELEASE;
        String format = RFLDailyUtilsKt.format(start, "yyyyMMdd'T'HHmmssZ", timezone3);
        String clientId = RFLSharedHolder.INSTANCE.clientId();
        int time = (int) (new Date().getTime() / ((long) 1000));
        String a2 = C0681a.m328a(new Object[]{RFGDef.DEFAULT_GYM_ID, Integer.valueOf(arrayList3.size())}, 2, "%s-%s", "java.lang.String.format(this, *args)");
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.checkExpressionValueIsNotNull(str3, "os");
        RFLDaily rFLDaily = new RFLDaily(timezone3, format, 0, emptyList, str3, Build.MANUFACTURER + " " + Build.MODEL, clientId, Integer.valueOf(time), (Integer) null, (List) null, (List) null, (Integer) null, (String) null, (String) null, str, valueOf, a2, (String) null, (Integer) null, (RFLSummary) null, (List) null, (RFLWeather) null, 4079104, (DefaultConstructorMarker) null);
        rFLDaily.setSegment(arrayList3);
        return rFLDaily;
    }

    /* renamed from: a */
    private final RFLTrackPoint m3689a(List<RFLTrackPoint> list, int i) {
        RFLTrackPoint rFLTrackPoint = (RFLTrackPoint) CollectionsKt___CollectionsKt.first(list);
        boolean z = rFLTrackPoint.getTimestamp() < i;
        for (RFLTrackPoint next : list) {
            if (next.getTimestamp() >= i) {
                boolean z2 = next.getAccuracy() <= rFLTrackPoint.getAccuracy();
                if (z) {
                    z2 = next.getAccuracy() <= rFLTrackPoint.getAccuracy() * ((float) 10);
                }
                if (z2) {
                    if (next.getTimestamp() < i) {
                        rFLTrackPoint = next;
                        z = true;
                    } else {
                        rFLTrackPoint = next;
                        z = false;
                    }
                }
            }
        }
        return rFLTrackPoint;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m3690a(Date date, Integer num) {
        C1696b.m2386a((C1699e) new C2140a(this, date, num)).mo27420a(C1683a.m2378b()).mo27421a();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public final void m3691a(Date date, RFLDaily rFLDaily, Integer num) {
        String format = RFLDailyUtilsKt.format(RFLDailyUtilsKt.start(date), "yyyyMMdd", "GMT");
        C1122a.m1600c("[SilentLogSDK] Info::Upload Daily begin... gmt date:%s", format);
        String json = new Gson().toJson((Object) rFLDaily);
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        Intrinsics.checkExpressionValueIsNotNull(json, "dailyJson");
        rFLH1Client.postDaily(format, json).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C2145d(this, date, num), C2146e.f3089a);
    }

    /* renamed from: a */
    private final void m3692a(Date date, RFLDaily rFLDaily, RFLDaily rFLDaily2) {
        RFLSummary summary;
        RFLSummary rFLSummary = null;
        String format$default = RFLDailyUtilsKt.format$default(date, "yyyy-MM-dd", (String) null, 2, (Object) null);
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        RFLDaily findDaily = rFLDataLogger.findDaily(format$default);
        if (findDaily != null) {
            rFLSummary = findDaily.getSummary();
        }
        if (!(rFLDaily2 == null || (summary = rFLDaily2.getSummary()) == null)) {
            rFLSummary = summary;
        }
        rFLDaily.setSummary(rFLSummary);
    }

    /* renamed from: a */
    private final void m3693a(List<RFLActivity> list, boolean z, String str) {
        if (this.f3070b) {
            C1122a.m1600c("=====Log Activities :: %s =====", str);
            for (RFLActivity next : list) {
                if (next.type() != RFL_ACTIVITY_TYPE.CHANGE) {
                    C1122a.m1600c("from::%s-%s type:%s act:%s %s歩 %s歩/個 size:%s", RFLDailyUtilsKt.format$default(new Date(((long) next.getFromDate()) * 1000), "yyyy-MM-dd HH:mm", (String) null, 2, (Object) null), RFLDailyUtilsKt.format$default(new Date(((long) next.getToDate()) * 1000), "HH:mm", (String) null, 2, (Object) null), next.type(), next.getActivity(), Integer.valueOf(next.getSteps()), Integer.valueOf(next.stepPerAct()), Integer.valueOf(next.getTrackPoints().size()));
                    if (z) {
                        m3718j(next.getTrackPoints());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m3694a(int i, List<RFLActivity> list) {
        if (list.isEmpty()) {
            return false;
        }
        int toDate = ((RFLActivity) CollectionsKt___CollectionsKt.last(list)).getToDate();
        if (this.f3070b) {
            C1122a.m1600c("=====shouldCreateNew :: serverLast:%s, localLast:%s", Integer.valueOf(i), Integer.valueOf(toDate));
        }
        return i < toDate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m3695a(java.util.List<java.lang.Integer> r6, int r7, int r8) {
        /*
            r5 = this;
            java.util.List r6 = r5.m3700b((java.util.List<java.lang.Integer>) r6, (int) r7)
            java.util.Iterator r7 = r6.iterator()
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x000b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0021
            java.lang.Object r3 = r7.next()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            int r1 = r1 + r3
            if (r3 != 0) goto L_0x000b
            int r2 = r2 + 1
            goto L_0x000b
        L_0x0021:
            int r1 = r1 / 8
            r7 = 45
            r3 = 1
            r4 = 20
            if (r1 <= r7) goto L_0x006d
            r7 = 4
            if (r2 >= r7) goto L_0x0070
            if (r8 <= r1) goto L_0x0030
            return r3
        L_0x0030:
            r1 = 3
            java.lang.Object r2 = r6.get(r1)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r6 = r6.get(r7)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r2 >= r4) goto L_0x0049
            if (r6 < r4) goto L_0x0070
        L_0x0049:
            if (r2 >= r4) goto L_0x0052
            if (r6 <= r4) goto L_0x0052
            if (r6 <= r2) goto L_0x0070
            if (r8 <= r4) goto L_0x0070
            return r3
        L_0x0052:
            if (r2 <= r4) goto L_0x005b
            if (r6 >= r4) goto L_0x005b
            if (r2 <= r6) goto L_0x0070
            if (r8 <= r4) goto L_0x0070
            return r3
        L_0x005b:
            int r7 = r2 + r8
            int r7 = r7 + r6
            int r7 = r7 / r1
            int r7 = r7 - r8
            r1 = 40
            if (r7 <= r1) goto L_0x006c
            int r2 = r2 + r6
            int r2 = r2 / 2
            int r2 = r2 - r8
            r6 = 70
            if (r2 <= r6) goto L_0x0070
        L_0x006c:
            return r3
        L_0x006d:
            if (r8 <= r4) goto L_0x0070
            return r3
        L_0x0070:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader.m3695a(java.util.List, int, int):boolean");
    }

    /* renamed from: a */
    private final boolean m3696a(RFLActivity rFLActivity) {
        RFLTrackPoint rFLTrackPoint = null;
        for (RFLTrackPoint next : rFLActivity.getTrackPoints()) {
            if (next.getTimestamp() >= rFLActivity.getFromDate()) {
                if (rFLTrackPoint == null) {
                    rFLTrackPoint = next;
                } else {
                    RFLDailyUtils rFLDailyUtils = this.dailyUtils;
                    if (rFLDailyUtils == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                    }
                    if (rFLDailyUtils.distanceBetween(rFLTrackPoint, next) > ((float) 500)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final String m3697b(Date date, RFLDaily rFLDaily) {
        List<Integer> b = m3698b(date);
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        List<RFLBarometer> findBarometer = rFLDataLogger.findBarometer(date);
        RFLDataLogger rFLDataLogger2 = this.dataLogger;
        if (rFLDataLogger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        List<RFLWeatherListData> findCurrentWeather = rFLDataLogger2.findCurrentWeather(RFLDailyUtilsKt.second(date));
        rFLDaily.setBarometer(findBarometer);
        rFLDaily.setStepList(b);
        rFLDaily.setWeatherListData(findCurrentWeather);
        String json = new Gson().toJson((Object) rFLDaily);
        return json != null ? json : "";
    }

    /* renamed from: b */
    private final List<Integer> m3698b(Date date) {
        if (!this.f3069a) {
            RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
            if (rFLGoogleFitManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
            }
            if (rFLGoogleFitManager.isConnected()) {
                return m3685a(this, date, false, 2, (Object) null);
            }
        }
        long time = RFLDailyUtilsKt.start(date).getTime();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 1439; i++) {
            long j = (((long) i) * 60000) + time;
            long j2 = 60000 + j;
            RFLDataLogger rFLDataLogger = this.dataLogger;
            if (rFLDataLogger == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
            }
            arrayList.add(Integer.valueOf(rFLDataLogger.findStep(j, j2)));
        }
        return arrayList;
    }

    /* renamed from: b */
    private final List<RFLActivity> m3699b(List<RFLActivity> list) {
        for (RFLActivity next : list) {
            boolean z = next.type() != RFL_ACTIVITY_TYPE.STAY;
            RFLDataLogger rFLDataLogger = this.dataLogger;
            if (rFLDataLogger == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
            }
            List<RFLTag> findTag = rFLDataLogger.findTag(next.getFromDate(), next.getToDate(), z);
            if (findTag != null && (!findTag.isEmpty())) {
                List<T> unused = CollectionsKt___CollectionsKt.distinct(findTag);
                ArrayList arrayList = new ArrayList();
                for (RFLTag rFLTag : findTag) {
                    if (rFLTag.isPredictRemoveTag()) {
                        rFLTag = null;
                    }
                    if (rFLTag != null) {
                        arrayList.add(rFLTag);
                    }
                }
                next.setTagList(arrayList);
            }
        }
        return list;
    }

    /* renamed from: b */
    private final List<Integer> m3700b(List<Integer> list, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        int size = list.size() - 1;
        int i2 = i - 4;
        int i3 = 0;
        int i4 = 9;
        if (list.size() < 9) {
            i4 = list.size();
        } else {
            if (i == size) {
                i2 = i - 8;
                i = 8;
            } else if (i == size - 1) {
                i2 = i - 7;
                i = 7;
            } else if (i == size - 2) {
                i2 = i - 6;
                i = 6;
            } else if (i == size - 3) {
                i2 = i - 5;
                i = 5;
            } else if (i == 3 || i == 2 || i == 1 || i == 0) {
                i2 = 0;
            } else {
                i = 4;
            }
            i3 = i2 + 9 >= list.size() ? list.size() - 9 : i2;
        }
        List<Integer> subList = arrayList.subList(i3, i4 + i3);
        subList.remove(i);
        return subList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0050, code lost:
        if (r11 > r8) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        r7 = r8;
        r8 = r11;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity> m3701b(java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint> r17, java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity> r18) {
        /*
            r16 = this;
            r0 = r18
            java.util.List r1 = r16.m3720l(r17)
            int r2 = r1.size()
            r3 = 1
            int r2 = r2 - r3
            int r4 = r18.size()
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0013:
            if (r6 >= r4) goto L_0x00c0
            java.lang.Object r9 = r0.get(r6)
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity r9 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.Object r11 = r1.get(r8)
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint r11 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint) r11
            r10.add(r11)
            if (r7 > r2) goto L_0x007c
            r11 = r8
            r8 = r7
        L_0x002d:
            java.lang.Object r12 = r1.get(r7)
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint r12 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint) r12
            r13 = r16
            jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils r14 = r13.dailyUtils
            if (r14 != 0) goto L_0x003e
            java.lang.String r15 = "dailyUtils"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r15)
        L_0x003e:
            int r15 = r9.getFromDate()
            int r5 = r12.getTimestamp()
            int r3 = r9.getToDate()
            int r3 = r14.isTimeBetweenBandC(r15, r5, r3)
            if (r3 >= 0) goto L_0x0053
            if (r11 <= r8) goto L_0x005f
            goto L_0x005e
        L_0x0053:
            if (r3 != 0) goto L_0x0067
            boolean r3 = r10.contains(r12)
            if (r3 != 0) goto L_0x005e
            r10.add(r12)
        L_0x005e:
            r11 = r8
        L_0x005f:
            int r8 = r8 + 1
            if (r7 == r2) goto L_0x0079
            int r7 = r7 + 1
            r3 = 1
            goto L_0x002d
        L_0x0067:
            int r3 = r12.getTimestamp()
            int r5 = r9.getToDate()
            int r3 = r3 - r5
            r5 = 61
            if (r3 >= r5) goto L_0x0079
            r10.add(r12)
            r7 = r8
            goto L_0x007e
        L_0x0079:
            r7 = r8
            r8 = r11
            goto L_0x007e
        L_0x007c:
            r13 = r16
        L_0x007e:
            if (r6 == 0) goto L_0x00b6
            int r3 = r6 + -1
            java.lang.Object r3 = r0.get(r3)
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity) r3
            java.util.List r5 = r3.getTrackPoints()
            int r5 = r5.size()
            r11 = 1
            if (r5 != r11) goto L_0x00b4
            int r5 = r10.size()
            if (r5 <= r11) goto L_0x00b4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r12 = r3.getTrackPoints()
            r5.addAll(r12)
            java.lang.Object r12 = r10.get(r11)
            r5.add(r12)
            r3.setLocation(r5)
            r3 = 0
            r10.remove(r3)
            goto L_0x00b8
        L_0x00b4:
            r3 = 0
            goto L_0x00b8
        L_0x00b6:
            r3 = 0
            r11 = 1
        L_0x00b8:
            r9.setLocation(r10)
            int r6 = r6 + 1
            r3 = 1
            goto L_0x0013
        L_0x00c0:
            r13 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader.m3701b(java.util.List, java.util.List):java.util.List");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final UpdateDaily m3702b(Date date, List<RFLActivity> list) {
        RFLDaily a = m3688a(date, list);
        if (a != null) {
            m3704b(date, a, (RFLDaily) null);
            m3692a(date, a, (RFLDaily) null);
            m3710c(date, a, (RFLDaily) null);
            String b = m3697b(date, a);
            boolean z = !Intrinsics.areEqual((Object) b, (Object) "");
            if (z) {
                String format$default = RFLDailyUtilsKt.format$default(date, "yyyy-MM-dd", (String) null, 2, (Object) null);
                RFLDataLogger rFLDataLogger = this.dataLogger;
                if (rFLDataLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
                }
                rFLDataLogger.insertDaily(a, format$default).mo27431a();
                C1126c cVar = this.eventBus;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventBus");
                }
                cVar.mo21903a((Object) new PostDaily(date, (Integer) null));
            }
            return new UpdateDaily(b, z);
        }
        C1122a.m1599b("[SilentLogSDK] Error:: Local Daily is Null ", new Object[0]);
        return new UpdateDaily("", false);
    }

    /* renamed from: b */
    private final void m3703b(Date date, RFLDaily rFLDaily, Integer num) {
        RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
        if (rFLGoogleFitManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
        }
        rFLGoogleFitManager.getDailyStepCount(date, new C2147f(this, rFLDaily, date, num));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r9 = r9.getUpdateTimeTag();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m3704b(java.util.Date r7, p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily r8, p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily r9) {
        /*
            r6 = this;
            jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger r0 = r6.dataLogger
            java.lang.String r1 = "dataLogger"
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0009:
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag r0 = r0.findDailyTag(r7)
            java.lang.String r2 = ""
            if (r9 == 0) goto L_0x0018
            java.lang.String r3 = r9.getDailyTag()
            if (r3 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r3 = r2
        L_0x0019:
            r4 = 0
            if (r9 == 0) goto L_0x0027
            java.lang.Integer r9 = r9.getUpdateTimeTag()
            if (r9 == 0) goto L_0x0027
            int r9 = r9.intValue()
            goto L_0x0028
        L_0x0027:
            r9 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0031
            java.lang.String r5 = r0.getDailyTag()
            if (r5 == 0) goto L_0x0031
            r2 = r5
        L_0x0031:
            if (r0 == 0) goto L_0x0037
            int r4 = r0.getUpdateTime()
        L_0x0037:
            if (r9 == 0) goto L_0x008d
            if (r4 != 0) goto L_0x0054
            r8.setDailyTag(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            r8.setUpdateTimeTag(r0)
            jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger r8 = r6.dataLogger
            if (r8 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x004c:
            g.a.r r7 = r8.saveDailyTag(r7, r3, r9)
            r7.mo27431a()
            return
        L_0x0054:
            if (r4 <= r9) goto L_0x0061
            r8.setDailyTag(r2)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r8.setUpdateTimeTag(r7)
            return
        L_0x0061:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0082
            r8.setDailyTag(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            r8.setUpdateTimeTag(r0)
            jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger r8 = r6.dataLogger
            if (r8 != 0) goto L_0x007a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x007a:
            g.a.r r7 = r8.saveDailyTag(r7, r3, r9)
            r7.mo27431a()
            return
        L_0x0082:
            r8.setDailyTag(r2)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r8.setUpdateTimeTag(r7)
            return
        L_0x008d:
            if (r4 == 0) goto L_0x0099
            r8.setDailyTag(r2)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r8.setUpdateTimeTag(r7)
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader.m3704b(java.util.Date, jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily, jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily):void");
    }

    /* renamed from: b */
    private final boolean m3705b(List<Integer> list, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (Integer intValue : m3708c(list, i)) {
            int intValue2 = intValue.intValue();
            i3 += intValue2;
            if (intValue2 == 0) {
                i4++;
            }
        }
        if (i3 / 4 > 0) {
            if (i2 != 0 || i4 > 3) {
                return true;
            }
        } else if (i2 > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final List<Integer> m3706c(Date date) {
        if (!this.f3069a) {
            RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
            if (rFLGoogleFitManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
            }
            if (rFLGoogleFitManager.isConnected()) {
                return m3681a(date, true);
            }
        }
        long time = RFLDailyUtilsKt.start(date).getTime();
        long time2 = new Date().getTime();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 1439; i++) {
            long j = (((long) i) * 60000) + time;
            long j2 = 60000 + j;
            RFLDataLogger rFLDataLogger = this.dataLogger;
            if (rFLDataLogger == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
            }
            arrayList.add(Integer.valueOf(rFLDataLogger.findStep(j, j2)));
            if (time2 <= j2) {
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private final List<RFLActivity> m3707c(List<RFLActivity> list) {
        ArrayList arrayList = new ArrayList();
        RFLActivity rFLActivity = null;
        for (RFLActivity next : list) {
            if (rFLActivity != null && next.type() == rFLActivity.type()) {
                rFLActivity.mo32041to(((long) next.getToDate()) * 1000);
                rFLActivity.setSteps(next.getSteps() + rFLActivity.getSteps());
            } else {
                arrayList.add(next);
                rFLActivity = next;
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private final List<Integer> m3708c(List<Integer> list, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        int size = list.size() - 1;
        int i2 = i - 2;
        int i3 = 0;
        int i4 = 5;
        if (list.size() < 5) {
            i4 = list.size();
        } else {
            if (i == size) {
                i2 = i - 4;
                i = 4;
            } else if (i == size - 1) {
                i2 = i - 3;
                i = 3;
            } else if (i == 1 || i == 0) {
                i2 = 0;
            } else {
                i = 2;
            }
            i3 = i2 + 5 >= list.size() ? list.size() - 5 : i2;
        }
        List<Integer> subList = arrayList.subList(i3, i4 + i3);
        subList.remove(i);
        return subList;
    }

    /* renamed from: c */
    private final List<RFLSegment> m3709c(List<RFLSegment> list, List<RFLSegment> list2) {
        List<RFLSegment> list3 = list2;
        HashMap hashMap = new HashMap();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            RFLSegment rFLSegment = list.get(i);
            int size2 = rFLSegment.getActivities().size();
            for (int i2 = 0; i2 < size2; i2++) {
                List<RFLTag> tagList = rFLSegment.getActivities().get(i2).getTagList();
                if (tagList != null && (!tagList.isEmpty())) {
                    String format = String.format("%s:%s", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
                    hashMap.put(format, tagList);
                }
            }
        }
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            RFLSegment rFLSegment2 = list3.get(i3);
            int size4 = rFLSegment2.getActivities().size();
            for (int i4 = 0; i4 < size4; i4++) {
                RFLActivity rFLActivity = rFLSegment2.getActivities().get(i4);
                String a = C0681a.m328a(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2, "%s:%s", "java.lang.String.format(this, *args)");
                if (hashMap.get(a) != null) {
                    List list4 = (List) hashMap.get(a);
                    if (list4 == null) {
                        Intrinsics.throwNpe();
                    }
                    rFLActivity.setNewTagList(list4);
                }
            }
        }
        return list3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bb, code lost:
        if (r2 == null) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e9, code lost:
        if (r2 == null) goto L_0x00eb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m3710c(java.util.Date r18, p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily r19, p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = 0
            if (r20 == 0) goto L_0x000f
            jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r4 = r20.getWeather()
            r5 = r4
            goto L_0x0010
        L_0x000f:
            r5 = r3
        L_0x0010:
            jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger r4 = r0.dataLogger
            java.lang.String r14 = "dataLogger"
            if (r4 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
        L_0x0019:
            int r6 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.second(r18)
            jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r4 = r4.findForecastByDate(r6)
            java.lang.String r15 = "[SilentLogSDK]::Debug date="
            java.lang.StringBuilder r6 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r15)
            r7 = 2
            java.lang.String r13 = "yyyyMMdd"
            java.lang.String r8 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.format$default(r1, r13, r3, r7, r3)
            r6.append(r8)
            java.lang.String r8 = " serverWeather="
            r6.append(r8)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r8]
            p048l.p049a.C1122a.m1596a(r6, r9)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r15)
            java.lang.String r7 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.format$default(r1, r13, r3, r7, r3)
            r6.append(r7)
            java.lang.String r7 = " localWeather="
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r7 = new java.lang.Object[r8]
            p048l.p049a.C1122a.m1596a(r6, r7)
            if (r5 != 0) goto L_0x006c
            if (r4 != 0) goto L_0x00f6
            r2.setWeather(r3)
            goto L_0x00f9
        L_0x006c:
            if (r4 != 0) goto L_0x00be
            int r6 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.second(r18)     // Catch:{ Exception -> 0x0082 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 62
            r3 = 0
            r4 = r13
            r13 = r3
            jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r3 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0083 }
            r5 = 2
            goto L_0x008a
        L_0x0082:
            r4 = r13
        L_0x0083:
            r3 = 2
            r5 = 0
            r16 = r5
            r5 = r3
            r3 = r16
        L_0x008a:
            r2.setWeather(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r15)
            r6 = 0
            java.lang.String r1 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.format$default(r1, r4, r6, r5, r6)
            r3.append(r1)
            java.lang.String r1 = " targetWeather="
            r3.append(r1)
            jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r1 = r19.getWeather()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            p048l.p049a.C1122a.m1596a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r1 = r19.getWeather()
            if (r1 == 0) goto L_0x00f9
            jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger r2 = r0.dataLogger
            if (r2 != 0) goto L_0x00ee
            goto L_0x00eb
        L_0x00be:
            java.lang.String r6 = r5.getTimestamp()
            java.lang.String r7 = r4.getTimestamp()
            int r6 = r6.compareTo(r7)
            if (r6 <= 0) goto L_0x00f6
            int r6 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.second(r18)     // Catch:{ Exception -> 0x00dd }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 62
            r13 = 0
            jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r3 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00de
        L_0x00dd:
        L_0x00de:
            r2.setWeather(r3)
            jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r1 = r19.getWeather()
            if (r1 == 0) goto L_0x00f9
            jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger r2 = r0.dataLogger
            if (r2 != 0) goto L_0x00ee
        L_0x00eb:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
        L_0x00ee:
            g.a.r r1 = r2.saveForecast(r1)
            r1.mo27431a()
            goto L_0x00f9
        L_0x00f6:
            r2.setWeather(r4)
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader.m3710c(java.util.Date, jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily, jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily):void");
    }

    /* renamed from: d */
    private final List<RFLActivity> m3711d(List<RFLActivity> list) {
        ArrayList arrayList = new ArrayList();
        RFLActivity rFLActivity = null;
        for (RFLActivity next : list) {
            if (rFLActivity != null && next.type() == rFLActivity.type()) {
                rFLActivity.mo32041to(next.endTime().getTime());
                rFLActivity.setSteps(next.getSteps() + rFLActivity.getSteps());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(rFLActivity.getTrackPoints());
                for (RFLTrackPoint next2 : next.getTrackPoints()) {
                    if (!arrayList2.contains(next2)) {
                        arrayList2.add(next2);
                    }
                }
                rFLActivity.setLocation(arrayList2);
            } else {
                arrayList.add(next);
                rFLActivity = next;
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private final List<RFLSegment> m3712d(List<RFLSegment> list, List<RFLSegment> list2) {
        int size;
        ArrayList arrayList = new ArrayList();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
        ArrayList arrayList2 = new ArrayList();
        boolean unused2 = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, list2);
        int size2 = arrayList.size();
        if (size2 > arrayList2.size()) {
            C1122a.m1599b("[SilentLogSDK]::Error ServerDataId is same with Local, but dataCount is different --> only use local", new Object[0]);
            return arrayList2;
        } else if (size2 == 0) {
            C1122a.m1599b("[SilentLogSDK]::Error no server data --> only use local", new Object[0]);
            return arrayList2;
        } else {
            int size3 = arrayList.size() - 1;
            for (int i = 0; i < size3; i++) {
                arrayList2.remove(0);
            }
            arrayList.remove(size3);
            if ((!arrayList.isEmpty()) && (!arrayList2.isEmpty()) && 1 <= (size = arrayList.size())) {
                int i2 = 1;
                while (true) {
                    if (((RFLSegment) CollectionsKt___CollectionsKt.last(arrayList)).getToDate() != ((RFLSegment) CollectionsKt___CollectionsKt.first(arrayList2)).getFromDate()) {
                        C1122a.m1600c("[SilentLogSDK]::Warn Server endtime is NOT same with local starttime", new Object[0]);
                        int size4 = arrayList.size() - 1;
                        arrayList.remove(size4);
                        arrayList2.add(0, list2.get(size4));
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            arrayList.addAll(arrayList2);
            if (arrayList.size() == list2.size()) {
                return arrayList;
            }
            C1122a.m1599b("[SilenLogSDK]::Error Merged Segments Count (%s) is not same with Local Segments Count (%s) --> only use local", Integer.valueOf(arrayList.size()), Integer.valueOf(list2.size()));
            return list2;
        }
    }

    /* renamed from: e */
    private final List<RFLActivity> m3713e(List<RFLActivity> list) {
        ArrayList arrayList = new ArrayList();
        RFLActivity rFLActivity = null;
        for (RFLActivity next : list) {
            if (rFLActivity != null && Intrinsics.areEqual((Object) next.getDetailType(), (Object) rFLActivity.getDetailType())) {
                rFLActivity.mo32041to(next.endTime().getTime());
                rFLActivity.setSteps(next.getSteps() + rFLActivity.getSteps());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(rFLActivity.getTrackPoints());
                for (RFLTrackPoint next2 : next.getTrackPoints()) {
                    if (!arrayList2.contains(next2)) {
                        arrayList2.add(next2);
                    }
                }
                rFLActivity.setLocation(arrayList2);
            } else {
                arrayList.add(next);
                rFLActivity = next;
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0080, code lost:
        if (r3 > 117) goto L_0x0082;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity> m3714f(java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity> r11) {
        /*
            r10 = this;
            java.util.Iterator r0 = r11.iterator()
        L_0x0004:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0090
            java.lang.Object r1 = r0.next()
            jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity r1 = (p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity) r1
            float r2 = r1.speed()
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r3 = r1.type()
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r4 = p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE.STAY
            r5 = 2
            if (r3 != r4) goto L_0x0031
            float r3 = r1.speedA2B()
            float r3 = r2 - r3
            float r4 = (float) r5
            float r3 = r3 / r4
            float r2 = r2 - r3
            double r2 = (double) r2
            r4 = 4610740262505640100(0x3ffca3d70a3d70a4, double:1.79)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0004
            goto L_0x0089
        L_0x0031:
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r3 = r1.type()
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r4 = p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE.WALK
            if (r3 != r4) goto L_0x0004
            float r3 = r1.speedA2B()
            float r3 = r2 - r3
            float r4 = (float) r5
            float r3 = r3 / r4
            float r2 = r2 - r3
            int r3 = r1.stepPerAct()
            double r6 = (double) r2
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x005e
            java.util.List r2 = r1.getTrackPoints()
            int r2 = r2.size()
            if (r2 <= r5) goto L_0x0004
            r2 = 60
            if (r3 >= r2) goto L_0x0004
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r2 = p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE.STAY
            goto L_0x008b
        L_0x005e:
            r4 = 4611235658464650854(0x3ffe666666666666, double:1.9)
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0075
            r4 = 4609884578576439706(0x3ff999999999999a, double:1.6)
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0004
            r2 = 130(0x82, float:1.82E-43)
            if (r3 <= r2) goto L_0x0004
            goto L_0x0082
        L_0x0075:
            r4 = 4614680912179589284(0x400aa3d70a3d70a4, double:3.33)
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0089
            r2 = 117(0x75, float:1.64E-43)
            if (r3 <= r2) goto L_0x0089
        L_0x0082:
            java.lang.String r2 = "run"
            r1.setDetailType(r2)
            goto L_0x0004
        L_0x0089:
            jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE r2 = p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE.TRANSPORT
        L_0x008b:
            r1.setType(r2)
            goto L_0x0004
        L_0x0090:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader.m3714f(java.util.List):java.util.List");
    }

    /* renamed from: g */
    private final List<RFLActivity> m3715g(List<RFLActivity> list) {
        RFL_ACTIVITY_TYPE rfl_activity_type;
        int size = list.size() - 1;
        int i = 0;
        for (RFLActivity rFLActivity : list) {
            if (!(i == 0 || i == size)) {
                RFLActivity rFLActivity2 = list.get(i - 1);
                RFLActivity rFLActivity3 = list.get(i + 1);
                RFLTrackPoint rFLTrackPoint = (RFLTrackPoint) CollectionsKt___CollectionsKt.last(rFLActivity2.getTrackPoints());
                if (rFLActivity2.type() == RFL_ACTIVITY_TYPE.STAY) {
                    rFLTrackPoint = m3689a(rFLActivity2.getTrackPoints(), rFLActivity2.getFromDate());
                }
                RFLTrackPoint rFLTrackPoint2 = (RFLTrackPoint) CollectionsKt___CollectionsKt.first(rFLActivity3.getTrackPoints());
                if (rFLActivity3.type() == RFL_ACTIVITY_TYPE.STAY) {
                    rFLTrackPoint2 = m3689a(rFLActivity3.getTrackPoints(), rFLActivity3.getFromDate());
                }
                if (rFLActivity.type() == RFL_ACTIVITY_TYPE.TRANSPORT) {
                    RFLDailyUtils rFLDailyUtils = this.dailyUtils;
                    if (rFLDailyUtils == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                    }
                    if (rFLDailyUtils.distanceBetween(rFLTrackPoint, rFLTrackPoint2) < ((float) 500)) {
                        if (m3696a(rFLActivity)) {
                            if (rFLActivity3.type() == RFL_ACTIVITY_TYPE.WALK && rFLActivity3.getTrackPoints().size() < 2) {
                                rfl_activity_type = RFL_ACTIVITY_TYPE.WALK;
                                rFLActivity.setType(rfl_activity_type);
                            }
                        }
                    }
                } else if (rFLActivity.type() == RFL_ACTIVITY_TYPE.WALK) {
                    RFLDailyUtils rFLDailyUtils2 = this.dailyUtils;
                    if (rFLDailyUtils2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                    }
                    float distanceBetween = rFLDailyUtils2.distanceBetween(rFLTrackPoint, rFLTrackPoint2);
                    if (rFLActivity.count() < 3) {
                        if (distanceBetween >= ((float) 35)) {
                            if (rFLActivity.speed() > ((float) 4)) {
                                if (rFLActivity.stepPerAct() >= 50) {
                                }
                            }
                        }
                    }
                }
                rfl_activity_type = RFL_ACTIVITY_TYPE.STAY;
                rFLActivity.setType(rfl_activity_type);
            }
            i++;
        }
        return list;
    }

    /* renamed from: h */
    private final List<RFLActivity> m3716h(List<RFLActivity> list) {
        int size = list.size() - 1;
        int i = 0;
        for (RFLActivity rFLActivity : list) {
            if (!(i == 0 || i == size || rFLActivity.type() != RFL_ACTIVITY_TYPE.STAY)) {
                RFLTrackPoint rFLTrackPoint = rFLActivity.getTrackPoints().get(0);
                RFLActivity rFLActivity2 = list.get(i + 1);
                if (rFLActivity2.getTrackPoints().size() > 1) {
                    RFLTrackPoint rFLTrackPoint2 = rFLActivity2.getTrackPoints().get(1);
                    int timestamp = rFLTrackPoint2.getTimestamp() - rFLActivity.getFromDate();
                    RFLDailyUtils rFLDailyUtils = this.dailyUtils;
                    if (rFLDailyUtils == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                    }
                    float distanceBetween = rFLDailyUtils.distanceBetween(rFLTrackPoint2, rFLTrackPoint);
                    double d = 0.9d;
                    if (rFLActivity.getTrackPoints().size() > 1) {
                        d = 0.5d;
                    }
                    if (distanceBetween > ((float) 20)) {
                        double d2 = (double) (distanceBetween / ((float) timestamp));
                        if (d2 > d) {
                            rFLActivity.setType((rFLActivity.stepPerAct() <= 40 || d2 >= 2.5d) ? RFL_ACTIVITY_TYPE.TRANSPORT : RFL_ACTIVITY_TYPE.WALK);
                        }
                    }
                }
            }
            i++;
        }
        return list;
    }

    /* renamed from: i */
    private final List<RFLActivity> m3717i(List<RFLActivity> list) {
        for (RFLActivity next : list) {
            if (next.type() == RFL_ACTIVITY_TYPE.STAY) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(m3689a(next.getTrackPoints(), next.getFromDate()));
                next.setLocation(arrayList);
            }
        }
        return list;
    }

    /* renamed from: j */
    private final void m3718j(List<RFLTrackPoint> list) {
        for (RFLTrackPoint next : list) {
            C1122a.m1596a("timestamp:%s latlon:%s,%st", new Date(((long) next.getTimestamp()) * 1000), Double.valueOf(next.getLatitude()), Double.valueOf(next.getLongitude()));
        }
    }

    /* renamed from: k */
    private final String m3719k(List<String> list) {
        int size = list.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            str = C0681a.m320a(str, list.get(i));
            if (i != list.size() - 1) {
                str = C0681a.m320a(str, ",");
            }
        }
        return str;
    }

    /* renamed from: l */
    private final List<RFLTrackPoint> m3720l(List<RFLTrackPoint> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<RFLTrackPoint> it = list.iterator();
        RFLTrackPoint rFLTrackPoint = null;
        while (true) {
            int i = 1;
            if (!it.hasNext()) {
                break;
            }
            RFLTrackPoint next = it.next();
            if (rFLTrackPoint != null) {
                RFLDailyUtils rFLDailyUtils = this.dailyUtils;
                if (rFLDailyUtils == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                }
                i = rFLDailyUtils.validBetween(rFLTrackPoint, next);
            }
            arrayList.add(new RFLTrackPointMap(i, next));
            rFLTrackPoint = next;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            RFLTrackPointMap rFLTrackPointMap = (RFLTrackPointMap) it2.next();
            if (rFLTrackPointMap.getDistance() == 1) {
                arrayList2.add(rFLTrackPointMap.getLocation());
            }
        }
        float f = -1.0f;
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            RFLTrackPoint rFLTrackPoint2 = (RFLTrackPoint) it3.next();
            RFLTrackPoint rFLTrackPoint3 = i2 != 0 ? (RFLTrackPoint) arrayList2.get(i2 - 1) : null;
            if (rFLTrackPoint3 != null) {
                RFLDailyUtils rFLDailyUtils2 = this.dailyUtils;
                if (rFLDailyUtils2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                }
                float distanceBetween = rFLDailyUtils2.distanceBetween(rFLTrackPoint3, rFLTrackPoint2);
                RFLDailyUtils rFLDailyUtils3 = this.dailyUtils;
                if (rFLDailyUtils3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                }
                float durationBetween = rFLDailyUtils3.durationBetween(rFLTrackPoint3, rFLTrackPoint2);
                float f2 = distanceBetween / durationBetween;
                float abs = Math.abs(f2 / f);
                if (durationBetween >= ((float) 60) || distanceBetween <= ((float) 100) || abs <= ((float) 5)) {
                    arrayList3.add(rFLTrackPoint2);
                    f = f2;
                }
            } else {
                arrayList3.add(rFLTrackPoint2);
            }
            i2++;
        }
        return arrayList3;
    }

    /* renamed from: m */
    private final List<RFLActivity> m3721m(List<RFLActivity> list) {
        ArrayList arrayList = new ArrayList();
        for (RFLActivity next : list) {
            if (next.type() != RFL_ACTIVITY_TYPE.CHANGE) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    private final List<RFLTrackPoint> m3722n(List<RFLTrackPoint> list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(list);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(linkedHashSet);
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new C2148x6cc512be());
        }
        return arrayList;
    }

    public final RFLDailyUtils getDailyUtils() {
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return rFLDailyUtils;
    }

    public final RFLDataLogger getDataLogger() {
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        return rFLDataLogger;
    }

    public final C1126c getEventBus() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        return cVar;
    }

    public final RFLGoogleFitManager getGoogleFitManager() {
        RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
        if (rFLGoogleFitManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
        }
        return rFLGoogleFitManager;
    }

    public final RFLH1Client getH1Client() {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        return rFLH1Client;
    }

    public final RFLPointManager getPointManager() {
        RFLPointManager rFLPointManager = this.pointManager;
        if (rFLPointManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointManager");
        }
        return rFLPointManager;
    }

    public final boolean isDebugMode() {
        return this.f3070b;
    }

    public final boolean isUseSdkStepPerMinutes() {
        return this.f3069a;
    }

    public final C1714r<UpdateDaily> loadDaily(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        C1714r<R> a = rFLH1Client.getDaily(date).mo27430a(new C2141b(this, date)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "h1Client.getDaily(date)\n…dSchedulers.mainThread())");
        return a;
    }

    public final C1714r<UpdateDaily> loadPredictionDaily(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        C1714r<R> a = rFLH1Client.getDaily(date).mo27430a(new C2143c(this, date)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "h1Client.getDaily(date)\n…dSchedulers.mainThread())");
        return a;
    }

    public final void postDaily(Date date, RFLDaily rFLDaily, Integer num) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(rFLDaily, "daily");
        RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
        if (rFLGoogleFitManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
        }
        if (rFLGoogleFitManager.isConnected()) {
            m3703b(date, rFLDaily, num);
        } else {
            m3691a(date, rFLDaily, num);
        }
    }

    public final void setDailyUtils(RFLDailyUtils rFLDailyUtils) {
        Intrinsics.checkParameterIsNotNull(rFLDailyUtils, "<set-?>");
        this.dailyUtils = rFLDailyUtils;
    }

    public final void setDataLogger(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "<set-?>");
        this.dataLogger = rFLDataLogger;
    }

    public final void setDebugMode(boolean z) {
        this.f3070b = z;
    }

    public final void setEventBus(C1126c cVar) {
        Intrinsics.checkParameterIsNotNull(cVar, "<set-?>");
        this.eventBus = cVar;
    }

    public final void setGoogleFitManager(RFLGoogleFitManager rFLGoogleFitManager) {
        Intrinsics.checkParameterIsNotNull(rFLGoogleFitManager, "<set-?>");
        this.googleFitManager = rFLGoogleFitManager;
    }

    public final void setH1Client(RFLH1Client rFLH1Client) {
        Intrinsics.checkParameterIsNotNull(rFLH1Client, "<set-?>");
        this.h1Client = rFLH1Client;
    }

    public final void setPointManager(RFLPointManager rFLPointManager) {
        Intrinsics.checkParameterIsNotNull(rFLPointManager, "<set-?>");
        this.pointManager = rFLPointManager;
    }

    public final void setUseSdkStepPerMinutes(boolean z) {
        this.f3069a = z;
    }
}
