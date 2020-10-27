package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.C1513u;

/* renamed from: com.squareup.picasso.v */
final class C1523v extends BitmapDrawable {

    /* renamed from: h */
    private static final Paint f1704h = new Paint();

    /* renamed from: a */
    private final boolean f1705a;

    /* renamed from: b */
    private final float f1706b;

    /* renamed from: c */
    private final C1513u.C1519e f1707c;

    /* renamed from: d */
    Drawable f1708d;

    /* renamed from: e */
    long f1709e;

    /* renamed from: f */
    boolean f1710f;

    /* renamed from: g */
    int f1711g = 255;

    C1523v(Context context, Bitmap bitmap, Drawable drawable, C1513u.C1519e eVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f1705a = z2;
        this.f1706b = context.getResources().getDisplayMetrics().density;
        this.f1707c = eVar;
        if (eVar != C1513u.C1519e.MEMORY && !z) {
            this.f1708d = drawable;
            this.f1710f = true;
            this.f1709e = SystemClock.uptimeMillis();
        }
    }

    /* renamed from: a */
    private static Path m2082a(int i, int i2, int i3) {
        Path path = new Path();
        float f = (float) i;
        float f2 = (float) i2;
        path.moveTo(f, f2);
        path.lineTo((float) (i + i3), f2);
        path.lineTo(f, (float) (i2 + i3));
        return path;
    }

    /* renamed from: a */
    static void m2083a(ImageView imageView, Context context, Bitmap bitmap, C1513u.C1519e eVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new C1523v(context, bitmap, drawable, eVar, z, z2));
    }

    /* renamed from: a */
    static void m2084a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            boolean r0 = r6.f1710f
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0005:
            super.draw(r7)
            goto L_0x0038
        L_0x0009:
            long r2 = android.os.SystemClock.uptimeMillis()
            long r4 = r6.f1709e
            long r2 = r2 - r4
            float r0 = (float) r2
            r2 = 1128792064(0x43480000, float:200.0)
            float r0 = r0 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0020
            r6.f1710f = r1
            r0 = 0
            r6.f1708d = r0
            goto L_0x0005
        L_0x0020:
            android.graphics.drawable.Drawable r2 = r6.f1708d
            if (r2 == 0) goto L_0x0027
            r2.draw(r7)
        L_0x0027:
            int r2 = r6.f1711g
            float r2 = (float) r2
            float r2 = r2 * r0
            int r0 = (int) r2
            super.setAlpha(r0)
            super.draw(r7)
            int r0 = r6.f1711g
            super.setAlpha(r0)
        L_0x0038:
            boolean r0 = r6.f1705a
            if (r0 == 0) goto L_0x006b
            android.graphics.Paint r0 = f1704h
            r2 = -1
            r0.setColor(r2)
            float r0 = r6.f1706b
            r2 = 1098907648(0x41800000, float:16.0)
            float r0 = r0 * r2
            int r0 = (int) r0
            android.graphics.Path r0 = m2082a(r1, r1, r0)
            android.graphics.Paint r2 = f1704h
            r7.drawPath(r0, r2)
            android.graphics.Paint r0 = f1704h
            com.squareup.picasso.u$e r2 = r6.f1707c
            int r2 = r2.f1699a
            r0.setColor(r2)
            float r0 = r6.f1706b
            r2 = 1097859072(0x41700000, float:15.0)
            float r0 = r0 * r2
            int r0 = (int) r0
            android.graphics.Path r0 = m2082a(r1, r1, r0)
            android.graphics.Paint r1 = f1704h
            r7.drawPath(r0, r1)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1523v.draw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1708d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i) {
        this.f1711g = i;
        Drawable drawable = this.f1708d;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1708d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
