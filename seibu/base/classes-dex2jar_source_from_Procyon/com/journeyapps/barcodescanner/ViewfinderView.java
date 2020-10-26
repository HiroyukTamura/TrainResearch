// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import java.util.Iterator;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.content.res.Resources;
import java.util.ArrayList;
import com.google.zxing.client.android.R;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import com.google.zxing.ResultPoint;
import java.util.List;
import android.graphics.Rect;
import android.view.View;

public class ViewfinderView extends View
{
    protected static final long ANIMATION_DELAY = 80L;
    protected static final int CURRENT_POINT_OPACITY = 160;
    protected static final int MAX_RESULT_POINTS = 20;
    protected static final int POINT_SIZE = 6;
    protected static final int[] SCANNER_ALPHA;
    protected static final String TAG;
    protected CameraPreview cameraPreview;
    protected Rect framingRect;
    protected final int laserColor;
    protected List<ResultPoint> lastPossibleResultPoints;
    protected final int maskColor;
    protected final Paint paint;
    protected List<ResultPoint> possibleResultPoints;
    protected Rect previewFramingRect;
    protected Bitmap resultBitmap;
    protected final int resultColor;
    protected final int resultPointColor;
    protected int scannerAlpha;
    
    static {
        TAG = ViewfinderView.class.getSimpleName();
        SCANNER_ALPHA = new int[] { 0, 64, 128, 192, 255, 192, 128, 64 };
    }
    
    public ViewfinderView(final Context context, final AttributeSet set) {
        super(context, set);
        this.paint = new Paint(1);
        final Resources resources = this.getResources();
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, R.styleable.zxing_finder);
        this.maskColor = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R.color.zxing_viewfinder_mask));
        this.resultColor = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_result_view, resources.getColor(R.color.zxing_result_view));
        this.laserColor = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R.color.zxing_viewfinder_laser));
        this.resultPointColor = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R.color.zxing_possible_result_points));
        obtainStyledAttributes.recycle();
        this.scannerAlpha = 0;
        this.possibleResultPoints = new ArrayList<ResultPoint>(20);
        this.lastPossibleResultPoints = new ArrayList<ResultPoint>(20);
    }
    
    public void addPossibleResultPoint(final ResultPoint resultPoint) {
        if (this.possibleResultPoints.size() < 20) {
            this.possibleResultPoints.add(resultPoint);
        }
    }
    
    public void drawResultBitmap(final Bitmap resultBitmap) {
        this.resultBitmap = resultBitmap;
        this.invalidate();
    }
    
    public void drawViewfinder() {
        final Bitmap resultBitmap = this.resultBitmap;
        this.resultBitmap = null;
        if (resultBitmap != null) {
            resultBitmap.recycle();
        }
        this.invalidate();
    }
    
    public void onDraw(final Canvas canvas) {
        this.refreshSizes();
        if (this.framingRect == null || this.previewFramingRect == null) {
            return;
        }
        final Rect framingRect = this.framingRect;
        final Rect previewFramingRect = this.previewFramingRect;
        final int width = canvas.getWidth();
        final int height = canvas.getHeight();
        final Paint paint = this.paint;
        int color;
        if (this.resultBitmap != null) {
            color = this.resultColor;
        }
        else {
            color = this.maskColor;
        }
        paint.setColor(color);
        canvas.drawRect(0.0f, 0.0f, (float)width, (float)framingRect.top, this.paint);
        canvas.drawRect(0.0f, (float)framingRect.top, (float)framingRect.left, (float)(framingRect.bottom + 1), this.paint);
        canvas.drawRect((float)(framingRect.right + 1), (float)framingRect.top, (float)width, (float)(framingRect.bottom + 1), this.paint);
        canvas.drawRect(0.0f, (float)(framingRect.bottom + 1), (float)width, (float)height, this.paint);
        if (this.resultBitmap != null) {
            this.paint.setAlpha(160);
            canvas.drawBitmap(this.resultBitmap, (Rect)null, framingRect, this.paint);
            return;
        }
        this.paint.setColor(this.laserColor);
        this.paint.setAlpha(ViewfinderView.SCANNER_ALPHA[this.scannerAlpha]);
        this.scannerAlpha = (this.scannerAlpha + 1) % ViewfinderView.SCANNER_ALPHA.length;
        final int n = framingRect.height() / 2 + framingRect.top;
        canvas.drawRect((float)(framingRect.left + 2), (float)(n - 1), (float)(framingRect.right - 1), (float)(n + 2), this.paint);
        final float n2 = framingRect.width() / (float)previewFramingRect.width();
        final float n3 = framingRect.height() / (float)previewFramingRect.height();
        final int left = framingRect.left;
        final int top = framingRect.top;
        if (!this.lastPossibleResultPoints.isEmpty()) {
            this.paint.setAlpha(80);
            this.paint.setColor(this.resultPointColor);
            for (final ResultPoint resultPoint : this.lastPossibleResultPoints) {
                canvas.drawCircle((float)((int)(resultPoint.getX() * n2) + left), (float)((int)(resultPoint.getY() * n3) + top), 3.0f, this.paint);
            }
            this.lastPossibleResultPoints.clear();
        }
        if (!this.possibleResultPoints.isEmpty()) {
            this.paint.setAlpha(160);
            this.paint.setColor(this.resultPointColor);
            for (final ResultPoint resultPoint2 : this.possibleResultPoints) {
                canvas.drawCircle((float)((int)(resultPoint2.getX() * n2) + left), (float)((int)(resultPoint2.getY() * n3) + top), 6.0f, this.paint);
            }
            final List<ResultPoint> possibleResultPoints = this.possibleResultPoints;
            this.possibleResultPoints = this.lastPossibleResultPoints;
            this.lastPossibleResultPoints = possibleResultPoints;
            this.possibleResultPoints.clear();
        }
        this.postInvalidateDelayed(80L, framingRect.left - 6, framingRect.top - 6, framingRect.right + 6, framingRect.bottom + 6);
    }
    
    protected void refreshSizes() {
        if (this.cameraPreview != null) {
            final Rect framingRect = this.cameraPreview.getFramingRect();
            final Rect previewFramingRect = this.cameraPreview.getPreviewFramingRect();
            if (framingRect != null && previewFramingRect != null) {
                this.framingRect = framingRect;
                this.previewFramingRect = previewFramingRect;
            }
        }
    }
    
    public void setCameraPreview(final CameraPreview cameraPreview) {
        (this.cameraPreview = cameraPreview).addStateListener((CameraPreview.StateListener)new CameraPreview.StateListener() {
            @Override
            public void cameraClosed() {
            }
            
            @Override
            public void cameraError(final Exception ex) {
            }
            
            @Override
            public void previewSized() {
                ViewfinderView.this.refreshSizes();
                ViewfinderView.this.invalidate();
            }
            
            @Override
            public void previewStarted() {
            }
            
            @Override
            public void previewStopped() {
            }
        });
    }
}
