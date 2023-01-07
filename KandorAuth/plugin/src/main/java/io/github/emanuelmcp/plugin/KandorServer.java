package io.github.emanuelmcp.plugin;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.github.emanuelmcp.plugin.injectors.BinderModule;
import io.github.emanuelmcp.plugin.injectors.CommandInitializer;
import io.github.emanuelmcp.plugin.injectors.ListenerInitializer;
import io.github.emanuelmcp.staff_database.StaffDatabase;
import org.bukkit.plugin.java.JavaPlugin;

public class KandorServer extends JavaPlugin {

    @Inject
    private ListenerInitializer listenerInitializer;
    @Inject
    private CommandInitializer commandInitializer;
    @Inject
    private StaffDatabase database;

    @Override
    public void onEnable() {
        final Injector injector = Guice.createInjector(new BinderModule(this));
        injector.injectMembers(this);
        listenerInitializer.init(injector);
        commandInitializer.init(injector);
        database.addNeededData();
        saveDefaultConfig();
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onDisable() {
        //End logic pluginç

    }

}
