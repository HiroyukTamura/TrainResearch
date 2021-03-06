/*
 * Decompiled with CFR 0.139.
 */
package androidx.c;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class e<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public e(int n2) {
        if (n2 > 0) {
            this.c = n2;
            this.a = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int c(K k2, V v2) {
        int n2 = this.b(k2, v2);
        if (n2 >= 0) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(k2);
        stringBuilder.append("=");
        stringBuilder.append(v2);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V a(K k2) {
        if (k2 == null) throw new NullPointerException("key == null");
        // MONITORENTER : this
        V v2 = this.a.get(k2);
        if (v2 != null) {
            ++this.g;
            // MONITOREXIT : this
            return v2;
        }
        ++this.h;
        // MONITOREXIT : this
        v2 = this.c(k2);
        if (v2 == null) {
            return null;
        }
        // MONITORENTER : this
        ++this.e;
        V v3 = this.a.put(k2, v2);
        if (v3 != null) {
            this.a.put(k2, v3);
        } else {
            this.b += this.c(k2, v2);
        }
        // MONITOREXIT : this
        if (v3 != null) {
            this.a(false, k2, v2, v3);
            return v3;
        }
        this.a(this.c);
        return v2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V a(K k2, V v2) {
        if (k2 == null) throw new NullPointerException("key == null || value == null");
        if (v2 == null) throw new NullPointerException("key == null || value == null");
        // MONITORENTER : this
        ++this.d;
        this.b += this.c(k2, v2);
        V v3 = this.a.put(k2, v2);
        if (v3 != null) {
            this.b -= this.c(k2, v3);
        }
        // MONITOREXIT : this
        if (v3 != null) {
            this.a(false, k2, v3, v2);
        }
        this.a(this.c);
        return v3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n2) {
        StringBuilder stringBuilder;
        do {
            Map.Entry<K, V> entry;
            synchronized (this) {
                if (this.b < 0 || this.a.isEmpty() && this.b != 0) break block4;
                if (this.b <= n2 || this.a.isEmpty()) break;
                entry = this.a.entrySet().iterator().next();
                stringBuilder = entry.getKey();
                entry = entry.getValue();
                this.a.remove(stringBuilder);
                this.b -= this.c(stringBuilder, entry);
                ++this.f;
            }
            this.a(true, stringBuilder, entry, null);
        } while (true);
        {
            block4 : {
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getName());
            stringBuilder.append(".sizeOf() is reporting inconsistent results!");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    protected void a(boolean bl2, K k2, V v2, V v3) {
    }

    protected int b(K k2, V v2) {
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V b(K k2) {
        if (k2 == null) throw new NullPointerException("key == null");
        // MONITORENTER : this
        Object v2 = this.a.remove(k2);
        if (v2 != null) {
            this.b -= this.c(k2, v2);
        }
        // MONITOREXIT : this
        if (v2 == null) return v2;
        this.a(false, k2, v2, null);
        return v2;
    }

    protected V c(K k2) {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String toString() {
        synchronized (this) {
            int n2 = this.g + this.h;
            n2 = n2 != 0 ? this.g * 100 / n2 : 0;
            return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.c, this.g, this.h, n2);
        }
    }
}

