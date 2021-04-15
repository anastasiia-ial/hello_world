package equals;

    import java.util.Objects;

    public class Parent {
        String someString;

        public Parent(String someString) {
            this.someString = someString;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            Parent parent = (Parent) o;
            return Objects.equals(someString, parent.someString);
        }

        @Override
        public int hashCode() {
            return Objects.hash(someString);
        }
    }

