package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class RestrictedComponentContainer extends AbstractComponentContainer {
    private final Set<Class<?>> allowedDirectInterfaces;
    private final Set<Class<?>> allowedProviderInterfaces;
    private final Set<Class<?>> allowedPublishedEvents;
    private final Set<Class<?>> allowedSetDirectInterfaces;
    private final Set<Class<?>> allowedSetProviderInterfaces;
    private final ComponentContainer delegateContainer;

    private static class RestrictedPublisher implements Publisher {
        private final Set<Class<?>> allowedPublishedEvents;
        private final Publisher delegate;

        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher) {
            this.allowedPublishedEvents = set;
            this.delegate = publisher;
        }

        public void publish(Event<?> event) {
            if (this.allowedPublishedEvents.contains(event.getType())) {
                this.delegate.publish(event);
            } else {
                throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", new Object[]{event}));
            }
        }
    }

    RestrictedComponentContainer(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Dependency next : component.getDependencies()) {
            if (next.isDirectInjection()) {
                boolean isSet = next.isSet();
                Class<?> cls = next.getInterface();
                if (isSet) {
                    hashSet3.add(cls);
                } else {
                    hashSet.add(cls);
                }
            } else {
                boolean isSet2 = next.isSet();
                Class<?> cls2 = next.getInterface();
                if (isSet2) {
                    hashSet4.add(cls2);
                } else {
                    hashSet2.add(cls2);
                }
            }
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet);
        this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
        this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet3);
        this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet4);
        this.allowedPublishedEvents = component.getPublishedEvents();
        this.delegateContainer = componentContainer;
    }

    public <T> T get(Class<T> cls) {
        if (this.allowedDirectInterfaces.contains(cls)) {
            T t = this.delegateContainer.get(cls);
            return !cls.equals(Publisher.class) ? t : new RestrictedPublisher(this.allowedPublishedEvents, (Publisher) t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        if (this.allowedProviderInterfaces.contains(cls)) {
            return this.delegateContainer.getProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public <T> Set<T> setOf(Class<T> cls) {
        if (this.allowedSetDirectInterfaces.contains(cls)) {
            return this.delegateContainer.setOf(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        if (this.allowedSetProviderInterfaces.contains(cls)) {
            return this.delegateContainer.setOfProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }
}
