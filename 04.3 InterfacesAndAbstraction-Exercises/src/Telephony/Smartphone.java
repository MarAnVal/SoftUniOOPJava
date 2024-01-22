package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        setNumbers(numbers);
        setUrls(urls);
    }

    private void setNumbers(List<String> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            String currentNumber = numbers.get(i);
            if (includeLetters(currentNumber)){
                numbers.set(i, "Invalid number!");
            } else {
                numbers.set(i, "Calling... " + currentNumber);
            }
        }
        this.numbers = numbers;
    }

    private void setUrls(List<String> urls) {
        for (int i = 0; i < urls.size(); i++) {
            String currentNumber = urls.get(i);
            if (includeDigits(currentNumber)){
                urls.set(i, "Invalid URL!");
            } else {
                urls.set(i, "Browsing: " + currentNumber + "!");
            }
        }
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < urls.size(); i++) {
            if (i < urls.size() - 1){
                text.append(urls.get(i));
                text.append(System.lineSeparator());
            } else {
                text.append(urls.get(i));
            }
        }
        return text.toString();
    }

    @Override
    public String call() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (i < numbers.size() - 1){
                text.append(numbers.get(i));
                text.append(System.lineSeparator());
            } else {
                text.append(numbers.get(i));
            }
        }
        return text.toString();
    }
    private boolean includeDigits(String text){
        for (int i = 0; i < text.length(); i++) {
            if(Character.isDigit(text.charAt(i))){
                return true;
            }
        }
        return false;
    }
    private boolean includeLetters(String text){
        for (int i = 0; i < text.length(); i++) {
            if(!Character.isDigit(text.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
