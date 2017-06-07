package net.sk.methodreference;

import java.util.function.Supplier;

class PersonFactory {

    private Supplier<Person> supplier;

    public PersonFactory(Supplier<Person> supplier) {
        this.supplier = supplier;
    }

    public Person getPerson() {
        return supplier.get();
    }
}