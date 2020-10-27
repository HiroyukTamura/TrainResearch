package p009e.p015c.p016a.p017a.p018a;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p009e.p015c.p016a.p017a.p018a.p019n.C0713c;
import p009e.p015c.p016a.p017a.p018a.p024s.C0738f;

/* renamed from: e.c.a.a.a.k */
public interface C0707k<Model> extends C0738f {
    void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull Model model, boolean z);

    @NonNull
    Object[] convertToArgs(@NonNull C0700h hVar, @NonNull Model model, boolean z);

    @NonNull
    ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull Model model, boolean z);

    @NonNull
    String getCreateTableStatement();

    @NonNull
    String[] getDefaultResultColumns();

    @Nullable
    String getEscapedTableAlias();

    @NonNull
    String getEscapedTableName();

    @NonNull
    String getInsertStatement(int i, boolean z);

    @NonNull
    Class<Model> getModelClass();

    @NonNull
    C0695c<Model, ?> getPrimaryKey();

    @NonNull
    String getSelectFromTableClause();

    @NonNull
    String getTableName();

    @NonNull
    Model newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i);
}
