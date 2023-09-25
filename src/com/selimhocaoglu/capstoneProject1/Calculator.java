package com.selimhocaoglu.capstoneProject1;


import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Calculator {
    String ourLine;
    private String targetWord;
    private String ourXNumber;
    private String ourYNumber;
    private String ourLineTest;
    private boolean hasError = false;


    public Calculator(Scanner ourLine){
        this.ourLine = String.valueOf(ourLine);
    }

    public void Calculate(){
        sqrtCalculator();
        powCalculator();
        sinCalculator();
        cosCalculator();
        tanCalculator();
    }


    private void sqrtCalculator(){
        targetWord = "sqrt";
        ourXNumber = null;
        ourLineTest = ourLine;

        while(ourLineTest.contains(targetWord)){
            int indexOfWord = ourLine.indexOf(targetWord);
//Hata güncellemelerinde kullanılacak.            int indexOfWordLeftParenthesis = ourLine.indexOf("(");
            int indexOfWordRightParenthesis = ourLine.indexOf(")", indexOfWord);
            ourXNumber = ourLineTest.substring(indexOfWord + targetWord.length() + 1, indexOfWordRightParenthesis);
            double ourXNumberDoubleVersion = Math.sqrt(Double.parseDouble(ourXNumber));
            String StringVersionOfOurXNumberDoubleVersion = Double.toString(ourXNumberDoubleVersion);
            StringBuilder sb = new StringBuilder(ourLine);
            ourLine = String.valueOf(sb.delete(indexOfWord, indexOfWordRightParenthesis + 1));
            String firstPart = ourLine.substring(0, indexOfWord);
            String lastPart = ourLine.substring(indexOfWord);
            ourLine = firstPart.concat(StringVersionOfOurXNumberDoubleVersion.concat(lastPart));
            ourLineTest = String.valueOf(sb.delete(0, indexOfWord + 3));
        }
    }

    private void powCalculator(){//pow(x,y)
        targetWord = "pow";
        ourXNumber = null;
        ourYNumber = null;
        ourLineTest = ourLine;

        while(ourLineTest.contains(targetWord)){
            int indexOfWord = ourLine.indexOf(targetWord);
//Hata güncellemelerinde kullanılacak.            int indexOfWordLeftParenthesis = ourLine.indexOf("(");
            int indexOfWordRightParenthesis = ourLine.indexOf(")", indexOfWord);
            int indexOfWordComa = ourLine.indexOf(",");
            ourXNumber = ourLine.substring(indexOfWord + targetWord.length() + 1, indexOfWordComa);
            ourYNumber = ourLine.substring(indexOfWordComa + 1, indexOfWordRightParenthesis);
            double ourCalculationDoubleVersion = Math.pow(Double.parseDouble(ourXNumber), Double.parseDouble(ourYNumber));
            String StringVersionOfOurCalculationDoubleVersion = Double.toString(ourCalculationDoubleVersion);
            StringBuilder sb = new StringBuilder(ourLine);
            ourLine = String.valueOf(sb.delete(indexOfWord, indexOfWordRightParenthesis + 1));
            String firstPart = ourLine.substring(0, indexOfWord);
            String lastPart = ourLine.substring(indexOfWord);
            ourLine = firstPart.concat(StringVersionOfOurCalculationDoubleVersion.concat(lastPart));
            ourLineTest = String.valueOf(sb.delete(0, indexOfWord + 5));
        }
    }

    private void sinCalculator(){
        targetWord = "sin";
        ourXNumber = null;
        ourLineTest = ourLine;

        while(ourLineTest.contains(targetWord)){
            int indexOfWord = ourLine.indexOf(targetWord);
//Hata güncellemelerinde kullanılacak.            int indexOfWordLeftParenthesis = ourLine.indexOf("(");
            int indexOfWordRightParenthesis = ourLine.indexOf(")", indexOfWord);
            ourXNumber = ourLine.substring(indexOfWord + targetWord.length() + 1, indexOfWordRightParenthesis);
            double ourXNumberDoubleVersion = Math.sin(Math.toRadians(Double.parseDouble(ourXNumber)));
            BigDecimal sinCalculated = BigDecimal.valueOf(ourXNumberDoubleVersion).setScale(10, RoundingMode.HALF_UP);
            String sinCalculatedStringVersion = sinCalculated.toString();
            StringBuilder sb = new StringBuilder(ourLine);
            ourLine = String.valueOf(sb.delete(indexOfWord, indexOfWordRightParenthesis + 1));
            String firstPart = ourLine.substring(0, indexOfWord);
            String lastPart = ourLine.substring(indexOfWord);
            ourLine = firstPart.concat(sinCalculatedStringVersion.concat(lastPart));
            ourLineTest = String.valueOf(sb.delete(0, indexOfWord + 3));
        }
    }

    private void cosCalculator(){
        targetWord = "cos";
        ourXNumber = null;
        ourLineTest = ourLine;

        while(ourLineTest.contains(targetWord)){
            int indexOfWord = ourLine.indexOf(targetWord);
//Hata güncellemelerinde kullanılacak.            int indexOfWordLeftParenthesis = ourLine.indexOf("(");
            int indexOfWordRightParenthesis = ourLine.indexOf(")", indexOfWord);
            ourXNumber = ourLine.substring(indexOfWord + targetWord.length() + 1, indexOfWordRightParenthesis);
            double ourXNumberDoubleVersion = Math.cos(Math.toRadians(Double.parseDouble(ourXNumber)));
            BigDecimal cosCalculated = BigDecimal.valueOf(ourXNumberDoubleVersion).setScale(10, RoundingMode.HALF_UP);
            String cosCalculatedStringVersion = cosCalculated.toString();
            StringBuilder sb = new StringBuilder(ourLine);
            ourLine = String.valueOf(sb.delete(indexOfWord, indexOfWordRightParenthesis + 1));
            String firstPart = ourLine.substring(0, indexOfWord);
            String lastPart = ourLine.substring(indexOfWord);
            ourLine = firstPart.concat(cosCalculatedStringVersion.concat(lastPart));
            ourLineTest = String.valueOf(sb.delete(0, indexOfWord + 3));
        }
    }

    private void tanCalculator(){
        targetWord = "tan";
        ourXNumber = null;
        ourLineTest = ourLine;


        while(ourLineTest.contains(targetWord)){
            int indexOfWord = ourLine.indexOf(targetWord);
//Hata güncellemelerinde kullanılacak.            int indexOfWordLeftParenthesis = ourLine.indexOf("(");
            int indexOfWordRightParenthesis = ourLine.indexOf(")", indexOfWord);
            ourXNumber = ourLine.substring(indexOfWord + targetWord.length() + 1, indexOfWordRightParenthesis);
            double ourXNumberDoubleVersion = Math.tan(Math.toRadians(Double.parseDouble(ourXNumber)));
            BigDecimal tanCalculated = BigDecimal.valueOf(ourXNumberDoubleVersion).setScale(10, RoundingMode.HALF_UP);
            String tanCalculatedStringVersion = tanCalculated.toString();
            StringBuilder sb = new StringBuilder(ourLine);
            ourLine = String.valueOf(sb.delete(indexOfWord, indexOfWordRightParenthesis + 1));
            String firstPart = ourLine.substring(0, indexOfWord);
            String lastPart = ourLine.substring(indexOfWord);
            ourLine = firstPart.concat(tanCalculatedStringVersion.concat(lastPart));
            ourLineTest = String.valueOf(sb.delete(0, indexOfWord + 3));
        }
    }

    public void func() {
        String operators = "+-*/";
        StringTokenizer tokenizer = new StringTokenizer(ourLine, operators, true);
        String[] tokens = new String[tokenizer.countTokens()];
        Double[] d = new Double[tokens.length];
        int tokenIndex = 0;
        int functionParenthesesCounter = 0;

        while (tokenizer.hasMoreTokens()) {
            tokens[tokenIndex++] = tokenizer.nextToken();
        }

        for (int i = 0; i < tokens.length; i++){
            String token = tokens[i];
            if(operators.contains(token)){
                if(token.equals("(")){
                    functionParenthesesCounter++;
                }
                else if(token.equals(")")){
                    functionParenthesesCounter--;
                    if(functionParenthesesCounter < 0){
                        System.err.println("Hata!");
                        hasError = true;
                        break;
                    }
                }
                else if(plusMinusMultiplyDivideController(token) == false){
                    System.out.println("Hata");
                    hasError = true;
                    break;
                }
            }
            else {
                try {
                    d[i] = Double.parseDouble(token);
                } catch (NumberFormatException e){
                    if (functionController(token) == false){
                        System.out.println("Hata");
                        hasError = true;
                        break;
                    }
                }
            }

        }

        if (functionParenthesesCounter != 0){
            System.out.println("Hata");
            hasError = true;
        }



        for (int i = 0; i < tokens.length; i++) {
            if(operators.contains(tokens[i])){
                if(i > 0) {
                    if (d[i - 1] == null || d[i + 1] == null) {
                        System.out.println("Hata!");
                        hasError = true;
                        break;
                    }
                }
                else{
                    if(d[i + 1] == null){
                        System.out.println("Hata!");
                        hasError = true;
                        break;
                    }
                }
                if(tokens[i].equals("*")){
                    d[i + 1] = d[i - 1] * d[i + 1];
                    d[i] = null;
                    d[i - 1] = null;
                }
                else if(tokens[i].equals("/")){
                    d[i + 1] = d[i - 1] / d[i + 1];
                    d[i] = null;
                    d[i - 1] = null;
                }
                else if(tokens[i].equals("+")){
                    d[i + 1] = d[i - 1] + d[i + 1];
                    d[i] = null;
                    d[i - 1] = null;
                }
                else if(tokens[i].equals("-")){
                    d[i + 1] = d[i - 1] - d[i + 1];
                    d[i] = null;
                    d[i - 1] = null;
                }
            }
        }


        double sum = 0;
        if(hasError != true) {
            for (int i = 0; i < d.length; i++) {
                Double number = d[i];
                if (number != null) {
                    sum += number;
                }
            }
        }
        if (hasError != true) {
            System.out.println("Sonuç: " + sum);
        }
    }

    private boolean plusMinusMultiplyDivideController(String token){
        return token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-");
    }

    private boolean functionController(String token){
        return token.equals("sqrt") || token.equals("pow") || token.equals("sin") || token.equals("cos") || token.equals("tan");
    }
}
