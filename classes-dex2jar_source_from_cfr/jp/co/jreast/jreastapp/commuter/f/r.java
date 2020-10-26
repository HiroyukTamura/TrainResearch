/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ContentProvider
 *  android.os.Handler
 */
package jp.co.jreast.jreastapp.commuter.f;

import a.a.b;
import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.os.Handler;
import f.n;
import java.util.Collections;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.App;
import jp.co.jreast.jreastapp.commuter.acknowledgement.AcknowledgementActivity;
import jp.co.jreast.jreastapp.commuter.ad;
import jp.co.jreast.jreastapp.commuter.ae;
import jp.co.jreast.jreastapp.commuter.af;
import jp.co.jreast.jreastapp.commuter.ag;
import jp.co.jreast.jreastapp.commuter.ah;
import jp.co.jreast.jreastapp.commuter.candidatestation.CandidateStationActivity;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.RemoveAccessLogActivity;
import jp.co.jreast.jreastapp.commuter.f.a;
import jp.co.jreast.jreastapp.commuter.f.b;
import jp.co.jreast.jreastapp.commuter.f.c;
import jp.co.jreast.jreastapp.commuter.f.d;
import jp.co.jreast.jreastapp.commuter.f.e;
import jp.co.jreast.jreastapp.commuter.f.f;
import jp.co.jreast.jreastapp.commuter.f.g;
import jp.co.jreast.jreastapp.commuter.f.h;
import jp.co.jreast.jreastapp.commuter.f.i;
import jp.co.jreast.jreastapp.commuter.f.j;
import jp.co.jreast.jreastapp.commuter.f.k;
import jp.co.jreast.jreastapp.commuter.f.l;
import jp.co.jreast.jreastapp.commuter.f.m;
import jp.co.jreast.jreastapp.commuter.f.n;
import jp.co.jreast.jreastapp.commuter.f.o;
import jp.co.jreast.jreastapp.commuter.favoriteroute.FavoriteRouteRegistrationActivity;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.FavoriteRouteEditActivity;
import jp.co.jreast.jreastapp.commuter.launchscreen.LaunchScreenActivity;
import jp.co.jreast.jreastapp.commuter.main.MainActivity;
import jp.co.jreast.jreastapp.commuter.main.b;
import jp.co.jreast.jreastapp.commuter.main.c;
import jp.co.jreast.jreastapp.commuter.main.d;
import jp.co.jreast.jreastapp.commuter.main.e;
import jp.co.jreast.jreastapp.commuter.main.f;
import jp.co.jreast.jreastapp.commuter.main.g;
import jp.co.jreast.jreastapp.commuter.main.h;
import jp.co.jreast.jreastapp.commuter.main.i;
import jp.co.jreast.jreastapp.commuter.main.j;
import jp.co.jreast.jreastapp.commuter.main.k;
import jp.co.jreast.jreastapp.commuter.main.l;
import jp.co.jreast.jreastapp.commuter.main.m;
import jp.co.jreast.jreastapp.commuter.main.n;
import jp.co.jreast.jreastapp.commuter.main.o;
import jp.co.jreast.jreastapp.commuter.main.p;
import jp.co.jreast.jreastapp.commuter.main.q;
import jp.co.jreast.jreastapp.commuter.others.OthersActivity;
import jp.co.jreast.jreastapp.commuter.push.PushReceiveActivity;
import jp.co.jreast.jreastapp.commuter.selectsetting.SelectSettingActivity;
import jp.co.jreast.jreastapp.commuter.servicestatus.ServiceStatusDetailActivity;
import jp.co.jreast.jreastapp.commuter.skewscroll.SkewScrollRecyclerViewFragment;
import jp.co.jreast.jreastapp.commuter.timeselect.DepartureArrivalTimeSelectActivity;
import jp.co.jreast.jreastapp.commuter.trainlocation.CandidateLineActivity;
import jp.co.jreast.jreastapp.commuter.webview.WebViewActivity;

public final class r
implements jp.co.jreast.jreastapp.commuter.f.o {
    private javax.a.a<jp.co.jreast.jreastapp.commuter.r.g> A;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.c> B;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.q.b> C;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.e> D;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.u> E;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.common.q> F;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.f> G;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.webview.b> H;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.d> I;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.e.a> J;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.candidatestation.e> K;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.t> L;
    private javax.a.a<Handler> M;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.g> N;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.e.c> O;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.r> P;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.n> Q;
    private javax.a.a<n.a> R;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.l.d> S;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.j> T;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.i.a> U;
    private javax.a.a<h.a.a> a;
    private javax.a.a<c.a.a> b;
    private javax.a.a<d.a.a> c;
    private javax.a.a<f.a.a> d;
    private javax.a.a<m.a.a> e;
    private javax.a.a<l.a.a> f;
    private javax.a.a<n.a.a> g;
    private javax.a.a<a.a.a> h;
    private javax.a.a<e.a.a> i;
    private javax.a.a<g.a.a> j;
    private javax.a.a<b.a.a> k;
    private javax.a.a<k.a.a> l;
    private javax.a.a<i.a.a> m;
    private javax.a.a<j.a.a> n;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.l.a> o;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.s> p;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.q> q;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.p> r;
    private jp.co.jreast.jreastapp.commuter.j s;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.a> t;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> u;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.l> v;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.k> w;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.skewscroll.a> x;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.m.m> y;
    private javax.a.a<jp.co.jreast.jreastapp.commuter.common.l> z;

    private r(c c2) {
        this.a(c2);
    }

    public static o.a a() {
        return new c();
    }

    @Override
    private void a(c c2) {
        this.a = new javax.a.a<h.a.a>(){

            public h.a.a a() {
                return new p();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.b = new javax.a.a<c.a.a>(){

            public c.a.a a() {
                return new f();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.c = new javax.a.a<d.a.a>(){

            public d.a.a a() {
                return new h();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.d = new javax.a.a<f.a.a>(){

            public f.a.a a() {
                return new l();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.e = new javax.a.a<m.a.a>(){

            public m.a.a a() {
                return new z();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.f = new javax.a.a<l.a.a>(){

            public l.a.a a() {
                return new x();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.g = new javax.a.a<n.a.a>(){

            public n.a.a a() {
                return new ab();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.h = new javax.a.a<a.a.a>(){

            public a.a.a a() {
                return new a();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.i = new javax.a.a<e.a.a>(){

            public e.a.a a() {
                return new j();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.j = new javax.a.a<g.a.a>(){

            public g.a.a a() {
                return new n();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.k = new javax.a.a<b.a.a>(){

            public b.a.a a() {
                return new d();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.l = new javax.a.a<k.a.a>(){

            public k.a.a a() {
                return new v();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.m = new javax.a.a<i.a.a>(){

            public i.a.a a() {
                return new r();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.n = new javax.a.a<j.a.a>(){

            public j.a.a a() {
                return new t();
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        };
        this.o = a.b.b.a(jp.co.jreast.jreastapp.commuter.g.b(c2.a));
        this.p = a.b.b.a(ad.b(c2.a));
        this.q = a.b.b.a(jp.co.jreast.jreastapp.commuter.ab.b(c2.a));
        this.r = a.b.b.a(jp.co.jreast.jreastapp.commuter.aa.b(c2.a));
        this.s = jp.co.jreast.jreastapp.commuter.j.b(c2.a);
        this.t = a.b.b.a(jp.co.jreast.jreastapp.commuter.b.b(c2.a));
        this.u = a.b.b.a(jp.co.jreast.jreastapp.commuter.k.b(c2.a));
        this.v = a.b.b.a(jp.co.jreast.jreastapp.commuter.r.b(c2.a));
        this.w = a.b.b.a(jp.co.jreast.jreastapp.commuter.e.b(c2.a));
        this.x = a.b.b.a(jp.co.jreast.jreastapp.commuter.t.b(c2.a));
        this.y = a.b.b.a(jp.co.jreast.jreastapp.commuter.f.b(c2.a));
        this.z = a.b.b.a(jp.co.jreast.jreastapp.commuter.u.b(c2.a));
        this.A = a.b.b.a(jp.co.jreast.jreastapp.commuter.w.b(c2.a));
        this.B = a.b.b.a(jp.co.jreast.jreastapp.commuter.l.b(c2.a));
        this.C = a.b.b.a(jp.co.jreast.jreastapp.commuter.z.b(c2.a));
        this.D = a.b.b.a(jp.co.jreast.jreastapp.commuter.o.b(c2.a));
        this.E = a.b.b.a(af.b(c2.a));
        this.F = a.b.b.a(jp.co.jreast.jreastapp.commuter.x.b(c2.a));
        this.G = a.b.b.a(jp.co.jreast.jreastapp.commuter.p.b(c2.a));
        this.H = a.b.b.a(jp.co.jreast.jreastapp.commuter.i.b(c2.a));
        this.I = a.b.b.a(jp.co.jreast.jreastapp.commuter.m.b(c2.a));
        this.J = a.b.b.a(jp.co.jreast.jreastapp.commuter.h.b(c2.a));
        this.K = a.b.b.a(jp.co.jreast.jreastapp.commuter.c.b(c2.a));
        this.L = a.b.b.a(ae.b(c2.a));
        this.M = a.b.b.a(jp.co.jreast.jreastapp.commuter.n.b(c2.a));
        this.N = a.b.b.a(jp.co.jreast.jreastapp.commuter.d.b(c2.a));
        this.O = a.b.b.a(ag.b(c2.a));
        this.P = a.b.b.a(jp.co.jreast.jreastapp.commuter.ac.b(c2.a));
        this.Q = a.b.b.a(jp.co.jreast.jreastapp.commuter.s.b(c2.a));
        this.R = a.b.b.a(ah.b(c2.a));
        this.S = a.b.b.a(jp.co.jreast.jreastapp.commuter.v.b(c2.a));
        this.T = a.b.b.a(jp.co.jreast.jreastapp.commuter.q.b(c2.a));
        this.U = a.b.b.a(jp.co.jreast.jreastapp.commuter.y.b(c2.a));
    }

    private Map<Class<? extends Activity>, javax.a.a<b.b<? extends Activity>>> b() {
        return a.b.d.a(14).a(MainActivity.class, this.a).a(CandidateStationActivity.class, this.b).a(DepartureArrivalTimeSelectActivity.class, this.c).a(FavoriteRouteRegistrationActivity.class, this.d).a(ServiceStatusDetailActivity.class, this.e).a(SelectSettingActivity.class, this.f).a(WebViewActivity.class, this.g).a(AcknowledgementActivity.class, this.h).a(FavoriteRouteEditActivity.class, this.i).a(LaunchScreenActivity.class, this.j).a(CandidateLineActivity.class, this.k).a(RemoveAccessLogActivity.class, this.l).a(OthersActivity.class, this.m).a(PushReceiveActivity.class, this.n).a();
    }

    private App b(App app) {
        a.a.d.a(app, this.c());
        a.a.d.b(app, this.d());
        a.a.d.c(app, this.e());
        a.a.d.d(app, this.f());
        a.a.d.e(app, this.g());
        a.a.d.a(app);
        a.a.a.c.a(app, this.h());
        return app;
    }

    private a.a.e<Activity> c() {
        return a.a.f.a(this.b());
    }

    private a.a.e<BroadcastReceiver> d() {
        return a.a.f.a(Collections.emptyMap());
    }

    private a.a.e<Fragment> e() {
        return a.a.f.a(Collections.emptyMap());
    }

    private a.a.e<Service> f() {
        return a.a.f.a(Collections.emptyMap());
    }

    private a.a.e<ContentProvider> g() {
        return a.a.f.a(Collections.emptyMap());
    }

    private a.a.e<androidx.f.a.d> h() {
        return a.a.f.a(Collections.emptyMap());
    }

    @Override
    public void a(App app) {
        this.b(app);
    }

    private final class a
    extends a.a.a {
        private AcknowledgementActivity b;

        private a() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(AcknowledgementActivity acknowledgementActivity) {
            this.b = a.b.f.a(acknowledgementActivity);
        }

        public a.a b() {
            if (this.b != null) {
                return new b(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AcknowledgementActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((AcknowledgementActivity)object);
        }
    }

    private final class aa
    implements m.a {
        private jp.co.jreast.jreastapp.commuter.servicestatus.c b;

        private aa(z z2) {
            this.a(z2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.servicestatus.b.class, this.b);
        }

        @Override
        private void a(z z2) {
            this.b = jp.co.jreast.jreastapp.commuter.servicestatus.c.b(r.this.u, r.this.r, r.this.o);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private ServiceStatusDetailActivity b(ServiceStatusDetailActivity serviceStatusDetailActivity) {
            jp.co.jreast.jreastapp.commuter.servicestatus.a.a(serviceStatusDetailActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.servicestatus.a.a(serviceStatusDetailActivity, this.b());
            return serviceStatusDetailActivity;
        }

        @Override
        public void a(ServiceStatusDetailActivity serviceStatusDetailActivity) {
            this.b(serviceStatusDetailActivity);
        }
    }

    private final class ab
    extends n.a.a {
        private WebViewActivity b;

        private ab() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(WebViewActivity webViewActivity) {
            this.b = a.b.f.a(webViewActivity);
        }

        public n.a b() {
            if (this.b != null) {
                return new ac(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(WebViewActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((WebViewActivity)object);
        }
    }

    private final class ac
    implements n.a {
        private jp.co.jreast.jreastapp.commuter.webview.s b;

        private ac(ab ab2) {
            this.a(ab2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.webview.r.class, this.b);
        }

        @Override
        private void a(ab ab2) {
            this.b = jp.co.jreast.jreastapp.commuter.webview.s.b(r.this.H, r.this.u);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private WebViewActivity b(WebViewActivity webViewActivity) {
            jp.co.jreast.jreastapp.commuter.webview.p.a(webViewActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.webview.p.a(webViewActivity, this.b());
            return webViewActivity;
        }

        @Override
        public void a(WebViewActivity webViewActivity) {
            this.b(webViewActivity);
        }
    }

    private final class b
    implements a.a {
        private jp.co.jreast.jreastapp.commuter.acknowledgement.c b;

        private b(a a2) {
            this.a(a2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.acknowledgement.b.class, this.b);
        }

        @Override
        private void a(a a2) {
            this.b = jp.co.jreast.jreastapp.commuter.acknowledgement.c.b(r.this.N);
        }

        private AcknowledgementActivity b(AcknowledgementActivity acknowledgementActivity) {
            jp.co.jreast.jreastapp.commuter.acknowledgement.a.a(acknowledgementActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.acknowledgement.a.a(acknowledgementActivity, this.b());
            return acknowledgementActivity;
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        @Override
        public void a(AcknowledgementActivity acknowledgementActivity) {
            this.b(acknowledgementActivity);
        }
    }

    private static final class c
    implements o.a {
        private jp.co.jreast.jreastapp.commuter.a a;
        private App b;

        private c() {
        }

        @Override
        public /* synthetic */ o.a a(App app) {
            return this.b(app);
        }

        @Override
        public /* synthetic */ o.a a(jp.co.jreast.jreastapp.commuter.a a2) {
            return this.b(a2);
        }

        @Override
        public jp.co.jreast.jreastapp.commuter.f.o a() {
            if (this.a != null) {
                if (this.b != null) {
                    return new r(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(App.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(jp.co.jreast.jreastapp.commuter.a.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public c b(App app) {
            this.b = a.b.f.a(app);
            return this;
        }

        public c b(jp.co.jreast.jreastapp.commuter.a a2) {
            this.a = a.b.f.a(a2);
            return this;
        }
    }

    private final class d
    extends b.a.a {
        private CandidateLineActivity b;

        private d() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(CandidateLineActivity candidateLineActivity) {
            this.b = a.b.f.a(candidateLineActivity);
        }

        public b.a b() {
            if (this.b != null) {
                return new e(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(CandidateLineActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((CandidateLineActivity)object);
        }
    }

    private final class e
    implements b.a {
        private jp.co.jreast.jreastapp.commuter.trainlocation.e b;

        private e(d d2) {
            this.a(d2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.trainlocation.d.class, this.b);
        }

        @Override
        private void a(d d2) {
            this.b = jp.co.jreast.jreastapp.commuter.trainlocation.e.b(r.this.G, r.this.E);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private CandidateLineActivity b(CandidateLineActivity candidateLineActivity) {
            jp.co.jreast.jreastapp.commuter.trainlocation.a.a(candidateLineActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.trainlocation.a.a(candidateLineActivity, this.b());
            return candidateLineActivity;
        }

        @Override
        public void a(CandidateLineActivity candidateLineActivity) {
            this.b(candidateLineActivity);
        }
    }

    private final class f
    extends c.a.a {
        private CandidateStationActivity b;

        private f() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(CandidateStationActivity candidateStationActivity) {
            this.b = a.b.f.a(candidateStationActivity);
        }

        public c.a b() {
            if (this.b != null) {
                return new g(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(CandidateStationActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((CandidateStationActivity)object);
        }
    }

    private final class g
    implements c.a {
        private jp.co.jreast.jreastapp.commuter.candidatestation.d b;

        private g(f f2) {
            this.a(f2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.candidatestation.c.class, this.b);
        }

        @Override
        private void a(f f2) {
            this.b = jp.co.jreast.jreastapp.commuter.candidatestation.d.b(r.this.K, r.this.L);
        }

        private CandidateStationActivity b(CandidateStationActivity candidateStationActivity) {
            jp.co.jreast.jreastapp.commuter.candidatestation.a.a(candidateStationActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.candidatestation.a.a(candidateStationActivity, this.b());
            return candidateStationActivity;
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        @Override
        public void a(CandidateStationActivity candidateStationActivity) {
            this.b(candidateStationActivity);
        }
    }

    private final class h
    extends d.a.a {
        private DepartureArrivalTimeSelectActivity b;

        private h() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(DepartureArrivalTimeSelectActivity departureArrivalTimeSelectActivity) {
            this.b = a.b.f.a(departureArrivalTimeSelectActivity);
        }

        public d.a b() {
            if (this.b != null) {
                return new i(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DepartureArrivalTimeSelectActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((DepartureArrivalTimeSelectActivity)object);
        }
    }

    private final class i
    implements d.a {
        private jp.co.jreast.jreastapp.commuter.timeselect.c b;

        private i(h h2) {
            this.a(h2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.timeselect.b.class, this.b);
        }

        @Override
        private void a(h h2) {
            this.b = jp.co.jreast.jreastapp.commuter.timeselect.c.b(r.this.s, r.this.M);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private DepartureArrivalTimeSelectActivity b(DepartureArrivalTimeSelectActivity departureArrivalTimeSelectActivity) {
            jp.co.jreast.jreastapp.commuter.timeselect.a.a(departureArrivalTimeSelectActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.timeselect.a.a(departureArrivalTimeSelectActivity, this.b());
            return departureArrivalTimeSelectActivity;
        }

        @Override
        public void a(DepartureArrivalTimeSelectActivity departureArrivalTimeSelectActivity) {
            this.b(departureArrivalTimeSelectActivity);
        }
    }

    private final class j
    extends e.a.a {
        private FavoriteRouteEditActivity b;

        private j() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(FavoriteRouteEditActivity favoriteRouteEditActivity) {
            this.b = a.b.f.a(favoriteRouteEditActivity);
        }

        public e.a b() {
            if (this.b != null) {
                return new k(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(FavoriteRouteEditActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((FavoriteRouteEditActivity)object);
        }
    }

    private final class k
    implements e.a {
        private jp.co.jreast.jreastapp.commuter.favoriterouteedit.g b;

        private k(j j2) {
            this.a(j2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.favoriterouteedit.f.class, this.b);
        }

        @Override
        private void a(j j2) {
            this.b = jp.co.jreast.jreastapp.commuter.favoriterouteedit.g.b(r.this.q, r.this.O);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private FavoriteRouteEditActivity b(FavoriteRouteEditActivity favoriteRouteEditActivity) {
            jp.co.jreast.jreastapp.commuter.favoriterouteedit.c.a(favoriteRouteEditActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.favoriterouteedit.c.a(favoriteRouteEditActivity, this.b());
            return favoriteRouteEditActivity;
        }

        @Override
        public void a(FavoriteRouteEditActivity favoriteRouteEditActivity) {
            this.b(favoriteRouteEditActivity);
        }
    }

    private final class l
    extends f.a.a {
        private FavoriteRouteRegistrationActivity b;

        private l() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(FavoriteRouteRegistrationActivity favoriteRouteRegistrationActivity) {
            this.b = a.b.f.a(favoriteRouteRegistrationActivity);
        }

        public f.a b() {
            if (this.b != null) {
                return new m(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(FavoriteRouteRegistrationActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((FavoriteRouteRegistrationActivity)object);
        }
    }

    private final class m
    implements f.a {
        private jp.co.jreast.jreastapp.commuter.favoriteroute.c b;

        private m(l l2) {
            this.a(l2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.favoriteroute.b.class, this.b);
        }

        @Override
        private void a(l l2) {
            this.b = jp.co.jreast.jreastapp.commuter.favoriteroute.c.b(r.this.q);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private FavoriteRouteRegistrationActivity b(FavoriteRouteRegistrationActivity favoriteRouteRegistrationActivity) {
            jp.co.jreast.jreastapp.commuter.favoriteroute.a.a(favoriteRouteRegistrationActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.favoriteroute.a.a(favoriteRouteRegistrationActivity, this.b());
            return favoriteRouteRegistrationActivity;
        }

        @Override
        public void a(FavoriteRouteRegistrationActivity favoriteRouteRegistrationActivity) {
            this.b(favoriteRouteRegistrationActivity);
        }
    }

    private final class n
    extends g.a.a {
        private LaunchScreenActivity b;

        private n() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(LaunchScreenActivity launchScreenActivity) {
            this.b = a.b.f.a(launchScreenActivity);
        }

        public g.a b() {
            if (this.b != null) {
                return new o(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LaunchScreenActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((LaunchScreenActivity)object);
        }
    }

    private final class o
    implements g.a {
        private jp.co.jreast.jreastapp.commuter.m.i b;
        private jp.co.jreast.jreastapp.commuter.k.b c;
        private jp.co.jreast.jreastapp.commuter.launchscreen.c d;

        private o(n n2) {
            this.a(n2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.launchscreen.b.class, this.d);
        }

        @Override
        private void a(n n2) {
            this.b = jp.co.jreast.jreastapp.commuter.m.i.b(r.this.R, r.this.S);
            this.c = jp.co.jreast.jreastapp.commuter.k.b.b(this.b, r.this.q, r.this.s);
            this.d = jp.co.jreast.jreastapp.commuter.launchscreen.c.b(r.this.P, r.this.Q, r.this.p, r.this.L, this.c);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private LaunchScreenActivity b(LaunchScreenActivity launchScreenActivity) {
            jp.co.jreast.jreastapp.commuter.launchscreen.a.a(launchScreenActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.launchscreen.a.a(launchScreenActivity, this.b());
            return launchScreenActivity;
        }

        @Override
        public void a(LaunchScreenActivity launchScreenActivity) {
            this.b(launchScreenActivity);
        }
    }

    private final class p
    extends h.a.a {
        private MainActivity b;

        private p() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(MainActivity mainActivity) {
            this.b = a.b.f.a(mainActivity);
        }

        public h.a b() {
            if (this.b != null) {
                return new q(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(MainActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((MainActivity)object);
        }
    }

    private final class jp.co.jreast.jreastapp.commuter.f.r$q
    implements h.a {
        private jp.co.jreast.jreastapp.commuter.common.p A;
        private jp.co.jreast.jreastapp.commuter.trainlocation.z B;
        private jp.co.jreast.jreastapp.commuter.trainlocation.k C;
        private jp.co.jreast.jreastapp.commuter.trainlocation.q D;
        private jp.co.jreast.jreastapp.commuter.trainlocation.e E;
        private jp.co.jreast.jreastapp.commuter.webview.k F;
        private javax.a.a<c.a.a> b;
        private javax.a.a<h.a.a> c;
        private javax.a.a<k.a.a> d;
        private javax.a.a<d.a.a> e;
        private javax.a.a<q.a.a> f;
        private javax.a.a<i.a.a> g;
        private javax.a.a<o.a.a> h;
        private javax.a.a<n.a.a> i;
        private javax.a.a<e.a.a> j;
        private javax.a.a<f.a.a> k;
        private javax.a.a<b.a.a> l;
        private javax.a.a<j.a.a> m;
        private javax.a.a<l.a.a> n;
        private javax.a.a<p.a.a> o;
        private javax.a.a<m.a.a> p;
        private javax.a.a<g.a.a> q;
        private jp.co.jreast.jreastapp.commuter.main.t r;
        private jp.co.jreast.jreastapp.commuter.commuterpager.e s;
        private jp.co.jreast.jreastapp.commuter.commuterpager.b.d t;
        private jp.co.jreast.jreastapp.commuter.commuterpager.settings.k u;
        private jp.co.jreast.jreastapp.commuter.commuterpager.a.h v;
        private jp.co.jreast.jreastapp.commuter.o.i w;
        private jp.co.jreast.jreastapp.commuter.p.g x;
        private jp.co.jreast.jreastapp.commuter.n.m y;
        private jp.co.jreast.jreastapp.commuter.q.i z;

        private jp.co.jreast.jreastapp.commuter.f.r$q(jp.co.jreast.jreastapp.commuter.f.r$p p2) {
            this.a(p2);
        }

        private Map<Class<? extends androidx.f.a.d>, javax.a.a<b.b<? extends androidx.f.a.d>>> a() {
            return a.b.d.a(16).a(jp.co.jreast.jreastapp.commuter.commuterpager.b.class, this.b).a(jp.co.jreast.jreastapp.commuter.commuterpager.b.a.class, this.c).a(jp.co.jreast.jreastapp.commuter.commuterpager.settings.h.class, this.d).a(jp.co.jreast.jreastapp.commuter.commuterpager.a.a.class, this.e).a(jp.co.jreast.jreastapp.commuter.commuterpager.c.c.class, this.f).a(jp.co.jreast.jreastapp.commuter.o.e.class, this.g).a(jp.co.jreast.jreastapp.commuter.q.c.class, this.h).a(jp.co.jreast.jreastapp.commuter.trainlocation.w.class, this.i).a(jp.co.jreast.jreastapp.commuter.trainlocation.h.class, this.j).a(jp.co.jreast.jreastapp.commuter.trainlocation.n.class, this.k).a(jp.co.jreast.jreastapp.commuter.webview.g.class, this.l).a(jp.co.jreast.jreastapp.commuter.common.m.class, this.m).a(SkewScrollRecyclerViewFragment.class, this.n).a(jp.co.jreast.jreastapp.commuter.q.a.a.class, this.o).a(jp.co.jreast.jreastapp.commuter.p.b.class, this.p).a(jp.co.jreast.jreastapp.commuter.n.e.class, this.q).a();
        }

        @Override
        private void a(jp.co.jreast.jreastapp.commuter.f.r$p p2) {
            this.b = new javax.a.a<c.a.a>(){

                public c.a.a a() {
                    return new c();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.c = new javax.a.a<h.a.a>(){

                public h.a.a a() {
                    return new m();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.d = new javax.a.a<k.a.a>(){

                public k.a.a a() {
                    return new s();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.e = new javax.a.a<d.a.a>(){

                public d.a.a a() {
                    return new e();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.f = new javax.a.a<q.a.a>(){

                public q.a.a a() {
                    return new ae();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.g = new javax.a.a<i.a.a>(){

                public i.a.a a() {
                    return new o();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.h = new javax.a.a<o.a.a>(){

                public o.a.a a() {
                    return new aa();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.i = new javax.a.a<n.a.a>(){

                public n.a.a a() {
                    return new y();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.j = new javax.a.a<e.a.a>(){

                public e.a.a a() {
                    return new g();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.k = new javax.a.a<f.a.a>(){

                public f.a.a a() {
                    return new i();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.l = new javax.a.a<b.a.a>(){

                public b.a.a a() {
                    return new a();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.m = new javax.a.a<j.a.a>(){

                public j.a.a a() {
                    return new q();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.n = new javax.a.a<l.a.a>(){

                public l.a.a a() {
                    return new u();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.o = new javax.a.a<p.a.a>(){

                public p.a.a a() {
                    return new ac();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.p = new javax.a.a<m.a.a>(){

                public m.a.a a() {
                    return new w();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.q = new javax.a.a<g.a.a>(){

                public g.a.a a() {
                    return new k();
                }

                @Override
                public /* synthetic */ Object b() {
                    return this.a();
                }
            };
            this.r = jp.co.jreast.jreastapp.commuter.main.t.b(r.this.o);
            this.s = jp.co.jreast.jreastapp.commuter.commuterpager.e.b(r.this.p, r.this.q, r.this.r);
            this.t = jp.co.jreast.jreastapp.commuter.commuterpager.b.d.b(r.this.s, r.this.r, r.this.p, r.this.t, r.this.o);
            this.u = jp.co.jreast.jreastapp.commuter.commuterpager.settings.k.b(r.this.p, r.this.r, r.this.o);
            this.v = jp.co.jreast.jreastapp.commuter.commuterpager.a.h.b(r.this.u, r.this.v, r.this.r, r.this.o);
            this.w = jp.co.jreast.jreastapp.commuter.o.i.b(r.this.w, r.this.u, r.this.p, r.this.r, r.this.x, r.this.s, r.this.o);
            this.x = jp.co.jreast.jreastapp.commuter.p.g.b(r.this.y, r.this.u, r.this.p, r.this.r, r.this.x, r.this.s, r.this.o);
            this.y = jp.co.jreast.jreastapp.commuter.n.m.b(r.this.z, r.this.A, r.this.B, r.this.u, r.this.q, r.this.p, r.this.r, r.this.o);
            this.z = jp.co.jreast.jreastapp.commuter.q.i.b(r.this.v, r.this.C, r.this.r, r.this.u, r.this.D, r.this.p, r.this.o);
            this.A = jp.co.jreast.jreastapp.commuter.common.p.b(r.this.D);
            this.B = jp.co.jreast.jreastapp.commuter.trainlocation.z.b(r.this.E, r.this.p, r.this.F, r.this.o, r.this.G, r.this.r);
            this.C = jp.co.jreast.jreastapp.commuter.trainlocation.k.b(r.this.E, r.this.u);
            this.D = jp.co.jreast.jreastapp.commuter.trainlocation.q.b(r.this.G, r.this.u);
            this.E = jp.co.jreast.jreastapp.commuter.trainlocation.e.b(r.this.G, r.this.E);
            this.F = jp.co.jreast.jreastapp.commuter.webview.k.b(r.this.H, r.this.I, r.this.u, r.this.G, r.this.F, r.this.E, r.this.r, r.this.J);
        }

        private a.a.e<androidx.f.a.d> b() {
            return a.a.f.a(this.a());
        }

        private MainActivity b(MainActivity mainActivity) {
            jp.co.jreast.jreastapp.commuter.main.a.a(mainActivity, this.b());
            jp.co.jreast.jreastapp.commuter.main.a.a(mainActivity, this.d());
            return mainActivity;
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> c() {
            return a.b.d.a(16).a(jp.co.jreast.jreastapp.commuter.main.s.class, this.r).a(jp.co.jreast.jreastapp.commuter.commuterpager.d.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.s)).a(jp.co.jreast.jreastapp.commuter.commuterpager.b.c.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.t)).a(jp.co.jreast.jreastapp.commuter.commuterpager.settings.j.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.u)).a(jp.co.jreast.jreastapp.commuter.commuterpager.a.g.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.v)).a(jp.co.jreast.jreastapp.commuter.o.h.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.w)).a(jp.co.jreast.jreastapp.commuter.p.f.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.x)).a(jp.co.jreast.jreastapp.commuter.n.k.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.y)).a(jp.co.jreast.jreastapp.commuter.q.h.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.z)).a(jp.co.jreast.jreastapp.commuter.common.o.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.A)).a(jp.co.jreast.jreastapp.commuter.q.a.c.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)jp.co.jreast.jreastapp.commuter.q.a.d.d())).a(jp.co.jreast.jreastapp.commuter.trainlocation.y.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.B)).a(jp.co.jreast.jreastapp.commuter.trainlocation.j.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.C)).a(jp.co.jreast.jreastapp.commuter.trainlocation.p.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.D)).a(jp.co.jreast.jreastapp.commuter.trainlocation.d.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.E)).a(jp.co.jreast.jreastapp.commuter.webview.j.class, (jp.co.jreast.jreastapp.commuter.main.t)((Object)this.F)).a();
        }

        private jp.co.jreast.jreastapp.commuter.f.t d() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.c());
        }

        @Override
        public void a(MainActivity mainActivity) {
            this.b(mainActivity);
        }

        private final class a
        extends b.a.a {
            private jp.co.jreast.jreastapp.commuter.webview.g b;

            private a() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.webview.g g2) {
                this.b = a.b.f.a(g2);
            }

            public b.a b() {
                if (this.b != null) {
                    return new b(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.webview.g.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.webview.g)object);
            }
        }

        private final class aa
        extends o.a.a {
            private jp.co.jreast.jreastapp.commuter.q.c b;

            private aa() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.q.c c2) {
                this.b = a.b.f.a(c2);
            }

            public o.a b() {
                if (this.b != null) {
                    return new ab(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.q.c.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.q.c)object);
            }
        }

        private final class ab
        implements o.a {
            private ab(aa aa2) {
            }

            private jp.co.jreast.jreastapp.commuter.q.c b(jp.co.jreast.jreastapp.commuter.q.c c2) {
                jp.co.jreast.jreastapp.commuter.q.d.a(c2, q.this.d());
                return c2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.q.c c2) {
                this.b(c2);
            }
        }

        private final class ac
        extends p.a.a {
            private jp.co.jreast.jreastapp.commuter.q.a.a b;

            private ac() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.q.a.a a2) {
                this.b = a.b.f.a(a2);
            }

            public p.a b() {
                if (this.b != null) {
                    return new ad(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.q.a.a.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.q.a.a)object);
            }
        }

        private final class ad
        implements p.a {
            private ad(ac ac2) {
            }

            private jp.co.jreast.jreastapp.commuter.q.a.a b(jp.co.jreast.jreastapp.commuter.q.a.a a2) {
                jp.co.jreast.jreastapp.commuter.q.a.b.a(a2, q.this.b());
                jp.co.jreast.jreastapp.commuter.q.a.b.a(a2, q.this.d());
                return a2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.q.a.a a2) {
                this.b(a2);
            }
        }

        private final class ae
        extends q.a.a {
            private jp.co.jreast.jreastapp.commuter.commuterpager.c.c b;

            private ae() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.c.c c2) {
                this.b = a.b.f.a(c2);
            }

            public q.a b() {
                if (this.b != null) {
                    return new af(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.commuterpager.c.c.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.commuterpager.c.c)object);
            }
        }

        private final class af
        implements q.a {
            private af(ae ae2) {
            }

            private jp.co.jreast.jreastapp.commuter.commuterpager.c.c b(jp.co.jreast.jreastapp.commuter.commuterpager.c.c c2) {
                jp.co.jreast.jreastapp.commuter.commuterpager.c.d.a(c2, q.this.d());
                return c2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.c.c c2) {
                this.b(c2);
            }
        }

        private final class b
        implements b.a {
            private b(a a2) {
            }

            private jp.co.jreast.jreastapp.commuter.webview.g b(jp.co.jreast.jreastapp.commuter.webview.g g2) {
                jp.co.jreast.jreastapp.commuter.webview.i.a(g2, q.this.d());
                return g2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.webview.g g2) {
                this.b(g2);
            }
        }

        private final class c
        extends c.a.a {
            private jp.co.jreast.jreastapp.commuter.commuterpager.b b;

            private c() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.b b2) {
                this.b = a.b.f.a(b2);
            }

            public c.a b() {
                if (this.b != null) {
                    return new d(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.commuterpager.b.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.commuterpager.b)object);
            }
        }

        private final class d
        implements c.a {
            private d(c c2) {
            }

            private jp.co.jreast.jreastapp.commuter.commuterpager.b b(jp.co.jreast.jreastapp.commuter.commuterpager.b b2) {
                jp.co.jreast.jreastapp.commuter.commuterpager.c.a(b2, q.this.d());
                return b2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.b b2) {
                this.b(b2);
            }
        }

        private final class e
        extends d.a.a {
            private jp.co.jreast.jreastapp.commuter.commuterpager.a.a b;

            private e() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.a.a a2) {
                this.b = a.b.f.a(a2);
            }

            public d.a b() {
                if (this.b != null) {
                    return new f(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.commuterpager.a.a.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.commuterpager.a.a)object);
            }
        }

        private final class f
        implements d.a {
            private f(e e2) {
            }

            private jp.co.jreast.jreastapp.commuter.commuterpager.a.a b(jp.co.jreast.jreastapp.commuter.commuterpager.a.a a2) {
                jp.co.jreast.jreastapp.commuter.commuterpager.a.b.a(a2, q.this.d());
                return a2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.a.a a2) {
                this.b(a2);
            }
        }

        private final class g
        extends e.a.a {
            private jp.co.jreast.jreastapp.commuter.trainlocation.h b;

            private g() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.trainlocation.h h2) {
                this.b = a.b.f.a(h2);
            }

            public e.a b() {
                if (this.b != null) {
                    return new h(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.trainlocation.h.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.trainlocation.h)object);
            }
        }

        private final class h
        implements e.a {
            private h(g g2) {
            }

            private jp.co.jreast.jreastapp.commuter.trainlocation.h b(jp.co.jreast.jreastapp.commuter.trainlocation.h h2) {
                jp.co.jreast.jreastapp.commuter.trainlocation.i.a(h2, q.this.d());
                return h2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.trainlocation.h h2) {
                this.b(h2);
            }
        }

        private final class i
        extends f.a.a {
            private jp.co.jreast.jreastapp.commuter.trainlocation.n b;

            private i() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.trainlocation.n n2) {
                this.b = a.b.f.a(n2);
            }

            public f.a b() {
                if (this.b != null) {
                    return new j(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.trainlocation.n.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.trainlocation.n)object);
            }
        }

        private final class j
        implements f.a {
            private j(i i2) {
            }

            private jp.co.jreast.jreastapp.commuter.trainlocation.n b(jp.co.jreast.jreastapp.commuter.trainlocation.n n2) {
                jp.co.jreast.jreastapp.commuter.trainlocation.o.a(n2, q.this.d());
                return n2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.trainlocation.n n2) {
                this.b(n2);
            }
        }

        private final class k
        extends g.a.a {
            private jp.co.jreast.jreastapp.commuter.n.e b;

            private k() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.n.e e2) {
                this.b = a.b.f.a(e2);
            }

            public g.a b() {
                if (this.b != null) {
                    return new l(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.n.e.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.n.e)object);
            }
        }

        private final class l
        implements g.a {
            private l(k k2) {
            }

            private jp.co.jreast.jreastapp.commuter.n.e b(jp.co.jreast.jreastapp.commuter.n.e e2) {
                jp.co.jreast.jreastapp.commuter.n.h.a(e2, q.this.d());
                return e2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.n.e e2) {
                this.b(e2);
            }
        }

        private final class m
        extends h.a.a {
            private jp.co.jreast.jreastapp.commuter.commuterpager.b.a b;

            private m() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.b.a a2) {
                this.b = a.b.f.a(a2);
            }

            public h.a b() {
                if (this.b != null) {
                    return new n(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.commuterpager.b.a.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.commuterpager.b.a)object);
            }
        }

        private final class n
        implements h.a {
            private n(m m2) {
            }

            private jp.co.jreast.jreastapp.commuter.commuterpager.b.a b(jp.co.jreast.jreastapp.commuter.commuterpager.b.a a2) {
                jp.co.jreast.jreastapp.commuter.commuterpager.b.b.a(a2, q.this.d());
                return a2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.b.a a2) {
                this.b(a2);
            }
        }

        private final class o
        extends i.a.a {
            private jp.co.jreast.jreastapp.commuter.o.e b;

            private o() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.o.e e2) {
                this.b = a.b.f.a(e2);
            }

            public i.a b() {
                if (this.b != null) {
                    return new p(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.o.e.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.o.e)object);
            }
        }

        private final class p
        implements i.a {
            private p(o o2) {
            }

            private jp.co.jreast.jreastapp.commuter.o.e b(jp.co.jreast.jreastapp.commuter.o.e e2) {
                jp.co.jreast.jreastapp.commuter.o.f.a(e2, q.this.d());
                return e2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.o.e e2) {
                this.b(e2);
            }
        }

        private final class q
        extends j.a.a {
            private jp.co.jreast.jreastapp.commuter.common.m b;

            private q() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.common.m m2) {
                this.b = a.b.f.a(m2);
            }

            public j.a b() {
                if (this.b != null) {
                    return new r(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.common.m.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.common.m)object);
            }
        }

        private final class r
        implements j.a {
            private r(q q3) {
            }

            private jp.co.jreast.jreastapp.commuter.common.m b(jp.co.jreast.jreastapp.commuter.common.m m2) {
                jp.co.jreast.jreastapp.commuter.common.n.a(m2, q.this.d());
                return m2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.common.m m2) {
                this.b(m2);
            }
        }

        private final class s
        extends k.a.a {
            private jp.co.jreast.jreastapp.commuter.commuterpager.settings.h b;

            private s() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.settings.h h2) {
                this.b = a.b.f.a(h2);
            }

            public k.a b() {
                if (this.b != null) {
                    return new t(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.commuterpager.settings.h.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.commuterpager.settings.h)object);
            }
        }

        private final class t
        implements k.a {
            private t(s s2) {
            }

            private jp.co.jreast.jreastapp.commuter.commuterpager.settings.h b(jp.co.jreast.jreastapp.commuter.commuterpager.settings.h h2) {
                jp.co.jreast.jreastapp.commuter.commuterpager.settings.i.a(h2, q.this.d());
                jp.co.jreast.jreastapp.commuter.commuterpager.settings.i.a(h2, (jp.co.jreast.jreastapp.commuter.m.p)r.this.r.b());
                return h2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.commuterpager.settings.h h2) {
                this.b(h2);
            }
        }

        private final class u
        extends l.a.a {
            private SkewScrollRecyclerViewFragment b;

            private u() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(SkewScrollRecyclerViewFragment skewScrollRecyclerViewFragment) {
                this.b = a.b.f.a(skewScrollRecyclerViewFragment);
            }

            public l.a b() {
                if (this.b != null) {
                    return new v(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(SkewScrollRecyclerViewFragment.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((SkewScrollRecyclerViewFragment)object);
            }
        }

        private final class v
        implements l.a {
            private v(u u2) {
            }

            private SkewScrollRecyclerViewFragment b(SkewScrollRecyclerViewFragment skewScrollRecyclerViewFragment) {
                jp.co.jreast.jreastapp.commuter.skewscroll.f.a(skewScrollRecyclerViewFragment, q.this.d());
                return skewScrollRecyclerViewFragment;
            }

            @Override
            public void a(SkewScrollRecyclerViewFragment skewScrollRecyclerViewFragment) {
                this.b(skewScrollRecyclerViewFragment);
            }
        }

        private final class w
        extends m.a.a {
            private jp.co.jreast.jreastapp.commuter.p.b b;

            private w() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.p.b b2) {
                this.b = a.b.f.a(b2);
            }

            public m.a b() {
                if (this.b != null) {
                    return new x(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.p.b.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.p.b)object);
            }
        }

        private final class x
        implements m.a {
            private x(w w2) {
            }

            private jp.co.jreast.jreastapp.commuter.p.b b(jp.co.jreast.jreastapp.commuter.p.b b2) {
                jp.co.jreast.jreastapp.commuter.p.c.a(b2, q.this.d());
                return b2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.p.b b2) {
                this.b(b2);
            }
        }

        private final class y
        extends n.a.a {
            private jp.co.jreast.jreastapp.commuter.trainlocation.w b;

            private y() {
            }

            @Override
            public /* synthetic */ a.a.b a() {
                return this.b();
            }

            public void a(jp.co.jreast.jreastapp.commuter.trainlocation.w w2) {
                this.b = a.b.f.a(w2);
            }

            public n.a b() {
                if (this.b != null) {
                    return new z(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jp.co.jreast.jreastapp.commuter.trainlocation.w.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            @Override
            public /* synthetic */ void b(Object object) {
                this.a((jp.co.jreast.jreastapp.commuter.trainlocation.w)object);
            }
        }

        private final class z
        implements n.a {
            private z(y y2) {
            }

            private jp.co.jreast.jreastapp.commuter.trainlocation.w b(jp.co.jreast.jreastapp.commuter.trainlocation.w w2) {
                jp.co.jreast.jreastapp.commuter.trainlocation.x.a(w2, q.this.d());
                return w2;
            }

            @Override
            public void a(jp.co.jreast.jreastapp.commuter.trainlocation.w w2) {
                this.b(w2);
            }
        }

    }

    private final class r
    extends i.a.a {
        private OthersActivity b;

        private r() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(OthersActivity othersActivity) {
            this.b = a.b.f.a(othersActivity);
        }

        public i.a b() {
            if (this.b != null) {
                return new s(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(OthersActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((OthersActivity)object);
        }
    }

    private final class s
    implements i.a {
        private jp.co.jreast.jreastapp.commuter.others.f b;

        private s(r r3) {
            this.a(r3);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.others.d.class, this.b);
        }

        @Override
        private void a(r r2) {
            this.b = jp.co.jreast.jreastapp.commuter.others.f.b(r.this.P);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private OthersActivity b(OthersActivity othersActivity) {
            jp.co.jreast.jreastapp.commuter.others.a.a(othersActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.others.a.a(othersActivity, this.b());
            return othersActivity;
        }

        @Override
        public void a(OthersActivity othersActivity) {
            this.b(othersActivity);
        }
    }

    private final class t
    extends j.a.a {
        private PushReceiveActivity b;

        private t() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(PushReceiveActivity pushReceiveActivity) {
            this.b = a.b.f.a(pushReceiveActivity);
        }

        public j.a b() {
            if (this.b != null) {
                return new u(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(PushReceiveActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((PushReceiveActivity)object);
        }
    }

    private final class u
    implements j.a {
        private jp.co.jreast.jreastapp.commuter.push.d b;

        private u(t t2) {
            this.a(t2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.push.c.class, this.b);
        }

        @Override
        private void a(t t2) {
            this.b = jp.co.jreast.jreastapp.commuter.push.d.b(r.this.P, r.this.r);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private PushReceiveActivity b(PushReceiveActivity pushReceiveActivity) {
            jp.co.jreast.jreastapp.commuter.push.b.a(pushReceiveActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.push.b.a(pushReceiveActivity, this.b());
            jp.co.jreast.jreastapp.commuter.push.b.a(pushReceiveActivity, (jp.co.jreast.jreastapp.commuter.i.a)r.this.U.b());
            return pushReceiveActivity;
        }

        @Override
        public void a(PushReceiveActivity pushReceiveActivity) {
            this.b(pushReceiveActivity);
        }
    }

    private final class v
    extends k.a.a {
        private RemoveAccessLogActivity b;

        private v() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(RemoveAccessLogActivity removeAccessLogActivity) {
            this.b = a.b.f.a(removeAccessLogActivity);
        }

        public k.a b() {
            if (this.b != null) {
                return new w(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(RemoveAccessLogActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((RemoveAccessLogActivity)object);
        }
    }

    private final class w
    implements k.a {
        private jp.co.jreast.jreastapp.commuter.commuterpager.settings.f b;

        private w(v v2) {
            this.a(v2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.commuterpager.settings.e.class, this.b);
        }

        @Override
        private void a(v v2) {
            this.b = jp.co.jreast.jreastapp.commuter.commuterpager.settings.f.b(r.this.T, r.this.o, r.this.p);
        }

        private RemoveAccessLogActivity b(RemoveAccessLogActivity removeAccessLogActivity) {
            jp.co.jreast.jreastapp.commuter.commuterpager.settings.a.a(removeAccessLogActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.commuterpager.settings.a.a(removeAccessLogActivity, this.b());
            return removeAccessLogActivity;
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        @Override
        public void a(RemoveAccessLogActivity removeAccessLogActivity) {
            this.b(removeAccessLogActivity);
        }
    }

    private final class x
    extends l.a.a {
        private SelectSettingActivity b;

        private x() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(SelectSettingActivity selectSettingActivity) {
            this.b = a.b.f.a(selectSettingActivity);
        }

        public l.a b() {
            if (this.b != null) {
                return new y(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(SelectSettingActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((SelectSettingActivity)object);
        }
    }

    private final class y
    implements l.a {
        private jp.co.jreast.jreastapp.commuter.selectsetting.f b;

        private y(x x2) {
            this.a(x2);
        }

        private Map<Class<? extends androidx.lifecycle.v>, javax.a.a<androidx.lifecycle.v>> a() {
            return Collections.singletonMap(jp.co.jreast.jreastapp.commuter.selectsetting.d.class, this.b);
        }

        @Override
        private void a(x x2) {
            this.b = jp.co.jreast.jreastapp.commuter.selectsetting.f.b(r.this.p, r.this.r, r.this.o);
        }

        private jp.co.jreast.jreastapp.commuter.f.t b() {
            return new jp.co.jreast.jreastapp.commuter.f.t(this.a());
        }

        private SelectSettingActivity b(SelectSettingActivity selectSettingActivity) {
            jp.co.jreast.jreastapp.commuter.selectsetting.a.a(selectSettingActivity, r.this.h());
            jp.co.jreast.jreastapp.commuter.selectsetting.a.a(selectSettingActivity, this.b());
            return selectSettingActivity;
        }

        @Override
        public void a(SelectSettingActivity selectSettingActivity) {
            this.b(selectSettingActivity);
        }
    }

    private final class z
    extends m.a.a {
        private ServiceStatusDetailActivity b;

        private z() {
        }

        @Override
        public /* synthetic */ a.a.b a() {
            return this.b();
        }

        public void a(ServiceStatusDetailActivity serviceStatusDetailActivity) {
            this.b = a.b.f.a(serviceStatusDetailActivity);
        }

        public m.a b() {
            if (this.b != null) {
                return new aa(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ServiceStatusDetailActivity.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((ServiceStatusDetailActivity)object);
        }
    }

}

