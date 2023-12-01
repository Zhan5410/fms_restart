package com.example;

import javax.swing.JFileChooser;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;

import com.util.system_parameters;

public class fms_restart 
{
    private void objset(){
        object_list.jfr.setSize(600,800);
        object_list.jfr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        object_list.jfr.setTitle(system_parameters.system_name);
        object_list.jfr.setLayout(new GridBagLayout());

        for(int i=0 ; i<object_list.jlb.length ; i++){
            object_list.jlb[i].setText(system_parameters.labeltext[i]);
        }

        for(int i=0 ; i<object_list.jcb.length ; i++){
            object_list.jcb[i].setText(system_parameters.jcbtext[i]);
        }

        for(int i=0 ; i<object_list.jrb.length ; i++){
            object_list.jrb[i].setText(system_parameters.radiobuttontext[i]);
        }

        for(int i=0 ; i<system_parameters.combolist.length ; i++){
            object_list.jcombo_textforecolor.addItem(system_parameters.combolist[i]);
            object_list.jcombo_textbackcolor.addItem(system_parameters.combolist[i]);
        }

        object_list.jl.setListData(system_parameters.listtext);

        object_list.jsl_textsize.setMinimum(0);
        object_list.jsl_textsize.setMaximum(100);
        object_list.jsl_textsize.setValue(12);

        object_list.jtb_bold.setText("B");
        object_list.jtb_italics.setText("I");
        object_list.jtb_underline.setText("U");

        for(int i=0 ; i<object_list.jbt.length ; i++){
            object_list.jbt[i].setText(system_parameters.buttontext[i]);
        }

    }
//*========================================================================================================================================= */
    private void objfunction(){
        //setcheckbox
        for(int i=0 ; i<object_list.jcb.length ; i++){
            object_list.jcb[i].setSelected(true);
            object_list.jcb[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    changecontent();
                }
            });
        }

        //addgroup
        for(int i=0 ; i<object_list.jrb.length ; i++){
            object_list.jrb_group.add(object_list.jrb[i]);
        }
        object_list.jrb_style1.setSelected(true);

        //set_combobox
        for(int i=0 ; i<object_list.jcombo.length ; i++){
            object_list.jcombo[i].setEnabled(false);
        }

        //set_radio
        object_list.jrb_style1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_list.jrb_style1.isSelected()){
                    object_list.jta_fileinformation.setForeground(system_parameters.color[0][0]);
                    object_list.jta_fileinformation.setBackground(system_parameters.color[0][1]);
                    object_list.jta_filecontent.setForeground(system_parameters.color[0][0]);
                    object_list.jta_filecontent.setBackground(system_parameters.color[0][1]);

                    object_list.jcombo_textforecolor.setEnabled(false);
                    object_list.jcombo_textbackcolor.setEnabled(false);
                }
            }
            
        });
        object_list.jrb_style2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_list.jrb_style2.isSelected()){
                    object_list.jta_fileinformation.setForeground(system_parameters.color[1][0]);
                    object_list.jta_fileinformation.setBackground(system_parameters.color[1][1]);
                    object_list.jta_filecontent.setForeground(system_parameters.color[1][0]);
                    object_list.jta_filecontent.setBackground(system_parameters.color[1][1]);

                    object_list.jcombo_textforecolor.setEnabled(false);
                    object_list.jcombo_textbackcolor.setEnabled(false);
                }
            }
            
        });
        object_list.jrb_uesrsetting.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_list.jrb_uesrsetting.isSelected()){
                    object_list.jcombo_textforecolor.setEnabled(true);
                    object_list.jcombo_textbackcolor.setEnabled(true);
                }
            }
            
        });

        //set_combobox
        object_list.jcombo_textforecolor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String fore_color = object_list.jcombo_textforecolor.getSelectedItem().toString();
                String back_color = object_list.jcombo_textbackcolor.getSelectedItem().toString();
                changecolor(fore_color,back_color);
            }
            
        });
        object_list.jcombo_textbackcolor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String fore_color = object_list.jcombo_textforecolor.getSelectedItem().toString();
                String back_color = object_list.jcombo_textbackcolor.getSelectedItem().toString();
                changecolor(fore_color, back_color);
            }
            
        });

        //setJList
        object_list.jl.setVisibleRowCount(5);

        //button_open
        object_list.jbt_open.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("openfile");
                JFileChooser jfc = new JFileChooser();
                int returnvalue = jfc.showOpenDialog(object_list.jfr);
                if(returnvalue == JFileChooser.APPROVE_OPTION){
                    File file = jfc.getSelectedFile();
                    object_list.jtf_filepathway.setText(file.getAbsolutePath());
                }
                else{
                    object_list.jtf_filepathway.setText("open command cancelled by user");
                }
            }
            
        });

        //button_read
        object_list.jbt_read.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("raadfile");
                File file = new File(object_list.jtf_filepathway.getText());
                StringBuffer sb = new StringBuffer();

                sb.append(file.getName() + "檔案資訊如下：　\n");
                sb.append("==========================\n");
                sb.append(system_parameters.jcbtext[0] + "：" + file.length() + "\n");
                sb.append(system_parameters.jcbtext[1] + "：" + (file.isFile()?"是檔案":"不是檔案") + "\n");
                sb.append(system_parameters.jcbtext[2] + "：" + (file.isDirectory()?"是目錄":"不是目錄") + "\n");
                sb.append(system_parameters.jcbtext[3] + "：" + (file.canRead()?"可讀":"不可讀") + "\n");
                sb.append(system_parameters.jcbtext[4] + "：" + (file.canWrite()?"可寫":"不可寫") + "\n");
                sb.append(system_parameters.jcbtext[5] + "：" + (file.isHidden()?"是隱藏檔案":"不是隱藏檔案") + "\n");
                sb.append(system_parameters.jcbtext[6] + "：" + todate(file.lastModified()) + "\n");
                sb.append(system_parameters.jcbtext[7] + "：" + file.getName() + "\n");
                sb.append(system_parameters.jcbtext[8] + "：" + file.getPath() + "\n");
                sb.append(system_parameters.jcbtext[9] + "：" + file.getAbsolutePath() + "\n");

                object_list.jta_fileinformation.setText(sb.toString());
                object_list.jta_filecontent.setText((readdata(object_list.jtf_filepathway.getText())).toString());
            }
        });

        //slider
        object_list.jsl_textsize.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Font font  = object_list.jta_filecontent.getFont().deriveFont((float)object_list.jsl_textsize.getValue());
                object_list.jta_filecontent.setFont(font);
                object_list.jta_fileinformation.setFont(font);
                object_list.jlb_textsizevalue.setText(String.valueOf(object_list.jsl_textsize.getValue()));
            }
            
        });

        //jlist
        object_list.jl.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Font font = object_list.jta_filecontent.getFont().deriveFont(Float.valueOf(system_parameters.listtext[object_list.jl.getSelectedIndex()]));
                object_list.jta_filecontent.setFont(font);
                object_list.jta_fileinformation.setFont(font);
                object_list.jlb_textsizevalue.setText(system_parameters.listtext[object_list.jl.getSelectedIndex()]);
            }
            
        });

        //toggle_button
        object_list.jtb_bold.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = object_list.jta_filecontent.getFont().deriveFont(object_list.jta_filecontent.getFont().getStyle()^Font.BOLD);
                object_list.jta_filecontent.setFont(font);
                object_list.jta_fileinformation.setFont(font);
            }
            
        });
        object_list.jtb_italics.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = object_list.jta_filecontent.getFont().deriveFont(object_list.jta_filecontent.getFont().getStyle()^Font.ITALIC);
                object_list.jta_filecontent.setFont(font);
                object_list.jta_fileinformation.setFont(font);
            }
            
        });
        object_list.jtb_underline.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = object_list.jta_filecontent.getFont().deriveFont(object_list.jta_filecontent.getFont().getStyle()^Font.HANGING_BASELINE);
                object_list.jta_filecontent.setFont(font);
                object_list.jta_fileinformation.setFont(font);
            }
            
        });

    }

//*========================================================================================================================================= */

    //change_content
    private void changecontent(){
        File file = new File(object_list.jtf_filepathway.getText());
        StringBuffer sb = new StringBuffer();

        if(object_list.jcb_filesize.isSelected()){sb.append(system_parameters.jcbtext[0] + "：" + file.length() + "\n");}
        if(object_list.jcb_isfile.isSelected()){sb.append(system_parameters.jcbtext[1] + "：" + (file.isFile()?"是檔案":"不是檔案") + "\n");}
        if(object_list.jcb_isdir.isSelected()){sb.append(system_parameters.jcbtext[2] + "：" + (file.isDirectory()?"是目錄":"不是目錄") + "\n");}
        if(object_list.jcb_canread.isSelected()){sb.append(system_parameters.jcbtext[3] + "：" + (file.canRead()?"可讀":"不可讀") + "\n");}
        if(object_list.jcb_canwrite.isSelected()){sb.append(system_parameters.jcbtext[4] + "：" + (file.canWrite()?"可寫":"不可寫") + "\n");}
        if(object_list.jcb_ishidden.isSelected()){sb.append(system_parameters.jcbtext[5] + "：" + (file.isHidden()?"是隱藏檔案":"不是隱藏檔案") + "\n");}
        if(object_list.jcb_lastmodify.isSelected()){sb.append(system_parameters.jcbtext[6] + "：" + todate(file.lastModified()) + "\n");}
        if(object_list.jcb_filename.isSelected()){sb.append(system_parameters.jcbtext[7] + "：" + file.getName() + "\n");}
        if(object_list.jcb_filepathway.isSelected()){sb.append(system_parameters.jcbtext[8] + "：" + file.getPath() + "\n");}
        if(object_list.jcb_fileabosptahway.isSelected()){sb.append(system_parameters.jcbtext[9] + "：" + file.getAbsolutePath() + "\n");}

        object_list.jta_fileinformation.setText(sb.toString());
    }

    //to_datatime
    private String todate(long lastModified){
        String data = new String();
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS");
        data = df.format(lastModified);

        return data;
    }

    //button_read
    private StringBuffer readdata(String path){
        StringBuffer sb = new StringBuffer();
        try {
             BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String text = "";

            while ((text = br.readLine()) != null) {
                sb.append(text + "\n");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    };

    //change_color
    private void changecolor(String fore_color,String back_color){
        object_list.jta_fileinformation.setForeground(getcolor(fore_color));
        object_list.jta_fileinformation.setBackground(getcolor(back_color));
        object_list.jta_filecontent.setForeground(getcolor(fore_color));
        object_list.jta_filecontent.setBackground(getcolor(back_color));
    }

    //get_color
    private Color getcolor(String color){
        switch (color) {
            case "黑色":
                return Color.BLACK;
            case "白色":
                return Color.WHITE;
            case "黃色":
                return Color.YELLOW;
            case "綠色":
                return Color.GREEN;
            case "藍色":
                return Color.BLUE;
            case "灰色":
                return Color.GRAY;
            default:
                return Color.RED;
        }
    }

//*====================================================================================================== */
    private void objadd(){
        //handel label
        for(int i=0 ; i<object_list.jlb.length ; i++){
            object_list.GUIcomp.add(object_list.jlb[i]);
        }

        //handel textfield
        for(int i=0 ; i<object_list.jtf.length ; i++){
            object_list.GUIcomp.add(object_list.jtf[i]);
        }

        //handel scrollpane
        for(int i=0 ; i<object_list.jsp.length ; i++){
            object_list.GUIcomp.add(object_list.jsp[i]);
        }

        //handel checkbox
        for(int i=0 ; i<object_list.jcb.length ; i++){
            object_list.GUIcomp.add(object_list.jcb[i]);
        }

        //handel radiobutton
        for(int i=0 ; i<object_list.jrb.length ; i++){
            object_list.GUIcomp.add(object_list.jrb[i]);
        }

        //handel combobox
        for(int i=0 ; i<object_list.jcombo.length ; i++){
            object_list.GUIcomp.add(object_list.jcombo[i]);
        }

        //handel scrollbar
        object_list.GUIcomp.add(object_list.jsl_textsize);

        //handel togglebutton
        for(int i=0 ; i<object_list.jtb.length ; i++){
            object_list.GUIcomp.add(object_list.jtb[i]);
        }

        //handel button
        for(int i=0 ; i<object_list.jbt.length ; i++){
            object_list.GUIcomp.add(object_list.jbt[i]);
        }

        //add on frame
        for(int i=0 ; i<object_list.GUIcomp.size() ; i++){
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = system_parameters.gbc[i][0];
            c.gridy = system_parameters.gbc[i][1];
            c.gridwidth = system_parameters.gbc[i][2];
            c.gridheight = system_parameters.gbc[i][3];
            c.weightx = system_parameters.gbc[i][4];
            c.weighty = system_parameters.gbc[i][5];
            c.fill = system_parameters.gbc[i][6];
            c.anchor = system_parameters.gbc[i][7];
            object_list.jfr.add(object_list.GUIcomp.get(i), c);
        }
    }
//*=========================================================================================================== */
    public static void main( String[] args )
    {
        fms_restart start = new fms_restart();
        start.objset();
        start.objfunction();
        start.objadd();
        object_list.jfr.setVisible(true);
    }
}
