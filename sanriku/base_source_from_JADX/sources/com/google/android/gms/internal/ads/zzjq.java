package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzln;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzjq {
    private static final zzlr zzaob = new zzjp();
    private static final Pattern zzaoc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzagv = -1;
    public int zzagw = -1;

    private final boolean zzb(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = zzaoc.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzagv = parseInt;
                    this.zzagw = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean zzb(zzln zzln) {
        for (int i = 0; i < zzln.length(); i++) {
            zzln.zza zzau = zzln.zzau(i);
            if (zzau instanceof zzlp) {
                zzlp zzlp = (zzlp) zzau;
                if (zzb(zzlp.description, zzlp.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzgs() {
        return (this.zzagv == -1 || this.zzagw == -1) ? false : true;
    }
}
