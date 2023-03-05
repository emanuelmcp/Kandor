package io.github.emanuelmcp.kandorauth;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.github.emanuelmcp.kandorauth.api.injector.BinderModule;
import io.github.emanuelmcp.kandorauth.api.injector.CommandInitializer;
import io.github.emanuelmcp.kandorauth.api.injector.ListenerInitializer;
import org.bukkit.plugin.java.JavaPlugin;

public final class KandorAuth extends JavaPlugin {
    @Inject
    private ListenerInitializer listenerInitializer;
    @Inject
    private CommandInitializer commandInitializer;
    @Override
    public void onEnable() {
        final Injector injector = Guice.createInjector(new BinderModule(this));
        injector.injectMembers(this);
        listenerInitializer.init(injector);
        commandInitializer.init(injector);
        saveDefaultConfig();
    }
}
