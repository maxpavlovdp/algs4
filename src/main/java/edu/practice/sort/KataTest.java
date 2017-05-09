package edu.practice.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Maksym Pavlov on 5/4/17.
 */
public class KataTest {
    @Test
    public void countBits() throws Exception {
        assertEquals(5, Kata.countBits(1234));
    }

    @Test
    public void sort() {

        int[] actual = Kata.sortByValueAndIndex(new int[]{1, 2, 3, 4, 5});
        int[] expected = new int[]{1, 2, 3, 4, 5};
        String message = "Your result:\n" + arrayToString(actual) + "\n\nExpected result:\n" + arrayToString(expected) + "\n\n";
        assertEquals(message, arrayToString(expected), arrayToString(actual));

        actual = Kata.sortByValueAndIndex(new int[]{23, 2, 3, 4, 5});
        expected = new int[]{2, 3, 4, 23, 5};
        message = "Your result:\n" + arrayToString(actual) + "\n\nExpected result:\n" + arrayToString(expected) + "\n\n";
        assertEquals(message, arrayToString(expected), arrayToString(actual));

        actual = Kata.sortByValueAndIndex(new int[]{26, 2, 3, 4, 5});
        expected = new int[]{2, 3, 4, 5, 26};
        message = "Your result:\n" + arrayToString(actual) + "\n\nExpected result:\n" + arrayToString(expected) + "\n\n";
        assertEquals(message, arrayToString(expected), arrayToString(actual));

        actual = Kata.sortByValueAndIndex(new int[]{9, 5, 1, 4, 3});
        expected = new int[]{1, 9, 5, 3, 4};
        message = "Your result:\n" + arrayToString(actual) + "\n\nExpected result:\n" + arrayToString(expected) + "\n\n";
        assertEquals(message, arrayToString(expected), arrayToString(actual));
    }

    private String arrayToString(int[] array) {
        return Arrays.toString(array);
    }

    @Test
    public void lineupStudents_BasicTest1() {
        String[] expectedResult = {"Takehiko","Takayuki", "Takahiro","Takeshi","Takeshi","Takashi","Tadashi","Takeo","Takao"};
        assertArrayEquals(expectedResult, Kata.lineupStudents("Tadashi Takahiro Takao Takashi Takayuki Takehiko Takeo Takeshi Takeshi"));
    }
    @Test
    public void lineupStudents_BasicTest2() {
        String[] expectedResult = {
                "Yoshimitsu", "Yoshiyuki", "Yoshinori", "Yoshikazu", "Yoshihiro", "Toshiyuki",
                "Toshihiro", "Shigekazu", "Yoshiaki", "Yasuhiro", "Yasahiro", "Tsuyoshi","Toshiaki",
                "Takehiko", "Takayuki", "Takahiro", "Shunichi", "Shinichi","Shichiro",
                "Nobuyuki", "Yoshito", "Yoshiro", "Yasushi", "Tsutomu","Tetsuya", "Tatsuya",
                "Tamotsu", "Takeshi", "Takeshi", "Takashi","Tadashi", "Shuichi", "Shoichi",
                "Shigeru", "Senichi", "Seiichi","Satoshi", "Ryuichi", "Ryoichi", "Mitsuru",
                "Yuichi", "Yoshio","Yoichi", "Tsuneo", "Toshio", "Tetsip", "Tatsuo", "Takumi",
                "Susumu", "Shinji", "Shigeo", "Satoru", "Samuru", "Saburo","Rokuro", "Raiden",
                "Noboru", "Mitsuo", "Minoru", "Minori", "Michio", "Yoshi", "Yemon", "Yasuo",
                "Uyeda", "Toshi", "Tomio","Teruo", "Takeo", "Takao", "Tadao", "Shuji", "Shoji",
                "Shiro", "Shima", "Seiji", "Sadao", "Ryozo", "Ryota", "Ronin", "Ringo", "Osamu",
                "Norio", "Nobuo", "Naoko", "Naoki", "Mikio", "Yuki", "Yuji", "Yori", "Yogi",
                "Toyo", "Toru", "Tomi", "Taro", "Tama", "Shin", "Shig", "Ryuu", "Rafu", "Nori",
                "Nobu", "Miki", "Ryo", "Nao"};
        assertArrayEquals(expectedResult, Kata.lineupStudents("Michio Miki Mikio Minori Minoru Mitsuo Mitsuru Nao Naoki Naoko Noboru Nobu Nobuo Nobuyuki Nori Norio Osamu Rafu Raiden Ringo Rokuro Ronin Ryo Ryoichi Ryota Ryozo Ryuichi Ryuu Saburo Sadao Samuru Satoru Satoshi Seiichi Seiji Senichi Shichiro Shig Shigekazu Shigeo Shigeru Shima Shin Shinichi Shinji Shiro Shoichi Shoji Shuichi Shuji Shunichi Susumu Tadao Tadashi Takahiro Takao Takashi Takayuki Takehiko Takeo Takeshi Takeshi Takumi Tama Tamotsu Taro Tatsuo Tatsuya Teruo Tetsip Tetsuya Tomi Tomio Toru Toshi Toshiaki Toshihiro Toshio Toshiyuki Toyo Tsuneo Tsutomu Tsuyoshi Uyeda Yasahiro Yasuhiro Yasuo Yasushi Yemon Yogi Yoichi Yori Yoshi Yoshiaki Yoshihiro Yoshikazu Yoshimitsu Yoshinori Yoshio Yoshiro Yoshito Yoshiyuki Yuichi Yuji Yuki"));
    }

    @Test
    public void testSortItOut_1() {
        assertArrayEquals(Kata.sortItOut(new Double[] {11d,22d,33d,44d,55d,55d,90.4,4d,78d}), new Double[] { 11d,33d,55d,55d,90.4,78d,44d,22d,4d});
    }

    @Test
    public void testSortItOut_2() {
        assertArrayEquals(Kata.sortItOut(new Double[] {26d,243d,52d,2d,432414d,1d,11d,46d,32d}), new Double[] {1d,11d,243d,432414d,52d,46d,32d,26d,2d});
    }
    @Test
    public void testSortItOut_3() {
        assertArrayEquals(Kata.sortItOut(new Double[] {19d,65d,88d,112d,60d,14d,33d,49d,88d}), new Double[] {19d,33d,49d,65d,112d,88d,88d,60d,14d});
    }
    @Test
    public void testSortItOut_4() {
        assertArrayEquals(Kata.sortItOut(new Double[0]),(new Double[0]));
    }
    @Test
    public void testSortItOut_5() {
        assertArrayEquals(Kata.sortItOut(new Double[] {68d,25d,99d,50d,10d,67d,2d,5d,8d,34d,67d}), new Double[] {5d,25d,67d,67d,99d,68d,50d,34d,10d,8d,2d});
    }
}