package p043jp.reifrontier.gym.domain.app;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p067e.p068a.C1568a;
import p043jp.reifrontier.gym.BuildConfig;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000e\b\b\u0018\u0000 62\u00020\u0001:\u00016BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u0006J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0006\u0010'\u001a\u00020\u0006J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0002J\u0006\u0010+\u001a\u00020\u0003J\u0006\u0010,\u001a\u00020\u0006J\u0006\u0010-\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020$J\u0006\u0010/\u001a\u00020\u0006J\u0006\u00100\u001a\u00020\u0006J\u0006\u00101\u001a\u00020\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\u0006\u00103\u001a\u00020$J\u0006\u00104\u001a\u00020$J\b\u00105\u001a\u00020\u0006H\u0002R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u00067"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/app/RFGAdapterActivity;", "", "startTime", "", "endTime", "original", "", "activity", "step", "distance", "", "list", "", "Lcom/google/android/gms/maps/model/LatLng;", "(IILjava/lang/String;Ljava/lang/String;IFLjava/util/List;)V", "getActivity", "()Ljava/lang/String;", "getDistance", "()F", "getEndTime", "()I", "getList", "()Ljava/util/List;", "getOriginal", "getStartTime", "getStep", "analyticsTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "km", "longitudeToPixelSpaceX", "", "longitude", "mapColor", "mapURL", "steps", "sty", "time", "title", "titleImage", "toString", "trp", "wlk", "zoomLevel", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.app.RFGAdapterActivity */
public final class RFGAdapterActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double MERCATOR_OFFSET = 2.68435456E8d;
    private static final double MERCATOR_RADIUS = 8.544565944705395E7d;
    private static final String StaticKey = "&key=";
    private static final String StaticPathBik = "&path=weight:12%7Ccolor:0x99FF66AA%7Cenc:";
    private static final String StaticPathTrp = "&path=weight:12%7Ccolor:0x1089FFAA%7Cenc:";
    private static final String StaticPathWlk = "&path=weight:12%7Ccolor:0xFFEF48AA%7Cenc:";
    private static final String StaticURL = "https://maps.googleapis.com/maps/api/staticmap?size=300x300&scale=2";
    private final String activity;
    private final float distance;
    private final int endTime;
    private final List<LatLng> list;
    private final String original;
    private final int startTime;
    private final int step;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/app/RFGAdapterActivity$Companion;", "", "()V", "MERCATOR_OFFSET", "", "MERCATOR_RADIUS", "StaticKey", "", "StaticPathBik", "StaticPathTrp", "StaticPathWlk", "StaticURL", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.domain.app.RFGAdapterActivity$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RFGAdapterActivity(int i, int i2, String str, String str2, int i3, float f, List<LatLng> list2) {
        Intrinsics.checkParameterIsNotNull(str, "original");
        Intrinsics.checkParameterIsNotNull(str2, "activity");
        Intrinsics.checkParameterIsNotNull(list2, "list");
        this.startTime = i;
        this.endTime = i2;
        this.original = str;
        this.activity = str2;
        this.step = i3;
        this.distance = f;
        this.list = list2;
    }

    public static /* synthetic */ RFGAdapterActivity copy$default(RFGAdapterActivity rFGAdapterActivity, int i, int i2, String str, String str2, int i3, float f, List<LatLng> list2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = rFGAdapterActivity.startTime;
        }
        if ((i4 & 2) != 0) {
            i2 = rFGAdapterActivity.endTime;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            str = rFGAdapterActivity.original;
        }
        String str3 = str;
        if ((i4 & 8) != 0) {
            str2 = rFGAdapterActivity.activity;
        }
        String str4 = str2;
        if ((i4 & 16) != 0) {
            i3 = rFGAdapterActivity.step;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            f = rFGAdapterActivity.distance;
        }
        float f2 = f;
        if ((i4 & 64) != 0) {
            list2 = rFGAdapterActivity.list;
        }
        return rFGAdapterActivity.copy(i, i5, str3, str4, i6, f2, list2);
    }

    private final double longitudeToPixelSpaceX(double d) {
        return (double) MathKt__MathJVMKt.roundToLong((((d * MERCATOR_RADIUS) * 3.141592653589793d) / 180.0d) + MERCATOR_OFFSET);
    }

    private final String zoomLevel() {
        if (Intrinsics.areEqual((Object) this.activity, (Object) "sty")) {
            return "&zoom=18";
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng include : this.list) {
            builder.include(include);
        }
        LatLngBounds build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "bounds");
        LatLng center = build.getCenter();
        double longitudeToPixelSpaceX = longitudeToPixelSpaceX(build.northeast.longitude) - longitudeToPixelSpaceX(build.southwest.longitude);
        double d = (double) 300;
        Double.isNaN(d);
        double d2 = longitudeToPixelSpaceX / d;
        double d3 = (double) 18;
        double log = Math.log(d2);
        Double.isNaN(d3);
        return C0681a.m328a(new Object[]{Integer.valueOf((int) (d3 - log)), Double.valueOf(center.latitude), Double.valueOf(center.longitude)}, 3, "&zoom=%s&center=%.4f,%.4f", "java.lang.String.format(this, *args)");
    }

    public final String analyticsTime() {
        return RFLDailyUtilsKt.format$default(new Date(((long) this.startTime) * 1000), "yyyyMMddHHmm", (String) null, 2, (Object) null) + " - " + RFLDailyUtilsKt.format$default(new Date(((long) this.endTime) * 1000), "HHmm", (String) null, 2, (Object) null);
    }

    public final int component1() {
        return this.startTime;
    }

    public final int component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.original;
    }

    public final String component4() {
        return this.activity;
    }

    public final int component5() {
        return this.step;
    }

    public final float component6() {
        return this.distance;
    }

    public final List<LatLng> component7() {
        return this.list;
    }

    public final RFGAdapterActivity copy(int i, int i2, String str, String str2, int i3, float f, List<LatLng> list2) {
        Intrinsics.checkParameterIsNotNull(str, "original");
        Intrinsics.checkParameterIsNotNull(str2, "activity");
        List<LatLng> list3 = list2;
        Intrinsics.checkParameterIsNotNull(list3, "list");
        return new RFGAdapterActivity(i, i2, str, str2, i3, f, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGAdapterActivity)) {
            return false;
        }
        RFGAdapterActivity rFGAdapterActivity = (RFGAdapterActivity) obj;
        return this.startTime == rFGAdapterActivity.startTime && this.endTime == rFGAdapterActivity.endTime && Intrinsics.areEqual((Object) this.original, (Object) rFGAdapterActivity.original) && Intrinsics.areEqual((Object) this.activity, (Object) rFGAdapterActivity.activity) && this.step == rFGAdapterActivity.step && Float.compare(this.distance, rFGAdapterActivity.distance) == 0 && Intrinsics.areEqual((Object) this.list, (Object) rFGAdapterActivity.list);
    }

    public final String getActivity() {
        return this.activity;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final List<LatLng> getList() {
        return this.list;
    }

    public final String getOriginal() {
        return this.original;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        int i = ((this.startTime * 31) + this.endTime) * 31;
        String str = this.original;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.activity;
        int floatToIntBits = (Float.floatToIntBits(this.distance) + ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.step) * 31)) * 31;
        List<LatLng> list2 = this.list;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return floatToIntBits + i2;
    }

    /* renamed from: km */
    public final String mo30460km() {
        return C0681a.m328a(new Object[]{Float.valueOf(this.distance / 1000.0f)}, 1, "%.1f", "java.lang.String.format(this, *args)");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r0 = "#221D35";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return android.graphics.Color.parseColor(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return android.graphics.Color.parseColor("#FFEF48");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r0.equals("wlk") != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (r0.equals("sty") != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mapColor() {
        /*
            r3 = this;
            java.lang.String r0 = r3.activity
            int r1 = r0.hashCode()
            java.lang.String r2 = "#FFEF48"
            switch(r1) {
                case -117759745: goto L_0x002d;
                case 114232: goto L_0x0020;
                case 115122: goto L_0x0015;
                case 117814: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0038
        L_0x000c:
            java.lang.String r1 = "wlk"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            goto L_0x0028
        L_0x0015:
            java.lang.String r1 = "trp"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = "#009EFD"
            goto L_0x003a
        L_0x0020:
            java.lang.String r1 = "sty"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
        L_0x0028:
            int r0 = android.graphics.Color.parseColor(r2)
            goto L_0x003e
        L_0x002d:
            java.lang.String r1 = "bicycle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = "#99ff66"
            goto L_0x003a
        L_0x0038:
            java.lang.String r0 = "#221D35"
        L_0x003a:
            int r0 = android.graphics.Color.parseColor(r0)
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.app.RFGAdapterActivity.mapColor():int");
    }

    public final String mapURL() {
        String str;
        String a = C1568a.m2195a(this.list);
        String str2 = this.activity;
        int hashCode = str2.hashCode();
        if (hashCode != -117759745) {
            if (hashCode != 114232) {
                if (hashCode == 117814 && str2.equals("wlk")) {
                    str = String.format("%s%s%s%s%s%s", Arrays.copyOf(new Object[]{StaticURL, zoomLevel(), StaticKey, BuildConfig.GGL_API_KEY, StaticPathWlk, a}, 6));
                    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
                    C1122a.m1596a("StaticMap URL: " + str, new Object[0]);
                    return str;
                }
            } else if (str2.equals("sty")) {
                str = String.format("%s%s%s%s%s%s", Arrays.copyOf(new Object[]{StaticURL, zoomLevel(), StaticKey, BuildConfig.GGL_API_KEY, StaticPathTrp, a}, 6));
                Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
                C1122a.m1596a("StaticMap URL: " + str, new Object[0]);
                return str;
            }
        } else if (str2.equals("bicycle")) {
            str = String.format("%s%s%s%s%s%s", Arrays.copyOf(new Object[]{StaticURL, zoomLevel(), StaticKey, BuildConfig.GGL_API_KEY, StaticPathBik, a, StaticKey, BuildConfig.GGL_API_KEY}, 8));
            Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
            C1122a.m1596a("StaticMap URL: " + str, new Object[0]);
            return str;
        }
        str = String.format("%s%s%s%s%s%s", Arrays.copyOf(new Object[]{StaticURL, zoomLevel(), StaticKey, BuildConfig.GGL_API_KEY, StaticPathTrp, a, StaticKey, BuildConfig.GGL_API_KEY}, 8));
        Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
        C1122a.m1596a("StaticMap URL: " + str, new Object[0]);
        return str;
    }

    public final String steps() {
        return C0681a.m328a(new Object[]{Integer.valueOf(this.step)}, 1, "%s", "java.lang.String.format(this, *args)");
    }

    public final boolean sty() {
        return Intrinsics.areEqual((Object) this.activity, (Object) "sty");
    }

    public final String time() {
        return RFLDailyUtilsKt.format$default(new Date(((long) this.startTime) * 1000), "H:mm", (String) null, 2, (Object) null) + " - " + RFLDailyUtilsKt.format$default(new Date(((long) this.endTime) * 1000), "H:mm", (String) null, 2, (Object) null);
    }

    public final String title() {
        String str = this.activity;
        switch (str.hashCode()) {
            case -117759745:
                if (str.equals("bicycle")) {
                    return "自転車";
                }
                break;
            case 114232:
                if (str.equals("sty")) {
                    return "滞在";
                }
                break;
            case 115122:
                if (str.equals("trp")) {
                    return "乗り物";
                }
                break;
            case 117814:
                if (str.equals("wlk")) {
                    return "徒歩";
                }
                break;
        }
        return "";
    }

    public final int titleImage() {
        String str = this.activity;
        switch (str.hashCode()) {
            case -117759745:
                return str.equals("bicycle") ? R.mipmap.act_bk : R.mipmap.act_wlk;
            case 114232:
                return str.equals("sty") ? R.mipmap.act_sty : R.mipmap.act_wlk;
            case 115122:
                return str.equals("trp") ? R.mipmap.act_tp : R.mipmap.act_wlk;
            case 117814:
                boolean equals = str.equals("wlk");
                return R.mipmap.act_wlk;
            default:
                return R.mipmap.act_wlk;
        }
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGAdapterActivity(startTime=");
        a.append(this.startTime);
        a.append(", endTime=");
        a.append(this.endTime);
        a.append(", original=");
        a.append(this.original);
        a.append(", activity=");
        a.append(this.activity);
        a.append(", step=");
        a.append(this.step);
        a.append(", distance=");
        a.append(this.distance);
        a.append(", list=");
        return C0681a.m325a(a, (List) this.list, ")");
    }

    public final boolean trp() {
        return Intrinsics.areEqual((Object) this.activity, (Object) "trp");
    }

    public final boolean wlk() {
        return Intrinsics.areEqual((Object) this.activity, (Object) "wlk");
    }
}
