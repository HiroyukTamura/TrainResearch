/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.d;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.al;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.l;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.s;
import androidx.core.h.t;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList;
    private static final Map<String, Constructor<? extends View>> sConstructorMap;
    private static final Class<?>[] sConstructorSignature;
    private static final int[] sOnClickAttrs;
    private final Object[] mConstructorArgs = new Object[2];

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{16843375};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new androidx.c.a<String, Constructor<? extends View>>();
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Object object = view.getContext();
        if (object instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT >= 15 && !t.C(view)) {
                return;
            }
            attributeSet = object.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            object = attributeSet.getString(0);
            if (object != null) {
                view.setOnClickListener((View.OnClickListener)new a(view, (String)object));
            }
            attributeSet.recycle();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private View createViewByPrefix(Context var1_1, String var2_3, String var3_4) {
        var5_5 = AppCompatViewInflater.sConstructorMap.get(var2_3);
        var4_6 = var5_5;
        if (var5_5 != null) ** GOTO lbl15
        try {
            var4_6 = var1_1.getClassLoader();
            if (var3_4 != null) {
                var1_1 = new StringBuilder();
                var1_1.append(var3_4);
                var1_1.append(var2_3);
                var1_1 = var1_1.toString();
            } else {
                var1_1 = var2_3;
            }
            var4_6 = var4_6.loadClass((String)var1_1).asSubclass(View.class).getConstructor(AppCompatViewInflater.sConstructorSignature);
            AppCompatViewInflater.sConstructorMap.put(var2_3, var4_6);
lbl15: // 2 sources:
            var4_6.setAccessible(true);
            return (View)var4_6.newInstance(this.mConstructorArgs);
        }
        catch (Exception var1_2) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private View createViewFromTag(Context context, String string2, AttributeSet attributeSet) {
        String string3;
        block7 : {
            string3 = string2;
            if (string2.equals("view")) {
                string3 = attributeSet.getAttributeValue(null, "class");
            }
            try {
                this.mConstructorArgs[0] = context;
                this.mConstructorArgs[1] = attributeSet;
                if (-1 != string3.indexOf(46)) {
                    context = this.createViewByPrefix(context, string3, null);
                    this.mConstructorArgs[0] = null;
                    this.mConstructorArgs[1] = null;
                    return context;
                }
                break block7;
            }
            catch (Throwable throwable) {
                this.mConstructorArgs[0] = null;
                this.mConstructorArgs[1] = null;
                throw throwable;
            }
            catch (Exception exception) {}
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
            return null;
        }
        for (int i2 = 0; i2 < sClassPrefixList.length; ++i2) {
            string2 = this.createViewByPrefix(context, string3, sClassPrefixList[i2]);
            if (string2 == null) continue;
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
            return string2;
        }
        this.mConstructorArgs[0] = null;
        this.mConstructorArgs[1] = null;
        return null;
    }

    private static Context themifyContext(Context context, AttributeSet object, boolean bl2, boolean bl3) {
        block6 : {
            int n2;
            block7 : {
                object = context.obtainStyledAttributes(object, a.j.View, 0, 0);
                int n3 = bl2 ? object.getResourceId(a.j.View_android_theme, 0) : 0;
                n2 = n3;
                if (bl3) {
                    n2 = n3;
                    if (n3 == 0) {
                        n2 = n3 = object.getResourceId(a.j.View_theme, 0);
                        if (n3 != 0) {
                            Log.i((String)LOG_TAG, (String)"app:theme is now deprecated. Please move to using android:theme instead.");
                            n2 = n3;
                        }
                    }
                }
                object.recycle();
                object = context;
                if (n2 == 0) break block6;
                if (!(context instanceof d)) break block7;
                object = context;
                if (((d)context).a() == n2) break block6;
            }
            object = new d(context, n2);
        }
        return object;
    }

    private void verifyNotNull(View object, String string2) {
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(this.getClass().getName());
        ((StringBuilder)object).append(" asked to inflate view for <");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(">, but returned null");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    protected e createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected g createCheckBox(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    protected AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    protected AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    protected AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    protected AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected l createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new l(context, attributeSet);
    }

    protected o createRadioButton(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    protected p createRatingBar(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    protected q createSeekBar(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    protected s createSpinner(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    protected AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    protected View createView(Context context, String string2, AttributeSet attributeSet) {
        return null;
    }

    final View createView(View object, String string2, Context context, AttributeSet attributeSet, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        Context context2;
        block39 : {
            block38 : {
                block37 : {
                    context2 = bl2 && object != null ? object.getContext() : context;
                    if (bl3) break block37;
                    object = context2;
                    if (!bl4) break block38;
                }
                object = AppCompatViewInflater.themifyContext(context2, attributeSet, bl3, bl4);
            }
            context2 = object;
            if (bl5) {
                context2 = al.a((Context)object);
            }
            int n2 = -1;
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 2001146706: {
                    if (!string2.equals("Button")) break;
                    n2 = 2;
                    break;
                }
                case 1666676343: {
                    if (!string2.equals("EditText")) break;
                    n2 = 3;
                    break;
                }
                case 1601505219: {
                    if (!string2.equals("CheckBox")) break;
                    n2 = 6;
                    break;
                }
                case 1413872058: {
                    if (!string2.equals("AutoCompleteTextView")) break;
                    n2 = 9;
                    break;
                }
                case 1125864064: {
                    if (!string2.equals("ImageView")) break;
                    n2 = 1;
                    break;
                }
                case 776382189: {
                    if (!string2.equals("RadioButton")) break;
                    n2 = 7;
                    break;
                }
                case -339785223: {
                    if (!string2.equals("Spinner")) break;
                    n2 = 4;
                    break;
                }
                case -658531749: {
                    if (!string2.equals("SeekBar")) break;
                    n2 = 12;
                    break;
                }
                case -937446323: {
                    if (!string2.equals("ImageButton")) break;
                    n2 = 5;
                    break;
                }
                case -938935918: {
                    if (!string2.equals("TextView")) break;
                    n2 = 0;
                    break;
                }
                case -1346021293: {
                    if (!string2.equals("MultiAutoCompleteTextView")) break;
                    n2 = 10;
                    break;
                }
                case -1455429095: {
                    if (!string2.equals("CheckedTextView")) break;
                    n2 = 8;
                    break;
                }
                case -1946472170: {
                    if (!string2.equals("RatingBar")) break;
                    n2 = 11;
                }
            }
            switch (n2) {
                default: {
                    object = this.createView(context2, string2, attributeSet);
                    break block39;
                }
                case 12: {
                    object = this.createSeekBar(context2, attributeSet);
                    break;
                }
                case 11: {
                    object = this.createRatingBar(context2, attributeSet);
                    break;
                }
                case 10: {
                    object = this.createMultiAutoCompleteTextView(context2, attributeSet);
                    break;
                }
                case 9: {
                    object = this.createAutoCompleteTextView(context2, attributeSet);
                    break;
                }
                case 8: {
                    object = this.createCheckedTextView(context2, attributeSet);
                    break;
                }
                case 7: {
                    object = this.createRadioButton(context2, attributeSet);
                    break;
                }
                case 6: {
                    object = this.createCheckBox(context2, attributeSet);
                    break;
                }
                case 5: {
                    object = this.createImageButton(context2, attributeSet);
                    break;
                }
                case 4: {
                    object = this.createSpinner(context2, attributeSet);
                    break;
                }
                case 3: {
                    object = this.createEditText(context2, attributeSet);
                    break;
                }
                case 2: {
                    object = this.createButton(context2, attributeSet);
                    break;
                }
                case 1: {
                    object = this.createImageView(context2, attributeSet);
                    break;
                }
                case 0: {
                    object = this.createTextView(context2, attributeSet);
                }
            }
            this.verifyNotNull((View)object, string2);
        }
        Object object2 = object;
        if (object == null) {
            object2 = object;
            if (context != context2) {
                object2 = this.createViewFromTag(context2, string2, attributeSet);
            }
        }
        if (object2 != null) {
            this.checkOnClickListener((View)object2, attributeSet);
        }
        return object2;
    }

    private static class a
    implements View.OnClickListener {
        private final View a;
        private final String b;
        private Method c;
        private Context d;

        public a(View view, String string2) {
            this.a = view;
            this.b = string2;
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private void a(Context object, String object2) {
            do {
                if (object != null) {
                    if (!object.isRestricted()) {
                        object2 = object.getClass().getMethod(this.b, View.class);
                        if (object2 != null) {
                            this.c = object2;
                            this.d = object;
                            return;
                        }
                    }
                } else {
                    int n2 = this.a.getId();
                    if (n2 == -1) {
                        object = "";
                    } else {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(" with id '");
                        ((StringBuilder)object).append(this.a.getContext().getResources().getResourceEntryName(n2));
                        ((StringBuilder)object).append("'");
                        object = ((StringBuilder)object).toString();
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Could not find method ");
                    ((StringBuilder)object2).append(this.b);
                    ((StringBuilder)object2).append("(View) in a parent or ancestor Context for android:onClick ");
                    ((StringBuilder)object2).append("attribute defined on view ");
                    ((StringBuilder)object2).append(this.a.getClass());
                    ((StringBuilder)object2).append((String)object);
                    throw new IllegalStateException(((StringBuilder)object2).toString());
                    catch (NoSuchMethodException noSuchMethodException) {}
                }
                if (object instanceof ContextWrapper) {
                    object = ((ContextWrapper)object).getBaseContext();
                    continue;
                }
                object = null;
            } while (true);
        }

        public void onClick(View view) {
            if (this.c == null) {
                this.a(this.a.getContext(), this.b);
            }
            try {
                this.c.invoke((Object)this.d, new Object[]{view});
                return;
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new IllegalStateException("Could not execute method for android:onClick", invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", illegalAccessException);
            }
        }
    }

}

