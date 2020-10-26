/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 */
package com.google.android.material.d;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.d.c;

public interface d
extends c.a {
    public void a();

    public void b();

    public int getCircularRevealScrimColor();

    public d getRevealInfo();

    public void setCircularRevealOverlayDrawable(Drawable var1);

    public void setCircularRevealScrimColor(int var1);

    public void setRevealInfo(d var1);

    public static class a
    implements TypeEvaluator<d> {
        public static final TypeEvaluator<d> a = new a();
        private final d b = new d();

        public d a(float f2, d d2, d d3) {
            this.b.a(com.google.android.material.g.a.a(d2.a, d3.a, f2), com.google.android.material.g.a.a(d2.b, d3.b, f2), com.google.android.material.g.a.a(d2.c, d3.c, f2));
            return this.b;
        }

        public /* synthetic */ Object evaluate(float f2, Object object, Object object2) {
            return this.a(f2, (d)object, (d)object2);
        }
    }

    public static class b
    extends Property<d, d> {
        public static final Property<d, d> a = new b("circularReveal");

        private b(String string2) {
            super(d.class, string2);
        }

        public d a(d d2) {
            return d2.getRevealInfo();
        }

        public void a(d d2, d d3) {
            d2.setRevealInfo(d3);
        }

        public /* synthetic */ Object get(Object object) {
            return this.a((d)object);
        }

        public /* synthetic */ void set(Object object, Object object2) {
            this.a((d)object, (d)object2);
        }
    }

    public static class c
    extends Property<d, Integer> {
        public static final Property<d, Integer> a = new c("circularRevealScrimColor");

        private c(String string2) {
            super(Integer.class, string2);
        }

        public Integer a(d d2) {
            return d2.getCircularRevealScrimColor();
        }

        public void a(d d2, Integer n2) {
            d2.setCircularRevealScrimColor(n2);
        }

        public /* synthetic */ Object get(Object object) {
            return this.a((d)object);
        }

        public /* synthetic */ void set(Object object, Object object2) {
            this.a((d)object, (Integer)object2);
        }
    }

    public static class d {
        public float a;
        public float b;
        public float c;

        private d() {
        }

        public d(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
        }

        public d(d d2) {
            this(d2.a, d2.b, d2.c);
        }

        public void a(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
        }

        public void a(d d2) {
            this.a(d2.a, d2.b, d2.c);
        }

        public boolean a() {
            return this.c == Float.MAX_VALUE;
        }
    }

}

