package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.C1513u;

/* renamed from: com.squareup.picasso.l */
class C1500l extends C1478a<ImageView> {

    /* renamed from: m */
    C1489e f1640m;

    C1500l(C1513u uVar, ImageView imageView, C1526x xVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, C1489e eVar, boolean z) {
        super(uVar, imageView, xVar, i, i2, i3, drawable, str, obj, z);
        this.f1640m = eVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27196a() {
        this.f1582l = true;
        if (this.f1640m != null) {
            this.f1640m = null;
        }
    }

    /* renamed from: a */
    public void mo27183a(Bitmap bitmap, C1513u.C1519e eVar) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f1573c.get();
            if (imageView != null) {
                C1513u uVar = this.f1571a;
                Bitmap bitmap2 = bitmap;
                C1513u.C1519e eVar2 = eVar;
                C1523v.m2083a(imageView, uVar.f1677e, bitmap2, eVar2, this.f1574d, uVar.f1685m);
                C1489e eVar3 = this.f1640m;
                if (eVar3 != null) {
                    eVar3.onSuccess();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    /* renamed from: a */
    public void mo27184a(Exception exc) {
        ImageView imageView = (ImageView) this.f1573c.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            int i = this.f1577g;
            if (i != 0) {
                imageView.setImageResource(i);
            } else {
                Drawable drawable2 = this.f1578h;
                if (drawable2 != null) {
                    imageView.setImageDrawable(drawable2);
                }
            }
            C1489e eVar = this.f1640m;
            if (eVar != null) {
                eVar.onError(exc);
            }
        }
    }
}
