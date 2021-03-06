package p043jp.reifrontier.gym.data.train.spot;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGTitleTextSizeType;", "", "(Ljava/lang/String;I)V", "getPixelSize", "", "context", "Landroid/content/Context;", "H1", "H2", "H3", "H4", "H5", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGTitleTextSizeType */
public enum RFGTitleTextSizeType {
    H1,
    H2,
    H3,
    H4,
    H5;
    
    public static final Companion Companion = null;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGTitleTextSizeType$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/data/train/spot/RFGTitleTextSizeType;", "value", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.spot.RFGTitleTextSizeType$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGTitleTextSizeType getType(int i) {
            return (1 <= i && 5 >= i) ? RFGTitleTextSizeType.values()[i - 1] : RFGTitleTextSizeType.H1;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.spot.RFGTitleTextSizeType$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[RFGTitleTextSizeType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGTitleTextSizeType rFGTitleTextSizeType = RFGTitleTextSizeType.H1;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGTitleTextSizeType rFGTitleTextSizeType2 = RFGTitleTextSizeType.H2;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGTitleTextSizeType rFGTitleTextSizeType3 = RFGTitleTextSizeType.H3;
            iArr3[2] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            RFGTitleTextSizeType rFGTitleTextSizeType4 = RFGTitleTextSizeType.H4;
            iArr4[3] = 4;
            int[] iArr5 = $EnumSwitchMapping$0;
            RFGTitleTextSizeType rFGTitleTextSizeType5 = RFGTitleTextSizeType.H5;
            iArr5[4] = 5;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final float getPixelSize(Context context) {
        Resources resources;
        int i;
        Intrinsics.checkParameterIsNotNull(context, "context");
        int ordinal = ordinal();
        if (ordinal == 0) {
            resources = context.getResources();
            i = R.dimen.sanriku_h1_text;
        } else if (ordinal == 1) {
            resources = context.getResources();
            i = R.dimen.sanriku_h2_text;
        } else if (ordinal == 2) {
            resources = context.getResources();
            i = R.dimen.sanriku_h3_text;
        } else if (ordinal == 3) {
            resources = context.getResources();
            i = R.dimen.sanriku_h4_text;
        } else if (ordinal == 4) {
            resources = context.getResources();
            i = R.dimen.sanriku_h5_text;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return resources.getDimension(i);
    }
}
