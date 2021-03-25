package Commands.Guides;

import com.github.ygimenez.method.Pages;
import com.github.ygimenez.model.Page;
import com.github.ygimenez.type.PageType;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.ArrayList;
import java.util.List;

public interface Essentials {
    static void setEmbedMessage(CommandEvent e, EmbedBuilder eb, ArrayList<Page> pages, String system, String command, String title) {
        StringDescriptions str = new StringDescriptions();
        List<String[]> data = str.getData(system, command);
        List<String> desc = new ArrayList<>();
        List<String> images = new ArrayList<>();
        for (String[] descImages : data) {
            desc.add(descImages[0]);
            images.add(descImages[1]);
        }

        for (int i = 0; i < desc.size(); i++) {
            eb.clear();
            String categoryName = "-- **Step " + (i + 1) + "** --";
            eb.setTitle(title);
            eb.setImage(images.get(i));
            eb.addField(categoryName, desc.get(i), false);
            pages.add(new Page(PageType.EMBED, eb.build()));
        }
        pages.add(new Page(PageType.EMBED, eb.build()));
        e.getChannel().sendMessage((MessageEmbed) pages.get(0).getContent()).queue(success -> Pages.paginate(success, pages));
    }
}