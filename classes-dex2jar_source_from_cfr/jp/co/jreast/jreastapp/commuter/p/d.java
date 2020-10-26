/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.p;

import java.util.Date;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.d.b;
import jp.co.jreast.jreastapp.commuter.j.a;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.e.b.j;
import kotlin.s;

@Metadata(bv={1, 0, 2}, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0016J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2={"Ljp/co/jreast/jreastapp/commuter/timetable/TimetableRequestParameter;", "Ljp/co/jreast/jreastapp/commuter/http/CommuterRequestParameter;", "previousNextKey", "", "selectedDate", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "getPreviousNextKey", "()Ljava/lang/String;", "getSelectedDate", "()Ljava/util/Date;", "buildParameter", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
implements a {
    private final String a;
    private final Date b;

    public d(String string2, Date date) {
        j.b(string2, "previousNextKey");
        j.b(date, "selectedDate");
        this.a = string2;
        this.b = date;
    }

    @Override
    public Map<String, String> a() {
        return af.a(s.a(jp.co.jreast.jreastapp.commuter.common.a.l.a(), this.a), s.a(jp.co.jreast.jreastapp.commuter.common.a.c.a(), b.a(this.b)), s.a(jp.co.jreast.jreastapp.commuter.common.a.d.a(), b.b(this.b)));
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof d)) break block3;
                object = (d)object;
                if (j.a((Object)this.a, (Object)((d)object).a) && j.a((Object)this.b, (Object)((d)object).b)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object object = this.a;
        int n2 = 0;
        int n3 = object != null ? object.hashCode() : 0;
        object = this.b;
        if (object != null) {
            n2 = object.hashCode();
        }
        return n3 * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TimetableRequestParameter(previousNextKey=");
        stringBuilder.append(this.a);
        stringBuilder.append(", selectedDate=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

