package p041io.realm.internal;

import android.content.Context;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Locale;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p013b.p014a.C0685c;

/* renamed from: io.realm.internal.RealmCore */
public class RealmCore {
    private static final String BINARIES_PATH;
    private static final String FILE_SEP = File.separator;
    private static final String JAVA_LIBRARY_PATH = "java.library.path";
    private static final String PATH_SEP = File.pathSeparator;
    private static boolean libraryIsLoaded = false;

    static {
        StringBuilder a = C0681a.m330a("lib");
        a.append(PATH_SEP);
        a.append("..");
        BINARIES_PATH = C0681a.m324a(a, FILE_SEP, "lib");
    }

    public static void addNativeLibraryPath(String str) {
        try {
            System.setProperty(JAVA_LIBRARY_PATH, System.getProperty(JAVA_LIBRARY_PATH) + PATH_SEP + str + PATH_SEP);
        } catch (Exception e) {
            throw new RuntimeException("Cannot set the library path!", e);
        }
    }

    private static String loadCorrectLibrary(String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                System.loadLibrary(str);
                return str;
            } catch (Throwable unused) {
                i++;
            }
        }
        return null;
    }

    public static synchronized void loadLibrary(Context context) {
        synchronized (RealmCore.class) {
            if (!libraryIsLoaded) {
                C0685c.m343a(context, "realm-jni", "6.0.0");
                libraryIsLoaded = true;
            }
        }
    }

    private static String loadLibraryWindows() {
        try {
            addNativeLibraryPath(BINARIES_PATH);
            resetLibraryPath();
        } catch (Throwable unused) {
        }
        String loadCorrectLibrary = loadCorrectLibrary("realm_jni32d", "realm_jni64d");
        if (loadCorrectLibrary != null) {
            System.out.println("!!! Realm debug version loaded. !!!\n");
        } else {
            loadCorrectLibrary = loadCorrectLibrary("realm_jni32", "realm_jni64");
            if (loadCorrectLibrary == null) {
                PrintStream printStream = System.err;
                StringBuilder a = C0681a.m330a("Searched java.library.path=");
                a.append(System.getProperty(JAVA_LIBRARY_PATH));
                printStream.println(a.toString());
                throw new RuntimeException("Couldn't load the Realm JNI library 'realm_jni32.dll or realm_jni64.dll'. Please include the directory to the library in java.library.path.");
            }
        }
        return loadCorrectLibrary;
    }

    public static boolean osIsWindows() {
        return System.getProperty("os.name").toLowerCase(Locale.getDefault()).contains("win");
    }

    private static void resetLibraryPath() {
        try {
            Field declaredField = ClassLoader.class.getDeclaredField("sys_paths");
            declaredField.setAccessible(true);
            declaredField.set((Object) null, (Object) null);
        } catch (Exception e) {
            throw new RuntimeException("Cannot reset the library path!", e);
        }
    }
}
