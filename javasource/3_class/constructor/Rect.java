/*
1. 가로 width, 세로 height
2. 넓이 : calcArea()
   둘레 : calcRound()
*/
public class Rect {
    int width;
    int height;
    
    public Rect() {
        //this(4, 3);
        this.width = 4;
        this.height = 3;
    }

    public Rect(int width, int height) {
        this.width = width;
        this.height = width;
    }

    int calcArea() {
        return width * height;
    }
    int calcRound() {
        return (width + height) * 2;
    }
    
}
