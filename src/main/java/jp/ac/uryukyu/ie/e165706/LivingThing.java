package jp.ac.uryukyu.ie.e165706;


public  abstract class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private int magicPoint;
    private boolean dead;

    public LivingThing (String name, int maximumHP, int attack,int maximumMP){
        this.name = name;
        hitPoint = maximumHP;
        magicPoint = maximumMP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%d。MPは%dです。\n", name, maximumHP, attack,maximumMP);
    }

    public boolean isDead(){return dead;}
    public  void  setDead(boolean dead){this.dead = dead;}


    public  String getName(){return name;}
    public void setName(String name){this.name = name;}


    public int getHitPoint() {return hitPoint;}
    public  void setHitPoint(int hitPoint){this.hitPoint = hitPoint;}

    public  int getMagicPoint(){return magicPoint;}
    public  void setMagicPoint(int magicPoint){this.magicPoint = magicPoint;}

    public  int Heal(){
        int heal = (int)(Math.random()*6 + Math.random() * 10 );
        System.out.printf("%sはホイミを唱えた!!",getName());
        System.out.printf("HPを%d回復した!!\n",heal);
        hitPoint +=heal;
        magicPoint -=3;
        return  heal;
    }
    public  int mini_fire(int damage){
        damage = (int)( Math.random() * 10 + 5 );
        magicPoint -= 3;
        return damage;
    }

    public void attack(LivingThing opponent){
        if (dead == false) {
            int damage = (int) (Math.random()  * attack);
            System.out.printf("%sの攻撃！\n", name);
            damage = attack_option(damage,opponent);
            opponent.wounded(damage,name);
        }
        else{
            dead = true;
        }
    }

    public abstract int attack_option(int damage,LivingThing opponent);

    public  int Magic_burst(){
        int damage = (int) (magicPoint * (1.5));
        System.out.printf("%sはホイミを唱えた!!\n",getName());
        System.out.printf(damage+"のダメージ!!\n");
        magicPoint -= magicPoint;
        return damage;
    }

    public void wounded(int damage,String name){
        hitPoint -= damage;
        name = getName();
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた!!\n",name);
        }
    }

}