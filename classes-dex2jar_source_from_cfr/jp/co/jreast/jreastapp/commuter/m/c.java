/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  android.os.Handler
 */
package jp.co.jreast.jreastapp.commuter.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;
import g.a.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import jp.co.jreast.jreastapp.commuter.common.e;
import jp.co.jreast.jreastapp.commuter.r.d;
import kotlin.Metadata;
import kotlin.d.b;
import kotlin.e.b.j;
import kotlin.e.b.y;

@Metadata(bv={1, 0, 2}, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/ExternalStorageRepository;", "", "context", "Landroid/content/Context;", "datetimeUtil", "Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "imagesMedia", "Ljp/co/jreast/jreastapp/commuter/common/ImagesMediaWrapper;", "fileUtil", "Ljp/co/jreast/jreastapp/commuter/util/FileUtil;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;Ljp/co/jreast/jreastapp/commuter/common/ImagesMediaWrapper;Ljp/co/jreast/jreastapp/commuter/util/FileUtil;)V", "getContext", "()Landroid/content/Context;", "getFileName", "", "saveAsPngImage", "", "image", "Landroid/graphics/Bitmap;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c {
    private final Context a;
    private final jp.co.jreast.jreastapp.commuter.d.a b;
    private final e c;
    private final d d;

    public c(Context context, jp.co.jreast.jreastapp.commuter.d.a a2, e e2, d d2) {
        j.b((Object)context, "context");
        j.b(a2, "datetimeUtil");
        j.b(e2, "imagesMedia");
        j.b(d2, "fileUtil");
        this.a = context;
        this.b = a2;
        this.c = e2;
        this.d = d2;
    }

    private final String b() {
        Object object = this.b.b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(((Calendar)object).get(1)));
        Object object2 = y.a;
        object2 = new Object[]{((Calendar)object).get(2) + 1};
        object2 = String.format("%02d", Arrays.copyOf(object2, ((Object[])object2).length));
        j.a(object2, "java.lang.String.format(format, *args)");
        stringBuilder.append((String)object2);
        object2 = y.a;
        object2 = new Object[]{((Calendar)object).get(5)};
        object2 = String.format("%02d", Arrays.copyOf(object2, ((Object[])object2).length));
        j.a(object2, "java.lang.String.format(format, *args)");
        stringBuilder.append((String)object2);
        stringBuilder.append("-");
        object2 = y.a;
        object2 = new Object[]{((Calendar)object).get(11)};
        object2 = String.format("%02d", Arrays.copyOf(object2, ((Object[])object2).length));
        j.a(object2, "java.lang.String.format(format, *args)");
        stringBuilder.append((String)object2);
        object2 = y.a;
        object2 = new Object[]{((Calendar)object).get(12)};
        object2 = String.format("%02d", Arrays.copyOf(object2, ((Object[])object2).length));
        j.a(object2, "java.lang.String.format(format, *args)");
        stringBuilder.append((String)object2);
        object2 = y.a;
        object2 = new Object[]{((Calendar)object).get(13)};
        object = String.format("%02d", Arrays.copyOf(object2, ((Object[])object2).length));
        j.a(object, "java.lang.String.format(format, *args)");
        stringBuilder.append((String)object);
        stringBuilder.append(".png");
        return stringBuilder.toString();
    }

    public final Context a() {
        return this.a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final boolean a(Bitmap bitmap) {
        Throwable throwable2222;
        j.b((Object)bitmap, "image");
        Object object = this.d;
        Serializable serializable = new StringBuilder();
        serializable.append("Screenshot_");
        serializable.append(this.b());
        final File file = ((d)object).a(serializable.toString());
        Closeable closeable = this.d.a(file);
        serializable = null;
        object = serializable;
        FileOutputStream fileOutputStream = (FileOutputStream)closeable;
        object = serializable;
        boolean bl2 = bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)fileOutputStream);
        b.a(closeable, (Throwable)serializable);
        if (!bl2) return bl2;
        new Handler().postDelayed(new Runnable(){

            @Override
            public final void run() {
                e e2 = this.c;
                Context context = this.a();
                String string2 = file.getAbsolutePath();
                j.a((Object)string2, "file.absolutePath");
                MediaScannerConnection.OnScanCompletedListener onScanCompletedListener = 1.a;
                e2.a(context, new String[]{string2}, new String[]{"image/png"}, onScanCompletedListener);
            }

        }, 200L);
        return bl2;
        {
            catch (Throwable throwable2222) {
            }
            catch (Throwable throwable3) {}
            object = throwable3;
            {
                throw throwable3;
            }
        }
        b.a(closeable, (Throwable)object);
        throw throwable2222;
    }

}

