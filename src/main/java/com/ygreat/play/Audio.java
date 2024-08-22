package com.ygreat.play;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

@Slf4j
public class Audio extends Thread{

    private Player player;

    public Audio(String path) {
        InputStream is = Audio.class.getClassLoader().getResourceAsStream(path);
        try {
            assert is != null;
            player = new Player(is);
        } catch (JavaLayerException e) {
            log.error("获取流失败：{}", path, e);
        }
    }

    @Override
    public void run() {
        try {
            player.play();
        } catch (JavaLayerException e) {
            log.error("播放失败：{}", e.getMessage());
        }
    }
}
