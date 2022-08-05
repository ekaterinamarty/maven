package lesson4;

    //1. Напишите функцию, вычисляющую площадь треугольника по трём сторонам (int a, int b, int c).

public class Triangle {
    public static double Area(int a, int b, int c) {
        double p = .5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static double AreaWithCheck(int a, int b, int c) {
        if (a <= 0) throw new IllegalArgumentException("Parameter 'a' must be greater than 0.");
        if (b <= 0) throw new IllegalArgumentException("Parameter 'b' must be greater than 0.");
        if (c <= 0) throw new IllegalArgumentException("Parameter 'c' must be greater than 0.");
        double p = .5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

