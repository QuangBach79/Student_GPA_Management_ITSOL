package helper;

public class ValidateStudent {
    public boolean validateName(String name){
        if(name.length() == 0){
            System.out.println("Ban chua nhap ten sinh vien");
            return false;
        }else if(name.length()>200){
            System.out.println("Ten sinh vien qua dai");
            return false;
        }else{
            return true;
        }
    }

    public boolean validateAddress(String address){
        if(address.length() == 0){
            System.out.println("Ban chua nhap dia chi");
            return false;
        }else{
            return true;
        }
    }

    public boolean validateNumberPhone(String numberPhone){
        if(numberPhone.length() == 0){
            System.out.println("Ban chau nhap so lien lac");
            return false;
        }else if(numberPhone.length()>=11){
            System.out.println("So lien lac khong hop le");
            return false;
        }else{
            return true;
        }
    }

    public boolean validateRoomClass(String roomClass){
        if(roomClass.length() == 0){
            System.out.println("Ban chua nhap lop sinh vien");
            return false;
        }else{
            return true;
        }
    }

}
