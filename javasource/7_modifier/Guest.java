public class Guest {

    static int cnt;//class ����
    String name;//instance ���� �ν��Ͻ� ���

    public Guest(String name) {
        this.name = name;
    }
    public int visit() {
        cnt++;
        return cnt;
    }
}
