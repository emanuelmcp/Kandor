package io.github.emanuelmcp.minecraftcore.injector;

import com.google.inject.Inject;
import com.google.inject.Injector;
import io.github.emanuelmcp.minecraftcore.listeners.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ListenerInitializer implements Initializer {

    private final JavaPlugin javaPlugin;
    private final PluginManager pluginManager;

    @Inject
    public ListenerInitializer(JavaPlugin javaPlugin, PluginManager pluginManager) {
        this.javaPlugin = javaPlugin;
        this.pluginManager = pluginManager;
    }
    @Override
    public void init(@NotNull Injector injector) {
        /*pluginManager.registerEvents(injector.getInstance(PlayerJoin.class), javaPlugin);*/
        //pluginManager.registerEvents(injector.getInstance(PlayerJoin.class), javaPlugin);
        pluginManager.registerEvents(injector.getInstance(PlayerJoinEvent.class), javaPlugin);
    }
}
