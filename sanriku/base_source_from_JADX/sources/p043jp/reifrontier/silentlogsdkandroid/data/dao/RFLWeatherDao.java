package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityForecast;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherListData;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006J>\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J>\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLWeatherDao;", "", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "countForecastByDate", "", "date", "findCurrentWeather", "", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherListData;", "findForecastByDate", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityForecast;", "saveCurrentWeather", "", "temperature", "timestamp", "pressure", "", "pressureIn", "trend", "type", "saveForecast", "highTemperature", "lowTemperature", "icon", "weatherCode", "weatherType", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLWeatherDao */
public final class RFLWeatherDao {

    /* renamed from: a */
    private final RFLOrmaHolder f3341a;

    public RFLWeatherDao(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "rflOrmaHolder");
        this.f3341a = rFLOrmaHolder;
    }

    public final int countForecastByDate(int i) {
        return this.f3341a.getORMA().selectFromRFLEntityForecast().dateEq(RFLDailyUtilsKt.second(RFLDailyUtilsKt.start(RFLDailyUtilsKt.date(i)))).count();
    }

    public final List<RFLWeatherListData> findCurrentWeather(int i) {
        List<RFLEntityWeather> list = this.f3341a.getORMA().selectFromRFLEntityWeather().dateEq(RFLDailyUtilsKt.second(RFLDailyUtilsKt.start(RFLDailyUtilsKt.date(i)))).toList();
        Intrinsics.checkExpressionValueIsNotNull(list, "rflOrmaHolder.ORMA\n     …                .toList()");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (RFLEntityWeather rFLEntityWeather : list) {
            arrayList.add(new RFLWeatherListData(rFLEntityWeather.getDate(), rFLEntityWeather.getTemperature(), rFLEntityWeather.getTimestamp(), rFLEntityWeather.getPressure(), rFLEntityWeather.getPressureIn(), rFLEntityWeather.getTrend(), rFLEntityWeather.getType()));
        }
        return arrayList;
    }

    public final RFLEntityForecast findForecastByDate(int i) {
        int second = RFLDailyUtilsKt.second(RFLDailyUtilsKt.start(RFLDailyUtilsKt.date(i)));
        C1122a.m1596a("[SilentLogSDK]::Debug weatherDao findForecastByDate " + i + ", " + second, new Object[0]);
        return (RFLEntityForecast) this.f3341a.getORMA().selectFromRFLEntityForecast().dateEq(second).valueOrNull();
    }

    public final void saveCurrentWeather(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "pressure");
        Intrinsics.checkParameterIsNotNull(str2, "pressureIn");
        Intrinsics.checkParameterIsNotNull(str3, "trend");
        Intrinsics.checkParameterIsNotNull(str4, "type");
        this.f3341a.getORMA().prepareInsertIntoRFLEntityWeather(5).mo19796a(new RFLEntityWeather(RFLDailyUtilsKt.second(RFLDailyUtilsKt.start(RFLDailyUtilsKt.date(i))), i2, i3, str, str2, str3, str4));
    }

    public final void saveForecast(int i, int i2, int i3, String str, int i4, int i5, int i6) {
        Intrinsics.checkParameterIsNotNull(str, "icon");
        C1122a.m1596a("[SilentLogSDK]::Debug weatherDao saveForecast " + i, new Object[0]);
        this.f3341a.getORMA().prepareInsertIntoRFLEntityForecast(5).mo19796a(new RFLEntityForecast(i, i2, i3, str, i4, i5, i6));
    }
}
