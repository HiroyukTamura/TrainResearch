package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzib.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzib<MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgj<MessageType, BuilderType> {
    private static Map<Object, zzib<?, ?>> zzd = new ConcurrentHashMap();
    protected zzkt zzb = zzkt.zza();
    private int zzc = -1;

    public static abstract class zza<MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgi<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zza(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (zzib) messagetype.zza(zzf.zzd, (Object) null, (Object) null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjy.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzhf zzhf, zzho zzho) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzjy.zza().zza(this.zza).zza(this.zza, zzhg.zza(zzhf), zzho);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzho zzho) throws zzij {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzjy.zza().zza(this.zza).zza(this.zza, bArr, 0, i2 + 0, new zzgo(zzho));
                return this;
            } catch (zzij e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzij.zza();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza2 = (zza) this.zzc.zza(zzf.zze, (Object) null, (Object) null);
            zza2.zza((zzib) zzu());
            return zza2;
        }

        /* renamed from: g_ */
        public final boolean mo22643g_() {
            return zzib.zza(this.zza, false);
        }

        /* renamed from: h_ */
        public final /* synthetic */ zzjj mo22644h_() {
            return this.zzc;
        }

        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2) throws zzij {
            return zzb(bArr, 0, i2, zzho.zza());
        }

        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2, zzho zzho) throws zzij {
            return zzb(bArr, 0, i2, zzho);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        public final /* synthetic */ zzgi zzp() {
            return (zza) clone();
        }

        /* access modifiers changed from: protected */
        public void zzq() {
            MessageType messagetype = (zzib) this.zza.zza(zzf.zzd, (Object) null, (Object) null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: zzs */
        public MessageType zzu() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzjy.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzt */
        public final MessageType zzv() {
            MessageType messagetype = (zzib) zzu();
            if (messagetype.mo22643g_()) {
                return messagetype;
            }
            throw new zzkr(messagetype);
        }
    }

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzib<MessageType, BuilderType> implements zzjl {
        protected zzhr<zze> zzc = zzhr.zza();

        /* access modifiers changed from: package-private */
        public final zzhr<zze> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzhr) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public static class zzc<T extends zzib<T, ?>> extends zzgk<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    public static class zzd<ContainingType extends zzjj, Type> extends zzhm<ContainingType, Type> {
    }

    static final class zze implements zzht<zze> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzjm zza(zzjm zzjm, zzjj zzjj) {
            throw new NoSuchMethodError();
        }

        public final zzjs zza(zzjs zzjs, zzjs zzjs2) {
            throw new NoSuchMethodError();
        }

        public final zzlh zzb() {
            throw new NoSuchMethodError();
        }

        public final zzlo zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* 'enum' modifier removed */
    public static final class zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    static <T extends zzib<?, ?>> T zza(Class<T> cls) {
        T t = (zzib) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzib) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzib) ((zzib) zzla.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static zzih zza(zzih zzih) {
        int size = zzih.size();
        return zzih.zzc(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzik<E> zza(zzik<E> zzik) {
        int size = zzik.size();
        return zzik.zza(size == 0 ? 10 : size << 1);
    }

    protected static Object zza(zzjj zzjj, String str, Object[] objArr) {
        return new zzka(zzjj, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static <T extends zzib<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static final <T extends zzib<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzjy.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }

    protected static zzii zzbn() {
        return zzic.zzd();
    }

    protected static zzih zzbo() {
        return zzix.zzd();
    }

    protected static <E> zzik<E> zzbp() {
        return zzjx.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjy.zza().zza(this).zza(this, (zzib) obj);
        }
        return false;
    }

    /* renamed from: g_ */
    public final boolean mo22643g_() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* renamed from: h_ */
    public final /* synthetic */ zzjj mo22644h_() {
        return (zzib) zza(zzf.zzf, (Object) null, (Object) null);
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza2 = zzjy.zza().zza(this).zza(this);
        this.zza = zza2;
        return zza2;
    }

    public String toString() {
        return zzjo.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public final void zza(zzhi zzhi) throws IOException {
        zzjy.zza().zza(this).zza(this, (zzln) zzhl.zza(zzhi));
    }

    /* access modifiers changed from: package-private */
    public final int zzbj() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbk() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzbl() {
        BuilderType buildertype = (zza) zza(zzf.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    public final int zzbm() {
        if (this.zzc == -1) {
            this.zzc = zzjy.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    public final /* synthetic */ zzjm zzbq() {
        zza zza2 = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzjm zzbr() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i) {
        this.zzc = i;
    }
}
