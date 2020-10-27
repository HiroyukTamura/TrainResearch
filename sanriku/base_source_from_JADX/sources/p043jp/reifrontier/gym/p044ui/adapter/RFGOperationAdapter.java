package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGOperationAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "operationCount", "", "(Landroid/content/Context;I)V", "mContainer", "Landroid/view/ViewGroup;", "destroyItem", "", "container", "position", "object", "", "finishUpdate", "getCount", "getPageTitle", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGOperationAdapter */
public final class RFGOperationAdapter extends PagerAdapter {
    /* access modifiers changed from: private */
    public final Context context;
    private ViewGroup mContainer;
    private final int operationCount;

    public RFGOperationAdapter(Context context2, int i) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        this.operationCount = i;
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
        return 1;
    }

    public CharSequence getPageTitle(int i) {
        return "getPageTitle";
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "container");
        int i2 = 0;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.row_operation, viewGroup, false);
        if (inflate != null) {
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            View findViewById = viewGroup2.findViewById(R.id.delayed_feed_image);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "layout.findViewById<Imag…(R.id.delayed_feed_image)");
            ((ImageView) findViewById).setVisibility(this.operationCount == 0 ? 8 : 0);
            View findViewById2 = viewGroup2.findViewById(R.id.ontime_feed_image);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "layout.findViewById<Imag…>(R.id.ontime_feed_image)");
            ImageView imageView = (ImageView) findViewById2;
            if (this.operationCount != 0) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            ((ImageView) viewGroup2.findViewById(R.id.delayed_feed_image)).setOnClickListener(new RFGOperationAdapter$instantiateItem$1(this));
            viewGroup.addView(viewGroup2);
            return viewGroup2;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        Intrinsics.checkParameterIsNotNull(obj, "object");
        return view == obj;
    }
}
