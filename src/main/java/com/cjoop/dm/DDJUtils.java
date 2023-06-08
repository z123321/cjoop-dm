package com.cjoop.dm;

import com.jacob.com.ComThread;
import com.jacob.com.Variant;

import java.util.Random;

public class DDJUtils {
    private static DmSoft dm;
    private static int isBand;
    private static int hwnd=66984;

    static {
        ComThread.InitSTA();
        dm = new DmSoft();
        isBand = dm.BindWindow(hwnd, "dx2", "windows3", "normal", 0);
        System.out.println("version:" + dm.Ver());
    }


    static void goIntoGame() {
        try {

//            System.out.println("运行模拟器成功");

            if (isBand == 1) {
                System.out.println("窗口绑定成功");
                Variant x = getVariant();
                Variant y = getVariant();
                dm.FindPic(23, 504, 432, 761, "c:/wsddj/start.bmp|/wsddj/start_wechat.bmp", "", 0.6, 0, x, y);
                dm.MoveTo(x.getInt(), y.getInt());

                System.out.println("点击了进入游戏");

                dm.delay(getDelayTime());
                dm.LeftClick();


            }


        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    private static Variant getVariant() {
        return new Variant(0, true);
    }

    public static void login() {
        Variant x, y, x1, y1;
        x = new Variant(0, true);
        y = new Variant(0, true);
        x1 = new Variant(0, true);
        y1 = new Variant(0, true);
        if (isBand == 1) {
            //ss
            try {
                dm.FindPic(123, 222, 566, 676, "/wsddj/agree.bmp", "", 0.6, 0, x, y);

                dm.MoveTo(x.getInt(), y.getInt());
                dm.delay(getDelayTime());
                dm.LeftClick();
                System.out.println("点击同意协议！");

                dm.delay(getDelayTime());
                dm.FindPic(123, 222, 566, 676, "/wsddj/login.bmp", "", 0.6, 0, x1, y1);
                dm.MoveTo(x1.getInt(), y1.getInt() + 0);
                dm.delay(getDelayTime());
                dm.LeftClick();
                System.out.println("点击了登陆按钮");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static long getDelayTime() {
        Random random = new Random();
        long time = random.nextInt(500) + 150;
        System.out.println(time);
        return time;
    }

    public static void homeParty() {

        try {
            Variant x, y, x1, y1, x3, y3;
            x = getVariant();
            y = getVariant();
            x1 = getVariant();
            y1 = getVariant();
            x3 = getVariant();
            y3 = getVariant();
            int res = dm.FindPic(115, 120, 476, 699, "/wsddj/homeparyt.bmp", "", 0.6, 0, x, y);

            System.out.println("res" + res);
            if (res == 0) {
                System.out.println("找到家宴");
                dm.MoveTo(x.getInt(), y.getInt());
                dm.delay(300);
                dm.LeftClick();
                dm.delay(500);
                int sit = dm.FindPic(106, 243, 474, 723, "/wsddj/havesit.bmp", "", 0.6, 0, x, y);
                int sn = dm.FindPic(106, 243, 474, 723, "/wsddj/sn.bmp", "", 0.6, 0, x, y);
                if (sit == 0) {
                    System.out.println("还有空坐位");
                } else {
                    System.out.println("没有坐位了");
                }
                if (sn == 0) {
                    System.out.println("找到社牛佬一个");
                } else {
                    System.out.println("这桌没有社牛佬");
                }
            }
        } catch (Exception e) {
            System.out.println("没有找到家宴");
        }
    }

    public static void closeAd() {
        //   418,203,482,284,

        // int ad = dm.FindPic(310,97,373,151, "/wsddj/closead1.bmp", "", 0.6, 0, x, y);
        try {

//              int  x1=x.getInt();
//            int    y1=y.getInt();
            //      5,0,121,26,

            dm.MoveTo(340, 125);
            dm.delay(150);
            dm.LeftClick();

            dm.delay(300);

            dm.LeftClick();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void goPaty() {
        Variant x, y;
        x = new Variant(0, true);
        y = new Variant(0, true);

//        String base_path = dm.GetBasePath();

        int dm_ret = dm.SetDict(0, "/wsddj/texts.txt");
        //  isfind = dm.FindStr(194,455,210,475,"","fffffb-975b44",1.0,x,y)

        int login = dm.FindStr(20, 340, 312, 499, "宴","fffffb-975b44" , 0.8, x, y);
        System.out.println(login);
        if (login == 0) {
            System.out.println("找到了");
        } else {
            System.out.println("没找到");
            // System.out.println(dm.FindWindow("","微信"));
        }
    }
    public static boolean isLogin() {
        //5,0,121,26,
        Variant x, y;
        x = new Variant(0, true);
        y = new Variant(0, true);
        int login = dm.FindPic(88, 309, 335, 554, "/wsddj/top.bmp", "", 0.6, 0, x, y);
        if (login == 0) {
            return true;
        } else {

            return false;
        }


    }

}
