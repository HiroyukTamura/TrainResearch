package p040i;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.i */
public final class C1930i {

    /* renamed from: a */
    private final Map<String, String> f2781a;

    /* renamed from: b */
    private final String f2782b;

    public C1930i(String str, Map<String, String> map) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        Intrinsics.checkParameterIsNotNull(map, "authParams");
        this.f2782b = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            String str3 = (String) next.getKey();
            String str4 = (String) next.getValue();
            if (str3 != null) {
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "US");
                str2 = str3.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            linkedHashMap.put(str2, str4);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f2781a = unmodifiableMap;
    }

    @JvmName(name = "charset")
    /* renamed from: a */
    public final Charset mo28067a() {
        String str = this.f2781a.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        Intrinsics.checkExpressionValueIsNotNull(charset, "ISO_8859_1");
        return charset;
    }

    @JvmName(name = "realm")
    /* renamed from: b */
    public final String mo28068b() {
        return this.f2781a.get("realm");
    }

    @JvmName(name = "scheme")
    /* renamed from: c */
    public final String mo28069c() {
        return this.f2782b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1930i) {
            C1930i iVar = (C1930i) obj;
            return Intrinsics.areEqual((Object) iVar.f2782b, (Object) this.f2782b) && Intrinsics.areEqual((Object) iVar.f2781a, (Object) this.f2781a);
        }
    }

    public int hashCode() {
        return this.f2781a.hashCode() + ((this.f2782b.hashCode() + 899) * 31);
    }

    public String toString() {
        return this.f2782b + " authParams=" + this.f2781a;
    }
}
