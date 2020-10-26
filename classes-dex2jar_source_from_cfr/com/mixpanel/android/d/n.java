/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Base64OutputStream
 *  android.util.DisplayMetrics
 *  android.util.JsonWriter
 *  android.util.LruCache
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  org.json.JSONObject
 */
package com.mixpanel.android.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.LruCache;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.mixpanel.android.b.s;
import com.mixpanel.android.c.f;
import com.mixpanel.android.d.i;
import com.mixpanel.android.d.k;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@TargetApi(value=16)
class n {
    private final com.mixpanel.android.b.k a;
    private final c b;
    private final List<i> c;
    private final b d;
    private final Handler e;
    private final s f;

    public n(Context context, List<i> list, s s2) {
        this.a = com.mixpanel.android.b.k.a(context);
        this.c = list;
        this.f = s2;
        this.e = new Handler(Looper.getMainLooper());
        this.b = new c();
        this.d = new b(255);
    }

    private void b(JsonWriter jsonWriter, View view) {
        View view2;
        int n2;
        float f2;
        if (view.getVisibility() == 4 && this.a.t()) {
            return;
        }
        int n3 = view.getId();
        Object object = -1 == n3 ? null : this.f.a(n3);
        jsonWriter.beginObject();
        jsonWriter.name("hashCode").value((long)view.hashCode());
        jsonWriter.name("id").value((long)n3);
        jsonWriter.name("mp_id_name").value((String)object);
        object = view.getContentDescription();
        if (object == null) {
            jsonWriter.name("contentDescription").nullValue();
        } else {
            jsonWriter.name("contentDescription").value(object.toString());
        }
        object = view.getTag();
        if (object == null) {
            jsonWriter.name("tag").nullValue();
        } else if (object instanceof CharSequence) {
            jsonWriter.name("tag").value(object.toString());
        }
        jsonWriter.name("top").value((long)view.getTop());
        jsonWriter.name("left").value((long)view.getLeft());
        jsonWriter.name("width").value((long)view.getWidth());
        jsonWriter.name("height").value((long)view.getHeight());
        jsonWriter.name("scrollX").value((long)view.getScrollX());
        jsonWriter.name("scrollY").value((long)view.getScrollY());
        jsonWriter.name("visibility").value((long)view.getVisibility());
        n3 = Build.VERSION.SDK_INT;
        float f3 = 0.0f;
        if (n3 >= 11) {
            f3 = view.getTranslationX();
            f2 = view.getTranslationY();
        } else {
            f2 = 0.0f;
        }
        jsonWriter.name("translationX").value((double)f3);
        jsonWriter.name("translationY").value((double)f2);
        jsonWriter.name("classes");
        jsonWriter.beginArray();
        object = view.getClass();
        do {
            jsonWriter.value((String)this.d.get(object));
            view2 = object.getSuperclass();
            if (view2 == Object.class) break;
            object = view2;
        } while (view2 != null);
        jsonWriter.endArray();
        this.c(jsonWriter, view);
        object = view.getLayoutParams();
        boolean bl2 = object instanceof RelativeLayout.LayoutParams;
        int n4 = 0;
        if (bl2) {
            object = ((RelativeLayout.LayoutParams)object).getRules();
            jsonWriter.name("layoutRules");
            jsonWriter.beginArray();
            n2 = ((int[])object).length;
            for (n3 = 0; n3 < n2; ++n3) {
                jsonWriter.value((long)object[n3]);
            }
            jsonWriter.endArray();
        }
        jsonWriter.name("subviews");
        jsonWriter.beginArray();
        bl2 = view instanceof ViewGroup;
        if (bl2) {
            object = (ViewGroup)view;
            n2 = object.getChildCount();
            for (n3 = 0; n3 < n2; ++n3) {
                view2 = object.getChildAt(n3);
                if (view2 == null) continue;
                jsonWriter.value((long)view2.hashCode());
            }
        }
        jsonWriter.endArray();
        jsonWriter.endObject();
        if (bl2) {
            view = (ViewGroup)view;
            n2 = view.getChildCount();
            for (n3 = n4; n3 < n2; ++n3) {
                object = view.getChildAt(n3);
                if (object == null) continue;
                this.b(jsonWriter, (View)object);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(JsonWriter jsonWriter, View view) {
        Class<?> class_ = view.getClass();
        Iterator<i> iterator = this.c.iterator();
        do {
            Object object;
            i i2;
            block11 : {
                void var3_8;
                block10 : {
                    block9 : {
                        if (!iterator.hasNext()) {
                            return;
                        }
                        i2 = iterator.next();
                        if (!i2.b.isAssignableFrom(class_) || i2.c == null || (object = i2.c.a(view)) == null) continue;
                        if (!(object instanceof Number)) break block9;
                        JsonWriter jsonWriter2 = jsonWriter.name(i2.a);
                        object = (Number)object;
                        break block10;
                    }
                    if (object instanceof Boolean) {
                        jsonWriter.name(i2.a).value(((Boolean)object).booleanValue());
                        continue;
                    }
                    if (!(object instanceof ColorStateList)) break block11;
                    JsonWriter jsonWriter3 = jsonWriter.name(i2.a);
                    object = ((ColorStateList)object).getDefaultColor();
                }
                var3_8.value((Number)object);
                continue;
            }
            if (object instanceof Drawable) {
                void var3_11;
                object = (Drawable)object;
                Rect rect = object.getBounds();
                jsonWriter.name(i2.a);
                jsonWriter.beginObject();
                jsonWriter.name("classes");
                jsonWriter.beginArray();
                Class<?> class_2 = object.getClass();
                while (var3_11 != Object.class) {
                    jsonWriter.value(var3_11.getCanonicalName());
                    Class class_3 = var3_11.getSuperclass();
                }
                jsonWriter.endArray();
                jsonWriter.name("dimensions");
                jsonWriter.beginObject();
                jsonWriter.name("left").value((long)rect.left);
                jsonWriter.name("right").value((long)rect.right);
                jsonWriter.name("top").value((long)rect.top);
                jsonWriter.name("bottom").value((long)rect.bottom);
                jsonWriter.endObject();
                if (object instanceof ColorDrawable) {
                    ColorDrawable colorDrawable = (ColorDrawable)object;
                    jsonWriter.name("color").value((long)colorDrawable.getColor());
                }
                jsonWriter.endObject();
                continue;
            }
            jsonWriter.name(i2.a).value(object.toString());
        } while (true);
    }

    void a(JsonWriter jsonWriter, View view) {
        jsonWriter.beginArray();
        this.b(jsonWriter, view);
        jsonWriter.endArray();
    }

    public void a(k<Activity> object, OutputStream outputStream) {
        this.b.a((k<Activity>)object);
        Object object2 = new FutureTask<List<d>>(this.b);
        this.e.post(object2);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        object = Collections.emptyList();
        outputStreamWriter.write("[");
        try {
            object = object2 = ((FutureTask)object2).get(1L, TimeUnit.SECONDS);
        }
        catch (ExecutionException executionException) {
            f.e("MixpanelAPI.Snapshot", "Exception thrown during screenshot attempt", executionException);
        }
        catch (TimeoutException timeoutException) {
            f.c("MixpanelAPI.Snapshot", "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", timeoutException);
        }
        catch (InterruptedException interruptedException) {
            f.b("MixpanelAPI.Snapshot", "Screenshot interrupted, no screenshot will be sent.", interruptedException);
        }
        int n2 = object.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                outputStreamWriter.write(",");
            }
            object2 = (d)object.get(i2);
            outputStreamWriter.write("{");
            outputStreamWriter.write("\"activity\":");
            outputStreamWriter.write(JSONObject.quote((String)((d)object2).a));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"scale\":");
            outputStreamWriter.write(String.format("%s", Float.valueOf(((d)object2).d)));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"serialized_objects\":");
            JsonWriter jsonWriter = new JsonWriter((Writer)outputStreamWriter);
            jsonWriter.beginObject();
            jsonWriter.name("rootObject").value((long)((d)object2).b.hashCode());
            jsonWriter.name("objects");
            this.a(jsonWriter, ((d)object2).b);
            jsonWriter.endObject();
            jsonWriter.flush();
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"screenshot\":");
            outputStreamWriter.flush();
            ((d)object2).c.a(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStreamWriter.write("}");
        }
        outputStreamWriter.write("]");
        outputStreamWriter.flush();
    }

    private static class a {
        private Bitmap a = null;
        private final Paint b = new Paint(2);

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void a(int n2, int n3, int n4, Bitmap bitmap) {
            synchronized (this) {
                int n5;
                if (this.a == null || this.a.getWidth() != n2 || (n5 = this.a.getHeight()) != n3) {
                    block7 : {
                        try {
                            this.a = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.RGB_565);
                            break block7;
                        }
                        catch (OutOfMemoryError outOfMemoryError) {}
                        this.a = null;
                    }
                    if (this.a != null) {
                        this.a.setDensity(n4);
                    }
                }
                if (this.a != null) {
                    new Canvas(this.a).drawBitmap(bitmap, 0.0f, 0.0f, this.b);
                }
                return;
            }
        }

        public void a(Bitmap.CompressFormat compressFormat, int n2, OutputStream outputStream) {
            synchronized (this) {
                if (this.a != null && this.a.getWidth() != 0 && this.a.getHeight() != 0) {
                    outputStream.write(34);
                    compressFormat = new Base64OutputStream(outputStream, 2);
                    this.a.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)compressFormat);
                    compressFormat.flush();
                    outputStream.write(34);
                } else {
                    outputStream.write("null".getBytes());
                }
                return;
            }
        }
    }

    private static class b
    extends LruCache<Class<?>, String> {
        public b(int n2) {
            super(n2);
        }

        protected String a(Class<?> class_) {
            return class_.getCanonicalName();
        }

        protected /* synthetic */ Object create(Object object) {
            return this.a((Class)object);
        }
    }

    private static class c
    implements Callable<List<d>> {
        private k<Activity> a;
        private final List<d> b = new ArrayList<d>();
        private final DisplayMetrics c = new DisplayMetrics();
        private final a d = new a();
        private final int e = 160;

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private void a(d d2) {
            Method method;
            View view;
            float f2;
            Object object;
            block20 : {
                block19 : {
                    block22 : {
                        view = d2.b;
                        try {
                            method = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
                            method.setAccessible(true);
                            method = (Bitmap)method.invoke((Object)view, new Object[]{Bitmap.Config.RGB_565, -1, false});
                            break block19;
                        }
                        catch (ClassCastException classCastException) {
                            object = "createSnapshot didn't return a bitmap?";
                        }
                        catch (IllegalAccessException illegalAccessException) {
                            object = "Can't access createSnapshot, using drawCache";
                        }
                        catch (InvocationTargetException invocationTargetException) {
                            object = "Exception when calling createSnapshot";
                        }
                        f.e("MixpanelAPI.Snapshot", (String)object, (Throwable)((Object)method));
                        break block22;
                        catch (IllegalArgumentException illegalArgumentException) {
                            f.b("MixpanelAPI.Snapshot", "Can't call createSnapshot with arguments", illegalArgumentException);
                        }
                        catch (NoSuchMethodException noSuchMethodException) {
                            f.a("MixpanelAPI.Snapshot", "Can't call createSnapshot, will use drawCache", noSuchMethodException);
                        }
                    }
                    method = null;
                }
                if (method == null) {
                    void var10_13;
                    block21 : {
                        object = view.isDrawingCacheEnabled();
                        try {
                            view.setDrawingCacheEnabled(true);
                            view.buildDrawingCache(true);
                            Bitmap bitmap = view.getDrawingCache();
                            method = bitmap;
                            break block20;
                        }
                        catch (RuntimeException runtimeException) {
                            break block21;
                        }
                        catch (RuntimeException runtimeException) {
                            object = null;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Can't take a bitmap snapshot of view ");
                    stringBuilder.append((Object)view);
                    stringBuilder.append(", skipping for now.");
                    f.a("MixpanelAPI.Snapshot", stringBuilder.toString(), (Throwable)var10_13);
                } else {
                    object = null;
                }
            }
            float f3 = f2 = 1.0f;
            if (method != null) {
                int n2 = method.getDensity();
                if (n2 != 0) {
                    f2 = 160.0f / (float)n2;
                }
                n2 = method.getWidth();
                int n3 = method.getHeight();
                int n4 = (int)((double)((float)method.getWidth() * f2) + 0.5);
                int n5 = (int)((double)((float)method.getHeight() * f2) + 0.5);
                f3 = f2;
                if (n2 > 0) {
                    f3 = f2;
                    if (n3 > 0) {
                        f3 = f2;
                        if (n4 > 0) {
                            f3 = f2;
                            if (n5 > 0) {
                                this.d.a(n4, n5, 160, (Bitmap)method);
                                f3 = f2;
                            }
                        }
                    }
                }
            }
            if (object != null && !((Boolean)object).booleanValue()) {
                view.setDrawingCacheEnabled(false);
            }
            d2.d = f3;
            d2.c = this.d;
        }

        public List<d> a() {
            this.b.clear();
            for (Object object : this.a.a()) {
                String string2 = object.getClass().getCanonicalName();
                View view = object.getWindow().getDecorView().getRootView();
                object.getWindowManager().getDefaultDisplay().getMetrics(this.c);
                object = new d(string2, view);
                this.b.add((d)object);
            }
            int n2 = this.b.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.a(this.b.get(i2));
            }
            return this.b;
        }

        public void a(k<Activity> k2) {
            this.a = k2;
        }

        @Override
        public /* synthetic */ Object call() {
            return this.a();
        }
    }

    private static class d {
        public final String a;
        public final View b;
        public a c;
        public float d;

        public d(String string2, View view) {
            this.a = string2;
            this.b = view;
            this.c = null;
            this.d = 1.0f;
        }
    }

}

