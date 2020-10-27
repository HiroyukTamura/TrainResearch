package p043jp.reifrontier.gym.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0004J\b\u0010\u0013\u001a\u00020\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0004J\b\u0010%\u001a\u00020\u000eH&J\u001e\u0010&\u001a\u00020\u00162\b\b\u0001\u0010'\u001a\u00020\u00142\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010(H\u0004J\b\u0010)\u001a\u00020\u0016H\u0004J\b\u0010*\u001a\u00020\u0016H\u0004J\b\u0010+\u001a\u00020\u0016H\u0004J\u0012\u0010,\u001a\u00020\u00162\b\b\u0001\u0010'\u001a\u00020\u0014H\u0004R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006."}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGFragmentBase;", "Landroidx/fragment/app/Fragment;", "()V", "<set-?>", "", "isLoading", "()Z", "listener", "Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "getListener", "()Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "setListener", "(Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;)V", "actionBarTitle", "", "fragmentType", "Ljp/reifrontier/gym/RFGDef$FragType;", "getImageUrl", "baseUrl", "layoutId", "", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onResume", "onStart", "refreshActionBarTitle", "screenId", "showErrorDialog", "resourceId", "Ljp/reifrontier/gym/ui/dialog/RFGErrorDialog$ErrorDialogListener;", "startLoading", "stopLoading", "terminate", "terminateWithMessage", "OnFragmentBaseListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.RFGFragmentBase */
public abstract class RFGFragmentBase extends Fragment {
    private HashMap _$_findViewCache;
    private boolean isLoading;
    private OnFragmentBaseListener listener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "", "onStart", "", "type", "Ljp/reifrontier/gym/RFGDef$FragType;", "title", "", "onStartLoading", "onStopLoading", "onTerminate", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGFragmentBase$OnFragmentBaseListener */
    public interface OnFragmentBaseListener {
        void onStart(RFGDef.FragType fragType, String str);

        void onStartLoading();

        void onStopLoading();

        void onTerminate();
    }

    public static /* synthetic */ void showErrorDialog$default(RFGFragmentBase rFGFragmentBase, int i, RFGErrorDialog.ErrorDialogListener errorDialogListener, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                errorDialogListener = null;
            }
            rFGFragmentBase.showErrorDialog(i, errorDialogListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorDialog");
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

    public abstract String actionBarTitle();

    public abstract RFGDef.FragType fragmentType();

    /* access modifiers changed from: protected */
    public final String getImageUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "baseUrl");
        return C0681a.m321a(str, RFGDef.IMAGE_URL_SUFFIX, RFLSharedHolder.INSTANCE.accessToken());
    }

    /* access modifiers changed from: protected */
    public final OnFragmentBaseListener getListener() {
        return this.listener;
    }

    /* access modifiers changed from: protected */
    public final boolean isLoading() {
        return this.isLoading;
    }

    @LayoutRes
    public abstract int layoutId();

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnFragmentBaseListener) {
            this.listener = (OnFragmentBaseListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentBaseListener");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(layoutId(), viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    public void onResume() {
        super.onResume();
        RFGAnalyticsManager.INSTANCE.sendScreen(screenId());
    }

    public void onStart() {
        super.onStart();
        refreshActionBarTitle();
    }

    /* access modifiers changed from: protected */
    public final void refreshActionBarTitle() {
        OnFragmentBaseListener onFragmentBaseListener = this.listener;
        if (onFragmentBaseListener != null) {
            onFragmentBaseListener.onStart(fragmentType(), actionBarTitle());
        }
    }

    public abstract String screenId();

    /* access modifiers changed from: protected */
    public final void setListener(OnFragmentBaseListener onFragmentBaseListener) {
        this.listener = onFragmentBaseListener;
    }

    /* access modifiers changed from: protected */
    public final void showErrorDialog(@StringRes int i, RFGErrorDialog.ErrorDialogListener errorDialogListener) {
        RFGErrorDialog.Companion companion = RFGErrorDialog.Companion;
        String string = getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(resourceId)");
        RFGErrorDialog newInstance$default = RFGErrorDialog.Companion.newInstance$default(companion, (String) null, string, 1, (Object) null);
        if (errorDialogListener != null) {
            newInstance$default.setListener(errorDialogListener);
        }
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            newInstance$default.show(fragmentManager, RFGErrorDialog.Companion.getTAG());
        }
    }

    /* access modifiers changed from: protected */
    public final void startLoading() {
        this.isLoading = true;
        OnFragmentBaseListener onFragmentBaseListener = this.listener;
        if (onFragmentBaseListener != null) {
            onFragmentBaseListener.onStartLoading();
        }
    }

    /* access modifiers changed from: protected */
    public final void stopLoading() {
        OnFragmentBaseListener onFragmentBaseListener = this.listener;
        if (onFragmentBaseListener != null) {
            onFragmentBaseListener.onStopLoading();
        }
        this.isLoading = false;
    }

    /* access modifiers changed from: protected */
    public final void terminate() {
        OnFragmentBaseListener onFragmentBaseListener = this.listener;
        if (onFragmentBaseListener != null) {
            onFragmentBaseListener.onTerminate();
        }
    }

    /* access modifiers changed from: protected */
    public final void terminateWithMessage(@StringRes int i) {
        showErrorDialog(i, new RFGFragmentBase$terminateWithMessage$1(this));
    }
}
