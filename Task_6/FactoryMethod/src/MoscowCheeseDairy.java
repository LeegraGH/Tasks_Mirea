public class MoscowCheeseDairy extends CheeseDairy {
    @Override
    protected Cheese createCheese(CheeseType type) {
        Cheese cheese = null;
        switch (type) {
            case GOUDA:
                cheese = new MoscowCheeseGouda();
                break;
            case CHEDDAR:
                cheese = new MoscowCheeseCheddar();
                break;
            case PARMESAN:
                cheese = new MoscowCheeseParmesan();
                break;
        }
        return cheese;
    }
}

class MoscowCheeseGouda extends Cheese {
}

class MoscowCheeseParmesan extends Cheese {
}

class MoscowCheeseCheddar extends Cheese {
}