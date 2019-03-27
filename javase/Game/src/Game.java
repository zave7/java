public abstract class Game {

	private String category;
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

    public abstract void startGame(); //게임 실행

    
    public abstract void exitGame();//게임 종료

}