package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList<E> implements List<E>, RandomAccess {
    private final List<E> immutableList;

    private ImmutableList(List<E> list) {
        this.immutableList = Collections.unmodifiableList(list);
    }

    @NonNull
    public static <E> ImmutableList<E> from(@NonNull List<E> list) {
        return new ImmutableList<>(list);
    }

    @NonNull
    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    public void add(int i, @NonNull E e) {
        this.immutableList.add(i, e);
    }

    public boolean add(@NonNull E e) {
        return this.immutableList.add(e);
    }

    public boolean addAll(int i, @NonNull Collection<? extends E> collection) {
        return this.immutableList.addAll(i, collection);
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.immutableList.addAll(collection);
    }

    public void clear() {
        this.immutableList.clear();
    }

    public boolean contains(@Nullable Object obj) {
        return this.immutableList.contains(obj);
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.immutableList.containsAll(collection);
    }

    public boolean equals(@Nullable Object obj) {
        return this.immutableList.equals(obj);
    }

    @NonNull
    public E get(int i) {
        return this.immutableList.get(i);
    }

    public int hashCode() {
        return this.immutableList.hashCode();
    }

    public int indexOf(@Nullable Object obj) {
        return this.immutableList.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.immutableList.isEmpty();
    }

    @NonNull
    public Iterator<E> iterator() {
        return this.immutableList.iterator();
    }

    public int lastIndexOf(@Nullable Object obj) {
        return this.immutableList.lastIndexOf(obj);
    }

    @NonNull
    public ListIterator<E> listIterator() {
        return this.immutableList.listIterator();
    }

    @NonNull
    public ListIterator<E> listIterator(int i) {
        return this.immutableList.listIterator(i);
    }

    public E remove(int i) {
        return this.immutableList.remove(i);
    }

    public boolean remove(@Nullable Object obj) {
        return this.immutableList.remove(obj);
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.immutableList.removeAll(collection);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.immutableList.retainAll(collection);
    }

    @NonNull
    public E set(int i, @NonNull E e) {
        return this.immutableList.set(i, e);
    }

    public int size() {
        return this.immutableList.size();
    }

    @NonNull
    public List<E> subList(int i, int i2) {
        return this.immutableList.subList(i, i2);
    }

    @Nullable
    public Object[] toArray() {
        return this.immutableList.toArray();
    }

    public <T> T[] toArray(@Nullable T[] tArr) {
        return this.immutableList.toArray(tArr);
    }
}
