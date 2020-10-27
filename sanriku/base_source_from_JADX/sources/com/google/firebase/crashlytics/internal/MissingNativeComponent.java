package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
import java.io.File;

public final class MissingNativeComponent implements CrashlyticsNativeComponent {
    private static final NativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER = new MissingNativeSessionFileProvider();

    private static final class MissingNativeSessionFileProvider implements NativeSessionFileProvider {
        private MissingNativeSessionFileProvider() {
        }

        public File getAppFile() {
            return null;
        }

        public File getBinaryImagesFile() {
            return null;
        }

        public File getDeviceFile() {
            return null;
        }

        public File getMetadataFile() {
            return null;
        }

        public File getMinidumpFile() {
            return null;
        }

        public File getOsFile() {
            return null;
        }

        public File getSessionFile() {
            return null;
        }
    }

    public boolean finalizeSession(@NonNull String str) {
        return true;
    }

    @NonNull
    public NativeSessionFileProvider getSessionFileProvider(@NonNull String str) {
        return MISSING_NATIVE_SESSION_FILE_PROVIDER;
    }

    public boolean hasCrashDataForSession(@NonNull String str) {
        return false;
    }

    public boolean openSession(@NonNull String str) {
        return true;
    }

    public void writeBeginSession(@NonNull String str, @NonNull String str2, long j) {
    }

    public void writeSessionApp(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) {
    }

    public void writeSessionDevice(@NonNull String str, int i, @NonNull String str2, int i2, long j, long j2, boolean z, int i3, @NonNull String str3, @NonNull String str4) {
    }

    public void writeSessionOs(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
    }
}
