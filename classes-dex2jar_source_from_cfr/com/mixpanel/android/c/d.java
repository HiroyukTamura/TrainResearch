/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.util.Base64
 */
package com.mixpanel.android.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import androidx.c.e;
import com.mixpanel.android.b.k;
import com.mixpanel.android.c.c;
import com.mixpanel.android.c.f;
import com.mixpanel.android.c.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public class d {
    private static e<String, Bitmap> e;
    private final File a;
    private final i b;
    private final MessageDigest c;
    private final k d;

    public d(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MixpanelAPI.Images.");
        stringBuilder.append(string2);
        this(context, stringBuilder.toString(), new c());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public d(Context object, String string2, i i2) {
        block6 : {
            this.a = object.getDir(string2, 0);
            this.b = i2;
            this.d = k.a(object);
            try {
                object = MessageDigest.getInstance("SHA1");
                break block6;
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
            f.d("MixpanelAPI.ImageStore", "Images won't be stored because this platform doesn't supply a SHA1 hash function");
            object = null;
        }
        this.c = object;
        if (e != null) {
            return;
        }
        synchronized (d.class) {
            if (e == null) {
                e = new e<String, Bitmap>((int)(Runtime.getRuntime().maxMemory() / 1024L) / this.d.E()){

                    @Override
                    protected int a(String string2, Bitmap bitmap) {
                        return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
                    }

                    @Override
                    protected /* synthetic */ int b(Object object, Object object2) {
                        return this.a((String)object, (Bitmap)object2);
                    }
                };
            }
            return;
        }
    }

    private static float a() {
        Runtime runtime = Runtime.getRuntime();
        float f2 = runtime.totalMemory() - runtime.freeMemory();
        return (float)runtime.maxMemory() - f2;
    }

    private static Bitmap a(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile((String)file.getAbsolutePath(), (BitmapFactory.Options)options);
        if (!((float)options.outHeight * (float)options.outWidth > d.a())) {
            options = BitmapFactory.decodeFile((String)file.getAbsolutePath());
            if (options != null) {
                return options;
            }
            file.delete();
            throw new a("Bitmap on disk can't be opened or was corrupt");
        }
        throw new a("Do not have enough memory for the image");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String string2, Bitmap bitmap) {
        if (d.d(string2) == null) {
            e<String, Bitmap> e2 = e;
            synchronized (e2) {
                e.a(string2, bitmap);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bitmap d(String string2) {
        e<String, Bitmap> e2 = e;
        synchronized (e2) {
            return e.a(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void e(String string2) {
        e<String, Bitmap> e2 = e;
        synchronized (e2) {
            e.b(string2);
            return;
        }
    }

    private File f(String object) {
        if (this.c == null) {
            return null;
        }
        object = this.c.digest(object.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MP_IMG_");
        stringBuilder.append(Base64.encodeToString((byte[])object, (int)10));
        object = stringBuilder.toString();
        return new File(this.a, (String)object);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public File a(String object) {
        Object object2;
        Object var4_13;
        block17 : {
            File file = this.f((String)object);
            if (file != null) {
                if (file.exists()) return file;
            }
            byte[] arrby = this.d.C();
            i i2 = this.b;
            Object var3_9 = null;
            var4_13 = null;
            object2 = null;
            arrby = i2.a((String)object, null, (SSLSocketFactory)arrby);
            if (arrby == null) return file;
            if (file == null) return file;
            if (arrby.length >= 10000000) return file;
            object = object2;
            object2 = new FileOutputStream(file);
            ((OutputStream)object2).write(arrby);
            try {
                ((OutputStream)object2).close();
                return file;
            }
            catch (IOException iOException) {
                f.d("MixpanelAPI.ImageStore", "Problem closing output file", iOException);
                return file;
            }
            catch (Throwable throwable) {
                object = object2;
                object2 = throwable;
                break block17;
            }
            catch (IOException iOException) {
                object = object2;
                object2 = iOException;
                throw new a("Can't store bitmap", (Throwable)object2);
            }
            catch (FileNotFoundException fileNotFoundException) {
                object = object2;
                object2 = fileNotFoundException;
                throw new a("It appears that ImageStore is misconfigured, or disk storage is unavailable- can't write to bitmap directory", (Throwable)object2);
            }
            catch (i.a a2) {
                throw new a("Couldn't download image due to service availability", a2);
            }
            catch (IOException iOException) {
                throw new a("Can't download bitmap", iOException);
            }
            catch (Throwable throwable) {
                break block17;
            }
            catch (IOException iOException) {
                object = var3_9;
            }
            {
                throw new a("Can't store bitmap", (Throwable)object2);
            }
        }
        if (object == null) throw object2;
        try {
            ((OutputStream)object).close();
            throw object2;
        }
        catch (IOException iOException) {
            f.d("MixpanelAPI.ImageStore", "Problem closing output file", iOException);
        }
        throw object2;
        catch (FileNotFoundException fileNotFoundException) {
            object = var4_13;
            throw new a("It appears that ImageStore is misconfigured, or disk storage is unavailable- can't write to bitmap directory", (Throwable)object2);
        }
    }

    public Bitmap b(String string2) {
        Bitmap bitmap;
        Bitmap bitmap2 = bitmap = d.d(string2);
        if (bitmap == null) {
            bitmap2 = d.a(this.a(string2));
            d.a(string2, bitmap2);
        }
        return bitmap2;
    }

    public void c(String string2) {
        File file = this.f(string2);
        if (file != null) {
            file.delete();
            d.e(string2);
        }
    }

    public static class a
    extends Exception {
        public a(String string2) {
            super(string2);
        }

        public a(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

}

