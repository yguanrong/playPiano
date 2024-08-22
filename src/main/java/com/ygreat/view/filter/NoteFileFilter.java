package com.ygreat.view.filter;


import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * NoteFileFilter
 * Date 2024/8/22 23:12
 * Created by y_great
 */
public class NoteFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        // 允许选择文件夹
        if (f.isDirectory()) {
            return false;
        }
        // 仅允许选择扩展名为.txt的文件
        return f.getName().toLowerCase().endsWith(".notes");
    }

    @Override
    public String getDescription() {
        return "*.notes";
    }
}
