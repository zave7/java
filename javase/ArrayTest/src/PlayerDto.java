//Dto : Data Transfer Object
//vo : value object
//Bean : ������
//0 ����Ÿ��
//1 ����
//2 ����
//3 1���
//4 2���
//5 3���
//6 ���ݼ�
//7 ���ͼ�
//8 �߰߼�
//9 ���ͼ�
//Ÿ�� : Ÿ��
//���� : �����
public class PlayerDto {
	private int number;
	private String name;
	private int position;
	private double grade;
	private String[] positionStr = {"����Ÿ��", "����", "����", "1���", "2���", "3���", "���ݼ�", "���ͼ�", "�߰߼�", "���ͼ�"};
	public PlayerDto(int number, String name, int position, double grade) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.grade = grade;
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "PlayerDto [���ȣ=" + number + ",\t\t������=" + name + "\t\t" + "������=" + positionStr[position] + "\t" + (position == 1 ? "�����" : "Ÿ��") + grade + "]";
	}
	
}