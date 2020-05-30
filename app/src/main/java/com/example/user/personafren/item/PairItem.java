package com.example.user.personafren.item;

/**
 * Created by user on 2018/4/25.
 */
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class PairItem {
    private int UserPersonality;    //使用者人格
    private int UserMood;   //使用者心情
    private int SecondaryPersonality;    //使用者付人格
    private int UsePersonality;  //要配對的人格
    private String OtherPersonName;  //對方姓名
    private int OtherPersonality = 0;  //產出的人格
    private int [] GoodPreson  ;  //主型復形
    double GPLenght = 0;
    int PresonSum = 0;
    ArrayList<String> PersonList;

    Random ran = new Random();

    public PairItem(int UserPersonality, int UserMood) {
        this.UserPersonality = UserPersonality;
        this.UserMood = UserMood;
    }
    public String ChoosePersonality(){
        try {
            FindUsePersonality();
            sleep(1000);
            System.out.println("睡眠結束1");
            double x = ran.nextInt(10)+1;
            if( x <= 6){
                UsePersonality = UserPersonality;
            }else{
                UsePersonality = SecondaryPersonality;
            }
            System.out.println("x : "+x);
            System.out.println("UsePersonality : "+UsePersonality);
            FindGoodPreson();
            sleep(2000);
            System.out.println("睡眠結束2");
            x = ran.nextInt(10)+1;
            if(x < ( 10/GPLenght ) ){
                OtherPersonality = GoodPreson[0];
            }else if (x < ( 10/GPLenght*2 ) ){
                OtherPersonality = GoodPreson[1];
            }else if (x < ( 10/GPLenght*3 ) ){
                OtherPersonality = GoodPreson[2];
            }else if (x < ( 10/GPLenght*4 ) ){
                OtherPersonality = GoodPreson[3];
            }else if (x < ( 10/GPLenght*5 ) ){
                OtherPersonality = GoodPreson[4];
            }else if (x < ( 10/GPLenght*6 ) ){
                OtherPersonality = GoodPreson[5];
            }else if (x < ( 10/GPLenght*7 ) ){
                OtherPersonality = GoodPreson[6];
            }else if (x < ( 10/GPLenght*8 ) ){
                OtherPersonality = GoodPreson[7];
            }else if (x < ( 10/GPLenght*9 ) ){
                OtherPersonality = GoodPreson[8];
            }
            System.out.println("OtherPersonality : "+OtherPersonality);
            FindPreson();
            sleep(1000);
            OtherPersonName = PersonList.get( ran.nextInt(PresonSum) );
            System.out.println("OtherPersonName : "+OtherPersonName);
        }catch (InterruptedException e){
            System.out.println("執行緒被中斷");
        }
        return  OtherPersonName;
    }

    public int FindOtherPersonality(){
//        int [] a= FindGoodPreson(UserPersonality,UserMood);
        OtherPersonality = getWho2(ran.nextInt(100)+1);
        return  OtherPersonality;
    }
    public int getWho(int [] num,int ran){
        int x = 0;
        int [] k = GetProbability();
        switch (num.length){
            case 1 :
                x = num[0];
                break;
            case 2 :
                if (ran <= k[0] ){
                    x = num[0];
                }else{
                    x = num[1];
                }
                break;
            case 3 :
                if (ran <= k[0] ){
                    x = num[0];
                }else if(ran <= (k[0]+k[1]) ){
                    x = num[1];
                }else{
                    x = num[2];
                }
                break;
            case 4 :
                if (ran <= k[0] ){
                    x = num[0];
                }else if(ran <= (k[0]+k[1]) ){
                    x = num[1];
                }else if(ran <= (k[0]+k[1]+k[2]) ){
                    x = num[2];
                }else{
                    x = num[3];
                }
                break;
        }
        return x;
    }


    public void FindPreson(){    // 資料庫抓資料，取得可以配對的人格
        new Thread(new Runnable() {
            public void run() {
                PersonList = connectionFind();
            }
        }).start();
    }

    public void FindGoodPreson(){    // 資料庫抓資料，取得可以配對的人格
        new Thread(new Runnable() {
            public void run() {
                GoodPreson=connection();
                for (int i=0;i<GoodPreson.length;i++){
                    System.out.println(i+" = "+GoodPreson[i]);
                }
            }
        }).start();
    }

    public void FindUsePersonality(){    // 資料庫抓資料，取得可以配對的人格
        new Thread(new Runnable() {
            public void run() {
                SecondaryPersonality = connection2(UserPersonality,UserMood);
            }
        }).start();
    }

    public int [] GetProbability(){ //取的機率
        int [] x = {50, 17, 17 ,16 };
        return x;
    }

    public int getWho2(int ran){
        int z = 0;
        int [] k = GetProbability2();
        if (ran <= k[0] ){
            z = 1;
        }else if(ran <= (k[0]+k[1]) ){
            z = 2;
        }else if(ran <= (k[0]+k[1]+k[2]) ){
            z = 3;
        }else if(ran <= (k[0]+k[1]+k[2]+k[3]) ){
            z = 4;
        }else if(ran <= (k[0]+k[1]+k[2]+k[3]+k[4]) ){
            z = 5;
        }else if(ran <= (k[0]+k[1]+k[2]+k[3]+k[4]+k[5]) ){
            z = 6;
        }else if(ran <= (k[0]+k[1]+k[2]+k[3]+k[4]+k[5]+k[6]) ){
            z = 7;
        }else if(ran <= (k[0]+k[1]+k[2]+k[3]+k[4]+k[5]+k[6]+k[7]) ){
            z = 8;
        }else if(ran <= (k[0]+k[1]+k[2]+k[3]+k[4]+k[5]+k[6]+k[7]+k[8]) ){
            z = 9;
        }else{
            z = 0;
        }
        return z;
    }
    public int [] GetProbability2(){ //取的機率
        int [] x = {0, 25, 17, 17 , 0, 16, 0, 0, 25 };
        return x;
    }

    private int [] connection() {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int [] a = new int[9];
        try {
            String result = DBConnector.executeQuery("SELECT OkP FROM PersonalityPair WHERE MainP='"+UsePersonality+"' " );

            JSONArray jsonArray = new JSONArray(result);
            System.out.println("jsonArray.length() "+jsonArray.length());
            GPLenght = jsonArray.length();
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonData = jsonArray.getJSONObject(i);
                list.add(Integer.parseInt(jsonData.getString("OkP")));
            }

            System.out.println("connect ok "+result);

        } catch(Exception e) {
            list.add(0);
            Log.e("log_tag", e.toString());
            System.out.println("connect failed");
        }
        for (int i=0;i<list.size();i++){
            a[i]=list.get(i);
            System.out.println(a[i]);
        }
        return a;
    }   //取得可配對人格

    private int connection2(int UserPersonality, int UserMood) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int a = 0;
        try {
            String result = DBConnector.executeQuery("SELECT Secondary FROM PersonalityPrimary WHERE Main='"+UserPersonality+"' and  Energy='"+UserMood+"'   " );

            JSONArray jsonArray = new JSONArray(result);
            System.out.println("jsonArray.length() "+jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonData = jsonArray.getJSONObject(i);
                a = Integer.parseInt(jsonData.getString("Secondary"));
            }

            System.out.println("connect ok "+result);

        } catch(Exception e) {
            list.add(0);
            Log.e("log_tag", e.toString());
            System.out.println("connect failed");
        }
        System.out.println(a);
        return a;
    }   //取得付人格

    private ArrayList connectionFind() {
        ArrayList<String> list=new ArrayList<String>();
        try {
            String result = DBConnector.executeQuery("SELECT Name FROM member WHERE Personality='"+OtherPersonality+"' " );

            JSONArray jsonArray = new JSONArray(result);
            System.out.println("jsonArray.length() "+jsonArray.length());
            PresonSum = jsonArray.length();     //取得總人數
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonData = jsonArray.getJSONObject(i);
                list.add(jsonData.getString("Name"));
            }
            System.out.println("connect ok "+result);

        } catch(Exception e) {
            Log.e("log_tag", e.toString());
            System.out.println("connect failed");
        }

        return list;
    }  //取的對方

}
