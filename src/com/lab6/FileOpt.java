package com.lab6;

import java.io.*;

class FileOpt {

    String read(String filePath) {

        File file = new File(filePath);

        String temp = "";

        BufferedReader bufferedReader = null;
        StringBuilder string = new StringBuilder();
        FileReader fb = null;
        try{
            fb = new FileReader(file);
            bufferedReader = new BufferedReader(fb);
            while( (temp = bufferedReader.readLine()) != null){
                string.append(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fb != null){
                try {
                    fb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string.toString();
    }
    //向文件中写入数据
    void write(String content, String log){
        try {
            FileWriter wr = new FileWriter(log, true);
            wr.write(content);
            wr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("IOException...");
            e.printStackTrace();
        }
    }

    void clear(String log){
        try{FileWriter wr = new FileWriter(log,false);
            wr.write("");
        }catch(IOException e){
            System.out.println("Clear Error");
            e.printStackTrace();
        }
    }

    static String mergeFiles(String file1, String file2) {
        String outputFile = "outputFile";
        try {
            FileReader fr1=new FileReader(file1);//读取newFile.txt的内容
            FileReader fr2=new FileReader(file2);//读取newFile1.txt的内容
            BufferedReader br1=new BufferedReader(fr1);
            BufferedReader br2=new BufferedReader(fr2);
            BufferedWriter bw3=new BufferedWriter(new FileWriter(outputFile));
            String s,s1;
            s=br1.readLine();
            s1=br2.readLine();
            while(s!=null) {
                bw3.write(s);
                s=br1.readLine();
                bw3.newLine();//换行
            }
            while(s1!=null) {
                bw3.write(s1);
                s1=br1.readLine();
                bw3.newLine();
            }
            br1.close();
            br2.close();
            bw3.close();
            System.out.println("文件合并成功...");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return outputFile;
    }
}
