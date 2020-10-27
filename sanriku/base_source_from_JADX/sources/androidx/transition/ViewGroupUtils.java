package androidx.transition;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

class ViewGroupUtils {
    private ViewGroupUtils() {
    }

    static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        ViewGroupUtilsApi18.suppressLayout(viewGroup, z);
    }
}
