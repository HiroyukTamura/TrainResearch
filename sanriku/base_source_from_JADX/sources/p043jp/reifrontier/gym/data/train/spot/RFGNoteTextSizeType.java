package p043jp.reifrontier.gym.data.train.spot;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGNoteTextSizeType;", "", "(Ljava/lang/String;I)V", "getPixelSize", "", "context", "Landroid/content/Context;", "LARGE", "MEDIUM", "SMALL", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGNoteTextSizeType */
public enum RFGNoteTextSizeType {
    LARGE,
    MEDIUM,
    SMALL;
    
    public static final Companion Companion = null;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGNoteTextSizeType$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/data/train/spot/RFGNoteTextSizeType;", "value", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.spot.RFGNoteTextSizeType$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGNoteTextSizeType getType(int i) {
            return (1 <= i && 3 >= i) ? RFGNoteTextSizeType.values()[i - 1] : RFGNoteTextSizeType.MEDIUM;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.spot.RFGNoteTextSizeType$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[RFGNoteTextSizeType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGNoteTextSizeType rFGNoteTextSizeType = RFGNoteTextSizeType.LARGE;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGNoteTextSizeType rFGNoteTextSizeType2 = RFGNoteTextSizeType.MEDIUM;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGNoteTextSizeType rFGNoteTextSizeType3 = RFGNoteTextSizeType.SMALL;
            iArr3[2] = 3;
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
            i = R.dimen.sanriku_note_text_large;
        } else if (ordinal == 1) {
            resources = context.getResources();
            i = R.dimen.sanriku_note_text_medium;
        } else if (ordinal == 2) {
            resources = context.getResources();
            i = R.dimen.sanriku_note_text_small;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return resources.getDimension(i);
    }
}
