/*
1. 체력 hp 100, 모드 (0 : 일반모드, 1 : 흥분)
2. 공격 attack()
    1회 공격당 적체력 ( 0 : -10, 1 : -15)
   모드변경 changeMode()
    내 체력 -25;
    내 체력 40이하일 경우는 변경 불가
*/
public class Marine {
    int hp;
    int mode;
    int power;

    public Marine() {
        this.hp = 100;
        this.mode = 0;
        this.power = 10;
    }

    void attack(Marine com, int count) {
            com.setHp(-power * count);
    }

    void changeMode() {
        if(hp > 40) {
            if(mode == 0) {
                mode = 1;
                hp -= 25;
                power = 15;
            } else {
                mode = 0;
                power = 10;
            }
        } else {
            System.out.println("경고 : 모드 변경 불가~!!!!");
        }
    }

    void setHp(int hp) {
        this.hp += hp;
    }

    String getHp() {
        return hp <= 0 ? "die" : hp + "";
    }
}