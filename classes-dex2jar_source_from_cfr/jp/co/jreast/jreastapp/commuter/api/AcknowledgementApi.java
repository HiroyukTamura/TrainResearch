/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.api;

import b.a.e;
import f.c.f;
import jp.co.jreast.jreastapp.commuter.model.Acknowledgement;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'\u00a8\u0006\u0005"}, d2={"Ljp/co/jreast/jreastapp/commuter/api/AcknowledgementApi;", "", "getAcknowledgement", "Lio/reactivex/Observable;", "Ljp/co/jreast/jreastapp/commuter/model/Acknowledgement;", "app_productRelease"}, k=1, mv={1, 1, 11})
public interface AcknowledgementApi {
    @f(a="about/timetableInformation")
    public e<Acknowledgement> getAcknowledgement();
}

