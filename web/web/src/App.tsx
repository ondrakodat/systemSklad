import {ZamestnanciSeznam} from "./components/ZamestnanciSeznam.tsx";
import HeaderSklad from "./components/HeaderSklad.tsx";
import {BrowserRouter} from "react-router-dom";

function App() {
  return <BrowserRouter>
    <HeaderSklad/>
    <div>
      <h1> Skladový systém 1.0.0 </h1>
      <p> Vypis zamestnancu </p>
      <ZamestnanciSeznam/>
    </div>

  </BrowserRouter>
}

export default App;