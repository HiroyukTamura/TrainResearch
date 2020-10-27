package p043jp.reifrontier.gym.fragment.train;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.fragment.train.RFGStationFragment;
import p043jp.reifrontier.gym.p044ui.adapter.RFGStationAdapter;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGStationFragment$setUpStation$1 */
final class RFGStationFragment$setUpStation$1 implements AdapterView.OnItemClickListener {
    final /* synthetic */ RFGStationAdapter $adapter;
    final /* synthetic */ RFGStationFragment this$0;

    RFGStationFragment$setUpStation$1(RFGStationFragment rFGStationFragment, RFGStationAdapter rFGStationAdapter) {
        this.this$0 = rFGStationFragment;
        this.$adapter = rFGStationAdapter;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        RFGStation rFGStation = (RFGStation) this.$adapter.getItem(i);
        if (rFGStation != null) {
            Intrinsics.checkExpressionValueIsNotNull(rFGStation, "adapter.getItem(position…rn@setOnItemClickListener");
            RFGAnalyticsManager.INSTANCE.sendEvent("210", "210c", String.valueOf(rFGStation.getStationId()));
            RFGStationFragment.OnStationFragmentListener access$getStationFragmentListener$p = this.this$0.stationFragmentListener;
            if (access$getStationFragmentListener$p != null) {
                access$getStationFragmentListener$p.onSelectedStation(rFGStation);
            }
        }
    }
}
