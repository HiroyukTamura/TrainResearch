/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001HBs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u000bH\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\u0091\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0006\u0010>\u001a\u00020\u0003J\u0006\u0010?\u001a\u00020\u0003J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u00d6\u0003J\t\u0010D\u001a\u00020\u000bH\u00d6\u0001J\u0006\u0010E\u001a\u00020\u000bJ\u0006\u0010F\u001a\u00020\u000bJ\t\u0010G\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015\u00a8\u0006I"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "Ljava/io/Serializable;", "universalId", "", "jrId", "trainLocationId", "lineCode", "color", "iconName", "railKind", "displayType", "", "displayName", "section", "kana", "siteUrl", "storeUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getDisplayName", "setDisplayName", "getDisplayType", "()I", "setDisplayType", "(I)V", "getIconName", "setIconName", "getJrId", "setJrId", "getKana", "setKana", "getLineCode", "setLineCode", "getRailKind", "setRailKind", "getSection", "setSection", "getSiteUrl", "setSiteUrl", "getStoreUrl", "setStoreUrl", "getTrainLocationId", "setTrainLocationId", "getUniversalId", "setUniversalId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "displayDirectionOfList", "displayLineSectionName", "equals", "", "other", "", "hashCode", "showLinerText", "showUnderLinerText", "toString", "Type", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class RailwayLineInformation
implements Serializable {
    private String color;
    private String displayName;
    private int displayType;
    private String iconName;
    private String jrId;
    private String kana;
    private String lineCode;
    private String railKind;
    private String section;
    private String siteUrl;
    private String storeUrl;
    private String trainLocationId;
    private String universalId;

    public RailwayLineInformation(String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n2, String string9, String string10, String string11, String string12, String string13) {
        j.b(string2, "universalId");
        j.b(string3, "jrId");
        j.b(string4, "trainLocationId");
        j.b(string5, "lineCode");
        j.b(string6, "color");
        j.b(string8, "railKind");
        j.b(string9, "displayName");
        j.b(string10, "section");
        j.b(string11, "kana");
        this.universalId = string2;
        this.jrId = string3;
        this.trainLocationId = string4;
        this.lineCode = string5;
        this.color = string6;
        this.iconName = string7;
        this.railKind = string8;
        this.displayType = n2;
        this.displayName = string9;
        this.section = string10;
        this.kana = string11;
        this.siteUrl = string12;
        this.storeUrl = string13;
    }

    public static /* synthetic */ RailwayLineInformation copy$default(RailwayLineInformation railwayLineInformation, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n2, String string9, String string10, String string11, String string12, String string13, int n3, Object object) {
        block12 : {
            if ((n3 & 1) != 0) {
                string2 = railwayLineInformation.universalId;
            }
            if ((n3 & 2) != 0) {
                string3 = railwayLineInformation.jrId;
            }
            if ((n3 & 4) != 0) {
                string4 = railwayLineInformation.trainLocationId;
            }
            if ((n3 & 8) != 0) {
                string5 = railwayLineInformation.lineCode;
            }
            if ((n3 & 16) != 0) {
                string6 = railwayLineInformation.color;
            }
            if ((n3 & 32) != 0) {
                string7 = railwayLineInformation.iconName;
            }
            if ((n3 & 64) != 0) {
                string8 = railwayLineInformation.railKind;
            }
            if ((n3 & 128) != 0) {
                n2 = railwayLineInformation.displayType;
            }
            if ((n3 & 256) != 0) {
                string9 = railwayLineInformation.displayName;
            }
            if ((n3 & 512) != 0) {
                string10 = railwayLineInformation.section;
            }
            if ((n3 & 1024) != 0) {
                string11 = railwayLineInformation.kana;
            }
            if ((n3 & 2048) != 0) {
                string12 = railwayLineInformation.siteUrl;
            }
            if ((n3 & 4096) == 0) break block12;
            string13 = railwayLineInformation.storeUrl;
        }
        return railwayLineInformation.copy(string2, string3, string4, string5, string6, string7, string8, n2, string9, string10, string11, string12, string13);
    }

    public final String component1() {
        return this.universalId;
    }

    public final String component10() {
        return this.section;
    }

    public final String component11() {
        return this.kana;
    }

    public final String component12() {
        return this.siteUrl;
    }

    public final String component13() {
        return this.storeUrl;
    }

    public final String component2() {
        return this.jrId;
    }

    public final String component3() {
        return this.trainLocationId;
    }

    public final String component4() {
        return this.lineCode;
    }

    public final String component5() {
        return this.color;
    }

    public final String component6() {
        return this.iconName;
    }

    public final String component7() {
        return this.railKind;
    }

    public final int component8() {
        return this.displayType;
    }

    public final String component9() {
        return this.displayName;
    }

    public final RailwayLineInformation copy(String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n2, String string9, String string10, String string11, String string12, String string13) {
        j.b(string2, "universalId");
        j.b(string3, "jrId");
        j.b(string4, "trainLocationId");
        j.b(string5, "lineCode");
        j.b(string6, "color");
        j.b(string8, "railKind");
        j.b(string9, "displayName");
        j.b(string10, "section");
        j.b(string11, "kana");
        return new RailwayLineInformation(string2, string3, string4, string5, string6, string7, string8, n2, string9, string10, string11, string12, string13);
    }

    public final String displayDirectionOfList() {
        String string2 = this.trainLocationId;
        switch (string2.hashCode()) {
            default: {
                break;
            }
            case 56315: {
                if (!string2.equals("902")) break;
                return "\u65b0\u5bbf\u65b9\u9762";
            }
            case 56314: {
                if (!string2.equals("901")) break;
                return "\u6771\u4eac\u65b9\u9762";
            }
        }
        return "";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String displayLineSectionName() {
        String string2;
        CharSequence charSequence;
        block6 : {
            int n2 = this.displayType;
            if (n2 == 0) return this.displayName;
            if (n2 != 3) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(this.displayName);
                ((StringBuilder)charSequence).append('(');
                ((StringBuilder)charSequence).append(this.section);
                ((StringBuilder)charSequence).append(')');
                do {
                    return ((StringBuilder)charSequence).toString();
                    break;
                } while (true);
            }
            charSequence = this.trainLocationId;
            switch (((String)charSequence).hashCode()) {
                default: {
                    break;
                }
                case 56315: {
                    if (!((String)charSequence).equals("902")) break;
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(this.displayName);
                    ((StringBuilder)charSequence).append('(');
                    ((StringBuilder)charSequence).append(this.section);
                    string2 = ") /\u30e9\u30a4\u30ca\u30fc(\u65b0\u5bbf\u65b9\u9762)";
                    break block6;
                }
                case 56314: {
                    if (!((String)charSequence).equals("901")) break;
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(this.displayName);
                    ((StringBuilder)charSequence).append('(');
                    ((StringBuilder)charSequence).append(this.section);
                    string2 = ") /\u30e9\u30a4\u30ca\u30fc(\u6771\u4eac\u65b9\u9762)";
                    break block6;
                }
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(this.displayName);
            ((StringBuilder)charSequence).append('(');
            ((StringBuilder)charSequence).append(this.section);
            string2 = ") /\u30e9\u30a4\u30ca\u30fc";
        }
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof RailwayLineInformation) {
                boolean bl2;
                object = (RailwayLineInformation)object;
                if (j.a((Object)this.universalId, (Object)((RailwayLineInformation)object).universalId) && j.a((Object)this.jrId, (Object)((RailwayLineInformation)object).jrId) && j.a((Object)this.trainLocationId, (Object)((RailwayLineInformation)object).trainLocationId) && j.a((Object)this.lineCode, (Object)((RailwayLineInformation)object).lineCode) && j.a((Object)this.color, (Object)((RailwayLineInformation)object).color) && j.a((Object)this.iconName, (Object)((RailwayLineInformation)object).iconName) && j.a((Object)this.railKind, (Object)((RailwayLineInformation)object).railKind) && (bl2 = this.displayType == ((RailwayLineInformation)object).displayType) && j.a((Object)this.displayName, (Object)((RailwayLineInformation)object).displayName) && j.a((Object)this.section, (Object)((RailwayLineInformation)object).section) && j.a((Object)this.kana, (Object)((RailwayLineInformation)object).kana) && j.a((Object)this.siteUrl, (Object)((RailwayLineInformation)object).siteUrl) && j.a((Object)this.storeUrl, (Object)((RailwayLineInformation)object).storeUrl)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getDisplayType() {
        return this.displayType;
    }

    public final String getIconName() {
        return this.iconName;
    }

    public final String getJrId() {
        return this.jrId;
    }

    public final String getKana() {
        return this.kana;
    }

    public final String getLineCode() {
        return this.lineCode;
    }

    public final String getRailKind() {
        return this.railKind;
    }

    public final String getSection() {
        return this.section;
    }

    public final String getSiteUrl() {
        return this.siteUrl;
    }

    public final String getStoreUrl() {
        return this.storeUrl;
    }

    public final String getTrainLocationId() {
        return this.trainLocationId;
    }

    public final String getUniversalId() {
        return this.universalId;
    }

    public int hashCode() {
        String string2 = this.universalId;
        int n2 = 0;
        int n3 = string2 != null ? string2.hashCode() : 0;
        string2 = this.jrId;
        int n4 = string2 != null ? string2.hashCode() : 0;
        string2 = this.trainLocationId;
        int n5 = string2 != null ? string2.hashCode() : 0;
        string2 = this.lineCode;
        int n6 = string2 != null ? string2.hashCode() : 0;
        string2 = this.color;
        int n7 = string2 != null ? string2.hashCode() : 0;
        string2 = this.iconName;
        int n8 = string2 != null ? string2.hashCode() : 0;
        string2 = this.railKind;
        int n9 = string2 != null ? string2.hashCode() : 0;
        int n10 = this.displayType;
        string2 = this.displayName;
        int n11 = string2 != null ? string2.hashCode() : 0;
        string2 = this.section;
        int n12 = string2 != null ? string2.hashCode() : 0;
        string2 = this.kana;
        int n13 = string2 != null ? string2.hashCode() : 0;
        string2 = this.siteUrl;
        int n14 = string2 != null ? string2.hashCode() : 0;
        string2 = this.storeUrl;
        if (string2 != null) {
            n2 = string2.hashCode();
        }
        return (((((((((((n3 * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n12) * 31 + n13) * 31 + n14) * 31 + n2;
    }

    public final void setColor(String string2) {
        j.b(string2, "<set-?>");
        this.color = string2;
    }

    public final void setDisplayName(String string2) {
        j.b(string2, "<set-?>");
        this.displayName = string2;
    }

    public final void setDisplayType(int n2) {
        this.displayType = n2;
    }

    public final void setIconName(String string2) {
        this.iconName = string2;
    }

    public final void setJrId(String string2) {
        j.b(string2, "<set-?>");
        this.jrId = string2;
    }

    public final void setKana(String string2) {
        j.b(string2, "<set-?>");
        this.kana = string2;
    }

    public final void setLineCode(String string2) {
        j.b(string2, "<set-?>");
        this.lineCode = string2;
    }

    public final void setRailKind(String string2) {
        j.b(string2, "<set-?>");
        this.railKind = string2;
    }

    public final void setSection(String string2) {
        j.b(string2, "<set-?>");
        this.section = string2;
    }

    public final void setSiteUrl(String string2) {
        this.siteUrl = string2;
    }

    public final void setStoreUrl(String string2) {
        this.storeUrl = string2;
    }

    public final void setTrainLocationId(String string2) {
        j.b(string2, "<set-?>");
        this.trainLocationId = string2;
    }

    public final void setUniversalId(String string2) {
        j.b(string2, "<set-?>");
        this.universalId = string2;
    }

    public final int showLinerText() {
        if (j.a((Object)this.trainLocationId, (Object)"903")) {
            return 8;
        }
        return 0;
    }

    public final int showUnderLinerText() {
        if (j.a((Object)this.trainLocationId, (Object)"903")) {
            return 0;
        }
        return 8;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RailwayLineInformation(universalId=");
        stringBuilder.append(this.universalId);
        stringBuilder.append(", jrId=");
        stringBuilder.append(this.jrId);
        stringBuilder.append(", trainLocationId=");
        stringBuilder.append(this.trainLocationId);
        stringBuilder.append(", lineCode=");
        stringBuilder.append(this.lineCode);
        stringBuilder.append(", color=");
        stringBuilder.append(this.color);
        stringBuilder.append(", iconName=");
        stringBuilder.append(this.iconName);
        stringBuilder.append(", railKind=");
        stringBuilder.append(this.railKind);
        stringBuilder.append(", displayType=");
        stringBuilder.append(this.displayType);
        stringBuilder.append(", displayName=");
        stringBuilder.append(this.displayName);
        stringBuilder.append(", section=");
        stringBuilder.append(this.section);
        stringBuilder.append(", kana=");
        stringBuilder.append(this.kana);
        stringBuilder.append(", siteUrl=");
        stringBuilder.append(this.siteUrl);
        stringBuilder.append(", storeUrl=");
        stringBuilder.append(this.storeUrl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation$Type;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "NOSECTION", "SECTION", "LINES", "OTHERS", "AKAGI", "CLEAR", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class Type
    extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES;
        public static final /* enum */ Type AKAGI;
        public static final /* enum */ Type CLEAR;
        public static final /* enum */ Type LINES;
        public static final /* enum */ Type NOSECTION;
        public static final /* enum */ Type OTHERS;
        public static final /* enum */ Type SECTION;
        private final int code;

        static {
            Type type;
            Type type2;
            Type type3;
            Type type4;
            Type type5;
            Type type6;
            NOSECTION = type2 = new Type(0);
            SECTION = type = new Type(1);
            LINES = type5 = new Type(2);
            OTHERS = type4 = new Type(3);
            AKAGI = type3 = new Type(4);
            CLEAR = type6 = new Type(999);
            $VALUES = new Type[]{type2, type, type5, type4, type3, type6};
        }

        protected Type(int n3) {
            this.code = n3;
        }

        public static Type valueOf(String string2) {
            return Enum.valueOf(Type.class, string2);
        }

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }

        public final int getCode() {
            return this.code;
        }
    }

}

