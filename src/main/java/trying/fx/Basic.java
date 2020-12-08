package trying.fx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Basic extends Application implements EventHandler<KeyEvent>{
	
	final int WINDOW_WIDTH = 600;
    final int WINDOW_HEIGHT = 400;
	
    final double ballRadius = 40;
    double ballX = 100;
    double ballY = 200;
    double ballSpeedX = 4;
    double ballSpeedY = 0;
    
	public static void main(String[] args) {
		
		launch(args);
	}

	
	@Override
	public void start(Stage stage) throws Exception { 
		//Stage: top level frame. Può mostrare una Scene
		
		stage.setTitle("Basic JavaFX demo");
		
		//Group contiene una collezione di node
		Group root = new Group();
		//La scene mantiene un albero di Node, molti oggetti di FX sono node
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); //root e dimensione della finestra
		
		Circle greenCircle = createCircle(ballX, ballY, ballRadius, Color.GREEN);
		
		//Gestore eventi tastiera
		greenCircle.setFocusTraversable(true);
		greenCircle.requestFocus();
		greenCircle.setOnKeyPressed(this);
		
		//ritorna la collezione di nodi del root
		root.getChildren().add(greenCircle);
		
		stage.setScene(scene);
		stage.show();
		
		AnimationTimer animator = ballAnimation(greenCircle);
		
		animator.start();
	}
	
	@Override
	public void handle(KeyEvent arg0) {
		
		if(arg0.getCode() == KeyCode.UP) {
			
			ballSpeedY = ballSpeedY + 1;
			
        } else if(arg0.getCode() == KeyCode.DOWN) {
        	
        	ballSpeedY = ballSpeedY - 1;
        	
        }
		
	}
	
	private Circle createCircle(double centerX, double centerY, double radius, Color color) {
	
		Circle circle = new Circle();
		circle.setCenterX(centerX);
		circle.setCenterY(centerY);
		circle.setRadius(radius);
		circle.setFill(color);
		
		return circle;
	}
	
	
	private AnimationTimer ballAnimation(Circle greenCircle) {
		
		return new AnimationTimer() {

			//eseguito ripetitivamente 60 frame per secondo se possibile
			@Override
			public void handle(long arg0) {
				
				ballX = ballX + ballSpeedX;
				ballY = ballY + ballSpeedY;
				
				if(ballX + ballRadius >= WINDOW_WIDTH) { // sta uscendo sopra
					
					ballX = WINDOW_WIDTH - ballRadius;
					ballSpeedX = ballSpeedX * -1;
					
				} else if(ballX - ballRadius < 0) { // sta uscendo sotto
					
					ballX = 0 + ballRadius;
					ballSpeedX = ballSpeedX * -1;
					
				} else if(ballY + ballRadius >= WINDOW_HEIGHT) {
					
					ballY = WINDOW_HEIGHT - ballRadius;
					ballSpeedY = ballSpeedY * -1;
					
				} else if(ballY - ballRadius < 0) {
					
					ballY = 0 + ballRadius;
					ballSpeedY = ballSpeedY * -1;
					
				}
				
				greenCircle.setCenterX(ballX);
				greenCircle.setCenterY(ballY);
			}
			
		};
	}
	
}
