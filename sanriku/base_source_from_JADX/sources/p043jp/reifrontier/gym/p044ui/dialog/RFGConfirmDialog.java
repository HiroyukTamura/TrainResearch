package p043jp.reifrontier.gym.p044ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGConfirmDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "mListener", "Ljp/reifrontier/gym/ui/dialog/RFGConfirmDialog$ConfirmDialogListener;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setListener", "", "listener", "Companion", "ConfirmDialogListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGConfirmDialog */
public final class RFGConfirmDialog extends DialogFragment {
    public static final String ARG_CANCEL_TEXT = "cancel_text";
    public static final String ARG_MESSAGE = "message";
    public static final String ARG_OK_TEXT = "ok_text";
    public static final String ARG_TITLE = "title";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public ConfirmDialogListener mListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGConfirmDialog$ConfirmDialogListener;", "", "onDismiss", "", "cancel", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGConfirmDialog$ConfirmDialogListener */
    public interface ConfirmDialogListener {
        void onDismiss(boolean z);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGConfirmDialog$Companion;", "", "()V", "ARG_CANCEL_TEXT", "", "ARG_MESSAGE", "ARG_OK_TEXT", "ARG_TITLE", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGConfirmDialog;", "title", "message", "okText", "cancelText", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGConfirmDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RFGConfirmDialog newInstance$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            return companion.newInstance(str, str2, str3, str4);
        }

        public final String getTAG() {
            return RFGConfirmDialog.TAG;
        }

        public final RFGConfirmDialog newInstance(String str, String str2, String str3, String str4) {
            Intrinsics.checkParameterIsNotNull(str, "title");
            Intrinsics.checkParameterIsNotNull(str2, "message");
            RFGConfirmDialog rFGConfirmDialog = new RFGConfirmDialog();
            Bundle arguments = rFGConfirmDialog.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
                arguments.putString("title", str);
                arguments.putString("message", str2);
                arguments.putString("ok_text", str3);
                arguments.putString("cancel_text", str4);
            }
            rFGConfirmDialog.setArguments(arguments);
            return rFGConfirmDialog;
        }
    }

    static {
        String simpleName = RFGConfirmDialog.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "RFGConfirmDialog::class.java.simpleName");
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

    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments.getString("message");
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        String string2 = arguments2.getString("title");
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        String string3 = arguments3.getString("ok_text");
        if (string3 == null) {
            string3 = getString(17039370);
        }
        Intrinsics.checkExpressionValueIsNotNull(string3, "arguments!!.getString(AR…ring(android.R.string.ok)");
        Bundle arguments4 = getArguments();
        if (arguments4 == null) {
            Intrinsics.throwNpe();
        }
        String string4 = arguments4.getString("cancel_text");
        if (string4 == null) {
            string4 = getString(17039360);
        }
        Intrinsics.checkExpressionValueIsNotNull(string4, "arguments!!.getString(AR…(android.R.string.cancel)");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        AlertDialog create = new AlertDialog.Builder(activity).setTitle((CharSequence) string2).setMessage((CharSequence) string).setPositiveButton((CharSequence) string3, (DialogInterface.OnClickListener) new RFGConfirmDialog$onCreateDialog$1(this)).setNegativeButton((CharSequence) string4, (DialogInterface.OnClickListener) new RFGConfirmDialog$onCreateDialog$2(this)).create();
        create.setCanceledOnTouchOutside(false);
        Intrinsics.checkExpressionValueIsNotNull(create, "AlertDialog.Builder(acti…side(false)\n            }");
        return create;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setListener(ConfirmDialogListener confirmDialogListener) {
        Intrinsics.checkParameterIsNotNull(confirmDialogListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = confirmDialogListener;
    }
}
