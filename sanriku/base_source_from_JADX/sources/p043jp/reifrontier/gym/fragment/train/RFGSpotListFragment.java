package p043jp.reifrontier.gym.fragment.train;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.train.RFGSpotData;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.gym.fragment.RFGFragmentBase;
import p043jp.reifrontier.gym.p044ui.adapter.RFGSpotListAdapter;
import p043jp.reifrontier.gym.p044ui.dialog.RFGSpotOrderDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGSpotStationDialog;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGSpotOrderType;
import p043jp.reifrontier.sanriku.R;
import p048l.p049a.C1122a;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0004,-./B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020%H\u0007J\u001a\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010)\u001a\u00020\u0013H\u0007J\b\u0010*\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase;", "()V", "canLoadMoreSpot", "", "filterOrder", "Ljp/reifrontier/gym/ui/viewModel/RFGSpotOrderType;", "filterStationId", "", "fragmentListener", "Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment$OnSpotListFragmentListener;", "param1", "", "param2", "spotList", "", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "actionBarTitle", "changeFilterView", "", "clearSpotList", "fragmentType", "Ljp/reifrontier/gym/RFGDef$FragType;", "layoutId", "onAttach", "context", "Landroid/content/Context;", "onClickOrderButton", "onClickStationButton", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onSelectedOrder", "event", "Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment$OnSelectedOrder;", "onSelectedStation", "Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment$OnSelectedStation;", "onViewCreated", "view", "Landroid/view/View;", "requestSpotList", "screenId", "setUpSpotList", "Companion", "OnSelectedOrder", "OnSelectedStation", "OnSpotListFragmentListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment */
public final class RFGSpotListFragment extends RFGFragmentBase {
    private static final String ARG_FILTER_ORDER = "filter_order";
    private static final String ARG_FILTER_STATION_ID = "filter_station_id";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean canLoadMoreSpot;
    private RFGSpotOrderType filterOrder = RFGSpotOrderType.LATEST;
    private int filterStationId = -1;
    /* access modifiers changed from: private */
    public OnSpotListFragmentListener fragmentListener;
    private String param1;
    private String param2;
    /* access modifiers changed from: private */
    public List<RFGSpot> spotList = new ArrayList();

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment$OnSpotListFragmentListener;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "onSelectedSpot", "", "spot", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment$OnSpotListFragmentListener */
    public interface OnSpotListFragmentListener extends RFGFragmentBase.OnFragmentBaseListener {
        void onSelectedSpot(RFGSpot rFGSpot);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment$Companion;", "", "()V", "ARG_FILTER_ORDER", "", "ARG_FILTER_STATION_ID", "ARG_PARAM1", "ARG_PARAM2", "newInstance", "Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment;", "param1", "param2", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGSpotListFragment newInstance(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, RFGSpotListFragment.ARG_PARAM1);
            Intrinsics.checkParameterIsNotNull(str2, RFGSpotListFragment.ARG_PARAM2);
            RFGSpotListFragment rFGSpotListFragment = new RFGSpotListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(RFGSpotListFragment.ARG_PARAM1, str);
            bundle.putString(RFGSpotListFragment.ARG_PARAM2, str2);
            bundle.putSerializable(RFGSpotListFragment.ARG_FILTER_ORDER, RFGSpotOrderType.LATEST);
            bundle.putInt(RFGSpotListFragment.ARG_FILTER_STATION_ID, -1);
            rFGSpotListFragment.setArguments(bundle);
            return rFGSpotListFragment;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment$OnSelectedOrder;", "", "cancel", "", "selectedOrder", "Ljp/reifrontier/gym/ui/viewModel/RFGSpotOrderType;", "(ZLjp/reifrontier/gym/ui/viewModel/RFGSpotOrderType;)V", "getCancel", "()Z", "getSelectedOrder", "()Ljp/reifrontier/gym/ui/viewModel/RFGSpotOrderType;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment$OnSelectedOrder */
    public static final class OnSelectedOrder {
        private final boolean cancel;
        private final RFGSpotOrderType selectedOrder;

        public OnSelectedOrder(boolean z, RFGSpotOrderType rFGSpotOrderType) {
            this.cancel = z;
            this.selectedOrder = rFGSpotOrderType;
        }

        public static /* synthetic */ OnSelectedOrder copy$default(OnSelectedOrder onSelectedOrder, boolean z, RFGSpotOrderType rFGSpotOrderType, int i, Object obj) {
            if ((i & 1) != 0) {
                z = onSelectedOrder.cancel;
            }
            if ((i & 2) != 0) {
                rFGSpotOrderType = onSelectedOrder.selectedOrder;
            }
            return onSelectedOrder.copy(z, rFGSpotOrderType);
        }

        public final boolean component1() {
            return this.cancel;
        }

        public final RFGSpotOrderType component2() {
            return this.selectedOrder;
        }

        public final OnSelectedOrder copy(boolean z, RFGSpotOrderType rFGSpotOrderType) {
            return new OnSelectedOrder(z, rFGSpotOrderType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSelectedOrder)) {
                return false;
            }
            OnSelectedOrder onSelectedOrder = (OnSelectedOrder) obj;
            return this.cancel == onSelectedOrder.cancel && Intrinsics.areEqual((Object) this.selectedOrder, (Object) onSelectedOrder.selectedOrder);
        }

        public final boolean getCancel() {
            return this.cancel;
        }

        public final RFGSpotOrderType getSelectedOrder() {
            return this.selectedOrder;
        }

        public int hashCode() {
            boolean z = this.cancel;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            RFGSpotOrderType rFGSpotOrderType = this.selectedOrder;
            return i + (rFGSpotOrderType != null ? rFGSpotOrderType.hashCode() : 0);
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("OnSelectedOrder(cancel=");
            a.append(this.cancel);
            a.append(", selectedOrder=");
            a.append(this.selectedOrder);
            a.append(")");
            return a.toString();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment$OnSelectedStation;", "", "cancel", "", "selectedStation", "Ljp/reifrontier/gym/data/train/RFGStation;", "(ZLjp/reifrontier/gym/data/train/RFGStation;)V", "getCancel", "()Z", "getSelectedStation", "()Ljp/reifrontier/gym/data/train/RFGStation;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment$OnSelectedStation */
    public static final class OnSelectedStation {
        private final boolean cancel;
        private final RFGStation selectedStation;

        public OnSelectedStation(boolean z, RFGStation rFGStation) {
            this.cancel = z;
            this.selectedStation = rFGStation;
        }

        public static /* synthetic */ OnSelectedStation copy$default(OnSelectedStation onSelectedStation, boolean z, RFGStation rFGStation, int i, Object obj) {
            if ((i & 1) != 0) {
                z = onSelectedStation.cancel;
            }
            if ((i & 2) != 0) {
                rFGStation = onSelectedStation.selectedStation;
            }
            return onSelectedStation.copy(z, rFGStation);
        }

        public final boolean component1() {
            return this.cancel;
        }

        public final RFGStation component2() {
            return this.selectedStation;
        }

        public final OnSelectedStation copy(boolean z, RFGStation rFGStation) {
            return new OnSelectedStation(z, rFGStation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSelectedStation)) {
                return false;
            }
            OnSelectedStation onSelectedStation = (OnSelectedStation) obj;
            return this.cancel == onSelectedStation.cancel && Intrinsics.areEqual((Object) this.selectedStation, (Object) onSelectedStation.selectedStation);
        }

        public final boolean getCancel() {
            return this.cancel;
        }

        public final RFGStation getSelectedStation() {
            return this.selectedStation;
        }

        public int hashCode() {
            boolean z = this.cancel;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            RFGStation rFGStation = this.selectedStation;
            return i + (rFGStation != null ? rFGStation.hashCode() : 0);
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("OnSelectedStation(cancel=");
            a.append(this.cancel);
            a.append(", selectedStation=");
            a.append(this.selectedStation);
            a.append(")");
            return a.toString();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFGSpotOrderType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGSpotOrderType rFGSpotOrderType = RFGSpotOrderType.NEAREST;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGSpotOrderType rFGSpotOrderType2 = RFGSpotOrderType.LATEST;
            iArr2[1] = 2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006c, code lost:
        if (r1 != null) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void changeFilterView() {
        /*
            r5 = this;
            jp.reifrontier.gym.ui.viewModel.RFGSpotOrderType r0 = r5.filterOrder
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x0015
            r1 = 1
            if (r0 != r1) goto L_0x000f
            r0 = 2131624377(0x7f0e01b9, float:1.8875932E38)
            goto L_0x0018
        L_0x000f:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0015:
            r0 = 2131624378(0x7f0e01ba, float:1.8875934E38)
        L_0x0018:
            int r1 = p043jp.reifrontier.gym.C2092R.C2094id.viewOrderButtonText
            android.view.View r1 = r5._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setText(r0)
            int r0 = p043jp.reifrontier.gym.C2092R.C2094id.viewStationButtonText
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "viewStationButtonText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            jp.reifrontier.gym.data.train.RFGTrainData r1 = p043jp.reifrontier.gym.data.train.RFGTrainData.INSTANCE
            int r2 = r5.filterStationId
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            jp.reifrontier.gym.data.train.RFGStation r1 = r1.findStation((java.lang.Integer) r2)
            if (r1 == 0) goto L_0x006f
            android.content.Context r2 = r5.getContext()
            if (r2 == 0) goto L_0x0068
            int r3 = p043jp.reifrontier.gym.C2092R.C2094id.viewStationButtonBackground
            android.view.View r3 = r5._$_findCachedViewById(r3)
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r4 = 2131034285(0x7f0500ad, float:1.7679083E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r2, r4)
            r3.setBackgroundColor(r4)
            int r3 = p043jp.reifrontier.gym.C2092R.C2094id.viewStationButtonText
            android.view.View r3 = r5._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 2131034286(0x7f0500ae, float:1.7679085E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r4)
            r3.setTextColor(r2)
        L_0x0068:
            java.lang.String r1 = r1.getName()
            if (r1 == 0) goto L_0x006f
            goto L_0x009f
        L_0x006f:
            android.content.Context r1 = r5.getContext()
            if (r1 == 0) goto L_0x0098
            int r2 = p043jp.reifrontier.gym.C2092R.C2094id.viewStationButtonBackground
            android.view.View r2 = r5._$_findCachedViewById(r2)
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2
            java.lang.String r3 = "viewStationButtonBackground"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            r3 = 0
            r2.setBackground(r3)
            int r2 = p043jp.reifrontier.gym.C2092R.C2094id.viewStationButtonText
            android.view.View r2 = r5._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2131034280(0x7f0500a8, float:1.7679073E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r3)
            r2.setTextColor(r1)
        L_0x0098:
            r1 = 2131624379(0x7f0e01bb, float:1.8875936E38)
            java.lang.String r1 = r5.getString(r1)
        L_0x009f:
            r0.setText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.fragment.train.RFGSpotListFragment.changeFilterView():void");
    }

    private final void clearSpotList() {
        this.spotList.clear();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "spotListView");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (!(adapter instanceof RFGSpotListAdapter)) {
            adapter = null;
        }
        RFGSpotListAdapter rFGSpotListAdapter = (RFGSpotListAdapter) adapter;
        if (rFGSpotListAdapter != null) {
            rFGSpotListAdapter.clearData();
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "spotListView");
        recyclerView2.setTag((Object) null);
        ((RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView)).scrollToPosition(0);
    }

    /* access modifiers changed from: private */
    public final void onClickOrderButton() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            Intrinsics.checkExpressionValueIsNotNull(fragmentManager, "fragmentManager ?: return");
            C1126c.m1638c().mo21908c(this);
            C1126c.m1638c().mo21907b(this);
            RFGSpotOrderDialog.Companion.newInstance(this.filterOrder).show(fragmentManager, RFGSpotOrderDialog.TAG);
        }
    }

    /* access modifiers changed from: private */
    public final void onClickStationButton() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            Intrinsics.checkExpressionValueIsNotNull(fragmentManager, "fragmentManager ?: return");
            C1126c.m1638c().mo21908c(this);
            C1126c.m1638c().mo21907b(this);
            RFGSpotStationDialog.Companion.newInstance(this.filterStationId).show(fragmentManager, RFGSpotStationDialog.TAG);
        }
    }

    private final void setUpSpotList() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "spotListView");
        recyclerView.setTag(1);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "spotListView");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstCompletelyVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : 0;
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, "spotListView");
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
        ((RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView)).scrollToPosition(findFirstCompletelyVisibleItemPosition);
        RFGSpotListAdapter rFGSpotListAdapter = new RFGSpotListAdapter();
        rFGSpotListAdapter.addData(this.spotList);
        RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView4, "spotListView");
        recyclerView4.setAdapter(rFGSpotListAdapter);
        rFGSpotListAdapter.setOnItemClicked(new RFGSpotListFragment$setUpSpotList$1(this));
        ((RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView)).addOnScrollListener(new RFGSpotListFragment$setUpSpotList$2(this));
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
        String string = getString(R.string.sanriku_spot_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.sanriku_spot_title)");
        return string;
    }

    public RFGDef.FragType fragmentType() {
        return RFGDef.FragType.SpotList;
    }

    public int layoutId() {
        return R.layout.fragment_sanriku_spot_list;
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnSpotListFragmentListener) {
            this.fragmentListener = (OnSpotListFragmentListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnSpotListFragmentListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1122a.m1596a("[Sanriku]::Debug onCrate", new Object[0]);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.param1 = arguments.getString(ARG_PARAM1);
            this.param2 = arguments.getString(ARG_PARAM2);
            Serializable serializable = arguments.getSerializable(ARG_FILTER_ORDER);
            if (serializable != null) {
                this.filterOrder = (RFGSpotOrderType) serializable;
                this.filterStationId = arguments.getInt(ARG_FILTER_STATION_ID, -1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.ui.viewModel.RFGSpotOrderType");
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        this.fragmentListener = null;
        super.onDetach();
    }

    @C1129m
    public final void onSelectedOrder(OnSelectedOrder onSelectedOrder) {
        Intrinsics.checkParameterIsNotNull(onSelectedOrder, "event");
        C1126c.m1638c().mo21908c(this);
        if (!onSelectedOrder.getCancel() && onSelectedOrder.getSelectedOrder() != null && this.filterOrder != onSelectedOrder.getSelectedOrder()) {
            this.filterOrder = onSelectedOrder.getSelectedOrder();
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            Intrinsics.checkExpressionValueIsNotNull(arguments, "arguments ?: Bundle()");
            arguments.putSerializable(ARG_FILTER_ORDER, this.filterOrder);
            setArguments(arguments);
            clearSpotList();
            requestSpotList();
        }
    }

    @C1129m
    public final void onSelectedStation(OnSelectedStation onSelectedStation) {
        Intrinsics.checkParameterIsNotNull(onSelectedStation, "event");
        C1126c.m1638c().mo21908c(this);
        if (!onSelectedStation.getCancel()) {
            RFGStation selectedStation = onSelectedStation.getSelectedStation();
            int stationId = selectedStation != null ? selectedStation.getStationId() : -1;
            if (this.filterStationId != stationId) {
                this.filterStationId = stationId;
                Bundle arguments = getArguments();
                if (arguments == null) {
                    arguments = new Bundle();
                }
                Intrinsics.checkExpressionValueIsNotNull(arguments, "arguments ?: Bundle()");
                arguments.putSerializable(ARG_FILTER_STATION_ID, Integer.valueOf(this.filterStationId));
                setArguments(arguments);
                clearSpotList();
                requestSpotList();
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        C1122a.m1596a("[Sanriku]::Debug onViewCreated " + bundle, new Object[0]);
        setUpSpotList();
        changeFilterView();
        ((CardView) _$_findCachedViewById(C2092R.C2094id.viewOrderButton)).setOnClickListener(new RFGSpotListFragment$onViewCreated$1(this));
        ((CardView) _$_findCachedViewById(C2092R.C2094id.viewStationButton)).setOnClickListener(new RFGSpotListFragment$onViewCreated$2(this));
    }

    @SuppressLint({"CheckResult"})
    public final void requestSpotList() {
        if (!isLoading()) {
            changeFilterView();
            startLoading();
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "spotListView");
            Object tag = recyclerView.getTag();
            Integer num = null;
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num2 = (Integer) tag;
            int intValue = num2 != null ? num2.intValue() : 1;
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.spotListView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "spotListView");
            recyclerView2.setTag(Integer.valueOf(intValue));
            C1122a.m1596a("[Sanriku]::Debug filterOrder=" + this.filterOrder + ", filterStationId=" + this.filterStationId + ", page=" + intValue, new Object[0]);
            RFGSpotData rFGSpotData = new RFGSpotData();
            RFGSpotOrderType rFGSpotOrderType = this.filterOrder;
            RFGStation findStation = RFGTrainData.INSTANCE.findStation(Integer.valueOf(this.filterStationId));
            if (findStation != null) {
                num = Integer.valueOf(findStation.getStationId());
            }
            rFGSpotData.getSpotList(rFGSpotOrderType, num, intValue).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGSpotListFragment$requestSpotList$1(this), new RFGSpotListFragment$requestSpotList$2(this));
        }
    }

    public String screenId() {
        return "300";
    }
}
