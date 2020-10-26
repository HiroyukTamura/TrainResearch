/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.graphics;

import android.graphics.Typeface;
import androidx.core.graphics.f;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class g
extends f {
    @Override
    protected Typeface a(Object object) {
        try {
            Object object2 = Array.newInstance(this.a, 1);
            Array.set(object2, 0, object);
            object = (Typeface)this.g.invoke(null, object2, "sans-serif", -1, -1);
            return object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    @Override
    protected Method f(Class genericDeclaration) {
        genericDeclaration = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(genericDeclaration, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE);
        ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
        return genericDeclaration;
    }
}

