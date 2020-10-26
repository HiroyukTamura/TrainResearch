// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.controller;

import com.rd.animation.type.WormAnimation;
import com.rd.animation.type.DropAnimation;
import com.rd.draw.data.Orientation;
import com.rd.utils.CoordinatesUtils;
import android.animation.ValueAnimator;
import com.rd.animation.data.Value;
import android.support.annotation.NonNull;
import com.rd.animation.type.BaseAnimation;
import com.rd.draw.data.Indicator;

public class AnimationController
{
    private Indicator indicator;
    private boolean isInteractive;
    private ValueController.UpdateListener listener;
    private float progress;
    private BaseAnimation runningAnimation;
    private ValueController valueController;
    
    public AnimationController(@NonNull final Indicator indicator, @NonNull final ValueController.UpdateListener listener) {
        this.valueController = new ValueController(listener);
        this.listener = listener;
        this.indicator = indicator;
    }
    
    private void animate() {
        switch (this.indicator.getAnimationType()) {
            default: {}
            case NONE: {
                this.listener.onValueUpdated(null);
            }
            case COLOR: {
                this.colorAnimation();
            }
            case SCALE: {
                this.scaleAnimation();
            }
            case WORM: {
                this.wormAnimation();
            }
            case FILL: {
                this.fillAnimation();
            }
            case SLIDE: {
                this.slideAnimation();
            }
            case THIN_WORM: {
                this.thinWormAnimation();
            }
            case DROP: {
                this.dropAnimation();
            }
            case SWAP: {
                this.swapAnimation();
            }
        }
    }
    
    private void colorAnimation() {
        final BaseAnimation<ValueAnimator> duration = this.valueController.color().with(this.indicator.getUnselectedColor(), this.indicator.getSelectedColor()).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        }
        else {
            duration.start();
        }
        this.runningAnimation = duration;
    }
    
    private void dropAnimation() {
        int n;
        if (this.indicator.isInteractiveAnimation()) {
            n = this.indicator.getSelectedPosition();
        }
        else {
            n = this.indicator.getLastSelectedPosition();
        }
        int n2;
        if (this.indicator.isInteractiveAnimation()) {
            n2 = this.indicator.getSelectingPosition();
        }
        else {
            n2 = this.indicator.getSelectedPosition();
        }
        final int coordinate = CoordinatesUtils.getCoordinate(this.indicator, n);
        final int coordinate2 = CoordinatesUtils.getCoordinate(this.indicator, n2);
        int paddingTop = this.indicator.getPaddingTop();
        final int paddingLeft = this.indicator.getPaddingLeft();
        if (this.indicator.getOrientation() != Orientation.HORIZONTAL) {
            paddingTop = paddingLeft;
        }
        final int radius = this.indicator.getRadius();
        final DropAnimation with = this.valueController.drop().duration(this.indicator.getAnimationDuration()).with(coordinate, coordinate2, radius * 3 + paddingTop, radius + paddingTop, radius);
        if (this.isInteractive) {
            with.progress(this.progress);
        }
        else {
            with.start();
        }
        this.runningAnimation = with;
    }
    
    private void fillAnimation() {
        final BaseAnimation<ValueAnimator> duration = this.valueController.fill().with(this.indicator.getUnselectedColor(), this.indicator.getSelectedColor(), this.indicator.getRadius(), this.indicator.getStroke()).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        }
        else {
            duration.start();
        }
        this.runningAnimation = duration;
    }
    
    private void scaleAnimation() {
        final BaseAnimation<ValueAnimator> duration = this.valueController.scale().with(this.indicator.getUnselectedColor(), this.indicator.getSelectedColor(), this.indicator.getRadius(), this.indicator.getScaleFactor()).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        }
        else {
            duration.start();
        }
        this.runningAnimation = duration;
    }
    
    private void slideAnimation() {
        int n;
        if (this.indicator.isInteractiveAnimation()) {
            n = this.indicator.getSelectedPosition();
        }
        else {
            n = this.indicator.getLastSelectedPosition();
        }
        int n2;
        if (this.indicator.isInteractiveAnimation()) {
            n2 = this.indicator.getSelectingPosition();
        }
        else {
            n2 = this.indicator.getSelectedPosition();
        }
        final BaseAnimation<ValueAnimator> duration = this.valueController.slide().with(CoordinatesUtils.getCoordinate(this.indicator, n), CoordinatesUtils.getCoordinate(this.indicator, n2)).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        }
        else {
            duration.start();
        }
        this.runningAnimation = duration;
    }
    
    private void swapAnimation() {
        int n;
        if (this.indicator.isInteractiveAnimation()) {
            n = this.indicator.getSelectedPosition();
        }
        else {
            n = this.indicator.getLastSelectedPosition();
        }
        int n2;
        if (this.indicator.isInteractiveAnimation()) {
            n2 = this.indicator.getSelectingPosition();
        }
        else {
            n2 = this.indicator.getSelectedPosition();
        }
        final BaseAnimation<ValueAnimator> duration = this.valueController.swap().with(CoordinatesUtils.getCoordinate(this.indicator, n), CoordinatesUtils.getCoordinate(this.indicator, n2)).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        }
        else {
            duration.start();
        }
        this.runningAnimation = duration;
    }
    
    private void thinWormAnimation() {
        int n;
        if (this.indicator.isInteractiveAnimation()) {
            n = this.indicator.getSelectedPosition();
        }
        else {
            n = this.indicator.getLastSelectedPosition();
        }
        int n2;
        if (this.indicator.isInteractiveAnimation()) {
            n2 = this.indicator.getSelectingPosition();
        }
        else {
            n2 = this.indicator.getSelectedPosition();
        }
        final WormAnimation duration = this.valueController.thinWorm().with(CoordinatesUtils.getCoordinate(this.indicator, n), CoordinatesUtils.getCoordinate(this.indicator, n2), this.indicator.getRadius(), n2 > n).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        }
        else {
            duration.start();
        }
        this.runningAnimation = duration;
    }
    
    private void wormAnimation() {
        int n;
        if (this.indicator.isInteractiveAnimation()) {
            n = this.indicator.getSelectedPosition();
        }
        else {
            n = this.indicator.getLastSelectedPosition();
        }
        int n2;
        if (this.indicator.isInteractiveAnimation()) {
            n2 = this.indicator.getSelectingPosition();
        }
        else {
            n2 = this.indicator.getSelectedPosition();
        }
        final WormAnimation duration = this.valueController.worm().with(CoordinatesUtils.getCoordinate(this.indicator, n), CoordinatesUtils.getCoordinate(this.indicator, n2), this.indicator.getRadius(), n2 > n).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        }
        else {
            duration.start();
        }
        this.runningAnimation = duration;
    }
    
    public void basic() {
        this.isInteractive = false;
        this.progress = 0.0f;
        this.animate();
    }
    
    public void end() {
        if (this.runningAnimation != null) {
            this.runningAnimation.end();
        }
    }
    
    public void interactive(final float progress) {
        this.isInteractive = true;
        this.progress = progress;
        this.animate();
    }
}
