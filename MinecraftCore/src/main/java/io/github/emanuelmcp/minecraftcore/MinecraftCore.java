package io.github.emanuelmcp.minecraftcore;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.github.emanuelmcp.minecraftcore.injector.BinderModule;
import io.github.emanuelmcp.minecraftcore.injector.CommandInitializer;
import io.github.emanuelmcp.minecraftcore.injector.ListenerInitializer;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftCore extends JavaPlugin {

    @Inject
    private ListenerInitializer listenerInitializer;
    @Inject
    private CommandInitializer commandInitializer;
    @Override
    public void onEnable() {
        // Plugin startup logic
        final Injector injector = Guice.createInjector(new BinderModule(this));
        injector.injectMembers(this);
        listenerInitializer.init(injector);
        commandInitializer.init(injector);
        saveDefaultConfig();
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
