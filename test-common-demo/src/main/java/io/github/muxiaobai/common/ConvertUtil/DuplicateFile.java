package io.github.muxiaobai.common.ConvertUtil;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class DuplicateFile {
    private  void load(Set set, String path){
        BufferedReader reader= new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(path)));
        try{
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                set.add(line);
            }

            reader.close();
        }catch(IOException e){
        }
    }
    public static void main(String[] args) {
        Set set = new TreeSet();
        DuplicateFile stop = new DuplicateFile();
        stop.load(set,"/word/stop_words.txt");
        System.out.println(set.size());
        stop.writeToTxt(set);

    }
    public void writeToTxt(Set set){

        Iterator iterator = set.iterator();
        File file = new File("./stop_words.txt");

        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            while(iterator.hasNext()){
                writer.write(iterator.next().toString());
                writer.newLine();//换行
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                writer.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}