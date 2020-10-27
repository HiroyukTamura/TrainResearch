package p043jp.reifrontier.gym.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
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
import p041io.realm.Realm;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;
import p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator;
import p043jp.reifrontier.gym.util.GymUtils;
import p043jp.reifrontier.sanriku.R;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0014J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0014J,\u0010\u001f\u001a\u00020\u000e2\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110!j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\"H\u0003J\b\u0010#\u001a\u00020\u000eH\u0003J\b\u0010$\u001a\u00020\u000eH\u0002J\b\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J$\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110!j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006("}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGMailInfoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "isLoading", "", "mRealm", "Lio/realm/Realm;", "user", "Ljp/reifrontier/gym/domain/api/RFGUser;", "getUser", "()Ljp/reifrontier/gym/domain/api/RFGUser;", "setUser", "(Ljp/reifrontier/gym/domain/api/RFGUser;)V", "closeKeyboard", "", "errorDialog", "message", "", "finishEdit", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "requestUpdate", "data", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "requestUser", "setupMail", "startLoading", "stopLoading", "updateParam", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMailInfoActivity */
public final class RFGMailInfoActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean isLoading;
    /* access modifiers changed from: private */
    public Realm mRealm;
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
        HashMap<String, String> updateParam = updateParam();
        if (updateParam.size() > 0) {
            String str = updateParam.get("username");
            if (str == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(str, "data[\"username\"]!!");
            if (!GymUtils.INSTANCE.validateEmail(str)) {
                errorDialog("正しい形式のメールアドレスを入力してください");
                return;
            }
            this.isLoading = true;
            startLoading();
            requestUpdate(updateParam);
            return;
        }
        onBackPressed();
    }

    @SuppressLint({"CheckResult"})
    private final void requestUpdate(HashMap<String, String> hashMap) {
        String str = hashMap.get("username");
        if (str == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "data[\"username\"]!!");
        C1714r<RFGH2Client.H2APIResponse> b = RFGH2Client.Companion.getINSTANCE().updateUser(hashMap).mo27434b(C1683a.m2378b());
        Intrinsics.checkExpressionValueIsNotNull(b, "RFGH2Client.INSTANCE.upd…scribeOn(Schedulers.io())");
        b.mo27429a(C1721a.m2428a()).mo27432a(new RFGMailInfoActivity$requestUpdate$1(this, str), new RFGMailInfoActivity$requestUpdate$2(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUser() {
        RFGH2Client.Companion.getINSTANCE().userInfo().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMailInfoActivity$requestUser$1(this), RFGMailInfoActivity$requestUser$2.INSTANCE);
    }

    private final void setupMail() {
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.loginEmail);
        Intrinsics.checkExpressionValueIsNotNull(editText, "loginEmail");
        Drawable background = editText.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background, "loginEmail.background");
        background.setAlpha(0);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.login_pass_layout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "login_pass_layout");
        constraintLayout.setVisibility(8);
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.loginMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView, "loginMessage");
        textView.setVisibility(8);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.changeMessageLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "changeMessageLayout");
        constraintLayout2.setVisibility(8);
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.accountMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "accountMessage");
        textView2.setVisibility(8);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.login_pass_layout2);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "login_pass_layout2");
        constraintLayout3.setVisibility(8);
        EditText editText2 = (EditText) _$_findCachedViewById(C2092R.C2094id.loginEmail);
        RFGUser rFGUser = this.user;
        if (rFGUser == null) {
            Intrinsics.throwNpe();
        }
        editText2.setText(rFGUser.getEmail());
        Button button = (Button) _$_findCachedViewById(C2092R.C2094id.buttonLogin);
        Intrinsics.checkExpressionValueIsNotNull(button, "buttonLogin");
        button.setText("メールアドレスを更新");
        ((Button) _$_findCachedViewById(C2092R.C2094id.buttonLogin)).setOnClickListener(new RFGMailInfoActivity$setupMail$1(this));
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

    private final HashMap<String, String> updateParam() {
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.loginEmail);
        Intrinsics.checkExpressionValueIsNotNull(editText, "loginEmail");
        String replace = new Regex("[ 　\\s]").replace((CharSequence) editText.getText().toString(), "");
        HashMap<String, String> hashMap = new HashMap<>();
        RFGUser rFGUser = this.user;
        if (rFGUser == null) {
            Intrinsics.throwNpe();
        }
        if (!Intrinsics.areEqual((Object) replace, (Object) rFGUser.getEmail())) {
            hashMap.put("username", replace);
        }
        return hashMap;
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
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "402", "402b", (String) null, 4, (Object) null);
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_mail_info);
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
        supportActionBar.setTitle((CharSequence) "メールアドレスを編集");
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
        setupMail();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
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

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        RFGAnalyticsManager.INSTANCE.sendScreen("402");
    }

    public final void setUser(RFGUser rFGUser) {
        this.user = rFGUser;
    }
}
