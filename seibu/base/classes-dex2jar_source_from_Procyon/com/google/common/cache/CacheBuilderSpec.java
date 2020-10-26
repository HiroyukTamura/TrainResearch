// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Iterator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import com.google.common.base.Splitter;
import com.google.common.annotations.Beta;

@Beta
public final class CacheBuilderSpec
{
    private static final Splitter KEYS_SPLITTER;
    private static final Splitter KEY_VALUE_SPLITTER;
    private static final ImmutableMap<String, ValueParser> VALUE_PARSERS;
    @VisibleForTesting
    long accessExpirationDuration;
    @VisibleForTesting
    TimeUnit accessExpirationTimeUnit;
    @VisibleForTesting
    Integer concurrencyLevel;
    @VisibleForTesting
    Integer initialCapacity;
    @VisibleForTesting
    LocalCache.Strength keyStrength;
    @VisibleForTesting
    Long maximumSize;
    @VisibleForTesting
    Long maximumWeight;
    @VisibleForTesting
    Boolean recordStats;
    @VisibleForTesting
    long refreshDuration;
    @VisibleForTesting
    TimeUnit refreshTimeUnit;
    private final String specification;
    @VisibleForTesting
    LocalCache.Strength valueStrength;
    @VisibleForTesting
    long writeExpirationDuration;
    @VisibleForTesting
    TimeUnit writeExpirationTimeUnit;
    
    static {
        KEYS_SPLITTER = Splitter.on(',').trimResults();
        KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
        VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", (InitialCapacityParser)new MaximumSizeParser()).put("maximumWeight", (InitialCapacityParser)new MaximumWeightParser()).put("concurrencyLevel", (InitialCapacityParser)new ConcurrencyLevelParser()).put("weakKeys", (InitialCapacityParser)new KeyStrengthParser(LocalCache.Strength.WEAK)).put("softValues", (InitialCapacityParser)new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", (InitialCapacityParser)new ValueStrengthParser(LocalCache.Strength.WEAK)).put("recordStats", (InitialCapacityParser)new RecordStatsParser()).put("expireAfterAccess", (InitialCapacityParser)new AccessDurationParser()).put("expireAfterWrite", (InitialCapacityParser)new WriteDurationParser()).put("refreshAfterWrite", (InitialCapacityParser)new RefreshDurationParser()).put("refreshInterval", (InitialCapacityParser)new RefreshDurationParser()).build();
    }
    
    private CacheBuilderSpec(final String specification) {
        this.specification = specification;
    }
    
    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }
    
    @Nullable
    private static Long durationInNanos(final long duration, @Nullable final TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return timeUnit.toNanos(duration);
    }
    
    public static CacheBuilderSpec parse(String s) {
        final CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(s);
        if (!s.isEmpty()) {
            for (final String s2 : CacheBuilderSpec.KEYS_SPLITTER.split(s)) {
                final ImmutableList<Object> copy = ImmutableList.copyOf((Iterable<?>)CacheBuilderSpec.KEY_VALUE_SPLITTER.split(s2));
                Preconditions.checkArgument(!copy.isEmpty(), (Object)"blank key-value pair");
                Preconditions.checkArgument(copy.size() <= 2, "key-value pair %s with more than one equals sign", s2);
                final String s3 = copy.get(0);
                final ValueParser valueParser = CacheBuilderSpec.VALUE_PARSERS.get(s3);
                Preconditions.checkArgument(valueParser != null, "unknown key %s", s3);
                if (copy.size() == 1) {
                    s = null;
                }
                else {
                    s = (String)copy.get(1);
                }
                valueParser.parse(cacheBuilderSpec, s3, s);
            }
        }
        return cacheBuilderSpec;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (this != o) {
            if (!(o instanceof CacheBuilderSpec)) {
                return false;
            }
            final CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec)o;
            if (!Objects.equal(this.initialCapacity, cacheBuilderSpec.initialCapacity) || !Objects.equal(this.maximumSize, cacheBuilderSpec.maximumSize) || !Objects.equal(this.maximumWeight, cacheBuilderSpec.maximumWeight) || !Objects.equal(this.concurrencyLevel, cacheBuilderSpec.concurrencyLevel) || !Objects.equal(this.keyStrength, cacheBuilderSpec.keyStrength) || !Objects.equal(this.valueStrength, cacheBuilderSpec.valueStrength) || !Objects.equal(this.recordStats, cacheBuilderSpec.recordStats) || !Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(cacheBuilderSpec.writeExpirationDuration, cacheBuilderSpec.writeExpirationTimeUnit)) || !Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(cacheBuilderSpec.accessExpirationDuration, cacheBuilderSpec.accessExpirationTimeUnit)) || !Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(cacheBuilderSpec.refreshDuration, cacheBuilderSpec.refreshTimeUnit))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit));
    }
    
    CacheBuilder<Object, Object> toCacheBuilder() {
        final CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();
        if (this.initialCapacity != null) {
            builder.initialCapacity(this.initialCapacity);
        }
        if (this.maximumSize != null) {
            builder.maximumSize(this.maximumSize);
        }
        if (this.maximumWeight != null) {
            builder.maximumWeight(this.maximumWeight);
        }
        if (this.concurrencyLevel != null) {
            builder.concurrencyLevel(this.concurrencyLevel);
        }
        if (this.keyStrength != null) {
            switch (this.keyStrength) {
                default: {
                    throw new AssertionError();
                }
                case WEAK: {
                    builder.weakKeys();
                    break;
                }
            }
        }
        if (this.valueStrength != null) {
            switch (this.valueStrength) {
                default: {
                    throw new AssertionError();
                }
                case SOFT: {
                    builder.softValues();
                    break;
                }
                case WEAK: {
                    builder.weakValues();
                    break;
                }
            }
        }
        if (this.recordStats != null && this.recordStats) {
            builder.recordStats();
        }
        if (this.writeExpirationTimeUnit != null) {
            builder.expireAfterWrite(this.writeExpirationDuration, this.writeExpirationTimeUnit);
        }
        if (this.accessExpirationTimeUnit != null) {
            builder.expireAfterAccess(this.accessExpirationDuration, this.accessExpirationTimeUnit);
        }
        if (this.refreshTimeUnit != null) {
            builder.refreshAfterWrite(this.refreshDuration, this.refreshTimeUnit);
        }
        return builder;
    }
    
    public String toParsableString() {
        return this.specification;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.toParsableString()).toString();
    }
    
    static class AccessDurationParser extends DurationParser
    {
        @Override
        protected void parseDuration(final CacheBuilderSpec cacheBuilderSpec, final long accessExpirationDuration, final TimeUnit accessExpirationTimeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.accessExpirationTimeUnit == null, (Object)"expireAfterAccess already set");
            cacheBuilderSpec.accessExpirationDuration = accessExpirationDuration;
            cacheBuilderSpec.accessExpirationTimeUnit = accessExpirationTimeUnit;
        }
    }
    
    static class ConcurrencyLevelParser extends IntegerParser
    {
        @Override
        protected void parseInteger(final CacheBuilderSpec cacheBuilderSpec, final int i) {
            Preconditions.checkArgument(cacheBuilderSpec.concurrencyLevel == null, "concurrency level was already set to ", cacheBuilderSpec.concurrencyLevel);
            cacheBuilderSpec.concurrencyLevel = i;
        }
    }
    
    abstract static class DurationParser implements ValueParser
    {
        @Override
        public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, final String s2) {
        Label_0142_Outer:
            while (true) {
                Label_0131: {
                    if (s2 == null || s2.isEmpty()) {
                        break Label_0131;
                    }
                    final boolean b = true;
                    while (true) {
                        Label_0180: {
                            Label_0172: {
                                Label_0164: {
                                Label_0137:
                                    while (true) {
                                        Preconditions.checkArgument(b, "value of key %s omitted", s);
                                        while (true) {
                                            Label_0188: {
                                                try {
                                                    switch (s2.charAt(s2.length() - 1)) {
                                                        case 'd': {
                                                            break Label_0137;
                                                        }
                                                        case 'h': {
                                                            break Label_0164;
                                                        }
                                                        case 'm': {
                                                            break Label_0172;
                                                        }
                                                        case 's': {
                                                            break Label_0180;
                                                        }
                                                        default: {
                                                            break Label_0188;
                                                        }
                                                    }
                                                    throw new IllegalArgumentException(String.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", s, s2));
                                                }
                                                catch (NumberFormatException ex) {
                                                    throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", s, s2));
                                                }
                                                break Label_0131;
                                            }
                                            continue Label_0142_Outer;
                                        }
                                    }
                                    final TimeUnit timeUnit = TimeUnit.DAYS;
                                    this.parseDuration(cacheBuilderSpec, Long.parseLong(s2.substring(0, s2.length() - 1)), timeUnit);
                                    return;
                                }
                                final TimeUnit timeUnit = TimeUnit.HOURS;
                                continue;
                            }
                            final TimeUnit timeUnit = TimeUnit.MINUTES;
                            continue;
                        }
                        final TimeUnit timeUnit = TimeUnit.SECONDS;
                        continue;
                    }
                }
                final boolean b = false;
                continue;
            }
        }
        
        protected abstract void parseDuration(final CacheBuilderSpec p0, final long p1, final TimeUnit p2);
    }
    
    static class InitialCapacityParser extends IntegerParser
    {
        @Override
        protected void parseInteger(final CacheBuilderSpec cacheBuilderSpec, final int i) {
            Preconditions.checkArgument(cacheBuilderSpec.initialCapacity == null, "initial capacity was already set to ", cacheBuilderSpec.initialCapacity);
            cacheBuilderSpec.initialCapacity = i;
        }
    }
    
    abstract static class IntegerParser implements ValueParser
    {
        @Override
        public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, final String s2) {
            Label_0039: {
                if (s2 == null || s2.isEmpty()) {
                    break Label_0039;
                }
                boolean b = true;
                while (true) {
                    Preconditions.checkArgument(b, "value of key %s omitted", s);
                    try {
                        this.parseInteger(cacheBuilderSpec, Integer.parseInt(s2));
                        return;
                        b = false;
                    }
                    catch (NumberFormatException cause) {
                        throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", s, s2), cause);
                    }
                }
            }
        }
        
        protected abstract void parseInteger(final CacheBuilderSpec p0, final int p1);
    }
    
    static class KeyStrengthParser implements ValueParser
    {
        private final LocalCache.Strength strength;
        
        public KeyStrengthParser(final LocalCache.Strength strength) {
            this.strength = strength;
        }
        
        @Override
        public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, @Nullable final String s2) {
            Preconditions.checkArgument(s2 == null, "key %s does not take values", s);
            Preconditions.checkArgument(cacheBuilderSpec.keyStrength == null, "%s was already set to %s", s, cacheBuilderSpec.keyStrength);
            cacheBuilderSpec.keyStrength = this.strength;
        }
    }
    
    abstract static class LongParser implements ValueParser
    {
        @Override
        public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, final String s2) {
            Label_0039: {
                if (s2 == null || s2.isEmpty()) {
                    break Label_0039;
                }
                boolean b = true;
                while (true) {
                    Preconditions.checkArgument(b, "value of key %s omitted", s);
                    try {
                        this.parseLong(cacheBuilderSpec, Long.parseLong(s2));
                        return;
                        b = false;
                    }
                    catch (NumberFormatException cause) {
                        throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", s, s2), cause);
                    }
                }
            }
        }
        
        protected abstract void parseLong(final CacheBuilderSpec p0, final long p1);
    }
    
    static class MaximumSizeParser extends LongParser
    {
        @Override
        protected void parseLong(final CacheBuilderSpec cacheBuilderSpec, final long l) {
            Preconditions.checkArgument(cacheBuilderSpec.maximumSize == null, "maximum size was already set to ", cacheBuilderSpec.maximumSize);
            Preconditions.checkArgument(cacheBuilderSpec.maximumWeight == null, "maximum weight was already set to ", cacheBuilderSpec.maximumWeight);
            cacheBuilderSpec.maximumSize = l;
        }
    }
    
    static class MaximumWeightParser extends LongParser
    {
        @Override
        protected void parseLong(final CacheBuilderSpec cacheBuilderSpec, final long l) {
            Preconditions.checkArgument(cacheBuilderSpec.maximumWeight == null, "maximum weight was already set to ", cacheBuilderSpec.maximumWeight);
            Preconditions.checkArgument(cacheBuilderSpec.maximumSize == null, "maximum size was already set to ", cacheBuilderSpec.maximumSize);
            cacheBuilderSpec.maximumWeight = l;
        }
    }
    
    static class RecordStatsParser implements ValueParser
    {
        @Override
        public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, @Nullable final String s2) {
            final boolean b = false;
            Preconditions.checkArgument(s2 == null, (Object)"recordStats does not take values");
            boolean b2 = b;
            if (cacheBuilderSpec.recordStats == null) {
                b2 = true;
            }
            Preconditions.checkArgument(b2, (Object)"recordStats already set");
            cacheBuilderSpec.recordStats = true;
        }
    }
    
    static class RefreshDurationParser extends DurationParser
    {
        @Override
        protected void parseDuration(final CacheBuilderSpec cacheBuilderSpec, final long refreshDuration, final TimeUnit refreshTimeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.refreshTimeUnit == null, (Object)"refreshAfterWrite already set");
            cacheBuilderSpec.refreshDuration = refreshDuration;
            cacheBuilderSpec.refreshTimeUnit = refreshTimeUnit;
        }
    }
    
    private interface ValueParser
    {
        void parse(final CacheBuilderSpec p0, final String p1, @Nullable final String p2);
    }
    
    static class ValueStrengthParser implements ValueParser
    {
        private final LocalCache.Strength strength;
        
        public ValueStrengthParser(final LocalCache.Strength strength) {
            this.strength = strength;
        }
        
        @Override
        public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, @Nullable final String s2) {
            Preconditions.checkArgument(s2 == null, "key %s does not take values", s);
            Preconditions.checkArgument(cacheBuilderSpec.valueStrength == null, "%s was already set to %s", s, cacheBuilderSpec.valueStrength);
            cacheBuilderSpec.valueStrength = this.strength;
        }
    }
    
    static class WriteDurationParser extends DurationParser
    {
        @Override
        protected void parseDuration(final CacheBuilderSpec cacheBuilderSpec, final long writeExpirationDuration, final TimeUnit writeExpirationTimeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.writeExpirationTimeUnit == null, (Object)"expireAfterWrite already set");
            cacheBuilderSpec.writeExpirationDuration = writeExpirationDuration;
            cacheBuilderSpec.writeExpirationTimeUnit = writeExpirationTimeUnit;
        }
    }
}
