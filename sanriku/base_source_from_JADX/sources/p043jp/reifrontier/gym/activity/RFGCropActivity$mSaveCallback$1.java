package p043jp.reifrontier.gym.activity;

import android.content.Intent;
import android.net.Uri;
import com.isseiaoki.simplecropview.p052h.C1464d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo21739d2 = {"jp/reifrontier/gym/activity/RFGCropActivity$mSaveCallback$1", "Lcom/isseiaoki/simplecropview/callback/SaveCallback;", "onError", "", "e", "", "onSuccess", "uri", "Landroid/net/Uri;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGCropActivity$mSaveCallback$1 */
public final class RFGCropActivity$mSaveCallback$1 implements C1464d {
    final /* synthetic */ RFGCropActivity this$0;

    RFGCropActivity$mSaveCallback$1(RFGCropActivity rFGCropActivity) {
        this.this$0 = rFGCropActivity;
    }

    public void onError(Throwable th) {
        C1122a.m1599b("[Gym]::Error RF *** mSaveCallback onError ::" + th, new Object[0]);
    }

    public void onSuccess(Uri uri) {
        this.this$0.stopLoading();
        this.this$0.isLoading = false;
        Intent intent = new Intent();
        if (uri == null) {
            Intrinsics.throwNpe();
        }
        intent.putExtra("cropImage", uri.toString());
        this.this$0.setResult(-1, intent);
        this.this$0.finish();
    }
}
