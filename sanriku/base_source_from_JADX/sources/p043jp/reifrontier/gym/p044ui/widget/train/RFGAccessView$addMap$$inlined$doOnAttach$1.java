package p043jp.reifrontier.gym.p044ui.widget.train;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.maps.SupportMapFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, mo21739d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.train.RFGAccessView$addMap$$inlined$doOnAttach$1 */
public final class RFGAccessView$addMap$$inlined$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ double $lat$inlined;
    final /* synthetic */ double $lon$inlined;
    final /* synthetic */ View $this_doOnAttach;
    final /* synthetic */ RFGAccessView this$0;

    public RFGAccessView$addMap$$inlined$doOnAttach$1(View view, RFGAccessView rFGAccessView, double d, double d2) {
        this.$this_doOnAttach = view;
        this.this$0 = rFGAccessView;
        this.$lat$inlined = d;
        this.$lon$inlined = d2;
    }

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        this.this$0.mapFragment = supportMapFragment;
        FragmentTransaction beginTransaction = this.this$0.fragmentManager.beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
        beginTransaction.add((int) R.id.viewMapBase, (Fragment) supportMapFragment, "spotMapFragmentTag");
        beginTransaction.commit();
        supportMapFragment.getMapAsync(new RFGAccessView$addMap$$inlined$doOnAttach$1$lambda$1(this));
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
    }
}
