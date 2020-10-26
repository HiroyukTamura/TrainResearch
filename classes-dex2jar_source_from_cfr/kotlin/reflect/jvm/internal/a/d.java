/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"tryLoadClass", "Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "fqName", "", "descriptors.runtime"}, k=2, mv={1, 1, 11})
public final class d {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Class<?> a(ClassLoader class_, String string2) {
        j.b(class_, "$receiver");
        j.b(string2, "fqName");
        try {
            return ((ClassLoader)((Object)class_)).loadClass(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }
}

