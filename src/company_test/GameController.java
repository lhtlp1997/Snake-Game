package company_test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class GameController implements Runnable,KeyListener{//չʾ��ǰ��Ϸ�Ľ����״̬
	private Grid grid ;
	private GameView gameview;
	private boolean running;
	
	public GameController(Grid grid , GameView gameView) {
		// TODO Auto-generated constructor stub
		this.grid = grid;
		this.gameview = gameView;
		this.running = true;
	}
	@Override
	public void keyPressed(KeyEvent e) {//������
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		switch (keyCode) {
		
		case KeyEvent.VK_UP:
			grid.changeDirection(Direction.UP);
			break;
			
		case KeyEvent.VK_DOWN:
			grid.changeDirection(Direction.DOWN);
			break;
			
		case KeyEvent.VK_LEFT:
			grid.changeDirection(Direction.LEFT);
			break;
			
		case KeyEvent.VK_RIGHT:
			grid.changeDirection(Direction.RIGHT);
			break;
			
		case KeyEvent.VK_SPACE:
			if(running)
				running = false;
			else{
				running = true;
				new Thread(this).start();
			}
			break;
		case KeyEvent.VK_ENTER:
			if(!running){
				grid.init();
				running = true;
				new Thread(this).start();
			}else {
				running = true;
			}
			break;
		default:
			break;
		}
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running){
			try {
				Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
			} catch (InterruptedException e) {
				// TODO: handle exception
				break;
			}
			if(running){
				if(grid.nextRound()){
					gameview.draw();
				}else {
					running = false;
					showGameOverMessage();
				}
			}

		}
	}
	
	public void showGameOverMessage(){//չʾ��Ϸ�����ķ���
		JOptionPane.showMessageDialog(null, "��Ϸ����","��Ϸ����",JOptionPane.INFORMATION_MESSAGE);
	}
	
	//*****************************����Ҫ�õ��ķ���*************************
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
