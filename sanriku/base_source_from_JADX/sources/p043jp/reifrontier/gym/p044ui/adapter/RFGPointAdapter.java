package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.api.RFGPanelData;
import p043jp.reifrontier.gym.p044ui.widget.RFGProgressBar;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\"B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\rR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGPointAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "list", "", "Ljp/reifrontier/gym/domain/api/RFGPanelData;", "(Landroid/content/Context;Ljava/util/List;)V", "mContainer", "Landroid/view/ViewGroup;", "mContext", "mList", "mListener", "Ljp/reifrontier/gym/ui/adapter/RFGPointAdapter$OnPointListener;", "destroyItem", "", "container", "position", "", "object", "", "finishUpdate", "getCount", "getPageTitle", "", "getPageWidth", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "setListener", "listener", "OnPointListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGPointAdapter */
public final class RFGPointAdapter extends PagerAdapter {
    private ViewGroup mContainer;
    private final Context mContext;
    private final List<RFGPanelData> mList;
    /* access modifiers changed from: private */
    public OnPointListener mListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGPointAdapter$OnPointListener;", "", "didSelectPoint", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGPointAdapter$OnPointListener */
    public interface OnPointListener {
        void didSelectPoint();
    }

    public RFGPointAdapter(Context context, List<? extends RFGPanelData> list) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.mContext = context;
        this.mList = list;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "container");
        Intrinsics.checkParameterIsNotNull(obj, "object");
        viewGroup.removeView((View) obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "container");
        this.mContainer = viewGroup;
    }

    public int getCount() {
        return this.mList.size();
    }

    public CharSequence getPageTitle(int i) {
        return "getPageTitle";
    }

    public float getPageWidth(int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = this.mContext.getSystemService("window");
        if (systemService != null) {
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            float f = 347.5f;
            if (i == 0) {
                f = 341.0f;
            }
            return (f * displayMetrics.density) / ((float) displayMetrics.widthPixels);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2;
        float f;
        ViewGroup viewGroup3 = viewGroup;
        Intrinsics.checkParameterIsNotNull(viewGroup3, "container");
        RFGPanelData rFGPanelData = this.mList.get(i);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.row_point, viewGroup3, false);
        if (inflate != null) {
            ViewGroup viewGroup4 = (ViewGroup) inflate;
            RFGProgressBar rFGProgressBar = (RFGProgressBar) viewGroup4.findViewById(R.id.progress);
            TextView textView = (TextView) viewGroup4.findViewById(R.id.feedPointDate);
            TextView textView2 = (TextView) viewGroup4.findViewById(R.id.feedPointDateYear);
            TextView textView3 = (TextView) viewGroup4.findViewById(R.id.feedPointPoint);
            TextView textView4 = (TextView) viewGroup4.findViewById(R.id.feedPointStep);
            TextView textView5 = (TextView) viewGroup4.findViewById(R.id.feedPointTrain);
            TextView textView6 = (TextView) viewGroup4.findViewById(R.id.feedPointOther);
            TextView textView7 = (TextView) viewGroup4.findViewById(R.id.feedPointStepPoint);
            TextView textView8 = (TextView) viewGroup4.findViewById(R.id.feedPointTrainPoint);
            if (Intrinsics.areEqual((Object) rFGPanelData.getType(), (Object) "total")) {
                Intrinsics.checkExpressionValueIsNotNull(textView, "mDate");
                textView.setText("累計と平均");
                Intrinsics.checkExpressionValueIsNotNull(textView2, "mDateYear");
                String format = String.format("%s日目", Arrays.copyOf(new Object[]{Integer.valueOf(rFGPanelData.getDayNumber())}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
                textView2.setText(format);
                f = 5000.0f;
                viewGroup2 = viewGroup4;
            } else {
                if (rFGPanelData.getDate().length() > 0) {
                    viewGroup2 = viewGroup4;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    Date parse = simpleDateFormat.parse(rFGPanelData.getDate());
                    Intrinsics.checkExpressionValueIsNotNull(parse, "dateFormat.parse(summaryHistory.date)");
                    List split$default = StringsKt__StringsKt.split$default((CharSequence) RFGUtilsKt.formaaat11(parse, "yyyy年M月d日", "Asia/Tokyo"), new String[]{"年"}, false, 0, 6, (Object) null);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "mDate");
                    textView.setText((CharSequence) split$default.get(1));
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "mDateYear");
                    textView2.setText((CharSequence) split$default.get(0));
                } else {
                    viewGroup2 = viewGroup4;
                }
                f = 16.0f;
            }
            Intrinsics.checkExpressionValueIsNotNull(textView3, "mPoint");
            textView3.setText(rFGPanelData.point());
            Intrinsics.checkExpressionValueIsNotNull(textView4, "mStep");
            textView4.setText(rFGPanelData.stepText());
            Intrinsics.checkExpressionValueIsNotNull(textView7, "mStepPoint");
            textView7.setText(rFGPanelData.walkPointText());
            Intrinsics.checkExpressionValueIsNotNull(textView5, "mTrain");
            textView5.setText(rFGPanelData.train());
            Intrinsics.checkExpressionValueIsNotNull(textView8, "mTrainPoint");
            textView8.setText(rFGPanelData.trainPointText());
            Intrinsics.checkExpressionValueIsNotNull(textView6, "mOther");
            textView6.setText(rFGPanelData.otherPointText());
            rFGProgressBar.setStrokeWidth(40.0f);
            rFGProgressBar.setCircle((rFGPanelData.walkPointF() / f) * 100.0f, (rFGPanelData.trainPointF() / f) * 100.0f, (rFGPanelData.pointF() / f) * 100.0f);
            ViewGroup viewGroup5 = viewGroup2;
            viewGroup5.setOnClickListener(new RFGPointAdapter$instantiateItem$1(this));
            viewGroup5.setTag("myView" + i);
            viewGroup.addView(viewGroup5);
            return viewGroup5;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        Intrinsics.checkParameterIsNotNull(obj, "object");
        return view == obj;
    }

    public final void setListener(OnPointListener onPointListener) {
        Intrinsics.checkParameterIsNotNull(onPointListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = onPointListener;
    }
}
