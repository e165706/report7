package jp.ac.uryukyu.ie.e165706;
import java.util.Scanner;

public class Hero extends LivingThing {
    public Hero(String name, int hitPoint, int attack) {
        super(name, hitPoint, attack);// 必ず先頭で呼び出す
    }

    @Override
    public int attack_option(int damage, LivingThing opponent) {
        System.out.println("戦う:1/逃げる:2\nコマンドを入力してください。:");
        Scanner sc = new Scanner(System.in);
        int comand = sc.nextInt();
        if (comand == 1) {
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
            return damage;
        } else if (comand == 2) {

            escape(opponent.getName());
            return 0;
        } else {
            attack_option(damage,opponent);
        }

    return 0;
    }

    public static void escape(String monster) {
        double value = Math.random() * 100;
        if (monster == "スライム") {
            if (value >=70) {
                System.out.println("勇者は逃げ出した!!");
            } else {
                System.out.println("勇者は逃げようとしたが,回り込まれてしまった!!");
            }
        }
    }


}
