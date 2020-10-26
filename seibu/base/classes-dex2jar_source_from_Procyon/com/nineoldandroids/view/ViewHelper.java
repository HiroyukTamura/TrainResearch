// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.view;

import com.nineoldandroids.view.animation.AnimatorProxy;
import android.view.View;

public final class ViewHelper
{
    private ViewHelper() {
    }
    
    public static float getAlpha(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getAlpha();
        }
        return Honeycomb.getAlpha(view);
    }
    
    public static float getPivotX(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getPivotX();
        }
        return Honeycomb.getPivotX(view);
    }
    
    public static float getPivotY(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getPivotY();
        }
        return Honeycomb.getPivotY(view);
    }
    
    public static float getRotation(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotation();
        }
        return Honeycomb.getRotation(view);
    }
    
    public static float getRotationX(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationX();
        }
        return Honeycomb.getRotationX(view);
    }
    
    public static float getRotationY(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationY();
        }
        return Honeycomb.getRotationY(view);
    }
    
    public static float getScaleX(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScaleX();
        }
        return Honeycomb.getScaleX(view);
    }
    
    public static float getScaleY(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScaleY();
        }
        return Honeycomb.getScaleY(view);
    }
    
    public static float getScrollX(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return (float)AnimatorProxy.wrap(view).getScrollX();
        }
        return Honeycomb.getScrollX(view);
    }
    
    public static float getScrollY(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return (float)AnimatorProxy.wrap(view).getScrollY();
        }
        return Honeycomb.getScrollY(view);
    }
    
    public static float getTranslationX(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationX();
        }
        return Honeycomb.getTranslationX(view);
    }
    
    public static float getTranslationY(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationY();
        }
        return Honeycomb.getTranslationY(view);
    }
    
    public static float getX(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getX();
        }
        return Honeycomb.getX(view);
    }
    
    public static float getY(final View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getY();
        }
        return Honeycomb.getY(view);
    }
    
    public static void setAlpha(final View view, final float alpha) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(alpha);
            return;
        }
        Honeycomb.setAlpha(view, alpha);
    }
    
    public static void setPivotX(final View view, final float pivotX) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotX(pivotX);
            return;
        }
        Honeycomb.setPivotX(view, pivotX);
    }
    
    public static void setPivotY(final View view, final float pivotY) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(pivotY);
            return;
        }
        Honeycomb.setPivotY(view, pivotY);
    }
    
    public static void setRotation(final View view, final float rotation) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(rotation);
            return;
        }
        Honeycomb.setRotation(view, rotation);
    }
    
    public static void setRotationX(final View view, final float rotationX) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(rotationX);
            return;
        }
        Honeycomb.setRotationX(view, rotationX);
    }
    
    public static void setRotationY(final View view, final float rotationY) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(rotationY);
            return;
        }
        Honeycomb.setRotationY(view, rotationY);
    }
    
    public static void setScaleX(final View view, final float scaleX) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(scaleX);
            return;
        }
        Honeycomb.setScaleX(view, scaleX);
    }
    
    public static void setScaleY(final View view, final float scaleY) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(scaleY);
            return;
        }
        Honeycomb.setScaleY(view, scaleY);
    }
    
    public static void setScrollX(final View view, final int scrollX) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(scrollX);
            return;
        }
        Honeycomb.setScrollX(view, scrollX);
    }
    
    public static void setScrollY(final View view, final int scrollY) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(scrollY);
            return;
        }
        Honeycomb.setScrollY(view, scrollY);
    }
    
    public static void setTranslationX(final View view, final float translationX) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(translationX);
            return;
        }
        Honeycomb.setTranslationX(view, translationX);
    }
    
    public static void setTranslationY(final View view, final float translationY) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(translationY);
            return;
        }
        Honeycomb.setTranslationY(view, translationY);
    }
    
    public static void setX(final View view, final float x) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(x);
            return;
        }
        Honeycomb.setX(view, x);
    }
    
    public static void setY(final View view, final float y) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(y);
            return;
        }
        Honeycomb.setY(view, y);
    }
    
    private static final class Honeycomb
    {
        static float getAlpha(final View view) {
            return view.getAlpha();
        }
        
        static float getPivotX(final View view) {
            return view.getPivotX();
        }
        
        static float getPivotY(final View view) {
            return view.getPivotY();
        }
        
        static float getRotation(final View view) {
            return view.getRotation();
        }
        
        static float getRotationX(final View view) {
            return view.getRotationX();
        }
        
        static float getRotationY(final View view) {
            return view.getRotationY();
        }
        
        static float getScaleX(final View view) {
            return view.getScaleX();
        }
        
        static float getScaleY(final View view) {
            return view.getScaleY();
        }
        
        static float getScrollX(final View view) {
            return (float)view.getScrollX();
        }
        
        static float getScrollY(final View view) {
            return (float)view.getScrollY();
        }
        
        static float getTranslationX(final View view) {
            return view.getTranslationX();
        }
        
        static float getTranslationY(final View view) {
            return view.getTranslationY();
        }
        
        static float getX(final View view) {
            return view.getX();
        }
        
        static float getY(final View view) {
            return view.getY();
        }
        
        static void setAlpha(final View view, final float alpha) {
            view.setAlpha(alpha);
        }
        
        static void setPivotX(final View view, final float pivotX) {
            view.setPivotX(pivotX);
        }
        
        static void setPivotY(final View view, final float pivotY) {
            view.setPivotY(pivotY);
        }
        
        static void setRotation(final View view, final float rotation) {
            view.setRotation(rotation);
        }
        
        static void setRotationX(final View view, final float rotationX) {
            view.setRotationX(rotationX);
        }
        
        static void setRotationY(final View view, final float rotationY) {
            view.setRotationY(rotationY);
        }
        
        static void setScaleX(final View view, final float scaleX) {
            view.setScaleX(scaleX);
        }
        
        static void setScaleY(final View view, final float scaleY) {
            view.setScaleY(scaleY);
        }
        
        static void setScrollX(final View view, final int scrollX) {
            view.setScrollX(scrollX);
        }
        
        static void setScrollY(final View view, final int scrollY) {
            view.setScrollY(scrollY);
        }
        
        static void setTranslationX(final View view, final float translationX) {
            view.setTranslationX(translationX);
        }
        
        static void setTranslationY(final View view, final float translationY) {
            view.setTranslationY(translationY);
        }
        
        static void setX(final View view, final float x) {
            view.setX(x);
        }
        
        static void setY(final View view, final float y) {
            view.setY(y);
        }
    }
}
