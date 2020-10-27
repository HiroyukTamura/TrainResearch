package p043jp.reifrontier.gym.p044ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RadioButton;
import androidx.fragment.app.FragmentActivity;
import androidx.gridlayout.widget.GridLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.material.bottomsheet.C1171c;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.fragment.train.RFGSpotListFragment;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGSpotStationDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "addStation", "", "view", "Landroid/view/View;", "defaultStation", "Ljp/reifrontier/gym/data/train/RFGStation;", "createStationButton", "Landroid/widget/RadioButton;", "parent", "Landroidx/gridlayout/widget/GridLayout;", "name", "", "station", "cellWidth", "", "getDisplaySize", "Landroid/graphics/Point;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "setupDialog", "Landroid/app/Dialog;", "style", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGSpotStationDialog */
public final class RFGSpotStationDialog extends C1171c {
    private static final String ARG_DEFAULT_STATION_ID = "default_station_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "RFGSpotStationDialog";
    private HashMap _$_findViewCache;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGSpotStationDialog$Companion;", "", "()V", "ARG_DEFAULT_STATION_ID", "", "TAG", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGSpotStationDialog;", "stationId", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGSpotStationDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGSpotStationDialog newInstance(int i) {
            RFGSpotStationDialog rFGSpotStationDialog = new RFGSpotStationDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(RFGSpotStationDialog.ARG_DEFAULT_STATION_ID, i);
            rFGSpotStationDialog.setArguments(bundle);
            return rFGSpotStationDialog;
        }
    }

    private final void addStation(View view, RFGStation rFGStation) {
        int roundToInt = MathKt__MathJVMKt.roundToInt((((float) getDisplaySize().x) - (getResources().getDimension(R.dimen.margin_medium) * ((float) 2))) / 3.0f);
        GridLayout gridLayout = (GridLayout) view.findViewById(R.id.viewStationList);
        gridLayout.removeAllViews();
        Intrinsics.checkExpressionValueIsNotNull(gridLayout, "viewStationList");
        String string = getString(R.string.sanriku_spot_station_all);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.sanriku_spot_station_all)");
        RadioButton createStationButton = createStationButton(gridLayout, string, (RFGStation) null, roundToInt);
        gridLayout.addView(createStationButton);
        Set<Map.Entry<Integer, RFGStation>> entrySet = RFGTrainData.INSTANCE.getStationMap().entrySet();
        Intrinsics.checkExpressionValueIsNotNull(entrySet, "RFGTrainData.stationMap.entries");
        for (Map.Entry value : entrySet) {
            RFGStation rFGStation2 = (RFGStation) value.getValue();
            gridLayout.addView(createStationButton(gridLayout, rFGStation2.getName(), rFGStation2, roundToInt));
        }
        int childCount = gridLayout.getChildCount() % 3;
        if (childCount != 0) {
            while (childCount < 3) {
                gridLayout.addView(createStationButton(gridLayout, "", (RFGStation) null, roundToInt));
                childCount++;
            }
        }
        if (rFGStation == null) {
            createStationButton.setChecked(true);
            return;
        }
        int childCount2 = gridLayout.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            View childAt = gridLayout.getChildAt(i);
            if (!(childAt instanceof RadioButton)) {
                childAt = null;
            }
            RadioButton radioButton = (RadioButton) childAt;
            if (radioButton != null) {
                Object tag = radioButton.getTag();
                if (!(tag instanceof RFGStation)) {
                    tag = null;
                }
                RFGStation rFGStation3 = (RFGStation) tag;
                if (rFGStation3 != null && rFGStation3.getStationId() == rFGStation.getStationId()) {
                    radioButton.setChecked(true);
                }
            }
        }
    }

    private final RadioButton createStationButton(GridLayout gridLayout, String str, RFGStation rFGStation, int i) {
        RadioButton radioButton = new RadioButton(gridLayout.getContext());
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.columnSpec = GridLayout.spec(gridLayout.getChildCount() % 3);
        layoutParams.rowSpec = GridLayout.spec(gridLayout.getChildCount() / 3);
        layoutParams.width = i;
        layoutParams.height = radioButton.getResources().getDimensionPixelSize(R.dimen.sanriku_spot_item_height);
        radioButton.setLayoutParams(layoutParams);
        radioButton.setBackgroundResource(R.drawable.spot_grid_cell_background);
        radioButton.setTextColor(R.drawable.spot_radio_text);
        radioButton.setGravity(17);
        boolean z = false;
        radioButton.setTextSize(0, radioButton.getResources().getDimension(R.dimen.sanriku_spot_item));
        radioButton.setTypeface(Typeface.DEFAULT_BOLD);
        radioButton.setButtonDrawable((Drawable) null);
        radioButton.setText(str);
        radioButton.setTag(rFGStation);
        radioButton.setEnabled(str.length() > 0);
        if (str.length() > 0) {
            z = true;
        }
        if (z) {
            radioButton.setOnClickListener(new RFGSpotStationDialog$createStationButton$$inlined$apply$lambda$1(this, gridLayout, i, str, rFGStation));
        }
        return radioButton;
    }

    private final Point getDisplaySize() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return new Point(0, 0);
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity ?: return Point(0, 0)");
        WindowManager windowManager = activity.getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "activity.windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
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

    public void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkParameterIsNotNull(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        C1126c.m1638c().mo21903a((Object) new RFGSpotListFragment.OnSelectedStation(true, (RFGStation) null));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        RFGStation findStation = RFGTrainData.INSTANCE.findStation(arguments != null ? Integer.valueOf(arguments.getInt(ARG_DEFAULT_STATION_ID, -1)) : null);
        View inflate = View.inflate(getContext(), R.layout.dialog_spot_station, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, Promotion.ACTION_VIEW);
        addStation(inflate, findStation);
        dialog.setContentView(inflate);
    }
}
