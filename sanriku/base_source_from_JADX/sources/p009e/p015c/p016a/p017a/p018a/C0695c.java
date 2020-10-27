package p009e.p015c.p016a.p017a.p018a;

import android.database.Cursor;
import androidx.annotation.NonNull;
import java.lang.reflect.Type;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: e.c.a.a.a.c */
public abstract class C0695c<Model, T> {
    public static int AUTOINCREMENT = 2;
    public static int AUTO_VALUE = 4;
    public static int INDEXED = 16;
    public static int NULLABLE = 8;
    public static int PRIMARY_KEY = 1;
    public static int UNIQUE = 32;
    public final int flags;
    public final String name;
    public final C0707k<Model> schema;
    public final String storageType;
    public final Type type;

    public C0695c(C0707k<Model> kVar, String str, Type type2, String str2, int i) {
        this.schema = kVar;
        this.name = str;
        this.type = type2;
        this.storageType = str2;
        this.flags = i;
    }

    private boolean checkFlags(int i) {
        return (this.flags & i) == i;
    }

    public String buildCallExpr(String str) {
        StringBuilder c = C0681a.m340c(str, "(");
        c.append(getQualifiedName());
        c.append(")");
        return c.toString();
    }

    public abstract T get(@NonNull Model model);

    public String getEscapedName() {
        return C0681a.m323a(C0681a.m329a('`'), this.name, '`');
    }

    public abstract T getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i);

    @NonNull
    public String getQualifiedName() {
        String escapedTableAlias = this.schema.getEscapedTableAlias();
        if (escapedTableAlias != null) {
            return escapedTableAlias + '.' + getEscapedName();
        }
        return this.schema.getEscapedTableName() + '.' + getEscapedName();
    }

    public abstract Object getSerialized(@NonNull Model model);

    public boolean isAutoValue() {
        return checkFlags(AUTO_VALUE);
    }

    public boolean isAutoincremnt() {
        return checkFlags(AUTOINCREMENT);
    }

    public boolean isIndexed() {
        return checkFlags(INDEXED);
    }

    public boolean isNullable() {
        return checkFlags(NULLABLE);
    }

    public boolean isPrimaryKey() {
        return checkFlags(PRIMARY_KEY);
    }

    public boolean isUnique() {
        return checkFlags(UNIQUE);
    }

    public C0699g<Model> orderInAscending() {
        return new C0699g<>(this, "ASC");
    }

    public C0699g<Model> orderInDescending() {
        return new C0699g<>(this, "DESC");
    }

    @NonNull
    public String toString() {
        return this.schema.getModelClass().getSimpleName() + '#' + this.name;
    }
}
