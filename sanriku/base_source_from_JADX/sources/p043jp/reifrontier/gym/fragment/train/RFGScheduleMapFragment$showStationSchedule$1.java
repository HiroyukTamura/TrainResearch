package p043jp.reifrontier.gym.fragment.train;

import android.os.Handler;
import android.widget.ListView;
import java.util.Calendar;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGStationDetail;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGTrainDetail;
import p043jp.reifrontier.gym.util.CaledarExKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$showStationSchedule$1 */
final class RFGScheduleMapFragment$showStationSchedule$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RFGStationDetail $stationDetail;
    final /* synthetic */ RFGScheduleMapFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RFGScheduleMapFragment$showStationSchedule$1(RFGScheduleMapFragment rFGScheduleMapFragment, RFGStationDetail rFGStationDetail) {
        super(0);
        this.this$0 = rFGScheduleMapFragment;
        this.$stationDetail = rFGStationDetail;
    }

    public final void invoke() {
        Calendar instance = Calendar.getInstance();
        final Ref.IntRef intRef = new Ref.IntRef();
        Iterator<RFGTrainDetail> it = this.$stationDetail.getScheduleList().iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            Calendar departureTime = it.next().getDepartureTime();
            Intrinsics.checkExpressionValueIsNotNull(instance, "now");
            if (CaledarExKt.compareTime(departureTime, instance) > 0) {
                break;
            }
            i2++;
        }
        intRef.element = i2;
        if (i2 >= 0) {
            i = i2;
        }
        intRef.element = i;
        new Handler().postDelayed(new Runnable(this) {
            final /* synthetic */ RFGScheduleMapFragment$showStationSchedule$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                if (((ListView) this.this$0.this$0._$_findCachedViewById(C2092R.C2094id.scheduleList)) != null) {
                    ((ListView) this.this$0.this$0._$_findCachedViewById(C2092R.C2094id.scheduleList)).setSelection(intRef.element);
                }
            }
        }, 300);
        ((ListView) this.this$0._$_findCachedViewById(C2092R.C2094id.scheduleList)).post(new Runnable(this) {
            final /* synthetic */ RFGScheduleMapFragment$showStationSchedule$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                if (((ListView) this.this$0.this$0._$_findCachedViewById(C2092R.C2094id.scheduleList)) != null) {
                    ((ListView) this.this$0.this$0._$_findCachedViewById(C2092R.C2094id.scheduleList)).setSelection(intRef.element);
                }
            }
        });
    }
}
