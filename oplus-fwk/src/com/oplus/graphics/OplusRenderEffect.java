package com.oplus.graphics;

import android.graphics.RenderEffect;
import android.util.MathUtils;

public final class OplusRenderEffect {
    
    // Private Constructor
    private OplusRenderEffect() {
    }

    // 4 Parameters Overload
    public static RenderEffect createGradientBlurEffect(float startRadius, float endRadius,
            boolean isVertical, float speed) {
        return createGradientBlurEffect(startRadius, endRadius, isVertical, speed, 0, 0, 0);
    }

    // 7 Parameters Overload
    public static RenderEffect createGradientBlurEffect(float startRadius, float endRadius,
            boolean isVertical, float speed, int blendMode, int blendC, int mixC) {
        return createGradientBlurEffect(startRadius, endRadius, isVertical, speed, blendMode, blendC, mixC, null);
    }

    // Main Implementation (8 Parameters)
    public static RenderEffect createGradientBlurEffect(float startRadius, float endRadius,
            boolean isVertical, float speed, int blendMode, int blendC, int mixC,
            RenderEffect inputEffect) {
        
        float radiusX = MathUtils.max(0.0f, startRadius);
        float radiusY = MathUtils.max(0.0f, endRadius);
        
        if (radiusX == 0.0f && radiusY == 0.0f) {
            radiusX = 1.0f;
            radiusY = 1.0f;
        }
        
        if (inputEffect != null) {
            return RenderEffect.createBlurEffect(radiusX, radiusY, inputEffect, android.graphics.Shader.TileMode.CLAMP);
        } else {
            return RenderEffect.createBlurEffect(radiusX, radiusY, android.graphics.Shader.TileMode.CLAMP);
        }
    }
}
