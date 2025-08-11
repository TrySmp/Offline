package net.trysmp.offline.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.LoginEvent;
import net.trysmp.offline.util.ColorUtil;

public class LoginListener {

    @Subscribe
    public void handle(LoginEvent event) {
        if (event.getPlayer().hasPermission("*")) return;

        event.setResult(LoginEvent.ComponentResult.denied(ColorUtil.translateColorCodes("""
                &#ff0000The biggest TrySmp update is on the way!
                
                &7Our team is working tirelessly to improve your experience
                &7In the meantime, you are welcome to join our discord
                
                &#559eff&ndiscord.gg/trysmp
                """)));
    }

}
