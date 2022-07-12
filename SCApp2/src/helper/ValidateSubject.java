package helper;

public class ValidateSubject {
    public boolean validateName(String name){
        if(name.length() == 0){
            System.out.println("Ban chua nhap ten mon hoc");
            return false;
        }else if(name.length()>200){
            System.out.println("Ten mon hoc qua dai");
            return false;
        }else{
            return true;
        }
    }

    public boolean validateTotalUnit(int totalUnit){
        if(totalUnit == 0){
            System.out.println("Ban chua nhap don vi hoc trinh");
            return false;
        }else{
            return true;
        }
    }
}
