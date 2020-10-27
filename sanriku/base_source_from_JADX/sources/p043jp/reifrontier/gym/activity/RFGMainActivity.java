package p043jp.reifrontier.gym.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.squareup.picasso.C1489e;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1529y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import org.greenrobot.eventbus.ThreadMode;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.RFGDataRemover;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.api.RFGPointClient;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.bus.RFGCompletedRemoveData;
import p043jp.reifrontier.gym.data.bus.RFGSelectedStation;
import p043jp.reifrontier.gym.data.bus.RFGUnauthorize;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.gym.domain.api.RFGFeed;
import p043jp.reifrontier.gym.domain.api.RFGServerActivity;
import p043jp.reifrontier.gym.domain.api.RFGSummaryHistory;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.domain.api.RFGUserCurrentYearPoint;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;
import p043jp.reifrontier.gym.domain.app.RFGAdapterActivity;
import p043jp.reifrontier.gym.domain.app.RFGAdapterSummary;
import p043jp.reifrontier.gym.domain.silentlog.RFGActivity;
import p043jp.reifrontier.gym.domain.silentlog.RFGDay;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrackPoint;
import p043jp.reifrontier.gym.fragment.RFGActFragment;
import p043jp.reifrontier.gym.fragment.RFGFeedFragment;
import p043jp.reifrontier.gym.fragment.RFGPointFragment;
import p043jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment;
import p043jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment;
import p043jp.reifrontier.gym.fragment.train.RFGSpotListFragment;
import p043jp.reifrontier.gym.fragment.train.RFGStationFragment;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;
import p043jp.reifrontier.gym.p044ui.tab.RFGFragNavController;
import p043jp.reifrontier.gym.p044ui.tab.RFGFragmentHistory;
import p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator;
import p043jp.reifrontier.gym.util.GymUtils;
import p043jp.reifrontier.gym.util.RFGLocationPermissionUtils;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000Á\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001c\u0018\u0000 ±\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n:\u0002±\u0001B\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J8\u00108\u001a\u0002052.\u00109\u001a*\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0,0:j\u0014\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0,`<H\u0002J\u0016\u0010=\u001a\u0002052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0,H\u0002J\u0018\u0010@\u001a\u0002052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010,H\u0002J\u001e\u0010C\u001a\u0002052\f\u0010D\u001a\b\u0012\u0004\u0012\u0002070,2\u0006\u0010E\u001a\u00020FH\u0002J\u0016\u0010G\u001a\u0002052\f\u0010H\u001a\b\u0012\u0004\u0012\u00020?0,H\u0002J\b\u0010I\u001a\u000205H\u0002J\b\u0010J\u001a\u000205H\u0002J\b\u0010K\u001a\u000205H\u0002J\b\u0010L\u001a\u000205H\u0002J\b\u0010M\u001a\u000205H\u0002J\b\u0010N\u001a\u000205H\u0002J\u0010\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020\u0017H\u0002J&\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0,2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020U2\u0006\u00106\u001a\u000207H\u0002J\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020'H\u0002J\u0010\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u0002052\u0006\u0010]\u001a\u00020'H\u0002J\u0010\u0010^\u001a\u00020W2\u0006\u0010_\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020`H\u0002J\u0010\u0010d\u001a\u0002052\u0006\u0010Z\u001a\u00020[H\u0002J\b\u0010e\u001a\u000205H\u0002J\u0012\u0010f\u001a\u0002052\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\b\u0010i\u001a\u000205H\u0016J\u0010\u0010j\u001a\u0002052\u0006\u0010S\u001a\u00020%H\u0016J\b\u0010k\u001a\u000205H\u0016J\"\u0010l\u001a\u0002052\u0006\u0010m\u001a\u00020`2\u0006\u0010n\u001a\u00020`2\b\u0010o\u001a\u0004\u0018\u00010pH\u0014J\b\u0010q\u001a\u000205H\u0016J\u0010\u0010r\u001a\u0002052\u0006\u0010s\u001a\u00020tH\u0007J\u0012\u0010u\u001a\u0002052\b\u0010g\u001a\u0004\u0018\u00010hH\u0014J\u0012\u0010v\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010w\u001a\u000205H\u0014J\u0018\u0010x\u001a\u0002052\u0006\u0010y\u001a\u00020W2\u0006\u0010z\u001a\u00020{H\u0016J\u0012\u0010|\u001a\u00020\u00172\b\u0010}\u001a\u0004\u0018\u00010~H\u0016J\u0012\u0010\u001a\u0002052\b\u0010\u0001\u001a\u00030\u0001H\u0007J\t\u0010\u0001\u001a\u000205H\u0014J\u0012\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020hH\u0014J\u0013\u0010\u0001\u001a\u0002052\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u0002052\u0007\u0010s\u001a\u00030\u0001H\u0007J\u0013\u0010\u0001\u001a\u0002052\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u000205H\u0015J\u001b\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020'H\u0016J\t\u0010\u0001\u001a\u000205H\u0016J\t\u0010\u0001\u001a\u000205H\u0016J\u0019\u0010\u0001\u001a\u0002052\u0006\u0010y\u001a\u00020W2\u0006\u0010_\u001a\u00020`H\u0016J\t\u0010\u0001\u001a\u000205H\u0016J\t\u0010\u0001\u001a\u000205H\u0002J\t\u0010\u0001\u001a\u000205H\u0003J\t\u0010\u0001\u001a\u000205H\u0003J\t\u0010\u0001\u001a\u000205H\u0003J\t\u0010\u0001\u001a\u000205H\u0003J\t\u0010\u0001\u001a\u000205H\u0003J\t\u0010\u0001\u001a\u000205H\u0002J\t\u0010\u0001\u001a\u000205H\u0003J\t\u0010\u0001\u001a\u000205H\u0003J\u0014\u0010\u0001\u001a\u0002052\t\b\u0002\u0010\u0001\u001a\u00020\u0017H\u0002J\t\u0010\u0001\u001a\u000205H\u0016J\u0012\u0010\u0001\u001a\u0002052\u0007\u0010 \u0001\u001a\u00020\u0017H\u0002J\t\u0010¡\u0001\u001a\u000205H\u0002J\t\u0010¢\u0001\u001a\u000205H\u0002J\u0011\u0010£\u0001\u001a\u0002052\u0006\u0010c\u001a\u00020`H\u0002J\t\u0010¤\u0001\u001a\u000205H\u0016J\u0012\u0010¥\u0001\u001a\u0002052\u0007\u0010¦\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010§\u0001\u001a\u0002052\u0007\u0010¨\u0001\u001a\u00020`H\u0002J\t\u0010©\u0001\u001a\u000205H\u0002J,\u0010ª\u0001\u001a\u0002052\u0006\u0010y\u001a\u00020W2\u000e\u0010«\u0001\u001a\t\u0012\u0004\u0012\u0002050¬\u00012\t\b\u0002\u0010­\u0001\u001a\u00020`H\u0002J\u0013\u0010®\u0001\u001a\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020`H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006²\u0001"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGMainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ljp/reifrontier/gym/fragment/RFGFeedFragment$OnFeedFragmentListener;", "Ljp/reifrontier/gym/fragment/RFGActFragment$OnActivitySingleListener;", "Ljp/reifrontier/gym/fragment/RFGPointFragment$OnPointListener;", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionListener;", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$RootFragmentListener;", "Ljp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$OnScheduleMapFragmentListener;", "Ljp/reifrontier/gym/fragment/train/RFGStationFragment$OnStationFragmentListener;", "Ljp/reifrontier/gym/fragment/train/RFGSpotListFragment$OnSpotListFragmentListener;", "Ljp/reifrontier/gym/fragment/train/RFGSpotDetailFragment$OnSpotDetailFragmentListener;", "()V", "currentFragType", "Ljp/reifrontier/gym/RFGDef$FragType;", "dataRemover", "Ljp/reifrontier/gym/data/RFGDataRemover;", "fragmentHistory", "Ljp/reifrontier/gym/ui/tab/RFGFragmentHistory;", "getFragmentHistory", "()Ljp/reifrontier/gym/ui/tab/RFGFragmentHistory;", "setFragmentHistory", "(Ljp/reifrontier/gym/ui/tab/RFGFragmentHistory;)V", "isErrorHandling", "", "isLoading", "mNavController", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController;", "mOnNavigationItemSelectedListener", "jp/reifrontier/gym/activity/RFGMainActivity$mOnNavigationItemSelectedListener$1", "Ljp/reifrontier/gym/activity/RFGMainActivity$mOnNavigationItemSelectedListener$1;", "mRealm", "Lio/realm/Realm;", "mTabIconsSelected", "", "menu", "Landroid/view/Menu;", "requestDate", "Ljava/util/Date;", "requestFeedDateString", "", "searchQueryDate", "searchQueryDateString", "shouldShowLoginBonus", "tabs", "", "Ljp/reifrontier/gym/RFGDef$TabType;", "user", "Ljp/reifrontier/gym/domain/api/RFGUser;", "getUser", "()Ljp/reifrontier/gym/domain/api/RFGUser;", "setUser", "(Ljp/reifrontier/gym/domain/api/RFGUser;)V", "bindActivitySingle", "", "sum", "Ljp/reifrontier/gym/domain/api/RFGSummaryHistory;", "bindChallengesAndActivitiesAndFeeds", "feed", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bindFeeds", "list", "Ljp/reifrontier/gym/domain/api/RFGFeed;", "bindOperationFeed", "operationList", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "bindSummary", "items", "userCurrentYearPoint", "Ljp/reifrontier/gym/domain/api/RFGUserCurrentYearPoint;", "bindWeightFeed", "feeds", "changeImageSize", "checkGoogleFit", "checkLocationService", "checkLoginBonus", "closeKeyboard", "createAnalyticsEventOnBackPressed", "createDateQuery", "refresh", "createSummaries", "Ljp/reifrontier/gym/domain/app/RFGAdapterSummary;", "date", "day", "Ljp/reifrontier/gym/domain/silentlog/RFGDay;", "currentFragment", "Landroidx/fragment/app/Fragment;", "tag", "didSelectActFromSingle", "adapterActivity", "Ljp/reifrontier/gym/domain/app/RFGAdapterActivity;", "errorDialog", "message", "getRootFragment", "index", "", "getTabView", "Landroid/view/View;", "position", "gotoMap", "gotoSetting", "initTab", "savedInstanceState", "Landroid/os/Bundle;", "interactionFeedPoint", "interactionFeedSummary", "loadFeedsMore", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCompletedRemoveData", "event", "Ljp/reifrontier/gym/data/bus/RFGCompletedRemoveData;", "onCreate", "onCreateOptionsMenu", "onDestroy", "onFragmentTransaction", "fragment", "transactionType", "Ljp/reifrontier/gym/ui/tab/RFGFragNavController$TransactionType;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onReceiveUpdate", "unAuthorize", "Ljp/reifrontier/gym/data/bus/RFGUnauthorize;", "onResume", "onSaveInstanceState", "outState", "onSelectedSpot", "spot", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "onSelectedStation", "Ljp/reifrontier/gym/data/bus/RFGSelectedStation;", "station", "Ljp/reifrontier/gym/data/train/RFGStation;", "onStart", "type", "title", "onStartLoading", "onStopLoading", "onTabTransaction", "onTerminate", "removeAllData", "requestActivitySummaries", "requestApi", "requestFeedAndChallenge", "requestFeeds", "requestPointHistory", "requestStations", "requestSummary", "requestUser", "restartApp", "isError", "showStationFragment", "showToolBar", "show", "startLoading", "stopLoading", "switchTab", "updateFeed", "updateMenuVisible", "setting", "updateTabSelection", "currentTab", "updateToolbar", "waitForReadyFragment", "doSomething", "Lkotlin/Function0;", "tryCount", "whiteDrawableSelector", "Landroid/graphics/drawable/Drawable;", "selected", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity */
public final class RFGMainActivity extends AppCompatActivity implements RFGFeedFragment.OnFeedFragmentListener, RFGActFragment.OnActivitySingleListener, RFGPointFragment.OnPointListener, RFGFragNavController.TransactionListener, RFGFragNavController.RootFragmentListener, RFGScheduleMapFragment.OnScheduleMapFragmentListener, RFGStationFragment.OnStationFragmentListener, RFGSpotListFragment.OnSpotListFragmentListener, RFGSpotDetailFragment.OnSpotDetailFragmentListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String MAP_FEEDS = "feeds";
    private static final String MAP_OPERATION = "operation";
    private static final String MAP_WEIGHT = "weight";
    private static final int REQUEST_CODE_OPEN_SETTING = 1001;
    private HashMap _$_findViewCache;
    private RFGDef.FragType currentFragType = RFGDef.FragType.Feed;
    private RFGDataRemover dataRemover;
    private RFGFragmentHistory fragmentHistory = new RFGFragmentHistory();
    private boolean isErrorHandling;
    private boolean isLoading;
    /* access modifiers changed from: private */
    public RFGFragNavController mNavController;
    private final RFGMainActivity$mOnNavigationItemSelectedListener$1 mOnNavigationItemSelectedListener = new RFGMainActivity$mOnNavigationItemSelectedListener$1(this);
    /* access modifiers changed from: private */
    public Realm mRealm;
    private final int[] mTabIconsSelected = {C2092R.C2093drawable.tab_home, C2092R.C2093drawable.tab_train, C2092R.C2093drawable.tab_spot};
    private Menu menu;
    private Date requestDate = new Date();
    private String requestFeedDateString = "";
    private Date searchQueryDate;
    private String searchQueryDateString;
    /* access modifiers changed from: private */
    public boolean shouldShowLoginBonus;
    private final List<RFGDef.TabType> tabs = CollectionsKt__CollectionsKt.listOf(RFGDef.TabType.Feed, RFGDef.TabType.Schedule, RFGDef.TabType.Info);
    private RFGUser user;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGMainActivity$Companion;", "", "()V", "MAP_FEEDS", "", "MAP_OPERATION", "MAP_WEIGHT", "REQUEST_CODE_OPEN_SETTING", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$10;
        public static final /* synthetic */ int[] $EnumSwitchMapping$11;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;
        public static final /* synthetic */ int[] $EnumSwitchMapping$9;

        static {
            int[] iArr = new int[RFGDef.FragType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGDef.FragType fragType = RFGDef.FragType.Point;
            iArr[2] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGDef.FragType fragType2 = RFGDef.FragType.ActivitySingle;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGDef.FragType fragType3 = RFGDef.FragType.StationList;
            iArr3[4] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            RFGDef.FragType fragType4 = RFGDef.FragType.SpotDetail;
            iArr4[6] = 4;
            int[] iArr5 = new int[RFGDef.TabType.values().length];
            $EnumSwitchMapping$1 = iArr5;
            RFGDef.TabType tabType = RFGDef.TabType.Feed;
            iArr5[0] = 1;
            int[] iArr6 = $EnumSwitchMapping$1;
            RFGDef.TabType tabType2 = RFGDef.TabType.Schedule;
            iArr6[1] = 2;
            int[] iArr7 = $EnumSwitchMapping$1;
            RFGDef.TabType tabType3 = RFGDef.TabType.Info;
            iArr7[2] = 3;
            int[] iArr8 = new int[RFGDef.TabType.values().length];
            $EnumSwitchMapping$2 = iArr8;
            RFGDef.TabType tabType4 = RFGDef.TabType.Feed;
            iArr8[0] = 1;
            int[] iArr9 = $EnumSwitchMapping$2;
            RFGDef.TabType tabType5 = RFGDef.TabType.Schedule;
            iArr9[1] = 2;
            int[] iArr10 = $EnumSwitchMapping$2;
            RFGDef.TabType tabType6 = RFGDef.TabType.Info;
            iArr10[2] = 3;
            int[] iArr11 = new int[RFGDef.TabType.values().length];
            $EnumSwitchMapping$3 = iArr11;
            RFGDef.TabType tabType7 = RFGDef.TabType.Feed;
            iArr11[0] = 1;
            int[] iArr12 = $EnumSwitchMapping$3;
            RFGDef.TabType tabType8 = RFGDef.TabType.Schedule;
            iArr12[1] = 2;
            int[] iArr13 = $EnumSwitchMapping$3;
            RFGDef.TabType tabType9 = RFGDef.TabType.Info;
            iArr13[2] = 3;
            int[] iArr14 = new int[RFGDef.TabType.values().length];
            $EnumSwitchMapping$4 = iArr14;
            RFGDef.TabType tabType10 = RFGDef.TabType.Feed;
            iArr14[0] = 1;
            int[] iArr15 = $EnumSwitchMapping$4;
            RFGDef.TabType tabType11 = RFGDef.TabType.Schedule;
            iArr15[1] = 2;
            int[] iArr16 = $EnumSwitchMapping$4;
            RFGDef.TabType tabType12 = RFGDef.TabType.Info;
            iArr16[2] = 3;
            int[] iArr17 = new int[RFGDef.TabType.values().length];
            $EnumSwitchMapping$5 = iArr17;
            RFGDef.TabType tabType13 = RFGDef.TabType.Feed;
            iArr17[0] = 1;
            int[] iArr18 = $EnumSwitchMapping$5;
            RFGDef.TabType tabType14 = RFGDef.TabType.Schedule;
            iArr18[1] = 2;
            int[] iArr19 = $EnumSwitchMapping$5;
            RFGDef.TabType tabType15 = RFGDef.TabType.Info;
            iArr19[2] = 3;
            int[] iArr20 = new int[RFGDef.TabType.values().length];
            $EnumSwitchMapping$6 = iArr20;
            RFGDef.TabType tabType16 = RFGDef.TabType.Feed;
            iArr20[0] = 1;
            int[] iArr21 = $EnumSwitchMapping$6;
            RFGDef.TabType tabType17 = RFGDef.TabType.Schedule;
            iArr21[1] = 2;
            int[] iArr22 = $EnumSwitchMapping$6;
            RFGDef.TabType tabType18 = RFGDef.TabType.Info;
            iArr22[2] = 3;
            int[] iArr23 = new int[RFGDef.TabType.values().length];
            $EnumSwitchMapping$7 = iArr23;
            RFGDef.TabType tabType19 = RFGDef.TabType.Feed;
            iArr23[0] = 1;
            int[] iArr24 = $EnumSwitchMapping$7;
            RFGDef.TabType tabType20 = RFGDef.TabType.Schedule;
            iArr24[1] = 2;
            int[] iArr25 = $EnumSwitchMapping$7;
            RFGDef.TabType tabType21 = RFGDef.TabType.Info;
            iArr25[2] = 3;
            int[] iArr26 = new int[RFGDef.FragType.values().length];
            $EnumSwitchMapping$8 = iArr26;
            RFGDef.FragType fragType5 = RFGDef.FragType.Feed;
            iArr26[0] = 1;
            int[] iArr27 = $EnumSwitchMapping$8;
            RFGDef.FragType fragType6 = RFGDef.FragType.Point;
            iArr27[2] = 2;
            int[] iArr28 = $EnumSwitchMapping$8;
            RFGDef.FragType fragType7 = RFGDef.FragType.ActivitySingle;
            iArr28[1] = 3;
            int[] iArr29 = $EnumSwitchMapping$8;
            RFGDef.FragType fragType8 = RFGDef.FragType.ScheduleMap;
            iArr29[3] = 4;
            int[] iArr30 = $EnumSwitchMapping$8;
            RFGDef.FragType fragType9 = RFGDef.FragType.StationList;
            iArr30[4] = 5;
            int[] iArr31 = $EnumSwitchMapping$8;
            RFGDef.FragType fragType10 = RFGDef.FragType.SpotList;
            iArr31[5] = 6;
            int[] iArr32 = $EnumSwitchMapping$8;
            RFGDef.FragType fragType11 = RFGDef.FragType.SpotDetail;
            iArr32[6] = 7;
            int[] iArr33 = new int[RFGDef.TabType.values().length];
            $EnumSwitchMapping$9 = iArr33;
            RFGDef.TabType tabType22 = RFGDef.TabType.Feed;
            iArr33[0] = 1;
            int[] iArr34 = $EnumSwitchMapping$9;
            RFGDef.TabType tabType23 = RFGDef.TabType.Schedule;
            iArr34[1] = 2;
            int[] iArr35 = $EnumSwitchMapping$9;
            RFGDef.TabType tabType24 = RFGDef.TabType.Info;
            iArr35[2] = 3;
            int[] iArr36 = new int[RFGDef.FragType.values().length];
            $EnumSwitchMapping$10 = iArr36;
            RFGDef.FragType fragType12 = RFGDef.FragType.Feed;
            iArr36[0] = 1;
            int[] iArr37 = $EnumSwitchMapping$10;
            RFGDef.FragType fragType13 = RFGDef.FragType.SpotList;
            iArr37[5] = 2;
            int[] iArr38 = new int[RFGDef.FragType.values().length];
            $EnumSwitchMapping$11 = iArr38;
            RFGDef.FragType fragType14 = RFGDef.FragType.ActivitySingle;
            iArr38[1] = 1;
            int[] iArr39 = $EnumSwitchMapping$11;
            RFGDef.FragType fragType15 = RFGDef.FragType.Point;
            iArr39[2] = 2;
        }
    }

    public static final /* synthetic */ RFGFragNavController access$getMNavController$p(RFGMainActivity rFGMainActivity) {
        RFGFragNavController rFGFragNavController = rFGMainActivity.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        return rFGFragNavController;
    }

    /* access modifiers changed from: private */
    public final void bindActivitySingle(RFGSummaryHistory rFGSummaryHistory) {
        ArrayList arrayList = new ArrayList();
        Realm realm = this.mRealm;
        if (realm == null) {
            Intrinsics.throwNpe();
        }
        RFGDay rFGDay = (RFGDay) realm.where(RFGDay.class).equalTo("date", this.searchQueryDateString).findFirst();
        if (rFGDay != null && rFGDay.getActivites().size() > 0) {
            Date date = this.searchQueryDate;
            if (date == null) {
                Intrinsics.throwNpe();
            }
            arrayList.addAll(createSummaries(date, rFGDay, rFGSummaryHistory));
        }
        RFGDef.FragType fragType = RFGDef.FragType.ActivitySingle;
        Fragment currentFragment = currentFragment("ActivitySingle");
        if (currentFragment != null) {
            stopLoading();
            ((RFGActFragment) currentFragment).bindData(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public final void bindChallengesAndActivitiesAndFeeds(HashMap<String, List<Object>> hashMap) {
        ArrayList arrayList;
        List<Object> list = hashMap.get(MAP_WEIGHT);
        if (list == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(list, "feed[MAP_WEIGHT]!!");
        ArrayList arrayList2 = new ArrayList();
        for (Object next : list) {
            if (next instanceof RFGFeed) {
                arrayList2.add(next);
            }
        }
        bindWeightFeed(arrayList2);
        List list2 = hashMap.get(MAP_OPERATION);
        if (list2 != null) {
            arrayList = new ArrayList();
            for (Object next2 : list2) {
                if (next2 instanceof RFGApiOperation) {
                    arrayList.add(next2);
                }
            }
        } else {
            arrayList = null;
        }
        bindOperationFeed(arrayList);
        List<Object> list3 = hashMap.get(MAP_FEEDS);
        if (list3 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(list3, "feed[MAP_FEEDS]!!");
        ArrayList arrayList3 = new ArrayList();
        for (Object next3 : list3) {
            if (next3 instanceof RFGFeed) {
                arrayList3.add(next3);
            }
        }
        bindFeeds(arrayList3);
    }

    /* access modifiers changed from: private */
    public final void bindFeeds(List<RFGFeed> list) {
        RFGDef.FragType fragType = RFGDef.FragType.Feed;
        Fragment currentFragment = currentFragment("Feed");
        if (currentFragment != null) {
            boolean z = false;
            createDateQuery(false);
            Date parse = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.JAPANESE).parse(RFGShared.INSTANCE.firstDate());
            String format = parse != null ? RFLDailyUtilsKt.format(parse, "yyyyMMdd", "GMT") : null;
            if (format == null || format.compareTo(this.requestFeedDateString) <= 0) {
                z = true;
            }
            ((RFGFeedFragment) currentFragment).addFeeds(list, z);
        }
    }

    private final void bindOperationFeed(List<RFGApiOperation> list) {
        RFGDef.FragType fragType = RFGDef.FragType.Feed;
        Fragment currentFragment = currentFragment("Feed");
        if (!(currentFragment instanceof RFGFeedFragment)) {
            currentFragment = null;
        }
        RFGFeedFragment rFGFeedFragment = (RFGFeedFragment) currentFragment;
        if (rFGFeedFragment != null) {
            rFGFeedFragment.addOperationFeed(list);
        }
    }

    /* access modifiers changed from: private */
    public final void bindSummary(List<RFGSummaryHistory> list, RFGUserCurrentYearPoint rFGUserCurrentYearPoint) {
        T t;
        RFGDef.FragType fragType = RFGDef.FragType.Feed;
        Fragment currentFragment = currentFragment("Feed");
        if (currentFragment != null) {
            List<T> sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, RFGMainActivity$bindSummary$sortItems$1.INSTANCE);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = sortedWith.iterator();
            while (true) {
                t = null;
                if (!it.hasNext()) {
                    break;
                }
                T t2 = (RFGSummaryHistory) it.next();
                if (!Intrinsics.areEqual((Object) t2.getAType(), (Object) "total")) {
                    t = t2;
                }
                if (t != null) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(CollectionsKt___CollectionsKt.last(arrayList));
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                if (Intrinsics.areEqual((Object) ((RFGSummaryHistory) next).getAType(), (Object) "total")) {
                    t = next;
                    break;
                }
            }
            RFGSummaryHistory rFGSummaryHistory = (RFGSummaryHistory) t;
            if (rFGSummaryHistory != null) {
                rFGSummaryHistory.setCurrentYearPointDayNumber(rFGUserCurrentYearPoint.getADayNumber());
                arrayList2.add(rFGSummaryHistory);
            }
            RFGFeedFragment rFGFeedFragment = (RFGFeedFragment) currentFragment;
            waitForReadyFragment$default(this, rFGFeedFragment, new RFGMainActivity$bindSummary$3(rFGFeedFragment, arrayList2), 0, 4, (Object) null);
        }
    }

    private final void bindWeightFeed(List<RFGFeed> list) {
        RFGDef.FragType fragType = RFGDef.FragType.Feed;
        Fragment currentFragment = currentFragment("Feed");
        if (currentFragment != null) {
            ((RFGFeedFragment) currentFragment).addWeightFeed(list);
        }
    }

    private final void changeImageSize() {
        WindowManager windowManager = getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.login_bonus, options);
        int dimensionPixelSize = point.x - getResources().getDimensionPixelSize(R.dimen.login_bonus_margin);
        int roundToInt = MathKt__MathJVMKt.roundToInt((((float) dimensionPixelSize) / ((float) options.outWidth)) * ((float) options.outHeight));
        C1529y a = C1513u.m2068b().mo27244a((int) R.mipmap.login_bonus);
        a.mo27278a(dimensionPixelSize, roundToInt);
        a.mo27276a();
        a.mo27281a((ImageView) _$_findCachedViewById(C2092R.C2094id.viewLoginBonus), (C1489e) null);
    }

    private final void checkGoogleFit() {
        boolean isUseGoogleFit = RFGShared.INSTANCE.isUseGoogleFit();
        boolean hasInstalledGoogleFit = RFGUtilsKt.hasInstalledGoogleFit(this);
        if (isUseGoogleFit && !hasInstalledGoogleFit) {
            RFGShared.INSTANCE.setIsUseGoogleFit(false);
            String string = getString(R.string.google_fit_install_error_message);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.googl…it_install_error_message)");
            errorDialog(string);
        }
    }

    private final void checkLocationService() {
        RFGErrorDialog newInstance$default;
        RFGErrorDialog.ErrorDialogListener rFGMainActivity$checkLocationService$2;
        Object systemService = getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (systemService != null) {
            if (!((LocationManager) systemService).isProviderEnabled("network")) {
                newInstance$default = RFGErrorDialog.Companion.newInstance$default(RFGErrorDialog.Companion, (String) null, "端末の位置情報の検出情報が「高精度」になっていません。端末の設定を表示します。", 1, (Object) null);
                rFGMainActivity$checkLocationService$2 = new RFGMainActivity$checkLocationService$1(this);
            } else if (!RFGLocationPermissionUtils.INSTANCE.checkSelfPermission(this)) {
                newInstance$default = RFGErrorDialog.Companion.newInstance$default(RFGErrorDialog.Companion, (String) null, "アプリの位置情報の権限が許可されていません。端末の設定を表示します。", 1, (Object) null);
                rFGMainActivity$checkLocationService$2 = new RFGMainActivity$checkLocationService$2(this);
            } else {
                return;
            }
            newInstance$default.setListener(rFGMainActivity$checkLocationService$2);
            newInstance$default.show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
    }

    /* access modifiers changed from: private */
    public final void checkLoginBonus() {
        if (this.shouldShowLoginBonus) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            translateAnimation.setDuration(300);
            ((ImageView) _$_findCachedViewById(C2092R.C2094id.viewLoginBonus)).setOnClickListener(new RFGMainActivity$checkLoginBonus$1(this));
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C2092R.C2094id.viewLoginBonusCover);
            Intrinsics.checkExpressionValueIsNotNull(frameLayout, "viewLoginBonusCover");
            frameLayout.setVisibility(0);
            ((FrameLayout) _$_findCachedViewById(C2092R.C2094id.viewLoginBonusAnimation)).clearAnimation();
            ((FrameLayout) _$_findCachedViewById(C2092R.C2094id.viewLoginBonusAnimation)).startAnimation(translateAnimation);
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

    private final void createAnalyticsEventOnBackPressed() {
        String str;
        String str2;
        int ordinal = this.currentFragType.ordinal();
        if (ordinal == 1) {
            str2 = "110";
            str = "110d";
        } else if (ordinal == 2) {
            str2 = "101";
            str = "101c";
        } else if (ordinal == 4) {
            str2 = "210";
            str = "210d";
        } else if (ordinal != 6) {
            StringBuilder a = C0681a.m330a("[Gym]::Info OnBackPressed not attach GA: ");
            a.append(this.currentFragType);
            C1122a.m1600c(a.toString(), new Object[0]);
            str2 = RFGAnalyticsManager.UNDEFINED_CATEGORY;
            str = RFGAnalyticsManager.UNDEFINED_ACTION;
        } else {
            str2 = "310";
            str = "310d";
        }
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, str2, str, (String) null, 4, (Object) null);
    }

    private final void createDateQuery(boolean z) {
        Date date = this.requestDate;
        if (z) {
            date = RFLDailyUtilsKt.start(new Date());
        }
        Date ago = RFGUtilsKt.ago(date, 6);
        this.requestDate = ago;
        this.requestFeedDateString = RFLDailyUtilsKt.format(ago, "yyyyMMdd", "GMT");
    }

    private final List<RFGAdapterSummary> createSummaries(Date date, RFGDay rFGDay, RFGSummaryHistory rFGSummaryHistory) {
        Date date2 = date;
        RFGSummaryHistory rFGSummaryHistory2 = rFGSummaryHistory;
        ArrayList arrayList = new ArrayList();
        List<RFGServerActivity> serverActivities = rFGSummaryHistory.serverActivities();
        Iterator<T> it = rFGDay.getActivites().iterator();
        int i = 0;
        while (true) {
            String str = null;
            if (it.hasNext()) {
                RFGActivity rFGActivity = (RFGActivity) it.next();
                ArrayList arrayList2 = new ArrayList();
                Iterator<RFGTrackPoint> it2 = rFGActivity.getTrackPoints().iterator();
                RFGTrackPoint rFGTrackPoint = null;
                float f = 0.0f;
                while (it2.hasNext()) {
                    RFGTrackPoint next = it2.next();
                    int i2 = i;
                    arrayList2.add(new LatLng(next.getLatitude(), next.getLongitude()));
                    if (rFGTrackPoint != null) {
                        f += GymUtils.INSTANCE.distance(rFGTrackPoint.getLatitude(), rFGTrackPoint.getLongitude(), next.getLatitude(), next.getLongitude());
                    }
                    rFGTrackPoint = next;
                    i = i2;
                }
                int i3 = i;
                if (i < serverActivities.size()) {
                    str = rFGSummaryHistory.serverActivities().get(i).actType();
                }
                arrayList.add(new RFGAdapterActivity(rFGActivity.getFromDate(), rFGActivity.getToDate(), rFGActivity.getActivity(), rFGActivity.type(str), rFGActivity.getSteps(), f, arrayList2));
                i++;
            } else {
                return CollectionsKt__CollectionsKt.listOf(new RFGAdapterSummary(RFLDailyUtilsKt.format$default(date2, "yyyy年M月d日", (String) null, 2, (Object) null), date2, CollectionsKt__CollectionsKt.emptyList(), rFGSummaryHistory2), new RFGAdapterSummary("", date2, arrayList, rFGSummaryHistory2));
            }
        }
    }

    private final Fragment currentFragment(String str) {
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        Fragment currentFrag = rFGFragNavController.getCurrentFrag();
        if (currentFrag == null || !Intrinsics.areEqual((Object) currentFrag.getTag(), (Object) str)) {
            return null;
        }
        return currentFrag;
    }

    private final void errorDialog(String str) {
        RFGErrorDialog.Companion.newInstance$default(RFGErrorDialog.Companion, (String) null, str, 1, (Object) null).show(getSupportFragmentManager(), RFGErrorDialog.Companion.getTAG());
    }

    private final View getTabView(int i) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab_item_bottom, (TabLayout) _$_findCachedViewById(C2092R.C2094id.bottom_tab_layout), false);
        View findViewById = inflate.findViewById(R.id.tab_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.tab_icon)");
        ((ImageView) findViewById).setImageDrawable(whiteDrawableSelector(this.mTabIconsSelected[i]));
        Intrinsics.checkExpressionValueIsNotNull(inflate, Promotion.ACTION_VIEW);
        return inflate;
    }

    private final void gotoMap(RFGAdapterActivity rFGAdapterActivity) {
        String json = new Gson().toJson((Object) rFGAdapterActivity);
        RFGShared rFGShared = RFGShared.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(json, "data");
        rFGShared.setLocationData(json);
        RFGAnalyticsManager.INSTANCE.sendEvent("110", "110c", rFGAdapterActivity.analyticsTime());
        startActivity(new Intent(this, RFGMapsActivity.class));
    }

    private final void gotoSetting() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "100", "100e", (String) null, 4, (Object) null);
        startActivityForResult(new Intent(this, RFGSettingActivity.class), 1001);
    }

    private final void initTab(Bundle bundle) {
        if (((TabLayout) _$_findCachedViewById(C2092R.C2094id.bottom_tab_layout)) != null) {
            int size = this.tabs.size();
            for (int i = 0; i < size; i++) {
                ((TabLayout) _$_findCachedViewById(C2092R.C2094id.bottom_tab_layout)).mo25503a(((TabLayout) _$_findCachedViewById(C2092R.C2094id.bottom_tab_layout)).mo25513c());
                TabLayout.C1213f b = ((TabLayout) _$_findCachedViewById(C2092R.C2094id.bottom_tab_layout)).mo25511b(i);
                if (b != null) {
                    b.mo25541a(getTabView(i));
                }
            }
        }
        RFGFragNavController rFGFragNavController = new RFGFragNavController();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C2092R.C2094id.content_frame);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "content_frame");
        RFGFragNavController build = rFGFragNavController.newBuilder(bundle, supportFragmentManager, frameLayout.getId()).transactionListener(this).rootFragmentListener(this, this.tabs.size()).build();
        this.mNavController = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        build.initialize(0);
        ((TabLayout) _$_findCachedViewById(C2092R.C2094id.bottom_tab_layout)).mo25502a((TabLayout.C1207b) this.mOnNavigationItemSelectedListener);
    }

    private final void removeAllData() {
        startLoading();
        RFGDataRemover rFGDataRemover = this.dataRemover;
        if (rFGDataRemover == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataRemover");
        }
        rFGDataRemover.deleteWithLogout();
    }

    @SuppressLint({"CheckResult"})
    private final void requestActivitySummaries() {
        Date date = this.searchQueryDate;
        if (date != null) {
            if (date == null) {
                Intrinsics.throwNpe();
            }
            String format = RFLDailyUtilsKt.format(RFGUtilsKt.ago(date, 6), "yyyyMMdd", "GMT");
            startLoading();
            RFGH2Client.Companion.getINSTANCE().history("summary", format).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMainActivity$requestActivitySummaries$1(this), RFGMainActivity$requestActivitySummaries$2.INSTANCE);
        }
    }

    @SuppressLint({"CheckResult"})
    private final void requestApi() {
        startLoading();
        if (RFGShared.INSTANCE.getShouldRequestLoginBonus()) {
            Intrinsics.checkExpressionValueIsNotNull(RFGPointClient.Companion.getINSTANCE().pointAction().mo27434b(C1683a.m2378b()).mo27432a(new RFGMainActivity$requestApi$1(this), new RFGMainActivity$requestApi$2(this)), "RFGPointClient.INSTANCE.…      }\n                )");
        } else {
            requestStations();
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestFeedAndChallenge() {
        C1714r<R> a = C1714r.m2411a(RFGH2Client.Companion.getINSTANCE().feed(this.requestFeedDateString), RFGRailroadClient.Companion.getINSTANCE().getOperation(), RFGMainActivity$requestFeedAndChallenge$zip$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.zip(\n            …s\n            }\n        )");
        a.mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMainActivity$requestFeedAndChallenge$1(this), new RFGMainActivity$requestFeedAndChallenge$2(this));
    }

    @SuppressLint({"CheckResult"})
    private final void requestFeeds() {
        startLoading();
        RFGH2Client.Companion.getINSTANCE().feed(this.requestFeedDateString).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMainActivity$requestFeeds$1(this), RFGMainActivity$requestFeeds$2.INSTANCE);
    }

    @SuppressLint({"CheckResult"})
    private final void requestPointHistory() {
        RFGDef.FragType fragType = RFGDef.FragType.Point;
        Fragment currentFragment = currentFragment("Point");
        if (currentFragment != null) {
            startLoading();
            RFGH2Client.Companion.getINSTANCE().userHistory().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMainActivity$requestPointHistory$1(this, (RFGPointFragment) currentFragment), RFGMainActivity$requestPointHistory$2.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void requestStations() {
        RFGTrainData.INSTANCE.initialize(new RFGMainActivity$requestStations$1(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestSummary() {
        RFGShared.INSTANCE.setRequestFeed(System.currentTimeMillis());
        C1714r.m2411a(RFGH2Client.Companion.getINSTANCE().history("summary", this.requestFeedDateString), RFGH2Client.Companion.getINSTANCE().currentYearPoint(), RFGMainActivity$requestSummary$1.INSTANCE).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMainActivity$requestSummary$2(this), RFGMainActivity$requestSummary$3.INSTANCE);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void requestUser() {
        RFGH2Client.Companion.getINSTANCE().userInfo().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMainActivity$requestUser$1(this), RFGMainActivity$requestUser$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void restartApp(boolean z) {
        C1126c.m1638c().mo21908c(this);
        finish();
        Intent intent = new Intent(this, RFGInitActivity.class);
        intent.putExtra(RFGInitActivity.EXTRA_KEY_IS_ERROR_RESTART, z);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    static /* synthetic */ void restartApp$default(RFGMainActivity rFGMainActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        rFGMainActivity.restartApp(z);
    }

    private final void showToolBar(boolean z) {
        Toolbar toolbar;
        int i;
        if (z) {
            toolbar = (Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
            i = 0;
        } else {
            toolbar = (Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
            i = 8;
        }
        toolbar.setVisibility(i);
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
    public final void switchTab(int i) {
        String str;
        RFGDef.TabType tabType = this.tabs.get(i);
        int ordinal = this.currentFragType.ordinal();
        String str2 = RFGAnalyticsManager.UNDEFINED_ACTION;
        switch (ordinal) {
            case 0:
                int ordinal2 = tabType.ordinal();
                if (ordinal2 != 0) {
                    if (ordinal2 == 1) {
                        str2 = "100a";
                    } else if (ordinal2 == 2) {
                        str2 = "100b";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                str = "100";
                break;
            case 1:
                int ordinal3 = tabType.ordinal();
                if (ordinal3 != 0) {
                    if (ordinal3 == 1) {
                        str2 = "110a";
                    } else if (ordinal3 == 2) {
                        str2 = "110b";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                str = "110";
                break;
            case 2:
                int ordinal4 = tabType.ordinal();
                if (ordinal4 != 0) {
                    if (ordinal4 == 1) {
                        str2 = "101a";
                    } else if (ordinal4 == 2) {
                        str2 = "101b";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                str = "101";
                break;
            case 3:
                int ordinal5 = tabType.ordinal();
                if (ordinal5 == 0) {
                    str2 = "200a";
                } else if (ordinal5 != 1) {
                    if (ordinal5 == 2) {
                        str2 = "200b";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                str = "200";
                break;
            case 4:
                int ordinal6 = tabType.ordinal();
                if (ordinal6 == 0) {
                    str2 = "210a";
                } else if (ordinal6 != 1) {
                    if (ordinal6 == 2) {
                        str2 = "210b";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                str = "210";
                break;
            case 5:
                int ordinal7 = tabType.ordinal();
                if (ordinal7 == 0) {
                    str2 = "300a";
                } else if (ordinal7 == 1) {
                    str2 = "300b";
                } else if (ordinal7 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "300";
                break;
            case 6:
                int ordinal8 = tabType.ordinal();
                if (ordinal8 == 0) {
                    str2 = "310a";
                } else if (ordinal8 == 1) {
                    str2 = "310b";
                } else if (ordinal8 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "310";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, str, str2, (String) null, 4, (Object) null);
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        rFGFragNavController.switchTab(i);
    }

    private final void updateMenuVisible(boolean z) {
        Menu menu2 = this.menu;
        if (menu2 != null) {
            menu2.setGroupVisible(R.id.edit, false);
            menu2.setGroupVisible(R.id.setting, z);
        }
    }

    private final void updateTabSelection(int i) {
        TabLayout.C1213f b;
        int size = this.tabs.size();
        if (i >= 0 && size > i && (b = ((TabLayout) _$_findCachedViewById(C2092R.C2094id.bottom_tab_layout)).mo25511b(i)) != null) {
            b.mo25550g();
        }
    }

    private final void updateToolbar() {
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        Fragment currentFrag = rFGFragNavController.getCurrentFrag();
        if (currentFrag != null) {
            RFGFragNavController rFGFragNavController2 = this.mNavController;
            if (rFGFragNavController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavController");
            }
            boolean z = !rFGFragNavController2.isRootFragment();
            String tag = currentFrag.getTag();
            RFGDef.FragType fragType = RFGDef.FragType.Feed;
            boolean areEqual = Intrinsics.areEqual((Object) tag, (Object) "Feed");
            String tag2 = currentFrag.getTag();
            RFGDef.FragType fragType2 = RFGDef.FragType.SpotDetail;
            boolean areEqual2 = Intrinsics.areEqual((Object) tag2, (Object) "SpotDetail");
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                Intrinsics.throwNpe();
            }
            supportActionBar.setDisplayHomeAsUpEnabled(z);
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 == null) {
                Intrinsics.throwNpe();
            }
            supportActionBar2.setDisplayShowHomeEnabled(z);
            ActionBar supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 == null) {
                Intrinsics.throwNpe();
            }
            supportActionBar3.setHomeAsUpIndicator((int) R.mipmap.back);
            updateMenuVisible(areEqual);
            showToolBar(!areEqual2);
            return;
        }
        updateMenuVisible(false);
        showToolBar(true);
    }

    /* access modifiers changed from: private */
    public final void waitForReadyFragment(Fragment fragment, Function0<Unit> function0, int i) {
        if (fragment.isResumed()) {
            function0.invoke();
        } else if (i >= 3) {
            C1122a.m1599b("[Gym]::Error cannot resume Fragment. so, restart app.", new Object[0]);
            restartApp$default(this, false, 1, (Object) null);
        } else {
            new Handler().postDelayed(new RFGMainActivity$waitForReadyFragment$1(this, fragment, function0, i), 100);
        }
    }

    static /* synthetic */ void waitForReadyFragment$default(RFGMainActivity rFGMainActivity, Fragment fragment, Function0 function0, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        rFGMainActivity.waitForReadyFragment(fragment, function0, i);
    }

    private final Drawable whiteDrawableSelector(int i) {
        Drawable drawable = ContextCompat.getDrawable(this, i);
        if (drawable != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap createBitmap = Bitmap.createBitmap(bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new LightingColorFilter(ViewCompat.MEASURED_SIZE_MASK, -1));
            canvas.drawBitmap(bitmapDrawable.getBitmap(), 0.0f, 0.0f, paint);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(getResources(), createBitmap);
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            Paint paint2 = new Paint();
            paint2.setAlpha(126);
            canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
            BitmapDrawable bitmapDrawable3 = new BitmapDrawable(getResources(), createBitmap2);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842913}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{16842910}, bitmapDrawable3);
            return stateListDrawable;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
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

    public void didSelectActFromSingle(RFGAdapterActivity rFGAdapterActivity) {
        Intrinsics.checkParameterIsNotNull(rFGAdapterActivity, "adapterActivity");
        gotoMap(rFGAdapterActivity);
    }

    public final RFGFragmentHistory getFragmentHistory() {
        return this.fragmentHistory;
    }

    public Fragment getRootFragment(int i) {
        int ordinal = this.tabs.get(i).ordinal();
        if (ordinal == 0) {
            RFGFeedFragment.Companion companion = RFGFeedFragment.Companion;
            RFGDef.FragType fragType = RFGDef.FragType.Feed;
            return companion.newInstance("Feed", "");
        } else if (ordinal == 1) {
            RFGScheduleMapFragment.Companion companion2 = RFGScheduleMapFragment.Companion;
            RFGDef.FragType fragType2 = RFGDef.FragType.ScheduleMap;
            return companion2.newInstance("ScheduleMap", "");
        } else if (ordinal == 2) {
            RFGSpotListFragment.Companion companion3 = RFGSpotListFragment.Companion;
            RFGDef.FragType fragType3 = RFGDef.FragType.SpotList;
            return companion3.newInstance("SpotList", "");
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final RFGUser getUser() {
        return this.user;
    }

    public void interactionFeedPoint() {
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "100", "100c", (String) null, 4, (Object) null);
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        RFGPointFragment.Companion companion = RFGPointFragment.Companion;
        RFGDef.FragType fragType = RFGDef.FragType.Point;
        rFGFragNavController.pushFragment(companion.newInstance("Point", ""));
    }

    public void interactionFeedSummary(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        String format$default = RFLDailyUtilsKt.format$default(date, "yyyyMMdd'T'HHmmssZ", (String) null, 2, (Object) null);
        this.searchQueryDate = date;
        this.searchQueryDateString = format$default;
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "100", "100d", (String) null, 4, (Object) null);
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        RFGActFragment.Companion companion = RFGActFragment.Companion;
        RFGDef.FragType fragType = RFGDef.FragType.ActivitySingle;
        rFGFragNavController.pushFragment(companion.newInstance("ActivitySingle", format$default));
    }

    public void loadFeedsMore() {
        requestFeeds();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && intent != null && intent.hasExtra(RFGSettingActivity.RESULT_KEY_REQUEST_DELETE_DATA) && intent.getBooleanExtra(RFGSettingActivity.RESULT_KEY_REQUEST_DELETE_DATA, false)) {
            removeAllData();
        }
    }

    public void onBackPressed() {
        if (!this.isLoading) {
            RFGFragNavController rFGFragNavController = this.mNavController;
            if (rFGFragNavController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavController");
            }
            if (!rFGFragNavController.isRootFragment()) {
                createAnalyticsEventOnBackPressed();
                RFGFragNavController rFGFragNavController2 = this.mNavController;
                if (rFGFragNavController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavController");
                }
                rFGFragNavController2.popFragment();
            } else if (this.fragmentHistory.isEmpty()) {
                super.onBackPressed();
            } else if (this.fragmentHistory.getStackSize() > 1) {
                updateTabSelection(this.fragmentHistory.popPrevious());
            } else {
                updateTabSelection(0);
                this.fragmentHistory.emptyStack();
            }
        }
    }

    @C1129m
    public final void onCompletedRemoveData(RFGCompletedRemoveData rFGCompletedRemoveData) {
        RFGErrorDialog rFGErrorDialog;
        String str;
        FragmentManager fragmentManager;
        Intrinsics.checkParameterIsNotNull(rFGCompletedRemoveData, "event");
        stopLoading();
        if (rFGCompletedRemoveData.getSuccess()) {
            RFGErrorDialog.Companion companion = RFGErrorDialog.Companion;
            String string = getString(R.string.remove_all_data_completed_title);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.remov…all_data_completed_title)");
            String string2 = getString(R.string.remove_all_data_completed_message);
            Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.remov…l_data_completed_message)");
            rFGErrorDialog = companion.newInstance(string, string2);
            rFGErrorDialog.setListener(new RFGMainActivity$onCompletedRemoveData$1(this));
            fragmentManager = getSupportFragmentManager();
            str = "remove-all-data-completed";
        } else {
            RFGErrorDialog.Companion companion2 = RFGErrorDialog.Companion;
            String string3 = getString(R.string.remove_all_data_completed_error_message);
            Intrinsics.checkExpressionValueIsNotNull(string3, "getString(R.string.remov…_completed_error_message)");
            rFGErrorDialog = RFGErrorDialog.Companion.newInstance$default(companion2, (String) null, string3, 1, (Object) null);
            fragmentManager = getSupportFragmentManager();
            str = RFGErrorDialog.Companion.getTAG();
        }
        rFGErrorDialog.show(fragmentManager, str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar));
        Realm defaultInstance = Realm.getDefaultInstance();
        this.mRealm = defaultInstance;
        if (defaultInstance == null) {
            Intrinsics.throwNpe();
        }
        this.user = (RFGUser) defaultInstance.where(RFGUser.class).findFirst();
        changeImageSize();
        initTab(bundle);
        this.dataRemover = new RFGDataRemover(this);
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        if (menu2 == null) {
            Intrinsics.throwNpe();
        }
        this.menu = menu2;
        getMenuInflater().inflate(R.menu.main, menu2);
        menu2.setGroupVisible(R.id.edit, false);
        menu2.setGroupVisible(R.id.setting, true);
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

    public void onFragmentTransaction(Fragment fragment, RFGFragNavController.TransactionType transactionType) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        Intrinsics.checkParameterIsNotNull(transactionType, "transactionType");
        if (getSupportActionBar() != null) {
            updateToolbar();
            int ordinal = this.currentFragType.ordinal();
            if (ordinal == 1) {
                requestActivitySummaries();
            } else if (ordinal == 2) {
                requestPointHistory();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            Intrinsics.throwNpe();
        }
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.start_setting) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            gotoSetting();
            return true;
        }
    }

    @C1129m(threadMode = ThreadMode.MAIN)
    public final void onReceiveUpdate(RFGUnauthorize rFGUnauthorize) {
        Intrinsics.checkParameterIsNotNull(rFGUnauthorize, "unAuthorize");
        if (!this.isErrorHandling) {
            this.isErrorHandling = true;
            Realm realm = this.mRealm;
            if (realm == null) {
                Intrinsics.throwNpe();
            }
            realm.executeTransaction(new RFGMainActivity$onReceiveUpdate$1(this));
            SilentLogOperation.Companion.getInstance().logoutApi();
            Intent intent = new Intent(this, RFGInitActivity.class);
            intent.addFlags(268468224);
            startActivity(intent);
            this.isErrorHandling = false;
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        checkLocationService();
        checkGoogleFit();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        super.onSaveInstanceState(bundle);
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController != null) {
            if (rFGFragNavController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavController");
            }
            rFGFragNavController.onSaveInstanceState(bundle);
        }
    }

    public void onSelectedSpot(RFGSpot rFGSpot) {
        Intrinsics.checkParameterIsNotNull(rFGSpot, "spot");
        RFGSpotDetailFragment.Companion companion = RFGSpotDetailFragment.Companion;
        RFGDef.FragType fragType = RFGDef.FragType.SpotDetail;
        RFGSpotDetailFragment newInstance = companion.newInstance("SpotDetail", rFGSpot);
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        rFGFragNavController.pushFragment(newInstance);
        showToolBar(false);
    }

    @C1129m(threadMode = ThreadMode.MAIN)
    public final void onSelectedStation(RFGSelectedStation rFGSelectedStation) {
        Intrinsics.checkParameterIsNotNull(rFGSelectedStation, "event");
        updateTabSelection(this.tabs.indexOf(RFGDef.TabType.Schedule));
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        Fragment currentFrag = rFGFragNavController.getCurrentFrag();
        if (!(currentFrag instanceof RFGScheduleMapFragment)) {
            currentFrag = null;
        }
        RFGScheduleMapFragment rFGScheduleMapFragment = (RFGScheduleMapFragment) currentFrag;
        if (rFGScheduleMapFragment != null) {
            rFGScheduleMapFragment.search(rFGSelectedStation.getStation().getName());
        }
    }

    public void onSelectedStation(RFGStation rFGStation) {
        Intrinsics.checkParameterIsNotNull(rFGStation, "station");
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        rFGFragNavController.popFragment();
        RFGFragNavController rFGFragNavController2 = this.mNavController;
        if (rFGFragNavController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        Fragment currentFrag = rFGFragNavController2.getCurrentFrag();
        if (!(currentFrag instanceof RFGScheduleMapFragment)) {
            currentFrag = null;
        }
        RFGScheduleMapFragment rFGScheduleMapFragment = (RFGScheduleMapFragment) currentFrag;
        if (rFGScheduleMapFragment != null) {
            rFGScheduleMapFragment.search(rFGStation.getName());
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public void onStart() {
        super.onStart();
        C1126c.m1638c().mo21908c(this);
        C1126c.m1638c().mo21907b(this);
        SilentLogOperation.Companion.getInstance().onStart();
        SilentLogOperation.Companion.getInstance().stopGeofence();
        SilentLogOperation.Companion.getInstance().getDataFor(new Date()).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMainActivity$onStart$1(this), RFGMainActivity$onStart$2.INSTANCE);
    }

    public void onStart(RFGDef.FragType fragType, String str) {
        ImageView imageView;
        Intrinsics.checkParameterIsNotNull(fragType, "type");
        Intrinsics.checkParameterIsNotNull(str, "title");
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
        supportActionBar.setTitle((CharSequence) str);
        int i = 0;
        if (str.length() == 0) {
            imageView = (ImageView) _$_findCachedViewById(C2092R.C2094id.toolbarLogo);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "toolbarLogo");
        } else {
            imageView = (ImageView) _$_findCachedViewById(C2092R.C2094id.toolbarLogo);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "toolbarLogo");
            i = 8;
        }
        imageView.setVisibility(i);
        this.currentFragType = fragType;
    }

    public void onStartLoading() {
        startLoading();
    }

    public void onStopLoading() {
        stopLoading();
    }

    public void onTabTransaction(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        if (getSupportActionBar() != null) {
            updateToolbar();
            int ordinal = this.currentFragType.ordinal();
            if (ordinal != 0) {
                if (ordinal == 5) {
                    if (!(fragment instanceof RFGSpotListFragment)) {
                        fragment = null;
                    }
                    RFGSpotListFragment rFGSpotListFragment = (RFGSpotListFragment) fragment;
                    if (rFGSpotListFragment != null) {
                        rFGSpotListFragment.requestSpotList();
                    }
                }
            } else if (RFGShared.INSTANCE.shouldRequestFeed()) {
                createDateQuery(true);
                requestApi();
            }
        }
    }

    public void onTerminate() {
        onBackPressed();
    }

    public final void setFragmentHistory(RFGFragmentHistory rFGFragmentHistory) {
        Intrinsics.checkParameterIsNotNull(rFGFragmentHistory, "<set-?>");
        this.fragmentHistory = rFGFragmentHistory;
    }

    public final void setUser(RFGUser rFGUser) {
        this.user = rFGUser;
    }

    public void showStationFragment() {
        RFGStationFragment.Companion companion = RFGStationFragment.Companion;
        RFGDef.FragType fragType = RFGDef.FragType.StationList;
        RFGStationFragment newInstance = companion.newInstance("StationList", "");
        RFGFragNavController rFGFragNavController = this.mNavController;
        if (rFGFragNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavController");
        }
        rFGFragNavController.pushFragment(newInstance);
    }

    public void updateFeed() {
        createDateQuery(true);
        requestApi();
    }
}
