package jp.ac.uryukyu.ie.e165706;

public class MapMain {

    public static void main(String[] args) throws Exception {
        Maze maze = new Maze();
        Player player = new Player(maze.getStartPlace(), maze.getMapSize(), maze.getmap());
        System.out.println(maze.getmap().get(3).substring(0, 1));
        System.out.println("プレイヤーの初期位置: " + player.getPlayer_x() + "," + player.getPlayer_y());
        while (player.player_point() == false) {
            player.left_go();
            player.under_go();
            player.right_go();
            player.up_go();
        }
        System.out.println(player.getWalk_count());
    }
}