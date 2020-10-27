package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

public class IdManager implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";
    private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");
    private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
    static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
    static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
    static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
    private final Context appContext;
    private final String appIdentifier;
    private String crashlyticsInstallId;
    private final FirebaseInstanceIdInternal firebaseInstallId;
    private final InstallerPackageNameProvider installerPackageNameProvider;

    public IdManager(Context context, String str, FirebaseInstanceIdInternal firebaseInstanceIdInternal) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.appContext = context;
            this.appIdentifier = str;
            this.firebaseInstallId = firebaseInstanceIdInternal;
            this.installerPackageNameProvider = new InstallerPackageNameProvider();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    private synchronized String createAndStoreIid(String str, SharedPreferences sharedPreferences) {
        String formatId;
        formatId = formatId(UUID.randomUUID().toString());
        Logger logger = Logger.getLogger();
        logger.mo25712d("Created new Crashlytics IID: " + formatId);
        sharedPreferences.edit().putString("crashlytics.installation.id", formatId).putString(PREFKEY_FIREBASE_IID, str).apply();
        return formatId;
    }

    private static String formatId(String str) {
        if (str == null) {
            return null;
        }
        return ID_PATTERN.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    private synchronized void migrateLegacyId(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        Logger logger = Logger.getLogger();
        logger.mo25712d("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString(PREFKEY_FIREBASE_IID, str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove(PREFKEY_ADVERTISING_ID).apply();
    }

    private String removeForwardSlashesIn(String str) {
        return str.replaceAll(FORWARD_SLASH_REGEX, "");
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    @NonNull
    public synchronized String getCrashlyticsInstallId() {
        String createAndStoreIid;
        if (this.crashlyticsInstallId != null) {
            return this.crashlyticsInstallId;
        }
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.appContext);
        String id = this.firebaseInstallId.getId();
        String string = sharedPrefs.getString(PREFKEY_FIREBASE_IID, (String) null);
        if (string == null) {
            SharedPreferences legacySharedPrefs = CommonUtils.getLegacySharedPrefs(this.appContext);
            String string2 = legacySharedPrefs.getString("crashlytics.installation.id", (String) null);
            Logger logger = Logger.getLogger();
            logger.mo25712d("No cached FID; legacy id is " + string2);
            if (string2 == null) {
                this.crashlyticsInstallId = createAndStoreIid(id, sharedPrefs);
            } else {
                this.crashlyticsInstallId = string2;
                migrateLegacyId(string2, id, sharedPrefs, legacySharedPrefs);
            }
            return this.crashlyticsInstallId;
        }
        if (string.equals(id)) {
            this.crashlyticsInstallId = sharedPrefs.getString("crashlytics.installation.id", (String) null);
            Logger logger2 = Logger.getLogger();
            logger2.mo25712d("Found matching FID, using Crashlytics IID: " + this.crashlyticsInstallId);
            if (this.crashlyticsInstallId == null) {
                createAndStoreIid = createAndStoreIid(id, sharedPrefs);
            }
            return this.crashlyticsInstallId;
        }
        createAndStoreIid = createAndStoreIid(id, sharedPrefs);
        this.crashlyticsInstallId = createAndStoreIid;
        return this.crashlyticsInstallId;
    }

    public String getInstallerPackageName() {
        return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", new Object[]{removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL)});
    }

    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
    }

    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(Build.VERSION.RELEASE);
    }
}