package com.ygreat.view.listener;

import com.ygreat.constants.GlobalConst;
import com.ygreat.util.FileUtils;
import com.ygreat.view.MusicPlayerGUI;
import com.ygreat.view.filter.NoteFileFilter;
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
public class MainMelodyButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 打开文件选择器，选择主旋律文件
        JFileChooser fileChooser = new JFileChooser();
        // 设置文件过滤器，只显示.txt文件
        fileChooser.setFileFilter(new NoteFileFilter());
        // 替换为你想要的路径
        File defaultDirectory = new File(GlobalConst.DEFAULT_FILE_PATH);
        fileChooser.setCurrentDirectory(defaultDirectory);
        int result = fileChooser.showOpenDialog(MusicPlayerGUI.frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getName();
            MusicPlayerGUI.mainMelodyField.setText(fileName);
            MusicPlayerGUI.notes = FileUtils.readFile2String(fileChooser.getSelectedFile());
            MusicPlayerGUI.times = Integer.parseInt(fileName.substring(fileName.indexOf("_") + 1, fileName.indexOf(".")));
        }
    }
}
