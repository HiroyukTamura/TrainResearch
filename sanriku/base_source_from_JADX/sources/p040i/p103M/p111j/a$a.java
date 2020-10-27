package p040i.p103M.p111j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import p042j.C1016z;
import p042j.C2080p;
import p042j.C2090x;

/* renamed from: i.M.j.a$a */
public final class a$a implements C1873b {
    a$a() {
    }

    /* renamed from: a */
    public C1016z mo27954a(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return C2080p.m3585b(file);
    }

    /* renamed from: a */
    public void mo27955a(File file, File file2) throws IOException {
        Intrinsics.checkParameterIsNotNull(file, "from");
        Intrinsics.checkParameterIsNotNull(file2, "to");
        mo27959e(file2);
        if (!file.renameTo(file2)) {
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    }

    /* renamed from: b */
    public C2090x mo27956b(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        try {
            return C2080p.m3581a(file, false, 1, (Object) null);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return C2080p.m3581a(file, false, 1, (Object) null);
        }
    }

    /* renamed from: c */
    public void mo27957c(File file) throws IOException {
        Intrinsics.checkParameterIsNotNull(file, "directory");
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                Intrinsics.checkExpressionValueIsNotNull(file2, "file");
                if (file2.isDirectory()) {
                    mo27957c(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    /* renamed from: d */
    public boolean mo27958d(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return file.exists();
    }

    /* renamed from: e */
    public void mo27959e(File file) throws IOException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (!file.delete() && file.exists()) {
            throw new IOException("failed to delete " + file);
        }
    }

    /* renamed from: f */
    public C2090x mo27960f(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        try {
            return C2080p.m3580a(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return C2080p.m3580a(file);
        }
    }

    /* renamed from: g */
    public long mo27961g(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return file.length();
    }

    public String toString() {
        return "FileSystem.SYSTEM";
    }
}
