package p043jp.reifrontier.gym.p044ui.widget.train;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import com.google.android.gms.fitness.data.WorkoutExercises;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.train.spot.RFGContentInfo;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/train/RFGInfoListView;", "Landroid/widget/TableLayout;", "context", "Landroid/content/Context;", "infoList", "", "Ljp/reifrontier/gym/data/train/spot/RFGContentInfo;", "(Landroid/content/Context;Ljava/util/List;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "onClickTel", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "tel", "", "getOnClickTel", "()Lkotlin/jvm/functions/Function1;", "setOnClickTel", "(Lkotlin/jvm/functions/Function1;)V", "telTitle", "addInfo", "title", "value", "setUp", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@SuppressLint({"ViewConstructor"})
/* renamed from: jp.reifrontier.gym.ui.widget.train.RFGInfoListView */
public final class RFGInfoListView extends TableLayout {
    private HashMap _$_findViewCache;
    private final List<RFGContentInfo> infoList;
    private final LayoutInflater layoutInflater;
    private Function1<? super String, Unit> onClickTel;
    private final String telTitle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGInfoListView(Context context, List<RFGContentInfo> list) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(list, "infoList");
        this.infoList = list;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(context)");
        this.layoutInflater = from;
        String string = context.getString(R.string.sanriku_tel);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.string.sanriku_tel)");
        this.telTitle = string;
        View.inflate(context, R.layout.view_table, this);
        setUp();
    }

    private final void addInfo(String str, String str2) {
        View inflate = this.layoutInflater.inflate(R.layout.row_spot_text, (TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout), false);
        View findViewById = inflate.findViewById(R.id.viewTitle);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "row.findViewById<TextView>(R.id.viewTitle)");
        ((TextView) findViewById).setText(str);
        if (StringsKt__StringsJVMKt.startsWith$default(str, this.telTitle, false, 2, (Object) null)) {
            TextView textView = (TextView) inflate.findViewById(R.id.viewValue);
            Intrinsics.checkExpressionValueIsNotNull(textView, "valueView");
            textView.setText(HtmlCompat.fromHtml("<u><font color='#10579B'>" + str2 + "</font></u>", 63));
            textView.setOnClickListener(new RFGInfoListView$addInfo$1(this, str2));
        } else {
            View findViewById2 = inflate.findViewById(R.id.viewValue);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "row.findViewById<TextView>(R.id.viewValue)");
            ((TextView) findViewById2).setText(str2);
        }
        Intrinsics.checkExpressionValueIsNotNull(inflate, WorkoutExercises.ROW);
        ((TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout)).addView(inflate, inflate.getLayoutParams());
    }

    private final void setUp() {
        ((TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout)).removeAllViews();
        for (RFGContentInfo rFGContentInfo : this.infoList) {
            String title = rFGContentInfo.getTitle();
            String str = "";
            if (title == null) {
                title = str;
            }
            String contents = rFGContentInfo.getContents();
            if (contents != null) {
                str = contents;
            }
            addInfo(title, str);
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

    public final Function1<String, Unit> getOnClickTel() {
        return this.onClickTel;
    }

    public final void setOnClickTel(Function1<? super String, Unit> function1) {
        this.onClickTel = function1;
    }
}
