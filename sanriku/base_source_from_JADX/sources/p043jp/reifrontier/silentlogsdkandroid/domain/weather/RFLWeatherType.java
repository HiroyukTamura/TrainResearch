package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherType;", "", "(Ljava/lang/String;I)V", "CLEAR", "SNOW", "RAIN", "CLOUD", "FOGGY", "STORM", "MOST_CLEAR", "UNKNOWN", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType */
public enum RFLWeatherType {
    CLEAR,
    SNOW,
    RAIN,
    CLOUD,
    FOGGY,
    STORM,
    MOST_CLEAR,
    UNKNOWN;
    
    public static final Companion Companion = null;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherType$Companion;", "", "()V", "getFromApi", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherType;", "weatherId", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
            if (r2 < 1000) goto L_0x003b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType getFromApi(int r2) {
            /*
                r1 = this;
                r0 = 300(0x12c, float:4.2E-43)
                if (r2 >= r0) goto L_0x0005
                goto L_0x003b
            L_0x0005:
                r0 = 400(0x190, float:5.6E-43)
                if (r2 >= r0) goto L_0x000a
                goto L_0x0021
            L_0x000a:
                r0 = 500(0x1f4, float:7.0E-43)
                if (r2 >= r0) goto L_0x000f
                goto L_0x003e
            L_0x000f:
                r0 = 600(0x258, float:8.41E-43)
                if (r2 >= r0) goto L_0x0016
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.RAIN
                goto L_0x0040
            L_0x0016:
                r0 = 700(0x2bc, float:9.81E-43)
                if (r2 >= r0) goto L_0x001d
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.SNOW
                goto L_0x0040
            L_0x001d:
                r0 = 800(0x320, float:1.121E-42)
                if (r2 >= r0) goto L_0x0024
            L_0x0021:
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.FOGGY
                goto L_0x0040
            L_0x0024:
                if (r2 != r0) goto L_0x0029
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.CLEAR
                goto L_0x0040
            L_0x0029:
                r0 = 801(0x321, float:1.122E-42)
                if (r2 != r0) goto L_0x0030
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.MOST_CLEAR
                goto L_0x0040
            L_0x0030:
                r0 = 900(0x384, float:1.261E-42)
                if (r2 >= r0) goto L_0x0037
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.CLOUD
                goto L_0x0040
            L_0x0037:
                r0 = 1000(0x3e8, float:1.401E-42)
                if (r2 >= r0) goto L_0x003e
            L_0x003b:
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.STORM
                goto L_0x0040
            L_0x003e:
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.UNKNOWN
            L_0x0040:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.Companion.getFromApi(int):jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType");
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
