// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.utils.StringUtils;
import android.text.TextUtils;
import java.util.Map;
import android.database.Cursor;
import java.util.ArrayList;
import android.content.ContentValues;
import java.lang.reflect.Field;
import java.util.Iterator;
import jp.co.ncdc.apppot.stew.dto.APLogging;
import jp.co.ncdc.apppot.stew.dto.APMessageQueue;
import jp.co.ncdc.apppot.stew.utils.APObjectUtils;
import jp.co.ncdc.apppot.stew.log.Logger;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;
import android.database.sqlite.SQLiteOpenHelper;

class APSQLiteOpenHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    private static final String TAG = "APSQLiteOpenHelper";
    private List<APObject> mTableList;
    
    public APSQLiteOpenHelper(final Context context) {
        super(context, "stew.db", (SQLiteDatabase$CursorFactory)null, 1);
        this.mTableList = null;
    }
    
    public APSQLiteOpenHelper(final Context context, final String s, final int n, final List<APObject> mTableList) {
        super(context, s, (SQLiteDatabase$CursorFactory)null, n);
        this.mTableList = null;
        this.mTableList = mTableList;
    }
    
    @Deprecated
    public APSQLiteOpenHelper(final Context context, final List<APObject> list) {
        this(context, list, 1);
    }
    
    public APSQLiteOpenHelper(final Context context, final List<APObject> mTableList, final int n) {
        super(context, "stew.db", (SQLiteDatabase$CursorFactory)null, n);
        this.mTableList = null;
        this.mTableList = mTableList;
    }
    
    private String convertToSQLiteColumnType(final String str) {
        if (str.equals("String") || str.equals("BigDecimal")) {
            return "text";
        }
        if (str.equals("float") || str.equals("double")) {
            return "real";
        }
        if (str.equals("int") || str.equals("long") || str.equals("boolean") || str.equals("Date")) {
            return "integer";
        }
        throw new APException("Column Type " + str + " is not support.");
    }
    
    private void createTables(final SQLiteDatabase sqLiteDatabase, final boolean b) {
        if (this.mTableList != null) {
            Logger.d("APSQLiteOpenHelper", "createDB start");
            for (final APObject apObject : this.mTableList) {
                final StringBuilder sb = new StringBuilder();
                final Class<? extends APObject> class1 = apObject.getClass();
                final Field[] fields = class1.getFields();
                final List<String> encryptedProperties = apObject.getEncryptedProperties();
                sb.append("CREATE TABLE IF NOT EXISTS " + class1.getSimpleName() + " ( ");
                int n = 0;
                int n2;
                for (int i = 0; i < fields.length; ++i, n = n2) {
                    final String name = fields[i].getName();
                    n2 = n;
                    if (!APObjectUtils.isExceptColumn(name)) {
                        if (APObjectUtils.isServerColumn(name)) {
                            n2 = n;
                        }
                        else {
                            final int n3 = n + 1;
                            if (n3 > 1) {
                                sb.append(", ");
                            }
                            final String simpleName = fields[i].getType().getSimpleName();
                            sb.append(name + " ");
                            if (encryptedProperties.contains(name)) {
                                sb.append("varchar");
                            }
                            else {
                                sb.append(this.convertToSQLiteColumnType(simpleName));
                            }
                            n2 = n3;
                            if ("objectId".equals(name)) {
                                sb.append(" PRIMARY KEY");
                                n2 = n3;
                            }
                        }
                    }
                }
                sb.append(" );");
                final String string = sb.toString();
                Logger.d("APSQLiteOpenHelper", "create db:" + string);
                sqLiteDatabase.execSQL(string);
            }
        }
        sqLiteDatabase.execSQL(APMessageQueue.createQuery());
        if (b) {
            sqLiteDatabase.execSQL(APLogging.createQuery());
        }
        Logger.d("APSQLiteOpenHelper", "createDB end");
    }
    
    public void beginTransaction() {
        this.getWritableDatabase().beginTransaction();
    }
    
    public void commit() {
        this.getWritableDatabase().setTransactionSuccessful();
    }
    
    public boolean delete(final String s, final String s2) {
        return this.delete(s, s2, null);
    }
    
    public boolean delete(final String s, final String str, final String[] array) {
        Logger.d("APSQLiteOpenHelper", "[delete]where=" + str);
        return this.getWritableDatabase().delete(s, str, array) > 0;
    }
    
    public void endTransaction() {
        this.getWritableDatabase().endTransaction();
    }
    
    public int insert(final String s, final ContentValues contentValues) {
        return this.insert(s, null, contentValues);
    }
    
    public int insert(final String s, final String s2, final ContentValues contentValues) {
        return (int)this.getWritableDatabase().insert(s, s2, contentValues);
    }
    
    public boolean isValidSQLiteDB() {
        return this.mTableList != null;
    }
    
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        Logger.d("APSQLiteOpenHelper", "onCreate");
        this.createTables(sqLiteDatabase, true);
    }
    
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, int i, final int n) {
        Logger.d("APSQLiteOpenHelper", "onUpgrade");
        if (i < n) {
            final Cursor rawQuery = sqLiteDatabase.rawQuery("select name from sqlite_master where type = 'table' and name not in ('android_metadata', 'sqlite_sequence', '" + APLogging.class.getSimpleName() + "')", (String[])null);
            rawQuery.moveToFirst();
            final ArrayList<String> list = new ArrayList<String>();
            for (i = 0; i < rawQuery.getCount(); ++i) {
                list.add("DROP TABLE IF EXISTS " + rawQuery.getString(0));
                rawQuery.moveToNext();
            }
            rawQuery.close();
            for (final String s : list) {
                sqLiteDatabase.execSQL(s);
                Logger.d("APSQLiteOpenHelper", s);
            }
            this.createTables(sqLiteDatabase, false);
        }
    }
    
    public Cursor query(final String s) {
        return this.query(s, null, null, null, null, null, null);
    }
    
    public Cursor query(final String s, final String s2) {
        return this.query(s, s2, null);
    }
    
    public Cursor query(final String s, final String s2, final String s3) {
        return this.query(s, s2, null, s3, null);
    }
    
    public Cursor query(final String s, final String s2, final String s3, final String s4) {
        return this.query(s, s2, null, s3, s4);
    }
    
    public Cursor query(final String s, final String s2, final String[] array, final String s3) {
        return this.query(s, s2, array, s3, null);
    }
    
    public Cursor query(final String s, final String str, final String[] array, final String s2, final String s3) {
        if (str != null) {
            Logger.d("APSQLiteOpenHelper", "[query]" + str);
        }
        return this.getWritableDatabase().query(s, (String[])null, str, array, (String)null, (String)null, s2, s3);
    }
    
    @Deprecated
    public Cursor query(final String s, final Map<String, Object> map) {
        final String s2 = null;
        final String[] array = null;
        final String s3 = null;
        final List<Map> list = map.get("searchConditions");
        String string = s2;
        String[] stringArray = array;
        if (list != null) {
            string = s2;
            stringArray = array;
            if (list.size() > 0) {
                final int size = list.size();
                final StringBuilder obj = new StringBuilder();
                final ArrayList<Object> list2 = new ArrayList<Object>();
                for (int i = 0; i < size; ++i) {
                    final Map<String, Object> map2 = list.get(i);
                    if (APQuery.isContainConditon(map2)) {
                        obj.append(" (");
                        obj.append(TextUtils.join((CharSequence)",", (Iterable)APQuery.getValue(map2)));
                        obj.append(")");
                        Logger.v("APSQLiteOpenHelper", "Where:" + (Object)obj);
                    }
                    else {
                        list2.add(APQuery.getValue(map2).get(0));
                    }
                    if (i + 1 < size) {
                        obj.append(" and ");
                    }
                }
                stringArray = StringUtils.toStringArray(list2);
                string = obj.toString();
            }
        }
        final List<Map> list3 = map.get("sortConditions");
        String string2 = s3;
        if (list3 != null) {
            string2 = s3;
            if (list3.size() > 0) {
                final int size2 = list3.size();
                final StringBuilder sb = new StringBuilder();
                for (int j = 0; j < size2; ++j) {
                    sb.append(APQuery.convertToSQLiteSort(list3.get(j)));
                    if (j + 1 < size2) {
                        sb.append(", ");
                    }
                }
                string2 = sb.toString();
            }
        }
        return this.query(s, string, stringArray, string2, null);
    }
    
    public Cursor query(final String s, final String[] array, final String s2, final String[] array2, final String s3, final String s4, final String s5) {
        return this.getWritableDatabase().query(s, array, s2, array2, s3, s4, s5);
    }
    
    public Cursor rawQuery(String string, final String str, final String str2, final String[] array, final String str3, final String str4) {
        final StringBuilder sb = new StringBuilder();
        sb.append("select * from ");
        sb.append(string);
        sb.append(str);
        if (str2 != null) {
            sb.append(" where ");
            sb.append(str2);
        }
        if (str3 != null && str3.length() > 0) {
            sb.append(" order by ");
            sb.append(str3);
        }
        if (str4 != null && str4.length() > 0) {
            sb.append(" limit ");
            sb.append(str4);
        }
        string = sb.toString();
        Logger.d("APSQLiteOpenHelper", "rawQuery=" + string);
        return this.getWritableDatabase().rawQuery(string, array);
    }
    
    public Cursor rawQuery(final String s, final String[] array) {
        return this.getWritableDatabase().rawQuery(s, array);
    }
    
    public void setTableList(final List<APObject> mTableList) {
        this.mTableList = mTableList;
    }
    
    public int tableCount(final String str, final String str2, final String str3, final String[] array) {
        final StringBuilder obj = new StringBuilder();
        obj.append("select count(*) from ");
        obj.append(str);
        if (str2 != null) {
            obj.append(str2);
        }
        if (str3 != null) {
            obj.append(" where ");
            obj.append(str3);
        }
        final Cursor rawQuery = this.getWritableDatabase().rawQuery(obj.toString(), array);
        rawQuery.moveToFirst();
        final int int1 = rawQuery.getInt(0);
        Logger.d("APSQLiteOpenHelper", "sql:" + (Object)obj + ", count=" + int1);
        return int1;
    }
    
    public int update(final String s, final ContentValues contentValues, final String s2, final String[] array) {
        return this.getWritableDatabase().update(s, contentValues, s2, array);
    }
}
