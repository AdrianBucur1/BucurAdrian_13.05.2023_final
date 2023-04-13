package com.itfactory.metode;

import com.itfactory.claseDeObiecte.*;
import com.itfactory.exceptii.BugetInvalid;
import com.itfactory.exceptii.CantitateInsuficienta;
import org.junit.Test;
import org.junit.Before;
import java.time.LocalDate;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class MetodeTest {

    LocalDate dataExpirare = LocalDate.now().plusDays(5);
    Alimente aliment0 = new Alimente("lapte", 8, 20, LocalDate.parse("2023-05-28"));
    Alimente aliment1 = new Alimente("oua", 20, 30, LocalDate.parse("2023-05-20"));
    Alimente aliment2 = new Alimente("paine", 6, 50, dataExpirare);
    List<Alimente> listaAlimente = List.of(new Alimente[]{aliment0, aliment1, aliment2});

    Electronice electronice0 = new Electronice("televizor", 2300, 3, 3);
    Electronice electronice1 = new Electronice("smartphone", 3200, 5, 3);
    Electronice electronice2 = new Electronice("calculator", 7500, 2, 4);
    List<Electronice> listaElectronice = List.of(new Electronice[]{electronice0, electronice1, electronice2});

    Imbracaminte imbracaminte0 = new Imbracaminte("tricou", 120, 10, 30);
    Imbracaminte imbracaminte1 = new Imbracaminte("pantaloni scurti", 80, 10, 30);
    Imbracaminte imbracaminte2 = new Imbracaminte("geaca de ploaie", 450, 3, 60);
    List<Imbracaminte> listaImbracaminte = List.of(new Imbracaminte[]{imbracaminte0, imbracaminte1, imbracaminte2});

    IngrijirePersonala ingrijire0 = new IngrijirePersonala("parfum", 330, 7, false);
    IngrijirePersonala ingrijire1 = new IngrijirePersonala("deodorant", 35, 5, true);
    IngrijirePersonala ingrijire2 = new IngrijirePersonala("gel de dus", 45, 10, true);
    List<IngrijirePersonala> listaIngrijirePersonala = List.of(new IngrijirePersonala[]{ingrijire0, ingrijire1, ingrijire2});


    Cumparator cumparator1 = new Cumparator(10);
    Cumparator cumparator2 = new Cumparator(10000);
    Metode metode;

    @Before
    public void setup() {
        metode = new Metode();
    }

    @Test
    public void testCumparaAlimente1() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaAlimente(listaAlimente, cumparator1, "lapte", 20);
        String mesajAsteptat = "Fonduri insuficiente";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaAlimente2() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaAlimente(listaAlimente, cumparator2, "banane", 20);
        String mesajAsteptat = "Acest produs nu exista in magazin";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaAlimente3() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaAlimente(listaAlimente, cumparator2, "lapte", 21);
        String mesajAsteptat = "Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaAlimente4() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaAlimente(listaAlimente, cumparator2, "lapte", 20);
        String mesajAsteptat = "Produsul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator2.getBuget();
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaAlimente5() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaAlimente(listaAlimente, cumparator2, "paine", 20);
        String mesajAsteptat = null;
        for (Alimente aliment : listaAlimente) {
            if (aliment.getDenumire().equalsIgnoreCase("paine")) {
                mesajAsteptat = "Produsul beneficiaza de o reducere de 50% pentru ca urmeaza sa expire in urmatoarele zile. " +
                        "Pretul final este de : " + aliment.getPret() + " lei. " +
                        "\nProdusul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator2.getBuget();
                break;
            }
        }
        assertEquals(mesajAsteptat, mesajRezultat);
    }

    @Test
    public void testReducereAlimente1(){
        double pretRedus = aliment0.getPret()*0.5;
        assertNotEquals(Metode.reducereAlimente(aliment0),pretRedus);
    }

    @Test
    public void testReducereAlimente2(){
        double pretRedus = aliment1.getPret()*0.5;
        assertNotEquals(Metode.reducereAlimente(aliment1),pretRedus);
    }

    @Test
    public void testReducereAlimente3(){
        double pretRedus = aliment2.getPret()*0.5;
        assertEquals(Metode.reducereAlimente(aliment2),pretRedus);
    }


    @Test
    public void testCumparaElectronice1() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaElectronice(listaElectronice, cumparator1, "televizor", 1);
        String mesajAsteptat = "Fonduri insuficiente";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaElectronice2() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaElectronice(listaElectronice, cumparator2, "lampa", 1);
        String mesajAsteptat = "Acest produs nu exista in magazin";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaElectronice3() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaElectronice(listaElectronice, cumparator2, "televizor", 5);
        String mesajAsteptat = "Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaElectronice4() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaElectronice(listaElectronice, cumparator2, "televizor", 1);
        String mesajAsteptat = "Produsul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator2.getBuget();
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testPretFinalGarantieExtinsa(){
        double pretFinal= electronice1.getPret()*1.2;
        assertEquals(Metode.pretFinalGarantieExtinsa(electronice1),pretFinal);
    }

    @Test
    public void testCumparaImbracaminte1() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaImbracaminte(listaImbracaminte, cumparator1, "tricou", 1);
        String mesajAsteptat = "Fonduri insuficiente";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaImbracaminte2() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaImbracaminte(listaImbracaminte, cumparator2, "hanorac", 1);
        String mesajAsteptat = "Acest produs nu exista in magazin";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaImbracaminte3() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaImbracaminte(listaImbracaminte, cumparator2, "pantaloni scurti", 25);
        String mesajAsteptat = "Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaImbracaminte4() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaImbracaminte(listaImbracaminte, cumparator2, "geaca de ploaie", 1);
        String mesajAsteptat = "Produsul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator2.getBuget();
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaIngrijire1() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaIngrijire(listaIngrijirePersonala, cumparator1, "parfum", 1);
        String mesajAsteptat = "Fonduri insuficiente";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaIngrijire2() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaIngrijire(listaIngrijirePersonala, cumparator2, "pasta de dinti", 1);
        String mesajAsteptat = "Acest produs nu exista in magazin";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaIngrijire3() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaIngrijire(listaIngrijirePersonala, cumparator2, "gel de dus", 25);
        String mesajAsteptat = "Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.";
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testCumparaIngrijire4() throws BugetInvalid, CantitateInsuficienta {
        String mesajRezultat = Metode.cumparaIngrijire(listaIngrijirePersonala, cumparator2, "deodorant", 1);
        String mesajAsteptat = "Produsul a fost achizitionat cu succes. Fonduri disponibile ramase: " + cumparator2.getBuget();
        assertEquals(mesajAsteptat,mesajRezultat);
    }

    @Test
    public void testSuplimenteazaCantitateAlimente() throws CantitateInsuficienta {
        double s1=aliment2.getCantitate()+10;
        double s2= Metode.suplimenteazaCantitate(listaAlimente, listaImbracaminte, listaElectronice, listaIngrijirePersonala, aliment2.getDenumire(), 10);
        assertEquals(s1,s2);
    }

    @Test
    public void testSuplimenteazaCantitateElectronice() throws CantitateInsuficienta {
        double s1=electronice1.getCantitate()+15;
        double s2= Metode.suplimenteazaCantitate(listaAlimente, listaImbracaminte, listaElectronice, listaIngrijirePersonala, electronice1.getDenumire(), 15);
        assertEquals(s1,s2);
    }

    @Test
    public void testSuplimenteazaCantitateImbracaminte() throws CantitateInsuficienta {
        double s1=imbracaminte0.getCantitate()+15;
        double s2= Metode.suplimenteazaCantitate(listaAlimente, listaImbracaminte, listaElectronice, listaIngrijirePersonala, imbracaminte0.getDenumire(), 15);
        assertEquals(s1,s2);
    }

    @Test
    public void testSuplimenteazaCantitateIngrijirePersonala() throws CantitateInsuficienta {
        double s1=ingrijire2.getCantitate()+5;
        double s2= Metode.suplimenteazaCantitate(listaAlimente, listaImbracaminte, listaElectronice, listaIngrijirePersonala, ingrijire2.getDenumire(), 5);
        assertEquals(s1,s2);
    }

    @Test
    public void testExistentaAlimente1() {
        assertTrue(Metode.existentaAliment("lapte",listaAlimente));
    }

    @Test
    public void testExistentaAlimente2() {
        assertFalse(Metode.existentaAliment("morcovi",listaAlimente));
    }

    @Test
    public void testExistentaElectronice1() {
        assertTrue(Metode.existentaElectronice("televizor",listaElectronice));
    }

    @Test
    public void testExistentaElectronice2() {
        assertFalse(Metode.existentaElectronice("lampa",listaElectronice));
    }

    @Test
    public void testExistentaImbracaminte1() {
        assertTrue(Metode.existentaImbracaminte("tricou",listaImbracaminte));
    }

    @Test
    public void testExistentaImbracaminte2() {
        assertFalse(Metode.existentaImbracaminte("sosete",listaImbracaminte));
    }

    @Test
    public void testExistentaIngrijirePersonala1() {
        assertTrue(Metode.existentaIngrijirePersonala("parfum",listaIngrijirePersonala));
    }

    @Test
    public void testExistentaIngrijirePersonala2() {
        assertFalse(Metode.existentaIngrijirePersonala("apa de gura",listaIngrijirePersonala));
    }

}







