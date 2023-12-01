package com.util;

import java.awt.Color;
import java.awt.GridBagConstraints;

public class system_parameters {
    public static final String system_name =    "檔案管理系統";

    public static final String[] labeltext = {  "路徑",
                                                "檔案資訊",
                                                "檔案內容",
                                                "文字顏色",
                                                "背景顏色",
                                                "文字大小",
                                                "12",
    };

    public static final String[] radiobuttontext = {    "樣式一",
                                                        "樣式二",
                                                        "自訂",
    };

    public static final String[] jcbtext = {    "檔案長度",
                                                "是否為檔案",
                                                "是否為目錄",
                                                "是否可讀",
                                                "是否可寫",
                                                "是否隱藏",
                                                "最後修改日期",
                                                "檔案名稱",
                                                "檔案路徑",
                                                "絕對路徑" 
    };

    public static final String[] listtext = {   "8",
                                                "12",
                                                "24",
                                                "36",
                                                "48",
                                                "90",
                                                "100"
    };

    public static final String[] buttontext = { "開啟檔案",
                                                "讀取內容",
                                                "加密",
                                                "解密"
    };

    private static final int NONE = GridBagConstraints.NONE;
    private static final int BOTH = GridBagConstraints.BOTH;
    private static final int WEST = GridBagConstraints.WEST;

    public static final int gbc[][] = { {0,0,1,1,0,0,NONE,WEST},    //jlb_filepathway
                                        {0,1,1,1,0,0,NONE,WEST},    //jlb_fileinformation
                                        {0,12,1,1,0,0,NONE,WEST},   //jlb_filecontent
                                        {1,9,1,1,0,0,NONE,WEST},  //jlb_textforecolor
                                        {3,9,1,1,0,0,NONE,WEST},  //jlb_textbackcolor
                                        {1,10,1,1,0,0,NONE,WEST}, //jlb_textsize
                                        {5,10,1,1,0,0,NONE,WEST}, //jlb_textsizevalue
                                        {1,0,8,1,1,0,BOTH,WEST},    //jtf_filepathway
                                        {1,1,8,5,1,1,BOTH,WEST},  //jsp_fileinformation
                                        {1,12,8,5,1,1,BOTH,WEST}, //jsp_filecontent
                                        {6,6,3,4,0,0,BOTH,WEST},  //jsp_jl
                                        {1,6,1,1,0,0,NONE,WEST},  //jcb_filesize
                                        {2,6,1,1,0,0,NONE,WEST},  //jcb_isfile
                                        {3,6,1,1,0,0,NONE,WEST},  //jcb_isdir
                                        {4,6,2,1,0,0,BOTH,WEST},  //jcb_canread
                                        {1,7,1,1,0,0,NONE,WEST},  //jcb_canwrite
                                        {2,7,1,1,0,0,NONE,WEST},  //jcb_ishidden
                                        {3,7,1,1,0,0,NONE,WEST},  //jcb_lastmodify
                                        {4,7,2,1,0,0,BOTH,WEST},  //jcb_filename
                                        {1,8,1,1,0,0,NONE,WEST},  //jcb_filepathway
                                        {2,8,1,1,0,0,NONE,WEST},  //jcb_fileabosptahway
                                        {3,8,1,1,0,0,NONE,WEST},  //jrb_style1
                                        {4,8,1,1,0,0,NONE,WEST},  //jrb_style2
                                        {5,8,1,1,0,0,NONE,WEST},  //jrb_usersetting
                                        {2,9,1,1,0,0,NONE,WEST},  //jcombo_textforecolor
                                        {4,9,2,1,0,0,BOTH,WEST},  //jcombo_textbackcolor
                                        {2,10,3,1,1,0,BOTH,WEST}, //jsl_textsize
                                        {6,10,1,1,0,0,NONE,WEST}, //jtb_bold
                                        {7,10,1,1,0,0,NONE,WEST}, //jtb_italics
                                        {8,10,1,1,0,0,NONE,WEST},   //jtb_underline
                                        {1,11,1,1,0,0,NONE,WEST}, //jbt_open
                                        {2,11,1,1,0,0,NONE,WEST}, //jbt_read
                                        {3,11,0,1,1,0,NONE,WEST}, //jbt_encode
                                        {4,11,0,1,1,0,BOTH,WEST}, //jbt_decode
    };

    public static Color[][] color = {   {Color.BLACK,Color.WHITE},
                                        {Color.YELLOW,Color.BLACK}
    };

    public static String[] combolist = {    "黑色",
                                            "白色",
                                            "黃色",
                                            "綠色",
                                            "藍色",
                                            "灰色",
                                            "紅色"
    };
}
