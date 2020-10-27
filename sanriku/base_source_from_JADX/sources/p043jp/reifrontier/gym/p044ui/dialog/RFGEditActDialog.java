package p043jp.reifrontier.gym.p044ui.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGEditActDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "mListener", "Ljp/reifrontier/gym/ui/dialog/RFGEditActDialog$EditActDialogListener;", "setListener", "", "listener", "setupDialog", "dialog", "Landroid/app/Dialog;", "style", "", "Companion", "EditActDialogListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGEditActDialog */
public final class RFGEditActDialog extends DialogFragment {
    public static final String ARG_TYPE = "type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public EditActDialogListener mListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGEditActDialog$Companion;", "", "()V", "ARG_TYPE", "", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGEditActDialog;", "type", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGEditActDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return RFGEditActDialog.TAG;
        }

        public final RFGEditActDialog newInstance(String str) {
            Intrinsics.checkParameterIsNotNull(str, "type");
            RFGEditActDialog rFGEditActDialog = new RFGEditActDialog();
            Bundle arguments = rFGEditActDialog.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
                arguments.putString("type", str);
            }
            rFGEditActDialog.setArguments(arguments);
            return rFGEditActDialog;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGEditActDialog$EditActDialogListener;", "", "finishEdit", "", "type", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGEditActDialog$EditActDialogListener */
    public interface EditActDialogListener {
        void finishEdit(String str);
    }

    static {
        String simpleName = RFGEditActDialog.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "RFGEditActDialog::class.java.simpleName");
        TAG = simpleName;
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

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setListener(EditActDialogListener editActDialogListener) {
        Intrinsics.checkParameterIsNotNull(editActDialogListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = editActDialogListener;
    }

    @SuppressLint({"RestrictedApi"})
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        super.setupDialog(dialog, i);
        Window window = dialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments.getString("type");
        View inflate = View.inflate(getActivity(), R.layout.dialog_edit, (ViewGroup) null);
        dialog.setContentView(inflate);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.edit_bicycle);
        constraintLayout.setOnClickListener(new RFGEditActDialog$setupDialog$1(this));
        if (Intrinsics.areEqual((Object) string, (Object) "bicycle") || Intrinsics.areEqual((Object) string, (Object) "sty")) {
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "bike");
            constraintLayout.setVisibility(8);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.edit_walk);
        constraintLayout2.setOnClickListener(new RFGEditActDialog$setupDialog$2(this));
        if (Intrinsics.areEqual((Object) string, (Object) "wlk")) {
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "walk");
            constraintLayout2.setVisibility(8);
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) inflate.findViewById(R.id.edit_transport);
        constraintLayout3.setOnClickListener(new RFGEditActDialog$setupDialog$3(this));
        if (Intrinsics.areEqual((Object) string, (Object) "trp") || Intrinsics.areEqual((Object) string, (Object) "sty")) {
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "trp");
            constraintLayout3.setVisibility(8);
        }
    }
}
