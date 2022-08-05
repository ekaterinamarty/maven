package lesson4;

    //2. Разместите тесты на эту функцию в классе src/test/java/.../TriangleTest.java.

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger("TriangleTest");

    @Test
    @DisplayName("Проверка подсчета площади равностороннего треугольника, переданного в метод Triangle")
    void areaTestEquilateral () {
        logger.trace("Проверка подсчета площади равностороннего треугольника, переданного в метод Triangle");
        Assertions.assertEquals(ifTriangleIsEquilateral(1), Triangle.Area(1, 1, 1));
        Assertions.assertEquals(ifTriangleIsEquilateral(2), Triangle.Area(2, 2, 2));
        Assertions.assertEquals(ifTriangleIsEquilateral(3), Triangle.Area(3, 3, 3));
        Assertions.assertEquals(ifTriangleIsEquilateral(0), Triangle.Area(0, 0, 0));
        Assertions.assertEquals(ifTriangleIsEquilateral(256), Triangle.Area(256, 256, 256));
    }

    @Test
    @DisplayName("Проверка подсчета площади равнобедренного треугольника, переданного в метод Triangle")
    void areaTestIsosceles () {
        logger.trace("Проверка подсчета площади равнобедренного треугольника, переданного в метод Triangle");
        Assertions.assertEquals(ifTriangleIsIsosceles( 3,  4), Triangle.Area(3, 3, 4));
        Assertions.assertEquals(ifTriangleIsIsosceles( 3,  4), Triangle.Area(3, 4, 3));
        Assertions.assertEquals(ifTriangleIsIsosceles( 3,  4), Triangle.Area(4, 3, 3));
        Assertions.assertEquals(ifTriangleIsIsosceles( 0,  4), Triangle.Area(4, 0, 0));
        Assertions.assertEquals(ifTriangleIsIsosceles( 3,  0), Triangle.Area(0, 3, 3));
        Assertions.assertEquals(ifTriangleIsIsosceles( 0,  0), Triangle.Area(0, 0, 0));
    }

    @Test
    @DisplayName("Проверка подсчета площади разностороннего треугольника, переданного в метод Triangle")
    void areaTestTriangle () {
        logger.trace("Проверка подсчета площади разностороннего треугольника, переданного в метод Triangle");
        Assertions.assertEquals(Triangle.Area(6, 4, 2), Triangle.Area(2, 4, 6));
        Assertions.assertEquals(Triangle.Area(4, 6, 2), Triangle.Area(2, 4, 6));
        Assertions.assertEquals(Triangle.Area(4, 6, 2), Triangle.Area(4, 6, 2));
        Assertions.assertEquals(Triangle.Area(0, 0, 0), Triangle.Area(0, 0, 0));
        Assertions.assertEquals(Triangle.Area(256, 256, 256), Triangle.Area(256, 256, 256));
    }

    @Test
    @DisplayName("Проверка подсчета площади треугольника с отрицательным значением")
    void negativeTest () {
        logger.error("Проверка подсчета площади треугольника с отрицательным значением");
        Assertions.assertEquals(ifTriangleIsEquilateral(-4), Triangle.Area(-4, -4, -4));
        Assertions.assertEquals(ifTriangleIsIsosceles(-3,  4), Triangle.Area(-3, -3, 4));
        Assertions.assertEquals(ifTriangleIsIsosceles(-3, -4), Triangle.Area(-3, -3, -4)); // Тест не проходит, тк две разные формулы дают разный результат
        Assertions.assertEquals(ifTriangleIsIsosceles( 3, -4), Triangle.Area( 3,  3, -4));
    }

    @Test
    @DisplayName("Проверка подсчета площади треугольника с отрицательным значением с исключениями")
    void negativeThrow () {
        logger.trace("Проверка подсчета площади треугольника с отрицательным значением с исключениями");
        Assertions.assertThrows(IllegalArgumentException.class, () -> Triangle.AreaWithCheck(-3, 3, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Triangle.AreaWithCheck(3, -3, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Triangle.AreaWithCheck(3, 3, -4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Triangle.AreaWithCheck(0, 0, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Triangle.AreaWithCheck(1, 0, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Triangle.AreaWithCheck(1, 1, 0));
    }

    double ifTriangleIsEquilateral(int a) {
        return .25 * Math.sqrt(3) * a * a;
    }

    double ifTriangleIsIsosceles(int a, int b) {
        return 0.5 * b * Math.sqrt(a * a - 0.25 * b * b);
    }
}
