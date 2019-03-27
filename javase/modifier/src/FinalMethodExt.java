public class FinalMethodExt extends FinalMethod {
    @Override
    public void a() { //final method 는 override 불가
        x = 30;
    }
}
