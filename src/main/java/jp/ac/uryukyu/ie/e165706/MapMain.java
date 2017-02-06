package jp.ac.uryukyu.ie.e165706;

public class MapMain {

    public static void main(String[] args) throws Exception {
        Maze maze = new Maze();
        Player player = new Player(maze.getStartPlace(), maze.getMapSize(), maze.getmap());
        while (player.player_point() == false) {
            System.out.println("以下がプレイヤーの現在位置とマップです");
            System.out.println("現在位置:(横,縦)=("+player.getPlayer_x() + "," + player.getPlayer_y()+")");
            maze.getReturnMap();
            player.Moving();
        }
        /*
        主人公がゴールに着くとバトルが始まる
         */
    Main.main(args);
    }
}