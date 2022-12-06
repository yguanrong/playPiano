package cn.jianwoo.test;

import cn.jianwoo.play.Animation;
import cn.jianwoo.play.AudioPlay;
import java.io.File;

/**
 * @author gulihua
 * @Description
 * @date 2022-11-13 17:52
 */
public class Test1 {
    public static void main(String[] args) {
        String path = new File("").getAbsolutePath() + File.separator + "src/main/resources/notes" + File.separator;

        String accompanimentPath = path + "起风了_180.accompaniments";
        String notePath = path + "起风了_180.notes";

        String tianKongPath = path + "天空之城_240.notes";

        new AudioPlay(tianKongPath,240).start();
//        new AudioPlay(accompanimentPath,180).start();
//        new Animation(notePath,180).start();
    }
}
