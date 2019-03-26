package behavioural.template.game;

public class TemplatePatternDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class c = Class.forName(args[0]);
        Game game = (Game) c.newInstance();
        game.play();
    }
}

/*
A Template Pattern says that "just define the skeleton of a function in an operation, deferring some steps to its subclasses".

Benefits:
It is very common technique for reusing the code.This is only the main benefit of it.

Usage:
It is used when the common behavior among sub-classes should be moved to a single common class by avoiding the duplication.
 */