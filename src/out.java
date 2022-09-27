import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class out {
    private int a, b;
    private String operator[]={" + "," - "," × "," ÷ ","|"};//加空格
    static ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
    public void Process(int num) {

        Scanner sc=new Scanner(System.in);
        int size=50;
        ArrayList<String> ques= new ArrayList<String>();
        ArrayList<String> ans= new ArrayList<String>();
        for (int x=0;x<num;x++){
            int j = new Random().nextInt(2)+1;//多少个运算符号-1
            String str = "", ch;//str保存算术式子，ch存储运算符
            a = new Random().nextInt(size);//第一个数
            b = new Random().nextInt(size);//被操作数
            //System.out.println(a);//
            v v1 = new v();
            str += a;
            for (int i = 0;i<j+1;i++){//运算符
                ch = operator[new Random().nextInt(5)];//运算符号
                //System.out.println(ch);
                //System.out.println(b);/**/
                if (ch.equals("|")) {//判断是不是分数
                    i--;
                    if (b == 0){
                        break;
                    }
                    String arr="";
                    int max = str.split(" ").length - 1;
                    String temp = str.split(" ")[max];//求出最后一个数
                    for (int k=0;k<max;k++){
                        arr+=str.split(" ")[k]+" ";
                    };//删除最后一个字符,注意空格
                    str=arr;
                    String end=temp + "/" + b;
                    end=v1.swap(end);//对最后个数进行运算
                    try {
                        str += v1.swap(js.eval(v1.swap(end)).toString());//先算出除以号得出小鼠后再转换
                        // System.out.println(v1.swap(js.eval(v1.swap(end)).toString())+"     lllllllllll\t"+str);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    str+=ch+b;
                }
                b = new Random().nextInt(size);
            }//str是原始算术题
            String[] arrs=str.split(" ");//用空格符分开
            String[] arr=new String[arrs.length];//先进行转换再来检测是否有误
            for (int t=0;t<arrs.length;t++){
                arr[t]=v1.swap(arrs[t]);
            }
            if (v1.check(arr)==false){
                x--;
            }
            else {
                String process="";
                ques.add(str+" = ");
                v1.dress(arrs);//修饰成可以运算的式子
                for (int e=0;e<arrs.length;e++){
                    process+=v1.swap(arrs[e])+" ";
                }
                try {
                    String answer=v1.swap(js.eval(process).toString());//存储答案
                    ans.add(answer);
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(str+" = "+v1.swap(js.eval(process).toString()));//输出
                } catch (ScriptException e) {
                    e.printStackTrace();
                }/*/**/
            }
        }
        Txt.clear("D:\\java\\算数题目\\Exercises.txt");
        Txt.clear("D:\\java\\算数题目\\Answers.txt");
        Txt.clear("D:\\java\\算数题目\\Grade.txt");
        for (int y=0;y<ans.size();y++){
            Txt.writeTxt(y+1+"、"+ques.get(y),"D:\\java\\算数题目\\Exercises.txt");
            Txt.writeTxt(y+1+"、"+ans.get(y),"D:\\java\\算数题目\\Answers.txt");
        }
    }
}
