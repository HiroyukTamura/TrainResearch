// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.ResultMetadataType;
import java.util.Map;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import android.graphics.Paint;
import android.graphics.Canvas;
import com.google.zxing.Result;

public class BarcodeResult
{
    private static final float PREVIEW_DOT_WIDTH = 10.0f;
    private static final float PREVIEW_LINE_WIDTH = 4.0f;
    protected Result mResult;
    private final int mScaleFactor;
    protected SourceData sourceData;
    
    public BarcodeResult(final Result mResult, final SourceData sourceData) {
        this.mScaleFactor = 2;
        this.mResult = mResult;
        this.sourceData = sourceData;
    }
    
    private static void drawLine(final Canvas canvas, final Paint paint, final ResultPoint resultPoint, final ResultPoint resultPoint2, final int n) {
        if (resultPoint != null && resultPoint2 != null) {
            canvas.drawLine(resultPoint.getX() / n, resultPoint.getY() / n, resultPoint2.getX() / n, resultPoint2.getY() / n, paint);
        }
    }
    
    public BarcodeFormat getBarcodeFormat() {
        return this.mResult.getBarcodeFormat();
    }
    
    public Bitmap getBitmap() {
        return this.sourceData.getBitmap(2);
    }
    
    public int getBitmapScaleFactor() {
        return 2;
    }
    
    public Bitmap getBitmapWithResultPoints(int color) {
        final int n = 0;
        final Bitmap bitmap2;
        final Bitmap bitmap = bitmap2 = this.getBitmap();
        final ResultPoint[] resultPoints = this.mResult.getResultPoints();
        Bitmap bitmap3 = bitmap2;
        if (resultPoints != null) {
            bitmap3 = bitmap2;
            if (resultPoints.length > 0) {
                bitmap3 = bitmap2;
                if (bitmap != null) {
                    final Bitmap bitmap4 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap$Config.ARGB_8888);
                    final Canvas canvas = new Canvas(bitmap4);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint)null);
                    final Paint paint = new Paint();
                    paint.setColor(color);
                    if (resultPoints.length == 2) {
                        paint.setStrokeWidth(4.0f);
                        drawLine(canvas, paint, resultPoints[0], resultPoints[1], 2);
                        bitmap3 = bitmap4;
                    }
                    else {
                        if (resultPoints.length == 4 && (this.mResult.getBarcodeFormat() == BarcodeFormat.UPC_A || this.mResult.getBarcodeFormat() == BarcodeFormat.EAN_13)) {
                            drawLine(canvas, paint, resultPoints[0], resultPoints[1], 2);
                            drawLine(canvas, paint, resultPoints[2], resultPoints[3], 2);
                            return bitmap4;
                        }
                        paint.setStrokeWidth(10.0f);
                        final int length = resultPoints.length;
                        color = n;
                        while (true) {
                            bitmap3 = bitmap4;
                            if (color >= length) {
                                break;
                            }
                            final ResultPoint resultPoint = resultPoints[color];
                            if (resultPoint != null) {
                                canvas.drawPoint(resultPoint.getX() / 2.0f, resultPoint.getY() / 2.0f, paint);
                            }
                            ++color;
                        }
                    }
                }
            }
        }
        return bitmap3;
    }
    
    public byte[] getRawBytes() {
        return this.mResult.getRawBytes();
    }
    
    public Result getResult() {
        return this.mResult;
    }
    
    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.mResult.getResultMetadata();
    }
    
    public ResultPoint[] getResultPoints() {
        return this.mResult.getResultPoints();
    }
    
    public String getText() {
        return this.mResult.getText();
    }
    
    public long getTimestamp() {
        return this.mResult.getTimestamp();
    }
    
    @Override
    public String toString() {
        return this.mResult.getText();
    }
}
