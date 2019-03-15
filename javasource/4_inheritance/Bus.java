/*

    �°��� pcount
        (�°����� -�� �� �� ���� 40�� �̳��� ������ �� �ִ�)
    Ÿ�� getOn(Ÿ�� �°� ��) ���� Ÿ�� : String
        (������ N���� �°� + ź �°� (��, ������ �����忡���� Ż ����� ����))
    ������ getOut(������ �°� ��) ���� Ÿ�� : String
        (������ N���� �°� - ���� �°� (��, ù �����忡���� ���� ����� ���� ������ �����忡���� ���� �°��� ��� ������ �Ѵ�))
    �ִ� ���� maxPcount
        (� ������ ���� �𸣱� ������ �ϴ��� �����Ҷ� �����ش�. �� ������ ���� ������ ���� ������ ����Ʈ �����ڴ� �̱���)
*/
public class Bus extends Car{
    int pcount; //ž�� �õ� �ο�
    int maxPcount; //���� ����
    int startBusStop; //ù��° ���� ������
    int lastBusStop; //������ ���� ������
    //int nowBusStop; //���� ������
    public Bus(int maxPcount, int startBusStop, int lastBusStop) {
        this.maxPcount = maxPcount;
        this.startBusStop = startBusStop;
        this.lastBusStop = lastBusStop;
    }
    
    String getOn(int busStop, int getCount) {
        if(busStop == lastBusStop)
            return "������ �����忡���� ž�°��� ���� �� �����ϴ�";
        else if( busStop < startBusStop || busStop > busStop)
            return "�ش� ������ �������� �ƴϿ��� ž�� �� �� �����ϴ�";
        else if(getCount + pcount > maxPcount)
            return "���� ������ �ʰ��Ͽ� " + (getCount + pcount - maxPcount) + "���� �������ϴ�";
        return busStop + "�� �����忡�� " + getCount + "���� ž���߰� ����" + (pcount += getCount) + "���� ž�����Դϴ�";
    }
       
    String getOut(int busStop, int outCount) {
        if(busStop == startBusStop)
            return "ù��° �����忡���� ���� �°��� ���� �� �����ϴ�";
        else if( busStop < startBusStop || busStop > lastBusStop)
            return "�ش� ������ �������� �ƴϿ��� ���� �� �����ϴ�";
        else if(pcount < outCount)
            return "ž�� �ο����� ���� �°��� ������ ���� ���� �� ���� ���Դϴ�";
        return busStop + "�� �����忡�� " + outCount + "���� �������Ƿ� " + (pcount -= outCount) + "���� ž�����Դϴ�.";
    }
    //busStopCheck() {
        
    //}
}
