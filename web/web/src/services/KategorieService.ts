import {apiGet} from "../api/apiClient.ts";
import type {KategorieDto} from "../models/KategorieDto.ts";

export async function dejKategorie(){
    return apiGet<KategorieDto[]>("kategorie")
}