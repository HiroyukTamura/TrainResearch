/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ArgbEvaluator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.AnimatedVectorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.k.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.a.a.g;
import androidx.k.a.a.e;
import androidx.k.a.a.h;
import androidx.k.a.a.i;
import java.util.ArrayList;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;

public class c
extends h
implements androidx.k.a.a.b {
    ArrayList<Object> a = null;
    final Drawable.Callback b = new Drawable.Callback(){

        public void invalidateDrawable(Drawable drawable2) {
            c.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l2) {
            c.this.scheduleSelf(runnable, l2);
        }

        public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    };
    private a d;
    private Context e;
    private ArgbEvaluator f = null;
    private Animator.AnimatorListener g = null;

    c() {
        this(null, null, null);
    }

    private c(Context context) {
        this(context, null, null);
    }

    private c(Context context, a a2, Resources resources) {
        this.e = context;
        if (a2 != null) {
            this.d = a2;
            return;
        }
        this.d = new a(context, a2, this.b, resources);
    }

    public static c a(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        object = new c((Context)object);
        ((c)object).inflate(resources, xmlPullParser, attributeSet, theme);
        return object;
    }

    private void a(Animator animator) {
        Object object;
        if (animator instanceof AnimatorSet && (object = ((AnimatorSet)animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < object.size(); ++i2) {
                this.a((Animator)object.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator && ("fillColor".equals(object = (animator = (ObjectAnimator)animator).getPropertyName()) || "strokeColor".equals(object))) {
            if (this.f == null) {
                this.f = new ArgbEvaluator();
            }
            animator.setEvaluator((TypeEvaluator)this.f);
        }
    }

    private void a(String string2, Animator animator) {
        animator.setTarget(this.d.b.a(string2));
        if (Build.VERSION.SDK_INT < 21) {
            this.a(animator);
        }
        if (this.d.d == null) {
            this.d.d = new ArrayList();
            this.d.e = new androidx.c.a();
        }
        this.d.d.add(animator);
        this.d.e.put(animator, string2);
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.c != null) {
            return androidx.core.graphics.drawable.a.d(this.c);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
            return;
        }
        this.d.b.draw(canvas);
        if (this.d.c.isStarted()) {
            this.invalidateSelf();
        }
    }

    public int getAlpha() {
        if (this.c != null) {
            return androidx.core.graphics.drawable.a.c(this.c);
        }
        return this.d.b.getAlpha();
    }

    public int getChangingConfigurations() {
        if (this.c != null) {
            return this.c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.d.a;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.c != null && Build.VERSION.SDK_INT >= 24) {
            return new b(this.c.getConstantState());
        }
        return null;
    }

    public int getIntrinsicHeight() {
        if (this.c != null) {
            return this.c.getIntrinsicHeight();
        }
        return this.d.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.c != null) {
            return this.c.getIntrinsicWidth();
        }
        return this.d.b.getIntrinsicWidth();
    }

    public int getOpacity() {
        if (this.c != null) {
            return this.c.getOpacity();
        }
        return this.d.b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int n2 = xmlPullParser.getEventType();
        int n3 = xmlPullParser.getDepth();
        while (n2 != 1 && (xmlPullParser.getDepth() >= n3 + 1 || n2 != 3)) {
            block10 : {
                Object object;
                block12 : {
                    TypedArray typedArray;
                    block11 : {
                        if (n2 != 2) break block10;
                        object = xmlPullParser.getName();
                        if (!"animated-vector".equals(object)) break block11;
                        typedArray = g.a(resources, theme, attributeSet, androidx.k.a.a.a.e);
                        n2 = typedArray.getResourceId(0, 0);
                        object = typedArray;
                        if (n2 != 0) {
                            object = i.a(resources, n2, theme);
                            ((i)object).a(false);
                            object.setCallback(this.b);
                            if (this.d.b != null) {
                                this.d.b.setCallback(null);
                            }
                            this.d.b = object;
                            object = typedArray;
                        }
                        break block12;
                    }
                    if (!"target".equals(object)) break block10;
                    typedArray = resources.obtainAttributes(attributeSet, androidx.k.a.a.a.f);
                    String string2 = typedArray.getString(0);
                    n2 = typedArray.getResourceId(1, 0);
                    object = typedArray;
                    if (n2 != 0) {
                        if (this.e == null) {
                            typedArray.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        this.a(string2, e.a(this.e, n2));
                        object = typedArray;
                    }
                }
                object.recycle();
            }
            n2 = xmlPullParser.next();
        }
        this.d.a();
    }

    public boolean isAutoMirrored() {
        if (this.c != null) {
            return androidx.core.graphics.drawable.a.b(this.c);
        }
        return this.d.b.isAutoMirrored();
    }

    public boolean isRunning() {
        if (this.c != null) {
            return ((AnimatedVectorDrawable)this.c).isRunning();
        }
        return this.d.c.isRunning();
    }

    public boolean isStateful() {
        if (this.c != null) {
            return this.c.isStateful();
        }
        return this.d.b.isStateful();
    }

    public Drawable mutate() {
        if (this.c != null) {
            this.c.mutate();
        }
        return this;
    }

    @Override
    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
            return;
        }
        this.d.b.setBounds(rect);
    }

    @Override
    protected boolean onLevelChange(int n2) {
        if (this.c != null) {
            return this.c.setLevel(n2);
        }
        return this.d.b.setLevel(n2);
    }

    protected boolean onStateChange(int[] arrn) {
        if (this.c != null) {
            return this.c.setState(arrn);
        }
        return this.d.b.setState(arrn);
    }

    public void setAlpha(int n2) {
        if (this.c != null) {
            this.c.setAlpha(n2);
            return;
        }
        this.d.b.setAlpha(n2);
    }

    public void setAutoMirrored(boolean bl2) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, bl2);
            return;
        }
        this.d.b.setAutoMirrored(bl2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.c != null) {
            this.c.setColorFilter(colorFilter);
            return;
        }
        this.d.b.setColorFilter(colorFilter);
    }

    @Override
    public void setTint(int n2) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, n2);
            return;
        }
        this.d.b.setTint(n2);
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, colorStateList);
            return;
        }
        this.d.b.setTintList(colorStateList);
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, mode);
            return;
        }
        this.d.b.setTintMode(mode);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        if (this.c != null) {
            return this.c.setVisible(bl2, bl3);
        }
        this.d.b.setVisible(bl2, bl3);
        return super.setVisible(bl2, bl3);
    }

    public void start() {
        if (this.c != null) {
            ((AnimatedVectorDrawable)this.c).start();
            return;
        }
        if (this.d.c.isStarted()) {
            return;
        }
        this.d.c.start();
        this.invalidateSelf();
    }

    public void stop() {
        if (this.c != null) {
            ((AnimatedVectorDrawable)this.c).stop();
            return;
        }
        this.d.c.end();
    }

    private static class a
    extends Drawable.ConstantState {
        int a;
        i b;
        AnimatorSet c;
        ArrayList<Animator> d;
        androidx.c.a<Animator, String> e;

        /*
         * Enabled aggressive block sorting
         */
        public a(Context object, a a2, Drawable.Callback object2, Resources resources) {
            void var2_10;
            if (var2_10 != null) {
                this.a = var2_10.a;
                i i2 = var2_10.b;
                int n2 = 0;
                if (i2 != null) {
                    void var1_5;
                    void var3_11;
                    void var4_15;
                    Drawable.ConstantState constantState = var2_10.b.getConstantState();
                    if (var4_15 != null) {
                        Drawable drawable2 = constantState.newDrawable((Resources)var4_15);
                    } else {
                        Drawable drawable3 = constantState.newDrawable();
                    }
                    this.b = (i)var1_5;
                    this.b = (i)this.b.mutate();
                    this.b.setCallback((Drawable.Callback)var3_11);
                    this.b.setBounds(var2_10.b.getBounds());
                    this.b.a(false);
                }
                if (var2_10.d != null) {
                    int n3 = var2_10.d.size();
                    this.d = new ArrayList(n3);
                    this.e = new androidx.c.a(n3);
                    while (n2 < n3) {
                        Animator animator = var2_10.d.get(n2);
                        Animator animator2 = animator.clone();
                        String string2 = (String)var2_10.e.get((Object)animator);
                        animator2.setTarget(this.b.a(string2));
                        this.d.add(animator2);
                        this.e.put(animator2, string2);
                        ++n2;
                    }
                    this.a();
                }
            }
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    private static class b
    extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public b(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            c c2 = new c();
            c2.c = this.a.newDrawable();
            c2.c.setCallback(c2.b);
            return c2;
        }

        public Drawable newDrawable(Resources resources) {
            c c2 = new c();
            c2.c = this.a.newDrawable(resources);
            c2.c.setCallback(c2.b);
            return c2;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c c2 = new c();
            c2.c = this.a.newDrawable(resources, theme);
            c2.c.setCallback(c2.b);
            return c2;
        }
    }

}

