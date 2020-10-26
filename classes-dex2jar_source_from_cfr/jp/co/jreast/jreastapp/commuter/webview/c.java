/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.webview;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tJ\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0012"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/CommonRequestHeaderParameter;", "", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "buildParameterMap", "", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c {
    private String a;

    public c() {
        this(null, 1, null);
    }

    public c(String string2) {
        j.b(string2, "userId");
        this.a = string2;
    }

    public /* synthetic */ c(String string2, int n2, g g2) {
        if ((n2 & 1) != 0) {
            string2 = "000000";
        }
        this(string2);
    }

    public final Map<String, String> a() {
        Map map = new LinkedHashMap();
        map.put("User-Id", this.a);
        return map;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof c)) break block3;
                object = (c)object;
                if (j.a((Object)this.a, (Object)((c)object).a)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String string2 = this.a;
        if (string2 != null) {
            return string2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommonRequestHeaderParameter(userId=");
        stringBuilder.append(this.a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

