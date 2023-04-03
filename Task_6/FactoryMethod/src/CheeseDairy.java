public abstract class CheeseDairy {

    public Cheese orderCheese(CheeseType type){
        Cheese cheese = createCheese(type);
        cheese.makeCheese();
        return cheese;
    }
    protected abstract Cheese createCheese(CheeseType type);
}
