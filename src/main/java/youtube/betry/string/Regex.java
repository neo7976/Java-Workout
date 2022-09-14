package youtube.betry.string;

/**
 * https://regexlearn.com/learn/regex101
 */
public class Regex {
    public static void main(String[] args) {
        String s1 = "Пиво ПиIо ПиYо";

        //Прописываем в скобках символы и буквы, которые могут содержаться, тогда будет совпадение слова и замена совершится
        // стр. 5
        System.out.println(s1.replaceAll("Пи[IY]о", "1")); // (стр 5.)
        System.out.println(s1.replaceAll("Пи[^в]о", "5")); //заменить любой кроме 'в' (стр.6)
        String alfa = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(alfa.replaceAll("[e-o]", "1")); //заменяет в диапазоне  (стр.7)

    }
}
