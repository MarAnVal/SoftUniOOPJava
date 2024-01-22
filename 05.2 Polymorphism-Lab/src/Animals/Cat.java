package Animals;

class Cat extends Animal{

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("I am %s and my favourite food is %s", this.getName(), this.getFavouriteFood()));
        text.append(System.lineSeparator());
        text.append("MEEOW");
        return text.toString();
    }
}
