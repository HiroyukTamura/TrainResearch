package p043jp.reifrontier.gym.domain.api;

import android.content.Context;
import androidx.annotation.DrawableRes;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.util.CalendarEx;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0001Bå\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003Jî\u0001\u0010{\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010|J\b\u0010}\u001a\u00020\u0014H\u0002J\u0013\u0010~\u001a\u00020S2\b\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0007\u0010\u0001\u001a\u00020\u0003J\n\u0010\u0001\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0001\u001a\u00020\u0014H\u0003J\t\u0010\u0001\u001a\u00020\u0014H\u0003J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001J\u0011\u0010\u0001\u001a\u00020\u00032\b\u0010\u0001\u001a\u00030\u0001R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010$R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010$R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010$R\u0014\u0010)\u001a\u00020*8BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010$R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010$R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010$R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010$R\u0013\u00105\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b6\u00107R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001d\"\u0004\b9\u0010$R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b:\u00107\"\u0004\b;\u0010<R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u0010$R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001d\"\u0004\bA\u0010$R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010$R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001d\"\u0004\bE\u0010$R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001d\"\u0004\bG\u0010$R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001d\"\u0004\bI\u0010$R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001d\"\u0004\bK\u0010$R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001d\"\u0004\bM\u0010$R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001d\"\u0004\bO\u0010$R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001d\"\u0004\bQ\u0010$R\u0011\u0010R\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bR\u0010TR\u0011\u0010U\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bU\u0010TR\u0011\u0010V\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010W\u001a\u00020SXD¢\u0006\b\n\u0000\u001a\u0004\bW\u0010TR \u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030Y8BX\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0011\u0010\\\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b]\u0010\u001dR\u0011\u0010^\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b_\u0010\u001dR\u0011\u0010`\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\ba\u0010\u001dR\u0011\u0010b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bc\u0010\u001dR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u001d\"\u0004\be\u0010$¨\u0006\u0001"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGFeed;", "", "feedId", "", "feedTypeId", "feedTypeName", "userId", "feedUserName", "feedTitle", "feedDetail", "feedImage", "feedDate", "feedCreateDate", "feedUpdateDate", "feedStatus", "feedUrl", "feedSpecId", "feedMets", "feedSteps", "feedMiddleMets", "", "feedPoint", "feedChallengeName", "feedDistanceBike", "feedChallenge", "Ljp/reifrontier/gym/domain/api/RFGChallenge;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/reifrontier/gym/domain/api/RFGChallenge;)V", "distance", "getDistance", "()Ljava/lang/String;", "getFeedChallenge", "()Ljp/reifrontier/gym/domain/api/RFGChallenge;", "setFeedChallenge", "(Ljp/reifrontier/gym/domain/api/RFGChallenge;)V", "getFeedChallengeName", "setFeedChallengeName", "(Ljava/lang/String;)V", "getFeedCreateDate", "setFeedCreateDate", "getFeedDate", "setFeedDate", "feedDateMillis", "", "getFeedDateMillis", "()J", "getFeedDetail", "setFeedDetail", "getFeedDistanceBike", "setFeedDistanceBike", "getFeedId", "setFeedId", "getFeedImage", "setFeedImage", "feedImageResource", "getFeedImageResource", "()Ljava/lang/Integer;", "getFeedMets", "setFeedMets", "getFeedMiddleMets", "setFeedMiddleMets", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFeedPoint", "setFeedPoint", "getFeedSpecId", "setFeedSpecId", "getFeedStatus", "setFeedStatus", "getFeedSteps", "setFeedSteps", "getFeedTitle", "setFeedTitle", "getFeedTypeId", "setFeedTypeId", "getFeedTypeName", "setFeedTypeName", "getFeedUpdateDate", "setFeedUpdateDate", "getFeedUrl", "setFeedUrl", "getFeedUserName", "setFeedUserName", "isMatome", "", "()Z", "isUser", "isValid", "isWeight", "matomeDetail", "", "getMatomeDetail", "()Ljava/util/Map;", "mets", "getMets", "point", "getPoint", "specId", "getSpecId", "steps", "getSteps", "getUserId", "setUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/reifrontier/gym/domain/api/RFGChallenge;)Ljp/reifrontier/gym/domain/api/RFGFeed;", "distanceImage", "equals", "other", "extMets", "hashCode", "numberOfRidesImage", "randomLittleLaterToReachImage", "randomYesterdayLogImage", "toString", "username", "context", "Landroid/content/Context;", "FeedType", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGFeed */
public final class RFGFeed {
    @SerializedName("challenge_challenge")
    private RFGChallenge feedChallenge;
    @SerializedName("challenge_name")
    private String feedChallengeName;
    @SerializedName("created_at")
    private String feedCreateDate;
    @SerializedName("feed_date")
    private String feedDate;
    @SerializedName("feed_detail")
    private String feedDetail;
    @SerializedName("distance_bicycle")
    private String feedDistanceBike;
    @SerializedName("id")
    private String feedId;
    @SerializedName("feed_image")
    private String feedImage;
    @SerializedName("mets")
    private String feedMets;
    @SerializedName("middle_mets")
    private Integer feedMiddleMets;
    @SerializedName("point")
    private String feedPoint;
    @SerializedName("spec_id")
    private String feedSpecId;
    @SerializedName("feed_status_id")
    private String feedStatus;
    @SerializedName("steps")
    private String feedSteps;
    @SerializedName("feed_title")
    private String feedTitle;
    @SerializedName("feedtype_id")
    private String feedTypeId;
    @SerializedName("feedtype_name")
    private String feedTypeName;
    @SerializedName("updated_at")
    private String feedUpdateDate;
    @SerializedName("feed_url")
    private String feedUrl;
    @SerializedName("handle_name")
    private String feedUserName;
    private final transient boolean isWeight;
    @SerializedName("sl2user_id")
    private String userId;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGFeed$FeedType;", "", "specId", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSpecId", "()Ljava/lang/String;", "BOARDING_POINT", "LITTLE_LATER_TO_REACH", "REACH_METS", "MATOME", "REGISTER", "LOGIN_BONUS", "NUMBER_OF_RIDES_BONUS", "DISTANCE_BONUS", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.domain.api.RFGFeed$FeedType */
    public enum FeedType {
        BOARDING_POINT(UnifiedNativeAdAssetNames.ASSET_HEADLINE),
        LITTLE_LATER_TO_REACH(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION),
        REACH_METS(UnifiedNativeAdAssetNames.ASSET_ICON),
        MATOME(UnifiedNativeAdAssetNames.ASSET_BODY),
        REGISTER(UnifiedNativeAdAssetNames.ASSET_ADVERTISER),
        LOGIN_BONUS(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO),
        NUMBER_OF_RIDES_BONUS(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW),
        DISTANCE_BONUS("3012");
        
        private final String specId;

        private FeedType(String str) {
            this.specId = str;
        }

        public final String getSpecId() {
            return this.specId;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.domain.api.RFGFeed$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeedType.values().length];
            $EnumSwitchMapping$0 = iArr;
            FeedType feedType = FeedType.BOARDING_POINT;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            FeedType feedType2 = FeedType.LITTLE_LATER_TO_REACH;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            FeedType feedType3 = FeedType.REACH_METS;
            iArr3[2] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            FeedType feedType4 = FeedType.MATOME;
            iArr4[3] = 4;
            int[] iArr5 = $EnumSwitchMapping$0;
            FeedType feedType5 = FeedType.REGISTER;
            iArr5[4] = 5;
            int[] iArr6 = $EnumSwitchMapping$0;
            FeedType feedType6 = FeedType.LOGIN_BONUS;
            iArr6[5] = 6;
            int[] iArr7 = $EnumSwitchMapping$0;
            FeedType feedType7 = FeedType.NUMBER_OF_RIDES_BONUS;
            iArr7[6] = 7;
            int[] iArr8 = $EnumSwitchMapping$0;
            FeedType feedType8 = FeedType.DISTANCE_BONUS;
            iArr8[7] = 8;
        }
    }

    public RFGFeed() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (RFGChallenge) null, 2097151, (DefaultConstructorMarker) null);
    }

    public RFGFeed(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Integer num, String str17, String str18, String str19, RFGChallenge rFGChallenge) {
        String str20 = str;
        String str21 = str2;
        String str22 = str3;
        String str23 = str4;
        String str24 = str5;
        String str25 = str6;
        String str26 = str7;
        String str27 = str8;
        String str28 = str9;
        String str29 = str10;
        String str30 = str11;
        String str31 = str12;
        String str32 = str15;
        String str33 = str16;
        Intrinsics.checkParameterIsNotNull(str20, "feedId");
        Intrinsics.checkParameterIsNotNull(str21, "feedTypeId");
        Intrinsics.checkParameterIsNotNull(str22, "feedTypeName");
        Intrinsics.checkParameterIsNotNull(str23, "userId");
        Intrinsics.checkParameterIsNotNull(str24, "feedUserName");
        Intrinsics.checkParameterIsNotNull(str25, "feedTitle");
        Intrinsics.checkParameterIsNotNull(str26, "feedDetail");
        Intrinsics.checkParameterIsNotNull(str27, "feedImage");
        Intrinsics.checkParameterIsNotNull(str28, "feedDate");
        Intrinsics.checkParameterIsNotNull(str29, "feedCreateDate");
        Intrinsics.checkParameterIsNotNull(str30, "feedUpdateDate");
        Intrinsics.checkParameterIsNotNull(str31, "feedStatus");
        Intrinsics.checkParameterIsNotNull(str32, "feedMets");
        Intrinsics.checkParameterIsNotNull(str33, "feedSteps");
        this.feedId = str20;
        this.feedTypeId = str21;
        this.feedTypeName = str22;
        this.userId = str23;
        this.feedUserName = str24;
        this.feedTitle = str25;
        this.feedDetail = str26;
        this.feedImage = str27;
        this.feedDate = str28;
        this.feedCreateDate = str29;
        this.feedUpdateDate = str30;
        this.feedStatus = str31;
        this.feedUrl = str13;
        this.feedSpecId = str14;
        this.feedMets = str32;
        this.feedSteps = str33;
        this.feedMiddleMets = num;
        this.feedPoint = str17;
        this.feedChallengeName = str18;
        this.feedDistanceBike = str19;
        this.feedChallenge = rFGChallenge;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGFeed(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.Integer r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, p043jp.reifrontier.gym.domain.api.RFGChallenge r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            r22 = this;
            r0 = r44
            r1 = r0 & 1
            java.lang.String r2 = "0"
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r23
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r24
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r25
        L_0x001c:
            r5 = r0 & 8
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0024
            r5 = r6
            goto L_0x0026
        L_0x0024:
            r5 = r26
        L_0x0026:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002c
            r7 = r6
            goto L_0x002e
        L_0x002c:
            r7 = r27
        L_0x002e:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0034
            r8 = r6
            goto L_0x0036
        L_0x0034:
            r8 = r28
        L_0x0036:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003c
            r9 = r6
            goto L_0x003e
        L_0x003c:
            r9 = r29
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0044
            r10 = r6
            goto L_0x0046
        L_0x0044:
            r10 = r30
        L_0x0046:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004c
            r11 = r6
            goto L_0x004e
        L_0x004c:
            r11 = r31
        L_0x004e:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0054
            r12 = r6
            goto L_0x0056
        L_0x0054:
            r12 = r32
        L_0x0056:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005c
            r13 = r6
            goto L_0x005e
        L_0x005c:
            r13 = r33
        L_0x005e:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0065
            java.lang.String r14 = "1"
            goto L_0x0067
        L_0x0065:
            r14 = r34
        L_0x0067:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006d
            r15 = r6
            goto L_0x006f
        L_0x006d:
            r15 = r35
        L_0x006f:
            r45 = r2
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0077
            r2 = r6
            goto L_0x0079
        L_0x0077:
            r2 = r36
        L_0x0079:
            r23 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0082
            r6 = r23
            goto L_0x0084
        L_0x0082:
            r6 = r37
        L_0x0084:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x008e
            r16 = r23
            goto L_0x0090
        L_0x008e:
            r16 = r38
        L_0x0090:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x009d
            r17 = 0
            java.lang.Integer r17 = java.lang.Integer.valueOf(r17)
            goto L_0x009f
        L_0x009d:
            r17 = r39
        L_0x009f:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00a8
            r18 = r45
            goto L_0x00aa
        L_0x00a8:
            r18 = r40
        L_0x00aa:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00b3
            r19 = r45
            goto L_0x00b5
        L_0x00b3:
            r19 = r41
        L_0x00b5:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00be
            java.lang.String r20 = "0.00"
            goto L_0x00c0
        L_0x00be:
            r20 = r42
        L_0x00c0:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r21
            if (r0 == 0) goto L_0x00c8
            r0 = 0
            goto L_0x00ca
        L_0x00c8:
            r0 = r43
        L_0x00ca:
            r23 = r22
            r24 = r1
            r25 = r3
            r26 = r4
            r27 = r5
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r35 = r14
            r36 = r15
            r37 = r2
            r38 = r6
            r39 = r16
            r40 = r17
            r41 = r18
            r42 = r19
            r43 = r20
            r44 = r0
            r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGFeed.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, jp.reifrontier.gym.domain.api.RFGChallenge, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGFeed copy$default(RFGFeed rFGFeed, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Integer num, String str17, String str18, String str19, RFGChallenge rFGChallenge, int i, Object obj) {
        RFGFeed rFGFeed2 = rFGFeed;
        int i2 = i;
        return rFGFeed.copy((i2 & 1) != 0 ? rFGFeed2.feedId : str, (i2 & 2) != 0 ? rFGFeed2.feedTypeId : str2, (i2 & 4) != 0 ? rFGFeed2.feedTypeName : str3, (i2 & 8) != 0 ? rFGFeed2.userId : str4, (i2 & 16) != 0 ? rFGFeed2.feedUserName : str5, (i2 & 32) != 0 ? rFGFeed2.feedTitle : str6, (i2 & 64) != 0 ? rFGFeed2.feedDetail : str7, (i2 & 128) != 0 ? rFGFeed2.feedImage : str8, (i2 & 256) != 0 ? rFGFeed2.feedDate : str9, (i2 & 512) != 0 ? rFGFeed2.feedCreateDate : str10, (i2 & 1024) != 0 ? rFGFeed2.feedUpdateDate : str11, (i2 & 2048) != 0 ? rFGFeed2.feedStatus : str12, (i2 & 4096) != 0 ? rFGFeed2.feedUrl : str13, (i2 & 8192) != 0 ? rFGFeed2.feedSpecId : str14, (i2 & 16384) != 0 ? rFGFeed2.feedMets : str15, (i2 & 32768) != 0 ? rFGFeed2.feedSteps : str16, (i2 & 65536) != 0 ? rFGFeed2.feedMiddleMets : num, (i2 & 131072) != 0 ? rFGFeed2.feedPoint : str17, (i2 & 262144) != 0 ? rFGFeed2.feedChallengeName : str18, (i2 & 524288) != 0 ? rFGFeed2.feedDistanceBike : str19, (i2 & 1048576) != 0 ? rFGFeed2.feedChallenge : rFGChallenge);
    }

    private final int distanceImage() {
        return R.mipmap.feed_1000km;
    }

    private final long getFeedDateMillis() {
        Calendar parseTime = CalendarEx.INSTANCE.parseTime(this.feedDate, "yyyy-MM-dd HH:mm:ss");
        return parseTime != null ? parseTime.getTimeInMillis() : System.currentTimeMillis();
    }

    private final Map<String, String> getMatomeDetail() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (Intrinsics.areEqual((Object) getSpecId(), (Object) FeedType.MATOME.getSpecId())) {
            for (String split$default : StringsKt__StringsKt.split$default((CharSequence) this.feedDetail, new String[]{","}, false, 0, 6, (Object) null)) {
                List split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default, new String[]{"="}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2) {
                    linkedHashMap.put(split$default2.get(0), split$default2.get(1));
                }
            }
        }
        return linkedHashMap;
    }

    private final int numberOfRidesImage() {
        String str;
        List split$default = StringsKt__StringsKt.split$default((CharSequence) this.feedDetail, new String[]{"--SANJSON--,"}, false, 0, 6, (Object) null);
        if (split$default.size() != 2) {
            return R.mipmap.feed_year1st;
        }
        Map map = (Map) new Gson().fromJson((String) split$default.get(1), new RFGFeed$numberOfRidesImage$mapType$1().getType());
        if (!map.containsKey("image") || (str = (String) map.get("image")) == null) {
            return R.mipmap.feed_year1st;
        }
        int hashCode = str.hashCode();
        if (hashCode != -1296631563) {
            return hashCode != -1296630773 ? (hashCode == -1296629688 && str.equals("year3rd")) ? R.mipmap.feed_year3rd : R.mipmap.feed_year1st : str.equals("year2nd") ? R.mipmap.feed_year2nd : R.mipmap.feed_year1st;
        }
        boolean equals = str.equals("year1st");
        return R.mipmap.feed_year1st;
    }

    @DrawableRes
    private final int randomLittleLaterToReachImage() {
        return RandomKt.Random(getFeedDateMillis()).nextInt(0, 2) != 0 ? R.mipmap.feed_no_count2 : R.mipmap.feed_no_count1;
    }

    @DrawableRes
    private final int randomYesterdayLogImage() {
        int nextInt = RandomKt.Random(getFeedDateMillis()).nextInt(0, 3);
        return nextInt != 0 ? nextInt != 1 ? R.mipmap.feed_yesterday_log3 : R.mipmap.feed_yesterday_log2 : R.mipmap.feed_yesterday_log1;
    }

    public final String component1() {
        return this.feedId;
    }

    public final String component10() {
        return this.feedCreateDate;
    }

    public final String component11() {
        return this.feedUpdateDate;
    }

    public final String component12() {
        return this.feedStatus;
    }

    public final String component13() {
        return this.feedUrl;
    }

    public final String component14() {
        return this.feedSpecId;
    }

    public final String component15() {
        return this.feedMets;
    }

    public final String component16() {
        return this.feedSteps;
    }

    public final Integer component17() {
        return this.feedMiddleMets;
    }

    public final String component18() {
        return this.feedPoint;
    }

    public final String component19() {
        return this.feedChallengeName;
    }

    public final String component2() {
        return this.feedTypeId;
    }

    public final String component20() {
        return this.feedDistanceBike;
    }

    public final RFGChallenge component21() {
        return this.feedChallenge;
    }

    public final String component3() {
        return this.feedTypeName;
    }

    public final String component4() {
        return this.userId;
    }

    public final String component5() {
        return this.feedUserName;
    }

    public final String component6() {
        return this.feedTitle;
    }

    public final String component7() {
        return this.feedDetail;
    }

    public final String component8() {
        return this.feedImage;
    }

    public final String component9() {
        return this.feedDate;
    }

    public final RFGFeed copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Integer num, String str17, String str18, String str19, RFGChallenge rFGChallenge) {
        String str20 = str;
        Intrinsics.checkParameterIsNotNull(str20, "feedId");
        Intrinsics.checkParameterIsNotNull(str2, "feedTypeId");
        Intrinsics.checkParameterIsNotNull(str3, "feedTypeName");
        Intrinsics.checkParameterIsNotNull(str4, "userId");
        Intrinsics.checkParameterIsNotNull(str5, "feedUserName");
        Intrinsics.checkParameterIsNotNull(str6, "feedTitle");
        Intrinsics.checkParameterIsNotNull(str7, "feedDetail");
        Intrinsics.checkParameterIsNotNull(str8, "feedImage");
        Intrinsics.checkParameterIsNotNull(str9, "feedDate");
        Intrinsics.checkParameterIsNotNull(str10, "feedCreateDate");
        Intrinsics.checkParameterIsNotNull(str11, "feedUpdateDate");
        Intrinsics.checkParameterIsNotNull(str12, "feedStatus");
        Intrinsics.checkParameterIsNotNull(str15, "feedMets");
        Intrinsics.checkParameterIsNotNull(str16, "feedSteps");
        return new RFGFeed(str20, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, num, str17, str18, str19, rFGChallenge);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGFeed)) {
            return false;
        }
        RFGFeed rFGFeed = (RFGFeed) obj;
        return Intrinsics.areEqual((Object) this.feedId, (Object) rFGFeed.feedId) && Intrinsics.areEqual((Object) this.feedTypeId, (Object) rFGFeed.feedTypeId) && Intrinsics.areEqual((Object) this.feedTypeName, (Object) rFGFeed.feedTypeName) && Intrinsics.areEqual((Object) this.userId, (Object) rFGFeed.userId) && Intrinsics.areEqual((Object) this.feedUserName, (Object) rFGFeed.feedUserName) && Intrinsics.areEqual((Object) this.feedTitle, (Object) rFGFeed.feedTitle) && Intrinsics.areEqual((Object) this.feedDetail, (Object) rFGFeed.feedDetail) && Intrinsics.areEqual((Object) this.feedImage, (Object) rFGFeed.feedImage) && Intrinsics.areEqual((Object) this.feedDate, (Object) rFGFeed.feedDate) && Intrinsics.areEqual((Object) this.feedCreateDate, (Object) rFGFeed.feedCreateDate) && Intrinsics.areEqual((Object) this.feedUpdateDate, (Object) rFGFeed.feedUpdateDate) && Intrinsics.areEqual((Object) this.feedStatus, (Object) rFGFeed.feedStatus) && Intrinsics.areEqual((Object) this.feedUrl, (Object) rFGFeed.feedUrl) && Intrinsics.areEqual((Object) this.feedSpecId, (Object) rFGFeed.feedSpecId) && Intrinsics.areEqual((Object) this.feedMets, (Object) rFGFeed.feedMets) && Intrinsics.areEqual((Object) this.feedSteps, (Object) rFGFeed.feedSteps) && Intrinsics.areEqual((Object) this.feedMiddleMets, (Object) rFGFeed.feedMiddleMets) && Intrinsics.areEqual((Object) this.feedPoint, (Object) rFGFeed.feedPoint) && Intrinsics.areEqual((Object) this.feedChallengeName, (Object) rFGFeed.feedChallengeName) && Intrinsics.areEqual((Object) this.feedDistanceBike, (Object) rFGFeed.feedDistanceBike) && Intrinsics.areEqual((Object) this.feedChallenge, (Object) rFGFeed.feedChallenge);
    }

    public final String extMets() {
        MatchResult find = new Regex("\\d+歩").find(this.feedDetail, 0);
        return find != null ? (String) StringsKt__StringsKt.split$default((CharSequence) find.getValue(), new String[]{"歩"}, false, 0, 6, (Object) null).get(0) : "9000";
    }

    public final String getDistance() {
        String str = getMatomeDetail().get("distance");
        if (str == null) {
            str = IdManager.DEFAULT_VERSION_NAME;
        }
        return str;
    }

    public final RFGChallenge getFeedChallenge() {
        return this.feedChallenge;
    }

    public final String getFeedChallengeName() {
        return this.feedChallengeName;
    }

    public final String getFeedCreateDate() {
        return this.feedCreateDate;
    }

    public final String getFeedDate() {
        return this.feedDate;
    }

    public final String getFeedDetail() {
        return this.feedDetail;
    }

    public final String getFeedDistanceBike() {
        return this.feedDistanceBike;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final String getFeedImage() {
        return this.feedImage;
    }

    public final Integer getFeedImageResource() {
        FeedType feedType;
        int i;
        FeedType[] values = FeedType.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                feedType = null;
                break;
            }
            feedType = values[i2];
            if (Intrinsics.areEqual((Object) feedType.getSpecId(), (Object) getSpecId())) {
                break;
            }
            i2++;
        }
        if (feedType == null) {
            return null;
        }
        switch (feedType.ordinal()) {
            case 0:
            case 5:
                return null;
            case 1:
                i = randomLittleLaterToReachImage();
                break;
            case 2:
                i = R.mipmap.feed_daily_activity;
                break;
            case 3:
                i = randomYesterdayLogImage();
                break;
            case 4:
                i = R.mipmap.feed_new_account;
                break;
            case 6:
                i = numberOfRidesImage();
                break;
            case 7:
                i = distanceImage();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Integer.valueOf(i);
    }

    public final String getFeedMets() {
        return this.feedMets;
    }

    public final Integer getFeedMiddleMets() {
        return this.feedMiddleMets;
    }

    public final String getFeedPoint() {
        return this.feedPoint;
    }

    public final String getFeedSpecId() {
        return this.feedSpecId;
    }

    public final String getFeedStatus() {
        return this.feedStatus;
    }

    public final String getFeedSteps() {
        return this.feedSteps;
    }

    public final String getFeedTitle() {
        return this.feedTitle;
    }

    public final String getFeedTypeId() {
        return this.feedTypeId;
    }

    public final String getFeedTypeName() {
        return this.feedTypeName;
    }

    public final String getFeedUpdateDate() {
        return this.feedUpdateDate;
    }

    public final String getFeedUrl() {
        return this.feedUrl;
    }

    public final String getFeedUserName() {
        return this.feedUserName;
    }

    public final String getMets() {
        String str = getMatomeDetail().get("mets");
        if (str == null) {
            str = IdManager.DEFAULT_VERSION_NAME;
        }
        return str;
    }

    public final String getPoint() {
        String str = getMatomeDetail().get("point");
        if (str == null) {
            str = RFGDef.DEFAULT_GYM_ID;
        }
        return str;
    }

    public final String getSpecId() {
        String str = this.feedSpecId;
        if (str == null || str.length() == 0) {
            return "";
        }
        String str2 = this.feedSpecId;
        if (str2 != null) {
            return str2;
        }
        Intrinsics.throwNpe();
        return str2;
    }

    public final String getSteps() {
        String str = getMatomeDetail().get("steps");
        if (str == null) {
            str = RFGDef.DEFAULT_GYM_ID;
        }
        return str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.feedId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.feedTypeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.feedTypeName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.userId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.feedUserName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.feedTitle;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.feedDetail;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.feedImage;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.feedDate;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.feedCreateDate;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.feedUpdateDate;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.feedStatus;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.feedUrl;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.feedSpecId;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.feedMets;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.feedSteps;
        int hashCode16 = (hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        Integer num = this.feedMiddleMets;
        int hashCode17 = (hashCode16 + (num != null ? num.hashCode() : 0)) * 31;
        String str17 = this.feedPoint;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.feedChallengeName;
        int hashCode19 = (hashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.feedDistanceBike;
        int hashCode20 = (hashCode19 + (str19 != null ? str19.hashCode() : 0)) * 31;
        RFGChallenge rFGChallenge = this.feedChallenge;
        if (rFGChallenge != null) {
            i = rFGChallenge.hashCode();
        }
        return hashCode20 + i;
    }

    public final boolean isMatome() {
        return Intrinsics.areEqual((Object) this.feedSpecId, (Object) FeedType.MATOME.getSpecId());
    }

    public final boolean isUser() {
        return isMatome();
    }

    public final boolean isValid() {
        return this.feedTypeId.length() > 0;
    }

    public final boolean isWeight() {
        return this.isWeight;
    }

    public final void setFeedChallenge(RFGChallenge rFGChallenge) {
        this.feedChallenge = rFGChallenge;
    }

    public final void setFeedChallengeName(String str) {
        this.feedChallengeName = str;
    }

    public final void setFeedCreateDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedCreateDate = str;
    }

    public final void setFeedDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedDate = str;
    }

    public final void setFeedDetail(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedDetail = str;
    }

    public final void setFeedDistanceBike(String str) {
        this.feedDistanceBike = str;
    }

    public final void setFeedId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedId = str;
    }

    public final void setFeedImage(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedImage = str;
    }

    public final void setFeedMets(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedMets = str;
    }

    public final void setFeedMiddleMets(Integer num) {
        this.feedMiddleMets = num;
    }

    public final void setFeedPoint(String str) {
        this.feedPoint = str;
    }

    public final void setFeedSpecId(String str) {
        this.feedSpecId = str;
    }

    public final void setFeedStatus(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedStatus = str;
    }

    public final void setFeedSteps(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedSteps = str;
    }

    public final void setFeedTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedTitle = str;
    }

    public final void setFeedTypeId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedTypeId = str;
    }

    public final void setFeedTypeName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedTypeName = str;
    }

    public final void setFeedUpdateDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedUpdateDate = str;
    }

    public final void setFeedUrl(String str) {
        this.feedUrl = str;
    }

    public final void setFeedUserName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedUserName = str;
    }

    public final void setUserId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.userId = str;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGFeed(feedId=");
        a.append(this.feedId);
        a.append(", feedTypeId=");
        a.append(this.feedTypeId);
        a.append(", feedTypeName=");
        a.append(this.feedTypeName);
        a.append(", userId=");
        a.append(this.userId);
        a.append(", feedUserName=");
        a.append(this.feedUserName);
        a.append(", feedTitle=");
        a.append(this.feedTitle);
        a.append(", feedDetail=");
        a.append(this.feedDetail);
        a.append(", feedImage=");
        a.append(this.feedImage);
        a.append(", feedDate=");
        a.append(this.feedDate);
        a.append(", feedCreateDate=");
        a.append(this.feedCreateDate);
        a.append(", feedUpdateDate=");
        a.append(this.feedUpdateDate);
        a.append(", feedStatus=");
        a.append(this.feedStatus);
        a.append(", feedUrl=");
        a.append(this.feedUrl);
        a.append(", feedSpecId=");
        a.append(this.feedSpecId);
        a.append(", feedMets=");
        a.append(this.feedMets);
        a.append(", feedSteps=");
        a.append(this.feedSteps);
        a.append(", feedMiddleMets=");
        a.append(this.feedMiddleMets);
        a.append(", feedPoint=");
        a.append(this.feedPoint);
        a.append(", feedChallengeName=");
        a.append(this.feedChallengeName);
        a.append(", feedDistanceBike=");
        a.append(this.feedDistanceBike);
        a.append(", feedChallenge=");
        a.append(this.feedChallenge);
        a.append(")");
        return a.toString();
    }

    public final String username(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (isMatome()) {
            return this.feedUserName;
        }
        String string = context.getResources().getString(R.string.admin_name);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.resources.getString(R.string.admin_name)");
        return string;
    }
}
