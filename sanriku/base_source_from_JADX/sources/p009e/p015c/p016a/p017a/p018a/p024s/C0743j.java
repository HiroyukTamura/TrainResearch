package p009e.p015c.p016a.p017a.p018a.p024s;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.json.JSONArray;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0748a;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0749b;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0753c;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0760g;
import p043jp.reifrontier.gym.RFGDef;

@SuppressLint({"Assert"})
/* renamed from: e.c.a.a.a.s.j */
public class C0743j extends C0731a {

    /* renamed from: b */
    final String f444b;

    /* renamed from: c */
    final int f445c;

    /* renamed from: d */
    final String f446d;

    /* renamed from: e */
    final C0744k f447e = new C0744k();

    /* renamed from: f */
    private boolean f448f = false;

    public C0743j(@NonNull Context context, @NonNull String str, @NonNull C0745l lVar) {
        super(lVar);
        String str2 = C0731a.m413b(context).versionName;
        this.f444b = str2 == null ? "1" : str2;
        this.f445c = C0731a.m412a(context);
        this.f446d = str;
    }

    /* renamed from: a */
    private static Map<C0748a, String> m431a(@NonNull Collection<String> collection) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String next : collection) {
            linkedHashMap.put(C0760g.m463a(next), next);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static int m433c(@NonNull C0711a aVar) {
        return (int) ((C0714d) aVar).mo19911a("PRAGMA schema_version", (String[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19968a(@NonNull C0711a aVar) {
        if (!this.f448f) {
            C0714d dVar = (C0714d) aVar;
            if (dVar.mo19910a("sqlite_master", "tbl_name = ?", new String[]{"orma_schema_diff_migration_steps"}) != 0) {
                try {
                    dVar.mo19914a();
                    dVar.mo19919b("CREATE TABLE IF NOT EXISTS orma_schema_diff_migration_2 (id INTEGER PRIMARY KEY AUTOINCREMENT, db_version INTEGER NOT NULL, version_name TEXT NOT NULL, version_code INTEGER NOT NULL, schema_hash TEXT NOT NULL, sql TEXT NULL, args TEXT NULL, created_timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP)");
                    String[] strArr = {"id", RFGDef.DEFAULT_GYM_ID, "version_name", "version_code", "schema_hash", "sql", "args", "created_timestamp"};
                    dVar.mo19919b("INSERT INTO orma_schema_diff_migration_2 (" + TextUtils.join(", ", new String[]{"id", "db_version", "version_name", "version_code", "schema_hash", "sql", "args", "created_timestamp"}) + ") SELECT " + TextUtils.join(", ", strArr) + " FROM " + "orma_schema_diff_migration_steps");
                    dVar.mo19919b("DROP TABLE orma_schema_diff_migration_steps");
                    dVar.mo19919b("CREATE TABLE IF NOT EXISTS orma_schema_diff_migration_2 (id INTEGER PRIMARY KEY AUTOINCREMENT, db_version INTEGER NOT NULL, version_name TEXT NOT NULL, version_code INTEGER NOT NULL, schema_hash TEXT NOT NULL, sql TEXT NULL, args TEXT NULL, created_timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP)");
                    dVar.mo19924g();
                } finally {
                    dVar.mo19921d();
                }
            } else {
                dVar.mo19919b("CREATE TABLE IF NOT EXISTS orma_schema_diff_migration_2 (id INTEGER PRIMARY KEY AUTOINCREMENT, db_version INTEGER NOT NULL, version_name TEXT NOT NULL, version_code INTEGER NOT NULL, schema_hash TEXT NOT NULL, sql TEXT NULL, args TEXT NULL, created_timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP)");
            }
            this.f448f = true;
        }
    }

    @NonNull
    public String getTag() {
        return "SchemaDiffMigration";
    }

    /* renamed from: a */
    public void mo19969a(@NonNull C0711a aVar, int i, @Nullable String str, @NonNull Object... objArr) {
        String str2;
        mo19968a(aVar);
        ContentValues contentValues = new ContentValues();
        contentValues.put("db_version", Integer.valueOf(i));
        contentValues.put("version_name", this.f444b);
        contentValues.put("version_code", Integer.valueOf(this.f445c));
        contentValues.put("schema_hash", this.f446d);
        contentValues.put("sql", str);
        if (objArr.length == 0) {
            str2 = "[]";
        } else {
            JSONArray jSONArray = new JSONArray();
            for (Object put : objArr) {
                jSONArray.put(put);
            }
            str2 = jSONArray.toString();
        }
        contentValues.put("args", str2);
        ((C0714d) aVar).mo19908a("orma_schema_diff_migration_2", (String) null, contentValues);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public void mo19956a(@NonNull C0711a aVar, @NonNull List<? extends C0738f> list) {
        TreeMap treeMap;
        List list2;
        Object obj;
        C0711a aVar2 = aVar;
        mo19968a(aVar);
        C0714d dVar = (C0714d) aVar2;
        Cursor a = dVar.mo19912a("orma_schema_diff_migration_2", new String[]{"db_version", "schema_hash"}, (String) null, (String[]) null, (String) null, (String) null, "id DESC", "1");
        try {
            Pair pair = a.moveToFirst() ? new Pair(Integer.valueOf(a.getInt(0)), a.getString(1)) : new Pair(0, "");
            a.close();
            if (m433c(aVar) != ((Integer) pair.first).intValue() || !this.f446d.equals(pair.second)) {
                TreeMap treeMap2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                for (C0738f tableName : list) {
                    treeSet.add(tableName.getTableName());
                }
                String str = null;
                Cursor b = dVar.mo19917b("SELECT type,name,tbl_name,sql FROM sqlite_master", (String[]) null);
                try {
                    Map<String, C0741h> a2 = C0741h.m430a(b);
                    b.close();
                    for (Map.Entry next : a2.entrySet()) {
                        if (treeSet.contains(next.getKey())) {
                            treeMap2.put(next.getKey(), next.getValue());
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (C0738f fVar : list) {
                        C0738f fVar2 = (C0738f) treeMap2.get(fVar.getTableName());
                        if (fVar2 == null) {
                            arrayList.add(fVar.getCreateTableStatement());
                            arrayList.addAll(fVar.getCreateIndexStatements());
                            treeMap = treeMap2;
                        } else {
                            String createTableStatement = fVar2.getCreateTableStatement();
                            String createTableStatement2 = fVar.getCreateTableStatement();
                            if (createTableStatement.equals(createTableStatement2)) {
                                list2 = Collections.emptyList();
                                treeMap = treeMap2;
                            } else {
                                C0749b b2 = C0760g.m466b(createTableStatement);
                                C0749b b3 = C0760g.m466b(createTableStatement2);
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                ArrayList arrayList2 = new ArrayList();
                                ArrayList arrayList3 = new ArrayList();
                                for (C0749b.C0750a next2 : b3.mo19973a()) {
                                    TreeMap treeMap3 = treeMap2;
                                    linkedHashSet.add(next2);
                                    linkedHashSet2.add(next2.mo19976a());
                                    treeMap2 = treeMap3;
                                }
                                treeMap = treeMap2;
                                Iterator<C0749b.C0750a> it = b2.mo19973a().iterator();
                                while (it.hasNext()) {
                                    C0749b.C0750a next3 = it.next();
                                    if (linkedHashSet.contains(next3)) {
                                        arrayList2.add(next3);
                                    }
                                    Iterator<C0749b.C0750a> it2 = it;
                                    if (linkedHashSet2.contains(next3.mo19976a())) {
                                        arrayList3.add(next3.mo19976a());
                                    }
                                    it = it2;
                                }
                                if (arrayList2.size() == b3.mo19973a().size() && arrayList2.size() == b2.mo19973a().size() && b2.mo19974b().equals(b3.mo19974b())) {
                                    list2 = Collections.emptyList();
                                } else {
                                    mo19951a("from: %s", createTableStatement);
                                    mo19951a("to:   %s", createTableStatement2);
                                    C0744k kVar = this.f447e;
                                    if (kVar != null) {
                                        C0753c.C0756c c = b2.mo19975c();
                                        C0753c.C0756c c2 = b3.mo19975c();
                                        ArrayList arrayList4 = new ArrayList();
                                        StringBuilder a3 = C0681a.m330a("__temp_");
                                        a3.append(c2.mo19986a());
                                        C0753c.C0756c cVar = new C0753c.C0756c(a3.toString());
                                        List<C0749b.C0750a> a4 = b3.mo19973a();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("CREATE TABLE ");
                                        sb.append(cVar);
                                        sb.append(" (");
                                        kVar.mo19970a(sb, ", ", a4);
                                        sb.append(")");
                                        arrayList4.add(sb.toString());
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("INSERT INTO ");
                                        sb2.append(cVar);
                                        sb2.append(" (");
                                        kVar.mo19970a(sb2, ", ", arrayList3);
                                        sb2.append(") SELECT ");
                                        kVar.mo19970a(sb2, ", ", arrayList3);
                                        sb2.append(" FROM ");
                                        sb2.append(c);
                                        arrayList4.add(sb2.toString());
                                        arrayList4.add("DROP TABLE " + c);
                                        arrayList4.add("ALTER TABLE " + cVar + " RENAME TO " + c2);
                                        list2 = arrayList4;
                                    } else {
                                        throw null;
                                    }
                                }
                            }
                            if (list2.isEmpty()) {
                                List<String> createIndexStatements = fVar2.getCreateIndexStatements();
                                List<String> createIndexStatements2 = fVar.getCreateIndexStatements();
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                Map<C0748a, String> a5 = m431a((Collection<String>) createIndexStatements);
                                linkedHashMap.putAll(a5);
                                Map<C0748a, String> a6 = m431a((Collection<String>) createIndexStatements2);
                                linkedHashMap.putAll(a6);
                                ArrayList arrayList5 = new ArrayList();
                                for (Map.Entry entry : linkedHashMap.entrySet()) {
                                    boolean containsKey = ((HashMap) a6).containsKey(entry.getKey());
                                    boolean containsKey2 = ((HashMap) a5).containsKey(entry.getKey());
                                    if (!containsKey || !containsKey2) {
                                        if (containsKey) {
                                            obj = entry.getValue();
                                        } else {
                                            StringBuilder a7 = C0681a.m330a("DROP INDEX IF EXISTS ");
                                            a7.append(((C0748a) entry.getKey()).mo19972a());
                                            obj = a7.toString();
                                        }
                                        arrayList5.add(obj);
                                    }
                                }
                                arrayList.addAll(arrayList5);
                            } else {
                                arrayList.addAll(list2);
                                arrayList.addAll(fVar.getCreateIndexStatements());
                            }
                        }
                        str = null;
                        treeMap2 = treeMap;
                    }
                    if (arrayList.isEmpty()) {
                        mo19969a(aVar2, m433c(aVar), str, new Object[0]);
                    } else if (!arrayList.isEmpty()) {
                        mo19950a(aVar2, (Runnable) new C0742i(this, arrayList, aVar2));
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    b.close();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            a.close();
            throw th3;
        }
    }
}
