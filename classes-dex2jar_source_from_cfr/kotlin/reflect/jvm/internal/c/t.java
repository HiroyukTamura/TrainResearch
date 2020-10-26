/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.c.a.e.r;
import kotlin.reflect.jvm.internal.impl.c.a.m;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaModifierListOwner;", "isAbstract", "", "()Z", "isFinal", "isStatic", "modifiers", "", "getModifiers", "()I", "visibility", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "getVisibility", "()Lorg/jetbrains/kotlin/descriptors/Visibility;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public interface t
extends r {
    public int v();

    @Metadata(bv={1, 0, 2}, k=3, mv={1, 1, 11})
    public static final class a {
        public static boolean a(t t2) {
            return Modifier.isAbstract(t2.v());
        }

        public static boolean b(t t2) {
            return Modifier.isStatic(t2.v());
        }

        public static boolean c(t t2) {
            return Modifier.isFinal(t2.v());
        }

        /*
         * Enabled aggressive block sorting
         */
        public static ba d(t object) {
            ba ba2;
            int n2 = object.v();
            if (Modifier.isPublic(n2)) {
                ba2 = az.e;
                object = "Visibilities.PUBLIC";
            } else if (Modifier.isPrivate(n2)) {
                ba2 = az.a;
                object = "Visibilities.PRIVATE";
            } else if (Modifier.isProtected(n2)) {
                ba2 = Modifier.isStatic(n2) ? m.b : m.c;
                object = "if (Modifier.isStatic(mo\u2026ies.PROTECTED_AND_PACKAGE";
            } else {
                ba2 = m.a;
                object = "JavaVisibilities.PACKAGE_VISIBILITY";
            }
            j.a((Object)ba2, (String)object);
            return ba2;
        }
    }

}

