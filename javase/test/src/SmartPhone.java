public class SmartPhone {

    private String maker;
    private String name;
    private int price;
    private int discountRate;

    public SmartPhone(String maker, String name, int price) {
        this.maker = maker;
        this.name = name;
        this.price = price;
    }

    public SmartPhone(String maker, String name, int price, int discountRate) {
        this(maker, name, price);
        this.discountRate = discountRate;
    }

    public int calculateDiscount() {
        price -= (int)(price * (discountRate / 100));
        return price;
    }
    public String getMaker() {
        return maker;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    void printDiscountPrice() {
        if(discountRate != 0) {
            System.out.println("할인가격 : " + (price - (price * discountRate / 100)));
        }
    }
}
