
    import com.itfactory.claseDeObiecte.*;
    import com.itfactory.exceptii.BugetInvalid;
    import com.itfactory.exceptii.CantitateInsuficienta;
    import com.itfactory.metode.Metode;

    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random;
    import java.util.Scanner;

    import static com.itfactory.metode.Metode.*;

    public class Main {
        public static void main(String[] args) throws BugetInvalid, CantitateInsuficienta {

            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            Alimente aliment0 = new Alimente("lapte", 8, 20, LocalDate.parse("2023-05-08"));
            Alimente aliment1 = new Alimente("oua", 20, 30, LocalDate.parse("2023-05-28"));
            Alimente aliment2 = new Alimente("paine", 6, 50, LocalDate.parse("2023-05-20"));
            Alimente aliment3 = new Alimente("zahar", 5, 10, LocalDate.parse("2024-02-15"));

            List<Alimente> listaAlimente = new ArrayList<>();
            listaAlimente.add(aliment0);
            listaAlimente.add(aliment1);
            listaAlimente.add(aliment2);
            listaAlimente.add(aliment3);

            Electronice electronice0 = new Electronice("televizor", 2300, 3, 3);
            Electronice electronice1 = new Electronice("smartphone", 3200, 5, 3);
            Electronice electronice2 = new Electronice("calculator", 7500, 2, 4);
            Electronice electronice3 = new Electronice("frigider", 1450, 1, 2);
            Electronice electronice4 = new Electronice("masina de spalat", 2200, 1, 2);
            Electronice electronice5 = new Electronice("fier de calcat", 770, 2, 2);
            Electronice electronice6 = new Electronice("aragaz electric", 3500, 1, 2);

            List<Electronice> listaElectronice = new ArrayList<>();
            listaElectronice.add(electronice0);
            listaElectronice.add(electronice1);
            listaElectronice.add(electronice2);
            listaElectronice.add(electronice3);
            listaElectronice.add(electronice4);
            listaElectronice.add(electronice5);
            listaElectronice.add(electronice6);

            Imbracaminte imbracaminte0 = new Imbracaminte("tricou", 120, 10, 30);
            Imbracaminte imbracaminte1 = new Imbracaminte("pantaloni scurti", 80, 10, 30);
            Imbracaminte imbracaminte2 = new Imbracaminte("geaca de ploaie", 450, 3, 60);
            Imbracaminte imbracaminte3 = new Imbracaminte("pantaloni lungi", 150, 5, 30);
            Imbracaminte imbracaminte4 = new Imbracaminte("blugi", 120, 7, 15);
            Imbracaminte imbracaminte5 = new Imbracaminte("lenjerie", 90, 10, 0);
            Imbracaminte imbracaminte6 = new Imbracaminte("geaca de iarna", 800, 3, 60);
            Imbracaminte imbracaminte7 = new Imbracaminte("tenesi", 250, 6, 15);
            Imbracaminte imbracaminte8 = new Imbracaminte("ghete", 550, 8, 15);

            List<Imbracaminte> listaImbracaminte = new ArrayList<>();
            listaImbracaminte.add(imbracaminte0);
            listaImbracaminte.add(imbracaminte1);
            listaImbracaminte.add(imbracaminte2);
            listaImbracaminte.add(imbracaminte3);
            listaImbracaminte.add(imbracaminte4);
            listaImbracaminte.add(imbracaminte5);
            listaImbracaminte.add(imbracaminte6);
            listaImbracaminte.add(imbracaminte7);
            listaImbracaminte.add(imbracaminte8);

            IngrijirePersonala ingrijire0 = new IngrijirePersonala("parfum", 330, 7, false);
            IngrijirePersonala ingrijire1 = new IngrijirePersonala("deodorant", 35, 5, true);
            IngrijirePersonala ingrijire2 = new IngrijirePersonala("gel de dus", 45, 10, true);
            IngrijirePersonala ingrijire3 = new IngrijirePersonala("sampon de par", 33, 7, true);
            IngrijirePersonala ingrijire4 = new IngrijirePersonala("pasta de dinti", 22, 10, false);
            IngrijirePersonala ingrijire5 = new IngrijirePersonala("fixativ", 28, 3, false);

            List<IngrijirePersonala> listaIngrijire = new ArrayList<>();
            listaIngrijire.add(ingrijire0);
            listaIngrijire.add(ingrijire1);
            listaIngrijire.add(ingrijire2);
            listaIngrijire.add(ingrijire3);
            listaIngrijire.add(ingrijire4);
            listaIngrijire.add(ingrijire5);

            int bugetCumparator = random.nextInt(100, 10000);
            Cumparator cumparator = new Cumparator(bugetCumparator);

            List<String> comentarii = new ArrayList<>();

            String optiune;
            String raspuns;
            double suplimentar;

            System.out.println("\n Bine ati venit in magazinul nostru. Va rugam sa introduceti una din urmatoarele optiuni: \n");

            while (true) {
                System.out.print(" 0 - Verifica sold " +
                        "\n 1 - Alimente"+ "              |   " + "5 - Scrie un review pentru un produs " +
                        "\n 2 - Imbracaminte"+"          |   " + "6 - Afiseaza review-uri produse " +
                        "\n 3 - Electronice"+"           |   " + "7 - Administratie magazin " +
                        "\n 4 - Ingrijire personala"+ "   |   " + "8 - Iesire " +
                        "\n" +
                        "\n");
                optiune = scanner.nextLine();
                switch (optiune) {
                    case "0":
                        System.out.println("Soldul dumneavoastra este: " + cumparator.getBuget());
                        break;
                    case "1":
                        Metode.afiseazaAlimente(listaAlimente);
                        System.out.print(
                                "  " +
                                        "\n 1 - Verifica valabilitate produs " +
                                        "\n 2 - Cumpara produse" +
                                        " " +
                                        "\n");
                        String optiune1 = scanner.nextLine();
                            if (optiune1.equals("1")) {
                                System.out.println(Metode.valabilitateAlimente(listaAlimente));
                                do {
                                    System.out.print("Doriti sa verificati valabilitatea altui produs? (Da/Nu): ");
                                    raspuns = scanner.nextLine();
                                    if(raspuns.equalsIgnoreCase("Da")){
                                        System.out.println(Metode.valabilitateAlimente(listaAlimente));
                                    } else if(raspuns.equalsIgnoreCase("Nu")){
                                        System.out.println();
                                        break;
                                    } else {
                                        System.out.print("Raspuns invalid. ");
                                        raspuns="da";
                                    }
                                } while (raspuns.equalsIgnoreCase("Da"));
                                break;
                            } else if (optiune1.equals("2")) {
                                System.out.print("Introduceti denumirea produsului: ");
                                String produs = scanner.nextLine();
                                System.out.print("Introduceti cantitatea dorita: ");
                                try {
                                    double cantitate = Double.parseDouble(scanner.nextLine());
                                    System.out.println(Metode.cumparaAlimente(listaAlimente, cumparator,produs,cantitate));
                                } catch (NumberFormatException e) {
                                    System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                                do {
                                    System.out.print("Doriti sa continuati cumparaturile de produse din categoria alimente? (Da/Nu): ");
                                    raspuns = scanner.nextLine();
                                    if(raspuns.equalsIgnoreCase("Da")){
                                        System.out.print("Introduceti denumirea produsului: ");
                                        produs = scanner.nextLine();
                                        System.out.print("Introduceti cantitatea dorita: ");
                                        try {
                                            double cantitate = Double.parseDouble(scanner.nextLine());
                                            System.out.println(Metode.cumparaAlimente(listaAlimente, cumparator,produs,cantitate));
                                        } catch (NumberFormatException e) {
                                            System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                                    } else if(raspuns.equalsIgnoreCase("Nu")){
                                        System.out.println();
                                        break;
                                    } else {
                                        System.out.print("Raspuns invalid. ");
                                        raspuns="da";
                                    }
                                } while (raspuns.equalsIgnoreCase("Da"));
                                break;
                            } else {
                                System.out.println("Raspuns invalid");
                            }
                        System.out.println();
                        break;
                    case "2":
                        Metode.afiseazaImbracaminte(listaImbracaminte);
                        System.out.print(
                                "  " +
                                        "\n 1 - Verifica termen retur produs " +
                                        "\n 2 - Cumpara produse" +
                                        " " +
                                        "\n");
                        String optiune2 = scanner.nextLine();
                        if (optiune2.equals("1")) {
                            System.out.println(Metode.returImbracaminte(listaImbracaminte));
                            do {
                                System.out.print("Doriti sa verificati termenul de retur al altui produs? (Da/Nu): ");
                                raspuns = scanner.nextLine();
                                if (raspuns.equalsIgnoreCase("Da")) {
                                    System.out.println(Metode.returImbracaminte(listaImbracaminte));
                                } else if (raspuns.equalsIgnoreCase("Nu")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.print("Raspuns invalid. ");
                                    raspuns = "da";
                                }
                            } while (raspuns.equalsIgnoreCase("Da"));
                            break;
                         } else if (optiune2.equals("2")) {
                                System.out.print("Introduceti denumirea produsului: ");
                                String produs = scanner.nextLine();
                                System.out.print("Introduceti cantitatea dorita: ");
                                try {
                                    double cantitate = Double.parseDouble(scanner.nextLine());
                                    System.out.println(Metode.cumparaImbracaminte(listaImbracaminte, cumparator,produs,cantitate));
                                } catch (NumberFormatException e) {
                                    System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                                do {
                                    System.out.print("Doriti sa continuati cumparaturile de produse din categoria imbracaminte? (Da/Nu): ");
                                    raspuns = scanner.nextLine();
                                    if(raspuns.equalsIgnoreCase("Da")){
                                        System.out.print("Introduceti denumirea produsului: ");
                                        produs = scanner.nextLine();
                                        System.out.print("Introduceti cantitatea dorita: ");
                                        try {
                                            double cantitate = Double.parseDouble(scanner.nextLine());
                                            System.out.println(Metode.cumparaImbracaminte(listaImbracaminte, cumparator,produs,cantitate));
                                        } catch (NumberFormatException e) {
                                            System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                                    } else if(raspuns.equalsIgnoreCase("Nu")){
                                        System.out.println();
                                        break;
                                    } else {
                                        System.out.print("Raspuns invalid. ");
                                        raspuns="da";
                                    }
                                } while (raspuns.equalsIgnoreCase("Da"));
                                break;
                            } else {
                                System.out.println("Raspuns invalid");
                            }
                            System.out.println();
                            break;

                    case "3":
                        Metode.afiseazaElectronice(listaElectronice);
                        System.out.print(
                                "  " +
                                        "\n 1 - Verifica termen garantie produs " +
                                        "\n 2 - Cumpara produse" +
                                        " " +
                                        "\n");
                        String optiune3 = scanner.nextLine();
                        if (optiune3.equals("1")) {
                            System.out.println(Metode.garantieElectronice(listaElectronice));
                            do {
                                System.out.print("Doriti sa verificati termentul de garantie al altui produs? (Da/Nu): ");
                                raspuns = scanner.nextLine();
                                if (raspuns.equalsIgnoreCase("Da")) {
                                    System.out.println(Metode.garantieElectronice(listaElectronice));
                                } else if (raspuns.equalsIgnoreCase("Nu")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.print("Raspuns invalid. ");
                                    raspuns = "da";
                                }
                            } while (raspuns.equalsIgnoreCase("Da"));
                            break;
                        } else if (optiune3.equals("2")) {
                            System.out.print("Introduceti denumirea produsului: ");
                            String produs = scanner.nextLine();
                            System.out.print("Introduceti cantitatea dorita: ");
                            try {
                                double cantitate = Double.parseDouble(scanner.nextLine());
                                for(Electronice electronice : listaElectronice) {
                                    if (electronice.getDenumire().equalsIgnoreCase(produs)){
                                        System.out.println("Pentru un procent de 20% aplicat suplimentar pretului produsului puteti sa extindeti garantia acestuia cu 2 ani, adica pana la data de " +
                                                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now().plusYears(2)) + ". Doriti realizarea acestei operatiuni? (Da/Nu):");
                                        raspuns=scanner.nextLine();
                                        if (raspuns.equalsIgnoreCase("da")){
                                            electronice.setPret(pretFinalGarantieExtinsa(electronice));
                                        }
                                    }
                                }
                                System.out.println(Metode.cumparaElectronice(listaElectronice, cumparator,produs,cantitate));
                            } catch (NumberFormatException e) {
                                System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                            do {
                                System.out.print("Doriti sa continuati cumparaturile de produse din categoria electronice? (Da/Nu): ");
                                raspuns = scanner.nextLine();
                                if(raspuns.equalsIgnoreCase("Da")){
                                    System.out.print("Introduceti denumirea produsului: ");
                                    produs = scanner.nextLine();
                                    System.out.print("Introduceti cantitatea dorita: ");
                                    try {
                                        double cantitate = Double.parseDouble(scanner.nextLine());
                                        for(Electronice electronice : listaElectronice) {
                                            if (electronice.getDenumire().equalsIgnoreCase(produs)){
                                                System.out.println("Pentru un procent de 20% aplicat suplimentar pretului produsului puteti sa extindeti garantia acestuia cu 2 ani, adica pana la data de " +
                                                        DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now().plusYears(2)) + ". Doriti realizarea acestei operatiuni? (Da/Nu):");
                                                raspuns=scanner.nextLine();
                                                if (raspuns.equalsIgnoreCase("da")){
                                                    electronice.setPret(pretFinalGarantieExtinsa(electronice));
                                                }
                                            }
                                        }
                                        System.out.println(Metode.cumparaElectronice(listaElectronice, cumparator,produs,cantitate));
                                    } catch (NumberFormatException e) {
                                        System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                                } else if(raspuns.equalsIgnoreCase("Nu")){
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.print("Raspuns invalid. ");
                                    raspuns="da";
                                }
                            } while (raspuns.equalsIgnoreCase("Da"));
                            break;
                        } else {
                            System.out.println("Raspuns invalid");
                        }
                        System.out.println();
                        break;

                    case "4":
                        Metode.afiseazaIngrijirePersonala(listaIngrijire);
                        System.out.print(
                                "  " +
                                        "\n 1 - Verifica daca produsul poate fi returnat " +
                                        "\n 2 - Cumpara produse" +
                                        "\n");
                        String optiune4 = scanner.nextLine();
                        if (optiune4.equals("1")) {
                            System.out.println(Metode.ingrijireReturnabil(listaIngrijire));
                            do {
                                System.out.print("Doriti sa verificati posibilitatea de returnare al altui produs de ingrijire personala? (Da/Nu): ");
                                raspuns = scanner.nextLine();
                                if(raspuns.equalsIgnoreCase("Da")){
                                    System.out.println(Metode.ingrijireReturnabil(listaIngrijire));
                                } else if(raspuns.equalsIgnoreCase("Nu")){
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.print("Raspuns invalid. ");
                                    raspuns="da";
                                }
                            } while (raspuns.equalsIgnoreCase("Da"));
                            break;
                        } else if (optiune4.equals("2")) {
                            System.out.print("Introduceti denumirea produsului: ");
                            String produs = scanner.nextLine();
                            System.out.print("Introduceti cantitatea dorita: ");
                            try {
                                double cantitate = Double.parseDouble(scanner.nextLine());
                                System.out.println(Metode.cumparaIngrijire(listaIngrijire, cumparator,produs,cantitate));
                            } catch (NumberFormatException e) {
                                System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                            do {
                                System.out.print("Doriti sa continuati cumparaturile de produse din categoria ingrijire personala? (Da/Nu): ");
                                raspuns = scanner.nextLine();
                                if(raspuns.equalsIgnoreCase("Da")){
                                    System.out.print("Introduceti denumirea produsului: ");
                                    produs = scanner.nextLine();
                                    System.out.print("Introduceti cantitatea dorita: ");
                                    try {
                                        double cantitate = Double.parseDouble(scanner.nextLine());
                                        System.out.println(Metode.cumparaIngrijire(listaIngrijire, cumparator,produs,cantitate));
                                    } catch (NumberFormatException e) {
                                        System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                                } else if(raspuns.equalsIgnoreCase("Nu")){
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.print("Raspuns invalid. ");
                                    raspuns="da";
                                }
                            } while (raspuns.equalsIgnoreCase("Da"));
                            break;
                        } else {
                            System.out.println("Raspuns invalid");
                        }
                        System.out.println();
                        break;
                    case "5":
                        Metode.scrieReview(listaAlimente, listaImbracaminte, listaElectronice, listaIngrijire, comentarii);
                        do {
                            System.out.print("Doriti sa adaugati un alt review? (Da/Nu): ");
                            raspuns = scanner.nextLine();
                            if(raspuns.equalsIgnoreCase("Da")){
                                Metode.scrieReview(listaAlimente, listaImbracaminte, listaElectronice, listaIngrijire, comentarii);
                            } else if(raspuns.equalsIgnoreCase("Nu")){
                                System.out.println();
                                break;
                            } else {
                                System.out.print("Raspuns invalid. ");
                                raspuns="da";
                            }
                        } while (raspuns.equalsIgnoreCase("Da"));
                        break;
                    case "6":
                        Metode.afiseazaReview(comentarii);
                        do {
                            System.out.print("Iesire program (Da/Nu): ");
                            raspuns = scanner.nextLine();
                            if(raspuns.equalsIgnoreCase("Da")){
                                System.exit(0);
                            } else if(raspuns.equalsIgnoreCase("Nu")){
                                System.out.println();
                                break;
                            } else {
                                System.out.print("Raspuns invalid. ");
                                raspuns="da";
                            }
                        } while (raspuns.equalsIgnoreCase("Da"));
                        break;
                    case "7":
                        System.out.print(
                                "  " +
                                        "\n 1 - Verifica inventar " +
                                        "\n 2 - Suplimenteaza cantitate produse " +
                                        "\n");
                        String optiune5 = scanner.nextLine();
                        if (optiune5.equals("1")) {
                            Metode.Inventar(listaAlimente, listaImbracaminte, listaElectronice, listaIngrijire);
                            do {
                                System.out.print("Iesire program (Da/Nu): ");
                                raspuns = scanner.nextLine();
                                if (raspuns.equalsIgnoreCase("Da")) {
                                    System.exit(0);
                                } else if (raspuns.equalsIgnoreCase("Nu")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.print("Raspuns invalid. ");
                                    raspuns = "da";
                                }
                            } while (raspuns.equalsIgnoreCase("Da"));
                            break;
                        }
                        else if (optiune5.equals("2")) {
                            System.out.print("Introduceti numele produsului: ");
                            String produs = scanner.nextLine();
                            System.out.print("Introduceti cantitatea suplimentara: ");
                            try {
                                double cantitate = Double.parseDouble(scanner.nextLine());
                                suplimentar = Metode.suplimenteazaCantitate(listaAlimente,listaImbracaminte,listaElectronice,listaIngrijire,produs,cantitate);
                                if (existentaAliment(produs,listaAlimente)||existentaElectronice(produs,listaElectronice)
                                        ||existentaImbracaminte(produs,listaImbracaminte)||existentaIngrijirePersonala(produs,listaIngrijire)){
                                    System.out.println("Noua cantitate a produsului " + produs + " este de " + suplimentar + " buc. ");
                                } else {
                                    System.out.println("Acest produs nu exista in magazin");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");}
                            do {
                                System.out.print("Doriti sa suplimentati cantitatea altui produs? (Da/Nu) ");
                                raspuns = scanner.nextLine();
                                if (raspuns.equalsIgnoreCase("Da")) {
                                System.out.print("Introduceti numele produsului: ");
                                produs = scanner.nextLine();
                                System.out.print("Introduceti cantitatea suplimentara: ");
                                try {
                                    double cantitate = Double.parseDouble(scanner.nextLine());
                                    suplimentar = Metode.suplimenteazaCantitate(listaAlimente,listaImbracaminte,listaElectronice,listaIngrijire,produs,cantitate);
                                    if (existentaAliment(produs,listaAlimente)||existentaElectronice(produs,listaElectronice)
                                            ||existentaImbracaminte(produs,listaImbracaminte)||existentaIngrijirePersonala(produs,listaIngrijire)){
                                        System.out.println("Noua cantitate a produsului " + produs + " este de " + suplimentar + " buc. ");
                                    } else {
                                        System.out.println("Acest produs nu exista in magazin");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Eroare la tastarea cantitatii. Va rugam introduceti un numar");
                                }
                                } else if (raspuns.equalsIgnoreCase("Nu")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.print("Raspuns invalid. ");
                                    raspuns = "da";
                                }
                            } while (raspuns.equalsIgnoreCase("Da"));
                            break;
                        } else {
                            System.out.println("Raspuns invalid");
                        }
                        System.out.println();
                        break;

                    case "8":
                        System.exit(0);
                    default:
                        System.out.println("Raspuns invalid. Va rugam introduceti o optiune din cele de mai jos:");
                        break;
                }
            }
        }
    }
