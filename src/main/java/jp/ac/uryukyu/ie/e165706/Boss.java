package jp.ac.uryukyu.ie.e165706;
//import java.util.Scanner;

public class Boss extends LivingThing {
    public Boss(String name, int hitPoint, int attack, int magicPoint) {
        super(name, hitPoint, attack, magicPoint);// 必ず先頭で呼び出す

    }

    @Override
    public int attack_option(int damage, LivingThing opponent) {
        if (getHitPoint() >= 10) {
            if (damage == 0) {
                System.out.printf("%sの攻撃！...だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            } else {
                double hit = Math.random() * 100;
                if (hit >= 70) {
                    damage = damage * 2;
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%sのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                } else {
                    System.out.printf("%sに%dのダメージを与えた！！\n", opponent.getName(), damage);
                }
            }
        }else if(getHitPoint() >=6){
            Heal();
        }
        else{Magic_burst();}
        return damage;
    }
    public void battle_algorithm(int hitPoint){
        if (hitPoint >= 10){

        }
    }
}
