/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import b.a.e;
import c.ad;
import com.b.a.b.a.b;
import com.b.a.f;
import com.b.a.s;
import f.a.a.h;
import f.c;
import f.e;
import f.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import jp.co.jreast.jreastapp.commuter.api.ServiceStatusApi;
import jp.co.jreast.jreastapp.commuter.j.c;
import jp.co.jreast.jreastapp.commuter.j.d;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatus;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\nJ.\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u00120\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u0010\u0010\u001a\u00020\nJ4\u0010\u0016\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170\u00120\u00120\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\nJ \u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u00120\u000e2\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/NetworkServiceStatusRepository;", "", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "schedulerProvider", "Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;", "requestParameterUtil", "Ljp/co/jreast/jreastapp/commuter/http/RequestParameterUtil;", "(Lretrofit2/Retrofit$Builder;Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;Ljp/co/jreast/jreastapp/commuter/http/RequestParameterUtil;)V", "concatenateJrIdAndTrainDirection", "", "line", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "getDelayedKantoMapImage", "Lio/reactivex/Observable;", "Lokhttp3/ResponseBody;", "baseUrl", "getServiceStatus", "", "Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "lines", "", "getServiceStatusArea", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatus;", "areaCode", "", "getServiceStatusAreaSummary", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class l {
    private final n.a a;
    private final jp.co.jreast.jreastapp.commuter.l.d b;
    private final jp.co.jreast.jreastapp.commuter.j.b c;

    public l(n.a a2, jp.co.jreast.jreastapp.commuter.l.d d2, jp.co.jreast.jreastapp.commuter.j.b b2) {
        j.b(a2, "retrofitBuilder");
        j.b(d2, "schedulerProvider");
        j.b(b2, "requestParameterUtil");
        this.a = a2;
        this.b = d2;
        this.c = b2;
    }

    private final String a(RailwayLine railwayLine) {
        CharSequence charSequence = railwayLine.getTrainDirection();
        boolean bl2 = charSequence == null || charSequence.length() == 0;
        if (bl2) {
            return String.valueOf(railwayLine.getJrId());
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(railwayLine.getJrId());
        ((StringBuilder)charSequence).append("-");
        ((StringBuilder)charSequence).append(railwayLine.getTrainDirection());
        return ((StringBuilder)charSequence).toString();
    }

    public final e<Map<String, Map<String, LineServiceStatus>>> a(int n2, String object) {
        j.b(object, "baseUrl");
        s s2 = new s.a().a(new b()).a();
        object = this.a.a((String)object).a(Executors.newSingleThreadExecutor()).a(h.a()).a(f.b.a.a.a(s2)).a().a(ServiceStatusApi.class).getServiceStatusArea(this.c.b(String.valueOf(n2)).a()).b(this.b.b()).a(this.b.a());
        j.a(object, "service.getServiceStatus\u2026n(schedulerProvider.ui())");
        return object;
    }

    public final e<Map<String, ServiceStatus>> a(String object) {
        j.b(object, "baseUrl");
        s s2 = new s.a().a(new b()).a();
        object = this.a.a((String)object).a(Executors.newSingleThreadExecutor()).a(h.a()).a(f.b.a.a.a(s2)).a().a(ServiceStatusApi.class).getServiceStatusAreaSummary().b(this.b.b()).a(this.b.a());
        j.a(object, "service.getServiceStatus\u2026n(schedulerProvider.ui())");
        return object;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final e<Map<String, ServiceStatus>> a(List<RailwayLine> var1_1, String var2_2) {
        j.b(var1_1, "lines");
        j.b(var2_2, "baseUrl");
        var5_3 = new s.a().a(new b()).a();
        var2_2 = this.a.a((String)var2_2).a(Executors.newSingleThreadExecutor()).a(h.a()).a(f.b.a.a.a((s)var5_3)).a().a(ServiceStatusApi.class);
        var5_3 = new ArrayList<E>();
        var6_4 = (Iterable)var1_1;
        var1_1 = new ArrayList<E>();
        var6_4 = var6_4.iterator();
        while (var6_4.hasNext()) {
            var7_7 = var6_4.next();
            var8_8 = (RailwayLine)var7_7;
            var9_9 = var8_8.getJrId();
            var4_6 = true;
            if (var9_9 == null) ** GOTO lbl-1000
            var9_9 = var8_8.getJrId();
            if (var9_9 == null) {
                j.a();
            }
            if ((var3_5 = ((CharSequence)var9_9).length() > 0) && !var8_8.isNormalPaidExpress()) {
                var3_5 = var4_6;
            } else lbl-1000: // 2 sources:
            {
                var3_5 = false;
            }
            if (!var3_5) continue;
            var1_1.add(var7_7);
        }
        var6_4 = (List)var1_1;
        var1_1 = new ArrayList<E>(m.a(var6_4, 10));
        var6_4 = var6_4.iterator();
        while (var6_4.hasNext()) {
            var1_1.add(this.a((RailwayLine)var6_4.next()));
        }
        var1_1 = ((Iterable)m.o((List)var1_1)).iterator();
        do {
            if (!var1_1.hasNext()) {
                var1_1 = e.a((Iterable)var5_3, a.a);
                j.a(var1_1, "Observable\n             \u2026atusMap\n                }");
                return var1_1;
            }
            var6_4 = (String)var1_1.next();
            var5_3.add(var2_2.getServiceStatus(this.c.a((String)var6_4).a()).b(this.b.b()).a(this.b.a()));
        } while (true);
    }

    public final e<ad> b(String object) {
        j.b(object, "baseUrl");
        object = this.a.a((String)object).a(Executors.newSingleThreadExecutor()).a(h.a()).a().a(ServiceStatusApi.class).getDelayedKantoMapImage().b(this.b.b()).a(this.b.a());
        j.a(object, "service.getDelayedKantoM\u2026n(schedulerProvider.ui())");
        return object;
    }

}

