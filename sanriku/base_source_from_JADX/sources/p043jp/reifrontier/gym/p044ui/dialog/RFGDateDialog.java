package p043jp.reifrontier.gym.p044ui.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.google.android.material.bottomsheet.C1171c;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGDateDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "currentDay", "", "currentMonth", "currentYear", "mListener", "Ljp/reifrontier/gym/ui/dialog/RFGDateDialog$DateDialogListener;", "maxYear", "getMaxYear", "()I", "setMaxYear", "(I)V", "minYear", "getMinYear", "setMinYear", "onAttach", "", "context", "Landroid/content/Context;", "setupDialog", "dialog", "Landroid/app/Dialog;", "style", "Companion", "DateDialogListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGDateDialog */
public final class RFGDateDialog extends C1171c {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int currentDay = 1;
    /* access modifiers changed from: private */
    public int currentMonth = 1;
    /* access modifiers changed from: private */
    public int currentYear = 1990;
    /* access modifiers changed from: private */
    public DateDialogListener mListener;
    private int maxYear = Calendar.getInstance().get(1);
    private int minYear = 1910;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGDateDialog$DateDialogListener;", "", "onDateSelect", "", "year", "", "month", "day", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGDateDialog$DateDialogListener */
    public interface DateDialogListener {
        void onDateSelect(int i, int i2, int i3);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/dialog/RFGDateDialog$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newInstance", "Ljp/reifrontier/gym/ui/dialog/RFGDateDialog;", "year", "", "month", "day", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.dialog.RFGDateDialog$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return RFGDateDialog.TAG;
        }

        public final RFGDateDialog newInstance(int i, int i2, int i3) {
            RFGDateDialog rFGDateDialog = new RFGDateDialog();
            Bundle arguments = rFGDateDialog.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
                arguments.putInt("year", i);
                arguments.putInt("month", i2);
                arguments.putInt("day", i3);
            }
            rFGDateDialog.setArguments(arguments);
            return rFGDateDialog;
        }
    }

    static {
        String simpleName = RFGDateDialog.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "RFGDateDialog::class.java.simpleName");
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

    public final int getMaxYear() {
        return this.maxYear;
    }

    public final int getMinYear() {
        return this.minYear;
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof DateDialogListener) {
            this.mListener = (DateDialogListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement DateDialogListener");
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setMaxYear(int i) {
        this.maxYear = i;
    }

    public final void setMinYear(int i) {
        this.minYear = i;
    }

    @SuppressLint({"RestrictedApi"})
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        this.currentYear = arguments != null ? arguments.getInt("year") : Calendar.getInstance().get(1);
        Bundle arguments2 = getArguments();
        this.currentMonth = (arguments2 != null ? arguments2.getInt("month") : 0) + 1;
        Bundle arguments3 = getArguments();
        this.currentDay = arguments3 != null ? arguments3.getInt("day") : 1;
        View inflate = View.inflate(getActivity(), R.layout.dialog_date, (ViewGroup) null);
        dialog.setContentView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_date_picker_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleView");
        textView.setText("");
        ((TextView) inflate.findViewById(R.id.dialog_date_picker_cancel)).setOnClickListener(new RFGDateDialog$setupDialog$1(this));
        ((TextView) inflate.findViewById(R.id.dialog_date_picker_ok)).setOnClickListener(new RFGDateDialog$setupDialog$2(this));
        NumberPicker numberPicker = (NumberPicker) inflate.findViewById(R.id.year);
        NumberPicker numberPicker2 = (NumberPicker) inflate.findViewById(R.id.month);
        NumberPicker numberPicker3 = (NumberPicker) inflate.findViewById(R.id.day);
        Intrinsics.checkExpressionValueIsNotNull(numberPicker, "yearPicker");
        numberPicker.setMaxValue(this.maxYear);
        numberPicker.setMinValue(this.minYear);
        numberPicker.setValue(this.currentYear);
        numberPicker.setOnValueChangedListener(new RFGDateDialog$setupDialog$3(this, numberPicker3));
        Intrinsics.checkExpressionValueIsNotNull(numberPicker2, "monthPicker");
        numberPicker2.setMaxValue(12);
        numberPicker2.setMinValue(1);
        numberPicker2.setValue(this.currentMonth);
        numberPicker2.setOnValueChangedListener(new RFGDateDialog$setupDialog$4(this, numberPicker3));
        Calendar instance = Calendar.getInstance();
        instance.set(1, this.currentYear);
        instance.set(2, this.currentMonth);
        instance.set(5, 1);
        instance.add(5, -1);
        int i2 = instance.get(5);
        Intrinsics.checkExpressionValueIsNotNull(numberPicker3, "dayPicker");
        numberPicker3.setMaxValue(i2);
        numberPicker3.setMinValue(1);
        numberPicker3.setValue(this.currentDay);
        numberPicker3.setOnValueChangedListener(new RFGDateDialog$setupDialog$5(this));
    }
}
