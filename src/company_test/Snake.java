package company_test;

import java.util.*;

public class Snake { //������
	
	private LinkedList<Node> body = new LinkedList<>();
	
	public Node eat(Node food){//�߳Զ���
		if(isNeighbor(body.getFirst(), food)){
			body.addFirst(food);
			return food;
		}else 
			return null;
	}
	
	public Node move(Direction direction){//�ߵ��ƶ�		
		if(direction.compatibleWith(direction) && getHead().getX() >=0 && getHead().getY() >= 0){//�����ұ���Ҳ���ܳ���0  
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
			/*if(direction.equals(Direction.DOWN)){//�����˶�
				body.addFirst(new Node(getHead().getX(),getHead().getY()+1));
			}
			if(direction.equals(Direction.UP)){//�����˶�
				body.addFirst(new Node(getHead().getX(),getHead().getY()-1));
			}
			if(direction.equals(Direction.LEFT)){//�����˶�
				body.addFirst(new Node(getHead().getX()-1,getHead().getY()));
			}
			if(direction.equals(Direction.RIGHT)){//�����˶�
				body.addFirst(new Node(getHead().getX()+1,getHead().getY()));
			}
			body.removeLast();
			*/
		}
		return null;
	}
	
	public Node getHead(){//��ȡ�ߵ�ͷ��			
		return body.getFirst();
	}
	
	public LinkedList<Node> getBody(){//��ȡ�ߵ�����		
		return body;
	}
	
	public Node getTail(){//��ȡ�ߵ�β��			
		return body.getLast();
	}
	
	public Node addTail(Node n){//��β������
		this.body.addLast(n);
		return n;
	}
	
	private boolean isNeighbor(Node a, Node b) {//�ж��Ƿ�����(������Ϊ1)
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }
	
	public static void main(String[] args) {//���Ժ���
		Node node = new Node(5, 6);
		Direction direction =Direction.DOWN;
		LinkedList<Node> linkedList = new LinkedList<Node>();
		linkedList.add(new Node(3, 4));
		Snake snake = new Snake();
	}
}
