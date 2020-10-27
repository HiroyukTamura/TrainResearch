package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzazw;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestConfiguration {
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    public static final List<String> zzacu = Arrays.asList(new String[]{"MA", "T", "PG", "G"});
    private final int zzacq;
    private final int zzacr;
    private final String zzacs;
    private final List<String> zzact;

    public static class Builder {
        private int zzacq = -1;
        private int zzacr = -1;
        private String zzacs = null;
        private final List<String> zzact = new ArrayList();

        public RequestConfiguration build() {
            return new RequestConfiguration(this.zzacq, this.zzacr, this.zzacs, this.zzact);
        }

        public Builder setMaxAdContentRating(String str) {
            if (str == null || "".equals(str)) {
                str = null;
            } else if (!"G".equals(str) && !"PG".equals(str) && !"T".equals(str) && !"MA".equals(str)) {
                zzazw.zzfc(str.length() != 0 ? "Invalid value passed to setMaxAdContentRating: ".concat(str) : new String("Invalid value passed to setMaxAdContentRating: "));
                return this;
            }
            this.zzacs = str;
            return this;
        }

        public Builder setTagForChildDirectedTreatment(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzacq = i;
            } else {
                StringBuilder sb = new StringBuilder(68);
                sb.append("Invalid value passed to setTagForChildDirectedTreatment: ");
                sb.append(i);
                zzazw.zzfc(sb.toString());
            }
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzacr = i;
            } else {
                StringBuilder sb = new StringBuilder(63);
                sb.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
                sb.append(i);
                zzazw.zzfc(sb.toString());
            }
            return this;
        }

        public Builder setTestDeviceIds(List<String> list) {
            this.zzact.clear();
            if (list != null) {
                this.zzact.addAll(list);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    private RequestConfiguration(int i, int i2, String str, List<String> list) {
        this.zzacq = i;
        this.zzacr = i2;
        this.zzacs = str;
        this.zzact = list;
    }

    public String getMaxAdContentRating() {
        String str = this.zzacs;
        return str == null ? "" : str;
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzacq;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzacr;
    }

    public List<String> getTestDeviceIds() {
        return new ArrayList(this.zzact);
    }

    public Builder toBuilder() {
        return new Builder().setTagForChildDirectedTreatment(this.zzacq).setTagForUnderAgeOfConsent(this.zzacr).setMaxAdContentRating(this.zzacs).setTestDeviceIds(this.zzact);
    }
}
