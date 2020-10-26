/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.os.Handler
 */
package jp.co.jreast.jreastapp.commuter;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Handler;
import f.n;
import java.io.File;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.ai;
import jp.co.jreast.jreastapp.commuter.common.k;
import jp.co.jreast.jreastapp.commuter.common.l;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.c;
import jp.co.jreast.jreastapp.commuter.m.d;
import jp.co.jreast.jreastapp.commuter.m.e;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.m.g;
import jp.co.jreast.jreastapp.commuter.m.j;
import jp.co.jreast.jreastapp.commuter.m.m;
import jp.co.jreast.jreastapp.commuter.m.n;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.m.r;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.m.t;
import jp.co.jreast.jreastapp.commuter.m.u;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020%H\u0007J\b\u0010&\u001a\u00020'H\u0007J\b\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020/H\u0007J\b\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u000203H\u0007J\b\u00104\u001a\u000205H\u0007J\b\u00106\u001a\u000207H\u0007J\b\u00108\u001a\u000209H\u0007J\b\u0010:\u001a\u00020;H\u0007J\b\u0010<\u001a\u00020=H\u0007J\b\u0010>\u001a\u00020?H\u0007J\b\u0010@\u001a\u00020AH\u0007J\b\u0010B\u001a\u00020CH\u0007J\b\u0010D\u001a\u00020EH\u0007J\b\u0010F\u001a\u00020GH\u0007J\b\u0010H\u001a\u00020IH\u0007J\b\u0010J\u001a\u00020KH\u0007J\b\u0010L\u001a\u00020MH\u0007J\b\u0010N\u001a\u00020OH\u0007J\b\u0010P\u001a\u00020QH\u0007J\b\u0010R\u001a\u00020SH\u0007J\b\u0010T\u001a\u00020UH\u0007J\b\u0010V\u001a\u00020WH\u0007R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006X"}, d2={"Ljp/co/jreast/jreastapp/commuter/AppModule;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "context", "colorRepository", "Ljp/co/jreast/jreastapp/commuter/repository/ColorRepository;", "localStationRepository", "Ljp/co/jreast/jreastapp/commuter/candidatestation/LocalStationRepository;", "networkAcknowledgementRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkAcknowledgementRepository;", "networkRouteSearchRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkRouteSearchRepository;", "networkTimetableSearchRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkTimetableSearchRepository;", "provideAnalyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "provideAssetManager", "Landroid/content/res/AssetManager;", "provideAudioWaveBeaconService", "Ljp/co/jreast/jreastapp/commuter/device/AudioWaveBeaconService;", "provideCommonJavaScriptInterface", "Ljp/co/jreast/jreastapp/commuter/webview/CommonJavaScriptInterface;", "provideCommuterDateTimeUtil", "Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "provideDrawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "provideExternalStorageRepository", "Ljp/co/jreast/jreastapp/commuter/repository/ExternalStorageRepository;", "provideFileOutputStream", "Ljp/co/jreast/jreastapp/commuter/util/FileUtil;", "provideFileRepository", "Ljp/co/jreast/jreastapp/commuter/repository/FileRepository;", "provideHandler", "Landroid/os/Handler;", "provideImagesMedia", "Ljp/co/jreast/jreastapp/commuter/common/ImagesMediaWrapper;", "provideLocalCacheRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalCacheRepository;", "provideLocalJsonReader", "Ljp/co/jreast/jreastapp/commuter/common/LocalJsonUtil;", "provideLocalRailwayRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;", "provideLocalRailwaySearcher", "Ljp/co/jreast/jreastapp/commuter/trainlocation/LocalRailwaySearcher;", "provideLocalStationSearcher", "Ljp/co/jreast/jreastapp/commuter/candidatestation/LocalStationSearcher;", "provideNetworkMixpanelAPIRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkMixpanelAPIRepository;", "provideNetworkServiceStatusRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkServiceStatusRepository;", "provideNetworkUserInformationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkUserInformationRepository;", "providePreviousNextInformationBuilder", "Ljp/co/jreast/jreastapp/commuter/skewscroll/PreviousNextRoutesInformationBuilder;", "provideRandomizer", "Ljp/co/jreast/jreastapp/commuter/common/Randomizer;", "provideRequestParameterUtil", "Ljp/co/jreast/jreastapp/commuter/http/RequestParameterUtil;", "provideSSTouchManager", "Ljp/sstouch/SSTouchManager;", "provideSchedulerProvider", "Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;", "provideScreenCaptor", "Ljp/co/jreast/jreastapp/commuter/util/ScreenCaptor;", "provideSiteGenerator", "Ljp/co/jreast/jreastapp/commuter/common/SiteGenerator;", "provideTaskStackBuilderGenerator", "Ljp/co/jreast/jreastapp/commuter/generator/TaskStackBuilderGenerator;", "provideTrainServiceConverter", "Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceConverter;", "provideTranslationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "provideUserFavoriteRouteRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "provideUserInformationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;", "provideUserSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "provideUserStationHistoryRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserStationHistoryRepository;", "provideUserTrainLocationHistoryRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;", "provideVibrationService", "Ljp/co/jreast/jreastapp/commuter/device/VibrationService;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a {
    private final Application a;

    public a(Application application) {
        kotlin.e.b.j.b((Object)application, "application");
        this.a = application;
    }

    public final jp.co.jreast.jreastapp.commuter.d.a A() {
        return new jp.co.jreast.jreastapp.commuter.d.a();
    }

    public final Handler B() {
        return new Handler();
    }

    public final jp.co.jreast.jreastapp.commuter.m.a C() {
        return new jp.co.jreast.jreastapp.commuter.m.a((Context)this.a);
    }

    public final AssetManager D() {
        Resources resources = this.a.getResources();
        kotlin.e.b.j.a((Object)resources, "context.resources");
        resources = resources.getAssets();
        kotlin.e.b.j.a((Object)resources, "context.resources.assets");
        return resources;
    }

    public final jp.co.jreast.jreastapp.commuter.e.c E() {
        return new jp.co.jreast.jreastapp.commuter.e.c((Context)this.a);
    }

    public final jp.co.jreast.jreastapp.commuter.e.a F() {
        return new jp.co.jreast.jreastapp.commuter.e.a(this.G());
    }

    public final jp.a.a G() {
        jp.a.a a2 = jp.a.b.a((Context)this.a);
        kotlin.e.b.j.a((Object)a2, "SSTouchManagerFactory.getSharedManager(context)");
        return a2;
    }

    public final jp.co.jreast.jreastapp.commuter.webview.b H() {
        return new jp.co.jreast.jreastapp.commuter.webview.b(this.n());
    }

    public final jp.co.jreast.jreastapp.commuter.i.a I() {
        return new jp.co.jreast.jreastapp.commuter.i.a();
    }

    public final jp.co.jreast.jreastapp.commuter.common.q J() {
        return new jp.co.jreast.jreastapp.commuter.common.q(this.k(), this.j());
    }

    public final jp.co.jreast.jreastapp.commuter.r.g K() {
        return new jp.co.jreast.jreastapp.commuter.r.g();
    }

    public final c L() {
        return new c((Context)this.a, this.A(), this.M(), this.N());
    }

    public final jp.co.jreast.jreastapp.commuter.common.e M() {
        return new jp.co.jreast.jreastapp.commuter.common.e();
    }

    public final jp.co.jreast.jreastapp.commuter.r.d N() {
        return new jp.co.jreast.jreastapp.commuter.r.d();
    }

    public final l O() {
        return new l();
    }

    public final k a() {
        return new k(new File(this.a.getFilesDir(), "/data"), new jp.co.jreast.jreastapp.commuter.m.a.b(), this.D());
    }

    public final jp.co.jreast.jreastapp.commuter.candidatestation.e b() {
        return new jp.co.jreast.jreastapp.commuter.candidatestation.e(null, this.D(), this.j(), this.c(), 1, null);
    }

    public final jp.co.jreast.jreastapp.commuter.candidatestation.f c() {
        return new jp.co.jreast.jreastapp.commuter.candidatestation.f();
    }

    public final jp.co.jreast.jreastapp.commuter.m.k d() {
        return new jp.co.jreast.jreastapp.commuter.m.k(this.x(), this.y());
    }

    public final jp.co.jreast.jreastapp.commuter.skewscroll.a e() {
        return new jp.co.jreast.jreastapp.commuter.skewscroll.a(this.j());
    }

    public final m f() {
        return new m(this.x(), this.y());
    }

    public final jp.co.jreast.jreastapp.commuter.m.l g() {
        return new jp.co.jreast.jreastapp.commuter.m.l(this.x(), this.y(), this.w());
    }

    public final g h() {
        return new g(this.x(), this.y());
    }

    public final j i() {
        return new j(this.x(), this.y());
    }

    public final p j() {
        return new p((Context)this.a);
    }

    public final b k() {
        return new b((Context)this.a, new jp.co.jreast.jreastapp.commuter.m.a.a());
    }

    public final q l() {
        File file = this.a.getFilesDir();
        kotlin.e.b.j.a((Object)file, "context.filesDir");
        return new q(file, new jp.co.jreast.jreastapp.commuter.m.a.b(), this.z());
    }

    public final t m() {
        File file = this.a.getFilesDir();
        kotlin.e.b.j.a((Object)file, "context.filesDir");
        return new t(file, new jp.co.jreast.jreastapp.commuter.m.a.b(), null, 4, null);
    }

    public final r n() {
        return new r((Context)this.a, null, 2, null);
    }

    public final n o() {
        return new n(this.x(), this.y());
    }

    public final s p() {
        return new s((Context)this.a);
    }

    public final e q() {
        return new e();
    }

    public final d r() {
        return new d((Context)this.a);
    }

    public final f s() {
        return new f(this.a(), this.v());
    }

    public final u t() {
        return new u(this.a());
    }

    public final jp.co.jreast.jreastapp.commuter.q.b u() {
        return new jp.co.jreast.jreastapp.commuter.q.b(this.j());
    }

    public final jp.co.jreast.jreastapp.commuter.trainlocation.l v() {
        return new jp.co.jreast.jreastapp.commuter.trainlocation.l();
    }

    public final jp.co.jreast.jreastapp.commuter.j.b w() {
        return new jp.co.jreast.jreastapp.commuter.j.b();
    }

    public final n.a x() {
        return new n.a();
    }

    public final jp.co.jreast.jreastapp.commuter.l.d y() {
        return new jp.co.jreast.jreastapp.commuter.l.b();
    }

    public final jp.co.jreast.jreastapp.commuter.l.a z() {
        return new jp.co.jreast.jreastapp.commuter.l.c().a((Context)this.a);
    }
}

