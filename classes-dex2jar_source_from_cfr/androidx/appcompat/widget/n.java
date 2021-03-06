/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapShader
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.ClipDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.util.AttributeSet
 *  android.widget.ProgressBar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.appcompat.widget.ao;
import androidx.core.graphics.drawable.c;

class n {
    private static final int[] a = new int[]{16843067, 16843068};
    private final ProgressBar b;
    private Bitmap c;

    n(ProgressBar progressBar) {
        this.b = progressBar;
    }

    private Drawable a(Drawable drawable2) {
        Drawable drawable3 = drawable2;
        if (drawable2 instanceof AnimationDrawable) {
            drawable2 = (AnimationDrawable)drawable2;
            int n2 = drawable2.getNumberOfFrames();
            drawable3 = new AnimationDrawable();
            drawable3.setOneShot(drawable2.isOneShot());
            for (int i2 = 0; i2 < n2; ++i2) {
                Drawable drawable4 = this.a(drawable2.getFrame(i2), true);
                drawable4.setLevel(10000);
                drawable3.addFrame(drawable4, drawable2.getDuration(i2));
            }
            drawable3.setLevel(10000);
        }
        return drawable3;
    }

    private Drawable a(Drawable drawable2, boolean bl2) {
        Drawable drawable3;
        if (drawable2 instanceof c) {
            c c2 = (c)drawable2;
            Drawable drawable4 = c2.a();
            drawable3 = drawable2;
            if (drawable4 != null) {
                c2.a(this.a(drawable4, bl2));
                return drawable2;
            }
        } else {
            if (drawable2 instanceof LayerDrawable) {
                int n2;
                drawable2 = (LayerDrawable)drawable2;
                int n3 = drawable2.getNumberOfLayers();
                LayerDrawable layerDrawable = new Drawable[n3];
                int n4 = 0;
                for (n2 = 0; n2 < n3; ++n2) {
                    int n5 = drawable2.getId(n2);
                    Drawable drawable5 = drawable2.getDrawable(n2);
                    bl2 = n5 == 16908301 || n5 == 16908303;
                    layerDrawable[n2] = this.a(drawable5, bl2);
                }
                layerDrawable = new LayerDrawable((Drawable[])layerDrawable);
                for (n2 = n4; n2 < n3; ++n2) {
                    layerDrawable.setId(n2, drawable2.getId(n2));
                }
                return layerDrawable;
            }
            drawable3 = drawable2;
            if (drawable2 instanceof BitmapDrawable) {
                drawable2 = (BitmapDrawable)drawable2;
                Bitmap bitmap = drawable2.getBitmap();
                if (this.c == null) {
                    this.c = bitmap;
                }
                drawable3 = new ShapeDrawable(this.b());
                bitmap = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                drawable3.getPaint().setShader((Shader)bitmap);
                drawable3.getPaint().setColorFilter(drawable2.getPaint().getColorFilter());
                if (bl2) {
                    return new ClipDrawable(drawable3, 3, 1);
                }
            }
        }
        return drawable3;
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap a() {
        return this.c;
    }

    void a(AttributeSet object, int n2) {
        object = ao.a(this.b.getContext(), (AttributeSet)object, a, n2, 0);
        Drawable drawable2 = ((ao)object).b(0);
        if (drawable2 != null) {
            this.b.setIndeterminateDrawable(this.a(drawable2));
        }
        if ((drawable2 = ((ao)object).b(1)) != null) {
            this.b.setProgressDrawable(this.a(drawable2, false));
        }
        ((ao)object).a();
    }
}

