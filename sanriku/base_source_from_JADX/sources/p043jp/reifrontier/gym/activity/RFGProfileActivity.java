package p043jp.reifrontier.gym.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.fragment.RFGProfileFragment;
import p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ljp/reifrontier/gym/fragment/RFGProfileFragment$OnProfileListener;", "()V", "isLoading", "", "menu", "Landroid/view/Menu;", "profileFragment", "Ljp/reifrontier/gym/fragment/RFGProfileFragment;", "gotoEdit", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onStartLoading", "onStopLoading", "onTerminate", "setUpToolbar", "showHandleName", "handleName", "", "startLoading", "stopLoading", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGProfileActivity */
public final class RFGProfileActivity extends AppCompatActivity implements RFGProfileFragment.OnProfileListener {
    private HashMap _$_findViewCache;
    private boolean isLoading;
    private Menu menu;
    private RFGProfileFragment profileFragment;

    private final void gotoEdit() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "200", "200g", (String) null, 4, (Object) null);
        startActivity(new Intent(this, RFGEditActivity.class));
    }

    private final void setUpToolbar() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
            supportActionBar.setHomeAsUpIndicator((int) R.mipmap.back);
        }
    }

    private final void startLoading() {
        this.isLoading = true;
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.indicatorCover);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "indicatorCover");
        constraintLayout.setVisibility(0);
        ((RFGLoadingIndicator) _$_findCachedViewById(C2092R.C2094id.indicator)).smoothToShow();
    }

    private final void stopLoading() {
        this.isLoading = false;
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.indicatorCover);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "indicatorCover");
        constraintLayout.setVisibility(8);
        ((RFGLoadingIndicator) _$_findCachedViewById(C2092R.C2094id.indicator)).smoothToHide();
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_profile);
        setUpToolbar();
        this.profileFragment = RFGProfileFragment.Companion.newInstance();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "supportFragmentManager.beginTransaction()");
        RFGProfileFragment rFGProfileFragment = this.profileFragment;
        if (rFGProfileFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileFragment");
        }
        beginTransaction.add((int) R.id.content_frame, (Fragment) rFGProfileFragment);
        beginTransaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        if (menu2 == null) {
            Intrinsics.throwNpe();
        }
        this.menu = menu2;
        getMenuInflater().inflate(R.menu.main, menu2);
        menu2.setGroupVisible(R.id.edit, true);
        menu2.setGroupVisible(R.id.setting, false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.start_edit) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            gotoEdit();
            return true;
        }
    }

    public void onStartLoading() {
        startLoading();
    }

    public void onStopLoading() {
        stopLoading();
    }

    public void onTerminate() {
        onBackPressed();
    }

    public void showHandleName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "handleName");
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "it");
            supportActionBar.setTitle((CharSequence) str);
        }
    }
}
