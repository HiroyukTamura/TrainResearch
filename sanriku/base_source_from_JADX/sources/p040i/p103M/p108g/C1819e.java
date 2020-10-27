package p040i.p103M.p108g;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1758I;
import p040i.C1930i;
import p040i.C1937n;
import p040i.C1939p;
import p040i.C1952y;
import p040i.C1955z;
import p040i.p103M.C1764b;
import p040i.p103M.p112k.C1890h;
import p042j.C2068f;
import p042j.C2073i;

@JvmName(name = "HttpHeaders")
/* renamed from: i.M.g.e */
public final class C1819e {

    /* renamed from: a */
    private static final C2073i f2424a = C2073i.f2895e.mo29221b("\"\\");

    /* renamed from: b */
    private static final C2073i f2425b = C2073i.f2895e.mo29221b("\t ,=");

    /* renamed from: a */
    private static final String m2868a(C2068f fVar) {
        long b = fVar.mo29146b(f2425b);
        if (b == -1) {
            b = fVar.size();
        }
        if (b != 0) {
            return fVar.mo29167i(b);
        }
        return null;
    }

    /* renamed from: a */
    public static final List<C1930i> m2869a(C1952y yVar, String str) {
        Intrinsics.checkParameterIsNotNull(yVar, "$this$parseChallenges");
        Intrinsics.checkParameterIsNotNull(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = yVar.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt__StringsJVMKt.equals(str, yVar.mo28113a(i), true)) {
                C2068f fVar = new C2068f();
                fVar.mo29138a(yVar.mo28115b(i));
                try {
                    m2871a(fVar, (List<C1930i>) arrayList);
                } catch (EOFException e) {
                    C1890h.C1891a aVar = C1890h.f2683c;
                    C1890h.f2681a.mo27964a("Unable to parse challenge", 5, (Throwable) e);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static final void m2870a(C1939p pVar, C1955z zVar, C1952y yVar) {
        Intrinsics.checkParameterIsNotNull(pVar, "$this$receiveHeaders");
        Intrinsics.checkParameterIsNotNull(zVar, ImagesContract.URL);
        Intrinsics.checkParameterIsNotNull(yVar, "headers");
        if (pVar != C1939p.f2826a) {
            C1937n nVar = C1937n.f2816n;
            List<C1937n> a = C1937n.m3340a(zVar, yVar);
            if (!a.isEmpty()) {
                pVar.mo28093a(zVar, a);
            }
        }
    }

    /* renamed from: a */
    public static final boolean m2872a(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "$this$promisesBody");
        if (Intrinsics.areEqual((Object) i.mo27569y().mo27541f(), (Object) "HEAD")) {
            return false;
        }
        int o = i.mo27558o();
        return (((o >= 100 && o < 200) || o == 204 || o == 304) && C1764b.m2616a(i) == -1 && !StringsKt__StringsJVMKt.equals("chunked", C1758I.m2561a(i, "Transfer-Encoding", (String) null, 2), true)) ? false : true;
    }

    /* renamed from: b */
    private static final boolean m2873b(C2068f fVar) {
        boolean z = false;
        while (!fVar.mo29152c()) {
            byte h = fVar.mo29163h(0);
            if (h == 9 || h == 32) {
                fVar.readByte();
            } else if (h != 44) {
                break;
            } else {
                fVar.readByte();
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static final void m2871a(C2068f fVar, List<C1930i> list) throws EOFException {
        String a;
        int a2;
        String str;
        C2068f fVar2 = fVar;
        List<C1930i> list2 = list;
        while (true) {
            String str2 = null;
            while (true) {
                if (str2 == null) {
                    m2873b(fVar);
                    str2 = m2868a(fVar);
                    if (str2 == null) {
                        return;
                    }
                }
                boolean b = m2873b(fVar);
                a = m2868a(fVar);
                if (a != null) {
                    byte b2 = (byte) 61;
                    a2 = C1764b.m2606a(fVar2, b2);
                    boolean b3 = m2873b(fVar);
                    if (b || (!b3 && !fVar.mo29152c())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int a3 = C1764b.m2606a(fVar2, b2) + a2;
                        while (true) {
                            if (a == null) {
                                a = m2868a(fVar);
                                if (m2873b(fVar)) {
                                    continue;
                                    break;
                                }
                                a3 = C1764b.m2606a(fVar2, b2);
                            }
                            if (a3 == 0) {
                                continue;
                                break;
                            }
                            boolean z = true;
                            if (a3 <= 1 && !m2873b(fVar)) {
                                byte b4 = (byte) 34;
                                if (!fVar.mo29152c() && fVar2.mo29163h(0) == b4) {
                                    if (fVar.readByte() != b4) {
                                        z = false;
                                    }
                                    if (z) {
                                        C2068f fVar3 = new C2068f();
                                        while (true) {
                                            long b5 = fVar2.mo29146b(f2424a);
                                            if (b5 == -1) {
                                                break;
                                            } else if (fVar2.mo29163h(b5) == b4) {
                                                fVar3.mo27647a(fVar2, b5);
                                                fVar.readByte();
                                                str = fVar3.mo29175o();
                                                break;
                                            } else if (fVar.size() == b5 + 1) {
                                                break;
                                            } else {
                                                fVar3.mo27647a(fVar2, b5);
                                                fVar.readByte();
                                                fVar3.mo27647a(fVar2, 1);
                                            }
                                        }
                                        str = null;
                                    } else {
                                        throw new IllegalArgumentException("Failed requirement.".toString());
                                    }
                                } else {
                                    str = m2868a(fVar);
                                }
                                if (str != null && ((String) linkedHashMap.put(a, str)) == null) {
                                    if (m2873b(fVar) || fVar.mo29152c()) {
                                        a = null;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list2.add(new C1930i(str2, linkedHashMap));
                        str2 = a;
                    }
                } else if (fVar.mo29152c()) {
                    list2.add(new C1930i(str2, MapsKt__MapsKt.emptyMap()));
                    return;
                } else {
                    return;
                }
            }
            StringBuilder a4 = C0681a.m330a(a);
            a4.append(StringsKt__StringsJVMKt.repeat("=", a2));
            Map singletonMap = Collections.singletonMap((Object) null, a4.toString());
            Intrinsics.checkExpressionValueIsNotNull(singletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
            list2.add(new C1930i(str2, singletonMap));
        }
    }
}
