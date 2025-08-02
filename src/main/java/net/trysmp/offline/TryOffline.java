package net.trysmp.offline;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;
import net.trysmp.offline.listener.LoginListener;
import net.trysmp.offline.listener.ProxyPingListener;

import javax.inject.Inject;

@Plugin(
        id = "offline",
        name = "Offline",
        version = "1.0"
)
@Getter
public class TryOffline {

    @Getter
    private static TryOffline instance;
    private final ProxyServer server;

    @Inject
    public TryOffline(ProxyServer server) {
        this.server = server;
    }

    @Subscribe
    public void handle(ProxyInitializeEvent event) {
        instance = this;

        server.getEventManager().register(this, new LoginListener());
        server.getEventManager().register(this, new ProxyPingListener());
    }

}
