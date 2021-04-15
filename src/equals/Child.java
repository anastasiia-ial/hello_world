package equals;


    import java.util.Objects;

    public class Child extends Parent {
        String newString;

        public Child(String someString, String newString) {
            super(someString);
            this.newString = newString;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Child child = (Child) o;
            return Objects.equals(newString, child.newString);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), newString);
        }
    }

