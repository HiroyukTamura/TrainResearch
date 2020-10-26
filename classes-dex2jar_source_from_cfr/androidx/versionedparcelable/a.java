/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 */
package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.versionedparcelable.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {
    protected static <T extends c> T a(String object, a a2) {
        try {
            object = (c)Class.forName((String)object, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class).invoke(null, a2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getCause() instanceof RuntimeException) {
                throw (RuntimeException)invocationTargetException.getCause();
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException);
        }
        return (T)object;
    }

    private static Class a(Class<? extends c> class_) {
        return Class.forName(String.format("%s.%sParcelizer", class_.getPackage().getName(), class_.getSimpleName()), false, class_.getClassLoader());
    }

    protected static <T extends c> void a(T t2, a a2) {
        try {
            a.c(t2).getDeclaredMethod("write", t2.getClass(), a.class).invoke(null, t2, a2);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getCause() instanceof RuntimeException) {
                throw (RuntimeException)invocationTargetException.getCause();
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException);
        }
    }

    private void b(c c2) {
        try {
            Class class_ = a.a(c2.getClass());
            this.a(class_.getName());
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c2.getClass().getSimpleName());
            stringBuilder.append(" does not have a Parcelizer");
            throw new RuntimeException(stringBuilder.toString(), classNotFoundException);
        }
    }

    private static <T extends c> Class c(T t2) {
        return a.a(t2.getClass());
    }

    protected abstract void a(int var1);

    public void a(int n2, int n3) {
        this.c(n3);
        this.a(n2);
    }

    protected abstract void a(Parcelable var1);

    public void a(Parcelable parcelable, int n2) {
        this.c(n2);
        this.a(parcelable);
    }

    protected void a(c c2) {
        if (c2 == null) {
            this.a((String)null);
            return;
        }
        this.b(c2);
        a a2 = this.c();
        a.a(c2, a2);
        a2.b();
    }

    public void a(c c2, int n2) {
        this.c(n2);
        this.a(c2);
    }

    protected abstract void a(String var1);

    public void a(String string2, int n2) {
        this.c(n2);
        this.a(string2);
    }

    public void a(boolean bl2, boolean bl3) {
    }

    protected abstract void a(byte[] var1);

    public void a(byte[] arrby, int n2) {
        this.c(n2);
        this.a(arrby);
    }

    public boolean a() {
        return false;
    }

    public int b(int n2, int n3) {
        if (!this.b(n3)) {
            return n2;
        }
        return this.d();
    }

    public <T extends Parcelable> T b(T t2, int n2) {
        if (!this.b(n2)) {
            return t2;
        }
        return this.g();
    }

    public <T extends c> T b(T t2, int n2) {
        if (!this.b(n2)) {
            return t2;
        }
        return this.h();
    }

    public String b(String string2, int n2) {
        if (!this.b(n2)) {
            return string2;
        }
        return this.e();
    }

    protected abstract void b();

    protected abstract boolean b(int var1);

    public byte[] b(byte[] arrby, int n2) {
        if (!this.b(n2)) {
            return arrby;
        }
        return this.f();
    }

    protected abstract a c();

    protected abstract void c(int var1);

    protected abstract int d();

    protected abstract String e();

    protected abstract byte[] f();

    protected abstract <T extends Parcelable> T g();

    protected <T extends c> T h() {
        String string2 = this.e();
        if (string2 == null) {
            return null;
        }
        return a.a(string2, this.c());
    }
}

