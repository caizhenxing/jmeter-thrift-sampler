package me.skyleft.utils;

/**
 * Created by zhangzongchao on 2015/11/30.
 */

import java.io.*;


public class CopyDirectory {

    /***
     * �����ļ�
     *
     * @param sourceFile Դ�ļ�
     * @param targetFile Ŀ���ļ�
     * @throws IOException
     */
    public void copyFile(File sourceFile, File targetFile)
            throws IOException {
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff = new BufferedInputStream(input);

        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);

        byte[] b = new byte[1024 * 5];
        int len;
        while ((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        outBuff.flush();

        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }

    /***
     * �����ļ���
     *
     * @param sourceDir Դ�ļ���·��
     * @param targetDir Ŀ���ļ���·��
     * @throws IOException
     */
    public void copyDirectiory(String sourceDir, String targetDir)
            throws IOException {
        (new File(targetDir)).mkdirs();
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                File sourceFile = file[i];
                File targetFile = new File(new File(targetDir)
                        .getAbsolutePath()
                        + File.separator + file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory()) {
                String dir1 = sourceDir + "/" + file[i].getName();
                String dir2 = targetDir + "/" + file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }
    }
}
