package utez.edu.mx.foodOrders.utils;

public enum Food {
    ENCHILADAS(100),
    POLLO(80),
    TACOS(60),
    BURRITOS(90),
    QUESADILLAS(70),
    SOPA_DE_FIDEO(50),
    PIZZA(120),
    HAMBURGUESA(110),
    SUSHI(150),
    PASTEL(50),
    TACOS_AL_PASTOR(65),
    GUACAMOLE(40),
    PASTA(85),
    ARROZ(40),
    ENSALADA(45),
    PULPO(180),
    COCA_COLA(25),
    FRIJOLES(35),
    TORTAS(75),
    PAPA_FRITA(30),
    PESCADO(160),
    CALDOS(55),
    ALITAS(95),
    SANDWICH(65),
    HOT_DOG(50),
    GARNACHAS(40),
    NACHOS(45),
    JARRITO(30),
    MOLE(110),
    CHILAQUILES(70);

    private final double price;

    Food(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}