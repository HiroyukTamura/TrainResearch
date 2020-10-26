// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3;

import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeMap;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Set;
import okhttp3.internal.http.HttpDate;
import java.util.Date;
import java.util.Arrays;
import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;

public final class Headers
{
    private final String[] namesAndValues;
    
    Headers(final Headers.Headers$Builder headers$Builder) {
        this.namesAndValues = headers$Builder.namesAndValues.toArray(new String[headers$Builder.namesAndValues.size()]);
    }
    
    private Headers(final String[] namesAndValues) {
        this.namesAndValues = namesAndValues;
    }
    
    private static String get(final String[] array, final String s) {
        for (int i = array.length - 2; i >= 0; i -= 2) {
            if (s.equalsIgnoreCase(array[i])) {
                return array[i + 1];
            }
        }
        return null;
    }
    
    public static Headers of(final Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        final String[] array = new String[map.size() * 2];
        int n = 0;
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            final String trim = entry.getKey().trim();
            final String trim2 = entry.getValue().trim();
            if (trim.length() == 0 || trim.indexOf(0) != -1 || trim2.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + trim + ": " + trim2);
            }
            array[n] = trim;
            array[n + 1] = trim2;
            n += 2;
        }
        return new Headers(array);
    }
    
    public static Headers of(String... array) {
        if (array == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (array.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        array = array.clone();
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            array[i] = array[i].trim();
        }
        for (int j = 0; j < array.length; j += 2) {
            final String str = array[j];
            final String str2 = array[j + 1];
            if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new Headers(array);
    }
    
    public long byteCount() {
        long n = this.namesAndValues.length * 2;
        for (int i = 0; i < this.namesAndValues.length; ++i) {
            n += this.namesAndValues[i].length();
        }
        return n;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Headers && Arrays.equals(((Headers)o).namesAndValues, this.namesAndValues);
    }
    
    @Nullable
    public String get(final String s) {
        return get(this.namesAndValues, s);
    }
    
    @Nullable
    public Date getDate(String value) {
        value = this.get(value);
        if (value != null) {
            return HttpDate.parse(value);
        }
        return null;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }
    
    public String name(final int n) {
        return this.namesAndValues[n * 2];
    }
    
    public Set<String> names() {
        final TreeSet<String> s = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < this.size(); ++i) {
            s.add(this.name(i));
        }
        return (Set<String>)Collections.unmodifiableSet((Set<?>)s);
    }
    
    public Headers.Headers$Builder newBuilder() {
        final Headers.Headers$Builder headers$Builder = new Headers.Headers$Builder();
        Collections.addAll(headers$Builder.namesAndValues, this.namesAndValues);
        return headers$Builder;
    }
    
    public int size() {
        return this.namesAndValues.length / 2;
    }
    
    public Map<String, List<String>> toMultimap() {
        final TreeMap<Object, List<String>> treeMap = (TreeMap<Object, List<String>>)new TreeMap<Object, Object>((Comparator<? super Object>)String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < this.size(); ++i) {
            final String lowerCase = this.name(i).toLowerCase(Locale.US);
            List<String> list;
            if ((list = treeMap.get(lowerCase)) == null) {
                list = new ArrayList<String>(2);
                treeMap.put(lowerCase, list);
            }
            list.add(this.value(i));
        }
        return (Map<String, List<String>>)treeMap;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); ++i) {
            sb.append(this.name(i)).append(": ").append(this.value(i)).append("\n");
        }
        return sb.toString();
    }
    
    public String value(final int n) {
        return this.namesAndValues[n * 2 + 1];
    }
    
    public List<String> values(final String s) {
        List<? extends String> list = null;
        List<? extends String> list2;
        for (int i = 0; i < this.size(); ++i, list = list2) {
            list2 = list;
            if (s.equalsIgnoreCase(this.name(i))) {
                if ((list2 = list) == null) {
                    list2 = new ArrayList<String>(2);
                }
                list2.add(this.value(i));
            }
        }
        if (list != null) {
            return (List<String>)Collections.unmodifiableList((List<?>)list);
        }
        return Collections.emptyList();
    }
}
