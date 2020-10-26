/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package jp.co.jreast.jreastapp.commuter.servicestatus;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006)"}, d2={"Ljp/co/jreast/jreastapp/commuter/servicestatus/ServiceStatusDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "getAnalyticsProvider", "()Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "dismissServiceStatusDetailEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getDismissServiceStatusDetailEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "getDrawableRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "setDrawableRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;)V", "line", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "getLine", "()Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "setLine", "(Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;)V", "getTranslationRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "viewTypeName", "", "getViewTypeName", "()Ljava/lang/String;", "setViewTypeName", "(Ljava/lang/String;)V", "getDelayIcon", "Landroid/graphics/drawable/Drawable;", "getDispDelayMinute", "getLineIcon", "sendViewServiceStatusEvent", "", "tapCancelButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends v {
    public RailwayLine a;
    public String b;
    private final al<Void> c;
    private jp.co.jreast.jreastapp.commuter.m.b d;
    private final p e;
    private final a f;

    public b(jp.co.jreast.jreastapp.commuter.m.b b2, p p2, a a2) {
        j.b(b2, "drawableRepository");
        j.b(p2, "translationRepository");
        this.d = b2;
        this.e = p2;
        this.f = a2;
        this.c = new al();
    }

    public final void a(String string2) {
        j.b(string2, "<set-?>");
        this.b = string2;
    }

    public final void a(RailwayLine railwayLine) {
        j.b(railwayLine, "<set-?>");
        this.a = railwayLine;
    }

    public final al<Void> b() {
        return this.c;
    }

    public final RailwayLine c() {
        RailwayLine railwayLine = this.a;
        if (railwayLine == null) {
            j.b("line");
        }
        return railwayLine;
    }

    public final String d() {
        p p2 = this.e;
        RailwayLine railwayLine = this.a;
        if (railwayLine == null) {
            j.b("line");
        }
        return p2.a(2131558481, railwayLine.getServiceStatus().getDelayMinute());
    }

    public final Drawable e() {
        jp.co.jreast.jreastapp.commuter.m.b b2 = this.d;
        RailwayLine railwayLine = this.a;
        if (railwayLine == null) {
            j.b("line");
        }
        return b2.a(railwayLine);
    }

    public final Drawable f() {
        jp.co.jreast.jreastapp.commuter.m.b b2 = this.d;
        RailwayLine railwayLine = this.a;
        if (railwayLine == null) {
            j.b("line");
        }
        return b2.b(railwayLine);
    }

    public final void g() {
        this.c.f();
    }

    public final void h() {
        a a2 = this.f;
        if (a2 != null) {
            String string2 = this.b;
            if (string2 == null) {
                j.b("viewTypeName");
            }
            a2.a(string2);
        }
    }
}

