package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Help extends Command {

    public final EventWaiter waiter;

    public Help(EventWaiter waiter) {
        this.name = "help";
        this.waiter = waiter;
        this.hidden = false;
        this.help = "seems like you already know how to use this...";
    }

    @Override
    protected void execute(CommandEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Commands");
        eb.setColor(new Color((int) Math.floor(Math.random() * 255), (int) Math.floor(Math.random() * 255), (int) Math.floor(Math.random() * 255)));

        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Command> tempCmds = new ArrayList<>();
        for (Command c : e.getClient().getCommands()) {
            if(!c.isHidden()) {
                if(c.getCategory() == null) {
                    categories.add("No Category");
                } else if(!categories.contains(c.getCategory().getName())) {
                    categories.add(c.getCategory().getName());
                }
            }
        }

        for (String s : categories) {
            for (Command c : e.getClient().getCommands()) {
                if(c.getCategory() == null) {
                    if(s.contains("No Cate")) {
                        tempCmds.add(c);
                    }
                } else if(c.getCategory().getName().contains(s)) {
                    tempCmds.add(c);
                }
            }
            eb.addField(s, buildCommandString(tempCmds).toString(), false);
            tempCmds.clear();
        }
        Emoji checkMark = EmojiManager.getForAlias("white_check_mark");

        e.reply(eb.build());
    }

    StringBuilder buildCommandString(List<Command> commands) {
        StringBuilder sb = new StringBuilder();
        for (Command c : commands) {
            sb.append("`!").append(c.getName().toUpperCase()).append("`");
            if(c.getArguments() != null) {
                sb.append(" <").append(c.getArguments()).append("> - ");
            } else {
                sb.append(" - ");
            }
            sb.append("*").append(c.getHelp()).append("*\n");
        }
        return sb;
    }

}
