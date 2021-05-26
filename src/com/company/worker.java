package com.company;

public class worker extends human{
    String posada;
    double zarplata;
    String ustanowa;

    worker (){ //  1 конструктор без параметрів
        super(); // виклик 1 конструктора з класу human
        posada="_";
        ustanowa="_";
        zarplata=0;
    }

    worker (String n, String sn, int bd, String Psd, double zrp, String ust){ // "перегружений" 2 конструктор з шістьмома параметрами
        super(n,sn,bd); // виклик 2 конструктора з класу human
        posada=Psd;
        ustanowa=ust;
        zarplata=zrp;
    }

    worker (String n, String sn, int bd, human F, human M, human[] C, String Psd, double zrp, String ust){ // "перегружений" 3 конструктор з дев'ятьма параметрами
        super(n,sn,bd,F,M,C); // виклик 3 конструктора з класу human
        posada=Psd;
        ustanowa=ust;
        zarplata=zrp;
    }

    String Druk (){ // перевизначений метод
        return name+" "+surname+" "+birth+" "+posada+" "+ustanowa+" ";
        //System.out.println("Ім'я: "+name+". Фамілія: "+surname+". Рік народження: "+birth+". Посада: "+posada+". Установа: "+ustanowa);
    }
}
