package p043jp.reifrontier.gym.p044ui.tab;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0007ABCDEFGB\u001f\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0000\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u001d2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010 \u001a\u00020!2\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\rH\u0003J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bH\u0003J\n\u0010)\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014H\u0003J\b\u0010+\u001a\u00020\tH\u0007J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\tH\u0003J\b\u0010.\u001a\u00020\tH\u0007J\u0018\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00142\u0006\u0010-\u001a\u00020\tH\u0003J\u000e\u00100\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\tJ\b\u00101\u001a\u00020\u000fH\u0007J&\u00102\u001a\u00060\u0003R\u00020\u00002\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\tJ\u000e\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u0005J\u0006\u00107\u001a\u00020\u001dJ\u0014\u00107\u001a\u00020\u001d2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\tJ\u001c\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\t2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010:\u001a\u00020\u001d2\b\b\u0001\u0010(\u001a\u00020\u000bJ \u0010:\u001a\u00020\u001d2\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u000b2\u0006\u0010$\u001a\u00020!H\u0003J\u000e\u0010<\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u000bJ\u001c\u0010<\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u000b2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002J&\u0010=\u001a\u00020\u000f2\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0001\u0010>\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010?H\u0002J\u000e\u0010@\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\tJ\u001c\u0010@\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\t2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00140\u0013X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0007R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavController;", "", "builder", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$Builder;", "savedInstanceState", "Landroid/os/Bundle;", "(Ljp/reifrontier/gym/ui/tab/RFGFragNavController$Builder;Landroid/os/Bundle;)V", "()V", "mContainerId", "", "mCurrentFrag", "Landroidx/fragment/app/Fragment;", "mDefaultTransactionOptions", "Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions;", "mExecutingTransaction", "", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mFragmentStacks", "", "Ljava/util/Stack;", "mRootFragmentListener", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$RootFragmentListener;", "mSelectedTabIndex", "mSelectedTabIndex$annotations", "mTagCount", "mTransactionListener", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionListener;", "clearFragmentManager", "", "clearStack", "transactionOptions", "createTransactionWithOptions", "Landroidx/fragment/app/FragmentTransaction;", "aTransactionOptions", "detachCurrentFragment", "ft", "executePendingTransactions", "generateTag", "", "fragment", "getCurrentFrag", "getCurrentStack", "getCurrentStackIndex", "getRootFragment", "index", "getSize", "getStack", "initialize", "isRootFragment", "newBuilder", "fragmentManager", "containerId", "onSaveInstanceState", "outState", "popFragment", "popFragments", "popDepth", "pushFragment", "reattachPreviousFragment", "replaceFragment", "restoreFromBundle", "rootFragments", "", "switchTab", "Builder", "Companion", "RootFragmentListener", "TabIndex", "TransactionListener", "TransactionType", "Transit", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavController */
public final class RFGFragNavController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_CURRENT_FRAGMENT;
    private static final String EXTRA_FRAGMENT_STACK;
    private static final String EXTRA_SELECTED_TAB_INDEX;
    private static final String EXTRA_TAG_COUNT;
    public static final int MAX_NUM_TABS = 5;
    public static final int NO_TAB = -1;
    public static final int TAB1 = 0;
    public static final int TAB2 = 1;
    public static final int TAB3 = 2;
    public static final int TAB4 = 3;
    public static final int TAB5 = 4;
    @IdRes
    private int mContainerId;
    @Nullable
    private Fragment mCurrentFrag;
    private RFGFragNavTransactionOptions mDefaultTransactionOptions;
    private boolean mExecutingTransaction;
    private FragmentManager mFragmentManager;
    private List<Stack<Fragment>> mFragmentStacks;
    @Nullable
    private RootFragmentListener mRootFragmentListener;
    private int mSelectedTabIndex;
    private int mTagCount;
    @Nullable
    private TransactionListener mTransactionListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavController$RootFragmentListener;", "", "getRootFragment", "Landroidx/fragment/app/Fragment;", "index", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavController$RootFragmentListener */
    public interface RootFragmentListener {
        Fragment getRootFragment(int i);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TabIndex;", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavController$TabIndex */
    public @interface TabIndex {
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionListener;", "", "onFragmentTransaction", "", "fragment", "Landroidx/fragment/app/Fragment;", "transactionType", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionType;", "onTabTransaction", "index", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavController$TransactionListener */
    public interface TransactionListener {
        void onFragmentTransaction(Fragment fragment, TransactionType transactionType);

        void onTabTransaction(Fragment fragment, int i);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavController$Transit;", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavController$Transit */
    public @interface Transit {
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0005¢\u0006\u0002\u0010\tJ\u0006\u00106\u001a\u000207J\u0012\u00108\u001a\u00060\u0000R\u0002072\u0006\u00109\u001a\u00020\u0010J\u0012\u0010:\u001a\u00060\u0000R\u0002072\u0006\u0010:\u001a\u00020%J\u001a\u0010;\u001a\u00060\u0000R\u0002072\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u0007J\u001a\u0010=\u001a\u00060\u0000R\u0002072\f\u0010=\u001a\b\u0012\u0004\u0012\u00020%0>H\u0002J\u0012\u0010?\u001a\u00060\u0000R\u0002072\u0006\u0010?\u001a\u00020\u0007J\u0012\u0010@\u001a\u00060\u0000R\u0002072\u0006\u0010A\u001a\u000201R\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R \u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001a\u00100\u001a\u000201X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006B"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavController$Builder;", "", "savedInstanceState", "Landroid/os/Bundle;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "", "(Ljp/reifrontier/gym/ui/tab/RFGFragNavController;Landroid/os/Bundle;Landroidx/fragment/app/FragmentManager;I)V", "(Ljp/reifrontier/gym/ui/tab/RFGFragNavController;)V", "mContainerId", "getMContainerId", "()I", "setMContainerId", "(I)V", "mDefaultTransactionOptions", "Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions;", "getMDefaultTransactionOptions", "()Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions;", "setMDefaultTransactionOptions", "(Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions;)V", "mFragmentManager", "getMFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setMFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "mNumberOfTabs", "getMNumberOfTabs", "setMNumberOfTabs", "mRootFragmentListener", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$RootFragmentListener;", "getMRootFragmentListener", "()Ljp/reifrontier/gym/ui/tab/RFGFragNavController$RootFragmentListener;", "setMRootFragmentListener", "(Ljp/reifrontier/gym/ui/tab/RFGFragNavController$RootFragmentListener;)V", "mRootFragments", "", "Landroidx/fragment/app/Fragment;", "getMRootFragments", "()Ljava/util/List;", "setMRootFragments", "(Ljava/util/List;)V", "mSavedInstanceState", "mSelectedTabIndex", "mSelectedTabIndex$annotations", "()V", "getMSelectedTabIndex", "setMSelectedTabIndex", "mTransactionListener", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionListener;", "getMTransactionListener", "()Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionListener;", "setMTransactionListener", "(Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionListener;)V", "build", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController;", "defaultTransactionOptions", "transactionOptions", "rootFragment", "rootFragmentListener", "numberOfTabs", "rootFragments", "", "selectedTabIndex", "transactionListener", "val", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavController$Builder */
    public final class Builder {
        private int mContainerId;
        private RFGFragNavTransactionOptions mDefaultTransactionOptions;
        public FragmentManager mFragmentManager;
        private int mNumberOfTabs;
        public RootFragmentListener mRootFragmentListener;
        private List<Fragment> mRootFragments;
        private Bundle mSavedInstanceState;
        private int mSelectedTabIndex;
        public TransactionListener mTransactionListener;

        public Builder() {
            this.mContainerId = -1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(RFGFragNavController rFGFragNavController, Bundle bundle, FragmentManager fragmentManager, int i) {
            this();
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
            this.mSavedInstanceState = bundle;
            this.mFragmentManager = fragmentManager;
            this.mContainerId = i;
        }

        public static /* synthetic */ void mSelectedTabIndex$annotations() {
        }

        private final Builder rootFragments(List<? extends Fragment> list) {
            ArrayList arrayList = new ArrayList();
            this.mRootFragments = arrayList;
            if (arrayList == null) {
                Intrinsics.throwNpe();
            }
            arrayList.addAll(list);
            int size = list.size();
            this.mNumberOfTabs = size;
            if (size <= 5) {
                return this;
            }
            throw new IllegalArgumentException("Number of root fragments cannot be greater than 5".toString());
        }

        public final RFGFragNavController build() {
            return new RFGFragNavController(this, this.mSavedInstanceState);
        }

        public final Builder defaultTransactionOptions(RFGFragNavTransactionOptions rFGFragNavTransactionOptions) {
            Intrinsics.checkParameterIsNotNull(rFGFragNavTransactionOptions, "transactionOptions");
            this.mDefaultTransactionOptions = rFGFragNavTransactionOptions;
            return this;
        }

        public final int getMContainerId() {
            return this.mContainerId;
        }

        public final RFGFragNavTransactionOptions getMDefaultTransactionOptions() {
            return this.mDefaultTransactionOptions;
        }

        public final FragmentManager getMFragmentManager() {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentManager");
            }
            return fragmentManager;
        }

        public final int getMNumberOfTabs() {
            return this.mNumberOfTabs;
        }

        public final RootFragmentListener getMRootFragmentListener() {
            RootFragmentListener rootFragmentListener = this.mRootFragmentListener;
            if (rootFragmentListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootFragmentListener");
            }
            return rootFragmentListener;
        }

        public final List<Fragment> getMRootFragments() {
            return this.mRootFragments;
        }

        public final int getMSelectedTabIndex() {
            return this.mSelectedTabIndex;
        }

        public final TransactionListener getMTransactionListener() {
            TransactionListener transactionListener = this.mTransactionListener;
            if (transactionListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTransactionListener");
            }
            return transactionListener;
        }

        public final Builder rootFragment(Fragment fragment) {
            Intrinsics.checkParameterIsNotNull(fragment, "rootFragment");
            ArrayList arrayList = new ArrayList();
            this.mRootFragments = arrayList;
            if (arrayList == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(fragment);
            this.mNumberOfTabs = 1;
            List<Fragment> list = this.mRootFragments;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            return rootFragments(list);
        }

        public final Builder rootFragmentListener(RootFragmentListener rootFragmentListener, int i) {
            Intrinsics.checkParameterIsNotNull(rootFragmentListener, "rootFragmentListener");
            this.mRootFragmentListener = rootFragmentListener;
            this.mNumberOfTabs = i;
            if (i <= 5) {
                return this;
            }
            throw new IllegalArgumentException("Number of tabs cannot be greater than 5".toString());
        }

        public final Builder selectedTabIndex(int i) {
            this.mSelectedTabIndex = i;
            if (this.mRootFragments == null || i <= this.mNumberOfTabs) {
                return this;
            }
            throw new IndexOutOfBoundsException("Starting index cannot be larger than the number of stacks");
        }

        public final void setMContainerId(int i) {
            this.mContainerId = i;
        }

        public final void setMDefaultTransactionOptions(RFGFragNavTransactionOptions rFGFragNavTransactionOptions) {
            this.mDefaultTransactionOptions = rFGFragNavTransactionOptions;
        }

        public final void setMFragmentManager(FragmentManager fragmentManager) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "<set-?>");
            this.mFragmentManager = fragmentManager;
        }

        public final void setMNumberOfTabs(int i) {
            this.mNumberOfTabs = i;
        }

        public final void setMRootFragmentListener(RootFragmentListener rootFragmentListener) {
            Intrinsics.checkParameterIsNotNull(rootFragmentListener, "<set-?>");
            this.mRootFragmentListener = rootFragmentListener;
        }

        public final void setMRootFragments(List<Fragment> list) {
            this.mRootFragments = list;
        }

        public final void setMSelectedTabIndex(int i) {
            this.mSelectedTabIndex = i;
        }

        public final void setMTransactionListener(TransactionListener transactionListener) {
            Intrinsics.checkParameterIsNotNull(transactionListener, "<set-?>");
            this.mTransactionListener = transactionListener;
        }

        public final Builder transactionListener(TransactionListener transactionListener) {
            Intrinsics.checkParameterIsNotNull(transactionListener, "val");
            this.mTransactionListener = transactionListener;
            return this;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavController$Companion;", "", "()V", "EXTRA_CURRENT_FRAGMENT", "", "EXTRA_FRAGMENT_STACK", "EXTRA_SELECTED_TAB_INDEX", "EXTRA_TAG_COUNT", "MAX_NUM_TABS", "", "NO_TAB", "TAB1", "TAB2", "TAB3", "TAB4", "TAB5", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavController$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionType;", "", "(Ljava/lang/String;I)V", "PUSH", "POP", "REPLACE", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavController$TransactionType */
    public enum TransactionType {
        PUSH,
        POP,
        REPLACE
    }

    static {
        Class<RFGFragNavController> cls = RFGFragNavController.class;
        EXTRA_TAG_COUNT = cls.getName() + ":EXTRA_TAG_COUNT";
        EXTRA_SELECTED_TAB_INDEX = cls.getName() + ":EXTRA_SELECTED_TAB_INDEX";
        EXTRA_CURRENT_FRAGMENT = cls.getName() + ":EXTRA_CURRENT_FRAGMENT";
        EXTRA_FRAGMENT_STACK = cls.getName() + ":EXTRA_FRAGMENT_STACK";
    }

    public RFGFragNavController() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RFGFragNavController(Builder builder, @Nullable Bundle bundle) {
        this();
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.mFragmentManager = builder.getMFragmentManager();
        this.mContainerId = builder.getMContainerId();
        this.mFragmentStacks = new ArrayList(builder.getMNumberOfTabs());
        this.mRootFragmentListener = builder.getMRootFragmentListener();
        this.mTransactionListener = builder.getMTransactionListener();
        this.mDefaultTransactionOptions = builder.getMDefaultTransactionOptions();
        this.mSelectedTabIndex = builder.getMSelectedTabIndex();
        if (!restoreFromBundle(bundle, builder.getMRootFragments())) {
            int mNumberOfTabs = builder.getMNumberOfTabs();
            for (int i = 0; i < mNumberOfTabs; i++) {
                Stack stack = new Stack();
                if (builder.getMRootFragments() != null) {
                    List<Fragment> mRootFragments = builder.getMRootFragments();
                    if (mRootFragments == null) {
                        Intrinsics.throwNpe();
                    }
                    stack.add(mRootFragments.get(i));
                }
                List<Stack<Fragment>> list = this.mFragmentStacks;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
                }
                list.add(stack);
            }
        }
    }

    private final void clearFragmentManager() {
        FragmentTransaction createTransactionWithOptions = createTransactionWithOptions((RFGFragNavTransactionOptions) null);
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentManager");
        }
        for (Fragment next : fragmentManager.getFragments()) {
            if (next != null) {
                createTransactionWithOptions.remove(next);
            }
        }
        createTransactionWithOptions.commit();
        executePendingTransactions();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void clearStack(@androidx.annotation.Nullable p043jp.reifrontier.gym.p044ui.tab.RFGFragNavTransactionOptions r7) {
        /*
            r6 = this;
            int r0 = r6.mSelectedTabIndex
            r1 = -1
            if (r0 != r1) goto L_0x0006
            return
        L_0x0006:
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r0 = r6.mFragmentStacks
            java.lang.String r1 = "mFragmentStacks"
            if (r0 != 0) goto L_0x000f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x000f:
            int r2 = r6.mSelectedTabIndex
            java.lang.Object r0 = r0.get(r2)
            java.util.Stack r0 = (java.util.Stack) r0
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x00bd
            androidx.fragment.app.FragmentTransaction r7 = r6.createTransactionWithOptions(r7)
        L_0x0022:
            int r2 = r0.size()
            if (r2 <= r3) goto L_0x004a
            androidx.fragment.app.FragmentManager r2 = r6.mFragmentManager
            if (r2 != 0) goto L_0x0031
            java.lang.String r4 = "mFragmentManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x0031:
            java.lang.Object r4 = r0.pop()
            java.lang.String r5 = "fragmentStack.pop()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            java.lang.String r4 = r4.getTag()
            androidx.fragment.app.Fragment r2 = r2.findFragmentByTag(r4)
            if (r2 == 0) goto L_0x0022
            r7.remove(r2)
            goto L_0x0022
        L_0x004a:
            androidx.fragment.app.Fragment r2 = r6.reattachPreviousFragment(r7)
            r4 = 0
            if (r2 == 0) goto L_0x0056
        L_0x0051:
            r7.commit()
            r3 = 0
            goto L_0x0083
        L_0x0056:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0071
            java.lang.Object r2 = r0.peek()
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            int r3 = r6.mContainerId
            if (r2 != 0) goto L_0x0069
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0069:
            java.lang.String r5 = r2.getTag()
            r7.add((int) r3, (androidx.fragment.app.Fragment) r2, (java.lang.String) r5)
            goto L_0x0051
        L_0x0071:
            int r2 = r6.mSelectedTabIndex
            androidx.fragment.app.Fragment r2 = r6.getRootFragment(r2)
            int r4 = r6.mContainerId
            java.lang.String r5 = r6.generateTag(r2)
            r7.add((int) r4, (androidx.fragment.app.Fragment) r2, (java.lang.String) r5)
            r7.commit()
        L_0x0083:
            r6.executePendingTransactions()
            if (r3 == 0) goto L_0x009a
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r7 = r6.mFragmentStacks
            if (r7 != 0) goto L_0x008f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x008f:
            int r3 = r6.mSelectedTabIndex
            java.lang.Object r7 = r7.get(r3)
            java.util.Stack r7 = (java.util.Stack) r7
            r7.push(r2)
        L_0x009a:
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r7 = r6.mFragmentStacks
            if (r7 != 0) goto L_0x00a1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00a1:
            int r1 = r6.mSelectedTabIndex
            r7.set(r1, r0)
            r6.mCurrentFrag = r2
            jp.reifrontier.gym.ui.tab.RFGFragNavController$TransactionListener r7 = r6.mTransactionListener
            if (r7 == 0) goto L_0x00bd
            if (r7 != 0) goto L_0x00b1
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00b1:
            androidx.fragment.app.Fragment r0 = r6.mCurrentFrag
            if (r0 != 0) goto L_0x00b8
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00b8:
            jp.reifrontier.gym.ui.tab.RFGFragNavController$TransactionType r1 = p043jp.reifrontier.gym.p044ui.tab.RFGFragNavController.TransactionType.POP
            r7.onFragmentTransaction(r0, r1)
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.p044ui.tab.RFGFragNavController.clearStack(jp.reifrontier.gym.ui.tab.RFGFragNavTransactionOptions):void");
    }

    @CheckResult
    private final FragmentTransaction createTransactionWithOptions(@Nullable RFGFragNavTransactionOptions rFGFragNavTransactionOptions) {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentManager");
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "mFragmentManager.beginTransaction()");
        if (rFGFragNavTransactionOptions == null) {
            rFGFragNavTransactionOptions = this.mDefaultTransactionOptions;
        }
        if (rFGFragNavTransactionOptions != null) {
            beginTransaction.setCustomAnimations(rFGFragNavTransactionOptions.getEnterAnimation(), rFGFragNavTransactionOptions.getExitAnimation(), rFGFragNavTransactionOptions.getPopEnterAnimation(), rFGFragNavTransactionOptions.getPopExitAnimation());
            beginTransaction.setTransitionStyle(rFGFragNavTransactionOptions.getTransitionStyle());
            beginTransaction.setTransition(rFGFragNavTransactionOptions.getTransition());
            for (Pair next : rFGFragNavTransactionOptions.getSharedElements()) {
                beginTransaction.addSharedElement((View) next.getFirst(), (String) next.getSecond());
            }
            beginTransaction.setBreadCrumbTitle((CharSequence) rFGFragNavTransactionOptions.getBreadCrumbTitle());
            beginTransaction.setBreadCrumbShortTitle((CharSequence) rFGFragNavTransactionOptions.getBreadCrumbShortTitle());
        }
        return beginTransaction;
    }

    private final void detachCurrentFragment(FragmentTransaction fragmentTransaction) {
        Fragment currentFrag = getCurrentFrag();
        if (currentFrag != null) {
            fragmentTransaction.detach(currentFrag);
        }
    }

    private final void executePendingTransactions() {
        if (!this.mExecutingTransaction) {
            this.mExecutingTransaction = true;
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentManager");
            }
            fragmentManager.executePendingTransactions();
            this.mExecutingTransaction = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r2 = (r2 = r2.get("param1")).toString();
     */
    @androidx.annotation.CheckResult
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String generateTag(androidx.fragment.app.Fragment r2) {
        /*
            r1 = this;
            android.os.Bundle r2 = r2.getArguments()
            if (r2 == 0) goto L_0x0015
            java.lang.String r0 = "param1"
            java.lang.Object r2 = r2.get(r0)
            if (r2 == 0) goto L_0x0015
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            java.lang.String r2 = ""
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.p044ui.tab.RFGFragNavController.generateTag(androidx.fragment.app.Fragment):java.lang.String");
    }

    @CheckResult
    @Nullable
    private final Stack<Fragment> getCurrentStack() {
        return getStack(this.mSelectedTabIndex);
    }

    @CheckResult
    private final Fragment getRootFragment(int i) throws IllegalStateException {
        Fragment fragment;
        List<Stack<Fragment>> list = this.mFragmentStacks;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
        }
        if (!list.get(i).isEmpty()) {
            List<Stack<Fragment>> list2 = this.mFragmentStacks;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
            }
            fragment = (Fragment) list2.get(i).peek();
        } else {
            RootFragmentListener rootFragmentListener = this.mRootFragmentListener;
            if (rootFragmentListener != null) {
                if (rootFragmentListener == null) {
                    Intrinsics.throwNpe();
                }
                fragment = rootFragmentListener.getRootFragment(i);
                if (this.mSelectedTabIndex != -1) {
                    List<Stack<Fragment>> list3 = this.mFragmentStacks;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
                    }
                    list3.get(this.mSelectedTabIndex).push(fragment);
                }
            } else {
                fragment = null;
            }
        }
        if (fragment != null) {
            return fragment;
        }
        throw new IllegalStateException("Either you haven't past in a fragment at this index in your constructor, or you haven't provided a way to create it while via your RootFragmentListener.getRootFragment(index)".toString());
    }

    @CheckResult
    @Nullable
    private final Stack<Fragment> getStack(int i) {
        if (i == -1) {
            return null;
        }
        List<Stack<Fragment>> list = this.mFragmentStacks;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
        }
        if (i < list.size()) {
            List<Stack<Fragment>> list2 = this.mFragmentStacks;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
            }
            Object clone = list2.get(i).clone();
            if (clone != null) {
                return (Stack) clone;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.Stack<androidx.fragment.app.Fragment>");
        }
        throw new IndexOutOfBoundsException("Can't get an index that's larger than we've setup");
    }

    private static /* synthetic */ void mSelectedTabIndex$annotations() {
    }

    private final void popFragment(@Nullable RFGFragNavTransactionOptions rFGFragNavTransactionOptions) throws UnsupportedOperationException {
        popFragments(1, rFGFragNavTransactionOptions);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void popFragments(int r8, @androidx.annotation.Nullable p043jp.reifrontier.gym.p044ui.tab.RFGFragNavTransactionOptions r9) throws java.lang.UnsupportedOperationException {
        /*
            r7 = this;
            boolean r0 = r7.isRootFragment()
            if (r0 != 0) goto L_0x00fa
            r0 = 1
            if (r8 < r0) goto L_0x00f2
            int r1 = r7.mSelectedTabIndex
            r2 = -1
            if (r1 == r2) goto L_0x00ea
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r1 = r7.mFragmentStacks
            java.lang.String r2 = "mFragmentStacks"
            if (r1 != 0) goto L_0x0017
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0017:
            int r3 = r7.mSelectedTabIndex
            java.lang.Object r1 = r1.get(r3)
            java.util.Stack r1 = (java.util.Stack) r1
            int r1 = r1.size()
            int r1 = r1 - r0
            if (r8 < r1) goto L_0x002a
            r7.clearStack(r9)
            return
        L_0x002a:
            androidx.fragment.app.FragmentTransaction r9 = r7.createTransactionWithOptions(r9)
            r1 = 0
            r3 = 0
        L_0x0030:
            if (r3 >= r8) goto L_0x0065
            androidx.fragment.app.FragmentManager r4 = r7.mFragmentManager
            if (r4 != 0) goto L_0x003b
            java.lang.String r5 = "mFragmentManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x003b:
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r5 = r7.mFragmentStacks
            if (r5 != 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0042:
            int r6 = r7.mSelectedTabIndex
            java.lang.Object r5 = r5.get(r6)
            java.util.Stack r5 = (java.util.Stack) r5
            java.lang.Object r5 = r5.pop()
            java.lang.String r6 = "mFragmentStacks[mSelectedTabIndex].pop()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            java.lang.String r5 = r5.getTag()
            androidx.fragment.app.Fragment r4 = r4.findFragmentByTag(r5)
            if (r4 == 0) goto L_0x0062
            r9.remove(r4)
        L_0x0062:
            int r3 = r3 + 1
            goto L_0x0030
        L_0x0065:
            androidx.fragment.app.Fragment r8 = r7.reattachPreviousFragment(r9)
            if (r8 == 0) goto L_0x0070
        L_0x006b:
            r9.commit()
            r0 = 0
            goto L_0x00bb
        L_0x0070:
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r8 = r7.mFragmentStacks
            if (r8 != 0) goto L_0x0077
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0077:
            int r3 = r7.mSelectedTabIndex
            java.lang.Object r8 = r8.get(r3)
            java.util.Stack r8 = (java.util.Stack) r8
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x00a9
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r8 = r7.mFragmentStacks
            if (r8 != 0) goto L_0x008c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x008c:
            int r0 = r7.mSelectedTabIndex
            java.lang.Object r8 = r8.get(r0)
            java.util.Stack r8 = (java.util.Stack) r8
            java.lang.Object r8 = r8.peek()
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            int r0 = r7.mContainerId
            if (r8 != 0) goto L_0x00a1
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00a1:
            java.lang.String r3 = r8.getTag()
            r9.add((int) r0, (androidx.fragment.app.Fragment) r8, (java.lang.String) r3)
            goto L_0x006b
        L_0x00a9:
            int r8 = r7.mSelectedTabIndex
            androidx.fragment.app.Fragment r8 = r7.getRootFragment(r8)
            int r1 = r7.mContainerId
            java.lang.String r3 = r7.generateTag(r8)
            r9.add((int) r1, (androidx.fragment.app.Fragment) r8, (java.lang.String) r3)
            r9.commit()
        L_0x00bb:
            r7.executePendingTransactions()
            if (r0 == 0) goto L_0x00d2
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r9 = r7.mFragmentStacks
            if (r9 != 0) goto L_0x00c7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x00c7:
            int r0 = r7.mSelectedTabIndex
            java.lang.Object r9 = r9.get(r0)
            java.util.Stack r9 = (java.util.Stack) r9
            r9.push(r8)
        L_0x00d2:
            r7.mCurrentFrag = r8
            jp.reifrontier.gym.ui.tab.RFGFragNavController$TransactionListener r8 = r7.mTransactionListener
            if (r8 == 0) goto L_0x00e9
            if (r8 != 0) goto L_0x00dd
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00dd:
            androidx.fragment.app.Fragment r9 = r7.mCurrentFrag
            if (r9 != 0) goto L_0x00e4
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00e4:
            jp.reifrontier.gym.ui.tab.RFGFragNavController$TransactionType r0 = p043jp.reifrontier.gym.p044ui.tab.RFGFragNavController.TransactionType.POP
            r8.onFragmentTransaction(r9, r0)
        L_0x00e9:
            return
        L_0x00ea:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException
            java.lang.String r9 = "You can not pop fragments when no tab is selected"
            r8.<init>(r9)
            throw r8
        L_0x00f2:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException
            java.lang.String r9 = "popFragments parameter needs to be greater than 0"
            r8.<init>(r9)
            throw r8
        L_0x00fa:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException
            java.lang.String r9 = "You can not popFragment the rootFragment. If you need to change this fragment, use replaceFragment(fragment)"
            r8.<init>(r9)
            goto L_0x0103
        L_0x0102:
            throw r8
        L_0x0103:
            goto L_0x0102
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.p044ui.tab.RFGFragNavController.popFragments(int, jp.reifrontier.gym.ui.tab.RFGFragNavTransactionOptions):void");
    }

    private final void pushFragment(@Nullable Fragment fragment, @Nullable RFGFragNavTransactionOptions rFGFragNavTransactionOptions) {
        if (fragment != null && this.mSelectedTabIndex != -1) {
            FragmentTransaction createTransactionWithOptions = createTransactionWithOptions(rFGFragNavTransactionOptions);
            detachCurrentFragment(createTransactionWithOptions);
            createTransactionWithOptions.add(this.mContainerId, fragment, generateTag(fragment));
            createTransactionWithOptions.commit();
            executePendingTransactions();
            List<Stack<Fragment>> list = this.mFragmentStacks;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
            }
            list.get(this.mSelectedTabIndex).push(fragment);
            this.mCurrentFrag = fragment;
            TransactionListener transactionListener = this.mTransactionListener;
            if (transactionListener != null) {
                if (transactionListener == null) {
                    Intrinsics.throwNpe();
                }
                Fragment fragment2 = this.mCurrentFrag;
                if (fragment2 == null) {
                    Intrinsics.throwNpe();
                }
                transactionListener.onFragmentTransaction(fragment2, TransactionType.PUSH);
            }
        }
    }

    @Nullable
    private final Fragment reattachPreviousFragment(FragmentTransaction fragmentTransaction) {
        List<Stack<Fragment>> list = this.mFragmentStacks;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
        }
        Stack stack = list.get(this.mSelectedTabIndex);
        Fragment fragment = null;
        if (!stack.isEmpty()) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentManager");
            }
            Object peek = stack.peek();
            Intrinsics.checkExpressionValueIsNotNull(peek, "fragmentStack.peek()");
            fragment = fragmentManager.findFragmentByTag(((Fragment) peek).getTag());
            if (fragment != null) {
                fragmentTransaction.attach(fragment);
            }
        }
        return fragment;
    }

    private final void replaceFragment(Fragment fragment, @Nullable RFGFragNavTransactionOptions rFGFragNavTransactionOptions) {
        if (getCurrentFrag() != null) {
            FragmentTransaction createTransactionWithOptions = createTransactionWithOptions(rFGFragNavTransactionOptions);
            List<Stack<Fragment>> list = this.mFragmentStacks;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
            }
            Stack stack = list.get(this.mSelectedTabIndex);
            if (!stack.isEmpty()) {
                stack.pop();
            }
            createTransactionWithOptions.replace(this.mContainerId, fragment, generateTag(fragment));
            createTransactionWithOptions.commit();
            executePendingTransactions();
            stack.push(fragment);
            this.mCurrentFrag = fragment;
            TransactionListener transactionListener = this.mTransactionListener;
            if (transactionListener != null) {
                if (transactionListener == null) {
                    Intrinsics.throwNpe();
                }
                Fragment fragment2 = this.mCurrentFrag;
                if (fragment2 == null) {
                    Intrinsics.throwNpe();
                }
                transactionListener.onFragmentTransaction(fragment2, TransactionType.REPLACE);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d A[Catch:{ all -> 0x00c6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean restoreFromBundle(@androidx.annotation.Nullable android.os.Bundle r14, @androidx.annotation.Nullable java.util.List<? extends androidx.fragment.app.Fragment> r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = EXTRA_TAG_COUNT
            int r1 = r14.getInt(r1, r0)
            r13.mTagCount = r1
            androidx.fragment.app.FragmentManager r1 = r13.mFragmentManager
            java.lang.String r2 = "mFragmentManager"
            if (r1 != 0) goto L_0x0015
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0015:
            java.lang.String r3 = EXTRA_CURRENT_FRAGMENT
            java.lang.String r3 = r14.getString(r3)
            androidx.fragment.app.Fragment r1 = r1.findFragmentByTag(r3)
            r13.mCurrentFrag = r1
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = EXTRA_FRAGMENT_STACK     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = r14.getString(r3)     // Catch:{ all -> 0x00c6 }
            r1.<init>(r3)     // Catch:{ all -> 0x00c6 }
            int r3 = r1.length()     // Catch:{ all -> 0x00c6 }
            r4 = 0
        L_0x0031:
            r5 = 1
            if (r4 >= r3) goto L_0x00a6
            org.json.JSONArray r6 = r1.getJSONArray(r4)     // Catch:{ all -> 0x00c6 }
            java.util.Stack r7 = new java.util.Stack     // Catch:{ all -> 0x00c6 }
            r7.<init>()     // Catch:{ all -> 0x00c6 }
            int r8 = r6.length()     // Catch:{ all -> 0x00c6 }
            java.lang.String r9 = "null"
            if (r8 != r5) goto L_0x0071
            java.lang.String r6 = r6.getString(r0)     // Catch:{ all -> 0x00c6 }
            if (r6 == 0) goto L_0x005e
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r6, r5)     // Catch:{ all -> 0x00c6 }
            if (r5 == 0) goto L_0x0052
            goto L_0x005e
        L_0x0052:
            androidx.fragment.app.FragmentManager r5 = r13.mFragmentManager     // Catch:{ all -> 0x00c6 }
            if (r5 != 0) goto L_0x0059
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch:{ all -> 0x00c6 }
        L_0x0059:
            androidx.fragment.app.Fragment r5 = r5.findFragmentByTag(r6)     // Catch:{ all -> 0x00c6 }
            goto L_0x006b
        L_0x005e:
            if (r15 == 0) goto L_0x0067
            java.lang.Object r5 = r15.get(r4)     // Catch:{ all -> 0x00c6 }
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5     // Catch:{ all -> 0x00c6 }
            goto L_0x006b
        L_0x0067:
            androidx.fragment.app.Fragment r5 = r13.getRootFragment(r4)     // Catch:{ all -> 0x00c6 }
        L_0x006b:
            if (r5 == 0) goto L_0x0097
            r7.add(r5)     // Catch:{ all -> 0x00c6 }
            goto L_0x0097
        L_0x0071:
            int r8 = r6.length()     // Catch:{ all -> 0x00c6 }
            r10 = 0
        L_0x0076:
            if (r10 >= r8) goto L_0x0097
            java.lang.String r11 = r6.getString(r10)     // Catch:{ all -> 0x00c6 }
            if (r11 == 0) goto L_0x0094
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r11, r5)     // Catch:{ all -> 0x00c6 }
            if (r12 != 0) goto L_0x0094
            androidx.fragment.app.FragmentManager r12 = r13.mFragmentManager     // Catch:{ all -> 0x00c6 }
            if (r12 != 0) goto L_0x008b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch:{ all -> 0x00c6 }
        L_0x008b:
            androidx.fragment.app.Fragment r11 = r12.findFragmentByTag(r11)     // Catch:{ all -> 0x00c6 }
            if (r11 == 0) goto L_0x0094
            r7.add(r11)     // Catch:{ all -> 0x00c6 }
        L_0x0094:
            int r10 = r10 + 1
            goto L_0x0076
        L_0x0097:
            java.util.List<java.util.Stack<androidx.fragment.app.Fragment>> r5 = r13.mFragmentStacks     // Catch:{ all -> 0x00c6 }
            if (r5 != 0) goto L_0x00a0
            java.lang.String r6 = "mFragmentStacks"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)     // Catch:{ all -> 0x00c6 }
        L_0x00a0:
            r5.add(r7)     // Catch:{ all -> 0x00c6 }
            int r4 = r4 + 1
            goto L_0x0031
        L_0x00a6:
            java.lang.String r15 = EXTRA_SELECTED_TAB_INDEX     // Catch:{ all -> 0x00c6 }
            int r14 = r14.getInt(r15)     // Catch:{ all -> 0x00c6 }
            if (r14 == 0) goto L_0x00c2
            if (r14 == r5) goto L_0x00be
            r15 = 2
            if (r14 == r15) goto L_0x00ba
            r15 = 3
            if (r14 == r15) goto L_0x00ba
            r15 = 4
            if (r14 == r15) goto L_0x00ba
            goto L_0x00c5
        L_0x00ba:
            r13.switchTab(r15)     // Catch:{ all -> 0x00c6 }
            goto L_0x00c5
        L_0x00be:
            r13.switchTab(r5)     // Catch:{ all -> 0x00c6 }
            goto L_0x00c5
        L_0x00c2:
            r13.switchTab(r0)     // Catch:{ all -> 0x00c6 }
        L_0x00c5:
            return r5
        L_0x00c6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.p044ui.tab.RFGFragNavController.restoreFromBundle(android.os.Bundle, java.util.List):boolean");
    }

    private final void switchTab(int i, @Nullable RFGFragNavTransactionOptions rFGFragNavTransactionOptions) throws IndexOutOfBoundsException {
        List<Stack<Fragment>> list = this.mFragmentStacks;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
        }
        if (i >= list.size()) {
            StringBuilder b = C0681a.m338b("Can't switch to a tab that hasn't been initialized, Index : ", i, ", current stack size : ");
            List<Stack<Fragment>> list2 = this.mFragmentStacks;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
            }
            b.append(list2.size());
            b.append(". Make sure to create all of the tabs you need in the Constructor or provide a way for them to be created via RootFragmentListener.");
            throw new IndexOutOfBoundsException(b.toString());
        } else if (this.mSelectedTabIndex != i) {
            this.mSelectedTabIndex = i;
            FragmentTransaction createTransactionWithOptions = createTransactionWithOptions(rFGFragNavTransactionOptions);
            detachCurrentFragment(createTransactionWithOptions);
            Fragment fragment = null;
            if (i != -1 && (fragment = reattachPreviousFragment(createTransactionWithOptions)) == null) {
                fragment = getRootFragment(this.mSelectedTabIndex);
                createTransactionWithOptions.add(this.mContainerId, fragment, generateTag(fragment));
            }
            createTransactionWithOptions.commit();
            executePendingTransactions();
            this.mCurrentFrag = fragment;
            TransactionListener transactionListener = this.mTransactionListener;
            if (transactionListener != null) {
                if (transactionListener == null) {
                    Intrinsics.throwNpe();
                }
                Fragment fragment2 = this.mCurrentFrag;
                if (fragment2 == null) {
                    Intrinsics.throwNpe();
                }
                transactionListener.onTabTransaction(fragment2, this.mSelectedTabIndex);
            }
        }
    }

    public final void clearStack() {
        clearStack((RFGFragNavTransactionOptions) null);
    }

    @CheckResult
    @Nullable
    public final Fragment getCurrentFrag() {
        Fragment fragment = this.mCurrentFrag;
        if (fragment != null) {
            return fragment;
        }
        if (this.mSelectedTabIndex == -1) {
            return null;
        }
        List<Stack<Fragment>> list = this.mFragmentStacks;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
        }
        if (!list.get(this.mSelectedTabIndex).isEmpty()) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentManager");
            }
            List<Stack<Fragment>> list2 = this.mFragmentStacks;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
            }
            Object peek = list2.get(this.mSelectedTabIndex).peek();
            Intrinsics.checkExpressionValueIsNotNull(peek, "mFragmentStacks[mSelectedTabIndex].peek()");
            this.mCurrentFrag = fragmentManager.findFragmentByTag(((Fragment) peek).getTag());
        }
        return this.mCurrentFrag;
    }

    @CheckResult
    public final int getCurrentStackIndex() {
        return this.mSelectedTabIndex;
    }

    @CheckResult
    public final int getSize() {
        List<Stack<Fragment>> list = this.mFragmentStacks;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
        }
        return list.size();
    }

    public final void initialize(int i) {
        this.mSelectedTabIndex = i;
        List<Stack<Fragment>> list = this.mFragmentStacks;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
        }
        if (i <= list.size()) {
            this.mSelectedTabIndex = i;
            clearFragmentManager();
            if (i != -1) {
                FragmentTransaction createTransactionWithOptions = createTransactionWithOptions((RFGFragNavTransactionOptions) null);
                Fragment rootFragment = getRootFragment(i);
                createTransactionWithOptions.add(this.mContainerId, rootFragment, generateTag(rootFragment));
                createTransactionWithOptions.commit();
                executePendingTransactions();
                this.mCurrentFrag = rootFragment;
                TransactionListener transactionListener = this.mTransactionListener;
                if (transactionListener != null) {
                    if (transactionListener == null) {
                        Intrinsics.throwNpe();
                    }
                    Fragment fragment = this.mCurrentFrag;
                    if (fragment == null) {
                        Intrinsics.throwNpe();
                    }
                    transactionListener.onTabTransaction(fragment, this.mSelectedTabIndex);
                    return;
                }
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException("Starting index cannot be larger than the number of stacks");
    }

    @CheckResult
    public final boolean isRootFragment() {
        Stack<Fragment> currentStack = getCurrentStack();
        return currentStack == null || currentStack.size() == 1;
    }

    public final Builder newBuilder(@Nullable Bundle bundle, FragmentManager fragmentManager, int i) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
        return new Builder(this, bundle, fragmentManager, i);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        bundle.putInt(EXTRA_TAG_COUNT, this.mTagCount);
        bundle.putInt(EXTRA_SELECTED_TAB_INDEX, this.mSelectedTabIndex);
        Fragment fragment = this.mCurrentFrag;
        if (fragment != null) {
            String str = EXTRA_CURRENT_FRAGMENT;
            if (fragment == null) {
                Intrinsics.throwNpe();
            }
            bundle.putString(str, fragment.getTag());
        }
        try {
            JSONArray jSONArray = new JSONArray();
            List<Stack<Fragment>> list = this.mFragmentStacks;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragmentStacks");
            }
            for (Stack<Fragment> it : list) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    Fragment fragment2 = (Fragment) it2.next();
                    Intrinsics.checkExpressionValueIsNotNull(fragment2, "fragment");
                    jSONArray2.put(fragment2.getTag());
                }
                jSONArray.put(jSONArray2);
            }
            bundle.putString(EXTRA_FRAGMENT_STACK, jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public final void popFragment() throws UnsupportedOperationException {
        popFragment((RFGFragNavTransactionOptions) null);
    }

    public final void popFragments(int i) throws UnsupportedOperationException {
        popFragments(i, (RFGFragNavTransactionOptions) null);
    }

    public final void pushFragment(@Nullable Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        pushFragment(fragment, (RFGFragNavTransactionOptions) null);
    }

    public final void replaceFragment(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        replaceFragment(fragment, (RFGFragNavTransactionOptions) null);
    }

    public final void switchTab(int i) throws IndexOutOfBoundsException {
        switchTab(i, (RFGFragNavTransactionOptions) null);
    }
}
