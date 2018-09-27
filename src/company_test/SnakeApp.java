package company_test;

import java.awt.*;
import javax.swing.*;

public class SnakeApp implements Runnable {//整个负责与用户交互的窗体
	public void run(){
		//初始化grid
		Grid grid = new Grid(Settings.DEFAULT_GRID_WIDTH/Settings.DEFAULT_NODE_SIZE, Settings.DEFAULT_GRID_HEIGHT/Settings.DEFAULT_NODE_SIZE);
		
		//创建窗体
		JFrame window = new JFrame("贪吃蛇");
		
		//增加内容的部件
		Container contentPane = window.getContentPane();
		
		//基于Grid初始化gamaView
		GameView gameView = new GameView(grid);
		gameView.init();
		
		//初始化GameController
		GameController gameController = new GameController(grid,gameView);
		window.addKeyListener(gameController);
		new Thread(gameController).start();;
		//设置gameView中JPanel的大小
		gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT));   
		
		//将gameView中JPanel加入到窗口中
		contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
		
		//渲染和显示窗口
		window.setLocationRelativeTo(null);
		window.setSize(Settings.DEFAULT_GRID_WIDTH,Settings.DEFAULT_GRID_HEIGHT);
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SnakeApp());
	}
}
