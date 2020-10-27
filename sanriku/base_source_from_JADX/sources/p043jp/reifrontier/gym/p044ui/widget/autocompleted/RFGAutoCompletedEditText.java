package p043jp.reifrontier.gym.p044ui.widget.autocompleted;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.p044ui.widget.autocompleted.RFGAutoCompletedAdapter;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\tH\u0002J\u0012\u0010-\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/H\u0017J\"\u00100\u001a\u00020\u001c2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017J\b\u00103\u001a\u00020\u001cH\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020\u001cH\u0002J\b\u00106\u001a\u00020\u001cH\u0002J\b\u00107\u001a\u00020\u001cH\u0002J\b\u00108\u001a\u00020\u001cH\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Rg\u0010\u0011\u001aO\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00069"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedEditText;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Ljp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedAdapter;", "getAdapter", "()Ljp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedAdapter;", "onDoneListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "inputValue", "", "Ljp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedAdapter$RFGHintData;", "searchResults", "", "isAlwaysShow", "", "getOnDoneListener", "()Lkotlin/jvm/functions/Function3;", "setOnDoneListener", "(Lkotlin/jvm/functions/Function3;)V", "value", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "cancel", "hideBackground", "hideDropDown", "hideKeyboard", "onEditorActionListener", "actionId", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setHintList", "hintList", "alwaysShowList", "setUpButtons", "setUpEdit", "setUpLayout", "setUpList", "showBackground", "showDropDown", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.autocompleted.RFGAutoCompletedEditText */
public final class RFGAutoCompletedEditText extends RelativeLayout {
    private HashMap _$_findViewCache;
    private final RFGAutoCompletedAdapter adapter;
    private Function3<? super String, ? super List<RFGAutoCompletedAdapter.RFGHintData>, ? super Boolean, Unit> onDoneListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGAutoCompletedEditText(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.adapter = new RFGAutoCompletedAdapter(context2, R.layout.row_autocompleted);
        View.inflate(getContext(), R.layout.view_autocompleted, this);
        setUpLayout();
        setUpEdit();
        setUpList();
        setUpButtons();
        hideBackground();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGAutoCompletedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.adapter = new RFGAutoCompletedAdapter(context2, R.layout.row_autocompleted);
        View.inflate(getContext(), R.layout.view_autocompleted, this);
        setUpLayout();
        setUpEdit();
        setUpList();
        setUpButtons();
        hideBackground();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGAutoCompletedEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.adapter = new RFGAutoCompletedAdapter(context2, R.layout.row_autocompleted);
        View.inflate(getContext(), R.layout.view_autocompleted, this);
        setUpLayout();
        setUpEdit();
        setUpList();
        setUpButtons();
        hideBackground();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public RFGAutoCompletedEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.adapter = new RFGAutoCompletedAdapter(context2, R.layout.row_autocompleted);
        View.inflate(getContext(), R.layout.view_autocompleted, this);
        setUpLayout();
        setUpEdit();
        setUpList();
        setUpButtons();
        hideBackground();
    }

    /* access modifiers changed from: private */
    public final void cancel() {
        hideKeyboard();
        hideDropDown();
    }

    private final void hideBackground() {
        View _$_findCachedViewById = _$_findCachedViewById(C2092R.C2094id.viewBackground);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "viewBackground");
        _$_findCachedViewById.setVisibility(8);
        ImageView imageView = (ImageView) _$_findCachedViewById(C2092R.C2094id.buttonCancel);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "buttonCancel");
        imageView.setVisibility(4);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C2092R.C2094id.buttonDelete);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "buttonDelete");
        imageView2.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public final void hideDropDown() {
        ListView listView = (ListView) _$_findCachedViewById(C2092R.C2094id.hintList);
        Intrinsics.checkExpressionValueIsNotNull(listView, "hintList");
        if (listView.getVisibility() != 8) {
            hideBackground();
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((ListView) _$_findCachedViewById(C2092R.C2094id.hintList), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.5f})});
            Intrinsics.checkExpressionValueIsNotNull(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…rtyAlpha, propertyScaleY)");
            ofPropertyValuesHolder.setDuration(100);
            ofPropertyValuesHolder.addListener(new RFGAutoCompletedEditText$hideDropDown$1(this));
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: private */
    public final void hideKeyboard() {
        ((EditText) _$_findCachedViewById(C2092R.C2094id.editText)).clearFocus();
        Context context = getContext();
        Object obj = null;
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        if (systemService instanceof InputMethodManager) {
            obj = systemService;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) obj;
        if (inputMethodManager != null) {
            EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.editText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "editText");
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: private */
    public final boolean onEditorActionListener(int i) {
        if (i == 6 || i == 5 || i == 3) {
            hideKeyboard();
            hideDropDown();
            Function3<? super String, ? super List<RFGAutoCompletedAdapter.RFGHintData>, ? super Boolean, Unit> function3 = this.onDoneListener;
            if (function3 != null) {
                EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.editText);
                Intrinsics.checkExpressionValueIsNotNull(editText, "editText");
                Unit invoke = function3.invoke(editText.getText().toString(), this.adapter.getAllDisplayHintData(), false);
            }
        }
        return false;
    }

    private final void setUpButtons() {
        ((ImageView) _$_findCachedViewById(C2092R.C2094id.buttonCancel)).setOnClickListener(new RFGAutoCompletedEditText$setUpButtons$1(this));
        ((ImageView) _$_findCachedViewById(C2092R.C2094id.buttonDelete)).setOnClickListener(new RFGAutoCompletedEditText$setUpButtons$2(this));
    }

    private final void setUpEdit() {
        ((EditText) _$_findCachedViewById(C2092R.C2094id.editText)).setOnEditorActionListener(new RFGAutoCompletedEditText$setUpEdit$1(this));
        ((EditText) _$_findCachedViewById(C2092R.C2094id.editText)).setOnTouchListener(new RFGAutoCompletedEditText$setUpEdit$2(this));
        ((EditText) _$_findCachedViewById(C2092R.C2094id.editText)).addTextChangedListener(new RFGAutoCompletedEditText$setUpEdit$3(this));
    }

    private final void setUpLayout() {
        setBackgroundColor(ContextCompat.getColor(getContext(), 17170445));
    }

    private final void setUpList() {
        ListView listView = (ListView) _$_findCachedViewById(C2092R.C2094id.hintList);
        Intrinsics.checkExpressionValueIsNotNull(listView, "hintList");
        listView.setVisibility(8);
        ListView listView2 = (ListView) _$_findCachedViewById(C2092R.C2094id.hintList);
        Intrinsics.checkExpressionValueIsNotNull(listView2, "hintList");
        listView2.setAdapter(this.adapter);
        ((ListView) _$_findCachedViewById(C2092R.C2094id.hintList)).setOnItemClickListener(new RFGAutoCompletedEditText$setUpList$1(this));
    }

    private final void showBackground() {
        View _$_findCachedViewById = _$_findCachedViewById(C2092R.C2094id.viewBackground);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "viewBackground");
        _$_findCachedViewById.setVisibility(0);
        ImageView imageView = (ImageView) _$_findCachedViewById(C2092R.C2094id.buttonCancel);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "buttonCancel");
        imageView.setVisibility(0);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C2092R.C2094id.buttonDelete);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "buttonDelete");
        imageView2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showDropDown() {
        ListView listView = (ListView) _$_findCachedViewById(C2092R.C2094id.hintList);
        Intrinsics.checkExpressionValueIsNotNull(listView, "hintList");
        if (listView.getVisibility() != 0) {
            showBackground();
            ListView listView2 = (ListView) _$_findCachedViewById(C2092R.C2094id.hintList);
            Intrinsics.checkExpressionValueIsNotNull(listView2, "hintList");
            listView2.setVisibility(0);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((ListView) _$_findCachedViewById(C2092R.C2094id.hintList), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.5f, 1.0f})});
            Intrinsics.checkExpressionValueIsNotNull(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…rtyAlpha, propertyScaleY)");
            ofPropertyValuesHolder.setDuration(100);
            ofPropertyValuesHolder.start();
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final RFGAutoCompletedAdapter getAdapter() {
        return this.adapter;
    }

    public final Function3<String, List<RFGAutoCompletedAdapter.RFGHintData>, Boolean, Unit> getOnDoneListener() {
        return this.onDoneListener;
    }

    public final String getText() {
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.editText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editText");
        return editText.getText().toString();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getActionMasked() == 0) {
            View _$_findCachedViewById = _$_findCachedViewById(C2092R.C2094id.viewBackground);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "viewBackground");
            if (_$_findCachedViewById.getVisibility() == 0) {
                cancel();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setHintList(List<RFGAutoCompletedAdapter.RFGHintData> list, List<String> list2) {
        Intrinsics.checkParameterIsNotNull(list, "hintList");
        Intrinsics.checkParameterIsNotNull(list2, "alwaysShowList");
        this.adapter.setListData(list, list2);
    }

    public final void setOnDoneListener(Function3<? super String, ? super List<RFGAutoCompletedAdapter.RFGHintData>, ? super Boolean, Unit> function3) {
        this.onDoneListener = function3;
    }

    public final void setText(String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        ((EditText) _$_findCachedViewById(C2092R.C2094id.editText)).setText(str);
        this.adapter.updateFilterText(str);
    }
}
