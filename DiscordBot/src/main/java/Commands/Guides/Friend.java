package Commands.Guides;

import Commands.GuidesCmd;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.menu.Paginator;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.GuildChannel;

public class Friend extends GuidesCmd {

    private final Paginator.Builder pBuilder;

    public Friend(EventWaiter waiter) {
        this.name = "friends";
        this.help = "Helps you with everything friend related";
        this.arguments = "add | remove | message";
        this.pBuilder = new Paginator.Builder()
                .waitOnSinglePage(true)
                .setFinalAction(m -> m.clearReactions().queue(v -> {}, v -> {}))
                .setItemsPerPage(1)
                .showPageNumbers(true)
                .setEventWaiter(waiter);
    }

    @Override
    public void doCommand(CommandEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        String[] args = e.getArgs().toLowerCase().split("\\s+");

        if (args[0].contains("add")) {
            e.reply("How to Add Friends", message -> {
                pBuilder.clearItems();
                pBuilder.setColor(e.getMember().getColor());
                pBuilder.setText("Adding a Friend");
                for (int i = 0; i < StringDescriptions.addFriends.size(); i++) {
                    String categoryName = "--**Step " + (i + 1) + "**--";
                    pBuilder.addItems("--**" + categoryName + "**--");
                    pBuilder.addItems(StringDescriptions.addFriends.get(i));
                    eb.setImage(StringDescriptions.addFriendsImages.get(i));
                    eb.addField(categoryName, StringDescriptions.addFriends.get(i), false);
                }
                //pBuilder.build().display(message);

                e.reply(eb.build());
            });

        } else if (args[0].contains("remove")) {
            e.reply("noo dont remove me");
        } else if (args[0].contains("message")) {
            e.reply("yo");
        } else {
            e.replyError("Um... did you read the instructions??");
        }
    }
}
