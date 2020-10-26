/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.mixpanel.android.b.k;
import com.mixpanel.android.c.f;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class l {
    private static final Map<Context, l> a = new HashMap<Context, l>();
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private final a f;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(b.a.a());
        stringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilder.append("data");
        stringBuilder.append(" STRING NOT NULL, ");
        stringBuilder.append("created_at");
        stringBuilder.append(" INTEGER NOT NULL, ");
        stringBuilder.append("automatic_data");
        stringBuilder.append(" INTEGER DEFAULT 0, ");
        stringBuilder.append("token");
        stringBuilder.append(" STRING NOT NULL DEFAULT '')");
        b = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(b.b.a());
        stringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilder.append("data");
        stringBuilder.append(" STRING NOT NULL, ");
        stringBuilder.append("created_at");
        stringBuilder.append(" INTEGER NOT NULL, ");
        stringBuilder.append("automatic_data");
        stringBuilder.append(" INTEGER DEFAULT 0, ");
        stringBuilder.append("token");
        stringBuilder.append(" STRING NOT NULL DEFAULT '')");
        c = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        stringBuilder.append(b.a.a());
        stringBuilder.append(" (");
        stringBuilder.append("created_at");
        stringBuilder.append(");");
        d = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        stringBuilder.append(b.b.a());
        stringBuilder.append(" (");
        stringBuilder.append("created_at");
        stringBuilder.append(");");
        e = stringBuilder.toString();
    }

    public l(Context context) {
        this(context, "mixpanel");
    }

    public l(Context context, String string2) {
        this.f = new a(context, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static l a(Context object) {
        Map<Context, l> map = a;
        synchronized (map) {
            Context context = object.getApplicationContext();
            if (a.containsKey((Object)context)) return a.get((Object)context);
            object = new l(context);
            a.put(context, (l)object);
            return object;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void b(b var1_1, String var2_3) {
        var1_1 = var1_1.a();
        var3_5 = this.f.getWritableDatabase();
        var4_7 = new StringBuilder();
        var4_7.append("automatic_data = 1 AND token = '");
        var4_7.append(var2_3);
        var4_7.append("'");
        var3_5.delete((String)var1_1, var4_7.toString(), null);
lbl9: // 2 sources:
        do {
            this.f.close();
            return;
            break;
        } while (true);
        {
            catch (Throwable var1_2) {
            }
            catch (SQLiteException var2_4) {}
            {
                var3_6 = new StringBuilder();
                var3_6.append("Could not clean automatic Mixpanel records from ");
                var3_6.append((String)var1_1);
                var3_6.append(". Re-initializing database.");
                f.e("MixpanelAPI.Database", var3_6.toString(), (Throwable)var2_4);
                this.f.a();
                ** continue;
            }
        }
        this.f.close();
        throw var1_2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public int a(JSONObject object, String object2, b object3, boolean bl2) {
        void var1_4;
        block13 : {
            block14 : {
                StringBuilder stringBuilder;
                Object var6_11;
                String string2;
                block12 : {
                    int n2;
                    block11 : {
                        if (!this.c()) {
                            f.e("MixpanelAPI.Database", "There is not enough space left on the device to store Mixpanel data, so data was discarded");
                            return -2;
                        }
                        string2 = ((b)((Object)object3)).a();
                        var6_11 = null;
                        stringBuilder = null;
                        object3 = stringBuilder;
                        SQLiteDatabase sQLiteDatabase = this.f.getWritableDatabase();
                        object3 = stringBuilder;
                        ContentValues contentValues = new ContentValues();
                        object3 = stringBuilder;
                        contentValues.put("data", object.toString());
                        object3 = stringBuilder;
                        contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                        object3 = stringBuilder;
                        contentValues.put("automatic_data", Boolean.valueOf(bl2));
                        object3 = stringBuilder;
                        contentValues.put("token", (String)object2);
                        object3 = stringBuilder;
                        sQLiteDatabase.insert(string2, null, contentValues);
                        object3 = stringBuilder;
                        object = new StringBuilder();
                        object3 = stringBuilder;
                        ((StringBuilder)object).append("SELECT COUNT(*) FROM ");
                        object3 = stringBuilder;
                        ((StringBuilder)object).append(string2);
                        object3 = stringBuilder;
                        ((StringBuilder)object).append(" WHERE token='");
                        object3 = stringBuilder;
                        ((StringBuilder)object).append((String)object2);
                        object3 = stringBuilder;
                        ((StringBuilder)object).append("'");
                        object3 = stringBuilder;
                        object2 = object = sQLiteDatabase.rawQuery(((StringBuilder)object).toString(), null);
                        try {
                            object.moveToFirst();
                            object2 = object;
                            n2 = object.getInt(0);
                            if (object == null) break block11;
                        }
                        catch (SQLiteException sQLiteException) {
                            break block12;
                        }
                        object.close();
                    }
                    this.f.close();
                    return n2;
                    catch (Throwable throwable) {
                        object2 = object3;
                        break block13;
                    }
                    catch (SQLiteException sQLiteException) {
                        object = null;
                    }
                }
                object2 = object;
                try {
                    stringBuilder = new StringBuilder();
                    object2 = object;
                    stringBuilder.append("Could not add Mixpanel data to table ");
                    object2 = object;
                    stringBuilder.append(string2);
                    object2 = object;
                    stringBuilder.append(". Re-initializing database.");
                    object2 = object;
                    f.e("MixpanelAPI.Database", stringBuilder.toString(), (Throwable)object3);
                    if (object != null) {
                        object2 = object;
                        object.close();
                        object = var6_11;
                    }
                    object3 = object;
                    {
                        this.f.a();
                        if (object == null) break block14;
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                object.close();
            }
            this.f.close();
            return -1;
        }
        if (object2 != null) {
            object2.close();
        }
        this.f.close();
        throw var1_4;
    }

    public void a() {
        this.f.a();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(long var1_1, b var3_2) {
        var3_2 = var3_2.a();
        var4_4 = this.f.getWritableDatabase();
        var5_6 = new StringBuilder();
        var5_6.append("created_at <= ");
        var5_6.append(var1_1);
        var4_4.delete((String)var3_2, var5_6.toString(), null);
lbl8: // 2 sources:
        do {
            this.f.close();
            return;
            break;
        } while (true);
        {
            catch (Throwable var3_3) {
            }
            catch (SQLiteException var4_5) {}
            {
                var5_7 = new StringBuilder();
                var5_7.append("Could not clean timed-out Mixpanel records from ");
                var5_7.append((String)var3_2);
                var5_7.append(". Re-initializing database.");
                f.e("MixpanelAPI.Database", var5_7.toString(), (Throwable)var4_5);
                this.f.a();
                ** continue;
            }
        }
        this.f.close();
        throw var3_3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(b var1_1, String var2_3) {
        var1_1 = var1_1.a();
        var3_5 = this.f.getWritableDatabase();
        var4_7 = new StringBuilder();
        var4_7.append("token = '");
        var4_7.append(var2_3);
        var4_7.append("'");
        var3_5.delete((String)var1_1, var4_7.toString(), null);
lbl9: // 2 sources:
        do {
            this.f.close();
            return;
            break;
        } while (true);
        {
            catch (Throwable var1_2) {
            }
            catch (SQLiteException var2_4) {}
            {
                var3_6 = new StringBuilder();
                var3_6.append("Could not clean timed-out Mixpanel records from ");
                var3_6.append((String)var1_1);
                var3_6.append(". Re-initializing database.");
                f.e("MixpanelAPI.Database", var3_6.toString(), (Throwable)var2_4);
                this.f.a();
                ** continue;
            }
        }
        this.f.close();
        throw var1_2;
    }

    public void a(String string2) {
        synchronized (this) {
            this.b(b.a, string2);
            this.b(b.b, string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String charSequence, b object, String charSequence2, boolean bl2) {
        object = ((b)((Object)object)).a();
        try {
            try {
                SQLiteDatabase sQLiteDatabase = this.f.getWritableDatabase();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("_id <= ");
                stringBuilder.append((String)charSequence);
                stringBuilder.append(" AND ");
                stringBuilder.append("token");
                stringBuilder.append(" = '");
                stringBuilder.append((String)charSequence2);
                stringBuilder.append("'");
                charSequence = new StringBuffer(stringBuilder.toString());
                if (!bl2) {
                    ((StringBuffer)charSequence).append(" AND automatic_data=0");
                }
                sQLiteDatabase.delete((String)object, ((StringBuffer)charSequence).toString(), null);
            }
            catch (SQLiteException sQLiteException) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append("Could not clean sent Mixpanel records from ");
                ((StringBuilder)charSequence2).append((String)object);
                ((StringBuilder)charSequence2).append(". Re-initializing database.");
                f.e("MixpanelAPI.Database", ((StringBuilder)charSequence2).toString(), (Throwable)sQLiteException);
                this.f.a();
            }
        }
        catch (Throwable throwable2) {}
        this.f.close();
        return;
        this.f.close();
        throw throwable2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String[] a(b var1_1, String var2_2, boolean var3_3) {
        block29 : {
            block27 : {
                block30 : {
                    block28 : {
                        var8_4 = var1_1.a();
                        var5_5 = this.f.getReadableDatabase();
                        var4_18 = null;
                        var1_1 = new StringBuilder();
                        var1_1.append("SELECT * FROM ");
                        var1_1.append((String)var8_4);
                        var1_1.append(" WHERE ");
                        var1_1.append("token");
                        var1_1.append(" = '");
                        var1_1.append((String)var2_2);
                        var1_1.append("' ");
                        var1_1 = new StringBuffer(var1_1.toString());
                        var6_23 = new StringBuilder();
                        var6_23.append("SELECT COUNT(*) FROM ");
                        var6_23.append((String)var8_4);
                        var6_23.append(" WHERE ");
                        var6_23.append("token");
                        var6_23.append(" = '");
                        var6_23.append((String)var2_2);
                        var6_23.append("' ");
                        var2_2 = new StringBuffer(var6_23.toString());
                        if (!var3_3) {
                            var1_1.append("AND automatic_data = 0 ");
                            var2_2.append(" AND automatic_data = 0");
                        }
                        var1_1.append("ORDER BY created_at ASC LIMIT 50");
                        var1_1 = var5_5.rawQuery(var1_1.toString(), null);
                        var5_6 = var5_5.rawQuery(var2_2.toString(), null);
                        var6_23 = var5_6;
                        try {
                            var6_23.moveToFirst();
                            var7_26 = String.valueOf(var6_23.getInt(0));
                            try {
                                var4_18 = new JSONArray();
                                var2_2 = null;
lbl38: // 2 sources:
                                do {
                                    if (var1_1.moveToNext()) {
                                        if (var1_1.isLast()) {
                                            var2_2 = var1_1.getString(var1_1.getColumnIndex("_id"));
                                        }
                                        var4_18.put((Object)new JSONObject(var1_1.getString(var1_1.getColumnIndex("data"))));
                                    }
                                    var4_18 = var4_18.length() > 0 ? var4_18.toString() : null;
                                    this.f.close();
                                    if (var1_1 != null) {
                                        var1_1.close();
                                    }
                                    var8_4 = var7_26;
                                    var5_7 = var4_18;
                                    var1_1 = var2_2;
                                    if (var6_23 != null) {
                                        var6_23.close();
                                        var8_4 = var7_26;
                                        var5_8 = var4_18;
                                        var1_1 = var2_2;
                                    }
                                    break block27;
                                    break;
                                } while (true);
                                catch (SQLiteException var4_21) {
                                    var2_2 = null;
                                    break block28;
                                }
                                catch (Throwable var4_22) {
                                    var2_2 = null;
                                    break block29;
                                }
                                catch (SQLiteException var6_24) {
                                    var5_10 = null;
                                    var2_2 = var5_10;
                                    var4_18 = var1_1;
                                    var1_1 = var5_10;
                                    var5_11 = var6_24;
                                    break block30;
                                }
                                catch (Throwable var5_12) {
                                    var2_2 = null;
                                    var1_1 = var4_18;
                                    var4_18 = var5_12;
                                    break block29;
                                }
                                catch (SQLiteException var5_13) {
                                    var2_2 = var1_1 = (var4_18 = null);
                                    break block30;
                                }
                                catch (JSONException var9_27) {}
                                ** continue;
                            }
                            catch (SQLiteException var4_19) {
                                var2_2 = var7_26;
                            }
                        }
                        catch (Throwable var4_20) {
                            var2_2 = var6_23;
                            break block29;
                        }
                    }
                    var6_23 = var1_1;
                    var1_1 = var5_6;
                    var5_9 = var4_18;
                    var4_18 = var6_23;
                }
                try {
                    var6_23 = new StringBuilder();
                    var6_23.append("Could not pull records for Mixpanel out of database ");
                    var6_23.append((String)var8_4);
                    var6_23.append(". Waiting to send.");
                    f.e("MixpanelAPI.Database", var6_23.toString(), (Throwable)var5_14);
                }
                catch (Throwable var6_25) {
                    var5_17 = var4_18;
                    var2_2 = var1_1;
                    var4_18 = var6_25;
                    var1_1 = var5_17;
                }
                this.f.close();
                if (var4_18 != null) {
                    var4_18.close();
                }
                if (var1_1 != null) {
                    var1_1.close();
                }
                var5_15 = var1_1 = null;
                var8_4 = var2_2;
            }
            if (var1_1 != null && var5_16 != null) {
                return new String[]{var1_1, var5_16, var8_4};
            }
            return null;
        }
        this.f.close();
        if (var1_1 != null) {
            var1_1.close();
        }
        if (var2_2 != null) {
            var2_2.close();
        }
        throw var4_18;
    }

    public File b() {
        return this.f.a;
    }

    protected boolean c() {
        return this.f.b();
    }

    private static class a
    extends SQLiteOpenHelper {
        private final File a;
        private final k b;

        a(Context context, String string2) {
            super(context, string2, null, 5);
            this.a = context.getDatabasePath(string2);
            this.b = k.a(context);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void a(SQLiteDatabase sQLiteDatabase) {
            StringBuilder stringBuilder;
            int n2;
            String string2;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("ALTER TABLE ");
            stringBuilder2.append(b.a.a());
            stringBuilder2.append(" ADD COLUMN ");
            stringBuilder2.append("automatic_data");
            stringBuilder2.append(" INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("ALTER TABLE ");
            stringBuilder2.append(b.b.a());
            stringBuilder2.append(" ADD COLUMN ");
            stringBuilder2.append("automatic_data");
            stringBuilder2.append(" INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("ALTER TABLE ");
            stringBuilder2.append(b.a.a());
            stringBuilder2.append(" ADD COLUMN ");
            stringBuilder2.append("token");
            stringBuilder2.append(" STRING NOT NULL DEFAULT ''");
            sQLiteDatabase.execSQL(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("ALTER TABLE ");
            stringBuilder2.append(b.b.a());
            stringBuilder2.append(" ADD COLUMN ");
            stringBuilder2.append("token");
            stringBuilder2.append(" STRING NOT NULL DEFAULT ''");
            sQLiteDatabase.execSQL(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("SELECT * FROM ");
            stringBuilder2.append(b.a.a());
            stringBuilder2 = sQLiteDatabase.rawQuery(stringBuilder2.toString(), null);
            do {
                if (!stringBuilder2.moveToNext()) break;
                try {
                    string2 = new JSONObject(stringBuilder2.getString(stringBuilder2.getColumnIndex("data"))).getJSONObject("properties").getString("token");
                    n2 = stringBuilder2.getInt(stringBuilder2.getColumnIndex("_id"));
                }
                catch (JSONException jSONException) {}
                try {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("UPDATE ");
                    stringBuilder.append(b.a.a());
                    stringBuilder.append(" SET ");
                    stringBuilder.append("token");
                    stringBuilder.append(" = '");
                    stringBuilder.append(string2);
                    stringBuilder.append("' WHERE _id = ");
                    stringBuilder.append(n2);
                    sQLiteDatabase.execSQL(stringBuilder.toString());
                    continue;
                }
                catch (JSONException jSONException) {}
                n2 = 0;
                string2 = b.a.a();
                stringBuilder = new StringBuilder();
                stringBuilder.append("_id = ");
                stringBuilder.append(n2);
                sQLiteDatabase.delete(string2, stringBuilder.toString(), null);
            } while (true);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("SELECT * FROM ");
            stringBuilder2.append(b.b.a());
            stringBuilder2 = sQLiteDatabase.rawQuery(stringBuilder2.toString(), null);
            while (stringBuilder2.moveToNext()) {
                try {
                    string2 = new JSONObject(stringBuilder2.getString(stringBuilder2.getColumnIndex("data"))).getString("$token");
                    n2 = stringBuilder2.getInt(stringBuilder2.getColumnIndex("_id"));
                }
                catch (JSONException jSONException) {}
                try {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("UPDATE ");
                    stringBuilder.append(b.b.a());
                    stringBuilder.append(" SET ");
                    stringBuilder.append("token");
                    stringBuilder.append(" = '");
                    stringBuilder.append(string2);
                    stringBuilder.append("' WHERE _id = ");
                    stringBuilder.append(n2);
                    sQLiteDatabase.execSQL(stringBuilder.toString());
                    continue;
                }
                catch (JSONException jSONException) {}
                n2 = 0;
                string2 = b.b.a();
                stringBuilder = new StringBuilder();
                stringBuilder.append("_id = ");
                stringBuilder.append(n2);
                sQLiteDatabase.delete(string2, stringBuilder.toString(), null);
            }
            return;
        }

        public void a() {
            this.close();
            this.a.delete();
        }

        public boolean b() {
            boolean bl2 = this.a.exists();
            boolean bl3 = true;
            if (bl2) {
                if (Math.max(this.a.getUsableSpace(), (long)this.b.d()) >= this.a.length()) {
                    return true;
                }
                bl3 = false;
            }
            return bl3;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            f.a("MixpanelAPI.Database", "Creating a new Mixpanel events DB");
            sQLiteDatabase.execSQL(b);
            sQLiteDatabase.execSQL(c);
            sQLiteDatabase.execSQL(d);
            sQLiteDatabase.execSQL(e);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
            f.a("MixpanelAPI.Database", "Upgrading app, replacing Mixpanel events DB");
            if (n3 == 5) {
                this.a(sQLiteDatabase);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DROP TABLE IF EXISTS ");
            stringBuilder.append(b.a.a());
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("DROP TABLE IF EXISTS ");
            stringBuilder.append(b.b.a());
            sQLiteDatabase.execSQL(stringBuilder.toString());
            sQLiteDatabase.execSQL(b);
            sQLiteDatabase.execSQL(c);
            sQLiteDatabase.execSQL(d);
            sQLiteDatabase.execSQL(e);
        }
    }

    public static enum b {
        a("events"),
        b("people");
        
        private final String c;

        private b(String string3) {
            this.c = string3;
        }

        public String a() {
            return this.c;
        }
    }

}

