package p041io.realm;

import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;

/* renamed from: io.realm.io_realm_sync_permissions_RealmPermissionsRealmProxy$RealmPermissionsColumnInfo */
final class C2008x864ed6b3 extends ColumnInfo {
    long idIndex;
    long maxColumnIndexValue;
    long permissionsIndex;

    C2008x864ed6b3(ColumnInfo columnInfo, boolean z) {
        super(columnInfo, z);
        copy(columnInfo, this);
    }

    C2008x864ed6b3(OsSchemaInfo osSchemaInfo) {
        super(2);
        OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(C2007xa165cb7.INTERNAL_CLASS_NAME);
        this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
        this.permissionsIndex = addColumnDetails("permissions", "permissions", objectSchemaInfo);
        this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
    }

    /* access modifiers changed from: protected */
    public final ColumnInfo copy(boolean z) {
        return new C2008x864ed6b3(this, z);
    }

    /* access modifiers changed from: protected */
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        C2008x864ed6b3 io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo = (C2008x864ed6b3) columnInfo;
        C2008x864ed6b3 io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo2 = (C2008x864ed6b3) columnInfo2;
        io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo2.idIndex = io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo.idIndex;
        io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo2.permissionsIndex = io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo.permissionsIndex;
        io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo2.maxColumnIndexValue = io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo.maxColumnIndexValue;
    }
}
