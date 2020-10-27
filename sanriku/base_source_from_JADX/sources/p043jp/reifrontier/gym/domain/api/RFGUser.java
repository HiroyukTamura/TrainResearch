package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p041io.realm.RealmList;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxyInterface;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00102\u001a\u0004\u0018\u00010&J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\b\u00105\u001a\u0004\u0018\u00010&J\u0006\u00106\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00198\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR$\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00198\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u001e\u0010,\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR$\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001e¨\u00067"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUser;", "Lio/realm/RealmObject;", "()V", "archiveCount", "", "getArchiveCount", "()Ljava/lang/String;", "setArchiveCount", "(Ljava/lang/String;)V", "birthday", "getBirthday", "setBirthday", "email", "getEmail", "setEmail", "firstDate", "getFirstDate", "setFirstDate", "gender", "getGender", "setGender", "handleName", "getHandleName", "setHandleName", "heightHistory", "Lio/realm/RealmList;", "Ljp/reifrontier/gym/domain/api/RFGHistory;", "getHeightHistory", "()Lio/realm/RealmList;", "setHeightHistory", "(Lio/realm/RealmList;)V", "icon", "getIcon", "setIcon", "pushAllow", "getPushAllow", "setPushAllow", "summaryAll", "Ljp/reifrontier/gym/domain/api/RFGUserSummary;", "getSummaryAll", "setSummaryAll", "summaryToday", "getSummaryToday", "setSummaryToday", "userId", "getUserId", "setUserId", "weightHistory", "getWeightHistory", "setWeightHistory", "avg", "gymId", "height", "today", "weight", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.RFGUser */
public class RFGUser extends RealmObject implements jp_reifrontier_gym_domain_api_RFGUserRealmProxyInterface {
    @SerializedName("achieve_count")
    private String archiveCount;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("email")
    private String email;
    @SerializedName("firstDate")
    private String firstDate;
    @SerializedName("gender")
    private String gender;
    @SerializedName("handle_name")
    private String handleName;
    @SerializedName("height_histories")
    private RealmList<RFGHistory> heightHistory;
    @SerializedName("icon")
    private String icon;
    @SerializedName("push_allow")
    private String pushAllow;
    @SerializedName("summary_all")
    private RealmList<RFGUserSummary> summaryAll;
    @SerializedName("summary_today")
    private RealmList<RFGUserSummary> summaryToday;
    @SerializedName("userId")
    @PrimaryKey
    private String userId;
    @SerializedName("weight_histories")
    private RealmList<RFGHistory> weightHistory;

    public RFGUser() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$userId("");
        realmSet$firstDate("");
        realmSet$icon("");
        realmSet$gender("");
        realmSet$birthday("");
        realmSet$email("");
        realmSet$handleName("");
        realmSet$pushAllow("1");
        realmSet$archiveCount(RFGDef.DEFAULT_GYM_ID);
        realmSet$heightHistory(new RealmList());
        realmSet$weightHistory(new RealmList());
        realmSet$summaryToday(new RealmList());
        realmSet$summaryAll(new RealmList());
    }

    public final RFGUserSummary avg() {
        if (getSummaryAll().size() > 0) {
            return getSummaryAll().get(0);
        }
        return null;
    }

    public String getArchiveCount() {
        return realmGet$archiveCount();
    }

    public String getBirthday() {
        return realmGet$birthday();
    }

    public String getEmail() {
        return realmGet$email();
    }

    public String getFirstDate() {
        return realmGet$firstDate();
    }

    public String getGender() {
        return realmGet$gender();
    }

    public String getHandleName() {
        return realmGet$handleName();
    }

    public RealmList<RFGHistory> getHeightHistory() {
        return realmGet$heightHistory();
    }

    public String getIcon() {
        return realmGet$icon();
    }

    public String getPushAllow() {
        return realmGet$pushAllow();
    }

    public RealmList<RFGUserSummary> getSummaryAll() {
        return realmGet$summaryAll();
    }

    public RealmList<RFGUserSummary> getSummaryToday() {
        return realmGet$summaryToday();
    }

    public String getUserId() {
        return realmGet$userId();
    }

    public RealmList<RFGHistory> getWeightHistory() {
        return realmGet$weightHistory();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        r0 = (r0 = getHeightHistory().first()).getGymId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String gymId() {
        /*
            r2 = this;
            io.realm.RealmList r0 = r2.getHeightHistory()
            boolean r0 = r0.isEmpty()
            java.lang.String r1 = "0"
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            io.realm.RealmList r0 = r2.getHeightHistory()
            java.lang.Object r0 = r0.first()
            jp.reifrontier.gym.domain.api.RFGHistory r0 = (p043jp.reifrontier.gym.domain.api.RFGHistory) r0
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = r0.getGymId()
            if (r0 == 0) goto L_0x0020
            r1 = r0
        L_0x0020:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGUser.gymId():java.lang.String");
    }

    public final String height() {
        if (getHeightHistory().size() <= 0) {
            return "";
        }
        List split$default = StringsKt__StringsKt.split$default((CharSequence) ((RFGHistory) CollectionsKt___CollectionsKt.last(CollectionsKt___CollectionsKt.sortedWith(getHeightHistory(), RFGUser$height$sort$1.INSTANCE))).getHeight(), new String[]{"."}, false, 0, 6, (Object) null);
        String substring = StringsKt__StringsKt.substring((String) split$default.get(1), new IntRange(0, 0));
        return ((String) split$default.get(0)) + "." + substring;
    }

    public String realmGet$archiveCount() {
        return this.archiveCount;
    }

    public String realmGet$birthday() {
        return this.birthday;
    }

    public String realmGet$email() {
        return this.email;
    }

    public String realmGet$firstDate() {
        return this.firstDate;
    }

    public String realmGet$gender() {
        return this.gender;
    }

    public String realmGet$handleName() {
        return this.handleName;
    }

    public RealmList realmGet$heightHistory() {
        return this.heightHistory;
    }

    public String realmGet$icon() {
        return this.icon;
    }

    public String realmGet$pushAllow() {
        return this.pushAllow;
    }

    public RealmList realmGet$summaryAll() {
        return this.summaryAll;
    }

    public RealmList realmGet$summaryToday() {
        return this.summaryToday;
    }

    public String realmGet$userId() {
        return this.userId;
    }

    public RealmList realmGet$weightHistory() {
        return this.weightHistory;
    }

    public void realmSet$archiveCount(String str) {
        this.archiveCount = str;
    }

    public void realmSet$birthday(String str) {
        this.birthday = str;
    }

    public void realmSet$email(String str) {
        this.email = str;
    }

    public void realmSet$firstDate(String str) {
        this.firstDate = str;
    }

    public void realmSet$gender(String str) {
        this.gender = str;
    }

    public void realmSet$handleName(String str) {
        this.handleName = str;
    }

    public void realmSet$heightHistory(RealmList realmList) {
        this.heightHistory = realmList;
    }

    public void realmSet$icon(String str) {
        this.icon = str;
    }

    public void realmSet$pushAllow(String str) {
        this.pushAllow = str;
    }

    public void realmSet$summaryAll(RealmList realmList) {
        this.summaryAll = realmList;
    }

    public void realmSet$summaryToday(RealmList realmList) {
        this.summaryToday = realmList;
    }

    public void realmSet$userId(String str) {
        this.userId = str;
    }

    public void realmSet$weightHistory(RealmList realmList) {
        this.weightHistory = realmList;
    }

    public void setArchiveCount(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$archiveCount(str);
    }

    public void setBirthday(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$birthday(str);
    }

    public void setEmail(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$email(str);
    }

    public void setFirstDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$firstDate(str);
    }

    public void setGender(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$gender(str);
    }

    public void setHandleName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$handleName(str);
    }

    public void setHeightHistory(RealmList<RFGHistory> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$heightHistory(realmList);
    }

    public void setIcon(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$icon(str);
    }

    public void setPushAllow(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$pushAllow(str);
    }

    public void setSummaryAll(RealmList<RFGUserSummary> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$summaryAll(realmList);
    }

    public void setSummaryToday(RealmList<RFGUserSummary> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$summaryToday(realmList);
    }

    public void setUserId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$userId(str);
    }

    public void setWeightHistory(RealmList<RFGHistory> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$weightHistory(realmList);
    }

    public final RFGUserSummary today() {
        if (getSummaryToday().size() > 0) {
            return getSummaryToday().get(0);
        }
        return null;
    }

    public final String weight() {
        if (getWeightHistory().size() <= 0) {
            return "";
        }
        List split$default = StringsKt__StringsKt.split$default((CharSequence) ((RFGHistory) CollectionsKt___CollectionsKt.last(CollectionsKt___CollectionsKt.sortedWith(getWeightHistory(), RFGUser$weight$sort$1.INSTANCE))).getWeight(), new String[]{"."}, false, 0, 6, (Object) null);
        String substring = StringsKt__StringsKt.substring((String) split$default.get(1), new IntRange(0, 0));
        return ((String) split$default.get(0)) + "." + substring;
    }
}
