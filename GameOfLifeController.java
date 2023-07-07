import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class GameOfLifeController {

	final int RECT_SIZE = 20;
	final int NUM_OF_RECTS = 10;
    @FXML
    private Canvas canv;    
    private GraphicsContext gc;
    private Matrix life;
       
    @FXML
    // update the matrix to the next generation
    void btnpressed(ActionEvent event) {
    	
    	// create empty board
    	gc.clearRect(0, 0, RECT_SIZE*NUM_OF_RECTS, RECT_SIZE*NUM_OF_RECTS);
    	for(int i=0;i<RECT_SIZE*NUM_OF_RECTS;i=i+RECT_SIZE) {
    		for(int j=0;j<RECT_SIZE*NUM_OF_RECTS;j=j+RECT_SIZE) {
    			gc.strokeRect(i, j, RECT_SIZE, RECT_SIZE);  			
    		}
    	}
    	
    	// update next generation
    	life = life.next(life);
    	for(int i=0;i<NUM_OF_RECTS;i++) {    		
    		for(int j=0;j<NUM_OF_RECTS;j++) {
    			if(life.getMatrix()[i][j] == true)
    				gc.fillRect(i*RECT_SIZE,j*RECT_SIZE,RECT_SIZE,RECT_SIZE);
    		}
    	}
    }
    
    // initialize random board
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    	
    	// create empty board
    	for(int i=0;i<RECT_SIZE*NUM_OF_RECTS;i=i+RECT_SIZE) {
    		for(int j=0;j<RECT_SIZE*NUM_OF_RECTS;j=j+RECT_SIZE) {
    			gc.strokeRect(i, j, RECT_SIZE, RECT_SIZE);
    			
    		}
    	}
    	// create random board
    	life = new Matrix(NUM_OF_RECTS);
    	life.randomBoard(life);
    	for(int i=0;i<NUM_OF_RECTS;i++) {
    		
    		for(int j=0;j<NUM_OF_RECTS;j++) {
    			if(life.getMatrix()[i][j] == true)
    				gc.fillRect(i*RECT_SIZE,j*RECT_SIZE,RECT_SIZE,RECT_SIZE);
    		}
    	}

    }
}
