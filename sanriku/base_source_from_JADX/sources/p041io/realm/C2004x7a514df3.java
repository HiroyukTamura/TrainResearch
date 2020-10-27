package p041io.realm;

import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;

/* renamed from: io.realm.io_realm_sync_permissions_PermissionRealmProxy$PermissionColumnInfo */
final class C2004x7a514df3 extends ColumnInfo {
    long canCreateIndex;
    long canDeleteIndex;
    long canModifySchemaIndex;
    long canQueryIndex;
    long canReadIndex;
    long canSetPermissionsIndex;
    long canUpdateIndex;
    long maxColumnIndexValue;
    long roleIndex;

    C2004x7a514df3(ColumnInfo columnInfo, boolean z) {
        super(columnInfo, z);
        copy(columnInfo, this);
    }

    C2004x7a514df3(OsSchemaInfo osSchemaInfo) {
        super(8);
        OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(io_realm_sync_permissions_PermissionRealmProxy$ClassNameHelper.INTERNAL_CLASS_NAME);
        this.roleIndex = addColumnDetails("role", "role", objectSchemaInfo);
        this.canReadIndex = addColumnDetails("canRead", "canRead", objectSchemaInfo);
        this.canUpdateIndex = addColumnDetails("canUpdate", "canUpdate", objectSchemaInfo);
        this.canDeleteIndex = addColumnDetails("canDelete", "canDelete", objectSchemaInfo);
        this.canSetPermissionsIndex = addColumnDetails("canSetPermissions", "canSetPermissions", objectSchemaInfo);
        this.canQueryIndex = addColumnDetails("canQuery", "canQuery", objectSchemaInfo);
        this.canCreateIndex = addColumnDetails("canCreate", "canCreate", objectSchemaInfo);
        this.canModifySchemaIndex = addColumnDetails("canModifySchema", "canModifySchema", objectSchemaInfo);
        this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
    }

    /* access modifiers changed from: protected */
    public final ColumnInfo copy(boolean z) {
        return new C2004x7a514df3(this, z);
    }

    /* access modifiers changed from: protected */
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        C2004x7a514df3 io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo = (C2004x7a514df3) columnInfo;
        C2004x7a514df3 io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2 = (C2004x7a514df3) columnInfo2;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.roleIndex = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.roleIndex;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canReadIndex = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canReadIndex;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canUpdateIndex = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canUpdateIndex;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canDeleteIndex = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canDeleteIndex;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canSetPermissionsIndex = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canSetPermissionsIndex;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canQueryIndex = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canQueryIndex;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canCreateIndex = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canCreateIndex;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canModifySchemaIndex = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canModifySchemaIndex;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.maxColumnIndexValue = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.maxColumnIndexValue;
    }
}
