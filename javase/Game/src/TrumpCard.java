
public class TrumpCard extends Card {
	private int sizeOfClubs = 12;
	private int sizeOfDiamonds = 12;
	private int sizeOfHeart = 12;
	private int sizeOfSpade = 12;
	private boolean check = false;
	private char[] clubs = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	private char[] diamonds = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	private char[] heart = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	private char[] spade = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};

	public TrumpCard() {
		setTypeCard("Trump");
	}
	public char[] getTrumpCard() {
		char[] returnCard = new char[2];
		int[] selectCard = getRandomCard(4); //카드 타입 1~4
		int selectNum;
		while(true) { 
			switch(type) {
				case 0: 	if(sizeOfClubs==)
							selectNum = getRandomCard(sizeOfClubs);
							returnCard[1] = clubs[selectNum];
							sortTrumpCard(selectNum, sizeOfClubs);
							sizeOfClubs--;
							break;
				case 1: 	selectNum = getRandomCard(sizeOfDiamonds);
							returnCard[1] = diamonds[selectNum];
							sortTrumpCard(selectNum, sizeOfClubs);
							sizeOfDiamonds--;
							break;
				case 2: 	selectNum = getRandomCard(sizeOfHeart);
							returnCard[1] = heart[selectNum];
							sortTrumpCard(selectNum, sizeOfClubs);
							sizeOfHeart--;
							break;
				case 3:		selectNum = getRandomCard(sizeOfSpade);
							returnCard[1] = spade[selectNum];
							sortTrumpCard(selectNum, sizeOfClubs);
							sizeOfSpade--;
							break;
				default:	System.out.println("알 수 없는 오류");
						 	System.exit(0);
			}
		}
		returnCard[0] = trumpCard[0][intType];
		return returnCard;
	}

	public int[] getRandomCard(int num) {
		int[] card = new int[2];
		int n = (int) (Math.random() * num) + 1;
		int x = (int) (Math.random() * 4) + 1;
		card[1] = n; 
		switch(x) {
			case 1: card[0] = 'c'; 
			case 2:	card[0] = 'd';
			case 3: card[0] = 'h';
			case 4: card[0] = 's';
			default: System.out.println("알 수 없는 오류");
					 System.exit(0);
		}
		return card;
	}

	public int getRandomCard(int x, int y) {

		return (int) (Math.random() * x);
	}
	public void sortTrumpCard(int num, int size) { //카드를 뽑으면 빈자리를 채워넣는 메소드
		int i = num;
		if(num != size) {
			for(i = num ; i <= sizeOfClubs; i++) {
				select[i] = select[i+1];
				//System.out.println(trumpCard[i-1][type]);
			}
		} else if(num == size) {
			select[i] = '\u0000';
		}
	}
	public int getSizeOfClubs() {
		return sizeOfClubs;
	}
	public void setSizeOfClubs(int sizeOfClubs) {
		this.sizeOfClubs = sizeOfClubs;
	}
	public int getSizeOfDiamonds() {
		return sizeOfDiamonds;
	}
	public void setSizeOfDiamonds(int sizeOfDiamonds) {
		this.sizeOfDiamonds = sizeOfDiamonds;
	}
	public int getSizeOfHeart() {
		return sizeOfHeart;
	}
	public void setSizeOfHeart(int sizeOfHeart) {
		this.sizeOfHeart = sizeOfHeart;
	}
	public int getSizeOfSpade() {
		return sizeOfSpade;
	}
	public void setSizeOfSpade(int sizeOfSpade) {
		this.sizeOfSpade = sizeOfSpade;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public char[] getClubs() {
		return clubs;
	}
	public void setClubs(char[] clubs) {
		this.clubs = clubs;
	}
	public char[] getDiamonds() {
		return diamonds;
	}
	public void setDiamonds(char[] diamonds) {
		this.diamonds = diamonds;
	}
	public char[] getHeart() {
		return heart;
	}
	public void setHeart(char[] heart) {
		this.heart = heart;
	}
	public char[] getSpade() {
		return spade;
	}
	public void setSpade(char[] spade) {
		this.spade = spade;
	}
	
}