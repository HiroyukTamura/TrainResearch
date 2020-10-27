package androidx.browser.trusted;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.TrustedWebUtils;
import java.util.ArrayList;
import java.util.List;

public class TrustedWebActivityIntentBuilder {
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ADDITIONAL_TRUSTED_ORIGINS = "android.support.customtabs.extra.ADDITIONAL_TRUSTED_ORIGINS";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SPLASH_SCREEN_PARAMS = "androidx.browser.trusted.EXTRA_SPLASH_SCREEN_PARAMS";
    @Nullable
    private List<String> mAdditionalTrustedOrigins;
    @NonNull
    private final CustomTabsIntent.Builder mIntentBuilder = new CustomTabsIntent.Builder();
    @Nullable
    private Bundle mSplashScreenParams;
    @NonNull
    private final Uri mUri;

    public TrustedWebActivityIntentBuilder(@NonNull Uri uri) {
        this.mUri = uri;
    }

    @NonNull
    public Intent build(@NonNull CustomTabsSession customTabsSession) {
        if (customTabsSession != null) {
            this.mIntentBuilder.setSession(customTabsSession);
            Intent intent = this.mIntentBuilder.build().intent;
            intent.setData(this.mUri);
            intent.putExtra(TrustedWebUtils.EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY, true);
            if (this.mAdditionalTrustedOrigins != null) {
                intent.putExtra(EXTRA_ADDITIONAL_TRUSTED_ORIGINS, new ArrayList(this.mAdditionalTrustedOrigins));
            }
            Bundle bundle = this.mSplashScreenParams;
            if (bundle != null) {
                intent.putExtra(EXTRA_SPLASH_SCREEN_PARAMS, bundle);
            }
            return intent;
        }
        throw new NullPointerException("CustomTabsSession is required for launching a TWA");
    }

    @NonNull
    public CustomTabsIntent buildCustomTabsIntent() {
        return this.mIntentBuilder.build();
    }

    @NonNull
    public Uri getUrl() {
        return this.mUri;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setAdditionalTrustedOrigins(@NonNull List<String> list) {
        this.mAdditionalTrustedOrigins = list;
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setColorScheme(int i) {
        this.mIntentBuilder.setColorScheme(i);
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setColorSchemeParams(int i, @NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
        this.mIntentBuilder.setColorSchemeParams(i, customTabColorSchemeParams);
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setNavigationBarColor(@ColorInt int i) {
        this.mIntentBuilder.setNavigationBarColor(i);
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setSplashScreenParams(@NonNull Bundle bundle) {
        this.mSplashScreenParams = bundle;
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setToolbarColor(@ColorInt int i) {
        this.mIntentBuilder.setToolbarColor(i);
        return this;
    }
}
