/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.widget.ImageView
 */
package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.core.widget.k;

public class e {
    public static ColorStateList a(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (imageView instanceof k) {
            return ((k)imageView).getSupportImageTintList();
        }
        return null;
    }

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                colorStateList = imageView.getDrawable();
                boolean bl2 = imageView.getImageTintList() != null && imageView.getImageTintMode() != null;
                if (colorStateList != null && bl2) {
                    if (colorStateList.isStateful()) {
                        colorStateList.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable((Drawable)colorStateList);
                    return;
                }
            }
        } else if (imageView instanceof k) {
            ((k)imageView).setSupportImageTintList(colorStateList);
        }
    }

    public static void a(ImageView imageView, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                mode = imageView.getDrawable();
                boolean bl2 = imageView.getImageTintList() != null && imageView.getImageTintMode() != null;
                if (mode != null && bl2) {
                    if (mode.isStateful()) {
                        mode.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable((Drawable)mode);
                    return;
                }
            }
        } else if (imageView instanceof k) {
            ((k)imageView).setSupportImageTintMode(mode);
        }
    }

    public static PorterDuff.Mode b(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (imageView instanceof k) {
            return ((k)imageView).getSupportImageTintMode();
        }
        return null;
    }
}

