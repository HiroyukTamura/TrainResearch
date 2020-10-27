package p043jp.reifrontier.gym.data.train.spot;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGColorType;", "", "(Ljava/lang/String;I)V", "getColor", "", "context", "Landroid/content/Context;", "Black", "Gray", "Red", "Blue", "Green", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGColorType */
public enum RFGColorType {
    Black,
    Gray,
    Red,
    Blue,
    Green;
    
    public static final Companion Companion = null;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGColorType$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/data/train/spot/RFGColorType;", "value", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.spot.RFGColorType$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGColorType getType(int i) {
            return (1 <= i && 5 >= i) ? RFGColorType.values()[i - 1] : RFGColorType.Black;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.spot.RFGColorType$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[RFGColorType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGColorType rFGColorType = RFGColorType.Black;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGColorType rFGColorType2 = RFGColorType.Gray;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGColorType rFGColorType3 = RFGColorType.Red;
            iArr3[2] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            RFGColorType rFGColorType4 = RFGColorType.Blue;
            iArr4[3] = 4;
            int[] iArr5 = $EnumSwitchMapping$0;
            RFGColorType rFGColorType5 = RFGColorType.Green;
            iArr5[4] = 5;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @ColorInt
    public final int getColor(Context context) {
        int i;
        Intrinsics.checkParameterIsNotNull(context, "context");
        int ordinal = ordinal();
        if (ordinal == 0) {
            i = R.color.sanriku_black;
        } else if (ordinal == 1) {
            i = R.color.sanriku_gray;
        } else if (ordinal == 2) {
            i = R.color.sanriku_red;
        } else if (ordinal == 3) {
            i = R.color.sanriku_blue;
        } else if (ordinal == 4) {
            i = R.color.sanriku_green;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return ContextCompat.getColor(context, i);
    }
}
