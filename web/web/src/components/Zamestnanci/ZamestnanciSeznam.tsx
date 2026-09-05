import {useState, useEffect} from "react";
import {dejZamestnance} from "../../services/ZamestnanecService.ts";
import type {ZamestnanecDto} from "../../models/ZamestnanecDto.ts";


export function ZamestnanciSeznam(){
    const [zamestnanci, setZamestnanci] = useState<ZamestnanecDto[]>([]);

    useEffect(() => {
        async function nactiZamestnance(){
            const data = await dejZamestnance();

            console.log("DATA:", data);
            console.log("POCET:", data.length);

            setZamestnanci(data);
        }
        nactiZamestnance();
    }, [])

    function ZobrazTlacitko(){
        return <div>
            <button className="btn btn-outline-dark"> Zobrazit </button>
        </div>
    }

    return <div>
        <p> Pocet zamestnancu : {zamestnanci.length} </p>
        <table className="table table-striped table-hover text-center table-bordered table condensed table-responsive">
            <thead>
                <tr>
                    <th> Jmeno </th>
                    <th> Prijmeni </th>
                    <th> Email </th>
                    <th> Detail </th>
                </tr>
            </thead>
            <tbody>
                    {zamestnanci.map((zamestnanec) => (
                        <tr>
                            <td>{zamestnanec.jmeno}</td>
                            <td>{zamestnanec.prijmeni}</td>
                            <td>{zamestnanec.email}</td>
                            <td> {ZobrazTlacitko()} </td>
                        </tr>
                        )
                    )}
            </tbody>
        </table>
    </div>
}
