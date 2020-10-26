/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/SearchResultSubTitle;", "", "leftTitle", "", "rightTitle", "rightVisibility", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getLeftTitle", "()Ljava/lang/String;", "getRightTitle", "getRightVisibility", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class SearchResultSubTitle {
    private final String leftTitle;
    private final String rightTitle;
    private final int rightVisibility;

    public SearchResultSubTitle() {
        this(null, null, 0, 7, null);
    }

    public SearchResultSubTitle(String string2, String string3, int n2) {
        j.b(string2, "leftTitle");
        j.b(string3, "rightTitle");
        this.leftTitle = string2;
        this.rightTitle = string3;
        this.rightVisibility = n2;
    }

    public /* synthetic */ SearchResultSubTitle(String string2, String string3, int n2, int n3, g g2) {
        if ((n3 & 1) != 0) {
            string2 = "";
        }
        if ((n3 & 2) != 0) {
            string3 = "";
        }
        if ((n3 & 4) != 0) {
            n2 = 8;
        }
        this(string2, string3, n2);
    }

    public static /* synthetic */ SearchResultSubTitle copy$default(SearchResultSubTitle searchResultSubTitle, String string2, String string3, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            string2 = searchResultSubTitle.leftTitle;
        }
        if ((n3 & 2) != 0) {
            string3 = searchResultSubTitle.rightTitle;
        }
        if ((n3 & 4) != 0) {
            n2 = searchResultSubTitle.rightVisibility;
        }
        return searchResultSubTitle.copy(string2, string3, n2);
    }

    public final String component1() {
        return this.leftTitle;
    }

    public final String component2() {
        return this.rightTitle;
    }

    public final int component3() {
        return this.rightVisibility;
    }

    public final SearchResultSubTitle copy(String string2, String string3, int n2) {
        j.b(string2, "leftTitle");
        j.b(string3, "rightTitle");
        return new SearchResultSubTitle(string2, string3, n2);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof SearchResultSubTitle) {
                boolean bl2;
                object = (SearchResultSubTitle)object;
                if (j.a((Object)this.leftTitle, (Object)((SearchResultSubTitle)object).leftTitle) && j.a((Object)this.rightTitle, (Object)((SearchResultSubTitle)object).rightTitle) && (bl2 = this.rightVisibility == ((SearchResultSubTitle)object).rightVisibility)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final String getLeftTitle() {
        return this.leftTitle;
    }

    public final String getRightTitle() {
        return this.rightTitle;
    }

    public final int getRightVisibility() {
        return this.rightVisibility;
    }

    public int hashCode() {
        String string2 = this.leftTitle;
        int n2 = 0;
        int n3 = string2 != null ? string2.hashCode() : 0;
        string2 = this.rightTitle;
        if (string2 != null) {
            n2 = string2.hashCode();
        }
        return (n3 * 31 + n2) * 31 + this.rightVisibility;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SearchResultSubTitle(leftTitle=");
        stringBuilder.append(this.leftTitle);
        stringBuilder.append(", rightTitle=");
        stringBuilder.append(this.rightTitle);
        stringBuilder.append(", rightVisibility=");
        stringBuilder.append(this.rightVisibility);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

