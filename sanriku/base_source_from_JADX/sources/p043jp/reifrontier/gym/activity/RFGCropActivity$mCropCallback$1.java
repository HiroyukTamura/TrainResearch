package p043jp.reifrontier.gym.activity;

import android.graphics.Bitmap;
import com.isseiaoki.simplecropview.C1456f;
import com.isseiaoki.simplecropview.CropImageView;
import com.isseiaoki.simplecropview.p052h.C1462b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo21739d2 = {"jp/reifrontier/gym/activity/RFGCropActivity$mCropCallback$1", "Lcom/isseiaoki/simplecropview/callback/CropCallback;", "onError", "", "e", "", "onSuccess", "cropped", "Landroid/graphics/Bitmap;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGCropActivity$mCropCallback$1 */
public final class RFGCropActivity$mCropCallback$1 implements C1462b {
    final /* synthetic */ RFGCropActivity this$0;

    RFGCropActivity$mCropCallback$1(RFGCropActivity rFGCropActivity) {
        this.this$0 = rFGCropActivity;
    }

    public void onError(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
    }

    public void onSuccess(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "cropped");
        CropImageView cropImageView = (CropImageView) this.this$0._$_findCachedViewById(C2092R.C2094id.cropImageView);
        if (cropImageView != null) {
            C1456f fVar = new C1456f(cropImageView, bitmap);
            fVar.mo27159a(this.this$0.mCompressFormat);
            fVar.mo27160a(this.this$0.createSaveUri(), this.this$0.mSaveCallback);
            return;
        }
        throw null;
    }
}
