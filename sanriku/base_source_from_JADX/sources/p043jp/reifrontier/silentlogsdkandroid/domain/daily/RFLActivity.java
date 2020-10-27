package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import android.location.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0002\u0010\u0015J\u0006\u0010>\u001a\u00020\u0005J\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\fJ\b\u0010C\u001a\u00020AH\u0002J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\tHÆ\u0001J\u0006\u0010R\u001a\u00020\u0005J\u0006\u0010S\u001a\u00020TJ\u0013\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\u0005HÖ\u0001J\b\u0010Y\u001a\u00020AH\u0002J\u000e\u0010Z\u001a\u00020A2\u0006\u0010[\u001a\u00020\u0005J\u0014\u0010\\\u001a\u00020A2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bJ\u0014\u0010^\u001a\u00020A2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010_\u001a\u00020A2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bJ\u000e\u0010a\u001a\u00020A2\u0006\u0010b\u001a\u00020\u001bJ\u0006\u0010c\u001a\u00020AJ\u0006\u0010d\u001a\u00020\tJ\u0006\u0010e\u001a\u00020\tJ\u0006\u0010f\u001a\u00020TJ\u0006\u0010g\u001a\u00020\u0005J\u000e\u0010h\u001a\u00020A2\u0006\u0010i\u001a\u00020jJ\t\u0010k\u001a\u00020\u0003HÖ\u0001J\u0006\u0010b\u001a\u00020\u001bR\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u00101R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010!\"\u0004\b3\u00101R&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010!\"\u0004\b9\u00101R\u001e\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001f¨\u0006l"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivity;", "", "timezone", "", "fromDate", "", "toDate", "steps", "distance", "", "trackPoints", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "tagList", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTag;", "adjustTrackPoints", "activity", "detailType", "dataType", "calories", "totalTime", "(Ljava/lang/String;IIIFLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IF)V", "getActivity", "()Ljava/lang/String;", "setActivity", "(Ljava/lang/String;)V", "activityType", "Ljp/reifrontier/silentlogsdkandroid/utils/RFL_ACTIVITY_TYPE;", "getAdjustTrackPoints", "()Ljava/util/List;", "setAdjustTrackPoints", "(Ljava/util/List;)V", "getCalories", "()I", "dailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "getDailyUtils$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "setDailyUtils$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;)V", "getDataType", "getDetailType", "setDetailType", "getDistance", "()F", "setDistance", "(F)V", "getFromDate", "setFromDate", "(I)V", "getSteps", "setSteps", "getTagList", "setTagList", "getTimezone", "setTimezone", "getToDate", "setToDate", "getTotalTime", "setTotalTime", "getTrackPoints", "setTrackPoints", "actualEndTime", "actualStartTime", "addTrackPoint", "", "tp", "calculateDistance", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "count", "endTime", "Ljava/util/Date;", "equals", "", "other", "hashCode", "initComponent", "removeTrackpointAt", "index", "replaceUserTagList", "savedUserTagList", "setLocation", "setNewTagList", "newList", "setType", "type", "setTypeFromString", "speed", "speedA2B", "startTime", "stepPerAct", "to", "timestamp", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity */
public final class RFLActivity {

    /* renamed from: a */
    private transient RFL_ACTIVITY_TYPE f3513a = RFL_ACTIVITY_TYPE.STAY;
    @SerializedName("timezone")
    @Expose

    /* renamed from: b */
    private String f3514b;
    @SerializedName("startTime")
    @Expose

    /* renamed from: c */
    private int f3515c;
    @SerializedName("endTime")
    @Expose

    /* renamed from: d */
    private int f3516d;
    public transient RFLDailyUtils dailyUtils;
    @SerializedName("steps")
    @Expose

    /* renamed from: e */
    private int f3517e;
    @SerializedName("totalDistance")
    @Expose

    /* renamed from: f */
    private float f3518f;
    @SerializedName("trackPoints")
    @Expose

    /* renamed from: g */
    private List<RFLTrackPoint> f3519g;
    @SerializedName("activityTagList")
    @Expose

    /* renamed from: h */
    private List<RFLTag> f3520h;
    @SerializedName("adjustTrackPoints")
    @Expose

    /* renamed from: i */
    private List<RFLTrackPoint> f3521i;
    @SerializedName("activity")
    @Expose

    /* renamed from: j */
    private String f3522j;
    @SerializedName("detailType")
    @Expose

    /* renamed from: k */
    private String f3523k;
    @SerializedName("dataType")
    @Expose

    /* renamed from: l */
    private final String f3524l;
    @SerializedName("calories")
    @Expose

    /* renamed from: m */
    private final int f3525m;
    @SerializedName("totalTime")
    @Expose

    /* renamed from: n */
    private float f3526n;

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFL_ACTIVITY_TYPE.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFL_ACTIVITY_TYPE rfl_activity_type = RFL_ACTIVITY_TYPE.STAY;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFL_ACTIVITY_TYPE rfl_activity_type2 = RFL_ACTIVITY_TYPE.TRANSPORT;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFL_ACTIVITY_TYPE rfl_activity_type3 = RFL_ACTIVITY_TYPE.WALK;
            iArr3[2] = 3;
        }
    }

    public RFLActivity(String str, int i, int i2, int i3, float f, List<RFLTrackPoint> list, List<RFLTag> list2, List<RFLTrackPoint> list3, String str2, String str3, String str4, int i4, float f2) {
        Intrinsics.checkParameterIsNotNull(str, "timezone");
        Intrinsics.checkParameterIsNotNull(list, "trackPoints");
        Intrinsics.checkParameterIsNotNull(list3, "adjustTrackPoints");
        Intrinsics.checkParameterIsNotNull(str2, "activity");
        Intrinsics.checkParameterIsNotNull(str3, "detailType");
        Intrinsics.checkParameterIsNotNull(str4, "dataType");
        this.f3514b = str;
        this.f3515c = i;
        this.f3516d = i2;
        this.f3517e = i3;
        this.f3518f = f;
        this.f3519g = list;
        this.f3520h = list2;
        this.f3521i = list3;
        this.f3522j = str2;
        this.f3523k = str3;
        this.f3524l = str4;
        this.f3525m = i4;
        this.f3526n = f2;
        m3843b();
        setTypeFromString();
    }

    /* renamed from: a */
    private final void m3842a() {
        float f = 0.0f;
        if (this.f3519g.size() > 2) {
            int size = this.f3519g.size();
            for (int i = 0; i < size; i++) {
                RFLTrackPoint rFLTrackPoint = this.f3519g.get(i);
                if (rFLTrackPoint.getTimestamp() >= this.f3515c && i != 0) {
                    RFLDailyUtils rFLDailyUtils = this.dailyUtils;
                    if (rFLDailyUtils == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                    }
                    f = rFLDailyUtils.distanceBetween(this.f3519g.get(i - 1), rFLTrackPoint) + f;
                }
            }
        }
        this.f3518f = f;
    }

    /* renamed from: b */
    private final void m3843b() {
        if (this.dailyUtils == null) {
            if (RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release() == null) {
                this.dailyUtils = new RFLDailyUtils();
                return;
            }
            RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
            if (component$silentlogsdkandroid_release == null) {
                Intrinsics.throwNpe();
            }
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    public static /* synthetic */ RFLActivity copy$default(RFLActivity rFLActivity, String str, int i, int i2, int i3, float f, List list, List list2, List list3, String str2, String str3, String str4, int i4, float f2, int i5, Object obj) {
        RFLActivity rFLActivity2 = rFLActivity;
        int i6 = i5;
        return rFLActivity.copy((i6 & 1) != 0 ? rFLActivity2.f3514b : str, (i6 & 2) != 0 ? rFLActivity2.f3515c : i, (i6 & 4) != 0 ? rFLActivity2.f3516d : i2, (i6 & 8) != 0 ? rFLActivity2.f3517e : i3, (i6 & 16) != 0 ? rFLActivity2.f3518f : f, (i6 & 32) != 0 ? rFLActivity2.f3519g : list, (i6 & 64) != 0 ? rFLActivity2.f3520h : list2, (i6 & 128) != 0 ? rFLActivity2.f3521i : list3, (i6 & 256) != 0 ? rFLActivity2.f3522j : str2, (i6 & 512) != 0 ? rFLActivity2.f3523k : str3, (i6 & 1024) != 0 ? rFLActivity2.f3524l : str4, (i6 & 2048) != 0 ? rFLActivity2.f3525m : i4, (i6 & 4096) != 0 ? rFLActivity2.f3526n : f2);
    }

    public final int actualEndTime() {
        return ((RFLTrackPoint) CollectionsKt___CollectionsKt.last(this.f3519g)).getTimestamp();
    }

    public final int actualStartTime() {
        return ((RFLTrackPoint) CollectionsKt___CollectionsKt.first(this.f3519g)).getTimestamp();
    }

    public final void addTrackPoint(RFLTrackPoint rFLTrackPoint) {
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint, "tp");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3519g);
        arrayList.add(rFLTrackPoint);
        this.f3519g = arrayList;
        m3842a();
    }

    public final String component1() {
        return this.f3514b;
    }

    public final String component10() {
        return this.f3523k;
    }

    public final String component11() {
        return this.f3524l;
    }

    public final int component12() {
        return this.f3525m;
    }

    public final float component13() {
        return this.f3526n;
    }

    public final int component2() {
        return this.f3515c;
    }

    public final int component3() {
        return this.f3516d;
    }

    public final int component4() {
        return this.f3517e;
    }

    public final float component5() {
        return this.f3518f;
    }

    public final List<RFLTrackPoint> component6() {
        return this.f3519g;
    }

    public final List<RFLTag> component7() {
        return this.f3520h;
    }

    public final List<RFLTrackPoint> component8() {
        return this.f3521i;
    }

    public final String component9() {
        return this.f3522j;
    }

    public final RFLActivity copy(String str, int i, int i2, int i3, float f, List<RFLTrackPoint> list, List<RFLTag> list2, List<RFLTrackPoint> list3, String str2, String str3, String str4, int i4, float f2) {
        String str5 = str;
        Intrinsics.checkParameterIsNotNull(str5, "timezone");
        List<RFLTrackPoint> list4 = list;
        Intrinsics.checkParameterIsNotNull(list4, "trackPoints");
        List<RFLTrackPoint> list5 = list3;
        Intrinsics.checkParameterIsNotNull(list5, "adjustTrackPoints");
        String str6 = str2;
        Intrinsics.checkParameterIsNotNull(str6, "activity");
        String str7 = str3;
        Intrinsics.checkParameterIsNotNull(str7, "detailType");
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, "dataType");
        return new RFLActivity(str5, i, i2, i3, f, list4, list2, list5, str6, str7, str8, i4, f2);
    }

    public final int count() {
        int i = this.f3516d;
        if (i == 0) {
            return 1;
        }
        return (i - this.f3515c) / 60;
    }

    public final Date endTime() {
        return new Date(((long) this.f3516d) * 1000);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLActivity)) {
            return false;
        }
        RFLActivity rFLActivity = (RFLActivity) obj;
        return Intrinsics.areEqual((Object) this.f3514b, (Object) rFLActivity.f3514b) && this.f3515c == rFLActivity.f3515c && this.f3516d == rFLActivity.f3516d && this.f3517e == rFLActivity.f3517e && Float.compare(this.f3518f, rFLActivity.f3518f) == 0 && Intrinsics.areEqual((Object) this.f3519g, (Object) rFLActivity.f3519g) && Intrinsics.areEqual((Object) this.f3520h, (Object) rFLActivity.f3520h) && Intrinsics.areEqual((Object) this.f3521i, (Object) rFLActivity.f3521i) && Intrinsics.areEqual((Object) this.f3522j, (Object) rFLActivity.f3522j) && Intrinsics.areEqual((Object) this.f3523k, (Object) rFLActivity.f3523k) && Intrinsics.areEqual((Object) this.f3524l, (Object) rFLActivity.f3524l) && this.f3525m == rFLActivity.f3525m && Float.compare(this.f3526n, rFLActivity.f3526n) == 0;
    }

    public final String getActivity() {
        return this.f3522j;
    }

    public final List<RFLTrackPoint> getAdjustTrackPoints() {
        return this.f3521i;
    }

    public final int getCalories() {
        return this.f3525m;
    }

    public final RFLDailyUtils getDailyUtils$silentlogsdkandroid_release() {
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return rFLDailyUtils;
    }

    public final String getDataType() {
        return this.f3524l;
    }

    public final String getDetailType() {
        return this.f3523k;
    }

    public final float getDistance() {
        return this.f3518f;
    }

    public final int getFromDate() {
        return this.f3515c;
    }

    public final int getSteps() {
        return this.f3517e;
    }

    public final List<RFLTag> getTagList() {
        return this.f3520h;
    }

    public final String getTimezone() {
        return this.f3514b;
    }

    public final int getToDate() {
        return this.f3516d;
    }

    public final float getTotalTime() {
        return this.f3526n;
    }

    public final List<RFLTrackPoint> getTrackPoints() {
        return this.f3519g;
    }

    public int hashCode() {
        String str = this.f3514b;
        int i = 0;
        int floatToIntBits = (Float.floatToIntBits(this.f3518f) + ((((((((str != null ? str.hashCode() : 0) * 31) + this.f3515c) * 31) + this.f3516d) * 31) + this.f3517e) * 31)) * 31;
        List<RFLTrackPoint> list = this.f3519g;
        int hashCode = (floatToIntBits + (list != null ? list.hashCode() : 0)) * 31;
        List<RFLTag> list2 = this.f3520h;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<RFLTrackPoint> list3 = this.f3521i;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str2 = this.f3522j;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3523k;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3524l;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return Float.floatToIntBits(this.f3526n) + ((((hashCode5 + i) * 31) + this.f3525m) * 31);
    }

    public final void removeTrackpointAt(int i) {
        if (this.f3519g.size() >= i) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f3519g);
            arrayList.remove(i);
            this.f3519g = arrayList;
            m3842a();
        }
    }

    public final void replaceUserTagList(List<RFLTag> list) {
        T t;
        Object obj;
        Intrinsics.checkParameterIsNotNull(list, "savedUserTagList");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((RFLTag) t).isPredictRemoveTag()) {
                break;
            }
        }
        boolean z = t != null;
        ArrayList arrayList = new ArrayList();
        List<RFLTag> list2 = this.f3520h;
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (RFLTag rFLTag : list2) {
                if (Intrinsics.areEqual((Object) rFLTag.getTagName(), (Object) "predict")) {
                    rFLTag = z ? null : RFLTag.copy$default(rFLTag, (String) null, "silentlog-analytics", (String) null, (RFLPredict) null, (RFLActivityPoi) null, 29, (Object) null);
                }
                if (rFLTag != null) {
                    arrayList2.add(rFLTag);
                }
            }
            arrayList.addAll(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            RFLTag rFLTag2 = (RFLTag) next;
            if ((Intrinsics.areEqual((Object) rFLTag2.getTagOwner(), (Object) "user") ^ true) && (Intrinsics.areEqual((Object) rFLTag2.getTagOwner(), (Object) "poi.osm") ^ true)) {
                arrayList4.add(next);
            }
        }
        arrayList3.addAll(arrayList4);
        for (RFLTag next2 : list) {
            if (!next2.isPredictRemoveTag()) {
                Iterator it3 = arrayList3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it3.next();
                    if (Intrinsics.areEqual((Object) ((RFLTag) obj).getTagName(), (Object) next2.getTagName())) {
                        break;
                    }
                }
                if (obj == null) {
                    arrayList3.add(next2);
                }
            }
        }
        this.f3520h = arrayList3;
    }

    public final void setActivity(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f3522j = str;
    }

    public final void setAdjustTrackPoints(List<RFLTrackPoint> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f3521i = list;
    }

    public final void setDailyUtils$silentlogsdkandroid_release(RFLDailyUtils rFLDailyUtils) {
        Intrinsics.checkParameterIsNotNull(rFLDailyUtils, "<set-?>");
        this.dailyUtils = rFLDailyUtils;
    }

    public final void setDetailType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f3523k = str;
    }

    public final void setDistance(float f) {
        this.f3518f = f;
    }

    public final void setFromDate(int i) {
        this.f3515c = i;
    }

    public final void setLocation(List<RFLTrackPoint> list) {
        Intrinsics.checkParameterIsNotNull(list, "trackPoints");
        this.f3519g = list;
        if (list.isEmpty()) {
            this.f3518f = 0.0f;
            return;
        }
        this.f3514b = ((RFLTrackPoint) CollectionsKt___CollectionsKt.first(list)).getTimezone();
        m3842a();
    }

    public final void setNewTagList(List<RFLTag> list) {
        Intrinsics.checkParameterIsNotNull(list, "newList");
        ArrayList arrayList = new ArrayList();
        List<RFLTag> list2 = this.f3520h;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        for (RFLTag next : list) {
            List<RFLTag> list3 = this.f3520h;
            T t = null;
            if (list3 != null) {
                Iterator<T> it = list3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next2 = it.next();
                    if (Intrinsics.areEqual((Object) ((RFLTag) next2).getTagName(), (Object) next.getTagName())) {
                        t = next2;
                        break;
                    }
                }
                t = (RFLTag) t;
            }
            if (t == null) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            RFLTag rFLTag = (RFLTag) it2.next();
            if (Intrinsics.areEqual((Object) rFLTag.getTagName(), (Object) "predict")) {
                rFLTag = RFLTag.copy$default(rFLTag, (String) null, "silentlog-analytics", (String) null, (RFLPredict) null, (RFLActivityPoi) null, 29, (Object) null);
            }
            arrayList2.add(rFLTag);
        }
        this.f3520h = arrayList2;
    }

    public final void setSteps(int i) {
        this.f3517e = i;
    }

    public final void setTagList(List<RFLTag> list) {
        this.f3520h = list;
    }

    public final void setTimezone(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f3514b = str;
    }

    public final void setToDate(int i) {
        this.f3516d = i;
    }

    public final void setTotalTime(float f) {
        this.f3526n = f;
    }

    public final void setTrackPoints(List<RFLTrackPoint> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f3519g = list;
    }

    public final void setType(RFL_ACTIVITY_TYPE rfl_activity_type) {
        Intrinsics.checkParameterIsNotNull(rfl_activity_type, "type");
        this.f3513a = rfl_activity_type;
        int i = WhenMappings.$EnumSwitchMapping$0[rfl_activity_type.ordinal()];
        this.f3522j = i != 1 ? i != 2 ? i != 3 ? "chg" : "wlk" : "trp" : "sty";
    }

    public final void setTypeFromString() {
        RFL_ACTIVITY_TYPE rfl_activity_type;
        String str = this.f3522j;
        int hashCode = str.hashCode();
        if (hashCode != 114232) {
            if (hashCode != 115122) {
                if (hashCode == 117814 && str.equals("wlk")) {
                    rfl_activity_type = RFL_ACTIVITY_TYPE.WALK;
                    this.f3513a = rfl_activity_type;
                }
            } else if (str.equals("trp")) {
                rfl_activity_type = RFL_ACTIVITY_TYPE.TRANSPORT;
                this.f3513a = rfl_activity_type;
            }
        } else if (str.equals("sty")) {
            rfl_activity_type = RFL_ACTIVITY_TYPE.STAY;
            this.f3513a = rfl_activity_type;
        }
        rfl_activity_type = RFL_ACTIVITY_TYPE.CHANGE;
        this.f3513a = rfl_activity_type;
    }

    public final float speed() {
        if (this.f3519g.size() <= 2) {
            return 0.0f;
        }
        RFLTrackPoint rFLTrackPoint = null;
        int size = this.f3519g.size();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < size; i++) {
            RFLTrackPoint rFLTrackPoint2 = this.f3519g.get(i);
            if (rFLTrackPoint2.getTimestamp() >= this.f3515c && rFLTrackPoint2.getTimestamp() <= this.f3516d) {
                if (rFLTrackPoint != null) {
                    RFLDailyUtils rFLDailyUtils = this.dailyUtils;
                    if (rFLDailyUtils == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                    }
                    f2 += rFLDailyUtils.distanceBetween(rFLTrackPoint, rFLTrackPoint2);
                    f += (float) (rFLTrackPoint2.getTimestamp() - rFLTrackPoint.getTimestamp());
                }
                rFLTrackPoint = rFLTrackPoint2;
            }
        }
        if (f <= ((float) 0) || f2 < ((float) 5)) {
            return 0.0f;
        }
        return f2 / f;
    }

    public final float speedA2B() {
        if (this.f3519g.size() <= 2) {
            return 0.0f;
        }
        int size = this.f3519g.size();
        RFLTrackPoint rFLTrackPoint = null;
        RFLTrackPoint rFLTrackPoint2 = null;
        for (int i = 0; i < size; i++) {
            RFLTrackPoint rFLTrackPoint3 = this.f3519g.get(i);
            if (rFLTrackPoint3.getTimestamp() >= this.f3515c && rFLTrackPoint3.getTimestamp() <= this.f3516d) {
                if (rFLTrackPoint == null) {
                    rFLTrackPoint = rFLTrackPoint3;
                    rFLTrackPoint2 = rFLTrackPoint;
                } else {
                    rFLTrackPoint2 = rFLTrackPoint3;
                }
            }
        }
        if (rFLTrackPoint == null || rFLTrackPoint2 == null) {
            return 0.0f;
        }
        Location location = new Location("silentlog_android");
        location.setLatitude(rFLTrackPoint.getLatitude());
        location.setLongitude(rFLTrackPoint.getLongitude());
        Location location2 = new Location("silentlog_android");
        location2.setLatitude(rFLTrackPoint2.getLatitude());
        location2.setLongitude(rFLTrackPoint2.getLongitude());
        float distanceTo = location2.distanceTo(location);
        int timestamp = rFLTrackPoint2.getTimestamp() - rFLTrackPoint.getTimestamp();
        if (timestamp <= 0 || distanceTo < ((float) 5)) {
            return 0.0f;
        }
        return distanceTo / ((float) timestamp);
    }

    public final Date startTime() {
        return new Date(((long) this.f3515c) * 1000);
    }

    public final int stepPerAct() {
        int i;
        int i2 = this.f3516d;
        if (i2 != 0 && (i = (i2 - this.f3515c) / 60) > 0) {
            return this.f3517e / i;
        }
        return 0;
    }

    /* renamed from: to */
    public final void mo32041to(long j) {
        int i = (int) (j / ((long) 1000));
        this.f3516d = i;
        this.f3526n = (float) (i - this.f3515c);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLActivity(timezone=");
        a.append(this.f3514b);
        a.append(", fromDate=");
        a.append(this.f3515c);
        a.append(", toDate=");
        a.append(this.f3516d);
        a.append(", steps=");
        a.append(this.f3517e);
        a.append(", distance=");
        a.append(this.f3518f);
        a.append(", trackPoints=");
        a.append(this.f3519g);
        a.append(", tagList=");
        a.append(this.f3520h);
        a.append(", adjustTrackPoints=");
        a.append(this.f3521i);
        a.append(", activity=");
        a.append(this.f3522j);
        a.append(", detailType=");
        a.append(this.f3523k);
        a.append(", dataType=");
        a.append(this.f3524l);
        a.append(", calories=");
        a.append(this.f3525m);
        a.append(", totalTime=");
        a.append(this.f3526n);
        a.append(")");
        return a.toString();
    }

    public final RFL_ACTIVITY_TYPE type() {
        return this.f3513a;
    }
}
