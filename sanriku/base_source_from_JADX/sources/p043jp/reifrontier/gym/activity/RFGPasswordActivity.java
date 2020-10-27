package p043jp.reifrontier.gym.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import org.greenrobot.eventbus.ThreadMode;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.bus.RFGUpdatePassword;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;
import p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator;
import p043jp.reifrontier.gym.util.GymUtils;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0014J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u000eH\u0014J\b\u0010 \u001a\u00020\u000eH\u0014J\b\u0010!\u001a\u00020\u000eH\u0003J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006%"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGPasswordActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "isLoading", "", "mRealm", "Lio/realm/Realm;", "user", "Ljp/reifrontier/gym/domain/api/RFGUser;", "getUser", "()Ljp/reifrontier/gym/domain/api/RFGUser;", "setUser", "(Ljp/reifrontier/gym/domain/api/RFGUser;)V", "closeKeyboard", "", "errorDialog", "message", "", "finishEdit", "okDialog", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onReceiveUpdate", "connect", "Ljp/reifrontier/gym/data/bus/RFGUpdatePassword;", "onResume", "onStart", "requestResetPassword", "setup", "startLoading", "stopLoading", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGPasswordActivity */
public final class RFGPasswordActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean isLoading;
    private Realm mRealm;
    private RFGUser user;

    /* access modifiers changed from: private */
    public final void closeKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    /* access modifiers changed from: private */
    public final void errorDialog(String str) {
        RFGErrorDialog.Companion.newInstance$default(RFGErrorDialog.Companion, (String) null, str, 1, (Object) null).show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    /* access modifiers changed from: private */
    public final void finishEdit() {
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.passwordCurrent);
        Intrinsics.checkExpressionValueIsNotNull(editText, "passwordCurrent");
        String replace = new Regex("[ 　\\s]").replace((CharSequence) editText.getText().toString(), "");
        EditText editText2 = (EditText) _$_findCachedViewById(C2092R.C2094id.password1);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "password1");
        String replace2 = new Regex("[ 　\\s]").replace((CharSequence) editText2.getText().toString(), "");
        EditText editText3 = (EditText) _$_findCachedViewById(C2092R.C2094id.password2);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "password2");
        String replace3 = new Regex("[ 　\\s]").replace((CharSequence) editText3.getText().toString(), "");
        if (!GymUtils.INSTANCE.validatePassword(replace)) {
            errorDialog("現在のパスワードは英数字8文字以上で入力してください");
        } else if (!GymUtils.INSTANCE.validatePassword(replace2)) {
            errorDialog("新しいパスワードは英数字8文字以上で入力してください");
        } else if (!Intrinsics.areEqual((Object) replace2, (Object) replace3)) {
            errorDialog("新しいパスワードの入力が一致しません");
        } else if (!SilentLogOperation.Companion.getInstance().getInternalOperation().isValidPassword(replace)) {
            errorDialog("現在のパスワードが異なります");
        } else {
            startLoading();
            SilentLogInternalOperation internalOperation = SilentLogOperation.Companion.getInstance().getInternalOperation();
            RFGUser rFGUser = this.user;
            if (rFGUser == null) {
                Intrinsics.throwNpe();
            }
            internalOperation.updatePassword(replace2, rFGUser.getEmail());
        }
    }

    private final void okDialog(String str) {
        RFGErrorDialog.Companion.newInstance("変更完了", str).show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestResetPassword() {
        startLoading();
        StringBuilder a = C0681a.m330a("QcwR8KOwKczQTqUhq8oQFQXRNz2O4L3RXy_");
        RFGUser rFGUser = this.user;
        if (rFGUser == null) {
            Intrinsics.throwNpe();
        }
        a.append(rFGUser.getEmail());
        RFGH2Client.Companion.getINSTANCE().resetPass(a.toString()).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGPasswordActivity$requestResetPassword$1(this), new RFGPasswordActivity$requestResetPassword$2(this));
    }

    private final void setup() {
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.passwordCurrent);
        Intrinsics.checkExpressionValueIsNotNull(editText, "passwordCurrent");
        Drawable background = editText.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background, "passwordCurrent.background");
        background.setAlpha(0);
        EditText editText2 = (EditText) _$_findCachedViewById(C2092R.C2094id.password1);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "password1");
        Drawable background2 = editText2.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background2, "password1.background");
        background2.setAlpha(0);
        EditText editText3 = (EditText) _$_findCachedViewById(C2092R.C2094id.password2);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "password2");
        Drawable background3 = editText3.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background3, "password2.background");
        background3.setAlpha(0);
        ((Button) _$_findCachedViewById(C2092R.C2094id.buttonPassword)).setOnClickListener(new RFGPasswordActivity$setup$1(this));
        ((TextView) _$_findCachedViewById(C2092R.C2094id.textForgetPassword)).setOnClickListener(new RFGPasswordActivity$setup$2(this));
    }

    private final void startLoading() {
        this.isLoading = true;
        closeKeyboard();
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.indicatorCover);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "indicatorCover");
        constraintLayout.setVisibility(0);
        ((RFGLoadingIndicator) _$_findCachedViewById(C2092R.C2094id.indicator)).smoothToShow();
    }

    /* access modifiers changed from: private */
    public final void stopLoading() {
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

    public final RFGUser getUser() {
        return this.user;
    }

    public void onBackPressed() {
        if (!this.isLoading) {
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "403", "403b", (String) null, 4, (Object) null);
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_password);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar));
        Realm defaultInstance = Realm.getDefaultInstance();
        this.mRealm = defaultInstance;
        if (defaultInstance == null) {
            Intrinsics.throwNpe();
        }
        this.user = (RFGUser) defaultInstance.where(RFGUser.class).findFirst();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
        supportActionBar.setTitle((CharSequence) "パスワードを変更");
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar2.setDisplayHomeAsUpEnabled(true);
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar3.setDisplayShowHomeEnabled(true);
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar4.setHomeAsUpIndicator((int) R.mipmap.back);
        setup();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Realm realm = this.mRealm;
        if (realm != null) {
            realm.close();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            Intrinsics.throwNpe();
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @C1129m(threadMode = ThreadMode.MAIN)
    public final void onReceiveUpdate(RFGUpdatePassword rFGUpdatePassword) {
        Intrinsics.checkParameterIsNotNull(rFGUpdatePassword, "connect");
        boolean connect = rFGUpdatePassword.getConnect();
        stopLoading();
        if (connect) {
            okDialog("パスワードを変更しました");
        } else {
            errorDialog("パスワードを変更できませんでした");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        RFGAnalyticsManager.INSTANCE.sendScreen("403");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        C1126c.m1638c().mo21908c(this);
        C1126c.m1638c().mo21907b(this);
    }

    public final void setUser(RFGUser rFGUser) {
        this.user = rFGUser;
    }
}
