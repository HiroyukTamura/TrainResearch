package com.google.ads.mediation;

import com.google.android.gms.internal.ads.zzazw;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

@Deprecated
/* renamed from: com.google.ads.mediation.e */
public class C0563e {

    /* renamed from: com.google.ads.mediation.e$a */
    public static final class C0564a extends Exception {
        public C0564a(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.google.ads.mediation.e$b */
    public @interface C0565b {
        String name();

        boolean required() default true;
    }

    /* renamed from: a */
    public void mo9417a(Map<String, String> map) throws C0564a {
        StringBuilder sb;
        String str;
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            C0565b bVar = (C0565b) field.getAnnotation(C0565b.class);
            if (bVar != null) {
                hashMap.put(bVar.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzazw.zzfc("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry next : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(next.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, next.getValue());
                } catch (IllegalAccessException unused) {
                    String str2 = (String) next.getKey();
                    sb = new StringBuilder(C0681a.m336b(str2, 49));
                    sb.append("Server option \"");
                    sb.append(str2);
                    str = "\" could not be set: Illegal Access";
                } catch (IllegalArgumentException unused2) {
                    String str3 = (String) next.getKey();
                    sb = new StringBuilder(C0681a.m336b(str3, 43));
                    sb.append("Server option \"");
                    sb.append(str3);
                    str = "\" could not be set: Bad Type";
                }
            } else {
                String str4 = (String) next.getKey();
                String str5 = (String) next.getValue();
                StringBuilder b = C0681a.m337b(C0681a.m336b(str5, C0681a.m336b(str4, 31)), "Unexpected server option: ", str4, " = \"", str5);
                b.append("\"");
                zzazw.zzed(b.toString());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((C0565b) field3.getAnnotation(C0565b.class)).required()) {
                String valueOf = String.valueOf(((C0565b) field3.getAnnotation(C0565b.class)).name());
                zzazw.zzfc(valueOf.length() != 0 ? "Required server option missing: ".concat(valueOf) : new String("Required server option missing: "));
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(((C0565b) field3.getAnnotation(C0565b.class)).name());
            }
        }
        if (sb2.length() > 0) {
            String valueOf2 = String.valueOf(sb2.toString());
            throw new C0564a(valueOf2.length() != 0 ? "Required server option(s) missing: ".concat(valueOf2) : new String("Required server option(s) missing: "));
        }
        return;
        sb.append(str);
        zzazw.zzfc(sb.toString());
    }
}
