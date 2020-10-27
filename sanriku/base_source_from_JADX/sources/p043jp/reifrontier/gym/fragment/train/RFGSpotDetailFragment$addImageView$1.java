package p043jp.reifrontier.gym.fragment.train;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.squareup.picasso.C1489e;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1529y;
import kotlin.Metadata;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.train.spot.RFGContentImage;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo21739d2 = {"jp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$addImageView$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$addImageView$1 */
public final class RFGSpotDetailFragment$addImageView$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ RFGContentImage $image;
    final /* synthetic */ int $spotId;
    final /* synthetic */ ImageView $view;

    RFGSpotDetailFragment$addImageView$1(ImageView imageView, RFGContentImage rFGContentImage, int i) {
        this.$view = imageView;
        this.$image = rFGContentImage;
        this.$spotId = i;
    }

    public void onGlobalLayout() {
        this.$view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ViewGroup.LayoutParams layoutParams = this.$view.getLayoutParams();
        layoutParams.height = MathKt__MathJVMKt.roundToInt((((float) this.$view.getWidth()) / ((float) this.$image.getWidth())) * ((float) this.$image.getHeight()));
        this.$view.setLayoutParams(layoutParams);
        C1529y b = C1513u.m2068b().mo27251b(RFGRailroadClient.Companion.getINSTANCE().getImageUrl(this.$spotId, this.$image.getPath()));
        b.mo27284c();
        b.mo27281a(this.$view, (C1489e) null);
    }
}
