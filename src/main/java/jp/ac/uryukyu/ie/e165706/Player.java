package jp.ac.uryukyu.ie.e165706;

import javax.swing.text.Position;
import java.util.List;
import java.util.Scanner;

class Player {
    private int player_x;      //プレイヤーのx座標の値
    private int player_y;      //プレイヤーのy座標の値
    private int map_x;    //mapの最大値のx座標
    private int map_y;    //mapの最大値のy座標
    private List<String> take;   //Mazeで作ったマップをこの変数に入れる

    Player(String like, String h, List<String> rise){
        this.take = rise;
        String[] p = like.split("\\s+",0);
        for(int i = 0; i<2; i++){
            if (i == 0){
                String q = p[i];
                this.player_x = Integer.parseInt(q) ;
            }
            if (i ==1){
                String w = p[i];
                this.player_y = Integer.parseInt(w);
            }
        }

        String[] me = h.split("\\s+",0);
        for (int j = 0; j<2; j++){
            if (j == 0){
                String e  =me[j];
                this.map_x = Integer.parseInt(e);
            }
            if(j == 1){
                String qu = me[j];
                this.map_y = Integer.parseInt(qu);
            }
        }
    }

    /*
    以下の4つのメソッドが主人公から見てそれぞれの座標に"#"があるか否かを判断するメソッド。
     */
    Boolean judge_upside (){
        String loid = take.get(player_y+1);
        char far = loid.charAt(player_x);
        return "#".equals(far);
    }
    Boolean judge_undertside (){
        String loid = take.get(player_y );
        char far = loid.charAt(player_x);
        return "#".equals(far);
    }
    Boolean judge_rightside (){
        String loid = take.get(player_x +1);
        String far =loid.substring(player_x, player_x);
        return "#".equals(far);
    }
    Boolean judge_leftside (){
        String loid = take.get(player_x -1);
        String far =loid.substring(player_x +1, player_x + 2);
        return "#".equals(far);
    }

    /*
    以下4つのメソッドが各方向に移動するためのメソッド
     */
    void under_go() {
        String loid = take.get(player_y +1);
        String roal = loid.substring(player_x , player_x + 1);
        while (!("#".equals(roal))){
            if(judge_undertside ()) {
                this.player_y += 1;
                loid = take.get(player_y + 1);
                roal = loid.substring(player_x , player_x + 1);
            }else{
                this.player_y += 1;
                break;
            }
        }
    }
    void right_go() {
        String loid = take.get(player_y +1);
        String roal = loid.substring(player_x + 1, player_x +2);
        while (!("#".equals(roal))) {
            if (judge_rightside()) {
                this.player_x += 1;
                roal = loid.substring(player_x + 1, player_x + 2);
                System.out.println("行き止まりです!!");
            } else {
                this.player_x += 1;
                break;
            }
        }
    }
    void left_go() {
        String loid = take.get(player_y +1);
        String roal = loid.substring(player_x -1, player_x );
        while (!("#".equals(roal))){
            if (judge_leftside()){
                this.player_x -= 1;
                roal = loid.substring(player_x -1, player_x );
            }else{
                this.player_x -= 1;
                break;
            }
        }
    }
    void up_go() {
        String loid = take.get(player_y);
        String roal = loid.substring(player_x  , player_x + 1);
        while (!("#".equals(roal))){
            if (judge_upside()){
                this.player_y -= 1;
                loid = take.get(player_y -1 );
                roal = loid.substring(player_x , player_x + 1);
            }else{
                this.player_y -= 1;
                break;
            }
        }
    }
    /*
    主人公がGにいる時にtureを返す。
     */
    Boolean player_point() {
        String loid = take.get(player_y);
        String far;
        far = loid.substring(player_x , player_x + 1);
        return "G".equals(far);
    }
    /*
    主人公が移動する際のメソッド
     */
    public void Moving(){
        System.out.printf("主人公が移動する方向を選択してください。\n左:1\n下:2\n右:3\n上:4  :");
        Scanner st = new Scanner(System.in);
        int chara = st.nextInt();
        if (chara == 1) {
            left_go();
        } else if (chara == 2) {
            under_go();
        } else if (chara == 3) {
            right_go();
        } else if (chara == 4) {
            up_go();
        }
    }
    //以下getter
    int getPlayer_x(){return player_x;}
    int getPlayer_y() { return player_y; }

}