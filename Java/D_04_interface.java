class Unit {
	int currentHP;
	int x;
	int y;
}
// �������̽��� �������̽��� ����� ��� (extends)
// �������̽��� Ŭ�������� ����� ���� (implements)
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
