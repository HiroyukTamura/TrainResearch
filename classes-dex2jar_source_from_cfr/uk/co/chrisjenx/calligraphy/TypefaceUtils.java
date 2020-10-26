/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  android.util.Log
 */
package uk.co.chrisjenx.calligraphy;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import uk.co.chrisjenx.calligraphy.CalligraphyTypefaceSpan;

public final class TypefaceUtils {
    private static final Map<String, Typeface> sCachedFonts = new HashMap<String, Typeface>();
    private static final Map<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap<Typeface, CalligraphyTypefaceSpan>();

    private TypefaceUtils() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static CalligraphyTypefaceSpan getSpan(Typeface object) {
        if (object == null) {
            return null;
        }
        Map<Typeface, CalligraphyTypefaceSpan> map = sCachedSpans;
        synchronized (map) {
            if (sCachedSpans.containsKey(object)) return sCachedSpans.get(object);
            CalligraphyTypefaceSpan calligraphyTypefaceSpan = new CalligraphyTypefaceSpan((Typeface)object);
            sCachedSpans.put((Typeface)object, calligraphyTypefaceSpan);
            return calligraphyTypefaceSpan;
        }
    }

    public static boolean isLoaded(Typeface typeface) {
        return typeface != null && sCachedFonts.containsValue((Object)typeface);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Typeface load(AssetManager assetManager, String string2) {
        Map<String, Typeface> map = sCachedFonts;
        synchronized (map) {
            try {
                try {
                    if (sCachedFonts.containsKey(string2)) return sCachedFonts.get(string2);
                    assetManager = Typeface.createFromAsset((AssetManager)assetManager, (String)string2);
                    sCachedFonts.put(string2, (Typeface)assetManager);
                    return assetManager;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Can't create asset from ");
                    stringBuilder.append(string2);
                    stringBuilder.append(". Make sure you have passed in the correct path and file name.");
                    Log.w((String)"Calligraphy", (String)stringBuilder.toString(), (Throwable)exception);
                    sCachedFonts.put(string2, null);
                    return null;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}

