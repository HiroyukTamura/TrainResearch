// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.utils;

import java.util.Date;
import jp.co.ncdc.apppot.stew.APException;
import android.database.Cursor;
import java.lang.reflect.Field;
import android.content.ContentValues;

public class DBUtils
{
    public static final ContentValues convertToContentValues(final Object obj) {
        final Field[] fields = obj.getClass().getFields();
        final ContentValues contentValues = new ContentValues();
        final int length = fields.length;
        int n = 0;
    Label_0050_Outer:
        while (true) {
            if (n >= length) {
                return contentValues;
            }
            final Field field = fields[n];
            final String name = field.getName();
        Label_0073_Outer:
            while (true) {
                Label_0057: {
                    if (!APObjectUtils.isExceptColumn(name)) {
                        break Label_0057;
                    }
                    ++n;
                    continue Label_0050_Outer;
                }
                String value = null;
                while (true) {
                    try {
                        value = String.valueOf(field.get(obj));
                        contentValues.put(name, value);
                        continue Label_0073_Outer;
                    }
                    catch (IllegalArgumentException ex) {
                        continue;
                    }
                    catch (IllegalAccessException ex2) {
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
    
    public static final byte[] getBlob(final Cursor cursor, final String str) {
        final int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1) {
            throw new APException(str + " is not exist");
        }
        return cursor.getBlob(columnIndex);
    }
    
    public static final Date getDate(final Cursor cursor, final String s) {
        return new Date(getLong(cursor, s));
    }
    
    public static final int getInt(final Cursor cursor, final String str) {
        final int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1) {
            throw new APException(str + " is not exist");
        }
        return cursor.getInt(columnIndex);
    }
    
    public static final long getLong(final Cursor cursor, final String str) {
        final int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1) {
            throw new APException(str + " is not exist");
        }
        return cursor.getLong(columnIndex);
    }
    
    public static final String getString(final Cursor cursor, final String str) {
        final int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1) {
            throw new APException(str + " is not exist");
        }
        return cursor.getString(columnIndex);
    }
}
