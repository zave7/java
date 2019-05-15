public class Guest {

    static int cnt;//class 변수
    String name;//instance 변수 인스턴스 멤버

    public Guest(String name) {
        this.name = name;
    }
    public int visit() {
        cnt++;
        return cnt;
    }
}
