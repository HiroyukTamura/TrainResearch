/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Icon
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.Log
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class IconCompat
extends CustomVersionedParcelable {
    static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public int a;
    Object b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g = null;
    PorterDuff.Mode i = h;
    public String j;

    private static String a(int n2) {
        switch (n2) {
            default: {
                return "UNKNOWN";
            }
            case 5: {
                return "BITMAP_MASKABLE";
            }
            case 4: {
                return "URI";
            }
            case 3: {
                return "DATA";
            }
            case 2: {
                return "RESOURCE";
            }
            case 1: 
        }
        return "BITMAP";
    }

    private static String a(Icon object) {
        if (Build.VERSION.SDK_INT >= 28) {
            return object.getResPackage();
        }
        try {
            object = (String)object.getClass().getMethod("getResPackage", new Class[0]).invoke(object, new Object[0]);
            return object;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            Log.e((String)"IconCompat", (String)"Unable to get icon package", (Throwable)reflectiveOperationException);
            return null;
        }
    }

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            int n2 = (Integer)icon.getClass().getMethod("getResId", new Class[0]).invoke((Object)icon, new Object[0]);
            return n2;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            Log.e((String)"IconCompat", (String)"Unable to get icon resource", (Throwable)reflectiveOperationException);
            return 0;
        }
    }

    public String a() {
        if (this.a == -1 && Build.VERSION.SDK_INT >= 23) {
            return IconCompat.a((Icon)this.b);
        }
        if (this.a == 2) {
            return ((String)this.b).split(":", -1)[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getResPackage() on ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void a(boolean var1_1) {
        block10 : {
            block8 : {
                block9 : {
                    this.j = this.i.name();
                    var2_2 = this.a;
                    if (var2_2 == -1) break block8;
                    switch (var2_2) {
                        default: {
                            return;
                        }
                        case 4: {
                            var3_3 = this.b.toString();
                            ** GOTO lbl15
                        }
                        case 3: {
                            var3_3 = (byte[])this.b;
                            break block9;
                        }
                        case 2: {
                            var3_3 = (String)this.b;
lbl15: // 2 sources:
                            var3_3 = var3_3.getBytes(Charset.forName("UTF-16"));
                            break block9;
                        }
                        case 1: 
                        case 5: 
                    }
                    if (!var1_1) break block10;
                    var3_3 = (byte[])this.b;
                    var4_4 = new ByteArrayOutputStream();
                    var3_3.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)var4_4);
                    var3_3 = var4_4.toByteArray();
                }
                this.c = var3_3;
                return;
            }
            if (var1_1 != false) throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        this.d = (Parcelable)this.b;
    }

    public int b() {
        if (this.a == -1 && Build.VERSION.SDK_INT >= 23) {
            return IconCompat.b((Icon)this.b);
        }
        if (this.a == 2) {
            return this.e;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getResId() on ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void c() {
        void var2_4;
        block8 : {
            block9 : {
                block7 : {
                    this.i = PorterDuff.Mode.valueOf((String)this.j);
                    int n2 = this.a;
                    if (n2 == -1) break block7;
                    switch (n2) {
                        default: {
                            return;
                        }
                        case 3: {
                            byte[] arrby = this.c;
                            break block8;
                        }
                        case 2: 
                        case 4: {
                            String string2 = new String(this.c, Charset.forName("UTF-16"));
                            break block8;
                        }
                        case 1: 
                        case 5: {
                            if (this.d == null) {
                                this.b = this.c;
                                this.a = 3;
                                this.e = 0;
                                this.f = this.c.length;
                                return;
                            }
                            break block9;
                        }
                    }
                }
                if (this.d == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
            }
            Parcelable parcelable = this.d;
        }
        this.b = var2_4;
    }

    public String toString() {
        StringBuilder stringBuilder;
        block10 : {
            int n2;
            if (this.a == -1) {
                return String.valueOf(this.b);
            }
            stringBuilder = new StringBuilder("Icon(typ=");
            stringBuilder.append(IconCompat.a(this.a));
            switch (this.a) {
                default: {
                    break block10;
                }
                case 4: {
                    stringBuilder.append(" uri=");
                    stringBuilder.append(this.b);
                    break block10;
                }
                case 3: {
                    stringBuilder.append(" len=");
                    stringBuilder.append(this.e);
                    if (this.f != 0) {
                        stringBuilder.append(" off=");
                        n2 = this.f;
                        break;
                    }
                    break block10;
                }
                case 2: {
                    stringBuilder.append(" pkg=");
                    stringBuilder.append(this.a());
                    stringBuilder.append(" id=");
                    stringBuilder.append(String.format("0x%08x", this.b()));
                    break block10;
                }
                case 1: 
                case 5: {
                    stringBuilder.append(" size=");
                    stringBuilder.append(((Bitmap)this.b).getWidth());
                    stringBuilder.append("x");
                    n2 = ((Bitmap)this.b).getHeight();
                }
            }
            stringBuilder.append(n2);
        }
        if (this.g != null) {
            stringBuilder.append(" tint=");
            stringBuilder.append((Object)this.g);
        }
        if (this.i != h) {
            stringBuilder.append(" mode=");
            stringBuilder.append((Object)this.i);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

