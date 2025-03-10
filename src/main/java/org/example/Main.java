package org.example;

public class Main {
    public static void main(String[] args) {
        // Palindrom testleri
        System.out.println("Palindrom Testleri:");
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));   // true
        System.out.println(isPalindrome(11212)); // false

        // Mükemmel sayı testleri
        System.out.println("\nMükemmel Sayı Testleri:");
        System.out.println("6 is perfect number: " + isPerfectNumber(6));    // true
        System.out.println("28 is perfect number: " + isPerfectNumber(28));  // true
        System.out.println("5 is perfect number: " + isPerfectNumber(5));    // false
        System.out.println("-1 is perfect number: " + isPerfectNumber(-1));  // false

        // Sayıları kelimelere dönüştürme testleri
        System.out.println("\nSayıları Kelimelere Dönüştürme Testleri:");
        System.out.println(numberToWords(123));  // One Two Three
        System.out.println(numberToWords(1010)); // One Zero One Zero
        System.out.println(numberToWords(-12));  // Invalid Value
    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        number = Math.abs(number); // Negatif sayılar için mutlak değer alıyoruz

        int reversed = 0;
        int temp = number;

        while (temp > 0) {
            int lastDigit = temp % 10; // Son rakamı al
            reversed = reversed * 10 + lastDigit; // Yeni ters sayıyı oluştur
            temp /= 10; // Son rakamı at
        }

        return number == reversed; // Orijinal sayı (mutlak değer) ile tersini karşılaştır
    }

    /**
     * Bir sayının mükemmel sayı olup olmadığını kontrol eder.
     * Mükemmel sayı: Kendisi hariç pozitif bölenlerinin toplamı kendisine eşit olan sayı.
     * Örnek: 6 için bölenler: 1,2,3 => 1+2+3=6
     * @param number Kontrol edilecek sayı
     * @return Sayı mükemmel ise true, değilse false
     */
    public static boolean isPerfectNumber(int number) {
        // 0 veya negatif sayılar mükemmel sayı olamaz
        if (number <= 0) {
            return false;
        }

        // Bölenlerinin toplamını tutacak değişken
        int sumOfDivisors = 0;

        // 1'den başlayarak sayının karekökü kadar olan bölenlerini bul
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                // i bir bölen ise toplama ekle
                sumOfDivisors += i;

                // Eğer i sayının karekökünden farklı ve number/i sayının kendisinden farklı ise
                // diğer böleni de ekle
                if (i != Math.sqrt(number) && i != 1) {
                    sumOfDivisors += number / i;
                }
            }
        }

        // Sayı mükemmel sayı mı kontrol et
        return sumOfDivisors == number;
    }

    /**
     * Sayıyı kelime olarak ifade eder.
     * Her bir rakamı İngilizce kelime olarak döndürür.
     * @param number Dönüştürülecek sayı
     * @return Sayının kelime karşılığı veya negatif sayılar için "Invalid Value"
     */
    public static String numberToWords(int number) {
        // Negatif sayı kontrolü
        if (number < 0) {
            return "Invalid Value";
        }

        // Sayıyı stringe çevirip her bir rakamı kelimeye dönüştüreceğiz
        String[] words = {"Zero", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine"};

        // Sayı 0 ise direkt "Zero" döndür
        if (number == 0) {
            return words[0];
        }

        StringBuilder result = new StringBuilder();

        // Sayıyı string'e çevir ve her rakamı tek tek işle
        String numStr = String.valueOf(number);
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            result.append(words[digit]);

            // Son rakam değilse boşluk ekle
            if (i < numStr.length() - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}

