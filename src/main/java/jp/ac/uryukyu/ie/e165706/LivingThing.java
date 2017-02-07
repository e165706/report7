package jp.ac.uryukyu.ie.e165706;
import java.util.Random;

public  abstract class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private int magicPoint;
    private boolean dead;

    public LivingThing(String name, int maximumHP, int attack, int maximumMP) {
        this.name = name;
        hitPoint = maximumHP;
        magicPoint = maximumMP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%d。MPは%dです。\n", name, maximumHP, attack, maximumMP);
    }
    /*
    以下getter/setter
     */
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }
    /*
    以下呪文メソッド
    それぞれのメソッド内においてMPが0以下の場合は呪文が唱えらないようにif文を用い,分岐させた。
     */
    public int Heal() {
        if (magicPoint <=0){
            System.out.printf("%sはホイミを唱えようとしたがMPが足りなくて唱えられなかった!!",getName());
            return 0;
        }else {
            /*
            HPを乱数の10倍+乱数の10倍回復する。
            消費MPは3
             */
            int heal = (int) (Math.random() * 10 + Math.random() * 10);
            System.out.printf("%sはホイミを唱えた!!", getName());
            System.out.printf("HPを%d回復した!!\n", heal);
            hitPoint += heal;
            magicPoint -= 3;
            return heal;
        }
    }

    public int mini_fire(int damage) {
        if (magicPoint <=0){
            System.out.printf("%sはメラを唱えようとしたがMPが足りなくて唱えられなかった!!",getName());
            return 0;
        }else{
            /*
            5~8のダメージを相手に与える
            消費MPは3
             */
            damage = (int) (Math.floor(Math.random() * (8 - 5 + 1)) + 5);
            magicPoint -= 3;
            return damage;
        }
    }

    public int Magic_burst(int damage) {
        if (magicPoint <=0){
            System.out.printf("%sはマダンテを唱えようとしたがMPが足りなくて唱えられなかった!!",getName());
            return 0;
        }else{
            /*
            残りMPの1.5倍のダメージを相手に与える。
            消費MPは残りのMP全て
             */
            damage = (int) (magicPoint * 1.5);
            System.out.printf("%sのダメージ!!\n", damage);
            magicPoint -= magicPoint;
            return damage;
        }
    }

    /*
    以下アタックメソッド
     */
    public void attack(LivingThing opponent) {
        if (dead == false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！\n", name);
            damage = attack_option(damage, opponent);
            opponent.wounded(damage, name);
        } else {
            dead = true;
        }
    }
    /*
    以下アタックオプションメソッド
    抽象メソッドを用い,中の機能はそれぞれのクラス内に記述
    */
    public abstract int attack_option(int damage, LivingThing opponent);


    //以下bossのみが使うレポート攻撃メソッド
    public  int report(int damage){
        damage = (int) (Math.floor(Math.random() * (10 - 5 + 1)) + 5);
        return damage;
    }

    /*
    以下メソッドでHPからダメージを引いたり,死亡判定(HPが0より大きいか否か)を行っている
     */
    public void wounded(int damage, String name) {
        hitPoint -= damage;
        name = getName();
        if (hitPoint <= 0) {
            dead = true;
            if (getName() == "naltoma") {
                System.out.println("ゲームクリア!!");
            } else {
                System.out.printf("%sは倒れた!!\n", name);
            }
        }
    }
}