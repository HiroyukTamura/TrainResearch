/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.PointF
 *  android.util.Property
 */
package androidx.j;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class h<T>
extends Property<T, Float> {
    private final Property<T, PointF> a;
    private final PathMeasure b;
    private final float c;
    private final float[] d = new float[2];
    private final PointF e = new PointF();
    private float f;

    h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.a = property;
        this.b = new PathMeasure(path, false);
        this.c = this.b.getLength();
    }

    public Float a(T t2) {
        return Float.valueOf(this.f);
    }

    public void a(T t2, Float f2) {
        this.f = f2.floatValue();
        this.b.getPosTan(this.c * f2.floatValue(), this.d, null);
        this.e.x = this.d[0];
        this.e.y = this.d[1];
        this.a.set(t2, (Object)this.e);
    }

    public /* synthetic */ Object get(Object object) {
        return this.a(object);
    }

    public /* synthetic */ void set(Object object, Object object2) {
        this.a(object, (Float)object2);
    }
}

