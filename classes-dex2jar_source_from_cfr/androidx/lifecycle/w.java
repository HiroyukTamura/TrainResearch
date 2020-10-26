/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Application
 */
package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class w {
    private final b a;
    private final y b;

    public w(y y2, b b2) {
        this.a = b2;
        this.b = y2;
    }

    public <T extends v> T a(Class<T> class_) {
        String string2 = class_.getCanonicalName();
        if (string2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
            stringBuilder.append(string2);
            return this.a(stringBuilder.toString(), class_);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends v> T a(String string2, Class<T> class_) {
        v v2 = this.b.a(string2);
        if (class_.isInstance(v2)) {
            return (T)v2;
        }
        class_ = this.a.a(class_);
        this.b.a(string2, (v)((Object)class_));
        return (T)class_;
    }

    public static class a
    extends c {
        private static a a;
        private Application b;

        public a(Application application) {
            this.b = application;
        }

        public static a a(Application application) {
            if (a == null) {
                a = new a(application);
            }
            return a;
        }

        @Override
        public <T extends v> T a(Class<T> class_) {
            if (androidx.lifecycle.a.class.isAssignableFrom(class_)) {
                v v2;
                try {
                    v2 = (v)class_.getConstructor(Application.class).newInstance(new Object[]{this.b});
                }
                catch (InvocationTargetException invocationTargetException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot create an instance of ");
                    stringBuilder.append(class_);
                    throw new RuntimeException(stringBuilder.toString(), invocationTargetException);
                }
                catch (InstantiationException instantiationException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot create an instance of ");
                    stringBuilder.append(class_);
                    throw new RuntimeException(stringBuilder.toString(), instantiationException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot create an instance of ");
                    stringBuilder.append(class_);
                    throw new RuntimeException(stringBuilder.toString(), illegalAccessException);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot create an instance of ");
                    stringBuilder.append(class_);
                    throw new RuntimeException(stringBuilder.toString(), noSuchMethodException);
                }
                return (T)v2;
            }
            return super.a(class_);
        }
    }

    public static interface b {
        public <T extends v> T a(Class<T> var1);
    }

    public static class c
    implements b {
        @Override
        public <T extends v> T a(Class<T> class_) {
            v v2;
            try {
                v2 = (v)class_.newInstance();
            }
            catch (IllegalAccessException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create an instance of ");
                stringBuilder.append(class_);
                throw new RuntimeException(stringBuilder.toString(), illegalAccessException);
            }
            catch (InstantiationException instantiationException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create an instance of ");
                stringBuilder.append(class_);
                throw new RuntimeException(stringBuilder.toString(), instantiationException);
            }
            return (T)v2;
        }
    }

}

