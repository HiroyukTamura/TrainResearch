// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.dto;

import java.util.Collection;
import java.util.Map;
import jp.co.ncdc.apppot.stew.APError;
import jp.co.ncdc.apppot.stew.APResponseSelectHandler;
import jp.co.ncdc.apppot.stew.APSelect;
import jp.co.ncdc.apppot.stew.utils.StringUtils;
import java.math.BigDecimal;
import java.lang.reflect.Field;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

public class APObject implements Serializable
{
    private static final String TAG = "APObject";
    private static final long serialVersionUID = 4298492735256685804L;
    public Date createTime;
    public double createUserId;
    private List<String> encryptedProperties;
    public String groupIds;
    private boolean isAutoRefresh;
    public transient boolean isUsingLockForUpdate;
    private int lifeSpan;
    public String objectId;
    private PersistentType persistentType;
    private int refreshInterval;
    public int scopeType;
    private ScopeType scopeTypeForAutoRefresh;
    public String serverCreateTime;
    public String serverUpdateTime;
    public transient boolean syncDataFlag;
    public Date updateTime;
    
    public APObject() {
        this.persistentType = PersistentType.APServerOnly;
        this.isAutoRefresh = false;
        this.lifeSpan = 2592000;
        this.refreshInterval = 3600;
        this.scopeTypeForAutoRefresh = ScopeType.APScopeGroup;
        this.encryptedProperties = new ArrayList<String>();
        this.scopeType = ScopeType.APScopeGroup.ordinal();
        this.syncDataFlag = false;
        this.isUsingLockForUpdate = false;
    }
    
    public static final APObject newInstance(final Class<?> clazz) {
        try {
            return (APObject)clazz.newInstance();
        }
        catch (Exception ex) {
            Log.e("APObject", "newInstance clazz is " + clazz.getName(), (Throwable)ex);
            return null;
        }
    }
    
    public static final void setValueFromLocal(final APObject apObject, final Field field, final String value) {
        if (value != null) {
            try {
                if (field.getName().equals("serialVersionUID")) {
                    return;
                }
                if (field.getType().isAssignableFrom(Integer.TYPE)) {
                    field.setInt(apObject, Integer.parseInt(value));
                    return;
                }
            }
            catch (Exception ex) {
                Log.w("APObject", "field=" + field.getName() + ", " + value, (Throwable)ex);
                return;
            }
            if (field.getType().isAssignableFrom(Long.TYPE)) {
                field.setLong(apObject, Long.parseLong(value));
                return;
            }
            if (field.getType().isAssignableFrom(Boolean.TYPE)) {
                field.setBoolean(apObject, Boolean.parseBoolean(value));
                return;
            }
            if (field.getType().isAssignableFrom(Double.TYPE)) {
                field.setDouble(apObject, Double.parseDouble(value));
                return;
            }
            if (field.getType().isAssignableFrom(Float.TYPE)) {
                field.setFloat(apObject, Float.parseFloat(value));
                return;
            }
            if (field.getType().getSimpleName().equals("Date")) {
                field.set(apObject, new Date(Long.parseLong(value)));
                return;
            }
            if (field.getType().getSimpleName().equals(BigDecimal.class.getSimpleName())) {
                field.set(apObject, new BigDecimal(value));
                return;
            }
            Log.v("APObject", "[setValueFromLocal]:type=" + field.getType().getSimpleName());
            field.set(apObject, value);
        }
    }
    
    public static final void setValueFromServer(final APObject apObject, final Field field, final String value) {
        if (StringUtils.isNullSpace(value)) {
            Log.d("APObject", "field=" + field.getName() + " is empty or null.");
            return;
        }
        String str = value;
        try {
            if (field.getType().isAssignableFrom(Boolean.TYPE)) {
                str = value;
                field.setBoolean(apObject, Boolean.parseBoolean(value));
                return;
            }
        }
        catch (Exception ex) {
            Log.w("APObject", "field=" + field.getName() + ", " + str, (Throwable)ex);
            return;
        }
        if (field.getType().getSimpleName().equals("Date")) {
            field.set(apObject, new Date((long)Double.parseDouble(value)));
            return;
        }
        if (field.getType().isAssignableFrom(Integer.TYPE)) {
            field.setInt(apObject, Integer.parseInt(value));
            return;
        }
        if (field.getType().isAssignableFrom(Long.TYPE)) {
            field.setLong(apObject, Long.parseLong(value));
            return;
        }
        if (field.getType().isAssignableFrom(Float.TYPE)) {
            field.setFloat(apObject, Float.parseFloat(value));
            return;
        }
        if (field.getType().isAssignableFrom(Double.TYPE)) {
            field.setDouble(apObject, Double.parseDouble(value));
            return;
        }
        if (field.getType().isAssignableFrom(BigDecimal.class)) {
            while (true) {
                Label_0327: {
                    if (value == null) {
                        break Label_0327;
                    }
                    final String val = value;
                    if (value.length() == 0) {
                        break Label_0327;
                    }
                    field.set(apObject, new BigDecimal(val));
                    return;
                }
                final String val = "0";
                continue;
            }
        }
        field.set(apObject, value);
    }
    
    public List<String> getEncryptedProperties() {
        return this.encryptedProperties;
    }
    
    public int getLifeSpan() {
        return this.lifeSpan;
    }
    
    public PersistentType getPersistentType() {
        return this.persistentType;
    }
    
    public int getRefreshInterval() {
        return this.refreshInterval;
    }
    
    public ScopeType getScopeTypeForAutoRefresh() {
        return this.scopeTypeForAutoRefresh;
    }
    
    public final Object getValueFromLocal(final Field field, final String s) {
        if (s == null) {
            return s;
        }
        try {
            if (field.getName().equals("serialVersionUID")) {
                return null;
            }
            if (field.getType().isAssignableFrom(Integer.TYPE)) {
                return Integer.parseInt(s);
            }
            if (field.getType().isAssignableFrom(Long.TYPE)) {
                return Long.parseLong(s);
            }
            if (field.getType().isAssignableFrom(Boolean.TYPE)) {
                return Boolean.parseBoolean(s);
            }
            if (field.getType().isAssignableFrom(Double.TYPE)) {
                return Double.parseDouble(s);
            }
            if (field.getType().isAssignableFrom(Float.TYPE)) {
                return Float.parseFloat(s);
            }
            if (field.getType().getSimpleName().equals("Date")) {
                return new Date(Long.parseLong(s));
            }
            if (field.getType().getSimpleName().equals(BigDecimal.class.getSimpleName())) {
                return new BigDecimal(s);
            }
            Log.v("APObject", "[getValueFromLocal]:type=" + field.getType().getSimpleName());
            return s;
        }
        catch (Exception ex) {
            Log.w("APObject", "field=" + field.getName() + ", " + s, (Throwable)ex);
            return null;
        }
    }
    
    public boolean isAutoRefresh() {
        return this.isAutoRefresh;
    }
    
    public boolean isEncryptedProperties(final String s) {
        return this.encryptedProperties.contains(s);
    }
    
    public boolean isSyncedData() {
        return this.syncDataFlag;
    }
    
    public APSelect select() {
        return this.select(this.getClass().getSimpleName());
    }
    
    public APSelect select(final String s) {
        return APSelect.newInstance(this.getClass(), s, this.persistentType);
    }
    
    public APObject selectByObjectId(final String s) {
        final ArrayList<APObject> list = new ArrayList<APObject>();
        final APResponseSelectHandler apResponseSelectHandler = new APResponseSelectHandler() {
            @Override
            public void onFailure(final APError apError) {
            }
            
            @Override
            public void onSuccess(final Map<String, List<APObject>> map) {
                if (map != null && map.size() > 0) {
                    final List<APObject> list = map.get("APObject");
                    if (list != null && list.size() > 0) {
                        list.addAll(list);
                    }
                }
            }
        };
        apResponseSelectHandler.setUseSynchronousMode(true);
        this.select("APObject").where("#APObject.objectId = ?", s).findList(apResponseSelectHandler);
        if (list.size() == 1) {
            return (APObject)list.get(0);
        }
        return null;
    }
    
    protected void setAutoRefresh(final boolean isAutoRefresh) {
        this.isAutoRefresh = isAutoRefresh;
    }
    
    protected void setEncryptedProperties(final List<String> encryptedProperties) {
        this.encryptedProperties = encryptedProperties;
    }
    
    protected void setLifeSpan(final int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }
    
    public void setPersistentType(final PersistentType persistentType) {
        this.persistentType = persistentType;
    }
    
    protected void setRefreshInterval(final int refreshInterval) {
        this.refreshInterval = refreshInterval;
    }
    
    public void setScopeTypeForAutoRefresh(final ScopeType scopeTypeForAutoRefresh) {
        this.scopeTypeForAutoRefresh = scopeTypeForAutoRefresh;
    }
    
    protected void setSyncdDataFlag(final boolean syncDataFlag) {
        this.syncDataFlag = syncDataFlag;
    }
    
    public enum PersistentType
    {
        APLocalAndServer, 
        APLocalOnly, 
        APServerOnly;
    }
    
    public enum ScopeType
    {
        APScopeAll(3), 
        APScopeGroup(2), 
        APScopeUser(1);
        
        private int v;
        
        private ScopeType(final int v) {
            this.v = v;
        }
        
        public static int getValue(final String anObject) {
            if (ScopeType.APScopeUser.toString().equals(anObject)) {
                return ScopeType.APScopeUser.ordinal();
            }
            if (ScopeType.APScopeGroup.toString().equals(anObject)) {
                return ScopeType.APScopeGroup.ordinal();
            }
            if (ScopeType.APScopeAll.toString().equals(anObject)) {
                return ScopeType.APScopeAll.ordinal();
            }
            return ScopeType.APScopeAll.ordinal();
        }
    }
}
