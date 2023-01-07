package io.github.emanuelmcp.plugin.injectors;

import com.google.inject.Inject;
import com.google.inject.Injector;
import io.github.emanuelmcp.api.initializer.Initializer;
import io.github.emanuelmcp.plugin.staff.listeners.PlayerJoin;
import io.github.emanuelmcp.plugin.staff.listeners.PlayerLeave;
import io.github.emanuelmcp.plugin.staff.listeners.PlayerLoginRestriction;
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
        pluginManager.registerEvents(injector.getInstance(PlayerJoin.class), javaPlugin);
        pluginManager.registerEvents(injector.getInstance(PlayerLeave.class), javaPlugin);
        pluginManager.registerEvents(injector.getInstance(PlayerLoginRestriction.class), javaPlugin);
    }
}
