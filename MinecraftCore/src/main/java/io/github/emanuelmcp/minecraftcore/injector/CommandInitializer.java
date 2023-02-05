package io.github.emanuelmcp.minecraftcore.injector;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Singleton
public class CommandInitializer implements Initializer {

    @Inject
    private JavaPlugin javaPlugin;

    @Override
    public void init(@NotNull Injector injector) {
        /*Objects.requireNonNull(
                javaPlugin.getCommand("register"))
                .setExecutor(injector.getInstance(RegisterCommand.class));*/
    }
}
