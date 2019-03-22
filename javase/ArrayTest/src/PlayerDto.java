//Dto : Data Transfer Object
//vo : value object
//Bean : 껍데기
//0 지명타자
//1 투수
//2 포수
//3 1루수
//4 2루수
//5 3루수
//6 유격수
//7 좌익수
//8 중견수
//9 우익수
//타자 : 타율
//투수 : 방어율
public class PlayerDto {
	private int number;
	private String name;
	private int position;
	private double grade;
	private String[] positionStr = {"지명타자", "투수", "포수", "1루수", "2루수", "3루수", "유격수", "좌익수", "중견수", "우익수"};
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
		return "PlayerDto [등번호=" + number + ",\t\t선수명=" + name + "\t\t" + "포지션=" + positionStr[position] + "\t" + (position == 1 ? "방어율" : "타율") + grade + "]";
	}
	
}