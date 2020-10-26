// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.logging.Level;
import com.google.common.collect.Sets;
import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.Arrays;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import com.google.common.base.MoreObjects;
import com.google.common.annotations.VisibleForTesting;
import java.util.EnumMap;
import java.util.Collections;
import com.google.common.collect.Maps;
import java.util.List;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.util.logging.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.ArrayList;
import javax.annotation.concurrent.ThreadSafe;
import com.google.common.annotations.Beta;

@Beta
@ThreadSafe
public class CycleDetectingLockFactory
{
    private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks;
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> lockGraphNodesPerType;
    private static final Logger logger;
    final Policy policy;
    
    static {
        lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
        logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        acquiredLocks = new ThreadLocal<ArrayList<LockGraphNode>>() {
            @Override
            protected ArrayList<LockGraphNode> initialValue() {
                return Lists.newArrayListWithCapacity(3);
            }
        };
    }
    
    private CycleDetectingLockFactory(final Policy policy) {
        this.policy = Preconditions.checkNotNull(policy);
    }
    
    private void aboutToAcquire(final CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.isAcquiredByCurrentThread()) {
            final ArrayList<LockGraphNode> list = CycleDetectingLockFactory.acquiredLocks.get();
            final LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
            lockGraphNode.checkAcquiredLocks(this.policy, list);
            list.add(lockGraphNode);
        }
    }
    
    @VisibleForTesting
    static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(final Class<E> clazz) {
        final EnumMap<E, Object> enumMap = Maps.newEnumMap(clazz);
        final E[] array = clazz.getEnumConstants();
        final int length = array.length;
        final ArrayList<Object> arrayListWithCapacity = Lists.newArrayListWithCapacity(length);
        for (int length2 = array.length, i = 0; i < length2; ++i) {
            final Enum<E> key = array[i];
            final LockGraphNode lockGraphNode = new LockGraphNode(getLockName(key));
            arrayListWithCapacity.add(lockGraphNode);
            enumMap.put((E)key, lockGraphNode);
        }
        for (int j = 1; j < length; ++j) {
            arrayListWithCapacity.get(j).checkAcquiredLocks(Policies.THROW, arrayListWithCapacity.subList(0, j));
        }
        for (int k = 0; k < length - 1; ++k) {
            arrayListWithCapacity.get(k).checkAcquiredLocks(Policies.DISABLED, arrayListWithCapacity.subList(k + 1, length));
        }
        return Collections.unmodifiableMap((Map<? extends E, ? extends LockGraphNode>)enumMap);
    }
    
    private static String getLockName(final Enum<?> enum1) {
        final String value = String.valueOf(String.valueOf(enum1.getDeclaringClass().getSimpleName()));
        final String value2 = String.valueOf(String.valueOf(enum1.name()));
        return new StringBuilder(value.length() + 1 + value2.length()).append(value).append(".").append(value2).toString();
    }
    
    private static Map<? extends Enum, LockGraphNode> getOrCreateNodes(final Class<? extends Enum> clazz) {
        final Map<? extends Enum, LockGraphNode> map = CycleDetectingLockFactory.lockGraphNodesPerType.get(clazz);
        if (map != null) {
            return map;
        }
        final Map<Enum, LockGraphNode> nodes = createNodes(clazz);
        return MoreObjects.firstNonNull(CycleDetectingLockFactory.lockGraphNodesPerType.putIfAbsent(clazz, nodes), nodes);
    }
    
    private void lockStateChanged(final CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.isAcquiredByCurrentThread()) {
            final ArrayList<LockGraphNode> list = CycleDetectingLockFactory.acquiredLocks.get();
            final LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
            for (int i = list.size() - 1; i >= 0; --i) {
                if (list.get(i) == lockGraphNode) {
                    list.remove(i);
                    break;
                }
            }
        }
    }
    
    public static CycleDetectingLockFactory newInstance(final Policy policy) {
        return new CycleDetectingLockFactory(policy);
    }
    
    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(final Class<E> clazz, final Policy policy) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(policy);
        return new WithExplicitOrdering<E>(policy, (Map<E, LockGraphNode>)getOrCreateNodes(clazz));
    }
    
    public ReentrantLock newReentrantLock(final String s) {
        return this.newReentrantLock(s, false);
    }
    
    public ReentrantLock newReentrantLock(final String s, final boolean fair) {
        if (this.policy == Policies.DISABLED) {
            return new ReentrantLock(fair);
        }
        return new CycleDetectingReentrantLock(new LockGraphNode(s), fair);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(final String s) {
        return this.newReentrantReadWriteLock(s, false);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(final String s, final boolean fair) {
        if (this.policy == Policies.DISABLED) {
            return new ReentrantReadWriteLock(fair);
        }
        return new CycleDetectingReentrantReadWriteLock(new LockGraphNode(s), fair);
    }
    
    private interface CycleDetectingLock
    {
        LockGraphNode getLockGraphNode();
        
        boolean isAcquiredByCurrentThread();
    }
    
    final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock
    {
        private final LockGraphNode lockGraphNode;
        
        private CycleDetectingReentrantLock(final LockGraphNode lockGraphNode, final boolean fair) {
            super(fair);
            this.lockGraphNode = Preconditions.checkNotNull(lockGraphNode);
        }
        
        @Override
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }
        
        @Override
        public boolean isAcquiredByCurrentThread() {
            return this.isHeldByCurrentThread();
        }
        
        @Override
        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this);
            try {
                super.lock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this);
            }
        }
        
        @Override
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this);
            try {
                super.lockInterruptibly();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this);
            }
        }
        
        @Override
        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this);
            try {
                return super.tryLock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this);
            }
        }
        
        @Override
        public boolean tryLock(final long timeout, final TimeUnit unit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this);
            try {
                return super.tryLock(timeout, unit);
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this);
            }
        }
        
        @Override
        public void unlock() {
            try {
                super.unlock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this);
            }
        }
    }
    
    private class CycleDetectingReentrantReadLock extends ReadLock
    {
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        
        CycleDetectingReentrantReadLock(final CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }
        
        @Override
        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this.readWriteLock);
            try {
                super.lock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
        
        @Override
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this.readWriteLock);
            try {
                super.lockInterruptibly();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
        
        @Override
        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this.readWriteLock);
            try {
                return super.tryLock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
        
        @Override
        public boolean tryLock(final long timeout, final TimeUnit unit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this.readWriteLock);
            try {
                return super.tryLock(timeout, unit);
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
        
        @Override
        public void unlock() {
            try {
                super.unlock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
    }
    
    final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock
    {
        private final LockGraphNode lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;
        
        private CycleDetectingReentrantReadWriteLock(final LockGraphNode lockGraphNode, final boolean fair) {
            super(fair);
            this.readLock = new CycleDetectingReentrantReadLock(this);
            this.writeLock = new CycleDetectingReentrantWriteLock(this);
            this.lockGraphNode = Preconditions.checkNotNull(lockGraphNode);
        }
        
        @Override
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }
        
        @Override
        public boolean isAcquiredByCurrentThread() {
            return this.isWriteLockedByCurrentThread() || this.getReadHoldCount() > 0;
        }
        
        @Override
        public ReadLock readLock() {
            return this.readLock;
        }
        
        @Override
        public WriteLock writeLock() {
            return this.writeLock;
        }
    }
    
    private class CycleDetectingReentrantWriteLock extends WriteLock
    {
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        
        CycleDetectingReentrantWriteLock(final CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }
        
        @Override
        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this.readWriteLock);
            try {
                super.lock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
        
        @Override
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this.readWriteLock);
            try {
                super.lockInterruptibly();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
        
        @Override
        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this.readWriteLock);
            try {
                return super.tryLock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
        
        @Override
        public boolean tryLock(final long timeout, final TimeUnit unit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire((CycleDetectingLock)this.readWriteLock);
            try {
                return super.tryLock(timeout, unit);
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
        
        @Override
        public void unlock() {
            try {
                super.unlock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged((CycleDetectingLock)this.readWriteLock);
            }
        }
    }
    
    private static class ExampleStackTrace extends IllegalStateException
    {
        static final StackTraceElement[] EMPTY_STACK_TRACE;
        static Set<String> EXCLUDED_CLASS_NAMES;
        
        static {
            EMPTY_STACK_TRACE = new StackTraceElement[0];
            ExampleStackTrace.EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
        }
        
        ExampleStackTrace(final LockGraphNode lockGraphNode, final LockGraphNode lockGraphNode2) {
            final String value = String.valueOf(String.valueOf(lockGraphNode.getLockName()));
            final String value2 = String.valueOf(String.valueOf(lockGraphNode2.getLockName()));
            super(new StringBuilder(value.length() + 4 + value2.length()).append(value).append(" -> ").append(value2).toString());
            final StackTraceElement[] stackTrace = this.getStackTrace();
            for (int i = 0, length = stackTrace.length; i < length; ++i) {
                if (WithExplicitOrdering.class.getName().equals(stackTrace[i].getClassName())) {
                    this.setStackTrace(ExampleStackTrace.EMPTY_STACK_TRACE);
                    break;
                }
                if (!ExampleStackTrace.EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                    this.setStackTrace(Arrays.copyOfRange(stackTrace, i, length));
                    return;
                }
            }
        }
    }
    
    private static class LockGraphNode
    {
        final Map<LockGraphNode, ExampleStackTrace> allowedPriorLocks;
        final Map<LockGraphNode, PotentialDeadlockException> disallowedPriorLocks;
        final String lockName;
        
        LockGraphNode(final String s) {
            this.allowedPriorLocks = (Map<LockGraphNode, ExampleStackTrace>)new MapMaker().weakKeys().makeMap();
            this.disallowedPriorLocks = (Map<LockGraphNode, PotentialDeadlockException>)new MapMaker().weakKeys().makeMap();
            this.lockName = Preconditions.checkNotNull(s);
        }
        
        @Nullable
        private ExampleStackTrace findPathTo(final LockGraphNode lockGraphNode, final Set<LockGraphNode> set) {
            ExampleStackTrace exampleStackTrace;
            if (!set.add(this)) {
                exampleStackTrace = null;
            }
            else if ((exampleStackTrace = this.allowedPriorLocks.get(lockGraphNode)) == null) {
                for (final Map.Entry<LockGraphNode, ExampleStackTrace> entry : this.allowedPriorLocks.entrySet()) {
                    final LockGraphNode lockGraphNode2 = entry.getKey();
                    final ExampleStackTrace pathTo = lockGraphNode2.findPathTo(lockGraphNode, set);
                    if (pathTo != null) {
                        final ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(lockGraphNode2, this);
                        exampleStackTrace2.setStackTrace(entry.getValue().getStackTrace());
                        exampleStackTrace2.initCause(pathTo);
                        return exampleStackTrace2;
                    }
                }
                return null;
            }
            return exampleStackTrace;
        }
        
        void checkAcquiredLock(final Policy policy, final LockGraphNode lockGraphNode) {
            final boolean b = this != lockGraphNode;
            final String value = String.valueOf(lockGraphNode.getLockName());
            String concat;
            if (value.length() != 0) {
                concat = "Attempted to acquire multiple locks with the same rank ".concat(value);
            }
            else {
                concat = new String("Attempted to acquire multiple locks with the same rank ");
            }
            Preconditions.checkState(b, (Object)concat);
            if (this.allowedPriorLocks.containsKey(lockGraphNode)) {
                return;
            }
            final PotentialDeadlockException ex = this.disallowedPriorLocks.get(lockGraphNode);
            if (ex != null) {
                policy.handlePotentialDeadlock(new PotentialDeadlockException(lockGraphNode, this, ex.getConflictingStackTrace()));
                return;
            }
            final ExampleStackTrace pathTo = lockGraphNode.findPathTo(this, Sets.newIdentityHashSet());
            if (pathTo == null) {
                this.allowedPriorLocks.put(lockGraphNode, new ExampleStackTrace(lockGraphNode, this));
                return;
            }
            final PotentialDeadlockException ex2 = new PotentialDeadlockException(lockGraphNode, this, pathTo);
            this.disallowedPriorLocks.put(lockGraphNode, ex2);
            policy.handlePotentialDeadlock(ex2);
        }
        
        void checkAcquiredLocks(final Policy policy, final List<LockGraphNode> list) {
            for (int i = 0; i < list.size(); ++i) {
                this.checkAcquiredLock(policy, list.get(i));
            }
        }
        
        String getLockName() {
            return this.lockName;
        }
    }
    
    @Beta
    public enum Policies implements Policy
    {
        DISABLED {
            @Override
            public void handlePotentialDeadlock(final PotentialDeadlockException ex) {
            }
        }, 
        THROW {
            @Override
            public void handlePotentialDeadlock(final PotentialDeadlockException ex) {
                throw ex;
            }
        }, 
        WARN {
            @Override
            public void handlePotentialDeadlock(final PotentialDeadlockException thrown) {
                CycleDetectingLockFactory.logger.log(Level.SEVERE, "Detected potential deadlock", thrown);
            }
        };
    }
    
    @Beta
    @ThreadSafe
    public interface Policy
    {
        void handlePotentialDeadlock(final PotentialDeadlockException p0);
    }
    
    @Beta
    public static final class PotentialDeadlockException extends ExampleStackTrace
    {
        private final ExampleStackTrace conflictingStackTrace;
        
        private PotentialDeadlockException(final LockGraphNode lockGraphNode, final LockGraphNode lockGraphNode2, final ExampleStackTrace conflictingStackTrace) {
            super(lockGraphNode, lockGraphNode2);
            this.initCause(this.conflictingStackTrace = conflictingStackTrace);
        }
        
        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }
        
        @Override
        public String getMessage() {
            final StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable t = this.conflictingStackTrace; t != null; t = t.getCause()) {
                sb.append(", ").append(t.getMessage());
            }
            return sb.toString();
        }
    }
    
    @Beta
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory
    {
        private final Map<E, LockGraphNode> lockGraphNodes;
        
        @VisibleForTesting
        WithExplicitOrdering(final Policy policy, final Map<E, LockGraphNode> lockGraphNodes) {
            super(policy, null);
            this.lockGraphNodes = lockGraphNodes;
        }
        
        public ReentrantLock newReentrantLock(final E e) {
            return this.newReentrantLock(e, false);
        }
        
        public ReentrantLock newReentrantLock(final E e, final boolean fair) {
            if (this.policy == Policies.DISABLED) {
                return new ReentrantLock(fair);
            }
            return new CycleDetectingReentrantLock((LockGraphNode)this.lockGraphNodes.get(e), fair);
        }
        
        public ReentrantReadWriteLock newReentrantReadWriteLock(final E e) {
            return this.newReentrantReadWriteLock(e, false);
        }
        
        public ReentrantReadWriteLock newReentrantReadWriteLock(final E e, final boolean fair) {
            if (this.policy == Policies.DISABLED) {
                return new ReentrantReadWriteLock(fair);
            }
            return new CycleDetectingReentrantReadWriteLock((LockGraphNode)this.lockGraphNodes.get(e), fair);
        }
    }
}
