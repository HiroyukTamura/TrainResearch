package p043jp.reifrontier.gym.p044ui.widget.train;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo21739d2 = {"<anonymous>", "", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "kotlin.jvm.PlatformType", "onMapReady", "jp/reifrontier/gym/ui/widget/train/RFGAccessView$addMap$2$2"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.train.RFGAccessView$addMap$$inlined$doOnAttach$1$lambda$1 */
final class RFGAccessView$addMap$$inlined$doOnAttach$1$lambda$1 implements OnMapReadyCallback {
    final /* synthetic */ RFGAccessView$addMap$$inlined$doOnAttach$1 this$0;

    RFGAccessView$addMap$$inlined$doOnAttach$1$lambda$1(RFGAccessView$addMap$$inlined$doOnAttach$1 rFGAccessView$addMap$$inlined$doOnAttach$1) {
        this.this$0 = rFGAccessView$addMap$$inlined$doOnAttach$1;
    }

    public final void onMapReady(GoogleMap googleMap) {
        if (googleMap != null) {
            RFGAccessView$addMap$$inlined$doOnAttach$1 rFGAccessView$addMap$$inlined$doOnAttach$1 = this.this$0;
            rFGAccessView$addMap$$inlined$doOnAttach$1.this$0.onMapReady(googleMap, rFGAccessView$addMap$$inlined$doOnAttach$1.$lat$inlined, rFGAccessView$addMap$$inlined$doOnAttach$1.$lon$inlined);
        }
    }
}
