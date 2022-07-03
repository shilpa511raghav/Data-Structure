import java.time.LocalDateTime;
import java.util.Date;

public final class CustomImmutableClass {
    private String name;
    private Date dob;

    CustomImmutableClass(String name, Date dob){
        this.name= name;
        this.dob = new Date(dob.getTime());
        //this.dob = dob;

    }

    public String getName() {
        return name;
    }

    public Date getDob(){
        //return dob;
        return new Date(dob.getTime());
    }
}

class Main2{
    public static void main(String[] args) {
        CustomImmutableClass obj = new CustomImmutableClass("shilpa",new Date());
        System.out.println("obj before== "+obj.getDob());
        obj.getDob().setTime(0l);
        System.out.println("obj after == "+obj.getDob());
    }
}
