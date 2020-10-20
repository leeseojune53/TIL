class A {
    private final String name;
    private final String location;
    private final String phoneNumber;

    A(Builder builder) {
        this.name = builder.name;
        this.location = builder.location;
        this.phoneNumber = builder.phoneNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    protected static class Builder {
        private String name;
        private String location;
        private String phoneNumber;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public A build() {
            return new A(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}

public class Builder {
    public static void main(String args[]) {
        A a = A.builder()
                .name("")
                .phoneNumber("")
                .location("")
                .build();
    }
}

class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }
}