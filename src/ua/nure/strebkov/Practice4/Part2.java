package ua.nure.strebkov.Practice4;

/**
 * Create a class that creates and populates a file
 * of random integers from 0 to 50 (a total of 10 numbers),
 * then reads the file and outputs its content to another file,
 * sorting the numbers in ascending order.
 * The contents of both files (numbers separated by a space)
 * are output to the console.
 *
 * @authot Strebkov D.
 */

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Part2 {

    public static void writeRandomNumber(String name, int n) throws IOException {
        Random rand = new Random();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "Cp1251"));
            for (int i = 0; i < n; i++) {
                bw.write(Integer.toString(rand.nextInt(50)));
                bw.write(" ");
            }
            bw.close();
    }

    public static void writeArray(int[] arr, String name) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "Cp1251"));
        for (int i = 0; i < arr.length; i++) {
            bw.write(Integer.toString(arr[i]));
            bw.write(" ");
        }
        bw.close();

    }

    public static int[] readArray(String name, int n) {
        int[] res = new int[n];
        String result = Reader.read(name);
        Pattern pattern = Pattern.compile("(-?)\\d+");
        Matcher matcher = pattern.matcher(result);
        int i = 0;
        while (matcher.find() && i < n) {
            res[i++] = Integer.valueOf(matcher.group());
        }
        return res;
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }
        int i = start, j = end;
        int q = i - (i - j) / 2;
        while (i < j) {
            while (i < q && (arr[i] <= arr[q])) {
                i++;
            }
            while (j > q && (arr[q] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == q) {
                    q = j;
                } else if (j == q) {
                    q = i;
                }
            }
        }
        quickSort(arr, start, q);
        quickSort(arr, q + 1, end);

        return arr;
    }

    public static void main(String[] args) throws IOException {
        int n = 10;
        String name = "part2.txt";
        writeRandomNumber(name, n);
        System.out.println("input ==> " + Reader.read(name));
        int[] arr = quickSort(readArray(name, n), 0, n - 1);
        String name2 = "part2_sorted.txt";
        writeArray(arr, name2);
        System.out.println("output ==> " + Reader.read(name2));
    }


}