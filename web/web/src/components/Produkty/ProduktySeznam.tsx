import {useEffect, useState} from "react";
import type {ProduktDto} from "../../models/ProduktDto.ts";
import dejProdukty from "../../services/ProduktService.ts";

export default function ProduktySeznam(){
    const[produkty, setProdukty] = useState<ProduktDto[]>([]);

    useEffect(() => {
        async function nactiProdukty(){
            const data = await dejProdukty();
            setProdukty(data);
        }
        nactiProdukty();
    }, [])

    return (
        <div>
            <p>  Počet produktu: {produkty.length} </p>
            <table className="table table-striped table-hover text-center table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nazev</th>
                    <th>Popis</th>
                    <th>Kategorie Id</th>
                    <th>Cena</th>
                    <th>Nakupni Cena</th>
                    <th>Minimální skladované množství</th>
                    <th>EAN </th>
                    <th>Hmotnost</th>
                </tr>
                </thead>
                <tbody>
                {produkty.map((produkt) => (
                    <tr>
                        <td> {produkt.id} </td>
                        <td> {produkt.nazev} </td>
                        <td> {produkt.popis} </td>
                        <td> {produkt.kategorieId} </td>
                        <td> {produkt.cena} </td>
                        <td> {produkt.nakupniCena} </td>
                        <td> {produkt.minimalniSkladovaneMnozstvi} </td>
                        <td> {produkt.ean} </td>
                        <td> {produkt.hmotnost} </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}