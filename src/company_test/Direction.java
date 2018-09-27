package company_test;


//̰����ǰ���ķ���
public enum Direction{
	UP(0),
	RIGHT(1),
	DOWN(2),
	LEFT(3);
	
	//directionCode�Ķ���
	private final int directionCode;
	
	//����˽�г�Ա����
	public int directionCode(){
		return directionCode;
	}
	
	
	//���캯��
	Direction(int directionCode){
		this.directionCode = directionCode;
	}
	
	//�жϷ���ı��Ƿ���Ч����������Ϊ��Ч����������Ϊ��Ч
	public boolean compatibleWith(Direction direction) {
		if(Math.abs(this.directionCode - direction.directionCode) ==2)  {
			return false;		
		}
		else{
			return true;	
		}
			
    }
	

	//������
	public static void main(String[] args) {
		/*   ��һ������ compatibleWith(Direction direction)�Ĳ��Ժ���
		Direction direction = Direction.UP;
		direction.compatibleWith(DOWN);
		*/
	}
}
