/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.api;

import b.a.e;
import f.c.f;
import f.c.u;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'\u00a8\u0006\u0007"}, d2={"Ljp/co/jreast/jreastapp/commuter/api/MixpanelDeleteApi;", "", "deleteRequest", "Lio/reactivex/Observable;", "", "paramMap", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public interface MixpanelDeleteApi {
    @f(a="mixpanel/data-deletions")
    public e<String> deleteRequest(@u(a=true) Map<String, String> var1);
}

