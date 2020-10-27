package p043jp.reifrontier.gym.p044ui.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.google.android.material.bottomsheet.C1171c;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGBodyDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "currentBody", "", "currentDeci", "mListener", "Ljp/reifrontier/gym/ui/dialog/RFGBodyDialog$PickerDialogListener;", "pickerType", "Ljp/reifrontier/gym/RFGDef$BodyType;", "onAttach", "", "context", "Landroid/content/Context;", "setupDialog", "dialog", "Landroid/app/Dialog;", "style", "Companion", "PickerDialogListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGBodyDialog */
public final class RFGBodyDialog extends C1171c {
    public static final String ARG_TYPE = "type";
    public static final String ARG_VALUE = "value";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int currentBody = 170;
    /* access modifiers changed from: private */
    public int currentDeci;
    /* access modifiers changed from: private */
    public PickerDialogListener mListener;
    /* access modifiers changed from: private */
    public RFGDef.BodyType pickerType = RFGDef.BodyType.Height;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGBodyDialog$PickerDialogListener;", "", "onSelect", "", "type", "Ljp/reifrontier/gym/RFGDef$BodyType;", "value", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGBodyDialog$PickerDialogListener */
    public interface PickerDialogListener {
        void onSelect(RFGDef.BodyType bodyType, String str);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGBodyDialog$Companion;", "", "()V", "ARG_TYPE", "", "ARG_VALUE", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGBodyDialog;", "type", "Ljp/reifrontier/gym/RFGDef$BodyType;", "value", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGBodyDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return RFGBodyDialog.TAG;
        }

        public final RFGBodyDialog newInstance(RFGDef.BodyType bodyType, String str) {
            Intrinsics.checkParameterIsNotNull(bodyType, "type");
            Intrinsics.checkParameterIsNotNull(str, "value");
            RFGBodyDialog rFGBodyDialog = new RFGBodyDialog();
            Bundle arguments = rFGBodyDialog.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
                arguments.putInt("type", bodyType.ordinal());
                arguments.putString("value", str);
            }
            rFGBodyDialog.setArguments(arguments);
            return rFGBodyDialog;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGBodyDialog$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFGDef.BodyType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGDef.BodyType bodyType = RFGDef.BodyType.Height;
            iArr[0] = 1;
        }
    }

    static {
        String simpleName = RFGBodyDialog.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "RFGBodyDialog::class.java.simpleName");
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
        if (context instanceof PickerDialogListener) {
            this.mListener = (PickerDialogListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement PickerDialogListener");
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @SuppressLint({"RestrictedApi"})
    public void setupDialog(Dialog dialog, int i) {
        String str;
        int i2;
        Resources resources;
        int i3;
        String str2;
        String string;
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        this.pickerType = RFGDef.BodyType.values()[arguments.getInt("type")];
        Bundle arguments2 = getArguments();
        if (!(arguments2 == null || (string = arguments2.getString("value")) == null)) {
            Intrinsics.checkExpressionValueIsNotNull(string, "value");
            List split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{"."}, false, 0, 6, (Object) null);
            this.currentBody = Integer.parseInt((String) split$default.get(0));
            this.currentDeci = Integer.parseInt((String) split$default.get(1));
        }
        if (this.pickerType.ordinal() != 0) {
            str = getResources().getString(R.string.select_weight_title);
            Intrinsics.checkExpressionValueIsNotNull(str, "resources.getString(R.string.select_weight_title)");
            str2 = getResources().getString(R.string.kg);
            Intrinsics.checkExpressionValueIsNotNull(str2, "resources.getString(R.string.kg)");
            i3 = getResources().getInteger(R.integer.weight_max);
            resources = getResources();
            i2 = R.integer.weight_min;
        } else {
            str = getResources().getString(R.string.select_height_title);
            Intrinsics.checkExpressionValueIsNotNull(str, "resources.getString(R.string.select_height_title)");
            str2 = getResources().getString(R.string.cm);
            Intrinsics.checkExpressionValueIsNotNull(str2, "resources.getString(R.string.cm)");
            i3 = getResources().getInteger(R.integer.height_max);
            resources = getResources();
            i2 = R.integer.height_min;
        }
        int integer = resources.getInteger(i2);
        View inflate = View.inflate(getActivity(), R.layout.dialog_body, (ViewGroup) null);
        dialog.setContentView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_body_picker_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleView");
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.body_unit);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "unitView");
        textView2.setText(str2);
        ((TextView) inflate.findViewById(R.id.dialog_body_picker_cancel)).setOnClickListener(new RFGBodyDialog$setupDialog$2(this));
        ((TextView) inflate.findViewById(R.id.dialog_body_picker_ok)).setOnClickListener(new RFGBodyDialog$setupDialog$3(this, str2));
        NumberPicker numberPicker = (NumberPicker) inflate.findViewById(R.id.body_data);
        NumberPicker numberPicker2 = (NumberPicker) inflate.findViewById(R.id.deci_data);
        Intrinsics.checkExpressionValueIsNotNull(numberPicker, "bodyPicker");
        numberPicker.setMaxValue(i3);
        numberPicker.setMinValue(integer);
        numberPicker.setValue(this.currentBody);
        numberPicker.setOnValueChangedListener(new RFGBodyDialog$setupDialog$4(this));
        Intrinsics.checkExpressionValueIsNotNull(numberPicker2, "deciPicker");
        numberPicker2.setMaxValue(9);
        numberPicker2.setMinValue(0);
        numberPicker2.setValue(this.currentDeci);
        numberPicker2.setOnValueChangedListener(new RFGBodyDialog$setupDialog$5(this));
    }
}
