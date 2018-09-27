package company_test;

import java.awt.*;
import javax.swing.*;

public class SnakeApp implements Runnable {//�����������û������Ĵ���
	public void run(){
		//��ʼ��grid
		Grid grid = new Grid(Settings.DEFAULT_GRID_WIDTH/Settings.DEFAULT_NODE_SIZE, Settings.DEFAULT_GRID_HEIGHT/Settings.DEFAULT_NODE_SIZE);
		
		//��������
		JFrame window = new JFrame("̰����");
		
		//�������ݵĲ���
		Container contentPane = window.getContentPane();
		
		//����Grid��ʼ��gamaView
		GameView gameView = new GameView(grid);
		gameView.init();
		
		//��ʼ��GameController
		GameController gameController = new GameController(grid,gameView);
		window.addKeyListener(gameController);
		new Thread(gameController).start();;
		//����gameView��JPanel�Ĵ�С
		gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT));   
		
		//��gameView��JPanel���뵽������
		contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
		
		//��Ⱦ����ʾ����
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
