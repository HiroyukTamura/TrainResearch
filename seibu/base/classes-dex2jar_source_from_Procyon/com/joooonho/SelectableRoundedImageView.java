// 
// Decompiled by Procyon v0.5.36
// 

package com.joooonho;

import android.graphics.ColorFilter;
import android.graphics.Path$Direction;
import android.graphics.drawable.LayerDrawable;
import android.graphics.Bitmap$Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Rect;
import android.graphics.Matrix$ScaleToFit;
import android.graphics.Matrix;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.Paint$Style;
import android.graphics.Shader$TileMode;
import android.graphics.Path;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Paint;
import android.net.Uri;
import android.graphics.Bitmap;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.util.Log;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.content.res.ColorStateList;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;

public class SelectableRoundedImageView extends ImageView
{
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final String TAG = "SelectableRoundedImageView";
    private static final ImageView$ScaleType[] sScaleTypeArray;
    private boolean isOval;
    private ColorStateList mBorderColor;
    private float mBorderWidth;
    private Drawable mDrawable;
    private float mLeftBottomCornerRadius;
    private float mLeftTopCornerRadius;
    private float[] mRadii;
    private int mResource;
    private float mRightBottomCornerRadius;
    private float mRightTopCornerRadius;
    private ImageView$ScaleType mScaleType;
    
    static {
        sScaleTypeArray = new ImageView$ScaleType[] { ImageView$ScaleType.MATRIX, ImageView$ScaleType.FIT_XY, ImageView$ScaleType.FIT_START, ImageView$ScaleType.FIT_CENTER, ImageView$ScaleType.FIT_END, ImageView$ScaleType.CENTER, ImageView$ScaleType.CENTER_CROP, ImageView$ScaleType.CENTER_INSIDE };
    }
    
    public SelectableRoundedImageView(final Context context) {
        super(context);
        this.mResource = 0;
        this.mScaleType = ImageView$ScaleType.FIT_CENTER;
        this.mLeftTopCornerRadius = 0.0f;
        this.mRightTopCornerRadius = 0.0f;
        this.mLeftBottomCornerRadius = 0.0f;
        this.mRightBottomCornerRadius = 0.0f;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = ColorStateList.valueOf(-16777216);
        this.isOval = false;
        this.mRadii = new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
    }
    
    public SelectableRoundedImageView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public SelectableRoundedImageView(final Context context, final AttributeSet set, int int1) {
        super(context, set, int1);
        this.mResource = 0;
        this.mScaleType = ImageView$ScaleType.FIT_CENTER;
        this.mLeftTopCornerRadius = 0.0f;
        this.mRightTopCornerRadius = 0.0f;
        this.mLeftBottomCornerRadius = 0.0f;
        this.mRightBottomCornerRadius = 0.0f;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = ColorStateList.valueOf(-16777216);
        this.isOval = false;
        this.mRadii = new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.SelectableRoundedImageView, int1, 0);
        int1 = obtainStyledAttributes.getInt(R.styleable.SelectableRoundedImageView_android_scaleType, -1);
        if (int1 >= 0) {
            this.setScaleType(SelectableRoundedImageView.sScaleTypeArray[int1]);
        }
        this.mLeftTopCornerRadius = (float)obtainStyledAttributes.getDimensionPixelSize(R.styleable.SelectableRoundedImageView_sriv_left_top_corner_radius, 0);
        this.mRightTopCornerRadius = (float)obtainStyledAttributes.getDimensionPixelSize(R.styleable.SelectableRoundedImageView_sriv_right_top_corner_radius, 0);
        this.mLeftBottomCornerRadius = (float)obtainStyledAttributes.getDimensionPixelSize(R.styleable.SelectableRoundedImageView_sriv_left_bottom_corner_radius, 0);
        this.mRightBottomCornerRadius = (float)obtainStyledAttributes.getDimensionPixelSize(R.styleable.SelectableRoundedImageView_sriv_right_bottom_corner_radius, 0);
        if (this.mLeftTopCornerRadius < 0.0f || this.mRightTopCornerRadius < 0.0f || this.mLeftBottomCornerRadius < 0.0f || this.mRightBottomCornerRadius < 0.0f) {
            throw new IllegalArgumentException("radius values cannot be negative.");
        }
        this.mRadii = new float[] { this.mLeftTopCornerRadius, this.mLeftTopCornerRadius, this.mRightTopCornerRadius, this.mRightTopCornerRadius, this.mRightBottomCornerRadius, this.mRightBottomCornerRadius, this.mLeftBottomCornerRadius, this.mLeftBottomCornerRadius };
        this.mBorderWidth = (float)obtainStyledAttributes.getDimensionPixelSize(R.styleable.SelectableRoundedImageView_sriv_border_width, 0);
        if (this.mBorderWidth < 0.0f) {
            throw new IllegalArgumentException("border width cannot be negative.");
        }
        this.mBorderColor = obtainStyledAttributes.getColorStateList(R.styleable.SelectableRoundedImageView_sriv_border_color);
        if (this.mBorderColor == null) {
            this.mBorderColor = ColorStateList.valueOf(-16777216);
        }
        this.isOval = obtainStyledAttributes.getBoolean(R.styleable.SelectableRoundedImageView_sriv_oval, false);
        obtainStyledAttributes.recycle();
        this.updateDrawable();
    }
    
    private Drawable resolveResource() {
        final Resources resources = this.getResources();
        if (resources == null) {
            return null;
        }
        Drawable drawable = null;
        Label_0031: {
            if (this.mResource == 0) {
                break Label_0031;
            }
            try {
                drawable = resources.getDrawable(this.mResource);
                return SelectableRoundedCornerDrawable.fromDrawable(drawable, this.getResources());
            }
            catch (Resources$NotFoundException ex) {
                Log.w("SelectableRoundedImageView", "Unable to find resource: " + this.mResource, (Throwable)ex);
                this.mResource = 0;
                drawable = drawable;
                return SelectableRoundedCornerDrawable.fromDrawable(drawable, this.getResources());
            }
        }
    }
    
    private void updateDrawable() {
        if (this.mDrawable == null) {
            return;
        }
        ((SelectableRoundedCornerDrawable)this.mDrawable).setScaleType(this.mScaleType);
        ((SelectableRoundedCornerDrawable)this.mDrawable).setCornerRadii(this.mRadii);
        ((SelectableRoundedCornerDrawable)this.mDrawable).setBorderWidth(this.mBorderWidth);
        ((SelectableRoundedCornerDrawable)this.mDrawable).setBorderColor(this.mBorderColor);
        ((SelectableRoundedCornerDrawable)this.mDrawable).setOval(this.isOval);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.invalidate();
    }
    
    public int getBorderColor() {
        return this.mBorderColor.getDefaultColor();
    }
    
    public ColorStateList getBorderColors() {
        return this.mBorderColor;
    }
    
    public float getBorderWidth() {
        return this.mBorderWidth;
    }
    
    public float getCornerRadius() {
        return this.mLeftTopCornerRadius;
    }
    
    public ImageView$ScaleType getScaleType() {
        return this.mScaleType;
    }
    
    public boolean isOval() {
        return this.isOval;
    }
    
    public void setBorderColor(final int n) {
        this.setBorderColor(ColorStateList.valueOf(n));
    }
    
    public void setBorderColor(ColorStateList value) {
        if (!this.mBorderColor.equals(value)) {
            if (value == null) {
                value = ColorStateList.valueOf(-16777216);
            }
            this.mBorderColor = value;
            this.updateDrawable();
            if (this.mBorderWidth > 0.0f) {
                this.invalidate();
            }
        }
    }
    
    public void setBorderWidthDP(float mBorderWidth) {
        mBorderWidth *= this.getResources().getDisplayMetrics().density;
        if (this.mBorderWidth == mBorderWidth) {
            return;
        }
        this.mBorderWidth = mBorderWidth;
        this.updateDrawable();
        this.invalidate();
    }
    
    public void setCornerRadiiDP(float n, float n2, float n3, float n4) {
        final float density = this.getResources().getDisplayMetrics().density;
        n *= density;
        n2 *= density;
        n3 *= density;
        n4 *= density;
        this.mRadii = new float[] { n, n, n2, n2, n4, n4, n3, n3 };
        this.updateDrawable();
    }
    
    public void setImageBitmap(final Bitmap bitmap) {
        this.mResource = 0;
        super.setImageDrawable(this.mDrawable = SelectableRoundedCornerDrawable.fromBitmap(bitmap, this.getResources()));
        this.updateDrawable();
    }
    
    public void setImageDrawable(final Drawable drawable) {
        this.mResource = 0;
        super.setImageDrawable(this.mDrawable = SelectableRoundedCornerDrawable.fromDrawable(drawable, this.getResources()));
        this.updateDrawable();
    }
    
    public void setImageResource(final int mResource) {
        if (this.mResource != mResource) {
            this.mResource = mResource;
            super.setImageDrawable(this.mDrawable = this.resolveResource());
            this.updateDrawable();
        }
    }
    
    public void setImageURI(final Uri imageURI) {
        super.setImageURI(imageURI);
        this.setImageDrawable(this.getDrawable());
    }
    
    public void setOval(final boolean isOval) {
        this.isOval = isOval;
        this.updateDrawable();
        this.invalidate();
    }
    
    public void setScaleType(final ImageView$ScaleType imageView$ScaleType) {
        super.setScaleType(imageView$ScaleType);
        this.mScaleType = imageView$ScaleType;
        this.updateDrawable();
    }
    
    static class SelectableRoundedCornerDrawable extends Drawable
    {
        private static final int DEFAULT_BORDER_COLOR = -16777216;
        private static final String TAG = "SelectableRoundedCornerDrawable";
        private Bitmap mBitmap;
        private final int mBitmapHeight;
        private final Paint mBitmapPaint;
        private final RectF mBitmapRect;
        private BitmapShader mBitmapShader;
        private final int mBitmapWidth;
        private RectF mBorderBounds;
        private ColorStateList mBorderColor;
        private final Paint mBorderPaint;
        private float[] mBorderRadii;
        private float mBorderWidth;
        private RectF mBounds;
        private boolean mBoundsConfigured;
        private boolean mOval;
        private Path mPath;
        private float[] mRadii;
        private ImageView$ScaleType mScaleType;
        
        public SelectableRoundedCornerDrawable(final Bitmap mBitmap, final Resources resources) {
            this.mBounds = new RectF();
            this.mBorderBounds = new RectF();
            this.mBitmapRect = new RectF();
            this.mRadii = new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
            this.mBorderRadii = new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
            this.mOval = false;
            this.mBorderWidth = 0.0f;
            this.mBorderColor = ColorStateList.valueOf(-16777216);
            this.mScaleType = ImageView$ScaleType.FIT_CENTER;
            this.mPath = new Path();
            this.mBoundsConfigured = false;
            this.mBitmap = mBitmap;
            this.mBitmapShader = new BitmapShader(mBitmap, Shader$TileMode.CLAMP, Shader$TileMode.CLAMP);
            if (mBitmap != null) {
                this.mBitmapWidth = mBitmap.getScaledWidth(resources.getDisplayMetrics());
                this.mBitmapHeight = mBitmap.getScaledHeight(resources.getDisplayMetrics());
            }
            else {
                this.mBitmapHeight = -1;
                this.mBitmapWidth = -1;
            }
            this.mBitmapRect.set(0.0f, 0.0f, (float)this.mBitmapWidth, (float)this.mBitmapHeight);
            (this.mBitmapPaint = new Paint(1)).setStyle(Paint$Style.FILL);
            this.mBitmapPaint.setShader((Shader)this.mBitmapShader);
            (this.mBorderPaint = new Paint(1)).setStyle(Paint$Style.STROKE);
            this.mBorderPaint.setColor(this.mBorderColor.getColorForState(this.getState(), -16777216));
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        }
        
        private void adjustBorderWidthAndBorderBounds(final Canvas canvas) {
            final Matrix matrix = canvas.getMatrix();
            final float[] array = new float[9];
            matrix.getValues(array);
            this.mBorderWidth = this.mBorderWidth * this.mBounds.width() / (this.mBounds.width() * array[0] - this.mBorderWidth * 2.0f);
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderBounds.set(this.mBounds);
            this.mBorderBounds.inset(-this.mBorderWidth / 2.0f, -this.mBorderWidth / 2.0f);
        }
        
        private void adjustCanvasForBorder(final Canvas canvas) {
            final Matrix matrix = canvas.getMatrix();
            final float[] array = new float[9];
            matrix.getValues(array);
            final float n = array[0];
            final float n2 = array[4];
            final float n3 = array[2];
            final float n4 = array[5];
            final float n5 = this.mBounds.width() / (this.mBounds.width() + this.mBorderWidth + this.mBorderWidth);
            final float n6 = this.mBounds.height() / (this.mBounds.height() + this.mBorderWidth + this.mBorderWidth);
            canvas.scale(n5, n6);
            if (ImageView$ScaleType.FIT_START == this.mScaleType || ImageView$ScaleType.FIT_END == this.mScaleType || ImageView$ScaleType.FIT_XY == this.mScaleType || ImageView$ScaleType.FIT_CENTER == this.mScaleType || ImageView$ScaleType.CENTER_INSIDE == this.mScaleType || ImageView$ScaleType.MATRIX == this.mScaleType) {
                canvas.translate(this.mBorderWidth, this.mBorderWidth);
            }
            else if (ImageView$ScaleType.CENTER == this.mScaleType || ImageView$ScaleType.CENTER_CROP == this.mScaleType) {
                canvas.translate(-n3 / (n5 * n), -n4 / (n6 * n2));
                canvas.translate(-(this.mBounds.left - this.mBorderWidth), -(this.mBounds.top - this.mBorderWidth));
            }
        }
        
        private void applyScaleToRadii(final Matrix matrix) {
            final float[] array = new float[9];
            matrix.getValues(array);
            for (int i = 0; i < this.mRadii.length; ++i) {
                this.mRadii[i] /= array[0];
            }
        }
        
        private void configureBounds(final Canvas canvas) {
            final Rect clipBounds = canvas.getClipBounds();
            final Matrix matrix = canvas.getMatrix();
            if (ImageView$ScaleType.CENTER == this.mScaleType) {
                this.mBounds.set(clipBounds);
            }
            else {
                if (ImageView$ScaleType.CENTER_CROP == this.mScaleType) {
                    this.applyScaleToRadii(matrix);
                    this.mBounds.set(clipBounds);
                    return;
                }
                if (ImageView$ScaleType.FIT_XY == this.mScaleType) {
                    final Matrix localMatrix = new Matrix();
                    localMatrix.setRectToRect(this.mBitmapRect, new RectF(clipBounds), Matrix$ScaleToFit.FILL);
                    this.mBitmapShader.setLocalMatrix(localMatrix);
                    this.mBounds.set(clipBounds);
                    return;
                }
                if (ImageView$ScaleType.FIT_START == this.mScaleType || ImageView$ScaleType.FIT_END == this.mScaleType || ImageView$ScaleType.FIT_CENTER == this.mScaleType || ImageView$ScaleType.CENTER_INSIDE == this.mScaleType) {
                    this.applyScaleToRadii(matrix);
                    this.mBounds.set(this.mBitmapRect);
                    return;
                }
                if (ImageView$ScaleType.MATRIX == this.mScaleType) {
                    this.applyScaleToRadii(matrix);
                    this.mBounds.set(this.mBitmapRect);
                }
            }
        }
        
        public static Bitmap drawableToBitmap(final Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable)drawable).getBitmap();
            }
            final int max = Math.max(drawable.getIntrinsicWidth(), 2);
            final int max2 = Math.max(drawable.getIntrinsicHeight(), 2);
            try {
                final Bitmap bitmap = Bitmap.createBitmap(max, max2, Bitmap$Config.ARGB_8888);
                final Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return bitmap;
            }
            catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        public static SelectableRoundedCornerDrawable fromBitmap(final Bitmap bitmap, final Resources resources) {
            if (bitmap != null) {
                return new SelectableRoundedCornerDrawable(bitmap, resources);
            }
            return null;
        }
        
        public static Drawable fromDrawable(final Drawable drawable, final Resources resources) {
            if (drawable == null || drawable instanceof SelectableRoundedCornerDrawable) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                final LayerDrawable layerDrawable = (LayerDrawable)drawable;
                for (int numberOfLayers = layerDrawable.getNumberOfLayers(), i = 0; i < numberOfLayers; ++i) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), fromDrawable(layerDrawable.getDrawable(i), resources));
                }
                return (Drawable)layerDrawable;
            }
            final Bitmap drawableToBitmap = drawableToBitmap(drawable);
            if (drawableToBitmap != null) {
                return new SelectableRoundedCornerDrawable(drawableToBitmap, resources);
            }
            Log.w("SelectableRoundedCornerDrawable", "Failed to create bitmap from drawable!");
            return drawable;
        }
        
        private void setBorderRadii() {
            for (int i = 0; i < this.mRadii.length; ++i) {
                if (this.mRadii[i] > 0.0f) {
                    this.mBorderRadii[i] = this.mRadii[i];
                    this.mRadii[i] -= this.mBorderWidth;
                }
            }
        }
        
        public void draw(final Canvas canvas) {
            canvas.save();
            if (!this.mBoundsConfigured) {
                this.configureBounds(canvas);
                if (this.mBorderWidth > 0.0f) {
                    this.adjustBorderWidthAndBorderBounds(canvas);
                    this.setBorderRadii();
                }
                this.mBoundsConfigured = true;
            }
            if (this.mOval) {
                if (this.mBorderWidth > 0.0f) {
                    this.adjustCanvasForBorder(canvas);
                    this.mPath.addOval(this.mBounds, Path$Direction.CW);
                    canvas.drawPath(this.mPath, this.mBitmapPaint);
                    this.mPath.reset();
                    this.mPath.addOval(this.mBorderBounds, Path$Direction.CW);
                    canvas.drawPath(this.mPath, this.mBorderPaint);
                }
                else {
                    this.mPath.addOval(this.mBounds, Path$Direction.CW);
                    canvas.drawPath(this.mPath, this.mBitmapPaint);
                }
            }
            else if (this.mBorderWidth > 0.0f) {
                this.adjustCanvasForBorder(canvas);
                this.mPath.addRoundRect(this.mBounds, this.mRadii, Path$Direction.CW);
                canvas.drawPath(this.mPath, this.mBitmapPaint);
                this.mPath.reset();
                this.mPath.addRoundRect(this.mBorderBounds, this.mBorderRadii, Path$Direction.CW);
                canvas.drawPath(this.mPath, this.mBorderPaint);
            }
            else {
                this.mPath.addRoundRect(this.mBounds, this.mRadii, Path$Direction.CW);
                canvas.drawPath(this.mPath, this.mBitmapPaint);
            }
            canvas.restore();
        }
        
        public int getBorderColor() {
            return this.mBorderColor.getDefaultColor();
        }
        
        public ColorStateList getBorderColors() {
            return this.mBorderColor;
        }
        
        public float getBorderWidth() {
            return this.mBorderWidth;
        }
        
        public int getIntrinsicHeight() {
            return this.mBitmapHeight;
        }
        
        public int getIntrinsicWidth() {
            return this.mBitmapWidth;
        }
        
        public int getOpacity() {
            if (this.mBitmap == null || this.mBitmap.hasAlpha() || this.mBitmapPaint.getAlpha() < 255) {
                return -3;
            }
            return -1;
        }
        
        public ImageView$ScaleType getScaleType() {
            return this.mScaleType;
        }
        
        public boolean isOval() {
            return this.mOval;
        }
        
        public boolean isStateful() {
            return this.mBorderColor.isStateful();
        }
        
        protected boolean onStateChange(final int[] array) {
            final int colorForState = this.mBorderColor.getColorForState(array, 0);
            if (this.mBorderPaint.getColor() != colorForState) {
                this.mBorderPaint.setColor(colorForState);
                return true;
            }
            return super.onStateChange(array);
        }
        
        public void setAlpha(final int alpha) {
            this.mBitmapPaint.setAlpha(alpha);
            this.invalidateSelf();
        }
        
        public void setBorderColor(final int n) {
            this.setBorderColor(ColorStateList.valueOf(n));
        }
        
        public void setBorderColor(final ColorStateList mBorderColor) {
            if (mBorderColor == null) {
                this.mBorderWidth = 0.0f;
                this.mBorderColor = ColorStateList.valueOf(0);
                this.mBorderPaint.setColor(0);
                return;
            }
            this.mBorderColor = mBorderColor;
            this.mBorderPaint.setColor(this.mBorderColor.getColorForState(this.getState(), -16777216));
        }
        
        public void setBorderWidth(final float n) {
            this.mBorderWidth = n;
            this.mBorderPaint.setStrokeWidth(n);
        }
        
        public void setColorFilter(final ColorFilter colorFilter) {
            this.mBitmapPaint.setColorFilter(colorFilter);
            this.invalidateSelf();
        }
        
        public void setCornerRadii(final float[] array) {
            if (array != null) {
                if (array.length != 8) {
                    throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
                }
                for (int i = 0; i < array.length; ++i) {
                    this.mRadii[i] = array[i];
                }
            }
        }
        
        public void setDither(final boolean dither) {
            this.mBitmapPaint.setDither(dither);
            this.invalidateSelf();
        }
        
        public void setFilterBitmap(final boolean filterBitmap) {
            this.mBitmapPaint.setFilterBitmap(filterBitmap);
            this.invalidateSelf();
        }
        
        public void setOval(final boolean mOval) {
            this.mOval = mOval;
        }
        
        public void setScaleType(final ImageView$ScaleType mScaleType) {
            if (mScaleType == null) {
                return;
            }
            this.mScaleType = mScaleType;
        }
    }
}
