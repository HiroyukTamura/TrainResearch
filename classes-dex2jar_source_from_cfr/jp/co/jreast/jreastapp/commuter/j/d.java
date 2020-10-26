/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.j;

import java.util.Map;
import jp.co.jreast.jreastapp.commuter.j.a;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.e.b.j;
import kotlin.s;

@Metadata(bv={1, 0, 2}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bH\u0016J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2={"Ljp/co/jreast/jreastapp/commuter/http/ServiceStatusRequestParameter;", "Ljp/co/jreast/jreastapp/commuter/http/CommuterRequestParameter;", "jrId", "", "(Ljava/lang/String;)V", "getJrId", "()Ljava/lang/String;", "buildParameter", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
implements a {
    private final String a;

    public d(String string2) {
        j.b(string2, "jrId");
        this.a = string2;
    }

    @Override
    public Map<String, String> a() {
        return af.a(s.a(jp.co.jreast.jreastapp.commuter.common.a.j.a(), this.a));
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof d)) break block3;
                object = (d)object;
                if (j.a((Object)this.a, (Object)((d)object).a)) break block2;
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
        stringBuilder.append("ServiceStatusRequestParameter(jrId=");
        stringBuilder.append(this.a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

