// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase;

import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicReference;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.support.annotation.UiThread;
import com.google.android.gms.internal.aae;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.android.gms.tasks.Task;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import java.lang.reflect.Modifier;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.internal.zzbax;
import com.google.android.gms.internal.zzbaw;
import android.app.Application;
import android.text.TextUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzr;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import com.google.android.gms.internal.aac;
import com.google.android.gms.internal.aab;
import com.google.android.gms.common.internal.zzbo;
import java.util.concurrent.CopyOnWriteArrayList;
import android.support.v4.util.ArrayMap;
import java.util.Collections;
import java.util.Arrays;
import com.google.android.gms.internal.aad;
import java.util.concurrent.atomic.AtomicBoolean;
import android.content.Context;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class FirebaseApp
{
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final List<String> zzbUV;
    private static final List<String> zzbUW;
    private static final List<String> zzbUX;
    private static final List<String> zzbUY;
    private static final Set<String> zzbUZ;
    static final Map<String, FirebaseApp> zzbgQ;
    private static final Object zzuF;
    private final Context mApplicationContext;
    private final String mName;
    private final FirebaseOptions zzbVa;
    private final AtomicBoolean zzbVb;
    private final AtomicBoolean zzbVc;
    private final List<zza> zzbVd;
    private final List<zzc> zzbVe;
    private final List<Object> zzbVf;
    private aad zzbVg;
    private zzb zzbVh;
    
    static {
        zzbUV = Arrays.asList("com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId");
        zzbUW = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
        zzbUX = Arrays.asList("com.google.android.gms.measurement.AppMeasurement");
        zzbUY = Arrays.asList(new String[0]);
        zzbUZ = Collections.emptySet();
        zzuF = new Object();
        zzbgQ = new ArrayMap<String, FirebaseApp>();
    }
    
    private FirebaseApp(final Context context, final String s, final FirebaseOptions firebaseOptions) {
        this.zzbVb = new AtomicBoolean(false);
        this.zzbVc = new AtomicBoolean();
        this.zzbVd = new CopyOnWriteArrayList<zza>();
        this.zzbVe = new CopyOnWriteArrayList<zzc>();
        this.zzbVf = new CopyOnWriteArrayList<Object>();
        this.mApplicationContext = zzbo.zzu(context);
        this.mName = zzbo.zzcF(s);
        this.zzbVa = zzbo.zzu(firebaseOptions);
        this.zzbVh = (zzb)new aab();
    }
    
    public static List<FirebaseApp> getApps(final Context context) {
        aac.zzbL(context);
        final ArrayList<FirebaseApp> list;
        synchronized (FirebaseApp.zzuF) {
            list = new ArrayList<FirebaseApp>(FirebaseApp.zzbgQ.values());
            aac.zzJZ();
            final Set<String> zzKa = aac.zzKa();
            zzKa.removeAll(FirebaseApp.zzbgQ.keySet());
            for (final String s : zzKa) {
                aac.zzhq(s);
                list.add(initializeApp(context, null, s));
            }
        }
        // monitorexit(o)
        return list;
    }
    
    @Nullable
    public static FirebaseApp getInstance() {
        synchronized (FirebaseApp.zzuF) {
            if (FirebaseApp.zzbgQ.get("[DEFAULT]") == null) {
                final String value = String.valueOf(zzr.zzsf());
                throw new IllegalStateException(new StringBuilder(String.valueOf(value).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(value).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        // monitorexit(o)
        return;
    }
    
    public static FirebaseApp getInstance(@NonNull final String s) {
        while (true) {
            while (true) {
                Object o;
                synchronized (FirebaseApp.zzuF) {
                    o = FirebaseApp.zzbgQ.get(s.trim());
                    if (o != null) {
                        return (FirebaseApp)o;
                    }
                    o = zzEs();
                    if (((List)o).isEmpty()) {
                        o = "";
                        throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", s, o));
                    }
                }
                final String value = String.valueOf(TextUtils.join((CharSequence)", ", (Iterable)o));
                if (value.length() != 0) {
                    o = "Available app names: ".concat(value);
                    continue;
                }
                o = new String("Available app names: ");
                continue;
            }
        }
    }
    
    @Nullable
    public static FirebaseApp initializeApp(final Context context) {
        final FirebaseOptions fromResource;
        synchronized (FirebaseApp.zzuF) {
            if (FirebaseApp.zzbgQ.containsKey("[DEFAULT]")) {
                return getInstance();
            }
            fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                return null;
            }
        }
        final Context context2;
        // monitorexit(o)
        return initializeApp(context2, fromResource);
    }
    
    public static FirebaseApp initializeApp(final Context context, final FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, "[DEFAULT]");
    }
    
    public static FirebaseApp initializeApp(Context applicationContext, final FirebaseOptions firebaseOptions, String trim) {
        aac.zzbL((Context)applicationContext);
        if (((Context)applicationContext).getApplicationContext() instanceof Application) {
            zzbaw.zza((Application)((Context)applicationContext).getApplicationContext());
            zzbaw.zzpv().zza(new com.google.firebase.zza());
        }
        trim = trim.trim();
        Label_0191: {
            if (((Context)applicationContext).getApplicationContext() != null) {
                break Label_0191;
            }
            while (true) {
                synchronized (FirebaseApp.zzuF) {
                    zzbo.zza(!FirebaseApp.zzbgQ.containsKey(trim), (Object)new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
                    zzbo.zzb(applicationContext, "Application context cannot be null.");
                    final FirebaseApp firebaseApp = new FirebaseApp((Context)applicationContext, trim, firebaseOptions);
                    FirebaseApp.zzbgQ.put(trim, firebaseApp);
                    // monitorexit(FirebaseApp.zzuF)
                    aac.zze(firebaseApp);
                    firebaseApp.zza(FirebaseApp.class, firebaseApp, FirebaseApp.zzbUV);
                    if (firebaseApp.zzEq()) {
                        firebaseApp.zza(FirebaseApp.class, firebaseApp, FirebaseApp.zzbUW);
                        firebaseApp.zza(Context.class, firebaseApp.getApplicationContext(), FirebaseApp.zzbUX);
                    }
                    return firebaseApp;
                    applicationContext = ((Context)applicationContext).getApplicationContext();
                }
            }
        }
    }
    
    private final void zzEp() {
        zzbo.zza(!this.zzbVc.get(), (Object)"FirebaseApp was deleted");
    }
    
    private static List<String> zzEs() {
        final com.google.android.gms.common.util.zza<String> zza = new com.google.android.gms.common.util.zza<String>();
        synchronized (FirebaseApp.zzuF) {
            final Iterator<FirebaseApp> iterator = FirebaseApp.zzbgQ.values().iterator();
            while (iterator.hasNext()) {
                zza.add(iterator.next().getName());
            }
        }
        final Set<Object> c;
        if (aac.zzJZ() != null) {
            c.addAll(aac.zzKa());
        }
        // monitorexit(o)
        final ArrayList<Comparable> list = (ArrayList<Comparable>)new ArrayList<String>((Collection<? extends String>)c);
        Collections.sort(list);
        return (List<String>)list;
    }
    
    private final void zzEt() {
        this.zza(FirebaseApp.class, this, FirebaseApp.zzbUV);
        if (this.zzEq()) {
            this.zza(FirebaseApp.class, this, FirebaseApp.zzbUW);
            this.zza(Context.class, this.mApplicationContext, FirebaseApp.zzbUX);
        }
    }
    
    private final <T> void zza(final Class<T> clazz, final T t, Iterable<String> obj) {
        final boolean deviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.mApplicationContext);
        if (deviceProtectedStorage) {
            zzbB(this.mApplicationContext);
        }
        final Iterator<String> iterator = ((Iterable<String>)obj).iterator();
    Label_0067_Outer:
        while (iterator.hasNext()) {
            obj = iterator.next();
            while (true) {
                if (deviceProtectedStorage) {
                    try {
                        if (!FirebaseApp.zzbUY.contains(obj)) {
                            continue Label_0067_Outer;
                        }
                        final Method method = Class.forName(obj).getMethod("getInstance", clazz);
                        final int modifiers = method.getModifiers();
                        if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                            method.invoke(null, t);
                            continue Label_0067_Outer;
                        }
                        continue Label_0067_Outer;
                    }
                    catch (ClassNotFoundException ex3) {
                        if (FirebaseApp.zzbUZ.contains(obj)) {
                            throw new IllegalStateException(String.valueOf(obj).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                        }
                        Log.d("FirebaseApp", String.valueOf(obj).concat(" is not linked. Skipping initialization."));
                        continue Label_0067_Outer;
                    }
                    catch (NoSuchMethodException ex4) {
                        throw new IllegalStateException(String.valueOf(obj).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                    }
                    catch (InvocationTargetException ex) {
                        Log.wtf("FirebaseApp", "Firebase API initialization failure.", (Throwable)ex);
                        continue Label_0067_Outer;
                    }
                    catch (IllegalAccessException ex2) {
                        final String value = String.valueOf(obj);
                        String concat;
                        if (value.length() != 0) {
                            concat = "Failed to initialize ".concat(value);
                        }
                        else {
                            concat = new String("Failed to initialize ");
                        }
                        Log.wtf("FirebaseApp", concat, (Throwable)ex2);
                        continue Label_0067_Outer;
                    }
                    break;
                }
                continue;
            }
        }
    }
    
    public static void zzac(final boolean b) {
        synchronized (FirebaseApp.zzuF) {
            final ArrayList<Object> list = new ArrayList<Object>(FirebaseApp.zzbgQ.values());
            int n;
            for (int size = list.size(), i = 0; i < size; i = n) {
                final FirebaseApp value = list.get(i);
                n = i + 1;
                final FirebaseApp firebaseApp = value;
                i = n;
                if (firebaseApp.zzbVb.get()) {
                    firebaseApp.zzav(b);
                }
            }
        }
    }
    // monitorexit(o)
    
    private final void zzav(final boolean b) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        final Iterator<zzc> iterator = this.zzbVe.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzac(b);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof FirebaseApp && this.mName.equals(((FirebaseApp)o).getName());
    }
    
    @NonNull
    public Context getApplicationContext() {
        this.zzEp();
        return this.mApplicationContext;
    }
    
    @NonNull
    public String getName() {
        this.zzEp();
        return this.mName;
    }
    
    @NonNull
    public FirebaseOptions getOptions() {
        this.zzEp();
        return this.zzbVa;
    }
    
    public final Task<GetTokenResult> getToken(final boolean b) {
        this.zzEp();
        if (this.zzbVg == null) {
            return Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode."));
        }
        return this.zzbVg.zzaw(b);
    }
    
    @Override
    public int hashCode() {
        return this.mName.hashCode();
    }
    
    public void setAutomaticResourceManagementEnabled(final boolean newValue) {
        this.zzEp();
        if (this.zzbVb.compareAndSet(!newValue, newValue)) {
            final boolean zzpw = zzbaw.zzpv().zzpw();
            if (newValue && zzpw) {
                this.zzav(true);
            }
            else if (!newValue && zzpw) {
                this.zzav(false);
            }
        }
    }
    
    @Override
    public String toString() {
        return zzbe.zzt(this).zzg("name", this.mName).zzg("options", this.zzbVa).toString();
    }
    
    public final boolean zzEq() {
        return "[DEFAULT]".equals(this.getName());
    }
    
    public final String zzEr() {
        final String value = String.valueOf(com.google.android.gms.common.util.zzc.zzh(this.getName().getBytes()));
        final String value2 = String.valueOf(com.google.android.gms.common.util.zzc.zzh(this.getOptions().getApplicationId().getBytes()));
        return new StringBuilder(String.valueOf(value).length() + 1 + String.valueOf(value2).length()).append(value).append("+").append(value2).toString();
    }
    
    public final void zza(@NonNull final aad aad) {
        this.zzbVg = zzbo.zzu(aad);
    }
    
    @UiThread
    public final void zza(@NonNull final aae aae) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        final Iterator<zza> iterator = this.zzbVd.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next().zzb(aae);
            ++i;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", i));
    }
    
    public final void zza(@NonNull final zza zza) {
        this.zzEp();
        zzbo.zzu(zza);
        this.zzbVd.add(zza);
        this.zzbVd.size();
    }
    
    public final void zza(final zzc zzc) {
        this.zzEp();
        if (this.zzbVb.get() && zzbaw.zzpv().zzpw()) {
            zzc.zzac(true);
        }
        this.zzbVe.add(zzc);
    }
    
    public interface zza
    {
        void zzb(@NonNull final aae p0);
    }
    
    public interface zzb
    {
    }
    
    public interface zzc
    {
        void zzac(final boolean p0);
    }
    
    @TargetApi(24)
    static final class zzd extends BroadcastReceiver
    {
        private static AtomicReference<zzd> zzbVi;
        private final Context mApplicationContext;
        
        static {
            zzd.zzbVi = new AtomicReference<zzd>();
        }
        
        private zzd(final Context mApplicationContext) {
            this.mApplicationContext = mApplicationContext;
        }
        
        private static void zzbB(final Context context) {
            if (zzd.zzbVi.get() == null) {
                final zzd newValue = new zzd(context);
                if (zzd.zzbVi.compareAndSet(null, newValue)) {
                    context.registerReceiver((BroadcastReceiver)newValue, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }
        
        public final void onReceive(final Context context, final Intent intent) {
            synchronized (FirebaseApp.zzuF) {
                final Iterator<FirebaseApp> iterator = FirebaseApp.zzbgQ.values().iterator();
                while (iterator.hasNext()) {
                    iterator.next().zzEt();
                }
            }
            // monitorexit(context)
            this.mApplicationContext.unregisterReceiver((BroadcastReceiver)this);
        }
    }
}
