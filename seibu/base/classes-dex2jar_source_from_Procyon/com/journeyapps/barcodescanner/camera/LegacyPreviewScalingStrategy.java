// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.journeyapps.barcodescanner.Size;

public class LegacyPreviewScalingStrategy extends PreviewScalingStrategy
{
    private static final String TAG;
    
    static {
        TAG = LegacyPreviewScalingStrategy.class.getSimpleName();
    }
    
    public static Size scale(Size size, final Size size2) {
        Size size3 = size;
        if (!size2.fitsIn(size)) {
            while (true) {
                final Size scale = size.scale(3, 2);
                size = size.scale(2, 1);
                if (size2.fitsIn(scale)) {
                    return scale;
                }
                if (size2.fitsIn(size)) {
                    return size;
                }
            }
        }
        else {
            Size scale2 = null;
            Label_0049: {
                break Label_0049;
                do {
                    size3 = size;
                    scale2 = size3.scale(2, 3);
                    size = size3.scale(1, 2);
                } while (size2.fitsIn(size));
            }
            if (size2.fitsIn(scale2)) {
                return scale2;
            }
            return size3;
        }
    }
    
    @Override
    public Size getBestPreviewSize(final List<Size> list, final Size obj) {
        if (obj == null) {
            return list.get(0);
        }
        Collections.sort((List<Object>)list, (Comparator<? super Object>)new Comparator<Size>() {
            @Override
            public int compare(final Size size, final Size size2) {
                final int n = -1;
                final int n2 = LegacyPreviewScalingStrategy.scale(size, obj).width - size.width;
                final int n3 = LegacyPreviewScalingStrategy.scale(size2, obj).width - size2.width;
                int compareTo;
                if (n2 == 0 && n3 == 0) {
                    compareTo = size.compareTo(size2);
                }
                else {
                    compareTo = n;
                    if (n2 != 0) {
                        if (n3 == 0) {
                            return 1;
                        }
                        if (n2 < 0 && n3 < 0) {
                            return size.compareTo(size2);
                        }
                        if (n2 > 0 && n3 > 0) {
                            return -size.compareTo(size2);
                        }
                        compareTo = n;
                        if (n2 >= 0) {
                            return 1;
                        }
                    }
                }
                return compareTo;
            }
        });
        Log.i(LegacyPreviewScalingStrategy.TAG, "Viewfinder size: " + obj);
        Log.i(LegacyPreviewScalingStrategy.TAG, "Preview in order of preference: " + list);
        return list.get(0);
    }
    
    @Override
    public Rect scalePreview(final Size obj, final Size obj2) {
        final Size scale = scale(obj, obj2);
        Log.i(LegacyPreviewScalingStrategy.TAG, "Preview: " + obj + "; Scaled: " + scale + "; Want: " + obj2);
        final int n = (scale.width - obj2.width) / 2;
        final int n2 = (scale.height - obj2.height) / 2;
        return new Rect(-n, -n2, scale.width - n, scale.height - n2);
    }
}
