package company_test;

import java.util.Random;

public class Grid { //������
	public final boolean status[][];
	private final int width;
	private final int height;
	
	private Snake snake;
	private Node food;
	//��ʼ��������Ϊ��
	private Direction snakeDirection = Direction.LEFT;
	private Direction newDirection;
	public Grid(int width,int height){//��ʼ�����棬��ʼ�����߲���ʼ����ʳ��
		this.width = width;
		this.height = height;
		status = new boolean[width][height];

		initSnake();
		createFood();
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Snake getSnake(){
		return this.snake;
	}
	
	public Node getFood(){
		return this.food;
	}
	
	//��ʼ������(����2)
	
	/*private Snake initSnake() {
        snake = new Snake();

        // your code here����һ��ѭ������Snake��Body���������̸���״̬
        int length = this.width / 3;
        int Y = height / 2;
        int X = width / 2;
        for (int i = 0; i < length; i++) {
            Node node = new Node(X, Y);
            status[X][Y] = true;
            X++;
            snake.addTail(node);
        }

        return snake;
    }*/
	
	
	private Snake initSnake(){
	  snake = new Snake();
		for(int i = width/2; i<=(5*width/6); i++){ //�����꣬�� ����֮һwidth �� ����֮һ������֮һ����Ϊheight/2   
			snake.addTail(new Node(i, height/2));
			status[i][height/2] = true;
		}
		return snake;
	}
	
	//����ʳ�﷽��2
	/*public Node createFood() {


        Random rand = new Random();
        food = new Node(rand.nextInt(width), rand.nextInt(height));
        return food;
    }*/
	
	public Node createFood(){//����ʳ��
		int x,y;
		//ʹ��Random��������x��y
		Random random = new Random();
		x = random.nextInt(width);
		y = random.nextInt(height);
		food = new Node(x, y);
		while(!validPosition(food)){
			x=(int)Math.random();
			y=(int)Math.random();
			food = new Node(x, y);
		}
		return food;
	}
	
	public void init(){//��ʼ����Ϸ
		for(int i = 0 ; i<width ; i++)
			for(int j=0 ; j<height ; j++){
				status[i][j] = false;
			}
		snakeDirection = Direction.LEFT;
		newDirection = Direction.LEFT;
		initSnake();
		createFood();
	}
	
	public boolean nextRound(){//��Ϊ��һ���Ƿ��ܹ�ִ��
		Node snakeTail = snake.move(snakeDirection);
		Node snakeHead = snake.getHead();
		if(validPosition(snakeHead)){//ͷ����λ���Ƿ���Ч
			if(isFood(snakeHead)){//ͷ��ԭ����ʳ��
				snake.addTail(snakeTail);
				createFood();
			}else
				dispose(snakeTail);
			occupy(snakeHead);
			newDirection = snakeDirection;
			return true;
		}
			return false;
	}
	
	public void changeDirection(Direction newdirection){//��ɾ��β��������̰���߷�����޸�
		if(this.newDirection.compatibleWith(newdirection)||this.newDirection == newdirection){
			snakeDirection = newdirection;
		}
	}
	
	//************************��������************************
	public boolean validPosition(Node area) {//�Ƿ�����Ч�Ŀռ�
        int x = area.getX(), y = area.getY();
        return x >= 0 && x < width && y >= 0 && y < height && !status[x][y];
    }

    private void dispose(Node node) {//�ͷ���Щλ��
        status[node.getX()][node.getY()] = false;
    }

    private void occupy(Node node) {//ռ����Щλ��
        status[node.getX()][node.getY()] = true;
    }

    public boolean isFood(Node area) {//��ʳ��
        int x = area.getX(), y = area.getY();
        return x == food.getX() && y == food.getY();
    }
	

}
