import controller.Sort;
import controller.StudentControlelr;
import controller.SubjectController;
import controller.TranscripController;
import helper.Helper;

public class Main {
    public static void main(String[] args) {

        Helper helper = new Helper();
        StudentControlelr studentControlelr = new StudentControlelr();
        SubjectController subjectController = new SubjectController();
        TranscripController transcripController = new TranscripController();
        Sort sort = new Sort();

        int choice = 0;
        boolean check = true;
        while(check){
            helper.showMenu();
            while(true) {
                try {
                    choice = helper.getInt("Nhap lua chon chuc nang: ");
                    if(choice<1 || choice >6){
                        System.out.println("Cu phap khong hop le. Moi nhap lai");
                        continue;
                    }
                    break;
                }catch(Exception e){
                    System.out.println("Cu phap khong hop le. Moi nhap lai");
                }

            }
            switch (choice){
                case 1:
                    studentControlelr.functionChoice();
                    break;
                case 2:
                    subjectController.functionChoice();
                    break;
                case 3:
                    transcripController.functionChoice();
                    break;
                case 4:
                    sort.functionChoice();
                    break;
                case 6:
                    check = false;
                    break;
            }
        }
    }
}
