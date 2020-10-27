package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTriggerType;", "", "typeValue", "", "(Ljava/lang/String;II)V", "getTypeValue", "()I", "BEACON", "GEO_FENCE", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTriggerType */
public enum RFLAdTriggerType {
    BEACON(0),
    GEO_FENCE(1);
    
    public static final Companion Companion = null;

    /* renamed from: a */
    private final int f3456a;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTriggerType$Companion;", "", "()V", "getType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTriggerType;", "typeValue", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTriggerType$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFLAdTriggerType getType(int i) {
            RFLAdTriggerType rFLAdTriggerType;
            RFLAdTriggerType[] values = RFLAdTriggerType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    rFLAdTriggerType = null;
                    break;
                }
                rFLAdTriggerType = values[i2];
                if (rFLAdTriggerType.getTypeValue() == i) {
                    break;
                }
                i2++;
            }
            return rFLAdTriggerType != null ? rFLAdTriggerType : RFLAdTriggerType.BEACON;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private RFLAdTriggerType(int i) {
        this.f3456a = i;
    }

    public final int getTypeValue() {
        return this.f3456a;
    }
}
