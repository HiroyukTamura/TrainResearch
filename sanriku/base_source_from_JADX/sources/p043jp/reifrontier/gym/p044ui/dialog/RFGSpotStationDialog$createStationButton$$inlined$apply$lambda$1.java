package p043jp.reifrontier.gym.p044ui.dialog;

import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import kotlin.Metadata;
import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.fragment.train.RFGSpotListFragment;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "jp/reifrontier/gym/ui/dialog/RFGSpotStationDialog$createStationButton$1$1"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGSpotStationDialog$createStationButton$$inlined$apply$lambda$1 */
final class RFGSpotStationDialog$createStationButton$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ int $cellWidth$inlined;
    final /* synthetic */ String $name$inlined;
    final /* synthetic */ GridLayout $parent$inlined;
    final /* synthetic */ RFGStation $station$inlined;
    final /* synthetic */ RFGSpotStationDialog this$0;

    RFGSpotStationDialog$createStationButton$$inlined$apply$lambda$1(RFGSpotStationDialog rFGSpotStationDialog, GridLayout gridLayout, int i, String str, RFGStation rFGStation) {
        this.this$0 = rFGSpotStationDialog;
        this.$parent$inlined = gridLayout;
        this.$cellWidth$inlined = i;
        this.$name$inlined = str;
        this.$station$inlined = rFGStation;
    }

    public final void onClick(View view) {
        C1126c.m1638c().mo21903a((Object) new RFGSpotListFragment.OnSelectedStation(false, this.$station$inlined));
        this.this$0.dismiss();
    }
}
