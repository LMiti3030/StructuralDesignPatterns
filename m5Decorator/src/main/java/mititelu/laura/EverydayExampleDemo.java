package mititelu.laura;

import java.io.*;

public class EverydayExampleDemo {

    public static void main(String[] args) {
        try{
            File file  = new File("./output.txt");

        file.createNewFile();

        OutputStream oStream = new FileOutputStream(file);

        DataOutputStream doStream = new DataOutputStream(oStream);
        doStream.writeUTF("text");//writeChars("text");
        doStream.close();
        oStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
