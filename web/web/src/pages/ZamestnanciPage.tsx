import {ZamestnanciSeznam} from "../components/Zamestnanci/ZamestnanciSeznam.tsx";

export default function ZamestnanciPage(){
    return  (
        <div>
            <h1> Správa zaměstnanců </h1>
            <h3> Kompletní výpis zaměstnanců</h3>
            <ZamestnanciSeznam/>
        </div>
    );

}