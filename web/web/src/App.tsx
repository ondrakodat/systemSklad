import HeaderSklad from "./components/HeaderSklad.tsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import ZamestnanciPage from "./pages/ZamestnanciPage.tsx";
import ProduktPage from "./pages/ProduktPage.tsx";
import SkladPage from "./pages/Sklad.tsx";
import {KategoriePage} from "./pages/KategoriePage.tsx";

function App() {
  return <BrowserRouter>
    <HeaderSklad/>
    <div>
    </div>
    <Routes>
      <Route path="/" element={
        <div>
          <h1> Skladový systém 1.0.0 </h1>
          <p> Domovksá stránka </p>
        </div>
      } />

      <Route
        path="/zamestnanci"
        element={
        <ZamestnanciPage/>
        }
      />

      <Route path="/produkty" element={
        <ProduktPage/>
      }/>

      <Route path="/sklady" element={<SkladPage/>}
      />

      <Route
      path="kategorie"
      element={
        <KategoriePage/>
      }
      />


    </Routes>

  </BrowserRouter>
}

export default App;