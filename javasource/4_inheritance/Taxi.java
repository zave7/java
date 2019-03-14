/*
1.  요금
    기본요금(basicPrice)
        일반 3000 
        심야 5000

    요금합(totalPrice)
        
    요금(price)
        일반 100/km
        심야 150/km

2.  요금계산(calcPrice())
3.  심야할증 : 0시 ~ 6시 
*/
import java.util.*;
public class Taxi extends Car{
    int basicPrice; 
    int totalPrice;
    int price;
    int incPerKm;
    Calendar calendar;
    
    public Taxi() {
        //super(); 생략 얘도 첫번째 실행에서만 작동한다
    }    
    public Taxi(String carName, String color, String maker) {
        //super() 요기에 생략
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