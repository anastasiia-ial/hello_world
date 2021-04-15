package equals;
/*
создать свой класс и переопределить equals таким образом чтобы сво-во симметри или транзитивности не выполнялось
 */
public class Test {

        public static void main (String[]args){
            Parent parentOne = new Parent("Тест");
            Parent parentTwo = new Parent("Тест");
            Child child = new Child("Тест", "Второй аргумент");

            System.out.println("parentOne and child:");
            System.out.println(parentOne.equals(child));
            System.out.println(child.equals(parentOne));
            System.out.println();

            System.out.println("parentOne, parentTwo and child:");
            System.out.println(parentOne.equals(parentTwo));
            System.out.println(parentOne.equals(child));
            System.out.println(child.equals(parentTwo));

        }
    }


