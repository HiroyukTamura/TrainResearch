package p043jp.reifrontier.gym.fragment.train;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.C1471D;
import com.squareup.picasso.C1513u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p061c.p062a.C1562e;
import p009e.p028d.p061c.p062a.p063g.C1566a;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.bus.RFGSelectedStation;
import p043jp.reifrontier.gym.data.train.RFGSpotData;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.data.train.spot.RFGButtonType;
import p043jp.reifrontier.gym.data.train.spot.RFGColorType;
import p043jp.reifrontier.gym.data.train.spot.RFGContent;
import p043jp.reifrontier.gym.data.train.spot.RFGContentAccess;
import p043jp.reifrontier.gym.data.train.spot.RFGContentButton;
import p043jp.reifrontier.gym.data.train.spot.RFGContentImage;
import p043jp.reifrontier.gym.data.train.spot.RFGContentInfo;
import p043jp.reifrontier.gym.data.train.spot.RFGContentItem;
import p043jp.reifrontier.gym.data.train.spot.RFGContentNote;
import p043jp.reifrontier.gym.data.train.spot.RFGContentTitle;
import p043jp.reifrontier.gym.data.train.spot.RFGNoteTextSizeType;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.gym.data.train.spot.RFGSpotType;
import p043jp.reifrontier.gym.fragment.RFGFragmentBase;
import p043jp.reifrontier.gym.p044ui.widget.train.RFGAccessView;
import p043jp.reifrontier.gym.p044ui.widget.train.RFGInfoListView;
import p043jp.reifrontier.sanriku.R;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\f\u0018\u0000 Q2\u00020\u0001:\u0003QRSB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\fH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u0004\u0018\u00010\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00162\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0002J\u0019\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u00103J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u000eH\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020=H\u0007J\u0012\u0010>\u001a\u0002082\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u000208H\u0016J\u001a\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010D\u001a\u0002082\u0006\u0010E\u001a\u00020\fH\u0002J\u0018\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002J\b\u0010J\u001a\u000208H\u0002J\b\u0010K\u001a\u000208H\u0002J\u0010\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020\fH\u0002J\b\u0010N\u001a\u000208H\u0003J\b\u0010O\u001a\u00020\fH\u0016J\u0010\u0010P\u001a\u0002082\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotDetailFragment;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase;", "()V", "fragmentListener", "Ljp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$OnSpotDetailFragmentListener;", "hideTitleAnimation", "Landroid/view/animation/AlphaAnimation;", "isPrevNoMargin", "", "nearestStation", "Ljp/reifrontier/gym/data/train/RFGStation;", "param1", "", "param2", "", "showTitleAnimation", "spotDetail", "Ljp/reifrontier/gym/data/train/spot/RFGContent;", "twaLauncher", "Lcom/google/androidbrowserhelper/trusted/TwaLauncher;", "actionBarTitle", "addAccessView", "Landroid/view/View;", "access", "Ljp/reifrontier/gym/data/train/spot/RFGContentAccess;", "spotType", "Ljp/reifrontier/gym/data/train/spot/RFGSpotType;", "addButtonView", "spotId", "button", "Ljp/reifrontier/gym/data/train/spot/RFGContentButton;", "addImageView", "image", "Ljp/reifrontier/gym/data/train/spot/RFGContentImage;", "addInfoView", "infoList", "", "Ljp/reifrontier/gym/data/train/spot/RFGContentInfo;", "addNormalButton", "addNoteView", "note", "Ljp/reifrontier/gym/data/train/spot/RFGContentNote;", "addShareButton", "addTextButtonView", "addTitleView", "Landroid/widget/TextView;", "title", "Ljp/reifrontier/gym/data/train/spot/RFGContentTitle;", "createLayoutParams", "Landroid/view/ViewGroup$MarginLayoutParams;", "margin", "(Ljava/lang/Integer;)Landroid/view/ViewGroup$MarginLayoutParams;", "fragmentType", "Ljp/reifrontier/gym/RFGDef$FragType;", "layoutId", "onAttach", "", "context", "Landroid/content/Context;", "onCompletedSpotDetailRequest", "event", "Ljp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$OnCompletedSpotDetailRequest;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", "view", "openLink", "linkUrl", "openMapApp", "lat", "", "lon", "openShare", "openStationSchedule", "openTel", "tel", "requestSpotDetail", "screenId", "setUpDetail", "Companion", "OnCompletedSpotDetailRequest", "OnSpotDetailFragmentListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment */
public final class RFGSpotDetailFragment extends RFGFragmentBase {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    private OnSpotDetailFragmentListener fragmentListener;
    /* access modifiers changed from: private */
    public final AlphaAnimation hideTitleAnimation;
    private boolean isPrevNoMargin;
    private RFGStation nearestStation;
    private String param1;
    private int param2;
    /* access modifiers changed from: private */
    public final AlphaAnimation showTitleAnimation;
    private RFGContent spotDetail;
    private C1562e twaLauncher;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$OnSpotDetailFragmentListener;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$OnSpotDetailFragmentListener */
    public interface OnSpotDetailFragmentListener extends RFGFragmentBase.OnFragmentBaseListener {
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$Companion;", "", "()V", "ARG_PARAM1", "", "ARG_PARAM2", "newInstance", "Ljp/reifrontier/gym/fragment/train/RFGSpotDetailFragment;", "param1", "param2", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGSpotDetailFragment newInstance(String str, RFGSpot rFGSpot) {
            Intrinsics.checkParameterIsNotNull(str, RFGSpotDetailFragment.ARG_PARAM1);
            Intrinsics.checkParameterIsNotNull(rFGSpot, RFGSpotDetailFragment.ARG_PARAM2);
            RFGSpotDetailFragment rFGSpotDetailFragment = new RFGSpotDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(RFGSpotDetailFragment.ARG_PARAM1, str);
            bundle.putInt(RFGSpotDetailFragment.ARG_PARAM2, rFGSpot.getId());
            rFGSpotDetailFragment.setArguments(bundle);
            return rFGSpotDetailFragment;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$OnCompletedSpotDetailRequest;", "", "result", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "spotDetail", "Ljp/reifrontier/gym/data/train/spot/RFGContent;", "(Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;Ljp/reifrontier/gym/data/train/spot/RFGContent;)V", "getResult", "()Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "getSpotDetail", "()Ljp/reifrontier/gym/data/train/spot/RFGContent;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$OnCompletedSpotDetailRequest */
    public static final class OnCompletedSpotDetailRequest {
        private final RFGRailroadClient.RailroadApiResult result;
        private final RFGContent spotDetail;

        public OnCompletedSpotDetailRequest(RFGRailroadClient.RailroadApiResult railroadApiResult, RFGContent rFGContent) {
            Intrinsics.checkParameterIsNotNull(railroadApiResult, "result");
            this.result = railroadApiResult;
            this.spotDetail = rFGContent;
        }

        public static /* synthetic */ OnCompletedSpotDetailRequest copy$default(OnCompletedSpotDetailRequest onCompletedSpotDetailRequest, RFGRailroadClient.RailroadApiResult railroadApiResult, RFGContent rFGContent, int i, Object obj) {
            if ((i & 1) != 0) {
                railroadApiResult = onCompletedSpotDetailRequest.result;
            }
            if ((i & 2) != 0) {
                rFGContent = onCompletedSpotDetailRequest.spotDetail;
            }
            return onCompletedSpotDetailRequest.copy(railroadApiResult, rFGContent);
        }

        public final RFGRailroadClient.RailroadApiResult component1() {
            return this.result;
        }

        public final RFGContent component2() {
            return this.spotDetail;
        }

        public final OnCompletedSpotDetailRequest copy(RFGRailroadClient.RailroadApiResult railroadApiResult, RFGContent rFGContent) {
            Intrinsics.checkParameterIsNotNull(railroadApiResult, "result");
            return new OnCompletedSpotDetailRequest(railroadApiResult, rFGContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnCompletedSpotDetailRequest)) {
                return false;
            }
            OnCompletedSpotDetailRequest onCompletedSpotDetailRequest = (OnCompletedSpotDetailRequest) obj;
            return Intrinsics.areEqual((Object) this.result, (Object) onCompletedSpotDetailRequest.result) && Intrinsics.areEqual((Object) this.spotDetail, (Object) onCompletedSpotDetailRequest.spotDetail);
        }

        public final RFGRailroadClient.RailroadApiResult getResult() {
            return this.result;
        }

        public final RFGContent getSpotDetail() {
            return this.spotDetail;
        }

        public int hashCode() {
            RFGRailroadClient.RailroadApiResult railroadApiResult = this.result;
            int i = 0;
            int hashCode = (railroadApiResult != null ? railroadApiResult.hashCode() : 0) * 31;
            RFGContent rFGContent = this.spotDetail;
            if (rFGContent != null) {
                i = rFGContent.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("OnCompletedSpotDetailRequest(result=");
            a.append(this.result);
            a.append(", spotDetail=");
            a.append(this.spotDetail);
            a.append(")");
            return a.toString();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RFGButtonType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGButtonType rFGButtonType = RFGButtonType.BUTTON_LINK;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGButtonType rFGButtonType2 = RFGButtonType.TEXT_LINK;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGButtonType rFGButtonType3 = RFGButtonType.SHARE;
            iArr3[2] = 3;
            int[] iArr4 = new int[RFGColorType.values().length];
            $EnumSwitchMapping$1 = iArr4;
            RFGColorType rFGColorType = RFGColorType.Black;
            iArr4[0] = 1;
            int[] iArr5 = $EnumSwitchMapping$1;
            RFGColorType rFGColorType2 = RFGColorType.Gray;
            iArr5[1] = 2;
            int[] iArr6 = $EnumSwitchMapping$1;
            RFGColorType rFGColorType3 = RFGColorType.Red;
            iArr6[2] = 3;
            int[] iArr7 = $EnumSwitchMapping$1;
            RFGColorType rFGColorType4 = RFGColorType.Blue;
            iArr7[3] = 4;
            int[] iArr8 = $EnumSwitchMapping$1;
            RFGColorType rFGColorType5 = RFGColorType.Green;
            iArr8[4] = 5;
        }
    }

    public RFGSpotDetailFragment() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        this.showTitleAnimation = alphaAnimation;
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(100.0f, 0.0f);
        alphaAnimation2.setDuration(300);
        alphaAnimation2.setFillAfter(true);
        this.hideTitleAnimation = alphaAnimation2;
    }

    private final View addAccessView(RFGContentAccess rFGContentAccess, RFGSpotType rFGSpotType) {
        String str;
        Context context = getContext();
        if (context == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return null");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(parentFragmentManager, "parentFragmentManager");
        RFGStation rFGStation = this.nearestStation;
        if (rFGStation == null || (str = rFGStation.getName()) == null) {
            str = "";
        }
        RFGAccessView rFGAccessView = new RFGAccessView(context, parentFragmentManager, rFGContentAccess, rFGSpotType, str);
        rFGAccessView.setLayoutParams(createLayoutParams$default(this, (Integer) null, 1, (Object) null));
        rFGAccessView.setOnClickShowMap(new RFGSpotDetailFragment$addAccessView$1(this));
        rFGAccessView.setOnClickStation(new RFGSpotDetailFragment$addAccessView$2(this));
        ((LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView)).addView(rFGAccessView, rFGAccessView.getLayoutParams());
        return rFGAccessView;
    }

    private final View addButtonView(int i, RFGContentButton rFGContentButton) {
        int ordinal = rFGContentButton.getType().ordinal();
        if (ordinal == 0) {
            return addNormalButton(i, rFGContentButton);
        }
        if (ordinal == 1) {
            return addTextButtonView(i, rFGContentButton);
        }
        if (ordinal == 2) {
            return addShareButton(i, rFGContentButton);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final View addImageView(int i, RFGContentImage rFGContentImage) {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(createLayoutParams(rFGContentImage.getFull() ? 0 : null));
        ((LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView)).addView(imageView, imageView.getLayoutParams());
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new RFGSpotDetailFragment$addImageView$1(imageView, rFGContentImage, i));
        return imageView;
    }

    private final View addInfoView(List<RFGContentInfo> list) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return null");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (RFGContentInfo add : list) {
            arrayList.add(add);
        }
        RFGInfoListView rFGInfoListView = new RFGInfoListView(context, arrayList);
        rFGInfoListView.setLayoutParams(createLayoutParams$default(this, (Integer) null, 1, (Object) null));
        rFGInfoListView.setOnClickTel(new RFGSpotDetailFragment$addInfoView$1(this));
        ((LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView)).addView(rFGInfoListView, rFGInfoListView.getLayoutParams());
        return rFGInfoListView;
    }

    private final View addNormalButton(int i, RFGContentButton rFGContentButton) {
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return null");
            View inflate = LayoutInflater.from(context).inflate(R.layout.view_button_rounded, (LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView), false);
            if (!(inflate instanceof MaterialButton)) {
                inflate = null;
            }
            MaterialButton materialButton = (MaterialButton) inflate;
            if (materialButton != null) {
                materialButton.setLayoutParams(createLayoutParams$default(this, (Integer) null, 1, (Object) null));
                materialButton.setText(rFGContentButton.getLabel());
                int color = rFGContentButton.getColor().getColor(context);
                int ordinal = rFGContentButton.getColor().ordinal();
                if (ordinal == 0 || ordinal == 1 || ordinal == 2 || ordinal == 3 || ordinal == 4) {
                    int color2 = ContextCompat.getColor(context, R.color.white);
                    materialButton.setSupportBackgroundTintList(new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{color, color}));
                    materialButton.setTextColor(color2);
                    materialButton.setOnClickListener(new RFGSpotDetailFragment$addNormalButton$1(this, rFGContentButton, i));
                    ((LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView)).addView(materialButton, materialButton.getLayoutParams());
                    return materialButton;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return null;
    }

    private final View addNoteView(RFGContentNote rFGContentNote) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return null");
        TextView textView = new TextView(context);
        textView.setText(rFGContentNote.getValue());
        textView.setLayoutParams(createLayoutParams$default(this, (Integer) null, 1, (Object) null));
        textView.setTextSize(0, rFGContentNote.getSize().getPixelSize(context));
        if (rFGContentNote.getBold()) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        textView.setTextColor(rFGContentNote.getColor().getColor(context));
        ((LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView)).addView(textView, textView.getLayoutParams());
        return textView;
    }

    private final View addShareButton(int i, RFGContentButton rFGContentButton) {
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return null");
            View inflate = LayoutInflater.from(context).inflate(R.layout.view_button_share, (LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView), false);
            if (!(inflate instanceof MaterialButton)) {
                inflate = null;
            }
            MaterialButton materialButton = (MaterialButton) inflate;
            if (materialButton != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.margin_medium);
                marginLayoutParams.leftMargin = dimensionPixelSize;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.rightMargin = dimensionPixelSize;
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                materialButton.setLayoutParams(marginLayoutParams);
                materialButton.setOnClickListener(new RFGSpotDetailFragment$addShareButton$2(this, i, rFGContentButton));
                ((LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView)).addView(materialButton, materialButton.getLayoutParams());
                return materialButton;
            }
        }
        return null;
    }

    private final View addTextButtonView(int i, RFGContentButton rFGContentButton) {
        String label = rFGContentButton.getLabel();
        if (label != null) {
            View addNoteView = addNoteView(new RFGContentNote(label, RFGNoteTextSizeType.MEDIUM, false, rFGContentButton.getColor()));
            if (!(addNoteView instanceof TextView)) {
                addNoteView = null;
            }
            TextView textView = (TextView) addNoteView;
            if (textView != null) {
                SpannableString spannableString = new SpannableString(label);
                spannableString.setSpan(new UnderlineSpan(), 0, label.length(), 0);
                textView.setText(spannableString);
                textView.setClickable(true);
                textView.setOnClickListener(new RFGSpotDetailFragment$addTextButtonView$1(this, rFGContentButton, i));
                return textView;
            }
        }
        return null;
    }

    private final TextView addTitleView(RFGContentTitle rFGContentTitle) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return null");
        TextView textView = new TextView(context);
        textView.setText(rFGContentTitle.getValue());
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(ContextCompat.getColor(context, R.color.sanriku_black));
        textView.setLayoutParams(createLayoutParams$default(this, (Integer) null, 1, (Object) null));
        textView.setTextSize(0, rFGContentTitle.getSize().getPixelSize(context));
        ((LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView)).addView(textView, textView.getLayoutParams());
        return textView;
    }

    private final ViewGroup.MarginLayoutParams createLayoutParams(Integer num) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        int intValue = num != null ? num.intValue() : getResources().getDimensionPixelSize(R.dimen.margin_medium);
        boolean z = false;
        int i = (!this.isPrevNoMargin || num != null) ? 0 : intValue;
        if (num != null) {
            z = true;
        }
        this.isPrevNoMargin = z;
        marginLayoutParams.leftMargin = intValue;
        marginLayoutParams.topMargin = i;
        marginLayoutParams.rightMargin = intValue;
        marginLayoutParams.bottomMargin = intValue;
        return marginLayoutParams;
    }

    static /* synthetic */ ViewGroup.MarginLayoutParams createLayoutParams$default(RFGSpotDetailFragment rFGSpotDetailFragment, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return rFGSpotDetailFragment.createLayoutParams(num);
    }

    /* access modifiers changed from: private */
    public final void openLink(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkExpressionValueIsNotNull(activity, "activity ?: return");
            TrustedWebActivityIntentBuilder toolbarColor = new TrustedWebActivityIntentBuilder(Uri.parse(str)).setToolbarColor(ContextCompat.getColor(activity, R.color.sanriku_blue));
            Intrinsics.checkExpressionValueIsNotNull(toolbarColor, "TrustedWebActivityIntent…t, R.color.sanriku_blue))");
            C1562e eVar = this.twaLauncher;
            if (eVar != null) {
                eVar.mo27327a();
            }
            C1562e eVar2 = new C1562e(getActivity());
            this.twaLauncher = eVar2;
            if (eVar2 != null) {
                eVar2.mo27330b(toolbarColor, (C1566a) null, (Runnable) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void openMapApp(double d, double d2) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + d + ',' + d2 + "?q=" + d + ',' + d2 + "&z=18")));
    }

    /* access modifiers changed from: private */
    public final void openShare() {
        String name;
        RFGContent rFGContent = this.spotDetail;
        if (rFGContent != null) {
            ShareCompat.IntentBuilder from = ShareCompat.IntentBuilder.from(requireActivity());
            Intrinsics.checkExpressionValueIsNotNull(from, "ShareCompat.IntentBuilder.from(requireActivity())");
            String title = rFGContent.getTitle();
            if (title != null) {
                from.setSubject(title);
            }
            StringBuffer stringBuffer = new StringBuffer();
            String title2 = rFGContent.getTitle();
            if (title2 != null) {
                stringBuffer.append(title2 + 10);
            }
            String imageUrl = RFGRailroadClient.Companion.getINSTANCE().getImageUrl(rFGContent.getId(), "top.jpg");
            stringBuffer.append(imageUrl + 10);
            RFGStation findStation = RFGTrainData.INSTANCE.findStation(rFGContent.getStationId());
            if (!(findStation == null || (name = findStation.getName()) == null)) {
                stringBuffer.append(getString(R.string.sanriku_nearest_station, name));
            }
            from.setText(stringBuffer.toString());
            from.setType("text/plain");
            from.startChooser();
        }
    }

    /* access modifiers changed from: private */
    public final void openStationSchedule() {
        RFGStation rFGStation = this.nearestStation;
        if (rFGStation != null) {
            C1126c.m1638c().mo21903a((Object) new RFGSelectedStation(rFGStation));
        }
    }

    /* access modifiers changed from: private */
    public final void openTel(String str) {
        startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    @SuppressLint({"CheckResult"})
    private final void requestSpotDetail() {
        startLoading();
        C1126c.m1638c().mo21908c(this);
        C1126c.m1638c().mo21907b(this);
        new RFGSpotData().getSpotDetail(this.param2).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(RFGSpotDetailFragment$requestSpotDetail$1.INSTANCE, RFGSpotDetailFragment$requestSpotDetail$2.INSTANCE);
    }

    private final void setUpDetail(RFGContent rFGContent) {
        RFGContentImage image;
        this.nearestStation = RFGTrainData.INSTANCE.findStation(rFGContent.getStationId());
        int i = 0;
        if (rFGContent.getContents().size() > 0 && (image = rFGContent.getContents().get(0).getImage()) != null) {
            Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2092R.C2094id.fragmentToolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, "fragmentToolbar");
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
            if (layoutParams != null) {
                Toolbar toolbar2 = (Toolbar) _$_findCachedViewById(C2092R.C2094id.fragmentToolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar2, "fragmentToolbar");
                layoutParams.height = MathKt__MathJVMKt.roundToInt((((float) toolbar2.getWidth()) / ((float) image.getWidth())) * ((float) image.getHeight()));
                toolbar.setLayoutParams(layoutParams);
                C1513u.m2068b().mo27251b(RFGRailroadClient.Companion.getINSTANCE().getImageUrl(rFGContent.getId(), image.getPath())).mo27282a((C1471D) new RFGSpotDetailFragment$setUpDetail$$inlined$let$lambda$1(this, rFGContent));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        ((LinearLayout) _$_findCachedViewById(C2092R.C2094id.contentBaseView)).removeAllViews();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        List<RFGContentItem> contents = rFGContent.getContents();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(contents, 10));
        for (RFGContentItem add : contents) {
            arrayList.add(add);
        }
        for (Object next : CollectionsKt___CollectionsKt.sortedWith(arrayList, new RFGSpotDetailFragment$setUpDetail$$inlined$sortedBy$1())) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RFGContentItem rFGContentItem = (RFGContentItem) next;
            if (i > 0) {
                RFGContentTitle title = rFGContentItem.getTitle();
                if (title != null) {
                    T addTitleView = addTitleView(title);
                    if (((TextView) objectRef.element) == null) {
                        objectRef.element = addTitleView;
                    }
                }
                RFGContentNote note = rFGContentItem.getNote();
                if (note != null) {
                    addNoteView(note);
                }
                RFGContentImage image2 = rFGContentItem.getImage();
                if (image2 != null) {
                    addImageView(rFGContent.getId(), image2);
                }
                RFGContentAccess access = rFGContentItem.getAccess();
                if (access != null) {
                    addAccessView(access, rFGContent.getSpotType());
                }
                if (!rFGContentItem.getInfoList().isEmpty()) {
                    addInfoView(rFGContentItem.getInfoList());
                }
                RFGContentButton button = rFGContentItem.getButton();
                if (button != null) {
                    addButtonView(rFGContent.getId(), button);
                }
            }
            i = i2;
        }
        TextView textView = (TextView) objectRef.element;
        if (textView != null) {
            textView.addOnLayoutChangeListener(new RFGSpotDetailFragment$setUpDetail$$inlined$doOnNextLayout$1(this, objectRef));
        }
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

    public String actionBarTitle() {
        return "";
    }

    public RFGDef.FragType fragmentType() {
        return RFGDef.FragType.SpotDetail;
    }

    public int layoutId() {
        return R.layout.fragment_sanriku_spot_detail;
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnSpotDetailFragmentListener) {
            this.fragmentListener = (OnSpotDetailFragmentListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnSpotDetailFragmentListener");
    }

    @C1129m
    public final void onCompletedSpotDetailRequest(OnCompletedSpotDetailRequest onCompletedSpotDetailRequest) {
        Intrinsics.checkParameterIsNotNull(onCompletedSpotDetailRequest, "event");
        if (onCompletedSpotDetailRequest.getResult() == RFGRailroadClient.RailroadApiResult.SUCCESS) {
            if (onCompletedSpotDetailRequest.getSpotDetail() == null) {
                terminate();
            } else {
                this.spotDetail = onCompletedSpotDetailRequest.getSpotDetail();
                setUpDetail(onCompletedSpotDetailRequest.getSpotDetail());
            }
        }
        C1126c.m1638c().mo21908c(this);
        stopLoading();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkExpressionValueIsNotNull(arguments, "arguments ?: let {\n     …         return\n        }");
            this.param1 = arguments.getString(ARG_PARAM1);
            this.param2 = arguments.getInt(ARG_PARAM2);
            return;
        }
        terminate();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        this.fragmentListener = null;
        super.onDetach();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        requestSpotDetail();
        ((ImageView) _$_findCachedViewById(C2092R.C2094id.buttonBack)).setOnClickListener(new RFGSpotDetailFragment$onViewCreated$1(this));
        if (Build.VERSION.SDK_INT >= 26) {
            TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.viewSpotTitleTop);
            Intrinsics.checkExpressionValueIsNotNull(textView, "viewSpotTitleTop");
            Context context = textView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "viewSpotTitleTop.context");
            TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.viewSpotTitleTop);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "viewSpotTitleTop");
            Context context2 = textView2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "viewSpotTitleTop.context");
            TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes((TextView) _$_findCachedViewById(C2092R.C2094id.viewSpotTitleTop), new int[]{context.getResources().getDimensionPixelSize(R.dimen.sanriku_spot_title_min), context2.getResources().getDimensionPixelSize(R.dimen.sanriku_spot_title)}, 0);
        }
    }

    public String screenId() {
        return "310";
    }
}
