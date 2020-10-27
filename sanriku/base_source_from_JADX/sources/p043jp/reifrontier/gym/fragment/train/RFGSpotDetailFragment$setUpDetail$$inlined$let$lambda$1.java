package p043jp.reifrontier.gym.fragment.train;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.Toolbar;
import com.squareup.picasso.C1471D;
import com.squareup.picasso.C1513u;
import kotlin.Metadata;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.train.spot.RFGContent;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0010¸\u0006\u0000"}, mo21739d2 = {"jp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$setUpDetail$1$2", "Lcom/squareup/picasso/Target;", "onBitmapFailed", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "from", "Lcom/squareup/picasso/Picasso$LoadedFrom;", "onPrepareLoad", "placeHolderDrawable", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$setUpDetail$$inlined$let$lambda$1 */
public final class RFGSpotDetailFragment$setUpDetail$$inlined$let$lambda$1 implements C1471D {
    final /* synthetic */ RFGContent $spotDetail$inlined;
    final /* synthetic */ RFGSpotDetailFragment this$0;

    RFGSpotDetailFragment$setUpDetail$$inlined$let$lambda$1(RFGSpotDetailFragment rFGSpotDetailFragment, RFGContent rFGContent) {
        this.this$0 = rFGSpotDetailFragment;
        this.$spotDetail$inlined = rFGContent;
    }

    public void onBitmapFailed(Exception exc, Drawable drawable) {
    }

    public void onBitmapLoaded(Bitmap bitmap, C1513u.C1519e eVar) {
        Toolbar toolbar = (Toolbar) this.this$0._$_findCachedViewById(C2092R.C2094id.fragmentToolbar);
        if (toolbar != null) {
            toolbar.setBackground(new BitmapDrawable(this.this$0.getResources(), bitmap));
        }
    }

    public void onPrepareLoad(Drawable drawable) {
    }
}
