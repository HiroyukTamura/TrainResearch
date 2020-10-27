package p043jp.reifrontier.gym.fragment.train;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment;
import p043jp.reifrontier.gym.p044ui.widget.autocompleted.RFGAutoCompletedAdapter;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo21739d2 = {"<anonymous>", "", "value", "", "searchResults", "", "Ljp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedAdapter$RFGHintData;", "isAlwaysShow", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$setUpAutoCompleted$1 */
final class RFGScheduleMapFragment$setUpAutoCompleted$1 extends Lambda implements Function3<String, List<? extends RFGAutoCompletedAdapter.RFGHintData>, Boolean, Unit> {
    final /* synthetic */ RFGScheduleMapFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RFGScheduleMapFragment$setUpAutoCompleted$1(RFGScheduleMapFragment rFGScheduleMapFragment) {
        super(3);
        this.this$0 = rFGScheduleMapFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (List<RFGAutoCompletedAdapter.RFGHintData>) (List) obj2, ((Boolean) obj3).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, List<RFGAutoCompletedAdapter.RFGHintData> list, boolean z) {
        T t;
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(list, "searchResults");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) ((RFGAutoCompletedAdapter.RFGHintData) t).getDisplayValue(), (Object) str)) {
                break;
            }
        }
        if ((((RFGAutoCompletedAdapter.RFGHintData) t) != null) && list.size() == 1) {
            RFGStation findStation = RFGTrainData.INSTANCE.findStation(str);
            if (findStation != null) {
                RFGAnalyticsManager.INSTANCE.sendEvent("200", "200d", String.valueOf(findStation.getStationId()));
                this.this$0.search(findStation);
            }
        } else if (!list.isEmpty()) {
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "200", "200c", (String) null, 4, (Object) null);
            RFGScheduleMapFragment.resetScheduleViewHeight$default(this.this$0, false, 1, (Object) null);
            this.this$0.clearInitStationMarker();
            this.this$0.clearSearchResultMarker();
            ArrayList arrayList = new ArrayList();
            for (RFGAutoCompletedAdapter.RFGHintData displayValue : list) {
                RFGStation findStation2 = RFGTrainData.INSTANCE.findStation(displayValue.getDisplayValue());
                if (findStation2 != null) {
                    arrayList.add(findStation2);
                }
            }
            this.this$0.addSearchResultMarker(arrayList);
        } else if (z) {
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "200", "200e", (String) null, 4, (Object) null);
            RFGScheduleMapFragment.OnScheduleMapFragmentListener access$getScheduleMapFragmentListener$p = this.this$0.scheduleMapFragmentListener;
            if (access$getScheduleMapFragmentListener$p != null) {
                access$getScheduleMapFragmentListener$p.showStationFragment();
            }
        }
    }
}
