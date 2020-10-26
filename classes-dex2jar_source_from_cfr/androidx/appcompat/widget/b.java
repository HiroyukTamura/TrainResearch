/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

class b
extends Drawable {
    final ActionBarContainer a;

    public b(ActionBarContainer actionBarContainer) {
        this.a = actionBarContainer;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void draw(Canvas canvas) {
        block5 : {
            Drawable drawable2;
            block6 : {
                block4 : {
                    if (!this.a.d) break block4;
                    if (this.a.c == null) break block5;
                    drawable2 = this.a.c;
                    break block6;
                }
                if (this.a.a != null) {
                    this.a.a.draw(canvas);
                }
                if (this.a.b == null || !this.a.e) break block5;
                drawable2 = this.a.b;
            }
            drawable2.draw(canvas);
            return;
        }
    }

    public int getOpacity() {
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void getOutline(Outline outline) {
        block3 : {
            Drawable drawable2;
            block4 : {
                block2 : {
                    if (!this.a.d) break block2;
                    if (this.a.c == null) break block3;
                    drawable2 = this.a.c;
                    break block4;
                }
                if (this.a.a == null) break block3;
                drawable2 = this.a.a;
            }
            drawable2.getOutline(outline);
            return;
        }
    }

    public void setAlpha(int n2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

