package p041io.realm.internal;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.CompactOnLaunchCallback;
import p041io.realm.RealmConfiguration;
import p041io.realm.internal.OsSharedRealm;
import p041io.realm.log.RealmLog;

/* renamed from: io.realm.internal.OsRealmConfig */
public class OsRealmConfig implements NativeObject {
    public static final byte CLIENT_RESYNC_MODE_DISCARD = 1;
    public static final byte CLIENT_RESYNC_MODE_MANUAL = 2;
    public static final byte CLIENT_RESYNC_MODE_RECOVER = 0;
    private static final byte PROXYCONFIG_TYPE_VALUE_HTTP = 0;
    private static final byte SCHEMA_MODE_VALUE_ADDITIVE = 4;
    private static final byte SCHEMA_MODE_VALUE_AUTOMATIC = 0;
    private static final byte SCHEMA_MODE_VALUE_IMMUTABLE = 1;
    private static final byte SCHEMA_MODE_VALUE_MANUAL = 5;
    private static final byte SCHEMA_MODE_VALUE_READONLY = 2;
    private static final byte SCHEMA_MODE_VALUE_RESET_FILE = 3;
    private static final byte SYNCSESSION_STOP_POLICY_VALUE_AFTER_CHANGES_UPLOADED = 2;
    private static final byte SYNCSESSION_STOP_POLICY_VALUE_IMMEDIATELY = 0;
    private static final byte SYNCSESSION_STOP_POLICY_VALUE_LIVE_INDEFINETELY = 1;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final CompactOnLaunchCallback compactOnLaunchCallback;
    private final NativeContext context;
    private final OsSharedRealm.InitializationCallback initializationCallback;
    private final OsSharedRealm.MigrationCallback migrationCallback;
    private final long nativePtr;
    private final RealmConfiguration realmConfiguration;
    private final URI resolvedRealmURI;

    /* renamed from: io.realm.internal.OsRealmConfig$1 */
    static /* synthetic */ class C19701 {
        static final /* synthetic */ int[] $SwitchMap$java$net$Proxy$Type;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            $SwitchMap$java$net$Proxy$Type = iArr;
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: io.realm.internal.OsRealmConfig$Builder */
    public static class Builder {
        private boolean autoUpdateNotification = false;
        private RealmConfiguration configuration;
        private String fifoFallbackDir = "";
        private OsSharedRealm.InitializationCallback initializationCallback = null;
        private OsSharedRealm.MigrationCallback migrationCallback = null;
        private OsSchemaInfo schemaInfo = null;

        public Builder(RealmConfiguration realmConfiguration) {
            this.configuration = realmConfiguration;
        }

        public Builder autoUpdateNotification(boolean z) {
            this.autoUpdateNotification = z;
            return this;
        }

        public OsRealmConfig build() {
            return new OsRealmConfig(this.configuration, this.fifoFallbackDir, this.autoUpdateNotification, this.schemaInfo, this.migrationCallback, this.initializationCallback, (C19701) null);
        }

        public Builder fifoFallbackDir(File file) {
            this.fifoFallbackDir = file.getAbsolutePath();
            return this;
        }

        public Builder initializationCallback(OsSharedRealm.InitializationCallback initializationCallback2) {
            this.initializationCallback = initializationCallback2;
            return this;
        }

        public Builder migrationCallback(OsSharedRealm.MigrationCallback migrationCallback2) {
            this.migrationCallback = migrationCallback2;
            return this;
        }

        public Builder schemaInfo(OsSchemaInfo osSchemaInfo) {
            this.schemaInfo = osSchemaInfo;
            return this;
        }
    }

    /* renamed from: io.realm.internal.OsRealmConfig$Durability */
    public enum Durability {
        FULL(0),
        MEM_ONLY(1);
        
        final int value;

        private Durability(int i) {
            this.value = i;
        }
    }

    /* renamed from: io.realm.internal.OsRealmConfig$SchemaMode */
    public enum SchemaMode {
        SCHEMA_MODE_AUTOMATIC((byte) 0),
        SCHEMA_MODE_IMMUTABLE((byte) 1),
        SCHEMA_MODE_READONLY((byte) 2),
        SCHEMA_MODE_RESET_FILE((byte) 3),
        SCHEMA_MODE_ADDITIVE((byte) 4),
        SCHEMA_MODE_MANUAL((byte) 5);
        
        final byte value;

        private SchemaMode(byte b) {
            this.value = b;
        }

        public byte getNativeValue() {
            return this.value;
        }
    }

    /* renamed from: io.realm.internal.OsRealmConfig$SyncSessionStopPolicy */
    public enum SyncSessionStopPolicy {
        IMMEDIATELY((byte) 0),
        LIVE_INDEFINITELY((byte) 1),
        AFTER_CHANGES_UPLOADED((byte) 2);
        
        final byte value;

        private SyncSessionStopPolicy(byte b) {
            this.value = b;
        }

        public byte getNativeValue() {
            return this.value;
        }
    }

    private OsRealmConfig(RealmConfiguration realmConfiguration2, String str, boolean z, OsSchemaInfo osSchemaInfo, OsSharedRealm.MigrationCallback migrationCallback2, OsSharedRealm.InitializationCallback initializationCallback2) {
        URI uri;
        OsSharedRealm.InitializationCallback initializationCallback3 = initializationCallback2;
        this.context = new NativeContext();
        this.realmConfiguration = realmConfiguration2;
        this.nativePtr = nativeCreate(realmConfiguration2.getPath(), str, false, true);
        NativeContext.dummyContext.addReference(this);
        Object[] syncConfigurationOptions = ObjectServerFacade.getSyncFacadeIfPossible().getSyncConfigurationOptions(this.realmConfiguration);
        String str2 = (String) syncConfigurationOptions[0];
        String str3 = (String) syncConfigurationOptions[1];
        String str4 = (String) syncConfigurationOptions[2];
        String str5 = (String) syncConfigurationOptions[3];
        boolean equals = Boolean.TRUE.equals(syncConfigurationOptions[4]);
        String str6 = (String) syncConfigurationOptions[5];
        Byte b = (Byte) syncConfigurationOptions[6];
        boolean equals2 = Boolean.TRUE.equals(syncConfigurationOptions[7]);
        String str7 = (String) syncConfigurationOptions[8];
        String str8 = (String) syncConfigurationOptions[9];
        Byte b2 = (Byte) syncConfigurationOptions[11];
        Map map = (Map) syncConfigurationOptions[10];
        String[] strArr = new String[(map != null ? map.size() * 2 : 0)];
        if (map != null) {
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                strArr[i] = (String) entry.getKey();
                strArr[i + 1] = (String) entry.getValue();
                i += 2;
            }
        }
        byte[] encryptionKey = realmConfiguration2.getEncryptionKey();
        if (encryptionKey != null) {
            nativeSetEncryptionKey(this.nativePtr, encryptionKey);
        }
        nativeSetInMemory(this.nativePtr, realmConfiguration2.getDurability() == Durability.MEM_ONLY);
        nativeEnableChangeNotification(this.nativePtr, z);
        SchemaMode schemaMode = SchemaMode.SCHEMA_MODE_MANUAL;
        if (realmConfiguration2.isRecoveryConfiguration()) {
            schemaMode = SchemaMode.SCHEMA_MODE_IMMUTABLE;
        } else if (realmConfiguration2.isReadOnly()) {
            schemaMode = SchemaMode.SCHEMA_MODE_READONLY;
        } else if (str3 != null) {
            schemaMode = SchemaMode.SCHEMA_MODE_ADDITIVE;
        } else if (realmConfiguration2.shouldDeleteRealmIfMigrationNeeded()) {
            schemaMode = SchemaMode.SCHEMA_MODE_RESET_FILE;
        }
        long schemaVersion = realmConfiguration2.getSchemaVersion();
        long nativePtr2 = osSchemaInfo == null ? 0 : osSchemaInfo.getNativePtr();
        this.migrationCallback = migrationCallback2;
        String[] strArr2 = strArr;
        nativeSetSchemaConfig(this.nativePtr, schemaMode.getNativeValue(), schemaVersion, nativePtr2, migrationCallback2);
        CompactOnLaunchCallback compactOnLaunchCallback2 = realmConfiguration2.getCompactOnLaunchCallback();
        this.compactOnLaunchCallback = compactOnLaunchCallback2;
        if (compactOnLaunchCallback2 != null) {
            nativeSetCompactOnLaunchCallback(this.nativePtr, compactOnLaunchCallback2);
        }
        this.initializationCallback = initializationCallback3;
        if (initializationCallback3 != null) {
            nativeSetInitializationCallback(this.nativePtr, initializationCallback3);
        }
        URI uri2 = null;
        if (str3 != null) {
            boolean z2 = equals;
            String str9 = str6;
            String nativeCreateAndSetSyncConfig = nativeCreateAndSetSyncConfig(this.nativePtr, str3, str4, str2, str5, equals2, b.byteValue(), str7, str8, strArr2, b2.byteValue());
            try {
                uri = new URI(nativeCreateAndSetSyncConfig);
            } catch (URISyntaxException e) {
                RealmLog.error(e, "Cannot create a URI from the Realm URL address", new Object[0]);
                uri = null;
            }
            nativeSetSyncConfigSslSettings(this.nativePtr, z2, str9);
            ProxySelector proxySelector = ProxySelector.getDefault();
            if (!(uri == null || proxySelector == null)) {
                try {
                    uri2 = new URI(nativeCreateAndSetSyncConfig.replaceFirst("realm", "http"));
                } catch (URISyntaxException e2) {
                    RealmLog.error(e2, "Cannot create a URI from the Realm URL address", new Object[0]);
                }
                List<Proxy> select = proxySelector.select(uri2);
                if (select != null && !select.isEmpty()) {
                    Proxy proxy = select.get(0);
                    if (proxy.type() != Proxy.Type.DIRECT) {
                        byte b3 = C19701.$SwitchMap$java$net$Proxy$Type[proxy.type().ordinal()] == 1 ? (byte) 0 : -1;
                        if (proxy.type() == Proxy.Type.HTTP) {
                            SocketAddress address = proxy.address();
                            if (address instanceof InetSocketAddress) {
                                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                                nativeSetSyncConfigProxySettings(this.nativePtr, b3, inetSocketAddress.getHostString(), inetSocketAddress.getPort());
                            } else {
                                StringBuilder a = C0681a.m330a("Unsupported proxy socket address type: ");
                                a.append(address.getClass().getName());
                                RealmLog.error(a.toString(), new Object[0]);
                            }
                        } else {
                            RealmLog.error("SOCKS proxies are not supported.", new Object[0]);
                        }
                    }
                }
            }
            uri2 = uri;
        }
        this.resolvedRealmURI = uri2;
    }

    /* synthetic */ OsRealmConfig(RealmConfiguration realmConfiguration2, String str, boolean z, OsSchemaInfo osSchemaInfo, OsSharedRealm.MigrationCallback migrationCallback2, OsSharedRealm.InitializationCallback initializationCallback2, C19701 r7) {
        this(realmConfiguration2, str, z, osSchemaInfo, migrationCallback2, initializationCallback2);
    }

    private static native long nativeCreate(String str, String str2, boolean z, boolean z2);

    private static native String nativeCreateAndSetSyncConfig(long j, String str, String str2, String str3, String str4, boolean z, byte b, String str5, String str6, String[] strArr, byte b2);

    private static native void nativeEnableChangeNotification(long j, boolean z);

    private static native long nativeGetFinalizerPtr();

    private static native void nativeSetCompactOnLaunchCallback(long j, CompactOnLaunchCallback compactOnLaunchCallback2);

    private static native void nativeSetEncryptionKey(long j, byte[] bArr);

    private static native void nativeSetInMemory(long j, boolean z);

    private native void nativeSetInitializationCallback(long j, OsSharedRealm.InitializationCallback initializationCallback2);

    private native void nativeSetSchemaConfig(long j, byte b, long j2, long j3, OsSharedRealm.MigrationCallback migrationCallback2);

    private static native void nativeSetSyncConfigProxySettings(long j, byte b, String str, int i);

    private static native void nativeSetSyncConfigSslSettings(long j, boolean z, String str);

    /* access modifiers changed from: package-private */
    public NativeContext getContext() {
        return this.context;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public RealmConfiguration getRealmConfiguration() {
        return this.realmConfiguration;
    }

    public URI getResolvedRealmURI() {
        return this.resolvedRealmURI;
    }
}
