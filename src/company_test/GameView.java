package company_test;
import java.awt.*;
import javax.swing.*;

public class GameView {//使用Graphics API画图
	
	private final Grid grid;
	
	//设置一个布局
	private JPanel canvas;
	
	public GameView(Grid grid){
		this.grid = grid;
	}
	
	public JPanel getCanvas(){
		return this.canvas;
	}
	
	//初始化canvas
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
	//最后，画整个布局
	public void draw(){
		this.canvas.repaint();
	}
	//************************方法的实现*********************
	
	 public void drawSnake(Graphics graphics, Snake snake) {
		 for(int i = 0 ;i<snake.getBody().size() ;i++){
			 drawSquare(graphics, snake.getBody().get(i), Settings.DEFAULT_SNAKE_COLOR);
		 }
	 }

	 public void drawFood(Graphics graphics, Node squareArea) {
		 drawCircle(graphics, squareArea, Settings.DEFAULT_FOOD_COLOR);
	 }

	 public void drawGridBackground(Graphics graphics) {//画背景
		 graphics.setColor(Settings.DEFAULT_BACKGROUND_COLOR);
		 graphics.fillRect(0, 0, Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT);
	 }
	//*******************************辅助方法********************************************
	 
	 //画方块
	 private void drawSquare(Graphics graphics, Node squareArea, Color color) {
	        graphics.setColor(color);
	        int size = Settings.DEFAULT_NODE_SIZE;
	        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size - 1, size - 1);
	   }

	 
	 //画圈
	 private void drawCircle(Graphics graphics, Node squareArea, Color color) {
	        graphics.setColor(color);
	        int size = Settings.DEFAULT_NODE_SIZE;
	        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
	    }
	 
	 
}
