package edu.lawrence.pongclient;

import static edu.lawrence.pongclient.PongConstants.MARGIN;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.paint.Color.BLUE;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Bricks implements PongConstants{
    private List<Rectangle> shapes;
    Brick brick1;
    Brick brick2;
    Brick brick3;
    Brick brick4;
    Brick brick5;
    Brick brick6;
    
    public Bricks(){
        shapes = new ArrayList<Rectangle>();
        brick1 = new Brick(MARGIN);
        shapes.add(brick1);
        brick2 = new Brick(MARGIN+102);
        shapes.add(brick2);
        brick3 = new Brick(MARGIN+204);
        shapes.add(brick3);
        brick4 = new Brick(MARGIN+306);
        shapes.add(brick4);
        brick5 = new Brick(MARGIN+408);
        shapes.add(brick5);    
        brick6 = new Brick(MARGIN+510);
        shapes.add(brick6);    
    }
    
    public List<Rectangle> setColors(int counter1, int counter2, int counter3, int counter4, int counter5, int counter6) {
        if (counter1 == 1)
            brick1.setFill(BLUE);
        if (counter2 == 1)
            brick2.setFill(BLUE);
        if (counter3 == 1)
            brick3.setFill(BLUE);
        if (counter4 == 1)
            brick4.setFill(BLUE);
        if (counter5 == 1)
            brick5.setFill(BLUE);
        if (counter6 == 1)
            brick6.setFill(BLUE);
        return shapes;
    }
    
    public List<Rectangle> getBricks(){return shapes;}
}
