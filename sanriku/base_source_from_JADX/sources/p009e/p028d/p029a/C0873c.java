package p009e.p028d.p029a;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.ads.AdSize;

@Deprecated
/* renamed from: e.d.a.c */
public final class C0873c {

    /* renamed from: b */
    public static final C0873c f518b = new C0873c(-1, -2);

    /* renamed from: c */
    public static final C0873c f519c = new C0873c(320, 50);

    /* renamed from: d */
    public static final C0873c f520d = new C0873c(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);

    /* renamed from: e */
    public static final C0873c f521e = new C0873c(468, 60);

    /* renamed from: f */
    public static final C0873c f522f = new C0873c(728, 90);

    /* renamed from: g */
    public static final C0873c f523g = new C0873c(160, 600);

    /* renamed from: a */
    private final AdSize f524a;

    private C0873c(int i, int i2) {
        this.f524a = new AdSize(i, i2);
    }

    public C0873c(AdSize adSize) {
        this.f524a = adSize;
    }

    /* renamed from: a */
    public final int mo20270a() {
        return this.f524a.getHeight();
    }

    /* renamed from: b */
    public final int mo20271b() {
        return this.f524a.getWidth();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0873c)) {
            return false;
        }
        return this.f524a.equals(((C0873c) obj).f524a);
    }

    public final int hashCode() {
        return this.f524a.hashCode();
    }

    public final String toString() {
        return this.f524a.toString();
    }
}
