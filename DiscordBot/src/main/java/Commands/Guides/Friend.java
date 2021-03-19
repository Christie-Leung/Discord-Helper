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


public class Friend extends GuidesCmd {
    public Friend() {
        this.name = "friends";
        this.help = "Helps you with everything friend related";
        this.arguments = "add | accept | remove | message | block";
    }

    @Override
    public void doCommand(CommandEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        ArrayList<Page> pages = new ArrayList<>();
        StringDescriptions str = new StringDescriptions();

        String[] args = e.getArgs().toLowerCase().split("\\s+");
        eb.setImage("https://cdn.discordapp.com/attachments/821824091261763609/822182132477853707/unknown.png");
        eb.setTitle("The Friend System");

        if (args[0].contains("add")) {
            eb.setDescription("In this guide, you will learn how to add a friend!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            List<String> desc = str.getAddFriend();
            List<String> images = str.getAddImages();
            setEmbedMessage(e, eb, pages, desc, images, "Adding a Friend");
        } else if (args[0].contains("accept")) {
            eb.setDescription("In this guide, you will learn how to accept or ignore a friend request!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            List<String> desc = str.getAccept();
            List<String> images = str.getAcceptImages();
            setEmbedMessage(e, eb, pages, desc, images, "Accepting a Friend Request");
        } else if (args[0].contains("remove")) {
            eb.setDescription("In this guide, you will learn how to remove a friend!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            List<String> desc = str.getRemove();
            List<String> images = str.getRemoveImages();
            setEmbedMessage(e, eb, pages, desc, images, "Removing a Friend");
        } else if (args[0].contains("message") || args[0].contains("msg")) {
            ThrowingBiConsumer<Member, Message> method1 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend through the friends directory!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                List<String> desc = str.getMessage(1);
                List<String> images = str.getMessageImages(1);
                setEmbedMessage(e, eb, pages, desc, images, "Messaging a Friend");
            };

            ThrowingBiConsumer<Member, Message> method2 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend in a server environment!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                List<String> desc = str.getMessage(2);
                List<String> images = str.getMessageImages(2);
                setEmbedMessage(e, eb, pages, desc, images, "Messaging a Friend");
            };

            ThrowingBiConsumer<Member, Message> method3 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend using the friends page!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                List<String> desc = str.getMessage(3);
                List<String> images = str.getMessageImages(3);
                setEmbedMessage(e, eb, pages, desc, images, "Messaging a Friend");
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
                List<String> desc = str.getBlock(1);
                List<String> images = str.getBlockImages(1);
                setEmbedMessage(e, eb, pages, desc, images, "Blocking a Friend");
            };

            ThrowingBiConsumer<Member, Message> method2 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to block a friend/user in a server environment!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                List<String> desc = str.getBlock(2);
                List<String> images = str.getBlockImages(2);
                setEmbedMessage(e, eb, pages, desc, images, "Blocking a Friend");
            };

            Map<String, ThrowingBiConsumer<Member, Message>> functions = new LinkedHashMap<>();
            functions.put("1️⃣", method1);
            functions.put("2️⃣", method2);

            eb.setTitle("Blocking a Friend/User");
            eb.setDescription("There are 2 ways to block a friend/user. **Please note that blocking a friend will automatically remove them as a friend.**\nPlease react with the method you would like to learn. \n1️⃣ - Within the Friend Directory \n2️⃣ - In a Server Environment");
            e.getChannel().sendMessage(eb.build()).queue(success -> Pages.buttonize(success, functions, true));
        } else {
            e.replyError("Please try again with the proper parameters: \nFor example: `!friends add` or `!friends message` \n\n Here are all parameters: add, accept, remove, message, block");
        }
    }
}
// 1️⃣ 2️⃣ 3️⃣ 4️⃣ 5️⃣ 6️⃣ 7️⃣ 8️⃣ 9️⃣