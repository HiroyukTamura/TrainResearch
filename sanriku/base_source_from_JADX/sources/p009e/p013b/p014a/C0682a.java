package p009e.p013b.p014a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p013b.p014a.C0685c;

/* renamed from: e.b.a.a */
public class C0682a implements C0685c.C0686a {

    /* renamed from: e.b.a.a$a */
    private static class C0683a {

        /* renamed from: a */
        public ZipFile f364a;

        /* renamed from: b */
        public ZipEntry f365b;

        public C0683a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f364a = zipFile;
            this.f365b = zipEntry;
        }
    }

    /* renamed from: a */
    private C0683a m341a(Context context, String[] strArr, String str, C0689d dVar) {
        String[] strArr2;
        String[] strArr3;
        String[] strArr4 = strArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        char c = 0;
        int i = 1;
        if (Build.VERSION.SDK_INT < 21 || (strArr3 = applicationInfo.splitSourceDirs) == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[(strArr3.length + 1)];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        int length = strArr2.length;
        int i2 = 0;
        ZipFile zipFile = null;
        while (i2 < length) {
            String str2 = strArr2[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), i);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 >= 5) {
                        break;
                    }
                    int length2 = strArr4.length;
                    int i7 = 0;
                    while (i7 < length2) {
                        String str3 = strArr4[i7];
                        StringBuilder a = C0681a.m330a("lib");
                        a.append(File.separatorChar);
                        a.append(str3);
                        a.append(File.separatorChar);
                        a.append(str);
                        String sb = a.toString();
                        Object[] objArr = new Object[2];
                        objArr[c] = sb;
                        objArr[i] = str2;
                        if (dVar != null) {
                            String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(sb);
                            if (entry != null) {
                                return new C0683a(zipFile, entry);
                            }
                            i7++;
                            c = 0;
                            i = 1;
                        } else {
                            throw null;
                        }
                    }
                    String str4 = str;
                    i5 = i6;
                }
            }
            String str5 = str;
            i2++;
            c = 0;
            i = 1;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: e.b.a.a$a} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:47|48|52|(0)|(0)|66|67) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:33|34|35|36|37|38|39|40|(2:42|115)(1:117)) */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00ba, code lost:
        if (r15 == null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00be, code lost:
        if (r11.f364a == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00c0, code lost:
        r11.f364a.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        throw null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0061 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0064 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x009a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x00b6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x00b6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0071 A[Catch:{ IOException -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0090 A[SYNTHETIC, Splitter:B:60:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0097 A[SYNTHETIC, Splitter:B:64:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x009f A[SYNTHETIC, Splitter:B:71:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ae A[SYNTHETIC, Splitter:B:80:0x00ae] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x0064=Splitter:B:37:0x0064, B:66:0x009a=Splitter:B:66:0x009a} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19768a(android.content.Context r11, java.lang.String[] r12, java.lang.String r13, java.io.File r14, p009e.p013b.p014a.C0689d r15) {
        /*
            r10 = this;
            r0 = 0
            e.b.a.a$a r11 = r10.m341a(r11, r12, r13, r15)     // Catch:{ all -> 0x00d0 }
            if (r11 == 0) goto L_0x00c7
            r12 = 0
            r1 = 0
        L_0x0009:
            int r2 = r1 + 1
            r3 = 5
            if (r1 >= r3) goto L_0x00ba
            java.lang.String r1 = "Found %s! Extracting..."
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x00cd }
            r4[r12] = r13     // Catch:{ all -> 0x00cd }
            if (r15 == 0) goto L_0x00b9
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x00cd }
            java.lang.String.format(r5, r1, r4)     // Catch:{ all -> 0x00cd }
            boolean r1 = r14.exists()     // Catch:{ IOException -> 0x00b6 }
            if (r1 != 0) goto L_0x002a
            boolean r1 = r14.createNewFile()     // Catch:{ IOException -> 0x00b6 }
            if (r1 != 0) goto L_0x002a
            goto L_0x00b6
        L_0x002a:
            java.util.zip.ZipFile r1 = r11.f364a     // Catch:{ FileNotFoundException -> 0x00aa, IOException -> 0x009b, all -> 0x008c }
            java.util.zip.ZipEntry r4 = r11.f365b     // Catch:{ FileNotFoundException -> 0x00aa, IOException -> 0x009b, all -> 0x008c }
            java.io.InputStream r1 = r1.getInputStream(r4)     // Catch:{ FileNotFoundException -> 0x00aa, IOException -> 0x009b, all -> 0x008c }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0088, all -> 0x0084 }
            r4.<init>(r14)     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0088, all -> 0x0084 }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x0082, IOException -> 0x0080, all -> 0x007d }
            r6 = 0
        L_0x003d:
            int r8 = r1.read(r5)     // Catch:{ FileNotFoundException -> 0x0082, IOException -> 0x0080, all -> 0x007d }
            r9 = -1
            if (r8 != r9) goto L_0x0077
            r4.flush()     // Catch:{ FileNotFoundException -> 0x0082, IOException -> 0x0080, all -> 0x007d }
            java.io.FileDescriptor r5 = r4.getFD()     // Catch:{ FileNotFoundException -> 0x0082, IOException -> 0x0080, all -> 0x007d }
            r5.sync()     // Catch:{ FileNotFoundException -> 0x0082, IOException -> 0x0080, all -> 0x007d }
            long r8 = r14.length()     // Catch:{ FileNotFoundException -> 0x0082, IOException -> 0x0080, all -> 0x007d }
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x005e
            r1.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            r4.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00b6
        L_0x005e:
            r1.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0061:
            r4.close()     // Catch:{ IOException -> 0x0064 }
        L_0x0064:
            r14.setReadable(r3, r12)     // Catch:{ all -> 0x00cd }
            r14.setExecutable(r3, r12)     // Catch:{ all -> 0x00cd }
            r14.setWritable(r3)     // Catch:{ all -> 0x00cd }
            java.util.zip.ZipFile r12 = r11.f364a     // Catch:{ IOException -> 0x0076 }
            if (r12 == 0) goto L_0x0076
            java.util.zip.ZipFile r11 = r11.f364a     // Catch:{ IOException -> 0x0076 }
            r11.close()     // Catch:{ IOException -> 0x0076 }
        L_0x0076:
            return
        L_0x0077:
            r4.write(r5, r12, r8)     // Catch:{ FileNotFoundException -> 0x0082, IOException -> 0x0080, all -> 0x007d }
            long r8 = (long) r8
            long r6 = r6 + r8
            goto L_0x003d
        L_0x007d:
            r12 = move-exception
            r0 = r4
            goto L_0x0085
        L_0x0080:
            goto L_0x009d
        L_0x0082:
            goto L_0x00ac
        L_0x0084:
            r12 = move-exception
        L_0x0085:
            r13 = r0
            r0 = r1
            goto L_0x008e
        L_0x0088:
            r4 = r0
            goto L_0x009d
        L_0x008a:
            r4 = r0
            goto L_0x00ac
        L_0x008c:
            r12 = move-exception
            r13 = r0
        L_0x008e:
            if (r0 == 0) goto L_0x0095
            r0.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0095
        L_0x0094:
        L_0x0095:
            if (r13 == 0) goto L_0x009a
            r13.close()     // Catch:{ IOException -> 0x009a }
        L_0x009a:
            throw r12     // Catch:{ all -> 0x00cd }
        L_0x009b:
            r1 = r0
            r4 = r1
        L_0x009d:
            if (r1 == 0) goto L_0x00a4
            r1.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a4
        L_0x00a3:
        L_0x00a4:
            if (r4 == 0) goto L_0x00b6
        L_0x00a6:
            r4.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00b6
        L_0x00aa:
            r1 = r0
            r4 = r1
        L_0x00ac:
            if (r1 == 0) goto L_0x00b3
            r1.close()     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00b3
        L_0x00b2:
        L_0x00b3:
            if (r4 == 0) goto L_0x00b6
            goto L_0x00a6
        L_0x00b6:
            r1 = r2
            goto L_0x0009
        L_0x00b9:
            throw r0     // Catch:{ all -> 0x00cd }
        L_0x00ba:
            if (r15 == 0) goto L_0x00c6
            java.util.zip.ZipFile r12 = r11.f364a     // Catch:{ IOException -> 0x00c5 }
            if (r12 == 0) goto L_0x00c5
            java.util.zip.ZipFile r11 = r11.f364a     // Catch:{ IOException -> 0x00c5 }
            r11.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00c5:
            return
        L_0x00c6:
            throw r0     // Catch:{ all -> 0x00cd }
        L_0x00c7:
            e.b.a.b r12 = new e.b.a.b     // Catch:{ all -> 0x00cd }
            r12.<init>(r13)     // Catch:{ all -> 0x00cd }
            throw r12     // Catch:{ all -> 0x00cd }
        L_0x00cd:
            r12 = move-exception
            r0 = r11
            goto L_0x00d1
        L_0x00d0:
            r12 = move-exception
        L_0x00d1:
            if (r0 == 0) goto L_0x00dc
            java.util.zip.ZipFile r11 = r0.f364a     // Catch:{ IOException -> 0x00dc }
            if (r11 == 0) goto L_0x00dc
            java.util.zip.ZipFile r11 = r0.f364a     // Catch:{ IOException -> 0x00dc }
            r11.close()     // Catch:{ IOException -> 0x00dc }
        L_0x00dc:
            goto L_0x00de
        L_0x00dd:
            throw r12
        L_0x00de:
            goto L_0x00dd
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p013b.p014a.C0682a.mo19768a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, e.b.a.d):void");
    }
}
