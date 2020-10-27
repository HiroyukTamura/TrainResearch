package p041io.realm;

import android.util.JsonReader;
import io.realm.sync.Subscription;
import io.realm.sync.permissions.ClassPermissions;
import io.realm.sync.permissions.Permission;
import io.realm.sync.permissions.PermissionUser;
import io.realm.sync.permissions.RealmPermissions;
import io.realm.sync.permissions.Role;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p041io.realm.BaseRealm;
import p041io.realm.annotations.RealmModule;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.RealmProxyMediator;
import p041io.realm.internal.Row;

@RealmModule
/* renamed from: io.realm.BaseModuleMediator */
class BaseModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    static {
        HashSet hashSet = new HashSet(6);
        hashSet.add(PermissionUser.class);
        hashSet.add(RealmPermissions.class);
        hashSet.add(ClassPermissions.class);
        hashSet.add(Permission.class);
        hashSet.add(Role.class);
        hashSet.add(Subscription.class);
        MODEL_CLASSES = Collections.unmodifiableSet(hashSet);
    }

    BaseModuleMediator() {
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        PermissionUser copyOrUpdate;
        Class superclass = e instanceof RealmObjectProxy ? e.getClass().getSuperclass() : e.getClass();
        if (superclass.equals(PermissionUser.class)) {
            copyOrUpdate = io_realm_sync_permissions_PermissionUserRealmProxy.copyOrUpdate(realm, (C2006xf217bf53) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) PermissionUser.class), (PermissionUser) e, z, map, set);
        } else if (superclass.equals(RealmPermissions.class)) {
            copyOrUpdate = io_realm_sync_permissions_RealmPermissionsRealmProxy.copyOrUpdate(realm, (C2008x864ed6b3) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) RealmPermissions.class), (RealmPermissions) e, z, map, set);
        } else if (superclass.equals(ClassPermissions.class)) {
            copyOrUpdate = io_realm_sync_permissions_ClassPermissionsRealmProxy.copyOrUpdate(realm, (C2003xc9bb9c53) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) ClassPermissions.class), (ClassPermissions) e, z, map, set);
        } else if (superclass.equals(Permission.class)) {
            copyOrUpdate = io_realm_sync_permissions_PermissionRealmProxy.copyOrUpdate(realm, (C2004x7a514df3) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) Permission.class), (Permission) e, z, map, set);
        } else if (superclass.equals(Role.class)) {
            copyOrUpdate = io_realm_sync_permissions_RoleRealmProxy.copyOrUpdate(realm, (io_realm_sync_permissions_RoleRealmProxy$RoleColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) Role.class), (Role) e, z, map, set);
        } else if (superclass.equals(Subscription.class)) {
            copyOrUpdate = io_realm_sync_SubscriptionRealmProxy.copyOrUpdate(realm, (io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo) realm.getSchema().getColumnInfo((Class<? extends RealmModel>) Subscription.class), (Subscription) e, z, map, set);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
        }
        return (RealmModel) superclass.cast(copyOrUpdate);
    }

    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(PermissionUser.class)) {
            return io_realm_sync_permissions_PermissionUserRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RealmPermissions.class)) {
            return io_realm_sync_permissions_RealmPermissionsRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(ClassPermissions.class)) {
            return io_realm_sync_permissions_ClassPermissionsRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(Permission.class)) {
            return io_realm_sync_permissions_PermissionRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(Role.class)) {
            return io_realm_sync_permissions_RoleRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(Subscription.class)) {
            return io_realm_sync_SubscriptionRealmProxy.createColumnInfo(osSchemaInfo);
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        PermissionUser createDetachedCopy;
        Class<? super Object> superclass = e.getClass().getSuperclass();
        if (superclass.equals(PermissionUser.class)) {
            createDetachedCopy = io_realm_sync_permissions_PermissionUserRealmProxy.createDetachedCopy((PermissionUser) e, 0, i, map);
        } else if (superclass.equals(RealmPermissions.class)) {
            createDetachedCopy = io_realm_sync_permissions_RealmPermissionsRealmProxy.createDetachedCopy((RealmPermissions) e, 0, i, map);
        } else if (superclass.equals(ClassPermissions.class)) {
            createDetachedCopy = io_realm_sync_permissions_ClassPermissionsRealmProxy.createDetachedCopy((ClassPermissions) e, 0, i, map);
        } else if (superclass.equals(Permission.class)) {
            createDetachedCopy = io_realm_sync_permissions_PermissionRealmProxy.createDetachedCopy((Permission) e, 0, i, map);
        } else if (superclass.equals(Role.class)) {
            createDetachedCopy = io_realm_sync_permissions_RoleRealmProxy.createDetachedCopy((Role) e, 0, i, map);
        } else if (superclass.equals(Subscription.class)) {
            createDetachedCopy = io_realm_sync_SubscriptionRealmProxy.createDetachedCopy((Subscription) e, 0, i, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
        }
        return (RealmModel) superclass.cast(createDetachedCopy);
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> cls, Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        PermissionUser createOrUpdateUsingJsonObject;
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(PermissionUser.class)) {
            createOrUpdateUsingJsonObject = io_realm_sync_permissions_PermissionUserRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(RealmPermissions.class)) {
            createOrUpdateUsingJsonObject = io_realm_sync_permissions_RealmPermissionsRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(ClassPermissions.class)) {
            createOrUpdateUsingJsonObject = io_realm_sync_permissions_ClassPermissionsRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(Permission.class)) {
            createOrUpdateUsingJsonObject = io_realm_sync_permissions_PermissionRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(Role.class)) {
            createOrUpdateUsingJsonObject = io_realm_sync_permissions_RoleRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else if (cls.equals(Subscription.class)) {
            createOrUpdateUsingJsonObject = io_realm_sync_SubscriptionRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) cls);
        }
        return (RealmModel) cls.cast(createOrUpdateUsingJsonObject);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> cls, Realm realm, JsonReader jsonReader) throws IOException {
        PermissionUser createUsingJsonStream;
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(PermissionUser.class)) {
            createUsingJsonStream = io_realm_sync_permissions_PermissionUserRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(RealmPermissions.class)) {
            createUsingJsonStream = io_realm_sync_permissions_RealmPermissionsRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(ClassPermissions.class)) {
            createUsingJsonStream = io_realm_sync_permissions_ClassPermissionsRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(Permission.class)) {
            createUsingJsonStream = io_realm_sync_permissions_PermissionRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(Role.class)) {
            createUsingJsonStream = io_realm_sync_permissions_RoleRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else if (cls.equals(Subscription.class)) {
            createUsingJsonStream = io_realm_sync_SubscriptionRealmProxy.createUsingJsonStream(realm, jsonReader);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) cls);
        }
        return (RealmModel) cls.cast(createUsingJsonStream);
    }

    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap(6);
        hashMap.put(PermissionUser.class, io_realm_sync_permissions_PermissionUserRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RealmPermissions.class, io_realm_sync_permissions_RealmPermissionsRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(ClassPermissions.class, io_realm_sync_permissions_ClassPermissionsRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Permission.class, io_realm_sync_permissions_PermissionRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Role.class, io_realm_sync_permissions_RoleRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Subscription.class, io_realm_sync_SubscriptionRealmProxy.getExpectedObjectSchemaInfo());
        return hashMap;
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    public String getSimpleClassNameImpl(Class<? extends RealmModel> cls) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(PermissionUser.class)) {
            return C2005xa102e1bc.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(RealmPermissions.class)) {
            return C2007xa165cb7.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(ClassPermissions.class)) {
            return C2002x3a7fdb6e.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(Permission.class)) {
            return io_realm_sync_permissions_PermissionRealmProxy$ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(Role.class)) {
            return io_realm_sync_permissions_RoleRealmProxy$ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        if (cls.equals(Subscription.class)) {
            return io_realm_sync_SubscriptionRealmProxy$ClassNameHelper.INTERNAL_CLASS_NAME;
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class<?> superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(PermissionUser.class)) {
            io_realm_sync_permissions_PermissionUserRealmProxy.insert(realm, (PermissionUser) realmModel, map);
        } else if (superclass.equals(RealmPermissions.class)) {
            io_realm_sync_permissions_RealmPermissionsRealmProxy.insert(realm, (RealmPermissions) realmModel, map);
        } else if (superclass.equals(ClassPermissions.class)) {
            io_realm_sync_permissions_ClassPermissionsRealmProxy.insert(realm, (ClassPermissions) realmModel, map);
        } else if (superclass.equals(Permission.class)) {
            io_realm_sync_permissions_PermissionRealmProxy.insert(realm, (Permission) realmModel, map);
        } else if (superclass.equals(Role.class)) {
            io_realm_sync_permissions_RoleRealmProxy.insert(realm, (Role) realmModel, map);
        } else if (superclass.equals(Subscription.class)) {
            io_realm_sync_SubscriptionRealmProxy.insert(realm, (Subscription) realmModel, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
        }
    }

    public void insert(Realm realm, Collection<? extends RealmModel> collection) {
        Iterator<? extends RealmModel> it = collection.iterator();
        HashMap hashMap = new HashMap(collection.size());
        if (it.hasNext()) {
            PermissionUser permissionUser = (RealmModel) it.next();
            Class<?> superclass = permissionUser instanceof RealmObjectProxy ? permissionUser.getClass().getSuperclass() : permissionUser.getClass();
            if (superclass.equals(PermissionUser.class)) {
                io_realm_sync_permissions_PermissionUserRealmProxy.insert(realm, permissionUser, hashMap);
            } else if (superclass.equals(RealmPermissions.class)) {
                io_realm_sync_permissions_RealmPermissionsRealmProxy.insert(realm, (RealmPermissions) permissionUser, hashMap);
            } else if (superclass.equals(ClassPermissions.class)) {
                io_realm_sync_permissions_ClassPermissionsRealmProxy.insert(realm, (ClassPermissions) permissionUser, hashMap);
            } else if (superclass.equals(Permission.class)) {
                io_realm_sync_permissions_PermissionRealmProxy.insert(realm, (Permission) permissionUser, hashMap);
            } else if (superclass.equals(Role.class)) {
                io_realm_sync_permissions_RoleRealmProxy.insert(realm, (Role) permissionUser, hashMap);
            } else if (superclass.equals(Subscription.class)) {
                io_realm_sync_SubscriptionRealmProxy.insert(realm, (Subscription) permissionUser, hashMap);
            } else {
                throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
            }
            if (!it.hasNext()) {
                return;
            }
            if (superclass.equals(PermissionUser.class)) {
                io_realm_sync_permissions_PermissionUserRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(RealmPermissions.class)) {
                io_realm_sync_permissions_RealmPermissionsRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(ClassPermissions.class)) {
                io_realm_sync_permissions_ClassPermissionsRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(Permission.class)) {
                io_realm_sync_permissions_PermissionRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(Role.class)) {
                io_realm_sync_permissions_RoleRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(Subscription.class)) {
                io_realm_sync_SubscriptionRealmProxy.insert(realm, it, hashMap);
            } else {
                throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
            }
        }
    }

    public void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class<?> superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(PermissionUser.class)) {
            io_realm_sync_permissions_PermissionUserRealmProxy.insertOrUpdate(realm, (PermissionUser) realmModel, map);
        } else if (superclass.equals(RealmPermissions.class)) {
            io_realm_sync_permissions_RealmPermissionsRealmProxy.insertOrUpdate(realm, (RealmPermissions) realmModel, map);
        } else if (superclass.equals(ClassPermissions.class)) {
            io_realm_sync_permissions_ClassPermissionsRealmProxy.insertOrUpdate(realm, (ClassPermissions) realmModel, map);
        } else if (superclass.equals(Permission.class)) {
            io_realm_sync_permissions_PermissionRealmProxy.insertOrUpdate(realm, (Permission) realmModel, map);
        } else if (superclass.equals(Role.class)) {
            io_realm_sync_permissions_RoleRealmProxy.insertOrUpdate(realm, (Role) realmModel, map);
        } else if (superclass.equals(Subscription.class)) {
            io_realm_sync_SubscriptionRealmProxy.insertOrUpdate(realm, (Subscription) realmModel, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
        }
    }

    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> collection) {
        Iterator<? extends RealmModel> it = collection.iterator();
        HashMap hashMap = new HashMap(collection.size());
        if (it.hasNext()) {
            PermissionUser permissionUser = (RealmModel) it.next();
            Class<?> superclass = permissionUser instanceof RealmObjectProxy ? permissionUser.getClass().getSuperclass() : permissionUser.getClass();
            if (superclass.equals(PermissionUser.class)) {
                io_realm_sync_permissions_PermissionUserRealmProxy.insertOrUpdate(realm, permissionUser, hashMap);
            } else if (superclass.equals(RealmPermissions.class)) {
                io_realm_sync_permissions_RealmPermissionsRealmProxy.insertOrUpdate(realm, (RealmPermissions) permissionUser, hashMap);
            } else if (superclass.equals(ClassPermissions.class)) {
                io_realm_sync_permissions_ClassPermissionsRealmProxy.insertOrUpdate(realm, (ClassPermissions) permissionUser, hashMap);
            } else if (superclass.equals(Permission.class)) {
                io_realm_sync_permissions_PermissionRealmProxy.insertOrUpdate(realm, (Permission) permissionUser, hashMap);
            } else if (superclass.equals(Role.class)) {
                io_realm_sync_permissions_RoleRealmProxy.insertOrUpdate(realm, (Role) permissionUser, hashMap);
            } else if (superclass.equals(Subscription.class)) {
                io_realm_sync_SubscriptionRealmProxy.insertOrUpdate(realm, (Subscription) permissionUser, hashMap);
            } else {
                throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
            }
            if (!it.hasNext()) {
                return;
            }
            if (superclass.equals(PermissionUser.class)) {
                io_realm_sync_permissions_PermissionUserRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(RealmPermissions.class)) {
                io_realm_sync_permissions_RealmPermissionsRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(ClassPermissions.class)) {
                io_realm_sync_permissions_ClassPermissionsRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(Permission.class)) {
                io_realm_sync_permissions_PermissionRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(Role.class)) {
                io_realm_sync_permissions_RoleRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(Subscription.class)) {
                io_realm_sync_SubscriptionRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else {
                throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) superclass);
            }
        }
    }

    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            realmObjectContext.set((BaseRealm) obj, row, columnInfo, z, list);
            RealmProxyMediator.checkClass(cls);
            if (cls.equals(PermissionUser.class)) {
                return (RealmModel) cls.cast(new io_realm_sync_permissions_PermissionUserRealmProxy());
            }
            if (cls.equals(RealmPermissions.class)) {
                E e = (RealmModel) cls.cast(new io_realm_sync_permissions_RealmPermissionsRealmProxy());
                realmObjectContext.clear();
                return e;
            } else if (cls.equals(ClassPermissions.class)) {
                E e2 = (RealmModel) cls.cast(new io_realm_sync_permissions_ClassPermissionsRealmProxy());
                realmObjectContext.clear();
                return e2;
            } else if (cls.equals(Permission.class)) {
                E e3 = (RealmModel) cls.cast(new io_realm_sync_permissions_PermissionRealmProxy());
                realmObjectContext.clear();
                return e3;
            } else if (cls.equals(Role.class)) {
                E e4 = (RealmModel) cls.cast(new io_realm_sync_permissions_RoleRealmProxy());
                realmObjectContext.clear();
                return e4;
            } else if (cls.equals(Subscription.class)) {
                E e5 = (RealmModel) cls.cast(new io_realm_sync_SubscriptionRealmProxy());
                realmObjectContext.clear();
                return e5;
            } else {
                throw RealmProxyMediator.getMissingProxyClassException((Class<? extends RealmModel>) cls);
            }
        } finally {
            realmObjectContext.clear();
        }
    }

    public boolean transformerApplied() {
        return true;
    }
}
