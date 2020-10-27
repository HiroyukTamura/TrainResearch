package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLActivityPoiManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdjustTrackPointManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBarometerManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLPointManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLActivityDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLBarometerDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyTagDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLPedometerDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTagDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTrackPointDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLWeatherDao;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0001¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aJ\r\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b J\r\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b&J\r\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)J\r\u0010*\u001a\u00020\rH\u0001¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0J\r\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3J\r\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6J\r\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9J\r\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020;H\u0001¢\u0006\u0002\b@J\r\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCJ\r\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020N2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\bO¨\u0006P"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/di/module/RFLAppModule;", "", "()V", "provideEventBus", "Lorg/greenrobot/eventbus/EventBus;", "kotlin.jvm.PlatformType", "provideEventBus$silentlogsdkandroid_release", "provideRFLActivityDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLActivityDao;", "provideRFLActivityDao$silentlogsdkandroid_release", "provideRFLActivityPoiManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLActivityPoiManager;", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "provideRFLActivityPoiManager$silentlogsdkandroid_release", "provideRFLAdjustTrackPointDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLAdjustTrackPointDao;", "provideRFLAdjustTrackPointDao$silentlogsdkandroid_release", "provideRFLAdjustTrackPointManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdjustTrackPointManager;", "provideRFLAdjustTrackPointManager$silentlogsdkandroid_release", "provideRFLBarometerDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLBarometerDao;", "provideRFLBarometerDao$silentlogsdkandroid_release", "provideRFLBarometerManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLBarometerManager;", "provideRFLBarometerManager$silentlogsdkandroid_release", "provideRFLDailyDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyDao;", "provideRFLDailyDao$silentlogsdkandroid_release", "provideRFLDailyLoader", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;", "provideRFLDailyLoader$silentlogsdkandroid_release", "provideRFLDailyManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager;", "provideRFLDailyManager$silentlogsdkandroid_release", "provideRFLDailyTagManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyTagManager;", "provideRFLDailyTagManager$silentlogsdkandroid_release", "provideRFLDailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "provideRFLDailyUtils$silentlogsdkandroid_release", "provideRFLDataLogger", "provideRFLDataLogger$silentlogsdkandroid_release", "provideRFLEntityDailyTagDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyTagDao;", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "provideRFLEntityDailyTagDao$silentlogsdkandroid_release", "provideRFLH1Client", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "provideRFLH1Client$silentlogsdkandroid_release", "provideRFLPedometerDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLPedometerDao;", "provideRFLPedometerDao$silentlogsdkandroid_release", "provideRFLPedometerManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLPedometerManager;", "provideRFLPedometerManager$silentlogsdkandroid_release", "provideRFLPointClient", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLPointClient;", "provideRFLPointClient$silentlogsdkandroid_release", "provideRFLPointManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLPointManager;", "pointClient", "provideRFLPointManager$silentlogsdkandroid_release", "provideRFLTPDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTPDao;", "provideRFLTPDao$silentlogsdkandroid_release", "provideRFLTagDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTagDao;", "provideRFLTagDao$silentlogsdkandroid_release", "provideRFLTrackPointDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTrackPointDao;", "provideRFLTrackPointDao$silentlogsdkandroid_release", "provideRFLWeatherClient", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient;", "provideRFLWeatherClient$silentlogsdkandroid_release", "provideRFLWeatherDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLWeatherDao;", "provideRFLWeatherDao$silentlogsdkandroid_release", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule */
public final class RFLAppModule {
    public final C1126c provideEventBus$silentlogsdkandroid_release() {
        return C1126c.m1638c();
    }

    public final RFLActivityDao provideRFLActivityDao$silentlogsdkandroid_release() {
        return new RFLActivityDao();
    }

    public final RFLActivityPoiManager provideRFLActivityPoiManager$silentlogsdkandroid_release(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "dataLogger");
        return new RFLActivityPoiManager(rFLDataLogger);
    }

    public final RFLAdjustTrackPointDao provideRFLAdjustTrackPointDao$silentlogsdkandroid_release() {
        return new RFLAdjustTrackPointDao();
    }

    public final RFLAdjustTrackPointManager provideRFLAdjustTrackPointManager$silentlogsdkandroid_release(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "dataLogger");
        return new RFLAdjustTrackPointManager(rFLDataLogger);
    }

    public final RFLBarometerDao provideRFLBarometerDao$silentlogsdkandroid_release() {
        return new RFLBarometerDao();
    }

    public final RFLBarometerManager provideRFLBarometerManager$silentlogsdkandroid_release() {
        return new RFLBarometerManager();
    }

    public final RFLDailyDao provideRFLDailyDao$silentlogsdkandroid_release() {
        return new RFLDailyDao();
    }

    public final RFLDailyLoader provideRFLDailyLoader$silentlogsdkandroid_release() {
        return new RFLDailyLoader();
    }

    public final RFLDailyManager provideRFLDailyManager$silentlogsdkandroid_release() {
        return new RFLDailyManager();
    }

    public final RFLDailyTagManager provideRFLDailyTagManager$silentlogsdkandroid_release(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "dataLogger");
        return new RFLDailyTagManager(rFLDataLogger);
    }

    public final RFLDailyUtils provideRFLDailyUtils$silentlogsdkandroid_release() {
        return new RFLDailyUtils();
    }

    public final RFLDataLogger provideRFLDataLogger$silentlogsdkandroid_release() {
        return new RFLDataLogger();
    }

    public final RFLDailyTagDao provideRFLEntityDailyTagDao$silentlogsdkandroid_release(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "rflOrmaHolder");
        return new RFLDailyTagDao(rFLOrmaHolder);
    }

    public final RFLH1Client provideRFLH1Client$silentlogsdkandroid_release() {
        return new RFLH1Client();
    }

    public final RFLPedometerDao provideRFLPedometerDao$silentlogsdkandroid_release() {
        return new RFLPedometerDao();
    }

    public final RFLPedometerManager provideRFLPedometerManager$silentlogsdkandroid_release() {
        return new RFLPedometerManager();
    }

    public final RFLPointClient provideRFLPointClient$silentlogsdkandroid_release() {
        return new RFLPointClient();
    }

    public final RFLPointManager provideRFLPointManager$silentlogsdkandroid_release(RFLPointClient rFLPointClient) {
        Intrinsics.checkParameterIsNotNull(rFLPointClient, "pointClient");
        return new RFLPointManager(rFLPointClient);
    }

    public final RFLTPDao provideRFLTPDao$silentlogsdkandroid_release() {
        return new RFLTPDao();
    }

    public final RFLTagDao provideRFLTagDao$silentlogsdkandroid_release() {
        return new RFLTagDao();
    }

    public final RFLTrackPointDao provideRFLTrackPointDao$silentlogsdkandroid_release() {
        return new RFLTrackPointDao();
    }

    public final RFLWeatherClient provideRFLWeatherClient$silentlogsdkandroid_release() {
        return new RFLWeatherClient();
    }

    public final RFLWeatherDao provideRFLWeatherDao$silentlogsdkandroid_release(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "rflOrmaHolder");
        return new RFLWeatherDao(rFLOrmaHolder);
    }
}
