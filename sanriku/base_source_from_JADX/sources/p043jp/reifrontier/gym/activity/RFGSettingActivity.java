package p043jp.reifrontier.gym.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p061c.p062a.C1562e;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.BuildConfig;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.domain.app.RFGSetting;
import p043jp.reifrontier.gym.domain.silentlog.RFGDay;
import p043jp.reifrontier.gym.p044ui.adapter.RFGSettingAdapter;
import p043jp.reifrontier.gym.p044ui.dialog.RFGConfirmDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGSheetDialog;
import p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002abB\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\u001e\u0010%\u001a\u00020\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0#2\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020\u001dH\u0003J\b\u0010*\u001a\u00020\u001dH\u0002J\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020'H\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\u0018\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020'2\u0006\u0010.\u001a\u00020'H\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\b\u00104\u001a\u00020\u001dH\u0002J\"\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u000109H\u0014J\b\u0010:\u001a\u00020\u001dH\u0016J\u0012\u0010;\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020\u001dH\u0014J\b\u0010?\u001a\u00020\u001dH\u0016J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\bH\u0016J\u0012\u0010A\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J-\u0010D\u001a\u00020\u001d2\u0006\u00106\u001a\u00020-2\u000e\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0F2\u0006\u0010G\u001a\u00020HH\u0016¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u001dH\u0014J\u0010\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020-H\u0016J\b\u0010M\u001a\u00020\u001dH\u0014J\b\u0010N\u001a\u00020\u001dH\u0002J\b\u0010O\u001a\u00020\u001dH\u0002J\u0010\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020$H\u0002J\b\u0010R\u001a\u00020\u001dH\u0002J\b\u0010S\u001a\u00020\u001dH\u0002J\b\u0010T\u001a\u00020\u001dH\u0003J\b\u0010U\u001a\u00020\u001dH\u0002J\b\u0010V\u001a\u00020\u001dH\u0002J\b\u0010W\u001a\u00020\u001dH\u0002J\u001c\u0010X\u001a\u00020\u001d2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0YH\u0003J\b\u0010Z\u001a\u00020\u001dH\u0003J\b\u0010[\u001a\u00020\u001dH\u0002J\b\u0010\\\u001a\u00020\u001dH\u0002J\b\u0010]\u001a\u00020\u001dH\u0002J\b\u0010^\u001a\u00020\u001dH\u0002J\u0018\u0010_\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010`\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020$H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006c"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGSettingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$OnTouchListener;", "Ljp/reifrontier/gym/ui/dialog/RFGSheetDialog$SheetDialogListener;", "Ljp/reifrontier/gym/ui/dialog/RFGErrorDialog$ErrorDialogListener;", "Ljp/reifrontier/gym/ui/dialog/RFGConfirmDialog$ConfirmDialogListener;", "()V", "isLoading", "", "mAdapter", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter;", "mDownloadData", "", "Ljava/util/Date;", "mLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "mRealm", "Lio/realm/Realm;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "twaLauncher", "Lcom/google/androidbrowserhelper/trusted/TwaLauncher;", "user", "Ljp/reifrontier/gym/domain/api/RFGUser;", "getUser", "()Ljp/reifrontier/gym/domain/api/RFGUser;", "setUser", "(Ljp/reifrontier/gym/domain/api/RFGUser;)V", "accessGoogleFit", "", "changeGoogleFitSetting", "on", "changePushSetting", "confirmRemoveData", "createSetting", "", "Ljp/reifrontier/gym/domain/app/RFGSetting;", "createZip", "files", "", "path", "download", "downloadDaily", "downloadDialog", "count", "", "message", "downloadHistory", "errorDialog", "title", "logout", "mailSetting", "mailZip", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDismiss", "cancel", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSelect", "type", "onStart", "openGFitInstallDialog", "openGoogleFitDialog", "openLink", "setting", "openProfile", "openWebView", "osLocationSetting", "osSetting", "passSetting", "requestActivityRecognition", "requestUpdate", "Ljava/util/HashMap;", "requestUser", "sendMail", "setRecyclerViewLayoutManager", "startLoading", "stopLoading", "switch", "touch", "Companion", "LinkType", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity */
public final class RFGSettingActivity extends AppCompatActivity implements RFGSettingAdapter.OnTouchListener, RFGSheetDialog.SheetDialogListener, RFGErrorDialog.ErrorDialogListener, RFGConfirmDialog.ConfirmDialogListener {
    private static final int ACTIVITY_RECOGNITION_PERMISSIONS_REQUEST_CODE = 526;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int GOOGLE_FIT_PERMISSIONS_REQUEST_CODE = 525;
    public static final String RESULT_KEY_REQUEST_DELETE_DATA = "resultKeyRequestDeleteData";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean isLoading;
    /* access modifiers changed from: private */
    public RFGSettingAdapter mAdapter;
    private List<Date> mDownloadData = new ArrayList();
    private RecyclerView.LayoutManager mLayoutManager;
    /* access modifiers changed from: private */
    public Realm mRealm;
    private RecyclerView mRecyclerView;
    private C1562e twaLauncher;
    private RFGUser user;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGSettingActivity$Companion;", "", "()V", "ACTIVITY_RECOGNITION_PERMISSIONS_REQUEST_CODE", "", "GOOGLE_FIT_PERMISSIONS_REQUEST_CODE", "RESULT_KEY_REQUEST_DELETE_DATA", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGSettingActivity$LinkType;", "", "(Ljava/lang/String;I)V", "NONE", "OPEN_LINK", "MAIL_ZIP", "OPEN_WEB_VIEW", "DOWNLOAD_HISTORY", "PROFILE_SETTING", "MAIL_SETTING", "LOGOUT", "PASS_SETTING", "OS_SETTING", "PUSH_SETTING", "GOOGLE_FIT", "OS_LOCATION_SETTING", "REMOVE_DATA", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$LinkType */
    private enum LinkType {
        NONE,
        OPEN_LINK,
        MAIL_ZIP,
        OPEN_WEB_VIEW,
        DOWNLOAD_HISTORY,
        PROFILE_SETTING,
        MAIL_SETTING,
        LOGOUT,
        PASS_SETTING,
        OS_SETTING,
        PUSH_SETTING,
        GOOGLE_FIT,
        OS_LOCATION_SETTING,
        REMOVE_DATA;
        
        public static final Companion Companion = null;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGSettingActivity$LinkType$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/activity/RFGSettingActivity$LinkType;", "value", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$LinkType$Companion */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final LinkType getType(int i) {
                return LinkType.values()[i];
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LinkType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LinkType linkType = LinkType.OPEN_LINK;
            iArr[1] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            LinkType linkType2 = LinkType.MAIL_ZIP;
            iArr2[2] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            LinkType linkType3 = LinkType.OPEN_WEB_VIEW;
            iArr3[3] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            LinkType linkType4 = LinkType.DOWNLOAD_HISTORY;
            iArr4[4] = 4;
            int[] iArr5 = $EnumSwitchMapping$0;
            LinkType linkType5 = LinkType.MAIL_SETTING;
            iArr5[6] = 5;
            int[] iArr6 = $EnumSwitchMapping$0;
            LinkType linkType6 = LinkType.LOGOUT;
            iArr6[7] = 6;
            int[] iArr7 = $EnumSwitchMapping$0;
            LinkType linkType7 = LinkType.PASS_SETTING;
            iArr7[8] = 7;
            int[] iArr8 = $EnumSwitchMapping$0;
            LinkType linkType8 = LinkType.OS_SETTING;
            iArr8[9] = 8;
            int[] iArr9 = $EnumSwitchMapping$0;
            LinkType linkType9 = LinkType.OS_LOCATION_SETTING;
            iArr9[12] = 9;
            int[] iArr10 = $EnumSwitchMapping$0;
            LinkType linkType10 = LinkType.PROFILE_SETTING;
            iArr10[5] = 10;
            int[] iArr11 = $EnumSwitchMapping$0;
            LinkType linkType11 = LinkType.REMOVE_DATA;
            iArr11[13] = 11;
            int[] iArr12 = new int[LinkType.values().length];
            $EnumSwitchMapping$1 = iArr12;
            LinkType linkType12 = LinkType.PUSH_SETTING;
            iArr12[10] = 1;
            int[] iArr13 = $EnumSwitchMapping$1;
            LinkType linkType13 = LinkType.GOOGLE_FIT;
            iArr13[11] = 2;
        }
    }

    private final void accessGoogleFit() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "cal");
        instance.setTime(new Date());
        long timeInMillis = instance.getTimeInMillis();
        instance.add(5, -1);
        DataReadRequest build = new DataReadRequest.Builder().read(DataType.TYPE_STEP_COUNT_DELTA).setTimeRange(instance.getTimeInMillis(), timeInMillis, TimeUnit.MILLISECONDS).build();
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (lastSignedInAccount != null) {
            Intrinsics.checkExpressionValueIsNotNull(lastSignedInAccount, "GoogleSignIn.getLastSign…         return\n        }");
            Fitness.getHistoryClient((Activity) this, lastSignedInAccount).readData(build).addOnSuccessListener(new RFGSettingActivity$accessGoogleFit$1(this)).addOnFailureListener(new RFGSettingActivity$accessGoogleFit$2(this)).addOnCompleteListener(RFGSettingActivity$accessGoogleFit$3.INSTANCE);
            return;
        }
        C1122a.m1599b("RFGSettingActivity GoogleSignIn.getLastSignedInAccount Error", new Object[0]);
        stopLoading();
        RFGSettingAdapter rFGSettingAdapter = this.mAdapter;
        if (rFGSettingAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGSettingAdapter.setData(createSetting());
        String string = getString(R.string.google_fit_error_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.google_fit_error_title)");
        String string2 = getString(R.string.google_fit_error_message);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.google_fit_error_message)");
        errorDialog(string, string2);
    }

    private final void changeGoogleFitSetting(boolean z) {
        if (RFGUtilsKt.hasInstalledGoogleFit(this)) {
            startLoading();
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400r", (String) null, 4, (Object) null);
            if (z) {
                FitnessOptions build = FitnessOptions.builder().addDataType(DataType.TYPE_STEP_COUNT_DELTA, 0).build();
                if (!GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(this), (GoogleSignInOptionsExtension) build)) {
                    C1122a.m1600c("[Gym]::Info GoogleSignIn.hasPermissions no", new Object[0]);
                    GoogleSignIn.requestPermissions((Activity) this, (int) GOOGLE_FIT_PERMISSIONS_REQUEST_CODE, GoogleSignIn.getLastSignedInAccount(this), (GoogleSignInOptionsExtension) build);
                    return;
                }
                C1122a.m1600c("[Gym]::Info GoogleSignIn.hasPermissions yes", new Object[0]);
                requestActivityRecognition();
                return;
            }
            RFGShared.INSTANCE.setIsUseGoogleFit(false);
            openGoogleFitDialog();
            return;
        }
        RFGSettingAdapter rFGSettingAdapter = this.mAdapter;
        if (rFGSettingAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGSettingAdapter.setData(createSetting());
        openGFitInstallDialog();
    }

    private final void changePushSetting(boolean z) {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400h", (String) null, 4, (Object) null);
        startLoading();
        String str = z ? "1" : RFGDef.DEFAULT_GYM_ID;
        HashMap hashMap = new HashMap();
        hashMap.put("push_allow", str);
        requestUpdate(hashMap);
    }

    private final void confirmRemoveData() {
        RFGConfirmDialog.Companion companion = RFGConfirmDialog.Companion;
        String string = getString(R.string.remove_all_data_confirm_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.remove_all_data_confirm_title)");
        String string2 = getString(R.string.remove_all_data_confirm_message);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.remov…all_data_confirm_message)");
        RFGConfirmDialog newInstance = companion.newInstance(string, string2, getString(R.string.remove_all_data_confirm_yes), getString(R.string.remove_all_data_confirm_no));
        newInstance.setListener(new RFGSettingActivity$confirmRemoveData$$inlined$apply$lambda$1(this));
        newInstance.show(getSupportFragmentManager(), "remove-all-data-confirm");
    }

    /* access modifiers changed from: private */
    public final List<RFGSetting> createSetting() {
        ArrayList arrayList = new ArrayList();
        RFGSettingAdapter.SettingViewType settingViewType = RFGSettingAdapter.SettingViewType.SECTION;
        String a = C0681a.m327a(this, (int) R.string.setting_app, "resources.getString(R.string.setting_app)");
        LinkType linkType = LinkType.NONE;
        RFGSetting rFGSetting = new RFGSetting(settingViewType, a, false, false, 0, "");
        RFGSettingAdapter.SettingViewType settingViewType2 = RFGSettingAdapter.SettingViewType.SECTION;
        String a2 = C0681a.m327a(this, (int) R.string.setting_push, "resources.getString(R.string.setting_push)");
        LinkType linkType2 = LinkType.NONE;
        RFGSetting rFGSetting2 = new RFGSetting(settingViewType2, a2, false, false, 0, "");
        RFGSettingAdapter.SettingViewType settingViewType3 = RFGSettingAdapter.SettingViewType.SECTION;
        String a3 = C0681a.m327a(this, (int) R.string.setting_support, "resources.getString(R.string.setting_support)");
        LinkType linkType3 = LinkType.NONE;
        RFGSetting rFGSetting3 = new RFGSetting(settingViewType3, a3, false, false, 0, "");
        RFGSettingAdapter.SettingViewType settingViewType4 = RFGSettingAdapter.SettingViewType.SECTION;
        String a4 = C0681a.m327a(this, (int) R.string.setting_about, "resources.getString(R.string.setting_about)");
        LinkType linkType4 = LinkType.NONE;
        RFGSetting rFGSetting4 = new RFGSetting(settingViewType4, a4, false, false, 0, "");
        RFGSettingAdapter.SettingViewType settingViewType5 = RFGSettingAdapter.SettingViewType.SECTION;
        String a5 = C0681a.m327a(this, (int) R.string.setting_about_admin, "resources.getString(R.string.setting_about_admin)");
        LinkType linkType5 = LinkType.NONE;
        RFGSetting rFGSetting5 = new RFGSetting(settingViewType5, a5, false, false, 0, "");
        boolean isUseGoogleFit = RFGShared.INSTANCE.isUseGoogleFit();
        RFGSettingAdapter.SettingViewType settingViewType6 = RFGSettingAdapter.SettingViewType.ITEM;
        String a6 = C0681a.m327a(this, (int) R.string.setting_google_fit, "resources.getString(R.string.setting_google_fit)");
        LinkType linkType6 = LinkType.GOOGLE_FIT;
        RFGSetting rFGSetting6 = new RFGSetting(settingViewType6, a6, true, isUseGoogleFit, 11, "");
        RFGSettingAdapter.SettingViewType settingViewType7 = RFGSettingAdapter.SettingViewType.ITEM;
        String a7 = C0681a.m327a(this, (int) R.string.setting_download, "resources.getString(R.string.setting_download)");
        LinkType linkType7 = LinkType.DOWNLOAD_HISTORY;
        RFGSetting rFGSetting7 = r10;
        RFGSetting rFGSetting8 = new RFGSetting(settingViewType7, a7, false, false, 4, "");
        RFGSettingAdapter.SettingViewType settingViewType8 = RFGSettingAdapter.SettingViewType.ITEM;
        String a8 = C0681a.m327a(this, (int) R.string.sanriku_setting_profile, "resources.getString(R.st….sanriku_setting_profile)");
        LinkType linkType8 = LinkType.PROFILE_SETTING;
        RFGSetting rFGSetting9 = new RFGSetting(settingViewType8, a8, false, false, 5, "");
        RFGSettingAdapter.SettingViewType settingViewType9 = RFGSettingAdapter.SettingViewType.ITEM;
        String a9 = C0681a.m327a(this, (int) R.string.setting_mail, "resources.getString(R.string.setting_mail)");
        LinkType linkType9 = LinkType.MAIL_SETTING;
        RFGSetting rFGSetting10 = r10;
        RFGSetting rFGSetting11 = rFGSetting9;
        RFGSetting rFGSetting12 = new RFGSetting(settingViewType9, a9, false, false, 6, "");
        RFGSettingAdapter.SettingViewType settingViewType10 = RFGSettingAdapter.SettingViewType.ITEM;
        String a10 = C0681a.m327a(this, (int) R.string.setting_password, "resources.getString(R.string.setting_password)");
        LinkType linkType10 = LinkType.PASS_SETTING;
        RFGSetting rFGSetting13 = new RFGSetting(settingViewType10, a10, false, false, 8, "");
        RFGUser rFGUser = this.user;
        if (rFGUser == null) {
            Intrinsics.throwNpe();
        }
        boolean areEqual = Intrinsics.areEqual((Object) rFGUser.getPushAllow(), (Object) "1");
        RFGSettingAdapter.SettingViewType settingViewType11 = RFGSettingAdapter.SettingViewType.ITEM;
        String a11 = C0681a.m327a(this, (int) R.string.setting_push_on, "resources.getString(R.string.setting_push_on)");
        LinkType linkType11 = LinkType.PUSH_SETTING;
        RFGSetting rFGSetting14 = new RFGSetting(settingViewType11, a11, true, areEqual, 10, "");
        RFGSettingAdapter.SettingViewType settingViewType12 = RFGSettingAdapter.SettingViewType.ITEM;
        String a12 = C0681a.m327a(this, (int) R.string.setting_os, "resources.getString(R.string.setting_os)");
        LinkType linkType12 = LinkType.OS_LOCATION_SETTING;
        RFGSetting rFGSetting15 = new RFGSetting(settingViewType12, a12, false, false, 12, "");
        RFGSettingAdapter.SettingViewType settingViewType13 = RFGSettingAdapter.SettingViewType.ITEM;
        String a13 = C0681a.m327a(this, (int) R.string.setting_os_app, "resources.getString(R.string.setting_os_app)");
        LinkType linkType13 = LinkType.OS_SETTING;
        RFGSetting rFGSetting16 = new RFGSetting(settingViewType13, a13, false, false, 9, "");
        RFGSettingAdapter.SettingViewType settingViewType14 = RFGSettingAdapter.SettingViewType.ITEM;
        String a14 = C0681a.m327a(this, (int) R.string.setting_help, "resources.getString(R.string.setting_help)");
        LinkType linkType14 = LinkType.OPEN_LINK;
        RFGSetting rFGSetting17 = r13;
        RFGSetting rFGSetting18 = rFGSetting4;
        RFGSetting rFGSetting19 = new RFGSetting(settingViewType14, a14, false, false, 1, BuildConfig.URL_HELP);
        RFGSettingAdapter.SettingViewType settingViewType15 = RFGSettingAdapter.SettingViewType.ITEM;
        String a15 = C0681a.m327a(this, (int) R.string.setting_open_mail, "resources.getString(R.string.setting_open_mail)");
        LinkType linkType15 = LinkType.MAIL_ZIP;
        RFGSetting rFGSetting20 = new RFGSetting(settingViewType15, a15, false, false, 2, "");
        RFGSettingAdapter.SettingViewType settingViewType16 = RFGSettingAdapter.SettingViewType.ITEM;
        RFGSetting rFGSetting21 = rFGSetting20;
        String a16 = C0681a.m327a(this, (int) R.string.setting_remove_all_data, "resources.getString(R.st….setting_remove_all_data)");
        LinkType linkType16 = LinkType.REMOVE_DATA;
        RFGSetting rFGSetting22 = r14;
        RFGSetting rFGSetting23 = new RFGSetting(settingViewType16, a16, false, false, 13, "");
        RFGSettingAdapter.SettingViewType settingViewType17 = RFGSettingAdapter.SettingViewType.ITEM;
        String a17 = C0681a.m327a(this, (int) R.string.setting_terms, "resources.getString(R.string.setting_terms)");
        LinkType linkType17 = LinkType.OPEN_LINK;
        RFGSetting rFGSetting24 = new RFGSetting(settingViewType17, a17, false, false, 1, BuildConfig.URL_TERMS);
        RFGSettingAdapter.SettingViewType settingViewType18 = RFGSettingAdapter.SettingViewType.ITEM;
        String a18 = C0681a.m327a(this, (int) R.string.setting_policy, "resources.getString(R.string.setting_policy)");
        LinkType linkType18 = LinkType.OPEN_LINK;
        RFGSetting rFGSetting25 = r14;
        RFGSetting rFGSetting26 = new RFGSetting(settingViewType18, a18, false, false, 1, BuildConfig.URL_POLICY);
        RFGSettingAdapter.SettingViewType settingViewType19 = RFGSettingAdapter.SettingViewType.ITEM;
        RFGSetting rFGSetting27 = rFGSetting17;
        String a19 = C0681a.m327a(this, (int) R.string.setting_library, "resources.getString(R.string.setting_library)");
        LinkType linkType19 = LinkType.OPEN_WEB_VIEW;
        RFGSetting rFGSetting28 = new RFGSetting(settingViewType19, a19, false, false, 3, "");
        RFGSettingAdapter.SettingViewType settingViewType20 = RFGSettingAdapter.SettingViewType.ITEM;
        RFGSetting rFGSetting29 = rFGSetting28;
        String string = getResources().getString(R.string.setting_version, new Object[]{BuildConfig.VERSION_NAME, 24});
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…BuildConfig.VERSION_CODE)");
        LinkType linkType20 = LinkType.NONE;
        RFGSetting rFGSetting30 = new RFGSetting(settingViewType20, string, false, false, 0, "");
        RFGSettingAdapter.SettingViewType settingViewType21 = RFGSettingAdapter.SettingViewType.ITEM;
        String a20 = C0681a.m327a(this, (int) R.string.setting_web, "resources.getString(R.string.setting_web)");
        LinkType linkType21 = LinkType.OPEN_LINK;
        RFGSetting rFGSetting31 = new RFGSetting(settingViewType21, a20, false, false, 1, BuildConfig.URL_WEB);
        arrayList.add(rFGSetting);
        arrayList.add(rFGSetting6);
        arrayList.add(rFGSetting7);
        arrayList.add(rFGSetting11);
        arrayList.add(rFGSetting10);
        arrayList.add(rFGSetting13);
        arrayList.add(rFGSetting2);
        arrayList.add(rFGSetting14);
        arrayList.add(rFGSetting15);
        arrayList.add(rFGSetting16);
        arrayList.add(rFGSetting3);
        arrayList.add(rFGSetting27);
        arrayList.add(rFGSetting21);
        arrayList.add(rFGSetting22);
        arrayList.add(rFGSetting18);
        arrayList.add(rFGSetting24);
        arrayList.add(rFGSetting25);
        arrayList.add(rFGSetting29);
        arrayList.add(rFGSetting30);
        arrayList.add(rFGSetting5);
        arrayList.add(rFGSetting31);
        return arrayList;
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
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.activity.RFGSettingActivity.createZip(java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void download() {
        if (this.mDownloadData.size() > 0) {
            Date date = this.mDownloadData.get(0);
            this.mDownloadData.remove(0);
            Intrinsics.checkExpressionValueIsNotNull(SilentLogOperation.Companion.getInstance().getDataFor(date).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGSettingActivity$download$1(this, date), new RFGSettingActivity$download$2(this)), "SilentLogOperation.insta…load()\n                })");
            return;
        }
        stopLoading();
        errorDialog("お知らせ", "活動履歴の同期が終わりました");
    }

    private final void downloadDaily() {
        startLoading();
        download();
    }

    private final void downloadDialog(int i, String str) {
        RFGSheetDialog.Companion.newInstance(str, i).show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    private final void downloadHistory() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400a", (String) null, 4, (Object) null);
        startLoading();
        RFGUser rFGUser = this.user;
        if (rFGUser == null) {
            Intrinsics.throwNpe();
        }
        Date parse = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.JAPANESE).parse(rFGUser.getFirstDate());
        if (parse == null) {
            parse = new Date();
        }
        long time = parse.getTime();
        RFGShared.INSTANCE.setInstallDate(parse.getTime());
        int time2 = ((int) (((new Date().getTime() - time) / ((long) 1000)) / ((long) 86400))) - 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 2;
        if (time2 >= 0) {
            while (true) {
                Date later = RFGUtilsKt.later(parse, i);
                String format$default = RFLDailyUtilsKt.format$default(later, "yyyyMMdd'T'HHmmssZ", (String) null, 2, (Object) null);
                Realm realm = this.mRealm;
                if (realm == null) {
                    Intrinsics.throwNpe();
                }
                if (((RFGDay) realm.where(RFGDay.class).equalTo("date", format$default).findFirst()) == null) {
                    arrayList.add(later);
                }
                if (i == time2) {
                    break;
                }
                i++;
            }
        }
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, RFGSettingActivity$downloadHistory$sort$1.INSTANCE);
        int size = arrayList.size();
        stopLoading();
        if (size > 0) {
            ArrayList arrayList2 = new ArrayList();
            this.mDownloadData = arrayList2;
            arrayList2.addAll(sortedWith);
            if (this.mDownloadData.size() > 30) {
                i2 = 3;
            }
            downloadDialog(i2, C0681a.m327a(this, (int) R.string.setting_download_confirm, "resources.getString(R.st…setting_download_confirm)"));
            return;
        }
        errorDialog("エラー", C0681a.m327a(this, (int) R.string.setting_download_error, "resources.getString(R.st…g.setting_download_error)"));
    }

    /* access modifiers changed from: private */
    public final void errorDialog(String str, String str2) {
        RFGErrorDialog.Companion.newInstance(str, str2).show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    private final void logout() {
        Realm realm = this.mRealm;
        if (realm == null) {
            Intrinsics.throwNpe();
        }
        realm.executeTransaction(new RFGSettingActivity$logout$1(this));
        SilentLogOperation.Companion.getInstance().logoutApi();
        Intent intent = new Intent(this, RFGInitActivity.class);
        intent.addFlags(268468224);
        startActivity(intent);
        finish();
    }

    private final void mailSetting() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400f", (String) null, 4, (Object) null);
        startActivity(new Intent(this, RFGMailInfoActivity.class));
    }

    private final void mailZip() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400l", (String) null, 4, (Object) null);
        sendMail();
    }

    private final void openGFitInstallDialog() {
        String string = getString(R.string.google_fit_install_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.google_fit_install_title)");
        String string2 = getString(R.string.google_fit_install_message);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.google_fit_install_message)");
        RFGConfirmDialog newInstance$default = RFGConfirmDialog.Companion.newInstance$default(RFGConfirmDialog.Companion, string, string2, (String) null, (String) null, 12, (Object) null);
        newInstance$default.setListener(this);
        newInstance$default.show(getSupportFragmentManager(), RFGConfirmDialog.Companion.getTAG());
    }

    /* access modifiers changed from: private */
    public final void openGoogleFitDialog() {
        stopLoading();
        String string = getString(R.string.google_fit_success_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.google_fit_success_title)");
        String string2 = getString(R.string.google_fit_success_message);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.google_fit_success_message)");
        RFGErrorDialog newInstance = RFGErrorDialog.Companion.newInstance(string, string2);
        newInstance.setListener(this);
        newInstance.show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void openLink(p043jp.reifrontier.gym.domain.app.RFGSetting r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getLink()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1157626107: goto L_0x002d;
                case -558041319: goto L_0x0022;
                case -187619957: goto L_0x0017;
                case 1209569629: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0038
        L_0x000c:
            java.lang.String r1 = "https://santetsu.rei-frontier.jp/faq"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = "400k"
            goto L_0x003a
        L_0x0017:
            java.lang.String r1 = "https://santetsu.rei-frontier.jp/policy"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = "400n"
            goto L_0x003a
        L_0x0022:
            java.lang.String r1 = "https://santetsu.rei-frontier.jp/"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = "400p"
            goto L_0x003a
        L_0x002d:
            java.lang.String r1 = "https://santetsu.rei-frontier.jp/term"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = "400m"
            goto L_0x003a
        L_0x0038:
            java.lang.String r0 = "999"
        L_0x003a:
            r3 = r0
            jp.reifrontier.gym.data.analytics.RFGAnalyticsManager r1 = p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager.INSTANCE
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r2 = "400"
            p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager.sendEvent$default(r1, r2, r3, r4, r5, r6)
            androidx.browser.trusted.TrustedWebActivityIntentBuilder r0 = new androidx.browser.trusted.TrustedWebActivityIntentBuilder
            java.lang.String r8 = r8.getLink()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r0.<init>(r8)
            r8 = 2131034281(0x7f0500a9, float:1.7679075E38)
            int r8 = androidx.core.content.ContextCompat.getColor(r7, r8)
            androidx.browser.trusted.TrustedWebActivityIntentBuilder r8 = r0.setToolbarColor(r8)
            java.lang.String r0 = "TrustedWebActivityIntent…s, R.color.sanriku_blue))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r0)
            e.d.c.a.e r0 = r7.twaLauncher
            if (r0 == 0) goto L_0x0069
            r0.mo27327a()
        L_0x0069:
            e.d.c.a.e r0 = new e.d.c.a.e
            r0.<init>(r7)
            r7.twaLauncher = r0
            if (r0 == 0) goto L_0x0076
            r1 = 0
            r0.mo27330b(r8, r1, r1)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.activity.RFGSettingActivity.openLink(jp.reifrontier.gym.domain.app.RFGSetting):void");
    }

    private final void openProfile() {
        startActivity(new Intent(this, RFGProfileActivity.class));
    }

    private final void openWebView() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400o", (String) null, 4, (Object) null);
        startActivity(new Intent(this, RFGWebActivity.class));
    }

    @SuppressLint({"CheckResult"})
    private final void osLocationSetting() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400i", (String) null, 4, (Object) null);
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        startActivity(intent);
    }

    private final void osSetting() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400j", (String) null, 4, (Object) null);
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
        startActivity(intent);
    }

    private final void passSetting() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400g", (String) null, 4, (Object) null);
        startActivity(new Intent(this, RFGPasswordActivity.class));
    }

    private final void requestActivityRecognition() {
        if (Build.VERSION.SDK_INT >= 29) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACTIVITY_RECOGNITION", "com.google.android.gms.permission.ACTIVITY_RECOGNITION"}, ACTIVITY_RECOGNITION_PERMISSIONS_REQUEST_CODE);
        } else {
            accessGoogleFit();
        }
    }

    @SuppressLint({"CheckResult"})
    private final void requestUpdate(HashMap<String, String> hashMap) {
        C1714r<RFGH2Client.H2APIResponse> b = RFGH2Client.Companion.getINSTANCE().updateUser(hashMap).mo27434b(C1683a.m2378b());
        Intrinsics.checkExpressionValueIsNotNull(b, "RFGH2Client.INSTANCE.upd…scribeOn(Schedulers.io())");
        b.mo27429a(C1721a.m2428a()).mo27432a(new RFGSettingActivity$requestUpdate$1(this), RFGSettingActivity$requestUpdate$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUser() {
        RFGH2Client.Companion.getINSTANCE().userInfo().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGSettingActivity$requestUser$1(this), RFGSettingActivity$requestUser$2.INSTANCE);
    }

    private final void sendMail() {
        String str;
        String email;
        ArrayList arrayList = new ArrayList();
        List<String> listOf = CollectionsKt__CollectionsKt.listOf("1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5");
        String a = C0681a.m328a(new Object[]{getFilesDir(), getPackageName(), "-sdk.log"}, 3, "%s/%s%s", "java.lang.String.format(this, *args)");
        if (new File(a).exists()) {
            arrayList.add(a);
        }
        for (String str2 : listOf) {
            String str3 = a + '.' + str2;
            if (new File(str3).exists()) {
                arrayList.add(str3);
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
            String[] strArr = {getResources().getString(R.string.support_mail_to)};
            RFGUser rFGUser = this.user;
            String str4 = "";
            if (rFGUser == null || (str = rFGUser.getHandleName()) == null) {
                str = str4;
            }
            RFGUser rFGUser2 = this.user;
            if (!(rFGUser2 == null || (email = rFGUser2.getEmail()) == null)) {
                str4 = email;
            }
            intent.putExtra("android.intent.extra.EMAIL", strArr);
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayListOf);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.support_mail_subject));
            intent.putExtra("android.intent.extra.TEXT", getResources().getString(R.string.support_mail_body, new Object[]{str, str4}));
            intent.addFlags(3);
            startActivity(Intent.createChooser(intent, "Send email..."));
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
        this.mLayoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView3.setLayoutManager(this.mLayoutManager);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView4.scrollToPosition(i);
    }

    private final void startLoading() {
        this.isLoading = true;
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

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == GOOGLE_FIT_PERMISSIONS_REQUEST_CODE) {
            if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(this), (GoogleSignInOptionsExtension) FitnessOptions.builder().addDataType(DataType.TYPE_STEP_COUNT_DELTA, 0).build())) {
                C1122a.m1600c("[Gym]::Info onActivityResult hasPermissions yes", new Object[0]);
                requestActivityRecognition();
                return;
            }
            C1122a.m1599b("[Gym]::Error onActivityResult hasPermissions no", new Object[0]);
            stopLoading();
            RFGShared.INSTANCE.setIsUseGoogleFit(false);
            RFGSettingAdapter rFGSettingAdapter = this.mAdapter;
            if (rFGSettingAdapter == null) {
                Intrinsics.throwNpe();
            }
            rFGSettingAdapter.setData(createSetting());
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.isLoading) {
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400q", (String) null, 4, (Object) null);
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_setting);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar));
        Realm defaultInstance = Realm.getDefaultInstance();
        this.mRealm = defaultInstance;
        if (defaultInstance == null) {
            Intrinsics.throwNpe();
        }
        this.user = (RFGUser) defaultInstance.where(RFGUser.class).findFirst();
        this.mRecyclerView = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.settingRecyclerView);
        this.mLayoutManager = new LinearLayoutManager(this);
        setRecyclerViewLayoutManager();
        this.mAdapter = new RFGSettingAdapter(createSetting(), this);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwNpe();
        }
        RFGSettingAdapter rFGSettingAdapter = this.mAdapter;
        if (rFGSettingAdapter == null) {
            Intrinsics.throwNpe();
        }
        recyclerView.setAdapter(rFGSettingAdapter);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
        supportActionBar.setTitle((CharSequence) "設定");
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
        supportActionBar4.setHomeAsUpIndicator((int) R.mipmap.close);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Realm realm = this.mRealm;
        if (realm != null) {
            realm.close();
        }
        C1562e eVar = this.twaLauncher;
        if (eVar != null) {
            eVar.mo27327a();
        }
        this.twaLauncher = null;
        super.onDestroy();
    }

    public void onDismiss() {
        RFGPhoenixKt.triggerRebirth(this);
    }

    public void onDismiss(boolean z) {
        if (!z) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.fitness"));
            intent.addFlags(268468224);
            intent.addFlags(1073741824);
            startActivity(intent);
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

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == ACTIVITY_RECOGNITION_PERMISSIONS_REQUEST_CODE) {
            accessGoogleFit();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        RFGAnalyticsManager.INSTANCE.sendScreen("400");
    }

    public void onSelect(int i) {
        if (i == 0) {
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400b", (String) null, 4, (Object) null);
        } else if (i != 1) {
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400d", (String) null, 4, (Object) null);
            return;
        } else {
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "400", "400c", (String) null, 4, (Object) null);
            this.mDownloadData.subList(0, 29);
        }
        downloadDaily();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        RFGSettingAdapter rFGSettingAdapter = this.mAdapter;
        if (rFGSettingAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGSettingAdapter.notifyDataSetChanged();
    }

    public final void setUser(RFGUser rFGUser) {
        this.user = rFGUser;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m4600switch(RFGSetting rFGSetting, boolean z) {
        Intrinsics.checkParameterIsNotNull(rFGSetting, "setting");
        if (!this.isLoading) {
            int ordinal = LinkType.Companion.getType(rFGSetting.getLinkType()).ordinal();
            if (ordinal == 10) {
                changePushSetting(z);
            } else if (ordinal == 11) {
                changeGoogleFitSetting(z);
            }
        }
    }

    public void touch(RFGSetting rFGSetting) {
        Intrinsics.checkParameterIsNotNull(rFGSetting, "setting");
        if (!this.isLoading) {
            switch (LinkType.Companion.getType(rFGSetting.getLinkType()).ordinal()) {
                case 1:
                    openLink(rFGSetting);
                    return;
                case 2:
                    mailZip();
                    return;
                case 3:
                    openWebView();
                    return;
                case 4:
                    downloadHistory();
                    return;
                case 5:
                    openProfile();
                    return;
                case 6:
                    mailSetting();
                    return;
                case 7:
                    logout();
                    return;
                case 8:
                    passSetting();
                    return;
                case 9:
                    osSetting();
                    return;
                case 12:
                    osLocationSetting();
                    return;
                case 13:
                    confirmRemoveData();
                    return;
                default:
                    return;
            }
        }
    }
}
