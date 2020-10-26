/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 */
package jp.co.jreast.jreastapp.commuter.s;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jp.co.jreast.jreastapp.commuter.s.b;

public class a
implements SharedPreferences {
    private SharedPreferences a;

    public a(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    private void a(String string2) {
        if (!"crypto".equals(string2)) {
            return;
        }
        throw new IllegalStateException(string2);
    }

    public boolean contains(String string2) {
        this.a(string2);
        return this.a.contains(string2);
    }

    public SharedPreferences.Editor edit() {
        return new a(this.a);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Map<String, Object> getAll() {
        Map map = this.a.getAll();
        map.remove("crypto");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String string2 = (String)entry.getKey();
            Object v2 = entry.getValue();
            if (v2 instanceof String) {
                void var1_10;
                String[] arrstring = b.a(v2.toString()).split("\t", 2);
                if (arrstring[0].equals("S")) {
                    if (arrstring.length == 2) {
                        String string3 = arrstring[1];
                    } else {
                        String string4 = "";
                    }
                } else if (arrstring[0].equals("I")) {
                    Integer n2 = Integer.valueOf(arrstring[1]);
                } else if (arrstring[0].equals("L")) {
                    Long l2 = Long.valueOf(arrstring[1]);
                } else if (arrstring[0].equals("F")) {
                    Float f2 = Float.valueOf(arrstring[1]);
                } else {
                    if (!arrstring[0].equals("B")) continue;
                    Boolean bl2 = Boolean.valueOf(arrstring[1]);
                }
                map.put(string2, var1_10);
                continue;
            }
            if (!(v2 instanceof Set)) continue;
            Object object = (Set)v2;
            HashSet<String> hashSet = new HashSet<String>();
            object = object.iterator();
            while (object.hasNext()) {
                hashSet.add(b.a((String)object.next()));
            }
            map.put(string2, hashSet);
        }
        return map;
    }

    public boolean getBoolean(String string2, boolean bl2) {
        String string3;
        this.a(string2);
        string2 = string3 = this.a.getString(string2, null);
        if (string3 != null) {
            string2 = b.a(string3);
            if (string2.startsWith("B\t")) {
                string2 = string2.substring(2);
            } else {
                throw new IllegalStateException();
            }
        }
        if (string2 != null) {
            bl2 = Boolean.parseBoolean(string2);
        }
        return bl2;
    }

    public float getFloat(String string2, float f2) {
        String string3;
        this.a(string2);
        string2 = string3 = this.a.getString(string2, null);
        if (string3 != null) {
            string2 = b.a(string3);
            if (string2.startsWith("F\t")) {
                string2 = string2.substring(2);
            } else {
                throw new IllegalStateException();
            }
        }
        if (string2 != null) {
            f2 = Float.parseFloat(string2);
        }
        return f2;
    }

    public int getInt(String string2, int n2) {
        String string3;
        this.a(string2);
        string2 = string3 = this.a.getString(string2, null);
        if (string3 != null) {
            string2 = b.a(string3);
            if (string2.startsWith("I\t")) {
                string2 = string2.substring(2);
            } else {
                throw new IllegalStateException();
            }
        }
        if (string2 != null) {
            n2 = Integer.parseInt(string2);
        }
        return n2;
    }

    public long getLong(String string2, long l2) {
        String string3;
        this.a(string2);
        string2 = string3 = this.a.getString(string2, null);
        if (string3 != null) {
            string2 = b.a(string3);
            if (string2.startsWith("L\t")) {
                string2 = string2.substring(2);
            } else {
                throw new IllegalStateException();
            }
        }
        if (string2 != null) {
            l2 = Long.parseLong(string2);
        }
        return l2;
    }

    public String getString(String string2, String string3) {
        String string4;
        this.a(string2);
        string2 = string4 = this.a.getString(string2, null);
        if (string4 != null) {
            string2 = b.a(string4);
            if (string2.startsWith("S\t")) {
                string2 = string2.substring(2);
            } else {
                throw new IllegalStateException();
            }
        }
        if (string2 != null) {
            return string2;
        }
        return string3;
    }

    @TargetApi(value=11)
    public Set<String> getStringSet(String object, Set<String> object2) {
        this.a((String)object);
        Set set = this.a.getStringSet((String)object, null);
        if (set != null) {
            HashSet<String> hashSet = new HashSet<String>();
            Iterator iterator = set.iterator();
            do {
                object = hashSet;
                if (iterator.hasNext()) {
                    hashSet.add(b.a((String)iterator.next()));
                    continue;
                }
                break;
            } while (true);
        } else {
            object = null;
        }
        if (set != null) {
            object2 = object;
        }
        return object2;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    class a
    implements SharedPreferences.Editor {
        private SharedPreferences.Editor b;

        a(SharedPreferences sharedPreferences) {
            this.b = sharedPreferences.edit();
        }

        public void apply() {
            this.b.apply();
        }

        public SharedPreferences.Editor clear() {
            this.b.clear();
            return this;
        }

        public boolean commit() {
            this.b.putBoolean("crypto", true);
            return this.b.commit();
        }

        public SharedPreferences.Editor putBoolean(String string2, boolean bl2) {
            a.this.a(string2);
            SharedPreferences.Editor editor = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("B\t");
            stringBuilder.append(bl2);
            editor.putString(string2, b.b(stringBuilder.toString()));
            return this;
        }

        public SharedPreferences.Editor putFloat(String string2, float f2) {
            a.this.a(string2);
            SharedPreferences.Editor editor = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("F\t");
            stringBuilder.append(f2);
            editor.putString(string2, b.b(stringBuilder.toString()));
            return this;
        }

        public SharedPreferences.Editor putInt(String string2, int n2) {
            a.this.a(string2);
            SharedPreferences.Editor editor = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("I\t");
            stringBuilder.append(n2);
            editor.putString(string2, b.b(stringBuilder.toString()));
            return this;
        }

        public SharedPreferences.Editor putLong(String string2, long l2) {
            a.this.a(string2);
            SharedPreferences.Editor editor = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("L\t");
            stringBuilder.append(l2);
            editor.putString(string2, b.b(stringBuilder.toString()));
            return this;
        }

        public SharedPreferences.Editor putString(String string2, String string3) {
            a.this.a(string2);
            SharedPreferences.Editor editor = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("S\t");
            stringBuilder.append(string3);
            editor.putString(string2, b.b(stringBuilder.toString()));
            return this;
        }

        @TargetApi(value=11)
        public SharedPreferences.Editor putStringSet(String string2, Set<String> object) {
            a.this.a(string2);
            if (object != null) {
                HashSet<String> hashSet = new HashSet<String>();
                object = object.iterator();
                while (object.hasNext()) {
                    hashSet.add(b.b((String)object.next()));
                }
                this.b.putStringSet(string2, hashSet);
            }
            return this;
        }

        public SharedPreferences.Editor remove(String string2) {
            a.this.a(string2);
            this.b.remove(string2);
            return this;
        }
    }

}

