/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/ChangeRoutes;", "", "jrId", "", "imageResource", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getImageResource", "()I", "getJrId", "()Ljava/lang/String;", "TOKAI", "CHUOKAISOKU", "CHUOSOBU", "UTSUNOMIYA", "TAKASAKI", "YOKOSUKA", "SHONANSHINJUKU", "KEIHINTOHOKU", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class ChangeRoutes
extends Enum<ChangeRoutes> {
    private static final /* synthetic */ ChangeRoutes[] $VALUES;
    public static final /* enum */ ChangeRoutes CHUOKAISOKU;
    public static final /* enum */ ChangeRoutes CHUOSOBU;
    public static final /* enum */ ChangeRoutes KEIHINTOHOKU;
    public static final /* enum */ ChangeRoutes SHONANSHINJUKU;
    public static final /* enum */ ChangeRoutes TAKASAKI;
    public static final /* enum */ ChangeRoutes TOKAI;
    public static final /* enum */ ChangeRoutes UTSUNOMIYA;
    public static final /* enum */ ChangeRoutes YOKOSUKA;
    private final int imageResource;
    private final String jrId;

    static {
        ChangeRoutes changeRoutes;
        ChangeRoutes changeRoutes2;
        ChangeRoutes changeRoutes3;
        ChangeRoutes changeRoutes4;
        ChangeRoutes changeRoutes5;
        ChangeRoutes changeRoutes6;
        ChangeRoutes changeRoutes7;
        ChangeRoutes changeRoutes8;
        TOKAI = changeRoutes2 = new ChangeRoutes("60", 2131165445);
        CHUOKAISOKU = changeRoutes = new ChangeRoutes("57", 2131165446);
        CHUOSOBU = changeRoutes3 = new ChangeRoutes("56", 2131165447);
        UTSUNOMIYA = changeRoutes5 = new ChangeRoutes("34", 2131165448);
        TAKASAKI = changeRoutes7 = new ChangeRoutes("55", 2131165449);
        YOKOSUKA = changeRoutes4 = new ChangeRoutes("69", 2131165450);
        SHONANSHINJUKU = changeRoutes8 = new ChangeRoutes("46", 2131165451);
        KEIHINTOHOKU = changeRoutes6 = new ChangeRoutes("40", 2131165452);
        $VALUES = new ChangeRoutes[]{changeRoutes2, changeRoutes, changeRoutes3, changeRoutes5, changeRoutes7, changeRoutes4, changeRoutes8, changeRoutes6};
    }

    protected ChangeRoutes(String string3, int n3) {
        j.b(string3, "jrId");
        this.jrId = string3;
        this.imageResource = n3;
    }

    public static ChangeRoutes valueOf(String string2) {
        return Enum.valueOf(ChangeRoutes.class, string2);
    }

    public static ChangeRoutes[] values() {
        return (ChangeRoutes[])$VALUES.clone();
    }

    public final int getImageResource() {
        return this.imageResource;
    }

    public final String getJrId() {
        return this.jrId;
    }
}

