package jp.ac.uryukyu.ie.e165706;

import java.io.File; // ファイルやディレクトリの抽象表現
import java.io.FileNotFoundException; // 例外
import java.util.ArrayList; // Listの実装
import java.util.List; // いわゆる「リスト構造」のインターフェース（実装のないクラス。教科書19章）
import java.util.Scanner; // 標準入力読み込みの際に利用したクラス


class Maze {
    private List<String> strings = new ArrayList<String>();
    private String first_place;
    private String map_size;

    /*
    * Maze()ではmap.txtを読み込みする
    * try,catchを用いることでエラーにも対処(ここは前reportと変更なし)
    * 主人公の初期位置とmapの大きさをそれぞれの変数に代入
    * map.txtの1行目と2行目を削除
    */
    Maze() {
        Scanner scanner;
        String filename = "./src/main/java/jp/ac/uryukyu/ie/e165706/map.txt";
        try {
            scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.strings.add(line);
        }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1); //終了ステータス。ここでは取り敢えず0(=正常)以外にした。
        }
        first_place = this.strings.get(0);
        map_size = this.strings.get(1);
        this.strings.remove(0);
        this.strings.remove(0);

    }
    /*
    以下getter/setter
    */
    String getStartPlace() {
        return first_place;
    }

    String getMapSize() {
        return map_size;
    }

    public List<String> getmap() {
        return strings;
    }

    void getReturnMap() {
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

}