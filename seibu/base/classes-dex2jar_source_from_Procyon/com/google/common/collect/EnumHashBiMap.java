// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.Set;
import com.google.common.base.Preconditions;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.EnumMap;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V>
{
    @GwtIncompatible("only needed in emulated source.")
    private static final long serialVersionUID = 0L;
    private transient Class<K> keyType;
    
    private EnumHashBiMap(final Class<K> clazz) {
        super((Map<Object, Object>)WellBehavedMap.wrap((Map<K, V>)new EnumMap<K, Object>(clazz)), Maps.newHashMapWithExpectedSize(clazz.getEnumConstants().length));
        this.keyType = clazz;
    }
    
    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(final Class<K> clazz) {
        return new EnumHashBiMap<K, V>(clazz);
    }
    
    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(final Map<K, ? extends V> map) {
        final EnumHashBiMap<K, V> create = (EnumHashBiMap<K, V>)create((Class<K>)EnumBiMap.inferKeyType((Map<K, ?>)map));
        create.putAll((Map)map);
        return create;
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class<K>)objectInputStream.readObject();
        this.setDelegates(WellBehavedMap.wrap(new EnumMap<K, V>(this.keyType)), new HashMap<V, K>(this.keyType.getEnumConstants().length * 3 / 2));
        Serialization.populateMap((Map<Object, Object>)this, objectInputStream);
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        Serialization.writeMap((Map<Object, Object>)this, objectOutputStream);
    }
    
    @Override
    K checkKey(final K k) {
        return Preconditions.checkNotNull(k);
    }
    
    @Override
    public V forcePut(final K k, @Nullable final V v) {
        return super.forcePut(k, v);
    }
    
    public Class<K> keyType() {
        return this.keyType;
    }
    
    @Override
    public V put(final K k, @Nullable final V v) {
        return super.put(k, v);
    }
}
