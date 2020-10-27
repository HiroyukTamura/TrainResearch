package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

public final class CustomTabColorSchemeParams {
    @ColorInt
    @Nullable
    public final Integer navigationBarColor;
    @ColorInt
    @Nullable
    public final Integer secondaryToolbarColor;
    @ColorInt
    @Nullable
    public final Integer toolbarColor;

    public static final class Builder {
        @ColorInt
        @Nullable
        private Integer mNavigationBarColor;
        @ColorInt
        @Nullable
        private Integer mSecondaryToolbarColor;
        @ColorInt
        @Nullable
        private Integer mToolbarColor;

        @NonNull
        public CustomTabColorSchemeParams build() {
            return new CustomTabColorSchemeParams(this.mToolbarColor, this.mSecondaryToolbarColor, this.mNavigationBarColor);
        }

        @NonNull
        public Builder setNavigationBarColor(@ColorInt int i) {
            this.mNavigationBarColor = Integer.valueOf(i | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }

        @NonNull
        public Builder setSecondaryToolbarColor(@ColorInt int i) {
            this.mSecondaryToolbarColor = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder setToolbarColor(@ColorInt int i) {
            this.mToolbarColor = Integer.valueOf(i | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }
    }

    CustomTabColorSchemeParams(@ColorInt @Nullable Integer num, @ColorInt @Nullable Integer num2, @ColorInt @Nullable Integer num3) {
        this.toolbarColor = num;
        this.secondaryToolbarColor = num2;
        this.navigationBarColor = num3;
    }

    @NonNull
    static CustomTabColorSchemeParams fromBundle(@Nullable Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(0);
        }
        return new CustomTabColorSchemeParams((Integer) bundle.get(CustomTabsIntent.EXTRA_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        Integer num = this.toolbarColor;
        if (num != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, num.intValue());
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR, num2.intValue());
        }
        Integer num3 = this.navigationBarColor;
        if (num3 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR, num3.intValue());
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CustomTabColorSchemeParams withDefaults(@NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
        Integer num = this.toolbarColor;
        if (num == null) {
            num = customTabColorSchemeParams.toolbarColor;
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 == null) {
            num2 = customTabColorSchemeParams.secondaryToolbarColor;
        }
        Integer num3 = this.navigationBarColor;
        if (num3 == null) {
            num3 = customTabColorSchemeParams.navigationBarColor;
        }
        return new CustomTabColorSchemeParams(num, num2, num3);
    }
}
