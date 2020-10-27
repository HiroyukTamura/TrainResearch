package p043jp.reifrontier.gym.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.squareup.picasso.C1473F;
import com.squareup.picasso.C1489e;
import com.squareup.picasso.C1508r;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1529y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.BuildConfig;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.p044ui.dialog.RFGBodyDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGCameraDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGDateDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;
import p043jp.reifrontier.gym.p044ui.dialog.RFGGenderDialog;
import p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator;
import p043jp.reifrontier.gym.p044ui.widget.RFGRadiusTransform;
import p043jp.reifrontier.gym.util.GymUtils;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\\B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\"\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0016J\u0012\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0012\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u000105H\u0016J \u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0016J\b\u0010:\u001a\u00020\u001eH\u0014J\u0012\u0010;\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J-\u0010>\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\n2\u000e\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0@2\u0006\u0010A\u001a\u00020BH\u0016¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020\u001eH\u0014J\u0018\u0010E\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020F2\u0006\u0010G\u001a\u00020\fH\u0016J\u0010\u0010E\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0016J\u0018\u0010H\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020F2\u0006\u0010G\u001a\u00020\fH\u0002J\b\u0010I\u001a\u00020\u001eH\u0002J\b\u0010J\u001a\u00020\u001eH\u0002J\b\u0010K\u001a\u00020\u001eH\u0002J\b\u0010L\u001a\u00020\u001eH\u0002J\b\u0010M\u001a\u00020\u001eH\u0002J\b\u0010N\u001a\u00020\u001eH\u0002J\b\u0010O\u001a\u00020\u001eH\u0003J\b\u0010P\u001a\u00020\u001eH\u0002J\u001c\u0010Q\u001a\u00020\u001e2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0RH\u0003J\b\u0010S\u001a\u00020\u001eH\u0003J\b\u0010T\u001a\u00020\u001eH\u0003J\u0010\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\fH\u0003J\b\u0010W\u001a\u00020\u001eH\u0002J\b\u0010X\u001a\u00020\u001eH\u0002J\b\u0010Y\u001a\u00020\u001eH\u0002J\b\u0010Z\u001a\u00020\u001eH\u0002J\u0014\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0RH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGEditActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ljp/reifrontier/gym/ui/dialog/RFGDateDialog$DateDialogListener;", "Ljp/reifrontier/gym/ui/dialog/RFGGenderDialog$GenderDialogListener;", "Ljp/reifrontier/gym/ui/dialog/RFGCameraDialog$CameraDialogListener;", "Ljp/reifrontier/gym/ui/dialog/RFGBodyDialog$PickerDialogListener;", "()V", "beforeBirthDay", "Ljava/util/Date;", "cameraType", "", "currentGender", "", "hasIconChanged", "", "isLoading", "mCameraUri", "Landroid/net/Uri;", "mRealm", "Lio/realm/Realm;", "mSaveUri", "updateBirthday", "user", "Ljp/reifrontier/gym/domain/api/RFGUser;", "getUser", "()Ljp/reifrontier/gym/domain/api/RFGUser;", "setUser", "(Ljp/reifrontier/gym/domain/api/RFGUser;)V", "weightFeedId", "camera", "", "checkManifest", "closeKeyboard", "cropFromCamera", "cropFromGallery", "errorDialog", "message", "finishEdit", "finishEditActivity", "gallery", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCameraSelect", "type", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDateSelect", "year", "month", "day", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSelect", "Ljp/reifrontier/gym/RFGDef$BodyType;", "value", "openBodySheet", "openCamera", "openCameraSheet", "openDateSheet", "openGallery", "openGenderSheet", "requestError", "requestFeed", "requestPermission", "requestUpdate", "Ljava/util/HashMap;", "requestUpdateIcon", "requestUser", "requestWeightUpdated", "feedId", "setupEdit", "startLoading", "stopLoading", "update", "updateParam", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGEditActivity */
public final class RFGEditActivity extends AppCompatActivity implements RFGDateDialog.DateDialogListener, RFGGenderDialog.GenderDialogListener, RFGCameraDialog.CameraDialogListener, RFGBodyDialog.PickerDialogListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REQ_CAMERA = 1984;
    private static final int REQ_CROP = 216;
    private static final int REQ_GALLERY = 2016;
    private static final int REQ_PERMISSION = 1982;
    private HashMap _$_findViewCache;
    private Date beforeBirthDay = new Date(631197119000L);
    private int cameraType;
    private String currentGender = "男性";
    private boolean hasIconChanged;
    private boolean isLoading;
    private Uri mCameraUri;
    /* access modifiers changed from: private */
    public Realm mRealm;
    private Uri mSaveUri;
    private Date updateBirthday = new Date(631197119000L);
    private RFGUser user;
    /* access modifiers changed from: private */
    public String weightFeedId;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGEditActivity$Companion;", "", "()V", "REQ_CAMERA", "", "REQ_CROP", "REQ_GALLERY", "REQ_PERMISSION", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGEditActivity$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGEditActivity$WhenMappings */
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

    /* access modifiers changed from: private */
    public final void errorDialog(String str) {
        RFGErrorDialog.Companion.newInstance$default(RFGErrorDialog.Companion, (String) null, str, 1, (Object) null).show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    /* access modifiers changed from: private */
    public final void finishEdit() {
        if (!this.isLoading) {
            boolean z = false;
            if (this.weightFeedId != null) {
                HashMap<String, String> updateParam = updateParam();
                if (updateParam.size() > 0) {
                    z = updateParam.containsKey("weight");
                }
            }
            if (z) {
                String str = this.weightFeedId;
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                requestWeightUpdated(str);
                return;
            }
            update();
        }
    }

    /* access modifiers changed from: private */
    public final void finishEditActivity() {
        onBackPressed();
    }

    private final void gallery() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
        intent.setType("image/jpeg");
        startActivityForResult(Intent.createChooser(intent, "画像を選択"), REQ_GALLERY);
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

    /* access modifiers changed from: private */
    public final void openDateSheet() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(this.updateBirthday);
        RFGDateDialog.Companion.newInstance(instance.get(1), instance.get(2), instance.get(5)).show(getSupportFragmentManager(), RFGDateDialog.Companion.getTAG());
    }

    private final void openGallery() {
        if (checkManifest()) {
            gallery();
        } else {
            requestPermission();
        }
    }

    /* access modifiers changed from: private */
    public final void openGenderSheet() {
        RFGGenderDialog.Companion.newInstance().show(getSupportFragmentManager(), RFGGenderDialog.Companion.getTAG());
    }

    /* access modifiers changed from: private */
    public final void requestError() {
        stopLoading();
        String string = getString(R.string.error_update_user_info);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.error_update_user_info)");
        errorDialog(string);
    }

    @SuppressLint({"CheckResult"})
    private final void requestFeed() {
        startLoading();
        RFGH2Client.Companion.getINSTANCE().feed(RFLDailyUtilsKt.format(RFGUtilsKt.ago(RFLDailyUtilsKt.start(new Date()), 6), "yyyyMMdd", "GMT")).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGEditActivity$requestFeed$1(this), new RFGEditActivity$requestFeed$2(this));
    }

    private final void requestPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, REQ_PERMISSION);
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUpdate(HashMap<String, String> hashMap) {
        hashMap.put("push_device_id", RFGShared.INSTANCE.token());
        RFGH2Client.Companion.getINSTANCE().updateUser(hashMap).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGEditActivity$requestUpdate$1(this), new RFGEditActivity$requestUpdate$2(this));
    }

    @SuppressLint({"CheckResult"})
    private final void requestUpdateIcon() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        StringBuilder sb = new StringBuilder();
        RFGUser rFGUser = this.user;
        if (rFGUser == null) {
            Intrinsics.throwNpe();
        }
        sb.append(rFGUser.getIcon());
        sb.append(RFGDef.IMAGE_URL_SUFFIX);
        sb.append(accessToken);
        C1513u.m2068b().mo27250a(sb.toString());
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
        RFGH2Client.Companion.getINSTANCE().uploadPhoto(file).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGEditActivity$requestUpdateIcon$1(this), new RFGEditActivity$requestUpdateIcon$2(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUser() {
        RFGShared.INSTANCE.setRequestFeed(0);
        RFGH2Client.Companion.getINSTANCE().userInfo().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGEditActivity$requestUser$1(this), new RFGEditActivity$requestUser$2(this));
    }

    @SuppressLint({"CheckResult"})
    private final void requestWeightUpdated(String str) {
        startLoading();
        RFGShared.INSTANCE.setRequestFeed(0);
        HashMap hashMap = new HashMap();
        hashMap.put("feed_id", str);
        RFGH2Client.Companion.getINSTANCE().userAction(hashMap).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGEditActivity$requestWeightUpdated$1(this), new RFGEditActivity$requestWeightUpdated$2(this));
    }

    private final void setupEdit() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        StringBuilder sb = new StringBuilder();
        RFGUser rFGUser = this.user;
        if (rFGUser == null) {
            Intrinsics.throwNpe();
        }
        sb.append(rFGUser.getIcon());
        sb.append(RFGDef.IMAGE_URL_SUFFIX);
        sb.append(accessToken);
        C1529y b = C1513u.m2068b().mo27251b(sb.toString());
        b.mo27279a((C1473F) new RFGRadiusTransform(-1.0f));
        b.mo27280a(C1508r.NO_CACHE, new C1508r[0]);
        b.mo27281a((ImageView) _$_findCachedViewById(C2092R.C2094id.editIcon), (C1489e) new RFGEditActivity$setupEdit$1());
        ((ImageView) _$_findCachedViewById(C2092R.C2094id.editIcon)).setOnClickListener(new RFGEditActivity$setupEdit$2(this));
        ((Button) _$_findCachedViewById(C2092R.C2094id.editIconButton)).setOnClickListener(new RFGEditActivity$setupEdit$3(this));
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.editName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editName");
        Drawable background = editText.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(background, "editName.background");
        background.setAlpha(0);
        EditText editText2 = (EditText) _$_findCachedViewById(C2092R.C2094id.editName);
        RFGUser rFGUser2 = this.user;
        if (rFGUser2 == null) {
            Intrinsics.throwNpe();
        }
        editText2.setText(rFGUser2.getHandleName());
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editHeight);
        Intrinsics.checkExpressionValueIsNotNull(textView, "editHeight");
        Resources resources = getResources();
        Object[] objArr = new Object[1];
        RFGUser rFGUser3 = this.user;
        if (rFGUser3 == null) {
            Intrinsics.throwNpe();
        }
        objArr[0] = rFGUser3.height();
        textView.setText(resources.getString(R.string.unit_cm, objArr));
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.editWeight);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "editWeight");
        Resources resources2 = getResources();
        Object[] objArr2 = new Object[1];
        RFGUser rFGUser4 = this.user;
        if (rFGUser4 == null) {
            Intrinsics.throwNpe();
        }
        objArr2[0] = rFGUser4.weight();
        textView2.setText(resources2.getString(R.string.unit_kg, objArr2));
        ((TextView) _$_findCachedViewById(C2092R.C2094id.editHeight)).setOnClickListener(new RFGEditActivity$setupEdit$4(this));
        ((TextView) _$_findCachedViewById(C2092R.C2094id.editWeight)).setOnClickListener(new RFGEditActivity$setupEdit$5(this));
        GymUtils gymUtils = GymUtils.INSTANCE;
        RFGUser rFGUser5 = this.user;
        if (rFGUser5 == null) {
            Intrinsics.throwNpe();
        }
        this.currentGender = gymUtils.genderFrom(rFGUser5.getGender());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN);
        RFGUser rFGUser6 = this.user;
        if (rFGUser6 == null) {
            Intrinsics.throwNpe();
        }
        Date parse = simpleDateFormat.parse(rFGUser6.getBirthday());
        Intrinsics.checkExpressionValueIsNotNull(parse, "dateFormat.parse(user!!.birthday)");
        this.updateBirthday = parse;
        this.beforeBirthDay = parse;
        String formaaat11$default = RFGUtilsKt.formaaat11$default(parse, "yyyy年M月d日", (String) null, 2, (Object) null);
        TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.editBirthday);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "editBirthday");
        textView3.setText(formaaat11$default);
        ((TextView) _$_findCachedViewById(C2092R.C2094id.editBirthday)).setOnClickListener(new RFGEditActivity$setupEdit$6(this));
        TextView textView4 = (TextView) _$_findCachedViewById(C2092R.C2094id.editGender);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "editGender");
        textView4.setText(this.currentGender);
        ((TextView) _$_findCachedViewById(C2092R.C2094id.editGender)).setOnClickListener(new RFGEditActivity$setupEdit$7(this));
        Button button = (Button) _$_findCachedViewById(C2092R.C2094id.editButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "editButton");
        button.setText("更新する");
        ((Button) _$_findCachedViewById(C2092R.C2094id.editButton)).setOnClickListener(new RFGEditActivity$setupEdit$8(this));
        TextView textView5 = (TextView) _$_findCachedViewById(C2092R.C2094id.profileMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "profileMessage");
        textView5.setVisibility(8);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.profileMessageLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "profileMessageLayout");
        constraintLayout.setVisibility(8);
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

    /* access modifiers changed from: private */
    public final void update() {
        if (this.hasIconChanged) {
            this.isLoading = true;
            startLoading();
            requestUpdateIcon();
            return;
        }
        HashMap<String, String> updateParam = updateParam();
        if (updateParam.size() > 0) {
            this.isLoading = true;
            startLoading();
            requestUpdate(updateParam);
            return;
        }
        finishEditActivity();
    }

    /* access modifiers changed from: private */
    public final HashMap<String, String> updateParam() {
        EditText editText = (EditText) _$_findCachedViewById(C2092R.C2094id.editName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editName");
        String obj = editText.getText().toString();
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.editHeight);
        Intrinsics.checkExpressionValueIsNotNull(textView, "editHeight");
        CharSequence text = textView.getText();
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.editWeight);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "editWeight");
        CharSequence text2 = textView2.getText();
        TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.editGender);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "editGender");
        String str = Intrinsics.areEqual((Object) textView3.getText(), (Object) "女性") ? "female" : RFLAccountManager.DEFAULT_GENDER;
        HashMap<String, String> hashMap = new HashMap<>();
        RFGUser rFGUser = this.user;
        if (rFGUser == null) {
            Intrinsics.throwNpe();
        }
        if (!Intrinsics.areEqual((Object) obj, (Object) rFGUser.getHandleName())) {
            hashMap.put("handle_name", obj);
        }
        RFGUser rFGUser2 = this.user;
        if (rFGUser2 == null) {
            Intrinsics.throwNpe();
        }
        if (!Intrinsics.areEqual((Object) text, (Object) rFGUser2.height())) {
            Intrinsics.checkExpressionValueIsNotNull(text, "height");
            hashMap.put("height", StringsKt__StringsKt.split$default(text, new String[]{"c"}, false, 0, 6, (Object) null).get(0));
        }
        RFGUser rFGUser3 = this.user;
        if (rFGUser3 == null) {
            Intrinsics.throwNpe();
        }
        if (!Intrinsics.areEqual((Object) text2, (Object) rFGUser3.weight())) {
            Intrinsics.checkExpressionValueIsNotNull(text2, "weight");
            hashMap.put("weight", StringsKt__StringsKt.split$default(text2, new String[]{"k"}, false, 0, 6, (Object) null).get(0));
        }
        RFGUser rFGUser4 = this.user;
        if (rFGUser4 == null) {
            Intrinsics.throwNpe();
        }
        if (!Intrinsics.areEqual((Object) str, (Object) rFGUser4.getGender())) {
            hashMap.put("gender", str);
        }
        if (!Intrinsics.areEqual((Object) this.beforeBirthDay, (Object) this.updateBirthday)) {
            hashMap.put("birthday", RFGUtilsKt.formaaat11$default(this.updateBirthday, "yyyyMMdd", (String) null, 2, (Object) null));
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
            RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "401", "401b", (String) null, 4, (Object) null);
            super.onBackPressed();
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
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_edit);
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
        supportActionBar.setTitle((CharSequence) "プロフィールを編集");
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
        setupEdit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
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

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != REQ_PERMISSION || iArr[0] != 0) {
            return;
        }
        if (this.cameraType == 0) {
            camera();
        } else {
            gallery();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        RFGAnalyticsManager.INSTANCE.sendScreen("401");
        if (!this.isLoading) {
            requestFeed();
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

    public final void setUser(RFGUser rFGUser) {
        this.user = rFGUser;
    }
}
