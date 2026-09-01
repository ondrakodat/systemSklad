export interface ProduktDto {
    id : number;
    nazev : string;
    popis : string;
    kategorieId : number;
    cena : number;
    nakupniCena : number;
    minimalniSkladovaneMnozstvi : number;
    ean : string;
    hmotnost : number;
}