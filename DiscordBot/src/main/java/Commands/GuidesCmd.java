package Commands;

import com.github.ygimenez.exception.InvalidHandlerException;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public abstract class GuidesCmd extends Command {
    public GuidesCmd() {
        this.category = new Category("Guides");
    }

    @Override
    protected void execute(CommandEvent e) {
        try {
            doCommand(e);
        } catch (InvalidHandlerException invalidHandlerException) {
            invalidHandlerException.printStackTrace();
        }
    }

    public abstract void doCommand(CommandEvent e) throws InvalidHandlerException;
}
