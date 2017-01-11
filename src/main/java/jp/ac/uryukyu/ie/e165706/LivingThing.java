package jp.ac.uryukyu.ie.e165706;


public  abstract class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing (String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    public boolean isDead(){return dead;}
    public  void  setDead(boolean dead){this.dead = dead;}



    public  String getName(){return name;}
    public void setName(String name){this.name = name;}


    public int getHitPoint() {return hitPoint;}
    public  void setHitPoint(int hitPoint){this.hitPoint = hitPoint;}



    public void attack(LivingThing opponent){
        if (dead == false) {
            int damage = (int) (Math.random()  * attack);
            System.out.printf("%sの攻撃！\n", name);
            damage = attack_option(damage,opponent);
            opponent.wounded(damage);
        }
        else{
            dead = true;
        }
    }
    public abstract int attack_option(int damage,LivingThing opponent);

    public void wounded(int damage){
        hitPoint -= damage;
        //System.out.println("残り体力は" + getHitPoint());
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}