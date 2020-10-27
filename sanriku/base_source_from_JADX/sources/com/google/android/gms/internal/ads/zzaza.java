package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaza {
    public static Point zza(MotionEvent motionEvent, @Nullable View view) {
        int[] zzt = zzt(view);
        return new Point(((int) motionEvent.getRawX()) - zzt[0], ((int) motionEvent.getRawY()) - zzt[1]);
    }

    @Nullable
    private static JSONObject zza(Context context, Point point, Point point2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", zzb(context, point2.x));
            jSONObject.put("y", zzb(context, point2.y));
            jSONObject.put("start_x", zzb(context, point.x));
            jSONObject.put("start_y", zzb(context, point.y));
            return jSONObject;
        } catch (JSONException e) {
            zzazw.zzc("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    private static JSONObject zza(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzb(context, rect.right - rect.left));
        jSONObject.put("height", zzb(context, rect.bottom - rect.top));
        jSONObject.put("x", zzb(context, rect.left));
        jSONObject.put("y", zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce A[Catch:{ JSONException -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00de A[Catch:{ JSONException -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f6 A[Catch:{ JSONException -> 0x00fa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zza(android.content.Context r12, @androidx.annotation.Nullable android.view.View r13) {
        /*
            java.lang.String r0 = "window"
            java.lang.String r1 = "relative_to"
            java.lang.String r2 = "y"
            java.lang.String r3 = "x"
            java.lang.String r4 = "height"
            java.lang.String r5 = "width"
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            if (r13 != 0) goto L_0x0014
            return r6
        L_0x0014:
            r7 = 1
            r8 = 0
            int[] r9 = zzt(r13)     // Catch:{ Exception -> 0x0086 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0086 }
            r10.<init>()     // Catch:{ Exception -> 0x0086 }
            int r11 = r13.getMeasuredWidth()     // Catch:{ Exception -> 0x0086 }
            int r11 = zzb((android.content.Context) r12, (int) r11)     // Catch:{ Exception -> 0x0086 }
            r10.put(r5, r11)     // Catch:{ Exception -> 0x0086 }
            int r11 = r13.getMeasuredHeight()     // Catch:{ Exception -> 0x0086 }
            int r11 = zzb((android.content.Context) r12, (int) r11)     // Catch:{ Exception -> 0x0086 }
            r10.put(r4, r11)     // Catch:{ Exception -> 0x0086 }
            r11 = r9[r8]     // Catch:{ Exception -> 0x0086 }
            int r11 = zzb((android.content.Context) r12, (int) r11)     // Catch:{ Exception -> 0x0086 }
            r10.put(r3, r11)     // Catch:{ Exception -> 0x0086 }
            r11 = r9[r7]     // Catch:{ Exception -> 0x0086 }
            int r11 = zzb((android.content.Context) r12, (int) r11)     // Catch:{ Exception -> 0x0086 }
            r10.put(r2, r11)     // Catch:{ Exception -> 0x0086 }
            r10.put(r1, r0)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r11 = "frame"
            r6.put(r11, r10)     // Catch:{ Exception -> 0x0086 }
            android.graphics.Rect r10 = new android.graphics.Rect     // Catch:{ Exception -> 0x0086 }
            r10.<init>()     // Catch:{ Exception -> 0x0086 }
            boolean r11 = r13.getGlobalVisibleRect(r10)     // Catch:{ Exception -> 0x0086 }
            if (r11 == 0) goto L_0x005f
            org.json.JSONObject r12 = zza((android.content.Context) r12, (android.graphics.Rect) r10)     // Catch:{ Exception -> 0x0086 }
            goto L_0x0080
        L_0x005f:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0086 }
            r10.<init>()     // Catch:{ Exception -> 0x0086 }
            r10.put(r5, r8)     // Catch:{ Exception -> 0x0086 }
            r10.put(r4, r8)     // Catch:{ Exception -> 0x0086 }
            r4 = r9[r8]     // Catch:{ Exception -> 0x0086 }
            int r4 = zzb((android.content.Context) r12, (int) r4)     // Catch:{ Exception -> 0x0086 }
            r10.put(r3, r4)     // Catch:{ Exception -> 0x0086 }
            r3 = r9[r7]     // Catch:{ Exception -> 0x0086 }
            int r12 = zzb((android.content.Context) r12, (int) r3)     // Catch:{ Exception -> 0x0086 }
            r10.put(r2, r12)     // Catch:{ Exception -> 0x0086 }
            r10.put(r1, r0)     // Catch:{ Exception -> 0x0086 }
            r12 = r10
        L_0x0080:
            java.lang.String r0 = "visible_bounds"
            r6.put(r0, r12)     // Catch:{ Exception -> 0x0086 }
            goto L_0x008b
        L_0x0086:
            java.lang.String r12 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.ads.zzazw.zzfc(r12)
        L_0x008b:
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzzz.zzctb
            com.google.android.gms.internal.ads.zzzv r0 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r12 = r0.zzd(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0100
            android.view.ViewParent r12 = r13.getParent()
            if (r12 == 0) goto L_0x00c2
            java.lang.Class r13 = r12.getClass()     // Catch:{ NoSuchMethodException -> 0x00c2, SecurityException -> 0x00bc, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b8 }
            java.lang.String r0 = "getTemplateTypeName"
            java.lang.Class[] r1 = new java.lang.Class[r8]     // Catch:{ NoSuchMethodException -> 0x00c2, SecurityException -> 0x00bc, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b8 }
            java.lang.reflect.Method r13 = r13.getMethod(r0, r1)     // Catch:{ NoSuchMethodException -> 0x00c2, SecurityException -> 0x00bc, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b8 }
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ NoSuchMethodException -> 0x00c2, SecurityException -> 0x00bc, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b8 }
            java.lang.Object r12 = r13.invoke(r12, r0)     // Catch:{ NoSuchMethodException -> 0x00c2, SecurityException -> 0x00bc, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b8 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ NoSuchMethodException -> 0x00c2, SecurityException -> 0x00bc, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b8 }
            goto L_0x00c4
        L_0x00b8:
            r12 = move-exception
            goto L_0x00bd
        L_0x00ba:
            r12 = move-exception
            goto L_0x00bd
        L_0x00bc:
            r12 = move-exception
        L_0x00bd:
            java.lang.String r13 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.internal.ads.zzazw.zzc(r13, r12)
        L_0x00c2:
            java.lang.String r12 = ""
        L_0x00c4:
            r13 = -1
            int r0 = r12.hashCode()     // Catch:{ JSONException -> 0x00fa }
            r1 = -2066603854(0xffffffff84d220b2, float:-4.940079E-36)
            if (r0 == r1) goto L_0x00de
            r1 = 2019754500(0x78630204, float:1.8417067E34)
            if (r0 == r1) goto L_0x00d4
            goto L_0x00e7
        L_0x00d4:
            java.lang.String r0 = "medium_template"
            boolean r12 = r12.equals(r0)     // Catch:{ JSONException -> 0x00fa }
            if (r12 == 0) goto L_0x00e7
            r13 = 1
            goto L_0x00e7
        L_0x00de:
            java.lang.String r0 = "small_template"
            boolean r12 = r12.equals(r0)     // Catch:{ JSONException -> 0x00fa }
            if (r12 == 0) goto L_0x00e7
            r13 = 0
        L_0x00e7:
            java.lang.String r12 = "native_template_type"
            if (r13 == 0) goto L_0x00f6
            if (r13 == r7) goto L_0x00f1
            r6.put(r12, r8)     // Catch:{ JSONException -> 0x00fa }
            goto L_0x0100
        L_0x00f1:
            r13 = 2
            r6.put(r12, r13)     // Catch:{ JSONException -> 0x00fa }
            goto L_0x0100
        L_0x00f6:
            r6.put(r12, r7)     // Catch:{ JSONException -> 0x00fa }
            goto L_0x0100
        L_0x00fa:
            r12 = move-exception
            java.lang.String r13 = "Could not log native template signal to JSON"
            com.google.android.gms.internal.ads.zzazw.zzc(r13, r12)
        L_0x0100:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaza.zza(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static JSONObject zza(Context context, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, @Nullable View view) {
        String str;
        String str2;
        JSONObject jSONObject;
        Context context2 = context;
        Map<String, WeakReference<View>> map3 = map2;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (!(map == null || view == null)) {
            int[] zzt = zzt(view);
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                View view2 = (View) ((WeakReference) next.getValue()).get();
                if (view2 != null) {
                    int[] zzt2 = zzt(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator<Map.Entry<String, WeakReference<View>>> it2 = it;
                    try {
                        jSONObject4.put("width", zzb(context2, view2.getMeasuredWidth()));
                        jSONObject4.put("height", zzb(context2, view2.getMeasuredHeight()));
                        jSONObject4.put("x", zzb(context2, zzt2[0] - zzt[0]));
                        jSONObject4.put("y", zzb(context2, zzt2[1] - zzt[1]));
                        jSONObject4.put(str4, str3);
                        jSONObject3.put("frame", jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = zza(context2, rect);
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put("width", 0);
                            jSONObject.put("height", 0);
                            jSONObject.put("x", zzb(context2, zzt2[0] - zzt[0]));
                            jSONObject.put("y", zzb(context2, zzt2[1] - zzt[1]));
                            jSONObject.put(str4, str3);
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            str2 = str3;
                            str = str4;
                            try {
                                jSONObject3.put("font_size", (double) textView.getTextSize());
                                jSONObject3.put("text", textView.getText());
                            } catch (JSONException unused) {
                                zzazw.zzfc("Unable to get asset views information");
                                it = it2;
                                str3 = str2;
                                str4 = str;
                            }
                        } else {
                            str2 = str3;
                            str = str4;
                        }
                        jSONObject3.put("is_clickable", map3 != null && map3.containsKey(next.getKey()) && view2.isClickable());
                        jSONObject2.put((String) next.getKey(), jSONObject3);
                    } catch (JSONException unused2) {
                        str2 = str3;
                        str = str4;
                        zzazw.zzfc("Unable to get asset views information");
                        it = it2;
                        str3 = str2;
                        str4 = str;
                    }
                    it = it2;
                    str3 = str2;
                    str4 = str;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject zza(@Nullable String str, Context context, Point point, Point point2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("click_point", zza(context, point, point2));
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e) {
                e = e;
                jSONObject = jSONObject2;
            }
        } catch (Exception e2) {
            e = e2;
            zzazw.zzc("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
    }

    private static int zzb(Context context, int i) {
        return zzvj.zzpr().zzb(context, i);
    }

    public static JSONObject zzb(Context context, @Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzq.zzkw();
            jSONObject.put("can_show_on_lock_screen", zzaxa.zzq(view));
            zzq.zzkw();
            jSONObject.put("is_keyguard_locked", zzaxa.zzax(context));
        } catch (JSONException unused) {
            zzazw.zzfc("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static boolean zzdb(int i) {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcoj)).booleanValue()) {
            return true;
        }
        return ((Boolean) zzvj.zzpv().zzd(zzzz.zzcok)).booleanValue() || i <= 15299999;
    }

    public static JSONObject zzs(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzq.zzkw();
            jSONObject.put("contained_in_scroll_view", zzaxa.zzr(view) != -1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static int[] zzt(@Nullable View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }
}
