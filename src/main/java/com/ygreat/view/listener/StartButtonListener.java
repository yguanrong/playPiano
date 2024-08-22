package com.ygreat.view.listener;

import com.ygreat.play.AudioPlay;
import com.ygreat.view.MusicPlayerGUI;
import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * StartButtonListener
 * Date 2024/8/22 23:29
 * Created by y_great
 */
@Slf4j
public class StartButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 实现播放功能
        log.info("播放音乐");
        String[] notes = MusicPlayerGUI.notes.split(" ");
        String[] accomp = MusicPlayerGUI.accompaniments.split(" ");

        MusicPlayerGUI.notePlay = new AudioPlay(notes, MusicPlayerGUI.times);
        MusicPlayerGUI.accompanimentPlay = new AudioPlay(accomp, MusicPlayerGUI.times);
        MusicPlayerGUI.notePlay.start();
        MusicPlayerGUI.accompanimentPlay.start();
    }
}
