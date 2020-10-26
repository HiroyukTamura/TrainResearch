// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.utils.StringUtils;
import jp.co.ncdc.apppot.stew.log.Logger;
import android.text.TextUtils;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APQuery
{
    public static final String AND = "AND";
    private static final String IGNORE_CASE = " COLLATE NOCASE ";
    private static final String KEY_ALIAS_NAME = "tableAlias";
    static final String KEY_BASE_COLUMN = "baseColumn";
    static final String KEY_BASE_OBJECT = "baseObjectName";
    private static final String KEY_IGNORE_CASE = "isIgnoreCase";
    static final String KEY_JOIN_ALIAS = "joinAlias";
    static final String KEY_JOIN_COLUMN = "joinColumn";
    static final String KEY_JOIN_CONDITIONS = "joinConditions";
    static final String KEY_JOIN_OBJECT = "joinObjectName";
    private static final String KEY_JOIN_TYPE = "joinType";
    private static final String KEY_NAME = "columnName";
    static final String KEY_SCOPE_TYPE = "scope";
    static final String KEY_SEARCH_CONDITIONS = "searchConditions";
    static final String KEY_SORT_CONDITIONS = "sortConditions";
    private static final String KEY_TABLE_NAME = "tableName";
    private static final String KEY_TYPE = "type";
    private static final String KEY_VALUE = "conditionValue";
    static final String KEY_WHERE_CONDITIONS = "whereConditions";
    public static final String OR = "OR";
    private static final int PER_PAGE_ROW = 1000;
    public static final String SEARCH_CONTAIN = "8";
    public static final String SEARCH_EQUAL = "1";
    public static final String SEARCH_GREATER_THAN = "4";
    public static final String SEARCH_GREATER_THAN_OR_EQUAL = "5";
    public static final String SEARCH_LESS_THAN = "6";
    public static final String SEARCH_LESS_THAN_OR_EQUAL = "7";
    public static final String SEARCH_LIKE = "3";
    public static final String SEARCH_NOT_CONTAIN = "9";
    public static final String SEARCH_NOT_EQUAL = "2";
    private static final String SORT_ASC = "1";
    private static final String SORT_DEFAULT = "0";
    private static final String SORT_DESC = "2";
    private static final String TAG = "APQuery";
    private static int sTableAliasCount;
    public String baseColumn;
    public String baseObjectName;
    public String joinColumn;
    public APQuery joinQuery;
    public JoinType joinType;
    private String mClassName;
    private Map<String, Object> mCondition;
    private List<Map<String, Object>> mJoinCondition;
    private List<Map<String, Object>> mSearchConditionList;
    private List<Map<String, String>> mSortCondition;
    private Class<?> mTable;
    private String mTableAlias;
    public int maxRecord;
    public int pageIndex;
    protected List<Class<?>> returnObjects;
    public List<Map<String, Object>> whereCondition;
    
    static {
        APQuery.sTableAliasCount = 0;
    }
    
    public APQuery(final Class<?> mTable) {
        this(mTable.getSimpleName());
        this.mTable = mTable;
    }
    
    public APQuery(final Class<?> clazz, final List<Class<?>> returnObjects) {
        this(clazz);
        this.returnObjects = returnObjects;
    }
    
    public APQuery(final String mClassName) {
        this.mTable = null;
        this.mSortCondition = null;
        this.mJoinCondition = null;
        this.mSearchConditionList = null;
        this.mCondition = null;
        this.whereCondition = null;
        this.pageIndex = 1;
        this.maxRecord = 1000;
        this.joinColumn = null;
        this.baseObjectName = null;
        this.baseColumn = null;
        this.joinType = JoinType.INNER;
        this.mClassName = mClassName;
        this.mTableAlias = this.mClassName.substring(0, 1) + APQuery.sTableAliasCount;
        ++APQuery.sTableAliasCount;
        this.mCondition = new HashMap<String, Object>();
    }
    
    private void addSearchCondition(final Map<String, Object> map, final String s) {
        if (this.mSearchConditionList == null || s != null) {
            this.mSearchConditionList = new ArrayList<Map<String, Object>>();
            final HashMap<String, List<Map<String, Object>>> hashMap = new HashMap<String, List<Map<String, Object>>>();
            hashMap.put("searchConditions", this.mSearchConditionList);
            hashMap.put("type", (List<Map<String, Object>>)s);
            if (this.whereCondition == null) {
                this.whereCondition = new ArrayList<Map<String, Object>>();
            }
            this.whereCondition.add((Map<String, Object>)hashMap);
        }
        this.mSearchConditionList.add(map);
    }
    
    private List<String> checkValue(final List<Object> list) {
        final ArrayList<String> list2 = new ArrayList<String>();
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(this.toTypeValue(iterator.next()));
        }
        return list2;
    }
    
    protected static String convertToSQLiteSort(final Map<String, String> map) {
        final StringBuilder sb = new StringBuilder();
        sb.append(map.get("tableName") + ".");
        sb.append(map.get("columnName"));
        if ("2".equals(map.get("conditionValue"))) {
            sb.append(" DESC");
        }
        else {
            sb.append(" ASC");
        }
        return sb.toString();
    }
    
    protected static List<Object> getValue(final Map<String, Object> map) {
        return map.get("conditionValue");
    }
    
    static void initTableAliasCount() {
        APQuery.sTableAliasCount = 0;
    }
    
    protected static boolean isContainConditon(final Map<String, Object> map) {
        final String value = String.valueOf(map.get("type"));
        return "8".equals(value) || "9".equals(value);
    }
    
    private APQuery makeJoinQuery(final Class<?> clazz, final Class<?> clazz2, final String baseColumn, final String joinColumn) {
        final APQuery apQuery = new APQuery(clazz);
        apQuery.baseObjectName = clazz2.getSimpleName();
        apQuery.baseColumn = baseColumn;
        apQuery.joinColumn = joinColumn;
        return apQuery;
    }
    
    private String toStringJoinType(final int n) {
        if (n == JoinType.INNER.getValue()) {
            return " inner join ";
        }
        return " left outer join ";
    }
    
    private String toTypeValue(final Object o) {
        int n = 0;
        if (o instanceof Integer) {
            n = 1;
        }
        else if (o instanceof Long) {
            n = 1;
        }
        else if (o instanceof Double) {
            n = 1;
        }
        else if (o instanceof Float) {
            n = 1;
        }
        else if (o instanceof Boolean) {
            n = 1;
        }
        if (n == 0) {
            return "'" + o + "'";
        }
        return String.valueOf(o);
    }
    
    public void addJoin(final Class<?> clazz, final Class<?> clazz2, final String s, final String s2) {
        this.addJoin(this.makeJoinQuery(clazz, clazz2, s, s2));
    }
    
    public void addJoin(final Class<?> clazz, final String s, final String s2) {
        this.addJoin(clazz, this.getTableClass(), s, s2);
    }
    
    public void addJoin(final APQuery joinQuery) {
        this.joinQuery = joinQuery;
        String s = null;
        if (joinQuery == null) {
            s = "joinQuery Object is Null";
        }
        else if (joinQuery.joinColumn == null) {
            s = "It is necessary to set joinColumn to JoinQuery...";
        }
        else if (joinQuery.baseColumn == null) {
            s = "It is necessary to set baseColumn to JoinQuery...";
        }
        if (s != null) {
            throw new IllegalArgumentException(s);
        }
        if (joinQuery.baseObjectName == null) {
            joinQuery.baseObjectName = this.getTableName();
        }
        final HashMap<String, List<Map<String, Object>>> hashMap = new HashMap<String, List<Map<String, Object>>>();
        hashMap.put("joinObjectName", joinQuery.getTableName());
        hashMap.put("joinAlias", (List<Map<String, Object>>)joinQuery.getAlias());
        hashMap.put("joinColumn", (List<Map<String, Object>>)joinQuery.joinColumn);
        hashMap.put("baseObjectName", (List<Map<String, Object>>)joinQuery.baseObjectName);
        hashMap.put("baseColumn", (List<Map<String, Object>>)joinQuery.baseColumn);
        hashMap.put("joinType", (List<Map<String, Object>>)joinQuery.joinType.getValue());
        if (joinQuery.whereCondition != null) {
            hashMap.put("whereConditions", joinQuery.whereCondition);
        }
        if (this.mJoinCondition == null) {
            this.mJoinCondition = new ArrayList<Map<String, Object>>();
        }
        this.mJoinCondition.add((Map<String, Object>)hashMap);
        this.mCondition.put("joinConditions", this.mJoinCondition);
    }
    
    public void addLeftOuterJoin(final Class<?> clazz, final Class<?> clazz2, final String s, final String s2) {
        final APQuery joinQuery = this.makeJoinQuery(clazz, clazz2, s, s2);
        joinQuery.joinType = JoinType.LEFT_OUTER;
        this.addJoin(joinQuery);
    }
    
    public void addLeftOuterJoin(final Class<?> clazz, final String s, final String s2) {
        this.addLeftOuterJoin(clazz, this.getTableClass(), s, s2);
    }
    
    public void addWhere(final Class<?> clazz, final String s, final Object o, final String s2, final String s3) {
        this.addWhere(clazz, s, o, s2, s3, false);
    }
    
    public void addWhere(final Class<?> clazz, final String s, final Object o, final String s2, final String s3, final boolean b) {
        if (s3 != null && !s3.equals("AND") && !s3.equals("OR")) {
            throw new IllegalArgumentException("whereType is not APQuery.AND or APQuery.OR");
        }
        String s4;
        if (clazz == null) {
            s4 = this.getTableName();
        }
        else {
            s4 = clazz.getSimpleName();
        }
        final HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
        hashMap.put("type", Integer.valueOf(Integer.parseInt(s2)));
        hashMap.put("columnName", (Boolean)s);
        hashMap.put("tableName", (Boolean)s4);
        if (this.mJoinCondition != null) {
            hashMap.put("tableAlias", (Boolean)this.getAlias());
        }
        hashMap.put("isIgnoreCase", b);
        if (o instanceof List) {
            hashMap.put("conditionValue", (Boolean)o);
        }
        else {
            final APObject instance = APObject.newInstance(clazz);
            Object encrypt = o;
            if (s2.equals("1")) {
                encrypt = o;
                if (instance.isEncryptedProperties(s)) {
                    encrypt = APEntityManager.getInstance().encrypt((String)o);
                }
            }
            final ArrayList<Object> list = new ArrayList<Object>();
            list.add(encrypt);
            hashMap.put("conditionValue", (Boolean)list);
        }
        this.addSearchCondition((Map<String, Object>)hashMap, s3);
    }
    
    public void addWhere(final String s, final Object o, final String s2, final String s3) {
        this.addWhere(this.getTableClass(), s, o, s2, s3);
    }
    
    public void addWhereContain(final Class<?> clazz, final String s, final List<Object> list, final String s2) {
        this.addWhere(clazz, s, list, "8", s2);
    }
    
    public void addWhereContain(final String s, final List<Object> list, final String s2) {
        this.addWhereContain(this.getTableClass(), s, list, s2);
    }
    
    public void addWhereEqual(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, "1", s2);
    }
    
    public void addWhereEqual(final String s, final Object o, final String s2) {
        this.addWhereEqual(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereEqualIgnoreCase(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhereIgnoreCase(clazz, s, o, "1", s2);
    }
    
    public void addWhereEqualIgnoreCase(final String s, final Object o, final String s2) {
        this.addWhereEqualIgnoreCase(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereGreateThan(final String s, final Object o, final String s2) {
        this.addWhereGreaterThan(s, o, s2);
    }
    
    public void addWhereGreateThanOrEqual(final String s, final Object o, final String s2) {
        this.addWhereGreaterThanOrEqual(s, o, s2);
    }
    
    public void addWhereGreaterThan(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, "4", s2);
    }
    
    public void addWhereGreaterThan(final String s, final Object o, final String s2) {
        this.addWhereGreaterThan(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereGreaterThanOrEqual(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, "5", s2);
    }
    
    public void addWhereGreaterThanOrEqual(final String s, final Object o, final String s2) {
        this.addWhereGreaterThanOrEqual(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereIgnoreCase(final Class<?> clazz, final String s, final Object o, final String s2, final String s3) {
        this.addWhere(clazz, s, o, s2, s3, true);
    }
    
    public void addWhereIgnoreCase(final String s, final Object o, final String s2, final String s3) {
        this.addWhereIgnoreCase(this.getTableClass(), s, o, s2, s3);
    }
    
    public void addWhereLessThan(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, "6", s2);
    }
    
    public void addWhereLessThan(final String s, final Object o, final String s2) {
        this.addWhereLessThan(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereLessThanOrEqual(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, "7", s2);
    }
    
    public void addWhereLessThanOrEqual(final String s, final Object o, final String s2) {
        this.addWhereLessThanOrEqual(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereLike(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, "3", s2);
    }
    
    public void addWhereLike(final String s, final Object o, final String s2) {
        this.addWhereLike(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereLikeIgnoreCase(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhereIgnoreCase(clazz, s, o, "3", s2);
    }
    
    public void addWhereLikeIgnoreCase(final String s, final Object o, final String s2) {
        this.addWhereLikeIgnoreCase(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereNotEqual(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, "2", s2);
    }
    
    public void addWhereNotEqual(final String s, final Object o, final String s2) {
        this.addWhereNotEqual(this.getTableClass(), s, o, s2);
    }
    
    public void addWhereNotEqualIgnoreCase(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhereIgnoreCase(clazz, s, o, "2", s2);
    }
    
    public void addWhereNotEqualIgnoreCase(final String s, final Object o, final String s2) {
        this.addWhereNotEqualIgnoreCase(this.getTableClass(), s, o, s2);
    }
    
    protected String convertToSQLiteCondition(final Map<String, Object> map) {
        return this.convertToSQLiteCondition(map, false);
    }
    
    protected String convertToSQLiteCondition(final Map<String, Object> map, final boolean b) {
        final StringBuilder sb = new StringBuilder();
        if (this.mJoinCondition != null) {
            sb.append(map.get("tableAlias") + "." + map.get("columnName"));
        }
        else {
            sb.append(map.get("columnName"));
        }
        final String value = String.valueOf(map.get("type"));
        String typeValue = "?";
        String str;
        if ("8".equals(value)) {
            str = " in ";
            typeValue = null;
        }
        else if ("9".equals(value)) {
            str = " not in ";
            typeValue = null;
        }
        else if ("2".equals(value)) {
            str = " != ";
        }
        else if ("3".equals(value)) {
            str = " like ";
        }
        else if ("4".equals(value)) {
            str = " > ";
        }
        else if ("5".equals(value)) {
            str = " >= ";
        }
        else if ("6".equals(value)) {
            str = " < ";
        }
        else if ("7".equals(value)) {
            str = " <= ";
        }
        else {
            str = " = ";
        }
        sb.append(str);
        if (b) {
            typeValue = this.toTypeValue(getValue(map).get(0));
        }
        if (typeValue != null) {
            sb.append(typeValue);
        }
        final Boolean b2 = map.get("isIgnoreCase");
        if (b2 != null && b2) {
            sb.append(" COLLATE NOCASE ");
        }
        return sb.toString();
    }
    
    public APObject getAPObject() {
        return APObject.newInstance(this.mTable);
    }
    
    public String getAlias() {
        return this.mTableAlias;
    }
    
    public Map<String, Object> getCondition() {
        if (!this.mCondition.containsKey("whereConditions")) {
            this.mCondition.put("whereConditions", this.whereCondition);
        }
        return this.mCondition;
    }
    
    public Class<?> getTableClass() {
        return this.mTable;
    }
    
    public String getTableName() {
        return this.mClassName;
    }
    
    public void groupWhere(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, s2, null);
    }
    
    public void groupWhere(final String s, final Object o, final String s2) {
        this.groupWhere(this.getTableClass(), s, o, s2);
    }
    
    public void groupWhereContain(final Class<?> clazz, final String s, final List<Object> list) {
        this.groupWhere(clazz, s, list, "8");
    }
    
    public void groupWhereContain(final String s, final List<Object> list) {
        this.groupWhereContain(this.getTableClass(), s, list);
    }
    
    public void groupWhereEqual(final Class<?> clazz, final String s, final Object o) {
        this.groupWhere(clazz, s, o, "1");
    }
    
    public void groupWhereEqual(final String s, final Object o) {
        this.groupWhereEqual(this.getTableClass(), s, o);
    }
    
    public void groupWhereEqualIgnoreCase(final Class<?> clazz, final String s, final Object o) {
        this.groupWhereIgnoreCase(clazz, s, o, "1");
    }
    
    public void groupWhereEqualIgnoreCase(final String s, final Object o) {
        this.groupWhereEqualIgnoreCase(this.getTableClass(), s, o);
    }
    
    public void groupWhereGreateThan(final String s, final Object o) {
        this.groupWhereGreaterThan(s, o);
    }
    
    public void groupWhereGreateThanOrEqual(final String s, final Object o) {
        this.groupWhereGreaterThanOrEqual(s, o);
    }
    
    public void groupWhereGreaterThan(final Class<?> clazz, final String s, final Object o) {
        this.groupWhere(clazz, s, o, "4");
    }
    
    public void groupWhereGreaterThan(final String s, final Object o) {
        this.groupWhereGreaterThan(this.getTableClass(), s, o);
    }
    
    public void groupWhereGreaterThanOrEqual(final Class<?> clazz, final String s, final Object o) {
        this.groupWhere(clazz, s, o, "5");
    }
    
    public void groupWhereGreaterThanOrEqual(final String s, final Object o) {
        this.groupWhereGreaterThanOrEqual(this.getTableClass(), s, o);
    }
    
    public void groupWhereIgnoreCase(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhereIgnoreCase(clazz, s, o, s2, null);
    }
    
    public void groupWhereIgnoreCase(final String s, final Object o, final String s2) {
        this.groupWhereIgnoreCase(this.getTableClass(), s, o, s2);
    }
    
    public void groupWhereLessThan(final Class<?> clazz, final String s, final Object o) {
        this.groupWhere(clazz, s, o, "6");
    }
    
    public void groupWhereLessThan(final String s, final Object o) {
        this.groupWhereLessThan(this.getTableClass(), s, o);
    }
    
    public void groupWhereLessThanOrEqual(final Class<?> clazz, final String s, final Object o) {
        this.groupWhere(clazz, s, o, "7");
    }
    
    public void groupWhereLessThanOrEqual(final String s, final Object o) {
        this.groupWhereLessThanOrEqual(this.getTableClass(), s, o);
    }
    
    public void groupWhereLike(final Class<?> clazz, final String s, final Object o) {
        this.groupWhere(clazz, s, o, "3");
    }
    
    public void groupWhereLike(final String s, final Object o) {
        this.groupWhereLike(this.getTableClass(), s, o);
    }
    
    public void groupWhereLikeIgnoreCase(final Class<?> clazz, final String s, final Object o) {
        this.groupWhereIgnoreCase(clazz, s, o, "3");
    }
    
    public void groupWhereLikeIgnoreCase(final String s, final Object o) {
        this.groupWhereLikeIgnoreCase(this.getTableClass(), s, o);
    }
    
    public void groupWhereNotEqual(final Class<?> clazz, final String s, final Object o) {
        this.groupWhere(clazz, s, o, "2");
    }
    
    public void groupWhereNotEqual(final String s, final Object o) {
        this.groupWhereNotEqual(this.getTableClass(), s, o);
    }
    
    public void groupWhereNotEqualIgnoreCase(final Class<?> clazz, final String s, final Object o) {
        this.groupWhereIgnoreCase(clazz, s, o, "2");
    }
    
    public void groupWhereNotEqualIgnoreCase(final String s, final Object o) {
        this.groupWhereNotEqualIgnoreCase(this.getTableClass(), s, o);
    }
    
    public boolean isHasJoin() {
        return this.mJoinCondition != null;
    }
    
    protected void makeWhereCondition(final List<Map<String, Object>> list, final StringBuilder obj, final List<Object> list2, final boolean b) {
        for (int size = list.size(), i = 0; i < size; ++i) {
            final Map<String, Object> map = list.get(i);
            final List<Map> list3 = map.get("searchConditions");
            obj.append(" (");
            int n = 0;
            for (final Map<String, Object> map2 : list3) {
                if (n != 0) {
                    obj.append(" AND ");
                }
                else {
                    n = 1;
                }
                obj.append(this.convertToSQLiteCondition(map2));
                if (isContainConditon(map2)) {
                    obj.append(" (");
                    obj.append(TextUtils.join((CharSequence)",", (Iterable)this.checkValue(getValue(map2))));
                    obj.append(")");
                    Logger.v("APQuery", "Where:" + (Object)obj);
                }
                else {
                    list2.add(getValue(map2).get(0));
                }
            }
            obj.append(") ");
            if (i + 1 < size || b) {
                obj.append(" " + map.get("type") + " ");
            }
        }
    }
    
    public void scopeType(final String s) {
        this.mCondition.put("scope", s);
    }
    
    public void sort(final Class<?> clazz, final String s) {
        this.sort(clazz, s, "0");
    }
    
    public void sort(final Class<?> clazz, final String s, final String s2) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        Class<?> tableClass = clazz;
        if (clazz == null) {
            tableClass = this.getTableClass();
        }
        hashMap.put("tableName", tableClass.getSimpleName());
        if (this.mJoinCondition != null) {
            hashMap.put("tableAlias", this.getAlias());
        }
        hashMap.put("columnName", s);
        hashMap.put("conditionValue", s2);
        if (this.mSortCondition == null) {
            this.mSortCondition = new ArrayList<Map<String, String>>();
        }
        this.mSortCondition.add(hashMap);
        this.mCondition.put("sortConditions", this.mSortCondition);
    }
    
    public void sort(final String s) {
        this.sort(this.getTableClass(), s);
    }
    
    public void sort(final String s, final String s2) {
        this.sort(this.getTableClass(), s, s2);
    }
    
    public void sortAsc(final Class<?> clazz, final String s) {
        this.sort(clazz, s, "1");
    }
    
    public void sortAsc(final String s) {
        this.sortAsc(this.getTableClass(), s);
    }
    
    public void sortDesc(final Class<?> clazz, final String s) {
        this.sort(clazz, s, "2");
    }
    
    public void sortDesc(final String s) {
        this.sortDesc(this.getTableClass(), s);
    }
    
    protected String toLimit() {
        if (this.pageIndex == 0 || this.pageIndex < 0) {
            this.pageIndex = 1;
        }
        String string = null;
        if (this.pageIndex == 1) {
            string = "" + this.maxRecord;
        }
        else if (this.pageIndex > 1) {
            return (this.pageIndex - 1) * this.maxRecord + 1 + " , " + this.maxRecord;
        }
        return string;
    }
    
    protected String toSort() {
        final StringBuilder sb = new StringBuilder();
        if (this.mSortCondition != null && this.mSortCondition.size() > 0) {
            for (int size = this.mSortCondition.size(), i = 0; i < size; ++i) {
                sb.append(convertToSQLiteSort(this.mSortCondition.get(i)));
                if (i + 1 < size) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }
    
    protected String toStringJoinQuery() {
        final StringBuilder sb = new StringBuilder(" " + this.mTableAlias);
        for (final Map<String, Object> map : this.mJoinCondition) {
            final String str = map.get("joinObjectName");
            final String str2 = map.get("joinColumn");
            final String s = map.get("joinAlias");
            if (str2 == null) {
                throw new IllegalArgumentException("join column is null");
            }
            final String s2 = map.get("baseObjectName");
            final String str3 = map.get("baseColumn");
            sb.append(this.toStringJoinType((int)map.get("joinType")));
            sb.append(str + " " + s + " on ");
            sb.append(this.mTableAlias + ".");
            sb.append(str3);
            sb.append(" = ");
            sb.append(s + ".");
            sb.append(str2);
        }
        return sb.toString();
    }
    
    protected Map<String, Object> toWhere() {
        String string = null;
        Object stringArray = null;
        final StringBuilder sb = new StringBuilder();
        final ArrayList<Object> list = new ArrayList<Object>();
        boolean b2;
        final boolean b = b2 = false;
        if (this.joinQuery != null) {
            b2 = b;
            if (this.joinQuery.whereCondition != null) {
                b2 = true;
            }
        }
        if (this.whereCondition != null && this.whereCondition.size() > 0) {
            this.makeWhereCondition(this.whereCondition, sb, list, b2);
        }
        if (b2) {
            this.joinQuery.makeWhereCondition(this.joinQuery.whereCondition, sb, list, false);
        }
        if (list.size() > 0) {
            stringArray = StringUtils.toStringArray(list);
        }
        if (sb.length() > 0) {
            string = sb.toString();
        }
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("where", string);
        hashMap.put("args", (String)stringArray);
        return (Map<String, Object>)hashMap;
    }
    
    public void where(final Class<?> clazz, final String s, final Object o, final String s2) {
        this.addWhere(clazz, s, o, s2, "AND");
    }
    
    public void where(final String s, final Object o, final String s2) {
        this.where(this.getTableClass(), s, o, s2);
    }
    
    public void whereContain(final Class<?> clazz, final String s, final List<Object> list) {
        this.where(clazz, s, list, "8");
    }
    
    public void whereContain(final String s, final List<Object> list) {
        this.whereContain(this.getTableClass(), s, list);
    }
    
    public void whereEqual(final Class<?> clazz, final String s, final Object o) {
        this.where(clazz, s, o, "1");
    }
    
    public void whereEqual(final String s, final Object o) {
        this.whereEqual(this.getTableClass(), s, o);
    }
    
    public void whereGreateThan(final String s, final Object o) {
        this.whereGreaterThan(s, o);
    }
    
    public void whereGreaterThan(final Class<?> clazz, final String s, final Object o) {
        this.where(clazz, s, o, "4");
    }
    
    public void whereGreaterThan(final String s, final Object o) {
        this.whereGreaterThan(this.getTableClass(), s, o);
    }
    
    public void whereGreaterThanOrEqual(final Class<?> clazz, final String s, final Object o) {
        this.where(clazz, s, o, "5");
    }
    
    public void whereGreaterThanOrEqual(final String s, final Object o) {
        this.whereGreaterThanOrEqual(this.getTableClass(), s, o);
    }
    
    public void whereLessThan(final Class<?> clazz, final String s, final Object o) {
        this.where(clazz, s, o, "6");
    }
    
    public void whereLessThan(final String s, final Object o) {
        this.whereLessThan(this.getTableClass(), s, o);
    }
    
    public void whereLessThanOrEqual(final Class<?> clazz, final String s, final Object o) {
        this.where(clazz, s, o, "7");
    }
    
    public void whereLessThanOrEqual(final String s, final Object o) {
        this.whereLessThanOrEqual(this.getTableClass(), s, o);
    }
    
    public void whereLike(final Class<?> clazz, final String s, final Object o) {
        this.where(clazz, s, o, "3");
    }
    
    public void whereLike(final String s, final Object o) {
        this.whereLike(this.getTableClass(), s, o);
    }
    
    public void whereNotEqual(final Class<?> clazz, final String s, final Object o) {
        this.where(clazz, s, o, "2");
    }
    
    public void whereNotEqual(final String s, final Object o) {
        this.whereNotEqual(this.getTableClass(), s, o);
    }
    
    public enum JoinType
    {
        INNER(1), 
        LEFT_OUTER(2), 
        RIGHT_OUTER(3);
        
        private int value;
        
        private JoinType(final int value) {
            this.value = value;
        }
        
        public String getString() {
            switch (this) {
                default: {
                    return "Inner Join";
                }
                case LEFT_OUTER: {
                    return "Left Outer Join";
                }
                case RIGHT_OUTER: {
                    return "Right Outer Join";
                }
            }
        }
        
        public int getValue() {
            return this.value;
        }
    }
    
    public interface ScopeType
    {
        public static final String ALL = "3";
        public static final String GROUP = "2";
        public static final String USER = "1";
    }
    
    public enum SortType
    {
        ASC, 
        DESC;
        
        public String getString() {
            switch (this) {
                default: {
                    return "ASC";
                }
                case ASC: {
                    return "ASC";
                }
                case DESC: {
                    return "DESC";
                }
            }
        }
    }
}
