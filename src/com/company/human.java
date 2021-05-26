package com.company;

public class human {

    String name;
    String surname;
    int birth;
    human Father;
    human Mother;
    human[] Children;

    human() { //  1 конструктор без параметрів
        name="_";
        surname="_";
        birth=0;
        Father=null;  // значення null це пуста адреса пам'яті
        Mother=null;
        Children=null;
    }

    human(String nameValue, String surnameValue, int birthValue) {  // "перегружений" 2 конструктор з трьома параметрами
        name = nameValue;
        surname = surnameValue;
        birth = birthValue;
        Father=null;
        Mother=null;
        Children=null;
    }

    human(String nameValue, String surnameValue, int birthValue, human F, human M, human[] C) { // "перегружений" 3 конструктор з шістьмома параметрами
        name = nameValue;
        surname = surnameValue;
        birth = birthValue;
        Father=F;
        Mother=M;
        Children=C;
    }

    String Druk (){ // метод, що буде перевизначений в похідному класі worker
        return name+" "+surname+" "+birth;
        //System.out.println(name+" "+surname+" "+birth);
    }
}
