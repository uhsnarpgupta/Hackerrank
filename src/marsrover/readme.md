### Introduction
--------------------

This problem used to be a coding assignment at ThoughtWorks' interview coding round. With this repository and a series of blog posts here I use this problem to demonstrate application of OO concepts and design patterns. 

Feel free to use it in any way you like. Reach out to me at "priyaaank [at] gmail" for any feedback or comments.

The complete write-up rationalizing the code is in a series of blog (mentioned below):

[Decoding ThoughtWorks' coding problem](http://priyaaank.tumblr.com/post/95095165285/decoding-thoughtworks-coding-problems)

[Objects that talk domain](http://priyaaank.tumblr.com/post/95095193545/objects-that-talk-domain)

[Objects that are loose and discrete](http://priyaaank.tumblr.com/post/95095211355/objects-that-are-loose-discrete)

[Design patterns for win](http://priyaaank.tumblr.com/post/95095221320/design-patterns-for-win)

[Reinforced design with TDD](http://priyaaank.tumblr.com/post/95095229180/reinforced-design-with-tdd)

And other personal musings at my [blog](http://priyaaank.tumblr.com/)


### Mars Rovers thoughtworks puzzles
--------------------

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

#### INPUT:

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

#### OUTPUT:

The output for each rover should be its final co-ordinates and heading.

#### INPUT AND OUTPUT:

##### Test Input:
5 5

1 2 N

LMLMLMLMM

3 3 E

MMRMMRMRRM

##### Expected Output:

1 3 N

5 1 E