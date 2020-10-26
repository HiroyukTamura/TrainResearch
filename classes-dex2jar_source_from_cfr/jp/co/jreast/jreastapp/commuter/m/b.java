/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 */
package jp.co.jreast.jreastapp.commuter.m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import jp.co.jreast.jreastapp.commuter.m.a.a;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatus;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J*\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017H\u0002J'\u0010&\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0000\u00a2\u0006\u0002\b'J\u0018\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006+"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "", "context", "Landroid/content/Context;", "appCompatResourcesUtil", "Ljp/co/jreast/jreastapp/commuter/repository/di/AppCompatResourcesUtil;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/repository/di/AppCompatResourcesUtil;)V", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "getResources", "()Landroid/content/res/Resources;", "getDelayIcon", "Landroid/graphics/drawable/Drawable;", "line", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "getDelayIconByLineServiceStatus", "serviceStatus", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatus;", "getDelayIconByServiceStatus", "Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "getDelayIconDrawable", "delayIcon", "", "getDrawable", "resId", "", "getLineIcon", "getLineIconByRailwayList", "listInfo", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "getLineIconByServiceStatus", "getLineIconDrawable", "iconName", "railKind", "isWalking", "", "colorCode", "getResourceId", "getResourceId$app_productRelease", "setColor", "", "lineIconDrawable", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b {
    private final Resources a;
    private final Context b;
    private final a c;

    public b(Context context, a a2) {
        j.b((Object)context, "context");
        j.b(a2, "appCompatResourcesUtil");
        this.b = context;
        this.c = a2;
        this.a = this.b.getResources();
    }

    private final Drawable a(String string2) {
        int n2;
        Resources resources = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ic_status_");
        stringBuilder.append(string2);
        int n3 = n2 = resources.getIdentifier(stringBuilder.toString(), "drawable", this.b.getPackageName());
        if (n2 == 0) {
            n3 = 2131165417;
        }
        if ((string2 = this.c.a(this.b, n3)) == null) {
            j.a();
        }
        return string2;
    }

    private final Drawable a(String string2, String string3, boolean bl2, String string4) {
        int n2 = this.a(string2, string3, bl2);
        string2 = this.c.a(this.b, n2);
        if (string2 == null) {
            j.a();
        }
        string2 = string2.mutate();
        if (n2 == 2131165405) {
            if (string2 == null) {
                j.a();
            }
            this.a(string4, (Drawable)string2);
            string3 = this.c.a(this.b, 2131165682);
            if (string3 == null) {
                j.a();
            }
            return (Drawable)new LayerDrawable(new Drawable[]{string3.mutate(), string2});
        }
        if (n2 == 2131165404) {
            string3 = this.c.a(this.b, 2131165683);
            if (string3 == null) {
                j.a();
            }
            string3 = string3.mutate();
            Drawable drawable2 = this.c.a(this.b, 2131165682);
            if (drawable2 == null) {
                j.a();
            }
            drawable2 = drawable2.mutate();
            if (string3 == null) {
                j.a();
            }
            this.a(string4, (Drawable)string3);
            return (Drawable)new LayerDrawable(new Drawable[]{drawable2, string2, string3});
        }
        if (string2 == null) {
            j.a();
        }
        return string2;
    }

    private final void a(String string2, Drawable drawable2) {
        boolean bl2 = ((CharSequence)string2).length() == 0;
        if (!bl2) {
            drawable2.setColorFilter(Color.parseColor((String)string2), PorterDuff.Mode.SRC_IN);
        }
    }

    public final int a(String string2, String string3, boolean bl2) {
        int n2;
        j.b(string3, "railKind");
        String string4 = this.b.getPackageName();
        if (bl2) {
            n2 = 2131165407;
        } else if (j.a((Object)string2, (Object)"lineIconDefault")) {
            n2 = 2131165405;
        } else if (string2 != null && j.a((Object)string2, (Object)"") ^ true) {
            Resources resources = this.a;
            string2 = string2.toLowerCase();
            j.a((Object)string2, "(this as java.lang.String).toLowerCase()");
            n2 = resources.getIdentifier(string2, "drawable", string4);
        } else {
            n2 = 0;
        }
        int n3 = n2;
        if (n2 == 0) {
            if (j.a((Object)string3, (Object)"JR")) {
                return 2131165404;
            }
            n3 = 2131165405;
        }
        return n3;
    }

    public final Drawable a(int n2) {
        Drawable drawable2 = this.c.a(this.b, n2);
        if (drawable2 == null) {
            j.a();
        }
        return drawable2;
    }

    public final Drawable a(LineServiceStatus lineServiceStatus) {
        j.b(lineServiceStatus, "serviceStatus");
        String string2 = lineServiceStatus.getIconName();
        String string3 = j.a((Object)lineServiceStatus.getCompanyId(), (Object)"1") ? "JR" : "";
        return this.a(string2, string3, false, lineServiceStatus.getLineColor());
    }

    public final Drawable a(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.a(railwayLine.getIconName(), railwayLine.getRailKind(), railwayLine.isWalking(), railwayLine.getColor());
    }

    public final Drawable a(RailwayLineInformation railwayLineInformation) {
        j.b(railwayLineInformation, "listInfo");
        return this.a(railwayLineInformation.getIconName(), railwayLineInformation.getRailKind(), false, railwayLineInformation.getColor());
    }

    public final Drawable a(ServiceStatus serviceStatus) {
        j.b(serviceStatus, "serviceStatus");
        return this.a(serviceStatus.getDelayIcon());
    }

    public final Drawable b(LineServiceStatus lineServiceStatus) {
        j.b(lineServiceStatus, "serviceStatus");
        return this.a(lineServiceStatus.getDelayIcon());
    }

    public final Drawable b(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.a(railwayLine.getServiceStatus().getDelayIcon());
    }
}

