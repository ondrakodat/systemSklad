import {DejInfo} from "./components/Info.tsx";
import {DejZajmy} from "./components/Zajmy.tsx";
import {DejJmeno} from "./components/Jmeno.tsx";


function App() {
  return <div>
    <h1> Skladovy systém 1.0.0 </h1>
    <DejJmeno jmeno={"Ondra Kodat"}/>
    <DejInfo vaha={72} vyska={169}/>
    <DejZajmy/>


  </div>
}

export default App;