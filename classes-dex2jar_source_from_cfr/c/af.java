/*
 * Decompiled with CFR 0.139.
 */
package c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum af {
    a("TLSv1.3"),
    b("TLSv1.2"),
    c("TLSv1.1"),
    d("TLSv1"),
    e("SSLv3");
    
    final String f;

    private af(String string3) {
        this.f = string3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static af a(String var0) {
        block19 : {
            block17 : {
                block18 : {
                    var1_1 = var0.hashCode();
                    if (var1_1 == 79201641) break block17;
                    if (var1_1 == 79923350) break block18;
                    switch (var1_1) {
                        default: {
                            ** GOTO lbl-1000
                        }
                        case -503070501: {
                            if (var0.equals("TLSv1.3")) {
                                var1_1 = 0;
                                ** break;
                            }
                            ** GOTO lbl-1000
                        }
                        case -503070502: {
                            if (var0.equals("TLSv1.2")) {
                                var1_1 = 1;
                                ** break;
                            }
                            ** GOTO lbl-1000
                        }
                        case -503070503: {
                            if (var0.equals("TLSv1.1")) {
                                var1_1 = 2;
                                ** break;
                            }
                            ** GOTO lbl-1000
lbl22: // 3 sources:
                            break;
                        }
                    }
                    break block19;
                }
                if (!var0.equals("TLSv1")) ** GOTO lbl-1000
                var1_1 = 3;
                break block19;
            }
            if (var0.equals("SSLv3")) {
                var1_1 = 4;
            } else lbl-1000: // 6 sources:
            {
                var1_1 = -1;
            }
        }
        switch (var1_1) {
            default: {
                var2_2 = new StringBuilder();
                var2_2.append("Unexpected TLS version: ");
                var2_2.append(var0);
                throw new IllegalArgumentException(var2_2.toString());
            }
            case 4: {
                return af.e;
            }
            case 3: {
                return af.d;
            }
            case 2: {
                return af.c;
            }
            case 1: {
                return af.b;
            }
            case 0: 
        }
        return af.a;
    }

    static /* varargs */ List<af> a(String ... arrstring) {
        ArrayList<af> arrayList = new ArrayList<af>(arrstring.length);
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(af.a(arrstring[i2]));
        }
        return Collections.unmodifiableList(arrayList);
    }
}

