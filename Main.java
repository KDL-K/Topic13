package com.shevlik;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main=new Main();
        File file=new File("./Register.txt");
        main.tillFile(file, new Student("Сидоров",5,7,3,6), new Student("Петров",9,8,7),
                new Student("Семенов",9,3,4,8),new Student("Иванов",9,8,7,5,8));
        main.changeFileByAverageScore(file,7);


    }

    void tillFile(File file, Student... students){
        int size=students.length;
        try(FileWriter fw=new FileWriter(file,true)){
            for(int i=0;i<size;i++){
                fw.write(students[i].getDescription());
                fw.write("\r\n");
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    void reTillFile(File file, List list){
        int size=list.size();
        try(FileWriter fw=new FileWriter(file,false)){
            for(int i=0;i<size;i++){
                fw.write((String)list.get(i));
                fw.write("\r\n");
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    void changeFileByAverageScore(File file,int averageScore){
        List description=new ArrayList();
        try(FileReader fr=new FileReader(file)){
            int readNext;
            readNext=fr.read();
            do{
                char[] bufName=new char[15];
                int[] bufNumbers=new int[15];
                int i = 0;
                while (readNext != 32) {
                    bufName[i]=(char)readNext;
                    i++;
                    readNext=fr.read();
                }
                i=0;
                while (readNext != '\r') {
                    if(readNext!=32){
                        bufNumbers[i]=Character.getNumericValue(readNext);
                        i++;
                    }
                    readNext=fr.read();
                }
                i=0;
                int sum=0;
                for(int j=0;j<bufNumbers.length;j++){
                    if(bufNumbers[j]>0){
                        sum+=bufNumbers[j];
                        i++;
                    }
                }
                String name;
                if((float)sum/i>averageScore){
                    name=new String(bufName).trim().toUpperCase();
                } else name=new String(bufName).trim();
                for(int j=0;j<bufNumbers.length;j++){
                    if(bufNumbers[j]==0) break;
                    name+=" "+bufNumbers[j];
                }
                description.add(name);
                readNext=fr.read();
                readNext=fr.read();
            }while(readNext!=-1);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        reTillFile(file,description);

    }


}
