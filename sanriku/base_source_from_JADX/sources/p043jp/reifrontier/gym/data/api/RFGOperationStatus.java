package p043jp.reifrontier.gym.data.api;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGOperationStatus;", "", "(Ljava/lang/String;I)V", "NORMAL", "DELAY", "STOP", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGOperationStatus */
public enum RFGOperationStatus {
    NORMAL,
    DELAY,
    STOP;
    
    public static final Companion Companion = null;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGOperationStatus$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/data/api/RFGOperationStatus;", "trainId", "", "operationList", "", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGOperationStatus$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGOperationStatus getType(String str, List<RFGApiOperation> list) {
            T t;
            String status;
            Integer intOrNull;
            Intrinsics.checkParameterIsNotNull(str, "trainId");
            Intrinsics.checkParameterIsNotNull(list, "operationList");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual((Object) ((RFGApiOperation) t).getTrainId(), (Object) str)) {
                    break;
                }
            }
            RFGApiOperation rFGApiOperation = (RFGApiOperation) t;
            return (rFGApiOperation == null || (status = rFGApiOperation.getStatus()) == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(status)) == null) ? RFGOperationStatus.NORMAL : intOrNull.intValue() < 0 ? RFGOperationStatus.STOP : RFGOperationStatus.DELAY;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
