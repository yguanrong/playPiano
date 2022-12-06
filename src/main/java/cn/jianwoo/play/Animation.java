package cn.jianwoo.play;

import cn.hutool.core.io.FileUtil;

/**
 * 打印音符
 */
public class Animation extends Thread{

    /** 音符 */
    private String[] notes;

    /** 间隔时间（单位：毫秒） */
    private int times;

    public Animation(int times) {
        this.times = times;
    }

    public Animation(String filePath, int times)
    {
        String content = FileUtil.readString(filePath,"UTF-8");
        this.notes = content.split(",");
        this.times = times;
    }

    public Animation loadNotes(String notes) {
        this.notes = notes.split(",");
        return this;
    }

    @Override
    public void run() {
        try {
            int times = this.times;
            new Audio("audio/test.mp3").start();
            sleep(1000);
            for (int i = 0; i < this.notes.length; i++)
            {
                String n = this.notes[i].replace("+","").replace("-","");
                if (n.equals("\n")||n.equals("\r")){
                    System.out.print("\n");
                    continue;
                }
                if(i%16 == 0){
                    System.out.print("\n");
                }
                switch (n)
                {
                    case "0":
                        System.out.print("\t_");
                        break;
                    case "1":
                        System.out.print("\t▁");
                        break;
                    case "2":
                        System.out.print("\t▂");
                        break;
                    case "3":
                        System.out.print("\t▃");
                        break;
                    case "4":
                        System.out.print("\t▄");
                        break;
                    case "5":
                        System.out.print("\t▅");
                        break;
                    case "6":
                        System.out.print("\t▆");
                        break;
                    case "7":
                        System.out.print("\t▇");
                        break;
                }
                System.out.print(" ");
                sleep(times);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
