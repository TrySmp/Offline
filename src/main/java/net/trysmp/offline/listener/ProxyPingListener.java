package net.trysmp.offline.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.proxy.server.ServerPing;
import net.trysmp.offline.util.ColorUtil;

public class ProxyPingListener {

    private static final String MOTD_1 = "&7                      &#1684FF&lT&#1A8DFF&lr&#1E96FF&ly&#22A0FF&lS&#26A9FF&lm&#2BB2FF&lp&#2FBBFF&l.&#33C5FF&ln&#37CEFF&le&#3BD7FF&lt";
    private static final String MOTD_2 = "&7            &7never been so hyped before";

    private static final int MIN_PLAYERS = 10000;
    private static final int MAX_PLAYERS = 250000;

    @Subscribe
    public void handle(ProxyPingEvent event) {
        ServerPing.Builder builder = event.getPing().asBuilder();

        builder.clearSamplePlayers();
        builder.description(ColorUtil.translateColorCodes(MOTD_1 + "\n" + MOTD_2));

        int players = (int) (Math.random() * (MAX_PLAYERS - MIN_PLAYERS + 1) + MIN_PLAYERS);
        builder.onlinePlayers(players - 1);
        builder.maximumPlayers(players);

        event.setPing(builder.build());
    }

}
