package p041io.realm.sync.permissions;

/* renamed from: io.realm.sync.permissions.Permission$Builder */
public class Permission$Builder {
    private boolean canCreate = false;
    private boolean canDelete = false;
    private boolean canModifySchema = false;
    private boolean canQuery = false;
    private boolean canRead = false;
    private boolean canSetPermissions = false;
    private boolean canUpdate = false;
    private Role role;

    public Permission$Builder(Role role2) {
        this.role = role2;
    }

    public Permission$Builder allPrivileges() {
        this.canRead = true;
        this.canUpdate = true;
        this.canDelete = true;
        this.canSetPermissions = true;
        this.canQuery = true;
        this.canCreate = true;
        this.canModifySchema = true;
        return this;
    }

    public Permission build() {
        return new Permission(this.role, this.canRead, this.canUpdate, this.canDelete, this.canSetPermissions, this.canQuery, this.canCreate, this.canModifySchema, (Permission$1) null);
    }

    public Permission$Builder canCreate(boolean z) {
        this.canCreate = z;
        return this;
    }

    public Permission$Builder canDelete(boolean z) {
        this.canDelete = z;
        return this;
    }

    public Permission$Builder canModifySchema(boolean z) {
        this.canModifySchema = z;
        return this;
    }

    public Permission$Builder canQuery(boolean z) {
        this.canQuery = z;
        return this;
    }

    public Permission$Builder canRead(boolean z) {
        this.canRead = z;
        return this;
    }

    public Permission$Builder canSetPermissions(boolean z) {
        this.canSetPermissions = z;
        return this;
    }

    public Permission$Builder canUpdate(boolean z) {
        this.canUpdate = z;
        return this;
    }

    public Permission$Builder noPrivileges() {
        this.canRead = false;
        this.canUpdate = false;
        this.canDelete = false;
        this.canSetPermissions = false;
        this.canQuery = false;
        this.canCreate = false;
        this.canModifySchema = false;
        return this;
    }
}
