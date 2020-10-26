/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.util.Base64
 *  android.webkit.WebBackForwardList
 *  android.webkit.WebHistoryItem
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Base64;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.common.q;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.u;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.webview.f;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u00030\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u0017J\u0011\u0010\u0082\u0001\u001a\u00030\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u0017J\b\u0010\u0083\u0001\u001a\u00030\u0001J\b\u0010\u0084\u0001\u001a\u00030\u0001J\u0019\u0010\u0085\u0001\u001a\u00020\u00172\u0007\u0010\u0086\u0001\u001a\u00020\u00172\u0007\u0010\u0087\u0001\u001a\u00020\u0017J\u0007\u0010\u0088\u0001\u001a\u00020\u0003J\u0012\u0010\u0089\u0001\u001a\u00030\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001J\u0011\u0010\u008c\u0001\u001a\u00030\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u0017J\u0011\u0010\u008d\u0001\u001a\u00030\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0017J\u0011\u0010\u008f\u0001\u001a\u00030\u00012\u0007\u0010\u0090\u0001\u001a\u00020GJ\b\u0010\u0091\u0001\u001a\u00030\u0001J\u0011\u0010\u0092\u0001\u001a\u00030\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u0015J\u0011\u0010\u0094\u0001\u001a\u00030\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u0015J\b\u0010\u0095\u0001\u001a\u00030\u0001J\u0010\u0010\u0096\u0001\u001a\u00030\u00012\u0006\u0010]\u001a\u00020LJ\b\u0010\u0097\u0001\u001a\u00030\u0001J\b\u0010\u0098\u0001\u001a\u00030\u0001J\b\u0010\u0099\u0001\u001a\u00030\u0001J\b\u0010\u009a\u0001\u001a\u00030\u0001J\b\u0010\u009b\u0001\u001a\u00030\u0001J\b\u0010\u009c\u0001\u001a\u00030\u0001J\b\u0010\u009d\u0001\u001a\u00030\u0001J\b\u0010\u009e\u0001\u001a\u00030\u0001R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150*8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000*8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010,R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170*\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170*\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00150*8F\u00a2\u0006\u0006\u001a\u0004\b7\u0010,R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150*8F\u00a2\u0006\u0006\u001a\u0004\b9\u0010,R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0*\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020&0%\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010(R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00150%\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010(R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150*\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u001a\u0010F\u001a\u00020GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010H\"\u0004\bI\u0010JR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020L0%\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010(R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00150*\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010,R\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001f0*\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010,R\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020L0%X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010(R\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020L0%X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010(R\u001a\u0010V\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010(R\u001a\u0010]\u001a\u00020LX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010(R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00170*\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010,R\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020&0%\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010(R\u000e\u0010h\u001a\u00020iX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00170*\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010,R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00150*\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010,R\u0017\u0010p\u001a\b\u0012\u0004\u0012\u0002000\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00150*8F\u00a2\u0006\u0006\u001a\u0004\bt\u0010,R\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00150*\u00a2\u0006\b\n\u0000\u001a\u0004\bv\u0010,R\u001a\u0010w\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001a\u0010|\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u0010X\"\u0004\b~\u0010Z\u00a8\u0006\u009f\u0001"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "Landroidx/lifecycle/ViewModel;", "commonJavaScriptInterface", "Ljp/co/jreast/jreastapp/commuter/webview/CommonJavaScriptInterface;", "fileRepository", "Ljp/co/jreast/jreastapp/commuter/repository/FileRepository;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "localRailwayRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;", "siteGenerator", "Ljp/co/jreast/jreastapp/commuter/common/SiteGenerator;", "locationHistoryRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "audioWaveBeaconService", "Ljp/co/jreast/jreastapp/commuter/device/AudioWaveBeaconService;", "(Ljp/co/jreast/jreastapp/commuter/webview/CommonJavaScriptInterface;Ljp/co/jreast/jreastapp/commuter/repository/FileRepository;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;Ljp/co/jreast/jreastapp/commuter/common/SiteGenerator;Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/device/AudioWaveBeaconService;)V", "_beaconStatusVisibleProperty", "Landroidx/lifecycle/MutableLiveData;", "", "_errorStatusMessage", "", "_errorStatusMessageWithReload", "_errorStatusVisibleProperty", "_faviconDrawable", "Landroid/graphics/drawable/Drawable;", "_infoButtonVisibility", "_reloadButtonVisibility", "_reloadMessage", "", "_subTitleProperty", "_titleTextProperty", "_visibilityFavicon", "_visibilitySubTitle", "beaconStatusAnimationEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getBeaconStatusAnimationEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "beaconStatusVisibleProperty", "Landroidx/lifecycle/LiveData;", "getBeaconStatusVisibleProperty", "()Landroidx/lifecycle/LiveData;", "errorStatusAnimationEvent", "getErrorStatusAnimationEvent$app_productRelease", "errorStatusEnabled", "", "getErrorStatusEnabled", "errorStatusMessage", "getErrorStatusMessage", "errorStatusMessageWithReload", "getErrorStatusMessageWithReload", "errorStatusVisibleProperty", "getErrorStatusVisibleProperty", "errorWithReloadVisibility", "getErrorWithReloadVisibility", "faviconDrawable", "getFaviconDrawable", "finishActivityEvent", "getFinishActivityEvent", "goBackPageEvent", "getGoBackPageEvent", "hideBeaconStatusEvent", "getHideBeaconStatusEvent$app_productRelease", "hideErrorStatusEvent", "getHideErrorStatusEvent$app_productRelease", "infoButtonVisibility", "getInfoButtonVisibility", "isError", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewErrorType;", "()Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewErrorType;", "setError", "(Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewErrorType;)V", "openInfoModalEvent", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "getOpenInfoModalEvent", "reloadButtonVisibility", "getReloadButtonVisibility", "reloadMessage", "getReloadMessage", "reloadWebViewByErrorViewEvent", "getReloadWebViewByErrorViewEvent$app_productRelease", "reloadWebViewEvent", "getReloadWebViewEvent$app_productRelease", "savedOffsetY", "getSavedOffsetY", "()Ljava/lang/String;", "setSavedOffsetY", "(Ljava/lang/String;)V", "showBeaconStatusEvent", "getShowBeaconStatusEvent$app_productRelease", "site", "getSite", "()Ljp/co/jreast/jreastapp/commuter/webview/Site;", "setSite", "(Ljp/co/jreast/jreastapp/commuter/webview/Site;)V", "stopWebViewEvent", "getStopWebViewEvent$app_productRelease", "subTitleProperty", "getSubTitleProperty", "tapBackButtonEvent", "getTapBackButtonEvent", "timeoutHandler", "Landroid/os/Handler;", "timeoutRunnable", "Ljava/lang/Runnable;", "titleTextProperty", "getTitleTextProperty", "visibilityFavicon", "getVisibilityFavicon", "visibilityIndicator", "getVisibilityIndicator", "()Landroidx/lifecycle/MutableLiveData;", "visibilityIndicatorProperty", "getVisibilityIndicatorProperty", "visibilitySubTitle", "getVisibilitySubTitle", "visibleHint", "getVisibleHint", "()Z", "setVisibleHint", "(Z)V", "yamanoteLineDirectionUrl", "getYamanoteLineDirectionUrl", "setYamanoteLineDirectionUrl", "addHistory", "", "url", "changeTitle", "checkBeacon", "checkErrorToReload", "getCreateFontfaceJavascriptToEs5", "filepath", "fontWeight", "getJavaScriptInterface", "goBackOrFinish", "historyList", "Landroid/webkit/WebBackForwardList;", "openWebViewModal", "receiveBeacon", "beaconId", "receivedError", "errorType", "reload", "setBeaconStatusVisibleProperty", "visibility", "setErrorStatusVisibleProperty", "setOffsetY", "setTitle", "stopBeacon", "stopLoading", "tapBackButton", "tapErrorReloadButton", "tapHideBarButton", "tapHideBeaconBarButton", "tapInfoButton", "tapReloadButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class j
extends v {
    private final al<Void> A;
    private final al<o> B;
    private final al<o> C;
    private final al<Void> D;
    private final al<Void> E;
    private final al<Void> F;
    private final Handler G;
    private final Runnable H;
    private f I;
    private boolean J;
    private String K;
    private final al<Void> L;
    private final al<Integer> M;
    private final al<o> N;
    private final al<Void> O;
    private String P;
    private final jp.co.jreast.jreastapp.commuter.webview.b Q;
    private final jp.co.jreast.jreastapp.commuter.m.d R;
    private final jp.co.jreast.jreastapp.commuter.m.b S;
    private final jp.co.jreast.jreastapp.commuter.m.f T;
    private final q U;
    private final u V;
    private final p W;
    private final jp.co.jreast.jreastapp.commuter.e.a X;
    public o a;
    private final androidx.lifecycle.p<String> b;
    private final LiveData<String> c;
    private final androidx.lifecycle.p<String> d;
    private final LiveData<String> e;
    private final androidx.lifecycle.p<String> f;
    private final LiveData<String> g;
    private final androidx.lifecycle.p<CharSequence> h;
    private final LiveData<CharSequence> i;
    private final al<Void> j;
    private final androidx.lifecycle.p<Integer> k;
    private final al<Void> l;
    private final androidx.lifecycle.p<Integer> m;
    private final androidx.lifecycle.p<Boolean> n;
    private final androidx.lifecycle.p<Integer> o;
    private final androidx.lifecycle.p<Drawable> p;
    private final androidx.lifecycle.p<String> q;
    private final androidx.lifecycle.p<Integer> r;
    private final androidx.lifecycle.p<Integer> s;
    private final androidx.lifecycle.p<Integer> t;
    private final LiveData<Integer> u;
    private final LiveData<Drawable> v;
    private final LiveData<String> w;
    private final LiveData<Integer> x;
    private final LiveData<Integer> y;
    private final LiveData<Integer> z;

    public j(jp.co.jreast.jreastapp.commuter.webview.b object, jp.co.jreast.jreastapp.commuter.m.d d2, jp.co.jreast.jreastapp.commuter.m.b b2, jp.co.jreast.jreastapp.commuter.m.f f2, q q2, u u2, p p2, jp.co.jreast.jreastapp.commuter.e.a a2) {
        kotlin.e.b.j.b(object, "commonJavaScriptInterface");
        kotlin.e.b.j.b(d2, "fileRepository");
        kotlin.e.b.j.b(b2, "drawableRepository");
        kotlin.e.b.j.b(f2, "localRailwayRepository");
        kotlin.e.b.j.b(q2, "siteGenerator");
        kotlin.e.b.j.b(u2, "locationHistoryRepository");
        kotlin.e.b.j.b(p2, "translationRepository");
        kotlin.e.b.j.b(a2, "audioWaveBeaconService");
        this.Q = object;
        this.R = d2;
        this.S = b2;
        this.T = f2;
        this.U = q2;
        this.V = u2;
        this.W = p2;
        this.X = a2;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b("");
        this.b = object;
        this.c = this.b;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b("");
        this.d = object;
        this.e = this.d;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b("");
        this.f = object;
        this.g = this.f;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b("");
        this.h = object;
        this.i = this.h;
        this.j = new al();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(8);
        this.k = object;
        this.l = new al();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(8);
        this.m = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.n = object;
        this.o = new androidx.lifecycle.p();
        this.p = new androidx.lifecycle.p();
        this.q = new androidx.lifecycle.p();
        this.r = new androidx.lifecycle.p();
        this.s = new androidx.lifecycle.p();
        this.t = new androidx.lifecycle.p();
        this.u = this.o;
        this.v = this.p;
        this.w = this.q;
        this.x = this.r;
        this.y = this.s;
        this.z = this.t;
        this.A = new al();
        this.B = new al();
        this.C = new al();
        this.D = new al();
        this.E = new al();
        this.F = new al();
        this.G = new Handler();
        this.H = new Runnable(){

            @Override
            public final void run() {
                this.R();
            }
        };
        this.I = f.a;
        this.K = "";
        this.L = new al();
        this.M = new al();
        this.N = new al();
        this.O = new al();
        this.P = "javascript:callIn()";
        this.Q.a(this);
        this.X.a(new jp.co.jreast.jreastapp.commuter.e.b(this));
    }

    public final al<Void> A() {
        return this.L;
    }

    public final al<Integer> B() {
        return this.M;
    }

    public final al<o> C() {
        return this.N;
    }

    public final al<Void> D() {
        return this.O;
    }

    public final String E() {
        return this.P;
    }

    public final jp.co.jreast.jreastapp.commuter.webview.b F() {
        return this.Q;
    }

    public final void G() {
        this.A.a(null);
    }

    public final void H() {
        if (this.I != f.a) {
            this.K();
        }
    }

    public final void I() {
        this.D.a(null);
        this.Q();
        this.F.a(null);
    }

    public final void J() {
        o o2 = this.a;
        if (o2 == null) {
            kotlin.e.b.j.b("site");
        }
        if (n.b((CharSequence)o2.b(), (CharSequence)"zw01", false, 2, null)) {
            this.Q.a(true);
            return;
        }
        o2 = this.a;
        if (o2 == null) {
            kotlin.e.b.j.b("site");
        }
        if (n.b((CharSequence)o2.b(), (CharSequence)"com-static/ew01/static/trainnet/trainnetTop.html", false, 2, null)) {
            this.Q.a(false);
            return;
        }
        this.K();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void K() {
        Object object;
        Object object2;
        block6 : {
            block7 : {
                block5 : {
                    if (n.c(this.K) != null) {
                        object = this.U;
                        object2 = this.a;
                        if (object2 == null) {
                            kotlin.e.b.j.b("site");
                        }
                        this.a = ((q)object).a((o)object2);
                    }
                    if ((object = (Integer)this.m.a()) != null && (Integer)object == 0) break block5;
                    al<o> al2 = this.C;
                    o o2 = this.a;
                    object2 = al2;
                    object = o2;
                    if (o2 != null) break block6;
                    object = o2;
                    object2 = al2;
                    break block7;
                }
                al<o> al3 = this.B;
                o o3 = this.a;
                object2 = al3;
                object = o3;
                if (o3 != null) break block6;
                object2 = al3;
                object = o3;
            }
            kotlin.e.b.j.b("site");
        }
        ((androidx.lifecycle.p)object2).a((o)object);
    }

    public final void L() {
        this.D.a(null);
    }

    public final void M() {
        this.X.b();
        this.G.removeCallbacks(this.H);
        this.E.a(null);
    }

    public final void N() {
        jp.co.jreast.jreastapp.commuter.webview.b b2 = this.Q;
        String string2 = this.K;
        o o2 = this.a;
        if (o2 == null) {
            kotlin.e.b.j.b("site");
        }
        b2.a(string2, o2.b());
    }

    public final void O() {
        o o2 = this.a;
        if (o2 == null) {
            kotlin.e.b.j.b("site");
        }
        o2 = new o("\u3054\u5229\u7528\u30ac\u30a4\u30c9", o2.h(), 0, 2131165303, 0, null, 0, null, 0, null, 1008, null);
        this.N.a(o2);
    }

    public final void P() {
        this.O.f();
    }

    public final void Q() {
        this.k.a(0);
        this.G.removeCallbacks(this.H);
        this.X.a();
        this.G.postDelayed(this.H, 15000L);
    }

    public final void R() {
        if (this.X.c()) {
            this.X.b();
            this.b(f.c);
        }
    }

    public final String a(String string2, String string3) {
        kotlin.e.b.j.b(string2, "filepath");
        kotlin.e.b.j.b(string3, "fontWeight");
        string2 = Base64.encodeToString((byte[])this.R.a(string2), (int)2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var style = document.createElement('style');");
        stringBuilder.append("style.appendChild(document.createTextNode(\"@font-face {font-family: 'YamaFont'; src: url(data:font/truetype;charset=utf-8;base64,");
        stringBuilder.append(string2);
        stringBuilder.append(") format('truetype');");
        stringBuilder.append("font-weight: ");
        stringBuilder.append(string3);
        stringBuilder.append(";}\"));document.head.appendChild(style);");
        return stringBuilder.toString();
    }

    public final void a(int n2) {
        this.k.b(n2);
    }

    public final void a(WebBackForwardList webBackForwardList) {
        kotlin.e.b.j.b((Object)webBackForwardList, "historyList");
        if (webBackForwardList.getCurrentIndex() == 0) {
            this.L.f();
            return;
        }
        if (webBackForwardList.getCurrentItem() == null) {
            return;
        }
        Object object = webBackForwardList.getCurrentItem();
        kotlin.e.b.j.a(object, "historyList.currentItem");
        String string2 = object.getUrl();
        kotlin.e.b.j.a((Object)string2, "currentUrl");
        int n2 = n.a((CharSequence)string2, ".html", 0, false, 6, null);
        object = string2;
        if (n2 > 0) {
            object = string2.substring(0, n2 + ((CharSequence)".html").length());
            kotlin.e.b.j.a(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        int n3 = -1;
        for (n2 = webBackForwardList.getCurrentIndex() - 1; n2 >= 0; --n2) {
            string2 = webBackForwardList.getItemAtIndex(n2);
            kotlin.e.b.j.a((Object)string2, "urlHistoryItem");
            string2 = string2.getUrl();
            kotlin.e.b.j.a((Object)string2, "urlHistoryItem.url");
            kotlin.e.b.j.a(object, "baseUrl");
            if (!n.a(string2, (String)object, false, 2, null)) break;
            --n3;
        }
        if (-n3 == webBackForwardList.getCurrentIndex() + 1) {
            this.L.f();
            return;
        }
        this.M.a(n3);
    }

    public final void a(String string2) {
        kotlin.e.b.j.b(string2, "<set-?>");
        this.K = string2;
    }

    public final void a(f f2) {
        kotlin.e.b.j.b((Object)f2, "<set-?>");
        this.I = f2;
    }

    public final void a(o o2) {
        kotlin.e.b.j.b(o2, "<set-?>");
        this.a = o2;
    }

    public final void a(boolean bl2) {
        this.J = bl2;
    }

    public final LiveData<String> b() {
        return this.c;
    }

    public final void b(int n2) {
        this.m.b(n2);
    }

    public final void b(String string2) {
        kotlin.e.b.j.b(string2, "<set-?>");
        this.P = string2;
    }

    public final void b(f f2) {
        Integer n2;
        kotlin.e.b.j.b((Object)f2, "errorType");
        this.I = f2;
        if (f2 == f.b && (n2 = this.z.a()) != null && n2 == 0) {
            this.d.a(this.W.a(f2.a()));
            this.f.a("");
        } else {
            this.d.a("");
            this.f.a(this.W.a(f2.a()));
            this.h.a(this.W.b(f2.b()));
        }
        this.m.a(0);
        this.l.a(null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void b(o o2) {
        block4 : {
            Drawable drawable2;
            androidx.lifecycle.p<Drawable> p2;
            block3 : {
                block2 : {
                    kotlin.e.b.j.b(o2, "site");
                    this.a = o2;
                    this.b.b(o2.a());
                    this.o.b(o2.c());
                    if (o2.j() == null) break block2;
                    p2 = this.p;
                    drawable2 = this.S.a(o2.j());
                    break block3;
                }
                if (o2.d() == null) break block4;
                p2 = this.p;
                drawable2 = this.S.a(o2.d());
            }
            p2.b(drawable2);
        }
        this.q.b(o2.f());
        this.r.b(o2.e());
        this.s.b(o2.g());
        this.t.b(o2.i());
    }

    public final LiveData<String> c() {
        return this.e;
    }

    public final void c(String object) {
        kotlin.e.b.j.b(object, "url");
        object = this.T.b((String)object);
        if (object != null) {
            this.a = this.U.a((RailwayLineInformation)object);
            object = this.a;
            if (object == null) {
                kotlin.e.b.j.b("site");
            }
            this.b((o)object);
        }
    }

    public final LiveData<String> d() {
        return this.g;
    }

    public final void d(String object) {
        kotlin.e.b.j.b(object, "url");
        object = this.T.b((String)object);
        if (object != null) {
            this.V.a((RailwayLineInformation)object);
        }
    }

    public final LiveData<CharSequence> e() {
        return this.i;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void e(String var1_1) {
        block3 : {
            block2 : {
                kotlin.e.b.j.b(var1_1, "url");
                var4_2 = (CharSequence)var1_1;
                var3_3 = n.b((CharSequence)var4_2, (CharSequence)"trainnet/cars", false, 2, null) != false || n.b((CharSequence)var4_2, (CharSequence)"trainnet/top/?beaconId", false, 2, null) != false ? 0 : 8;
                if (!n.b((CharSequence)var4_2, (CharSequence)"trainnet/homeExit", false, 2, null)) break block2;
                var4_2 = this.W;
                var2_4 = 2131558598;
                ** GOTO lbl17
            }
            if (!n.b((CharSequence)var4_2, (CharSequence)"trainnet/cars", false, 2, null)) break block3;
            var4_2 = this.W;
            var2_4 = 2131558597;
            ** GOTO lbl17
        }
        if (n.b((CharSequence)var4_2, (CharSequence)"trainnet/top/?beaconId", false, 2, null)) {
            var4_2 = this.W;
            var2_4 = 2131558603;
lbl17: // 3 sources:
            var4_2 = var4_2.a(var2_4);
        } else {
            var4_2 = "";
        }
        var1_1 = new o((String)var4_2, (String)var1_1, 8, null, 0, null, 0, null, var3_3, null, 760, null);
        this.N.b((o)var1_1);
    }

    public final LiveData<Integer> f() {
        return this.k;
    }

    public final void f(String string2) {
        kotlin.e.b.j.b(string2, "beaconId");
        this.E.a(null);
        this.X.b();
        this.G.removeCallbacks(this.H);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://rp00.cloudrail.jp/tw02/jreast_app/trainnet/top/?beaconId=");
        stringBuilder.append(string2);
        this.e(stringBuilder.toString());
    }

    public final al<Void> g() {
        return this.l;
    }

    public final LiveData<Integer> h() {
        return this.m;
    }

    public final LiveData<Boolean> i() {
        LiveData<Boolean> liveData = androidx.lifecycle.u.a((LiveData)this.m, a.a);
        kotlin.e.b.j.a(liveData, "Transformations.switchMa\u2026)\n            }\n        }");
        return liveData;
    }

    public final LiveData<Integer> j() {
        LiveData<Integer> liveData = androidx.lifecycle.u.a(this.g, b.a);
        kotlin.e.b.j.a(liveData, "Transformations.switchMa\u2026}\n            }\n        }");
        return liveData;
    }

    public final androidx.lifecycle.p<Boolean> k() {
        return this.n;
    }

    public final LiveData<Integer> l() {
        LiveData<Integer> liveData = androidx.lifecycle.u.a((LiveData)this.n, d.a);
        kotlin.e.b.j.a(liveData, "Transformations.switchMa\u2026E\n            }\n        }");
        return liveData;
    }

    public final LiveData<Integer> m() {
        return this.u;
    }

    public final LiveData<Drawable> n() {
        return this.v;
    }

    public final LiveData<String> o() {
        return this.w;
    }

    public final LiveData<Integer> p() {
        return this.x;
    }

    public final LiveData<Integer> q() {
        return this.y;
    }

    public final LiveData<Integer> r() {
        return this.z;
    }

    public final al<Void> s() {
        return this.A;
    }

    public final al<o> t() {
        return this.B;
    }

    public final al<o> u() {
        return this.C;
    }

    public final al<Void> v() {
        return this.D;
    }

    public final al<Void> w() {
        return this.E;
    }

    public final al<Void> x() {
        return this.F;
    }

    public final f y() {
        return this.I;
    }

    public final boolean z() {
        return this.J;
    }

}

