package Enum_Example;

public enum TicketType implements  Commented{

    BUG("hight"),
    TASK("medium"){
        @Override
        public boolean isAssigned() {   // nadpisujemy metodę dla wartości TASK
            return true;
        }
        @Override
        public void comment() {
            System.out.println("Task comment");
        }
    },
    SUGGESTION("low");

    private String priority;
    // dodając jakieś pole do enuma musimy do każdej wartości przypisać wartość tego pola
    // inaczej będzie błąd

    TicketType(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isAssigned() {   // mozemy tę metodę nadpisać dla konkretnej wartości enuma
        return false;
    }


    //public abstract boolean isDone();   // możemy zdeklarować metodę która każda wartość będzie musiała nadpisać

    @Override
    public void comment() {
        System.out.println("Standard comment");
    }
}
