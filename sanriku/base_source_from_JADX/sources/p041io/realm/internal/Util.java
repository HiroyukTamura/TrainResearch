package p041io.realm.internal;

import android.os.Build;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.RealmModel;
import p041io.realm.RealmObject;
import p041io.realm.log.RealmLog;

/* renamed from: io.realm.internal.Util */
public class Util {
    public static boolean deleteRealm(String str, File file, String str2) {
        boolean z;
        File file2 = new File(file, C0681a.m320a(str2, ".management"));
        File file3 = new File(str);
        File file4 = new File(C0681a.m320a(str, ".note"));
        File[] listFiles = file2.listFiles();
        if (listFiles != null) {
            for (File file5 : listFiles) {
                if (!file5.delete()) {
                    RealmLog.warn(String.format(Locale.ENGLISH, "Realm temporary file at %s cannot be deleted", new Object[]{file5.getAbsolutePath()}), new Object[0]);
                }
            }
        }
        if (file2.exists() && !file2.delete()) {
            RealmLog.warn(String.format(Locale.ENGLISH, "Realm temporary folder at %s cannot be deleted", new Object[]{file2.getAbsolutePath()}), new Object[0]);
        }
        if (file3.exists()) {
            z = file3.delete();
            if (!z) {
                RealmLog.warn(String.format(Locale.ENGLISH, "Realm file at %s cannot be deleted", new Object[]{file3.getAbsolutePath()}), new Object[0]);
            }
        } else {
            z = true;
        }
        if (file4.exists() && !file4.delete()) {
            RealmLog.warn(String.format(Locale.ENGLISH, ".note file at %s cannot be deleted", new Object[]{file4.getAbsolutePath()}), new Object[0]);
        }
        return z;
    }

    public static Class<? extends RealmModel> getOriginalModelClass(Class<? extends RealmModel> cls) {
        Class<RealmObject> cls2 = RealmObject.class;
        if (cls.equals(RealmModel.class) || cls.equals(cls2)) {
            throw new IllegalArgumentException("RealmModel or RealmObject was passed as an argument. Only subclasses of these can be used as arguments to methods that accept a Realm model class.");
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass.equals(Object.class) || superclass.equals(cls2)) ? cls : superclass;
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static String getTablePrefix() {
        return nativeGetTablePrefix();
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmulator() {
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }

    static native String nativeGetTablePrefix();

    public static <T> Set<T> toSet(T... tArr) {
        if (tArr == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (T t : tArr) {
            if (t != null) {
                linkedHashSet.add(t);
            }
        }
        return linkedHashSet;
    }
}
