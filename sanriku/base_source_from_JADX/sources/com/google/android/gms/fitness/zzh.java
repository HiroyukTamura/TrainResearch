package com.google.android.gms.fitness;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class zzh {
    public static Set<Scope> zza(Collection<Scope> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (Scope next : collection) {
            Scope scope = next.equals(new Scope(Scopes.FITNESS_ACTIVITY_READ)) ? new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE) : next.equals(new Scope(Scopes.FITNESS_LOCATION_READ)) ? new Scope(Scopes.FITNESS_LOCATION_READ_WRITE) : next.equals(new Scope(Scopes.FITNESS_BODY_READ)) ? new Scope(Scopes.FITNESS_BODY_READ_WRITE) : next.equals(new Scope(Scopes.FITNESS_NUTRITION_READ)) ? new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE) : next.equals(new Scope(Scopes.FITNESS_BLOOD_PRESSURE_READ)) ? new Scope(Scopes.FITNESS_BLOOD_PRESSURE_READ_WRITE) : next.equals(new Scope(Scopes.FITNESS_BLOOD_GLUCOSE_READ)) ? new Scope(Scopes.FITNESS_BLOOD_GLUCOSE_READ_WRITE) : next.equals(new Scope(Scopes.FITNESS_OXYGEN_SATURATION_READ)) ? new Scope(Scopes.FITNESS_OXYGEN_SATURATION_READ_WRITE) : next.equals(new Scope(Scopes.FITNESS_BODY_TEMPERATURE_READ)) ? new Scope(Scopes.FITNESS_BODY_TEMPERATURE_READ_WRITE) : next.equals(new Scope(Scopes.FITNESS_REPRODUCTIVE_HEALTH_READ)) ? new Scope(Scopes.FITNESS_REPRODUCTIVE_HEALTH_READ_WRITE) : next;
            if (scope.equals(next) || !collection.contains(scope)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }
}
