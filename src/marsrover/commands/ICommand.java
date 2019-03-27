package marsrover.commands;

import marsrover.MarsRover;

public interface ICommand {
    public void execute(final MarsRover rover);
}
