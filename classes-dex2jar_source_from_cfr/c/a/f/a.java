/*
 * Decompiled with CFR 0.139.
 */
package c.a.f;

import java.io.File;
import java.io.IOException;

public interface a {
    public static final a a = new a(){

        @Override
        public void a(File file) {
            if (!file.delete()) {
                if (!file.exists()) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed to delete ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
        }

        @Override
        public void a(File file, File file2) {
            this.a(file2);
            if (file.renameTo(file2)) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to rename ");
            stringBuilder.append(file);
            stringBuilder.append(" to ");
            stringBuilder.append(file2);
            throw new IOException(stringBuilder.toString());
        }

        @Override
        public boolean b(File file) {
            return file.exists();
        }

        @Override
        public long c(File file) {
            return file.length();
        }
    };

    public void a(File var1);

    public void a(File var1, File var2);

    public boolean b(File var1);

    public long c(File var1);

}

