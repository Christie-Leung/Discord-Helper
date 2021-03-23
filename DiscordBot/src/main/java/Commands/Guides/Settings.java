package Commands.Guides;

import Commands.GuidesCmd;
import com.github.ygimenez.model.Page;
import com.github.ygimenez.type.PageType;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.util.ArrayList;
import java.util.List;

import static Commands.Guides.Essentials.setEmbedMessage;

public class Settings extends GuidesCmd {

    public Settings() {
        this.name = "settings";
        this.help = "Shows different essential settings and how to use them";
        this.arguments = "language | appearance | sound";
    }

    @Override
    public void doCommand(CommandEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        ArrayList<Page> pages = new ArrayList<>();

        String[] args = e.getArgs().toLowerCase().split("\\s+");
        eb.setImage("https://cdn.discordapp.com/attachments/821824091261763609/822550834050105354/unknown.png");
        eb.setTitle("Discord Settings");

        if (args[0].contains("language")) {
            eb.setDescription("In this guide, you will learn how to change the language!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            setEmbedMessage(e, eb, pages, this.name, args[0], "Changing Languages");
        } else if (args[0].contains("appearance")) {
            eb.setDescription("In this guide, you will learn how to change the appearance of your window!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            setEmbedMessage(e, eb, pages, this.name, args[0], "Changing the Appearance");
        } else if (args[0].contains("sound")) {
            eb.setDescription("In this guide, you will learn how to adjust your voice and video settings!");
            pages.add(new Page(PageType.EMBED, eb.build()));
            setEmbedMessage(e, eb, pages, this.name, args[0], "Adjusting Voice and Video");
        } else {
            e.replyError("Please try again with the proper parameters: \nFor example: `!settings language` or `!settings sound` \n\n Here are all parameters: language, appearance, and sound.");
        }

    }


}
