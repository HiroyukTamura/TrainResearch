package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import p009e.p010a.p011a.p012a.C0681a;

final class MultiDexExtractor implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    private static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        StringBuilder a = C0681a.m330a("MultiDexExtractor(");
        a.append(file.getPath());
        a.append(", ");
        a.append(file2.getPath());
        a.append(")");
        Log.i(TAG, a.toString());
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.lockRaf = randomAccessFile;
        try {
            this.lockChannel = randomAccessFile.getChannel();
            try {
                Log.i(TAG, "Blocking on lock " + file3.getPath());
                this.cacheLock = this.lockChannel.lock();
                Log.i(TAG, file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            closeQuietly(this.lockRaf);
            throw e4;
        }
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            StringBuilder a = C0681a.m330a("Failed to list secondary dex dir content (");
            a.append(this.dexDir.getPath());
            a.append(").");
            Log.w(TAG, a.toString());
            return;
        }
        for (File file : listFiles) {
            StringBuilder a2 = C0681a.m330a("Trying to delete old file ");
            a2.append(file.getPath());
            a2.append(" of size ");
            a2.append(file.length());
            Log.i(TAG, a2.toString());
            if (!file.delete()) {
                StringBuilder a3 = C0681a.m330a("Failed to delete old file ");
                a3.append(file.getPath());
                Log.w(TAG, a3.toString());
            } else {
                StringBuilder a4 = C0681a.m330a("Deleted old file ");
                a4.append(file.getPath());
                Log.i(TAG, a4.toString());
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w(TAG, "Failed to close resource", e);
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(C0681a.m320a("tmp-", str), EXTRACTED_SUFFIX, file.getParentFile());
        StringBuilder a = C0681a.m330a("Extracting ");
        a.append(createTempFile.getPath());
        Log.i(TAG, a.toString());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i(TAG, "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    closeQuietly(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    private static boolean isModified(Context context, File file, long j, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + "timestamp", -1) == getTimeStamp(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(KEY_CRC);
            return multiDexPreferences.getLong(sb.toString(), -1) != j;
        }
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = str;
        Log.i(TAG, "loading existing secondary dex files");
        String str3 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i = multiDexPreferences.getInt(str2 + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, C0681a.m317a(str3, i2, EXTRACTED_SUFFIX));
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                long j = multiDexPreferences.getLong(str2 + KEY_DEX_CRC + i2, -1);
                long j2 = multiDexPreferences.getLong(str2 + KEY_DEX_TIME + i2, -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i2++;
                        multiDexPreferences = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
            }
            StringBuilder a = C0681a.m330a("Missing extracted secondary dex file '");
            a.append(extractedDex.getPath());
            a.append("'");
            throw new IOException(a.toString());
        }
        return arrayList;
    }

    private List<ExtractedDex> performExtractions() throws IOException {
        ExtractedDex extractedDex;
        boolean z;
        String str = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        clearDexDir();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        int i = 2;
        String str2 = "classes2.dex";
        while (true) {
            try {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry != null) {
                    extractedDex = new ExtractedDex(this.dexDir, str + i + EXTRACTED_SUFFIX);
                    arrayList.add(extractedDex);
                    Log.i(TAG, "Extraction is needed for file " + extractedDex);
                    int i2 = 0;
                    z = false;
                    while (i2 < 3 && !z) {
                        i2++;
                        extract(zipFile, entry, extractedDex, str);
                        extractedDex.crc = getZipCrc(extractedDex);
                        z = true;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Extraction ");
                        sb.append(z ? "succeeded" : "failed");
                        sb.append(" '");
                        sb.append(extractedDex.getAbsolutePath());
                        sb.append("': length ");
                        sb.append(extractedDex.length());
                        sb.append(" - crc: ");
                        sb.append(extractedDex.crc);
                        Log.i(TAG, sb.toString());
                        if (!z) {
                            extractedDex.delete();
                            if (extractedDex.exists()) {
                                Log.w(TAG, "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                            }
                        }
                    }
                    if (z) {
                        i++;
                        str2 = DEX_PREFIX + i + DEX_SUFFIX;
                    } else {
                        throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i + ")");
                    }
                } else {
                    try {
                        zipFile.close();
                    } catch (IOException e) {
                        Log.w(TAG, "Failed to close resource", e);
                    }
                    return arrayList;
                }
            } catch (IOException e2) {
                Log.w(TAG, "Failed to read crc from " + extractedDex.getAbsolutePath(), e2);
                z = false;
            } catch (Throwable th) {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    Log.w(TAG, "Failed to close resource", e3);
                }
                throw th;
            }
        }
    }

    private static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(C0681a.m324a(new StringBuilder(), str, KEY_CRC), j2);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + KEY_DEX_CRC + i, next.crc);
            edit.putLong(str + KEY_DEX_TIME + i, next.lastModified());
            i++;
        }
        edit.commit();
    }

    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    /* access modifiers changed from: package-private */
    public List<? extends File> load(Context context, String str, boolean z) throws IOException {
        List<ExtractedDex> list;
        StringBuilder a = C0681a.m330a("MultiDexExtractor.load(");
        a.append(this.sourceApk.getPath());
        a.append(", ");
        a.append(z);
        a.append(", ");
        a.append(str);
        a.append(")");
        Log.i(TAG, a.toString());
        if (this.cacheLock.isValid()) {
            if (z || isModified(context, this.sourceApk, this.sourceCrc, str)) {
                Log.i(TAG, z ? "Forced extraction must be performed." : "Detected that extraction must be performed.");
            } else {
                try {
                    list = loadExistingExtractions(context, str);
                } catch (IOException e) {
                    Log.w(TAG, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                }
                StringBuilder a2 = C0681a.m330a("load found ");
                a2.append(list.size());
                a2.append(" secondary dex files");
                Log.i(TAG, a2.toString());
                return list;
            }
            List<ExtractedDex> performExtractions = performExtractions();
            putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
            list = performExtractions;
            StringBuilder a22 = C0681a.m330a("load found ");
            a22.append(list.size());
            a22.append(" secondary dex files");
            Log.i(TAG, a22.toString());
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
