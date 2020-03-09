package edu.lawrence.pongclient;

import static edu.lawrence.pongclient.PongConstants.MARGIN;
import java.util.ArrayList;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.ORANGE;
import static javafx.scene.paint.Color.TRANSPARENT;
import static javafx.scene.paint.Color.YELLOW;
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
    
    public void setFill(int timesHit) {
        switch(timesHit){
            case 1:
                this.setFill(GREEN);
                break;
            case 2:
                this.setFill(ORANGE);
                break;
            case 3:
                this.setFill(YELLOW);
                break;
            case 4:
                this.setFill(TRANSPARENT);
        }
        //for when it's been hit 4 times, change the server side to ignore the brick
    }
    
}
