package p043jp.reifrontier.silentlogsdkandroid.daily;

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
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger_MembersInjector */
public final class RFLDataLogger_MembersInjector implements C1583a<RFLDataLogger> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3182a;

    /* renamed from: b */
    private final C1743a<RFLTrackPointDao> f3183b;

    /* renamed from: c */
    private final C1743a<RFLPedometerDao> f3184c;

    /* renamed from: d */
    private final C1743a<RFLDailyDao> f3185d;

    /* renamed from: e */
    private final C1743a<RFLTPDao> f3186e;

    /* renamed from: f */
    private final C1743a<RFLTagDao> f3187f;

    /* renamed from: g */
    private final C1743a<RFLAdjustTrackPointDao> f3188g;

    /* renamed from: h */
    private final C1743a<RFLBarometerDao> f3189h;

    /* renamed from: i */
    private final C1743a<RFLDailyTagDao> f3190i;

    /* renamed from: j */
    private final C1743a<RFLWeatherDao> f3191j;

    public RFLDataLogger_MembersInjector(C1743a<RFLOrmaHolder> aVar, C1743a<RFLTrackPointDao> aVar2, C1743a<RFLPedometerDao> aVar3, C1743a<RFLDailyDao> aVar4, C1743a<RFLTPDao> aVar5, C1743a<RFLTagDao> aVar6, C1743a<RFLAdjustTrackPointDao> aVar7, C1743a<RFLBarometerDao> aVar8, C1743a<RFLDailyTagDao> aVar9, C1743a<RFLWeatherDao> aVar10) {
        this.f3182a = aVar;
        this.f3183b = aVar2;
        this.f3184c = aVar3;
        this.f3185d = aVar4;
        this.f3186e = aVar5;
        this.f3187f = aVar6;
        this.f3188g = aVar7;
        this.f3189h = aVar8;
        this.f3190i = aVar9;
        this.f3191j = aVar10;
    }

    public static C1583a<RFLDataLogger> create(C1743a<RFLOrmaHolder> aVar, C1743a<RFLTrackPointDao> aVar2, C1743a<RFLPedometerDao> aVar3, C1743a<RFLDailyDao> aVar4, C1743a<RFLTPDao> aVar5, C1743a<RFLTagDao> aVar6, C1743a<RFLAdjustTrackPointDao> aVar7, C1743a<RFLBarometerDao> aVar8, C1743a<RFLDailyTagDao> aVar9, C1743a<RFLWeatherDao> aVar10) {
        return new RFLDataLogger_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10);
    }

    public static void injectAdjustTrackPointDao(RFLDataLogger rFLDataLogger, RFLAdjustTrackPointDao rFLAdjustTrackPointDao) {
        rFLDataLogger.adjustTrackPointDao = rFLAdjustTrackPointDao;
    }

    public static void injectBarometerDao(RFLDataLogger rFLDataLogger, RFLBarometerDao rFLBarometerDao) {
        rFLDataLogger.barometerDao = rFLBarometerDao;
    }

    public static void injectDailyDao(RFLDataLogger rFLDataLogger, RFLDailyDao rFLDailyDao) {
        rFLDataLogger.dailyDao = rFLDailyDao;
    }

    public static void injectDailyTagDao(RFLDataLogger rFLDataLogger, RFLDailyTagDao rFLDailyTagDao) {
        rFLDataLogger.dailyTagDao = rFLDailyTagDao;
    }

    public static void injectPedometerDao(RFLDataLogger rFLDataLogger, RFLPedometerDao rFLPedometerDao) {
        rFLDataLogger.pedometerDao = rFLPedometerDao;
    }

    public static void injectRflOrmaHolder(RFLDataLogger rFLDataLogger, RFLOrmaHolder rFLOrmaHolder) {
        rFLDataLogger.rflOrmaHolder = rFLOrmaHolder;
    }

    public static void injectTagDao(RFLDataLogger rFLDataLogger, RFLTagDao rFLTagDao) {
        rFLDataLogger.tagDao = rFLTagDao;
    }

    public static void injectTpDao(RFLDataLogger rFLDataLogger, RFLTPDao rFLTPDao) {
        rFLDataLogger.tpDao = rFLTPDao;
    }

    public static void injectTrackPointDao(RFLDataLogger rFLDataLogger, RFLTrackPointDao rFLTrackPointDao) {
        rFLDataLogger.trackPointDao = rFLTrackPointDao;
    }

    public static void injectWeatherDao(RFLDataLogger rFLDataLogger, RFLWeatherDao rFLWeatherDao) {
        rFLDataLogger.weatherDao = rFLWeatherDao;
    }

    public void injectMembers(RFLDataLogger rFLDataLogger) {
        injectRflOrmaHolder(rFLDataLogger, this.f3182a.get());
        injectTrackPointDao(rFLDataLogger, this.f3183b.get());
        injectPedometerDao(rFLDataLogger, this.f3184c.get());
        injectDailyDao(rFLDataLogger, this.f3185d.get());
        injectTpDao(rFLDataLogger, this.f3186e.get());
        injectTagDao(rFLDataLogger, this.f3187f.get());
        injectAdjustTrackPointDao(rFLDataLogger, this.f3188g.get());
        injectBarometerDao(rFLDataLogger, this.f3189h.get());
        injectDailyTagDao(rFLDataLogger, this.f3190i.get());
        injectWeatherDao(rFLDataLogger, this.f3191j.get());
    }
}
