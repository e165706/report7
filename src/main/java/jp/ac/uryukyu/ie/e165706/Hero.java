package jp.ac.uryukyu.ie.e165706;
import java.util.Scanner;

public class Hero extends LivingThing {
    public Hero(String name, int hitPoint, int attack,int  magicPoint) {
        super(name, hitPoint, attack, magicPoint);// 必ず先頭で呼び出す
    }

    @Override
    public int attack_option(int damage, LivingThing opponent) {
        System.out.println("戦う:1/逃げる:2\nコマンドを入力してください。:");
        Scanner sc = new Scanner(System.in);
        int command = sc.nextInt();
        if (command == 1) {
            Hero_attack(damage, opponent);
        } else if (command == 2) {
            escape(opponent.getName());
            return 0;
        } else {
            attack_option(damage, opponent);
        }
        return damage;
    }

    public int Hero_attack(int damage, LivingThing opponent) {
        System.out.printf("攻撃:1/呪文:2\nコマンドを入力してください。:");
        Scanner st = new Scanner(System.in);
        int attack_command = st.nextInt();
        if (attack_command == 1) {
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
        } else if (attack_command == 2) {
            System.out.printf("メラ:1/ホイミ:2\nコマンドを入力してください。:");
            Scanner St = new Scanner(System.in);
            int magic_command = St.nextInt();
            if (magic_command == 1) {
                mini_fire(damage);
                System.out.printf("残りMP:"+getMagicPoint());
                if (damage == 0) {
                    System.out.printf("%sはメラを唱えた!!...だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
                }else{
                        System.out.printf("%sは%sに%dダメージを与えた!!",getName(),opponent.getName(),damage);
                    }
            } else if (magic_command == 2) {
                Heal();
                System.out.printf("残りMP:"+getMagicPoint());
            } else {
                Hero_attack(damage, opponent);
            }
        }
    return damage;
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
