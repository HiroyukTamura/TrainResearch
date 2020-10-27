package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdpt implements FilenameFilter {
    private final Pattern zzgvg;

    public zzdpt(Pattern pattern) {
        this.zzgvg = (Pattern) zzdoj.checkNotNull(pattern);
    }

    public final boolean accept(@NullableDecl File file, String str) {
        return this.zzgvg.matcher(str).matches();
    }
}
