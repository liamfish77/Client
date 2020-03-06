package edu.lawrence.pongclient;

import static edu.lawrence.pongclient.PongConstants.MARGIN;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle {
    
    public Brick(double xCoord){
        this.setX(xCoord);
        this.setY(50);
        this.setWidth(90);
        this.setHeight(20);
        this.setArcWidth(5);
        this.setArcHeight(5);
    }
    
}
