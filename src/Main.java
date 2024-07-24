import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class AvtoTurargoh {
    private List<Avtomobil> avtomobillar;

    public AvtoTurargoh() {
        this.avtomobillar = new ArrayList<>();
    }

    public void avtomobilQoshish(String model, int yil) {
        Avtomobil avto = new Avtomobil(model, yil);
        avtomobillar.add(avto);
        System.out.println(model + " avtomobili ro'yxatga qo'shildi.");
    }

    public void avtomobilOchirish(String model) {
        Iterator<Avtomobil> iterator = avtomobillar.iterator();
        while (iterator.hasNext()) {
            Avtomobil avto = iterator.next();
            if (avto.getModel().equals(model)) {
                iterator.remove();
                System.out.println(model + " avtomobili ro'yxatdan o'chirildi.");
                return;
            }
        }
        System.out.println(model + " avtomobili topilmadi.");
    }

    public void avtomobillarniKorsatishMatritsa() {
        if (avtomobillar.isEmpty()) {
            System.out.println("Hozircha avtomobillar mavjud emas.");
        } else {
            System.out.println("Turargohda mavjud avtomobillar:");
            System.out.println("----------------------------------------------------");
            System.out.printf("| %-20s | %-25s |\n", "Model", "Ishlab chiqarilgan yil");
            System.out.println("----------------------------------------------------");
            for (Avtomobil avto : avtomobillar) {
                System.out.printf("| %-20s | %-25s |\n", avto.getModel(), avto.getIshlabChiqarilganYil());
            }
            System.out.println("----------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AvtoTurargoh turargoh = new AvtoTurargoh();

        System.out.println("Avtoturargoh dasturiga xush kelibsiz!");
        System.out.println("Dasturning amallari:");
        System.out.println("1 - Avtomobil qo'shish");
        System.out.println("2 - Avtomobillarni ko'rish");
        System.out.println("3 - Avtomobilni o'chirish");
        System.out.println("0 - Dasturdan chiqish");

        int amal;
        do {
            System.out.print("Amalni tanlang: ");
            amal = scanner.nextInt();
            scanner.nextLine(); // Scanner dan qoldiqni o'chiramiz

            switch (amal) {
                case 1:
                    System.out.print("Avtomobil modelini kiriting: ");
                    String model = scanner.nextLine();
                    System.out.print("Ishlab chiqarilgan yilini kiriting: ");
                    int yil = scanner.nextInt();
                    turargoh.avtomobilQoshish(model, yil);
                    break;
                case 2:
                    turargoh.avtomobillarniKorsatishMatritsa();
                    break;
                case 3:
                    System.out.print("O'chirish uchun avtomobil modelini kiriting: ");
                    String ochirishModel = scanner.nextLine();
                    turargoh.avtomobilOchirish(ochirishModel);
                    break;
                case 0:
                    System.out.println("Dastur tugadi. Xayr!");
                    break;
                default:
                    System.out.println("Noto'g'ri amal tanlandi. Qayta urinib ko'ring.");
                    break;
            }
        } while (amal != 0);
    }
}

class Avtomobil {
    private String model;
    private int ishlabChiqarilganYil;

    public Avtomobil(String model, int ishlabChiqarilganYil) {
        this.model = model;
        this.ishlabChiqarilganYil = ishlabChiqarilganYil;
    }

    public String getModel() {
        return model;
    }

    public int getIshlabChiqarilganYil() {
        return ishlabChiqarilganYil;
    }
}
