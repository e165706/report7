package jp.ac.uryukyu.ie.e165706;

import org.junit.Test;

import static org.junit.Assert.*;


public class LivingThingTest {
    @Test
    public void attack() throws Exception {
        int EnemyHP = 15;
        Hero hero = new Hero("me", 30, 5,30);
        Enemy enemy = new Enemy("you", EnemyHP,10,0);
        enemy.setDead(true);
        for (int i = 0; i < 10; i++) {
            enemy.attack(hero); //乱数で0ダメージとなることもあるため、複数回実行してみる。
        }
        assertEquals(EnemyHP,enemy.getHitPoint());
    }
}