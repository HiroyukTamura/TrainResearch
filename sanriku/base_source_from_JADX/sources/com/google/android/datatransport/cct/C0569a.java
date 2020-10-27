package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.p032i.C0894e;

/* renamed from: com.google.android.datatransport.cct.a */
public final class C0569a implements C0894e {

    /* renamed from: c */
    static final String f122c = C0610f.m197a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* renamed from: d */
    static final String f123d = C0610f.m197a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");

    /* renamed from: e */
    private static final String f124e = C0610f.m197a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");

    /* renamed from: f */
    private static final Set<C0875b> f125f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new C0875b[]{C0875b.m1149a("proto"), C0875b.m1149a("json")})));

    /* renamed from: g */
    public static final C0569a f126g = new C0569a(f123d, f124e);
    @NonNull

    /* renamed from: a */
    private final String f127a;
    @Nullable

    /* renamed from: b */
    private final String f128b;

    static {
        new C0569a(f122c, (String) null);
    }

    public C0569a(@NonNull String str, @Nullable String str2) {
        this.f127a = str;
        this.f128b = str2;
    }

    @NonNull
    /* renamed from: a */
    public static C0569a m57a(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new C0569a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    /* renamed from: a */
    public Set<C0875b> mo9430a() {
        return f125f;
    }

    @Nullable
    /* renamed from: b */
    public String mo9431b() {
        return this.f128b;
    }

    @NonNull
    /* renamed from: c */
    public String mo9432c() {
        return this.f127a;
    }

    @Nullable
    public byte[] getExtras() {
        if (this.f128b == null && this.f127a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f127a;
        objArr[2] = "\\";
        String str = this.f128b;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    @NonNull
    public String getName() {
        return "cct";
    }
}
