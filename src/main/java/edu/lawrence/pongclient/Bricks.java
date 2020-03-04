package edu.lawrence.pongclient;

import static edu.lawrence.pongclient.PongConstants.MARGIN;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Bricks implements PongConstants{
    private List<Rectangle> shapes;
    Rectangle brick;
    Rectangle brick1;
    Rectangle brick2;
    Rectangle brick3;
    Rectangle brick4;
    Rectangle brick5;
    
    public Bricks(){
        shapes = new ArrayList<Rectangle>();
        brick = new Rectangle();
        brick.setX(MARGIN);
        brick.setY(50);
        brick.setWidth(90);
        brick.setHeight(20);
        brick.setArcWidth(5);
        brick.setArcHeight(5);
        shapes.add(brick);
        brick1 = new Rectangle();
        brick1.setX(MARGIN+102);
        brick1.setY(50);
        brick1.setWidth(90);
        brick1.setHeight(20);
        brick1.setArcWidth(5);
        brick1.setArcHeight(5);
        shapes.add(brick1);
        brick2 = new Rectangle();
        brick2.setX(MARGIN+204);
        brick2.setY(50);
        brick2.setWidth(90);
        brick2.setHeight(20);
        brick2.setArcWidth(5);
        brick2.setArcHeight(5);
        shapes.add(brick2);
        brick3 = new Rectangle();
        brick3.setX(MARGIN+306);
        brick3.setY(50);
        brick3.setWidth(90);
        brick3.setHeight(20);
        brick3.setArcWidth(5);
        brick3.setArcHeight(5);
        shapes.add(brick3);
        brick4 = new Rectangle();
        brick4.setX(MARGIN+408);
        brick4.setY(50);
        brick4.setWidth(90);
        brick4.setHeight(20);
        brick4.setArcWidth(5);
        brick4.setArcHeight(5);
        shapes.add(brick4);
        brick5 = new Rectangle();
        brick5.setX(MARGIN+510);
        brick5.setY(50);
        brick5.setWidth(90);
        brick5.setHeight(20);
        brick5.setArcWidth(5);
        brick5.setArcHeight(5);
        shapes.add(brick5);        
    }
    
    public List<Rectangle> getBricks(){return shapes;}
}
