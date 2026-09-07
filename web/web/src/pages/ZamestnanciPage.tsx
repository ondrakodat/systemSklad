import {ZamestnanciSeznam} from "../components/Zamestnanci/ZamestnanciSeznam.tsx";
import {ZamestnanciSeznamNalezeni} from "../components/Zamestnanci/ZamestnanciSeznamNalezeni.tsx";

export default function ZamestnanciPage() {
    return (
        <div>
            <h1>Správa zaměstnanců</h1>

            <h3>Vyhledávání zaměstnanců</h3>
            <ZamestnanciSeznamNalezeni/>

            <hr/>

            <h3>Kompletní výpis zaměstnanců</h3>
            <ZamestnanciSeznam/>



        </div>
    );
}