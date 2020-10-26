// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer;

import com.rd.animation.data.Value;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.type.WormDrawer;
import com.rd.draw.drawer.type.ThinWormDrawer;
import com.rd.draw.drawer.type.SwapDrawer;
import com.rd.draw.drawer.type.SlideDrawer;
import com.rd.draw.drawer.type.ScaleDrawer;
import com.rd.draw.drawer.type.FillDrawer;
import com.rd.draw.drawer.type.DropDrawer;
import com.rd.draw.drawer.type.ColorDrawer;
import com.rd.draw.drawer.type.BasicDrawer;

public class Drawer
{
    private BasicDrawer basicDrawer;
    private ColorDrawer colorDrawer;
    private int coordinateX;
    private int coordinateY;
    private DropDrawer dropDrawer;
    private FillDrawer fillDrawer;
    private int position;
    private ScaleDrawer scaleDrawer;
    private SlideDrawer slideDrawer;
    private SwapDrawer swapDrawer;
    private ThinWormDrawer thinWormDrawer;
    private WormDrawer wormDrawer;
    
    public Drawer(@NonNull final Indicator indicator) {
        final Paint paint = new Paint();
        paint.setStyle(Paint$Style.FILL);
        paint.setAntiAlias(true);
        this.basicDrawer = new BasicDrawer(paint, indicator);
        this.colorDrawer = new ColorDrawer(paint, indicator);
        this.scaleDrawer = new ScaleDrawer(paint, indicator);
        this.wormDrawer = new WormDrawer(paint, indicator);
        this.slideDrawer = new SlideDrawer(paint, indicator);
        this.fillDrawer = new FillDrawer(paint, indicator);
        this.thinWormDrawer = new ThinWormDrawer(paint, indicator);
        this.dropDrawer = new DropDrawer(paint, indicator);
        this.swapDrawer = new SwapDrawer(paint, indicator);
    }
    
    public void drawBasic(@NonNull final Canvas canvas, final boolean b) {
        if (this.colorDrawer != null) {
            this.basicDrawer.draw(canvas, this.position, b, this.coordinateX, this.coordinateY);
        }
    }
    
    public void drawColor(@NonNull final Canvas canvas, @NonNull final Value value) {
        if (this.colorDrawer != null) {
            this.colorDrawer.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }
    
    public void drawDrop(@NonNull final Canvas canvas, @NonNull final Value value) {
        if (this.dropDrawer != null) {
            this.dropDrawer.draw(canvas, value, this.coordinateX, this.coordinateY);
        }
    }
    
    public void drawFill(@NonNull final Canvas canvas, @NonNull final Value value) {
        if (this.fillDrawer != null) {
            this.fillDrawer.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }
    
    public void drawScale(@NonNull final Canvas canvas, @NonNull final Value value) {
        if (this.scaleDrawer != null) {
            this.scaleDrawer.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }
    
    public void drawSlide(@NonNull final Canvas canvas, @NonNull final Value value) {
        if (this.slideDrawer != null) {
            this.slideDrawer.draw(canvas, value, this.coordinateX, this.coordinateY);
        }
    }
    
    public void drawSwap(@NonNull final Canvas canvas, @NonNull final Value value) {
        if (this.swapDrawer != null) {
            this.swapDrawer.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }
    
    public void drawThinWorm(@NonNull final Canvas canvas, @NonNull final Value value) {
        if (this.thinWormDrawer != null) {
            this.thinWormDrawer.draw(canvas, value, this.coordinateX, this.coordinateY);
        }
    }
    
    public void drawWorm(@NonNull final Canvas canvas, @NonNull final Value value) {
        if (this.wormDrawer != null) {
            this.wormDrawer.draw(canvas, value, this.coordinateX, this.coordinateY);
        }
    }
    
    public void setup(final int position, final int coordinateX, final int coordinateY) {
        this.position = position;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
}
