// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.Collections;
import java.util.ArrayList;
import javax.annotation.concurrent.GuardedBy;
import java.util.List;
import com.google.common.annotations.Beta;

@Beta
public abstract class AbstractService implements Service
{
    private static final ListenerCallQueue.Callback<Listener> RUNNING_CALLBACK;
    private static final ListenerCallQueue.Callback<Listener> STARTING_CALLBACK;
    private static final ListenerCallQueue.Callback<Listener> STOPPING_FROM_RUNNING_CALLBACK;
    private static final ListenerCallQueue.Callback<Listener> STOPPING_FROM_STARTING_CALLBACK;
    private static final ListenerCallQueue.Callback<Listener> TERMINATED_FROM_NEW_CALLBACK;
    private static final ListenerCallQueue.Callback<Listener> TERMINATED_FROM_RUNNING_CALLBACK;
    private static final ListenerCallQueue.Callback<Listener> TERMINATED_FROM_STOPPING_CALLBACK;
    private final Monitor.Guard hasReachedRunning;
    private final Monitor.Guard isStartable;
    private final Monitor.Guard isStoppable;
    private final Monitor.Guard isStopped;
    @GuardedBy("monitor")
    private final List<ListenerCallQueue<Listener>> listeners;
    private final Monitor monitor;
    @GuardedBy("monitor")
    private volatile StateSnapshot snapshot;
    
    static {
        STARTING_CALLBACK = new ListenerCallQueue.Callback<Listener>("starting()") {
            void call(final Listener listener) {
                listener.starting();
            }
        };
        RUNNING_CALLBACK = new ListenerCallQueue.Callback<Listener>("running()") {
            void call(final Listener listener) {
                listener.running();
            }
        };
        STOPPING_FROM_STARTING_CALLBACK = stoppingCallback(State.STARTING);
        STOPPING_FROM_RUNNING_CALLBACK = stoppingCallback(State.RUNNING);
        TERMINATED_FROM_NEW_CALLBACK = terminatedCallback(State.NEW);
        TERMINATED_FROM_RUNNING_CALLBACK = terminatedCallback(State.RUNNING);
        TERMINATED_FROM_STOPPING_CALLBACK = terminatedCallback(State.STOPPING);
    }
    
    protected AbstractService() {
        this.monitor = new Monitor();
        this.isStartable = new Monitor.Guard(this.monitor) {
            @Override
            public boolean isSatisfied() {
                return AbstractService.this.state() == State.NEW;
            }
        };
        this.isStoppable = new Monitor.Guard(this.monitor) {
            @Override
            public boolean isSatisfied() {
                return AbstractService.this.state().compareTo(State.RUNNING) <= 0;
            }
        };
        this.hasReachedRunning = new Monitor.Guard(this.monitor) {
            @Override
            public boolean isSatisfied() {
                return AbstractService.this.state().compareTo(State.RUNNING) >= 0;
            }
        };
        this.isStopped = new Monitor.Guard(this.monitor) {
            @Override
            public boolean isSatisfied() {
                return AbstractService.this.state().isTerminal();
            }
        };
        this.listeners = Collections.synchronizedList(new ArrayList<ListenerCallQueue<Listener>>());
        this.snapshot = new StateSnapshot(State.NEW);
    }
    
    @GuardedBy("monitor")
    private void checkCurrentState(final State state) {
        final State state2 = this.state();
        if (state2 == state) {
            return;
        }
        if (state2 == State.FAILED) {
            final String value = String.valueOf(String.valueOf(state));
            throw new IllegalStateException(new StringBuilder(value.length() + 55).append("Expected the service to be ").append(value).append(", but the service has FAILED").toString(), this.failureCause());
        }
        final String value2 = String.valueOf(String.valueOf(state));
        final String value3 = String.valueOf(String.valueOf(state2));
        throw new IllegalStateException(new StringBuilder(value2.length() + 37 + value3.length()).append("Expected the service to be ").append(value2).append(", but was ").append(value3).toString());
    }
    
    private void executeListeners() {
        if (!this.monitor.isOccupiedByCurrentThread()) {
            for (int i = 0; i < this.listeners.size(); ++i) {
                this.listeners.get(i).execute();
            }
        }
    }
    
    @GuardedBy("monitor")
    private void failed(final State obj, final Throwable obj2) {
        final String value = String.valueOf(String.valueOf(obj));
        final String value2 = String.valueOf(String.valueOf(obj2));
        ((ListenerCallQueue.Callback<Listener>)new ListenerCallQueue.Callback<Listener>(new StringBuilder(value.length() + 27 + value2.length()).append("failed({from = ").append(value).append(", cause = ").append(value2).append("})").toString()) {
            void call(final Listener listener) {
                listener.failed(obj, obj2);
            }
        }).enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    private void running() {
        AbstractService.RUNNING_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    private void starting() {
        AbstractService.STARTING_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    private void stopping(final State state) {
        if (state == State.STARTING) {
            AbstractService.STOPPING_FROM_STARTING_CALLBACK.enqueueOn(this.listeners);
            return;
        }
        if (state == State.RUNNING) {
            AbstractService.STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
            return;
        }
        throw new AssertionError();
    }
    
    private static ListenerCallQueue.Callback<Listener> stoppingCallback(final State obj) {
        final String value = String.valueOf(String.valueOf(obj));
        return new ListenerCallQueue.Callback<Listener>(new StringBuilder(value.length() + 19).append("stopping({from = ").append(value).append("})").toString()) {
            void call(final Listener listener) {
                listener.stopping(obj);
            }
        };
    }
    
    @GuardedBy("monitor")
    private void terminated(final State state) {
        switch (state) {
            default: {
                throw new AssertionError();
            }
            case NEW: {
                AbstractService.TERMINATED_FROM_NEW_CALLBACK.enqueueOn(this.listeners);
            }
            case RUNNING: {
                AbstractService.TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
            }
            case STOPPING: {
                AbstractService.TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(this.listeners);
            }
        }
    }
    
    private static ListenerCallQueue.Callback<Listener> terminatedCallback(final State obj) {
        final String value = String.valueOf(String.valueOf(obj));
        return new ListenerCallQueue.Callback<Listener>(new StringBuilder(value.length() + 21).append("terminated({from = ").append(value).append("})").toString()) {
            void call(final Listener listener) {
                listener.terminated(obj);
            }
        };
    }
    
    @Override
    public final void addListener(final Listener listener, final Executor executor) {
        Preconditions.checkNotNull(listener, (Object)"listener");
        Preconditions.checkNotNull(executor, (Object)"executor");
        this.monitor.enter();
        try {
            if (!this.state().isTerminal()) {
                this.listeners.add(new ListenerCallQueue<Listener>(listener, executor));
            }
        }
        finally {
            this.monitor.leave();
        }
    }
    
    @Override
    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        try {
            this.checkCurrentState(State.RUNNING);
        }
        finally {
            this.monitor.leave();
        }
    }
    
    @Override
    public final void awaitRunning(final long n, final TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, n, timeUnit)) {
            try {
                this.checkCurrentState(State.RUNNING);
                return;
            }
            finally {
                this.monitor.leave();
            }
        }
        final String value = String.valueOf(String.valueOf(this));
        final String value2 = String.valueOf(String.valueOf(this.state()));
        throw new TimeoutException(new StringBuilder(value.length() + 66 + value2.length()).append("Timed out waiting for ").append(value).append(" to reach the RUNNING state. ").append("Current state: ").append(value2).toString());
    }
    
    @Override
    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        try {
            this.checkCurrentState(State.TERMINATED);
        }
        finally {
            this.monitor.leave();
        }
    }
    
    @Override
    public final void awaitTerminated(final long n, final TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, n, timeUnit)) {
            try {
                this.checkCurrentState(State.TERMINATED);
                return;
            }
            finally {
                this.monitor.leave();
            }
        }
        final String value = String.valueOf(String.valueOf(this));
        final String value2 = String.valueOf(String.valueOf(this.state()));
        throw new TimeoutException(new StringBuilder(value.length() + 65 + value2.length()).append("Timed out waiting for ").append(value).append(" to reach a terminal state. ").append("Current state: ").append(value2).toString());
    }
    
    protected abstract void doStart();
    
    protected abstract void doStop();
    
    @Override
    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }
    
    @Override
    public final boolean isRunning() {
        return this.state() == State.RUNNING;
    }
    
    protected final void notifyFailed(final Throwable cause) {
    Label_0187:
        while (true) {
            Preconditions.checkNotNull(cause);
            this.monitor.enter();
            State state = null;
            Label_0165: {
                Label_0121: {
                    while (true) {
                        Label_0199: {
                            try {
                                state = this.state();
                                switch (state) {
                                    case NEW:
                                    case TERMINATED: {
                                        break Label_0121;
                                    }
                                    case STARTING:
                                    case RUNNING:
                                    case STOPPING: {
                                        break Label_0165;
                                    }
                                    case FAILED: {
                                        break Label_0187;
                                    }
                                    default: {
                                        break Label_0199;
                                    }
                                }
                                final String value = String.valueOf(String.valueOf(state));
                                throw new AssertionError((Object)new StringBuilder(value.length() + 18).append("Unexpected state: ").append(value).toString());
                            }
                            finally {
                                this.monitor.leave();
                                this.executeListeners();
                            }
                            break Label_0121;
                        }
                        continue;
                    }
                }
                final String value2 = String.valueOf(String.valueOf(state));
                throw new IllegalStateException(new StringBuilder(value2.length() + 22).append("Failed while in state:").append(value2).toString(), cause);
            }
            this.snapshot = new StateSnapshot(State.FAILED, false, cause);
            this.failed(state, cause);
            break;
        }
        this.monitor.leave();
        this.executeListeners();
    }
    
    protected final void notifyStarted() {
        this.monitor.enter();
        try {
            if (this.snapshot.state != State.STARTING) {
                final String value = String.valueOf(String.valueOf(this.snapshot.state));
                final IllegalStateException ex = new IllegalStateException(new StringBuilder(value.length() + 43).append("Cannot notifyStarted() when the service is ").append(value).toString());
                this.notifyFailed(ex);
                throw ex;
            }
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
        if (this.snapshot.shutdownWhenStartupFinishes) {
            this.snapshot = new StateSnapshot(State.STOPPING);
            this.doStop();
        }
        else {
            this.snapshot = new StateSnapshot(State.RUNNING);
            this.running();
        }
        this.monitor.leave();
        this.executeListeners();
    }
    
    protected final void notifyStopped() {
        this.monitor.enter();
        try {
            final State state = this.snapshot.state;
            if (state != State.STOPPING && state != State.RUNNING) {
                final String value = String.valueOf(String.valueOf(state));
                final IllegalStateException ex = new IllegalStateException(new StringBuilder(value.length() + 43).append("Cannot notifyStopped() when the service is ").append(value).toString());
                this.notifyFailed(ex);
                throw ex;
            }
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
        this.snapshot = new StateSnapshot(State.TERMINATED);
        final State state2;
        this.terminated(state2);
        this.monitor.leave();
        this.executeListeners();
    }
    
    @Override
    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable)) {
            try {
                this.snapshot = new StateSnapshot(State.STARTING);
                this.starting();
                this.doStart();
                return this;
            }
            catch (Throwable t) {
                this.notifyFailed(t);
                return this;
            }
            finally {
                this.monitor.leave();
                this.executeListeners();
            }
        }
        final String value = String.valueOf(String.valueOf(this));
        throw new IllegalStateException(new StringBuilder(value.length() + 33).append("Service ").append(value).append(" has already been started").toString());
    }
    
    @Override
    public final State state() {
        return this.snapshot.externalState();
    }
    
    @Override
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable)) {
            State state = null;
        Label_0228:
            while (true) {
                while (true) {
                    Label_0271: {
                        Label_0160: {
                            try {
                                state = this.state();
                                switch (state) {
                                    case NEW: {
                                        break Label_0160;
                                        break Label_0160;
                                    }
                                    case STARTING: {
                                        break Label_0160;
                                        break Label_0160;
                                    }
                                    case RUNNING: {}
                                    case STOPPING:
                                    case TERMINATED:
                                    case FAILED: {
                                        break Label_0228;
                                    }
                                    default: {
                                        break Label_0271;
                                    }
                                }
                                final String value = String.valueOf(String.valueOf(state));
                                throw new AssertionError((Object)new StringBuilder(value.length() + 18).append("Unexpected state: ").append(value).toString());
                            }
                            catch (Throwable t) {
                                try {
                                    this.notifyFailed(t);
                                    return this;
                                    this.snapshot = new StateSnapshot(State.TERMINATED);
                                    this.terminated(State.NEW);
                                    return this;
                                    this.snapshot = new StateSnapshot(State.STARTING, true, null);
                                    this.stopping(State.STARTING);
                                }
                                finally {
                                    this.monitor.leave();
                                    this.executeListeners();
                                }
                            }
                        }
                        this.snapshot = new StateSnapshot(State.STOPPING);
                        this.stopping(State.RUNNING);
                        this.doStop();
                        return this;
                    }
                    continue;
                }
            }
            final String value2 = String.valueOf(String.valueOf(state));
            throw new AssertionError((Object)new StringBuilder(value2.length() + 45).append("isStoppable is incorrectly implemented, saw: ").append(value2).toString());
        }
        return this;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.getClass().getSimpleName()));
        final String value2 = String.valueOf(String.valueOf(this.state()));
        return new StringBuilder(value.length() + 3 + value2.length()).append(value).append(" [").append(value2).append("]").toString();
    }
    
    @Immutable
    private static final class StateSnapshot
    {
        @Nullable
        final Throwable failure;
        final boolean shutdownWhenStartupFinishes;
        final State state;
        
        StateSnapshot(final State state) {
            this(state, false, null);
        }
        
        StateSnapshot(final State state, final boolean shutdownWhenStartupFinishes, @Nullable final Throwable failure) {
            Preconditions.checkArgument(!shutdownWhenStartupFinishes || state == State.STARTING, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            boolean b;
            if (failure != null) {
                b = true;
            }
            else {
                b = false;
            }
            boolean b2;
            if (state == State.FAILED) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            Preconditions.checkArgument(!(b ^ b2), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, failure);
            this.state = state;
            this.shutdownWhenStartupFinishes = shutdownWhenStartupFinishes;
            this.failure = failure;
        }
        
        State externalState() {
            if (this.shutdownWhenStartupFinishes && this.state == State.STARTING) {
                return State.STOPPING;
            }
            return this.state;
        }
        
        Throwable failureCause() {
            Preconditions.checkState(this.state == State.FAILED, "failureCause() is only valid if the service has failed, service is %s", this.state);
            return this.failure;
        }
    }
}
