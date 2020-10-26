/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Picture
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 *  android.view.ViewParent
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.j.ad;

class r {
    private static final boolean a;
    private static final boolean b;
    private static final boolean c;

    static {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        boolean bl3 = n2 >= 19;
        a = bl3;
        bl3 = Build.VERSION.SDK_INT >= 18;
        b = bl3;
        bl3 = bl2;
        if (Build.VERSION.SDK_INT >= 28) {
            bl3 = true;
        }
        c = bl3;
    }

    static Animator a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }

    private static Bitmap a(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        int n2;
        boolean bl2;
        boolean bl3;
        block10 : {
            block9 : {
                block8 : {
                    if (!a) break block8;
                    bl2 = view.isAttachedToWindow() ^ true;
                    if (viewGroup == null) break block9;
                    bl3 = viewGroup.isAttachedToWindow();
                    break block10;
                }
                bl2 = false;
            }
            bl3 = false;
        }
        boolean bl4 = b;
        Bitmap bitmap = null;
        if (bl4 && bl2) {
            if (!bl3) {
                return null;
            }
            viewGroup2 = (ViewGroup)view.getParent();
            n2 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        } else {
            viewGroup2 = null;
            n2 = 0;
        }
        int n3 = Math.round(rectF.width());
        int n4 = Math.round(rectF.height());
        Bitmap bitmap2 = bitmap;
        if (n3 > 0) {
            bitmap2 = bitmap;
            if (n4 > 0) {
                float f2 = Math.min(1.0f, 1048576.0f / (float)(n3 * n4));
                n3 = Math.round((float)n3 * f2);
                n4 = Math.round((float)n4 * f2);
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(f2, f2);
                if (c) {
                    rectF = new Picture();
                    bitmap2 = rectF.beginRecording(n3, n4);
                    bitmap2.concat(matrix);
                    view.draw((Canvas)bitmap2);
                    rectF.endRecording();
                    bitmap2 = Bitmap.createBitmap((Picture)rectF);
                } else {
                    bitmap2 = Bitmap.createBitmap((int)n3, (int)n4, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    rectF = new Canvas(bitmap2);
                    rectF.concat(matrix);
                    view.draw((Canvas)rectF);
                }
            }
        }
        if (b && bl2) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, n2);
        }
        return bitmap2;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        ad.a(view, matrix);
        ad.b((View)viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        matrix.mapRect(rectF);
        int n2 = Math.round(rectF.left);
        int n3 = Math.round(rectF.top);
        int n4 = Math.round(rectF.right);
        int n5 = Math.round(rectF.bottom);
        view2 = new ImageView(view.getContext());
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup = r.a(view, matrix, rectF, viewGroup);
        if (viewGroup != null) {
            view2.setImageBitmap((Bitmap)viewGroup);
        }
        view2.measure(View.MeasureSpec.makeMeasureSpec((int)(n4 - n2), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)(n5 - n3), (int)1073741824));
        view2.layout(n2, n3, n4, n5);
        return view2;
    }
}

