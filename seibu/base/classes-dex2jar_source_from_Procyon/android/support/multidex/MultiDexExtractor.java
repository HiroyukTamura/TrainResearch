// 
// Decompiled by Procyon v0.5.36
// 

package android.support.multidex;

import java.util.zip.ZipException;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import android.content.pm.ApplicationInfo;
import android.os.Build$VERSION;
import android.content.SharedPreferences;
import android.content.Context;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.zip.ZipOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.IOException;
import android.util.Log;
import java.io.Closeable;
import java.lang.reflect.InvocationTargetException;
import android.content.SharedPreferences$Editor;
import java.lang.reflect.Method;

final class MultiDexExtractor
{
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1L;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private static Method sApplyMethod;
    
    static {
        try {
            MultiDexExtractor.sApplyMethod = SharedPreferences$Editor.class.getMethod("apply", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException ex) {
            MultiDexExtractor.sApplyMethod = null;
        }
    }
    
    private static void apply(final SharedPreferences$Editor obj) {
        if (MultiDexExtractor.sApplyMethod == null) {
            goto Label_0020;
        }
        try {
            MultiDexExtractor.sApplyMethod.invoke(obj, new Object[0]);
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {
            goto Label_0020;
        }
    }
    
    private static void closeQuietly(final Closeable closeable) {
        try {
            closeable.close();
        }
        catch (IOException ex) {
            Log.w("MultiDex", "Failed to close resource", (Throwable)ex);
        }
    }
    
    private static void extract(ZipFile zipFile, final ZipEntry entry, final File dest, String tempFile) throws IOException, FileNotFoundException {
        final InputStream inputStream = zipFile.getInputStream(entry);
        tempFile = (String)File.createTempFile(tempFile, ".zip", dest.getParentFile());
        Log.i("MultiDex", "Extracting " + ((File)tempFile).getPath());
        while (true) {
            try {
                zipFile = (ZipFile)new ZipOutputStream(new BufferedOutputStream(new FileOutputStream((File)tempFile)));
                Label_0245: {
                    try {
                        final ZipEntry e = new ZipEntry("classes.dex");
                        e.setTime(entry.getTime());
                        ((ZipOutputStream)zipFile).putNextEntry(e);
                        final byte[] b = new byte[16384];
                        for (int i = inputStream.read(b); i != -1; i = inputStream.read(b)) {
                            ((ZipOutputStream)zipFile).write(b, 0, i);
                        }
                        ((ZipOutputStream)zipFile).closeEntry();
                        try {
                            ((ZipOutputStream)zipFile).close();
                            Log.i("MultiDex", "Renaming to " + dest.getPath());
                            if (!((File)tempFile).renameTo(dest)) {
                                throw new IOException("Failed to rename \"" + ((File)tempFile).getAbsolutePath() + "\" to \"" + dest.getAbsolutePath() + "\"");
                            }
                            break Label_0245;
                        }
                        finally {}
                        closeQuietly(inputStream);
                        ((File)tempFile).delete();
                        throw zipFile;
                    }
                    finally {
                        ((ZipOutputStream)zipFile).close();
                    }
                }
                closeQuietly(inputStream);
                ((File)tempFile).delete();
            }
            finally {
                continue;
            }
            break;
        }
    }
    
    private static SharedPreferences getMultiDexPreferences(final Context context) {
        int n;
        if (Build$VERSION.SDK_INT < 11) {
            n = 0;
        }
        else {
            n = 4;
        }
        return context.getSharedPreferences("multidex.version", n);
    }
    
    private static long getTimeStamp(final File file) {
        long lastModified;
        final long n = lastModified = file.lastModified();
        if (n == -1L) {
            lastModified = n - 1L;
        }
        return lastModified;
    }
    
    private static long getZipCrc(final File file) throws IOException {
        long zipCrc;
        final long n = zipCrc = ZipUtil.getZipCrc(file);
        if (n == -1L) {
            zipCrc = n - 1L;
        }
        return zipCrc;
    }
    
    private static boolean isModified(final Context context, final File file, final long n) {
        final SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        return multiDexPreferences.getLong("timestamp", -1L) != getTimeStamp(file) || multiDexPreferences.getLong("crc", -1L) != n;
    }
    
    static List<File> load(Context loadExistingExtractions, final ApplicationInfo applicationInfo, final File file, final boolean b) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor.load(" + applicationInfo.sourceDir + ", " + b + ")");
        final File file2 = new File(applicationInfo.sourceDir);
        final long zipCrc = getZipCrc(file2);
        while (true) {
            Label_0169: {
                if (b || isModified((Context)loadExistingExtractions, file2, zipCrc)) {
                    break Label_0169;
                }
                try {
                    loadExistingExtractions = loadExistingExtractions((Context)loadExistingExtractions, file2, file);
                    Log.i("MultiDex", "load found " + ((List)loadExistingExtractions).size() + " secondary dex files");
                    return (List<File>)loadExistingExtractions;
                }
                catch (IOException ex) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", (Throwable)ex);
                    final List<File> performExtractions = performExtractions(file2, file);
                    putStoredApkInfo((Context)loadExistingExtractions, getTimeStamp(file2), zipCrc, performExtractions.size() + 1);
                    loadExistingExtractions = performExtractions;
                    continue;
                }
            }
            Log.i("MultiDex", "Detected that extraction must be performed.");
            final List<File> performExtractions2 = performExtractions(file2, file);
            putStoredApkInfo((Context)loadExistingExtractions, getTimeStamp(file2), zipCrc, performExtractions2.size() + 1);
            loadExistingExtractions = performExtractions2;
            continue;
        }
    }
    
    private static List<File> loadExistingExtractions(final Context context, final File file, final File parent) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        final String string = file.getName() + ".classes";
        final int int1 = getMultiDexPreferences(context).getInt("dex.number", 1);
        final ArrayList list = new ArrayList<File>(int1);
        for (int i = 2; i <= int1; ++i) {
            final File obj = new File(parent, string + i + ".zip");
            if (!obj.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + obj.getPath() + "'");
            }
            list.add(obj);
            if (!verifyZipFile(obj)) {
                Log.i("MultiDex", "Invalid zip file: " + obj);
                throw new IOException("Invalid ZIP file.");
            }
        }
        return (List<File>)list;
    }
    
    private static void mkdirChecked(final File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            final File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            }
            else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create cache directory " + file.getPath());
        }
    }
    
    private static List<File> performExtractions(final File p0, final File p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: aload_0        
        //     8: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //    11: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    14: ldc             ".classes"
        //    16: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    19: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    22: astore          9
        //    24: aload_1        
        //    25: aload           9
        //    27: invokestatic    android/support/multidex/MultiDexExtractor.prepareDexDir:(Ljava/io/File;Ljava/lang/String;)V
        //    30: new             Ljava/util/ArrayList;
        //    33: dup            
        //    34: invokespecial   java/util/ArrayList.<init>:()V
        //    37: astore          8
        //    39: new             Ljava/util/zip/ZipFile;
        //    42: dup            
        //    43: aload_0        
        //    44: invokespecial   java/util/zip/ZipFile.<init>:(Ljava/io/File;)V
        //    47: astore          10
        //    49: iconst_2       
        //    50: istore_2       
        //    51: aload           10
        //    53: new             Ljava/lang/StringBuilder;
        //    56: dup            
        //    57: invokespecial   java/lang/StringBuilder.<init>:()V
        //    60: ldc             "classes"
        //    62: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    65: iconst_2       
        //    66: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    69: ldc             ".dex"
        //    71: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    74: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    77: invokevirtual   java/util/zip/ZipFile.getEntry:(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
        //    80: astore_0       
        //    81: aload_0        
        //    82: ifnull          447
        //    85: new             Ljava/io/File;
        //    88: dup            
        //    89: aload_1        
        //    90: new             Ljava/lang/StringBuilder;
        //    93: dup            
        //    94: invokespecial   java/lang/StringBuilder.<init>:()V
        //    97: aload           9
        //    99: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: iload_2        
        //   103: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   106: ldc             ".zip"
        //   108: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   111: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   114: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   117: astore          11
        //   119: aload           8
        //   121: aload           11
        //   123: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   128: pop            
        //   129: ldc             "MultiDex"
        //   131: new             Ljava/lang/StringBuilder;
        //   134: dup            
        //   135: invokespecial   java/lang/StringBuilder.<init>:()V
        //   138: ldc_w           "Extraction is needed for file "
        //   141: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   144: aload           11
        //   146: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   149: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   152: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   155: pop            
        //   156: iconst_0       
        //   157: istore_3       
        //   158: iconst_0       
        //   159: istore          5
        //   161: iload_3        
        //   162: iconst_3       
        //   163: if_icmpge       357
        //   166: iload           5
        //   168: ifne            357
        //   171: iload_3        
        //   172: iconst_1       
        //   173: iadd           
        //   174: istore          4
        //   176: aload           10
        //   178: aload_0        
        //   179: aload           11
        //   181: aload           9
        //   183: invokestatic    android/support/multidex/MultiDexExtractor.extract:(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/lang/String;)V
        //   186: aload           11
        //   188: invokestatic    android/support/multidex/MultiDexExtractor.verifyZipFile:(Ljava/io/File;)Z
        //   191: istore          6
        //   193: new             Ljava/lang/StringBuilder;
        //   196: dup            
        //   197: invokespecial   java/lang/StringBuilder.<init>:()V
        //   200: ldc_w           "Extraction "
        //   203: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   206: astore          12
        //   208: iload           6
        //   210: ifeq            349
        //   213: ldc_w           "success"
        //   216: astore          7
        //   218: ldc             "MultiDex"
        //   220: aload           12
        //   222: aload           7
        //   224: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   227: ldc_w           " - length "
        //   230: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   233: aload           11
        //   235: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   238: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   241: ldc_w           ": "
        //   244: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: aload           11
        //   249: invokevirtual   java/io/File.length:()J
        //   252: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   255: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   258: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   261: pop            
        //   262: iload           6
        //   264: istore          5
        //   266: iload           4
        //   268: istore_3       
        //   269: iload           6
        //   271: ifne            161
        //   274: aload           11
        //   276: invokevirtual   java/io/File.delete:()Z
        //   279: pop            
        //   280: iload           6
        //   282: istore          5
        //   284: iload           4
        //   286: istore_3       
        //   287: aload           11
        //   289: invokevirtual   java/io/File.exists:()Z
        //   292: ifeq            161
        //   295: ldc             "MultiDex"
        //   297: new             Ljava/lang/StringBuilder;
        //   300: dup            
        //   301: invokespecial   java/lang/StringBuilder.<init>:()V
        //   304: ldc_w           "Failed to delete corrupted secondary dex '"
        //   307: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   310: aload           11
        //   312: invokevirtual   java/io/File.getPath:()Ljava/lang/String;
        //   315: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   318: ldc_w           "'"
        //   321: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   324: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   327: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   330: pop            
        //   331: iload           6
        //   333: istore          5
        //   335: iload           4
        //   337: istore_3       
        //   338: goto            161
        //   341: astore_0       
        //   342: aload           10
        //   344: invokevirtual   java/util/zip/ZipFile.close:()V
        //   347: aload_0        
        //   348: athrow         
        //   349: ldc_w           "failed"
        //   352: astore          7
        //   354: goto            218
        //   357: iload           5
        //   359: ifne            410
        //   362: new             Ljava/io/IOException;
        //   365: dup            
        //   366: new             Ljava/lang/StringBuilder;
        //   369: dup            
        //   370: invokespecial   java/lang/StringBuilder.<init>:()V
        //   373: ldc_w           "Could not create zip file "
        //   376: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   379: aload           11
        //   381: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   384: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   387: ldc_w           " for secondary dex ("
        //   390: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   393: iload_2        
        //   394: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   397: ldc_w           ")"
        //   400: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   403: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   406: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   409: athrow         
        //   410: iload_2        
        //   411: iconst_1       
        //   412: iadd           
        //   413: istore_2       
        //   414: aload           10
        //   416: new             Ljava/lang/StringBuilder;
        //   419: dup            
        //   420: invokespecial   java/lang/StringBuilder.<init>:()V
        //   423: ldc             "classes"
        //   425: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   428: iload_2        
        //   429: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   432: ldc             ".dex"
        //   434: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   437: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   440: invokevirtual   java/util/zip/ZipFile.getEntry:(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
        //   443: astore_0       
        //   444: goto            81
        //   447: aload           10
        //   449: invokevirtual   java/util/zip/ZipFile.close:()V
        //   452: aload           8
        //   454: areturn        
        //   455: astore_0       
        //   456: ldc             "MultiDex"
        //   458: ldc             "Failed to close resource"
        //   460: aload_0        
        //   461: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   464: pop            
        //   465: aload           8
        //   467: areturn        
        //   468: astore_1       
        //   469: ldc             "MultiDex"
        //   471: ldc             "Failed to close resource"
        //   473: aload_1        
        //   474: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   477: pop            
        //   478: goto            347
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  (Ljava/io/File;Ljava/io/File;)Ljava/util/List<Ljava/io/File;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  51     81     341    349    Any
        //  85     156    341    349    Any
        //  176    208    341    349    Any
        //  218    262    341    349    Any
        //  274    280    341    349    Any
        //  287    331    341    349    Any
        //  342    347    468    481    Ljava/io/IOException;
        //  362    410    341    349    Any
        //  414    444    341    349    Any
        //  447    452    455    468    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0347:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void prepareDexDir(File file, final String s) throws IOException {
        mkdirChecked(file.getParentFile());
        mkdirChecked(file);
        final File[] listFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(final File file) {
                return !file.getName().startsWith(s);
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
        }
        else {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                file = listFiles[i];
                Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
                if (!file.delete()) {
                    Log.w("MultiDex", "Failed to delete old file " + file.getPath());
                }
                else {
                    Log.i("MultiDex", "Deleted old file " + file.getPath());
                }
            }
        }
    }
    
    private static void putStoredApkInfo(final Context context, final long n, final long n2, final int n3) {
        final SharedPreferences$Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong("timestamp", n);
        edit.putLong("crc", n2);
        edit.putInt("dex.number", n3);
        apply(edit);
    }
    
    static boolean verifyZipFile(final File file) {
        try {
            final ZipFile zipFile = new ZipFile(file);
            try {
                zipFile.close();
                return true;
            }
            catch (IOException ex3) {
                Log.w("MultiDex", "Failed to close zip file: " + file.getAbsolutePath());
            }
            return false;
        }
        catch (ZipException ex) {
            Log.w("MultiDex", "File " + file.getAbsolutePath() + " is not a valid zip file.", (Throwable)ex);
            return false;
        }
        catch (IOException ex2) {
            Log.w("MultiDex", "Got an IOException trying to open zip file: " + file.getAbsolutePath(), (Throwable)ex2);
            return false;
        }
    }
}
