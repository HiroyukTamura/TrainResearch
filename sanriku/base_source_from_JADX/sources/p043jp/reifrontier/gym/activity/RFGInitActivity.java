package p043jp.reifrontier.gym.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.format.DateFormat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.C1473F;
import com.squareup.picasso.C1489e;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1529y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.greenrobot.eventbus.C1129m;
import org.greenrobot.eventbus.ThreadMode;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p061c.p062a.C1562e;
import p009e.p028d.p061c.p062a.p063g.C1566a;
import p009e.p069e.p073b.p075b.C1580a;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.BuildConfig;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.RFGDataRemover;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.api.RFGPointClient;
import p043jp.reifrontier.gym.data.bus.RFGConnectSilentLog;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.domain.gcm.RFGGcmToken;
import p043jp.reifrontier.gym.exception.AbnormalLaunchException;
import p043jp.reifrontier.gym.p044ui.dialog.RFGAddMemberDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGBodyDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGCameraDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGConfirmDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGDateDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGGenderDialog;
import p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator;
import p043jp.reifrontier.gym.p044ui.widget.RFGRadiusTransform;
import p043jp.reifrontier.gym.util.GymUtils;
import p043jp.reifrontier.gym.util.RFGLocationPermissionUtils;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p048l.p049a.C1122a;
import p078g.p079a.C1706l;
import p078g.p079a.p080A.p082b.C1592a;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p084d.C1606e;
import p078g.p079a.p080A.p085e.p089d.C1625c;
import p078g.p079a.p080A.p085e.p089d.C1629e;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p100z.C1738a;
import p078g.p079a.p100z.C1741d;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002opB\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u001e\u0010(\u001a\u00020\u001d2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0*2\u0006\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\b\u00101\u001a\u00020\fH\u0002J\"\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020\u001dH\u0016J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\bH\u0016J\u0012\u0010:\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J \u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bH\u0016J\b\u0010A\u001a\u00020\u001dH\u0014J\u0010\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020DH\u0007J-\u0010E\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\b2\u000e\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0G2\u0006\u0010H\u001a\u00020IH\u0016¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u00020\u001dH\u0014J\u0018\u0010L\u001a\u00020\u001d2\u0006\u00109\u001a\u00020M2\u0006\u0010N\u001a\u00020\nH\u0016J\u0010\u0010L\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\bH\u0016J\b\u0010O\u001a\u00020\u001dH\u0014J\u0018\u0010P\u001a\u00020\u001d2\u0006\u00109\u001a\u00020M2\u0006\u0010N\u001a\u00020\nH\u0002J\b\u0010Q\u001a\u00020\u001dH\u0002J\b\u0010R\u001a\u00020\u001dH\u0002J\b\u0010S\u001a\u00020\u001dH\u0002J\u0010\u0010T\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020\nH\u0002J\b\u0010V\u001a\u00020\u001dH\u0002J\b\u0010W\u001a\u00020\u001dH\u0002J\b\u0010X\u001a\u00020\u001dH\u0002J\b\u0010Y\u001a\u00020\u001dH\u0003J\u0010\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\nH\u0003J\u001c\u0010\\\u001a\u00020\u001d2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0]H\u0003J\b\u0010^\u001a\u00020\u001dH\u0003J\u001c\u0010_\u001a\u00020\u001d2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0]H\u0003J\b\u0010`\u001a\u00020\u001dH\u0003J\b\u0010a\u001a\u00020\u001dH\u0003J\b\u0010b\u001a\u00020\u001dH\u0002J\b\u0010c\u001a\u00020\u001dH\u0002J\b\u0010d\u001a\u00020\u001dH\u0002J\b\u0010e\u001a\u00020\u001dH\u0002J\b\u0010f\u001a\u00020\u001dH\u0002J\b\u0010g\u001a\u00020\u001dH\u0003J\b\u0010h\u001a\u00020\u001dH\u0002J\b\u0010i\u001a\u00020\u001dH\u0002J\b\u0010j\u001a\u00020\u001dH\u0002J\b\u0010k\u001a\u00020\u001dH\u0002J\b\u0010l\u001a\u00020\u001dH\u0002J\b\u0010m\u001a\u00020\u001dH\u0002J\u0014\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0]H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGInitActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ljp/reifrontier/gym/ui/dialog/RFGGenderDialog$GenderDialogListener;", "Ljp/reifrontier/gym/ui/dialog/RFGCameraDialog$CameraDialogListener;", "Ljp/reifrontier/gym/ui/dialog/RFGDateDialog$DateDialogListener;", "Ljp/reifrontier/gym/ui/dialog/RFGBodyDialog$PickerDialogListener;", "()V", "cameraType", "", "firstDate", "", "hasIconChanged", "", "hasUser", "isLoading", "isPolicyTap", "isTermsTap", "loginType", "Ljp/reifrontier/gym/activity/RFGInitActivity$LoginType;", "mCameraUri", "Landroid/net/Uri;", "mRealm", "Lio/realm/Realm;", "mSaveUri", "twaLauncher", "Lcom/google/androidbrowserhelper/trusted/TwaLauncher;", "updateBirthday", "Ljava/util/Date;", "alertWith", "", "message", "authH1Account", "camera", "canStartApp", "changeCreateOrLogin", "checkLocationService", "checkManifest", "closeKeyboard", "confirmRemoveAllData", "createH2Account", "createZip", "files", "", "path", "cropFromCamera", "cropFromGallery", "gallery", "gotoLogin", "gotoMain", "isDummyUser", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCameraSelect", "type", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDateSelect", "year", "month", "day", "onDestroy", "onReceiveConnect", "connect", "Ljp/reifrontier/gym/data/bus/RFGConnectSilentLog;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSelect", "Ljp/reifrontier/gym/RFGDef$BodyType;", "value", "onStart", "openBodySheet", "openCamera", "openCameraSheet", "openGallery", "openLink", "link", "removeAllData", "request", "requestPermission", "requestRegisterFeed", "requestResetPassword", "mailAddress", "requestUpdate", "Ljava/util/HashMap;", "requestUpdateIcon", "requestUpdatePushDeviceId", "requestUser", "requestUserAfterLogin", "sendMail", "setEditView", "setLocationView", "setLoginView", "setupGCM", "setupLocation", "setupLogin", "setupProfile", "setupTerms", "showAddMemberDialog", "startLoading", "stopLoading", "updateParam", "Companion", "LoginType", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity */
public final class RFGInitActivity extends AppCompatActivity implements RFGGenderDialog.GenderDialogListener, RFGCameraDialog.CameraDialogListener, RFGDateDialog.DateDialogListener, RFGBodyDialog.PickerDialogListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_KEY_IS_ERROR_RESTART = "error_restart";
    private static final int REQ_CAMERA = 1984;
    private static final int REQ_CROP = 216;
    private static final int REQ_GALLERY = 2016;
    private static final int REQ_PERMISSION = 1982;
    private HashMap _$_findViewCache;
    private int cameraType;
    private String firstDate;
    /* access modifiers changed from: private */
    public boolean hasIconChanged;
    private boolean hasUser;
    /* access modifiers changed from: private */
    public boolean isLoading;
    /* access modifiers changed from: private */
    public boolean isPolicyTap;
    /* access modifiers changed from: private */
    public boolean isTermsTap;
    private LoginType loginType = LoginType.Create;
    private Uri mCameraUri;
    /* access modifiers changed from: private */
    public Realm mRealm;
    private Uri mSaveUri;
    private C1562e twaLauncher;
    /* access modifiers changed from: private */
    public Date updateBirthday = new Date(631197119000L);

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGInitActivity$Companion;", "", "()V", "EXTRA_KEY_IS_ERROR_RESTART", "", "REQ_CAMERA", "", "REQ_CROP", "REQ_GALLERY", "REQ_PERMISSION", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGInitActivity$LoginType;", "", "(Ljava/lang/String;I)V", "Create", "Login", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$LoginType */
    public enum LoginType {
        Create,
        Login
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFGDef.BodyType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGDef.BodyType bodyType = RFGDef.BodyType.Height;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGDef.BodyType bodyType2 = RFGDef.BodyType.Weight;
            iArr2[1] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final void alertWith(String str) {
        RFGErrorDialog.Companion.newInstance$default(RFGErrorDialog.Companion, (String) null, str, 1, (Object) null).show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    /* access modifiers changed from: private */
    public final void authH1Account() {
        String str;
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.loginEmail);
        Intrinsics.checkExpressionValueIsNotNull(editText, "loginEmail");
        String replace = new Regex("[ 　\\s]").replace((CharSequence) editText.getText().toString(), "");
        EditText editText2 = (EditText) _$_findCachedViewById(C2092R.C2094id.loginPassword);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "loginPassword");
        String replace2 = new Regex("[ 　\\s]").replace((CharSequence) editText2.getText().toString(), "");
        EditText editText3 = (EditText) _$_findCachedViewById(C2092R.C2094id.loginPassword2);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "loginPassword2");
        String replace3 = new Regex("[ 　\\s]").replace((CharSequence) editText3.getText().toString(), "");
        if (StringsKt__StringsJVMKt.isBlank(replace)) {
            str = "メールアドレスを入力してください";
        } else if (StringsKt__StringsJVMKt.isBlank(replace2)) {
            str = "パスワードを入力してください";
        } else if (!GymUtils.INSTANCE.validateEmail(replace)) {
            str = "正しい形式のメールアドレスを入力してください";
        } else if (!GymUtils.INSTANCE.validatePassword(replace2)) {
            str = "パスワードは8文字以上で入力してください";
        } else if (this.loginType != LoginType.Create || !(!Intrinsics.areEqual((Object) replace2, (Object) replace3))) {
            startLoading();
            if (SilentLogOperation.Companion.getInstance().isLogin()) {
                return;
            }
            if (this.loginType == LoginType.Login) {
                SilentLogOperation.Companion.getInstance().getInternalOperation().connectApiViaLogin(replace, replace2);
                return;
            } else {
                SilentLogOperation.Companion.getInstance().getInternalOperation().connectApiWithPass(replace, replace2, (Integer) null, (Date) null);
                return;
            }
        } else {
            str = "2つのパスワードが一致しません";
        }
        alertWith(str);
    }

    private final void camera() {
        CharSequence format = DateFormat.format("ddkkmmss", Calendar.getInstance());
        File file = new File(getFilesDir(), "zips");
        file.mkdirs();
        File file2 = new File(C0681a.m328a(new Object[]{file, format, ".jpg"}, 3, "%s/%s%s", "java.lang.String.format(this, *args)"));
        if (file2.exists()) {
            file2.delete();
        }
        this.mCameraUri = FileProvider.getUriForFile(this, BuildConfig.MAIL_PROVIDER, file2);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", this.mCameraUri);
        startActivityForResult(intent, REQ_CAMERA);
    }

    private final boolean canStartApp() {
        Intent intent = getIntent();
        if (!(intent != null ? intent.getBooleanExtra(EXTRA_KEY_IS_ERROR_RESTART, false) : false)) {
            C1122a.m1596a("can start app: no error.", new Object[0]);
            RFGShared.INSTANCE.setIsErrorRestart(false);
            return true;
        } else if (RFGShared.INSTANCE.isErrorRestart()) {
            C1122a.m1601d("cannot start app: already restart by error.", new Object[0]);
            RFGShared.INSTANCE.setIsErrorRestart(false);
            return false;
        } else {
            C1122a.m1601d("can start app: has error.", new Object[0]);
            RFGShared.INSTANCE.setIsErrorRestart(true);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final void changeCreateOrLogin() {
        LoginType loginType2 = this.loginType;
        LoginType loginType3 = LoginType.Create;
        if (loginType2 == loginType3) {
            loginType3 = LoginType.Login;
        }
        if (loginType3 == LoginType.Create) {
            TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.loginMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView, "loginMessage");
            textView.setVisibility(0);
            Button button = (Button) _$_findCachedViewById(C2092R.C2094id.buttonLogin);
            Intrinsics.checkExpressionValueIsNotNull(button, "buttonLogin");
            button.setText(getString(R.string.account));
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
            supportActionBar.setTitle((CharSequence) getString(R.string.account));
            Button button2 = (Button) _$_findCachedViewById(C2092R.C2094id.changeMessage);
            Intrinsics.checkExpressionValueIsNotNull(button2, "changeMessage");
            button2.setText(getString(R.string.login_here));
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.login_pass_layout2);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "login_pass_layout2");
            constraintLayout.setVisibility(0);
            TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.accountMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "accountMessage");
            textView2.setVisibility(0);
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutForgetPassword);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "layoutForgetPassword");
            relativeLayout.setVisibility(8);
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutSupportLogin);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "layoutSupportLogin");
            relativeLayout2.setVisibility(8);
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutRemoveAllData);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "layoutRemoveAllData");
            relativeLayout3.setVisibility(8);
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.loginMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "loginMessage");
            textView3.setVisibility(8);
            Button button3 = (Button) _$_findCachedViewById(C2092R.C2094id.buttonLogin);
            Intrinsics.checkExpressionValueIsNotNull(button3, "buttonLogin");
            button3.setText(getString(R.string.login));
            Button button4 = (Button) _$_findCachedViewById(C2092R.C2094id.changeMessage);
            Intrinsics.checkExpressionValueIsNotNull(button4, "changeMessage");
            button4.setText(getString(R.string.account_here));
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(supportActionBar2, "supportActionBar!!");
            supportActionBar2.setTitle((CharSequence) getString(R.string.login));
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.login_pass_layout2);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "login_pass_layout2");
            constraintLayout2.setVisibility(8);
            TextView textView4 = (TextView) _$_findCachedViewById(C2092R.C2094id.accountMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "accountMessage");
            textView4.setVisibility(8);
            RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutForgetPassword);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, "layoutForgetPassword");
            relativeLayout4.setVisibility(8);
            RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutSupportLogin);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, "layoutSupportLogin");
            relativeLayout5.setVisibility(0);
            RelativeLayout relativeLayout6 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutRemoveAllData);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout6, "layoutRemoveAllData");
            relativeLayout6.setVisibility(0);
        }
        this.loginType = loginType3;
    }

    private final void checkLocationService() {
        Object systemService = getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
        } else if (!((LocationManager) systemService).isProviderEnabled("network")) {
            alertWith("位置情報の取得がオフになっています。");
        }
    }

    private final boolean checkManifest() {
        return ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

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
    public final void confirmRemoveAllData() {
        RFGConfirmDialog.Companion companion = RFGConfirmDialog.Companion;
        String string = getString(R.string.remove_all_data_confirm_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.remove_all_data_confirm_title)");
        String string2 = getString(R.string.remove_all_data_confirm_message);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.remov…all_data_confirm_message)");
        RFGConfirmDialog newInstance = companion.newInstance(string, string2, getString(R.string.remove_all_data_confirm_yes), getString(R.string.remove_all_data_confirm_no));
        newInstance.setListener(new RFGInitActivity$confirmRemoveAllData$$inlined$apply$lambda$1(this));
        newInstance.show(getSupportFragmentManager(), "remove-all-data-confirm");
    }

    /* access modifiers changed from: private */
    public final void createH2Account() {
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.editName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editName");
        Editable text = editText.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "editName.text");
        if (StringsKt__StringsJVMKt.isBlank(text)) {
            alertWith("ニックネームを入力してください");
            return;
        }
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editBirthday);
        Intrinsics.checkExpressionValueIsNotNull(textView, "editBirthday");
        if (Intrinsics.areEqual((Object) textView.getText(), (Object) "設定してください")) {
            alertWith("誕生日を選択してください");
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.editGender);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "editGender");
        if (Intrinsics.areEqual((Object) textView2.getText(), (Object) "設定してください")) {
            alertWith("性別を選択してください");
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.editHeight);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "editHeight");
        if (Intrinsics.areEqual((Object) textView3.getText(), (Object) "設定してください")) {
            alertWith("身長を選択してください");
            return;
        }
        TextView textView4 = (TextView) _$_findCachedViewById(C2092R.C2094id.editWeight);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "editWeight");
        if (Intrinsics.areEqual((Object) textView4.getText(), (Object) "設定してください")) {
            alertWith("体重を選択してください");
            return;
        }
        startLoading();
        requestUpdate(updateParam());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r9, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r8, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0073, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0077, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void createZip(java.util.List<java.lang.String> r11, java.lang.String r12) {
        /*
            r10 = this;
            java.util.zip.ZipOutputStream r0 = new java.util.zip.ZipOutputStream
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r2 = new java.io.FileOutputStream
            r2.<init>(r12)
            r1.<init>(r2)
            r0.<init>(r1)
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0070 }
        L_0x0013:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0070 }
            r1 = 0
            if (r12 == 0) goto L_0x006a
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0070 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0070 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x0070 }
            r8.<init>(r12)     // Catch:{ all -> 0x0070 }
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0063 }
            r9.<init>(r8)     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = "/"
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r12
            int r2 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r2, (java.lang.String) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x005c }
            if (r12 == 0) goto L_0x0054
            java.lang.String r12 = r12.substring(r2)     // Catch:{ all -> 0x005c }
            java.lang.String r2 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r2)     // Catch:{ all -> 0x005c }
            java.util.zip.ZipEntry r2 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x005c }
            r2.<init>(r12)     // Catch:{ all -> 0x005c }
            r0.putNextEntry(r2)     // Catch:{ all -> 0x005c }
            r12 = 1024(0x400, float:1.435E-42)
            kotlin.p045io.ByteStreamsKt.copyTo(r9, r0, r12)     // Catch:{ all -> 0x005c }
            kotlin.p045io.CloseableKt.closeFinally(r9, r1)     // Catch:{ all -> 0x0063 }
            kotlin.p045io.CloseableKt.closeFinally(r8, r1)     // Catch:{ all -> 0x0070 }
            goto L_0x0013
        L_0x0054:
            kotlin.TypeCastException r11 = new kotlin.TypeCastException     // Catch:{ all -> 0x005c }
            java.lang.String r12 = "null cannot be cast to non-null type java.lang.String"
            r11.<init>(r12)     // Catch:{ all -> 0x005c }
            throw r11     // Catch:{ all -> 0x005c }
        L_0x005c:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x005e }
        L_0x005e:
            r12 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r9, r11)     // Catch:{ all -> 0x0063 }
            throw r12     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r12 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r8, r11)     // Catch:{ all -> 0x0070 }
            throw r12     // Catch:{ all -> 0x0070 }
        L_0x006a:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0070 }
            kotlin.p045io.CloseableKt.closeFinally(r0, r1)
            return
        L_0x0070:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r12 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r0, r11)
            goto L_0x0078
        L_0x0077:
            throw r12
        L_0x0078:
            goto L_0x0077
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.activity.RFGInitActivity.createZip(java.util.List, java.lang.String):void");
    }

    private final void cropFromCamera() {
        GymUtils gymUtils = GymUtils.INSTANCE;
        Uri uri = this.mCameraUri;
        if (uri == null) {
            Intrinsics.throwNpe();
        }
        Bitmap resizeBitmap = gymUtils.resizeBitmap(this, uri, 300);
        File createImageFile = GymUtils.INSTANCE.createImageFile(this);
        if (createImageFile != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(createImageFile);
            if (resizeBitmap == null) {
                Intrinsics.throwNpe();
            }
            resizeBitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream);
            fileOutputStream.flush();
            this.mCameraUri = Uri.fromFile(createImageFile);
            Intent intent = new Intent(this, RFGCropActivity.class);
            intent.putExtra("imageUri", String.valueOf(this.mCameraUri));
            startActivityForResult(intent, REQ_CROP);
        }
    }

    private final void cropFromGallery() {
        Intent intent = new Intent(this, RFGCropActivity.class);
        intent.putExtra("imageUri", String.valueOf(this.mCameraUri));
        startActivityForResult(intent, REQ_CROP);
    }

    private final void gallery() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
        intent.setType("image/jpeg");
        startActivityForResult(Intent.createChooser(intent, "画像を選択"), REQ_GALLERY);
    }

    private final void gotoLogin() {
        this.isPolicyTap = true;
        this.isTermsTap = true;
        this.loginType = LoginType.Create;
        changeCreateOrLogin();
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewTerms);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "viewTerms");
        scrollView.setVisibility(8);
        setLoginView();
    }

    /* access modifiers changed from: private */
    public final void gotoMain() {
        startActivity(new Intent(this, RFGMainActivity.class));
        finish();
    }

    private final boolean isDummyUser() {
        String username = RFLSharedHolder.INSTANCE.username();
        return (username.length() == 0) || StringsKt__StringsJVMKt.endsWith$default(username, "SDK@silentlog.com", false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void openBodySheet(RFGDef.BodyType bodyType, String str) {
        RFGBodyDialog.Companion.newInstance(bodyType, str).show(getSupportFragmentManager(), RFGBodyDialog.Companion.getTAG());
    }

    private final void openCamera() {
        if (checkManifest()) {
            camera();
        } else {
            requestPermission();
        }
    }

    /* access modifiers changed from: private */
    public final void openCameraSheet() {
        RFGCameraDialog.Companion.newInstance().show(getSupportFragmentManager(), RFGCameraDialog.Companion.getTAG());
    }

    private final void openGallery() {
        if (checkManifest()) {
            gallery();
        } else {
            requestPermission();
        }
    }

    /* access modifiers changed from: private */
    public final void openLink(String str) {
        TrustedWebActivityIntentBuilder toolbarColor = new TrustedWebActivityIntentBuilder(Uri.parse(str)).setToolbarColor(ContextCompat.getColor(this, R.color.sanriku_blue));
        Intrinsics.checkExpressionValueIsNotNull(toolbarColor, "TrustedWebActivityIntent…s, R.color.sanriku_blue))");
        C1562e eVar = this.twaLauncher;
        if (eVar != null) {
            eVar.mo27327a();
        }
        C1562e eVar2 = new C1562e(this);
        this.twaLauncher = eVar2;
        if (eVar2 != null) {
            eVar2.mo27330b(toolbarColor, (C1566a) null, (Runnable) null);
        }
    }

    /* access modifiers changed from: private */
    public final void removeAllData() {
        new RFGDataRemover(this).deleteWithoutLogout();
        RFGErrorDialog.Companion companion = RFGErrorDialog.Companion;
        String string = getString(R.string.remove_all_data_completed_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.remov…all_data_completed_title)");
        String string2 = getString(R.string.remove_all_data_completed_message);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.remov…l_data_completed_message)");
        companion.newInstance(string, string2).show(getSupportFragmentManager(), "remove-all-data-completed");
    }

    /* access modifiers changed from: private */
    public final void request() {
        if (RFGLocationPermissionUtils.INSTANCE.checkSelfPermission(this)) {
            SilentLogOperation.Companion.getInstance().permissionResult(SilentLogOperation.Companion.getInstance().getSILENT_LOG_SDK_GPS_PERMISSION(), 0);
        } else if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(RFGLocationPermissionUtils.INSTANCE.getPERMISSION_ARRAY(), SilentLogOperation.Companion.getInstance().getSILENT_LOG_SDK_GPS_PERMISSION());
        }
    }

    private final void requestPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, REQ_PERMISSION);
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestRegisterFeed() {
        RFGPointClient.Companion.getINSTANCE().pointAction().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGInitActivity$requestRegisterFeed$1(this), new RFGInitActivity$requestRegisterFeed$2(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestResetPassword(String str) {
        startLoading();
        RFGH2Client.Companion.getINSTANCE().resetPass(C0681a.m320a("QcwR8KOwKczQTqUhq8oQFQXRNz2O4L3RXy_", str)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGInitActivity$requestResetPassword$1(this), new RFGInitActivity$requestResetPassword$2(this));
    }

    @SuppressLint({"CheckResult"})
    private final void requestUpdate(HashMap<String, String> hashMap) {
        RFGH2Client.Companion.getINSTANCE().updateUser(hashMap).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGInitActivity$requestUpdate$1(this), new RFGInitActivity$requestUpdate$2(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUpdateIcon() {
        GymUtils gymUtils = GymUtils.INSTANCE;
        Uri uri = this.mSaveUri;
        if (uri == null) {
            Intrinsics.throwNpe();
        }
        Bitmap resizeBitmap = gymUtils.resizeBitmap(this, uri, 100);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (resizeBitmap == null) {
            Intrinsics.throwNpe();
        }
        resizeBitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        File file = new File(getCacheDir(), "temp-icon.jpg");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteArray);
        fileOutputStream.flush();
        fileOutputStream.close();
        RFGH2Client.Companion.getINSTANCE().uploadPhoto(file).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGInitActivity$requestUpdateIcon$1(this), new RFGInitActivity$requestUpdateIcon$2(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUpdatePushDeviceId(HashMap<String, String> hashMap) {
        RFGH2Client.Companion.getINSTANCE().updateUser(hashMap).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGInitActivity$requestUpdatePushDeviceId$1(this), new RFGInitActivity$requestUpdatePushDeviceId$2(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUser() {
        RFGH2Client.Companion.getINSTANCE().userInfo().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGInitActivity$requestUser$1(this), new RFGInitActivity$requestUser$2(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUserAfterLogin() {
        RFGH2Client.Companion.getINSTANCE().userInfo().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGInitActivity$requestUserAfterLogin$1(this), new RFGInitActivity$requestUserAfterLogin$2(this));
    }

    /* access modifiers changed from: private */
    public final void sendMail() {
        ArrayList arrayList = new ArrayList();
        List<String> listOf = CollectionsKt__CollectionsKt.listOf("1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5");
        String a = C0681a.m328a(new Object[]{getFilesDir(), getPackageName(), "-sdk.log"}, 3, "%s/%s%s", "java.lang.String.format(this, *args)");
        if (new File(a).exists()) {
            arrayList.add(a);
        }
        for (String str : listOf) {
            String str2 = a + '.' + str;
            if (new File(str2).exists()) {
                arrayList.add(str2);
            }
        }
        String a2 = C0681a.m328a(new Object[]{getFilesDir(), getPackageName(), ".zip"}, 3, "%s/%s%s", "java.lang.String.format(this, *args)");
        File file = new File(a2);
        if (file.exists()) {
            file.delete();
        }
        createZip(arrayList, a2);
        File file2 = new File(a2);
        if (file2.exists()) {
            File file3 = new File(getFilesDir(), "zips");
            file3.mkdirs();
            File file4 = new File(C0681a.m328a(new Object[]{file3, getPackageName(), ".zip"}, 3, "%s/%s%s", "java.lang.String.format(this, *args)"));
            if (file4.exists()) {
                file4.delete();
            }
            File unused = FilesKt__UtilsKt.copyTo$default(file2, file4, true, 0, 4, (Object) null);
            Uri uriForFile = FileProvider.getUriForFile(this, BuildConfig.MAIL_PROVIDER, file4);
            Intrinsics.checkExpressionValueIsNotNull(uriForFile, "contentUri");
            ArrayList arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uriForFile);
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.setType("vnd.android.cursor.dir/email");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{getResources().getString(R.string.support_mail_to)});
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayListOf);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.support_mail_subject));
            intent.putExtra("android.intent.extra.TEXT", getResources().getString(R.string.support_mail_body, new Object[]{"", ""}));
            intent.addFlags(3);
            startActivity(Intent.createChooser(intent, "Send email..."));
        }
    }

    /* access modifiers changed from: private */
    public final void setEditView() {
        stopLoading();
        RFGAnalyticsManager.INSTANCE.sendScreen("004");
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
        supportActionBar.setTitle((CharSequence) "プロフィールを作成");
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewTerms);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "viewTerms");
        scrollView.setVisibility(8);
        ScrollView scrollView2 = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewLogin);
        Intrinsics.checkExpressionValueIsNotNull(scrollView2, "viewLogin");
        scrollView2.setVisibility(8);
        ScrollView scrollView3 = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewEdit);
        Intrinsics.checkExpressionValueIsNotNull(scrollView3, "viewEdit");
        scrollView3.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void setLocationView() {
        if (!this.isPolicyTap || !this.isTermsTap) {
            alertWith("利用規約とプライバシーポリシーの両方を確認してください。");
            return;
        }
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewTerms);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "viewTerms");
        scrollView.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 23) {
            RFGAnalyticsManager.INSTANCE.sendScreen("002");
            ScrollView scrollView2 = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewLocation);
            Intrinsics.checkExpressionValueIsNotNull(scrollView2, "viewLocation");
            scrollView2.setVisibility(0);
            return;
        }
        if (RFGLocationPermissionUtils.INSTANCE.checkSelfPermission(this)) {
            SilentLogOperation.Companion.getInstance().permissionResult(SilentLogOperation.Companion.getInstance().getSILENT_LOG_SDK_GPS_PERMISSION(), 0);
        }
        setLoginView();
    }

    /* access modifiers changed from: private */
    public final void setLoginView() {
        RFGAnalyticsManager.INSTANCE.sendScreen("003");
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
        supportActionBar.setTitle((CharSequence) getString(R.string.account));
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewLocation);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "viewLocation");
        scrollView.setVisibility(8);
        ScrollView scrollView2 = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewLogin);
        Intrinsics.checkExpressionValueIsNotNull(scrollView2, "viewLogin");
        scrollView2.setVisibility(0);
    }

    private final void setupGCM() {
        if (GymUtils.INSTANCE.checkPlayServices(this)) {
            new RFGGcmToken().refreshToken();
        }
    }

    @SuppressLint({"CheckResult"})
    private final void setupLocation() {
        Button button = (Button) _$_findCachedViewById(C2092R.C2094id.buttonLocationNext);
        Intrinsics.checkExpressionValueIsNotNull(button, "buttonLocationNext");
        button.setEnabled(false);
        C1706l<Object> a = C1580a.m2209a((Button) _$_findCachedViewById(C2092R.C2094id.buttonLocation));
        RFGInitActivity$setupLocation$locationObservable$1 rFGInitActivity$setupLocation$locationObservable$1 = new RFGInitActivity$setupLocation$locationObservable$1(this);
        C1599b.m2241a(rFGInitActivity$setupLocation$locationObservable$1, "mapper is null");
        C1629e eVar = new C1629e(a, rFGInitActivity$setupLocation$locationObservable$1);
        C1742e b = C1592a.m2237b();
        C1599b.m2241a(b, "keySelector is null");
        C1625c cVar = new C1625c(eVar, b, C1599b.m2240a());
        RFGInitActivity$setupLocation$1 rFGInitActivity$setupLocation$1 = new RFGInitActivity$setupLocation$1(this);
        C1741d<Throwable> dVar = C1592a.f1867e;
        C1738a aVar = C1592a.f1865c;
        C1741d a2 = C1592a.m2235a();
        C1599b.m2241a(rFGInitActivity$setupLocation$1, "onNext is null");
        C1599b.m2241a(dVar, "onError is null");
        C1599b.m2241a(aVar, "onComplete is null");
        C1599b.m2241a(a2, "onSubscribe is null");
        cVar.mo27427a(new C1606e(rFGInitActivity$setupLocation$1, dVar, aVar, a2));
        ((Button) _$_findCachedViewById(C2092R.C2094id.buttonLocationNext)).setOnClickListener(new RFGInitActivity$setupLocation$2(this));
    }

    private final void setupLogin() {
        checkLocationService();
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.loginEmail);
        Intrinsics.checkExpressionValueIsNotNull(editText, "loginEmail");
        Drawable background = editText.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background, "loginEmail.background");
        background.setAlpha(0);
        EditText editText2 = (EditText) _$_findCachedViewById(C2092R.C2094id.loginPassword);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "loginPassword");
        Drawable background2 = editText2.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background2, "loginPassword.background");
        background2.setAlpha(0);
        EditText editText3 = (EditText) _$_findCachedViewById(C2092R.C2094id.loginPassword2);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "loginPassword2");
        Drawable background3 = editText3.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background3, "loginPassword2.background");
        background3.setAlpha(0);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutForgetPassword);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "layoutForgetPassword");
        relativeLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutSupportLogin);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "layoutSupportLogin");
        relativeLayout2.setVisibility(8);
        RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.layoutRemoveAllData);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "layoutRemoveAllData");
        relativeLayout3.setVisibility(8);
        ((Button) _$_findCachedViewById(C2092R.C2094id.buttonLogin)).setOnClickListener(new RFGInitActivity$setupLogin$1(this));
        this.loginType = LoginType.Create;
        ((Button) _$_findCachedViewById(C2092R.C2094id.changeMessage)).setOnClickListener(new RFGInitActivity$setupLogin$2(this));
        ((TextView) _$_findCachedViewById(C2092R.C2094id.textForgetPassword)).setOnClickListener(new RFGInitActivity$setupLogin$3(this));
        ((TextView) _$_findCachedViewById(C2092R.C2094id.textSupportLogin)).setOnClickListener(new RFGInitActivity$setupLogin$4(this));
        ((TextView) _$_findCachedViewById(C2092R.C2094id.textRemoveAllData)).setOnClickListener(new RFGInitActivity$setupLogin$5(this));
    }

    private final void setupProfile() {
        C1529y a = C1513u.m2068b().mo27244a((int) R.mipmap.icon);
        a.mo27279a((C1473F) new RFGRadiusTransform(-1.0f));
        a.mo27281a((ImageView) _$_findCachedViewById(C2092R.C2094id.editIcon), (C1489e) null);
        ((ImageView) _$_findCachedViewById(C2092R.C2094id.editIcon)).setOnClickListener(new RFGInitActivity$setupProfile$1(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.editIconButton)).setOnClickListener(new RFGInitActivity$setupProfile$2(this));
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.editName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editName");
        Drawable background = editText.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background, "editName.background");
        background.setAlpha(0);
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editHeight);
        Intrinsics.checkExpressionValueIsNotNull(textView, "editHeight");
        textView.setText("設定してください");
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.editWeight);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "editWeight");
        textView2.setText("設定してください");
        ((TextView) _$_findCachedViewById(C2092R.C2094id.editHeight)).setOnClickListener(new RFGInitActivity$setupProfile$3(this));
        ((TextView) _$_findCachedViewById(C2092R.C2094id.editWeight)).setOnClickListener(new RFGInitActivity$setupProfile$4(this));
        TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.editBirthday);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "editBirthday");
        textView3.setText("設定してください");
        ((TextView) _$_findCachedViewById(C2092R.C2094id.editBirthday)).setOnClickListener(new RFGInitActivity$setupProfile$5(this));
        TextView textView4 = (TextView) _$_findCachedViewById(C2092R.C2094id.editGender);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "editGender");
        textView4.setText("設定してください");
        ((TextView) _$_findCachedViewById(C2092R.C2094id.editGender)).setOnClickListener(new RFGInitActivity$setupProfile$6(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.editButton)).setOnClickListener(new RFGInitActivity$setupProfile$7(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.profileSupport)).setOnClickListener(new RFGInitActivity$setupProfile$8(this));
    }

    private final void setupTerms() {
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewTerms);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "viewTerms");
        scrollView.setVisibility(0);
        Button button = (Button) _$_findCachedViewById(C2092R.C2094id.buttonTermsNext);
        Intrinsics.checkExpressionValueIsNotNull(button, "buttonTermsNext");
        button.setEnabled(true);
        ((Button) _$_findCachedViewById(C2092R.C2094id.buttonTerms)).setOnClickListener(new RFGInitActivity$setupTerms$1(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.buttonPolicy)).setOnClickListener(new RFGInitActivity$setupTerms$2(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.buttonTermsNext)).setOnClickListener(new RFGInitActivity$setupTerms$3(this));
    }

    /* access modifiers changed from: private */
    public final void showAddMemberDialog() {
        RFGAddMemberDialog.Companion companion = RFGAddMemberDialog.Companion;
        String string = getResources().getString(R.string.password_reset_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.password_reset_title)");
        String string2 = getResources().getString(R.string.mail);
        Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.string.mail)");
        String string3 = getResources().getString(R.string.password_reset_send);
        Intrinsics.checkExpressionValueIsNotNull(string3, "resources.getString(R.string.password_reset_send)");
        RFGAddMemberDialog newInstance = companion.newInstance(string, string2, string3, "example@test.com");
        newInstance.setListener(new RFGInitActivity$showAddMemberDialog$1(this));
        newInstance.show(getSupportFragmentManager(), RFGAddMemberDialog.Companion.getTAG());
    }

    private final void startLoading() {
        closeKeyboard();
        ((RFGLoadingIndicator) _$_findCachedViewById(C2092R.C2094id.indicator)).show();
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.indicatorCover);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "indicatorCover");
        constraintLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void stopLoading() {
        ((RFGLoadingIndicator) _$_findCachedViewById(C2092R.C2094id.indicator)).hide();
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.indicatorCover);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "indicatorCover");
        constraintLayout.setVisibility(8);
    }

    private final HashMap<String, String> updateParam() {
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.editName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editName");
        String obj = editText.getText().toString();
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editHeight);
        Intrinsics.checkExpressionValueIsNotNull(textView, "editHeight");
        CharSequence text = textView.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "editHeight.text");
        String str = (String) StringsKt__StringsKt.split$default(text, new String[]{"c"}, false, 0, 6, (Object) null).get(0);
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.editWeight);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "editWeight");
        CharSequence text2 = textView2.getText();
        Intrinsics.checkExpressionValueIsNotNull(text2, "editWeight.text");
        String str2 = (String) StringsKt__StringsKt.split$default(text2, new String[]{"k"}, false, 0, 6, (Object) null).get(0);
        TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.editGender);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "editGender");
        String str3 = Intrinsics.areEqual((Object) textView3.getText(), (Object) "女性") ? "female" : RFLAccountManager.DEFAULT_GENDER;
        HashMap<String, String> hashMap = new HashMap<>();
        String str4 = RFGShared.INSTANCE.token();
        hashMap.put("handle_name", obj);
        hashMap.put("app_id", BuildConfig.APP_ID);
        hashMap.put("point", String.valueOf(0));
        hashMap.put("push_allow", String.valueOf(1));
        hashMap.put("valid_flag", String.valueOf(1));
        hashMap.put("push_device_id", str4);
        hashMap.put("height", str);
        hashMap.put("weight", str2);
        hashMap.put("gender", str3);
        hashMap.put("birthday", RFGUtilsKt.formaaat11$default(this.updateBirthday, "yyyyMMdd", (String) null, 2, (Object) null));
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

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == REQ_CAMERA && i2 == -1) {
            cropFromCamera();
        } else if (i == REQ_CROP && i2 == -1) {
            this.hasIconChanged = true;
            if (intent == null) {
                Intrinsics.throwNpe();
            }
            this.mSaveUri = Uri.parse(intent.getStringExtra("cropImage"));
            C1529y a = C1513u.m2068b().mo27245a(this.mSaveUri);
            a.mo27279a((C1473F) new RFGRadiusTransform(-1.0f));
            a.mo27281a((ImageView) _$_findCachedViewById(C2092R.C2094id.editIcon), (C1489e) null);
        } else if (i == REQ_GALLERY && i2 == -1) {
            if (intent == null) {
                Intrinsics.throwNpe();
            }
            this.mCameraUri = intent.getData();
            cropFromGallery();
        }
    }

    public void onBackPressed() {
        if (!this.isLoading) {
            finish();
        }
    }

    public void onCameraSelect(int i) {
        if (i == 0) {
            this.cameraType = 0;
            openCamera();
            return;
        }
        this.cameraType = 1;
        openGallery();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (canStartApp()) {
            setTheme(C2092R.style.AppTheme_NoActionBar);
            super.onCreate(bundle);
            setContentView((int) R.layout.activity_init);
            setSupportActionBar((Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar));
            RFGAnalyticsManager.INSTANCE.sendScreen("000");
            Realm defaultInstance = Realm.getDefaultInstance();
            this.mRealm = defaultInstance;
            if (defaultInstance == null) {
                Intrinsics.throwNpe();
            }
            RFGUser rFGUser = (RFGUser) defaultInstance.where(RFGUser.class).findFirst();
            if (rFGUser != null) {
                if (rFGUser.getUserId().length() > 0) {
                    this.hasUser = true;
                    this.firstDate = rFGUser.getFirstDate();
                    SilentLogOperation.Companion.getInstance().getInternalOperation().saveSl2Id(rFGUser.gymId());
                }
            }
            setupGCM();
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
            supportActionBar.setTitle(getResources().getText(R.string.app_title));
            ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewTerms);
            Intrinsics.checkExpressionValueIsNotNull(scrollView, "viewTerms");
            scrollView.setVisibility(8);
            setupTerms();
            ScrollView scrollView2 = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewLocation);
            Intrinsics.checkExpressionValueIsNotNull(scrollView2, "viewLocation");
            scrollView2.setVisibility(8);
            setupLocation();
            ScrollView scrollView3 = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewLogin);
            Intrinsics.checkExpressionValueIsNotNull(scrollView3, "viewLogin");
            scrollView3.setVisibility(8);
            setupLogin();
            ScrollView scrollView4 = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewEdit);
            Intrinsics.checkExpressionValueIsNotNull(scrollView4, "viewEdit");
            scrollView4.setVisibility(8);
            setupProfile();
            RFGShared.INSTANCE.setRequestFeed(0);
            RFGShared.INSTANCE.setRequestPoint(0);
            RFGShared.INSTANCE.setRequestActs(0);
            return;
        }
        throw new AbnormalLaunchException();
    }

    public void onDateSelect(int i, int i2, int i3) {
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editBirthday);
        Intrinsics.checkExpressionValueIsNotNull(textView, "editBirthday");
        String format = String.format("%s年%s月%s日", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)}, 3));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
        textView.setText(format);
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        Date time = instance.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "calendar.time");
        this.updateBirthday = time;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C1562e eVar = this.twaLauncher;
        if (eVar != null) {
            eVar.mo27327a();
        }
        this.twaLauncher = null;
        super.onDestroy();
    }

    @C1129m(threadMode = ThreadMode.MAIN)
    public final void onReceiveConnect(RFGConnectSilentLog rFGConnectSilentLog) {
        Intrinsics.checkParameterIsNotNull(rFGConnectSilentLog, "connect");
        if (rFGConnectSilentLog.getConnect()) {
            String userId = rFGConnectSilentLog.getUserId();
            if (userId == null) {
                Intrinsics.throwNpe();
            }
            RFGShared.INSTANCE.setSilentLogId(userId);
            requestUser();
            return;
        }
        stopLoading();
        alertWith("メールアドレスかパスワードが間違っています");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == REQ_PERMISSION) {
            if (iArr[0] != 0) {
                return;
            }
            if (this.cameraType == 0) {
                camera();
            } else {
                gallery();
            }
        } else if (i == SilentLogOperation.Companion.getInstance().getSILENT_LOG_SDK_GPS_PERMISSION()) {
            SilentLogOperation.Companion.getInstance().permissionResult(i, iArr[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2092R.C2094id.viewTerms);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "viewTerms");
        if (scrollView.getVisibility() == 0) {
            if (this.isTermsTap) {
                ((TextView) _$_findCachedViewById(C2092R.C2094id.confirmTermsText)).setText(R.string.confirm_terms);
                ((ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.confirmTerms)).setBackgroundResource(R.drawable.radius_ok);
            }
            if (this.isPolicyTap) {
                ((TextView) _$_findCachedViewById(C2092R.C2094id.confirmPolicyText)).setText(R.string.confirm_policy);
                ((ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.confirmPolicy)).setBackgroundResource(R.drawable.radius_ok);
            }
            if (this.isTermsTap && this.isPolicyTap) {
                ((Button) _$_findCachedViewById(C2092R.C2094id.buttonTermsNext)).setTextColor(Color.parseColor("#333333"));
                ((Button) _$_findCachedViewById(C2092R.C2094id.buttonTermsNext)).setBackgroundResource(R.drawable.button_main);
            }
        }
    }

    public void onSelect(int i) {
        TextView textView;
        int i2;
        Resources resources;
        if (i == 0) {
            textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editGender);
            Intrinsics.checkExpressionValueIsNotNull(textView, "editGender");
            resources = getResources();
            i2 = R.string.genderF;
        } else {
            textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editGender);
            Intrinsics.checkExpressionValueIsNotNull(textView, "editGender");
            resources = getResources();
            i2 = R.string.genderM;
        }
        textView.setText(resources.getText(i2));
    }

    public void onSelect(RFGDef.BodyType bodyType, String str) {
        TextView textView;
        String str2;
        Intrinsics.checkParameterIsNotNull(bodyType, "type");
        Intrinsics.checkParameterIsNotNull(str, "value");
        int ordinal = bodyType.ordinal();
        if (ordinal == 0) {
            textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editHeight);
            str2 = "editHeight";
        } else if (ordinal == 1) {
            textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editWeight);
            str2 = "editWeight";
        } else {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(textView, str2);
        textView.setText(str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        if ((r0 != null ? r0.getBooleanExtra(EXTRA_KEY_IS_ERROR_RESTART, true) : true) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
            r4 = this;
            super.onStart()
            jp.reifrontier.silentlogsdkandroid.SilentLogOperation$Companion r0 = p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation.Companion
            jp.reifrontier.silentlogsdkandroid.SilentLogOperation r0 = r0.getInstance()
            r0.onStart()
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.C1126c.m1638c()
            r0.mo21908c(r4)
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.C1126c.m1638c()
            r0.mo21907b(r4)
            android.content.Intent r0 = r4.getIntent()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0039
            java.lang.String r3 = "error_restart"
            boolean r0 = r0.hasExtra(r3)
            if (r0 != r2) goto L_0x0039
            android.content.Intent r0 = r4.getIntent()
            if (r0 == 0) goto L_0x0035
            boolean r0 = r0.getBooleanExtra(r3, r2)
            goto L_0x0036
        L_0x0035:
            r0 = 1
        L_0x0036:
            if (r0 != 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r2 = 0
        L_0x003a:
            if (r2 == 0) goto L_0x0040
        L_0x003c:
            r4.gotoLogin()
            goto L_0x007f
        L_0x0040:
            jp.reifrontier.silentlogsdkandroid.SilentLogOperation$Companion r0 = p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation.Companion
            jp.reifrontier.silentlogsdkandroid.SilentLogOperation r0 = r0.getInstance()
            boolean r0 = r0.isLogin()
            if (r0 == 0) goto L_0x0068
            boolean r0 = r4.isDummyUser()
            if (r0 == 0) goto L_0x005c
            jp.reifrontier.silentlogsdkandroid.SilentLogOperation$Companion r0 = p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation.Companion
            jp.reifrontier.silentlogsdkandroid.SilentLogOperation r0 = r0.getInstance()
            r0.logoutApi()
            goto L_0x003c
        L_0x005c:
            boolean r0 = r4.hasUser
            if (r0 == 0) goto L_0x0064
            r4.gotoMain()
            goto L_0x007f
        L_0x0064:
            r4.setEditView()
            goto L_0x007f
        L_0x0068:
            jp.reifrontier.gym.data.analytics.RFGAnalyticsManager r0 = p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager.INSTANCE
            java.lang.String r2 = "001"
            r0.sendScreen(r2)
            int r0 = p043jp.reifrontier.gym.C2092R.C2094id.viewTerms
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            java.lang.String r2 = "viewTerms"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r0.setVisibility(r1)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.activity.RFGInitActivity.onStart():void");
    }
}
