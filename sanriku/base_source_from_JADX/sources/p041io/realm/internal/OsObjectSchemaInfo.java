package p041io.realm.internal;

import p041io.realm.RealmFieldType;

/* renamed from: io.realm.internal.OsObjectSchemaInfo */
public class OsObjectSchemaInfo implements NativeObject {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    /* access modifiers changed from: private */
    public long nativePtr;

    /* renamed from: io.realm.internal.OsObjectSchemaInfo$Builder */
    public static class Builder {
        private final String className;
        private final long[] computedPropertyPtrArray;
        private int computedPropertyPtrCurPos = 0;
        private final long[] persistedPropertyPtrArray;
        private int persistedPropertyPtrCurPos = 0;

        public Builder(String str, int i, int i2) {
            this.className = str;
            this.persistedPropertyPtrArray = new long[i];
            this.computedPropertyPtrArray = new long[i2];
        }

        public Builder addComputedLinkProperty(String str, String str2, String str3) {
            long nativeCreateComputedLinkProperty = Property.nativeCreateComputedLinkProperty(str, str2, str3);
            long[] jArr = this.computedPropertyPtrArray;
            int i = this.computedPropertyPtrCurPos;
            jArr[i] = nativeCreateComputedLinkProperty;
            this.computedPropertyPtrCurPos = i + 1;
            return this;
        }

        public Builder addPersistedLinkProperty(String str, RealmFieldType realmFieldType, String str2) {
            long nativeCreatePersistedLinkProperty = Property.nativeCreatePersistedLinkProperty(str, Property.convertFromRealmFieldType(realmFieldType, false), str2);
            long[] jArr = this.persistedPropertyPtrArray;
            int i = this.persistedPropertyPtrCurPos;
            jArr[i] = nativeCreatePersistedLinkProperty;
            this.persistedPropertyPtrCurPos = i + 1;
            return this;
        }

        public Builder addPersistedProperty(String str, RealmFieldType realmFieldType, boolean z, boolean z2, boolean z3) {
            long nativeCreatePersistedProperty = Property.nativeCreatePersistedProperty(str, Property.convertFromRealmFieldType(realmFieldType, z3), z, z2);
            long[] jArr = this.persistedPropertyPtrArray;
            int i = this.persistedPropertyPtrCurPos;
            jArr[i] = nativeCreatePersistedProperty;
            this.persistedPropertyPtrCurPos = i + 1;
            return this;
        }

        public Builder addPersistedValueListProperty(String str, RealmFieldType realmFieldType, boolean z) {
            long nativeCreatePersistedProperty = Property.nativeCreatePersistedProperty(str, Property.convertFromRealmFieldType(realmFieldType, z), false, false);
            long[] jArr = this.persistedPropertyPtrArray;
            int i = this.persistedPropertyPtrCurPos;
            jArr[i] = nativeCreatePersistedProperty;
            this.persistedPropertyPtrCurPos = i + 1;
            return this;
        }

        public OsObjectSchemaInfo build() {
            if (this.persistedPropertyPtrCurPos == -1 || this.computedPropertyPtrCurPos == -1) {
                throw new IllegalStateException("'OsObjectSchemaInfo.build()' has been called before on this object.");
            }
            OsObjectSchemaInfo osObjectSchemaInfo = new OsObjectSchemaInfo(this.className);
            OsObjectSchemaInfo.nativeAddProperties(osObjectSchemaInfo.nativePtr, this.persistedPropertyPtrArray, this.computedPropertyPtrArray);
            this.persistedPropertyPtrCurPos = -1;
            this.computedPropertyPtrCurPos = -1;
            return osObjectSchemaInfo;
        }
    }

    OsObjectSchemaInfo(long j) {
        this.nativePtr = j;
        NativeContext.dummyContext.addReference(this);
    }

    private OsObjectSchemaInfo(String str) {
        this(nativeCreateRealmObjectSchema(str));
    }

    /* access modifiers changed from: private */
    public static native void nativeAddProperties(long j, long[] jArr, long[] jArr2);

    private static native long nativeCreateRealmObjectSchema(String str);

    private static native String nativeGetClassName(long j);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetMaxColumnIndex(long j);

    private static native long nativeGetPrimaryKeyProperty(long j);

    private static native long nativeGetProperty(long j, String str);

    public String getClassName() {
        return nativeGetClassName(this.nativePtr);
    }

    public long getMaxColumnIndex() {
        return nativeGetMaxColumnIndex(this.nativePtr);
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public Property getPrimaryKeyProperty() {
        if (nativeGetPrimaryKeyProperty(this.nativePtr) == 0) {
            return null;
        }
        return new Property(nativeGetPrimaryKeyProperty(this.nativePtr));
    }

    public Property getProperty(String str) {
        return new Property(nativeGetProperty(this.nativePtr, str));
    }
}
