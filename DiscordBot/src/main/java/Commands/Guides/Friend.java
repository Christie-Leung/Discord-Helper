package Commands.Guides;

import Commands.GuidesCmd;
import com.github.ygimenez.method.Pages;
import com.github.ygimenez.model.Page;
import com.github.ygimenez.model.ThrowingBiConsumer;
import com.github.ygimenez.type.PageType;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static Commands.Guides.Essentials.setEmbedMessage;

// inherits GuidesCmd class
public class Friend extends GuidesCmd {

    // Sets essential settings for command (name, help message, parameters)
    public Friend() {
        this.name = "friend";
        this.help = "Helps you with everything friend related";
        this.arguments = "add | accept | remove | message | block";
    }

    @Override
    public void doCommand(CommandEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        ArrayList<Page> pages = new ArrayList<>();

        // First page
        String[] args = e.getArgs().toLowerCase().split("\\s+");
        eb.setImage("https://cdn.discordapp.com/attachments/821824091261763609/822182132477853707/unknown.png");
        eb.setTitle("The Friend System");

        // Checks what parameters the user put and give the according guides
        if (args[0].contains("add")) {
            eb.setDescription("In this guide, you will learn how to add a friend!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            setEmbedMessage(e, eb, pages, this.name, args[0], "Adding a Friend");
        } else if (args[0].contains("accept")) {
            eb.setDescription("In this guide, you will learn how to accept or ignore a friend request!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            setEmbedMessage(e, eb, pages,this.name, args[0], "Accepting a Friend Request");
        } else if (args[0].contains("remove")) {
            eb.setDescription("In this guide, you will learn how to remove a friend!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            setEmbedMessage(e, eb, pages, this.name, args[0], "Removing a Friend");
        } else if (args[0].contains("message") || args[0].contains("msg")) {
            ThrowingBiConsumer<Member, Message> method1 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend through the friends directory!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                setEmbedMessage(e, eb, pages, this.name, "msg1", "Messaging a Friend");
            };

            ThrowingBiConsumer<Member, Message> method2 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend in a server environment!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                setEmbedMessage(e, eb, pages, this.name, "msg2", "Messaging a Friend");
            };

            ThrowingBiConsumer<Member, Message> method3 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend using the friends page!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                setEmbedMessage(e, eb, pages, this.name, "msg3", "Messaging a Friend");
            };

            Map<String, ThrowingBiConsumer<Member, Message>> functions = new LinkedHashMap<>();
            functions.put("1️⃣", method1);
            functions.put("2️⃣", method2);
            functions.put("3️⃣", method3);

            eb.setTitle("Messaging a Friend");
            eb.setDescription("There are 3 ways to message a friend. \nPlease react with the method you would like to learn. \n1️⃣ - Within the Friend Directory \n2️⃣ - In a Server Environment \n3️⃣ - Within the Friends Page");
            e.getChannel().sendMessage(eb.build()).queue(success -> Pages.buttonize(success, functions, true));
        } else if (args[0].contains("block")) {
            ThrowingBiConsumer<Member, Message> method1 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to block a friend/user through the friends directory!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                setEmbedMessage(e, eb, pages, this.name, "block1", "Blocking a Friend");

            };

            ThrowingBiConsumer<Member, Message> method2 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to block a friend/user in a server environment!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                setEmbedMessage(e, eb, pages, this.name, "block2", "Blocking a Friend");
            };

            Map<String, ThrowingBiConsumer<Member, Message>> functions = new LinkedHashMap<>();
            functions.put("1️⃣", method1);
            functions.put("2️⃣", method2);

            eb.setTitle("Blocking a Friend/User");
            eb.setDescription("There are 2 ways to block a friend/user. **Please note that blocking a friend will automatically remove them as a friend.**\nPlease react with the method you would like to learn. \n1️⃣ - Within the Friend Directory \n2️⃣ - In a Server Environment");
            e.getChannel().sendMessage(eb.build()).queue(success -> Pages.buttonize(success, functions, true));
        } else {
            e.replyError("Please try again with the proper parameters: \nFor example: `!friends add` or `!friends message` \n\nHere are all parameters: add, accept, remove, message, block");
        }
    }
}
// 1️⃣ 2️⃣ 3️⃣ 4️⃣ 5️⃣ 6️⃣ 7️⃣ 8️⃣ 9️⃣