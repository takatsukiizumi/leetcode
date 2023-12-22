package takatsukiizumi.leetcode;

import java.io.*;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/5/17
 */
public class IoTest  {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\wildartist\\Desktop\\123.txt";
         File file = new File(filePath);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            String abc = "abcabcabc11111111";
            //向文件写入
            outputStream.write(abc.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try  {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.newLine();  // 换行
            writer.write("this is a new line qaq");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String bit;
            while((bit=bufferedReader.readLine())!=null){
                //从文件读取
                stringBuffer.append(bit);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuffer.toString());
    }




}
