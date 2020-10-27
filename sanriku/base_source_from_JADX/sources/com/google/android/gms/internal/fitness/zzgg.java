package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;
import com.google.android.gms.internal.fitness.zzgg.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzgg<MessageType extends zzgg<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzex<MessageType, BuilderType> {
    private static Map<Object, zzgg<?, ?>> zzvd = new ConcurrentHashMap();
    protected zzit zzvb = zzit.zzdd();
    private int zzvc = -1;

    public static class zza<T extends zzgg<T, ?>> extends zzfb<T> {
        private final T zzvf;

        public zza(T t) {
            this.zzvf = t;
        }
    }

    public static abstract class zzb<MessageType extends zzgg<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzez<MessageType, BuilderType> {
        private final MessageType zzvf;
        private MessageType zzvg;
        private boolean zzvh = false;

        protected zzb(MessageType messagetype) {
            this.zzvf = messagetype;
            this.zzvg = (zzgg) messagetype.zza(zze.zzvo, (Object) null, (Object) null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzia.zzcp().zzl(messagetype).zzd(messagetype, messagetype2);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb = (zzb) this.zzvf.zza(zze.zzvp, (Object) null, (Object) null);
            zzb.zza((zzgg) zzbq());
            return zzb;
        }

        public final boolean isInitialized() {
            return zzgg.zza(this.zzvg, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzvh) {
                MessageType messagetype2 = (zzgg) this.zzvg.zza(zze.zzvo, (Object) null, (Object) null);
                zza(messagetype2, this.zzvg);
                this.zzvg = messagetype2;
                this.zzvh = false;
            }
            zza(this.zzvg, messagetype);
            return this;
        }

        public final /* synthetic */ zzez zzaj() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzho zzbm() {
            return this.zzvf;
        }

        /* renamed from: zzbo */
        public MessageType zzbq() {
            if (this.zzvh) {
                return this.zzvg;
            }
            MessageType messagetype = this.zzvg;
            zzia.zzcp().zzl(messagetype).zzc(messagetype);
            this.zzvh = true;
            return this.zzvg;
        }

        /* renamed from: zzbp */
        public final MessageType zzbr() {
            MessageType messagetype = (zzgg) zzbq();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzir(messagetype);
        }
    }

    static final class zzc implements zzgd<zzc> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final zzhn zza(zzhn zzhn, zzho zzho) {
            throw new NoSuchMethodError();
        }

        public final zzhu zza(zzhu zzhu, zzhu zzhu2) {
            throw new NoSuchMethodError();
        }

        public final zzji zzbg() {
            throw new NoSuchMethodError();
        }

        public final zzjl zzbh() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbi() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbj() {
            throw new NoSuchMethodError();
        }

        public final int zzc() {
            throw new NoSuchMethodError();
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzgg<MessageType, BuilderType> implements zzhq {
        protected zzgb<zzc> zzvi = zzgb.zzbe();
    }

    /* 'enum' modifier removed */
    public static final class zze {
        public static final int zzvl = 1;
        public static final int zzvm = 2;
        public static final int zzvn = 3;
        public static final int zzvo = 4;
        public static final int zzvp = 5;
        public static final int zzvq = 6;
        public static final int zzvr = 7;
        private static final /* synthetic */ int[] zzvs = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzvt = 1;
        public static final int zzvu = 2;
        private static final /* synthetic */ int[] zzvv = {1, 2};
        public static final int zzvw = 1;
        public static final int zzvx = 2;
        private static final /* synthetic */ int[] zzvy = {1, 2};

        public static int[] zzbs() {
            return (int[]) zzvs.clone();
        }
    }

    static <T extends zzgg<?, ?>> T zza(Class<T> cls) {
        T t = (zzgg) zzvd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzgg) zzvd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzgg) ((zzgg) zzja.zzg(cls)).zza(zze.zzvq, (Object) null, (Object) null);
            if (t != null) {
                zzvd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static Object zza(zzho zzho, String str, Object[] objArr) {
        return new zzhz(zzho, str, (Object[]) null);
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

    protected static <T extends zzgg<?, ?>> void zza(Class<T> cls, T t) {
        zzvd.put(cls, t);
    }

    protected static final <T extends zzgg<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzvl, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzj = zzia.zzcp().zzl(t).zzj(t);
        if (z) {
            t.zza(zze.zzvm, (Object) zzj ? t : null, (Object) null);
        }
        return zzj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzgg) zza(zze.zzvq, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzia.zzcp().zzl(this).equals(this, (zzgg) obj);
    }

    public int hashCode() {
        int i = this.zzrb;
        if (i != 0) {
            return i;
        }
        int hashCode = zzia.zzcp().zzl(this).hashCode(this);
        this.zzrb = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public String toString() {
        return zzhp.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzah() {
        return this.zzvc;
    }

    public final void zzb(zzfs zzfs) throws IOException {
        zzia.zzcp().zzl(this).zza(this, zzfv.zza(zzfs));
    }

    public final int zzbk() {
        if (this.zzvc == -1) {
            this.zzvc = zzia.zzcp().zzl(this).zzk(this);
        }
        return this.zzvc;
    }

    public final /* synthetic */ zzhn zzbl() {
        zzb zzb2 = (zzb) zza(zze.zzvp, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzho zzbm() {
        return (zzgg) zza(zze.zzvq, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(int i) {
        this.zzvc = i;
    }
}
