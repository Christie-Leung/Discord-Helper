package Commands.Guides;

import Commands.GuidesCmd;
import com.github.ygimenez.exception.InvalidHandlerException;
import com.github.ygimenez.method.Pages;
import com.github.ygimenez.model.Page;
import com.github.ygimenez.model.ThrowingBiConsumer;
import com.github.ygimenez.type.PageType;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.*;

public class Friend extends GuidesCmd {

   // private final Paginator pBuilder;

    public Friend() {
        this.name = "friends";
        this.help = "Helps you with everything friend related";
        this.arguments = "add | accept | remove | message";

    }

    @Override
    public void doCommand(CommandEvent e) throws InvalidHandlerException {
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
            setEmbedMessage(e, eb, pages, desc, images);
        } else if (args[0].contains("accept")) {
            eb.setDescription("In this guide, you will learn how to accept or ignore a friend request!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            List<String> desc = str.getAccept();
            List<String> images = str.getAcceptImages();
            setEmbedMessage(e, eb, pages, desc, images);
        } else if (args[0].contains("remove")) {
            eb.setDescription("In this guide, you will learn how to remove a friend!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            List<String> desc = str.getRemove();
            List<String> images = str.getRemoveImages();
            setEmbedMessage(e, eb, pages, desc, images);
        } else if (args[0].contains("message")) {
            ThrowingBiConsumer<Member, Message> method1 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend through the friends directory!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                List<String> desc = str.getMessage(1);
                List<String> images = str.getMessageImages(1);
                setEmbedMessage(e, eb, pages, desc, images);
            };

            ThrowingBiConsumer<Member, Message> method2 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend in a server environment!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                List<String> desc = str.getMessage(2);
                List<String> images = str.getMessageImages(2);
                setEmbedMessage(e, eb, pages, desc, images);
            };

            ThrowingBiConsumer<Member, Message> method3 = (member, action) -> {
                eb.setDescription("In this guide, you will learn how to direct message a friend using the friends page!");
                pages.add(new Page(PageType.EMBED, eb.build()));
                List<String> desc = str.getMessage(3);
                List<String> images = str.getMessageImages(3);
                setEmbedMessage(e, eb, pages, desc, images);
            };

            Map<String, ThrowingBiConsumer<Member, Message>> functions = new LinkedHashMap<>();
            functions.put("1️⃣", method1);
            functions.put("2️⃣", method2);
            functions.put("3️⃣", method3);

            eb.setTitle("Messaging a Friend");
            eb.setDescription("There are 3 ways to message a friend. \nPlease react with the method you would like to learn. \n1️⃣ - Within the Friend Directory \n2️⃣ - In a Server Environment \n3️⃣ - Within the Friends Page");
            e.getChannel().sendMessage(eb.build()).queue(success -> Pages.buttonize(success, functions, true));
        } else {
            e.replyError("Um... did you read the instructions??");
        }
    }

    private void setEmbedMessage(CommandEvent e, EmbedBuilder eb, ArrayList<Page> pages, List<String> desc, List<String> images) {
        for (int i = 0; i < desc.size(); i++) {
            eb.clear();
            String categoryName = "-- **Step " + (i + 1) + "** --";
            eb.setTitle("Messaging a Friend");
            eb.setImage(images.get(i));
            eb.addField(categoryName, desc.get(i), false);
            pages.add(new Page(PageType.EMBED, eb.build()));
        }
        pages.add(new Page(PageType.EMBED, eb.build()));
        e.getChannel().sendMessage((MessageEmbed) pages.get(0).getContent()).queue(success -> Pages.paginate(success, pages));
    }
}
// 1️⃣ 2️⃣ 3️⃣ 4️⃣ 5️⃣ 6️⃣ 7️⃣ 8️⃣ 9️⃣