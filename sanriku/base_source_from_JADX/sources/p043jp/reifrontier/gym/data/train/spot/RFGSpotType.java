package p043jp.reifrontier.gym.data.train.spot;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGSpotType;", "", "(Ljava/lang/String;I)V", "NO_TYPE", "SIGHT_SEE", "FOOD", "PLAY", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGSpotType */
public enum RFGSpotType {
    NO_TYPE,
    SIGHT_SEE,
    FOOD,
    PLAY;
    
    public static final Companion Companion = null;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGSpotType$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/data/train/spot/RFGSpotType;", "value", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.spot.RFGSpotType$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGSpotType getType(int i) {
            RFGSpotType[] values = RFGSpotType.values();
            return (i < 0 || i > values.length + -1) ? RFGSpotType.NO_TYPE : values[i];
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
