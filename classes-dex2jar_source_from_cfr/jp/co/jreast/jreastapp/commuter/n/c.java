/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Date;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.cu;
import jp.co.jreast.jreastapp.commuter.common.s;
import jp.co.jreast.jreastapp.commuter.d.a;
import jp.co.jreast.jreastapp.commuter.d.b;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingDate;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.n.k;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailCaptureHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljp/co/jreast/jreastapp/commuter/util/Capturable;", "context", "Landroid/content/Context;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailCaptureHeaderBinding;", "currentCharacter", "Ljp/co/jreast/jreastapp/commuter/common/ToresugoCharacters;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailCaptureHeaderBinding;Ljp/co/jreast/jreastapp/commuter/common/ToresugoCharacters;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailCaptureHeaderBinding;", "getContext", "()Landroid/content/Context;", "getCurrentCharacter", "()Ljp/co/jreast/jreastapp/commuter/common/ToresugoCharacters;", "prepareCapture", "", "setVisibilityAmountTime", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends RecyclerView.x
implements jp.co.jreast.jreastapp.commuter.r.b {
    private final Context q;
    private final cu r;
    private final s s;

    public c(Context context, cu cu2, s s2) {
        j.b((Object)context, "context");
        j.b(cu2, "binding");
        j.b((Object)s2, "currentCharacter");
        super(cu2.e());
        this.q = context;
        this.r = cu2;
        this.s = s2;
    }

    private final void C() {
        Object object = this.r.k();
        if (object == null) {
            j.a();
        }
        if (j.a((Object)((Route)object).getAccuracy().getHour(), (Object)"0")) {
            object = this.r.i;
            j.a(object, "binding.hoursOfAmountTime");
            object.setVisibility(8);
            object = this.r.j;
            j.a(object, "binding.hoursUnitOfAmountTime");
            object.setVisibility(8);
        } else {
            object = this.r.i;
            j.a(object, "binding.hoursOfAmountTime");
            object.setVisibility(0);
            object = this.r.j;
            j.a(object, "binding.hoursUnitOfAmountTime");
            object.setVisibility(0);
        }
        object = this.r.k();
        if (object == null) {
            j.a();
        }
        if (j.a((Object)((Route)object).getAccuracy().getMin(), (Object)"0")) {
            object = this.r.k;
            j.a(object, "binding.minutesOfAmountTime");
            object.setVisibility(8);
            object = this.r.l;
            j.a(object, "binding.minutesUnitOfAmountTime");
            object.setVisibility(8);
            return;
        }
        object = this.r.k;
        j.a(object, "binding.minutesOfAmountTime");
        object.setVisibility(0);
        object = this.r.l;
        j.a(object, "binding.minutesUnitOfAmountTime");
        object.setVisibility(0);
    }

    public final cu A() {
        return this.r;
    }

    @Override
    public void B() {
        k k2;
        Object object = this.r.k();
        if (object != null && (k2 = this.r.j()) != null) {
            Object object2 = m.f(((Route)object).getLines()).getFrom().getBoardingDate();
            int n2 = ((CharSequence)((BoardingDate)object2).getYear()).length();
            int n3 = 0;
            if ((n2 = n2 > 0 ? 1 : 0) != 0 && (n2 = ((CharSequence)((BoardingDate)object2).getMonth()).length() > 0 ? 1 : 0) != 0) {
                n2 = n3;
                if (((CharSequence)((BoardingDate)object2).getDay()).length() > 0) {
                    n2 = 1;
                }
                if (n2 != 0) {
                    object2 = new a().a((BoardingDate)object2);
                    TextView textView = this.r.n;
                    j.a((Object)textView, "binding.nowDate");
                    String string2 = this.q.getString(2131558455);
                    j.a((Object)string2, "context.getString(R.stri\u2026creen_header_mmddweekday)");
                    textView.setText((CharSequence)b.a((Date)object2, string2));
                }
            }
            this.r.c.setImageResource(this.s.a());
            object2 = this.r.r;
            j.a(object2, "binding.titleDepartureTime");
            object2.setText((CharSequence)m.f(((Route)object).getLines()).getFrom().getAccuracy().fourDigitString());
            object2 = this.r.q;
            j.a(object2, "binding.titleArrivalTime");
            object2.setText((CharSequence)m.h(((Route)object).getLines()).getTo().getAccuracy().fourDigitString());
            object2 = this.r.i;
            j.a(object2, "binding.hoursOfAmountTime");
            object2.setText((CharSequence)((Route)object).getAccuracy().getHour());
            object2 = this.r.k;
            j.a(object2, "binding.minutesOfAmountTime");
            object2.setText((CharSequence)((Route)object).getAccuracy().getMin());
            object2 = this.r.o;
            j.a(object2, "binding.numberOfTransferCount");
            object2.setText((CharSequence)((Route)object).getTransferCount());
            object = this.r.g;
            j.a(object, "binding.fare");
            object.setText((CharSequence)k2.r());
            this.C();
        }
    }
}

