package edu.lawrence.pongclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Joe Gregg
 */
public class GameGateway implements PongConstants {
    private PrintWriter outputToServer;
    private BufferedReader inputFromServer;
    private List<Shape> shapes;
    Rectangle redPaddle;//left
    Rectangle bluePaddle;//right
    Circle ball;
    Circle ball2;
    boolean isOpen = true;
    Bricks bricks = new Bricks();
    
    public GameGateway() {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an output stream to send data to the server
            outputToServer = new PrintWriter(socket.getOutputStream());

            // Create an input stream to read data from the server
            inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException ex) {
            System.out.println("Exception in GameGateway.");
            ex.printStackTrace();
        }
        
        // Make the shapes
        shapes = new ArrayList<Shape>();
        redPaddle = new Rectangle(MARGIN+20,WIDTH+ MARGIN+200,THICKNESS+10,LENGTH-20);
        redPaddle.setFill(Color.RED);
        shapes.add(redPaddle);
        bluePaddle = new Rectangle(MARGIN +40,WIDTH+ MARGIN+200,THICKNESS+10,LENGTH-20);
        bluePaddle.setFill(Color.BLUE);
        shapes.add(bluePaddle);
        ball = new Circle(WIDTH/3,HEIGHT/5,MARGIN/5);
        ball.setFill(Color.RED);
        ball2 = new Circle(WIDTH/3,HEIGHT/5,MARGIN/7);
        ball2.setFill(Color.BLUE);
        shapes.add(ball);
        shapes.add(ball2);
        
        //Add the bricks
        for (Rectangle i : bricks.getBricks()) {
            shapes.add(i);
        }
    }
    
    public List<Shape> getShapes() { return shapes; }
    
    // Move the player's paddle
    public synchronized void movePaddle(boolean Left) {
        if(Left)
            outputToServer.println(MOVE_LEFT);
        else
            outputToServer.println(MOVE_RIGHT);
        outputToServer.flush();
    }

    // Refresh the game state
    public synchronized void refresh() {
        outputToServer.println(GET_GAME_STATE);
        outputToServer.flush();
        String state = "";
        try {
            state = inputFromServer.readLine();
        } catch (IOException ex) {
            System.out.println("Exception in GameGateway.");
            ex.printStackTrace();
        }
        String parts[] = state.split(" ");
        ball.setCenterX(Double.parseDouble(parts[0]));
        ball.setCenterY(Double.parseDouble(parts[1]));
        ball2.setCenterX(Double.parseDouble(parts[2]));
        ball2.setCenterY(Double.parseDouble(parts[3]));
        redPaddle.setX(Double.parseDouble(parts[4]));
        bluePaddle.setX(Double.parseDouble(parts[5]));
    }
    
    public void close() {
        try {
        outputToServer.close();
        inputFromServer.close();
        } catch(Exception ex) {
            
        }
        isOpen = false;
    }
    
    public boolean open() { return isOpen; }
}
