package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public abstract class GuidesCmd extends Command {
    // Sets all commands that inherits this class to be in the category of Guides
    public GuidesCmd() {
        this.category = new Category("Guides");
    }

    @Override
    protected void execute(CommandEvent e) {
        doCommand(e);
    }

    public abstract void doCommand(CommandEvent e);
}
