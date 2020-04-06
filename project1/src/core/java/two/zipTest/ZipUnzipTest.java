package core.java.two.zipTest;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUnzipTest {
    public static void main(String[] args) throws IOException {
        File file = new File("IJ_test.zip");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bfo = new BufferedOutputStream(fileOutputStream);
        ZipOutputStream zipOutputStream = new ZipOutputStream(bfo);
        BufferedReader bfr = null;
        BufferedInputStream bis = null;
        byte count = 0;
        while (count < 3) {
            File file1 = new File("ij-" + count + ".txt");
            System.out.print("input for " + "ij-" + count + ".txt: ");
            FileOutputStream dos = new FileOutputStream(file1);
            bfr = new BufferedReader(new InputStreamReader(System.in));

            int tmp;
            while ((tmp = bfr.read()) != 49)
                /** 由于采用控制台输入读不到空值，所以指定一个值用于结束输入*/
                dos.write(tmp);

            bis = new BufferedInputStream(new FileInputStream(file1));
            ZipEntry zipEntry = new ZipEntry(file1.getName());
            //这一步相当于在压缩包中新建了一个同名的条目，是空的
            zipOutputStream.putNextEntry(zipEntry);
            while ((tmp = bis.read()) != -1)
                zipOutputStream.write(tmp);
            //向新建的条目中写入原同名文件的值
            zipOutputStream.closeEntry();
            count++;
            dos.close();

        }
        bfr.close();
        bis.close();
        zipOutputStream.close();
        fileOutputStream.close();

        ZipFile zf = new ZipFile(file);
        FileInputStream fis = new FileInputStream(file);
        ZipInputStream zipInputStream = new ZipInputStream(fis);
        ZipEntry ze;
        while ((ze = zipInputStream.getNextEntry()) != null) {
            int tmp;
            InputStream inputStream = zf.getInputStream(ze);
            //将条目转为输入流
            while ((tmp = inputStream.read()) != -1)
                System.out.print((char) tmp);
        }

    }
}
