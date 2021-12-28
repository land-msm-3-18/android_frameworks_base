package org.fork.android.systemui.dagger;

import com.android.systemui.dagger.DefaultComponentBinder;
import com.android.systemui.dagger.DependencyProvider;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.SystemUIBinder;
import com.android.systemui.dagger.SysUIComponent;
import com.android.systemui.dagger.SystemUIModule;

import org.aospextended.android.systemui.keyguard.KeyguardSliceProviderAEX;
import org.aospextended.android.systemui.smartspace.KeyguardSmartspaceController;

import dagger.Subcomponent;

@SysUISingleton
@Subcomponent(modules = {
        DefaultComponentBinder.class,
        DependencyProvider.class,
        SystemUIBinder.class,
        SystemUIModule.class,
        SystemUIforkModule.class})
public interface SysUIComponentfork extends SysUIComponent {
    @SysUISingleton
    @Subcomponent.Builder
    interface Builder extends SysUIComponent.Builder {
        SysUIComponentfork build();
    }

    /**
     * Member injection into the supplied argument.
     */
    void inject(KeyguardSliceProviderAEX keyguardSliceProviderAEX);

    @SysUISingleton
    KeyguardSmartspaceController createKeyguardSmartspaceController();
}
