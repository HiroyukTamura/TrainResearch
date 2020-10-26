// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import java.util.Arrays;
import jp.co.ncdc.apppot.stew.utils.StringUtils;
import java.lang.reflect.Field;
import jp.co.ncdc.apppot.stew.utils.APObjectUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import jp.co.ncdc.apppot.stew.log.Logger;
import java.util.HashMap;
import java.util.List;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.Map;

public class APSelect
{
    private static final int NotFound = -1;
    private String mAlias;
    private Map<String, Class<APObject>> mAliasEntites;
    private Map mConditions;
    private Map<String, String> mFrom;
    private List<String> mJoinAliases;
    private List<Class> mJoinClasses;
    private List<List<Object>> mJoinParams;
    private List<String> mJoinQueries;
    private List<APQuery.JoinType> mJoinTypes;
    private List<Map<String, Object>> mJoins;
    private Class<APObject> mObjectClass;
    private List<Map> mOrderByList;
    private APObject.PersistentType mPersistentType;
    private Map<String, Integer> mRange;
    private String mWhere;
    private Map<String, Map> mWhereMap;
    private List<Object> mWhereParams;
    
    private APSelect(final Class<APObject> mObjectClass, final String mAlias, final APObject.PersistentType mPersistentType) {
        this.mWhere = null;
        this.mWhereMap = null;
        this.mWhereParams = null;
        this.mJoinQueries = null;
        this.mJoinClasses = null;
        this.mJoinAliases = null;
        this.mJoinTypes = null;
        this.mJoinParams = null;
        this.mOrderByList = null;
        this.mRange = null;
        this.mObjectClass = mObjectClass;
        this.mAlias = mAlias;
        this.mPersistentType = mPersistentType;
        this.mConditions = new HashMap();
        this.mAliasEntites = new HashMap<String, Class<APObject>>();
    }
    
    private Map<String, String> analyzeJoin(final String s) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final String[] split = s.split(" ");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String str = split[i];
            final String alias = this.findAlias(str);
            Logger.v("APSelect", str + " tempAlias=" + alias);
            if (alias != null && this.mAliasEntites.get(alias) == null) {
                hashMap.put("entityAlias", alias);
                break;
            }
        }
        return hashMap;
    }
    
    private void analyzeJoin() {
        if (this.isEmptyList(this.mJoinQueries)) {
            return;
        }
        this.mJoins = new ArrayList<Map<String, Object>>(this.mJoinQueries.size());
        int n = 0;
        for (final String s : this.mJoinQueries) {
            final HashMap<String, Object> hashMap = new HashMap<String, Object>() {
                final /* synthetic */ String val$entity = APSelect.this.mJoinClasses.get(n).getSimpleName();
                final /* synthetic */ String val$type = APSelect.this.mJoinTypes.get(n).getString();
                
                {
                    ((HashMap<String, String>)this).put("type", this.val$type);
                    ((HashMap<String, String>)this).put("entity", this.val$entity);
                }
            };
            ((Map<String, APSelect$7>)hashMap).putAll(this.analyzeJoin(s));
            List<Object> list;
            if (this.mJoinParams != null) {
                list = this.mJoinParams.get(n);
            }
            else {
                list = null;
            }
            ((Map<String, APSelect$7>)hashMap).put("expression", new HashMap<String, Object>() {
                {
                    ((HashMap<String, String>)this).put("source", s);
                    if (list != null) {
                        ((HashMap<String, List>)this).put("params", list);
                    }
                }
            });
            this.mJoins.add(hashMap);
            this.mAliasEntites.put(this.mJoinAliases.get(n), this.mJoinClasses.get(n));
            ++n;
        }
        this.mConditions.put("join", this.mJoins);
    }
    
    private void analyzeWhere() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        jp/co/ncdc/apppot/stew/APSelect.mWhere:Ljava/lang/String;
        //     4: ifnonnull       8
        //     7: return         
        //     8: aload_0        
        //     9: getfield        jp/co/ncdc/apppot/stew/APSelect.mWhereParams:Ljava/util/List;
        //    12: ifnonnull       26
        //    15: aload_0        
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: invokespecial   java/util/ArrayList.<init>:()V
        //    23: putfield        jp/co/ncdc/apppot/stew/APSelect.mWhereParams:Ljava/util/List;
        //    26: aload_0        
        //    27: new             Ljp/co/ncdc/apppot/stew/APSelect$5;
        //    30: dup            
        //    31: aload_0        
        //    32: new             Ljp/co/ncdc/apppot/stew/APSelect$4;
        //    35: dup            
        //    36: aload_0        
        //    37: invokespecial   jp/co/ncdc/apppot/stew/APSelect$4.<init>:(Ljp/co/ncdc/apppot/stew/APSelect;)V
        //    40: invokespecial   jp/co/ncdc/apppot/stew/APSelect$5.<init>:(Ljp/co/ncdc/apppot/stew/APSelect;Ljava/util/Map;)V
        //    43: putfield        jp/co/ncdc/apppot/stew/APSelect.mWhereMap:Ljava/util/Map;
        //    46: aload_0        
        //    47: getfield        jp/co/ncdc/apppot/stew/APSelect.mConditions:Ljava/util/Map;
        //    50: ldc             "where"
        //    52: aload_0        
        //    53: getfield        jp/co/ncdc/apppot/stew/APSelect.mWhereMap:Ljava/util/Map;
        //    56: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    61: pop            
        //    62: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:276)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:271)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:150)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:187)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedGenericType.accept(CoreMetadataFactory.java:653)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:276)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2591)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:655)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:365)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private String findAlias(final String s) {
        if (s.startsWith("#")) {
            final int index = s.indexOf(".");
            if (index != -1) {
                return s.substring(1, index);
            }
        }
        return null;
    }
    
    private List<Object> getAllParams() {
        final ArrayList<Object> list = new ArrayList<Object>();
        if (this.mWhereParams != null && this.mWhereParams.size() > 0) {
            list.addAll(this.mWhereParams);
        }
        if (this.mJoinParams != null && this.mJoinParams.size() > 0) {
            final Iterator<List<Object>> iterator = this.mJoinParams.iterator();
            while (iterator.hasNext()) {
                list.addAll(iterator.next());
            }
        }
        return list;
    }
    
    private Boolean isEmptyList(final List... array) {
        if (array == null || array.length == 0) {
            return true;
        }
        for (int length = array.length, i = 0; i < length; ++i) {
            final List list = array[i];
            if (list == null || list.size() == 0) {
                return true;
            }
        }
        return false;
    }
    
    private List<String> makeAliasQuery() {
        final ArrayList<String> list = new ArrayList<String>();
        for (final String s : this.mAliasEntites.keySet()) {
            final Field[] fields = this.mAliasEntites.get(s).getFields();
            for (int length = fields.length, i = 0; i < length; ++i) {
                final String name = fields[i].getName();
                if (!APObjectUtils.isExceptColumn(name) && !APObjectUtils.isServerColumn(name)) {
                    Logger.v("APSelect", "[makeAliasQuery]:column=" + name);
                    list.add(String.format("%s.%s AS %s%s", s, name, name, s));
                }
            }
        }
        return list;
    }
    
    public static APSelect newInstance(final Class clazz, final String s, final APObject.PersistentType persistentType) {
        return new APSelect(clazz, s, persistentType);
    }
    
    private <T> Map<String, T> runLocalQuery(final boolean b) {
        final ArrayList list = new ArrayList();
        final StringBuilder sb = new StringBuilder("SELECT ");
        if (b) {
            sb.append(String.format("COUNT(%s.objectId) AS %s", this.mFrom.get("alias"), "__APPPOT_COUNT__"));
        }
        else {
            sb.append(StringUtils.stringByJoinList(this.makeAliasQuery(), " ,"));
        }
        sb.append(String.format(" FROM %s AS %s", this.mFrom.get("phyName"), this.mFrom.get("alias")));
        if (this.mJoins != null) {
            for (final Map<String, Object> map : this.mJoins) {
                final Map<String, String> map2 = map.get("expression");
                sb.append(String.format(" %s %s AS %s ON %s", map.get("type"), map.get("entity"), map.get("entityAlias"), map2.get("source").replaceAll("#", "")));
                final List list2 = (List)map2.get("params");
                if (list2 != null) {
                    list.addAll(list2);
                }
            }
        }
        if (this.mWhereMap != null) {
            final Map<String, String> map3 = this.mWhereMap.get("expression");
            sb.append(String.format(" WHERE %s", map3.get("source").replaceAll("#", "")));
            final List list3 = (List)map3.get("params");
            if (list3 != null) {
                list.addAll(list3);
            }
        }
        if (this.mOrderByList != null) {
            sb.append(" ORDER BY");
            for (final Map<K, String> map4 : this.mOrderByList) {
                sb.append(String.format(" %s %s", map4.get("column").replaceAll("#", ""), map4.get("type")));
            }
        }
        if (this.mRange != null) {
            final int intValue = this.mRange.get("limit");
            if (intValue > 0) {
                sb.append(String.format(" LIMIT %d", intValue));
            }
            final int intValue2 = this.mRange.get("offset");
            if (intValue2 > 0) {
                sb.append(String.format(" OFFSET %d", intValue2));
            }
        }
        return (Map<String, T>)APEntityManager.getInstance().localSelect(sb.toString(), this.getAllParams(), this.mAliasEntites);
    }
    
    private void setFromQuery(final String s, final String s2) {
        this.mFrom = new HashMap<String, String>() {
            {
                this.put("phyName", s);
                this.put("alias", s2);
            }
        };
        this.mConditions.put("from", this.mFrom);
    }
    
    private List<Object> toList(final Object... a) {
        if (a != null && a.length > 0) {
            return new ArrayList<Object>(Arrays.asList(a));
        }
        return new ArrayList<Object>();
    }
    
    public int countList() {
        final String simpleName = this.mObjectClass.getSimpleName();
        if (this.mAlias == null) {
            this.mAlias = simpleName;
        }
        this.mAliasEntites.clear();
        this.setFromQuery(simpleName, this.mAlias);
        this.mAliasEntites.put(this.mAlias, this.mObjectClass);
        this.analyzeWhere();
        this.analyzeJoin();
        final APEntityManager instance = APEntityManager.getInstance();
        switch (this.mPersistentType) {
            default: {
                return 0;
            }
            case APLocalOnly: {
                return Integer.parseInt(this.runLocalQuery(true).get("count"));
            }
            case APServerOnly: {
                return instance.serverSelect(this, this.mAliasEntites);
            }
            case APLocalAndServer: {
                if (instance.isOnline()) {
                    return instance.serverSelect(this, this.mAliasEntites);
                }
                return Integer.parseInt(this.runLocalQuery(true).get("count"));
            }
        }
    }
    
    public void findList(final APResponseSelectHandler apResponseSelectHandler) {
        if (apResponseSelectHandler == null) {
            return;
        }
        this.mAliasEntites.clear();
        final String simpleName = this.mObjectClass.getSimpleName();
        if (this.mAlias == null) {
            this.mAlias = simpleName;
        }
        this.setFromQuery(simpleName, this.mAlias);
        this.mAliasEntites.put(this.mAlias, this.mObjectClass);
        this.analyzeWhere();
        this.analyzeJoin();
        apResponseSelectHandler.setAliasEntities(this.mAliasEntites);
        final APEntityManager instance = APEntityManager.getInstance();
        switch (this.mPersistentType) {
            default: {}
            case APLocalOnly: {
                final Map<String, List<APObject>> runLocalQuery = this.runLocalQuery(false);
                if (runLocalQuery != null) {
                    apResponseSelectHandler.onSuccess(runLocalQuery);
                    return;
                }
                apResponseSelectHandler.onFailure(new APError("No Data", -1));
            }
            case APServerOnly: {
                instance.serverSelect(this, apResponseSelectHandler);
            }
            case APLocalAndServer: {
                if (instance.isOnline()) {
                    instance.serverSelect(this, apResponseSelectHandler);
                    return;
                }
                final Map<String, List<APObject>> runLocalQuery2 = this.runLocalQuery(false);
                if (runLocalQuery2 != null) {
                    apResponseSelectHandler.onSuccess(runLocalQuery2);
                    return;
                }
                apResponseSelectHandler.onFailure(new APError("No Data", -1));
            }
        }
    }
    
    Map getConditions() {
        return this.mConditions;
    }
    
    String getObjectClassName() {
        return this.mObjectClass.getSimpleName();
    }
    
    public APSelect join(final String s, final Class clazz, final String s2) {
        return this.joins(Arrays.asList(s), (List<Class>)Arrays.asList(clazz), Arrays.asList(s2), null, Arrays.asList(APQuery.JoinType.INNER));
    }
    
    public APSelect join(final String s, final Class clazz, final String s2, final List<Object> list) {
        List<List<Object>> list2 = null;
        if (!this.isEmptyList(list)) {
            list2 = new ArrayList<List<Object>>();
            list2.add(list);
        }
        return this.joins(Arrays.asList(s), (List<Class>)Arrays.asList(clazz), Arrays.asList(s2), list2, Arrays.asList(APQuery.JoinType.INNER));
    }
    
    public APSelect join(final String s, final Class clazz, final String s2, final List<Object> list, final APQuery.JoinType joinType) {
        List<List<Object>> list2 = null;
        if (!this.isEmptyList(list)) {
            list2 = new ArrayList<List<Object>>();
            list2.add(list);
        }
        return this.joins(Arrays.asList(s), (List<Class>)Arrays.asList(clazz), Arrays.asList(s2), list2, Arrays.asList(joinType));
    }
    
    public APSelect join(final String s, final Class clazz, final String s2, final APQuery.JoinType joinType) {
        return this.joins(Arrays.asList(s), (List<Class>)Arrays.asList(clazz), Arrays.asList(s2), null, Arrays.asList(joinType));
    }
    
    public APSelect joins(final List<String> mJoinQueries, final List<Class> mJoinClasses, final List<String> mJoinAliases, final List<List<Object>> mJoinParams, final List<APQuery.JoinType> mJoinTypes) {
        if (this.isEmptyList(mJoinQueries, mJoinClasses, mJoinAliases)) {
            return this;
        }
        if (mJoinQueries.size() != mJoinTypes.size()) {
            throw new APException("Invalid Join query.");
        }
        this.mJoinQueries = mJoinQueries;
        this.mJoinAliases = mJoinAliases;
        this.mJoinClasses = mJoinClasses;
        this.mJoinTypes = mJoinTypes;
        this.mJoinParams = mJoinParams;
        return this;
    }
    
    public APSelect orderBy(final String s) {
        return this.ordersBy(Arrays.asList(s), Arrays.asList(APQuery.SortType.ASC));
    }
    
    public APSelect orderBy(final String s, final APQuery.SortType sortType) {
        return this.ordersBy(Arrays.asList(s), Arrays.asList(sortType));
    }
    
    public APSelect ordersBy(final List<String> list, final List<APQuery.SortType> list2) {
        if (this.isEmptyList(list, list2)) {
            return this;
        }
        if (list.size() != list2.size()) {
            throw new APException("Invalid OrderBy query.");
        }
        this.mOrderByList = new ArrayList<Map>(list2.size());
        int n = 0;
        final Iterator<APQuery.SortType> iterator = list2.iterator();
        while (iterator.hasNext()) {
            this.mOrderByList.add(new HashMap<String, String>() {
                final /* synthetic */ String val$column = list.get(n);
                final /* synthetic */ APQuery.SortType val$sortType = iterator.next();
                
                {
                    this.put("column", this.val$column);
                    this.put("type", this.val$sortType.getString());
                }
            });
            ++n;
        }
        this.mConditions.put("orderBy", this.mOrderByList);
        return this;
    }
    
    public APSelect range(final int n, final int n2) {
        this.mRange = new HashMap<String, Integer>() {
            {
                this.put("offset", n);
                this.put("limit", n2);
            }
        };
        this.mConditions.put("range", this.mRange);
        return this;
    }
    
    public APSelect where(final String s) {
        return this.where(s, null);
    }
    
    public APSelect where(final String mWhere, final Object... array) {
        if (StringUtils.isNullSpace(mWhere)) {
            return this;
        }
        int n;
        if (mWhere.indexOf("?") != -1) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            final int countHas = StringUtils.countHas(mWhere, "?");
            if (array == null || array.length != countHas) {
                throw new APException("Invalid Where query.");
            }
        }
        this.mWhere = mWhere;
        (this.mWhereParams = new ArrayList<Object>()).addAll(this.toList(array));
        return this;
    }
}
