/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 */
package jp.co.jreast.jreastapp.commuter.r;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2={"Ljp/co/jreast/jreastapp/commuter/util/FileUtil;", "", "()V", "getCameraDirectory", "Ljava/io/File;", "getExternalStorageCameraFile", "filename", "", "getFileOutputStream", "Ljava/io/FileOutputStream;", "file", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d {
    private final File a() {
        File file = new File(Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DCIM), "/GoByTrain");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public final File a(String string2) {
        j.b(string2, "filename");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a().getAbsolutePath());
        stringBuilder.append("/");
        stringBuilder.append(string2);
        return new File(stringBuilder.toString());
    }

    public final FileOutputStream a(File file) {
        j.b(file, "file");
        return new FileOutputStream(file);
    }
}

