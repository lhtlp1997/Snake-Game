package company_test;
import java.awt.*;
import javax.swing.*;

public class GameView {//ʹ��Graphics API��ͼ
	
	private final Grid grid;
	
	//����һ������
	private JPanel canvas;
	
	public GameView(Grid grid){
		this.grid = grid;
	}
	
	public JPanel getCanvas(){
		return this.canvas;
	}
	
	//��ʼ��canvas
	public void init() {
	    canvas = new JPanel() {
			private static final long serialVersionUID = 1L;
			@Override
			public void paintComponent(Graphics graphics) {
	            drawGridBackground(graphics);
	            drawSnake(graphics, grid.getSnake());
	            drawFood(graphics, grid.getFood());
	        }
	    };
	 }
	//��󣬻���������
	public void draw(){
		this.canvas.repaint();
	}
	//************************������ʵ��*********************
	
	 public void drawSnake(Graphics graphics, Snake snake) {
		 for(int i = 0 ;i<snake.getBody().size() ;i++){
			 drawSquare(graphics, snake.getBody().get(i), Settings.DEFAULT_SNAKE_COLOR);
		 }
	 }

	 public void drawFood(Graphics graphics, Node squareArea) {
		 drawCircle(graphics, squareArea, Settings.DEFAULT_FOOD_COLOR);
	 }

	 public void drawGridBackground(Graphics graphics) {//������
		 graphics.setColor(Settings.DEFAULT_BACKGROUND_COLOR);
		 graphics.fillRect(0, 0, Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT);
	 }
	//*******************************��������********************************************
	 
	 //������
	 private void drawSquare(Graphics graphics, Node squareArea, Color color) {
	        graphics.setColor(color);
	        int size = Settings.DEFAULT_NODE_SIZE;
	        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size - 1, size - 1);
	   }

	 
	 //��Ȧ
	 private void drawCircle(Graphics graphics, Node squareArea, Color color) {
	        graphics.setColor(color);
	        int size = Settings.DEFAULT_NODE_SIZE;
	        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
	    }
	 
	 
}
