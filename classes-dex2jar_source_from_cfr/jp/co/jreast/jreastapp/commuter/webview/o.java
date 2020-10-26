/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.webview;

import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003Jv\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u00d6\u0003J\t\u0010/\u001a\u00020\u0006H\u00d6\u0001J\t\u00100\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b\u00a8\u00061"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/Site;", "Ljava/io/Serializable;", "title", "", "url", "visibilityFavicon", "", "faviconResourceId", "visibilitySubTitle", "subTitle", "visibilityInfoButton", "infoButtonUrl", "visibilityReload", "railwayLineInformation", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;ILjava/lang/String;ILjp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;)V", "getFaviconResourceId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInfoButtonUrl", "()Ljava/lang/String;", "getRailwayLineInformation", "()Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "getSubTitle", "getTitle", "getUrl", "getVisibilityFavicon", "()I", "getVisibilityInfoButton", "getVisibilityReload", "getVisibilitySubTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;ILjava/lang/String;ILjp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;)Ljp/co/jreast/jreastapp/commuter/webview/Site;", "equals", "", "other", "", "hashCode", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class o
implements Serializable {
    private final String a;
    private final String b;
    private final int c;
    private final Integer d;
    private final int e;
    private final String f;
    private final int g;
    private final String h;
    private final int i;
    private final RailwayLineInformation j;

    public o(String string2, String string3, int n2, Integer n3, int n4, String string4, int n5, String string5, int n6, RailwayLineInformation railwayLineInformation) {
        j.b(string2, "title");
        j.b(string3, "url");
        j.b(string4, "subTitle");
        j.b(string5, "infoButtonUrl");
        this.a = string2;
        this.b = string3;
        this.c = n2;
        this.d = n3;
        this.e = n4;
        this.f = string4;
        this.g = n5;
        this.h = string5;
        this.i = n6;
        this.j = railwayLineInformation;
    }

    public /* synthetic */ o(String string2, String string3, int n2, Integer n3, int n4, String string4, int n5, String string5, int n6, RailwayLineInformation railwayLineInformation, int n7, g g2) {
        if ((n7 & 4) != 0) {
            n2 = 8;
        }
        if ((n7 & 8) != 0) {
            n3 = null;
        }
        if ((n7 & 16) != 0) {
            n4 = 8;
        }
        if ((n7 & 32) != 0) {
            string4 = "";
        }
        if ((n7 & 64) != 0) {
            n5 = 4;
        }
        if ((n7 & 128) != 0) {
            string5 = "";
        }
        if ((n7 & 256) != 0) {
            n6 = 8;
        }
        if ((n7 & 512) != 0) {
            railwayLineInformation = null;
        }
        this(string2, string3, n2, n3, n4, string4, n5, string5, n6, railwayLineInformation);
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final Integer d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof o) {
                boolean bl2;
                object = (o)object;
                if (j.a((Object)this.a, (Object)((o)object).a) && j.a((Object)this.b, (Object)((o)object).b) && (bl2 = this.c == ((o)object).c) && j.a((Object)this.d, (Object)((o)object).d) && (bl2 = this.e == ((o)object).e) && j.a((Object)this.f, (Object)((o)object).f) && (bl2 = this.g == ((o)object).g) && j.a((Object)this.h, (Object)((o)object).h) && (bl2 = this.i == ((o)object).i) && j.a((Object)this.j, (Object)((o)object).j)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        Object object = this.a;
        int n2 = 0;
        int n3 = object != null ? object.hashCode() : 0;
        object = this.b;
        int n4 = object != null ? object.hashCode() : 0;
        int n5 = this.c;
        object = this.d;
        int n6 = object != null ? object.hashCode() : 0;
        int n7 = this.e;
        object = this.f;
        int n8 = object != null ? object.hashCode() : 0;
        int n9 = this.g;
        object = this.h;
        int n10 = object != null ? object.hashCode() : 0;
        int n11 = this.i;
        object = this.j;
        if (object != null) {
            n2 = object.hashCode();
        }
        return ((((((((n3 * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n2;
    }

    public final int i() {
        return this.i;
    }

    public final RailwayLineInformation j() {
        return this.j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Site(title=");
        stringBuilder.append(this.a);
        stringBuilder.append(", url=");
        stringBuilder.append(this.b);
        stringBuilder.append(", visibilityFavicon=");
        stringBuilder.append(this.c);
        stringBuilder.append(", faviconResourceId=");
        stringBuilder.append(this.d);
        stringBuilder.append(", visibilitySubTitle=");
        stringBuilder.append(this.e);
        stringBuilder.append(", subTitle=");
        stringBuilder.append(this.f);
        stringBuilder.append(", visibilityInfoButton=");
        stringBuilder.append(this.g);
        stringBuilder.append(", infoButtonUrl=");
        stringBuilder.append(this.h);
        stringBuilder.append(", visibilityReload=");
        stringBuilder.append(this.i);
        stringBuilder.append(", railwayLineInformation=");
        stringBuilder.append(this.j);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

