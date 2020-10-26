/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 */
package androidx.constraintlayout.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

public class a {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(View object) {
        try {
            return object.getContext().getResources().getResourceEntryName(object.getId());
        }
        catch (Exception exception) {
            return "UNKNOWN";
        }
    }
}

