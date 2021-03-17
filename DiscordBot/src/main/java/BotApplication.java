
import Commands.Guides.Friend;
import Commands.Help;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;


public class BotApplication extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(Private.botToken);
        EventWaiter waiter = new EventWaiter();

        CommandClientBuilder client = new CommandClientBuilder();
        client.setPrefix("!")
                .setOwnerId(Private.ownerId)
                .useHelpBuilder(false)
                .setActivity(Activity.playing("Discord"))
                .addCommands(
                        new Help(waiter),
                        // Guides for new users
                        new Friend(waiter)
                );
        builder.addEventListeners(client.build());
        builder.build();
    }
}
