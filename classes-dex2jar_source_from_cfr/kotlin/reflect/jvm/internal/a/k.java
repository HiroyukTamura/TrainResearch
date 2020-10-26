/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.b.s;
import kotlin.reflect.jvm.internal.impl.c.b.t;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.d.c.a.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.w;

@Metadata(bv={1, 0, 2}, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/PackagePartProvider;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "packageParts", "Ljava/util/HashMap;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/HashMap;", "visitedModules", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "findPackageParts", "", "packageFqName", "getAnnotationsOnBinaryModule", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "moduleName", "registerModule", "", "EmptyEnumeration", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class k
implements t {
    private final HashSet<String> a;
    private final HashMap<String, LinkedHashSet<String>> b;
    private final ClassLoader c;

    public k(ClassLoader classLoader) {
        j.b(classLoader, "classLoader");
        this.c = classLoader;
        this.a = new HashSet();
        this.b = new HashMap();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a(String object) {
        Object object2;
        String string2;
        block20 : {
            // MONITORENTER : this
            j.b(object, "moduleName");
            boolean bl2 = this.a.add((String)object);
            if (!bl2) {
                // MONITOREXIT : this
                return;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("META-INF/");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(".kotlin_module");
            string2 = ((StringBuilder)object2).toString();
            try {
                object = this.c.getResources(string2);
                break block20;
            }
            catch (IOException iOException) {}
            object = a.a;
        }
        j.a(object, "resources");
        Iterator iterator = m.a(object);
        do {
            Throwable throwable3222;
            if (!iterator.hasNext()) {
                // MONITOREXIT : this
                return;
            }
            object = (URL)iterator.next();
            if ((object = ((URL)object).openStream()) == null) continue;
            Closeable closeable = (Closeable)object;
            Throwable throwable2 = null;
            object = throwable2;
            object2 = (InputStream)closeable;
            object = throwable2;
            Iterator<Map.Entry<String, kotlin.reflect.jvm.internal.impl.d.c.a.m>> iterator2 = s.a(kotlin.reflect.jvm.internal.impl.d.c.a.k.c, kotlin.d.a.a((InputStream)object2, 0, 1, null), string2, k.a.a, b.a).a().entrySet().iterator();
            do {
                object = throwable2;
                if (!iterator2.hasNext()) break;
                object = throwable2;
                object2 = iterator2.next();
                object = throwable2;
                String string3 = object2.getKey();
                object = throwable2;
                kotlin.reflect.jvm.internal.impl.d.c.a.m m2 = object2.getValue();
                object = throwable2;
                Map map = this.b;
                object = throwable2;
                Object v2 = map.get(string3);
                object2 = v2;
                if (v2 == null) {
                    object = throwable2;
                    object2 = new LinkedHashSet();
                    object = throwable2;
                    map.put(string3, object2);
                }
                object = throwable2;
                ((LinkedHashSet)object2).addAll((Collection)m2.a());
            } while (true);
            object = throwable2;
            object2 = w.a;
            kotlin.d.b.a(closeable, throwable2);
            continue;
            {
                catch (Throwable throwable3222) {
                }
                catch (Throwable throwable4) {}
                object = throwable4;
                {
                    throw throwable4;
                }
            }
            try {
                kotlin.d.b.a(closeable, (Throwable)object);
                throw throwable3222;
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                throw (Throwable)unsupportedOperationException;
            }
            catch (Exception exception) {
                continue;
            }
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<String> b(String collection) {
        synchronized (this) {
            j.b(collection, "packageFqName");
            collection = this.b.get(collection);
            collection = collection != null ? m.k((Iterable)collection) : null;
            if (collection == null) return m.a();
            return collection;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider$EmptyEnumeration;", "Ljava/util/Enumeration;", "", "()V", "hasMoreElements", "", "nextElement", "descriptors.runtime"}, k=1, mv={1, 1, 11})
    private static final class a
    implements Enumeration {
        public static final a a = new a();

        private a() {
        }

        public Void a() {
            throw (Throwable)new NoSuchElementException();
        }

        @Override
        public boolean hasMoreElements() {
            return false;
        }

        public /* synthetic */ Object nextElement() {
            return this.a();
        }
    }

}

