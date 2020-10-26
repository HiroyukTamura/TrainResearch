// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class APObjectUtils
{
    private static List<String> _exceptColumns;
    private static List<String> _localColumns;
    private static List<String> _serverColumns;
    
    static {
        APObjectUtils._localColumns = new ArrayList<String>();
        APObjectUtils._serverColumns = new ArrayList<String>();
        APObjectUtils._exceptColumns = new ArrayList<String>();
        APObjectUtils._localColumns.add("syncDataFlag");
        APObjectUtils._localColumns.add("serverCreateTime");
        APObjectUtils._localColumns.add("serverUpdateTime");
        APObjectUtils._localColumns.add("createUserId");
        APObjectUtils._localColumns.add("groupIds");
        APObjectUtils._localColumns.add("isUsingLockForUpdate");
        APObjectUtils._serverColumns.add("scopeType");
        APObjectUtils._exceptColumns.add("$change");
        APObjectUtils._exceptColumns.add("serverRecordStatus");
        APObjectUtils._exceptColumns.add("serialVersionUID");
    }
    
    public static Map<String, String> getFieldInfo(final Class<?> clazz) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final Field[] fields = clazz.getFields();
        for (int length = fields.length, i = 0; i < length; ++i) {
            final Field field = fields[i];
            hashMap.put(field.getName(), field.getType().getSimpleName());
        }
        return hashMap;
    }
    
    public static final boolean isDateType(final Class<?> clazz, final String s) {
        return "Date".equals(getFieldInfo(clazz).get(s));
    }
    
    public static boolean isExceptColumn(final String s) {
        return APObjectUtils._exceptColumns != null && APObjectUtils._exceptColumns.contains(s);
    }
    
    public static boolean isLocalColumn(final String s) {
        return APObjectUtils._localColumns != null && APObjectUtils._localColumns.contains(s);
    }
    
    public static boolean isServerColumn(final String s) {
        return APObjectUtils._serverColumns != null && APObjectUtils._serverColumns.contains(s);
    }
}
