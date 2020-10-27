package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzdhm {
    private final Pattern zzgvg;

    @VisibleForTesting
    public zzdhm() {
        Pattern pattern;
        try {
            pattern = Pattern.compile((String) zzvj.zzpv().zzd(zzzz.zzcud));
        } catch (PatternSyntaxException unused) {
            pattern = null;
        }
        this.zzgvg = pattern;
    }

    @Nullable
    public final String zzgs(@Nullable String str) {
        Pattern pattern = this.zzgvg;
        if (!(pattern == null || str == null)) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
