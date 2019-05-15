public class PointCard {

    int cnt=0;
    String name;

    public PointCard(String name) {
        this.name = name;
    }
    public int visit() {
        cnt++;
        return cnt;
    }
}
