package p043jp.reifrontier.gym.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.squareup.picasso.C1473F;
import com.squareup.picasso.C1489e;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1529y;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p045io.CloseableKt;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.RFGUserChart;
import p043jp.reifrontier.gym.domain.api.RFGUserChartData;
import p043jp.reifrontier.gym.domain.silentlog.RFGDay;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;
import p043jp.reifrontier.gym.p044ui.widget.RFGRadiusTransform;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\u00020\u0001:\u0003FGHB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0004H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020 H\u0002J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020\u001cH\u0016J\b\u0010:\u001a\u00020\u001cH\u0017J\u001a\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010=\u001a\u00020\u001cH\u0002J\b\u0010>\u001a\u00020\u001cH\u0003J\u0016\u0010?\u001a\u00020\u001c2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010@\u001a\u00020\u001cH\u0002J\b\u0010A\u001a\u00020\u001cH\u0002J\u001e\u0010B\u001a\u00020\u001c2\b\b\u0001\u0010C\u001a\u00020\u00102\n\b\u0002\u0010D\u001a\u0004\u0018\u00010EH\u0002R0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048B@BX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "items", "", "Ljp/reifrontier/gym/domain/api/RFGUserChart;", "cache", "getCache", "()Ljava/util/List;", "setCache", "(Ljava/util/List;)V", "cacheChartM12", "cacheChartM6", "cacheChartW12", "cacheChartW6", "cacheDataCount", "", "currentChartType", "Ljp/reifrontier/gym/RFGDef$ChartType;", "hasCache", "", "getHasCache", "()Z", "mListener", "Ljp/reifrontier/gym/fragment/RFGProfileFragment$OnProfileListener;", "user", "Ljp/reifrontier/gym/fragment/RFGProfileFragment$UserProfile;", "bindChart", "", "bindChartFromCache", "bindProfile", "createYTitles", "", "type", "Ljp/reifrontier/gym/RFGDef$ActivityChartType;", "values", "Ljp/reifrontier/gym/domain/api/RFGUserChartData;", "delightButton", "button", "Landroid/widget/Button;", "hideBmi", "highlightButton", "loadUserInfo", "onAttach", "context", "Landroid/content/Context;", "onClickChartButton", "chartType", "analyticsAction", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onResume", "onViewCreated", "view", "requestChartIfNeed", "requestGraph", "setChart", "setProfile", "setupButtons", "showErrorDialog", "resourceId", "listener", "Ljp/reifrontier/gym/ui/dialog/RFGErrorDialog$ErrorDialogListener;", "Companion", "OnProfileListener", "UserProfile", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.RFGProfileFragment */
public final class RFGProfileFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    private List<RFGUserChart> cacheChartM12 = CollectionsKt__CollectionsKt.emptyList();
    private List<RFGUserChart> cacheChartM6 = CollectionsKt__CollectionsKt.emptyList();
    private List<RFGUserChart> cacheChartW12 = CollectionsKt__CollectionsKt.emptyList();
    private List<RFGUserChart> cacheChartW6 = CollectionsKt__CollectionsKt.emptyList();
    private int cacheDataCount = -1;
    private RFGDef.ChartType currentChartType = RFGDef.ChartType.WEEK6;
    /* access modifiers changed from: private */
    public OnProfileListener mListener;
    private UserProfile user;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGProfileFragment$Companion;", "", "()V", "newInstance", "Ljp/reifrontier/gym/fragment/RFGProfileFragment;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGProfileFragment$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGProfileFragment newInstance() {
            return new RFGProfileFragment();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGProfileFragment$OnProfileListener;", "", "onStartLoading", "", "onStopLoading", "onTerminate", "showHandleName", "handleName", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGProfileFragment$OnProfileListener */
    public interface OnProfileListener {
        void onStartLoading();

        void onStopLoading();

        void onTerminate();

        void showHandleName(String str);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGProfileFragment$UserProfile;", "", "handleName", "", "firstDate", "icon", "height", "weight", "gender", "archiveCount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArchiveCount", "()Ljava/lang/String;", "getFirstDate", "getGender", "getHandleName", "getHeight", "getIcon", "getWeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGProfileFragment$UserProfile */
    private static final class UserProfile {
        private final String archiveCount;
        private final String firstDate;
        private final String gender;
        private final String handleName;
        private final String height;
        private final String icon;
        private final String weight;

        public UserProfile(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.checkParameterIsNotNull(str, "handleName");
            Intrinsics.checkParameterIsNotNull(str2, "firstDate");
            Intrinsics.checkParameterIsNotNull(str3, "icon");
            Intrinsics.checkParameterIsNotNull(str4, "height");
            Intrinsics.checkParameterIsNotNull(str5, "weight");
            Intrinsics.checkParameterIsNotNull(str6, "gender");
            Intrinsics.checkParameterIsNotNull(str7, "archiveCount");
            this.handleName = str;
            this.firstDate = str2;
            this.icon = str3;
            this.height = str4;
            this.weight = str5;
            this.gender = str6;
            this.archiveCount = str7;
        }

        public static /* synthetic */ UserProfile copy$default(UserProfile userProfile, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userProfile.handleName;
            }
            if ((i & 2) != 0) {
                str2 = userProfile.firstDate;
            }
            String str8 = str2;
            if ((i & 4) != 0) {
                str3 = userProfile.icon;
            }
            String str9 = str3;
            if ((i & 8) != 0) {
                str4 = userProfile.height;
            }
            String str10 = str4;
            if ((i & 16) != 0) {
                str5 = userProfile.weight;
            }
            String str11 = str5;
            if ((i & 32) != 0) {
                str6 = userProfile.gender;
            }
            String str12 = str6;
            if ((i & 64) != 0) {
                str7 = userProfile.archiveCount;
            }
            return userProfile.copy(str, str8, str9, str10, str11, str12, str7);
        }

        public final String component1() {
            return this.handleName;
        }

        public final String component2() {
            return this.firstDate;
        }

        public final String component3() {
            return this.icon;
        }

        public final String component4() {
            return this.height;
        }

        public final String component5() {
            return this.weight;
        }

        public final String component6() {
            return this.gender;
        }

        public final String component7() {
            return this.archiveCount;
        }

        public final UserProfile copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.checkParameterIsNotNull(str, "handleName");
            Intrinsics.checkParameterIsNotNull(str2, "firstDate");
            Intrinsics.checkParameterIsNotNull(str3, "icon");
            Intrinsics.checkParameterIsNotNull(str4, "height");
            Intrinsics.checkParameterIsNotNull(str5, "weight");
            Intrinsics.checkParameterIsNotNull(str6, "gender");
            String str8 = str7;
            Intrinsics.checkParameterIsNotNull(str8, "archiveCount");
            return new UserProfile(str, str2, str3, str4, str5, str6, str8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserProfile)) {
                return false;
            }
            UserProfile userProfile = (UserProfile) obj;
            return Intrinsics.areEqual((Object) this.handleName, (Object) userProfile.handleName) && Intrinsics.areEqual((Object) this.firstDate, (Object) userProfile.firstDate) && Intrinsics.areEqual((Object) this.icon, (Object) userProfile.icon) && Intrinsics.areEqual((Object) this.height, (Object) userProfile.height) && Intrinsics.areEqual((Object) this.weight, (Object) userProfile.weight) && Intrinsics.areEqual((Object) this.gender, (Object) userProfile.gender) && Intrinsics.areEqual((Object) this.archiveCount, (Object) userProfile.archiveCount);
        }

        public final String getArchiveCount() {
            return this.archiveCount;
        }

        public final String getFirstDate() {
            return this.firstDate;
        }

        public final String getGender() {
            return this.gender;
        }

        public final String getHandleName() {
            return this.handleName;
        }

        public final String getHeight() {
            return this.height;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getWeight() {
            return this.weight;
        }

        public int hashCode() {
            String str = this.handleName;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.firstDate;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.icon;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.height;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.weight;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.gender;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.archiveCount;
            if (str7 != null) {
                i = str7.hashCode();
            }
            return hashCode6 + i;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("UserProfile(handleName=");
            a.append(this.handleName);
            a.append(", firstDate=");
            a.append(this.firstDate);
            a.append(", icon=");
            a.append(this.icon);
            a.append(", height=");
            a.append(this.height);
            a.append(", weight=");
            a.append(this.weight);
            a.append(", gender=");
            a.append(this.gender);
            a.append(", archiveCount=");
            return C0681a.m324a(a, this.archiveCount, ")");
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGProfileFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[RFGDef.ChartType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGDef.ChartType chartType = RFGDef.ChartType.WEEK6;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGDef.ChartType chartType2 = RFGDef.ChartType.WEEK12;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGDef.ChartType chartType3 = RFGDef.ChartType.MONTH6;
            iArr3[2] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            RFGDef.ChartType chartType4 = RFGDef.ChartType.MONTH12;
            iArr4[3] = 4;
            int[] iArr5 = new int[RFGDef.ChartType.values().length];
            $EnumSwitchMapping$1 = iArr5;
            RFGDef.ChartType chartType5 = RFGDef.ChartType.WEEK6;
            iArr5[0] = 1;
            int[] iArr6 = $EnumSwitchMapping$1;
            RFGDef.ChartType chartType6 = RFGDef.ChartType.WEEK12;
            iArr6[1] = 2;
            int[] iArr7 = $EnumSwitchMapping$1;
            RFGDef.ChartType chartType7 = RFGDef.ChartType.MONTH6;
            iArr7[2] = 3;
            int[] iArr8 = $EnumSwitchMapping$1;
            RFGDef.ChartType chartType8 = RFGDef.ChartType.MONTH12;
            iArr8[3] = 4;
            int[] iArr9 = new int[RFGDef.ChartType.values().length];
            $EnumSwitchMapping$2 = iArr9;
            RFGDef.ChartType chartType9 = RFGDef.ChartType.WEEK6;
            iArr9[0] = 1;
            int[] iArr10 = $EnumSwitchMapping$2;
            RFGDef.ChartType chartType10 = RFGDef.ChartType.WEEK12;
            iArr10[1] = 2;
            int[] iArr11 = $EnumSwitchMapping$2;
            RFGDef.ChartType chartType11 = RFGDef.ChartType.MONTH6;
            iArr11[2] = 3;
            int[] iArr12 = $EnumSwitchMapping$2;
            RFGDef.ChartType chartType12 = RFGDef.ChartType.MONTH12;
            iArr12[3] = 4;
            int[] iArr13 = new int[RFGDef.ActivityChartType.values().length];
            $EnumSwitchMapping$3 = iArr13;
            RFGDef.ActivityChartType activityChartType = RFGDef.ActivityChartType.POINT;
            iArr13[1] = 1;
            int[] iArr14 = $EnumSwitchMapping$3;
            RFGDef.ActivityChartType activityChartType2 = RFGDef.ActivityChartType.WEIGHT;
            iArr14[2] = 2;
            int[] iArr15 = $EnumSwitchMapping$3;
            RFGDef.ActivityChartType activityChartType3 = RFGDef.ActivityChartType.STEP;
            iArr15[3] = 3;
            int[] iArr16 = $EnumSwitchMapping$3;
            RFGDef.ActivityChartType activityChartType4 = RFGDef.ActivityChartType.BICYCLE;
            iArr16[4] = 4;
            int[] iArr17 = new int[RFGDef.ChartType.values().length];
            $EnumSwitchMapping$4 = iArr17;
            RFGDef.ChartType chartType13 = RFGDef.ChartType.WEEK6;
            iArr17[0] = 1;
            int[] iArr18 = $EnumSwitchMapping$4;
            RFGDef.ChartType chartType14 = RFGDef.ChartType.WEEK12;
            iArr18[1] = 2;
            int[] iArr19 = $EnumSwitchMapping$4;
            RFGDef.ChartType chartType15 = RFGDef.ChartType.MONTH6;
            iArr19[2] = 3;
            int[] iArr20 = $EnumSwitchMapping$4;
            RFGDef.ChartType chartType16 = RFGDef.ChartType.MONTH12;
            iArr20[3] = 4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d0, code lost:
        r7 = r7.getWeight();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindChart(java.util.List<p043jp.reifrontier.gym.domain.api.RFGUserChart> r20) {
        /*
            r19 = this;
            r0 = r19
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.Iterator r6 = r20.iterator()
        L_0x001a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x007f
            java.lang.Object r7 = r6.next()
            jp.reifrontier.gym.domain.api.RFGUserChart r7 = (p043jp.reifrontier.gym.domain.api.RFGUserChart) r7
            java.lang.String r8 = r7.getType()
            jp.reifrontier.gym.RFGDef$ActivityChartType r9 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.X
            java.lang.String r9 = r9.getJson()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x003b
            java.util.List r1 = r7.getData()
            goto L_0x001a
        L_0x003b:
            jp.reifrontier.gym.RFGDef$ActivityChartType r9 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.POINT
            java.lang.String r9 = r9.getJson()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x004c
            java.util.List r2 = r7.getData()
            goto L_0x001a
        L_0x004c:
            jp.reifrontier.gym.RFGDef$ActivityChartType r9 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.WEIGHT
            java.lang.String r9 = r9.getJson()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x005d
            java.util.List r3 = r7.getData()
            goto L_0x001a
        L_0x005d:
            jp.reifrontier.gym.RFGDef$ActivityChartType r9 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.STEP
            java.lang.String r9 = r9.getJson()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x006e
            java.util.List r4 = r7.getData()
            goto L_0x001a
        L_0x006e:
            jp.reifrontier.gym.RFGDef$ActivityChartType r9 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.BICYCLE
            java.lang.String r9 = r9.getJson()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x001a
            java.util.List r5 = r7.getData()
            goto L_0x001a
        L_0x007f:
            jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$1 r6 = p043jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$1.INSTANCE
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r1, r6)
            jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$2 r6 = p043jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$2.INSTANCE
            java.util.List r10 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r2, r6)
            jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$3 r2 = p043jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$3.INSTANCE
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r3, r2)
            jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$4 r3 = p043jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$4.INSTANCE
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r4, r3)
            jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$5 r4 = p043jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$5.INSTANCE
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r5, r4)
            jp.reifrontier.gym.RFGDef$ActivityChartType r5 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.POINT
            java.util.List r11 = r0.createYTitles(r5, r10)
            jp.reifrontier.gym.RFGDef$ActivityChartType r5 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.WEIGHT
            java.util.List r5 = r0.createYTitles(r5, r2)
            jp.reifrontier.gym.RFGDef$ActivityChartType r6 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.STEP
            java.util.List r6 = r0.createYTitles(r6, r3)
            jp.reifrontier.gym.RFGDef$ActivityChartType r7 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.BICYCLE
            java.util.List r18 = r0.createYTitles(r7, r4)
            int r7 = p043jp.reifrontier.gym.C2092R.C2094id.profilePointChart
            android.view.View r7 = r0._$_findCachedViewById(r7)
            jp.reifrontier.gym.ui.widget.RFGChartView r7 = (p043jp.reifrontier.gym.p044ui.widget.RFGChartView) r7
            jp.reifrontier.gym.RFGDef$ActivityChartType r8 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.POINT
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 240(0xf0, float:3.36E-43)
            r17 = 0
            r9 = r1
            p043jp.reifrontier.gym.p044ui.widget.RFGChartView.setChartData$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            jp.reifrontier.gym.fragment.RFGProfileFragment$UserProfile r7 = r0.user
            r8 = 0
            if (r7 == 0) goto L_0x00dc
            java.lang.String r7 = r7.getWeight()
            if (r7 == 0) goto L_0x00dc
            float r7 = java.lang.Float.parseFloat(r7)
            r12 = r7
            goto L_0x00dd
        L_0x00dc:
            r12 = 0
        L_0x00dd:
            jp.reifrontier.gym.fragment.RFGProfileFragment$UserProfile r7 = r0.user
            if (r7 == 0) goto L_0x00eb
            java.lang.String r7 = r7.getHeight()
            if (r7 == 0) goto L_0x00eb
            float r8 = java.lang.Float.parseFloat(r7)
        L_0x00eb:
            r7 = 1120403456(0x42c80000, float:100.0)
            float r8 = r8 / r7
            float r8 = r8 * r8
            r7 = 1102053376(0x41b00000, float:22.0)
            float r13 = r8 * r7
            r7 = 1100218368(0x41940000, float:18.5)
            float r14 = r8 * r7
            r7 = 1103626240(0x41c80000, float:25.0)
            float r15 = r8 * r7
            int r7 = p043jp.reifrontier.gym.C2092R.C2094id.profilePointChart2
            android.view.View r7 = r0._$_findCachedViewById(r7)
            jp.reifrontier.gym.ui.widget.RFGChartView r7 = (p043jp.reifrontier.gym.p044ui.widget.RFGChartView) r7
            jp.reifrontier.gym.RFGDef$ActivityChartType r8 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.WEIGHT
            r9 = r1
            r10 = r2
            r11 = r5
            r7.setChartData(r8, r9, r10, r11, r12, r13, r14, r15)
            int r2 = p043jp.reifrontier.gym.C2092R.C2094id.profilePointChart3
            android.view.View r2 = r0._$_findCachedViewById(r2)
            r7 = r2
            jp.reifrontier.gym.ui.widget.RFGChartView r7 = (p043jp.reifrontier.gym.p044ui.widget.RFGChartView) r7
            jp.reifrontier.gym.RFGDef$ActivityChartType r8 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.STEP
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 240(0xf0, float:3.36E-43)
            r17 = 0
            r10 = r3
            r11 = r6
            p043jp.reifrontier.gym.p044ui.widget.RFGChartView.setChartData$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            int r2 = p043jp.reifrontier.gym.C2092R.C2094id.profilePointChart4
            android.view.View r2 = r0._$_findCachedViewById(r2)
            r7 = r2
            jp.reifrontier.gym.ui.widget.RFGChartView r7 = (p043jp.reifrontier.gym.p044ui.widget.RFGChartView) r7
            jp.reifrontier.gym.RFGDef$ActivityChartType r8 = p043jp.reifrontier.gym.RFGDef.ActivityChartType.BICYCLE
            r10 = r4
            r11 = r18
            p043jp.reifrontier.gym.p044ui.widget.RFGChartView.setChartData$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.fragment.RFGProfileFragment.bindChart(java.util.List):void");
    }

    private final void bindChartFromCache() {
        bindChart(getCache());
    }

    private final void bindProfile() {
        String str;
        if (this.cacheDataCount == -1) {
            UserProfile userProfile = this.user;
            if (userProfile == null || (str = userProfile.getFirstDate()) == null) {
                str = RFLDailyUtilsKt.format$default(RFLDailyUtilsKt.start(new Date()), "yyyyMMdd'T'HHmmss'Z'", (String) null, 2, (Object) null);
            }
            Date parse = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.JAPANESE).parse(str);
            if (parse != null) {
                int time = (int) (((new Date().getTime() - parse.getTime()) / ((long) 1000)) / ((long) 86400));
                Date start = RFLDailyUtilsKt.start(new Date());
                Realm defaultInstance = Realm.getDefaultInstance();
                int i = 0;
                if (time >= 0) {
                    int i2 = 0;
                    while (true) {
                        try {
                            if (((RFGDay) defaultInstance.where(RFGDay.class).equalTo("date", RFLDailyUtilsKt.format$default(RFGUtilsKt.ago(start, i), "yyyyMMdd'T'HHmmssZ", (String) null, 2, (Object) null)).findFirst()) == null) {
                                break;
                            }
                            i2++;
                            if (i == time) {
                                break;
                            }
                            i++;
                        } catch (Throwable th) {
                            CloseableKt.closeFinally(defaultInstance, th);
                            throw th;
                        }
                    }
                    i = i2;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(defaultInstance, (Throwable) null);
                this.cacheDataCount = i;
            } else {
                return;
            }
        }
        setProfile();
    }

    private final List<String> createYTitles(RFGDef.ActivityChartType activityChartType, List<RFGUserChartData> list) {
        float f;
        String height;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "activity!!.applicationContext");
        String unit = activityChartType.getUnit(applicationContext);
        int ordinal = activityChartType.ordinal();
        float f2 = 4.0f;
        float f3 = 0.0f;
        if (ordinal != 1) {
            if (ordinal == 2) {
                RFGUserChartData rFGUserChartData = (RFGUserChartData) CollectionsKt___CollectionsKt.maxWith(list, RFGProfileFragment$createYTitles$max$2.INSTANCE);
                if (rFGUserChartData == null) {
                    Intrinsics.throwNpe();
                }
                f2 = rFGUserChartData.weightF() * 1.5f;
                UserProfile userProfile = this.user;
                if (!(userProfile == null || (height = userProfile.getHeight()) == null)) {
                    f3 = Float.parseFloat(height);
                }
                float f4 = f3 / 100.0f;
                float f5 = f4 * f4 * 25.0f;
                if (f2 < f5) {
                    f2 = f5;
                }
            } else if (ordinal == 3) {
                RFGUserChartData rFGUserChartData2 = (RFGUserChartData) CollectionsKt___CollectionsKt.maxWith(list, RFGProfileFragment$createYTitles$max$3.INSTANCE);
                if (rFGUserChartData2 == null) {
                    Intrinsics.throwNpe();
                }
                float stepF = (rFGUserChartData2.stepF() * 1.5f) / 10000.0f;
                if (stepF >= 4.0f) {
                    f2 = stepF;
                }
            } else if (ordinal != 4) {
                f2 = 0.0f;
            } else {
                RFGUserChartData rFGUserChartData3 = (RFGUserChartData) CollectionsKt___CollectionsKt.maxWith(list, RFGProfileFragment$createYTitles$max$4.INSTANCE);
                if (rFGUserChartData3 == null) {
                    Intrinsics.throwNpe();
                }
                f = rFGUserChartData3.distanceF();
            }
            float rint = (float) Math.rint((double) f2);
            float f6 = rint / ((float) 4);
            return CollectionsKt__CollectionsKt.listOf(C0681a.m328a(new Object[]{Float.valueOf(rint)}, 1, "%.0f", "java.lang.String.format(this, *args)"), C0681a.m328a(new Object[]{Float.valueOf(rint - f6)}, 1, "%.0f", "java.lang.String.format(this, *args)"), C0681a.m328a(new Object[]{Float.valueOf(rint - (((float) 2) * f6))}, 1, "%.0f", "java.lang.String.format(this, *args)"), C0681a.m328a(new Object[]{Float.valueOf(rint - (f6 * ((float) 3)))}, 1, "%.0f", "java.lang.String.format(this, *args)"), unit);
        }
        RFGUserChartData rFGUserChartData4 = (RFGUserChartData) CollectionsKt___CollectionsKt.maxWith(list, RFGProfileFragment$createYTitles$max$1.INSTANCE);
        if (rFGUserChartData4 == null) {
            Intrinsics.throwNpe();
        }
        f = rFGUserChartData4.point();
        f2 = f * 1.5f;
        float rint2 = (float) Math.rint((double) f2);
        float f62 = rint2 / ((float) 4);
        return CollectionsKt__CollectionsKt.listOf(C0681a.m328a(new Object[]{Float.valueOf(rint2)}, 1, "%.0f", "java.lang.String.format(this, *args)"), C0681a.m328a(new Object[]{Float.valueOf(rint2 - f62)}, 1, "%.0f", "java.lang.String.format(this, *args)"), C0681a.m328a(new Object[]{Float.valueOf(rint2 - (((float) 2) * f62))}, 1, "%.0f", "java.lang.String.format(this, *args)"), C0681a.m328a(new Object[]{Float.valueOf(rint2 - (f62 * ((float) 3)))}, 1, "%.0f", "java.lang.String.format(this, *args)"), unit);
    }

    private final void delightButton(Button button) {
        button.setTextColor(Color.parseColor("#afafaf"));
        button.setBackgroundResource(R.drawable.button_delight);
    }

    private final List<RFGUserChart> getCache() {
        int ordinal = this.currentChartType.ordinal();
        if (ordinal == 0) {
            return this.cacheChartW6;
        }
        if (ordinal == 1) {
            return this.cacheChartW12;
        }
        if (ordinal == 2) {
            return this.cacheChartM6;
        }
        if (ordinal == 3) {
            return this.cacheChartM12;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean getHasCache() {
        if (!RFGShared.INSTANCE.shouldRequestPoint()) {
            return !getCache().isEmpty();
        }
        this.cacheChartW6 = CollectionsKt__CollectionsKt.emptyList();
        this.cacheChartW12 = CollectionsKt__CollectionsKt.emptyList();
        this.cacheChartM6 = CollectionsKt__CollectionsKt.emptyList();
        this.cacheChartM12 = CollectionsKt__CollectionsKt.emptyList();
        return false;
    }

    private final void hideBmi() {
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.profileChallengeUnit);
        Intrinsics.checkExpressionValueIsNotNull(textView, "profileChallengeUnit");
        textView.setVisibility(0);
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileChallenges);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "profileChallenges");
        textView2.setVisibility(0);
        TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileDays);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "profileDays");
        textView3.setVisibility(0);
        TextView textView4 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileDaysUnit);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "profileDaysUnit");
        textView4.setVisibility(0);
        TextView textView5 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileBmi);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "profileBmi");
        textView5.setVisibility(8);
        TextView textView6 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileBmiUnit);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "profileBmiUnit");
        textView6.setVisibility(8);
    }

    private final void highlightButton(Button button) {
        button.setTextColor(Color.parseColor("#FFFFFF"));
        button.setBackgroundResource(R.drawable.button_highlight);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void loadUserInfo() {
        /*
            r12 = this;
            io.realm.Realm r0 = p041io.realm.Realm.getDefaultInstance()
            java.lang.Class<jp.reifrontier.gym.domain.api.RFGUser> r1 = p043jp.reifrontier.gym.domain.api.RFGUser.class
            io.realm.RealmQuery r1 = r0.where(r1)     // Catch:{ all -> 0x0050 }
            java.lang.Object r1 = r1.findFirst()     // Catch:{ all -> 0x0050 }
            jp.reifrontier.gym.domain.api.RFGUser r1 = (p043jp.reifrontier.gym.domain.api.RFGUser) r1     // Catch:{ all -> 0x0050 }
            r2 = 0
            if (r1 == 0) goto L_0x0041
            jp.reifrontier.gym.fragment.RFGProfileFragment$UserProfile r11 = new jp.reifrontier.gym.fragment.RFGProfileFragment$UserProfile     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = r1.getHandleName()     // Catch:{ all -> 0x0050 }
            java.lang.String r5 = r1.getFirstDate()     // Catch:{ all -> 0x0050 }
            java.lang.String r6 = r1.getIcon()     // Catch:{ all -> 0x0050 }
            java.lang.String r7 = r1.height()     // Catch:{ all -> 0x0050 }
            java.lang.String r8 = r1.weight()     // Catch:{ all -> 0x0050 }
            jp.reifrontier.gym.util.GymUtils r3 = p043jp.reifrontier.gym.util.GymUtils.INSTANCE     // Catch:{ all -> 0x0050 }
            java.lang.String r9 = r1.getGender()     // Catch:{ all -> 0x0050 }
            java.lang.String r9 = r3.genderFrom(r9)     // Catch:{ all -> 0x0050 }
            java.lang.String r10 = r1.getArchiveCount()     // Catch:{ all -> 0x0050 }
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0050 }
            r12.user = r11     // Catch:{ all -> 0x0050 }
            kotlin.p045io.CloseableKt.closeFinally(r0, r2)
            return
        L_0x0041:
            kotlin.p045io.CloseableKt.closeFinally(r0, r2)
            r0 = 2131624103(0x7f0e00a7, float:1.8875376E38)
            jp.reifrontier.gym.fragment.RFGProfileFragment$loadUserInfo$2 r1 = new jp.reifrontier.gym.fragment.RFGProfileFragment$loadUserInfo$2
            r1.<init>(r12)
            r12.showErrorDialog(r0, r1)
            return
        L_0x0050:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r2 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.fragment.RFGProfileFragment.loadUserInfo():void");
    }

    /* access modifiers changed from: private */
    public final void onClickChartButton(RFGDef.ChartType chartType, String str) {
        if (this.currentChartType != chartType) {
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "200", str, (String) null, 4, (Object) null);
            this.currentChartType = chartType;
            setupButtons();
            requestChartIfNeed();
        }
    }

    private final void requestChartIfNeed() {
        if (getHasCache()) {
            bindChartFromCache();
        } else {
            requestGraph();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r0 != 3) goto L_0x0029;
     */
    @android.annotation.SuppressLint({"CheckResult"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void requestGraph() {
        /*
            r6 = this;
            jp.reifrontier.gym.fragment.RFGProfileFragment$OnProfileListener r0 = r6.mListener
            if (r0 == 0) goto L_0x0007
            r0.onStartLoading()
        L_0x0007:
            jp.reifrontier.gym.data.shared.RFGShared r0 = p043jp.reifrontier.gym.data.shared.RFGShared.INSTANCE
            long r1 = java.lang.System.currentTimeMillis()
            r0.setRequestPoint(r1)
            jp.reifrontier.gym.RFGDef$ChartType r0 = r6.currentChartType
            int r0 = r0.ordinal()
            java.lang.String r1 = "m"
            java.lang.String r2 = "12"
            java.lang.String r3 = "6"
            java.lang.String r4 = "w"
            if (r0 == 0) goto L_0x0029
            r5 = 1
            if (r0 == r5) goto L_0x002a
            r5 = 2
            if (r0 == r5) goto L_0x002c
            r5 = 3
            if (r0 == r5) goto L_0x002d
        L_0x0029:
            r2 = r3
        L_0x002a:
            r1 = r4
            goto L_0x002d
        L_0x002c:
            r2 = r3
        L_0x002d:
            jp.reifrontier.gym.data.api.RFGH2Client$Companion r0 = p043jp.reifrontier.gym.data.api.RFGH2Client.Companion
            jp.reifrontier.gym.data.api.RFGH2Client r0 = r0.getINSTANCE()
            g.a.r r0 = r0.chart(r1, r2)
            g.a.q r1 = p078g.p079a.p094C.C1683a.m2378b()
            g.a.r r0 = r0.mo27434b((p078g.p079a.C1711q) r1)
            g.a.q r1 = p078g.p079a.p096w.p097b.C1721a.m2428a()
            g.a.r r0 = r0.mo27429a((p078g.p079a.C1711q) r1)
            jp.reifrontier.gym.fragment.RFGProfileFragment$requestGraph$1 r1 = new jp.reifrontier.gym.fragment.RFGProfileFragment$requestGraph$1
            r1.<init>(r6)
            jp.reifrontier.gym.fragment.RFGProfileFragment$requestGraph$2 r2 = p043jp.reifrontier.gym.fragment.RFGProfileFragment$requestGraph$2.INSTANCE
            r0.mo27432a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.fragment.RFGProfileFragment.requestGraph():void");
    }

    private final void setCache(List<RFGUserChart> list) {
        int ordinal = this.currentChartType.ordinal();
        if (ordinal == 0) {
            this.cacheChartW6 = list;
        } else if (ordinal == 1) {
            this.cacheChartW12 = list;
        } else if (ordinal == 2) {
            this.cacheChartM6 = list;
        } else if (ordinal == 3) {
            this.cacheChartM12 = list;
        }
    }

    /* access modifiers changed from: private */
    public final void setChart(List<RFGUserChart> list) {
        setCache(list);
        bindChart(list);
    }

    private final void setProfile() {
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.profileDays);
        Intrinsics.checkExpressionValueIsNotNull(textView, "profileDays");
        String format = String.format("%s", Arrays.copyOf(new Object[]{Integer.valueOf(this.cacheDataCount)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
        textView.setText(format);
    }

    private final void setupButtons() {
        Button button;
        Button button2;
        Button button3;
        int ordinal = this.currentChartType.ordinal();
        if (ordinal == 0) {
            Button button4 = (Button) _$_findCachedViewById(C2092R.C2094id.week6);
            Intrinsics.checkExpressionValueIsNotNull(button4, "week6");
            highlightButton(button4);
            button3 = (Button) _$_findCachedViewById(C2092R.C2094id.week12);
            Intrinsics.checkExpressionValueIsNotNull(button3, "week12");
        } else if (ordinal == 1) {
            Button button5 = (Button) _$_findCachedViewById(C2092R.C2094id.week12);
            Intrinsics.checkExpressionValueIsNotNull(button5, "week12");
            highlightButton(button5);
            button3 = (Button) _$_findCachedViewById(C2092R.C2094id.week6);
            Intrinsics.checkExpressionValueIsNotNull(button3, "week6");
        } else if (ordinal == 2) {
            Button button6 = (Button) _$_findCachedViewById(C2092R.C2094id.month6);
            Intrinsics.checkExpressionValueIsNotNull(button6, "month6");
            highlightButton(button6);
            Button button7 = (Button) _$_findCachedViewById(C2092R.C2094id.week12);
            Intrinsics.checkExpressionValueIsNotNull(button7, "week12");
            delightButton(button7);
            button2 = (Button) _$_findCachedViewById(C2092R.C2094id.week6);
            Intrinsics.checkExpressionValueIsNotNull(button2, "week6");
            delightButton(button2);
            button = (Button) _$_findCachedViewById(C2092R.C2094id.month12);
            Intrinsics.checkExpressionValueIsNotNull(button, "month12");
            delightButton(button);
        } else if (ordinal == 3) {
            Button button8 = (Button) _$_findCachedViewById(C2092R.C2094id.month12);
            Intrinsics.checkExpressionValueIsNotNull(button8, "month12");
            highlightButton(button8);
            Button button9 = (Button) _$_findCachedViewById(C2092R.C2094id.week12);
            Intrinsics.checkExpressionValueIsNotNull(button9, "week12");
            delightButton(button9);
            Button button10 = (Button) _$_findCachedViewById(C2092R.C2094id.month6);
            Intrinsics.checkExpressionValueIsNotNull(button10, "month6");
            delightButton(button10);
            button = (Button) _$_findCachedViewById(C2092R.C2094id.week6);
            Intrinsics.checkExpressionValueIsNotNull(button, "week6");
            delightButton(button);
        } else {
            return;
        }
        delightButton(button3);
        button2 = (Button) _$_findCachedViewById(C2092R.C2094id.month6);
        Intrinsics.checkExpressionValueIsNotNull(button2, "month6");
        delightButton(button2);
        button = (Button) _$_findCachedViewById(C2092R.C2094id.month12);
        Intrinsics.checkExpressionValueIsNotNull(button, "month12");
        delightButton(button);
    }

    private final void showErrorDialog(@StringRes int i, RFGErrorDialog.ErrorDialogListener errorDialogListener) {
        RFGErrorDialog.Companion companion = RFGErrorDialog.Companion;
        String string = getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(resourceId)");
        RFGErrorDialog newInstance$default = RFGErrorDialog.Companion.newInstance$default(companion, (String) null, string, 1, (Object) null);
        if (errorDialogListener != null) {
            newInstance$default.setListener(errorDialogListener);
        }
        newInstance$default.show(getChildFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    static /* synthetic */ void showErrorDialog$default(RFGProfileFragment rFGProfileFragment, int i, RFGErrorDialog.ErrorDialogListener errorDialogListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            errorDialogListener = null;
        }
        rFGProfileFragment.showErrorDialog(i, errorDialogListener);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnProfileListener) {
            this.mListener = (OnProfileListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    @SuppressLint({"SetTextI18n"})
    public void onResume() {
        super.onResume();
        loadUserInfo();
        UserProfile userProfile = this.user;
        if (userProfile != null) {
            OnProfileListener onProfileListener = this.mListener;
            if (onProfileListener != null) {
                onProfileListener.showHandleName(userProfile.getHandleName());
            }
            bindProfile();
            requestChartIfNeed();
            String accessToken = RFLSharedHolder.INSTANCE.accessToken();
            C1529y b = C1513u.m2068b().mo27251b(userProfile.getIcon() + RFGDef.IMAGE_URL_SUFFIX + accessToken);
            b.mo27279a((C1473F) new RFGRadiusTransform(-1.0f));
            b.mo27281a((ImageView) _$_findCachedViewById(C2092R.C2094id.profileImageIcon), (C1489e) null);
            TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.profileHeight);
            Intrinsics.checkExpressionValueIsNotNull(textView, "profileHeight");
            textView.setText(userProfile.getHeight());
            TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileWeight);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "profileWeight");
            textView2.setText(userProfile.getWeight());
            TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileGender);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "profileGender");
            textView3.setText(userProfile.getGender());
            TextView textView4 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileChallenges);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "profileChallenges");
            textView4.setText(userProfile.getArchiveCount());
            float parseFloat = Float.parseFloat(userProfile.getHeight()) / 100.0f;
            float parseFloat2 = Float.parseFloat(userProfile.getWeight()) / (parseFloat * parseFloat);
            TextView textView5 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileBmi);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "profileBmi");
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(parseFloat2)}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
            textView5.setText(format);
            RFGAnalyticsManager.INSTANCE.sendScreen("200");
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.profileDays);
        Intrinsics.checkExpressionValueIsNotNull(textView, "profileDays");
        textView.setText("-");
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileChallenges);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "profileChallenges");
        textView2.setText(RFGDef.DEFAULT_GYM_ID);
        hideBmi();
        setupButtons();
        ((Button) _$_findCachedViewById(C2092R.C2094id.week6)).setOnClickListener(new RFGProfileFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.week12)).setOnClickListener(new RFGProfileFragment$onViewCreated$2(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.month6)).setOnClickListener(new RFGProfileFragment$onViewCreated$3(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.month12)).setOnClickListener(new RFGProfileFragment$onViewCreated$4(this));
    }
}
