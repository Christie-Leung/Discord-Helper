package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public abstract class GuidesCmd extends Command {
    public GuidesCmd() {
        this.category = new Category("Guides");
    }

    @Override
    protected void execute(CommandEvent e) {
        doCommand(e);
    }

    public abstract void doCommand(CommandEvent e);
}
