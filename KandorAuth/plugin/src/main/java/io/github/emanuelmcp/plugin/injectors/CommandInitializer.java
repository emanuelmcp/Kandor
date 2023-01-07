package io.github.emanuelmcp.plugin.injectors;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import io.github.emanuelmcp.api.initializer.Initializer;
import io.github.emanuelmcp.plugin.authentication.commands.SetPasswordCommand;
import io.github.emanuelmcp.plugin.authentication.commands.LoginCommand;
import io.github.emanuelmcp.plugin.authentication.commands.RegisterCommand;
import io.github.emanuelmcp.plugin.authentication.commands.UnregisterCommand;
import io.github.emanuelmcp.plugin.staff.commands.groups.GroupsCommands;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Singleton
public class CommandInitializer implements Initializer {

    @Inject
    private JavaPlugin javaPlugin;

    @Override
    public void init(@NotNull Injector injector) {
        Objects.requireNonNull(
                javaPlugin.getCommand("register"))
                .setExecutor(injector.getInstance(RegisterCommand.class));

        Objects.requireNonNull(
                javaPlugin.getCommand("unregister"))
                .setExecutor(injector.getInstance(UnregisterCommand.class));

        Objects.requireNonNull(
                javaPlugin.getCommand("login"))
                .setExecutor(injector.getInstance(LoginCommand.class));

        Objects.requireNonNull(
                javaPlugin.getCommand("setpassword"))
                .setExecutor(injector.getInstance(SetPasswordCommand.class));

        Objects.requireNonNull(
                javaPlugin.getCommand("group"))
                .setExecutor(injector.getInstance(GroupsCommands.class));

    }
}
