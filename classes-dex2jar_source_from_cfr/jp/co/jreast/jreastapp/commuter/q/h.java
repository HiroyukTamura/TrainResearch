/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.NetworkOnMainThreadException
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.NetworkOnMainThreadException;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import c.ad;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.common.j;
import jp.co.jreast.jreastapp.commuter.m.l;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.ChangeRoutes;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatus;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatusItem;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.r;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 ~2\u00020\u0001:\u0001~BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020 J\u0006\u0010Y\u001a\u00020ZJ\u0010\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0002J\u000e\u0010_\u001a\u00020Z2\u0006\u0010`\u001a\u000209J\u0016\u0010a\u001a\u00020\u00132\u0006\u0010X\u001a\u00020 2\u0006\u0010b\u001a\u00020 J\u000e\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fJ\u000e\u0010g\u001a\u00020 2\u0006\u0010h\u001a\u00020iJ\u000e\u0010j\u001a\u0002002\u0006\u0010k\u001a\u00020!J\u000e\u0010l\u001a\u0002002\u0006\u0010k\u001a\u00020iJ\u0010\u0010m\u001a\u00020Z2\u0006\u0010n\u001a\u00020\u0013H\u0002J\u000e\u0010o\u001a\u0002002\u0006\u0010k\u001a\u00020iJ\u000e\u0010p\u001a\u00020\u00132\u0006\u0010h\u001a\u00020iJ\u000e\u0010q\u001a\u00020\u00132\u0006\u0010h\u001a\u00020iJ\u0006\u0010r\u001a\u00020ZJ\u0006\u0010s\u001a\u00020ZJ\u0006\u0010t\u001a\u00020ZJ\u0010\u0010u\u001a\u00020Z2\u0006\u0010v\u001a\u00020\u0013H\u0002J\u000e\u0010w\u001a\u00020Z2\u0006\u0010x\u001a\u00020\u0015J\u0006\u0010y\u001a\u00020ZJ\u001e\u0010z\u001a\u00020Z2\u0006\u0010`\u001a\u0002092\u0006\u0010{\u001a\u00020\u00152\u0006\u0010|\u001a\u00020:J\u0006\u0010}\u001a\u00020ZR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u001a\u0010%\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00150\u00178F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0019R)\u00107\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020:080\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001dR\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001dR\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020=0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001dR \u0010A\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u00102\"\u0004\bB\u00104R \u0010C\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u00102\"\u0004\bD\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u0002000\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0019R\u001d\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0H0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010\u001dR\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020=0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010\u001dR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020=0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010\u001dR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020=0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\u001dR \u0010P\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u00102\"\u0004\bR\u00104R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020 0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0019R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceViewModel;", "Landroidx/lifecycle/ViewModel;", "networkServiceStatusRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkServiceStatusRepository;", "trainServiceConverter", "Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceConverter;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "cacheRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalCacheRepository;", "settingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/repository/NetworkServiceStatusRepository;Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceConverter;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/LocalCacheRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "_areaSelectPopupEnable", "Landroidx/lifecycle/MutableLiveData;", "", "_errorStatusVisibleProperty", "", "areaSelectPopupEnable", "Landroidx/lifecycle/LiveData;", "getAreaSelectPopupEnable", "()Landroidx/lifecycle/LiveData;", "areaServicePopupAnimationEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "getAreaServicePopupAnimationEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "areaServiceStatusChangedEvent", "", "", "Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "getAreaServiceStatusChangedEvent", "changeAreaEvent", "getChangeAreaEvent", "clickableKantoAreaMap", "getClickableKantoAreaMap", "()Z", "setClickableKantoAreaMap", "(Z)V", "currentArea", "getCurrentArea", "()I", "setCurrentArea", "(I)V", "delayedImageBitmap", "Landroid/graphics/drawable/Drawable;", "getDelayedImageBitmap", "()Landroidx/lifecycle/MutableLiveData;", "setDelayedImageBitmap", "(Landroidx/lifecycle/MutableLiveData;)V", "errorStatusVisibleProperty", "getErrorStatusVisibleProperty", "expandRowEvent", "Lkotlin/Triple;", "Landroid/view/View;", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;", "getExpandRowEvent", "hasImageDownloadFinishedEvent", "Ljava/lang/Void;", "getHasImageDownloadFinishedEvent", "hideErrorStatusAnimationEvent", "getHideErrorStatusAnimationEvent", "isAreaServiceStatusNormal", "setAreaServiceStatusNormal", "isLoading", "setLoading", "normalLiveDrawable", "getNormalLiveDrawable", "notifyDataSetChangedEvent", "", "getNotifyDataSetChangedEvent", "openDelayedDetailImageEvent", "getOpenDelayedDetailImageEvent", "openTrainServiceInfoEvent", "getOpenTrainServiceInfoEvent", "showErrorStatusAnimationEvent", "getShowErrorStatusAnimationEvent", "showZoomIcon", "getShowZoomIcon", "setShowZoomIcon", "titleLiveText", "getTitleLiveText", "titleUnitVisibility", "getTitleUnitVisibility", "addChangeRoute", "jrId", "checkAreaServiceStatus", "", "createBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "inputStream", "Ljava/io/InputStream;", "dismissPopup", "view", "existChangeRoute", "delayStatus", "getAdapter", "Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceAdapter;", "context", "Landroid/content/Context;", "getDelayFromStationToStationText", "lineServiceStatus", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatus;", "getDelayIcon", "serviceStatus", "getDelayIconForLine", "getDelayedKantoMapImage", "clickable", "getLineIcon", "goneOccurrenceTimeText", "goneResumeTimeText", "onRefresh", "openTrainServiceInfo", "sendViewEvent", "showOrHidePopup", "isShown", "tapAreaButton", "areaCode", "tapDelayedImage", "tapRow", "position", "lineServiceStatusItem", "tapSelectArea", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class h
extends v {
    public static final a a;
    private final jp.co.jreast.jreastapp.commuter.m.b A;
    private final jp.co.jreast.jreastapp.commuter.m.e B;
    private final s C;
    private final jp.co.jreast.jreastapp.commuter.l.a D;
    private int b;
    private boolean c;
    private final al<LineServiceStatusItem[]> d;
    private final al<Integer> e;
    private final al<Void> f;
    private final al<Void> g;
    private final al<r<View, Integer, LineServiceStatusItem>> h;
    private final al<Map<String, ServiceStatus>> i;
    private final al<Void> j;
    private final al<Void> k;
    private final al<Void> l;
    private androidx.lifecycle.p<Boolean> m;
    private final LiveData<Boolean> n;
    private androidx.lifecycle.p<Boolean> o;
    private androidx.lifecycle.p<Drawable> p;
    private androidx.lifecycle.p<Boolean> q;
    private androidx.lifecycle.p<Boolean> r;
    private androidx.lifecycle.p<Integer> s;
    private final al<Boolean> t;
    private final LiveData<Integer> u;
    private final LiveData<String> v;
    private final LiveData<Drawable> w;
    private final l x;
    private final jp.co.jreast.jreastapp.commuter.q.b y;
    private final p z;

    static {
        a = new a(null);
    }

    public h(l liveData, jp.co.jreast.jreastapp.commuter.q.b b2, p p2, jp.co.jreast.jreastapp.commuter.m.b b3, jp.co.jreast.jreastapp.commuter.m.e e2, s s2, jp.co.jreast.jreastapp.commuter.l.a a2) {
        kotlin.e.b.j.b(liveData, "networkServiceStatusRepository");
        kotlin.e.b.j.b(b2, "trainServiceConverter");
        kotlin.e.b.j.b(p2, "translationRepository");
        kotlin.e.b.j.b(b3, "drawableRepository");
        kotlin.e.b.j.b(e2, "cacheRepository");
        kotlin.e.b.j.b(s2, "settingsRepository");
        this.x = liveData;
        this.y = b2;
        this.z = p2;
        this.A = b3;
        this.B = e2;
        this.C = s2;
        this.D = a2;
        this.d = new al();
        this.e = new al();
        this.f = new al();
        this.g = new al();
        this.h = new al();
        this.i = new al();
        this.j = new al();
        this.k = new al();
        this.l = new al();
        liveData = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)liveData).b(false);
        this.m = liveData;
        this.n = this.m;
        liveData = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)liveData).b(false);
        this.o = liveData;
        this.p = new androidx.lifecycle.p();
        this.q = new androidx.lifecycle.p();
        liveData = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)liveData).b(false);
        this.r = liveData;
        liveData = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)liveData).b(8);
        this.s = liveData;
        this.t = new al();
        liveData = u.a((LiveData)this.e, g.a);
        kotlin.e.b.j.a(liveData, "Transformations.switchMa\u2026          }\n            }");
        this.u = liveData;
        liveData = u.a((LiveData)this.e, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    