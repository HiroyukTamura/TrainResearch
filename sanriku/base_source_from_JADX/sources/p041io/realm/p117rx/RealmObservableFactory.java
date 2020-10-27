package p041io.realm.p117rx;

import java.util.IdentityHashMap;
import java.util.Map;
import p041io.realm.DynamicRealm;
import p041io.realm.DynamicRealmObject;
import p041io.realm.ObjectChangeSet;
import p041io.realm.OrderedCollectionChangeSet;
import p041io.realm.OrderedRealmCollectionChangeListener;
import p041io.realm.Realm;
import p041io.realm.RealmChangeListener;
import p041io.realm.RealmConfiguration;
import p041io.realm.RealmList;
import p041io.realm.RealmModel;
import p041io.realm.RealmObject;
import p041io.realm.RealmObjectChangeListener;
import p041io.realm.RealmQuery;
import p041io.realm.RealmResults;
import p078g.p079a.C1695a;
import p078g.p079a.C1701g;
import p078g.p079a.C1702h;
import p078g.p079a.C1703i;
import p078g.p079a.C1706l;
import p078g.p079a.C1707m;
import p078g.p079a.C1708n;
import p078g.p079a.C1714r;
import p078g.p079a.p098x.C1728c;

/* renamed from: io.realm.rx.RealmObservableFactory */
public class RealmObservableFactory implements RxObservableFactory {
    private static final C1695a BACK_PRESSURE_STRATEGY = C1695a.LATEST;
    /* access modifiers changed from: private */
    public ThreadLocal<StrongReferenceCounter<RealmList>> listRefs = new ThreadLocal<StrongReferenceCounter<RealmList>>() {
        /* access modifiers changed from: protected */
        public StrongReferenceCounter<RealmList> initialValue() {
            return new StrongReferenceCounter<>();
        }
    };
    /* access modifiers changed from: private */
    public ThreadLocal<StrongReferenceCounter<RealmModel>> objectRefs = new ThreadLocal<StrongReferenceCounter<RealmModel>>() {
        /* access modifiers changed from: protected */
        public StrongReferenceCounter<RealmModel> initialValue() {
            return new StrongReferenceCounter<>();
        }
    };
    /* access modifiers changed from: private */
    public ThreadLocal<StrongReferenceCounter<RealmResults>> resultsRefs = new ThreadLocal<StrongReferenceCounter<RealmResults>>() {
        /* access modifiers changed from: protected */
        public StrongReferenceCounter<RealmResults> initialValue() {
            return new StrongReferenceCounter<>();
        }
    };

    /* renamed from: io.realm.rx.RealmObservableFactory$StrongReferenceCounter */
    private static class StrongReferenceCounter<K> {
        private final Map<K, Integer> references;

        private StrongReferenceCounter() {
            this.references = new IdentityHashMap();
        }

        public void acquireReference(K k) {
            Integer num = this.references.get(k);
            if (num == null) {
                this.references.put(k, 1);
            } else {
                this.references.put(k, Integer.valueOf(num.intValue() + 1));
            }
        }

        public void releaseReference(K k) {
            Integer num = this.references.get(k);
            if (num == null) {
                throw new IllegalStateException("Object does not have any references: " + k);
            } else if (num.intValue() > 1) {
                this.references.put(k, Integer.valueOf(num.intValue() - 1));
            } else if (num.intValue() == 1) {
                this.references.remove(k);
            } else {
                throw new IllegalStateException("Invalid reference count: " + num);
            }
        }
    }

    public C1706l<ObjectChange<DynamicRealmObject>> changesetsFrom(DynamicRealm dynamicRealm, final DynamicRealmObject dynamicRealmObject) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return C1706l.m2396a(new C1708n<ObjectChange<DynamicRealmObject>>() {
            public void subscribe(final C1707m<ObjectChange<DynamicRealmObject>> mVar) throws Exception {
                final DynamicRealm instance = DynamicRealm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).acquireReference(dynamicRealmObject);
                final C20351 r1 = new RealmObjectChangeListener<DynamicRealmObject>() {
                    public void onChange(DynamicRealmObject dynamicRealmObject, ObjectChangeSet objectChangeSet) {
                        if (!mVar.mo27340a()) {
                            mVar.mo27373a(new ObjectChange(dynamicRealmObject, objectChangeSet));
                        }
                    }
                };
                dynamicRealmObject.addChangeListener(r1);
                mVar.mo27372a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        dynamicRealmObject.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).releaseReference(dynamicRealmObject);
                    }
                }));
                mVar.mo27373a(new ObjectChange(dynamicRealmObject, (ObjectChangeSet) null));
            }
        });
    }

    public <E> C1706l<CollectionChange<RealmList<E>>> changesetsFrom(DynamicRealm dynamicRealm, final RealmList<E> realmList) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return C1706l.m2396a(new C1708n<CollectionChange<RealmList<E>>>() {
            public void subscribe(final C1707m<CollectionChange<RealmList<E>>> mVar) throws Exception {
                final DynamicRealm instance = DynamicRealm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).acquireReference(realmList);
                final C20231 r1 = new OrderedRealmCollectionChangeListener<RealmList<E>>() {
                    public void onChange(RealmList<E> realmList, OrderedCollectionChangeSet orderedCollectionChangeSet) {
                        if (!mVar.mo27340a()) {
                            mVar.mo27373a(new CollectionChange(realmList, orderedCollectionChangeSet));
                        }
                    }
                };
                realmList.addChangeListener(r1);
                mVar.mo27372a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        realmList.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).releaseReference(realmList);
                    }
                }));
                mVar.mo27373a(new CollectionChange(realmList, (OrderedCollectionChangeSet) null));
            }
        });
    }

    public <E> C1706l<CollectionChange<RealmResults<E>>> changesetsFrom(DynamicRealm dynamicRealm, final RealmResults<E> realmResults) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return C1706l.m2396a(new C1708n<CollectionChange<RealmResults<E>>>() {
            public void subscribe(final C1707m<CollectionChange<RealmResults<E>>> mVar) throws Exception {
                final DynamicRealm instance = DynamicRealm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).acquireReference(realmResults);
                final C20551 r1 = new OrderedRealmCollectionChangeListener<RealmResults<E>>() {
                    public void onChange(RealmResults<E> realmResults, OrderedCollectionChangeSet orderedCollectionChangeSet) {
                        if (!mVar.mo27340a()) {
                            mVar.mo27373a(new CollectionChange(realmResults, orderedCollectionChangeSet));
                        }
                    }
                };
                realmResults.addChangeListener(r1);
                mVar.mo27372a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        realmResults.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).releaseReference(realmResults);
                    }
                }));
                mVar.mo27373a(new CollectionChange(realmResults, (OrderedCollectionChangeSet) null));
            }
        });
    }

    public <E> C1706l<CollectionChange<RealmList<E>>> changesetsFrom(Realm realm, final RealmList<E> realmList) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return C1706l.m2396a(new C1708n<CollectionChange<RealmList<E>>>() {
            public void subscribe(final C1707m<CollectionChange<RealmList<E>>> mVar) throws Exception {
                final Realm instance = Realm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).acquireReference(realmList);
                final C20171 r1 = new OrderedRealmCollectionChangeListener<RealmList<E>>() {
                    public void onChange(RealmList<E> realmList, OrderedCollectionChangeSet orderedCollectionChangeSet) {
                        if (!mVar.mo27340a()) {
                            mVar.mo27373a(new CollectionChange(realmList, orderedCollectionChangeSet));
                        }
                    }
                };
                realmList.addChangeListener(r1);
                mVar.mo27372a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        realmList.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).releaseReference(realmList);
                    }
                }));
                mVar.mo27373a(new CollectionChange(realmList, (OrderedCollectionChangeSet) null));
            }
        });
    }

    public <E extends RealmModel> C1706l<ObjectChange<E>> changesetsFrom(Realm realm, final E e) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return C1706l.m2396a(new C1708n<ObjectChange<E>>() {
            public void subscribe(final C1707m<ObjectChange<E>> mVar) throws Exception {
                final Realm instance = Realm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).acquireReference(e);
                final C20291 r1 = new RealmObjectChangeListener<E>() {
                    public void onChange(E e, ObjectChangeSet objectChangeSet) {
                        if (!mVar.mo27340a()) {
                            mVar.mo27373a(new ObjectChange(e, objectChangeSet));
                        }
                    }
                };
                RealmObject.addChangeListener(e, r1);
                mVar.mo27372a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        RealmObject.removeChangeListener(e, r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).releaseReference(e);
                    }
                }));
                mVar.mo27373a(new ObjectChange(e, (ObjectChangeSet) null));
            }
        });
    }

    public <E> C1706l<CollectionChange<RealmResults<E>>> changesetsFrom(Realm realm, final RealmResults<E> realmResults) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return C1706l.m2396a(new C1708n<CollectionChange<RealmResults<E>>>() {
            public void subscribe(final C1707m<CollectionChange<RealmResults<E>>> mVar) throws Exception {
                final Realm instance = Realm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).acquireReference(realmResults);
                final C20491 r1 = new OrderedRealmCollectionChangeListener<RealmResults<E>>() {
                    public void onChange(RealmResults<E> realmResults, OrderedCollectionChangeSet orderedCollectionChangeSet) {
                        if (!mVar.mo27340a()) {
                            mVar.mo27373a(new CollectionChange(realmResults, orderedCollectionChangeSet));
                        }
                    }
                };
                realmResults.addChangeListener(r1);
                mVar.mo27372a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        realmResults.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).releaseReference(realmResults);
                    }
                }));
                mVar.mo27373a(new CollectionChange(realmResults, (OrderedCollectionChangeSet) null));
            }
        });
    }

    public boolean equals(Object obj) {
        return obj instanceof RealmObservableFactory;
    }

    public C1701g<DynamicRealm> from(DynamicRealm dynamicRealm) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return C1701g.m2394a(new C1703i<DynamicRealm>() {
            public void subscribe(final C1702h<DynamicRealm> hVar) throws Exception {
                final DynamicRealm instance = DynamicRealm.getInstance(configuration);
                final C20431 r1 = new RealmChangeListener<DynamicRealm>() {
                    public void onChange(DynamicRealm dynamicRealm) {
                        if (!hVar.isCancelled()) {
                            hVar.mo27373a(dynamicRealm);
                        }
                    }
                };
                instance.addChangeListener(r1);
                hVar.mo27424a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        instance.removeChangeListener(r1);
                        instance.close();
                    }
                }));
                hVar.mo27373a(instance);
            }
        }, BACK_PRESSURE_STRATEGY);
    }

    public C1701g<DynamicRealmObject> from(DynamicRealm dynamicRealm, final DynamicRealmObject dynamicRealmObject) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return C1701g.m2394a(new C1703i<DynamicRealmObject>() {
            public void subscribe(final C1702h<DynamicRealmObject> hVar) throws Exception {
                final DynamicRealm instance = DynamicRealm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).acquireReference(dynamicRealmObject);
                final C20321 r1 = new RealmChangeListener<DynamicRealmObject>() {
                    public void onChange(DynamicRealmObject dynamicRealmObject) {
                        if (!hVar.isCancelled()) {
                            hVar.mo27373a(dynamicRealmObject);
                        }
                    }
                };
                RealmObject.addChangeListener(dynamicRealmObject, r1);
                hVar.mo27424a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        RealmObject.removeChangeListener(dynamicRealmObject, r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).releaseReference(dynamicRealmObject);
                    }
                }));
                hVar.mo27373a(dynamicRealmObject);
            }
        }, BACK_PRESSURE_STRATEGY);
    }

    public <E> C1701g<RealmList<E>> from(DynamicRealm dynamicRealm, final RealmList<E> realmList) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return C1701g.m2394a(new C1703i<RealmList<E>>() {
            public void subscribe(final C1702h<RealmList<E>> hVar) throws Exception {
                final DynamicRealm instance = DynamicRealm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).acquireReference(realmList);
                final C20201 r1 = new RealmChangeListener<RealmList<E>>() {
                    public void onChange(RealmList<E> realmList) {
                        if (!hVar.isCancelled()) {
                            hVar.mo27373a(realmList);
                        }
                    }
                };
                realmList.addChangeListener(r1);
                hVar.mo27424a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        realmList.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).releaseReference(realmList);
                    }
                }));
                hVar.mo27373a(realmList);
            }
        }, BACK_PRESSURE_STRATEGY);
    }

    public <E> C1701g<RealmResults<E>> from(DynamicRealm dynamicRealm, final RealmResults<E> realmResults) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return C1701g.m2394a(new C1703i<RealmResults<E>>() {
            public void subscribe(final C1702h<RealmResults<E>> hVar) throws Exception {
                final DynamicRealm instance = DynamicRealm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).acquireReference(realmResults);
                final C20521 r1 = new RealmChangeListener<RealmResults<E>>() {
                    public void onChange(RealmResults<E> realmResults) {
                        if (!hVar.isCancelled()) {
                            hVar.mo27373a(realmResults);
                        }
                    }
                };
                realmResults.addChangeListener(r1);
                hVar.mo27424a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        realmResults.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).releaseReference(realmResults);
                    }
                }));
                hVar.mo27373a(realmResults);
            }
        }, BACK_PRESSURE_STRATEGY);
    }

    public C1701g<Realm> from(Realm realm) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return C1701g.m2394a(new C1703i<Realm>() {
            public void subscribe(final C1702h<Realm> hVar) throws Exception {
                final Realm instance = Realm.getInstance(configuration);
                final C20401 r1 = new RealmChangeListener<Realm>() {
                    public void onChange(Realm realm) {
                        if (!hVar.isCancelled()) {
                            hVar.mo27373a(realm);
                        }
                    }
                };
                instance.addChangeListener(r1);
                hVar.mo27424a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        instance.removeChangeListener(r1);
                        instance.close();
                    }
                }));
                hVar.mo27373a(instance);
            }
        }, BACK_PRESSURE_STRATEGY);
    }

    public <E> C1701g<RealmList<E>> from(Realm realm, final RealmList<E> realmList) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return C1701g.m2394a(new C1703i<RealmList<E>>() {
            public void subscribe(final C1702h<RealmList<E>> hVar) throws Exception {
                final Realm instance = Realm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).acquireReference(realmList);
                final C20141 r1 = new RealmChangeListener<RealmList<E>>() {
                    public void onChange(RealmList<E> realmList) {
                        if (!hVar.isCancelled()) {
                            hVar.mo27373a(realmList);
                        }
                    }
                };
                realmList.addChangeListener(r1);
                hVar.mo27424a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        realmList.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).releaseReference(realmList);
                    }
                }));
                hVar.mo27373a(realmList);
            }
        }, BACK_PRESSURE_STRATEGY);
    }

    public <E extends RealmModel> C1701g<E> from(Realm realm, final E e) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return C1701g.m2394a(new C1703i<E>() {
            public void subscribe(final C1702h<E> hVar) throws Exception {
                final Realm instance = Realm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).acquireReference(e);
                final C20261 r1 = new RealmChangeListener<E>() {
                    public void onChange(E e) {
                        if (!hVar.isCancelled()) {
                            hVar.mo27373a(e);
                        }
                    }
                };
                RealmObject.addChangeListener(e, r1);
                hVar.mo27424a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        RealmObject.removeChangeListener(e, r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).releaseReference(e);
                    }
                }));
                hVar.mo27373a(e);
            }
        }, BACK_PRESSURE_STRATEGY);
    }

    public <E> C1701g<RealmResults<E>> from(Realm realm, final RealmResults<E> realmResults) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return C1701g.m2394a(new C1703i<RealmResults<E>>() {
            public void subscribe(final C1702h<RealmResults<E>> hVar) throws Exception {
                final Realm instance = Realm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).acquireReference(realmResults);
                final C20461 r1 = new RealmChangeListener<RealmResults<E>>() {
                    public void onChange(RealmResults<E> realmResults) {
                        if (!hVar.isCancelled()) {
                            hVar.mo27373a(realmResults);
                        }
                    }
                };
                realmResults.addChangeListener(r1);
                hVar.mo27424a(C1728c.m2443a(new Runnable() {
                    public void run() {
                        realmResults.removeChangeListener(r1);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).releaseReference(realmResults);
                    }
                }));
                hVar.mo27373a(realmResults);
            }
        }, BACK_PRESSURE_STRATEGY);
    }

    public <E> C1714r<RealmQuery<E>> from(DynamicRealm dynamicRealm, RealmQuery<E> realmQuery) {
        throw new RuntimeException("RealmQuery not supported yet.");
    }

    public <E> C1714r<RealmQuery<E>> from(Realm realm, RealmQuery<E> realmQuery) {
        throw new RuntimeException("RealmQuery not supported yet.");
    }

    public int hashCode() {
        return 37;
    }
}
