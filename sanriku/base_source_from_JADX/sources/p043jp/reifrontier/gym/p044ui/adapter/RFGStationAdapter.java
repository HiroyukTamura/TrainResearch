package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGStationAdapter;", "Landroid/widget/ArrayAdapter;", "Ljp/reifrontier/gym/data/train/RFGStation;", "context", "Landroid/content/Context;", "nearestStation", "resource", "", "(Landroid/content/Context;Ljp/reifrontier/gym/data/train/RFGStation;I)V", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "nearestPosition", "getNearestPosition", "()I", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGStationAdapter */
public final class RFGStationAdapter extends ArrayAdapter<RFGStation> {
    private final LayoutInflater layoutInflater;
    private final RFGStation nearestStation;
    private final int resource;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RFGStationAdapter(android.content.Context r3, p043jp.reifrontier.gym.data.train.RFGStation r4, int r5) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            jp.reifrontier.gym.data.train.RFGTrainData r0 = p043jp.reifrontier.gym.data.train.RFGTrainData.INSTANCE
            java.util.LinkedHashMap r0 = r0.getStationMap()
            java.util.Collection r0 = r0.values()
            java.lang.String r1 = "RFGTrainData.stationMap.values"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r0)
            r2.<init>(r3, r5, r0)
            r2.nearestStation = r4
            r2.resource = r5
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r2.layoutInflater = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.p044ui.adapter.RFGStationAdapter.<init>(android.content.Context, jp.reifrontier.gym.data.train.RFGStation, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGStationAdapter(Context context, RFGStation rFGStation, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, rFGStation, (i2 & 4) != 0 ? R.layout.row_sanriku_station : i);
    }

    public final int getNearestPosition() {
        int count = getCount();
        for (int i = 0; i < count; i++) {
            RFGStation rFGStation = (RFGStation) getItem(i);
            if (rFGStation != null) {
                Intrinsics.checkExpressionValueIsNotNull(rFGStation, "getItem(position) ?: continue");
                RFGStation rFGStation2 = this.nearestStation;
                if (rFGStation2 != null && rFGStation2.getStationId() == rFGStation.getStationId()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        int i2 = 0;
        if (view == null) {
            view = this.layoutInflater.inflate(this.resource, viewGroup, false);
        }
        RFGStation rFGStation = (RFGStation) getItem(i);
        if (rFGStation != null) {
            View findViewById = view.findViewById(R.id.locationPin);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById<ImageView>(R.id.locationPin)");
            ImageView imageView = (ImageView) findViewById;
            int stationId = rFGStation.getStationId();
            RFGStation rFGStation2 = this.nearestStation;
            imageView.setVisibility((rFGStation2 == null || stationId != rFGStation2.getStationId()) ? 8 : 0);
            View findViewById2 = view.findViewById(R.id.connectorTop);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById<ImageView>(R.id.connectorTop)");
            ((ImageView) findViewById2).setVisibility(i == 0 ? 4 : 0);
            View findViewById3 = view.findViewById(R.id.connectorBottom);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById<ImageView>(R.id.connectorBottom)");
            ImageView imageView2 = (ImageView) findViewById3;
            if (i >= getCount() - 1) {
                i2 = 4;
            }
            imageView2.setVisibility(i2);
            View findViewById4 = view.findViewById(R.id.stationName);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById<TextView>(R.id.stationName)");
            ((TextView) findViewById4).setText(rFGStation.getName());
            View findViewById5 = view.findViewById(R.id.stationNameKo);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "view.findViewById<TextView>(R.id.stationNameKo)");
            ((TextView) findViewById5).setText(rFGStation.getNameKo());
            View findViewById6 = view.findViewById(R.id.stationNameEn);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "view.findViewById<TextView>(R.id.stationNameEn)");
            ((TextView) findViewById6).setText(rFGStation.getNameEn());
        }
        Intrinsics.checkExpressionValueIsNotNull(view, Promotion.ACTION_VIEW);
        return view;
    }
}
