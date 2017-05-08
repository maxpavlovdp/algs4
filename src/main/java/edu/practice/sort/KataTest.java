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
}