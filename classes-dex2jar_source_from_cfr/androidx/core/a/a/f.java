/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.util.TypedValue
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.a.a.c;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class f {
    public static Typeface a(Context context, int n2, TypedValue typedValue, int n3, a a2) {
        if (context.isRestricted()) {
            return null;
        }
        return f.a(context, n2, typedValue, n3, a2, null, true);
    }

    private static Typeface a(Context object, int n2, TypedValue typedValue, int n3, a a2, Handler handler, boolean bl2) {
        Resources resources = object.getResources();
        resources.getValue(n2, typedValue, true);
        object = f.a((Context)object, resources, typedValue, n2, n3, a2, handler, bl2);
        if (object == null) {
            if (a2 != null) {
                return object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Font resource ID #0x");
            ((StringBuilder)object).append(Integer.toHexString(n2));
            ((StringBuilder)object).append(" could not be retrieved.");
            throw new Resources.NotFoundException(((StringBuilder)object).toString());
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Typeface a(Context object, Resources object2, TypedValue object3, int n2, int n3, a a2, Handler handler, boolean bl2) {
        void var6_14;
        void var2_10;
        void var5_13;
        void var4_12;
        void var0_3;
        void var3_11;
        if (object3.string == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Resource \"");
            ((StringBuilder)object).append(object2.getResourceName((int)var3_11));
            ((StringBuilder)object).append("\" (");
            ((StringBuilder)object).append(Integer.toHexString((int)var3_11));
            ((StringBuilder)object).append(") is not a Font: ");
            ((StringBuilder)object).append(object3);
            throw new Resources.NotFoundException(((StringBuilder)object).toString());
        }
        String string2 = object3.string.toString();
        if (!string2.startsWith("res/")) {
            if (var5_13 == null) return null;
            {
                var5_13.a(-3, (Handler)var6_14);
            }
            return null;
        }
        Typeface typeface = androidx.core.graphics.c.a((Resources)object2, (int)var3_11, (int)var4_12);
        if (typeface != null) {
            if (var5_13 == null) return typeface;
            {
                var5_13.a(typeface, (Handler)var6_14);
            }
            return typeface;
        }
        try {
            if (string2.toLowerCase().endsWith(".xml")) {
                c.a a3 = c.a((XmlPullParser)object2.getXml((int)var3_11), (Resources)object2);
                if (a3 != null) {
                    void var7_15;
                    return androidx.core.graphics.c.a((Context)object, a3, (Resources)object2, (int)var3_11, (int)var4_12, (a)var5_13, (Handler)var6_14, (boolean)var7_15);
                }
                Log.e((String)"ResourcesCompat", (String)"Failed to find font-family tag");
                if (var5_13 == null) return null;
                {
                    var5_13.a(-3, (Handler)var6_14);
                    return null;
                }
            }
            object = androidx.core.graphics.c.a((Context)object, (Resources)object2, (int)var3_11, string2, (int)var4_12);
            if (var5_13 == null) return object;
            {
                if (object != null) {
                    var5_13.a((Typeface)object, (Handler)var6_14);
                    return object;
                }
                var5_13.a(-3, (Handler)var6_14);
            }
            return object;
        }
        catch (IOException iOException) {
            object2 = new StringBuilder();
            String string3 = "Failed to read xml resource ";
        }
        catch (XmlPullParserException xmlPullParserException) {
            object2 = new StringBuilder();
            String string4 = "Failed to parse xml resource ";
        }
        ((StringBuilder)object2).append((String)var2_10);
        ((StringBuilder)object2).append(string2);
        Log.e((String)"ResourcesCompat", (String)((StringBuilder)object2).toString(), (Throwable)var0_3);
        if (var5_13 == null) return null;
        {
            var5_13.a(-3, (Handler)var6_14);
        }
        return null;
    }

    public static Drawable a(Resources resources, int n2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(n2, theme);
        }
        return resources.getDrawable(n2);
    }

    public static abstract class a {
        public abstract void a(int var1);

        public final void a(final int n2, Handler handler) {
            Handler handler2 = handler;
            if (handler == null) {
                handler2 = new Handler(Looper.getMainLooper());
            }
            handler2.post(new Runnable(){

                @Override
                public void run() {
                    a.this.a(n2);
                }
            });
        }

        public abstract void a(Typeface var1);

        public final void a(final Typeface typeface, Handler handler) {
            Handler handler2 = handler;
            if (handler == null) {
                handler2 = new Handler(Looper.getMainLooper());
            }
            handler2.post(new Runnable(){

                @Override
                public void run() {
                    a.this.a(typeface);
                }
            });
        }

    }

}

