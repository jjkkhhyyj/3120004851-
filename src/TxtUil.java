import org.junit.Test;

import java.io.*;

public class TxtUil {
    public static String readTxt(String txtPath){
        String str = "";
        String strLine;
        File file = new File(txtPath);
        FileInputStream fileInputStream ;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((strLine = bufferedReader.readLine()) != null) {
                str += strLine+"\n";
            }
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static void clear(String txtPath){
        File file = new File(txtPath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeTxt(String str,String txtPath){
        File file = new File(txtPath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.write(str);
            fileWriter.write("\r\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        TxtUil.clear("D:\\java\\算数题目\\Exercises.txt");
        TxtUil.clear("D:\\java\\算数题目\\Answers.txt");
        TxtUil.clear("D:\\java\\算数题目\\Grade.txt");
    }
}
