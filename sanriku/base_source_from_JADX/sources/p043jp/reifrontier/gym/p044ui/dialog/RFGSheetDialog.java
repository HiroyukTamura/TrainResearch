package p043jp.reifrontier.gym.p044ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGSheetDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "mListener", "Ljp/reifrontier/gym/ui/dialog/RFGSheetDialog$SheetDialogListener;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "SheetDialogListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGSheetDialog */
public final class RFGSheetDialog extends DialogFragment {
    public static final String ARG_COUNT = "count";
    public static final String ARG_MESSAGE = "message";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public SheetDialogListener mListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGSheetDialog$SheetDialogListener;", "", "onSelect", "", "type", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGSheetDialog$SheetDialogListener */
    public interface SheetDialogListener {
        void onSelect(int i);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGSheetDialog$Companion;", "", "()V", "ARG_COUNT", "", "ARG_MESSAGE", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGSheetDialog;", "message", "count", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGSheetDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return RFGSheetDialog.TAG;
        }

        public final RFGSheetDialog newInstance(String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            RFGSheetDialog rFGSheetDialog = new RFGSheetDialog();
            Bundle arguments = rFGSheetDialog.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
                arguments.putString("message", str);
                arguments.putInt(RFGSheetDialog.ARG_COUNT, i);
            }
            rFGSheetDialog.setArguments(arguments);
            return rFGSheetDialog;
        }
    }

    static {
        String simpleName = RFGSheetDialog.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "RFGSheetDialog::class.java.simpleName");
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
        if (context instanceof SheetDialogListener) {
            this.mListener = (SheetDialogListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement SheetDialogListener");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        int i = arguments.getInt(ARG_COUNT);
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments2.getString("message");
        View inflate = View.inflate(getContext(), R.layout.dialog_sheet, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_sheet_message);
        Intrinsics.checkExpressionValueIsNotNull(textView, "messageView");
        textView.setText(string);
        ((ConstraintLayout) inflate.findViewById(R.id.dialog_sheet_all)).setOnClickListener(new RFGSheetDialog$onCreateDialog$1(this));
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.dialog_sheet_30);
        if (i == 3) {
            constraintLayout.setOnClickListener(new RFGSheetDialog$onCreateDialog$2(this));
        } else {
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "d30");
            constraintLayout.setVisibility(8);
        }
        ((ConstraintLayout) inflate.findViewById(R.id.dialog_sheet_cancel)).setOnClickListener(new RFGSheetDialog$onCreateDialog$3(this));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        AlertDialog create = new AlertDialog.Builder(activity).setView(inflate).create();
        create.setCanceledOnTouchOutside(false);
        Intrinsics.checkExpressionValueIsNotNull(create, "AlertDialog.Builder(acti…side(false)\n            }");
        return create;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
