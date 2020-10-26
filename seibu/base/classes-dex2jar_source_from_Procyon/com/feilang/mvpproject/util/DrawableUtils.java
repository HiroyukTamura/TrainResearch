// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import android.support.v4.graphics.drawable.DrawableCompat;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.content.Context;
import android.view.View;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.Paint$Style;
import android.graphics.drawable.shapes.Shape;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.Drawable;

public class DrawableUtils
{
    private static Drawable getLayerDrawable(final int color, final int color2) {
        final RectShape rectShape = new RectShape();
        final ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 0, 0, 0);
        shapeDrawable.setShape((Shape)rectShape);
        shapeDrawable.getPaint().setStyle(Paint$Style.FILL);
        shapeDrawable.getPaint().setColor(color2);
        final ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.setPadding(23, 23, 23, 23);
        shapeDrawable2.setShape((Shape)rectShape);
        shapeDrawable2.getPaint().setStyle(Paint$Style.FILL);
        shapeDrawable2.getPaint().setColor(color);
        return (Drawable)new LayerDrawable(new Drawable[] { (Drawable)shapeDrawable2, (Drawable)shapeDrawable });
    }
    
    private static Drawable getLayerDrawable(final Drawable drawable, final int color) {
        final RectShape shape = new RectShape();
        final ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 0, 0, 0);
        shapeDrawable.setShape((Shape)shape);
        shapeDrawable.getPaint().setStyle(Paint$Style.FILL);
        shapeDrawable.getPaint().setColor(color);
        Drawable[] array;
        if (drawable != null) {
            array = new Drawable[] { drawable, (Drawable)shapeDrawable };
        }
        else {
            array = new Drawable[] { (Drawable)shapeDrawable };
        }
        return (Drawable)new LayerDrawable(array);
    }
    
    private static Drawable getStateListDrawable(final int n, final int n2) {
        final StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[] { 16842919 }, getLayerDrawable(n2, n));
        stateListDrawable.addState(new int[0], (Drawable)new ColorDrawable(n));
        return (Drawable)stateListDrawable;
    }
    
    private static Drawable getStateListDrawable(final View view, final int n) {
        final StateListDrawable stateListDrawable = new StateListDrawable();
        final Drawable background = view.getBackground();
        stateListDrawable.addState(new int[] { 16842919 }, getLayerDrawable(background, n));
        if (background != null) {
            stateListDrawable.addState(new int[0], background);
        }
        return (Drawable)stateListDrawable;
    }
    
    public static void setBackgroundDrawable(final View view, final int n, final int n2) {
        view.setBackground(getStateListDrawable(n, n2));
    }
    
    public static void setHighlightDrawable(final View view) {
        setHighlightDrawable(view, -2002081110);
    }
    
    public static void setHighlightDrawable(final View view, final int n) {
        view.setBackground(getStateListDrawable(view, n));
    }
    
    public static void setTintDrawable(final Context context, final ImageView imageView, final int n) {
        imageView.setImageDrawable(tintDrawable(context, imageView.getDrawable(), n));
    }
    
    public static void setTintDrawable(final ImageView imageView, final int n) {
        imageView.setImageDrawable(tintDrawable(imageView.getDrawable(), n));
    }
    
    public static Drawable tintDrawable(final Context context, final Drawable drawable, final int n) {
        return tintDrawable(drawable, ColorStateList.valueOf(ContextCompat.getColor(context, n)));
    }
    
    public static Drawable tintDrawable(final Drawable drawable, final int n) {
        return tintDrawable(drawable, ColorStateList.valueOf(n));
    }
    
    public static Drawable tintDrawable(Drawable wrap, final ColorStateList list) {
        wrap = DrawableCompat.wrap(wrap);
        DrawableCompat.setTintList(wrap, list);
        return wrap;
    }
}
