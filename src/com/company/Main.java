package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        List<String> lines = readMovesFromFile("resources/sample-moves-invalid.txt");

        Board board = new Board();
        board.play(lines);

    }

    private static List<String> readMovesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            lines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("File name is incorrect!");
            //e.printStackTrace();
        }
        return lines;
    }
}
