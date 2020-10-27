package p041io.realm.internal;

import p041io.realm.RealmChangeListener;
import p041io.realm.internal.ObservableCollection;
import p041io.realm.internal.core.DescriptorOrdering;
import p041io.realm.internal.sync.OsSubscription;
import p041io.realm.internal.sync.SubscriptionAction;

/* renamed from: io.realm.internal.SubscriptionAwareOsResults */
public class SubscriptionAwareOsResults extends OsResults {
    /* access modifiers changed from: private */
    public boolean collectionChanged = false;
    /* access modifiers changed from: private */
    public long delayedNotificationPtr = 0;
    private boolean firstCallback = true;
    private OsSubscription subscription = null;
    /* access modifiers changed from: private */
    public boolean subscriptionChanged;

    SubscriptionAwareOsResults(OsSharedRealm osSharedRealm, Table table, long j, SubscriptionAction subscriptionAction) {
        super(osSharedRealm, table, j);
        OsSubscription osSubscription = new OsSubscription(this, subscriptionAction);
        this.subscription = osSubscription;
        osSubscription.addChangeListener(new RealmChangeListener<OsSubscription>() {
            public void onChange(OsSubscription osSubscription) {
                boolean unused = SubscriptionAwareOsResults.this.subscriptionChanged = true;
            }
        });
        RealmNotifier realmNotifier = osSharedRealm.realmNotifier;
        realmNotifier.addBeginSendingNotificationsCallback(new Runnable() {
            public void run() {
                boolean unused = SubscriptionAwareOsResults.this.subscriptionChanged = false;
                boolean unused2 = SubscriptionAwareOsResults.this.collectionChanged = false;
                long unused3 = SubscriptionAwareOsResults.this.delayedNotificationPtr = 0;
            }
        });
        realmNotifier.addFinishedSendingNotificationsCallback(new Runnable() {
            public void run() {
                if (SubscriptionAwareOsResults.this.collectionChanged || SubscriptionAwareOsResults.this.subscriptionChanged) {
                    SubscriptionAwareOsResults.this.triggerDelayedChangeListener();
                }
            }
        });
    }

    public static SubscriptionAwareOsResults createFromQuery(OsSharedRealm osSharedRealm, TableQuery tableQuery, DescriptorOrdering descriptorOrdering, SubscriptionAction subscriptionAction) {
        tableQuery.validateQuery();
        return new SubscriptionAwareOsResults(osSharedRealm, tableQuery.getTable(), OsResults.nativeCreateResults(osSharedRealm.getNativePtr(), tableQuery.getNativePtr(), descriptorOrdering.getNativePtr()), subscriptionAction);
    }

    /* access modifiers changed from: private */
    public void triggerDelayedChangeListener() {
        OsSubscription osSubscription = this.subscriptionChanged ? this.subscription : null;
        if (this.delayedNotificationPtr != 0 || osSubscription == null || this.firstCallback || osSubscription.getState() == OsSubscription.SubscriptionState.ERROR || osSubscription.getState() == OsSubscription.SubscriptionState.COMPLETE) {
            OsCollectionChangeSet emptyLoadChangeSet = this.delayedNotificationPtr == 0 ? new EmptyLoadChangeSet(osSubscription, this.firstCallback, true) : new OsCollectionChangeSet(this.delayedNotificationPtr, this.firstCallback, osSubscription, true);
            if (!emptyLoadChangeSet.isEmpty() || !isLoaded()) {
                this.loaded = true;
                this.firstCallback = false;
                this.observerPairs.foreach(new ObservableCollection.Callback(emptyLoadChangeSet));
            }
        }
    }

    public void notifyChangeListeners(long j) {
        this.collectionChanged = true;
        this.delayedNotificationPtr = j;
    }
}
