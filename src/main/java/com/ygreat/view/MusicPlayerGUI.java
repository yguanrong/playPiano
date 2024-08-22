package com.ygreat.view;


import com.ygreat.constants.GlobalConst;
import com.ygreat.play.AudioPlay;
import com.ygreat.view.filter.NoteFileFilter;
import com.ygreat.util.FileUtils;
import com.ygreat.view.listener.AccompanimentButtonListener;
import com.ygreat.view.listener.MainMelodyButtonListener;
import com.ygreat.view.listener.StartButtonListener;
import com.ygreat.view.listener.StopButtonListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Classname MusicPlayerGUI
 * Date 2024/8/22 22:42
 * Created by y_great
 */
@Slf4j
public class MusicPlayerGUI {

    public static JFrame frame;
    public static JTextField mainMelodyField;
    public static JTextField accompanimentField;

    public static String notes;
    public static String accompaniments;
    public static int times;

    public static AudioPlay notePlay;
    public static AudioPlay accompanimentPlay;

    public MusicPlayerGUI() {
        // 创建主窗口
        frame = new JFrame("Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);

        // 使窗口居中显示
        frame.setLocationRelativeTo(null);

        // 使用BoxLayout垂直布局管理器
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 设置窗口四周的边距

        // 创建主旋律行
        JPanel mainMelodyPanel = new JPanel(new BorderLayout(10, 10)); // 增加组件之间的水平间隔
        mainMelodyField = new JTextField();
        mainMelodyField.setEditable(false);
        mainMelodyPanel.add(new JLabel("旋律文件："), BorderLayout.WEST);
        mainMelodyPanel.add(mainMelodyField, BorderLayout.CENTER);
        mainPanel.add(mainMelodyPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        // 创建伴奏行
        JPanel accompanimentPanel = new JPanel(new BorderLayout(10, 10)); // 增加组件之间的水平间隔
        accompanimentField = new JTextField();
        accompanimentField.setEditable(false);
        accompanimentPanel.add(new JLabel("伴奏文件："), BorderLayout.WEST);
        accompanimentPanel.add(accompanimentField, BorderLayout.CENTER);
        mainPanel.add(accompanimentPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        // 创建按钮行1（主旋律、伴奏）
        JPanel fileChoosePanel = getFileChoosePanel();
        mainPanel.add(fileChoosePanel);
        mainPanel.add(Box.createVerticalStrut(10));

        // 创建按钮行2（播放、暂停）
        JPanel playButtonPanel = getPlayButtonPanel();
        mainPanel.add(playButtonPanel);

        // 将主面板添加到窗口
        frame.setContentPane(mainPanel);

        // 显示窗口
        frame.setVisible(true);
    }

    /**
     * 获取播放按钮布局
     * @return
     */
    private static JPanel getPlayButtonPanel() {
        JPanel playButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JButton playButton = new JButton("播放");
        JButton pauseButton = new JButton("暂停");
        playButtonPanel.add(playButton);
        playButtonPanel.add(pauseButton);

        // 添加按钮的事件监听
        playButton.addActionListener(new StartButtonListener());
        pauseButton.addActionListener(new StopButtonListener());
        return playButtonPanel;
    }

    /**
     * 获取文件选择按钮的Panel
     * @return
     */
    private static JPanel getFileChoosePanel() {
        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JButton mainMelodyButton = new JButton("选择旋律");
        JButton accompanimentButton = new JButton("选择伴奏");
        buttonPanel1.add(mainMelodyButton);
        buttonPanel1.add(accompanimentButton);

        // 添加按钮的事件监听
        mainMelodyButton.addActionListener(new MainMelodyButtonListener());
        accompanimentButton.addActionListener(new AccompanimentButtonListener());
        return buttonPanel1;
    }


}




