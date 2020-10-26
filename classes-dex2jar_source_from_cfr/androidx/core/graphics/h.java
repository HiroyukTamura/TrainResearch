/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 */
package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.core.a.a.c;
import androidx.core.e.b;
import androidx.core.graphics.c;
import androidx.core.graphics.i;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class h {
    h() {
    }

    private c.c a(c.b b2, int n2) {
        return h.a(b2.a(), n2, new a<c.c>(){

            public int a(c.c c2) {
                return c2.b();
            }

            @Override
            public /* synthetic */ boolean a(Object object) {
                return this.b((c.c)object);
            }

            @Override
            public /* synthetic */ int b(Object object) {
                return this.a((c.c)object);
            }

            public boolean b(c.c c2) {
                return c2.c();
            }
        });
    }

    private static <T> T a(T[] arrT, int n2, a<T> a2) {
        int n3 = (n2 & 1) == 0 ? 400 : 700;
        boolean bl2 = (n2 & 2) != 0;
        int n4 = arrT.length;
        T t2 = null;
        int n5 = Integer.MAX_VALUE;
        for (n2 = 0; n2 < n4; ++n2) {
            int n6;
            block4 : {
                int n7;
                T t3;
                block3 : {
                    t3 = arrT[n2];
                    n7 = Math.abs(a2.b(t3) - n3);
                    n6 = a2.a(t3) == bl2 ? 0 : 1;
                    n7 = n7 * 2 + n6;
                    if (t2 == null) break block3;
                    n6 = n5;
                    if (n5 <= n7) break block4;
                }
                t2 = t3;
                n6 = n7;
            }
            n5 = n6;
        }
        return t2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public Typeface a(Context var1_1, Resources var2_2, int var3_5, String var4_6, int var5_7) {
        block6 : {
            if ((var1_1 = i.a((Context)var1_1)) == null) {
                return null;
            }
            var6_8 = i.a((File)var1_1, var2_2, var3_5);
            if (var6_8) break block6;
            var1_1.delete();
            return null;
        }
        try {
            var2_2 = Typeface.createFromFile((String)var1_1.getPath());
        }
        catch (Throwable var2_3) {
            var1_1.delete();
            throw var2_3;
        }
        var1_1.delete();
        return var2_2;
lbl16: // 1 sources:
        do {
            var1_1.delete();
            return null;
            break;
        } while (true);
        catch (RuntimeException var2_4) {
            ** continue;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Typeface a(Context object, CancellationSignal object2, b.b[] arrb, int n2) {
        Object object3;
        block8 : {
            void var1_5;
            block7 : {
                Typeface typeface;
                void var4_12;
                void var3_10;
                int n3 = ((void)var3_10).length;
                Object var6_14 = null;
                if (n3 < 1) {
                    return null;
                }
                object3 = this.a((b.b[])var3_10, (int)var4_12);
                object3 = object.getContentResolver().openInputStream(((b.b)object3).a());
                try {
                    typeface = this.a((Context)object, (InputStream)object3);
                }
                catch (Throwable throwable) {
                    Object object4 = object3;
                    object3 = throwable;
                    break block7;
                }
                i.a((Closeable)object3);
                return typeface;
                catch (Throwable throwable) {
                    Object var1_4 = var6_14;
                }
            }
            i.a((Closeable)var1_5);
            throw object3;
            catch (IOException iOException) {}
            object3 = null;
            break block8;
            catch (IOException iOException) {}
        }
        i.a((Closeable)object3);
        return null;
    }

    public Typeface a(Context context, c.b object, Resources resources, int n2) {
        if ((object = this.a((c.b)object, n2)) == null) {
            return null;
        }
        return c.a(context, resources, ((c.c)object).f(), ((c.c)object).a(), n2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    protected Typeface a(Context var1_1, InputStream var2_2) {
        block6 : {
            if ((var1_1 = i.a((Context)var1_1)) == null) {
                return null;
            }
            var3_5 = i.a((File)var1_1, var2_2);
            if (var3_5) break block6;
            var1_1.delete();
            return null;
        }
        try {
            var2_2 = Typeface.createFromFile((String)var1_1.getPath());
        }
        catch (Throwable var2_3) {
            var1_1.delete();
            throw var2_3;
        }
        var1_1.delete();
        return var2_2;
lbl16: // 1 sources:
        do {
            var1_1.delete();
            return null;
            break;
        } while (true);
        catch (RuntimeException var2_4) {
            ** continue;
        }
    }

    protected b.b a(b.b[] arrb, int n2) {
        return h.a(arrb, n2, new a<b.b>(){

            public int a(b.b b2) {
                return b2.c();
            }

            @Override
            public /* synthetic */ boolean a(Object object) {
                return this.b((b.b)object);
            }

            @Override
            public /* synthetic */ int b(Object object) {
                return this.a((b.b)object);
            }

            public boolean b(b.b b2) {
                return b2.d();
            }
        });
    }

    private static interface a<T> {
        public boolean a(T var1);

        public int b(T var1);
    }

}

