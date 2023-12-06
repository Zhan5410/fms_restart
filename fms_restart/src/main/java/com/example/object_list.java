package com.example;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class object_list {
    public static JFrame jfr = new JFrame();

    public static ArrayList<JComponent> GUIcomp = new ArrayList<>();

    public static JLabel jlb_filepathway = new JLabel();
    public static JLabel jlb_fileinformation = new JLabel();
    public static JLabel jlb_filecontent = new JLabel();
    public static JLabel jlb_textforecolor = new JLabel();
    public static JLabel jlb_textbackcolor = new JLabel();
    public static JLabel jlb_textsize = new JLabel();
    public static JLabel jlb_textsizevalue = new JLabel();
    public static JLabel[] jlb = new JLabel[]{  jlb_filepathway,
                                                jlb_fileinformation,
                                                jlb_filecontent,
                                                jlb_textforecolor,
                                                jlb_textbackcolor,
                                                jlb_textsize,
                                                jlb_textsizevalue

    };

    public static JTextField jtf_filepathway = new JTextField();
    public static JTextField jtf[] = new JTextField[]{  jtf_filepathway,

    };

    public static JTextArea jta_fileinformation = new JTextArea();
    public static JTextArea jta_filecontent = new JTextArea();

    public static JCheckBox jcb_filesize = new JCheckBox();
    public static JCheckBox jcb_isfile = new JCheckBox();
    public static JCheckBox jcb_isdir = new JCheckBox();
    public static JCheckBox jcb_canread = new JCheckBox();
    public static JCheckBox jcb_canwrite = new JCheckBox();
    public static JCheckBox jcb_ishidden = new JCheckBox();
    public static JCheckBox jcb_lastmodify = new JCheckBox();
    public static JCheckBox jcb_filename = new JCheckBox();
    public static JCheckBox jcb_filepathway = new JCheckBox();
    public static JCheckBox jcb_fileabosptahway = new JCheckBox();
    public static JCheckBox jcb[] = new JCheckBox[]{    jcb_filesize,
                                                        jcb_isfile,
                                                        jcb_isdir,
                                                        jcb_canread,
                                                        jcb_canwrite,
                                                        jcb_ishidden,
                                                        jcb_lastmodify,
                                                        jcb_filename,
                                                        jcb_filepathway,
                                                        jcb_fileabosptahway

    };

    public static JRadioButton jrb_style1 = new JRadioButton();
    public static JRadioButton jrb_style2 = new JRadioButton();
    public static JRadioButton jrb_uesrsetting = new JRadioButton();
    public static JRadioButton[] jrb = new JRadioButton[]{  jrb_style1,
                                                            jrb_style2,
                                                            jrb_uesrsetting

    };
    public static ButtonGroup jrb_group = new ButtonGroup();

    public static JList<String> jl = new JList<>();

    public static JScrollPane jsp_fileinformation = new JScrollPane(jta_fileinformation);
    public static JScrollPane jsp_filecontent = new JScrollPane(jta_filecontent);
    public static JScrollPane jsp_jl = new JScrollPane(jl);
    public static JScrollPane jsp[] = new JScrollPane[]{    jsp_fileinformation,
                                                            jsp_filecontent,
                                                            jsp_jl

    };

    public static JComboBox<String> jcombo_textforecolor = new JComboBox<>();
    public static JComboBox<String> jcombo_textbackcolor = new JComboBox<>();
    public static JComponent[] jcombo = new JComboBox[]{ jcombo_textforecolor,
                                                         jcombo_textbackcolor

    };

    public static JSlider jsl_textsize = new JSlider();

    public static JToggleButton jtb_bold = new JToggleButton();
    public static JToggleButton jtb_italics = new JToggleButton();
    public static JToggleButton jtb_underline = new JToggleButton();
    public static JToggleButton[] jtb = new JToggleButton[]{    jtb_bold,
                                                                jtb_italics,
                                                                jtb_underline

    };

    public static JButton jbt_open = new JButton();
    public static JButton jbt_read = new JButton();
    public static JButton jbt_encode = new JButton();
    public static JButton jbt_decode = new JButton();
    public static JButton[] jbt = new JButton[]{    jbt_open,
                                                    jbt_read,
                                                    jbt_encode,
                                                    jbt_decode

    };

    static JProgressBar jpb_progress = new JProgressBar();
}
