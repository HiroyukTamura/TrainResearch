package p043jp.reifrontier.gym.p044ui.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrain;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.data.train.RFGTrainSchedule;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGTrainScheduleDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "currentStation", "Ljp/reifrontier/gym/data/train/RFGTrainSchedule;", "train", "Ljp/reifrontier/gym/data/train/RFGTrain;", "extractArgs", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "scrollToCurrentStation", "viewScroll", "Landroid/widget/ScrollView;", "viewScheduleList", "Landroid/widget/LinearLayout;", "setUpView", "Landroid/view/View;", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGTrainScheduleDialog */
public final class RFGTrainScheduleDialog extends DialogFragment {
    private static final String ARGS_CURRENT_STATION = "ARGS_CURRENT_STATION";
    private static final String ARGS_TRAIN_NO = "ARGS_TRAIN_NO";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    private RFGTrainSchedule currentStation;
    private RFGTrain train;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGTrainScheduleDialog$Companion;", "", "()V", "ARGS_CURRENT_STATION", "", "ARGS_TRAIN_NO", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGTrainScheduleDialog;", "trainNo", "stationId", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGTrainScheduleDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGTrainScheduleDialog newInstance(String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "trainNo");
            Bundle bundle = new Bundle();
            bundle.putString(RFGTrainScheduleDialog.ARGS_TRAIN_NO, str);
            bundle.putInt(RFGTrainScheduleDialog.ARGS_CURRENT_STATION, i);
            RFGTrainScheduleDialog rFGTrainScheduleDialog = new RFGTrainScheduleDialog((DefaultConstructorMarker) null);
            rFGTrainScheduleDialog.setArguments(bundle);
            return rFGTrainScheduleDialog;
        }
    }

    private RFGTrainScheduleDialog() {
    }

    public /* synthetic */ RFGTrainScheduleDialog(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void extractArgs() {
        T t;
        boolean z;
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments.getString(ARGS_TRAIN_NO);
        if (string == null) {
            string = "";
        }
        Intrinsics.checkExpressionValueIsNotNull(string, "arguments!!.getString(ARGS_TRAIN_NO) ?: \"\"");
        RFGTrain rFGTrain = RFGTrainData.INSTANCE.getTrainMap().get(string);
        if (rFGTrain != null) {
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                Intrinsics.throwNpe();
            }
            int i = arguments2.getInt(ARGS_CURRENT_STATION, 0);
            Iterator<T> it = rFGTrain.getSchedules().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (((RFGTrainSchedule) t).getStationId() == i) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            this.train = rFGTrain;
            this.currentStation = (RFGTrainSchedule) t;
        }
    }

    private final void scrollToCurrentStation(ScrollView scrollView, LinearLayout linearLayout) {
        RFGTrainSchedule rFGTrainSchedule = this.currentStation;
        if (rFGTrainSchedule != null) {
            linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new RFGTrainScheduleDialog$scrollToCurrentStation$1(linearLayout, rFGTrainSchedule, scrollView));
        }
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v6 */
    @SuppressLint({"InflateParams"})
    private final View setUpView() {
        RFGTrainSchedule rFGTrainSchedule;
        String str;
        String str2;
        int i;
        Context context = getContext();
        View view = null;
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return null");
            RFGTrain rFGTrain = this.train;
            if (!(rFGTrain == null || (rFGTrainSchedule = this.currentStation) == null)) {
                LayoutInflater from = LayoutInflater.from(context);
                ? r7 = 0;
                view = from.inflate(R.layout.dialog_train_schedule, (ViewGroup) null, false);
                Resources resources = getResources();
                StringBuilder a = C0681a.m330a("train_line_");
                a.append(rFGTrain.getTrainType().getTypeValue());
                ((TextView) view.findViewById(R.id.viewTrainLine)).setBackgroundResource(resources.getIdentifier(a.toString(), "mipmap", context.getPackageName()));
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.viewScheduleList);
                int i2 = 0;
                for (RFGTrainSchedule next : rFGTrain.getSchedules()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    RFGTrainSchedule rFGTrainSchedule2 = next;
                    View inflate = from.inflate(R.layout.row_train_schedule, linearLayout, r7);
                    Intrinsics.checkExpressionValueIsNotNull(inflate, "rowView");
                    inflate.setTag(rFGTrainSchedule2);
                    TextView textView = (TextView) inflate.findViewById(R.id.viewStationName);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "viewStationName");
                    RFGStation findStation = RFGTrainData.INSTANCE.findStation(Integer.valueOf(rFGTrainSchedule2.getStationId()));
                    if (findStation == null || (str = findStation.getName()) == null) {
                        str = "";
                    }
                    textView.setText(str);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.viewSchedule);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "viewSchedule");
                    if (i2 == 0) {
                        Object[] objArr = new Object[1];
                        objArr[r7] = rFGTrainSchedule2.getDeparture();
                        str2 = getString(R.string.sanriku_train_info_departure, objArr);
                    } else if (i2 == rFGTrain.getSchedules().size() - 1) {
                        Object[] objArr2 = new Object[1];
                        objArr2[r7] = rFGTrainSchedule2.getArrival();
                        str2 = getString(R.string.sanriku_train_info_arrival, objArr2);
                    } else {
                        Object[] objArr3 = new Object[1];
                        objArr3[r7] = rFGTrainSchedule2.getArrival();
                        String string = getString(R.string.sanriku_train_info_arrival, objArr3);
                        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.sanri…rrival, schedule.arrival)");
                        Object[] objArr4 = new Object[1];
                        objArr4[r7] = rFGTrainSchedule2.getDeparture();
                        String string2 = getString(R.string.sanriku_train_info_departure, objArr4);
                        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.sanri…ture, schedule.departure)");
                        str2 = string + " / " + string2;
                    }
                    textView2.setText(str2);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.viewTrainPosition);
                    if (i2 == rFGTrain.getSchedules().size() - 1) {
                        Intrinsics.checkExpressionValueIsNotNull(imageView, "viewTrainPosition");
                        i = 8;
                    } else {
                        int stationId = rFGTrainSchedule.getStationId();
                        int stationId2 = rFGTrainSchedule2.getStationId();
                        Intrinsics.checkExpressionValueIsNotNull(imageView, "viewTrainPosition");
                        i = stationId == stationId2 ? 0 : 4;
                    }
                    imageView.setVisibility(i);
                    linearLayout.addView(inflate);
                    r7 = 0;
                    i2 = i3;
                }
                ScrollView scrollView = (ScrollView) view.findViewById(R.id.viewScroll);
                Intrinsics.checkExpressionValueIsNotNull(scrollView, "viewScroll");
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "viewScheduleList");
                scrollToCurrentStation(scrollView, linearLayout);
            }
        }
        return view;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        extractArgs();
        AlertDialog create = new AlertDialog.Builder(getContext()).setTitle(R.string.sanriku_train_info).setView(setUpView()).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).create();
        create.setCanceledOnTouchOutside(false);
        Intrinsics.checkExpressionValueIsNotNull(create, "AlertDialog.Builder(cont…side(false)\n            }");
        return create;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
