package p043jp.reifrontier.gym.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dinuscxj.refresh.RecyclerRefreshLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p028d.p061c.p062a.C1562e;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.domain.api.RFGFeed;
import p043jp.reifrontier.gym.domain.api.RFGPanelData;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;
import p043jp.reifrontier.gym.domain.app.RFGAdapterOperation;
import p043jp.reifrontier.gym.domain.app.RFGAdapterPoint;
import p043jp.reifrontier.gym.domain.app.RFGAdapterWeight;
import p043jp.reifrontier.gym.fragment.RFGFragmentBase;
import p043jp.reifrontier.gym.p044ui.adapter.RFGFeedAdapter;
import p043jp.reifrontier.gym.p044ui.widget.RFGRefreshView;
import p043jp.reifrontier.sanriku.R;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0019\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0003FGHB\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\u0005J\u0016\u0010$\u001a\u00020\u001f2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010!J\u0014\u0010'\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!J\u0014\u0010*\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\u0006\u0010+\u001a\u00020\u001fJ\b\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00109\u001a\u00020\u001fH\u0016J\b\u0010:\u001a\u00020\u001fH\u0016J\b\u0010;\u001a\u00020\u001fH\u0016J\b\u0010<\u001a\u00020\u001fH\u0016J\b\u0010=\u001a\u00020\u001fH\u0016J\u001a\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u0010@\u001a\u00020\u001fH\u0002J\b\u0010A\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020\u001fH\u0016J\u0010\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020EH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGFeedFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$OnFeedItemListener;", "()V", "isRequesting", "", "mAdapter", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter;", "mFeedItems", "", "", "mLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "mListener", "Ljp/reifrontier/gym/fragment/RFGFeedFragment$OnFeedFragmentListener;", "mParam1", "", "mParam2", "mRecyclerRefreshLayout", "Lcom/dinuscxj/refresh/RecyclerRefreshLayout;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mRefreshEventDetector", "Ljp/reifrontier/gym/fragment/RFGFeedFragment$RefreshEventDetector;", "onScrollListener", "jp/reifrontier/gym/fragment/RFGFeedFragment$onScrollListener$1", "Ljp/reifrontier/gym/fragment/RFGFeedFragment$onScrollListener$1;", "shouldLoadMore", "twaLauncher", "Lcom/google/androidbrowserhelper/trusted/TwaLauncher;", "addFeeds", "", "feeds", "", "Ljp/reifrontier/gym/domain/api/RFGFeed;", "shouldLoad", "addOperationFeed", "operationList", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "addSummaries", "items", "Ljp/reifrontier/gym/domain/api/RFGPanelData;", "addWeightFeed", "clear", "notifyDataSet", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onDetach", "onResume", "onStart", "onViewCreated", "view", "setRecyclerViewLayoutManager", "setupFeedRecyclerView", "touchPoint", "touchTimeline", "date", "Ljava/util/Date;", "Companion", "OnFeedFragmentListener", "RefreshEventDetector", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.RFGFeedFragment */
public final class RFGFeedFragment extends Fragment implements RFGFeedAdapter.OnFeedItemListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean isRequesting = true;
    /* access modifiers changed from: private */
    public RFGFeedAdapter mAdapter;
    private List<Object> mFeedItems = new ArrayList();
    private RecyclerView.LayoutManager mLayoutManager;
    /* access modifiers changed from: private */
    public OnFeedFragmentListener mListener;
    private String mParam1;
    private String mParam2;
    /* access modifiers changed from: private */
    public RecyclerRefreshLayout mRecyclerRefreshLayout;
    private RecyclerView mRecyclerView;
    private final RefreshEventDetector mRefreshEventDetector = new RefreshEventDetector();
    private final RFGFeedFragment$onScrollListener$1 onScrollListener = new RFGFeedFragment$onScrollListener$1(this);
    /* access modifiers changed from: private */
    public boolean shouldLoadMore = true;
    private C1562e twaLauncher;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGFeedFragment$OnFeedFragmentListener;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "interactionFeedPoint", "", "interactionFeedSummary", "date", "Ljava/util/Date;", "loadFeedsMore", "updateFeed", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGFeedFragment$OnFeedFragmentListener */
    public interface OnFeedFragmentListener extends RFGFragmentBase.OnFragmentBaseListener {
        void interactionFeedPoint();

        void interactionFeedSummary(Date date);

        void loadFeedsMore();

        void updateFeed();
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGFeedFragment$Companion;", "", "()V", "ARG_PARAM1", "", "ARG_PARAM2", "newInstance", "Ljp/reifrontier/gym/fragment/RFGFeedFragment;", "param1", "param2", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGFeedFragment$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGFeedFragment newInstance(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, RFGFeedFragment.ARG_PARAM1);
            Intrinsics.checkParameterIsNotNull(str2, RFGFeedFragment.ARG_PARAM2);
            RFGFeedFragment rFGFeedFragment = new RFGFeedFragment();
            Bundle bundle = new Bundle();
            bundle.putString(RFGFeedFragment.ARG_PARAM1, str);
            bundle.putString(RFGFeedFragment.ARG_PARAM2, str2);
            rFGFeedFragment.setArguments(bundle);
            return rFGFeedFragment;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGFeedFragment$RefreshEventDetector;", "Lcom/dinuscxj/refresh/RecyclerRefreshLayout$OnRefreshListener;", "(Ljp/reifrontier/gym/fragment/RFGFeedFragment;)V", "onRefresh", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGFeedFragment$RefreshEventDetector */
    public final class RefreshEventDetector implements RecyclerRefreshLayout.C0541f {
        public RefreshEventDetector() {
        }

        public void onRefresh() {
            RecyclerRefreshLayout access$getMRecyclerRefreshLayout$p = RFGFeedFragment.this.mRecyclerRefreshLayout;
            if (access$getMRecyclerRefreshLayout$p == null) {
                Intrinsics.throwNpe();
            }
            access$getMRecyclerRefreshLayout$p.mo9337a(true);
            RFGFeedFragment.this.isRequesting = true;
            OnFeedFragmentListener access$getMListener$p = RFGFeedFragment.this.mListener;
            if (access$getMListener$p == null) {
                Intrinsics.throwNpe();
            }
            access$getMListener$p.updateFeed();
        }
    }

    private final void notifyDataSet() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.post(new RFGFeedFragment$notifyDataSet$1(this));
        }
    }

    private final void setRecyclerViewLayoutManager() {
        int i;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwNpe();
        }
        if (recyclerView.getLayoutManager() != null) {
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwNpe();
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager != null) {
                i = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        } else {
            i = 0;
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView3.addOnScrollListener(this.onScrollListener);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        this.mLayoutManager = new LinearLayoutManager(activity);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView4.setLayoutManager(this.mLayoutManager);
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView5.scrollToPosition(i);
    }

    private final void setupFeedRecyclerView() {
        this.mRecyclerView = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.recyclerView);
        this.mLayoutManager = new LinearLayoutManager(getActivity());
        setRecyclerViewLayoutManager();
        RFGFeedAdapter rFGFeedAdapter = new RFGFeedAdapter();
        this.mAdapter = rFGFeedAdapter;
        if (rFGFeedAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGFeedAdapter.setMListener(this);
        if (this.mFeedItems.size() > 0) {
            RFGFeedAdapter rFGFeedAdapter2 = this.mAdapter;
            if (rFGFeedAdapter2 == null) {
                Intrinsics.throwNpe();
            }
            rFGFeedAdapter2.addAll(this.mFeedItems);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwNpe();
        }
        RFGFeedAdapter rFGFeedAdapter3 = this.mAdapter;
        if (rFGFeedAdapter3 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView.setAdapter(rFGFeedAdapter3);
        RecyclerRefreshLayout recyclerRefreshLayout = (RecyclerRefreshLayout) _$_findCachedViewById(C2092R.C2094id.refresh_layout);
        this.mRecyclerRefreshLayout = recyclerRefreshLayout;
        if (recyclerRefreshLayout == null) {
            Intrinsics.throwNpe();
        }
        recyclerRefreshLayout.mo9337a(false);
        RecyclerRefreshLayout recyclerRefreshLayout2 = this.mRecyclerRefreshLayout;
        if (recyclerRefreshLayout2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerRefreshLayout2.mo9336a(RecyclerRefreshLayout.C0542g.PINNED);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(100, 100);
        RecyclerRefreshLayout recyclerRefreshLayout3 = this.mRecyclerRefreshLayout;
        if (recyclerRefreshLayout3 == null) {
            Intrinsics.throwNpe();
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        recyclerRefreshLayout3.mo9334a((View) new RFGRefreshView(activity), layoutParams);
        RecyclerRefreshLayout recyclerRefreshLayout4 = this.mRecyclerRefreshLayout;
        if (recyclerRefreshLayout4 == null) {
            Intrinsics.throwNpe();
        }
        recyclerRefreshLayout4.mo9333a(30.0f);
        RecyclerRefreshLayout recyclerRefreshLayout5 = this.mRecyclerRefreshLayout;
        if (recyclerRefreshLayout5 == null) {
            Intrinsics.throwNpe();
        }
        recyclerRefreshLayout5.setNestedScrollingEnabled(true);
        RecyclerRefreshLayout recyclerRefreshLayout6 = this.mRecyclerRefreshLayout;
        if (recyclerRefreshLayout6 == null) {
            Intrinsics.throwNpe();
        }
        recyclerRefreshLayout6.mo9335a((RecyclerRefreshLayout.C0541f) this.mRefreshEventDetector);
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

    public final void addFeeds(List<RFGFeed> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "feeds");
        C1122a.m1600c("[Gym]::Info addFeeds mFeedItems count:%s shouldLoad:%s", Integer.valueOf(this.mFeedItems.size()), Boolean.valueOf(z));
        this.shouldLoadMore = z;
        this.isRequesting = false;
        RecyclerRefreshLayout recyclerRefreshLayout = this.mRecyclerRefreshLayout;
        if (recyclerRefreshLayout == null) {
            Intrinsics.throwNpe();
        }
        recyclerRefreshLayout.mo9337a(false);
        this.mFeedItems.addAll(list);
        RFGFeedAdapter rFGFeedAdapter = this.mAdapter;
        if (rFGFeedAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGFeedAdapter.addFeeds(list);
        notifyDataSet();
    }

    public final void addOperationFeed(List<RFGApiOperation> list) {
        RFGAdapterOperation rFGAdapterOperation = new RFGAdapterOperation(list != null ? list.size() : -1);
        this.mFeedItems.add(rFGAdapterOperation);
        RFGFeedAdapter rFGFeedAdapter = this.mAdapter;
        if (rFGFeedAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGFeedAdapter.addOperation(rFGAdapterOperation);
        notifyDataSet();
    }

    public final void addSummaries(List<? extends RFGPanelData> list) {
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        RFGAdapterPoint rFGAdapterPoint = new RFGAdapterPoint(list);
        this.mFeedItems.add(rFGAdapterPoint);
        RFGFeedAdapter rFGFeedAdapter = this.mAdapter;
        if (rFGFeedAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGFeedAdapter.addSummary(rFGAdapterPoint);
        notifyDataSet();
    }

    public final void addWeightFeed(List<RFGFeed> list) {
        Intrinsics.checkParameterIsNotNull(list, "feeds");
        if (!list.isEmpty()) {
            RFGAdapterWeight rFGAdapterWeight = new RFGAdapterWeight((RFGFeed) CollectionsKt___CollectionsKt.first(list));
            this.mFeedItems.add(rFGAdapterWeight);
            RFGFeedAdapter rFGFeedAdapter = this.mAdapter;
            if (rFGFeedAdapter == null) {
                Intrinsics.throwNpe();
            }
            rFGFeedAdapter.addWeight(rFGAdapterWeight);
            notifyDataSet();
        }
    }

    public final void clear() {
        this.isRequesting = true;
        RFGFeedAdapter rFGFeedAdapter = this.mAdapter;
        if (rFGFeedAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGFeedAdapter.clear();
        this.mFeedItems = new ArrayList();
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnFeedFragmentListener) {
            this.mListener = (OnFeedFragmentListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFeedFragmentListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                Intrinsics.throwNpe();
            }
            this.mParam1 = arguments.getString(ARG_PARAM1);
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                Intrinsics.throwNpe();
            }
            this.mParam2 = arguments2.getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_feed, viewGroup, false);
    }

    public void onDestroy() {
        this.mFeedItems = new ArrayList();
        C1562e eVar = this.twaLauncher;
        if (eVar != null) {
            eVar.mo27327a();
        }
        this.twaLauncher = null;
        super.onDestroy();
    }

    public void onDestroyView() {
        this.mRecyclerView = null;
        this.mAdapter = null;
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    public void onResume() {
        super.onResume();
        RFGAnalyticsManager.INSTANCE.sendScreen("100");
    }

    public void onStart() {
        super.onStart();
        OnFeedFragmentListener onFeedFragmentListener = this.mListener;
        if (onFeedFragmentListener == null) {
            Intrinsics.throwNpe();
        }
        onFeedFragmentListener.onStart(RFGDef.FragType.Feed, "");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        setupFeedRecyclerView();
        super.onViewCreated(view, bundle);
    }

    public void touchPoint() {
        OnFeedFragmentListener onFeedFragmentListener = this.mListener;
        if (onFeedFragmentListener == null) {
            Intrinsics.throwNpe();
        }
        onFeedFragmentListener.interactionFeedPoint();
    }

    public void touchTimeline(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        OnFeedFragmentListener onFeedFragmentListener = this.mListener;
        if (onFeedFragmentListener == null) {
            Intrinsics.throwNpe();
        }
        onFeedFragmentListener.interactionFeedSummary(date);
    }
}
