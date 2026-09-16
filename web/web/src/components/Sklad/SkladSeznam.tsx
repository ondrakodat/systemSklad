import {useState, useEffect} from "react";
import type {SkladDto} from "../../models/SkladDto.ts";
import {dejSklady} from "../../services/SkladService.ts";
import SkladCard from "./SkladCard.tsx";

export default function SkladySeznam(){
    const[sklady, setSklady] = useState<SkladDto[]>([]);
    const[sklad, setSklad] = useState<number | null>(null);

    useEffect(() => {
        async function nactiSklady(){
            const data = await dejSklady();
            setSklady(data);
        }
        nactiSklady();
    }, [])



    return(
        <div>
            <p> Nalezeno : {sklady.length} </p>
            <table className="table table-striped table-hover text-center table-bordered table condensed table-responsive">
                <thead>
                <tr>
                    <th> Nazev </th>
                    <th> Mesto </th>
                    <th> Další </th>
                </tr>
                </thead>
                <tbody>
                {sklady.map((sklad) => (
                        <tr key={sklad.id}>
                            <td>{sklad.nazev}</td>
                            <td>{sklad.mesto }</td>
                            <td>
                                <button className="btn btn-outline-dark"
                                onClick={() => setSklad(sklad.id)}
                                >
                                    Podrobnosti
                                </button>
                            </td>
                        </tr>
                    )
                )}
                </tbody>
            </table>
            {sklad && (
                <SkladCard sklad={sklad} />
            )}
        </div>
    );
}