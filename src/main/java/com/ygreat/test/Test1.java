package com.ygreat.test;

import com.ygreat.play.Animation;
import com.ygreat.play.AudioPlay;

import java.io.File;


public class Test1 {
    public static void main(String[] args) {
        String path = new File("").getAbsolutePath() + File.separator + "src/main/resources/notes" + File.separator;

        String accompanimentPath = path + "起风了_180.accomp";
        String notePath = path + "起风了_180.notes";

        String jtAccompPath = path + "小星星.accomp";
        String jtNotePath = path + "小星星.notes";

        new AudioPlay(notePath,240).start();
        new AudioPlay(accompanimentPath,240).start();
        new Animation(notePath,240).start();
    }
}
