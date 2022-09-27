import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class v{
    static ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
    public boolean check(String arr[]) {//先判断乘除
        List<String> op=new ArrayList<>();
        List<String> num=new ArrayList<>();//" × "," ÷ "
        for (int i = 0 ;i < arr.length; i+=2){
            num.add(arr[i]);
        }
        for (int j=1;j<arr.length;j+=2){
            if (arr[j].equals("×")){
                op.add("*");
            }
            else if (arr[j].equals("÷")){
                op.add("/");
            }else {
                op.add(arr[j]);
            }
        }
        if (op.contains("/")) {
            if (num.get(op.indexOf("/")+1).equals("0")) {//被除数为0
                return false;
            }
        }
        for (int x=0;x<op.size();x++){
            if(op.get(x).equals("*")||op.get(x).equals("/")){//先判断乘除
                try {
                    String ans=this.swap(js.eval(this.swap(num.get(x))+op.get(x)+this.swap(num.get(x+1))).toString());
                    op.remove(x);
                    num.remove(x);
                    num.remove(x);
                    num.add(x,ans);
                    x--;
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int y=0;y<op.size();y++){
            try {
                String ans=this.swap(js.eval(this.swap(num.get(y))+op.get(y)+this.swap(num.get(y+1))).toString());
                if (ans.contains("-")){
                    return false;
                }
                op.remove(y);
                num.remove(y);
                num.remove(y);
                num.add(y,ans);
                y--;
            } catch (ScriptException e){
                e.printStackTrace();
            }
        }
        return true;
    }/**/
    public void dress(String arr[]){//修饰为显示的算数题目
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("÷")){
                arr[i]="/";
            }
            else  if (arr[i].contains("×")){
                arr[i]="*";
            }
        }
    }
    public String swap(String n){//小数换分数，2'1/2=5/2
        for (int u=0;u<n.length();u++){
            if(n.charAt(u)=='E'){
                return "0";
            }
        }
        String str1 = null, str2 = null;
        int i, j, c;
        boolean flag=false;//判断有没有分数
        for(int k=0;k<n.length();k++){
            if(n.charAt(k) == '.')
            {
                str1 = n.substring(0, k);
                str2 = n.substring(k + 1);
                if (str2.length()>7){//无限小鼠取3位
                    str2=str2.substring(0,3);
                }
                flag=true;
                break;
            }
            else if(n.charAt(k)=='‘'){
                String[] arrs=n.split("\\‘|/");
                if (arrs[1].equals("0")){
                    return arrs[0];
                }
                if(arrs.length>3){
                    return String.valueOf(Integer.parseInt(arrs[0])*Integer.parseInt(arrs[2])+Integer.parseInt(arrs[1]))+"/"+String.valueOf(Integer.parseInt(arrs[2])*Integer.parseInt(arrs[3]));
                }
                else {
                    return String.valueOf(Integer.parseInt(arrs[0])*Integer.parseInt(arrs[2])+Integer.parseInt(arrs[1]))+"/"+String.valueOf(Integer.parseInt(arrs[2]));
                }/**/
            }
        }
        if (flag==false){
            return n;
        }
        i = str2.length();
        c = (int) Math.pow(10, i);
        int a = Integer.parseInt(str2);
        int b = Integer.parseInt(str1);
        for(j = 2; j <= a; j++)
        {
            if((a % j == 0) && (c % j == 0))
            {
                a = a / j;
                c = c / j;
                j = 1;
            }
        }
        if (b==0){
            return ( a + "/" + c);
        }else {
            return (b+"‘"+ a + "/" + c);
        }
    }
}