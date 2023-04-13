package com.itfactory.metode;

import com.itfactory.claseDeObiecte.*;
import com.itfactory.exceptii.BugetInvalid;
import com.itfactory.exceptii.CantitateInsuficienta;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Metode {


    public static void afiseazaAlimente(List<Alimente> dateAlimente) {
        for (Alimente aliment : dateAlimente) {
            if (aliment.getCantitate() != 0) {
                System.out.println(aliment);
            }
        }
    }

    public static void afiseazaElectronice(List<Electronice> dateElectronice) {
        for (Electronice electronice : dateElectronice) {
            if (electronice.getCantitate() != 0) {
                System.out.println(electronice);
            }
        }
    }

    public static void afiseazaImbracaminte(List<Imbracaminte> dateImbracaminte) {
        for (Imbracaminte imbracaminte : dateImbracaminte) {
            if (imbracaminte.getCantitate() != 0) {
                System.out.println(imbracaminte);
            }
        }
    }

    public static void afiseazaIngrijirePersonala(List<IngrijirePersonala> dateIngrijirePersonala) {
        for (IngrijirePersonala ingrijire : dateIngrijirePersonala) {
            if (ingrijire.getCantitate() != 0) {
                System.out.println(ingrijire);
            }
        }
    }

    public static boolean existentaAliment(String aliment, List<Alimente> dateAlimente) {
        boolean valid=false;
        for (Alimente alimentDinBazadeDate : dateAlimente) {
            if (aliment.equalsIgnoreCase(alimentDinBazadeDate.getDenumire())) {
                valid=true;
            }
        }
        return valid;
    }

    public static boolean existentaImbracaminte(String imbracaminte, List<Imbracaminte> dateImbracaminte) {
        boolean valid=false;
        for (Imbracaminte imbracaminteDinBazadeDate : dateImbracaminte) {
            if (imbracaminte.equalsIgnoreCase(imbracaminteDinBazadeDate.getDenumire())) {
                valid=true;
            }
        }
        return valid;
    }

    public static boolean existentaElectronice(String electronice, List<Electronice> dateElectronice) {
        boolean valid=false;
        for (Electronice electroniceDinBazadeDate : dateElectronice) {
            if (electronice.equalsIgnoreCase(electroniceDinBazadeDate.getDenumire())) {
                valid=true;
            }
        }
        return valid;
    }

    public static boolean existentaIngrijirePersonala(String ingrijire, List<IngrijirePersonala> dateIngrijire) {
        boolean valid=false;
        for (IngrijirePersonala ingrijireDinBazadeDate : dateIngrijire) {
            if (ingrijire.equalsIgnoreCase(ingrijireDinBazadeDate.getDenumire())) {
                valid=true;
            }
        }
        return valid;
    }

    public static String valabilitateAlimente(List<Alimente> dateAlimente) {
        System.out.print("Introduceti denumirea produsului: ");
        Scanner scanner = new Scanner(System.in);
        String alimentCautat = scanner.nextLine();
        String mesaj = null;
        LocalDate astazi = LocalDate.now();

        for (Alimente alimentDinBazadeDate : dateAlimente) {
            if (alimentCautat.equalsIgnoreCase(alimentDinBazadeDate.getDenumire())) {
                if (astazi.isBefore(alimentDinBazadeDate.getDataValabilitate())) {
                    mesaj = "Produsul expira in data de: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(alimentDinBazadeDate.getDataValabilitate());
                } else {
                    mesaj = "Produsul a expirat in data de " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(alimentDinBazadeDate.getDataValabilitate());
                }
                    break;
            }
        }
        if (!existentaAliment(alimentCautat,dateAlimente)) {
            mesaj="Acest produs nu exista in magazin";
        }
        return mesaj;
    }

    public static String returImbracaminte(List<Imbracaminte> dateImbracaminte) {
        System.out.print("Introduceti denumirea articolului de imbracaminte: ");
        Scanner scanner = new Scanner(System.in);
        String imbracaminteCautat = scanner.nextLine();
        String mesaj = null;
        LocalDate thisMoment = LocalDate.now();

        for (Imbracaminte imbracaminteDinBazadeDate : dateImbracaminte) {
            if (imbracaminteCautat.equalsIgnoreCase(imbracaminteDinBazadeDate.getDenumire())) {
                if (imbracaminteDinBazadeDate.getTermenRetur() > 0) {
                    mesaj="Articolul de imbracaminte poate fi retunrat in termen de " + imbracaminteDinBazadeDate.getTermenRetur() + " de zile,"
                            + " adica pana la data de " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(thisMoment.plusDays(imbracaminteDinBazadeDate.getTermenRetur())) + ".";
                } else {
                    mesaj="Acest articol de imbracaminte face parte din categoria de produse care nu pot fi returnate.";
                }
                break;
            }
        }
        if (!existentaImbracaminte(imbracaminteCautat,dateImbracaminte)) {
            mesaj="Acest produs nu exista in magazin";
        }
        return mesaj;
    }

    public static String garantieElectronice(List<Electronice> dateElectronice) {
        System.out.print("Introduceti denumirea produsului: ");
        Scanner scanner = new Scanner(System.in);
        String electroniceCautat = scanner.nextLine();
        String mesaj = null;
        LocalDate thisMoment = LocalDate.now();
        for (Electronice electroniceDinBazadeDate : dateElectronice) {
            if (electroniceCautat.equalsIgnoreCase(electroniceDinBazadeDate.getDenumire())) {
                mesaj="Produsul are un termen de garantie " + electroniceDinBazadeDate.getTermenGarantie() + " ani,"
                        + " adica pana la data de " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(thisMoment.plusYears(electroniceDinBazadeDate.getTermenGarantie())) + ".";
                break;
            }
        }
        if (!existentaElectronice(electroniceCautat,dateElectronice)) {
            mesaj="Acest produs nu exista in magazin";
        }
        return mesaj;
    }

    public static double pretFinalGarantieExtinsa (Electronice electronice) {
        double pret = electronice.getPret()*1.2;
        return pret;
    }

    public static String ingrijireReturnabil(List<IngrijirePersonala> dateIngrijire) {
        System.out.print("Introduceti denumirea produsului: ");
        Scanner scanner = new Scanner(System.in);
        String ingrijireCautat = scanner.nextLine();
        String mesaj = null;

        for (IngrijirePersonala ingrijireDinBazadeDate : dateIngrijire) {
            if (ingrijireCautat.equalsIgnoreCase(ingrijireDinBazadeDate.getDenumire())) {
                if (ingrijireDinBazadeDate.isRetur())
                    mesaj="Produsul poate fi returnat";
                else {
                    mesaj="Produsul nu poate fi returnat";
                }
                break;
            }
        }
        if (!existentaIngrijirePersonala(ingrijireCautat,dateIngrijire)) {
            mesaj="Acest produs nu exista in magazin";
        }
        return mesaj;
    }

    public static String cumparaAlimente(List<Alimente> dateAlimente, Cumparator cumparator, String produs, double cantitate) throws BugetInvalid, CantitateInsuficienta {
        String mesaj=null;
        LocalDate astazi = LocalDate.now();
        for (Alimente alimentDinBazadeDate : dateAlimente) {
            if (produs.equalsIgnoreCase(alimentDinBazadeDate.getDenumire())) {
                try {
                    alimentDinBazadeDate.setCantitate(alimentDinBazadeDate.getCantitate() - cantitate);
                } catch (CantitateInsuficienta e) {
                    mesaj = "Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.";
                    break;
                }
                alimentDinBazadeDate.setCantitate(alimentDinBazadeDate.getCantitate() + cantitate);
                if (alimentDinBazadeDate.getCantitate() - cantitate >= 0) {
                    try {
                        cumparator.setBuget(cumparator.getBuget() - alimentDinBazadeDate.getPret() * cantitate);
                    } catch (BugetInvalid e) {
                        mesaj = "Fonduri insuficiente";
                        break;
                    }
                    cumparator.setBuget(cumparator.getBuget() + alimentDinBazadeDate.getPret() * cantitate);
                    if(astazi.isBefore(alimentDinBazadeDate.getDataValabilitate())) {
                        if (cumparator.getBuget() - alimentDinBazadeDate.getPret() * cantitate >= 0) {
                            if (astazi.isAfter(alimentDinBazadeDate.getDataValabilitate().minusDays(10))){
                                alimentDinBazadeDate.setPret(reducereAlimente(alimentDinBazadeDate));
                                cumparator.setBuget(cumparator.getBuget() - alimentDinBazadeDate.getPret() * cantitate);
                                alimentDinBazadeDate.setCantitate(alimentDinBazadeDate.getCantitate() - cantitate);
                                mesaj = "Produsul beneficiaza de o reducere de 50% pentru ca urmeaza sa expire in urmatoarele zile. " +
                                        "Pretul final este de : " + alimentDinBazadeDate.getPret() + " lei. " +
                                        "\nProdusul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator.getBuget();
                            } else {
                                cumparator.setBuget(cumparator.getBuget() - alimentDinBazadeDate.getPret() * cantitate);
                                alimentDinBazadeDate.setCantitate(alimentDinBazadeDate.getCantitate() - cantitate);
                                mesaj = "Produsul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator.getBuget();
                            }
                        }
                    } else {
                        mesaj = "Produs expirat. Achizitia nu a fost realizata.";
                    }
                }
                break;
            }
        }
        if (!existentaAliment(produs,dateAlimente)) {
            mesaj="Acest produs nu exista in magazin";
        }
        return mesaj;
    }

    public static double reducereAlimente (Alimente aliment) {
        LocalDate thisMoment = LocalDate.now();
        double reducere=aliment.getPret();
        if (thisMoment.isAfter(aliment.getDataValabilitate().minusDays(10))){
            reducere=aliment.getPret()*0.5;
        }
        return reducere;
    }


    public static String cumparaElectronice(List<Electronice> dateElectronice, Cumparator cumparator, String produs, double cantitate) throws BugetInvalid, CantitateInsuficienta {
        String mesaj=null;
        for (Electronice electroniceDinBazadeDate : dateElectronice) {
            if (produs.equalsIgnoreCase(electroniceDinBazadeDate.getDenumire())) {
                try {
                    electroniceDinBazadeDate.setCantitate(electroniceDinBazadeDate.getCantitate() - cantitate);
                } catch (CantitateInsuficienta e) {
                    mesaj="Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.";
                    break;
                }
                electroniceDinBazadeDate.setCantitate(electroniceDinBazadeDate.getCantitate() + cantitate);
                if (electroniceDinBazadeDate.getCantitate() - cantitate >= 0) {
                    try {
                        cumparator.setBuget(cumparator.getBuget() - electroniceDinBazadeDate.getPret() * cantitate);
                    } catch (BugetInvalid e) {
                        mesaj="Fonduri insuficiente";
                        break;
                    }
                    cumparator.setBuget(cumparator.getBuget() + electroniceDinBazadeDate.getPret() * cantitate);
                    if (cumparator.getBuget() - electroniceDinBazadeDate.getPret() * cantitate >= 0) {
                        cumparator.setBuget(cumparator.getBuget() - electroniceDinBazadeDate.getPret() * cantitate);
                        electroniceDinBazadeDate.setCantitate(electroniceDinBazadeDate.getCantitate() - cantitate);
                        mesaj="Produsul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator.getBuget();
                    }
                }
                break;
            }
        }
        if (!existentaElectronice(produs,dateElectronice)) {
            mesaj="Acest produs nu exista in magazin";
        }
        return mesaj;
    }

    public static String cumparaImbracaminte(List<Imbracaminte> dateImbracaminte, Cumparator cumparator, String produs, double cantitate) throws BugetInvalid, CantitateInsuficienta {
        String mesaj=null;
        for (Imbracaminte imbracaminteDinBazadeDate : dateImbracaminte) {
            if (produs.equalsIgnoreCase(imbracaminteDinBazadeDate.getDenumire())) {
                try {
                    imbracaminteDinBazadeDate.setCantitate(imbracaminteDinBazadeDate.getCantitate() - cantitate);
                } catch (CantitateInsuficienta e) {
                    mesaj="Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.";
                    break;
                }
                imbracaminteDinBazadeDate.setCantitate(imbracaminteDinBazadeDate.getCantitate() + cantitate);
                if (imbracaminteDinBazadeDate.getCantitate() - cantitate >= 0) {
                    try {
                        cumparator.setBuget(cumparator.getBuget() - imbracaminteDinBazadeDate.getPret() * cantitate);
                    } catch (BugetInvalid e) {
                        mesaj="Fonduri insuficiente";
                        break;
                    }
                    cumparator.setBuget(cumparator.getBuget() + imbracaminteDinBazadeDate.getPret() * cantitate);
                    if (cumparator.getBuget() - imbracaminteDinBazadeDate.getPret() * cantitate >= 0) {
                        cumparator.setBuget(cumparator.getBuget() - imbracaminteDinBazadeDate.getPret() * cantitate);
                        imbracaminteDinBazadeDate.setCantitate(imbracaminteDinBazadeDate.getCantitate() - cantitate);
                        mesaj="Produsul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator.getBuget();
                    }
                }
                break;
            }
        }
        if (!existentaImbracaminte(produs,dateImbracaminte)) {
            mesaj="Acest produs nu exista in magazin";
        }
        return mesaj;
    }

    public static String cumparaIngrijire(List<IngrijirePersonala> dateIngrijire, Cumparator cumparator, String produs, double cantitate) throws BugetInvalid, CantitateInsuficienta {
        String mesaj=null;
        for (IngrijirePersonala ingrijireDinBazadeDate : dateIngrijire) {
            if (produs.equalsIgnoreCase(ingrijireDinBazadeDate.getDenumire())) {
                try {
                    ingrijireDinBazadeDate.setCantitate(ingrijireDinBazadeDate.getCantitate() - cantitate);
                } catch (CantitateInsuficienta e) {
                    mesaj="Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.";
                    break;
                }
                ingrijireDinBazadeDate.setCantitate(ingrijireDinBazadeDate.getCantitate() + cantitate);
                if (ingrijireDinBazadeDate.getCantitate() - cantitate >= 0) {
                    try {
                        cumparator.setBuget(cumparator.getBuget() - ingrijireDinBazadeDate.getPret() * cantitate);
                    } catch (BugetInvalid e) {
                        mesaj="Fonduri insuficiente";
                        break;
                    }
                    cumparator.setBuget(cumparator.getBuget() + ingrijireDinBazadeDate.getPret() * cantitate);
                    if (cumparator.getBuget() - ingrijireDinBazadeDate.getPret() * cantitate >= 0) {
                        cumparator.setBuget(cumparator.getBuget() - ingrijireDinBazadeDate.getPret() * cantitate);
                        ingrijireDinBazadeDate.setCantitate(ingrijireDinBazadeDate.getCantitate() - cantitate);
                        mesaj="Produsul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator.getBuget();
                    }
                }
                break;
            }
        }
        if (!existentaIngrijirePersonala(produs,dateIngrijire)) {
            mesaj="Acest produs nu exista in magazin";
        }
        return mesaj;
    }


    public static void scrieReview(List<Alimente> dateAlimente, List<Imbracaminte> dateImbracaminte, List<Electronice> dateElectronice, List<IngrijirePersonala> dateIngrijire, List<String> comentarii) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti denumirea produsului: ");
        String produs = scanner.nextLine();
        String review;
        if (existentaAliment(produs,dateAlimente)) {
            System.out.println("Produsul ales face parte din categoria alimente. Scrieti review-ul mai jos:");
            review = scanner.nextLine();
            comentarii.add(produs + ": " + review);
        } else if (existentaElectronice(produs,dateElectronice)) {
            System.out.println("Produsul ales face parte din categoria electronice. Scrieti review-ul mai jos:");
            review = scanner.nextLine();
            comentarii.add(produs + ": " + review);
        } else if (existentaImbracaminte(produs,dateImbracaminte)) {
            System.out.println("Produsul ales face parte din categoria imbracaminte. Scrieti review-ul mai jos:");
            review = scanner.nextLine();
            comentarii.add(produs + ": " + review);
        } else if (existentaIngrijirePersonala(produs,dateIngrijire)){
            System.out.println("Produsul ales face parte din categoria ingrijire personala. Scrieti review-ul mai jos:");
            review = scanner.nextLine();
            comentarii.add(produs + ": " + review);
        } else {
            System.out.println("Acest produs nu exista in magazin");
            System.out.println("");
        }
    }

    public static void afiseazaReview(List<String> comentarii) {
        for (String comentariu : comentarii) {
            System.out.println(comentariu);
        }
        if (comentarii.isEmpty()) {
            System.out.println("Nu exista review-uri in baza de date");
        }
        System.out.println("");
    }

    public static double cantitateTotalaAlimente(List<Alimente> dateAlimente) {
        double c = 0;
        for (Alimente aliment : dateAlimente) {
            c = c + aliment.getCantitate();
        }
        return c;
    }

    public static double pretTotalAlimente(List<Alimente> dateAlimente) {
        double p = 0;
        for (Alimente aliment : dateAlimente) {
            p = p + aliment.getCantitate() * aliment.getPret();
        }
        return p;
    }

    public static double cantitateTotalaElectronice(List<Electronice> dateElectronice) {
        double c = 0;
        for (Electronice electronice : dateElectronice) {
            c = c + electronice.getCantitate();
        }
        return c;
    }

    public static double pretTotalElectronice(List<Electronice> dateElectronice) {
        double p = 0;
        for (Electronice electronice : dateElectronice) {
            p = p + electronice.getCantitate() * electronice.getPret();
        }
        return p;
    }

    public static double cantitateTotalaImbracaminte(List<Imbracaminte> dateImbracaminte) {
        double c = 0;
        for (Imbracaminte imbracaminte : dateImbracaminte) {
            c = c + imbracaminte.getCantitate();
        }
        return c;
    }

    public static double pretTotalImbracaminte(List<Imbracaminte> dateImbracaminte) {
        double p = 0;
        for (Imbracaminte imbracaminte : dateImbracaminte) {
            p = p + imbracaminte.getCantitate() * imbracaminte.getPret();
        }
        return p;
    }

    public static double cantitateTotalaIngrijire(List<IngrijirePersonala> dateIngrijire) {
        double c = 0;
        for (IngrijirePersonala ingrijire : dateIngrijire) {
            c = c + ingrijire.getCantitate();
        }
        return c;
    }

    public static double pretTotalIngrijire(List<IngrijirePersonala> dateIngrijire) {
        double p = 0;
        for (IngrijirePersonala ingrijire : dateIngrijire) {
            p = p + ingrijire.getCantitate() * ingrijire.getPret();
        }
        return p;
    }

    public static void Inventar(List<Alimente> dateAlimente, List<Imbracaminte> dateImbracaminte, List<Electronice> dateElectronice, List<IngrijirePersonala> dateIngrijire) {
        double c1 = cantitateTotalaAlimente(dateAlimente);
        double c2 = cantitateTotalaElectronice(dateElectronice);
        double c3 = cantitateTotalaImbracaminte(dateImbracaminte);
        double c4 = cantitateTotalaIngrijire(dateIngrijire);
        double p1 = pretTotalAlimente(dateAlimente);
        double p2 = pretTotalElectronice(dateElectronice);
        double p3 = pretTotalImbracaminte(dateImbracaminte);
        double p4 = pretTotalIngrijire(dateIngrijire);
        System.out.println("Magazinul dispune de un numar de :" +
                "\n - " + c1 + " produse din categoria alimente in valoare totala de " + p1 + " lei" +
                "\n - " + c2 + " produse din categoria electronice in valoare totala de " + p2 + " lei" +
                "\n - " + c3 + " produse din categoria imbracaminte in valoare totala de " + p3 + " lei" +
                "\n - " + c4 + " produse din categoria ingrijire personala in valoare totala de " + p4 + " lei" +
                "\n - " + "Un total de " + (c1 + c2 + c3 + c4) + " de produse in valoare de " + (p1 + p2 + p3 + p4) + " lei" +
                "\n");
    }

    public static double suplimenteazaCantitate(List<Alimente> dateAlimente, List<Imbracaminte> dateImbracaminte, List<Electronice> dateElectronice, List<IngrijirePersonala> dateIngrijire, String produs, double cantitate) throws CantitateInsuficienta {
        boolean valid = false;
        double cantitateFinala = 0;
        for (Alimente alimente : dateAlimente) {
            if (produs.equalsIgnoreCase(alimente.getDenumire())) {
                cantitateFinala = alimente.getCantitate() + cantitate;
                alimente.setCantitate(cantitateFinala);
                valid = true;
                break;
            }
        }

        if (!valid) {
            for (Electronice electronice : dateElectronice) {
                if (produs.equalsIgnoreCase(electronice.getDenumire())) {
                    cantitateFinala = electronice.getCantitate() + cantitate;
                    electronice.setCantitate(cantitateFinala);
                    valid = true;
                    break;
                }
            }
        }
        if (!valid) {
            for (Imbracaminte imbracaminte : dateImbracaminte) {
                if (produs.equalsIgnoreCase(imbracaminte.getDenumire())) {
                    cantitateFinala = imbracaminte.getCantitate() + cantitate;
                    imbracaminte.setCantitate(cantitateFinala);
                    valid = true;
                    break;
                }
            }
        }
        if (!valid) {
            for (IngrijirePersonala ingrijirePersonala : dateIngrijire) {
                if (produs.equalsIgnoreCase(ingrijirePersonala.getDenumire())) {
                    cantitateFinala = ingrijirePersonala.getCantitate() + cantitate;
                    ingrijirePersonala.setCantitate(cantitateFinala);
                    valid = true;
                    break;
                }
            }
        }
        if (!valid) {
            System.out.println("");
            cantitateFinala = cantitate;
        }
        return cantitateFinala;
    }
    }







