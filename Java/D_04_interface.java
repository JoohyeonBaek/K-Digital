class Unit {
	int currentHP;
	int x;
	int y;
}
// 인터페이스와 인터페이스의 관계는 상속 (extends)
// 인터페이스와 클래스와의 관계근 구현 (implements)
interface Movable { void move(int x, int y); }
interface Attackable { void attack(Unit u); }
interface Fightable extends Movable, Attackable{}

class Fighter extends Unit implements Fightable {
	public void move(int x, int y) {}
	public void attack(Unit u) {}
}

public class D_04_interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
