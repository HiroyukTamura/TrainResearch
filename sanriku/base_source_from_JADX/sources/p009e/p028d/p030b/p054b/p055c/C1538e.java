package p009e.p028d.p030b.p054b.p055c;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* renamed from: e.d.b.b.c.e */
public class C1538e extends Property<ImageView, Matrix> {

    /* renamed from: a */
    private final Matrix f1777a = new Matrix();

    public C1538e() {
        super(Matrix.class, "imageMatrixProperty");
    }

    public Object get(Object obj) {
        this.f1777a.set(((ImageView) obj).getImageMatrix());
        return this.f1777a;
    }

    public void set(Object obj, Object obj2) {
        ((ImageView) obj).setImageMatrix((Matrix) obj2);
    }
}
