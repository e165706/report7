package jp.ac.uryukyu.ie.e165706;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("RPG(?)にようこそ!!\n主人公の名前を入力しください!!:");
        Scanner scan = new Scanner(System.in);
        String hero_name = scan.next();
        Hero hero = new Hero(hero_name, 50, 5, 40);
        Enemy enemy = new Enemy("スライム", 15, 3, 0);
        Boss boss = new Boss("naltoma", 20, 5, 30);
        String Enemy_name = enemy.getName();
        for (int i = 0; i < 2; i++) {
            System.out.printf("%s vs. %s\n", hero.getName(), Enemy_name);
            int turn = 0;
            if (i == 0) {
                while (hero.isDead() == false && enemy.isDead() == false) {
                    turn++;
                    System.out.printf("%dターン目開始！\n", turn);
                    hero.attack(enemy);
                    enemy.attack(hero);
                }
                Enemy_name = boss.getName();
            } else {
                while (hero.isDead() == false && boss.isDead() == false) {
                    turn++;
                    System.out.printf("%dターン目開始！\n", turn);
                    hero.attack(boss);
                    boss.attack(hero);
                }
            }
            System.out.println("戦闘終了");
        }
    }
}

