package p043jp.reifrontier.gym.data.train.spot;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGButtonType;", "", "(Ljava/lang/String;I)V", "BUTTON_LINK", "TEXT_LINK", "SHARE", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGButtonType */
public enum RFGButtonType {
    BUTTON_LINK,
    TEXT_LINK,
    SHARE;
    
    public static final Companion Companion = null;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGButtonType$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/data/train/spot/RFGButtonType;", "value", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.spot.RFGButtonType$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGButtonType getType(int i) {
            return (1 <= i && 3 >= i) ? RFGButtonType.values()[i - 1] : RFGButtonType.BUTTON_LINK;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
