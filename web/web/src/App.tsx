import  {DejInfoOProduktu, DejNazevProduktu } from "./components/ProduktKomponenta.tsx";
import type {ProduktDto} from "./models/ProduktDto.ts";

function App() {

  const produkt: ProduktDto = {
    id: 1,
    nazev: "Notebook",
    popis: "Herní notebook",
    kategorieId: 2,
    cena: 25000,
    nakupniCena: 20000,
    minimalniSkladovaneMnozstvi: 5,
    ean: "123456789",
    hmotnost: 2.5
  };

  return <div>
      <p> Toto je react </p>
      <DejInfoOProduktu dto = {produkt} />
      <DejNazevProduktu dto = {produkt} />
  </div>
}

export default App;