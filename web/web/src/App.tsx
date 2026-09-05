import HeaderSklad from "./components/HeaderSklad.tsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import ZamestnanciPage from "./pages/ZamestnanciPage.tsx";
import ProduktPage from "./pages/ProduktPage.tsx";

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

    </Routes>

  </BrowserRouter>
}

export default App;