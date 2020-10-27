package p043jp.reifrontier.gym.activity;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.isseiaoki.simplecropview.C1453c;
import com.isseiaoki.simplecropview.C1454d;
import com.isseiaoki.simplecropview.CropImageView;
import com.isseiaoki.simplecropview.p052h.C1463c;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0003\b\r\u0013\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001d\u001a\u00020\u0018J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0012\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020!H\u0016J\b\u0010*\u001a\u00020\u0018H\u0002J\u0006\u0010+\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGCropActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "isLoading", "", "mCompressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "mCropCallback", "jp/reifrontier/gym/activity/RFGCropActivity$mCropCallback$1", "Ljp/reifrontier/gym/activity/RFGCropActivity$mCropCallback$1;", "mFrameRect", "Landroid/graphics/RectF;", "mLoadCallback", "jp/reifrontier/gym/activity/RFGCropActivity$mLoadCallback$1", "Ljp/reifrontier/gym/activity/RFGCropActivity$mLoadCallback$1;", "mRatioX", "", "mRatioY", "mSaveCallback", "jp/reifrontier/gym/activity/RFGCropActivity$mSaveCallback$1", "Ljp/reifrontier/gym/activity/RFGCropActivity$mSaveCallback$1;", "mSourceUri", "Landroid/net/Uri;", "closeKeyboard", "", "createNewUri", "context", "Landroid/content/Context;", "createSaveUri", "crop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "startLoading", "stopLoading", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGCropActivity */
public final class RFGCropActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_FRAME_RECT = "FrameRect";
    private static final String KEY_SOURCE_URI = "SourceUri";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean isLoading;
    /* access modifiers changed from: private */
    public final Bitmap.CompressFormat mCompressFormat = Bitmap.CompressFormat.JPEG;
    private final RFGCropActivity$mCropCallback$1 mCropCallback = new RFGCropActivity$mCropCallback$1(this);
    private RectF mFrameRect;
    private final RFGCropActivity$mLoadCallback$1 mLoadCallback = new RFGCropActivity$mLoadCallback$1();
    private int mRatioX = 1;
    private final int mRatioY = 1;
    /* access modifiers changed from: private */
    public final RFGCropActivity$mSaveCallback$1 mSaveCallback = new RFGCropActivity$mSaveCallback$1(this);
    private Uri mSourceUri;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGCropActivity$Companion;", "", "()V", "KEY_FRAME_RECT", "", "KEY_SOURCE_URI", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGCropActivity$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void closeKeyboard() {
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

    private final Uri createNewUri(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = DateFormat.format("yyyyMMdd_kkmmss", new Date(currentTimeMillis)).toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", obj);
        contentValues.put("_display_name", "fileName");
        contentValues.put("mime_type", "image/jpg");
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + '/' + getPackageName() + "-folder");
        long j = currentTimeMillis / ((long) 1000);
        contentValues.put("date_added", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(j));
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private final void startLoading() {
        this.isLoading = true;
        closeKeyboard();
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.indicatorCover);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "indicatorCover");
        constraintLayout.setVisibility(0);
        ((RFGLoadingIndicator) _$_findCachedViewById(C2092R.C2094id.indicator)).smoothToShow();
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

    public final Uri createSaveUri() {
        return createNewUri(this);
    }

    public final void crop() {
        this.isLoading = true;
        startLoading();
        CropImageView cropImageView = (CropImageView) _$_findCachedViewById(C2092R.C2094id.cropImageView);
        Uri uri = this.mSourceUri;
        if (cropImageView != null) {
            new C1453c(cropImageView, uri).mo27155a(this.mCropCallback);
            return;
        }
        throw null;
    }

    public void onBackPressed() {
        if (!this.isLoading) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_crop);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar));
        if (bundle != null) {
            this.mFrameRect = (RectF) bundle.getParcelable(KEY_FRAME_RECT);
            this.mSourceUri = (Uri) bundle.getParcelable(KEY_SOURCE_URI);
        }
        if (this.mSourceUri == null) {
            this.mSourceUri = Uri.parse(getIntent().getStringExtra("imageUri"));
        }
        if (getIntent().hasExtra("ratioX")) {
            this.mRatioX = getIntent().getIntExtra("ratioX", 1);
        }
        CropImageView cropImageView = (CropImageView) _$_findCachedViewById(C2092R.C2094id.cropImageView);
        Uri uri = this.mSourceUri;
        if (cropImageView != null) {
            C1454d dVar = new C1454d(cropImageView, uri);
            dVar.mo27156a(this.mFrameRect);
            dVar.mo27157a(true);
            dVar.mo27158a((C1463c) this.mLoadCallback);
            ((CropImageView) _$_findCachedViewById(C2092R.C2094id.cropImageView)).mo27123a(CropImageView.C1448e.CUSTOM);
            ((CropImageView) _$_findCachedViewById(C2092R.C2094id.cropImageView)).mo27118a(this.mRatioX, this.mRatioY);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
            supportActionBar.setTitle((CharSequence) "画像を切り抜き");
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
            return;
        }
        throw null;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.crop, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            Intrinsics.throwNpe();
        }
        int itemId = menuItem.getItemId();
        if (itemId == R.id.finish_crop) {
            crop();
            return true;
        } else if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onBackPressed();
            return true;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        super.onSaveInstanceState(bundle);
        CropImageView cropImageView = (CropImageView) _$_findCachedViewById(C2092R.C2094id.cropImageView);
        Intrinsics.checkExpressionValueIsNotNull(cropImageView, "cropImageView");
        bundle.putParcelable(KEY_FRAME_RECT, cropImageView.mo27115a());
        CropImageView cropImageView2 = (CropImageView) _$_findCachedViewById(C2092R.C2094id.cropImageView);
        Intrinsics.checkExpressionValueIsNotNull(cropImageView2, "cropImageView");
        bundle.putParcelable(KEY_SOURCE_URI, cropImageView2.mo27124b());
    }

    public final void stopLoading() {
        this.isLoading = false;
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2092R.C2094id.indicatorCover);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "indicatorCover");
        constraintLayout.setVisibility(8);
        ((RFGLoadingIndicator) _$_findCachedViewById(C2092R.C2094id.indicator)).smoothToHide();
    }
}
