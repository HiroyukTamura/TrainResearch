package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class FileBackedNativeSessionFile implements NativeSessionFile {
    @NonNull
    private final String dataTransportFilename;
    @NonNull
    private final File file;
    @NonNull
    private final String reportsEndpointFilename;

    FileBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @NonNull File file2) {
        this.dataTransportFilename = str;
        this.reportsEndpointFilename = str2;
        this.file = file2;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0041 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x004d */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] asGzippedBytes() {
        /*
            r7 = this;
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.InputStream r2 = r7.getStream()     // Catch:{ IOException -> 0x004e }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0047 }
            r3.<init>()     // Catch:{ all -> 0x0047 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0042 }
            r4.<init>(r3)     // Catch:{ all -> 0x0042 }
            if (r2 != 0) goto L_0x0021
            r4.close()     // Catch:{ all -> 0x0042 }
            r3.close()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0020
            r2.close()     // Catch:{ IOException -> 0x004e }
        L_0x0020:
            return r1
        L_0x0021:
            int r5 = r2.read(r0)     // Catch:{ all -> 0x003d }
            if (r5 <= 0) goto L_0x002c
            r6 = 0
            r4.write(r0, r6, r5)     // Catch:{ all -> 0x003d }
            goto L_0x0021
        L_0x002c:
            r4.finish()     // Catch:{ all -> 0x003d }
            byte[] r0 = r3.toByteArray()     // Catch:{ all -> 0x003d }
            r4.close()     // Catch:{ all -> 0x0042 }
            r3.close()     // Catch:{ all -> 0x0047 }
            r2.close()     // Catch:{ IOException -> 0x004e }
            return r0
        L_0x003d:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x0041 }
        L_0x0041:
            throw r0     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x0046 }
        L_0x0046:
            throw r0     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r0 = move-exception
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ all -> 0x004d }
        L_0x004d:
            throw r0     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.FileBackedNativeSessionFile.asGzippedBytes():byte[]");
    }

    @Nullable
    public CrashlyticsReport.FilesPayload.File asFilePayload() {
        byte[] asGzippedBytes = asGzippedBytes();
        if (asGzippedBytes != null) {
            return CrashlyticsReport.FilesPayload.File.builder().setContents(asGzippedBytes).setFilename(this.dataTransportFilename).build();
        }
        return null;
    }

    @NonNull
    public String getReportsEndpointFilename() {
        return this.reportsEndpointFilename;
    }

    @Nullable
    public InputStream getStream() {
        if (this.file.exists() && this.file.isFile()) {
            try {
                return new FileInputStream(this.file);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
