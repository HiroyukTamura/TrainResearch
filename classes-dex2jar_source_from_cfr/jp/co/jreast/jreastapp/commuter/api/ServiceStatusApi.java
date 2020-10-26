/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.api;

import b.a.e;
import c.ad;
import f.c.f;
import f.c.u;
import f.c.w;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatus;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J0\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00032\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H'J<\u0010\n\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u00060\u00060\u00032\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H'J\u001a\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003H'\u00a8\u0006\r"}, d2={"Ljp/co/jreast/jreastapp/commuter/api/ServiceStatusApi;", "", "getDelayedKantoMapImage", "Lio/reactivex/Observable;", "Lokhttp3/ResponseBody;", "getServiceStatus", "", "", "Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "paramMap", "getServiceStatusArea", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatus;", "getServiceStatusAreaSummary", "app_productRelease"}, k=1, mv={1, 1, 11})
public interface ServiceStatusApi {
    @f(a="com/img/kanto.png")
    @w
    public e<ad> getDelayedKantoMapImage();

    @f(a="serviceStatus")
    public e<Map<String, ServiceStatus>> getServiceStatus(@u(a=true) Map<String, String> var1);

    @f(a="serviceStatusArea")
    public e<Map<String, Map<String, LineServiceStatus>>> getServiceStatusArea(@u(a=true) Map<String, String> var1);

    @f(a="serviceStatusAreaSummary")
    public e<Map<String, ServiceStatus>> getServiceStatusAreaSummary();
}

