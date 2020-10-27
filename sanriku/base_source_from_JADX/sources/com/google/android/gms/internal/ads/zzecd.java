package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import com.google.android.gms.internal.ads.zzecd.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzecd<MessageType extends zzecd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzeag<MessageType, BuilderType> {
    private static Map<Object, zzecd<?, ?>> zzhxx = new ConcurrentHashMap();
    protected zzefb zzhxv = zzefb.zzbhd();
    private int zzhxw = -1;

    public static abstract class zza<MessageType extends zzecd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzeaj<MessageType, BuilderType> {
        private final MessageType zzhxs;
        protected MessageType zzhxt;
        protected boolean zzhxu = false;

        protected zza(MessageType messagetype) {
            this.zzhxs = messagetype;
            this.zzhxt = (zzecd) messagetype.zza(zzf.zzhye, (Object) null, (Object) null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzedz.zzbgk().zzax(messagetype).zzf(messagetype, messagetype2);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzebf zzebf, zzebq zzebq) throws IOException {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            try {
                zzedz.zzbgk().zzax(this.zzhxt).zza(this.zzhxt, zzebi.zza(zzebf), zzebq);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzebq zzebq) throws zzeco {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            try {
                zzedz.zzbgk().zzax(this.zzhxt).zza(this.zzhxt, bArr, 0, i2 + 0, new zzeap(zzebq));
                return this;
            } catch (zzeco e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzeco.zzbfg();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzhxs.zza(zzf.zzhyf, (Object) null, (Object) null);
            zza.zza((zzecd) zzbes());
            return zza;
        }

        public final boolean isInitialized() {
            return zzecd.zza(this.zzhxt, false);
        }

        public final /* synthetic */ zzeaj zza(byte[] bArr, int i, int i2, zzebq zzebq) throws zzeco {
            return zzb(bArr, 0, i2, zzebq);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            zza(this.zzhxt, messagetype);
            return this;
        }

        public final /* synthetic */ zzeaj zzbch() {
            return (zza) clone();
        }

        /* access modifiers changed from: protected */
        public void zzbep() {
            MessageType messagetype = (zzecd) this.zzhxt.zza(zzf.zzhye, (Object) null, (Object) null);
            zza(messagetype, this.zzhxt);
            this.zzhxt = messagetype;
        }

        /* renamed from: zzbeq */
        public MessageType zzbes() {
            if (this.zzhxu) {
                return this.zzhxt;
            }
            MessageType messagetype = this.zzhxt;
            zzedz.zzbgk().zzax(messagetype).zzak(messagetype);
            this.zzhxu = true;
            return this.zzhxt;
        }

        /* renamed from: zzber */
        public final MessageType zzbet() {
            MessageType messagetype = (zzecd) zzbes();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzeez(messagetype);
        }

        public final /* synthetic */ zzedo zzbeu() {
            return this.zzhxs;
        }
    }

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzecd<MessageType, BuilderType> implements zzedq {
        protected zzebt<zze> zzhxy = zzebt.zzbee();

        /* access modifiers changed from: package-private */
        public final zzebt<zze> zzbfd() {
            if (this.zzhxy.isImmutable()) {
                this.zzhxy = (zzebt) this.zzhxy.clone();
            }
            return this.zzhxy;
        }
    }

    public static class zzc<T extends zzecd<T, ?>> extends zzeal<T> {
        private final T zzhxs;

        public zzc(T t) {
            this.zzhxs = t;
        }
    }

    public static class zzd<ContainingType extends zzedo, Type> extends zzebo<ContainingType, Type> {
    }

    static final class zze implements zzebv<zze> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final zzedn zza(zzedn zzedn, zzedo zzedo) {
            throw new NoSuchMethodError();
        }

        public final zzedt zza(zzedt zzedt, zzedt zzedt2) {
            throw new NoSuchMethodError();
        }

        public final zzefp zzbej() {
            throw new NoSuchMethodError();
        }

        public final zzefw zzbek() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbel() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbem() {
            throw new NoSuchMethodError();
        }

        public final int zzw() {
            throw new NoSuchMethodError();
        }
    }

    /* 'enum' modifier removed */
    public static final class zzf {
        public static final int zzhyb = 1;
        public static final int zzhyc = 2;
        public static final int zzhyd = 3;
        public static final int zzhye = 4;
        public static final int zzhyf = 5;
        public static final int zzhyg = 6;
        public static final int zzhyh = 7;
        private static final /* synthetic */ int[] zzhyi = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzhyj = 1;
        public static final int zzhyk = 2;
        private static final /* synthetic */ int[] zzhyl = {1, 2};
        public static final int zzhym = 1;
        public static final int zzhyn = 2;
        private static final /* synthetic */ int[] zzhyo = {1, 2};

        public static int[] zzbff() {
            return (int[]) zzhyi.clone();
        }
    }

    protected static <T extends zzecd<T, ?>> T zza(T t, zzeaq zzeaq) throws zzeco {
        return zzb(zzb(zzb(t, zzeaq, zzebq.zzbec())));
    }

    protected static <T extends zzecd<T, ?>> T zza(T t, zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return zzb(zzb(t, zzeaq, zzebq));
    }

    private static <T extends zzecd<T, ?>> T zza(T t, zzebf zzebf, zzebq zzebq) throws zzeco {
        T t2 = (zzecd) t.zza(zzf.zzhye, (Object) null, (Object) null);
        try {
            zzeek zzax = zzedz.zzbgk().zzax(t2);
            zzax.zza(t2, zzebi.zza(zzebf), zzebq);
            zzax.zzak(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzeco) {
                throw ((zzeco) e.getCause());
            }
            throw new zzeco(e.getMessage()).zzl(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzeco) {
                throw ((zzeco) e2.getCause());
            }
            throw e2;
        }
    }

    protected static <T extends zzecd<T, ?>> T zza(T t, byte[] bArr) throws zzeco {
        return zzb(zza(t, bArr, 0, bArr.length, zzebq.zzbec()));
    }

    private static <T extends zzecd<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzebq zzebq) throws zzeco {
        T t2 = (zzecd) t.zza(zzf.zzhye, (Object) null, (Object) null);
        try {
            zzeek zzax = zzedz.zzbgk().zzax(t2);
            zzax.zza(t2, bArr, 0, i2, new zzeap(zzebq));
            zzax.zzak(t2);
            if (t2.zzhsq == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzeco) {
                throw ((zzeco) e.getCause());
            }
            throw new zzeco(e.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzeco.zzbfg().zzl(t2);
        }
    }

    protected static <T extends zzecd<T, ?>> T zza(T t, byte[] bArr, zzebq zzebq) throws zzeco {
        return zzb(zza(t, bArr, 0, bArr.length, zzebq));
    }

    protected static zzeck zza(zzeck zzeck) {
        int size = zzeck.size();
        return zzeck.zzgv(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzecl<E> zza(zzecl<E> zzecl) {
        int size = zzecl.size();
        return zzecl.zzfn(size == 0 ? 10 : size << 1);
    }

    protected static Object zza(zzedo zzedo, String str, Object[] objArr) {
        return new zzeeb(zzedo, str, objArr);
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

    protected static <T extends zzecd<?, ?>> void zza(Class<T> cls, T t) {
        zzhxx.put(cls, t);
    }

    protected static final <T extends zzecd<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zzhyb, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzaw = zzedz.zzbgk().zzax(t).zzaw(t);
        if (z) {
            t.zza(zzf.zzhyc, (Object) zzaw ? t : null, (Object) null);
        }
        return zzaw;
    }

    private static <T extends zzecd<T, ?>> T zzb(T t) throws zzeco {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzeco(new zzeez(t).getMessage()).zzl(t);
    }

    private static <T extends zzecd<T, ?>> T zzb(T t, zzeaq zzeaq, zzebq zzebq) throws zzeco {
        T zza2;
        try {
            zzebf zzbcq = zzeaq.zzbcq();
            zza2 = zza(t, zzbcq, zzebq);
            zzbcq.zzfs(0);
            return zza2;
        } catch (zzeco e) {
            throw e.zzl(zza2);
        } catch (zzeco e2) {
            throw e2;
        }
    }

    protected static zzeck zzbey() {
        return zzece.zzbfe();
    }

    protected static zzecm zzbez() {
        return zzedc.zzbfx();
    }

    protected static <E> zzecl<E> zzbfa() {
        return zzeec.zzbgn();
    }

    static <T extends zzecd<?, ?>> T zzf(Class<T> cls) {
        T t = (zzecd) zzhxx.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzecd) zzhxx.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzecd) ((zzecd) zzefi.zzj(cls)).zza(zzf.zzhyg, (Object) null, (Object) null);
            if (t != null) {
                zzhxx.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzedz.zzbgk().zzax(this).equals(this, (zzecd) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzhsq;
        if (i != 0) {
            return i;
        }
        int hashCode = zzedz.zzbgk().zzax(this).hashCode(this);
        this.zzhsq = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public String toString() {
        return zzedp.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public final void zzb(zzebk zzebk) throws IOException {
        zzedz.zzbgk().zzax(this).zza(this, zzebn.zza(zzebk));
    }

    /* access modifiers changed from: package-private */
    public final int zzbcf() {
        return this.zzhxw;
    }

    public final /* synthetic */ zzedo zzbeu() {
        return (zzecd) zza(zzf.zzhyg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzecd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbev() {
        return (zza) zza(zzf.zzhyf, (Object) null, (Object) null);
    }

    public final BuilderType zzbew() {
        BuilderType buildertype = (zza) zza(zzf.zzhyf, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    public final int zzbex() {
        if (this.zzhxw == -1) {
            this.zzhxw = zzedz.zzbgk().zzax(this).zzau(this);
        }
        return this.zzhxw;
    }

    public final /* synthetic */ zzedn zzbfb() {
        zza zza2 = (zza) zza(zzf.zzhyf, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzedn zzbfc() {
        return (zza) zza(zzf.zzhyf, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzfk(int i) {
        this.zzhxw = i;
    }
}
