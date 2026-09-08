import {useEffect, useState} from "react";
import type {KategorieDto} from "../models/KategorieDto.ts";
import {dejKategorie} from "../services/KategorieService.ts";

export function SeznamKategorii(){
    const[kategorie, setKategorie] = useState<KategorieDto[]>([])
    useEffect(() => {
        async function vypisKategorie(){
            const data = await dejKategorie();
            setKategorie(data);
        }
        vypisKategorie();
    }, [])

    function ZobrazTlacitko(){
        return <div>
            <button className="btn btn-outline-dark"> Detail </button>
        </div>
    }

    return (
        <div>
            <table className="table table-striped table-hover text-center table-bordered table condensed table-responsive">
                <thead>
                <tr>
                    <th> Nazev </th>
                    <th> NadKategorie </th>
                    <th> Detail </th>
                </tr>
                </thead>
                <tbody>
                {kategorie.map((jednaKategorie) => (
                        <tr>
                            <td>{jednaKategorie.nazev}</td>
                            <td>{jednaKategorie.nadKategorie }</td>
                            <td> {ZobrazTlacitko()} </td>
                        </tr>
                    )
                )}
                </tbody>
            </table>
        </div>
    )

}