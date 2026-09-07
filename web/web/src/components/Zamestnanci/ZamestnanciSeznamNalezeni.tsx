import {useEffect, useState} from "react";
import type {ZamestnanecDto} from "../../models/ZamestnanecDto.ts";
import {dejZamestnancePodleNazvu} from "../../services/ZamestnanecService.ts";

export function ZamestnanciSeznamNalezeni() {

    const [nalezeniZamestnanci, setNalezeniZamestnanci] =
        useState<ZamestnanecDto[]>([]);

    const [nazev, setNazev] = useState("");

    useEffect(() => {

        async function nactiSeznamNalezenych() {

            if (nazev.trim() === "") {
                setNalezeniZamestnanci([]);
                return;
            }

            const data = await dejZamestnancePodleNazvu(nazev);
            setNalezeniZamestnanci(data);
        }

        nactiSeznamNalezenych();

    }, [nazev]);

    return (
        <div>

            <input
                type="text"
                className="form-control mb-3"
                placeholder="Hledat zaměstnance..."
                value={nazev}
                onChange={(e) => setNazev(e.target.value)}
            />

            <p>
                Počet nalezených zaměstnanců: {nalezeniZamestnanci.length}
            </p>

            <table className="table table-striped table-hover text-center table-bordered">
                <thead>
                <tr>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Email</th>
                    <th>Detail</th>
                </tr>
                </thead>

                <tbody>
                {nalezeniZamestnanci.map((zamestnanec) => (
                    <tr key={zamestnanec.id}>
                        <td>{zamestnanec.jmeno}</td>
                        <td>{zamestnanec.prijmeni}</td>
                        <td>{zamestnanec.email}</td>
                        <td>
                            <button className="btn btn-primary">
                                Detail
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

        </div>
    );


}