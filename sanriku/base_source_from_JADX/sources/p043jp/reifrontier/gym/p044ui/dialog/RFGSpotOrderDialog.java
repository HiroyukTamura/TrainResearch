package p043jp.reifrontier.gym.p044ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import com.google.android.material.bottomsheet.C1171c;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.gym.fragment.train.RFGSpotListFragment;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGSpotOrderType;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGSpotOrderDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "setupDialog", "Landroid/app/Dialog;", "style", "", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGSpotOrderDialog */
public final class RFGSpotOrderDialog extends C1171c {
    private static final String ARG_DEFAULT_ORDER = "default_order";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "RFGSpotOrderDialog";
    private HashMap _$_findViewCache;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGSpotOrderDialog$Companion;", "", "()V", "ARG_DEFAULT_ORDER", "", "TAG", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGSpotOrderDialog;", "orderType", "Ljp/reifrontier/gym/ui/viewModel/RFGSpotOrderType;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGSpotOrderDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGSpotOrderDialog newInstance(RFGSpotOrderType rFGSpotOrderType) {
            Intrinsics.checkParameterIsNotNull(rFGSpotOrderType, "orderType");
            RFGSpotOrderDialog rFGSpotOrderDialog = new RFGSpotOrderDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable(RFGSpotOrderDialog.ARG_DEFAULT_ORDER, rFGSpotOrderType);
            rFGSpotOrderDialog.setArguments(bundle);
            return rFGSpotOrderDialog;
        }
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
        C1126c.m1638c().mo21903a((Object) new RFGSpotListFragment.OnSelectedOrder(true, RFGSpotOrderType.NEAREST));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(ARG_DEFAULT_ORDER) : null;
        if (!(serializable instanceof RFGSpotOrderType)) {
            serializable = null;
        }
        RFGSpotOrderType rFGSpotOrderType = (RFGSpotOrderType) serializable;
        if (rFGSpotOrderType == null) {
            rFGSpotOrderType = RFGSpotOrderType.LATEST;
        }
        View inflate = View.inflate(getContext(), R.layout.dialog_spot_order, (ViewGroup) null);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.viewOrderLatest);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.viewOrderNearest);
        Intrinsics.checkExpressionValueIsNotNull(radioButton, "viewOrderLatest");
        boolean z = true;
        radioButton.setChecked(rFGSpotOrderType == RFGSpotOrderType.LATEST);
        radioButton.setOnClickListener(new RFGSpotOrderDialog$setupDialog$1(this));
        Intrinsics.checkExpressionValueIsNotNull(radioButton2, "viewOrderNearest");
        if (rFGSpotOrderType != RFGSpotOrderType.NEAREST) {
            z = false;
        }
        radioButton2.setChecked(z);
        radioButton2.setOnClickListener(new RFGSpotOrderDialog$setupDialog$2(this));
        dialog.setContentView(inflate);
    }
}
