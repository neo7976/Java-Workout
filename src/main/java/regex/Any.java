package regex;

public class Any {

        public static void main(String[] args) {
            String Str = new String("Добро пожаловать на ProgLang.su");

            System.out.print("Возвращаемое значение: ");
            System.out.println(Str.replaceAll("(.*)ProgLang(.*)",
                    "IAMGROOT"));

            System.out.print("Возвращаемое значение: ");
            System.out.println(Str.replaceAll("ProgLang.su",
                    "сайт посвященный программированию!"));

            String inputString = "Это просто 2016 2014 строка 98765 в 000101 Java 1101001";

            // заменяем все цифры и числа на пустоту
            String result = inputString.replaceAll("[0-9]+", "");
            // выведет в консоль 'Это просто   строка  в  Java'
            System.out.println(result);

            // заменяем все буквы и слова на слово Java
            String result1 = inputString.replaceAll("[а-яА-я]+", "Java");
            // выведет в консоль 'Java Java 2016   2014 Java 98765 Java 000101 Java 1101001'
            System.out.println(result1);

            String resul = inputString.replaceAll("[a-zA-z]+", "Привет");
            System.out.println(resul);
        }
    }

