/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package jp.co.jreast.jreastapp.commuter.others;

import android.content.Context;
import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.common.h;
import jp.co.jreast.jreastapp.commuter.common.i;
import jp.co.jreast.jreastapp.commuter.m.r;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.others.b;
import jp.co.jreast.jreastapp.commuter.others.e;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2={"Ljp/co/jreast/jreastapp/commuter/others/OthersViewModel;", "Landroidx/lifecycle/ViewModel;", "userInformationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;)V", "openWebViewEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "getOpenWebViewEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "getUserInformationRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;", "getAdapter", "Ljp/co/jreast/jreastapp/commuter/others/OthersAdapter;", "context", "Landroid/content/Context;", "tapItem", "", "otherItem", "Ljp/co/jreast/jreastapp/commuter/common/LinkInformation;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
extends v {
    private final al<o> a;
    private final r b;

    public d(r r2) {
        j.b(r2, "userInformationRepository");
        this.b = r2;
        this.a = new al();
    }

    public final b a(Context context) {
        j.b((Object)context, "context");
        return new b(context, this);
    }

    public final void a(h object) {
        j.b(object, "otherItem");
        Object object2 = ((h)object).c();
        if (e.a[((Enum)object2).ordinal()] == 1) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("https://rp.cloudrail.jp/");
            ((StringBuilder)object2).append(n.a(((h)object).d(), "%uid%", this.b.a(), false, 4, null));
            object2 = ((StringBuilder)object2).toString();
            object = new o(((h)object).b(), (String)object2, 0, null, 0, null, 0, null, 0, null, 1020, null);
            this.a.b((o)object);
            return;
        }
        throw (Throwable)new Exception("No Implementation!");
    }

    public final al<o> b() {
        return this.a;
    }
}

