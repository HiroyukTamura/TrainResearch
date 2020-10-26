// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.graphics.PorterDuff$Mode;
import android.os.Build$VERSION;

class ViewUtils
{
    static final ValueAnimatorCompat.Creator DEFAULT_ANIMATOR_CREATOR;
    
    static {
        DEFAULT_ANIMATOR_CREATOR = new ValueAnimatorCompat.Creator() {
            @Override
            public ValueAnimatorCompat createAnimator() {
                Impl impl;
                if (Build$VERSION.SDK_INT >= 12) {
                    impl = new ValueAnimatorCompatImplHoneycombMr1();
                }
                else {
                    impl = new ValueAnimatorCompatImplGingerbread();
                }
                return new ValueAnimatorCompat(impl);
            }
        };
    }
    
    static ValueAnimatorCompat createAnimator() {
        return ViewUtils.DEFAULT_ANIMATOR_CREATOR.createAnimator();
    }
    
    static boolean objectEquals(final Object o, final Object obj) {
        return o == obj || (o != null && o.equals(obj));
    }
    
    static PorterDuff$Mode parseTintMode(final int n, final PorterDuff$Mode porterDuff$Mode) {
        switch (n) {
            default: {
                return porterDuff$Mode;
            }
            case 3: {
                return PorterDuff$Mode.SRC_OVER;
            }
            case 5: {
                return PorterDuff$Mode.SRC_IN;
            }
            case 9: {
                return PorterDuff$Mode.SRC_ATOP;
            }
            case 14: {
                return PorterDuff$Mode.MULTIPLY;
            }
            case 15: {
                return PorterDuff$Mode.SCREEN;
            }
        }
    }
}
