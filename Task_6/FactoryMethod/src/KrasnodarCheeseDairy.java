public class KrasnodarCheeseDairy extends CheeseDairy {
    @Override
    protected Cheese createCheese(CheeseType type) {
        Cheese cheese = null;
        switch (type) {
            case GOUDA:
                cheese = new KrasnodarCheeseGouda();
                break;
            case CHEDDAR:
                cheese = new KrasnodarCheeseCheddar();
                break;
            case PARMESAN:
                cheese = new KrasnodarCheeseParmesan();
                break;
        }
        return cheese;
    }
}

class KrasnodarCheeseGouda extends Cheese {
}

class KrasnodarCheeseParmesan extends Cheese {
}

class KrasnodarCheeseCheddar extends Cheese {
}