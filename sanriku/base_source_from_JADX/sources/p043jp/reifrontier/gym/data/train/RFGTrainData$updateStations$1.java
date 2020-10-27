package p043jp.reifrontier.gym.data.train;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity;
import p043jp.reifrontier.gym.util.CalendarEx;
import p078g.p079a.C1715s;
import p078g.p079a.C1717u;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "realmEmitter", "Lio/reactivex/SingleEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainData$updateStations$1 */
final class RFGTrainData$updateStations$1<T> implements C1717u<T> {
    public static final RFGTrainData$updateStations$1 INSTANCE = new RFGTrainData$updateStations$1();

    RFGTrainData$updateStations$1() {
    }

    public final void subscribe(C1715s<Boolean> sVar) {
        Intrinsics.checkParameterIsNotNull(sVar, "realmEmitter");
        RFGTrainEntity rFGTrainEntity = (RFGTrainEntity) Realm.getDefaultInstance().where(RFGTrainEntity.class).findFirst();
        boolean z = true;
        if (rFGTrainEntity != null) {
            Intrinsics.checkExpressionValueIsNotNull(rFGTrainEntity, "Realm.getDefaultInstance…turn@create\n            }");
            if (!rFGTrainEntity.isValid()) {
                sVar.onSuccess(true);
            } else if (rFGTrainEntity.getUpdateTime() < RFGTrainData.changeJsonTime) {
                sVar.onSuccess(true);
            } else {
                if (rFGTrainEntity.getUpdateTime() >= CalendarEx.INSTANCE.today().getTimeInMillis()) {
                    z = false;
                }
                sVar.onSuccess(Boolean.valueOf(z));
            }
        } else {
            RFGTrainData rFGTrainData = RFGTrainData.INSTANCE;
            sVar.onSuccess(true);
        }
    }
}
