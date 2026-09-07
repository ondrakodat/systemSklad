import {apiGet} from "../api/apiClient.ts";
import type {ZamestnanecDto} from "../models/ZamestnanecDto.ts";


export async function dejZamestnance(){
    return apiGet<ZamestnanecDto[]>("zamestnanec");
}

export async function dejZamestnancePodleNazvu(
    nazev: string
){
    const response = await fetch(
        `http://localhost:8080/api/zamestnanec/hledat?nazev=${encodeURIComponent(nazev)}`
    );
    if(!response.ok){
        throw new Error("Nepodařilo se načíst zaměstnance");
    }
    return await response.json();
}