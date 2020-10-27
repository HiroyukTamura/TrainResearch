package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import java.util.Calendar;
import java.util.Random;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherCategory;", "", "hour", "", "(Ljava/lang/String;II)V", "randomMinute", "getRandomMinute", "()I", "randomTime", "Ljava/util/Calendar;", "getRandomTime", "()Ljava/util/Calendar;", "NONE", "A", "B", "C", "D", "E", "F", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherCategory */
public enum RFLWeatherCategory {
    NONE(4),
    f3790A(4),
    B(4),
    C(5),
    D(5),
    f3794E(6),
    F(6);
    

    /* renamed from: a */
    private final int f3797a;

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherCategory$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[RFLWeatherCategory.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFLWeatherCategory rFLWeatherCategory = RFLWeatherCategory.NONE;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFLWeatherCategory rFLWeatherCategory2 = RFLWeatherCategory.f3790A;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFLWeatherCategory rFLWeatherCategory3 = RFLWeatherCategory.B;
            iArr3[2] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            RFLWeatherCategory rFLWeatherCategory4 = RFLWeatherCategory.C;
            iArr4[3] = 4;
            int[] iArr5 = $EnumSwitchMapping$0;
            RFLWeatherCategory rFLWeatherCategory5 = RFLWeatherCategory.D;
            iArr5[4] = 5;
            int[] iArr6 = $EnumSwitchMapping$0;
            RFLWeatherCategory rFLWeatherCategory6 = RFLWeatherCategory.f3794E;
            iArr6[5] = 6;
            int[] iArr7 = $EnumSwitchMapping$0;
            RFLWeatherCategory rFLWeatherCategory7 = RFLWeatherCategory.F;
            iArr7[6] = 7;
        }
    }

    private RFLWeatherCategory(int i) {
        this.f3797a = i;
    }

    /* renamed from: a */
    private final int m3938a() {
        int[] iArr;
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                iArr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                break;
            case 3:
                iArr = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
                break;
            case 4:
                iArr = new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
                break;
            case 5:
                iArr = new int[]{30, 31, 32, 33, 34, 35, 36, 37, 38, 39};
                break;
            case 6:
                iArr = new int[]{40, 41, 42, 43, 44, 45, 46, 47, 48, 49};
                break;
            case 7:
                iArr = new int[]{50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return iArr[new Random(System.currentTimeMillis()).nextInt(iArr.length)];
    }

    public final Calendar getRandomTime() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, this.f3797a);
        instance.set(12, m3938a());
        instance.set(13, 0);
        instance.set(14, 0);
        Intrinsics.checkExpressionValueIsNotNull(instance, "value");
        return instance;
    }
}
