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
    int pcount;
    int maxPcount;
    int startBusStop;
    int lastBusStop;
    public Bus(int maxPcount, int startBusStop, int lastBusStop) {
        this.maxPcount = maxPcount;
        this.startBusStop = startBusStop;
        this.lastBusStop = lastBusStop;
    }
    
    String getOn(int getCount, int busStop) {
        if(busStop == lastBusStop)
            return "������ �����忡���� ž�°��� ���� �� �����ϴ�";
        else if( busStop < startBusStop && busStop > busStop)
            return "�ش� ������ �������� �ƴϿ��� ž�� �� �� �����ϴ�";
        else if(getCount + pcount > maxPcount)
            return "���� ������ �ʰ��Ͽ� ���� " + (getCount + pcount - maxPcount) + "���� �������ϴ�"
        return pcount += count;
    }
       
    String getOut(int outCount, int busStop) {
        if(busStop == startBusStop)
            return "ù��° �����忡���� ���� �°��� ���� �� �����ϴ�";
        else if( busStop < startBusStop && busStop > busStop)
            return "�ش� ������ �������� �ƴϿ��� ���� �� �����ϴ�";
        return pcount -= outCount;
    }
}
