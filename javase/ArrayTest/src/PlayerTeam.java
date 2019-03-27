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
public class PlayerTeam {
	public static void main(String[] args) {
		
		PlayerDto player[] = new PlayerDto[5];
		PlayerDto t1 = new PlayerDto(24,"오재원", 4, 0.321);
		PlayerDto t2 = new PlayerDto(13, "허경민", 5, 0.351);
		PlayerDto t3 = new PlayerDto(34, "린드블럼", 1, 0.001);
		PlayerDto t4 = new PlayerDto(9, "페르난데스", 3, 0.421);
		PlayerDto t5 = new PlayerDto(38, "김대한", 7, 0.384);
		player[0] = t1;
		player[1] = t2;
		player[2] = t3;
		player[3] = t4;
		player[4] = t5;
		
		int len = player.length; //for문에서 한번에 비교하지 마라 변수에 저장해서 비교
		for (int i = 0; i < len; i++) {
			System.out.println(player[i]);
		}
	}
}
