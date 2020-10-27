package p043jp.reifrontier.gym.p044ui.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.C1171c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGCameraDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "mListener", "Ljp/reifrontier/gym/ui/dialog/RFGCameraDialog$CameraDialogListener;", "onAttach", "", "context", "Landroid/content/Context;", "setupDialog", "dialog", "Landroid/app/Dialog;", "style", "", "CameraDialogListener", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGCameraDialog */
public final class RFGCameraDialog extends C1171c {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public CameraDialogListener mListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGCameraDialog$CameraDialogListener;", "", "onCameraSelect", "", "type", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGCameraDialog$CameraDialogListener */
    public interface CameraDialogListener {
        void onCameraSelect(int i);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGCameraDialog$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGCameraDialog;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGCameraDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return RFGCameraDialog.TAG;
        }

        public final RFGCameraDialog newInstance() {
            RFGCameraDialog rFGCameraDialog = new RFGCameraDialog();
            Bundle arguments = rFGCameraDialog.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            rFGCameraDialog.setArguments(arguments);
            return rFGCameraDialog;
        }
    }

    static {
        String simpleName = RFGCameraDialog.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "RFGCameraDialog::class.java.simpleName");
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

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof CameraDialogListener) {
            this.mListener = (CameraDialogListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement CameraDialogListener");
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @SuppressLint({"RestrictedApi"})
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        super.setupDialog(dialog, i);
        View inflate = View.inflate(getContext(), R.layout.dialog_gender, (ViewGroup) null);
        dialog.setContentView(inflate);
        ((ImageView) inflate.findViewById(R.id.imageBottomGenderMale)).setImageResource(R.mipmap.camera);
        TextView textView = (TextView) inflate.findViewById(R.id.bottomGenderMale);
        Intrinsics.checkExpressionValueIsNotNull(textView, RFLAccountManager.DEFAULT_GENDER);
        textView.setText("カメラで撮影");
        textView.setOnClickListener(new RFGCameraDialog$setupDialog$1(this));
        ((ImageView) inflate.findViewById(R.id.imageBottomGenderFemale)).setImageResource(R.mipmap.gallery);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bottomGenderFeMale);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "female");
        textView2.setText("ギャラリーから選択");
        textView2.setOnClickListener(new RFGCameraDialog$setupDialog$2(this));
    }
}
