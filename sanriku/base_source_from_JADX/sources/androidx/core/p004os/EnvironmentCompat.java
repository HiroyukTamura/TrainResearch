package androidx.core.p004os;

import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import java.io.File;

/* renamed from: androidx.core.os.EnvironmentCompat */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    private EnvironmentCompat() {
    }

    @NonNull
    public static String getStorageState(@NonNull File file) {
        return Build.VERSION.SDK_INT >= 21 ? Environment.getExternalStorageState(file) : Environment.getStorageState(file);
    }
}
