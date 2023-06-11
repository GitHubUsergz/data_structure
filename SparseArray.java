import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
        //创建chessArray
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        for (int i = 0; i < chessArray.length; i++){
            for (int j = 0; j < chessArray[0].length; j++){
                System.out.print(chessArray[i][j]+"\t");
            }
            System.out.println();
        }

        //遍历稀疏数组有效位数
        int sum = 0;
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (chessArray[i][j] > 0){
                    sum++;
                }
            }
        }
        //System.out.println(chessArray[1].length);
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //将数据赋给稀疏数组
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[1].length;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (chessArray[i][j] > 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        //稀疏矩阵已经创建好了，这时候出入硬盘存起来
        //输出流
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("map_data");
            for (int i = 0; i < sparseArray.length; i++){
                for (int j = 0; j < sparseArray[0].length; j++){
                    fos.write(sparseArray[i][j]);
                }
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //输入流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\java_learn\\data_structure\\map_data");
            for (int i = 0; i < sparseArray.length; i++){
                for (int j = 0; j < sparseArray[0].length; j++){
                    sparseArray[i][j] = fis.read();
                    //System.out.println(sparseArray[i][j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //输出稀疏数组
        for (int i = 0; i < sparseArray.length; i++){
            for (int j = 0; j < sparseArray[0].length; j++){
                System.out.print(sparseArray[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------");
        //读取稀疏数组第一行 创建原始数组大小
        int[][] originalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        //读取稀疏数组最后几行 赋值给原始数组
        for (int i = 1; i < sparseArray.length; i++){
            originalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int i = 0; i < originalArray.length; i++){
            for (int j = 0; j < originalArray[0].length; j++){
                System.out.print(originalArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
