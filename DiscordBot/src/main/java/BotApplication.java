import Commands.Guides.Friend;
import Commands.Guides.Settings;
import Commands.Help;
import com.github.ygimenez.exception.InvalidHandlerException;
import com.github.ygimenez.method.Pages;
import com.github.ygimenez.model.Paginator;
import com.github.ygimenez.model.PaginatorBuilder;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;


public class BotApplication extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, InvalidHandlerException {
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
                        new Friend(),
                        new Settings()
                );
        builder.addEventListeners(client.build());
        JDA bot = builder.build();

        Paginator paginator = PaginatorBuilder.createPaginator()
                .setHandler(bot)
                .shouldRemoveOnReact(true)
                .build();
        Pages.activate(paginator);
    }
}
