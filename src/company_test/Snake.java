package company_test;

import java.util.*;

public class Snake { //那条蛇
	
	private LinkedList<Node> body = new LinkedList<>();
	
	public Node eat(Node food){//蛇吃东西
		if(isNeighbor(body.getFirst(), food)){
			body.addFirst(food);
			return food;
		}else 
			return null;
	}
	
	public Node move(Direction direction){//蛇的移动		
		if(direction.compatibleWith(direction) && getHead().getX() >=0 && getHead().getY() >= 0){//不能乱变向，也不能超过0  
			switch (direction) {
			case DOWN:
				body.addFirst(new Node(getHead().getX(),getHead().getY()+1));
				return body.removeLast();
				
			case UP:
				body.addFirst(new Node(getHead().getX(),getHead().getY()-1));
				return body.removeLast();
				
			case LEFT:
				body.addFirst(new Node(getHead().getX()-1,getHead().getY()));
				return body.removeLast();
								
			case RIGHT:
				body.addFirst(new Node(getHead().getX()+1,getHead().getY()));
				return body.removeLast();
			}
			/*if(direction.equals(Direction.DOWN)){//向下运动
				body.addFirst(new Node(getHead().getX(),getHead().getY()+1));
			}
			if(direction.equals(Direction.UP)){//向上运动
				body.addFirst(new Node(getHead().getX(),getHead().getY()-1));
			}
			if(direction.equals(Direction.LEFT)){//向上运动
				body.addFirst(new Node(getHead().getX()-1,getHead().getY()));
			}
			if(direction.equals(Direction.RIGHT)){//向上运动
				body.addFirst(new Node(getHead().getX()+1,getHead().getY()));
			}
			body.removeLast();
			*/
		}
		return null;
	}
	
	public Node getHead(){//获取蛇的头部			
		return body.getFirst();
	}
	
	public LinkedList<Node> getBody(){//获取蛇的身体		
		return body;
	}
	
	public Node getTail(){//获取蛇的尾部			
		return body.getLast();
	}
	
	public Node addTail(Node n){//在尾部增加
		this.body.addLast(n);
		return n;
	}
	
	private boolean isNeighbor(Node a, Node b) {//判断是否相邻(即距离为1)
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }
	
	public static void main(String[] args) {//测试函数
		Node node = new Node(5, 6);
		Direction direction =Direction.DOWN;
		LinkedList<Node> linkedList = new LinkedList<Node>();
		linkedList.add(new Node(3, 4));
		Snake snake = new Snake();
	}
}
