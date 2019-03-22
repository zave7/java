
public class TrumpCard extends Card {
	private int sizeOfClubs = 13;
	private int sizeOfDiamonds = 13;
	private int sizeOfHeart = 13;
	private int sizeOfSpade = 13;
	private char[] clubs = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	private char[] diamonds = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	private char[] heart = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	private char[] spade = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	public TrumpCard() {
		setTypeCard("Trump");
	}
	public char[] getTrumpCard() {
		char[] returnCard = {'\u0000','\u0000'};
		int type; //카드 타입 1~4
		boolean check = false;
		while(true) {
			type = getRandomType(4);
			switch(type) {
				case 0: 	if(sizeOfClubs>0) { 
							check = true;
							returnCard[0] = 'c';
							returnCard[1] = clubs[getRandomType(sizeOfClubs)];
							sortTrumpCard(returnCard[1]-48, type);
							} 
							break;
				case 1: 	if(sizeOfDiamonds>0) {
							check = true;
							returnCard[0] = 'd';
							returnCard[1] = diamonds[getRandomType(sizeOfDiamonds)];
							sortTrumpCard(returnCard[1]-48, type); 
							}
							break;
				case 2: 	if(sizeOfHeart>0) {
							check = true;
							returnCard[0] = 'h';
							returnCard[1] = heart[getRandomType(sizeOfHeart)];
							sortTrumpCard(returnCard[1]-48, type);
							}
							break;
				case 3:		if(sizeOfSpade>0) {
							check = true;
							returnCard[0] = 's';
							returnCard[1] = spade[getRandomType(sizeOfSpade)];
							sortTrumpCard(returnCard[1]-48, type);
							}
							break;
				default: 	System.out.println(returnCard[0] + ":" +returnCard[1]);	
							System.out.println("카드 리턴 오류");
			}
			if(check==true) 
				break;
		}
		return returnCard;
	}

	public int getRandomType(int num) {
		return (int) (Math.random() * num);
	}


//	public int getRandomCard(int x, int y) {
//
//		return (int) (Math.random() * x);
//	}
	public void sortTrumpCard(int num, int type) { //카드를 뽑으면 빈자리를 채워넣는 메소드
		int i = num;
		switch(type) {
			case 0: 
				if(num != sizeOfClubs) {
					for(i = num ; i <= sizeOfClubs; i++) {
						clubs[i] = clubs[i+1];
					}
				} else if(num == sizeOfClubs) {
					clubs[i] = '\u0000';
				}
				sizeOfClubs--;
				break;
			case 1: 
				if(num != sizeOfDiamonds) {
					for(i = num ; i <= sizeOfDiamonds; i++) {
						diamonds[i] = diamonds[i+1];
					}
				} else if(num == sizeOfDiamonds) {
					diamonds[i] = '\u0000';
				}
				sizeOfDiamonds--;
				break;
			case 2: 
				if(num != sizeOfHeart) {
					for(i = num ; i <= sizeOfHeart; i++) {
						heart[i] = heart[i+1];
					}
				} else if(num == sizeOfHeart) {
					heart[i] = '\u0000';
				}
				sizeOfHeart--;
				break;
			case 3: 
				if(num != sizeOfSpade) {
					for(i = num ; i <= sizeOfSpade; i++) {
						spade[i] = spade[i+1];
					}
				} else if(num == sizeOfSpade) {
					spade[i] = '\u0000';
				}
				sizeOfSpade--;
				break;
			default: System.out.println("정렬 오류");
		}
	}
	
}