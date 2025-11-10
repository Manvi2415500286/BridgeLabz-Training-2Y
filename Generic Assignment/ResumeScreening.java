import java.util.*;

abstract class JobRole {
    String roleName;
    JobRole(String r){ roleName = r; }
    public String toString(){ return roleName; }
}

class SoftwareEngineer extends JobRole { SoftwareEngineer(){ super("Software Engineer"); } }
class DataScientist extends JobRole { DataScientist(){ super("Data Scientist"); } }
class ProductManager extends JobRole { ProductManager(){ super("Product Manager"); } }

class Resume<T extends JobRole> {
    String candidate;
    T role;

    Resume(String c, T r){ candidate=c; role=r; }

    public String toString(){ return candidate + " -> " + role; }
}

public class ResumeScreening {
    public static void processPipeline(List<? extends JobRole> roles) {
        roles.forEach(r -> System.out.println("Running model for: " + r));
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Aman", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Bela", new DataScientist());

        System.out.println(r1);
        System.out.println(r2);

        processPipeline(List.of(new SoftwareEngineer(), new ProductManager()));
    }
}
