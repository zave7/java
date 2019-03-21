public abstract class Game {

	private String category;
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

    public abstract void startGame(); //���� ����

    
    public abstract void exitGame();//���� ����

}