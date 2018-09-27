package company_test;


//贪吃蛇前进的方向
public enum Direction{
	UP(0),
	RIGHT(1),
	DOWN(2),
	LEFT(3);
	
	//directionCode的定义
	private final int directionCode;
	
	//返回私有成员变量
	public int directionCode(){
		return directionCode;
	}
	
	
	//构造函数
	Direction(int directionCode){
		this.directionCode = directionCode;
	}
	
	//判断方向改变是否有效，从上往下为无效，从左往右为无效
	public boolean compatibleWith(Direction direction) {
		if(Math.abs(this.directionCode - direction.directionCode) ==2)  {
			return false;		
		}
		else{
			return true;	
		}
			
    }
	

	//主方法
	public static void main(String[] args) {
		/*   这一部分是 compatibleWith(Direction direction)的测试函数
		Direction direction = Direction.UP;
		direction.compatibleWith(DOWN);
		*/
	}
}
