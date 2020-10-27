package p009e.p028d.p061c.p062a;

import android.content.pm.PackageManager;
import java.util.Arrays;
import java.util.List;

/* renamed from: e.d.c.a.d */
public class C1561d {

    /* renamed from: a */
    private static final List<String> f1820a = Arrays.asList(new String[]{"com.google.android.apps.chrome", "org.chromium.chrome", "com.chrome.canary", "com.chrome.dev", "com.chrome.beta", "com.android.chrome"});

    /* renamed from: b */
    private static final List<String> f1821b = Arrays.asList(new String[]{"com.google.android.apps.chrome", "org.chromium.chrome"});

    static {
        Arrays.asList(new String[]{"com.chrome.beta", "com.android.chrome"});
    }

    /* renamed from: a */
    public static boolean m2177a(PackageManager packageManager, String str) {
        if (!f1820a.contains(str)) {
            return true;
        }
        return m2178a(packageManager, str, 368300000);
    }

    /* renamed from: a */
    private static boolean m2178a(PackageManager packageManager, String str, int i) {
        int i2;
        if (f1821b.contains(str)) {
            return true;
        }
        try {
            i2 = packageManager.getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            i2 = 0;
        }
        return i2 >= i;
    }

    /* renamed from: b */
    public static boolean m2179b(PackageManager packageManager, String str) {
        if (!f1820a.contains(str)) {
            return false;
        }
        return m2178a(packageManager, str, 362600000);
    }
}
