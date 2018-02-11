/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ccojo
 */
public class GuessTheMovie {
    Scanner scanner;
    Scanner scannerInput;
    File moviesFile;
    
    ArrayList<String> moviesArrayList = new ArrayList();
    
    String movieToGuess;
    
    char[] movieCharArray;
    char[] underscoreCharArray;
    
    int wrongCount = 0;
    ArrayList<Character> wrongGuesses = new ArrayList();
    
    public static void main(String[] args) {
        GuessTheMovie letsPlay = new GuessTheMovie();
        letsPlay.scanFile();
        letsPlay.chooseRandomMovie(letsPlay.moviesArrayList);
        letsPlay.printInitial();
    }
    
    public void printInitial(){
        System.out.println("Guess the movie name!");
        System.out.println("The title has " + movieToGuess.length() + " letters (including any spaces or other characters)");
        for(int i = 0; i < movieToGuess.length(); i++){
            underscoreCharArray[i] = '_';
        }
        System.out.println("You are guessing: " + printCharArrayAsString(underscoreCharArray));
        System.out.println("Input your first guess: ");
    }
    
    public void printAfterGuesses(char c){
        for(int i = 0; i < movieToGuess.length(); i++){
            if(movieCharArray[i] == c){
                underscoreCharArray[i] = c;
            }
        }
        System.out.println("You are guessing: " + printCharArrayAsString(underscoreCharArray));
    }
    
    public void scanFile(){
        try {
            moviesFile = new File("src/files/movies.txt");
            scanner = new Scanner(moviesFile);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found!");
            return;
        }
        
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            moviesArrayList.add(line);
        }
    }
    
    public void chooseRandomMovie(ArrayList<String> arrayList){
        int numberOfMovies = arrayList.size();
        int randomMovieNumber = (int) (Math.random() * numberOfMovies);
        movieToGuess = arrayList.get(randomMovieNumber);
        System.out.println("Title to guess is: " + movieToGuess + " (to be removed)");
        movieCharArray = new char[movieToGuess.length()];
        underscoreCharArray = new char[movieToGuess.length()];
        for(int i = 0; i < movieToGuess.length(); i++){
            movieCharArray[i] = movieToGuess.charAt(i);
        }
    }
    
    public String printCharArrayAsString(char[] charArray){
        String toBeReturned = "";
        for(int i = 0; i < charArray.length; i++){
            toBeReturned += charArray[i] + " ";
        }
        return toBeReturned;
    }
}
