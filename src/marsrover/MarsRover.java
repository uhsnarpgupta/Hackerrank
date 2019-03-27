package marsrover;

import marsrover.commands.ICommand;
import marsrover.parser.StringCommandParser;
import marsrover.universe.Coordinates;
import marsrover.universe.Direction;
import marsrover.universe.Plateau;

import java.util.List;

public class MarsRover {
    private Coordinates currentCoordinates;
    private Direction currentDirection;
    private Plateau plateau;


    public MarsRover(final Plateau plateau, final Direction direction, final Coordinates coordinates) {
        this.plateau = plateau;
        this.currentDirection = direction;
        this.currentCoordinates = coordinates;
    }

    public void run(final String commandString) {
        List<ICommand> roverCommands = new StringCommandParser(commandString).toCommands();
        for (ICommand command : roverCommands) {
            command.execute(this);
        }
    }

    public String currentLocation() {
        return currentCoordinates.toString() + " " + currentDirection.toString();
    }

    public void turnRight() {
        this.currentDirection = this.currentDirection.right();
    }

    public void turnLeft() {
        this.currentDirection = this.currentDirection.left();
    }

    public void move() {
        Coordinates positionAfterMove = currentCoordinates.newCoordinatesForStepSize(
                currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());

        //ignores the command if rover is being driven off plateau
        if (plateau.hasWithinBounds(positionAfterMove))
            currentCoordinates = currentCoordinates.newCoordinatesFor(currentDirection.stepSizeForXAxis(),
                    currentDirection.stepSizeForYAxis());
    }
}
