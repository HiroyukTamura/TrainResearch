package p043jp.reifrontier.gym.p044ui.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.C1473F;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGRadiusTransform;", "Lcom/squareup/picasso/Transformation;", "radius", "", "(F)V", "getRadius", "()F", "key", "", "transform", "Landroid/graphics/Bitmap;", "source", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.RFGRadiusTransform */
public final class RFGRadiusTransform implements C1473F {
    private final float radius;

    public RFGRadiusTransform(float f) {
        this.radius = f;
    }

    public final float getRadius() {
        return this.radius;
    }

    public String key() {
        return "RFGRadiusTransform";
    }

    public Bitmap transform(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, FirebaseAnalytics.Param.SOURCE);
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        if (!Intrinsics.areEqual((Object) createBitmap, (Object) bitmap)) {
            bitmap.recycle();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f = this.radius;
        if (f == -1.0f) {
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "squaredBitmap");
            f = (float) (createBitmap.getHeight() / 2);
        }
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "squaredBitmap");
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) createBitmap.getWidth(), (float) createBitmap.getHeight()), f, f, paint);
        createBitmap.recycle();
        Intrinsics.checkExpressionValueIsNotNull(createBitmap2, "bitmap");
        return createBitmap2;
    }
}
