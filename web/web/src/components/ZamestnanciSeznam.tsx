import {useState, useEffect} from "react";
import {dejZamestnance} from "../services/ZamestnanecService.ts";
import type {ZamestnanecDto} from "../models/ZamestnanecDto.ts";


export function ZamestnanciSeznam(){
    const [zamestnanci, setZamestnanci] = useState<ZamestnanecDto[]>([]);

    useEffect(() => {
        async function nactiZamestnance(){
            const data = await dejZamestnance();

            console.log("DATA:", data);
            console.log("POCET:", data.length);

            setZamestnanci(data);
            setZamestnanci(data);
        }
        nactiZamestnance();
    }, [])

    return <div>
        <h1> Seznam zamestnancu </h1>
        <p> Pocet zamestnancu : {zamestnanci.length} </p>
        {
            zamestnanci.map((zamestnanec) => (
                <div key={zamestnanec.id}>
                    <p>
                        Jmeno {zamestnanec.jmeno}
                    </p>
                    <p>
                        Prijmeni {zamestnanec.prijmeni}
                    </p>
                    <p>
                        Email {zamestnanec.email}
                    </p>
                </div>
            ))
        }
    </div>
}