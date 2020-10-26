/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.o;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.d.b;
import jp.co.jreast.jreastapp.commuter.j.a;
import jp.co.jreast.jreastapp.commuter.model.Station;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.e.b.j;
import kotlin.s;

@Metadata(bv={1, 0, 2}, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J]\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020\bH\u00d6\u0001J\t\u0010*\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f\u00a8\u0006+"}, d2={"Ljp/co/jreast/jreastapp/commuter/routesearchresults/RouteSearchResultRequestParameter;", "Ljp/co/jreast/jreastapp/commuter/http/CommuterRequestParameter;", "departureStation", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "arrivalStation", "selectDate", "Ljava/util/Date;", "departureOrArrival", "", "express", "transferTime", "viaStation1", "viaStation2", "(Ljp/co/jreast/jreastapp/commuter/model/Station;Ljp/co/jreast/jreastapp/commuter/model/Station;Ljava/util/Date;IIILjp/co/jreast/jreastapp/commuter/model/Station;Ljp/co/jreast/jreastapp/commuter/model/Station;)V", "getArrivalStation", "()Ljp/co/jreast/jreastapp/commuter/model/Station;", "getDepartureOrArrival", "()I", "getDepartureStation", "getExpress", "getSelectDate", "()Ljava/util/Date;", "getTransferTime", "getViaStation1", "getViaStation2", "buildParameter", "", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
implements a {
    private final Station a;
    private final Station b;
    private final Date c;
    private final int d;
    private final int e;
    private final int f;
    private final Station g;
    private final Station h;

    public c(Station station, Station station2, Date date, int n2, int n3, int n4, Station station3, Station station4) {
        j.b(station, "departureStation");
        j.b(station2, "arrivalStation");
        j.b(date, "selectDate");
        this.a = station;
        this.b = station2;
        this.c = date;
        this.d = n2;
        this.e = n3;
        this.f = n4;
        this.g = station3;
        this.h = station4;
    }

    @Override
    public Map<String, String> a() {
        Map<String, String> map = af.b(s.a(jp.co.jreast.jreastapp.commuter.common.a.a.a(), this.a.getCode()), s.a(jp.co.jreast.jreastapp.commuter.common.a.b.a(), this.b.getCode()), s.a(jp.co.jreast.jreastapp.commuter.common.a.c.a(), b.a(this.c)), s.a(jp.co.jreast.jreastapp.commuter.common.a.d.a(), b.b(this.c)), s.a(jp.co.jreast.jreastapp.commuter.common.a.e.a(), String.valueOf(this.d)), s.a(jp.co.jreast.jreastapp.commuter.common.a.f.a(), String.valueOf(this.e)), s.a(jp.co.jreast.jreastapp.commuter.common.a.g.a(), String.valueOf(this.f)));
        if (this.g != null) {
            map.put(jp.co.jreast.jreastapp.commuter.common.a.h.a(), this.g.getCode());
        }
        if (this.h != null) {
            map.put(jp.co.jreast.jreastapp.commuter.common.a.i.a(), this.h.getCode());
        }
        return map;
    }

    public final Station b() {
        return this.a;
    }

    public final Station c() {
        return this.b;
    }

    public final Date d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof c) {
                boolean bl2;
                object = (c)object;
                if (j.a((Object)this.a, (Object)((c)object).a) && j.a((Object)this.b, (Object)((c)object).b) && j.a((Object)this.c, (Object)((c)object).c) && (bl2 = this.d == ((c)object).d) && (bl2 = this.e == ((c)object).e) && (bl2 = this.f == ((c)object).f) && j.a((Object)this.g, (Object)((c)object).g) && j.a((Object)this.h, (Object)((c)object).h)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }

    public final Station h() {
        return this.g;
    }

    public int hashCode() {
        Serializable serializable = this.a;
        int n2 = 0;
        int n3 = serializable != null ? serializable.hashCode() : 0;
        serializable = this.b;
        int n4 = serializable != null ? serializable.hashCode() : 0;
        serializable = this.c;
        int n5 = serializable != null ? serializable.hashCode() : 0;
        int n6 = this.d;
        int n7 = this.e;
        int n8 = this.f;
        serializable = this.g;
        int n9 = serializable != null ? serializable.hashCode() : 0;
        serializable = this.h;
        if (serializable != null) {
            n2 = serializable.hashCode();
        }
        return ((((((n3 * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n2;
    }

    public final Station i() {
        return this.h;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RouteSearchResultRequestParameter(departureStation=");
        stringBuilder.append(this.a);
        stringBuilder.append(", arrivalStation=");
        stringBuilder.append(this.b);
        stringBuilder.append(", selectDate=");
        stringBuilder.append(this.c);
        stringBuilder.append(", departureOrArrival=");
        stringBuilder.append(this.d);
        stringBuilder.append(", express=");
        stringBuilder.append(this.e);
        stringBuilder.append(", transferTime=");
        stringBuilder.append(this.f);
        stringBuilder.append(", viaStation1=");
        stringBuilder.append(this.g);
        stringBuilder.append(", viaStation2=");
        stringBuilder.append(this.h);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

