package com.squareup.picasso;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;

/* renamed from: com.squareup.picasso.h */
class C1492h implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final C1529y f1618a;
    @VisibleForTesting

    /* renamed from: b */
    final WeakReference<ImageView> f1619b;
    @VisibleForTesting

    /* renamed from: c */
    C1489e f1620c;

    C1492h(C1529y yVar, ImageView imageView, C1489e eVar) {
        this.f1618a = yVar;
        this.f1619b = new WeakReference<>(imageView);
        this.f1620c = eVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27214a() {
        this.f1618a.mo27283b();
        this.f1620c = null;
        ImageView imageView = (ImageView) this.f1619b.get();
        if (imageView != null) {
            this.f1619b.clear();
            imageView.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f1619b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f1619b.clear();
            C1529y yVar = this.f1618a;
            yVar.mo27285d();
            yVar.mo27278a(width, height);
            yVar.mo27281a(imageView, this.f1620c);
        }
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
