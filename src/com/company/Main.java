package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
    /*  human[] person=new human[6];   // масив людей в який будуть записані і human і worker
        person[0]=new human("A", "B", 1921);                // 2 конструктор human
        person[1]=new worker("C", "D", 1921,"Rob1",6000,"Ust1");    // 2 конструктор worker
        person[2]=new human("E", "F", 1970,person[0],person[1],null ); // 3 конструктор human
        person[3]=new human();                  // 1 конструктор human
        person[4]=new worker();                 // 1 конструктор worker
        person[5]=new worker("G", "H", 1957,person[2],person[4], null, "Rob2",6000,"Ust2");  // 3 конструктор worker
        for (human h: person) // цикл, в якому змінна h від першого до останнього присвоїть всі значення з масиву person
            h.Druk();  // друк людей методом Druk, який перевизначений у класах human і worker, тому викликатиметься з того класу, з якого буде черговий елемент масиву person
    */
//############################################################################### Запис масиву людей в файл a.txt ###################################################
        human[] h={new human("a"," ",1990),
                new human("b","B",1991),
                new human("c","C",1992),};

        FileWriter fw = new FileWriter("a.txt"); // створення об'єкта класу що зчитує текст з файлу, параметром має бути ім'я файлу що знаходиться в папці проєкту «people»
        //FileWriter fw = new FileWriter("C:\\Users\\Hun\\Desktop\\u.txt"); - якщо файл не в папці проєкту, то необхідно вказати повний шлях до нього
        for (human l:h) {    // цикл, що проведе змінну l по всіх елементах масиву людей h
            fw.write(l.Druk());     // метод write класу FileWriter записує передане йому значення типу String в файл
            fw.write("\n");     // запис переходу на новий рядок
        }
        fw.close();     // закриття записувача в файл
        System.out.println("Масив людей h записано в файл а.txt");
//############################################################################## Зчитування масиву людей з файла a.txt ################################################
        ArrayList<human> mas= new ArrayList<>();    // "динамічний масив"(тобто із змінною довжиною) людей
        FileReader fr = new FileReader("a.txt");    // створення об'єкта класу що записує текст в файл, параметром має бути ім'я файлу що знаходиться в папці проєкту «people»
        String nm,sn,ryadok;   // змінні, куди записуватимуться ім'я, прізвище з поточного рядка та сам рядок з файла
        int by=0;   // змінна, куди записуватиметься рік народження з поточного рядка
        Scanner scf=new Scanner(fr);    // сканер для сканування рядків в файлі
        Scanner scr;    // сканер для сканування слів в рядку

        while(scf.hasNext()){       // поки далі в файлі щось є
            ryadok=scf.nextLine();    // зчитуємо черговий рядок
            scr=new Scanner(ryadok);    // передаємо сканеру для рядка цей рядок
            if (scr.hasNext())      // якщо далі в рядку слово(перше)
                nm=scr.next();      // то записуємо його в змінну для імені
            else continue;          // інакше пропускаємо всі наступні команди цього витка цикла і переходимо на наступний виток
            if (scr.hasNext())      // якщо далі в рядку слово(друге)
                sn=scr.next();      // то записуємо його в змінну для прізвища
            else continue;
            if (scr.hasNextInt())   // якщо далі в рядку ціле число
                by=scr.nextInt();   // то записуємо його в змінну для дати народження
            else continue;
            scr.close(); // закриття сканера рядка
            mas.add(new human(nm,sn,by));   // додаємо, з допомогою методу add класу ArrayList, в масив нову людину
        }
        scf.close(); // закриття сканера файла
        fr.close(); // закриття зчитувача файла

        System.out.println("Масив людей зчитано з файлу а.txt:");
        for (human l:mas)       // цикл, що проведе змінну l по всіх елементах масиву людей mas
            System.out.println(l.Druk());   // і роздрукує кожну людину
//################################################## Зчитування з файла t.txt по рядках, видалення слів і запис в інший файл tred.txt ##############################################
        StringBuffer sb= new StringBuffer("w");     // клас StringBuffer - динамічний аналог класу String, тому в sb можна записати слово будь якої довжини і потім як завгодно міняти
        int i=0;    // змінна, куди записуватиметься позиція в рядку першої букви слова що треба видалити в рядку
        scf=new Scanner(new FileReader("t.txt"));      // створення для змінної сканера нового об'єкта сканера з нового об'єкта зчитувача файла з файла t.txt
        fw=new FileWriter("tred.txt");      // створення для змінної записувача в файл нового об'єкта записувача в файл в файл tred.txt

        while(scf.hasNext()){       // поки далі в файлі щось є
            sb.delete(0,sb.length());   // очистити попередній рядок(тобто з нульової позиції до наступної після останньої)
            sb.append(scf.nextLine());  // записати наступний рядок
            i=sb.indexOf("формата");    // отримати індекс(позицію) першого символа першого знайденого слова "формата", якщо такого нема, то запишеться -1
            while (i!=-1){              // доки не буде слів "формата"
                sb.delete(i,i+7);       // видаляти знайдене перше слово з рядка
                i=sb.indexOf("формата");    // та шукати наступне
            }
            fw.write(sb.toString());    // після циклу не залишиться жодного слова "формата", тому записуємо очищений рядок в файл
            fw.write("\n");         // та дописуємо перехід на новий рядок
        }
        scf.close();    // закриття сканера файла
        fw.close();     // закриття записувача в файл
        System.out.println("Текст з файлу t записано в файл tred без слів \"формата\"");
    }
}