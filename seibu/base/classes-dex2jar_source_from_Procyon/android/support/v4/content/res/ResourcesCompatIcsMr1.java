// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.content.res;

import android.content.res.Resources$NotFoundException;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(15)
@RequiresApi(15)
class ResourcesCompatIcsMr1
{
    public static Drawable getDrawableForDensity(final Resources resources, final int n, final int n2) throws Resources$NotFoundException {
        return resources.getDrawableForDensity(n, n2);
    }
}
