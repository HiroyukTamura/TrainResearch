package com.google.android.gms.internal.gtm;

import java.io.PrintStream;

public final class zzpf {
    private static final zzpg zzavi;
    private static final int zzavj;

    static final class zza extends zzpg {
        zza() {
        }

        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = zzmu()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0015
            int r2 = r1.intValue()     // Catch:{ all -> 0x002a }
            r3 = 19
            if (r2 < r3) goto L_0x0015
            com.google.android.gms.internal.gtm.zzpk r2 = new com.google.android.gms.internal.gtm.zzpk     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x005f
        L_0x0015:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch:{ all -> 0x002a }
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.gtm.zzpj r2 = new com.google.android.gms.internal.gtm.zzpj     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x005f
        L_0x0024:
            com.google.android.gms.internal.gtm.zzpf$zza r2 = new com.google.android.gms.internal.gtm.zzpf$zza     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x005f
        L_0x002a:
            r2 = move-exception
            goto L_0x002e
        L_0x002c:
            r2 = move-exception
            r1 = 0
        L_0x002e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.gtm.zzpf$zza> r4 = com.google.android.gms.internal.gtm.zzpf.zza.class
            java.lang.String r4 = r4.getName()
            int r5 = r4.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.gtm.zzpf$zza r2 = new com.google.android.gms.internal.gtm.zzpf$zza
            r2.<init>()
        L_0x005f:
            zzavi = r2
            if (r1 != 0) goto L_0x0064
            goto L_0x0068
        L_0x0064:
            int r0 = r1.intValue()
        L_0x0068:
            zzavj = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzpf.<clinit>():void");
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzavi.zza(th, printStream);
    }

    private static Integer zzmu() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
