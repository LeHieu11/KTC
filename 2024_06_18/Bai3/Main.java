public class Main {
    public static void main(String[] args) {
        double DEFAULT_SALARY = 40000;

        Developer mDeveloper = new Developer("Iver Dipaly", DEFAULT_SALARY);
        Manager mManager = new Manager("Avril Aroldo", DEFAULT_SALARY);
        Programmer mProgrammer = new Programmer("Yaron Gabriel", DEFAULT_SALARY);

        println("Manager's bonus: " + mManager.getBonus() );
        println("Developer's bonus: " + mDeveloper.getBonus() );
        println("Programmer's bonus: " + mProgrammer.getBonus() );

        mManager.performanceReport("Excellent");
        mDeveloper.performanceReport("Good");
        mProgrammer.performanceReport("Excellent");

        mManager.work();
        mDeveloper.work();
        mProgrammer.work();
    }

    public static void println(String string){
        System.out.println(string);
    }
}
