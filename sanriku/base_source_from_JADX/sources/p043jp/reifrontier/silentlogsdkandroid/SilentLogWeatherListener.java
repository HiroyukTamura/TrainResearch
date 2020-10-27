package p043jp.reifrontier.silentlogsdkandroid;

import kotlin.Metadata;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogWeatherListener;", "", "OnCompletedFind", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogWeatherListener */
public interface SilentLogWeatherListener {

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogWeatherListener$OnCompletedFind;", "", "result", "", "weather", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogWeatherListener$OnCompletedFind */
    public interface OnCompletedFind {
        void result(RFLWeather rFLWeather);
    }
}
