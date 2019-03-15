/*

    승객수 pcount
        (승객수는 -가 될 수 없고 40명 이내만 수용할 수 있다)
    타다 getOn(타는 승객 수) 리턴 타입 : String
        (기존의 N명의 승객 + 탄 승객 (단, 마지막 정류장에서는 탈 사람이 없다))
    내리다 getOut(내리는 승객 수) 리턴 타입 : String
        (기존의 N명의 승객 - 내린 승객 (단, 첫 정류장에서는 내릴 사람이 없고 마지막 정류장에서는 남은 승객이 모두 내려야 한다))
    최대 정원 maxPcount
        (어떤 버스가 될지 모르기 때문에 일단은 생성할때 정해준다. 또 정원이 없는 버스는 없기 때문에 디폴트 생성자는 미구현)
*/
public class Bus extends Car{
    int pcount; //탑승 시도 인원
    int maxPcount; //버스 정원
    int startBusStop; //첫번째 버스 정류장
    int lastBusStop; //마지막 버스 정류장
    //int nowBusStop; //현재 정류장
    public Bus(int maxPcount, int startBusStop, int lastBusStop) {
        this.maxPcount = maxPcount;
        this.startBusStop = startBusStop;
        this.lastBusStop = lastBusStop;
    }
    
    String getOn(int busStop, int getCount) {
        if(busStop == lastBusStop)
            return "마지막 정류장에서는 탑승객이 있을 수 없습니다";
        else if( busStop < startBusStop || busStop > busStop)
            return "해당 버스의 정류장이 아니여서 탑승 할 수 없습니다";
        else if(getCount + pcount > maxPcount)
            return "버스 정원을 초과하여 " + (getCount + pcount - maxPcount) + "명은 못탔습니다";
        return busStop + "번 정류장에서 " + getCount + "명이 탑승했고 현재" + (pcount += getCount) + "명이 탑승중입니다";
    }
       
    String getOut(int busStop, int outCount) {
        if(busStop == startBusStop)
            return "첫번째 정류장에서는 내릴 승객이 있을 수 없습니다";
        else if( busStop < startBusStop || busStop > lastBusStop)
            return "해당 버스의 정류장이 아니여서 내릴 수 없습니다";
        else if(pcount < outCount)
            return "탑승 인원보다 많은 승객이 내리는 것은 있을 수 없는 일입니다";
        return busStop + "번 정류장에서 " + outCount + "명이 내렸으므로 " + (pcount -= outCount) + "명이 탑승중입니다.";
    }
    //busStopCheck() {
        
    //}
}
