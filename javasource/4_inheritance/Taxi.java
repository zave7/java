/*
1.  ���
    �⺻���(basicPrice)
        �Ϲ� 3000 
        �ɾ� 5000

    �����(totalPrice)
        
    ���(price)
        �Ϲ� 100/km
        �ɾ� 150/km

2.  ��ݰ��(calcPrice())
3.  �ɾ����� : 0�� ~ 6�� 
*/
import java.util.*;
public class Taxi extends Car{
    int basicPrice; 
    int totalPrice;
    int price;
    int incPerKm;
    Calendar calendar;
    
    public Taxi() {
        //super(); ���� �굵 ù��° ���࿡���� �۵��Ѵ�
    }    
    public Taxi(String carName, String color, String maker) {
        //super() ��⿡ ����
        super(carName, color, maker);
    }
    void initPrice() {
        calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if( hour <= 6 ) {
            basicPrice = 5800;
            incPerKm = 150;
        } else { 
            basicPrice = 3800;
            incPerKm = 100;
        }
        price = basicPrice;
    }
    void sumPrice(int km) {
        totalPrice += calcPrice(km);
        price = 0;
        basicPrice = 0;
    }
    int calcPrice(int km) {    
        price += km * incPerKm;
        return price;
    }
}