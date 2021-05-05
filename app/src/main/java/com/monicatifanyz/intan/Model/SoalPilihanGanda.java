package com.monicatifanyz.intan.Model;

public class SoalPilihanGanda {

    //  Questions array
    public String mQuestions [] = {
            "1.\tCerita fantasi “Tiga Anak Saudara dan Raja Labu” menceritakan seorang anak baik yang tinggal bersama kakeknya",
            "2.\tTokoh dalam cerita fantasi “Tiga Anak Saudara dan Raja Labu” adalah  tiga anak saudara yang bernama Tana, Tini dan Tono.",
            "3.\tDalam cerita fantasi “Tiga Anak Saudara dan Raja Labu” tersebut, tokoh tini memiliki sifat ceroboh.",
            "4.\tPeristiwa dalam cerita fantasi “Tiga Anak Saudara dan Raja Labu” bisa menggunakan sudut pandang orang pertama.",
            "5.\tCerita fantasi “Tiga Anak Saudara dan Raja Labu” menceritakan sebuah peristiwa berlatarkan kota besar.",
            "6.\tPeristiwa yang diceritakan dalam Cerita fantasi “Tiga Anak Saudara dan Raja Labu” tersebut menggunakan alur maju.",
            "7.\tKetiga tokoh dalam Cerita fantasi “Tiga Anak Saudara dan Raja Labu”  memiliki sifat yang sama.",
            "8.\tCerita fantasi “Tiga Anak Saudara dan Raja Labu” menceritakan sebuah peristiwa berlatarkan rumah kakek dan hutan.",
            "9.\tTokoh kakek dalam Cerita fantasi “Tiga Anak Saudara dan Raja Labu” memiliki sifat pemberani",
            "10.\tCerita fantasi “Tiga Anak Saudara dan Raja Labu” menggambarkan peristiwa dengan suasana yang sangat menyenangkan. "

    };

    //  Answers array
    private String mChoices [][] = {
            {"Benar", "Salah"},
            {"Benar", "Salah"},
            {"Benar", "Salah"},
            {"Benar", "Salah"},
            {"Benar", "Salah"},
            {"Benar", "Salah"},
            {"Benar", "Salah"},
            {"Benar", "Salah"},
            {"Benar", "Salah"},
            {"Benar", "Salah"}
    };

    //  Correct answers array
    private String mCorrectAnswers[] = {
            "Salah",
            "Benar",
            "Benar",
            "Salah",
            "Salah",
            "Benar",
            "Salah",
            "Benar",
            "Benar",
            "Salah"

    };

    //  pulling text for question
    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    //  pulling text for 1st choice button
    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    //  pulling text for 2nd choice button
    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
//  pulling text for 3rd choice button


    //  pulling correct answer
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}