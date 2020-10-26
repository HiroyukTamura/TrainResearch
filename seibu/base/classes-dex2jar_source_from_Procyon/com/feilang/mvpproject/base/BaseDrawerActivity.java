// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base;

import android.view.MenuItem;
import android.support.v7.app.ActionBarDrawerToggle;
import com.feilang.mvpproject.R;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public abstract class BaseDrawerActivity extends BaseAppCompatActivity
{
    protected void closeDrawer() {
        final DrawerLayout drawerLayout = this.getDrawerLayout();
        if (drawerLayout != null) {
            drawerLayout.closeDrawers();
        }
    }
    
    protected abstract Class[] getDrawerActivities();
    
    protected abstract DrawerLayout getDrawerLayout();
    
    protected abstract Class getHeaderActivityClass();
    
    int getMenuIndex(final Activity activity) {
        for (int i = 0; i < this.getDrawerActivities().length; ++i) {
            if (this.getDrawerActivities()[i].isInstance(activity)) {
                return i;
            }
        }
        return 0;
    }
    
    protected abstract NavigationView.OnNavigationItemSelectedListener getNavigationItemSelectedListener();
    
    protected abstract NavigationView getNavigationView();
    
    protected void initDrawerToggle(final DrawerLayout drawerLayout, final Toolbar toolbar) {
        final ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_open, R.string.menu_close) {
            @Override
            public void onDrawerClosed(final View view) {
                super.onDrawerClosed(view);
            }
            
            @Override
            public void onDrawerOpened(final View view) {
                super.onDrawerOpened(view);
            }
        };
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener((DrawerLayout.DrawerListener)actionBarDrawerToggle);
    }
    
    boolean isDrawerActivity(final Activity activity) {
        final boolean b = false;
        final Class[] drawerActivities = this.getDrawerActivities();
        final int length = drawerActivities.length;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= length) {
                break;
            }
            if (drawerActivities[n].isInstance(activity)) {
                b2 = true;
                break;
            }
            ++n;
        }
        return b2;
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 16908332: {
                if (this.isDrawerActivity(this)) {
                    final DrawerLayout drawerLayout = this.getDrawerLayout();
                    if (drawerLayout != null) {
                        drawerLayout.openDrawer(8388611);
                    }
                    else {
                        this.finish();
                    }
                }
                else {
                    this.finish();
                }
                return true;
            }
        }
    }
    
    protected void setupDrawer() {
        final DrawerLayout drawerLayout = this.getDrawerLayout();
        final NavigationView navigationView = this.getNavigationView();
        this.initDrawerToggle(drawerLayout, this.getToolbar());
        if (navigationView != null) {
            this.setupDrawerContent(navigationView);
        }
    }
    
    protected void setupDrawerContent(final NavigationView navigationView) {
        navigationView.getMenu().getItem(this.getMenuIndex(this)).setChecked(true);
        navigationView.getHeaderView(0).setOnClickListener(BaseDrawerActivity$$Lambda$1.lambdaFactory$(this));
        navigationView.setNavigationItemSelectedListener(this.getNavigationItemSelectedListener());
    }
}
