import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by daga on 12.01.2017.
 */
public class JSONDownloaderTest {

    JSONObject compare= new JSONObject("{  \n" +
            "   \"id\":\"174\",\n" +
            "   \"dataset\":\"poslowie\",\n" +
            "   \"url\":\"https:\\/\\/api-v3.mojepanstwo.pl\\/dane\\/poslowie\\/174\",\n" +
            "   \"mp_url\":\"https:\\/\\/mojepanstwo.pl\\/dane\\/poslowie\\/174\",\n" +
            "   \"schema_url\":\"https:\\/\\/api-v3.mojepanstwo.pl\\/schemas\\/dane\\/poslowie.json\",\n" +
            "   \"global_id\":\"1556675\",\n" +
            "   \"slug\":\"klosowski-slawomir\",\n" +
            "   \"score\":null,\n" +
            "   \"data\":{  \n" +
            "      \"ludzie.id\":\"162\",\n" +
            "      \"ludzie.nazwa\":\"S\\u0142awomir K\\u0142osowski\",\n" +
            "      \"ludzie.slug\":\"slawomir-klosowski\",\n" +
            "      \"sejm_kluby.id\":\"2\",\n" +
            "      \"sejm_kluby.skrot\":\"PiS\",\n" +
            "      \"sejm_kluby.nazwa\":\"Prawo i Sprawiedliwo\\u015b\\u0107\",\n" +
            "      \"poslowie.wartosc_biuro_inne\":2115.78,\n" +
            "      \"poslowie.wartosc_biuro_ekspertyzy\":0,\n" +
            "      \"poslowie.wartosc_biuro_materialy_biurowe\":4289.64,\n" +
            "      \"poslowie.frekwencja\":92.3,\n" +
            "      \"poslowie.mandat_wygasl\":\"1\",\n" +
            "      \"poslowie.wartosc_biuro_taksowki\":0,\n" +
            "      \"poslowie.sejm_okreg_id\":\"21\",\n" +
            "      \"poslowie.liczba_przelotow\":51,\n" +
            "      \"poslowie.wartosc_biuro_zlecenia\":13708.58,\n" +
            "      \"poslowie.liczba_projektow_uchwal\":32,\n" +
            "      \"poslowie.imiona\":\"S\\u0142awomir\",\n" +
            "      \"poslowie.biuro_html\":\"<table><thead><th class=\\\"left\\\">Wydatkowanie kwoty rycza\\u0142tu przeznaczonego na prowadzenie biura poselskiego:<\\/th><\\/thead><tbody><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2011161\\/$File\\/2011ryczalt_161.pdf?OpenElement\\\" target=\\\"_blank\\\">2011 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2012161\\/$File\\/2012ryczalt_161.pdf?OpenElement\\\" target=\\\"_blank\\\">2012 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2013161\\/$File\\/2013ryczalt_161.pdf?OpenElement\\\" target=\\\"_blank\\\">2013 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2014161\\/$File\\/2014ryczalt_161.pdf?OpenElement\\\" target=\\\"_blank\\\">2014 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Rozliczenie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2015161\\/$File\\/2015ryczalt_161.pdf?OpenElement\\\" target=\\\"_blank\\\">okres sprawowania mandatu <\\/A><\\/td><\\/tr><\\/tbody><\\/table>\",\n" +
            "      \"poslowie.wartosc_biuro_wynagrodzenia_pracownikow\":49159.18,\n" +
            "      \"poslowie.numer_legitymacji\":161,\n" +
            "      \"poslowie.data_wygasniecia_mandatu\":\"2015-11-26\",\n" +
            "      \"poslowie.imie_pierwsze\":\"S\\u0142awomir\",\n" +
            "      \"poslowie.liczba_glosow\":14165,\n" +
            "      \"poslowie.procent_glosow\":4.43,\n" +
            "      \"poslowie.pkw_komitet_id\":\"7\",\n" +
            "      \"poslowie.wartosc_uposazenia_pln\":9892.3,\n" +
            "      \"poslowie.zawod\":\"nauczyciel historii\",\n" +
            "      \"poslowie.data_urodzenia\":\"1964-02-21\",\n" +
            "      \"poslowie.okreg_gminy_str\":\"Opole, K\\u0119dzierzyn-Ko\\u017ale, Nysa\",\n" +
            "      \"poslowie.imie_drugie\":\"\",\n" +
            "      \"poslowie.kadencja_ostatnia\":\"8\",\n" +
            "      \"poslowie.wartosc_biuro_spotkania\":0,\n" +
            "      \"poslowie.liczba_glosowan_zbuntowanych\":21,\n" +
            "      \"poslowie.klub_id\":\"2\",\n" +
            "      \"poslowie.liczba_komisji\":2,\n" +
            "      \"poslowie.wartosc_wyjazdow\":0,\n" +
            "      \"poslowie.zbuntowanie\":0.3,\n" +
            "      \"poslowie.nazwa_odwrocona\":\"K\\u0142osowski S\\u0142awomir\",\n" +
            "      \"poslowie.twitter_account_id\":\"95\",\n" +
            "      \"poslowie.wartosc_biuro_przejazdy\":35103.6,\n" +
            "      \"poslowie.liczba_glosowan_opuszczonych\":482,\n" +
            "      \"poslowie.plec\":\"M\",\n" +
            "      \"poslowie.kadencja\":[  \n" +
            "         7,\n" +
            "         8\n" +
            "      ],\n" +
            "      \"poslowie.id\":\"174\",\n" +
            "      \"poslowie.wartosc_refundacja_kwater_pln\":0,\n" +
            "      \"poslowie.liczba_interpelacji\":7,\n" +
            "      \"poslowie.nazwa\":\"S\\u0142awomir K\\u0142osowski\",\n" +
            "      \"poslowie.dopelniacz\":\"S\\u0142awomira K\\u0142osowskiego\",\n" +
            "      \"poslowie.wartosc_biuro_telekomunikacja\":5426.2,\n" +
            "      \"poslowie.liczba_uchwal_komisji_etyki\":0,\n" +
            "      \"poslowie.nazwisko\":\"K\\u0142osowski\",\n" +
            "      \"poslowie.wartosc_biuro_biuro\":24024.64,\n" +
            "      \"poslowie.miejsce_urodzenia\":\"Wambierzyce\",\n" +
            "      \"poslowie.wartosc_biuro_podroze_pracownikow\":35.1,\n" +
            "      \"poslowie.krs_osoba_id\":\"0\",\n" +
            "      \"poslowie.liczba_podkomisji\":2,\n" +
            "      \"poslowie.liczba_przejazdow\":54,\n" +
            "      \"poslowie.numer_na_liscie\":2,\n" +
            "      \"poslowie.rozliczenie_id\":\"274667\",\n" +
            "      \"poslowie.pkw_nr_listy\":\"0\",\n" +
            "      \"poslowie.liczba_wyjazdow\":0,\n" +
            "      \"poslowie.liczba_wypowiedzi\":83,\n" +
            "      \"poslowie.liczba_projektow_ustaw\":43,\n" +
            "      \"poslowie.liczba_glosowan\":6280,\n" +
            "      \"poslowie.liczba_wnioskow\":0,\n" +
            "      \"poslowie.miejsce_zamieszkania\":\"Opole\",\n" +
            "      \"poslowie.mowca_id\":\"162\",\n" +
            "      \"poslowie.okreg_wyborczy_numer\":\"21\",\n" +
            "      \"poslowie.liczba_slow\":42587,\n" +
            "      \"poslowie.wartosc_biuro_srodki_trwale\":399\n" +
            "   },\n" +
            "   \"layers\":{  \n" +
            "      \"dataset\":null,\n" +
            "      \"channels\":null,\n" +
            "      \"page\":null,\n" +
            "      \"subscribers\":null\n" +
            "   },\n" +
            "   \"Aggs\":{  \n" +
            "      \"_page\":{  \n" +
            "         \"doc_count\":0,\n" +
            "         \"page\":{  \n" +
            "            \"hits\":{  \n" +
            "               \"total\":0,\n" +
            "               \"max_score\":null,\n" +
            "               \"hits\":[  \n" +
            "\n" +
            "               ]\n" +
            "            }\n" +
            "         }\n" +
            "      }\n" +
            "   }\n" +
            "}");
    JSONObject compare1= new JSONObject("{  \n" +
            "   \"id\":\"95\",\n" +
            "   \"dataset\":\"poslowie\",\n" +
            "   \"url\":\"https:\\/\\/api-v3.mojepanstwo.pl\\/dane\\/poslowie\\/95\",\n" +
            "   \"mp_url\":\"https:\\/\\/mojepanstwo.pl\\/dane\\/poslowie\\/95\",\n" +
            "   \"schema_url\":\"https:\\/\\/api-v3.mojepanstwo.pl\\/schemas\\/dane\\/poslowie.json\",\n" +
            "   \"global_id\":\"1556596\",\n" +
            "   \"slug\":\"garbowski-tomasz\",\n" +
            "   \"score\":null,\n" +
            "   \"data\":{  \n" +
            "      \"ludzie.id\":\"84\",\n" +
            "      \"ludzie.nazwa\":\"Tomasz Garbowski\",\n" +
            "      \"ludzie.slug\":\"tomasz-garbowski\",\n" +
            "      \"sejm_kluby.id\":\"4\",\n" +
            "      \"sejm_kluby.skrot\":\"SLD\",\n" +
            "      \"sejm_kluby.nazwa\":\"Sojusz Lewicy Demokratycznej\",\n" +
            "      \"poslowie.wartosc_biuro_inne\":1136.69,\n" +
            "      \"poslowie.wartosc_biuro_ekspertyzy\":0,\n" +
            "      \"poslowie.wartosc_biuro_materialy_biurowe\":1414.28,\n" +
            "      \"poslowie.frekwencja\":78.1,\n" +
            "      \"poslowie.mandat_wygasl\":\"0\",\n" +
            "      \"poslowie.wartosc_biuro_taksowki\":1274.05,\n" +
            "      \"poslowie.sejm_okreg_id\":\"21\",\n" +
            "      \"poslowie.liczba_przelotow\":23,\n" +
            "      \"poslowie.wartosc_biuro_zlecenia\":1455,\n" +
            "      \"poslowie.liczba_projektow_uchwal\":25,\n" +
            "      \"poslowie.imiona\":\"Tomasz Robert\",\n" +
            "      \"poslowie.biuro_html\":\"<table><thead><th class=\\\"left\\\">Wydatkowanie kwoty rycza\\u0142tu przeznaczonego na prowadzenie biura poselskiego:<\\/th><\\/thead><tbody><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2011095\\/$File\\/2011ryczalt_095.pdf?OpenElement\\\" target=\\\"_blank\\\">2011 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Korekta za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2011095k\\/$File\\/2011ryczaltkor_095.pdf?OpenElement\\\" target=\\\"_blank\\\">2011 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2012095\\/$File\\/2012ryczalt_095.pdf?OpenElement\\\" target=\\\"_blank\\\">2012 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Korekta za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2012095k\\/$File\\/2012ryczaltkor_095.pdf?OpenElement\\\" target=\\\"_blank\\\">2012 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2013095\\/$File\\/2013ryczalt_095.pdf?OpenElement\\\" target=\\\"_blank\\\">2013 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2014095\\/$File\\/2014ryczalt_095.pdf?OpenElement\\\" target=\\\"_blank\\\">2014 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Rozliczenie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2015095\\/$File\\/2015ryczalt_095.pdf?OpenElement\\\" target=\\\"_blank\\\">okres sprawowania mandatu <\\/A><\\/td><\\/tr><\\/tbody><\\/table>\",\n" +
            "      \"poslowie.wartosc_biuro_wynagrodzenia_pracownikow\":73847.58,\n" +
            "      \"poslowie.numer_legitymacji\":95,\n" +
            "      \"poslowie.imie_pierwsze\":\"Tomasz\",\n" +
            "      \"poslowie.liczba_glosow\":6828,\n" +
            "      \"poslowie.procent_glosow\":2.14,\n" +
            "      \"poslowie.pkw_komitet_id\":\"5\",\n" +
            "      \"poslowie.wartosc_uposazenia_pln\":9892.3,\n" +
            "      \"poslowie.zawod\":\"historyk\",\n" +
            "      \"poslowie.data_urodzenia\":\"1979-01-07\",\n" +
            "      \"poslowie.okreg_gminy_str\":\"Opole, K\\u0119dzierzyn-Ko\\u017ale, Nysa\",\n" +
            "      \"poslowie.imie_drugie\":\"Robert\",\n" +
            "      \"poslowie.kadencja_ostatnia\":\"7\",\n" +
            "      \"poslowie.wartosc_biuro_spotkania\":2200.7,\n" +
            "      \"poslowie.liczba_glosowan_zbuntowanych\":106,\n" +
            "      \"poslowie.klub_id\":\"4\",\n" +
            "      \"poslowie.liczba_komisji\":2,\n" +
            "      \"poslowie.wartosc_wyjazdow\":72533.1,\n" +
            "      \"poslowie.zbuntowanie\":1.7,\n" +
            "      \"poslowie.nazwa_odwrocona\":\"Garbowski Tomasz\",\n" +
            "      \"poslowie.twitter_account_id\":\"70\",\n" +
            "      \"poslowie.wartosc_biuro_przejazdy\":35103.6,\n" +
            "      \"poslowie.liczba_glosowan_opuszczonych\":1350,\n" +
            "      \"poslowie.plec\":\"M\",\n" +
            "      \"poslowie.kadencja\":[  \n" +
            "         7\n" +
            "      ],\n" +
            "      \"poslowie.id\":\"95\",\n" +
            "      \"poslowie.wartosc_refundacja_kwater_pln\":0,\n" +
            "      \"poslowie.liczba_interpelacji\":189,\n" +
            "      \"poslowie.nazwa\":\"Tomasz Garbowski\",\n" +
            "      \"poslowie.dopelniacz\":\"Tomasza Garbowskiego\",\n" +
            "      \"poslowie.wartosc_biuro_telekomunikacja\":6062.35,\n" +
            "      \"poslowie.liczba_uchwal_komisji_etyki\":0,\n" +
            "      \"poslowie.nazwisko\":\"Garbowski\",\n" +
            "      \"poslowie.wartosc_biuro_biuro\":24532.91,\n" +
            "      \"poslowie.miejsce_urodzenia\":\"Kluczbork\",\n" +
            "      \"poslowie.wartosc_biuro_podroze_pracownikow\":4682.67,\n" +
            "      \"poslowie.krs_osoba_id\":\"0\",\n" +
            "      \"poslowie.liczba_podkomisji\":2,\n" +
            "      \"poslowie.liczba_przejazdow\":69,\n" +
            "      \"poslowie.numer_na_liscie\":1,\n" +
            "      \"poslowie.rozliczenie_id\":\"274383\",\n" +
            "      \"poslowie.pkw_nr_listy\":\"0\",\n" +
            "      \"poslowie.liczba_wyjazdow\":10,\n" +
            "      \"poslowie.liczba_wypowiedzi\":15,\n" +
            "      \"poslowie.liczba_projektow_ustaw\":85,\n" +
            "      \"poslowie.liczba_glosowan\":6174,\n" +
            "      \"poslowie.liczba_wnioskow\":0,\n" +
            "      \"poslowie.miejsce_zamieszkania\":\"Opole\",\n" +
            "      \"poslowie.mowca_id\":\"84\",\n" +
            "      \"poslowie.okreg_wyborczy_numer\":\"21\",\n" +
            "      \"poslowie.liczba_slow\":11814,\n" +
            "      \"poslowie.wartosc_biuro_srodki_trwale\":429.27\n" +
            "   },\n" +
            "   \"layers\":{  \n" +
            "      \"dataset\":null,\n" +
            "      \"channels\":null,\n" +
            "      \"page\":null,\n" +
            "      \"subscribers\":null\n" +
            "   },\n" +
            "   \"Aggs\":{  \n" +
            "      \"_page\":{  \n" +
            "         \"doc_count\":0,\n" +
            "         \"page\":{  \n" +
            "            \"hits\":{  \n" +
            "               \"total\":0,\n" +
            "               \"max_score\":null,\n" +
            "               \"hits\":[  \n" +
            "\n" +
            "               ]\n" +
            "            }\n" +
            "         }\n" +
            "      }\n" +
            "   }\n" +
            "}\n" +
            "\n");

    @Test
    public void runtest() throws IOException
    {

        JSONObject test1 =JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie/95.json?layers=dataset");
        JSONObject test =JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie/174.json?layers=dataset");
        assertEquals(test.toString(),compare.toString());
        assertEquals(test1.toString(),compare1.toString());

    }



}

