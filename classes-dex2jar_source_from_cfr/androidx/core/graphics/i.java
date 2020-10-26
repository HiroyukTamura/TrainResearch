/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class i {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static File a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".font");
        stringBuilder.append(Process.myPid());
        stringBuilder.append("-");
        stringBuilder.append(Process.myTid());
        stringBuilder.append("-");
        String string2 = stringBuilder.toString();
        int n2 = 0;
        do {
            if (n2 >= 100) {
                return null;
            }
            File file = context.getCacheDir();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(n2);
            file = new File(file, stringBuilder2.toString());
            try {
                boolean bl2 = file.createNewFile();
                if (bl2) {
                    return file;
                }
            }
            catch (IOException iOException) {}
            ++n2;
        } while (true);
    }

    public static ByteBuffer a(Context object, Resources object2, int n2) {
        block5 : {
            if ((object = i.a((Context)object)) == null) {
                return null;
            }
            boolean bl2 = i.a((File)object, object2, n2);
            if (bl2) break block5;
            ((File)object).delete();
            return null;
        }
        try {
            object2 = i.a((File)object);
            return object2;
        }
        finally {
            ((File)object).delete();
        }
    }

    /*
     * Exception decompiling
     */
    public static ByteBuffer a(Context var0, CancellationSignal var1_6, Uri var2_10) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[TRYBLOCK]], but top level block is 15[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static ByteBuffer a(File var0) {
        try {
            var4_3 = new FileInputStream((File)var0);
        }
        catch (IOException var0_2) {
            return null;
        }
        var0 = var4_3.getChannel();
        var1_5 = var0.size();
        var0 = var0.map(FileChannel.MapMode.READ_ONLY, 0L, var1_5);
        var4_3.close();
        return var0;
        catch (Throwable var3_6) {
            var0 = null;
        }
        catch (Throwable var0_1) {
            try {
                throw var0_1;
            }
            catch (Throwable var3_7) {
                // empty catch block
            }
        }
        if (var0 == null) ** GOTO lbl28
        try {
            var4_3.close();
            throw var3_8;
        }
        catch (Throwable var4_4) {
            var0.addSuppressed(var4_4);
            throw var3_8;
        }
lbl28: // 1 sources:
        var4_3.close();
        throw var3_8;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean a(File file, Resources object, int n2) {
        void var0_3;
        block4 : {
            boolean bl2;
            object = object.openRawResource(n2);
            try {
                bl2 = i.a(file, (InputStream)object);
            }
            catch (Throwable throwable) {
                break block4;
            }
            i.a((Closeable)object);
            return bl2;
            catch (Throwable throwable) {
                object = null;
            }
        }
        i.a((Closeable)object);
        throw var0_3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean a(File object, InputStream inputStream) {
        StrictMode.ThreadPolicy threadPolicy;
        Object object2;
        block8 : {
            StringBuilder stringBuilder;
            block9 : {
                threadPolicy = StrictMode.allowThreadDiskWrites();
                stringBuilder = null;
                object2 = null;
                object = new FileOutputStream((File)object, false);
                try {
                    int n2;
                    object2 = new byte[1024];
                    while ((n2 = inputStream.read((byte[])object2)) != -1) {
                        ((FileOutputStream)object).write((byte[])object2, 0, n2);
                    }
                }
                catch (Throwable throwable) {
                    object2 = object;
                    object = throwable;
                    break block8;
                }
                catch (IOException iOException) {
                    break block9;
                }
                i.a((Closeable)object);
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
                return true;
                catch (Throwable throwable) {
                    break block8;
                }
                catch (IOException iOException) {
                    object = stringBuilder;
                }
            }
            object2 = object;
            {
                void var1_6;
                stringBuilder = new StringBuilder();
                object2 = object;
                stringBuilder.append("Error copying resource contents to temp file: ");
                object2 = object;
                stringBuilder.append(var1_6.getMessage());
                object2 = object;
                Log.e((String)"TypefaceCompatUtil", (String)stringBuilder.toString());
            }
            i.a((Closeable)object);
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
            return false;
        }
        i.a(object2);
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        throw object;
    }
}

