package io.github.emanuelmcp.kandorauth.api.injector;

import com.google.inject.Inject;
import com.google.inject.Injector;
import io.github.emanuelmcp.kandorauth.command.GroupCmd;
import io.github.emanuelmcp.kandorauth.command.RegisterCmd;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandInitializer implements Initializer{
    @Inject
    private JavaPlugin javaPlugin;

    @Override
    public void init(@NotNull Injector injector) {
        Objects.requireNonNull(
                javaPlugin.getCommand("register"))
                .setExecutor(injector.getInstance(RegisterCmd.class));
        Objects.requireNonNull(javaPlugin.getCommand("group"))
                .setExecutor(injector.getInstance(GroupCmd.class));
    }
}
