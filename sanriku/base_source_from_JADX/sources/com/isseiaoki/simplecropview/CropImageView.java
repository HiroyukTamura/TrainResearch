package com.isseiaoki.simplecropview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.isseiaoki.simplecropview.p051g.C1457a;
import com.isseiaoki.simplecropview.p051g.C1458b;
import com.isseiaoki.simplecropview.p051g.C1459c;
import com.isseiaoki.simplecropview.p052h.C1461a;
import com.isseiaoki.simplecropview.p052h.C1462b;
import com.isseiaoki.simplecropview.p052h.C1463c;
import com.isseiaoki.simplecropview.p052h.C1464d;
import com.isseiaoki.simplecropview.p053i.C1465a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import p009e.p010a.p011a.p012a.C0681a;

public class CropImageView extends ImageView {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public Uri f1365A;

    /* renamed from: B */
    private Uri f1366B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f1367C;

    /* renamed from: D */
    private int f1368D;

    /* renamed from: E */
    private int f1369E;

    /* renamed from: F */
    private int f1370F;

    /* renamed from: G */
    private int f1371G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f1372H;

    /* renamed from: I */
    private Bitmap.CompressFormat f1373I;

    /* renamed from: J */
    private int f1374J;

    /* renamed from: K */
    private int f1375K;

    /* renamed from: L */
    private int f1376L;

    /* renamed from: M */
    private int f1377M;

    /* renamed from: N */
    private int f1378N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public AtomicBoolean f1379O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public AtomicBoolean f1380P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public AtomicBoolean f1381Q;

    /* renamed from: R */
    private ExecutorService f1382R;

    /* renamed from: S */
    private C1450g f1383S;

    /* renamed from: T */
    private C1448e f1384T;

    /* renamed from: U */
    private C1449f f1385U;

    /* renamed from: V */
    private C1449f f1386V;

    /* renamed from: W */
    private float f1387W;

    /* renamed from: a */
    private int f1388a;

    /* renamed from: a0 */
    private int f1389a0;

    /* renamed from: b */
    private int f1390b;

    /* renamed from: b0 */
    private int f1391b0;

    /* renamed from: c */
    private float f1392c;

    /* renamed from: c0 */
    private boolean f1393c0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f1394d;

    /* renamed from: d0 */
    private boolean f1395d0;

    /* renamed from: e */
    private float f1396e;

    /* renamed from: e0 */
    private boolean f1397e0;

    /* renamed from: f */
    private float f1398f;

    /* renamed from: f0 */
    private boolean f1399f0;

    /* renamed from: g */
    private boolean f1400g;

    /* renamed from: g0 */
    private PointF f1401g0;

    /* renamed from: h */
    private Matrix f1402h;

    /* renamed from: h0 */
    private float f1403h0;

    /* renamed from: i */
    private Paint f1404i;

    /* renamed from: i0 */
    private float f1405i0;

    /* renamed from: j0 */
    private int f1406j0;

    /* renamed from: k0 */
    private int f1407k0;

    /* renamed from: l */
    private Paint f1408l;

    /* renamed from: l0 */
    private int f1409l0;

    /* renamed from: m */
    private Paint f1410m;

    /* renamed from: m0 */
    private int f1411m0;

    /* renamed from: n */
    private Paint f1412n;

    /* renamed from: n0 */
    private int f1413n0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public RectF f1414o;

    /* renamed from: o0 */
    private float f1415o0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RectF f1416p;

    /* renamed from: p0 */
    private boolean f1417p0;

    /* renamed from: q */
    private RectF f1418q;

    /* renamed from: q0 */
    private int f1419q0;

    /* renamed from: r */
    private PointF f1420r;

    /* renamed from: r0 */
    private boolean f1421r0;

    /* renamed from: s */
    private float f1422s;

    /* renamed from: t */
    private float f1423t;

    /* renamed from: u */
    private boolean f1424u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f1425v;

    /* renamed from: w */
    private C1457a f1426w;

    /* renamed from: x */
    private final Interpolator f1427x;

    /* renamed from: y */
    private Interpolator f1428y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public Handler f1429z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C1440a();

        /* renamed from: A */
        Uri f1430A;

        /* renamed from: B */
        Bitmap.CompressFormat f1431B;

        /* renamed from: C */
        int f1432C;

        /* renamed from: D */
        boolean f1433D;

        /* renamed from: E */
        int f1434E;

        /* renamed from: F */
        int f1435F;

        /* renamed from: G */
        int f1436G;

        /* renamed from: H */
        int f1437H;

        /* renamed from: I */
        boolean f1438I;

        /* renamed from: J */
        int f1439J;

        /* renamed from: K */
        int f1440K;

        /* renamed from: L */
        int f1441L;

        /* renamed from: M */
        int f1442M;

        /* renamed from: a */
        C1448e f1443a;

        /* renamed from: b */
        int f1444b;

        /* renamed from: c */
        int f1445c;

        /* renamed from: d */
        int f1446d;

        /* renamed from: e */
        C1449f f1447e;

        /* renamed from: f */
        C1449f f1448f;

        /* renamed from: g */
        boolean f1449g;

        /* renamed from: h */
        boolean f1450h;

        /* renamed from: i */
        int f1451i;

        /* renamed from: l */
        int f1452l;

        /* renamed from: m */
        float f1453m;

        /* renamed from: n */
        float f1454n;

        /* renamed from: o */
        float f1455o;

        /* renamed from: p */
        float f1456p;

        /* renamed from: q */
        float f1457q;

        /* renamed from: r */
        boolean f1458r;

        /* renamed from: s */
        int f1459s;

        /* renamed from: t */
        int f1460t;

        /* renamed from: u */
        float f1461u;

        /* renamed from: v */
        float f1462v;

        /* renamed from: w */
        boolean f1463w;

        /* renamed from: x */
        int f1464x;

        /* renamed from: y */
        int f1465y;

        /* renamed from: z */
        Uri f1466z;

        /* renamed from: com.isseiaoki.simplecropview.CropImageView$SavedState$a */
        static class C1440a implements Parcelable.Creator {
            C1440a() {
            }

            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (C1445c) null);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, C1445c cVar) {
            super(parcel);
            this.f1443a = (C1448e) parcel.readSerializable();
            this.f1444b = parcel.readInt();
            this.f1445c = parcel.readInt();
            this.f1446d = parcel.readInt();
            this.f1447e = (C1449f) parcel.readSerializable();
            this.f1448f = (C1449f) parcel.readSerializable();
            boolean z = false;
            this.f1449g = parcel.readInt() != 0;
            this.f1450h = parcel.readInt() != 0;
            this.f1451i = parcel.readInt();
            this.f1452l = parcel.readInt();
            this.f1453m = parcel.readFloat();
            this.f1454n = parcel.readFloat();
            this.f1455o = parcel.readFloat();
            this.f1456p = parcel.readFloat();
            this.f1457q = parcel.readFloat();
            this.f1458r = parcel.readInt() != 0;
            this.f1459s = parcel.readInt();
            this.f1460t = parcel.readInt();
            this.f1461u = parcel.readFloat();
            this.f1462v = parcel.readFloat();
            this.f1463w = parcel.readInt() != 0;
            this.f1464x = parcel.readInt();
            this.f1465y = parcel.readInt();
            this.f1466z = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.f1430A = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.f1431B = (Bitmap.CompressFormat) parcel.readSerializable();
            this.f1432C = parcel.readInt();
            this.f1433D = parcel.readInt() != 0;
            this.f1434E = parcel.readInt();
            this.f1435F = parcel.readInt();
            this.f1436G = parcel.readInt();
            this.f1437H = parcel.readInt();
            this.f1438I = parcel.readInt() != 0 ? true : z;
            this.f1439J = parcel.readInt();
            this.f1440K = parcel.readInt();
            this.f1441L = parcel.readInt();
            this.f1442M = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.f1443a);
            parcel.writeInt(this.f1444b);
            parcel.writeInt(this.f1445c);
            parcel.writeInt(this.f1446d);
            parcel.writeSerializable(this.f1447e);
            parcel.writeSerializable(this.f1448f);
            parcel.writeInt(this.f1449g ? 1 : 0);
            parcel.writeInt(this.f1450h ? 1 : 0);
            parcel.writeInt(this.f1451i);
            parcel.writeInt(this.f1452l);
            parcel.writeFloat(this.f1453m);
            parcel.writeFloat(this.f1454n);
            parcel.writeFloat(this.f1455o);
            parcel.writeFloat(this.f1456p);
            parcel.writeFloat(this.f1457q);
            parcel.writeInt(this.f1458r ? 1 : 0);
            parcel.writeInt(this.f1459s);
            parcel.writeInt(this.f1460t);
            parcel.writeFloat(this.f1461u);
            parcel.writeFloat(this.f1462v);
            parcel.writeInt(this.f1463w ? 1 : 0);
            parcel.writeInt(this.f1464x);
            parcel.writeInt(this.f1465y);
            parcel.writeParcelable(this.f1466z, i);
            parcel.writeParcelable(this.f1430A, i);
            parcel.writeSerializable(this.f1431B);
            parcel.writeInt(this.f1432C);
            parcel.writeInt(this.f1433D ? 1 : 0);
            parcel.writeInt(this.f1434E);
            parcel.writeInt(this.f1435F);
            parcel.writeInt(this.f1436G);
            parcel.writeInt(this.f1437H);
            parcel.writeInt(this.f1438I ? 1 : 0);
            parcel.writeInt(this.f1439J);
            parcel.writeInt(this.f1440K);
            parcel.writeInt(this.f1441L);
            parcel.writeInt(this.f1442M);
        }
    }

    /* renamed from: com.isseiaoki.simplecropview.CropImageView$a */
    class C1441a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Uri f1467a;

        /* renamed from: b */
        final /* synthetic */ C1462b f1468b;

        /* renamed from: com.isseiaoki.simplecropview.CropImageView$a$a */
        class C1442a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f1470a;

            C1442a(Bitmap bitmap) {
                this.f1470a = bitmap;
            }

            public void run() {
                C1462b bVar = C1441a.this.f1468b;
                if (bVar != null) {
                    bVar.onSuccess(this.f1470a);
                }
                if (CropImageView.this.f1372H) {
                    CropImageView.this.invalidate();
                }
            }
        }

        C1441a(Uri uri, C1462b bVar) {
            this.f1467a = uri;
            this.f1468b = bVar;
        }

        public void run() {
            try {
                CropImageView.this.f1380P.set(true);
                if (this.f1467a != null) {
                    Uri unused = CropImageView.this.f1365A = this.f1467a;
                }
                CropImageView.this.f1429z.post(new C1442a(CropImageView.m1926c(CropImageView.this)));
            } catch (Exception e) {
                CropImageView.m1917a(CropImageView.this, (C1461a) this.f1468b, (Throwable) e);
            } catch (Throwable th) {
                CropImageView.this.f1380P.set(false);
                throw th;
            }
            CropImageView.this.f1380P.set(false);
        }
    }

    /* renamed from: com.isseiaoki.simplecropview.CropImageView$b */
    class C1443b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bitmap f1472a;

        /* renamed from: b */
        final /* synthetic */ Uri f1473b;

        /* renamed from: c */
        final /* synthetic */ C1464d f1474c;

        /* renamed from: com.isseiaoki.simplecropview.CropImageView$b$a */
        class C1444a implements Runnable {
            C1444a() {
            }

            public void run() {
                C1443b bVar = C1443b.this;
                C1464d dVar = bVar.f1474c;
                if (dVar != null) {
                    dVar.onSuccess(bVar.f1473b);
                }
            }
        }

        C1443b(Bitmap bitmap, Uri uri, C1464d dVar) {
            this.f1472a = bitmap;
            this.f1473b = uri;
            this.f1474c = dVar;
        }

        public void run() {
            try {
                CropImageView.this.f1381Q.set(true);
                CropImageView.m1913a(CropImageView.this, this.f1472a, this.f1473b);
                CropImageView.this.f1429z.post(new C1444a());
            } catch (Exception e) {
                CropImageView.m1917a(CropImageView.this, (C1461a) this.f1474c, (Throwable) e);
            } catch (Throwable th) {
                CropImageView.this.f1381Q.set(false);
                throw th;
            }
            CropImageView.this.f1381Q.set(false);
        }
    }

    /* renamed from: com.isseiaoki.simplecropview.CropImageView$c */
    class C1445c implements C1458b {

        /* renamed from: a */
        final /* synthetic */ RectF f1477a;

        /* renamed from: b */
        final /* synthetic */ float f1478b;

        /* renamed from: c */
        final /* synthetic */ float f1479c;

        /* renamed from: d */
        final /* synthetic */ float f1480d;

        /* renamed from: e */
        final /* synthetic */ float f1481e;

        /* renamed from: f */
        final /* synthetic */ RectF f1482f;

        C1445c(RectF rectF, float f, float f2, float f3, float f4, RectF rectF2) {
            this.f1477a = rectF;
            this.f1478b = f;
            this.f1479c = f2;
            this.f1480d = f3;
            this.f1481e = f4;
            this.f1482f = rectF2;
        }

        /* renamed from: a */
        public void mo27146a() {
            RectF unused = CropImageView.this.f1414o = this.f1482f;
            CropImageView.this.invalidate();
            boolean unused2 = CropImageView.this.f1425v = false;
        }

        /* renamed from: a */
        public void mo27147a(float f) {
            CropImageView cropImageView = CropImageView.this;
            RectF rectF = this.f1477a;
            RectF unused = cropImageView.f1414o = new RectF((this.f1478b * f) + rectF.left, (this.f1479c * f) + rectF.top, (this.f1480d * f) + rectF.right, (this.f1481e * f) + rectF.bottom);
            CropImageView.this.invalidate();
        }

        /* renamed from: b */
        public void mo27148b() {
            boolean unused = CropImageView.this.f1425v = true;
        }
    }

    /* renamed from: com.isseiaoki.simplecropview.CropImageView$d */
    class C1446d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Uri f1484a;

        /* renamed from: b */
        final /* synthetic */ RectF f1485b;

        /* renamed from: c */
        final /* synthetic */ boolean f1486c;

        /* renamed from: d */
        final /* synthetic */ C1463c f1487d;

        /* renamed from: com.isseiaoki.simplecropview.CropImageView$d$a */
        class C1447a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f1489a;

            C1447a(Bitmap bitmap) {
                this.f1489a = bitmap;
            }

            public void run() {
                CropImageView cropImageView = CropImageView.this;
                float unused = cropImageView.f1394d = (float) cropImageView.f1367C;
                CropImageView.m1916a(CropImageView.this, (Drawable) new BitmapDrawable(CropImageView.this.getResources(), this.f1489a));
                C1463c cVar = C1446d.this.f1487d;
                if (cVar != null) {
                    cVar.onSuccess();
                }
            }
        }

        C1446d(Uri uri, RectF rectF, boolean z, C1463c cVar) {
            this.f1484a = uri;
            this.f1485b = rectF;
            this.f1486c = z;
            this.f1487d = cVar;
        }

        public void run() {
            try {
                CropImageView.this.f1379O.set(true);
                Uri unused = CropImageView.this.f1365A = this.f1484a;
                RectF unused2 = CropImageView.this.f1416p = this.f1485b;
                if (this.f1486c) {
                    CropImageView.m1924b(CropImageView.this, this.f1484a);
                }
                CropImageView.this.f1429z.post(new C1447a(CropImageView.m1927c(CropImageView.this, this.f1484a)));
            } catch (Exception e) {
                CropImageView.m1917a(CropImageView.this, (C1461a) this.f1487d, (Throwable) e);
            } catch (Throwable th) {
                CropImageView.this.f1379O.set(false);
                throw th;
            }
            CropImageView.this.f1379O.set(false);
        }
    }

    /* renamed from: com.isseiaoki.simplecropview.CropImageView$e */
    public enum C1448e {
        FIT_IMAGE(0),
        RATIO_4_3(1),
        RATIO_3_4(2),
        SQUARE(3),
        RATIO_16_9(4),
        RATIO_9_16(5),
        FREE(6),
        CUSTOM(7),
        CIRCLE(8),
        CIRCLE_SQUARE(9);
        

        /* renamed from: a */
        private final int f1502a;

        private C1448e(int i) {
            this.f1502a = i;
        }

        /* renamed from: b */
        public static C1448e[] m1963b() {
            return (C1448e[]) f1501n.clone();
        }

        /* renamed from: a */
        public int mo27151a() {
            return this.f1502a;
        }
    }

    /* renamed from: com.isseiaoki.simplecropview.CropImageView$f */
    public enum C1449f {
        SHOW_ALWAYS(1),
        SHOW_ON_TOUCH(2),
        NOT_SHOW(3);
        

        /* renamed from: a */
        private final int f1507a;

        private C1449f(int i) {
            this.f1507a = i;
        }

        /* renamed from: b */
        public static C1449f[] m1965b() {
            return (C1449f[]) f1506e.clone();
        }

        /* renamed from: a */
        public int mo27152a() {
            return this.f1507a;
        }
    }

    /* renamed from: com.isseiaoki.simplecropview.CropImageView$g */
    private enum C1450g {
        OUT_OF_BOUNDS,
        CENTER,
        LEFT_TOP,
        RIGHT_TOP,
        LEFT_BOTTOM,
        RIGHT_BOTTOM
    }

    static {
        Class<CropImageView> cls = CropImageView.class;
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1388a = 0;
        this.f1390b = 0;
        this.f1392c = 1.0f;
        this.f1394d = 0.0f;
        this.f1396e = 0.0f;
        this.f1398f = 0.0f;
        this.f1400g = false;
        this.f1402h = null;
        this.f1420r = new PointF();
        this.f1424u = false;
        this.f1425v = false;
        this.f1426w = null;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        this.f1427x = decelerateInterpolator;
        this.f1428y = decelerateInterpolator;
        this.f1429z = new Handler(Looper.getMainLooper());
        this.f1365A = null;
        this.f1366B = null;
        this.f1367C = 0;
        this.f1370F = 0;
        this.f1371G = 0;
        this.f1372H = false;
        this.f1373I = Bitmap.CompressFormat.PNG;
        this.f1374J = 100;
        this.f1375K = 0;
        this.f1376L = 0;
        this.f1377M = 0;
        this.f1378N = 0;
        this.f1379O = new AtomicBoolean(false);
        this.f1380P = new AtomicBoolean(false);
        this.f1381Q = new AtomicBoolean(false);
        this.f1383S = C1450g.OUT_OF_BOUNDS;
        this.f1384T = C1448e.SQUARE;
        C1449f fVar = C1449f.SHOW_ALWAYS;
        this.f1385U = fVar;
        this.f1386V = fVar;
        this.f1391b0 = 0;
        this.f1393c0 = true;
        this.f1395d0 = true;
        this.f1397e0 = true;
        this.f1399f0 = true;
        this.f1401g0 = new PointF(1.0f, 1.0f);
        this.f1403h0 = 2.0f;
        this.f1405i0 = 2.0f;
        this.f1417p0 = true;
        this.f1419q0 = 100;
        this.f1421r0 = true;
        this.f1382R = Executors.newSingleThreadExecutor();
        float e = m1934e();
        int i2 = (int) (14.0f * e);
        this.f1389a0 = i2;
        float f = 50.0f * e;
        this.f1387W = f;
        float f2 = e * 1.0f;
        this.f1403h0 = f2;
        this.f1405i0 = f2;
        this.f1408l = new Paint();
        this.f1404i = new Paint();
        Paint paint = new Paint();
        this.f1410m = paint;
        paint.setFilterBitmap(true);
        Paint paint2 = new Paint();
        this.f1412n = paint2;
        paint2.setAntiAlias(true);
        this.f1412n.setStyle(Paint.Style.STROKE);
        this.f1412n.setColor(-1);
        this.f1412n.setTextSize(e * 15.0f);
        this.f1402h = new Matrix();
        this.f1392c = 1.0f;
        this.f1406j0 = 0;
        this.f1409l0 = -1;
        this.f1407k0 = -1157627904;
        this.f1411m0 = -1;
        this.f1413n0 = -1140850689;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1455e.f1527a, i, 0);
        this.f1384T = C1448e.SQUARE;
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(14);
            if (drawable != null) {
                this.f1400g = false;
                m1945l();
                super.setImageDrawable(drawable);
                m1947n();
            }
            C1448e[] b = C1448e.m1963b();
            int length = b.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                C1448e eVar = b[i3];
                if (obtainStyledAttributes.getInt(4, 3) == eVar.mo27151a()) {
                    this.f1384T = eVar;
                    break;
                }
                i3++;
            }
            this.f1406j0 = obtainStyledAttributes.getColor(2, 0);
            this.f1407k0 = obtainStyledAttributes.getColor(17, -1157627904);
            this.f1409l0 = obtainStyledAttributes.getColor(5, -1);
            this.f1411m0 = obtainStyledAttributes.getColor(10, -1);
            this.f1413n0 = obtainStyledAttributes.getColor(7, -1140850689);
            C1449f[] b2 = C1449f.m1965b();
            int length2 = b2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                C1449f fVar2 = b2[i4];
                if (obtainStyledAttributes.getInt(8, 1) == fVar2.mo27152a()) {
                    this.f1385U = fVar2;
                    break;
                }
                i4++;
            }
            C1449f[] b3 = C1449f.m1965b();
            int length3 = b3.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length3) {
                    break;
                }
                C1449f fVar3 = b3[i5];
                if (obtainStyledAttributes.getInt(12, 1) == fVar3.mo27152a()) {
                    this.f1386V = fVar3;
                    break;
                }
                i5++;
            }
            C1449f fVar4 = this.f1385U;
            this.f1385U = fVar4;
            int ordinal = fVar4.ordinal();
            if (ordinal == 0) {
                this.f1393c0 = true;
            } else if (ordinal == 1 || ordinal == 2) {
                this.f1393c0 = false;
            }
            invalidate();
            C1449f fVar5 = this.f1386V;
            this.f1386V = fVar5;
            int ordinal2 = fVar5.ordinal();
            if (ordinal2 == 0) {
                this.f1395d0 = true;
            } else if (ordinal2 == 1 || ordinal2 == 2) {
                this.f1395d0 = false;
            }
            invalidate();
            this.f1389a0 = obtainStyledAttributes.getDimensionPixelSize(13, i2);
            this.f1391b0 = obtainStyledAttributes.getDimensionPixelSize(18, 0);
            this.f1387W = (float) obtainStyledAttributes.getDimensionPixelSize(16, (int) f);
            int i6 = (int) f2;
            this.f1403h0 = (float) obtainStyledAttributes.getDimensionPixelSize(6, i6);
            this.f1405i0 = (float) obtainStyledAttributes.getDimensionPixelSize(9, i6);
            this.f1397e0 = obtainStyledAttributes.getBoolean(3, true);
            float f3 = obtainStyledAttributes.getFloat(15, 1.0f);
            this.f1415o0 = (f3 < 0.01f || f3 > 1.0f) ? 1.0f : f3;
            this.f1417p0 = obtainStyledAttributes.getBoolean(1, true);
            this.f1419q0 = obtainStyledAttributes.getInt(0, 100);
            this.f1421r0 = obtainStyledAttributes.getBoolean(11, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private float m1909a(float f, float f2, float f3) {
        return f % 180.0f == 0.0f ? f2 : f3;
    }

    /* renamed from: a */
    private RectF m1911a(RectF rectF) {
        float b = m1919b(rectF.width());
        float c = m1925c(rectF.height());
        float width = rectF.width() / rectF.height();
        float f = b / c;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float f4 = rectF.right;
        float f5 = rectF.bottom;
        if (f >= width) {
            float f6 = (f3 + f5) * 0.5f;
            float width2 = (rectF.width() / f) * 0.5f;
            f5 = f6 + width2;
            f3 = f6 - width2;
        } else if (f < width) {
            float f7 = (f2 + f4) * 0.5f;
            float height = rectF.height() * f * 0.5f;
            f4 = f7 + height;
            f2 = f7 - height;
        }
        float f8 = f4 - f2;
        float f9 = f5 - f3;
        float f10 = (f8 / 2.0f) + f2;
        float f11 = (f9 / 2.0f) + f3;
        float f12 = this.f1415o0;
        float f13 = (f8 * f12) / 2.0f;
        float f14 = (f9 * f12) / 2.0f;
        return new RectF(f10 - f13, f11 - f14, f10 + f13, f11 + f14);
    }

    /* renamed from: a */
    static /* synthetic */ void m1917a(CropImageView cropImageView, C1461a aVar, Throwable th) {
        if (cropImageView == null) {
            throw null;
        } else if (aVar != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                aVar.onError(th);
            } else {
                cropImageView.f1429z.post(new C1451a(cropImageView, aVar, th));
            }
        }
    }

    /* renamed from: b */
    private float m1919b(float f) {
        switch (this.f1384T.ordinal()) {
            case 0:
                return this.f1418q.width();
            case 1:
                return 4.0f;
            case 2:
                return 3.0f;
            case 3:
            case 8:
            case 9:
                return 1.0f;
            case 4:
                return 16.0f;
            case 5:
                return 9.0f;
            case 7:
                return this.f1401g0.x;
            default:
                return f;
        }
    }

    /* renamed from: b */
    private Bitmap m1920b(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setRotate(this.f1394d, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: b */
    static /* synthetic */ void m1924b(CropImageView cropImageView, Uri uri) {
        Bitmap bitmap = null;
        if (cropImageView == null) {
            throw null;
        } else if (uri != null) {
            cropImageView.f1367C = C1465a.m1985a(cropImageView.getContext(), cropImageView.f1365A);
            int max = (int) (((float) Math.max(cropImageView.f1388a, cropImageView.f1390b)) * 0.1f);
            if (max != 0) {
                bitmap = C1465a.m1991b(cropImageView.getContext(), cropImageView.f1365A, max);
                cropImageView.f1375K = C1465a.f1534a;
                cropImageView.f1376L = C1465a.f1535b;
            }
            if (bitmap != null) {
                cropImageView.f1429z.post(new C1452b(cropImageView, bitmap));
            }
        } else {
            throw new IllegalStateException("Source Uri must not be null.");
        }
    }

    /* renamed from: c */
    private float m1925c(float f) {
        switch (this.f1384T.ordinal()) {
            case 0:
                return this.f1418q.height();
            case 1:
                return 3.0f;
            case 2:
                return 4.0f;
            case 3:
            case 8:
            case 9:
                return 1.0f;
            case 4:
                return 9.0f;
            case 5:
                return 16.0f;
            case 7:
                return this.f1401g0.y;
            default:
                return f;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010c  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ android.graphics.Bitmap m1926c(com.isseiaoki.simplecropview.CropImageView r10) throws java.io.IOException, java.lang.IllegalStateException {
        /*
            android.net.Uri r0 = r10.f1365A
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0051
            android.graphics.Bitmap r0 = r10.m1930d()
            if (r0 != 0) goto L_0x000e
            goto L_0x00e9
        L_0x000e:
            android.graphics.Bitmap r1 = r10.m1920b((android.graphics.Bitmap) r0)
            int r3 = r0.getWidth()
            int r4 = r0.getHeight()
            android.graphics.Rect r3 = r10.m1928c((int) r3, (int) r4)
            int r4 = r3.left
            int r5 = r3.top
            int r6 = r3.width()
            int r7 = r3.height()
            r8 = 0
            r9 = 0
            r3 = r1
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r4, r5, r6, r7, r8, r9)
            if (r1 == r3) goto L_0x0038
            if (r1 == r0) goto L_0x0038
            r1.recycle()
        L_0x0038:
            com.isseiaoki.simplecropview.CropImageView$e r0 = r10.f1384T
            com.isseiaoki.simplecropview.CropImageView$e r1 = com.isseiaoki.simplecropview.CropImageView.C1448e.CIRCLE
            if (r0 != r1) goto L_0x004e
            android.graphics.Bitmap r0 = r10.mo27114a((android.graphics.Bitmap) r3)
            android.graphics.Bitmap r1 = r10.m1930d()
            if (r3 == r1) goto L_0x004b
            r3.recycle()
        L_0x004b:
            r1 = r0
            goto L_0x00e9
        L_0x004e:
            r1 = r3
            goto L_0x00e9
        L_0x0051:
            android.content.Context r0 = r10.getContext()     // Catch:{ all -> 0x0162 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x0162 }
            android.net.Uri r3 = r10.f1365A     // Catch:{ all -> 0x0162 }
            java.io.InputStream r1 = r0.openInputStream(r3)     // Catch:{ all -> 0x0162 }
            android.graphics.BitmapRegionDecoder r0 = android.graphics.BitmapRegionDecoder.newInstance(r1, r2)     // Catch:{ all -> 0x0162 }
            int r3 = r0.getWidth()     // Catch:{ all -> 0x0162 }
            int r4 = r0.getHeight()     // Catch:{ all -> 0x0162 }
            android.graphics.Rect r5 = r10.m1928c((int) r3, (int) r4)     // Catch:{ all -> 0x0162 }
            float r6 = r10.f1394d     // Catch:{ all -> 0x0162 }
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x00b4
            android.graphics.Matrix r6 = new android.graphics.Matrix     // Catch:{ all -> 0x0162 }
            r6.<init>()     // Catch:{ all -> 0x0162 }
            float r8 = r10.f1394d     // Catch:{ all -> 0x0162 }
            float r8 = -r8
            r6.setRotate(r8)     // Catch:{ all -> 0x0162 }
            android.graphics.RectF r8 = new android.graphics.RectF     // Catch:{ all -> 0x0162 }
            r8.<init>()     // Catch:{ all -> 0x0162 }
            android.graphics.RectF r9 = new android.graphics.RectF     // Catch:{ all -> 0x0162 }
            r9.<init>(r5)     // Catch:{ all -> 0x0162 }
            r6.mapRect(r8, r9)     // Catch:{ all -> 0x0162 }
            float r5 = r8.left     // Catch:{ all -> 0x0162 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x0096
            float r3 = (float) r3     // Catch:{ all -> 0x0162 }
            goto L_0x0097
        L_0x0096:
            r3 = 0
        L_0x0097:
            float r5 = r8.top     // Catch:{ all -> 0x0162 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x009f
            float r4 = (float) r4     // Catch:{ all -> 0x0162 }
            goto L_0x00a0
        L_0x009f:
            r4 = 0
        L_0x00a0:
            r8.offset(r3, r4)     // Catch:{ all -> 0x0162 }
            android.graphics.Rect r5 = new android.graphics.Rect     // Catch:{ all -> 0x0162 }
            float r3 = r8.left     // Catch:{ all -> 0x0162 }
            int r3 = (int) r3     // Catch:{ all -> 0x0162 }
            float r4 = r8.top     // Catch:{ all -> 0x0162 }
            int r4 = (int) r4     // Catch:{ all -> 0x0162 }
            float r6 = r8.right     // Catch:{ all -> 0x0162 }
            int r6 = (int) r6     // Catch:{ all -> 0x0162 }
            float r8 = r8.bottom     // Catch:{ all -> 0x0162 }
            int r8 = (int) r8     // Catch:{ all -> 0x0162 }
            r5.<init>(r3, r4, r6, r8)     // Catch:{ all -> 0x0162 }
        L_0x00b4:
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x0162 }
            r3.<init>()     // Catch:{ all -> 0x0162 }
            android.graphics.Bitmap r0 = r0.decodeRegion(r5, r3)     // Catch:{ all -> 0x0162 }
            float r3 = r10.f1394d     // Catch:{ all -> 0x0162 }
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x00d3
            android.graphics.Bitmap r3 = r10.m1920b((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0162 }
            android.graphics.Bitmap r4 = r10.m1930d()     // Catch:{ all -> 0x0162 }
            if (r0 == r4) goto L_0x00d2
            if (r0 == r3) goto L_0x00d2
            r0.recycle()     // Catch:{ all -> 0x0162 }
        L_0x00d2:
            r0 = r3
        L_0x00d3:
            com.isseiaoki.simplecropview.p053i.C1465a.m1990a(r1)
            com.isseiaoki.simplecropview.CropImageView$e r1 = r10.f1384T
            com.isseiaoki.simplecropview.CropImageView$e r3 = com.isseiaoki.simplecropview.CropImageView.C1448e.CIRCLE
            if (r1 != r3) goto L_0x004b
            android.graphics.Bitmap r1 = r10.mo27114a((android.graphics.Bitmap) r0)
            android.graphics.Bitmap r3 = r10.m1930d()
            if (r0 == r3) goto L_0x00e9
            r0.recycle()
        L_0x00e9:
            int r0 = r1.getWidth()
            int r3 = r1.getHeight()
            android.graphics.RectF r4 = r10.f1414o
            float r4 = r4.width()
            float r4 = r10.m1919b((float) r4)
            android.graphics.RectF r5 = r10.f1414o
            float r5 = r5.height()
            float r5 = r10.m1925c((float) r5)
            float r4 = r4 / r5
            int r5 = r10.f1370F
            if (r5 <= 0) goto L_0x010c
            r2 = r5
            goto L_0x0139
        L_0x010c:
            int r5 = r10.f1371G
            if (r5 <= 0) goto L_0x0119
            float r0 = (float) r5
            float r0 = r0 * r4
            int r2 = java.lang.Math.round(r0)
            r0 = r5
            goto L_0x0141
        L_0x0119:
            int r5 = r10.f1368D
            if (r5 <= 0) goto L_0x0140
            int r6 = r10.f1369E
            if (r6 <= 0) goto L_0x0140
            if (r0 > r5) goto L_0x0125
            if (r3 <= r6) goto L_0x0140
        L_0x0125:
            int r0 = r10.f1368D
            float r2 = (float) r0
            int r3 = r10.f1369E
            float r5 = (float) r3
            float r2 = r2 / r5
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0138
            float r5 = r5 * r4
            int r2 = java.lang.Math.round(r5)
            r0 = r3
            goto L_0x0141
        L_0x0138:
            r2 = r0
        L_0x0139:
            float r0 = (float) r2
            float r0 = r0 / r4
            int r0 = java.lang.Math.round(r0)
            goto L_0x0141
        L_0x0140:
            r0 = 0
        L_0x0141:
            if (r2 <= 0) goto L_0x0155
            if (r0 <= 0) goto L_0x0155
            android.graphics.Bitmap r0 = com.isseiaoki.simplecropview.p053i.C1465a.m1987a((android.graphics.Bitmap) r1, (int) r2, (int) r0)
            android.graphics.Bitmap r2 = r10.m1930d()
            if (r1 == r2) goto L_0x0154
            if (r1 == r0) goto L_0x0154
            r1.recycle()
        L_0x0154:
            r1 = r0
        L_0x0155:
            int r0 = r1.getWidth()
            r10.f1377M = r0
            int r0 = r1.getHeight()
            r10.f1378N = r0
            return r1
        L_0x0162:
            r10 = move-exception
            com.isseiaoki.simplecropview.p053i.C1465a.m1990a(r1)
            goto L_0x0168
        L_0x0167:
            throw r10
        L_0x0168:
            goto L_0x0167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.CropImageView.m1926c(com.isseiaoki.simplecropview.CropImageView):android.graphics.Bitmap");
    }

    /* renamed from: c */
    private Rect m1928c(int i, int i2) {
        float f = (float) i;
        float f2 = (float) i2;
        float a = m1909a(this.f1394d, f, f2) / this.f1418q.width();
        RectF rectF = this.f1418q;
        float f3 = rectF.left * a;
        float f4 = rectF.top * a;
        int round = Math.round((this.f1414o.left * a) - f3);
        int round2 = Math.round((this.f1414o.top * a) - f4);
        int round3 = Math.round((this.f1414o.right * a) - f3);
        int round4 = Math.round((this.f1414o.bottom * a) - f4);
        int round5 = Math.round(m1909a(this.f1394d, f, f2));
        if (this.f1394d % 180.0f == 0.0f) {
            f = f2;
        }
        return new Rect(Math.max(round, 0), Math.max(round2, 0), Math.min(round3, round5), Math.min(round4, Math.round(f)));
    }

    /* renamed from: c */
    private void m1929c() {
        RectF rectF = this.f1414o;
        float f = rectF.left;
        RectF rectF2 = this.f1418q;
        float f2 = f - rectF2.left;
        float f3 = rectF.right - rectF2.right;
        float f4 = rectF.top - rectF2.top;
        float f5 = rectF.bottom - rectF2.bottom;
        if (f2 < 0.0f) {
            rectF.left = f - f2;
        }
        if (f3 > 0.0f) {
            this.f1414o.right -= f3;
        }
        if (f4 < 0.0f) {
            this.f1414o.top -= f4;
        }
        if (f5 > 0.0f) {
            this.f1414o.bottom -= f5;
        }
    }

    /* renamed from: d */
    private Bitmap m1930d() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* renamed from: d */
    private void m1932d(int i, int i2) {
        if (i != 0 && i2 != 0) {
            float f = (float) i;
            float f2 = (float) i2;
            this.f1420r = new PointF((f * 0.5f) + ((float) getPaddingLeft()), (0.5f * f2) + ((float) getPaddingTop()));
            float f3 = this.f1394d;
            this.f1396e = (float) getDrawable().getIntrinsicWidth();
            this.f1398f = (float) getDrawable().getIntrinsicHeight();
            if (this.f1396e <= 0.0f) {
                this.f1396e = f;
            }
            if (this.f1398f <= 0.0f) {
                this.f1398f = f2;
            }
            float f4 = f / f2;
            float a = m1909a(f3, this.f1396e, this.f1398f);
            float f5 = this.f1396e;
            float f6 = this.f1398f;
            float f7 = f3 % 180.0f;
            if (f7 == 0.0f) {
                f5 = f6;
            }
            float f8 = a / f5;
            float f9 = 1.0f;
            if (f8 >= f4) {
                f9 = f / m1909a(f3, this.f1396e, this.f1398f);
            } else if (f8 < f4) {
                float f10 = this.f1396e;
                float f11 = this.f1398f;
                if (f7 == 0.0f) {
                    f10 = f11;
                }
                f9 = f2 / f10;
            }
            this.f1392c = f9;
            m1946m();
            RectF rectF = new RectF(0.0f, 0.0f, this.f1396e, this.f1398f);
            Matrix matrix = this.f1402h;
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            this.f1418q = rectF2;
            RectF rectF3 = this.f1416p;
            if (rectF3 != null) {
                RectF rectF4 = new RectF();
                float f12 = rectF3.left;
                float f13 = this.f1392c;
                rectF4.set(f12 * f13, rectF3.top * f13, rectF3.right * f13, rectF3.bottom * f13);
                RectF rectF5 = this.f1418q;
                rectF4.offset(rectF5.left, rectF5.top);
                rectF4.set(Math.max(this.f1418q.left, rectF4.left), Math.max(this.f1418q.top, rectF4.top), Math.min(this.f1418q.right, rectF4.right), Math.min(this.f1418q.bottom, rectF4.bottom));
                this.f1414o = rectF4;
            } else {
                this.f1414o = m1911a(rectF2);
            }
            this.f1400g = true;
            invalidate();
        }
    }

    /* renamed from: d */
    private boolean m1933d(float f) {
        RectF rectF = this.f1418q;
        return rectF.left <= f && rectF.right >= f;
    }

    /* renamed from: e */
    private float m1934e() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /* renamed from: e */
    private boolean m1935e(float f) {
        RectF rectF = this.f1418q;
        return rectF.top <= f && rectF.bottom >= f;
    }

    /* renamed from: f */
    private float m1937f() {
        RectF rectF = this.f1414o;
        return rectF.bottom - rectF.top;
    }

    /* renamed from: g */
    private float m1939g() {
        RectF rectF = this.f1414o;
        return rectF.right - rectF.left;
    }

    /* renamed from: h */
    private float m1941h() {
        int ordinal = this.f1384T.ordinal();
        if (ordinal == 0) {
            return this.f1418q.width();
        }
        if (ordinal == 1) {
            return 4.0f;
        }
        if (ordinal == 2) {
            return 3.0f;
        }
        if (ordinal == 4) {
            return 16.0f;
        }
        if (ordinal == 5) {
            return 9.0f;
        }
        if (ordinal != 7) {
            return 1.0f;
        }
        return this.f1401g0.x;
    }

    /* renamed from: i */
    private float m1942i() {
        int ordinal = this.f1384T.ordinal();
        if (ordinal == 0) {
            return this.f1418q.height();
        }
        if (ordinal == 1) {
            return 3.0f;
        }
        if (ordinal == 2) {
            return 4.0f;
        }
        if (ordinal == 4) {
            return 9.0f;
        }
        if (ordinal == 5) {
            return 16.0f;
        }
        if (ordinal != 7) {
            return 1.0f;
        }
        return this.f1401g0.y;
    }

    /* renamed from: j */
    private boolean m1943j() {
        return m1937f() < this.f1387W;
    }

    /* renamed from: k */
    private boolean m1944k() {
        return m1939g() < this.f1387W;
    }

    /* renamed from: l */
    private void m1945l() {
        if (!this.f1379O.get()) {
            this.f1365A = null;
            this.f1366B = null;
            this.f1375K = 0;
            this.f1376L = 0;
            this.f1377M = 0;
            this.f1378N = 0;
            this.f1394d = (float) this.f1367C;
        }
    }

    /* renamed from: m */
    private void m1946m() {
        this.f1402h.reset();
        Matrix matrix = this.f1402h;
        PointF pointF = this.f1420r;
        matrix.setTranslate(pointF.x - (this.f1396e * 0.5f), pointF.y - (this.f1398f * 0.5f));
        Matrix matrix2 = this.f1402h;
        float f = this.f1392c;
        PointF pointF2 = this.f1420r;
        matrix2.postScale(f, f, pointF2.x, pointF2.y);
        Matrix matrix3 = this.f1402h;
        float f2 = this.f1394d;
        PointF pointF3 = this.f1420r;
        matrix3.postRotate(f2, pointF3.x, pointF3.y);
    }

    /* renamed from: n */
    private void m1947n() {
        if (getDrawable() != null) {
            m1932d(this.f1388a, this.f1390b);
        }
    }

    /* renamed from: a */
    public Bitmap mo27114a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Canvas canvas = new Canvas(createBitmap);
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawCircle((float) width, (float) height, (float) Math.min(width, height), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    /* renamed from: a */
    public RectF mo27115a() {
        RectF rectF = this.f1418q;
        float f = rectF.left;
        float f2 = this.f1392c;
        float f3 = f / f2;
        float f4 = rectF.top / f2;
        RectF rectF2 = this.f1414o;
        return new RectF(Math.max(0.0f, (rectF2.left / f2) - f3), Math.max(0.0f, (rectF2.top / f2) - f4), Math.min(this.f1418q.right / this.f1392c, (rectF2.right / f2) - f3), Math.min(this.f1418q.bottom / this.f1392c, (rectF2.bottom / f2) - f4));
    }

    /* renamed from: a */
    public void mo27116a(float f) {
        if (f < 0.01f || f > 1.0f) {
            f = 1.0f;
        }
        this.f1415o0 = f;
    }

    /* renamed from: a */
    public void mo27117a(int i) {
        this.f1374J = i;
    }

    /* renamed from: a */
    public void mo27119a(Bitmap.CompressFormat compressFormat) {
        this.f1373I = compressFormat;
    }

    /* renamed from: a */
    public void mo27120a(Uri uri, Bitmap bitmap, C1464d dVar) {
        this.f1382R.submit(new C1443b(bitmap, uri, dVar));
    }

    /* renamed from: a */
    public void mo27121a(Uri uri, C1462b bVar) {
        this.f1382R.submit(new C1441a(uri, bVar));
    }

    /* renamed from: a */
    public void mo27122a(Uri uri, boolean z, RectF rectF, C1463c cVar) {
        this.f1382R.submit(new C1446d(uri, rectF, z, cVar));
    }

    /* renamed from: b */
    public Uri mo27124b() {
        return this.f1365A;
    }

    /* renamed from: b */
    public void mo27125b(int i, int i2) {
        this.f1368D = i;
        this.f1369E = i2;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1382R.shutdown();
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        StringBuilder sb;
        int i;
        C1448e eVar;
        canvas.drawColor(this.f1406j0);
        if (this.f1400g) {
            m1946m();
            Bitmap d = m1930d();
            if (d != null) {
                canvas.drawBitmap(d, this.f1402h, this.f1410m);
                if (this.f1397e0 && !this.f1424u) {
                    this.f1404i.setAntiAlias(true);
                    this.f1404i.setFilterBitmap(true);
                    this.f1404i.setColor(this.f1407k0);
                    this.f1404i.setStyle(Paint.Style.FILL);
                    Path path = new Path();
                    RectF rectF = new RectF((float) Math.floor((double) this.f1418q.left), (float) Math.floor((double) this.f1418q.top), (float) Math.ceil((double) this.f1418q.right), (float) Math.ceil((double) this.f1418q.bottom));
                    if (this.f1425v || !((eVar = this.f1384T) == C1448e.CIRCLE || eVar == C1448e.CIRCLE_SQUARE)) {
                        path.addRect(rectF, Path.Direction.CW);
                        path.addRect(this.f1414o, Path.Direction.CCW);
                    } else {
                        path.addRect(rectF, Path.Direction.CW);
                        RectF rectF2 = this.f1414o;
                        PointF pointF = new PointF((rectF2.left + rectF2.right) / 2.0f, (rectF2.top + rectF2.bottom) / 2.0f);
                        RectF rectF3 = this.f1414o;
                        path.addCircle(pointF.x, pointF.y, (rectF3.right - rectF3.left) / 2.0f, Path.Direction.CCW);
                    }
                    canvas.drawPath(path, this.f1404i);
                    this.f1408l.setAntiAlias(true);
                    this.f1408l.setFilterBitmap(true);
                    this.f1408l.setStyle(Paint.Style.STROKE);
                    this.f1408l.setColor(this.f1409l0);
                    this.f1408l.setStrokeWidth(this.f1403h0);
                    canvas.drawRect(this.f1414o, this.f1408l);
                    if (this.f1393c0) {
                        this.f1408l.setColor(this.f1413n0);
                        this.f1408l.setStrokeWidth(this.f1405i0);
                        RectF rectF4 = this.f1414o;
                        float f = rectF4.left;
                        float f2 = rectF4.right;
                        float f3 = (f2 - f) / 3.0f;
                        float f4 = f3 + f;
                        float f5 = f2 - f3;
                        float f6 = rectF4.top;
                        float f7 = rectF4.bottom;
                        float f8 = (f7 - f6) / 3.0f;
                        float f9 = f8 + f6;
                        float f10 = f7 - f8;
                        canvas.drawLine(f4, f6, f4, f7, this.f1408l);
                        RectF rectF5 = this.f1414o;
                        canvas.drawLine(f5, rectF5.top, f5, rectF5.bottom, this.f1408l);
                        RectF rectF6 = this.f1414o;
                        canvas.drawLine(rectF6.left, f9, rectF6.right, f9, this.f1408l);
                        RectF rectF7 = this.f1414o;
                        canvas.drawLine(rectF7.left, f10, rectF7.right, f10, this.f1408l);
                    }
                    if (this.f1395d0) {
                        if (this.f1421r0) {
                            this.f1408l.setStyle(Paint.Style.FILL);
                            this.f1408l.setColor(-1157627904);
                            RectF rectF8 = new RectF(this.f1414o);
                            rectF8.offset(0.0f, 1.0f);
                            canvas.drawCircle(rectF8.left, rectF8.top, (float) this.f1389a0, this.f1408l);
                            canvas.drawCircle(rectF8.right, rectF8.top, (float) this.f1389a0, this.f1408l);
                            canvas.drawCircle(rectF8.left, rectF8.bottom, (float) this.f1389a0, this.f1408l);
                            canvas.drawCircle(rectF8.right, rectF8.bottom, (float) this.f1389a0, this.f1408l);
                        }
                        this.f1408l.setStyle(Paint.Style.FILL);
                        this.f1408l.setColor(this.f1411m0);
                        RectF rectF9 = this.f1414o;
                        canvas.drawCircle(rectF9.left, rectF9.top, (float) this.f1389a0, this.f1408l);
                        RectF rectF10 = this.f1414o;
                        canvas.drawCircle(rectF10.right, rectF10.top, (float) this.f1389a0, this.f1408l);
                        RectF rectF11 = this.f1414o;
                        canvas.drawCircle(rectF11.left, rectF11.bottom, (float) this.f1389a0, this.f1408l);
                        RectF rectF12 = this.f1414o;
                        canvas.drawCircle(rectF12.right, rectF12.bottom, (float) this.f1389a0, this.f1408l);
                    }
                }
            }
            if (this.f1372H) {
                Paint.FontMetrics fontMetrics = this.f1412n.getFontMetrics();
                this.f1412n.measureText(ExifInterface.LONGITUDE_WEST);
                int i2 = (int) (fontMetrics.descent - fontMetrics.ascent);
                int e = (int) ((((float) this.f1389a0) * 0.5f * m1934e()) + this.f1418q.left);
                int e2 = (int) ((((float) this.f1389a0) * 0.5f * m1934e()) + this.f1418q.top + ((float) i2));
                StringBuilder a = C0681a.m330a("LOADED FROM: ");
                a.append(this.f1365A != null ? "Uri" : "Bitmap");
                float f11 = (float) e;
                canvas.drawText(a.toString(), f11, (float) e2, this.f1412n);
                StringBuilder sb2 = new StringBuilder();
                if (this.f1365A == null) {
                    sb2.append("INPUT_IMAGE_SIZE: ");
                    sb2.append((int) this.f1396e);
                    sb2.append("x");
                    sb2.append((int) this.f1398f);
                    i = e2 + i2;
                    canvas.drawText(sb2.toString(), f11, (float) i, this.f1412n);
                    sb = new StringBuilder();
                } else {
                    StringBuilder a2 = C0681a.m330a("INPUT_IMAGE_SIZE: ");
                    a2.append(this.f1375K);
                    a2.append("x");
                    a2.append(this.f1376L);
                    i = e2 + i2;
                    canvas.drawText(a2.toString(), f11, (float) i, this.f1412n);
                    sb = new StringBuilder();
                }
                sb.append("LOADED_IMAGE_SIZE: ");
                sb.append(m1930d().getWidth());
                sb.append("x");
                sb.append(m1930d().getHeight());
                int i3 = i + i2;
                canvas.drawText(sb.toString(), f11, (float) i3, this.f1412n);
                StringBuilder sb3 = new StringBuilder();
                if (this.f1377M > 0 && this.f1378N > 0) {
                    sb3.append("OUTPUT_IMAGE_SIZE: ");
                    sb3.append(this.f1377M);
                    sb3.append("x");
                    sb3.append(this.f1378N);
                    int i4 = i3 + i2;
                    canvas.drawText(sb3.toString(), f11, (float) i4, this.f1412n);
                    int i5 = i4 + i2;
                    canvas.drawText("EXIF ROTATION: " + this.f1367C, f11, (float) i5, this.f1412n);
                    i3 = i5 + i2;
                    canvas.drawText("CURRENT_ROTATION: " + ((int) this.f1394d), f11, (float) i3, this.f1412n);
                }
                StringBuilder a3 = C0681a.m330a("FRAME_RECT: ");
                a3.append(this.f1414o.toString());
                int i6 = i3 + i2;
                canvas.drawText(a3.toString(), f11, (float) i6, this.f1412n);
                canvas.drawText("ACTUAL_CROP_RECT: " + mo27115a().toString(), f11, (float) (i6 + i2), this.f1412n);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getDrawable() != null) {
            m1932d(this.f1388a, this.f1390b);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        this.f1388a = (size - getPaddingLeft()) - getPaddingRight();
        this.f1390b = (size2 - getPaddingTop()) - getPaddingBottom();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1384T = savedState.f1443a;
        this.f1406j0 = savedState.f1444b;
        this.f1407k0 = savedState.f1445c;
        this.f1409l0 = savedState.f1446d;
        this.f1385U = savedState.f1447e;
        this.f1386V = savedState.f1448f;
        this.f1393c0 = savedState.f1449g;
        this.f1395d0 = savedState.f1450h;
        this.f1389a0 = savedState.f1451i;
        this.f1391b0 = savedState.f1452l;
        this.f1387W = savedState.f1453m;
        this.f1401g0 = new PointF(savedState.f1454n, savedState.f1455o);
        this.f1403h0 = savedState.f1456p;
        this.f1405i0 = savedState.f1457q;
        this.f1397e0 = savedState.f1458r;
        this.f1411m0 = savedState.f1459s;
        this.f1413n0 = savedState.f1460t;
        this.f1415o0 = savedState.f1461u;
        this.f1394d = savedState.f1462v;
        this.f1417p0 = savedState.f1463w;
        this.f1419q0 = savedState.f1464x;
        this.f1367C = savedState.f1465y;
        this.f1365A = savedState.f1466z;
        this.f1366B = savedState.f1430A;
        this.f1373I = savedState.f1431B;
        this.f1374J = savedState.f1432C;
        this.f1372H = savedState.f1433D;
        this.f1368D = savedState.f1434E;
        this.f1369E = savedState.f1435F;
        this.f1370F = savedState.f1436G;
        this.f1371G = savedState.f1437H;
        this.f1421r0 = savedState.f1438I;
        this.f1375K = savedState.f1439J;
        this.f1376L = savedState.f1440K;
        this.f1377M = savedState.f1441L;
        this.f1378N = savedState.f1442M;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1443a = this.f1384T;
        savedState.f1444b = this.f1406j0;
        savedState.f1445c = this.f1407k0;
        savedState.f1446d = this.f1409l0;
        savedState.f1447e = this.f1385U;
        savedState.f1448f = this.f1386V;
        savedState.f1449g = this.f1393c0;
        savedState.f1450h = this.f1395d0;
        savedState.f1451i = this.f1389a0;
        savedState.f1452l = this.f1391b0;
        savedState.f1453m = this.f1387W;
        PointF pointF = this.f1401g0;
        savedState.f1454n = pointF.x;
        savedState.f1455o = pointF.y;
        savedState.f1456p = this.f1403h0;
        savedState.f1457q = this.f1405i0;
        savedState.f1458r = this.f1397e0;
        savedState.f1459s = this.f1411m0;
        savedState.f1460t = this.f1413n0;
        savedState.f1461u = this.f1415o0;
        savedState.f1462v = this.f1394d;
        savedState.f1463w = this.f1417p0;
        savedState.f1464x = this.f1419q0;
        savedState.f1465y = this.f1367C;
        savedState.f1466z = this.f1365A;
        savedState.f1430A = this.f1366B;
        savedState.f1431B = this.f1373I;
        savedState.f1432C = this.f1374J;
        savedState.f1433D = this.f1372H;
        savedState.f1434E = this.f1368D;
        savedState.f1435F = this.f1369E;
        savedState.f1436G = this.f1370F;
        savedState.f1437H = this.f1371G;
        savedState.f1438I = this.f1421r0;
        savedState.f1439J = this.f1375K;
        savedState.f1440K = this.f1376L;
        savedState.f1441L = this.f1377M;
        savedState.f1442M = this.f1378N;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:155:0x052c, code lost:
        if (r7.f1385U == com.isseiaoki.simplecropview.CropImageView.C1449f.f1504c) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0560, code lost:
        if (r7.f1385U == com.isseiaoki.simplecropview.CropImageView.C1449f.f1504c) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0593, code lost:
        if (r7.f1385U == com.isseiaoki.simplecropview.CropImageView.C1449f.f1504c) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x05c6, code lost:
        if (r7.f1385U == com.isseiaoki.simplecropview.CropImageView.C1449f.f1504c) goto L_0x05c8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.f1400g
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r7.f1397e0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r0 = r7.f1399f0
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            boolean r0 = r7.f1424u
            if (r0 == 0) goto L_0x0015
            return r1
        L_0x0015:
            boolean r0 = r7.f1425v
            if (r0 == 0) goto L_0x001a
            return r1
        L_0x001a:
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f1379O
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x0023
            return r1
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f1380P
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x002c
            return r1
        L_0x002c:
            int r0 = r8.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x04e5
            if (r0 == r2) goto L_0x04c6
            r3 = 3
            r4 = 2
            if (r0 == r4) goto L_0x004b
            if (r0 == r3) goto L_0x003c
            return r1
        L_0x003c:
            android.view.ViewParent r8 = r7.getParent()
            r8.requestDisallowInterceptTouchEvent(r1)
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.OUT_OF_BOUNDS
            r7.f1383S = r8
            r7.invalidate()
            return r2
        L_0x004b:
            float r0 = r8.getX()
            float r1 = r7.f1422s
            float r0 = r0 - r1
            float r1 = r8.getY()
            float r5 = r7.f1423t
            float r1 = r1 - r5
            com.isseiaoki.simplecropview.CropImageView$g r5 = r7.f1383S
            int r5 = r5.ordinal()
            if (r5 == r2) goto L_0x0440
            if (r5 == r4) goto L_0x034d
            if (r5 == r3) goto L_0x0258
            r3 = 4
            if (r5 == r3) goto L_0x0163
            r3 = 5
            if (r5 == r3) goto L_0x006d
            goto L_0x04a9
        L_0x006d:
            com.isseiaoki.simplecropview.CropImageView$e r3 = r7.f1384T
            com.isseiaoki.simplecropview.CropImageView$e r4 = com.isseiaoki.simplecropview.CropImageView.C1448e.FREE
            if (r3 != r4) goto L_0x00ac
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.right
            float r4 = r4 + r0
            r3.right = r4
            float r0 = r3.bottom
            float r0 = r0 + r1
            r3.bottom = r0
            boolean r0 = r7.m1944k()
            if (r0 == 0) goto L_0x0093
            float r0 = r7.f1387W
            float r1 = r7.m1939g()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.right
            float r3 = r3 + r0
            r1.right = r3
        L_0x0093:
            boolean r0 = r7.m1943j()
            if (r0 == 0) goto L_0x00a7
            float r0 = r7.f1387W
            float r1 = r7.m1937f()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.bottom
            float r3 = r3 + r0
            r1.bottom = r3
        L_0x00a7:
            r7.m1929c()
            goto L_0x04a9
        L_0x00ac:
            float r1 = r7.m1942i()
            float r1 = r1 * r0
            float r3 = r7.m1941h()
            float r1 = r1 / r3
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.right
            float r4 = r4 + r0
            r3.right = r4
            float r0 = r3.bottom
            float r0 = r0 + r1
            r3.bottom = r0
            boolean r0 = r7.m1944k()
            if (r0 == 0) goto L_0x00e9
            float r0 = r7.f1387W
            float r1 = r7.m1939g()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.right
            float r3 = r3 + r0
            r1.right = r3
            float r1 = r7.m1942i()
            float r0 = r0 * r1
            float r1 = r7.m1941h()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.bottom
            float r3 = r3 + r0
            r1.bottom = r3
        L_0x00e9:
            boolean r0 = r7.m1943j()
            if (r0 == 0) goto L_0x010f
            float r0 = r7.f1387W
            float r1 = r7.m1937f()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.bottom
            float r3 = r3 + r0
            r1.bottom = r3
            float r1 = r7.m1941h()
            float r0 = r0 * r1
            float r1 = r7.m1942i()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.right
            float r3 = r3 + r0
            r1.right = r3
        L_0x010f:
            android.graphics.RectF r0 = r7.f1414o
            float r0 = r0.right
            boolean r0 = r7.m1933d((float) r0)
            if (r0 != 0) goto L_0x0138
            android.graphics.RectF r0 = r7.f1414o
            float r1 = r0.right
            android.graphics.RectF r3 = r7.f1418q
            float r3 = r3.right
            float r3 = r1 - r3
            float r1 = r1 - r3
            r0.right = r1
            float r0 = r7.m1942i()
            float r3 = r3 * r0
            float r0 = r7.m1941h()
            float r3 = r3 / r0
            android.graphics.RectF r0 = r7.f1414o
            float r1 = r0.bottom
            float r1 = r1 - r3
            r0.bottom = r1
        L_0x0138:
            android.graphics.RectF r0 = r7.f1414o
            float r0 = r0.bottom
            boolean r0 = r7.m1935e((float) r0)
            if (r0 != 0) goto L_0x04a9
            android.graphics.RectF r0 = r7.f1414o
            float r1 = r0.bottom
            android.graphics.RectF r3 = r7.f1418q
            float r3 = r3.bottom
            float r3 = r1 - r3
            float r1 = r1 - r3
            r0.bottom = r1
            float r0 = r7.m1941h()
            float r3 = r3 * r0
            float r0 = r7.m1942i()
            float r3 = r3 / r0
            android.graphics.RectF r0 = r7.f1414o
            float r1 = r0.right
            float r1 = r1 - r3
            r0.right = r1
            goto L_0x04a9
        L_0x0163:
            com.isseiaoki.simplecropview.CropImageView$e r3 = r7.f1384T
            com.isseiaoki.simplecropview.CropImageView$e r4 = com.isseiaoki.simplecropview.CropImageView.C1448e.FREE
            if (r3 != r4) goto L_0x01a2
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.left
            float r4 = r4 + r0
            r3.left = r4
            float r0 = r3.bottom
            float r0 = r0 + r1
            r3.bottom = r0
            boolean r0 = r7.m1944k()
            if (r0 == 0) goto L_0x0189
            float r0 = r7.f1387W
            float r1 = r7.m1939g()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r3 = r3 - r0
            r1.left = r3
        L_0x0189:
            boolean r0 = r7.m1943j()
            if (r0 == 0) goto L_0x019d
            float r0 = r7.f1387W
            float r1 = r7.m1937f()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.bottom
            float r3 = r3 + r0
            r1.bottom = r3
        L_0x019d:
            r7.m1929c()
            goto L_0x04a9
        L_0x01a2:
            float r1 = r7.m1942i()
            float r1 = r1 * r0
            float r3 = r7.m1941h()
            float r1 = r1 / r3
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.left
            float r4 = r4 + r0
            r3.left = r4
            float r0 = r3.bottom
            float r0 = r0 - r1
            r3.bottom = r0
            boolean r0 = r7.m1944k()
            if (r0 == 0) goto L_0x01df
            float r0 = r7.f1387W
            float r1 = r7.m1939g()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r3 = r3 - r0
            r1.left = r3
            float r1 = r7.m1942i()
            float r0 = r0 * r1
            float r1 = r7.m1941h()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.bottom
            float r3 = r3 + r0
            r1.bottom = r3
        L_0x01df:
            boolean r0 = r7.m1943j()
            if (r0 == 0) goto L_0x0205
            float r0 = r7.f1387W
            float r1 = r7.m1937f()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.bottom
            float r3 = r3 + r0
            r1.bottom = r3
            float r1 = r7.m1941h()
            float r0 = r0 * r1
            float r1 = r7.m1942i()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r3 = r3 - r0
            r1.left = r3
        L_0x0205:
            android.graphics.RectF r0 = r7.f1414o
            float r0 = r0.left
            boolean r0 = r7.m1933d((float) r0)
            if (r0 != 0) goto L_0x022d
            android.graphics.RectF r0 = r7.f1418q
            float r0 = r0.left
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r0 = r0 - r3
            float r3 = r3 + r0
            r1.left = r3
            float r1 = r7.m1942i()
            float r0 = r0 * r1
            float r1 = r7.m1941h()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.bottom
            float r3 = r3 - r0
            r1.bottom = r3
        L_0x022d:
            android.graphics.RectF r0 = r7.f1414o
            float r0 = r0.bottom
            boolean r0 = r7.m1935e((float) r0)
            if (r0 != 0) goto L_0x04a9
            android.graphics.RectF r0 = r7.f1414o
            float r1 = r0.bottom
            android.graphics.RectF r3 = r7.f1418q
            float r3 = r3.bottom
            float r3 = r1 - r3
            float r1 = r1 - r3
            r0.bottom = r1
            float r0 = r7.m1941h()
            float r3 = r3 * r0
            float r0 = r7.m1942i()
            float r3 = r3 / r0
            android.graphics.RectF r0 = r7.f1414o
            float r1 = r0.left
            float r1 = r1 + r3
            r0.left = r1
            goto L_0x04a9
        L_0x0258:
            com.isseiaoki.simplecropview.CropImageView$e r3 = r7.f1384T
            com.isseiaoki.simplecropview.CropImageView$e r4 = com.isseiaoki.simplecropview.CropImageView.C1448e.FREE
            if (r3 != r4) goto L_0x0297
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.right
            float r4 = r4 + r0
            r3.right = r4
            float r0 = r3.top
            float r0 = r0 + r1
            r3.top = r0
            boolean r0 = r7.m1944k()
            if (r0 == 0) goto L_0x027e
            float r0 = r7.f1387W
            float r1 = r7.m1939g()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.right
            float r3 = r3 + r0
            r1.right = r3
        L_0x027e:
            boolean r0 = r7.m1943j()
            if (r0 == 0) goto L_0x0292
            float r0 = r7.f1387W
            float r1 = r7.m1937f()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r3 = r3 - r0
            r1.top = r3
        L_0x0292:
            r7.m1929c()
            goto L_0x04a9
        L_0x0297:
            float r1 = r7.m1942i()
            float r1 = r1 * r0
            float r3 = r7.m1941h()
            float r1 = r1 / r3
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.right
            float r4 = r4 + r0
            r3.right = r4
            float r0 = r3.top
            float r0 = r0 - r1
            r3.top = r0
            boolean r0 = r7.m1944k()
            if (r0 == 0) goto L_0x02d4
            float r0 = r7.f1387W
            float r1 = r7.m1939g()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.right
            float r3 = r3 + r0
            r1.right = r3
            float r1 = r7.m1942i()
            float r0 = r0 * r1
            float r1 = r7.m1941h()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r3 = r3 - r0
            r1.top = r3
        L_0x02d4:
            boolean r0 = r7.m1943j()
            if (r0 == 0) goto L_0x02fa
            float r0 = r7.f1387W
            float r1 = r7.m1937f()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r3 = r3 - r0
            r1.top = r3
            float r1 = r7.m1941h()
            float r0 = r0 * r1
            float r1 = r7.m1942i()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.right
            float r3 = r3 + r0
            r1.right = r3
        L_0x02fa:
            android.graphics.RectF r0 = r7.f1414o
            float r0 = r0.right
            boolean r0 = r7.m1933d((float) r0)
            if (r0 != 0) goto L_0x0323
            android.graphics.RectF r0 = r7.f1414o
            float r1 = r0.right
            android.graphics.RectF r3 = r7.f1418q
            float r3 = r3.right
            float r3 = r1 - r3
            float r1 = r1 - r3
            r0.right = r1
            float r0 = r7.m1942i()
            float r3 = r3 * r0
            float r0 = r7.m1941h()
            float r3 = r3 / r0
            android.graphics.RectF r0 = r7.f1414o
            float r1 = r0.top
            float r1 = r1 + r3
            r0.top = r1
        L_0x0323:
            android.graphics.RectF r0 = r7.f1414o
            float r0 = r0.top
            boolean r0 = r7.m1935e((float) r0)
            if (r0 != 0) goto L_0x04a9
            android.graphics.RectF r0 = r7.f1418q
            float r0 = r0.top
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r0 = r0 - r3
            float r3 = r3 + r0
            r1.top = r3
            float r1 = r7.m1941h()
            float r0 = r0 * r1
            float r1 = r7.m1942i()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.right
            float r3 = r3 - r0
            r1.right = r3
            goto L_0x04a9
        L_0x034d:
            com.isseiaoki.simplecropview.CropImageView$e r3 = r7.f1384T
            com.isseiaoki.simplecropview.CropImageView$e r4 = com.isseiaoki.simplecropview.CropImageView.C1448e.FREE
            if (r3 != r4) goto L_0x038c
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.left
            float r4 = r4 + r0
            r3.left = r4
            float r0 = r3.top
            float r0 = r0 + r1
            r3.top = r0
            boolean r0 = r7.m1944k()
            if (r0 == 0) goto L_0x0373
            float r0 = r7.f1387W
            float r1 = r7.m1939g()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r3 = r3 - r0
            r1.left = r3
        L_0x0373:
            boolean r0 = r7.m1943j()
            if (r0 == 0) goto L_0x0387
            float r0 = r7.f1387W
            float r1 = r7.m1937f()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r3 = r3 - r0
            r1.top = r3
        L_0x0387:
            r7.m1929c()
            goto L_0x04a9
        L_0x038c:
            float r1 = r7.m1942i()
            float r1 = r1 * r0
            float r3 = r7.m1941h()
            float r1 = r1 / r3
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.left
            float r4 = r4 + r0
            r3.left = r4
            float r0 = r3.top
            float r0 = r0 + r1
            r3.top = r0
            boolean r0 = r7.m1944k()
            if (r0 == 0) goto L_0x03c9
            float r0 = r7.f1387W
            float r1 = r7.m1939g()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r3 = r3 - r0
            r1.left = r3
            float r1 = r7.m1942i()
            float r0 = r0 * r1
            float r1 = r7.m1941h()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r3 = r3 - r0
            r1.top = r3
        L_0x03c9:
            boolean r0 = r7.m1943j()
            if (r0 == 0) goto L_0x03ef
            float r0 = r7.f1387W
            float r1 = r7.m1937f()
            float r0 = r0 - r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r3 = r3 - r0
            r1.top = r3
            float r1 = r7.m1941h()
            float r0 = r0 * r1
            float r1 = r7.m1942i()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r3 = r3 - r0
            r1.left = r3
        L_0x03ef:
            android.graphics.RectF r0 = r7.f1414o
            float r0 = r0.left
            boolean r0 = r7.m1933d((float) r0)
            if (r0 != 0) goto L_0x0417
            android.graphics.RectF r0 = r7.f1418q
            float r0 = r0.left
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r0 = r0 - r3
            float r3 = r3 + r0
            r1.left = r3
            float r1 = r7.m1942i()
            float r0 = r0 * r1
            float r1 = r7.m1941h()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r3 = r3 + r0
            r1.top = r3
        L_0x0417:
            android.graphics.RectF r0 = r7.f1414o
            float r0 = r0.top
            boolean r0 = r7.m1935e((float) r0)
            if (r0 != 0) goto L_0x04a9
            android.graphics.RectF r0 = r7.f1418q
            float r0 = r0.top
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.top
            float r0 = r0 - r3
            float r3 = r3 + r0
            r1.top = r3
            float r1 = r7.m1941h()
            float r0 = r0 * r1
            float r1 = r7.m1942i()
            float r0 = r0 / r1
            android.graphics.RectF r1 = r7.f1414o
            float r3 = r1.left
            float r3 = r3 + r0
            r1.left = r3
            goto L_0x04a9
        L_0x0440:
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.left
            float r4 = r4 + r0
            r3.left = r4
            float r5 = r3.right
            float r5 = r5 + r0
            r3.right = r5
            float r0 = r3.top
            float r0 = r0 + r1
            r3.top = r0
            float r0 = r3.bottom
            float r0 = r0 + r1
            r3.bottom = r0
            android.graphics.RectF r0 = r7.f1418q
            float r0 = r0.left
            float r0 = r4 - r0
            r1 = 0
            int r6 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x0467
            float r4 = r4 - r0
            r3.left = r4
            float r5 = r5 - r0
            r3.right = r5
        L_0x0467:
            android.graphics.RectF r0 = r7.f1414o
            float r3 = r0.right
            android.graphics.RectF r4 = r7.f1418q
            float r4 = r4.right
            float r4 = r3 - r4
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r5 <= 0) goto L_0x047d
            float r5 = r0.left
            float r5 = r5 - r4
            r0.left = r5
            float r3 = r3 - r4
            r0.right = r3
        L_0x047d:
            android.graphics.RectF r0 = r7.f1414o
            float r3 = r0.top
            android.graphics.RectF r4 = r7.f1418q
            float r4 = r4.top
            float r4 = r3 - r4
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x0493
            float r3 = r3 - r4
            r0.top = r3
            float r3 = r0.bottom
            float r3 = r3 - r4
            r0.bottom = r3
        L_0x0493:
            android.graphics.RectF r0 = r7.f1414o
            float r3 = r0.bottom
            android.graphics.RectF r4 = r7.f1418q
            float r4 = r4.bottom
            float r4 = r3 - r4
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x04a9
            float r1 = r0.top
            float r1 = r1 - r4
            r0.top = r1
            float r3 = r3 - r4
            r0.bottom = r3
        L_0x04a9:
            r7.invalidate()
            float r0 = r8.getX()
            r7.f1422s = r0
            float r8 = r8.getY()
            r7.f1423t = r8
            com.isseiaoki.simplecropview.CropImageView$g r8 = r7.f1383S
            com.isseiaoki.simplecropview.CropImageView$g r0 = com.isseiaoki.simplecropview.CropImageView.C1450g.OUT_OF_BOUNDS
            if (r8 == r0) goto L_0x04c5
            android.view.ViewParent r8 = r7.getParent()
            r8.requestDisallowInterceptTouchEvent(r2)
        L_0x04c5:
            return r2
        L_0x04c6:
            android.view.ViewParent r8 = r7.getParent()
            r8.requestDisallowInterceptTouchEvent(r1)
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1385U
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x04d5
            r7.f1393c0 = r1
        L_0x04d5:
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1386V
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x04dd
            r7.f1395d0 = r1
        L_0x04dd:
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.OUT_OF_BOUNDS
            r7.f1383S = r8
            r7.invalidate()
            return r2
        L_0x04e5:
            r7.invalidate()
            float r0 = r8.getX()
            r7.f1422s = r0
            float r0 = r8.getY()
            r7.f1423t = r0
            float r0 = r8.getX()
            float r8 = r8.getY()
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.left
            float r4 = r0 - r4
            float r3 = r3.top
            float r3 = r8 - r3
            float r4 = r4 * r4
            float r3 = r3 * r3
            float r3 = r3 + r4
            int r4 = r7.f1389a0
            int r5 = r7.f1391b0
            int r4 = r4 + r5
            float r4 = (float) r4
            float r4 = r4 * r4
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0519
            r3 = 1
            goto L_0x051a
        L_0x0519:
            r3 = 0
        L_0x051a:
            if (r3 == 0) goto L_0x0530
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.LEFT_TOP
            r7.f1383S = r8
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1386V
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x0528
            r7.f1395d0 = r2
        L_0x0528:
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1385U
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x05fb
            goto L_0x05c8
        L_0x0530:
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.right
            float r4 = r0 - r4
            float r3 = r3.top
            float r3 = r8 - r3
            float r4 = r4 * r4
            float r3 = r3 * r3
            float r3 = r3 + r4
            int r4 = r7.f1389a0
            int r5 = r7.f1391b0
            int r4 = r4 + r5
            float r4 = (float) r4
            float r4 = r4 * r4
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x054d
            r3 = 1
            goto L_0x054e
        L_0x054d:
            r3 = 0
        L_0x054e:
            if (r3 == 0) goto L_0x0563
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.RIGHT_TOP
            r7.f1383S = r8
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1386V
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x055c
            r7.f1395d0 = r2
        L_0x055c:
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1385U
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x05fb
            goto L_0x05c8
        L_0x0563:
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.left
            float r4 = r0 - r4
            float r3 = r3.bottom
            float r3 = r8 - r3
            float r4 = r4 * r4
            float r3 = r3 * r3
            float r3 = r3 + r4
            int r4 = r7.f1389a0
            int r5 = r7.f1391b0
            int r4 = r4 + r5
            float r4 = (float) r4
            float r4 = r4 * r4
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0580
            r3 = 1
            goto L_0x0581
        L_0x0580:
            r3 = 0
        L_0x0581:
            if (r3 == 0) goto L_0x0596
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.LEFT_BOTTOM
            r7.f1383S = r8
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1386V
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x058f
            r7.f1395d0 = r2
        L_0x058f:
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1385U
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x05fb
            goto L_0x05c8
        L_0x0596:
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.right
            float r4 = r0 - r4
            float r3 = r3.bottom
            float r3 = r8 - r3
            float r4 = r4 * r4
            float r3 = r3 * r3
            float r3 = r3 + r4
            int r4 = r7.f1389a0
            int r5 = r7.f1391b0
            int r4 = r4 + r5
            float r4 = (float) r4
            float r4 = r4 * r4
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x05b3
            r3 = 1
            goto L_0x05b4
        L_0x05b3:
            r3 = 0
        L_0x05b4:
            if (r3 == 0) goto L_0x05cb
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.RIGHT_BOTTOM
            r7.f1383S = r8
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1386V
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x05c2
            r7.f1395d0 = r2
        L_0x05c2:
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1385U
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x05fb
        L_0x05c8:
            r7.f1393c0 = r2
            goto L_0x05fb
        L_0x05cb:
            android.graphics.RectF r3 = r7.f1414o
            float r4 = r3.left
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x05ea
            float r4 = r3.right
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x05ea
            float r0 = r3.top
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x05ea
            float r0 = r3.bottom
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x05ea
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.CENTER
            r7.f1383S = r8
            r1 = 1
        L_0x05ea:
            if (r1 == 0) goto L_0x05f7
            com.isseiaoki.simplecropview.CropImageView$f r8 = r7.f1385U
            com.isseiaoki.simplecropview.CropImageView$f r0 = com.isseiaoki.simplecropview.CropImageView.C1449f.SHOW_ON_TOUCH
            if (r8 != r0) goto L_0x05f4
            r7.f1393c0 = r2
        L_0x05f4:
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.CENTER
            goto L_0x05f9
        L_0x05f7:
            com.isseiaoki.simplecropview.CropImageView$g r8 = com.isseiaoki.simplecropview.CropImageView.C1450g.OUT_OF_BOUNDS
        L_0x05f9:
            r7.f1383S = r8
        L_0x05fb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.CropImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBackgroundColor(int i) {
        this.f1406j0 = i;
        invalidate();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f1399f0 = z;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f1400g = false;
        m1945l();
        super.setImageDrawable(drawable);
        m1947n();
    }

    public void setImageResource(int i) {
        this.f1400g = false;
        m1945l();
        super.setImageResource(i);
        m1947n();
    }

    public void setImageURI(Uri uri) {
        this.f1400g = false;
        super.setImageURI(uri);
        m1947n();
    }

    /* renamed from: a */
    static /* synthetic */ Uri m1913a(CropImageView cropImageView, Bitmap bitmap, Uri uri) throws IOException, IllegalStateException {
        cropImageView.f1366B = uri;
        if (uri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = cropImageView.getContext().getContentResolver().openOutputStream(uri);
                bitmap.compress(cropImageView.f1373I, cropImageView.f1374J, outputStream);
                C1465a.m1989a(cropImageView.getContext(), cropImageView.f1365A, uri, bitmap.getWidth(), bitmap.getHeight());
                C1465a.m1993c(cropImageView.getContext(), uri);
                return uri;
            } finally {
                C1465a.m1990a(outputStream);
            }
        } else {
            throw new IllegalStateException("Save uri must not be null.");
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m1916a(CropImageView cropImageView, Drawable drawable) {
        super.setImageDrawable(drawable);
        cropImageView.m1947n();
    }

    /* renamed from: a */
    public void mo27123a(C1448e eVar) {
        int i = this.f1419q0;
        if (eVar == C1448e.CUSTOM) {
            mo27118a(1, 1);
            return;
        }
        this.f1384T = eVar;
        m1923b(i);
    }

    /* renamed from: b */
    private void m1923b(int i) {
        if (this.f1418q != null) {
            if (this.f1425v) {
                if (this.f1426w == null) {
                    this.f1426w = new C1459c(this.f1428y);
                }
                this.f1426w.mo27161a();
            }
            RectF rectF = new RectF(this.f1414o);
            RectF a = m1911a(this.f1418q);
            float f = a.left - rectF.left;
            float f2 = a.top - rectF.top;
            float f3 = a.right - rectF.right;
            float f4 = a.bottom - rectF.bottom;
            if (this.f1417p0) {
                if (this.f1426w == null) {
                    this.f1426w = new C1459c(this.f1428y);
                }
                C1457a aVar = this.f1426w;
                aVar.mo27163a((C1458b) new C1445c(rectF, f, f2, f3, f4, a));
                aVar.mo27162a((long) i);
                return;
            }
            this.f1414o = m1911a(this.f1418q);
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo27118a(int i, int i2) {
        int i3 = this.f1419q0;
        if (i != 0 && i2 != 0) {
            this.f1384T = C1448e.CUSTOM;
            this.f1401g0 = new PointF((float) i, (float) i2);
            m1923b(i3);
        }
    }

    /* renamed from: c */
    static /* synthetic */ Bitmap m1927c(CropImageView cropImageView, Uri uri) {
        if (cropImageView == null) {
            throw null;
        } else if (uri != null) {
            cropImageView.f1367C = C1465a.m1985a(cropImageView.getContext(), cropImageView.f1365A);
            int[] iArr = new int[1];
            GLES10.glGetIntegerv(3379, iArr, 0);
            int min = iArr[0] > 0 ? Math.min(iArr[0], 4096) : 2048;
            int max = Math.max(cropImageView.f1388a, cropImageView.f1390b);
            if (max != 0) {
                min = max;
            }
            Bitmap b = C1465a.m1991b(cropImageView.getContext(), cropImageView.f1365A, min);
            cropImageView.f1375K = C1465a.f1534a;
            cropImageView.f1376L = C1465a.f1535b;
            return b;
        } else {
            throw new IllegalStateException("Source Uri must not be null.");
        }
    }
}
