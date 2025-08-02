package net.trysmp.offline.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.proxy.server.ServerPing;
import net.trysmp.offline.util.ColorUtil;

public class ProxyPingListener {

    private final String motd1 = "&7                      &#1684FF&lT&#1A8DFF&lr&#1E96FF&ly&#22A0FF&lS&#26A9FF&lm&#2BB2FF&lp&#2FBBFF&l.&#33C5FF&ln&#37CEFF&le&#3BD7FF&lt";
    private final String motd2 = "&7            &7never been so hyped before";

    @Subscribe
    public void handle(ProxyPingEvent event) {
        ServerPing.Builder builder = event.getPing().asBuilder();

        builder.clearSamplePlayers();

        builder.description(ColorUtil.translateColorCodes(motd1 + "\n" + motd2));
        builder.onlinePlayers(0);
        builder.maximumPlayers(0);
        builder.version(new ServerPing.Version(0, "§c"));

        event.setPing(builder.build());
    }

}
