import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class graphical {
    @Test
    public void go() {
        JFrame f=new JFrame("四则运算"); //创建窗口
        f.setLayout(null);
        f.setSize(300,200);  //设置窗口大小
        Color c=new Color(230,230,0,100);
        f.getContentPane().setBackground(c);  //设置窗口背景颜色
        // f.setVisible(true);  //设置窗口是可见的，不写的话，是没有显示效果的，且值要填true
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //关闭窗口的设置

        f.setBounds(500,200,600,600); //同时设置窗口初始位置和大小

        JLabel a1 = new JLabel("请输入题目数量:");
        a1.setFont(new Font("宋体", Font.PLAIN, 15));
        a1.setBounds(30, 10, 120, 30);
        f.add(a1);

        JTextField Field1 = new JTextField();
        Field1.setBounds(160, 10, 80, 30);
        f.add(Field1);

        JButton b1=new JButton("确定");
        b1.setBounds(260,10,80, 30);
        f.add(b1);

        JLabel a0 = new JLabel("题目:");
        a0.setFont(new Font("宋体", Font.PLAIN, 15));
        a0.setBounds(30, 80, 120, 30);
        f.add(a0);

        JTextArea output1=new JTextArea();//用于输出题目
        //output1.setBounds(30, 150, 140, 400);
        //f.add(output1);
        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(30, 130, 140, 400);
        scrollPane1.setViewportView(output1);
        f.add(scrollPane1);
        output1.append();

        JLabel a2 = new JLabel("请输入你的答案:");
        a2.setFont(new Font("宋体", Font.PLAIN, 15));
        a2.setBounds(280, 80, 120, 30);
        f.add(a2);

        JTextArea answer = new JTextArea();
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(280, 120, 200, 100);
        scrollPane2.setViewportView(answer);
        f.add(scrollPane2);
        //f.add(Field2);
        JButton b2=new JButton("确定");
        b2.setBounds(500,150,80, 30);
        f.add(b2);

        JLabel a3 = new JLabel("结果:");
        a3.setFont(new Font("宋体", Font.PLAIN, 15));
        a3.setBounds(280, 240, 120, 30);
        f.add(a3);

        JTextArea output2=new JTextArea();
        JScrollPane scrollPane3 = new JScrollPane();
        scrollPane3.setBounds(280, 280, 200, 220);
        scrollPane3.setViewportView(output2);
        f.add(scrollPane3);


        JButton searchButton1 =b1;
        searchButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                output1.setText("");
                String number=Field1.getText();
                int i = Integer.parseInt(number);
                new out().Process(i);
            }
        });
        f.add(searchButton1);

        JButton searchButton2 =b2;
        searchButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //一行行输入答案
                //一行行读取答案再跟正确答案对比
                //然后输出到output2中
            }
        });
        f.add(searchButton2);
        f.setVisible(true);
    }
}