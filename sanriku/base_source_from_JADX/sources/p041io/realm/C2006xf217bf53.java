package p041io.realm;

import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;

/* renamed from: io.realm.io_realm_sync_permissions_PermissionUserRealmProxy$PermissionUserColumnInfo */
final class C2006xf217bf53 extends ColumnInfo {
    long idIndex;
    long maxColumnIndexValue;
    long roleIndex;

    C2006xf217bf53(ColumnInfo columnInfo, boolean z) {
        super(columnInfo, z);
        copy(columnInfo, this);
    }

    C2006xf217bf53(OsSchemaInfo osSchemaInfo) {
        super(2);
        OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(C2005xa102e1bc.INTERNAL_CLASS_NAME);
        this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
        this.roleIndex = addColumnDetails("role", "role", objectSchemaInfo);
        addBacklinkDetails(osSchemaInfo, "roles", io_realm_sync_permissions_RoleRealmProxy$ClassNameHelper.INTERNAL_CLASS_NAME, "members");
        this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
    }

    /* access modifiers changed from: protected */
    public final ColumnInfo copy(boolean z) {
        return new C2006xf217bf53(this, z);
    }

    /* access modifiers changed from: protected */
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        C2006xf217bf53 io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo = (C2006xf217bf53) columnInfo;
        C2006xf217bf53 io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo2 = (C2006xf217bf53) columnInfo2;
        io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo2.idIndex = io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo.idIndex;
        io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo2.roleIndex = io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo.roleIndex;
        io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo2.maxColumnIndexValue = io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo.maxColumnIndexValue;
    }
}
