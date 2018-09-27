package company_test;

import java.util.Random;

public class Grid { //棋盘类
	public final boolean status[][];
	private final int width;
	private final int height;
	
	private Snake snake;
	private Node food;
	//初始方向设置为左
	private Direction snakeDirection = Direction.LEFT;
	private Direction newDirection;
	public Grid(int width,int height){//初始化界面，初始这条蛇并开始创造食物
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
	
	//初始这条蛇(方法2)
	
	/*private Snake initSnake() {
        snake = new Snake();

        // your code here：用一个循环设置Snake的Body并更新棋盘覆盖状态
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
		for(int i = width/2; i<=(5*width/6); i++){ //横坐标，从 二分之一width 到 二分之一加三分之一，纵为height/2   
			snake.addTail(new Node(i, height/2));
			status[i][height/2] = true;
		}
		return snake;
	}
	
	//创造食物方法2
	/*public Node createFood() {


        Random rand = new Random();
        food = new Node(rand.nextInt(width), rand.nextInt(height));
        return food;
    }*/
	
	public Node createFood(){//创造食物
		int x,y;
		//使用Random类来设置x和y
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
	
	public void init(){//初始化游戏
		for(int i = 0 ; i<width ; i++)
			for(int j=0 ; j<height ; j++){
				status[i][j] = false;
			}
		snakeDirection = Direction.LEFT;
		newDirection = Direction.LEFT;
		initSnake();
		createFood();
	}
	
	public boolean nextRound(){//认为下一步是否能够执行
		Node snakeTail = snake.move(snakeDirection);
		Node snakeHead = snake.getHead();
		if(validPosition(snakeHead)){//头部的位置是否有效
			if(isFood(snakeHead)){//头部原来是食物
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
	
	public void changeDirection(Direction newdirection){//不删除尾部，进行贪吃蛇方向的修改
		if(this.newDirection.compatibleWith(newdirection)||this.newDirection == newdirection){
			snakeDirection = newdirection;
		}
	}
	
	//************************辅助方法************************
	public boolean validPosition(Node area) {//是否是有效的空间
        int x = area.getX(), y = area.getY();
        return x >= 0 && x < width && y >= 0 && y < height && !status[x][y];
    }

    private void dispose(Node node) {//释放哪些位置
        status[node.getX()][node.getY()] = false;
    }

    private void occupy(Node node) {//占用哪些位置
        status[node.getX()][node.getY()] = true;
    }

    public boolean isFood(Node area) {//是食物
        int x = area.getX(), y = area.getY();
        return x == food.getX() && y == food.getY();
    }
	

}
