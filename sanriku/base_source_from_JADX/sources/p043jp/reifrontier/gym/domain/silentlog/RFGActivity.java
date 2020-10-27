package p043jp.reifrontier.gym.domain.silentlog;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1012xc63ff62a;
import p041io.realm.RealmList;
import p041io.realm.RealmObject;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;
import p043jp.reifrontier.gym.domain.api.RFGModActivity;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010 \u001a\u00020\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00138\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018¨\u0006\""}, mo21739d2 = {"Ljp/reifrontier/gym/domain/silentlog/RFGActivity;", "Lio/realm/RealmObject;", "()V", "activity", "", "getActivity", "()Ljava/lang/String;", "setActivity", "(Ljava/lang/String;)V", "fromDate", "", "getFromDate", "()I", "setFromDate", "(I)V", "steps", "getSteps", "setSteps", "tags", "Lio/realm/RealmList;", "Ljp/reifrontier/gym/domain/silentlog/RFGActTag;", "getTags", "()Lio/realm/RealmList;", "setTags", "(Lio/realm/RealmList;)V", "toDate", "getToDate", "setToDate", "trackPoints", "Ljp/reifrontier/gym/domain/silentlog/RFGTrackPoint;", "getTrackPoints", "setTrackPoints", "type", "server", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.silentlog.RFGActivity */
public class RFGActivity extends RealmObject implements C1012xc63ff62a {
    @SerializedName("activity")
    private String activity;
    @SerializedName("startTime")
    private int fromDate;
    @SerializedName("steps")
    private int steps;
    @SerializedName("activityTagList")
    private RealmList<RFGActTag> tags;
    @SerializedName("endTime")
    private int toDate;
    @SerializedName("trackPoints")
    private RealmList<RFGTrackPoint> trackPoints;

    public RFGActivity() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$activity("sty");
        realmSet$trackPoints(new RealmList());
        realmSet$tags(new RealmList());
    }

    public static /* synthetic */ String type$default(RFGActivity rFGActivity, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return rFGActivity.type(str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: type");
    }

    public String getActivity() {
        return realmGet$activity();
    }

    public int getFromDate() {
        return realmGet$fromDate();
    }

    public int getSteps() {
        return realmGet$steps();
    }

    public RealmList<RFGActTag> getTags() {
        return realmGet$tags();
    }

    public int getToDate() {
        return realmGet$toDate();
    }

    public RealmList<RFGTrackPoint> getTrackPoints() {
        return realmGet$trackPoints();
    }

    public String realmGet$activity() {
        return this.activity;
    }

    public int realmGet$fromDate() {
        return this.fromDate;
    }

    public int realmGet$steps() {
        return this.steps;
    }

    public RealmList realmGet$tags() {
        return this.tags;
    }

    public int realmGet$toDate() {
        return this.toDate;
    }

    public RealmList realmGet$trackPoints() {
        return this.trackPoints;
    }

    public void realmSet$activity(String str) {
        this.activity = str;
    }

    public void realmSet$fromDate(int i) {
        this.fromDate = i;
    }

    public void realmSet$steps(int i) {
        this.steps = i;
    }

    public void realmSet$tags(RealmList realmList) {
        this.tags = realmList;
    }

    public void realmSet$toDate(int i) {
        this.toDate = i;
    }

    public void realmSet$trackPoints(RealmList realmList) {
        this.trackPoints = realmList;
    }

    public void setActivity(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$activity(str);
    }

    public void setFromDate(int i) {
        realmSet$fromDate(i);
    }

    public void setSteps(int i) {
        realmSet$steps(i);
    }

    public void setTags(RealmList<RFGActTag> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$tags(realmList);
    }

    public void setToDate(int i) {
        realmSet$toDate(i);
    }

    public void setTrackPoints(RealmList<RFGTrackPoint> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$trackPoints(realmList);
    }

    public final String type(String str) {
        if (getTags().size() == 0) {
            return str != null ? str : getActivity();
        }
        ArrayList arrayList = new ArrayList();
        Gson gson = new Gson();
        Iterator<RFGActTag> it = getTags().iterator();
        while (it.hasNext()) {
            RFGActTag next = it.next();
            if (Intrinsics.areEqual((Object) next.getType(), (Object) "json") && Intrinsics.areEqual((Object) next.getOwner(), (Object) "custom") && (!Intrinsics.areEqual((Object) next.getName(), (Object) "predict"))) {
                RFGModActivity rFGModActivity = (RFGModActivity) gson.fromJson(URLDecoder.decode(next.getName(), "utf-8"), new RFGActivity$type$turnsType$1().getType());
                Intrinsics.checkExpressionValueIsNotNull(rFGModActivity, "modA");
                arrayList.add(rFGModActivity);
            }
        }
        return arrayList.size() == 0 ? str != null ? str : getActivity() : ((RFGModActivity) CollectionsKt___CollectionsKt.first(CollectionsKt___CollectionsKt.sortedWith(arrayList, RFGActivity$type$sort$1.INSTANCE))).getType();
    }
}
