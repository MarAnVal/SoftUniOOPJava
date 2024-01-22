package ShoppingSpree;

class Validations {
    static void validateName(String name){
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    static void validateMoney(double money){
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }
}
