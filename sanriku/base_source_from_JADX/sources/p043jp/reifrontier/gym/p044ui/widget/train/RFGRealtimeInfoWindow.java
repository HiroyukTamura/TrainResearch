package p043jp.reifrontier.gym.p044ui.widget.train;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGOperationStatus;
import p043jp.reifrontier.gym.data.api.RFGRealtime;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrain;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/train/RFGRealtimeInfoWindow;", "Lcom/google/android/gms/maps/GoogleMap$InfoWindowAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "infoWindowView", "Landroid/view/View;", "getInfoContents", "marker", "Lcom/google/android/gms/maps/model/Marker;", "getInfoWindow", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.train.RFGRealtimeInfoWindow */
public final class RFGRealtimeInfoWindow implements GoogleMap.InfoWindowAdapter {
    private final Context context;
    @SuppressLint({"InflateParams"})
    private final View infoWindowView;

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.widget.train.RFGRealtimeInfoWindow$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFGOperationStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGOperationStatus rFGOperationStatus = RFGOperationStatus.NORMAL;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGOperationStatus rFGOperationStatus2 = RFGOperationStatus.DELAY;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGOperationStatus rFGOperationStatus3 = RFGOperationStatus.STOP;
            iArr3[2] = 3;
        }
    }

    public RFGRealtimeInfoWindow(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        View inflate = LayoutInflater.from(context2).inflate(R.layout.view_realtime_info, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…view_realtime_info, null)");
        this.infoWindowView = inflate;
    }

    public View getInfoContents(Marker marker) {
        return null;
    }

    public View getInfoWindow(Marker marker) {
        String trainNo;
        RFGTrain rFGTrain;
        RFGStation findStation;
        int i;
        Object tag = marker != null ? marker.getTag() : null;
        if (!(tag instanceof RFGRealtime)) {
            tag = null;
        }
        RFGRealtime rFGRealtime = (RFGRealtime) tag;
        if (!(rFGRealtime == null || (rFGTrain = RFGTrainData.INSTANCE.getTrainMap().get(trainNo)) == null)) {
            Intrinsics.checkExpressionValueIsNotNull(rFGTrain, "RFGTrainData.trainMap[trainId] ?: return null");
            RFGStation findStation2 = RFGTrainData.INSTANCE.findStation(Integer.valueOf(rFGTrain.getFromStationId()));
            if (!(findStation2 == null || (findStation = RFGTrainData.INSTANCE.findStation(Integer.valueOf(rFGTrain.getToStationId()))) == null)) {
                TextView textView = (TextView) this.infoWindowView.findViewById(R.id.textView);
                ImageView imageView = (ImageView) this.infoWindowView.findViewById(R.id.imageView);
                Intrinsics.checkExpressionValueIsNotNull(textView, "textView");
                textView.setText(this.context.getString(R.string.sanriku_realtime_text, new Object[]{(trainNo = rFGRealtime.getTrainNo()), findStation2.getName(), findStation.getName()}));
                int ordinal = rFGRealtime.getStatus().ordinal();
                if (ordinal == 0) {
                    i = R.mipmap.train_status_normal;
                } else if (ordinal == 1) {
                    i = R.mipmap.train_status_deley;
                } else if (ordinal == 2) {
                    i = R.mipmap.train_status_stop;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                imageView.setImageResource(i);
                return this.infoWindowView;
            }
        }
        return null;
    }
}
