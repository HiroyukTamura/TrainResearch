/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.reflect.jvm.internal.impl.f.y;

public class j {
    public static final byte[] a = new byte[0];
    public static final ByteBuffer b = ByteBuffer.wrap(a);

    public static boolean a(byte[] arrby) {
        return y.a(arrby);
    }

    public static String b(byte[] object) {
        try {
            object = new String((byte[])object, "UTF-8");
            return object;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException);
        }
    }

    public static interface a {
        public int a();
    }

    public static interface b<T extends a> {
        public T b(int var1);
    }

}

