/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import jp.co.jreast.jreastapp.commuter.common.i;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001d"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/LinkInformation;", "", "menuTitle", "", "windowTitle", "iconName", "linkType", "Ljp/co/jreast/jreastapp/commuter/common/LinkType;", "args", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/co/jreast/jreastapp/commuter/common/LinkType;Ljava/lang/String;)V", "getArgs", "()Ljava/lang/String;", "getIconName", "getLinkType", "()Ljp/co/jreast/jreastapp/commuter/common/LinkType;", "getMenuTitle", "getWindowTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class h {
    private final String a;
    private final String b;
    private final String c;
    private final i d;
    private final String e;

    public h(String string2, String string3, String string4, i i2, String string5) {
        j.b(string2, "menuTitle");
        j.b(string3, "windowTitle");
        j.b(string4, "iconName");
        j.b((Object)i2, "linkType");
        j.b(string5, "args");
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = i2;
        this.e = string5;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final i c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof h)) break block3;
                object = (h)object;
                if (j.a((Object)this.a, (Object)((h)object).a) && j.a((Object)this.b, (Object)((h)object).b) && j.a((Object)this.c, (Object)((h)object).c) && j.a((Object)this.d, (Object)((h)object).d) && j.a((Object)this.e, (Object)((h)object).e)) break block2;
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
        int n4 = object != null ? object.hashCode() : 0;
        object = this.c;
        int n5 = object != null ? object.hashCode() : 0;
        object = this.d;
        int n6 = object != null ? object.hashCode() : 0;
        object = this.e;
        if (object != null) {
            n2 = object.hashCode();
        }
        return (((n3 * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkInformation(menuTitle=");
        stringBuilder.append(this.a);
        stringBuilder.append(", windowTitle=");
        stringBuilder.append(this.b);
        stringBuilder.append(", iconName=");
        stringBuilder.append(this.c);
        stringBuilder.append(", linkType=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append(", args=");
        stringBuilder.append(this.e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

