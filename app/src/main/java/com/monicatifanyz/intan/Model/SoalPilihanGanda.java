package com.monicatifanyz.intan.Model;

public class SoalPilihanGanda {

    //  Questions array
    public String mQuestions [] = {
            "1.\tCerita fantasi “Nina dan Korek Api Ajaib”  tidak bisa terjadi dalam dunia nyata karena tidak akan ada korek api yang bisa mengabulkan permintaan.",
            "2.\tCerita fantasi “Misteri Saudara Kembar Sara” memiliki keunikan sikap pada tokohnya yang bernama Sara, ia bisa melihat bayangan masa depan.",
            "3.\tCerita fantasi “Nina dan Korek Api Ajaib” tidak memiliki keunikan sikap pada tokohnya yang bernama Sara.",
            "4.\tCerita fantasi “Misteri Saudara Kembar Sara” memiliki rangkaian peristiwa yang diwali dari rumah Sara bocor dan mengungsi di rumah kakeknya.",
            "5.\tCerita fantasi “Nina dan Korek Api Ajaib” memiliki rangkaian peristiwa yang diakhiri dengan tangisan sedih oleh tokoh Nina.",
            "6.\tSebagian peristiwa dalam Cerita fantasi “Misteri Saudara Kembar Sara” bisa terjadi di dunia nyata seperti ketika Sara menerobos ruang masa lalu.",
            "7.\tCerita fantasi “Misteri Saudara Kembar Sara” tidak memiliki peristiwa aneh yakni Sara bisa menerobos ruang masa lalu melalui jam dinding.",
            "8.\t Cerita fantasi “Nina dan Korek Api Ajaib” memiliki peristiwa aneh yakni Nina diberi seorang kakek sebuah korek api ajaib yang bisa mengabulkan permintaan.",
            "9.\tPeristiwa dalam Cerita fantasi “Misteri Saudara Kembar Sara” tidak bisa terjadi di dunia nyata karena tidak mungkin seseorang bisa menembus ruang masa lalu.",
            "10.\tPeristiwa dalam Cerita fantasi “Nina dan Korek Api Ajaib” bisa terjadi di dunia nyata karena korek api ajaib ada di dunia nyata."

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
            "Benar",
            "Salah",
            "Benar",
            "Benar",
            "Salah",
            "Salah",
            "Benar",
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