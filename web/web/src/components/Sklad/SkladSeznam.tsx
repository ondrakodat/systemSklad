import {useState, useEffect} from "react";
import type {SkladDto} from "../../models/SkladDto.ts";
import {dejSklady} from "../../services/SkladService.ts";

export default function SkladySeznam(){
    const[sklady, setSklady] = useState<SkladDto[]>([]);

    useEffect(() => {
        async function nactiSklady(){
            const data = await dejSklady();
            setSklady(data);
        }
        nactiSklady();
    }, [])

    function ZobrazTlacitko(){
        return <div>
            <button className="btn btn-outline-dark" > Detail </button>
        </div>
    }


    return(
        <div>
            <p> Nalezeno : {sklady.length} </p>
            <table className="table table-striped table-hover text-center table-bordered table condensed table-responsive">
                <thead>
                <tr>
                    <th> Nazev </th>
                    <th> Mesto </th>
                    <th> Detail </th>
                </tr>
                </thead>
                <tbody>
                {sklady.map((sklad) => (
                        <tr key={sklad.id}>
                            <td>{sklad.nazev}</td>
                            <td>{sklad.mesto }</td>
                            <ZobrazTlacitko/>
                        </tr>
                    )
                )}
                </tbody>
            </table>
        </div>
    );
}