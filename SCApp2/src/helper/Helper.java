package helper;

import java.util.Scanner;

public class Helper {
    public int getInt(String ask){
        int value = 0;
        while(true){
            try{
                System.out.print(ask);
                value = new Scanner(System.in).nextInt();
                if (value<=0){
                    System.out.println("Cu phap khong hop le. Moi nhap lai");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Cu phap khong hop le. Moi nhap lai.");
            }
        }
        return value;
    }

    public double getDouble(String ask){
        int value = 0;
        while (true){
            try{
                System.out.print(ask);
                value = new Scanner(System.in).nextInt();
                if(value<=0){
                    System.out.println("Cu phap khong hop le.  Moi nhap lai");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Cu phap khong hop le. Moi nhap lai");
            }
        }
        return value;
    }

    public String getString(String ask){
        String str = null;
        while(true){
            try{
                System.out.print(ask);
                str = new Scanner(System.in).nextLine();
                break;
            }catch (Exception e){
                System.out.println("Cu phap khong hop le. Moi nhap lai");
            }
        }
        return str;
    }

    public void showMenu(){
        System.out.println("\n===== PHAN MEM QUAN LI TRA LUONG GIAO VIEN =====\n");
        System.out.println("1. Quan ly sinh vien.");
        System.out.println("2. Quan ly mon hoc.");
        System.out.println("3. Quan ly bang diem.");
        System.out.println("4. Sap xep danh sach bang diem");
        System.out.println("5. Tinh diem tong ket.");
        System.out.println("6. Thoat chuong trinh.");
        System.out.println("-----------------------------");
    }
}
