package p043jp.reifrontier.gym.fragment.train;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "marker", "Lcom/google/android/gms/maps/model/Marker;", "kotlin.jvm.PlatformType", "onMarkerClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$onMapReady$2 */
final class RFGScheduleMapFragment$onMapReady$2 implements GoogleMap.OnMarkerClickListener {
    final /* synthetic */ RFGScheduleMapFragment this$0;

    RFGScheduleMapFragment$onMapReady$2(RFGScheduleMapFragment rFGScheduleMapFragment) {
        this.this$0 = rFGScheduleMapFragment;
    }

    public final boolean onMarkerClick(Marker marker) {
        RFGScheduleMapFragment rFGScheduleMapFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(marker, "marker");
        return rFGScheduleMapFragment.onMarkerClick(marker);
    }
}
