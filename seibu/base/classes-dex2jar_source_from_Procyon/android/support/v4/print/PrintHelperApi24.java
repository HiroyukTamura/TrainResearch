// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.print;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(24)
@RequiresApi(24)
class PrintHelperApi24 extends PrintHelperApi23
{
    PrintHelperApi24(final Context context) {
        super(context);
        this.mIsMinMarginsHandlingCorrect = true;
        this.mPrintActivityRespectsOrientation = true;
    }
}
