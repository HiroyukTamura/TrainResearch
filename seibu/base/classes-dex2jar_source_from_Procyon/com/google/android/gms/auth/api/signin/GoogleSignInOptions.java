// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.auth.api.signin;

import java.util.Arrays;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;
import java.util.Set;
import android.os.Parcelable;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.internal.zzo;
import java.util.Iterator;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONObject;
import android.text.TextUtils;
import android.support.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.google.android.gms.auth.api.signin.internal.zzn;
import java.util.ArrayList;
import android.accounts.Account;
import java.util.Comparator;
import com.google.android.gms.common.api.Scope;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.safeparcel.zza;

public class GoogleSignInOptions extends zza implements Optional, ReflectedParcelable
{
    public static final Parcelable$Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    private static Scope SCOPE_GAMES;
    private static Comparator<Scope> zzalU;
    public static final Scope zzalV;
    public static final Scope zzalW;
    public static final Scope zzalX;
    private int versionCode;
    private Account zzajb;
    private final ArrayList<Scope> zzalY;
    private final boolean zzalZ;
    private boolean zzalh;
    private String zzali;
    private final boolean zzama;
    private String zzamb;
    private ArrayList<zzn> zzamc;
    private Map<Integer, zzn> zzamd;
    
    static {
        zzalV = new Scope("profile");
        zzalW = new Scope("email");
        zzalX = new Scope("openid");
        GoogleSignInOptions.SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
        DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
        DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(GoogleSignInOptions.SCOPE_GAMES, new Scope[0]).build();
        CREATOR = (Parcelable$Creator)new com.google.android.gms.auth.api.signin.zzd();
        GoogleSignInOptions.zzalU = new com.google.android.gms.auth.api.signin.zzc();
    }
    
    GoogleSignInOptions(final int n, final ArrayList<Scope> list, final Account account, final boolean b, final boolean b2, final boolean b3, final String s, final String s2, final ArrayList<zzn> list2) {
        this(n, list, account, b, b2, b3, s, s2, zzw(list2));
    }
    
    private GoogleSignInOptions(final int versionCode, final ArrayList<Scope> zzalY, final Account zzajb, final boolean zzalh, final boolean zzalZ, final boolean zzama, final String zzali, final String zzamb, final Map<Integer, zzn> zzamd) {
        this.versionCode = versionCode;
        this.zzalY = zzalY;
        this.zzajb = zzajb;
        this.zzalh = zzalh;
        this.zzalZ = zzalZ;
        this.zzama = zzama;
        this.zzali = zzali;
        this.zzamb = zzamb;
        this.zzamc = new ArrayList<zzn>(zzamd.values());
        this.zzamd = zzamd;
    }
    
    @Nullable
    public static GoogleSignInOptions zzbQ(@Nullable String optString) throws JSONException {
        if (TextUtils.isEmpty((CharSequence)optString)) {
            return null;
        }
        final JSONObject jsonObject = new JSONObject(optString);
        final HashSet<Scope> c = new HashSet<Scope>();
        final JSONArray jsonArray = jsonObject.getJSONArray("scopes");
        for (int length = jsonArray.length(), i = 0; i < length; ++i) {
            c.add(new Scope(jsonArray.getString(i)));
        }
        optString = jsonObject.optString("accountName", (String)null);
        Account account;
        if (!TextUtils.isEmpty((CharSequence)optString)) {
            account = new Account(optString, "com.google");
        }
        else {
            account = null;
        }
        return new GoogleSignInOptions(3, new ArrayList<Scope>(c), account, jsonObject.getBoolean("idTokenRequested"), jsonObject.getBoolean("serverAuthRequested"), jsonObject.getBoolean("forceCodeForRefreshToken"), jsonObject.optString("serverClientId", (String)null), jsonObject.optString("hostedDomain", (String)null), new HashMap<Integer, zzn>());
    }
    
    private final JSONObject zzmz() {
        final JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray();
            Collections.sort(this.zzalY, GoogleSignInOptions.zzalU);
            final ArrayList<Scope> list = this.zzalY;
            final int size = list.size();
            int i = 0;
            while (i < size) {
                final Scope value = list.get(i);
                ++i;
                jsonArray.put((Object)value.zzpp());
            }
        }
        catch (JSONException cause) {
            throw new RuntimeException((Throwable)cause);
        }
        jsonObject.put("scopes", (Object)jsonArray);
        if (this.zzajb != null) {
            jsonObject.put("accountName", (Object)this.zzajb.name);
        }
        jsonObject.put("idTokenRequested", this.zzalh);
        jsonObject.put("forceCodeForRefreshToken", this.zzama);
        jsonObject.put("serverAuthRequested", this.zzalZ);
        if (!TextUtils.isEmpty((CharSequence)this.zzali)) {
            jsonObject.put("serverClientId", (Object)this.zzali);
        }
        if (!TextUtils.isEmpty((CharSequence)this.zzamb)) {
            jsonObject.put("hostedDomain", (Object)this.zzamb);
        }
        return jsonObject;
    }
    
    private static Map<Integer, zzn> zzw(@Nullable final List<zzn> list) {
        final HashMap<Integer, zzn> hashMap = new HashMap<Integer, zzn>();
        if (list == null) {
            return hashMap;
        }
        for (final zzn zzn : list) {
            hashMap.put(zzn.getType(), zzn);
        }
        return hashMap;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != null) {
            try {
                final GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions)o;
                if (this.zzamc.size() <= 0 && googleSignInOptions.zzamc.size() <= 0 && this.zzalY.size() == googleSignInOptions.zzmA().size() && this.zzalY.containsAll(googleSignInOptions.zzmA())) {
                    if (this.zzajb == null) {
                        if (googleSignInOptions.zzajb != null) {
                            return false;
                        }
                    }
                    else if (!this.zzajb.equals((Object)googleSignInOptions.zzajb)) {
                        return false;
                    }
                    if (TextUtils.isEmpty((CharSequence)this.zzali)) {
                        if (!TextUtils.isEmpty((CharSequence)googleSignInOptions.zzali)) {
                            return false;
                        }
                    }
                    else if (!this.zzali.equals(googleSignInOptions.zzali)) {
                        return false;
                    }
                    if (this.zzama == googleSignInOptions.zzama && this.zzalh == googleSignInOptions.zzalh && this.zzalZ == googleSignInOptions.zzalZ) {
                        return true;
                    }
                }
            }
            catch (ClassCastException ex) {
                return false;
            }
        }
        return false;
    }
    
    public final Account getAccount() {
        return this.zzajb;
    }
    
    public Scope[] getScopeArray() {
        return this.zzalY.toArray(new Scope[this.zzalY.size()]);
    }
    
    public final String getServerClientId() {
        return this.zzali;
    }
    
    @Override
    public int hashCode() {
        final ArrayList<Comparable> list = new ArrayList<Comparable>();
        final ArrayList<Scope> list2 = this.zzalY;
        final int size = list2.size();
        int i = 0;
        while (i < size) {
            final Scope value = list2.get(i);
            ++i;
            list.add(value.zzpp());
        }
        Collections.sort(list);
        return new zzo().zzo(list).zzo(this.zzajb).zzo(this.zzali).zzP(this.zzama).zzP(this.zzalh).zzP(this.zzalZ).zzmJ();
    }
    
    public final boolean isIdTokenRequested() {
        return this.zzalh;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 2, this.zzmA(), false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, (Parcelable)this.zzajb, n, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzalh);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzalZ);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, this.zzama);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzali, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzamb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 9, this.zzamc, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzI(parcel, zze);
    }
    
    public final ArrayList<Scope> zzmA() {
        return new ArrayList<Scope>(this.zzalY);
    }
    
    public final boolean zzmB() {
        return this.zzalZ;
    }
    
    public final String zzmC() {
        return this.zzmz().toString();
    }
    
    public static final class Builder
    {
        private Account zzajb;
        private boolean zzalZ;
        private boolean zzalh;
        private String zzali;
        private boolean zzama;
        private String zzamb;
        private Set<Scope> zzame;
        private Map<Integer, zzn> zzamf;
        
        public Builder() {
            this.zzame = new HashSet<Scope>();
            this.zzamf = new HashMap<Integer, zzn>();
        }
        
        public Builder(@NonNull final GoogleSignInOptions googleSignInOptions) {
            this.zzame = new HashSet<Scope>();
            this.zzamf = new HashMap<Integer, zzn>();
            zzbo.zzu(googleSignInOptions);
            this.zzame = new HashSet<Scope>(googleSignInOptions.zzalY);
            this.zzalZ = googleSignInOptions.zzalZ;
            this.zzama = googleSignInOptions.zzama;
            this.zzalh = googleSignInOptions.zzalh;
            this.zzali = googleSignInOptions.zzali;
            this.zzajb = googleSignInOptions.zzajb;
            this.zzamb = googleSignInOptions.zzamb;
            this.zzamf = zzw(googleSignInOptions.zzamc);
        }
        
        private final String zzbR(final String anObject) {
            zzbo.zzcF(anObject);
            zzbo.zzb(this.zzali == null || this.zzali.equals(anObject), (Object)"two different server client ids provided");
            return anObject;
        }
        
        public final Builder addExtension(final GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (this.zzamf.containsKey(1)) {
                throw new IllegalStateException("Only one extension per type may be added");
            }
            this.zzamf.put(1, new zzn(googleSignInOptionsExtension));
            return this;
        }
        
        public final GoogleSignInOptions build() {
            if (this.zzalh && (this.zzajb == null || !this.zzame.isEmpty())) {
                this.requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList((Collection<? extends E>)this.zzame), this.zzajb, this.zzalh, this.zzalZ, this.zzama, this.zzali, this.zzamb, this.zzamf, null);
        }
        
        public final Builder requestEmail() {
            this.zzame.add(GoogleSignInOptions.zzalW);
            return this;
        }
        
        public final Builder requestId() {
            this.zzame.add(GoogleSignInOptions.zzalX);
            return this;
        }
        
        public final Builder requestIdToken(final String s) {
            this.zzalh = true;
            this.zzali = this.zzbR(s);
            return this;
        }
        
        public final Builder requestProfile() {
            this.zzame.add(GoogleSignInOptions.zzalV);
            return this;
        }
        
        public final Builder requestScopes(final Scope scope, final Scope... a) {
            this.zzame.add(scope);
            this.zzame.addAll(Arrays.asList(a));
            return this;
        }
        
        public final Builder requestServerAuthCode(final String s) {
            return this.requestServerAuthCode(s, false);
        }
        
        public final Builder requestServerAuthCode(final String s, final boolean zzama) {
            this.zzalZ = true;
            this.zzali = this.zzbR(s);
            this.zzama = zzama;
            return this;
        }
        
        public final Builder setAccountName(final String s) {
            this.zzajb = new Account(zzbo.zzcF(s), "com.google");
            return this;
        }
        
        public final Builder setHostedDomain(final String s) {
            this.zzamb = zzbo.zzcF(s);
            return this;
        }
    }
}
