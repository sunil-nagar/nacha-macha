package temp;

import java.util.Random;
import java.lang.Math;

public class DataGenerator {

    public DataGenerator() {
    }

    public int number(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(min, max + 1);
        return randomNumber;
    }

    public int number(int len) {
        int min = (int) Math.pow(10, len - 1);
        int max = min * 10 - 1;
        return number(min, max);
    }

    public String date() {
        String year = "" + number(24, 25);
        String month = padleft("" + number(1, 12), '0', 2);
        String date = padleft("" + number(1, 31), '0', 2);
        return year + month + date;
    }

    public String time() {
        String hour = padleft("" + number(0, 23), '0', 2);
        String minute = padleft("" + number(0, 59), '0', 2);
        return hour + minute;
    }

    public String letter(int p) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return "" + letters.charAt(p);
    }

    public String routingNumber() {
        return " " + number(9);
    }

    public String federalId() {
        return "1" + number(9);
    }

    public String bankName() {
        String bankName = DataBankNames.DATA[number(0, DataBankNames.DATA.length - 1)];
        if (bankName.length() > 15)
            bankName = bankName.substring(0, 15);
        return padright(bankName + " Bank", ' ', 23);
    }

    public String companyName() {
        String companyName = DataCompanyNames.DATA[number(0, DataCompanyNames.DATA.length - 1)];
        if (companyName.length() > 20)
            companyName = companyName.substring(0, 20);
        return padright(companyName, ' ', 23);
    }

    public String serviceClassCode() {
        return pickone(new String[] {"200", "220", "225"});
    }

    public String standardEntryClassCode() {
        return pickone(new String[] {"PPD", "CCD"});
    }

    public String companyEntryDescription() {
        return pickone(new String[] {"Payroll   ", "Payables  "});
    }

    public String transactionCode() {
        return pickone(new String[] {"22", "32", "27", "37"});
    }

    

    public String padleft(String data, char c, int len) {
        while (data.length() < len) {
            data = c + data;
        }
        return data;
    }

    public String padright(String data, char c, int len) {
        while (data.length() < len) {
            data = data + c;
        }
        return data;
    }

    public String pickone(String[] data) {
        int number = number(0, data.length-1);
        return data[number];
    }

    public static void main(String[] args) {
        System.out.println("\n\n");
        DataGenerator dataGenerator = new DataGenerator();
        System.out.println(dataGenerator.number(9));
        System.out.println(dataGenerator.routingNumber());
        System.out.println(dataGenerator.date());
        System.out.println(dataGenerator.time());
        System.out.println(dataGenerator.letter(3));
        System.out.println(dataGenerator.bankName());
        System.out.println(dataGenerator.companyName());

    }

}
