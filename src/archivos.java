package build;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class archivos {

    public static String leerTxt(String direccion) throws IOException {
        File dirs = new File(".");
        String filePath = dirs.getCanonicalPath() + File.separator + "src" + File.separator + "TestRead.java";

        StringBuilder fileData = new StringBuilder(1000);//Constructs a string buffer with no characters in it and the specified initial capacity
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        char[] buf = new char[1024];
        int numRead;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }

        reader.close();

        String returnStr = fileData.toString();
        System.out.println(returnStr);
        return returnStr;
    }
}
