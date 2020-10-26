/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.c.g;
import androidx.core.a.a.c;
import androidx.core.e.b;
import androidx.core.graphics.h;
import androidx.core.graphics.i;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class e
extends h {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;

    static {
        GenericDeclaration genericDeclaration;
        GenericDeclaration genericDeclaration2;
        Class<?> class_;
        GenericDeclaration genericDeclaration3;
        Object var4 = null;
        try {
            class_ = Class.forName("android.graphics.FontFamily");
            genericDeclaration2 = class_.getConstructor(new Class[0]);
            genericDeclaration = class_.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            genericDeclaration3 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(class_, 1).getClass());
        }
        catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
            Log.e((String)"TypefaceCompatApi24Impl", (String)reflectiveOperationException.getClass().getName(), (Throwable)reflectiveOperationException);
            class_ = null;
            genericDeclaration = genericDeclaration2 = class_;
            genericDeclaration3 = genericDeclaration2;
            genericDeclaration2 = var4;
        }
        b = genericDeclaration2;
        a = class_;
        c = genericDeclaration;
        d = genericDeclaration3;
    }

    e() {
    }

    private static Typeface a(Object object) {
        try {
            Object object2 = Array.newInstance(a, 1);
            Array.set(object2, 0, object);
            object = (Typeface)d.invoke(null, object2);
            return object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    public static boolean a() {
        if (c == null) {
            Log.w((String)"TypefaceCompatApi24Impl", (String)"Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static boolean a(Object object, ByteBuffer byteBuffer, int n2, int n3, boolean bl2) {
        try {
            bl2 = (Boolean)c.invoke(object, byteBuffer, n2, null, n3, bl2);
            return bl2;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    private static Object b() {
        try {
            Object t2 = b.newInstance(new Object[0]);
            return t2;
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    @Override
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.b[] arrb, int n2) {
        Object object = e.b();
        g<Uri, ByteBuffer> g2 = new g<Uri, ByteBuffer>();
        for (b.b b2 : arrb) {
            ByteBuffer byteBuffer;
            Uri uri = b2.a();
            ByteBuffer byteBuffer2 = byteBuffer = (ByteBuffer)g2.get((Object)uri);
            if (byteBuffer == null) {
                byteBuffer2 = i.a(context, cancellationSignal, uri);
                g2.put(uri, byteBuffer2);
            }
            if (e.a(object, byteBuffer2, b2.b(), b2.c(), b2.d())) continue;
            return null;
        }
        return Typeface.create((Typeface)e.a(object), (int)n2);
    }

    @Override
    public Typeface a(Context context, c.b arrc, Resources resources, int n2) {
        Object object = e.b();
        for (c.c c2 : arrc.a()) {
            ByteBuffer byteBuffer = i.a(context, resources, c2.f());
            if (byteBuffer == null) {
                return null;
            }
            if (e.a(object, byteBuffer, c2.e(), c2.b(), c2.c())) continue;
            return null;
        }
        return e.a(object);
    }
}

