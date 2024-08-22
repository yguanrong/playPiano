package com.ygreat.view.listener;

import com.ygreat.constants.GlobalConst;
import com.ygreat.util.FileUtils;
import com.ygreat.view.MusicPlayerGUI;
import com.ygreat.view.filter.AccomFileFilter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * StartButtonListener
 * Date 2024/8/22 23:29
 * Created by y_great
 */
@Slf4j
public class AccompanimentButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 打开文件选择器，选择伴奏文件
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new AccomFileFilter());

        // 替换为你想要的路径
        File defaultDirectory = new File(GlobalConst.DEFAULT_FILE_PATH);
        fileChooser.setCurrentDirectory(defaultDirectory);
        int result = fileChooser.showOpenDialog(MusicPlayerGUI.frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getName();
            MusicPlayerGUI.accompanimentField.setText(fileName);
            MusicPlayerGUI.accompaniments = FileUtils.readFile2String(fileChooser.getSelectedFile());
        }
    }
}
