package com.zhaohao.shareparkingspace;

public class MyApi {
    static String url = "http://192.168.1.102/ShareParkingSpace/";

    static String login = url+"user/login.php";
    static String signup = url+"user/signup.php";
    static String reusername = url+"user/reusername.php";
    static String repassword = url+"user/repassword.php";

    static String usercar = url+"car/usercar.php";
    static String addcar = url+"car/addcar.php";
    static String delcar = url+"car/delcar.php;";

    static String getmyps = url+"ps/getmyps.php";
    static String delps = url+"ps/delps.php";
    static String addps = url+"ps/addps.php";
    static String getnearps = url+"ps/getnearps.php";

    static String getpr = url+"pr/getpr.php";
    static String addpr = url+"pr/addpr.php";
    static String setprstate = url+"pr/setprstate.php";
}
