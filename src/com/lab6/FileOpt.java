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
}
