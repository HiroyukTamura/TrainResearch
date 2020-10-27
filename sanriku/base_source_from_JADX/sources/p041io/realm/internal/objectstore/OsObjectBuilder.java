package p041io.realm.internal.objectstore;

import java.io.Closeable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import p041io.realm.ImportFlag;
import p041io.realm.MutableRealmInteger;
import p041io.realm.RealmList;
import p041io.realm.RealmModel;
import p041io.realm.internal.NativeContext;
import p041io.realm.internal.OsSharedRealm;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Table;
import p041io.realm.internal.UncheckedRow;

/* renamed from: io.realm.internal.objectstore.OsObjectBuilder */
public class OsObjectBuilder implements Closeable {
    private static ItemCallback<Boolean> booleanItemCallback = new ItemCallback<Boolean>() {
        public void handleItem(long j, Boolean bool) {
            OsObjectBuilder.nativeAddBooleanListItem(j, bool.booleanValue());
        }
    };
    private static ItemCallback<byte[]> byteArrayItemCallback = new ItemCallback<byte[]>() {
        public void handleItem(long j, byte[] bArr) {
            OsObjectBuilder.nativeAddByteArrayListItem(j, bArr);
        }
    };
    private static ItemCallback<Byte> byteItemCallback = new ItemCallback<Byte>() {
        public void handleItem(long j, Byte b) {
            OsObjectBuilder.nativeAddIntegerListItem(j, b.longValue());
        }
    };
    private static ItemCallback<Date> dateItemCallback = new ItemCallback<Date>() {
        public void handleItem(long j, Date date) {
            OsObjectBuilder.nativeAddDateListItem(j, date.getTime());
        }
    };
    private static ItemCallback<Double> doubleItemCallback = new ItemCallback<Double>() {
        public void handleItem(long j, Double d) {
            OsObjectBuilder.nativeAddDoubleListItem(j, d.doubleValue());
        }
    };
    private static ItemCallback<Float> floatItemCallback = new ItemCallback<Float>() {
        public void handleItem(long j, Float f) {
            OsObjectBuilder.nativeAddFloatListItem(j, f.floatValue());
        }
    };
    private static ItemCallback<Integer> integerItemCallback = new ItemCallback<Integer>() {
        public void handleItem(long j, Integer num) {
            OsObjectBuilder.nativeAddIntegerListItem(j, (long) num.intValue());
        }
    };
    private static ItemCallback<Long> longItemCallback = new ItemCallback<Long>() {
        public void handleItem(long j, Long l) {
            OsObjectBuilder.nativeAddIntegerListItem(j, l.longValue());
        }
    };
    private static ItemCallback<MutableRealmInteger> mutableRealmIntegerItemCallback = new ItemCallback<MutableRealmInteger>() {
        public void handleItem(long j, MutableRealmInteger mutableRealmInteger) {
            Long l = mutableRealmInteger.get();
            if (l == null) {
                OsObjectBuilder.nativeAddNullListItem(j);
            } else {
                OsObjectBuilder.nativeAddIntegerListItem(j, l.longValue());
            }
        }
    };
    private static ItemCallback<? extends RealmModel> objectItemCallback = new ItemCallback<RealmModel>() {
        public void handleItem(long j, RealmModel realmModel) {
            OsObjectBuilder.nativeAddIntegerListItem(j, ((UncheckedRow) ((RealmObjectProxy) realmModel).realmGet$proxyState().getRow$realm()).getNativePtr());
        }
    };
    private static ItemCallback<Short> shortItemCallback = new ItemCallback<Short>() {
        public void handleItem(long j, Short sh) {
            OsObjectBuilder.nativeAddIntegerListItem(j, (long) sh.shortValue());
        }
    };
    private static ItemCallback<String> stringItemCallback = new ItemCallback<String>() {
        public void handleItem(long j, String str) {
            OsObjectBuilder.nativeAddStringListItem(j, str);
        }
    };
    private final long builderPtr;
    private final NativeContext context;
    private final boolean ignoreFieldsWithSameValue;
    private final long sharedRealmPtr;
    private final Table table;
    private final long tablePtr;

    /* renamed from: io.realm.internal.objectstore.OsObjectBuilder$ItemCallback */
    private interface ItemCallback<T> {
        void handleItem(long j, T t);
    }

    public OsObjectBuilder(Table table2, long j, Set<ImportFlag> set) {
        OsSharedRealm sharedRealm = table2.getSharedRealm();
        this.sharedRealmPtr = sharedRealm.getNativePtr();
        this.table = table2;
        this.tablePtr = table2.getNativePtr();
        this.builderPtr = nativeCreateBuilder(j + 1);
        this.context = sharedRealm.context;
        this.ignoreFieldsWithSameValue = set.contains(ImportFlag.CHECK_SAME_VALUES_BEFORE_SET);
    }

    private void addEmptyList(long j) {
        nativeStopList(this.builderPtr, j, nativeStartList(0));
    }

    private <T> void addListItem(long j, long j2, List<T> list, ItemCallback<T> itemCallback) {
        if (list != null) {
            long nativeStartList = nativeStartList((long) list.size());
            for (int i = 0; i < list.size(); i++) {
                T t = list.get(i);
                if (t == null) {
                    nativeAddNullListItem(nativeStartList);
                } else {
                    itemCallback.handleItem(nativeStartList, t);
                }
            }
            nativeStopList(j, j2, nativeStartList);
            return;
        }
        addEmptyList(j2);
    }

    private static native void nativeAddBoolean(long j, long j2, boolean z);

    /* access modifiers changed from: private */
    public static native void nativeAddBooleanListItem(long j, boolean z);

    private static native void nativeAddByteArray(long j, long j2, byte[] bArr);

    /* access modifiers changed from: private */
    public static native void nativeAddByteArrayListItem(long j, byte[] bArr);

    private static native void nativeAddDate(long j, long j2, long j3);

    /* access modifiers changed from: private */
    public static native void nativeAddDateListItem(long j, long j2);

    private static native void nativeAddDouble(long j, long j2, double d);

    /* access modifiers changed from: private */
    public static native void nativeAddDoubleListItem(long j, double d);

    private static native void nativeAddFloat(long j, long j2, float f);

    /* access modifiers changed from: private */
    public static native void nativeAddFloatListItem(long j, float f);

    private static native void nativeAddInteger(long j, long j2, long j3);

    /* access modifiers changed from: private */
    public static native void nativeAddIntegerListItem(long j, long j2);

    private static native void nativeAddNull(long j, long j2);

    /* access modifiers changed from: private */
    public static native void nativeAddNullListItem(long j);

    private static native void nativeAddObject(long j, long j2, long j3);

    private static native void nativeAddObjectList(long j, long j2, long[] jArr);

    private static native void nativeAddObjectListItem(long j, long j2);

    private static native void nativeAddString(long j, long j2, String str);

    /* access modifiers changed from: private */
    public static native void nativeAddStringListItem(long j, String str);

    private static native long nativeCreateBuilder(long j);

    private static native long nativeCreateOrUpdate(long j, long j2, long j3, boolean z, boolean z2);

    private static native void nativeDestroyBuilder(long j);

    private static native long nativeStartList(long j);

    private static native void nativeStopList(long j, long j2, long j3);

    public void addBoolean(long j, Boolean bool) {
        long j2 = this.builderPtr;
        if (bool == null) {
            nativeAddNull(j2, j);
        } else {
            nativeAddBoolean(j2, j, bool.booleanValue());
        }
    }

    public void addBooleanList(long j, RealmList<Boolean> realmList) {
        addListItem(this.builderPtr, j, realmList, booleanItemCallback);
    }

    public void addByteArray(long j, byte[] bArr) {
        long j2 = this.builderPtr;
        if (bArr == null) {
            nativeAddNull(j2, j);
        } else {
            nativeAddByteArray(j2, j, bArr);
        }
    }

    public void addByteArrayList(long j, RealmList<byte[]> realmList) {
        addListItem(this.builderPtr, j, realmList, byteArrayItemCallback);
    }

    public void addByteList(long j, RealmList<Byte> realmList) {
        addListItem(this.builderPtr, j, realmList, byteItemCallback);
    }

    public void addDate(long j, Date date) {
        if (date == null) {
            nativeAddNull(this.builderPtr, j);
            return;
        }
        nativeAddDate(this.builderPtr, j, date.getTime());
    }

    public void addDateList(long j, RealmList<Date> realmList) {
        addListItem(this.builderPtr, j, realmList, dateItemCallback);
    }

    public void addDouble(long j, Double d) {
        if (d == null) {
            nativeAddNull(this.builderPtr, j);
            return;
        }
        nativeAddDouble(this.builderPtr, j, d.doubleValue());
    }

    public void addDoubleList(long j, RealmList<Double> realmList) {
        addListItem(this.builderPtr, j, realmList, doubleItemCallback);
    }

    public void addFloat(long j, Float f) {
        long j2 = this.builderPtr;
        if (f == null) {
            nativeAddNull(j2, j);
        } else {
            nativeAddFloat(j2, j, f.floatValue());
        }
    }

    public void addFloatList(long j, RealmList<Float> realmList) {
        addListItem(this.builderPtr, j, realmList, floatItemCallback);
    }

    public void addInteger(long j, Byte b) {
        if (b == null) {
            nativeAddNull(this.builderPtr, j);
            return;
        }
        nativeAddInteger(this.builderPtr, j, (long) b.byteValue());
    }

    public void addInteger(long j, Integer num) {
        if (num == null) {
            nativeAddNull(this.builderPtr, j);
            return;
        }
        nativeAddInteger(this.builderPtr, j, (long) num.intValue());
    }

    public void addInteger(long j, Long l) {
        if (l == null) {
            nativeAddNull(this.builderPtr, j);
            return;
        }
        nativeAddInteger(this.builderPtr, j, l.longValue());
    }

    public void addInteger(long j, Short sh) {
        if (sh == null) {
            nativeAddNull(this.builderPtr, j);
            return;
        }
        nativeAddInteger(this.builderPtr, j, (long) sh.shortValue());
    }

    public void addIntegerList(long j, RealmList<Integer> realmList) {
        addListItem(this.builderPtr, j, realmList, integerItemCallback);
    }

    public void addLongList(long j, RealmList<Long> realmList) {
        addListItem(this.builderPtr, j, realmList, longItemCallback);
    }

    public void addMutableRealmInteger(long j, MutableRealmInteger mutableRealmInteger) {
        if (mutableRealmInteger == null || mutableRealmInteger.get() == null) {
            nativeAddNull(this.builderPtr, j);
            return;
        }
        nativeAddInteger(this.builderPtr, j, mutableRealmInteger.get().longValue());
    }

    public void addMutableRealmIntegerList(long j, RealmList<MutableRealmInteger> realmList) {
        addListItem(this.builderPtr, j, realmList, mutableRealmIntegerItemCallback);
    }

    public void addNull(long j) {
        nativeAddNull(this.builderPtr, j);
    }

    public void addObject(long j, RealmModel realmModel) {
        if (realmModel == null) {
            nativeAddNull(this.builderPtr, j);
            return;
        }
        nativeAddObject(this.builderPtr, j, ((UncheckedRow) ((RealmObjectProxy) realmModel).realmGet$proxyState().getRow$realm()).getNativePtr());
    }

    public <T extends RealmModel> void addObjectList(long j, RealmList<T> realmList) {
        int i = 0;
        if (realmList != null) {
            long[] jArr = new long[realmList.size()];
            while (i < realmList.size()) {
                RealmObjectProxy realmObjectProxy = (RealmObjectProxy) realmList.get(i);
                if (realmObjectProxy != null) {
                    jArr[i] = ((UncheckedRow) realmObjectProxy.realmGet$proxyState().getRow$realm()).getNativePtr();
                    i++;
                } else {
                    throw new IllegalArgumentException("Null values are not allowed in RealmLists containing Realm models");
                }
            }
            nativeAddObjectList(this.builderPtr, j, jArr);
            return;
        }
        nativeAddObjectList(this.builderPtr, j, new long[0]);
    }

    public void addShortList(long j, RealmList<Short> realmList) {
        addListItem(this.builderPtr, j, realmList, shortItemCallback);
    }

    public void addString(long j, String str) {
        long j2 = this.builderPtr;
        if (str == null) {
            nativeAddNull(j2, j);
        } else {
            nativeAddString(j2, j, str);
        }
    }

    public void addStringList(long j, RealmList<String> realmList) {
        addListItem(this.builderPtr, j, realmList, stringItemCallback);
    }

    public void close() {
        nativeDestroyBuilder(this.builderPtr);
    }

    public UncheckedRow createNewObject() {
        try {
            return new UncheckedRow(this.context, this.table, nativeCreateOrUpdate(this.sharedRealmPtr, this.tablePtr, this.builderPtr, false, false));
        } finally {
            close();
        }
    }

    public long getNativePtr() {
        return this.builderPtr;
    }

    public void updateExistingObject() {
        try {
            nativeCreateOrUpdate(this.sharedRealmPtr, this.tablePtr, this.builderPtr, true, this.ignoreFieldsWithSameValue);
        } finally {
            close();
        }
    }
}
