package p043jp.reifrontier.silentlogsdkandroid.utils;

import android.content.Context;
import java.io.File;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogger;", "", "clientContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "baseFileName", "", "isRunWriteThread", "", "logDataQueue", "Ljava/util/Queue;", "addQueue", "", "level", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogger$LEVEL;", "message", "error", "getOutputFile", "Ljava/io/File;", "info", "outputLog", "rotateLogFile", "threadQueue", "writeLogFile", "logBuffer", "Ljava/lang/StringBuffer;", "Companion", "LEVEL", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLLogger */
public final class RFLLogger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final String f3812a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f3813b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Queue<String> f3814c = new ConcurrentLinkedQueue();

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogger$Companion;", "", "()V", "FILE_NAME_EXT", "", "MAX_BACKUP_SIZE", "", "MAX_FILE_SIZE", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLLogger$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLLogger$a */
    private enum C2348a {
        INFO,
        ERROR
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLLogger$b */
    static final class C2349b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLLogger f3818a;

        C2349b(RFLLogger rFLLogger) {
            this.f3818a = rFLLogger;
        }

        public final void run() {
            StringBuffer stringBuffer = new StringBuffer();
            while (!this.f3818a.f3814c.isEmpty()) {
                String str = (String) this.f3818a.f3814c.poll();
                if (str != null) {
                    stringBuffer.append(str);
                }
            }
            this.f3818a.m3940a(stringBuffer);
            this.f3818a.f3813b = false;
        }
    }

    public RFLLogger(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "clientContext");
        File filesDir = context.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir, "clientContext.filesDir");
        String absolutePath = filesDir.getAbsolutePath();
        String packageName = context.getPackageName();
        this.f3812a = absolutePath + '/' + packageName + "-sdk.log";
    }

    /* renamed from: a */
    private final synchronized File m3939a() {
        File file;
        file = new File(this.f3812a);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
        } else if (file.length() > ((long) 524288)) {
            m3942b();
        }
        file.createNewFile();
        return file;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
        throw r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m3940a(java.lang.StringBuffer r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r6.length()     // Catch:{ all -> 0x0050 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000b
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 == 0) goto L_0x0010
            monitor-exit(r5)
            return
        L_0x0010:
            java.io.File r0 = r5.m3939a()     // Catch:{ all -> 0x0050 }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ all -> 0x0050 }
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ all -> 0x0050 }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x0050 }
            r3.<init>(r4)     // Catch:{ all -> 0x0050 }
            r0 = 0
            r3.append(r6)     // Catch:{ Exception -> 0x0028 }
            r3.flush()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0043
        L_0x0026:
            r6 = move-exception
            goto L_0x004a
        L_0x0028:
            r6 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
            r1.<init>()     // Catch:{ all -> 0x0026 }
            java.lang.String r4 = "[SilentLogSDK]::Error writeLogFile:"
            r1.append(r4)     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = r6.getLocalizedMessage()     // Catch:{ all -> 0x0026 }
            r1.append(r6)     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0026 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0026 }
            p048l.p049a.C1122a.m1599b(r6, r1)     // Catch:{ all -> 0x0026 }
        L_0x0043:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0026 }
            kotlin.p045io.CloseableKt.closeFinally(r3, r0)     // Catch:{ all -> 0x0050 }
            monitor-exit(r5)
            return
        L_0x004a:
            throw r6     // Catch:{ all -> 0x004b }
        L_0x004b:
            r0 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r3, r6)     // Catch:{ all -> 0x0050 }
            throw r0     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.utils.RFLLogger.m3940a(java.lang.StringBuffer):void");
    }

    /* renamed from: a */
    private final void m3941a(C2348a aVar, String str) {
        String format$default = RFLDailyUtilsKt.format$default(new Date(), "yyyy-MM-dd HH:mm:ss.SSS", (String) null, 2, (Object) null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String a = C0681a.m328a(new Object[]{aVar.name()}, 1, "%5s", "java.lang.String.format(format, *args)");
        this.f3814c.offer(format$default + ' ' + a + ':' + str + 10);
    }

    /* renamed from: b */
    private final synchronized void m3942b() {
        File file;
        for (int i = 5; i >= 0; i--) {
            if (i == 0) {
                file = new File(this.f3812a);
            } else {
                file = new File(this.f3812a + '.' + i);
            }
            if (i == 5) {
                file.deleteOnExit();
            } else if (file.exists()) {
                File file2 = new File(this.f3812a + '.' + (i + 1));
                file2.deleteOnExit();
                file.renameTo(file2);
            }
        }
    }

    /* renamed from: b */
    private final void m3943b(C2348a aVar, String str) {
        m3941a(aVar, str);
        m3944c();
    }

    /* renamed from: c */
    private final synchronized void m3944c() {
        try {
            if (!this.f3813b) {
                this.f3813b = true;
                new Thread(new C2349b(this)).start();
            } else {
                return;
            }
        } catch (Exception e) {
            C1122a.m1599b("[SilentLogSDK]::Error threadQueue:" + e.getLocalizedMessage(), new Object[0]);
        }
        return;
    }

    public final void error(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        m3943b(C2348a.ERROR, str);
    }

    public final void info(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        m3943b(C2348a.INFO, str);
    }
}
